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
    private com.baidu.tieba.person.e cLh;
    private TbPageContext cVh;
    private ai gjC;
    private d gjD;
    private com.baidu.tieba.view.a gjE;
    private a gjF;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bCi();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVh = tbPageContext;
        this.gjD = new d(tbPageContext, bdUniqueId);
        this.gjD.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.gjF != null) {
                    e.this.gjF.a(i, str, z, 0, 0L);
                }
            }
        });
        this.gjC = new ai(tbPageContext, bdUniqueId);
        this.gjC.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.gjF != null) {
                    e.this.gjF.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        azF();
    }

    public void ds(long j) {
        this.gjC.bz(j);
    }

    private void azF() {
        if (this.cLh == null) {
            this.gjE = new com.baidu.tieba.view.a(this.cVh.getContext());
            this.gjE.setTitleText(this.cVh.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.cVh.getString(R.string.confirm), this.gjE);
            c0629a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.cLh.dismiss();
                    if (e.this.gjF != null) {
                        e.this.gjF.bCi();
                    }
                    e.this.gjD.bCm();
                }
            });
            arrayList.add(c0629a);
            this.gjE.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.cLh != null) {
                        e.this.cLh.dismiss();
                    }
                }
            });
            this.gjE.az(arrayList);
            this.cLh = new com.baidu.tieba.person.e(this.cVh.getPageActivity(), this.gjE.aER());
            this.cLh.ae(0.7f);
        }
        this.cLh.show();
    }

    public void onChangeSkinType() {
        if (this.gjE != null) {
            this.gjE.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gjF = aVar;
    }
}
