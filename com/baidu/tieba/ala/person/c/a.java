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
    private InterfaceC0532a fXj;
    private com.baidu.live.m.a fXk;
    private c fXl;
    private c fXm;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0532a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fXl = new c(tbPageContext);
        this.fXm = new c(tbPageContext);
        this.fXl.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fXj != null) {
                    a.this.fXj.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.fXm.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fXj != null) {
                    a.this.fXj.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.fXj != null) {
                this.fXj.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.fXk = new com.baidu.live.m.a(new com.baidu.live.m.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.m.c
            public void a(PersonUserData personUserData) {
                if (a.this.fXj != null) {
                    a.this.fXj.c(personUserData);
                }
            }

            @Override // com.baidu.live.m.c
            public void o(int i, String str6) {
                if (a.this.fXj != null) {
                    a.this.fXj.onFail(str6);
                }
            }
        });
        this.fXk.execute(str, str2, str3, str4, str5);
        dj(str, str4);
    }

    public void dj(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.fXl.setPn(-1);
            this.fXl.h(0, str, str2);
            this.fXm.setPn(-1);
            this.fXm.h(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.fXk != null && !this.fXk.isCancelled()) {
            this.fXk.cancel();
        }
        if (this.fXj != null) {
            this.fXj.onFail(null);
        }
    }

    public void a(InterfaceC0532a interfaceC0532a) {
        this.fXj = interfaceC0532a;
    }
}
