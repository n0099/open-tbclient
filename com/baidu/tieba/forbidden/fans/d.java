package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class d {
    private e eJp;
    private TbPageContext eWx;
    private al jdh;
    private c jdi;
    private com.baidu.tieba.view.a jdj;
    private a jdk;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cAK();
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eWx = tbPageContext;
        this.jdi = new c(tbPageContext, bdUniqueId);
        this.jdi.a(new c.a() { // from class: com.baidu.tieba.forbidden.fans.d.1
            @Override // com.baidu.tieba.forbidden.fans.c.a
            public void k(int i, String str, boolean z) {
                if (d.this.jdk != null) {
                    d.this.jdk.a(i, str, z, 0, 0L);
                }
            }
        });
        this.jdh = new al(tbPageContext, bdUniqueId);
        this.jdh.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.d.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (d.this.jdk != null) {
                    d.this.jdk.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bkG();
    }

    public void gn(long j) {
        this.jdh.dR(j);
    }

    private void bkG() {
        if (this.eJp == null) {
            this.jdj = new com.baidu.tieba.view.a(this.eWx.getContext());
            this.jdj.setTitleText(this.eWx.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0903a c0903a = new a.C0903a(this.eWx.getString(R.string.confirm), this.jdj);
            c0903a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.d.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    d.this.eJp.dismiss();
                    if (d.this.jdk != null) {
                        d.this.jdk.cAK();
                    }
                    d.this.jdi.cAO();
                }
            });
            arrayList.add(c0903a);
            this.jdj.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.d.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eJp != null) {
                        d.this.eJp.dismiss();
                    }
                }
            });
            this.jdj.bw(arrayList);
            this.eJp = new e(this.eWx.getPageActivity(), this.jdj.bqS());
            this.eJp.ag(0.7f);
        }
        this.eJp.show();
    }

    public void onChangeSkinType() {
        if (this.jdj != null) {
            this.jdj.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.jdk = aVar;
    }
}
