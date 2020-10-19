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
    private com.baidu.tieba.person.e ehg;
    private TbPageContext etO;
    private al ijV;
    private d ijW;
    private com.baidu.tieba.view.a ijX;
    private a ijY;

    /* loaded from: classes23.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cqJ();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.etO = tbPageContext;
        this.ijW = new d(tbPageContext, bdUniqueId);
        this.ijW.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void l(int i, String str, boolean z) {
                if (e.this.ijY != null) {
                    e.this.ijY.a(i, str, z, 0, 0L);
                }
            }
        });
        this.ijV = new al(tbPageContext, bdUniqueId);
        this.ijV.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.ijY != null) {
                    e.this.ijY.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        beZ();
    }

    public void fe(long j) {
        this.ijV.cO(j);
    }

    private void beZ() {
        if (this.ehg == null) {
            this.ijX = new com.baidu.tieba.view.a(this.etO.getContext());
            this.ijX.setTitleText(this.etO.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0840a c0840a = new a.C0840a(this.etO.getString(R.string.confirm), this.ijX);
            c0840a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.ehg.dismiss();
                    if (e.this.ijY != null) {
                        e.this.ijY.cqJ();
                    }
                    e.this.ijW.cqN();
                }
            });
            arrayList.add(c0840a);
            this.ijX.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.ehg != null) {
                        e.this.ehg.dismiss();
                    }
                }
            });
            this.ijX.ba(arrayList);
            this.ehg = new com.baidu.tieba.person.e(this.etO.getPageActivity(), this.ijX.bkZ());
            this.ehg.W(0.7f);
        }
        this.ehg.show();
    }

    public void onChangeSkinType() {
        if (this.ijX != null) {
            this.ijX.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.ijY = aVar;
    }
}
