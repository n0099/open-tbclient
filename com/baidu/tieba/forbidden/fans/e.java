package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e {
    private com.baidu.tieba.person.e bCx;
    private ai fpL;
    private d fpM;
    private com.baidu.tieba.view.a fpN;
    private a fpO;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bkr();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.fpM = new d(tbPageContext, bdUniqueId);
        this.fpM.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void h(int i, String str, boolean z) {
                if (e.this.fpO != null) {
                    e.this.fpO.a(i, str, z, 0, 0L);
                }
            }
        });
        this.fpL = new ai(tbPageContext, bdUniqueId);
        this.fpL.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.fpO != null) {
                    e.this.fpO.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        abw();
    }

    public void df(long j) {
        this.fpL.av(j);
    }

    private void abw() {
        if (this.bCx == null) {
            this.fpN = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.fpN.setTitleText(this.mContext.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0431a c0431a = new a.C0431a(this.mContext.getString(R.string.confirm), this.fpN);
            c0431a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bCx.dismiss();
                    if (e.this.fpO != null) {
                        e.this.fpO.bkr();
                    }
                    e.this.fpM.bkv();
                }
            });
            arrayList.add(c0431a);
            this.fpN.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bCx != null) {
                        e.this.bCx.dismiss();
                    }
                }
            });
            this.fpN.W(arrayList);
            this.bCx = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.fpN.ahd());
            this.bCx.an(0.7f);
        }
        this.bCx.show();
    }

    public void onChangeSkinType() {
        if (this.fpN != null) {
            this.fpN.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fpO = aVar;
    }
}
