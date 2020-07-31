package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class e {
    private com.baidu.tieba.person.e dJI;
    private TbPageContext dVN;
    private ak hAC;
    private d hAD;
    private com.baidu.tieba.view.a hAE;
    private a hAF;

    /* loaded from: classes17.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bZB();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dVN = tbPageContext;
        this.hAD = new d(tbPageContext, bdUniqueId);
        this.hAD.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void k(int i, String str, boolean z) {
                if (e.this.hAF != null) {
                    e.this.hAF.a(i, str, z, 0, 0L);
                }
            }
        });
        this.hAC = new ak(tbPageContext, bdUniqueId);
        this.hAC.a(new ak.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ak.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.hAF != null) {
                    e.this.hAF.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        aTg();
    }

    public void es(long j) {
        this.hAC.cu(j);
    }

    private void aTg() {
        if (this.dJI == null) {
            this.hAE = new com.baidu.tieba.view.a(this.dVN.getContext());
            this.hAE.setTitleText(this.dVN.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0772a c0772a = new a.C0772a(this.dVN.getString(R.string.confirm), this.hAE);
            c0772a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dJI.dismiss();
                    if (e.this.hAF != null) {
                        e.this.hAF.bZB();
                    }
                    e.this.hAD.bZF();
                }
            });
            arrayList.add(c0772a);
            this.hAE.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dJI != null) {
                        e.this.dJI.dismiss();
                    }
                }
            });
            this.hAE.aS(arrayList);
            this.dJI = new com.baidu.tieba.person.e(this.dVN.getPageActivity(), this.hAE.aZb());
            this.dJI.P(0.7f);
        }
        this.dJI.show();
    }

    public void onChangeSkinType() {
        if (this.hAE != null) {
            this.hAE.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.hAF = aVar;
    }
}
