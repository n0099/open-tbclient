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
    private com.baidu.tieba.person.e cLt;
    private TbPageContext cVv;
    private a gkA;
    private ai gkx;
    private d gky;
    private com.baidu.tieba.view.a gkz;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bCp();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVv = tbPageContext;
        this.gky = new d(tbPageContext, bdUniqueId);
        this.gky.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.gkA != null) {
                    e.this.gkA.a(i, str, z, 0, 0L);
                }
            }
        });
        this.gkx = new ai(tbPageContext, bdUniqueId);
        this.gkx.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.gkA != null) {
                    e.this.gkA.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        azI();
    }

    public void ds(long j) {
        this.gkx.bz(j);
    }

    private void azI() {
        if (this.cLt == null) {
            this.gkz = new com.baidu.tieba.view.a(this.cVv.getContext());
            this.gkz.setTitleText(this.cVv.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0630a c0630a = new a.C0630a(this.cVv.getString(R.string.confirm), this.gkz);
            c0630a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.cLt.dismiss();
                    if (e.this.gkA != null) {
                        e.this.gkA.bCp();
                    }
                    e.this.gky.bCt();
                }
            });
            arrayList.add(c0630a);
            this.gkz.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.cLt != null) {
                        e.this.cLt.dismiss();
                    }
                }
            });
            this.gkz.az(arrayList);
            this.cLt = new com.baidu.tieba.person.e(this.cVv.getPageActivity(), this.gkz.aEV());
            this.cLt.ae(0.7f);
        }
        this.cLt.show();
    }

    public void onChangeSkinType() {
        if (this.gkz != null) {
            this.gkz.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gkA = aVar;
    }
}
