package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e {
    private com.baidu.tieba.person.e cHd;
    private TbPageContext cRe;
    private d ghA;
    private com.baidu.tieba.view.a ghB;
    private a ghC;
    private ai ghz;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bAE();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cRe = tbPageContext;
        this.ghA = new d(tbPageContext, bdUniqueId);
        this.ghA.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.ghC != null) {
                    e.this.ghC.a(i, str, z, 0, 0L);
                }
            }
        });
        this.ghz = new ai(tbPageContext, bdUniqueId);
        this.ghz.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.ghC != null) {
                    e.this.ghC.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        axp();
    }

    public void ds(long j) {
        this.ghz.bv(j);
    }

    private void axp() {
        if (this.cHd == null) {
            this.ghB = new com.baidu.tieba.view.a(this.cRe.getContext());
            this.ghB.setTitleText(this.cRe.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0621a c0621a = new a.C0621a(this.cRe.getString(R.string.confirm), this.ghB);
            c0621a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.cHd.dismiss();
                    if (e.this.ghC != null) {
                        e.this.ghC.bAE();
                    }
                    e.this.ghA.bAI();
                }
            });
            arrayList.add(c0621a);
            this.ghB.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.cHd != null) {
                        e.this.cHd.dismiss();
                    }
                }
            });
            this.ghB.az(arrayList);
            this.cHd = new com.baidu.tieba.person.e(this.cRe.getPageActivity(), this.ghB.aCF());
            this.cHd.af(0.7f);
        }
        this.cHd.show();
    }

    public void onChangeSkinType() {
        if (this.ghB != null) {
            this.ghB.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.ghC = aVar;
    }
}
