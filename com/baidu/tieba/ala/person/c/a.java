package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.person.c.c;
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0647a gUP;
    private com.baidu.live.o.a gUQ;
    private c gUR;
    private c gUS;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0647a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gUR = new c(tbPageContext);
        this.gUS = new c(tbPageContext);
        this.gUR.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.gUP != null) {
                    a.this.gUP.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.gUS.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.gUP != null) {
                    a.this.gUP.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gUP != null) {
                this.gUP.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.gUQ = new com.baidu.live.o.a(new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.o.c
            public void a(PersonUserData personUserData) {
                if (a.this.gUP != null) {
                    a.this.gUP.c(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.o.c
            public void q(int i, String str6) {
                if (a.this.gUP != null) {
                    a.this.gUP.onFail(str6);
                }
            }
        });
        this.gUQ.execute(str, str2, str3, str4, str5);
        el(str, str4);
    }

    public void el(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.gUR.setPn(-1);
            this.gUR.i(0, str, str2);
            this.gUS.setPn(-1);
            this.gUS.i(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.gUQ != null && !this.gUQ.isCancelled()) {
            this.gUQ.cancel();
        }
        if (this.gUP != null) {
            this.gUP.onFail(null);
        }
    }

    public void a(InterfaceC0647a interfaceC0647a) {
        this.gUP = interfaceC0647a;
    }
}
