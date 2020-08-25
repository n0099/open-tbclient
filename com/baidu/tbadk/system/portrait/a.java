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
/* loaded from: classes15.dex */
public class a extends BaseAdapter {
    private int eUA;
    private ArrayList<b> eUx;
    private int eUz;
    private TbPageContext<?> efn;
    private int padding;
    private int eUq = -1;
    private int rowSize = 0;
    private int epl = ap.getColor(R.color.common_color_10043);
    private int eUy = ap.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.eUx = null;
        this.efn = null;
        this.padding = 0;
        this.efn = tbPageContext;
        this.eUx = new ArrayList<>();
        this.eUz = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.eUA = l.getDimens(this.efn.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.efn.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eUx != null) {
            return this.eUx.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eUx == null || i >= this.eUx.size()) {
            return null;
        }
        return this.eUx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0558a c0558a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0558a = new C0558a();
            c0558a.eHv = (LinearLayout) view.findViewById(R.id.photo_container);
            c0558a.eUB = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0558a = (C0558a) view.getTag();
        }
        if (qF(i) == 1) {
            c0558a.eHv.setPadding(0, this.padding, 0, 0);
        } else if (qF(i) == 2) {
            c0558a.eHv.setPadding(0, 0, 0, this.padding);
        } else {
            c0558a.eHv.setPadding(0, 0, 0, 0);
        }
        c0558a.eUB.setDrawerType(0);
        c0558a.eUB.setBorderSurroundContent(true);
        c0558a.eUB.setDrawBorder(true);
        if (itemViewType == 0) {
            c0558a.eUB.setBorderColor(this.epl);
            c0558a.eUB.setBorderWidth(this.eUz);
        } else {
            c0558a.eUB.setBorderColor(this.eUy);
            c0558a.eUB.setBorderWidth(this.eUA);
        }
        c0558a.eUB.setDefaultResource(R.drawable.transparent_bg);
        c0558a.eUB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0558a.eUB.startLoad(this.eUx.get(i).getUrl(), 10, false);
        view.setTag(c0558a);
        return view;
    }

    public int qF(int i) {
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
        return i == this.eUq ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.eUx = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void qG(int i) {
        this.eUq = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0558a {
        LinearLayout eHv;
        TbImageView eUB;

        private C0558a() {
        }
    }
}
