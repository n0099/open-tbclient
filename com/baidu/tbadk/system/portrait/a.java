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
    private ArrayList<b> cNL;
    private int cNN;
    private int cNO;
    private TbPageContext<?> ceu;
    private int padding;
    private int cNE = -1;
    private int rowSize = 0;
    private int cmQ = am.getColor(R.color.common_color_10043);
    private int cNM = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.cNL = null;
        this.ceu = null;
        this.padding = 0;
        this.ceu = tbPageContext;
        this.cNL = new ArrayList<>();
        this.cNN = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.cNO = l.getDimens(this.ceu.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.ceu.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cNL != null) {
            return this.cNL.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cNL == null || i >= this.cNL.size()) {
            return null;
        }
        return this.cNL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0302a c0302a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0302a = new C0302a();
            c0302a.cBh = (LinearLayout) view.findViewById(R.id.photo_container);
            c0302a.cNP = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0302a = (C0302a) view.getTag();
        }
        if (kj(i) == 1) {
            c0302a.cBh.setPadding(0, this.padding, 0, 0);
        } else if (kj(i) == 2) {
            c0302a.cBh.setPadding(0, 0, 0, this.padding);
        } else {
            c0302a.cBh.setPadding(0, 0, 0, 0);
        }
        c0302a.cNP.setDrawerType(0);
        c0302a.cNP.setBorderSurroundContent(true);
        c0302a.cNP.setDrawBorder(true);
        if (itemViewType == 0) {
            c0302a.cNP.setBorderColor(this.cmQ);
            c0302a.cNP.setBorderWidth(this.cNN);
        } else {
            c0302a.cNP.setBorderColor(this.cNM);
            c0302a.cNP.setBorderWidth(this.cNO);
        }
        c0302a.cNP.setDefaultResource(R.drawable.transparent_bg);
        c0302a.cNP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0302a.cNP.startLoad(this.cNL.get(i).getUrl(), 10, false);
        view.setTag(c0302a);
        return view;
    }

    public int kj(int i) {
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
        return i == this.cNE ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void C(ArrayList<b> arrayList) {
        this.cNL = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kk(int i) {
        this.cNE = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0302a {
        LinearLayout cBh;
        TbImageView cNP;

        private C0302a() {
        }
    }
}
