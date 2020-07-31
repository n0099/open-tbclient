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
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0600a gED;
    private com.baidu.live.n.a gEE;
    private c gEF;
    private c gEG;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0600a {
        void a(d dVar);

        void b(d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gEF = new c(tbPageContext);
        this.gEG = new c(tbPageContext);
        this.gEF.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(d dVar) {
                if (dVar != null && a.this.gED != null) {
                    a.this.gED.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.gEG.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(d dVar) {
                if (dVar != null && a.this.gED != null) {
                    a.this.gED.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gED != null) {
                this.gED.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.gEE = new com.baidu.live.n.a(new com.baidu.live.n.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.n.c
            public void a(PersonUserData personUserData) {
                if (a.this.gED != null) {
                    a.this.gED.c(personUserData);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913214, personUserData));
            }

            @Override // com.baidu.live.n.c
            public void q(int i, String str6) {
                if (a.this.gED != null) {
                    a.this.gED.onFail(str6);
                }
            }
        });
        this.gEE.execute(str, str2, str3, str4, str5);
        dP(str, str4);
    }

    public void dP(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.gEF.setPn(-1);
            this.gEF.h(0, str, str2);
            this.gEG.setPn(-1);
            this.gEG.h(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.gEE != null && !this.gEE.isCancelled()) {
            this.gEE.cancel();
        }
        if (this.gED != null) {
            this.gED.onFail(null);
        }
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        this.gED = interfaceC0600a;
    }
}
