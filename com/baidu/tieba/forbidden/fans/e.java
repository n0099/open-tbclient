package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.tieba.person.e dkF;
    private TbPageContext duK;
    private ai gTK;
    private d gTL;
    private com.baidu.tieba.view.a gTM;
    private a gTN;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bMO();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.duK = tbPageContext;
        this.gTL = new d(tbPageContext, bdUniqueId);
        this.gTL.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void k(int i, String str, boolean z) {
                if (e.this.gTN != null) {
                    e.this.gTN.a(i, str, z, 0, 0L);
                }
            }
        });
        this.gTK = new ai(tbPageContext, bdUniqueId);
        this.gTK.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.gTN != null) {
                    e.this.gTN.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        aHT();
    }

    public void eb(long j) {
        this.gTK.ce(j);
    }

    private void aHT() {
        if (this.dkF == null) {
            this.gTM = new com.baidu.tieba.view.a(this.duK.getContext());
            this.gTM.setTitleText(this.duK.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0692a c0692a = new a.C0692a(this.duK.getString(R.string.confirm), this.gTM);
            c0692a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dkF.dismiss();
                    if (e.this.gTN != null) {
                        e.this.gTN.bMO();
                    }
                    e.this.gTL.bMS();
                }
            });
            arrayList.add(c0692a);
            this.gTM.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dkF != null) {
                        e.this.dkF.dismiss();
                    }
                }
            });
            this.gTM.aI(arrayList);
            this.dkF = new com.baidu.tieba.person.e(this.duK.getPageActivity(), this.gTM.aNh());
            this.dkF.O(0.7f);
        }
        this.dkF.show();
    }

    public void onChangeSkinType() {
        if (this.gTM != null) {
            this.gTM.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gTN = aVar;
    }
}
