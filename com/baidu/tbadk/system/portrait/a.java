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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eUY;
    private ArrayList<b> fMg;
    private int fMi;
    private int fMj;
    private int padding;
    private int fMa = -1;
    private int rowSize = 0;
    private int ffq = ap.getColor(R.color.common_color_10043);
    private int fMh = ap.getColor(R.color.CAM_X0302);

    public a(TbPageContext<?> tbPageContext) {
        this.fMg = null;
        this.eUY = null;
        this.padding = 0;
        this.eUY = tbPageContext;
        this.fMg = new ArrayList<>();
        this.fMi = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fMj = l.getDimens(this.eUY.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eUY.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fMg != null) {
            return this.fMg.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fMg == null || i >= this.fMg.size()) {
            return null;
        }
        return this.fMg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0580a c0580a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0580a = new C0580a();
            c0580a.fxX = (LinearLayout) view.findViewById(R.id.photo_container);
            c0580a.fMk = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0580a = (C0580a) view.getTag();
        }
        if (ry(i) == 1) {
            c0580a.fxX.setPadding(0, this.padding, 0, 0);
        } else if (ry(i) == 2) {
            c0580a.fxX.setPadding(0, 0, 0, this.padding);
        } else {
            c0580a.fxX.setPadding(0, 0, 0, 0);
        }
        c0580a.fMk.setDrawerType(0);
        c0580a.fMk.setBorderSurroundContent(true);
        c0580a.fMk.setDrawBorder(true);
        if (itemViewType == 0) {
            c0580a.fMk.setBorderColor(this.ffq);
            c0580a.fMk.setBorderWidth(this.fMi);
        } else {
            c0580a.fMk.setBorderColor(this.fMh);
            c0580a.fMk.setBorderWidth(this.fMj);
        }
        c0580a.fMk.setDefaultResource(R.drawable.transparent_bg);
        c0580a.fMk.startLoad(this.fMg.get(i).getUrl(), 10, false);
        view.setTag(c0580a);
        return view;
    }

    public int ry(int i) {
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
        return i == this.fMa ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void J(ArrayList<b> arrayList) {
        this.fMg = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void rz(int i) {
        this.fMa = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0580a {
        TbImageView fMk;
        LinearLayout fxX;

        private C0580a() {
        }
    }
}
