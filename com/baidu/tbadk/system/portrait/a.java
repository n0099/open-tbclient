package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aNe;
    private int aNg;
    private int aNh;
    private TbPageContext<?> adf;
    private int padding;
    private int aMX = -1;
    private int rowSize = 0;
    private int alv = ak.getColor(d.C0126d.common_color_10043);
    private int aNf = ak.getColor(d.C0126d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aNe = null;
        this.adf = null;
        this.padding = 0;
        this.adf = tbPageContext;
        this.aNe = new ArrayList<>();
        this.aNg = l.e(tbPageContext.getPageActivity(), d.e.ds1);
        this.aNh = l.e(this.adf.getPageActivity(), d.e.ds4);
        this.padding = l.e(this.adf.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aNe != null) {
            return this.aNe.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aNe == null || i >= this.aNe.size()) {
            return null;
        }
        return this.aNe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0104a c0104a;
        int itemViewType = getItemViewType(i);
        if (view2 == null) {
            view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.recommend_system_photo_item, viewGroup, false);
            c0104a = new C0104a();
            c0104a.ayZ = (LinearLayout) view2.findViewById(d.g.photo_container);
            c0104a.aNi = (TbImageView) view2.findViewById(d.g.photo);
        } else {
            c0104a = (C0104a) view2.getTag();
        }
        if (fm(i) == 1) {
            c0104a.ayZ.setPadding(0, this.padding, 0, 0);
        } else if (fm(i) == 2) {
            c0104a.ayZ.setPadding(0, 0, 0, this.padding);
        } else {
            c0104a.ayZ.setPadding(0, 0, 0, 0);
        }
        c0104a.aNi.setDrawerType(0);
        c0104a.aNi.setBorderSurroundContent(true);
        c0104a.aNi.setDrawBorder(true);
        if (itemViewType == 0) {
            c0104a.aNi.setBorderColor(this.alv);
            c0104a.aNi.setBorderWidth(this.aNg);
        } else {
            c0104a.aNi.setBorderColor(this.aNf);
            c0104a.aNi.setBorderWidth(this.aNh);
        }
        c0104a.aNi.setDefaultResource(d.f.transparent_bg);
        c0104a.aNi.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0104a.aNi.startLoad(this.aNe.get(i).getUrl(), 10, false);
        view2.setTag(c0104a);
        return view2;
    }

    public int fm(int i) {
        if (i / 4 == 0) {
            return 1;
        }
        if (i / 4 == this.rowSize - 1) {
            return 2;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == this.aMX ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aNe = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fn(int i) {
        this.aMX = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0104a {
        TbImageView aNi;
        LinearLayout ayZ;

        private C0104a() {
        }
    }
}
