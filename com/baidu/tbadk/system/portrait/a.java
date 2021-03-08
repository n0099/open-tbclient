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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eWx;
    private ArrayList<b> fNG;
    private int fNI;
    private int fNJ;
    private int padding;
    private int fNA = -1;
    private int rowSize = 0;
    private int fgP = ap.getColor(R.color.common_color_10043);
    private int fNH = ap.getColor(R.color.CAM_X0302);

    public a(TbPageContext<?> tbPageContext) {
        this.fNG = null;
        this.eWx = null;
        this.padding = 0;
        this.eWx = tbPageContext;
        this.fNG = new ArrayList<>();
        this.fNI = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fNJ = l.getDimens(this.eWx.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eWx.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fNG != null) {
            return this.fNG.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fNG == null || i >= this.fNG.size()) {
            return null;
        }
        return this.fNG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0586a c0586a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0586a = new C0586a();
            c0586a.fzw = (LinearLayout) view.findViewById(R.id.photo_container);
            c0586a.fNK = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0586a = (C0586a) view.getTag();
        }
        if (rA(i) == 1) {
            c0586a.fzw.setPadding(0, this.padding, 0, 0);
        } else if (rA(i) == 2) {
            c0586a.fzw.setPadding(0, 0, 0, this.padding);
        } else {
            c0586a.fzw.setPadding(0, 0, 0, 0);
        }
        c0586a.fNK.setDrawerType(0);
        c0586a.fNK.setBorderSurroundContent(true);
        c0586a.fNK.setDrawBorder(true);
        if (itemViewType == 0) {
            c0586a.fNK.setBorderColor(this.fgP);
            c0586a.fNK.setBorderWidth(this.fNI);
        } else {
            c0586a.fNK.setBorderColor(this.fNH);
            c0586a.fNK.setBorderWidth(this.fNJ);
        }
        c0586a.fNK.setDefaultResource(R.drawable.transparent_bg);
        c0586a.fNK.startLoad(this.fNG.get(i).getUrl(), 10, false);
        view.setTag(c0586a);
        return view;
    }

    public int rA(int i) {
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
        return i == this.fNA ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void J(ArrayList<b> arrayList) {
        this.fNG = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void rB(int i) {
        this.fNA = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0586a {
        TbImageView fNK;
        LinearLayout fzw;

        private C0586a() {
        }
    }
}
