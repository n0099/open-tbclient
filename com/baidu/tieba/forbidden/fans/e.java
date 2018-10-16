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
    private com.baidu.tieba.person.e aiP;
    private ai dvO;
    private d dvP;
    private com.baidu.tieba.view.a dvQ;
    private a dvR;
    private TbPageContext mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void axV();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.dvP = new d(tbPageContext, bdUniqueId);
        this.dvP.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.dvR != null) {
                    e.this.dvR.a(i, str, z, 0, 0L);
                }
            }
        });
        this.dvO = new ai(tbPageContext, bdUniqueId);
        this.dvO.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.dvR != null) {
                    e.this.dvR.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        vM();
    }

    public void bO(long j) {
        this.dvO.y(j);
    }

    private void vM() {
        if (this.aiP == null) {
            this.dvQ = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.dvQ.setTitleText(this.mContext.getString(e.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0292a c0292a = new a.C0292a(this.mContext.getString(e.j.confirm), this.dvQ);
            c0292a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.aiP.dismiss();
                    if (e.this.dvR != null) {
                        e.this.dvR.axV();
                    }
                    e.this.dvP.axZ();
                }
            });
            arrayList.add(c0292a);
            this.dvQ.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.aiP != null) {
                        e.this.aiP.dismiss();
                    }
                }
            });
            this.dvQ.eb(arrayList);
            this.aiP = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.dvQ.bKv());
            this.aiP.av(0.7f);
        }
        this.aiP.show();
    }

    public void onChangeSkinType() {
        if (this.dvQ != null) {
            this.dvQ.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dvR = aVar;
    }
}
