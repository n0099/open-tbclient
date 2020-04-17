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
    private TbPageContext<?> duG;
    private ArrayList<b> egf;
    private int egh;
    private int egi;
    private int padding;
    private int efY = -1;
    private int rowSize = 0;
    private int dCa = am.getColor(R.color.common_color_10043);
    private int egg = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.egf = null;
        this.duG = null;
        this.padding = 0;
        this.duG = tbPageContext;
        this.egf = new ArrayList<>();
        this.egh = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.egi = l.getDimens(this.duG.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.duG.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egf != null) {
            return this.egf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egf == null || i >= this.egf.size()) {
            return null;
        }
        return this.egf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0426a c0426a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0426a = new C0426a();
            c0426a.dTF = (LinearLayout) view.findViewById(R.id.photo_container);
            c0426a.egj = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0426a = (C0426a) view.getTag();
        }
        if (nc(i) == 1) {
            c0426a.dTF.setPadding(0, this.padding, 0, 0);
        } else if (nc(i) == 2) {
            c0426a.dTF.setPadding(0, 0, 0, this.padding);
        } else {
            c0426a.dTF.setPadding(0, 0, 0, 0);
        }
        c0426a.egj.setDrawerType(0);
        c0426a.egj.setBorderSurroundContent(true);
        c0426a.egj.setDrawBorder(true);
        if (itemViewType == 0) {
            c0426a.egj.setBorderColor(this.dCa);
            c0426a.egj.setBorderWidth(this.egh);
        } else {
            c0426a.egj.setBorderColor(this.egg);
            c0426a.egj.setBorderWidth(this.egi);
        }
        c0426a.egj.setDefaultResource(R.drawable.transparent_bg);
        c0426a.egj.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0426a.egj.startLoad(this.egf.get(i).getUrl(), 10, false);
        view.setTag(c0426a);
        return view;
    }

    public int nc(int i) {
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
        return i == this.efY ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.egf = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void nd(int i) {
        this.efY = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0426a {
        LinearLayout dTF;
        TbImageView egj;

        private C0426a() {
        }
    }
}
