package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class e {
    private com.baidu.tieba.person.e dSU;
    private TbPageContext efr;
    private al hNW;
    private d hNX;
    private com.baidu.tieba.view.a hNY;
    private a hNZ;

    /* loaded from: classes17.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cjY();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efr = tbPageContext;
        this.hNX = new d(tbPageContext, bdUniqueId);
        this.hNX.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.hNZ != null) {
                    e.this.hNZ.a(i, str, z, 0, 0L);
                }
            }
        });
        this.hNW = new al(tbPageContext, bdUniqueId);
        this.hNW.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.hNZ != null) {
                    e.this.hNZ.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bbx();
    }

    public void eD(long j) {
        this.hNW.cF(j);
    }

    private void bbx() {
        if (this.dSU == null) {
            this.hNY = new com.baidu.tieba.view.a(this.efr.getContext());
            this.hNY.setTitleText(this.efr.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0825a c0825a = new a.C0825a(this.efr.getString(R.string.confirm), this.hNY);
            c0825a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dSU.dismiss();
                    if (e.this.hNZ != null) {
                        e.this.hNZ.cjY();
                    }
                    e.this.hNX.ckc();
                }
            });
            arrayList.add(c0825a);
            this.hNY.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dSU != null) {
                        e.this.dSU.dismiss();
                    }
                }
            });
            this.hNY.aT(arrayList);
            this.dSU = new com.baidu.tieba.person.e(this.efr.getPageActivity(), this.hNY.bhw());
            this.dSU.U(0.7f);
        }
        this.dSU.show();
    }

    public void onChangeSkinType() {
        if (this.hNY != null) {
            this.hNY.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.hNZ = aVar;
    }
}
