package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.f;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.person.e abp;
    private aj dhT;
    private d dhU;
    private com.baidu.tieba.view.a dhV;
    private a dhW;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void asL();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dhU = new d(tbPageContext, bdUniqueId);
        this.dhU.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void d(int i, String str, boolean z) {
                if (e.this.dhW != null) {
                    e.this.dhW.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dhT = new aj(tbPageContext, bdUniqueId);
        this.dhT.a(new aj.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dhW != null) {
                    e.this.dhW.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        sw();
    }

    public void bD(long j) {
        this.dhT.s(j);
    }

    private void sw() {
        if (this.abp == null) {
            this.dhV = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dhV.setTitleText(this.mContext.getString(f.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.mContext.getString(f.j.confirm), this.dhV);
            c0251a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.abp.dismiss();
                    if (e.this.dhW != null) {
                        e.this.dhW.asL();
                    }
                    e.this.dhU.asP();
                }
            });
            arrayList.add(c0251a);
            this.dhV.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.abp != null) {
                        e.this.abp.dismiss();
                    }
                }
            });
            this.dhV.dM(arrayList);
            this.abp = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dhV.bEs());
            this.abp.aA(0.7f);
        }
        this.abp.show();
    }

    public void onChangeSkinType() {
        if (this.dhV != null) {
            this.dhV.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dhW = aVar;
    }
}
