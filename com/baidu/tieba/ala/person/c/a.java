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
/* loaded from: classes11.dex */
public class a {
    private InterfaceC0700a hXg;
    private com.baidu.live.s.a hXh;
    private c hXi;
    private c hXj;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0700a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hXi = new c(tbPageContext);
        this.hXj = new c(tbPageContext);
        this.hXi.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hXg != null) {
                    a.this.hXg.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hXj.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hXg != null) {
                    a.this.hXg.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hXg != null) {
                this.hXg.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hXh = new com.baidu.live.s.a(new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.s.c
            public void a(PersonUserData personUserData) {
                if (a.this.hXg != null) {
                    a.this.hXg.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.s.c
            public void u(int i, String str6) {
                if (a.this.hXg != null) {
                    a.this.hXg.onFail(str6);
                }
            }
        });
        this.hXh.execute(str, str2, str3, str4, str5);
        aF(str, str4);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hXg != null) {
                this.hXg.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hXh = new com.baidu.live.s.a(new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.person.c.a.4
            @Override // com.baidu.live.s.c
            public void a(PersonUserData personUserData) {
                if (a.this.hXg != null) {
                    a.this.hXg.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.s.c
            public void u(int i, String str7) {
                if (a.this.hXg != null) {
                    a.this.hXg.onFail(str7);
                }
            }
        });
        this.hXh.execute(str, str2, str3, str4, str5, str6);
        aF(str, str4);
    }

    public void aF(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hXi.setPn(-1);
            this.hXi.e(0, str, str2);
            this.hXj.setPn(-1);
            this.hXj.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hXh != null && !this.hXh.isCancelled()) {
            this.hXh.cancel();
        }
        if (this.hXg != null) {
            this.hXg.onFail(null);
        }
    }

    public void a(InterfaceC0700a interfaceC0700a) {
        this.hXg = interfaceC0700a;
    }
}
