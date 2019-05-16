package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<b> cAY;
    private int cBa;
    private int cBb;
    private TbPageContext<?> mContext;
    private int padding;
    private int cAR = -1;
    private int rowSize = 0;
    private int bWI = al.getColor(R.color.common_color_10043);
    private int cAZ = al.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.cAY = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.cAY = new ArrayList<>();
        this.cBa = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.cBb = l.g(this.mContext.getPageActivity(), R.dimen.ds4);
        this.padding = l.g(this.mContext.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cAY != null) {
            return this.cAY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cAY == null || i >= this.cAY.size()) {
            return null;
        }
        return this.cAY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0259a c0259a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0259a = new C0259a();
            c0259a.cmN = (LinearLayout) view.findViewById(R.id.photo_container);
            c0259a.cBc = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0259a = (C0259a) view.getTag();
        }
        if (kP(i) == 1) {
            c0259a.cmN.setPadding(0, this.padding, 0, 0);
        } else if (kP(i) == 2) {
            c0259a.cmN.setPadding(0, 0, 0, this.padding);
        } else {
            c0259a.cmN.setPadding(0, 0, 0, 0);
        }
        c0259a.cBc.setDrawerType(0);
        c0259a.cBc.setBorderSurroundContent(true);
        c0259a.cBc.setDrawBorder(true);
        if (itemViewType == 0) {
            c0259a.cBc.setBorderColor(this.bWI);
            c0259a.cBc.setBorderWidth(this.cBa);
        } else {
            c0259a.cBc.setBorderColor(this.cAZ);
            c0259a.cBc.setBorderWidth(this.cBb);
        }
        c0259a.cBc.setDefaultResource(R.drawable.transparent_bg);
        c0259a.cBc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0259a.cBc.startLoad(this.cAY.get(i).getUrl(), 10, false);
        view.setTag(c0259a);
        return view;
    }

    public int kP(int i) {
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
        return i == this.cAR ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void A(ArrayList<b> arrayList) {
        this.cAY = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kQ(int i) {
        this.cAR = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0259a {
        TbImageView cBc;
        LinearLayout cmN;

        private C0259a() {
        }
    }
}
