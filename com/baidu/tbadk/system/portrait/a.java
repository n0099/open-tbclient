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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> cRe;
    private ArrayList<b> dBT;
    private int dBV;
    private int dBW;
    private int padding;
    private int dBM = -1;
    private int rowSize = 0;
    private int dal = am.getColor(R.color.common_color_10043);
    private int dBU = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.dBT = null;
        this.cRe = null;
        this.padding = 0;
        this.cRe = tbPageContext;
        this.dBT = new ArrayList<>();
        this.dBV = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.dBW = l.getDimens(this.cRe.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.cRe.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dBT != null) {
            return this.dBT.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dBT == null || i >= this.dBT.size()) {
            return null;
        }
        return this.dBT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0385a c0385a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0385a = new C0385a();
            c0385a.dpb = (LinearLayout) view.findViewById(R.id.photo_container);
            c0385a.dBX = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0385a = (C0385a) view.getTag();
        }
        if (my(i) == 1) {
            c0385a.dpb.setPadding(0, this.padding, 0, 0);
        } else if (my(i) == 2) {
            c0385a.dpb.setPadding(0, 0, 0, this.padding);
        } else {
            c0385a.dpb.setPadding(0, 0, 0, 0);
        }
        c0385a.dBX.setDrawerType(0);
        c0385a.dBX.setBorderSurroundContent(true);
        c0385a.dBX.setDrawBorder(true);
        if (itemViewType == 0) {
            c0385a.dBX.setBorderColor(this.dal);
            c0385a.dBX.setBorderWidth(this.dBV);
        } else {
            c0385a.dBX.setBorderColor(this.dBU);
            c0385a.dBX.setBorderWidth(this.dBW);
        }
        c0385a.dBX.setDefaultResource(R.drawable.transparent_bg);
        c0385a.dBX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0385a.dBX.startLoad(this.dBT.get(i).getUrl(), 10, false);
        view.setTag(c0385a);
        return view;
    }

    public int my(int i) {
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
        return i == this.dBM ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void F(ArrayList<b> arrayList) {
        this.dBT = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void mz(int i) {
        this.dBM = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0385a {
        TbImageView dBX;
        LinearLayout dpb;

        private C0385a() {
        }
    }
}
