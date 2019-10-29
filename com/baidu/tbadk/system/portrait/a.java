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
    private ArrayList<b> cOC;
    private int cOE;
    private int cOF;
    private TbPageContext<?> cfl;
    private int padding;
    private int cOv = -1;
    private int rowSize = 0;
    private int cnI = am.getColor(R.color.common_color_10043);
    private int cOD = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.cOC = null;
        this.cfl = null;
        this.padding = 0;
        this.cfl = tbPageContext;
        this.cOC = new ArrayList<>();
        this.cOE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.cOF = l.getDimens(this.cfl.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.cfl.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cOC != null) {
            return this.cOC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cOC == null || i >= this.cOC.size()) {
            return null;
        }
        return this.cOC.get(i);
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
            view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0302a = new C0302a();
            c0302a.cBY = (LinearLayout) view.findViewById(R.id.photo_container);
            c0302a.cOG = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0302a = (C0302a) view.getTag();
        }
        if (kk(i) == 1) {
            c0302a.cBY.setPadding(0, this.padding, 0, 0);
        } else if (kk(i) == 2) {
            c0302a.cBY.setPadding(0, 0, 0, this.padding);
        } else {
            c0302a.cBY.setPadding(0, 0, 0, 0);
        }
        c0302a.cOG.setDrawerType(0);
        c0302a.cOG.setBorderSurroundContent(true);
        c0302a.cOG.setDrawBorder(true);
        if (itemViewType == 0) {
            c0302a.cOG.setBorderColor(this.cnI);
            c0302a.cOG.setBorderWidth(this.cOE);
        } else {
            c0302a.cOG.setBorderColor(this.cOD);
            c0302a.cOG.setBorderWidth(this.cOF);
        }
        c0302a.cOG.setDefaultResource(R.drawable.transparent_bg);
        c0302a.cOG.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0302a.cOG.startLoad(this.cOC.get(i).getUrl(), 10, false);
        view.setTag(c0302a);
        return view;
    }

    public int kk(int i) {
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
        return i == this.cOv ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void C(ArrayList<b> arrayList) {
        this.cOC = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void kl(int i) {
        this.cOv = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0302a {
        LinearLayout cBY;
        TbImageView cOG;

        private C0302a() {
        }
    }
}
