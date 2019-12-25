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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> cQU;
    private ArrayList<b> dBJ;
    private int dBL;
    private int dBM;
    private int padding;
    private int dBC = -1;
    private int rowSize = 0;
    private int dab = am.getColor(R.color.common_color_10043);
    private int dBK = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.dBJ = null;
        this.cQU = null;
        this.padding = 0;
        this.cQU = tbPageContext;
        this.dBJ = new ArrayList<>();
        this.dBL = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.dBM = l.getDimens(this.cQU.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.cQU.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dBJ != null) {
            return this.dBJ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dBJ == null || i >= this.dBJ.size()) {
            return null;
        }
        return this.dBJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0383a c0383a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0383a = new C0383a();
            c0383a.doQ = (LinearLayout) view.findViewById(R.id.photo_container);
            c0383a.dBN = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0383a = (C0383a) view.getTag();
        }
        if (my(i) == 1) {
            c0383a.doQ.setPadding(0, this.padding, 0, 0);
        } else if (my(i) == 2) {
            c0383a.doQ.setPadding(0, 0, 0, this.padding);
        } else {
            c0383a.doQ.setPadding(0, 0, 0, 0);
        }
        c0383a.dBN.setDrawerType(0);
        c0383a.dBN.setBorderSurroundContent(true);
        c0383a.dBN.setDrawBorder(true);
        if (itemViewType == 0) {
            c0383a.dBN.setBorderColor(this.dab);
            c0383a.dBN.setBorderWidth(this.dBL);
        } else {
            c0383a.dBN.setBorderColor(this.dBK);
            c0383a.dBN.setBorderWidth(this.dBM);
        }
        c0383a.dBN.setDefaultResource(R.drawable.transparent_bg);
        c0383a.dBN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0383a.dBN.startLoad(this.dBJ.get(i).getUrl(), 10, false);
        view.setTag(c0383a);
        return view;
    }

    public int my(int i) {
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
        return i == this.dBC ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void F(ArrayList<b> arrayList) {
        this.dBJ = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void mz(int i) {
        this.dBC = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0383a {
        TbImageView dBN;
        LinearLayout doQ;

        private C0383a() {
        }
    }
}
