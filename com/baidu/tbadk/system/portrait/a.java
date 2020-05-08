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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> duK;
    private ArrayList<b> egk;
    private int egm;
    private int egn;
    private int padding;
    private int egd = -1;
    private int rowSize = 0;
    private int dCe = am.getColor(R.color.common_color_10043);
    private int egl = am.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.egk = null;
        this.duK = null;
        this.padding = 0;
        this.duK = tbPageContext;
        this.egk = new ArrayList<>();
        this.egm = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.egn = l.getDimens(this.duK.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.duK.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egk != null) {
            return this.egk.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egk == null || i >= this.egk.size()) {
            return null;
        }
        return this.egk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0447a c0447a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0447a = new C0447a();
            c0447a.dTK = (LinearLayout) view.findViewById(R.id.photo_container);
            c0447a.ego = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0447a = (C0447a) view.getTag();
        }
        if (nc(i) == 1) {
            c0447a.dTK.setPadding(0, this.padding, 0, 0);
        } else if (nc(i) == 2) {
            c0447a.dTK.setPadding(0, 0, 0, this.padding);
        } else {
            c0447a.dTK.setPadding(0, 0, 0, 0);
        }
        c0447a.ego.setDrawerType(0);
        c0447a.ego.setBorderSurroundContent(true);
        c0447a.ego.setDrawBorder(true);
        if (itemViewType == 0) {
            c0447a.ego.setBorderColor(this.dCe);
            c0447a.ego.setBorderWidth(this.egm);
        } else {
            c0447a.ego.setBorderColor(this.egl);
            c0447a.ego.setBorderWidth(this.egn);
        }
        c0447a.ego.setDefaultResource(R.drawable.transparent_bg);
        c0447a.ego.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0447a.ego.startLoad(this.egk.get(i).getUrl(), 10, false);
        view.setTag(c0447a);
        return view;
    }

    public int nc(int i) {
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
        return i == this.egd ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void H(ArrayList<b> arrayList) {
        this.egk = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void nd(int i) {
        this.egd = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0447a {
        LinearLayout dTK;
        TbImageView ego;

        private C0447a() {
        }
    }
}
