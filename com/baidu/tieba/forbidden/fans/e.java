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
    private com.baidu.tieba.person.e dSQ;
    private TbPageContext efn;
    private al hNQ;
    private d hNR;
    private com.baidu.tieba.view.a hNS;
    private a hNT;

    /* loaded from: classes17.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cjX();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efn = tbPageContext;
        this.hNR = new d(tbPageContext, bdUniqueId);
        this.hNR.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.hNT != null) {
                    e.this.hNT.a(i, str, z, 0, 0L);
                }
            }
        });
        this.hNQ = new al(tbPageContext, bdUniqueId);
        this.hNQ.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.hNT != null) {
                    e.this.hNT.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bbx();
    }

    public void eD(long j) {
        this.hNQ.cF(j);
    }

    private void bbx() {
        if (this.dSQ == null) {
            this.hNS = new com.baidu.tieba.view.a(this.efn.getContext());
            this.hNS.setTitleText(this.efn.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0825a c0825a = new a.C0825a(this.efn.getString(R.string.confirm), this.hNS);
            c0825a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.dSQ.dismiss();
                    if (e.this.hNT != null) {
                        e.this.hNT.cjX();
                    }
                    e.this.hNR.ckb();
                }
            });
            arrayList.add(c0825a);
            this.hNS.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.dSQ != null) {
                        e.this.dSQ.dismiss();
                    }
                }
            });
            this.hNS.aT(arrayList);
            this.dSQ = new com.baidu.tieba.person.e(this.efn.getPageActivity(), this.hNS.bhw());
            this.dSQ.U(0.7f);
        }
        this.dSQ.show();
    }

    public void onChangeSkinType() {
        if (this.hNS != null) {
            this.hNS.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.hNT = aVar;
    }
}
