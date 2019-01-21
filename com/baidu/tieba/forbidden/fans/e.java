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
    private com.baidu.tieba.person.e anH;
    private ai dHd;
    private d dHe;
    private com.baidu.tieba.view.a dHf;
    private a dHg;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void aAp();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dHe = new d(tbPageContext, bdUniqueId);
        this.dHe.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.dHg != null) {
                    e.this.dHg.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dHd = new ai(tbPageContext, bdUniqueId);
        this.dHd.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dHg != null) {
                    e.this.dHg.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        xn();
    }

    public void bW(long j) {
        this.dHd.F(j);
    }

    private void xn() {
        if (this.anH == null) {
            this.dHf = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dHf.setTitleText(this.mContext.getString(e.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0333a c0333a = new a.C0333a(this.mContext.getString(e.j.confirm), this.dHf);
            c0333a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.anH.dismiss();
                    if (e.this.dHg != null) {
                        e.this.dHg.aAp();
                    }
                    e.this.dHe.aAt();
                }
            });
            arrayList.add(c0333a);
            this.dHf.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.anH != null) {
                        e.this.anH.dismiss();
                    }
                }
            });
            this.dHf.ef(arrayList);
            this.anH = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dHf.bNw());
            this.anH.ax(0.7f);
        }
        this.anH.show();
    }

    public void onChangeSkinType() {
        if (this.dHf != null) {
            this.dHf.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dHg = aVar;
    }
}
