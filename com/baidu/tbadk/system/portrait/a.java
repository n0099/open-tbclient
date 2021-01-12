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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private ArrayList<b> fJV;
    private int fJX;
    private int fJY;
    private int padding;
    private int fJP = -1;
    private int rowSize = 0;
    private int fdb = ao.getColor(R.color.common_color_10043);
    private int fJW = ao.getColor(R.color.CAM_X0302);

    public a(TbPageContext<?> tbPageContext) {
        this.fJV = null;
        this.eSJ = null;
        this.padding = 0;
        this.eSJ = tbPageContext;
        this.fJV = new ArrayList<>();
        this.fJX = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fJY = l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fJV != null) {
            return this.fJV.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fJV == null || i >= this.fJV.size()) {
            return null;
        }
        return this.fJV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0583a c0583a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0583a = new C0583a();
            c0583a.fvH = (LinearLayout) view.findViewById(R.id.photo_container);
            c0583a.fJZ = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0583a = (C0583a) view.getTag();
        }
        if (rt(i) == 1) {
            c0583a.fvH.setPadding(0, this.padding, 0, 0);
        } else if (rt(i) == 2) {
            c0583a.fvH.setPadding(0, 0, 0, this.padding);
        } else {
            c0583a.fvH.setPadding(0, 0, 0, 0);
        }
        c0583a.fJZ.setDrawerType(0);
        c0583a.fJZ.setBorderSurroundContent(true);
        c0583a.fJZ.setDrawBorder(true);
        if (itemViewType == 0) {
            c0583a.fJZ.setBorderColor(this.fdb);
            c0583a.fJZ.setBorderWidth(this.fJX);
        } else {
            c0583a.fJZ.setBorderColor(this.fJW);
            c0583a.fJZ.setBorderWidth(this.fJY);
        }
        c0583a.fJZ.setDefaultResource(R.drawable.transparent_bg);
        c0583a.fJZ.startLoad(this.fJV.get(i).getUrl(), 10, false);
        view.setTag(c0583a);
        return view;
    }

    public int rt(int i) {
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
        return i == this.fJP ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void J(ArrayList<b> arrayList) {
        this.fJV = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void ru(int i) {
        this.fJP = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0583a {
        TbImageView fJZ;
        LinearLayout fvH;

        private C0583a() {
        }
    }
}
