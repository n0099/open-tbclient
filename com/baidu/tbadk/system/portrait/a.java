package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> dVN;
    private ArrayList<b> eJR;
    private int eJT;
    private int eJU;
    private int padding;
    private int eJK = -1;
    private int rowSize = 0;
    private int edx = ao.getColor(R.color.common_color_10043);
    private int eJS = ao.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.eJR = null;
        this.dVN = null;
        this.padding = 0;
        this.dVN = tbPageContext;
        this.eJR = new ArrayList<>();
        this.eJT = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.eJU = l.getDimens(this.dVN.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.dVN.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eJR != null) {
            return this.eJR.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eJR == null || i >= this.eJR.size()) {
            return null;
        }
        return this.eJR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0512a c0512a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0512a = new C0512a();
            c0512a.ewV = (LinearLayout) view.findViewById(R.id.photo_container);
            c0512a.eJV = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0512a = (C0512a) view.getTag();
        }
        if (ou(i) == 1) {
            c0512a.ewV.setPadding(0, this.padding, 0, 0);
        } else if (ou(i) == 2) {
            c0512a.ewV.setPadding(0, 0, 0, this.padding);
        } else {
            c0512a.ewV.setPadding(0, 0, 0, 0);
        }
        c0512a.eJV.setDrawerType(0);
        c0512a.eJV.setBorderSurroundContent(true);
        c0512a.eJV.setDrawBorder(true);
        if (itemViewType == 0) {
            c0512a.eJV.setBorderColor(this.edx);
            c0512a.eJV.setBorderWidth(this.eJT);
        } else {
            c0512a.eJV.setBorderColor(this.eJS);
            c0512a.eJV.setBorderWidth(this.eJU);
        }
        c0512a.eJV.setDefaultResource(R.drawable.transparent_bg);
        c0512a.eJV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0512a.eJV.startLoad(this.eJR.get(i).getUrl(), 10, false);
        view.setTag(c0512a);
        return view;
    }

    public int ou(int i) {
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
        return i == this.eJK ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void I(ArrayList<b> arrayList) {
        this.eJR = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void ov(int i) {
        this.eJK = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0512a {
        TbImageView eJV;
        LinearLayout ewV;

        private C0512a() {
        }
    }
}
