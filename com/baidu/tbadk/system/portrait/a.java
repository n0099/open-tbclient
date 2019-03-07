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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<b> csP;
    private int csR;
    private int csS;
    private TbPageContext<?> mContext;
    private int padding;
    private int csI = -1;
    private int rowSize = 0;
    private int bOQ = al.getColor(d.C0236d.common_color_10043);
    private int csQ = al.getColor(d.C0236d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.csP = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.csP = new ArrayList<>();
        this.csR = l.h(tbPageContext.getPageActivity(), d.e.ds1);
        this.csS = l.h(this.mContext.getPageActivity(), d.e.ds4);
        this.padding = l.h(this.mContext.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.csP != null) {
            return this.csP.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.csP == null || i >= this.csP.size()) {
            return null;
        }
        return this.csP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0210a c0210a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0210a = new C0210a();
            c0210a.ceE = (LinearLayout) view.findViewById(d.g.photo_container);
            c0210a.csT = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0210a = (C0210a) view.getTag();
        }
        if (kb(i) == 1) {
            c0210a.ceE.setPadding(0, this.padding, 0, 0);
        } else if (kb(i) == 2) {
            c0210a.ceE.setPadding(0, 0, 0, this.padding);
        } else {
            c0210a.ceE.setPadding(0, 0, 0, 0);
        }
        c0210a.csT.setDrawerType(0);
        c0210a.csT.setBorderSurroundContent(true);
        c0210a.csT.setDrawBorder(true);
        if (itemViewType == 0) {
            c0210a.csT.setBorderColor(this.bOQ);
            c0210a.csT.setBorderWidth(this.csR);
        } else {
            c0210a.csT.setBorderColor(this.csQ);
            c0210a.csT.setBorderWidth(this.csS);
        }
        c0210a.csT.setDefaultResource(d.f.transparent_bg);
        c0210a.csT.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0210a.csT.startLoad(this.csP.get(i).getUrl(), 10, false);
        view.setTag(c0210a);
        return view;
    }

    public int kb(int i) {
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
        return i == this.csI ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void x(ArrayList<b> arrayList) {
        this.csP = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kc(int i) {
        this.csI = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0210a {
        LinearLayout ceE;
        TbImageView csT;

        private C0210a() {
        }
    }
}
