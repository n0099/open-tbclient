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
    private InterfaceC0665a hjN;
    private com.baidu.live.o.a hjO;
    private c hjP;
    private c hjQ;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0665a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hjP = new c(tbPageContext);
        this.hjQ = new c(tbPageContext);
        this.hjP.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hjN != null) {
                    a.this.hjN.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hjQ.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hjN != null) {
                    a.this.hjN.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hjN != null) {
                this.hjN.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.hjO = new com.baidu.live.o.a(new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.o.c
            public void a(PersonUserData personUserData) {
                if (a.this.hjN != null) {
                    a.this.hjN.c(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.o.c
            public void s(int i, String str6) {
                if (a.this.hjN != null) {
                    a.this.hjN.onFail(str6);
                }
            }
        });
        this.hjO.execute(str, str2, str3, str4, str5);
        es(str, str4);
    }

    public void es(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hjP.setPn(-1);
            this.hjP.i(0, str, str2);
            this.hjQ.setPn(-1);
            this.hjQ.i(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hjO != null && !this.hjO.isCancelled()) {
            this.hjO.cancel();
        }
        if (this.hjN != null) {
            this.hjN.onFail(null);
        }
    }

    public void a(InterfaceC0665a interfaceC0665a) {
        this.hjN = interfaceC0665a;
    }
}
