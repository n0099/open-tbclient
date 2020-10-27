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
    private TbPageContext eCn;
    private com.baidu.tieba.person.e epE;
    private al iwt;
    private d iwu;
    private com.baidu.tieba.view.a iwv;
    private a iww;

    /* loaded from: classes23.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void ctQ();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eCn = tbPageContext;
        this.iwu = new d(tbPageContext, bdUniqueId);
        this.iwu.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void l(int i, String str, boolean z) {
                if (e.this.iww != null) {
                    e.this.iww.a(i, str, z, 0, 0L);
                }
            }
        });
        this.iwt = new al(tbPageContext, bdUniqueId);
        this.iwt.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.iww != null) {
                    e.this.iww.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bgS();
    }

    public void ff(long j) {
        this.iwt.cQ(j);
    }

    private void bgS() {
        if (this.epE == null) {
            this.iwv = new com.baidu.tieba.view.a(this.eCn.getContext());
            this.iwv.setTitleText(this.eCn.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0855a c0855a = new a.C0855a(this.eCn.getString(R.string.confirm), this.iwv);
            c0855a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.epE.dismiss();
                    if (e.this.iww != null) {
                        e.this.iww.ctQ();
                    }
                    e.this.iwu.ctU();
                }
            });
            arrayList.add(c0855a);
            this.iwv.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.epE != null) {
                        e.this.epE.dismiss();
                    }
                }
            });
            this.iwv.bk(arrayList);
            this.epE = new com.baidu.tieba.person.e(this.eCn.getPageActivity(), this.iwv.bmS());
            this.epE.Y(0.7f);
        }
        this.epE.show();
    }

    public void onChangeSkinType() {
        if (this.iwv != null) {
            this.iwv.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.iww = aVar;
    }
}
