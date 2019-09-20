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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<b> cDt;
    private int cDv;
    private int cDw;
    private TbPageContext<?> mContext;
    private int padding;
    private int cDm = -1;
    private int rowSize = 0;
    private int bYK = am.getColor(R.color.common_color_10043);
    private int cDu = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.cDt = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.cDt = new ArrayList<>();
        this.cDv = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.cDw = l.g(this.mContext.getPageActivity(), R.dimen.ds4);
        this.padding = l.g(this.mContext.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cDt != null) {
            return this.cDt.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cDt == null || i >= this.cDt.size()) {
            return null;
        }
        return this.cDt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0270a c0270a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0270a = new C0270a();
            c0270a.cpd = (LinearLayout) view.findViewById(R.id.photo_container);
            c0270a.cDx = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0270a = (C0270a) view.getTag();
        }
        if (kZ(i) == 1) {
            c0270a.cpd.setPadding(0, this.padding, 0, 0);
        } else if (kZ(i) == 2) {
            c0270a.cpd.setPadding(0, 0, 0, this.padding);
        } else {
            c0270a.cpd.setPadding(0, 0, 0, 0);
        }
        c0270a.cDx.setDrawerType(0);
        c0270a.cDx.setBorderSurroundContent(true);
        c0270a.cDx.setDrawBorder(true);
        if (itemViewType == 0) {
            c0270a.cDx.setBorderColor(this.bYK);
            c0270a.cDx.setBorderWidth(this.cDv);
        } else {
            c0270a.cDx.setBorderColor(this.cDu);
            c0270a.cDx.setBorderWidth(this.cDw);
        }
        c0270a.cDx.setDefaultResource(R.drawable.transparent_bg);
        c0270a.cDx.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0270a.cDx.startLoad(this.cDt.get(i).getUrl(), 10, false);
        view.setTag(c0270a);
        return view;
    }

    public int kZ(int i) {
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
        return i == this.cDm ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void A(ArrayList<b> arrayList) {
        this.cDt = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void la(int i) {
        this.cDm = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0270a {
        TbImageView cDx;
        LinearLayout cpd;

        private C0270a() {
        }
    }
}
