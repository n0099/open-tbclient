package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.person.e abL;
    private aj dff;
    private d dfg;
    private com.baidu.tieba.view.a dfh;
    private a dfi;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void asi();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dfg = new d(tbPageContext, bdUniqueId);
        this.dfg.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void d(int i, String str, boolean z) {
                if (e.this.dfi != null) {
                    e.this.dfi.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dff = new aj(tbPageContext, bdUniqueId);
        this.dff.a(new aj.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dfi != null) {
                    e.this.dfi.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        sL();
    }

    public void bz(long j) {
        this.dff.s(j);
    }

    private void sL() {
        if (this.abL == null) {
            this.dfh = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dfh.setTitleText(this.mContext.getString(d.k.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.mContext.getString(d.k.confirm), this.dfh);
            c0251a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.abL.dismiss();
                    if (e.this.dfi != null) {
                        e.this.dfi.asi();
                    }
                    e.this.dfg.asm();
                }
            });
            arrayList.add(c0251a);
            this.dfh.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.abL != null) {
                        e.this.abL.dismiss();
                    }
                }
            });
            this.dfh.dQ(arrayList);
            this.abL = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dfh.bFF());
            this.abL.aA(0.7f);
        }
        this.abL.show();
    }

    public void onChangeSkinType() {
        if (this.dfh != null) {
            this.dfh.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dfi = aVar;
    }
}
