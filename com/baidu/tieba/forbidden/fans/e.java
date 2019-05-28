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
    private com.baidu.tieba.person.e bBz;
    private ai fko;
    private d fkp;
    private com.baidu.tieba.view.a fkq;
    private a fkr;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bii();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.fkp = new d(tbPageContext, bdUniqueId);
        this.fkp.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.fkr != null) {
                    e.this.fkr.a(i, str, z, 0, 0L);
                }
            }
        });
        this.fko = new ai(tbPageContext, bdUniqueId);
        this.fko.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.fkr != null) {
                    e.this.fkr.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        aax();
    }

    public void cY(long j) {
        this.fko.au(j);
    }

    private void aax() {
        if (this.bBz == null) {
            this.fkq = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.fkq.setTitleText(this.mContext.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0426a c0426a = new a.C0426a(this.mContext.getString(R.string.confirm), this.fkq);
            c0426a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bBz.dismiss();
                    if (e.this.fkr != null) {
                        e.this.fkr.bii();
                    }
                    e.this.fkp.bim();
                }
            });
            arrayList.add(c0426a);
            this.fkq.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bBz != null) {
                        e.this.bBz.dismiss();
                    }
                }
            });
            this.fkq.W(arrayList);
            this.bBz = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.fkq.afZ());
            this.bBz.an(0.7f);
        }
        this.bBz.show();
    }

    public void onChangeSkinType() {
        if (this.fkq != null) {
            this.fkq.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fkr = aVar;
    }
}
