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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eNx;
    private ArrayList<b> fEY;
    private int fFa;
    private int fFb;
    private int padding;
    private int fER = -1;
    private int rowSize = 0;
    private int eYj = ap.getColor(R.color.common_color_10043);
    private int fEZ = ap.getColor(R.color.CAM_X0302);

    public a(TbPageContext<?> tbPageContext) {
        this.fEY = null;
        this.eNx = null;
        this.padding = 0;
        this.eNx = tbPageContext;
        this.fEY = new ArrayList<>();
        this.fFa = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fFb = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEY != null) {
            return this.fEY.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fEY == null || i >= this.fEY.size()) {
            return null;
        }
        return this.fEY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0609a c0609a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0609a = new C0609a();
            c0609a.fqI = (LinearLayout) view.findViewById(R.id.photo_container);
            c0609a.fFc = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0609a = (C0609a) view.getTag();
        }
        if (sO(i) == 1) {
            c0609a.fqI.setPadding(0, this.padding, 0, 0);
        } else if (sO(i) == 2) {
            c0609a.fqI.setPadding(0, 0, 0, this.padding);
        } else {
            c0609a.fqI.setPadding(0, 0, 0, 0);
        }
        c0609a.fFc.setDrawerType(0);
        c0609a.fFc.setBorderSurroundContent(true);
        c0609a.fFc.setDrawBorder(true);
        if (itemViewType == 0) {
            c0609a.fFc.setBorderColor(this.eYj);
            c0609a.fFc.setBorderWidth(this.fFa);
        } else {
            c0609a.fFc.setBorderColor(this.fEZ);
            c0609a.fFc.setBorderWidth(this.fFb);
        }
        c0609a.fFc.setDefaultResource(R.drawable.transparent_bg);
        c0609a.fFc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0609a.fFc.startLoad(this.fEY.get(i).getUrl(), 10, false);
        view.setTag(c0609a);
        return view;
    }

    public int sO(int i) {
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
        return i == this.fER ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.fEY = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void sP(int i) {
        this.fER = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0609a {
        TbImageView fFc;
        LinearLayout fqI;

        private C0609a() {
        }
    }
}
