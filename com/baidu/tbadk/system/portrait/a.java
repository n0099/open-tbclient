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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> etO;
    private ArrayList<b> fjD;
    private int fjF;
    private int fjG;
    private int padding;
    private int fjw = -1;
    private int rowSize = 0;
    private int eDF = ap.getColor(R.color.common_color_10043);
    private int fjE = ap.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.fjD = null;
        this.etO = null;
        this.padding = 0;
        this.etO = tbPageContext;
        this.fjD = new ArrayList<>();
        this.fjF = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fjG = l.getDimens(this.etO.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.etO.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fjD != null) {
            return this.fjD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fjD == null || i >= this.fjD.size()) {
            return null;
        }
        return this.fjD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0571a c0571a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0571a = new C0571a();
            c0571a.eVN = (LinearLayout) view.findViewById(R.id.photo_container);
            c0571a.fjH = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0571a = (C0571a) view.getTag();
        }
        if (ru(i) == 1) {
            c0571a.eVN.setPadding(0, this.padding, 0, 0);
        } else if (ru(i) == 2) {
            c0571a.eVN.setPadding(0, 0, 0, this.padding);
        } else {
            c0571a.eVN.setPadding(0, 0, 0, 0);
        }
        c0571a.fjH.setDrawerType(0);
        c0571a.fjH.setBorderSurroundContent(true);
        c0571a.fjH.setDrawBorder(true);
        if (itemViewType == 0) {
            c0571a.fjH.setBorderColor(this.eDF);
            c0571a.fjH.setBorderWidth(this.fjF);
        } else {
            c0571a.fjH.setBorderColor(this.fjE);
            c0571a.fjH.setBorderWidth(this.fjG);
        }
        c0571a.fjH.setDefaultResource(R.drawable.transparent_bg);
        c0571a.fjH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0571a.fjH.startLoad(this.fjD.get(i).getUrl(), 10, false);
        view.setTag(c0571a);
        return view;
    }

    public int ru(int i) {
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
        return i == this.fjw ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.fjD = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void rv(int i) {
        this.fjw = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0571a {
        LinearLayout eVN;
        TbImageView fjH;

        private C0571a() {
        }
    }
}
