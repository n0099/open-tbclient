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
    private TbPageContext<?> eCn;
    private ArrayList<b> fsc;
    private int fse;
    private int fsf;
    private int padding;
    private int frV = -1;
    private int rowSize = 0;
    private int eMb = ap.getColor(R.color.common_color_10043);
    private int fsd = ap.getColor(R.color.cp_link_tip_a);

    public a(TbPageContext<?> tbPageContext) {
        this.fsc = null;
        this.eCn = null;
        this.padding = 0;
        this.eCn = tbPageContext;
        this.fsc = new ArrayList<>();
        this.fse = l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds1);
        this.fsf = l.getDimens(this.eCn.getPageActivity(), R.dimen.ds4);
        this.padding = l.getDimens(this.eCn.getPageActivity(), R.dimen.ds36);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fsc != null) {
            return this.fsc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fsc == null || i >= this.fsc.size()) {
            return null;
        }
        return this.fsc.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0585a c0585a;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.recommend_system_photo_item, viewGroup, false);
            c0585a = new C0585a();
            c0585a.fej = (LinearLayout) view.findViewById(R.id.photo_container);
            c0585a.fsg = (TbImageView) view.findViewById(R.id.photo);
        } else {
            c0585a = (C0585a) view.getTag();
        }
        if (rF(i) == 1) {
            c0585a.fej.setPadding(0, this.padding, 0, 0);
        } else if (rF(i) == 2) {
            c0585a.fej.setPadding(0, 0, 0, this.padding);
        } else {
            c0585a.fej.setPadding(0, 0, 0, 0);
        }
        c0585a.fsg.setDrawerType(0);
        c0585a.fsg.setBorderSurroundContent(true);
        c0585a.fsg.setDrawBorder(true);
        if (itemViewType == 0) {
            c0585a.fsg.setBorderColor(this.eMb);
            c0585a.fsg.setBorderWidth(this.fse);
        } else {
            c0585a.fsg.setBorderColor(this.fsd);
            c0585a.fsg.setBorderWidth(this.fsf);
        }
        c0585a.fsg.setDefaultResource(R.drawable.transparent_bg);
        c0585a.fsg.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        c0585a.fsg.startLoad(this.fsc.get(i).getUrl(), 10, false);
        view.setTag(c0585a);
        return view;
    }

    public int rF(int i) {
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
        return i == this.frV ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void O(ArrayList<b> arrayList) {
        this.fsc = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 4 == 0) {
                this.rowSize = arrayList.size() / 4;
            } else {
                this.rowSize = (arrayList.size() / 4) + 1;
            }
        }
    }

    public void rG(int i) {
        this.frV = i;
    }

    /* renamed from: com.baidu.tbadk.system.portrait.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0585a {
        LinearLayout fej;
        TbImageView fsg;

        private C0585a() {
        }
    }
}
