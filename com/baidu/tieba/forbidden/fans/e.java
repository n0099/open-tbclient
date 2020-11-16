package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class e {
    private TbPageContext eGu;
    private com.baidu.tieba.person.e etO;
    private al iDf;
    private d iDg;
    private com.baidu.tieba.view.a iDh;
    private a iDi;

    /* loaded from: classes22.dex */
    public interface a {
        void a(int i, String str, boolean z, int i2, long j);

        void cvU();
    }

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eGu = tbPageContext;
        this.iDg = new d(tbPageContext, bdUniqueId);
        this.iDg.a(new d.a() { // from class: com.baidu.tieba.forbidden.fans.e.1
            @Override // com.baidu.tieba.forbidden.fans.d.a
            public void l(int i, String str, boolean z) {
                if (e.this.iDi != null) {
                    e.this.iDi.a(i, str, z, 0, 0L);
                }
            }
        });
        this.iDf = new al(tbPageContext, bdUniqueId);
        this.iDf.a(new al.a() { // from class: com.baidu.tieba.forbidden.fans.e.2
            @Override // com.baidu.tbadk.core.util.al.a
            public void a(int i, String str, long j, boolean z) {
                if (e.this.iDi != null) {
                    e.this.iDi.a(i, str, z, 1, j);
                }
            }
        });
    }

    public void removeAll() {
        biw();
    }

    public void fE(long j) {
        this.iDf.dm(j);
    }

    private void biw() {
        if (this.etO == null) {
            this.iDh = new com.baidu.tieba.view.a(this.eGu.getContext());
            this.iDh.setTitleText(this.eGu.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.C0873a c0873a = new a.C0873a(this.eGu.getString(R.string.confirm), this.iDh);
            c0873a.a(new a.c() { // from class: com.baidu.tieba.forbidden.fans.e.3
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    e.this.etO.dismiss();
                    if (e.this.iDi != null) {
                        e.this.iDi.cvU();
                    }
                    e.this.iDg.cvY();
                }
            });
            arrayList.add(c0873a);
            this.iDh.a(new a.b() { // from class: com.baidu.tieba.forbidden.fans.e.4
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (e.this.etO != null) {
                        e.this.etO.dismiss();
                    }
                }
            });
            this.iDh.br(arrayList);
            this.etO = new com.baidu.tieba.person.e(this.eGu.getPageActivity(), this.iDh.bow());
            this.etO.Z(0.7f);
        }
        this.etO.show();
    }

    public void onChangeSkinType() {
        if (this.iDh != null) {
            this.iDh.onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.iDi = aVar;
    }
}
