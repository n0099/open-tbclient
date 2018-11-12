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
    private com.baidu.tieba.person.e ajC;
    private ai dxg;
    private d dxh;
    private com.baidu.tieba.view.a dxi;
    private a dxj;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void axt();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dxh = new d(tbPageContext, bdUniqueId);
        this.dxh.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.dxj != null) {
                    e.this.dxj.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dxg = new ai(tbPageContext, bdUniqueId);
        this.dxg.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dxj != null) {
                    e.this.dxj.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        vW();
    }

    public void bK(long j) {
        this.dxg.A(j);
    }

    private void vW() {
        if (this.ajC == null) {
            this.dxi = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dxi.setTitleText(this.mContext.getString(e.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0320a c0320a = new a.C0320a(this.mContext.getString(e.j.confirm), this.dxi);
            c0320a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.ajC.dismiss();
                    if (e.this.dxj != null) {
                        e.this.dxj.axt();
                    }
                    e.this.dxh.axx();
                }
            });
            arrayList.add(c0320a);
            this.dxi.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.ajC != null) {
                        e.this.ajC.dismiss();
                    }
                }
            });
            this.dxi.dZ(arrayList);
            this.ajC = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dxi.bJU());
            this.ajC.ax(0.7f);
        }
        this.ajC.show();
    }

    public void onChangeSkinType() {
        if (this.dxi != null) {
            this.dxi.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dxj = aVar;
    }
}
