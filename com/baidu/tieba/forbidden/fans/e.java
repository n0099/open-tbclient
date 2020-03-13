package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class e {
    private com.baidu.tieba.person.e cLi;
    private TbPageContext cVi;
    private ai gjP;
    private d gjQ;
    private com.baidu.tieba.view.a gjR;
    private a gjS;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bCj();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVi = tbPageContext;
        this.gjQ = new d(tbPageContext, bdUniqueId);
        this.gjQ.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.gjS != null) {
                    e.this.gjS.a(i, str, z, 0, 0L);
                }
            }
        });
        this.gjP = new ai(tbPageContext, bdUniqueId);
        this.gjP.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.gjS != null) {
                    e.this.gjS.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        azF();
    }

    public void ds(long j) {
        this.gjP.bz(j);
    }

    private void azF() {
        if (this.cLi == null) {
            this.gjR = new com.baidu.tieba.view.a(this.cVi.getContext());
            this.gjR.setTitleText(this.cVi.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.cVi.getString(R.string.confirm), this.gjR);
            c0629a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.cLi.dismiss();
                    if (e.this.gjS != null) {
                        e.this.gjS.bCj();
                    }
                    e.this.gjQ.bCn();
                }
            });
            arrayList.add(c0629a);
            this.gjR.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.cLi != null) {
                        e.this.cLi.dismiss();
                    }
                }
            });
            this.gjR.az(arrayList);
            this.cLi = new com.baidu.tieba.person.e(this.cVi.getPageActivity(), this.gjR.aER());
            this.cLi.ae(0.7f);
        }
        this.cLi.show();
    }

    public void onChangeSkinType() {
        if (this.gjR != null) {
            this.gjR.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gjS = aVar;
    }
}
