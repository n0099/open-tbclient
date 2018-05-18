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
    private ArrayList<b> aNf;
    private int aNh;
    private int aNi;
    private TbPageContext<?> mContext;
    private int padding;
    private int aMY = -1;
    private int rowSize = 0;
    private int alv = ak.getColor(d.C0126d.common_color_10043);
    private int aNg = ak.getColor(d.C0126d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aNf = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aNf = new ArrayList<>();
        this.aNh = l.e(tbPageContext.getPageActivity(), d.e.ds1);
        this.aNi = l.e(this.mContext.getPageActivity(), d.e.ds4);
        this.padding = l.e(this.mContext.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aNf != null) {
            return this.aNf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aNf == null || i >= this.aNf.size()) {
            return null;
        }
        return this.aNf.get(i);
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
            view2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.recommend_system_photo_item, viewGroup, false);
            c0104a = new C0104a();
            c0104a.aza = (LinearLayout) view2.findViewById(d.g.photo_container);
            c0104a.aNj = (TbImageView) view2.findViewById(d.g.photo);
        } else {
            c0104a = (C0104a) view2.getTag();
        }
        if (fn(i) == 1) {
            c0104a.aza.setPadding(0, this.padding, 0, 0);
        } else if (fn(i) == 2) {
            c0104a.aza.setPadding(0, 0, 0, this.padding);
        } else {
            c0104a.aza.setPadding(0, 0, 0, 0);
        }
        c0104a.aNj.setDrawerType(0);
        c0104a.aNj.setBorderSurroundContent(true);
        c0104a.aNj.setDrawBorder(true);
        if (itemViewType == 0) {
            c0104a.aNj.setBorderColor(this.alv);
            c0104a.aNj.setBorderWidth(this.aNh);
        } else {
            c0104a.aNj.setBorderColor(this.aNg);
            c0104a.aNj.setBorderWidth(this.aNi);
        }
        c0104a.aNj.setDefaultResource(d.f.transparent_bg);
        c0104a.aNj.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0104a.aNj.startLoad(this.aNf.get(i).getUrl(), 10, false);
        view2.setTag(c0104a);
        return view2;
    }

    public int fn(int i) {
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
        return i == this.aMY ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void s(ArrayList<b> arrayList) {
        this.aNf = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fo(int i) {
        this.aMY = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0104a {
        TbImageView aNj;
        LinearLayout aza;

        private C0104a() {
        }
    }
}
