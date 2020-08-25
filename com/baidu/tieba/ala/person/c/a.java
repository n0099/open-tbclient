package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.person.a.d;
import com.baidu.tieba.ala.person.c.c;
/* loaded from: classes7.dex */
public class a {
    private InterfaceC0650a gRd;
    private com.baidu.live.n.a gRe;
    private c gRf;
    private c gRg;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0650a {
        void a(d dVar);

        void b(d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gRf = new c(tbPageContext);
        this.gRg = new c(tbPageContext);
        this.gRf.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(d dVar) {
                if (dVar != null && a.this.gRd != null) {
                    a.this.gRd.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.gRg.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(d dVar) {
                if (dVar != null && a.this.gRd != null) {
                    a.this.gRd.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gRd != null) {
                this.gRd.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.gRe = new com.baidu.live.n.a(new com.baidu.live.n.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.n.c
            public void a(PersonUserData personUserData) {
                if (a.this.gRd != null) {
                    a.this.gRd.c(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.n.c
            public void p(int i, String str6) {
                if (a.this.gRd != null) {
                    a.this.gRd.onFail(str6);
                }
            }
        });
        this.gRe.execute(str, str2, str3, str4, str5);
        eg(str, str4);
    }

    public void eg(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.gRf.setPn(-1);
            this.gRf.h(0, str, str2);
            this.gRg.setPn(-1);
            this.gRg.h(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.gRe != null && !this.gRe.isCancelled()) {
            this.gRe.cancel();
        }
        if (this.gRd != null) {
            this.gRd.onFail(null);
        }
    }

    public void a(InterfaceC0650a interfaceC0650a) {
        this.gRd = interfaceC0650a;
    }
}
