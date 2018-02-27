package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> aRG;
    private ArrayList<b> bCB;
    private int bCD;
    private int bCE;
    private int padding;
    private int bCu = -1;
    private int rowSize = 0;
    private int aZP = aj.getColor(d.C0141d.common_color_10043);
    private int bCC = aj.getColor(d.C0141d.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.bCB = null;
        this.aRG = null;
        this.padding = 0;
        this.aRG = tbPageContext;
        this.bCB = new ArrayList<>();
        this.bCD = l.t(tbPageContext.getPageActivity(), d.e.ds1);
        this.bCE = l.t(this.aRG.getPageActivity(), d.e.ds4);
        this.padding = l.t(this.aRG.getPageActivity(), d.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bCB != null) {
            return this.bCB.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bCB == null || i >= this.bCB.size()) {
            return null;
        }
        return this.bCB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0115a c0115a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.recommend_system_photo_item, viewGroup, false);
            c0115a = new C0115a();
            c0115a.box = (LinearLayout) view.findViewById(d.g.photo_container);
            c0115a.bCF = (TbImageView) view.findViewById(d.g.photo);
        } else {
            c0115a = (C0115a) view.getTag();
        }
        if (im(i) == 1) {
            c0115a.box.setPadding(0, this.padding, 0, 0);
        } else if (im(i) == 2) {
            c0115a.box.setPadding(0, 0, 0, this.padding);
        } else {
            c0115a.box.setPadding(0, 0, 0, 0);
        }
        c0115a.bCF.setDrawerType(0);
        c0115a.bCF.setBorderSurroundContent(true);
        c0115a.bCF.setDrawBorder(true);
        if (itemViewType == 0) {
            c0115a.bCF.setBorderColor(this.aZP);
            c0115a.bCF.setBorderWidth(this.bCD);
        } else {
            c0115a.bCF.setBorderColor(this.bCC);
            c0115a.bCF.setBorderWidth(this.bCE);
        }
        c0115a.bCF.setDefaultResource(d.f.transparent_bg);
        c0115a.bCF.setDefaultErrorResource(d.f.icon_default_avatar100);
        c0115a.bCF.startLoad(this.bCB.get(i).getUrl(), 10, false);
        view.setTag(c0115a);
        return view;
    }

    public int im(int i) {
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
        return i == this.bCu ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void t(ArrayList<b> arrayList) {
        this.bCB = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void in(int i) {
        this.bCu = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0115a {
        TbImageView bCF;
        LinearLayout box;

        private C0115a() {
        }
    }
}
