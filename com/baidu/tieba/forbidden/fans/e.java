package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class e {
    private TbPageContext eIc;
    private com.baidu.tieba.person.e evx;
    private al iCq;
    private d iCr;
    private com.baidu.tieba.view.a iCs;
    private a iCt;

    /* loaded from: classes23.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cwr();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eIc = tbPageContext;
        this.iCr = new d(tbPageContext, bdUniqueId);
        this.iCr.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void l(int i, String str, boolean z) {
                if (e.this.iCt != null) {
                    e.this.iCt.a(i, str, z, 0, 0L);
                }
            }
        });
        this.iCq = new al(tbPageContext, bdUniqueId);
        this.iCq.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.iCt != null) {
                    e.this.iCt.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bjs();
    }

    public void fB(long j) {
        this.iCq.dm(j);
    }

    private void bjs() {
        if (this.evx == null) {
            this.iCs = new com.baidu.tieba.view.a(this.eIc.getContext());
            this.iCs.setTitleText(this.eIc.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0870a c0870a = new a.C0870a(this.eIc.getString(R.string.confirm), this.iCs);
            c0870a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.evx.dismiss();
                    if (e.this.iCt != null) {
                        e.this.iCt.cwr();
                    }
                    e.this.iCr.cwv();
                }
            });
            arrayList.add(c0870a);
            this.iCs.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.evx != null) {
                        e.this.evx.dismiss();
                    }
                }
            });
            this.iCs.br(arrayList);
            this.evx = new com.baidu.tieba.person.e(this.eIc.getPageActivity(), this.iCs.bps());
            this.evx.aa(0.7f);
        }
        this.evx.show();
    }

    public void onChangeSkinType() {
        if (this.iCs != null) {
            this.iCs.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.iCt = aVar;
    }
}
