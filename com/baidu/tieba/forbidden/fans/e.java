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
    private com.baidu.tieba.person.e dkB;
    private TbPageContext duG;
    private ai gTE;
    private d gTF;
    private com.baidu.tieba.view.a gTG;
    private a gTH;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bMP();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.duG = tbPageContext;
        this.gTF = new d(tbPageContext, bdUniqueId);
        this.gTF.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void k(int i, String str, boolean z) {
                if (e.this.gTH != null) {
                    e.this.gTH.a(i, str, z, 0, 0L);
                }
            }
        });
        this.gTE = new ai(tbPageContext, bdUniqueId);
        this.gTE.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.gTH != null) {
                    e.this.gTH.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        aHV();
    }

    public void eb(long j) {
        this.gTE.ce(j);
    }

    private void aHV() {
        if (this.dkB == null) {
            this.gTG = new com.baidu.tieba.view.a(this.duG.getContext());
            this.gTG.setTitleText(this.duG.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0671a c0671a = new a.C0671a(this.duG.getString(R.string.confirm), this.gTG);
            c0671a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dkB.dismiss();
                    if (e.this.gTH != null) {
                        e.this.gTH.bMP();
                    }
                    e.this.gTF.bMT();
                }
            });
            arrayList.add(c0671a);
            this.gTG.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dkB != null) {
                        e.this.dkB.dismiss();
                    }
                }
            });
            this.gTG.aI(arrayList);
            this.dkB = new com.baidu.tieba.person.e(this.duG.getPageActivity(), this.gTG.aNj());
            this.dkB.O(0.7f);
        }
        this.dkB.show();
    }

    public void onChangeSkinType() {
        if (this.gTG != null) {
            this.gTG.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gTH = aVar;
    }
}
