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
    private ai fpl;
    private d fpm;
    private com.baidu.tieba.view.a fpn;
    private a fpo;
    private TbPageContext mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void bkk();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.fpm = new d(tbPageContext, bdUniqueId);
        this.fpm.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void h(int i, String str, boolean z) {
                if (e.this.fpo != null) {
                    e.this.fpo.a(i, str, z, 0, 0L);
                }
            }
        });
        this.fpl = new ai(tbPageContext, bdUniqueId);
        this.fpl.a(new ai.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.ai.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.fpo != null) {
                    e.this.fpo.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        abw();
    }

    public void df(long j) {
        this.fpl.av(j);
    }

    private void abw() {
        if (this.bCx == null) {
            this.fpn = new com.baidu.tieba.view.a(this.mContext.getContext());
            this.fpn.setTitleText(this.mContext.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0425a c0425a = new a.C0425a(this.mContext.getString(R.string.confirm), this.fpn);
            c0425a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.bCx.dismiss();
                    if (e.this.fpo != null) {
                        e.this.fpo.bkk();
                    }
                    e.this.fpm.bko();
                }
            });
            arrayList.add(c0425a);
            this.fpn.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.bCx != null) {
                        e.this.bCx.dismiss();
                    }
                }
            });
            this.fpn.W(arrayList);
            this.bCx = new com.baidu.tieba.person.e(this.mContext.getPageActivity(), this.fpn.ahb());
            this.bCx.an(0.7f);
        }
        this.bCx.show();
    }

    public void onChangeSkinType() {
        if (this.fpn != null) {
            this.fpn.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fpo = aVar;
    }
}
