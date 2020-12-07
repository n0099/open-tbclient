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
    private InterfaceC0708a hKS;
    private com.baidu.live.r.a hKT;
    private c hKU;
    private c hKV;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0708a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hKU = new c(tbPageContext);
        this.hKV = new c(tbPageContext);
        this.hKU.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hKS != null) {
                    a.this.hKS.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hKV.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hKS != null) {
                    a.this.hKS.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hKS != null) {
                this.hKS.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hKT = new com.baidu.live.r.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.r.c
            public void a(PersonUserData personUserData) {
                if (a.this.hKS != null) {
                    a.this.hKS.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.r.c
            public void s(int i, String str6) {
                if (a.this.hKS != null) {
                    a.this.hKS.onFail(str6);
                }
            }
        });
        this.hKT.execute(str, str2, str3, str4, str5);
        aH(str, str4);
    }

    public void aH(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hKU.setPn(-1);
            this.hKU.e(0, str, str2);
            this.hKV.setPn(-1);
            this.hKV.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hKT != null && !this.hKT.isCancelled()) {
            this.hKT.cancel();
        }
        if (this.hKS != null) {
            this.hKS.onFail(null);
        }
    }

    public void a(InterfaceC0708a interfaceC0708a) {
        this.hKS = interfaceC0708a;
    }
}
