package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.e;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.person.e ane;
    private ai dDF;
    private d dDG;
    private com.baidu.tieba.view.a dDH;
    private a dDI;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void azd();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dDG = new d(tbPageContext, bdUniqueId);
        this.dDG.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.dDI != null) {
                    e.this.dDI.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dDF = new ai(tbPageContext, bdUniqueId);
        this.dDF.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dDI != null) {
                    e.this.dDI.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        xa();
    }

    public void bR(long j) {
        this.dDF.F(j);
    }

    private void xa() {
        if (this.ane == null) {
            this.dDH = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dDH.setTitleText(this.mContext.getString(e.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0334a c0334a = new a.C0334a(this.mContext.getString(e.j.confirm), this.dDH);
            c0334a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.ane.dismiss();
                    if (e.this.dDI != null) {
                        e.this.dDI.azd();
                    }
                    e.this.dDG.azh();
                }
            });
            arrayList.add(c0334a);
            this.dDH.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.ane != null) {
                        e.this.ane.dismiss();
                    }
                }
            });
            this.dDH.ed(arrayList);
            this.ane = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dDH.bLZ());
            this.ane.ax(0.7f);
        }
        this.ane.show();
    }

    public void onChangeSkinType() {
        if (this.dDH != null) {
            this.dDH.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dDI = aVar;
    }
}
