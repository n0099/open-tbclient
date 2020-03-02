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
    private InterfaceC0475a frX;
    private com.baidu.live.m.a frY;
    private c frZ;
    private c fsa;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0475a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.frZ = new c(tbPageContext);
        this.fsa = new c(tbPageContext);
        this.frZ.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.frX != null) {
                    a.this.frX.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.fsa.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.frX != null) {
                    a.this.frX.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.frX != null) {
                this.frX.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.frY = new com.baidu.live.m.a(new com.baidu.live.m.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.m.c
            public void a(PersonUserData personUserData) {
                if (a.this.frX != null) {
                    a.this.frX.c(personUserData);
                }
            }

            @Override // com.baidu.live.m.c
            public void p(int i, String str6) {
                if (a.this.frX != null) {
                    a.this.frX.onFail(str6);
                }
            }
        });
        this.frY.execute(str, str2, str3, str4, str5);
        cW(str, str4);
    }

    public void cW(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.frZ.setPn(-1);
            this.frZ.g(0, str, str2);
            this.fsa.setPn(-1);
            this.fsa.g(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.frY != null && !this.frY.isCancelled()) {
            this.frY.cancel();
        }
        if (this.frX != null) {
            this.frX.onFail(null);
        }
    }

    public void a(InterfaceC0475a interfaceC0475a) {
        this.frX = interfaceC0475a;
    }
}
