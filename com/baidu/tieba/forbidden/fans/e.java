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
    private TbPageContext dIF;
    private com.baidu.tieba.person.e dyF;
    private ai hiH;
    private d hiI;
    private com.baidu.tieba.view.a hiJ;
    private a hiK;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bTl();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dIF = tbPageContext;
        this.hiI = new d(tbPageContext, bdUniqueId);
        this.hiI.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void k(int i, String str, boolean z) {
                if (e.this.hiK != null) {
                    e.this.hiK.a(i, str, z, 0, 0L);
                }
            }
        });
        this.hiH = new ai(tbPageContext, bdUniqueId);
        this.hiH.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.hiK != null) {
                    e.this.hiK.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        aNH();
    }

    public void ec(long j) {
        this.hiH.ce(j);
    }

    private void aNH() {
        if (this.dyF == null) {
            this.hiJ = new com.baidu.tieba.view.a(this.dIF.getContext());
            this.hiJ.setTitleText(this.dIF.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0746a c0746a = new a.C0746a(this.dIF.getString(R.string.confirm), this.hiJ);
            c0746a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dyF.dismiss();
                    if (e.this.hiK != null) {
                        e.this.hiK.bTl();
                    }
                    e.this.hiI.bTp();
                }
            });
            arrayList.add(c0746a);
            this.hiJ.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dyF != null) {
                        e.this.dyF.dismiss();
                    }
                }
            });
            this.hiJ.aD(arrayList);
            this.dyF = new com.baidu.tieba.person.e(this.dIF.getPageActivity(), this.hiJ.aTh());
            this.dyF.N(0.7f);
        }
        this.dyF.show();
    }

    public void onChangeSkinType() {
        if (this.hiJ != null) {
            this.hiJ.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.hiK = aVar;
    }
}
