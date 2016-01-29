package com.baidu.tbadk.system.portrait;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> MR;
    private ArrayList<i> aCI;
    private int aCL;
    private int aCM;
    private int padding;
    private int aCA = -1;
    private int rowSize = 0;
    private int aCJ = ar.getColor(t.d.black_alpha10);
    private int aCK = ar.getColor(t.d.cp_link_tip_a);

    public h(TbPageContext<?> tbPageContext) {
        this.aCI = null;
        this.MR = null;
        this.padding = 0;
        this.MR = tbPageContext;
        this.aCI = new ArrayList<>();
        this.aCL = k.c(tbPageContext.getPageActivity(), t.e.ds1);
        this.aCM = k.c(this.MR.getPageActivity(), t.e.ds4);
        this.padding = k.c(this.MR.getPageActivity(), t.e.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aCI != null) {
            return this.aCI.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aCI == null || i >= this.aCI.size()) {
            return null;
        }
        return this.aCI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.recommend_system_photo_item, viewGroup, false);
            aVar = new a(this, null);
            aVar.aqa = (LinearLayout) view.findViewById(t.g.photo_container);
            aVar.aCN = (TbImageView) view.findViewById(t.g.photo);
        } else {
            aVar = (a) view.getTag();
        }
        if (fc(i) == 1) {
            aVar.aqa.setPadding(0, this.padding, 0, 0);
        } else if (fc(i) == 2) {
            aVar.aqa.setPadding(0, 0, 0, this.padding);
        } else {
            aVar.aqa.setPadding(0, 0, 0, 0);
        }
        aVar.aCN.setDrawerType(0);
        aVar.aCN.setBorderSurroundContent(true);
        aVar.aCN.setDrawBorder(true);
        if (itemViewType == 0) {
            aVar.aCN.setBorderColor(this.aCJ);
            aVar.aCN.setBorderWidth(this.aCL);
        } else {
            aVar.aCN.setBorderColor(this.aCK);
            aVar.aCN.setBorderWidth(this.aCM);
        }
        aVar.aCN.setDefaultResource(t.f.icon_default_avatar100);
        aVar.aCN.d(this.aCI.get(i).getUrl(), 10, false);
        view.setTag(aVar);
        return view;
    }

    public int fc(int i) {
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
        return i == this.aCA ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void u(ArrayList<i> arrayList) {
        this.aCI = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void fe(int i) {
        this.aCA = i;
    }

    /* loaded from: classes.dex */
    private class a {
        TbImageView aCN;
        LinearLayout aqa;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
