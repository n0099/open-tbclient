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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> cVi;
    private ArrayList<b> dGi;
    private int dGk;
    private int dGl;
    private int padding;
    private int dGb = -1;
    private int rowSize = 0;
    private int deF = am.getColor(R.color.common_color_10043);
    private int dGj = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.dGi = null;
        this.cVi = null;
        this.padding = 0;
        this.cVi = tbPageContext;
        this.dGi = new ArrayList<>();
        this.dGk = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.dGl = l.getDimens(this.cVi.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.cVi.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dGi != null) {
            return this.dGi.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dGi == null || i >= this.dGi.size()) {
            return null;
        }
        return this.dGi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0395a c0395a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0395a = new C0395a();
            c0395a.dtx = (LinearLayout) view.findViewById(R.id.photo_container);
            c0395a.dGm = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0395a = (C0395a) view.getTag();
        }
        if (mP(i) == 1) {
            c0395a.dtx.setPadding(0, this.padding, 0, 0);
        } else if (mP(i) == 2) {
            c0395a.dtx.setPadding(0, 0, 0, this.padding);
        } else {
            c0395a.dtx.setPadding(0, 0, 0, 0);
        }
        c0395a.dGm.setDrawerType(0);
        c0395a.dGm.setBorderSurroundContent(true);
        c0395a.dGm.setDrawBorder(true);
        if (itemViewType == 0) {
            c0395a.dGm.setBorderColor(this.deF);
            c0395a.dGm.setBorderWidth(this.dGk);
        } else {
            c0395a.dGm.setBorderColor(this.dGj);
            c0395a.dGm.setBorderWidth(this.dGl);
        }
        c0395a.dGm.setDefaultResource(R.drawable.transparent_bg);
        c0395a.dGm.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0395a.dGm.startLoad(this.dGi.get(i).getUrl(), 10, false);
        view.setTag(c0395a);
        return view;
    }

    public int mP(int i) {
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
        return i == this.dGb ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.dGi = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void mQ(int i) {
        this.dGb = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0395a {
        TbImageView dGm;
        LinearLayout dtx;

        private C0395a() {
        }
    }
}
