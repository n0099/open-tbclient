package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    private e eHO;
    private TbPageContext eUY;
    private com.baidu.tieba.view.a jbA;
    private a jbB;
    private al jby;
    private c jbz;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cAE();
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eUY = tbPageContext;
        this.jbz = new c(tbPageContext, bdUniqueId);
        this.jbz.a(new c.a() { // from class: com.baidu.tieba.forbidden.fans.d.1
            @Override // com.baidu.tieba.forbidden.fans.c.a
            public void k(int i, String str, boolean z) {
                if (d.this.jbB != null) {
                    d.this.jbB.a(i, str, z, 0, 0L);
                }
            }
        });
        this.jby = new al(tbPageContext, bdUniqueId);
        this.jby.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.d.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (d.this.jbB != null) {
                    d.this.jbB.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bkE();
    }

    public void gn(long j) {
        this.jby.dR(j);
    }

    private void bkE() {
        if (this.eHO == null) {
            this.jbA = new com.baidu.tieba.view.a(this.eUY.getContext());
            this.jbA.setTitleText(this.eUY.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0897a c0897a = new a.C0897a(this.eUY.getString(R.string.confirm), this.jbA);
            c0897a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.d.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    d.this.eHO.dismiss();
                    if (d.this.jbB != null) {
                        d.this.jbB.cAE();
                    }
                    d.this.jbz.cAI();
                }
            });
            arrayList.add(c0897a);
            this.jbA.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.d.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eHO != null) {
                        d.this.eHO.dismiss();
                    }
                }
            });
            this.jbA.bw(arrayList);
            this.eHO = new e(this.eUY.getPageActivity(), this.jbA.bqR());
            this.eHO.ac(0.7f);
        }
        this.eHO.show();
    }

    public void onChangeSkinType() {
        if (this.jbA != null) {
            this.jbA.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.jbB = aVar;
    }
}
