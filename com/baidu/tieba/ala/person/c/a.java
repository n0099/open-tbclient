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
/* loaded from: classes10.dex */
public class a {
    private com.baidu.live.s.a hSA;
    private c hSB;
    private c hSC;
    private InterfaceC0683a hSz;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0683a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hSB = new c(tbPageContext);
        this.hSC = new c(tbPageContext);
        this.hSB.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hSz != null) {
                    a.this.hSz.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hSC.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hSz != null) {
                    a.this.hSz.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hSz != null) {
                this.hSz.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hSA = new com.baidu.live.s.a(new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.s.c
            public void a(PersonUserData personUserData) {
                if (a.this.hSz != null) {
                    a.this.hSz.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.s.c
            public void v(int i, String str6) {
                if (a.this.hSz != null) {
                    a.this.hSz.onFail(str6);
                }
            }
        });
        this.hSA.execute(str, str2, str3, str4, str5);
        aE(str, str4);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hSz != null) {
                this.hSz.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hSA = new com.baidu.live.s.a(new com.baidu.live.s.c() { // from class: com.baidu.tieba.ala.person.c.a.4
            @Override // com.baidu.live.s.c
            public void a(PersonUserData personUserData) {
                if (a.this.hSz != null) {
                    a.this.hSz.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.s.c
            public void v(int i, String str7) {
                if (a.this.hSz != null) {
                    a.this.hSz.onFail(str7);
                }
            }
        });
        this.hSA.execute(str, str2, str3, str4, str5, str6);
        aE(str, str4);
    }

    public void aE(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hSB.setPn(-1);
            this.hSB.e(0, str, str2);
            this.hSC.setPn(-1);
            this.hSC.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hSA != null && !this.hSA.isCancelled()) {
            this.hSA.cancel();
        }
        if (this.hSz != null) {
            this.hSz.onFail(null);
        }
    }

    public void a(InterfaceC0683a interfaceC0683a) {
        this.hSz = interfaceC0683a;
    }
}
