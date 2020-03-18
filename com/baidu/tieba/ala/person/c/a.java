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
    private InterfaceC0475a fsJ;
    private com.baidu.live.m.a fsK;
    private c fsL;
    private c fsM;
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
        this.fsL = new c(tbPageContext);
        this.fsM = new c(tbPageContext);
        this.fsL.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fsJ != null) {
                    a.this.fsJ.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.fsM.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fsJ != null) {
                    a.this.fsJ.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.fsJ != null) {
                this.fsJ.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.fsK = new com.baidu.live.m.a(new com.baidu.live.m.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.m.c
            public void a(PersonUserData personUserData) {
                if (a.this.fsJ != null) {
                    a.this.fsJ.c(personUserData);
                }
            }

            @Override // com.baidu.live.m.c
            public void p(int i, String str6) {
                if (a.this.fsJ != null) {
                    a.this.fsJ.onFail(str6);
                }
            }
        });
        this.fsK.execute(str, str2, str3, str4, str5);
        cV(str, str4);
    }

    public void cV(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.fsL.setPn(-1);
            this.fsL.g(0, str, str2);
            this.fsM.setPn(-1);
            this.fsM.g(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.fsK != null && !this.fsK.isCancelled()) {
            this.fsK.cancel();
        }
        if (this.fsJ != null) {
            this.fsJ.onFail(null);
        }
    }

    public void a(InterfaceC0475a interfaceC0475a) {
        this.fsJ = interfaceC0475a;
    }
}
