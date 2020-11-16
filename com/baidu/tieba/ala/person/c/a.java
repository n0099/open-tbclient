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
    private InterfaceC0695a hBn;
    private com.baidu.live.p.a hBo;
    private c hBp;
    private c hBq;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0695a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hBp = new c(tbPageContext);
        this.hBq = new c(tbPageContext);
        this.hBp.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hBn != null) {
                    a.this.hBn.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hBq.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hBn != null) {
                    a.this.hBn.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hBn != null) {
                this.hBn.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hBo = new com.baidu.live.p.a(new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.p.c
            public void a(PersonUserData personUserData) {
                if (a.this.hBn != null) {
                    a.this.hBn.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.p.c
            public void s(int i, String str6) {
                if (a.this.hBn != null) {
                    a.this.hBn.onFail(str6);
                }
            }
        });
        this.hBo.execute(str, str2, str3, str4, str5);
        aD(str, str4);
    }

    public void aD(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hBp.setPn(-1);
            this.hBp.c(0, str, str2);
            this.hBq.setPn(-1);
            this.hBq.c(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hBo != null && !this.hBo.isCancelled()) {
            this.hBo.cancel();
        }
        if (this.hBn != null) {
            this.hBn.onFail(null);
        }
    }

    public void a(InterfaceC0695a interfaceC0695a) {
        this.hBn = interfaceC0695a;
    }
}
