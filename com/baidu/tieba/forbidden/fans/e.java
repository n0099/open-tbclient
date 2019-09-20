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
    private com.baidu.tieba.person.e bCV;
    private d frA;
    private com.baidu.tieba.view.a frB;
    private a frC;
    private ai frz;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void blc();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.frA = new d(tbPageContext, bdUniqueId);
        this.frA.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void h(int i, String str, boolean z) {
                if (e.this.frC != null) {
                    e.this.frC.a(i, str, z, 0, 0L);
                }
            }
        });
        this.frz = new ai(tbPageContext, bdUniqueId);
        this.frz.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.frC != null) {
                    e.this.frC.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        abA();
    }

    public void di(long j) {
        this.frz.av(j);
    }

    private void abA() {
        if (this.bCV == null) {
            this.frB = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.frB.setTitleText(this.mContext.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0442a c0442a = new a.C0442a(this.mContext.getString(R.string.confirm), this.frB);
            c0442a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bCV.dismiss();
                    if (e.this.frC != null) {
                        e.this.frC.blc();
                    }
                    e.this.frA.blg();
                }
            });
            arrayList.add(c0442a);
            this.frB.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bCV != null) {
                        e.this.bCV.dismiss();
                    }
                }
            });
            this.frB.W(arrayList);
            this.bCV = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.frB.ahh());
            this.bCV.an(0.7f);
        }
        this.bCV.show();
    }

    public void onChangeSkinType() {
        if (this.frB != null) {
            this.frB.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.frC = aVar;
    }
}
