package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.c;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class d {
    private e eKt;
    private TbPageContext eXu;
    private ak jak;
    private c jal;
    private com.baidu.tieba.view.a jam;
    private a jan;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cDd();
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eXu = tbPageContext;
        this.jal = new c(tbPageContext, bdUniqueId);
        this.jal.a(new c.a() { // from class: com.baidu.tieba.forbidden.fans.d.1
            @Override // com.baidu.tieba.forbidden.fans.c.a
            public void l(int i, String str, boolean z) {
                if (d.this.jan != null) {
                    d.this.jan.a(i, str, z, 0, 0L);
                }
            }
        });
        this.jak = new ak(tbPageContext, bdUniqueId);
        this.jak.a(new ak.a() { // from class: com.baidu.tieba.forbidden.fans.d.2
            @Override // com.baidu.tbadk.core.util.ak.a
            public void a(int i, String str, long j, boolean z) {
                if (d.this.jan != null) {
                    d.this.jan.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        bof();
    }

    public void gi(long j) {
        this.jak.dL(j);
    }

    private void bof() {
        if (this.eKt == null) {
            this.jam = new com.baidu.tieba.view.a(this.eXu.getContext());
            this.jam.setTitleText(this.eXu.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0871a c0871a = new a.C0871a(this.eXu.getString(R.string.confirm), this.jam);
            c0871a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.d.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    d.this.eKt.dismiss();
                    if (d.this.jan != null) {
                        d.this.jan.cDd();
                    }
                    d.this.jal.cDh();
                }
            });
            arrayList.add(c0871a);
            this.jam.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.d.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eKt != null) {
                        d.this.eKt.dismiss();
                    }
                }
            });
            this.jam.bB(arrayList);
            this.eKt = new e(this.eXu.getPageActivity(), this.jam.bur());
            this.eKt.ab(0.7f);
        }
        this.eKt.show();
    }

    public void onChangeSkinType() {
        if (this.jam != null) {
            this.jam.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.jan = aVar;
    }
}
