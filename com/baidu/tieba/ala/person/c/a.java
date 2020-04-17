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
    private InterfaceC0511a fXe;
    private com.baidu.live.m.a fXf;
    private c fXg;
    private c fXh;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.person.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0511a {
        void a(com.baidu.tieba.ala.person.a.d dVar);

        void b(com.baidu.tieba.ala.person.a.d dVar);

        void c(PersonUserData personUserData);

        void onFail(String str);
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fXg = new c(tbPageContext);
        this.fXh = new c(tbPageContext);
        this.fXg.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fXe != null) {
                    a.this.fXe.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.fXh.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fXe != null) {
                    a.this.fXe.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.fXe != null) {
                this.fXe.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.fXf = new com.baidu.live.m.a(new com.baidu.live.m.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.m.c
            public void a(PersonUserData personUserData) {
                if (a.this.fXe != null) {
                    a.this.fXe.c(personUserData);
                }
            }

            @Override // com.baidu.live.m.c
            public void o(int i, String str6) {
                if (a.this.fXe != null) {
                    a.this.fXe.onFail(str6);
                }
            }
        });
        this.fXf.execute(str, str2, str3, str4, str5);
        dj(str, str4);
    }

    public void dj(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.fXg.setPn(-1);
            this.fXg.h(0, str, str2);
            this.fXh.setPn(-1);
            this.fXh.h(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.fXf != null && !this.fXf.isCancelled()) {
            this.fXf.cancel();
        }
        if (this.fXe != null) {
            this.fXe.onFail(null);
        }
    }

    public void a(InterfaceC0511a interfaceC0511a) {
        this.fXe = interfaceC0511a;
    }
}
