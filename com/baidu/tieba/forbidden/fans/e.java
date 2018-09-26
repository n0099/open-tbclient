package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.e;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e {
    private com.baidu.tieba.person.e adS;
    private ai dnL;
    private d dnM;
    private com.baidu.tieba.view.a dnN;
    private a dnO;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void auz();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dnM = new d(tbPageContext, bdUniqueId);
        this.dnM.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.dnO != null) {
                    e.this.dnO.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dnL = new ai(tbPageContext, bdUniqueId);
        this.dnL.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dnO != null) {
                    e.this.dnO.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        tD();
    }

    public void bH(long j) {
        this.dnL.w(j);
    }

    private void tD() {
        if (this.adS == null) {
            this.dnN = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dnN.setTitleText(this.mContext.getString(e.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0257a c0257a = new a.C0257a(this.mContext.getString(e.j.confirm), this.dnN);
            c0257a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.adS.dismiss();
                    if (e.this.dnO != null) {
                        e.this.dnO.auz();
                    }
                    e.this.dnM.auD();
                }
            });
            arrayList.add(c0257a);
            this.dnN.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.adS != null) {
                        e.this.adS.dismiss();
                    }
                }
            });
            this.dnN.dN(arrayList);
            this.adS = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dnN.bHj());
            this.adS.au(0.7f);
        }
        this.adS.show();
    }

    public void onChangeSkinType() {
        if (this.dnN != null) {
            this.dnN.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dnO = aVar;
    }
}
