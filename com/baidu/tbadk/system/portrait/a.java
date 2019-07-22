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
    private ArrayList<b> cCq;
    private int cCs;
    private int cCt;
    private TbPageContext<?> mContext;
    private int padding;
    private int cCj = -1;
    private int rowSize = 0;
    private int bXL = am.getColor(R.color.common_color_10043);
    private int cCr = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.cCq = null;
        this.mContext = null;
        this.padding = 0;
        this.mContext = tbPageContext;
        this.cCq = new ArrayList<>();
        this.cCs = l.g(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.cCt = l.g(this.mContext.getPageActivity(), R.dimen.ds4);
        this.padding = l.g(this.mContext.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cCq != null) {
            return this.cCq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cCq == null || i >= this.cCq.size()) {
            return null;
        }
        return this.cCq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0256a c0256a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0256a = new C0256a();
            c0256a.cob = (LinearLayout) view.findViewById(R.id.photo_container);
            c0256a.cCu = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0256a = (C0256a) view.getTag();
        }
        if (kV(i) == 1) {
            c0256a.cob.setPadding(0, this.padding, 0, 0);
        } else if (kV(i) == 2) {
            c0256a.cob.setPadding(0, 0, 0, this.padding);
        } else {
            c0256a.cob.setPadding(0, 0, 0, 0);
        }
        c0256a.cCu.setDrawerType(0);
        c0256a.cCu.setBorderSurroundContent(true);
        c0256a.cCu.setDrawBorder(true);
        if (itemViewType == 0) {
            c0256a.cCu.setBorderColor(this.bXL);
            c0256a.cCu.setBorderWidth(this.cCs);
        } else {
            c0256a.cCu.setBorderColor(this.cCr);
            c0256a.cCu.setBorderWidth(this.cCt);
        }
        c0256a.cCu.setDefaultResource(R.drawable.transparent_bg);
        c0256a.cCu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0256a.cCu.startLoad(this.cCq.get(i).getUrl(), 10, false);
        view.setTag(c0256a);
        return view;
    }

    public int kV(int i) {
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
        return i == this.cCj ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void A(ArrayList<b> arrayList) {
        this.cCq = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kW(int i) {
        this.cCj = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0256a {
        TbImageView cCu;
        LinearLayout cob;

        private C0256a() {
        }
    }
}
