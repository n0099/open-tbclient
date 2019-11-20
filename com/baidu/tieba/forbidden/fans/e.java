package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e {
    private com.baidu.tieba.person.e bUz;
    private TbPageContext ceu;
    private ai fpT;
    private d fpU;
    private com.baidu.tieba.view.a fpV;
    private a fpW;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bih();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ceu = tbPageContext;
        this.fpU = new d(tbPageContext, bdUniqueId);
        this.fpU.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void h(int i, String str, boolean z) {
                if (e.this.fpW != null) {
                    e.this.fpW.a(i, str, z, 0, 0L);
                }
            }
        });
        this.fpT = new ai(tbPageContext, bdUniqueId);
        this.fpT.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.fpW != null) {
                    e.this.fpW.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        age();
    }

    public void cH(long j) {
        this.fpT.aN(j);
    }

    private void age() {
        if (this.bUz == null) {
            this.fpV = new com.baidu.tieba.view.a(this.ceu.getContext());
            this.fpV.setTitleText(this.ceu.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0537a c0537a = new a.C0537a(this.ceu.getString(R.string.confirm), this.fpV);
            c0537a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bUz.dismiss();
                    if (e.this.fpW != null) {
                        e.this.fpW.bih();
                    }
                    e.this.fpU.bil();
                }
            });
            arrayList.add(c0537a);
            this.fpV.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bUz != null) {
                        e.this.bUz.dismiss();
                    }
                }
            });
            this.fpV.at(arrayList);
            this.bUz = new com.baidu.tieba.person.e(this.ceu.getPageActivity(), this.fpV.alc());
            this.bUz.ab(0.7f);
        }
        this.bUz.show();
    }

    public void onChangeSkinType() {
        if (this.fpV != null) {
            this.fpV.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fpW = aVar;
    }
}
