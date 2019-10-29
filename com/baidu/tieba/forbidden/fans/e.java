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
    private com.baidu.tieba.person.e bVq;
    private TbPageContext cfl;
    private ai fqK;
    private d fqL;
    private com.baidu.tieba.view.a fqM;
    private a fqN;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bij();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cfl = tbPageContext;
        this.fqL = new d(tbPageContext, bdUniqueId);
        this.fqL.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void h(int i, String str, boolean z) {
                if (e.this.fqN != null) {
                    e.this.fqN.a(i, str, z, 0, 0L);
                }
            }
        });
        this.fqK = new ai(tbPageContext, bdUniqueId);
        this.fqK.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.fqN != null) {
                    e.this.fqN.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        agg();
    }

    public void cI(long j) {
        this.fqK.aO(j);
    }

    private void agg() {
        if (this.bVq == null) {
            this.fqM = new com.baidu.tieba.view.a(this.cfl.getContext());
            this.fqM.setTitleText(this.cfl.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0537a c0537a = new a.C0537a(this.cfl.getString(R.string.confirm), this.fqM);
            c0537a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bVq.dismiss();
                    if (e.this.fqN != null) {
                        e.this.fqN.bij();
                    }
                    e.this.fqL.bin();
                }
            });
            arrayList.add(c0537a);
            this.fqM.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bVq != null) {
                        e.this.bVq.dismiss();
                    }
                }
            });
            this.fqM.at(arrayList);
            this.bVq = new com.baidu.tieba.person.e(this.cfl.getPageActivity(), this.fqM.ale());
            this.bVq.ab(0.7f);
        }
        this.bVq.show();
    }

    public void onChangeSkinType() {
        if (this.fqM != null) {
            this.fqM.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fqN = aVar;
    }
}
