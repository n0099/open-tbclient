package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> aVY;
    private int aWa;
    private int aWb;
    private TbPageContext<?> mContext;
    private int padding;
    private int aVR = -1;
    private int rowSize = 0;
    private int auo = am.getColor(d.C0142d.common_color_10043);
    private int aVZ = am.getColor(d.C0142d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.aVY = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.aVY = new ArrayList<>();
        this.aWa = l.e(tbPageContext.getPageActivity(), d.e.ds1);
        this.aWb = l.e(this.mContext.getPageActivity(), d.e.ds4);
        this.padding = l.e(this.mContext.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVY != null) {
            return this.aVY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVY == null || i >= this.aVY.size()) {
            return null;
        }
        return this.aVY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0121a c0121a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.recommend_system_photo_item, viewGroup, false);
            c0121a = new C0121a();
            c0121a.aIs = (LinearLayout) view.findViewById(d.g.photo_container);
            c0121a.aWc = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0121a = (C0121a) view.getTag();
        }
        if (fp(i) == 1) {
            c0121a.aIs.setPadding(0, this.padding, 0, 0);
        } else if (fp(i) == 2) {
            c0121a.aIs.setPadding(0, 0, 0, this.padding);
        } else {
            c0121a.aIs.setPadding(0, 0, 0, 0);
        }
        c0121a.aWc.setDrawerType(0);
        c0121a.aWc.setBorderSurroundContent(true);
        c0121a.aWc.setDrawBorder(true);
        if (itemViewType == 0) {
            c0121a.aWc.setBorderColor(this.auo);
            c0121a.aWc.setBorderWidth(this.aWa);
        } else {
            c0121a.aWc.setBorderColor(this.aVZ);
            c0121a.aWc.setBorderWidth(this.aWb);
        }
        c0121a.aWc.setDefaultResource(d.f.transparent_bg);
        c0121a.aWc.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0121a.aWc.startLoad(this.aVY.get(i).getUrl(), 10, false);
        view.setTag(c0121a);
        return view;
    }

    public int fp(int i) {
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
        return i == this.aVR ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void v(ArrayList<b> arrayList) {
        this.aVY = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fq(int i) {
        this.aVR = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0121a {
        LinearLayout aIs;
        TbImageView aWc;

        private C0121a() {
        }
    }
}
