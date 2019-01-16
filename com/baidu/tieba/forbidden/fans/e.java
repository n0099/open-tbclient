package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.e;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.person.e anG;
    private ai dHc;
    private d dHd;
    private com.baidu.tieba.view.a dHe;
    private a dHf;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void aAp();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dHd = new d(tbPageContext, bdUniqueId);
        this.dHd.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.dHf != null) {
                    e.this.dHf.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dHc = new ai(tbPageContext, bdUniqueId);
        this.dHc.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dHf != null) {
                    e.this.dHf.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        xn();
    }

    public void bW(long j) {
        this.dHc.F(j);
    }

    private void xn() {
        if (this.anG == null) {
            this.dHe = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dHe.setTitleText(this.mContext.getString(e.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0333a c0333a = new a.C0333a(this.mContext.getString(e.j.confirm), this.dHe);
            c0333a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.anG.dismiss();
                    if (e.this.dHf != null) {
                        e.this.dHf.aAp();
                    }
                    e.this.dHd.aAt();
                }
            });
            arrayList.add(c0333a);
            this.dHe.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.anG != null) {
                        e.this.anG.dismiss();
                    }
                }
            });
            this.dHe.ef(arrayList);
            this.anG = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dHe.bNw());
            this.anG.ax(0.7f);
        }
        this.anG.show();
    }

    public void onChangeSkinType() {
        if (this.dHe != null) {
            this.dHe.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dHf = aVar;
    }
}
