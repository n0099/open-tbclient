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
    private InterfaceC0681a hvJ;
    private com.baidu.live.p.a hvK;
    private c hvL;
    private c hvM;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0681a {
        void a(com.baidu.tieba.ala.person.a.c cVar);

        void b(PersonUserData personUserData);

        void b(com.baidu.tieba.ala.person.a.c cVar);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.hvL = new c(tbPageContext);
        this.hvM = new c(tbPageContext);
        this.hvL.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hvJ != null) {
                    a.this.hvJ.a(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.hvM.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.c cVar) {
                if (cVar != null && a.this.hvJ != null) {
                    a.this.hvJ.b(cVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void k(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.hvJ != null) {
                this.hvJ.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.hvK = new com.baidu.live.p.a(new com.baidu.live.p.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.p.c
            public void a(PersonUserData personUserData) {
                if (a.this.hvJ != null) {
                    a.this.hvJ.b(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.p.c
            public void s(int i, String str6) {
                if (a.this.hvJ != null) {
                    a.this.hvJ.onFail(str6);
                }
            }
        });
        this.hvK.execute(str, str2, str3, str4, str5);
        aD(str, str4);
    }

    public void aD(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.hvL.setPn(-1);
            this.hvL.c(0, str, str2);
            this.hvM.setPn(-1);
            this.hvM.c(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.hvK != null && !this.hvK.isCancelled()) {
            this.hvK.cancel();
        }
        if (this.hvJ != null) {
            this.hvJ.onFail(null);
        }
    }

    public void a(InterfaceC0681a interfaceC0681a) {
        this.hvJ = interfaceC0681a;
    }
}
