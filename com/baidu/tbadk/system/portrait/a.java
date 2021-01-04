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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eXu;
    private ArrayList<b> fOC;
    private int fOE;
    private int fOF;
    private int padding;
    private int fOw = -1;
    private int rowSize = 0;
    private int fhJ = ao.getColor(R.color.common_color_10043);
    private int fOD = ao.getColor(R.color.CAM_X0302);

    public a(TbPageContext<?> tbPageContext) {
        this.fOC = null;
        this.eXu = null;
        this.padding = 0;
        this.eXu = tbPageContext;
        this.fOC = new ArrayList<>();
        this.fOE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fOF = l.getDimens(this.eXu.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eXu.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fOC != null) {
            return this.fOC.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fOC == null || i >= this.fOC.size()) {
            return null;
        }
        return this.fOC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0600a c0600a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0600a = new C0600a();
            c0600a.fAp = (LinearLayout) view.findViewById(R.id.photo_container);
            c0600a.fOG = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0600a = (C0600a) view.getTag();
        }
        if (sZ(i) == 1) {
            c0600a.fAp.setPadding(0, this.padding, 0, 0);
        } else if (sZ(i) == 2) {
            c0600a.fAp.setPadding(0, 0, 0, this.padding);
        } else {
            c0600a.fAp.setPadding(0, 0, 0, 0);
        }
        c0600a.fOG.setDrawerType(0);
        c0600a.fOG.setBorderSurroundContent(true);
        c0600a.fOG.setDrawBorder(true);
        if (itemViewType == 0) {
            c0600a.fOG.setBorderColor(this.fhJ);
            c0600a.fOG.setBorderWidth(this.fOE);
        } else {
            c0600a.fOG.setBorderColor(this.fOD);
            c0600a.fOG.setBorderWidth(this.fOF);
        }
        c0600a.fOG.setDefaultResource(R.drawable.transparent_bg);
        c0600a.fOG.startLoad(this.fOC.get(i).getUrl(), 10, false);
        view.setTag(c0600a);
        return view;
    }

    public int sZ(int i) {
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
        return i == this.fOw ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.fOC = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void ta(int i) {
        this.fOw = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0600a {
        LinearLayout fAp;
        TbImageView fOG;

        private C0600a() {
        }
    }
}
