package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e {
    private com.baidu.tieba.person.e bus;
    private ai eUq;
    private d eUr;
    private com.baidu.tieba.view.a eUs;
    private a eUt;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void baO();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.eUr = new d(tbPageContext, bdUniqueId);
        this.eUr.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void g(int i, String str, boolean z) {
                if (e.this.eUt != null) {
                    e.this.eUt.a(i, str, z, 0, 0L);
                }
            }
        });
        this.eUq = new ai(tbPageContext, bdUniqueId);
        this.eUq.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.eUt != null) {
                    e.this.eUt.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        VU();
    }

    public void cB(long j) {
        this.eUq.ai(j);
    }

    private void VU() {
        if (this.bus == null) {
            this.eUs = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.eUs.setTitleText(this.mContext.getString(d.j.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0407a c0407a = new a.C0407a(this.mContext.getString(d.j.confirm), this.eUs);
            c0407a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bus.dismiss();
                    if (e.this.eUt != null) {
                        e.this.eUt.baO();
                    }
                    e.this.eUr.baS();
                }
            });
            arrayList.add(c0407a);
            this.eUs.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bus != null) {
                        e.this.bus.dismiss();
                    }
                }
            });
            this.eUs.P(arrayList);
            this.bus = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.eUs.abk());
            this.bus.al(0.7f);
        }
        this.bus.show();
    }

    public void onChangeSkinType() {
        if (this.eUs != null) {
            this.eUs.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.eUt = aVar;
    }
}
