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
    private com.baidu.tieba.person.e abo;
    private aj dhV;
    private d dhW;
    private com.baidu.tieba.view.a dhX;
    private a dhY;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void asM();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dhW = new d(tbPageContext, bdUniqueId);
        this.dhW.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void d(int i, String str, boolean z) {
                if (e.this.dhY != null) {
                    e.this.dhY.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dhV = new aj(tbPageContext, bdUniqueId);
        this.dhV.a(new aj.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.aj.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dhY != null) {
                    e.this.dhY.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        sx();
    }

    public void bD(long j) {
        this.dhV.s(j);
    }

    private void sx() {
        if (this.abo == null) {
            this.dhX = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dhX.setTitleText(this.mContext.getString(d.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.mContext.getString(d.j.confirm), this.dhX);
            c0251a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.abo.dismiss();
                    if (e.this.dhY != null) {
                        e.this.dhY.asM();
                    }
                    e.this.dhW.asQ();
                }
            });
            arrayList.add(c0251a);
            this.dhX.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.abo != null) {
                        e.this.abo.dismiss();
                    }
                }
            });
            this.dhX.dM(arrayList);
            this.abo = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dhX.bEq());
            this.abo.aB(0.7f);
        }
        this.abo.show();
    }

    public void onChangeSkinType() {
        if (this.dhX != null) {
            this.dhX.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dhY = aVar;
    }
}
