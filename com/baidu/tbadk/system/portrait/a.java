package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private ArrayList<b> eXr;
    private int eXt;
    private int eXu;
    private TbPageContext<?> ehG;
    private int padding;
    private int eXk = -1;
    private int rowSize = 0;
    private int eru = ap.getColor(R.color.common_color_10043);
    private int eXs = ap.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.eXr = null;
        this.ehG = null;
        this.padding = 0;
        this.ehG = tbPageContext;
        this.eXr = new ArrayList<>();
        this.eXt = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.eXu = l.getDimens(this.ehG.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.ehG.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXr != null) {
            return this.eXr.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXr == null || i >= this.eXr.size()) {
            return null;
        }
        return this.eXr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0554a c0554a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0554a = new C0554a();
            c0554a.eJG = (LinearLayout) view.findViewById(R.id.photo_container);
            c0554a.eXv = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0554a = (C0554a) view.getTag();
        }
        if (qW(i) == 1) {
            c0554a.eJG.setPadding(0, this.padding, 0, 0);
        } else if (qW(i) == 2) {
            c0554a.eJG.setPadding(0, 0, 0, this.padding);
        } else {
            c0554a.eJG.setPadding(0, 0, 0, 0);
        }
        c0554a.eXv.setDrawerType(0);
        c0554a.eXv.setBorderSurroundContent(true);
        c0554a.eXv.setDrawBorder(true);
        if (itemViewType == 0) {
            c0554a.eXv.setBorderColor(this.eru);
            c0554a.eXv.setBorderWidth(this.eXt);
        } else {
            c0554a.eXv.setBorderColor(this.eXs);
            c0554a.eXv.setBorderWidth(this.eXu);
        }
        c0554a.eXv.setDefaultResource(R.drawable.transparent_bg);
        c0554a.eXv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0554a.eXv.startLoad(this.eXr.get(i).getUrl(), 10, false);
        view.setTag(c0554a);
        return view;
    }

    public int qW(int i) {
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
        return i == this.eXk ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.eXr = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void qX(int i) {
        this.eXk = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class C0554a {
        LinearLayout eJG;
        TbImageView eXv;

        private C0554a() {
        }
    }
}
