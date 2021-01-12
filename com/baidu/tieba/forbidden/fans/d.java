package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d {
    private e eFI;
    private TbPageContext eSJ;
    private ak iVD;
    private c iVE;
    private com.baidu.tieba.view.a iVF;
    private a iVG;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void czm();
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eSJ = tbPageContext;
        this.iVE = new c(tbPageContext, bdUniqueId);
        this.iVE.a(new c.a() { // from class: com.baidu.tieba.forbidden.fans.d.1
            @Override // com.baidu.tieba.forbidden.fans.c.a
            public void l(int i, String str, boolean z) {
                if (d.this.iVG != null) {
                    d.this.iVG.a(i, str, z, 0, 0L);
                }
            }
        });
        this.iVD = new ak(tbPageContext, bdUniqueId);
        this.iVD.a(new ak.a() { // from class: com.baidu.tieba.forbidden.fans.d.2
            @Override // com.baidu.tbadk.core.util.ak.a
            public void a(int i, String str, long j, boolean z) {
                if (d.this.iVG != null) {
                    d.this.iVG.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bkm();
    }

    public void gi(long j) {
        this.iVD.dL(j);
    }

    private void bkm() {
        if (this.eFI == null) {
            this.iVF = new com.baidu.tieba.view.a(this.eSJ.getContext());
            this.iVF.setTitleText(this.eSJ.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0892a c0892a = new a.C0892a(this.eSJ.getString(R.string.confirm), this.iVF);
            c0892a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.d.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    d.this.eFI.dismiss();
                    if (d.this.iVG != null) {
                        d.this.iVG.czm();
                    }
                    d.this.iVE.czq();
                }
            });
            arrayList.add(c0892a);
            this.iVF.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.d.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eFI != null) {
                        d.this.eFI.dismiss();
                    }
                }
            });
            this.iVF.bB(arrayList);
            this.eFI = new e(this.eSJ.getPageActivity(), this.iVF.bqy());
            this.eFI.ab(0.7f);
        }
        this.eFI.show();
    }

    public void onChangeSkinType() {
        if (this.iVF != null) {
            this.iVF.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.iVG = aVar;
    }
}
