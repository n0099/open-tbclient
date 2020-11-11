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
    private InterfaceC0695a hBG;
    private com.baidu.live.p.a hBH;
    private c hBI;
    private c hBJ;
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
        this.hBI = new c(tbPageContext);
        this.hBJ = new c(tbPageContext);
        this.hBI.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hBG != null) {
                    a.this.hBG.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hBJ.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hBG != null) {
                    a.this.hBG.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hBG != null) {
                this.hBG.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.hBH = new com.baidu.live.p.a(new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.p.c
            public void a(PersonUserData personUserData) {
                if (a.this.hBG != null) {
                    a.this.hBG.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.p.c
            public void s(int i, String str6) {
                if (a.this.hBG != null) {
                    a.this.hBG.onFail(str6);
                }
            }
        });
        this.hBH.execute(str, str2, str3, str4, str5);
        aE(str, str4);
    }

    public void aE(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hBI.setPn(-1);
            this.hBI.c(0, str, str2);
            this.hBJ.setPn(-1);
            this.hBJ.c(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hBH != null && !this.hBH.isCancelled()) {
            this.hBH.cancel();
        }
        if (this.hBG != null) {
            this.hBG.onFail(null);
        }
    }

    public void a(InterfaceC0695a interfaceC0695a) {
        this.hBG = interfaceC0695a;
    }
}
