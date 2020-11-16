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
    private TbPageContext<?> eGu;
    private ArrayList<b> fxj;
    private int fxl;
    private int fxm;
    private int padding;
    private int fxc = -1;
    private int rowSize = 0;
    private int eQS = ap.getColor(R.color.common_color_10043);
    private int fxk = ap.getColor(R.color.CAM_X0302);

    public a(TbPageContext<?> tbPageContext) {
        this.fxj = null;
        this.eGu = null;
        this.padding = 0;
        this.eGu = tbPageContext;
        this.fxj = new ArrayList<>();
        this.fxl = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fxm = l.getDimens(this.eGu.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eGu.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxj != null) {
            return this.fxj.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fxj == null || i >= this.fxj.size()) {
            return null;
        }
        return this.fxj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0596a c0596a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0596a = new C0596a();
            c0596a.fjk = (LinearLayout) view.findViewById(R.id.photo_container);
            c0596a.fxn = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0596a = (C0596a) view.getTag();
        }
        if (sn(i) == 1) {
            c0596a.fjk.setPadding(0, this.padding, 0, 0);
        } else if (sn(i) == 2) {
            c0596a.fjk.setPadding(0, 0, 0, this.padding);
        } else {
            c0596a.fjk.setPadding(0, 0, 0, 0);
        }
        c0596a.fxn.setDrawerType(0);
        c0596a.fxn.setBorderSurroundContent(true);
        c0596a.fxn.setDrawBorder(true);
        if (itemViewType == 0) {
            c0596a.fxn.setBorderColor(this.eQS);
            c0596a.fxn.setBorderWidth(this.fxl);
        } else {
            c0596a.fxn.setBorderColor(this.fxk);
            c0596a.fxn.setBorderWidth(this.fxm);
        }
        c0596a.fxn.setDefaultResource(R.drawable.transparent_bg);
        c0596a.fxn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0596a.fxn.startLoad(this.fxj.get(i).getUrl(), 10, false);
        view.setTag(c0596a);
        return view;
    }

    public int sn(int i) {
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
        return i == this.fxc ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.fxj = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void so(int i) {
        this.fxc = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class C0596a {
        LinearLayout fjk;
        TbImageView fxn;

        private C0596a() {
        }
    }
}
