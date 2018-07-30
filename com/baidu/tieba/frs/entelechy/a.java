package com.baidu.tieba.frs.entelechy;

import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a extends com.baidu.tieba.frs.view.b {
    protected n dnD;
    protected f dsX;
    protected TextView dsY;
    protected ViewGroup dsZ;
    protected FrsStarRankAndTaskContainer dta;
    private int dtb = 3;

    public void awz() {
        this.dsY = (TextView) this.dJh.findViewById(d.g.top_item_type);
        this.dsY.setText(TbadkCoreApplication.getInst().getString(d.j.game));
        this.dJl = new AdapterLinearLayout(this.dnR.getPageContext().getPageActivity());
        this.dJl.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dJl.setOrientation(1);
        this.dJl.setPadding(0, 0, 0, l.f(this.mContext.getPageActivity(), d.e.tbds16));
        this.dsX = new f(this.dnR);
        this.dsX.a(this.dJX);
        this.dJl.setAdapter(this.dsX);
    }

    public void a(n nVar) {
        this.dnD = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bn(List<g> list) {
        if (this.dnR != null && this.dnR.auD() != null && this.dsX != null) {
            ArrayList arrayList = new ArrayList();
            List<h> bvn = this.dnR.auD().bvn();
            if (!w.z(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).btU() == 1) {
                        arrayList.add(list.get(i));
                    }
                }
            }
            if (bvn != null) {
                for (int i2 = 0; i2 < w.y(bvn) && arrayList.size() < this.dtb; i2++) {
                    h hVar = (h) w.d(bvn, i2);
                    if (hVar instanceof bb) {
                        arrayList.add(hVar);
                        if (((bb) hVar).ve() == 1) {
                            this.dtb = 4;
                        } else if (this.dnR.auD().aZl() != null && this.dnR.auD().aZl().isShowAllTopThread == 0 && arrayList.size() >= 1) {
                            break;
                        }
                    }
                }
            }
            if (this.dsX instanceof com.baidu.tieba.frs.e.c) {
                f fVar = this.dsX;
                if (fVar.axh() != null && this.dnR.auD() != null) {
                    if (this.dnR.auD().gLj == 1) {
                        fVar.axh().dED = true;
                    } else {
                        fVar.axh().dED = false;
                    }
                    if (this.dnR.auD().aZl() != null) {
                        fVar.axh().dEF = this.dnR.auD().aZl().getId();
                    }
                }
            }
            if (!w.z(list) && list.get(0).btU() != 1) {
                arrayList.add(list.get(0));
            }
            this.dsX.c(this.dnD);
            this.dsX.setData(arrayList);
            this.dsX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awA() {
        if (this.dsX != null) {
            this.dsX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awB() {
        if (this.dsX != null) {
            this.dsX.notifyDataSetChanged();
        }
    }
}
