package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<b> bdP;
    private int bdR;
    private int bdS;
    private TbPageContext<?> mContext;
    private int padding;
    private int bdI = -1;
    private int rowSize = 0;
    private int aBQ = al.getColor(e.d.common_color_10043);
    private int bdQ = al.getColor(e.d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.bdP = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.bdP = new ArrayList<>();
        this.bdR = l.h(tbPageContext.getPageActivity(), e.C0175e.ds1);
        this.bdS = l.h(this.mContext.getPageActivity(), e.C0175e.ds4);
        this.padding = l.h(this.mContext.getPageActivity(), e.C0175e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bdP != null) {
            return this.bdP.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bdP == null || i >= this.bdP.size()) {
            return null;
        }
        return this.bdP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0142a c0142a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.recommend_system_photo_item, viewGroup, false);
            c0142a = new C0142a();
            c0142a.aQi = (LinearLayout) view.findViewById(e.g.photo_container);
            c0142a.bdT = (TbImageView) view.findViewById(e.g.photo);
        } else {
            c0142a = (C0142a) view.getTag();
        }
        if (fK(i) == 1) {
            c0142a.aQi.setPadding(0, this.padding, 0, 0);
        } else if (fK(i) == 2) {
            c0142a.aQi.setPadding(0, 0, 0, this.padding);
        } else {
            c0142a.aQi.setPadding(0, 0, 0, 0);
        }
        c0142a.bdT.setDrawerType(0);
        c0142a.bdT.setBorderSurroundContent(true);
        c0142a.bdT.setDrawBorder(true);
        if (itemViewType == 0) {
            c0142a.bdT.setBorderColor(this.aBQ);
            c0142a.bdT.setBorderWidth(this.bdR);
        } else {
            c0142a.bdT.setBorderColor(this.bdQ);
            c0142a.bdT.setBorderWidth(this.bdS);
        }
        c0142a.bdT.setDefaultResource(e.f.transparent_bg);
        c0142a.bdT.setDefaultErrorResource(e.f.icon_default_avatar100);
        c0142a.bdT.startLoad(this.bdP.get(i).getUrl(), 10, false);
        view.setTag(c0142a);
        return view;
    }

    public int fK(int i) {
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
        return i == this.bdI ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void v(ArrayList<b> arrayList) {
        this.bdP = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fL(int i) {
        this.bdI = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0142a {
        LinearLayout aQi;
        TbImageView bdT;

        private C0142a() {
        }
    }
}
