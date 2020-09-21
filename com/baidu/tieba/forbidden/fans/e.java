package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class e {
    private com.baidu.tieba.person.e dVe;
    private TbPageContext ehG;
    private al hUW;
    private d hUX;
    private com.baidu.tieba.view.a hUY;
    private a hUZ;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cnl();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ehG = tbPageContext;
        this.hUX = new d(tbPageContext, bdUniqueId);
        this.hUX.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.hUZ != null) {
                    e.this.hUZ.a(i, str, z, 0, 0L);
                }
            }
        });
        this.hUW = new al(tbPageContext, bdUniqueId);
        this.hUW.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.hUZ != null) {
                    e.this.hUZ.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bcr();
    }

    public void eN(long j) {
        this.hUW.cG(j);
    }

    private void bcr() {
        if (this.dVe == null) {
            this.hUY = new com.baidu.tieba.view.a(this.ehG.getContext());
            this.hUY.setTitleText(this.ehG.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0822a c0822a = new a.C0822a(this.ehG.getString(R.string.confirm), this.hUY);
            c0822a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dVe.dismiss();
                    if (e.this.hUZ != null) {
                        e.this.hUZ.cnl();
                    }
                    e.this.hUX.cnp();
                }
            });
            arrayList.add(c0822a);
            this.hUY.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dVe != null) {
                        e.this.dVe.dismiss();
                    }
                }
            });
            this.hUY.aX(arrayList);
            this.dVe = new com.baidu.tieba.person.e(this.ehG.getPageActivity(), this.hUY.biq());
            this.dVe.U(0.7f);
        }
        this.dVe.show();
    }

    public void onChangeSkinType() {
        if (this.hUY != null) {
            this.hUY.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.hUZ = aVar;
    }
}
