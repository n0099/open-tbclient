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
    private InterfaceC0475a fsk;
    private com.baidu.live.m.a fsl;
    private c fsm;
    private c fsn;
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
        this.fsm = new c(tbPageContext);
        this.fsn = new c(tbPageContext);
        this.fsm.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.1
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fsk != null) {
                    a.this.fsk.a(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
        this.fsn.a(new c.a() { // from class: com.baidu.tieba.ala.person.c.a.2
            @Override // com.baidu.tieba.ala.person.c.c.a
            public void c(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null && a.this.fsk != null) {
                    a.this.fsk.b(dVar);
                }
            }

            @Override // com.baidu.tieba.ala.person.c.c.a
            public void onFail(String str) {
            }
        });
    }

    public void h(String str, String str2, String str3, String str4, String str5) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.fsk != null) {
                this.fsk.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        this.fsl = new com.baidu.live.m.a(new com.baidu.live.m.c() { // from class: com.baidu.tieba.ala.person.c.a.3
            @Override // com.baidu.live.m.c
            public void a(PersonUserData personUserData) {
                if (a.this.fsk != null) {
                    a.this.fsk.c(personUserData);
                }
            }

            @Override // com.baidu.live.m.c
            public void p(int i, String str6) {
                if (a.this.fsk != null) {
                    a.this.fsk.onFail(str6);
                }
            }
        });
        this.fsl.execute(str, str2, str3, str4, str5);
        cW(str, str4);
    }

    public void cW(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.fsm.setPn(-1);
            this.fsm.g(0, str, str2);
            this.fsn.setPn(-1);
            this.fsn.g(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.fsl != null && !this.fsl.isCancelled()) {
            this.fsl.cancel();
        }
        if (this.fsk != null) {
            this.fsk.onFail(null);
        }
    }

    public void a(InterfaceC0475a interfaceC0475a) {
        this.fsk = interfaceC0475a;
    }
}
