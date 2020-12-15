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
    private InterfaceC0708a hKU;
    private com.baidu.live.r.a hKV;
    private c hKW;
    private c hKX;
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
        this.hKW = new c(tbPageContext);
        this.hKX = new c(tbPageContext);
        this.hKW.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hKU != null) {
                    a.this.hKU.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hKX.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hKU != null) {
                    a.this.hKU.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hKU != null) {
                this.hKU.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hKV = new com.baidu.live.r.a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.r.c
            public void a(PersonUserData personUserData) {
                if (a.this.hKU != null) {
                    a.this.hKU.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.r.c
            public void s(int i, String str6) {
                if (a.this.hKU != null) {
                    a.this.hKU.onFail(str6);
                }
            }
        });
        this.hKV.execute(str, str2, str3, str4, str5);
        aH(str, str4);
    }

    public void aH(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hKW.setPn(-1);
            this.hKW.e(0, str, str2);
            this.hKX.setPn(-1);
            this.hKX.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hKV != null && !this.hKV.isCancelled()) {
            this.hKV.cancel();
        }
        if (this.hKU != null) {
            this.hKU.onFail(null);
        }
    }

    public void a(InterfaceC0708a interfaceC0708a) {
        this.hKU = interfaceC0708a;
    }
}
