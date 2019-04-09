package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e {
    private com.baidu.tieba.person.e buw;
    private ai eUd;
    private d eUe;
    private com.baidu.tieba.view.a eUf;
    private a eUg;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void baM();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.eUe = new d(tbPageContext, bdUniqueId);
        this.eUe.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.eUg != null) {
                    e.this.eUg.a(i, str, z, 0, 0L);
                }
            }
        });
        this.eUd = new ai(tbPageContext, bdUniqueId);
        this.eUd.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.eUg != null) {
                    e.this.eUg.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        VR();
    }

    public void cB(long j) {
        this.eUd.ai(j);
    }

    private void VR() {
        if (this.buw == null) {
            this.eUf = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.eUf.setTitleText(this.mContext.getString(d.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.mContext.getString(d.j.confirm), this.eUf);
            c0407a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.buw.dismiss();
                    if (e.this.eUg != null) {
                        e.this.eUg.baM();
                    }
                    e.this.eUe.baQ();
                }
            });
            arrayList.add(c0407a);
            this.eUf.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.buw != null) {
                        e.this.buw.dismiss();
                    }
                }
            });
            this.eUf.P(arrayList);
            this.buw = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.eUf.abh());
            this.buw.al(0.7f);
        }
        this.buw.show();
    }

    public void onChangeSkinType() {
        if (this.eUf != null) {
            this.eUf.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.eUg = aVar;
    }
}
