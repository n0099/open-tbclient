package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class e {
    private com.baidu.tieba.person.e cGR;
    private TbPageContext cQU;
    private ai geq;
    private d ger;
    private com.baidu.tieba.view.a ges;
    private a get;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bzC();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cQU = tbPageContext;
        this.ger = new d(tbPageContext, bdUniqueId);
        this.ger.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.get != null) {
                    e.this.get.a(i, str, z, 0, 0L);
                }
            }
        });
        this.geq = new ai(tbPageContext, bdUniqueId);
        this.geq.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.get != null) {
                    e.this.get.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        awW();
    }

    public void dn(long j) {
        this.geq.bs(j);
    }

    private void awW() {
        if (this.cGR == null) {
            this.ges = new com.baidu.tieba.view.a(this.cQU.getContext());
            this.ges.setTitleText(this.cQU.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0616a c0616a = new a.C0616a(this.cQU.getString(R.string.confirm), this.ges);
            c0616a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.cGR.dismiss();
                    if (e.this.get != null) {
                        e.this.get.bzC();
                    }
                    e.this.ger.bzG();
                }
            });
            arrayList.add(c0616a);
            this.ges.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.cGR != null) {
                        e.this.cGR.dismiss();
                    }
                }
            });
            this.ges.aA(arrayList);
            this.cGR = new com.baidu.tieba.person.e(this.cQU.getPageActivity(), this.ges.aCm());
            this.cGR.ag(0.7f);
        }
        this.cGR.show();
    }

    public void onChangeSkinType() {
        if (this.ges != null) {
            this.ges.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.get = aVar;
    }
}
