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
    private com.baidu.tieba.person.e cLg;
    private TbPageContext cVg;
    private ai gjA;
    private d gjB;
    private com.baidu.tieba.view.a gjC;
    private a gjD;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bCg();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVg = tbPageContext;
        this.gjB = new d(tbPageContext, bdUniqueId);
        this.gjB.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void j(int i, String str, boolean z) {
                if (e.this.gjD != null) {
                    e.this.gjD.a(i, str, z, 0, 0L);
                }
            }
        });
        this.gjA = new ai(tbPageContext, bdUniqueId);
        this.gjA.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.gjD != null) {
                    e.this.gjD.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        azD();
    }

    public void ds(long j) {
        this.gjA.bz(j);
    }

    private void azD() {
        if (this.cLg == null) {
            this.gjC = new com.baidu.tieba.view.a(this.cVg.getContext());
            this.gjC.setTitleText(this.cVg.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0629a c0629a = new a.C0629a(this.cVg.getString(R.string.confirm), this.gjC);
            c0629a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.cLg.dismiss();
                    if (e.this.gjD != null) {
                        e.this.gjD.bCg();
                    }
                    e.this.gjB.bCk();
                }
            });
            arrayList.add(c0629a);
            this.gjC.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.cLg != null) {
                        e.this.cLg.dismiss();
                    }
                }
            });
            this.gjC.az(arrayList);
            this.cLg = new com.baidu.tieba.person.e(this.cVg.getPageActivity(), this.gjC.aEP());
            this.cLg.ae(0.7f);
        }
        this.cLg.show();
    }

    public void onChangeSkinType() {
        if (this.gjC != null) {
            this.gjC.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gjD = aVar;
    }
}
