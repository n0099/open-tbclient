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
    private InterfaceC0683a hWU;
    private com.baidu.live.r.a hWV;
    private c hWW;
    private c hWX;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0683a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hWW = new c(tbPageContext);
        this.hWX = new c(tbPageContext);
        this.hWW.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hWU != null) {
                    a.this.hWU.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hWX.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hWU != null) {
                    a.this.hWU.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hWU != null) {
                this.hWU.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hWV = new com.baidu.live.r.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.r.c
            public void a(PersonUserData personUserData) {
                if (a.this.hWU != null) {
                    a.this.hWU.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.r.c
            public void z(int i, String str6) {
                if (a.this.hWU != null) {
                    a.this.hWU.onFail(str6);
                }
            }
        });
        this.hWV.execute(str, str2, str3, str4, str5);
        aE(str, str4);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hWU != null) {
                this.hWU.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hWV = new com.baidu.live.r.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.person.c.a.4
            @Override // com.baidu.live.r.c
            public void a(PersonUserData personUserData) {
                if (a.this.hWU != null) {
                    a.this.hWU.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.r.c
            public void z(int i, String str7) {
                if (a.this.hWU != null) {
                    a.this.hWU.onFail(str7);
                }
            }
        });
        this.hWV.execute(str, str2, str3, str4, str5, str6);
        aE(str, str4);
    }

    public void aE(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hWW.setPn(-1);
            this.hWW.e(0, str, str2);
            this.hWX.setPn(-1);
            this.hWX.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hWV != null && !this.hWV.isCancelled()) {
            this.hWV.cancel();
        }
        if (this.hWU != null) {
            this.hWU.onFail(null);
        }
    }

    public void a(InterfaceC0683a interfaceC0683a) {
        this.hWU = interfaceC0683a;
    }
}
