package com.baidu.tbadk.system.portrait;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private TbPageContext<?> LH;
    private ArrayList<k> arV;
    private int arY;
    private int arZ;
    private int padding;
    private final int arQ = 4;
    private final int arR = 1;
    private final int arS = 2;
    private final int arT = 3;
    private int arU = 0;
    private int arK = -1;
    private int arW = ay.getColor(n.black_alpha10);
    private int arX = ay.getColor(n.cp_link_tip_a);

    public i(TbPageContext<?> tbPageContext) {
        this.arV = null;
        this.LH = null;
        this.padding = 0;
        this.LH = tbPageContext;
        this.arV = new ArrayList<>();
        this.arY = com.baidu.adp.lib.util.n.d(tbPageContext.getPageActivity(), o.ds1);
        this.arZ = com.baidu.adp.lib.util.n.d(this.LH.getPageActivity(), o.ds4);
        this.padding = com.baidu.adp.lib.util.n.d(this.LH.getPageActivity(), o.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.arV != null) {
            return this.arV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.arV == null || i >= this.arV.size()) {
            return null;
        }
        return this.arV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.LH.getPageActivity(), r.recommend_system_photo_item, viewGroup, false);
            jVar = new j(this, null);
            jVar.agF = (LinearLayout) view.findViewById(q.photo_container);
            jVar.asa = (TbImageView) view.findViewById(q.photo);
        } else {
            jVar = (j) view.getTag();
        }
        if (eo(i) == 1) {
            jVar.agF.setPadding(0, this.padding, 0, 0);
        } else if (eo(i) == 2) {
            jVar.agF.setPadding(0, 0, 0, this.padding);
        } else {
            jVar.agF.setPadding(0, 0, 0, 0);
        }
        jVar.asa.setDrawerType(0);
        jVar.asa.setBorderSurroundContent(true);
        jVar.asa.setDrawBorder(true);
        if (itemViewType == 0) {
            jVar.asa.setBorderColor(this.arW);
            jVar.asa.setBorderWidth(this.arY);
        } else {
            jVar.asa.setBorderColor(this.arX);
            jVar.asa.setBorderWidth(this.arZ);
        }
        jVar.asa.setDefaultResource(p.icon_default_avatar100);
        jVar.asa.c(this.arV.get(i).getUrl(), 10, false);
        view.setTag(jVar);
        return view;
    }

    public int eo(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.arU - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.arK ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<k> arrayList) {
        this.arV = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.arU = arrayList.size() / 4;
            } else {
                this.arU = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void ep(int i) {
        this.arK = i;
    }
}
