package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.tieba.person.e dDL;
    private TbPageContext dPv;
    private aj huQ;
    private d huR;
    private com.baidu.tieba.view.a huS;
    private a huT;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bWh();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dPv = tbPageContext;
        this.huR = new d(tbPageContext, bdUniqueId);
        this.huR.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void k(int i, String str, boolean z) {
                if (e.this.huT != null) {
                    e.this.huT.a(i, str, z, 0, 0L);
                }
            }
        });
        this.huQ = new aj(tbPageContext, bdUniqueId);
        this.huQ.a(new aj.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.huT != null) {
                    e.this.huT.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        aPl();
    }

    public void ef(long j) {
        this.huQ.cf(j);
    }

    private void aPl() {
        if (this.dDL == null) {
            this.huS = new com.baidu.tieba.view.a(this.dPv.getContext());
            this.huS.setTitleText(this.dPv.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0761a c0761a = new a.C0761a(this.dPv.getString(R.string.confirm), this.huS);
            c0761a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dDL.dismiss();
                    if (e.this.huT != null) {
                        e.this.huT.bWh();
                    }
                    e.this.huR.bWl();
                }
            });
            arrayList.add(c0761a);
            this.huS.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dDL != null) {
                        e.this.dDL.dismiss();
                    }
                }
            });
            this.huS.aL(arrayList);
            this.dDL = new com.baidu.tieba.person.e(this.dPv.getPageActivity(), this.huS.aVb());
            this.dDL.P(0.7f);
        }
        this.dDL.show();
    }

    public void onChangeSkinType() {
        if (this.huS != null) {
            this.huS.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.huT = aVar;
    }
}
