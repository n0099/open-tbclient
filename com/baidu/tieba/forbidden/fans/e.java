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
    private com.baidu.tieba.person.e buv;
    private ai eUc;
    private d eUd;
    private com.baidu.tieba.view.a eUe;
    private a eUf;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void baM();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.eUd = new d(tbPageContext, bdUniqueId);
        this.eUd.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.eUf != null) {
                    e.this.eUf.a(i, str, z, 0, 0L);
                }
            }
        });
        this.eUc = new ai(tbPageContext, bdUniqueId);
        this.eUc.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.eUf != null) {
                    e.this.eUf.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        VR();
    }

    public void cB(long j) {
        this.eUc.ai(j);
    }

    private void VR() {
        if (this.buv == null) {
            this.eUe = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.eUe.setTitleText(this.mContext.getString(d.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.mContext.getString(d.j.confirm), this.eUe);
            c0407a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.buv.dismiss();
                    if (e.this.eUf != null) {
                        e.this.eUf.baM();
                    }
                    e.this.eUd.baQ();
                }
            });
            arrayList.add(c0407a);
            this.eUe.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.buv != null) {
                        e.this.buv.dismiss();
                    }
                }
            });
            this.eUe.P(arrayList);
            this.buv = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.eUe.abh());
            this.buv.al(0.7f);
        }
        this.buv.show();
    }

    public void onChangeSkinType() {
        if (this.eUe != null) {
            this.eUe.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.eUf = aVar;
    }
}
