package com.baidu.tieba.ala.person.c;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.person.c.c;
/* loaded from: classes3.dex */
public class a {
    private InterfaceC0582a gmd;
    private com.baidu.live.m.a gme;
    private c gmf;
    private c gmg;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0582a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gmf = new c(tbPageContext);
        this.gmg = new c(tbPageContext);
        this.gmf.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.gmd != null) {
                    a.this.gmd.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.gmg.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.gmd != null) {
                    a.this.gmd.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.gmd != null) {
                this.gmd.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.gme = new com.baidu.live.m.a(new com.baidu.live.m.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.m.c
            public void a(PersonUserData personUserData) {
                if (a.this.gmd != null) {
                    a.this.gmd.c(personUserData);
                }
            }

            @Override // com.baidu.live.m.c
            public void o(int i, String str6) {
                if (a.this.gmd != null) {
                    a.this.gmd.onFail(str6);
                }
            }
        });
        this.gme.execute(str, str2, str3, str4, str5);
        dJ(str, str4);
    }

    public void dJ(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.gmf.setPn(-1);
            this.gmf.h(0, str, str2);
            this.gmg.setPn(-1);
            this.gmg.h(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.gme != null && !this.gme.isCancelled()) {
            this.gme.cancel();
        }
        if (this.gmd != null) {
            this.gmd.onFail(null);
        }
    }

    public void a(InterfaceC0582a interfaceC0582a) {
        this.gmd = interfaceC0582a;
    }
}
