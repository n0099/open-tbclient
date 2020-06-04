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
    private TbPageContext<?> dIF;
    private int euA;
    private int euB;
    private ArrayList<b> euy;
    private int padding;
    private int eur = -1;
    private int rowSize = 0;
    private int dQl = am.getColor(R.color.common_color_10043);
    private int euz = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.euy = null;
        this.dIF = null;
        this.padding = 0;
        this.dIF = tbPageContext;
        this.euy = new ArrayList<>();
        this.euA = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.euB = l.getDimens(this.dIF.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.dIF.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy != null) {
            return this.euy.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return null;
        }
        return this.euy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0494a c0494a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0494a = new C0494a();
            c0494a.ehT = (LinearLayout) view.findViewById(R.id.photo_container);
            c0494a.euC = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0494a = (C0494a) view.getTag();
        }
        if (nG(i) == 1) {
            c0494a.ehT.setPadding(0, this.padding, 0, 0);
        } else if (nG(i) == 2) {
            c0494a.ehT.setPadding(0, 0, 0, this.padding);
        } else {
            c0494a.ehT.setPadding(0, 0, 0, 0);
        }
        c0494a.euC.setDrawerType(0);
        c0494a.euC.setBorderSurroundContent(true);
        c0494a.euC.setDrawBorder(true);
        if (itemViewType == 0) {
            c0494a.euC.setBorderColor(this.dQl);
            c0494a.euC.setBorderWidth(this.euA);
        } else {
            c0494a.euC.setBorderColor(this.euz);
            c0494a.euC.setBorderWidth(this.euB);
        }
        c0494a.euC.setDefaultResource(R.drawable.transparent_bg);
        c0494a.euC.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0494a.euC.startLoad(this.euy.get(i).getUrl(), 10, false);
        view.setTag(c0494a);
        return view;
    }

    public int nG(int i) {
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
        return i == this.eur ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.euy = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void nH(int i) {
        this.eur = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0494a {
        LinearLayout ehT;
        TbImageView euC;

        private C0494a() {
        }
    }
}
