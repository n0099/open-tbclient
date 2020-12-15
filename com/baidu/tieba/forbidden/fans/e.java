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
    private com.baidu.tieba.person.e eAQ;
    private TbPageContext eNx;
    private al iNZ;
    private d iOa;
    private com.baidu.tieba.view.a iOb;
    private a iOc;

    /* loaded from: classes23.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cAk();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eNx = tbPageContext;
        this.iOa = new d(tbPageContext, bdUniqueId);
        this.iOa.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void l(int i, String str, boolean z) {
                if (e.this.iOc != null) {
                    e.this.iOc.a(i, str, z, 0, 0L);
                }
            }
        });
        this.iNZ = new al(tbPageContext, bdUniqueId);
        this.iNZ.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.iOc != null) {
                    e.this.iOc.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        blG();
    }

    public void gi(long j) {
        this.iNZ.dL(j);
    }

    private void blG() {
        if (this.eAQ == null) {
            this.iOb = new com.baidu.tieba.view.a(this.eNx.getContext());
            this.iOb.setTitleText(this.eNx.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0889a c0889a = new a.C0889a(this.eNx.getString(R.string.confirm), this.iOb);
            c0889a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.eAQ.dismiss();
                    if (e.this.iOc != null) {
                        e.this.iOc.cAk();
                    }
                    e.this.iOa.cAo();
                }
            });
            arrayList.add(c0889a);
            this.iOb.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.eAQ != null) {
                        e.this.eAQ.dismiss();
                    }
                }
            });
            this.iOb.bu(arrayList);
            this.eAQ = new com.baidu.tieba.person.e(this.eNx.getPageActivity(), this.iOb.brP());
            this.eAQ.Z(0.7f);
        }
        this.eAQ.show();
    }

    public void onChangeSkinType() {
        if (this.iOb != null) {
            this.iOb.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.iOc = aVar;
    }
}
