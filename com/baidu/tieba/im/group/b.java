package com.baidu.tieba.im.group;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private ArrayList<com.baidu.tbadk.b.a.a> aew = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.b.a.a> QE = new ArrayList<>();
    private int aYq = 0;
    private String aYr = "";

    public b(Context context) {
        this.mContext = context;
        c cVar = new c(this, this.mContext, y.nearby_group_title, u.icon_nearby_group, y.nearbygroup_description, 0);
        d dVar = new d(this, this.mContext, y.qr_code, u.icon_qr_code, y.qrcode_description, 1);
        e eVar = new e(this, this.mContext, y.add_group_title_main, u.icon_qun_search, y.addgroup_description, 2);
        this.aew.clear();
        if (TbadkApplication.m251getInst().isNearByGroupOpen()) {
            this.aew.add(cVar);
        }
        this.aew.add(dVar);
        this.aew.add(eVar);
    }

    public void v(ArrayList<com.baidu.tbadk.b.a.a> arrayList) {
        this.QE = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.QE != null && this.aew != null) {
            return this.aew.size() + this.QE.size();
        }
        if (this.aew != null) {
            return this.aew.size();
        }
        if (this.QE != null) {
            return this.QE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cC */
    public com.baidu.tbadk.b.a.a getItem(int i) {
        if (getCount() == 0) {
            return null;
        }
        if (i < this.aew.size()) {
            return this.aew.get(i);
        }
        if (i < this.aew.size() || i >= getCount()) {
            return null;
        }
        return this.QE.get(i - this.aew.size());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, w.discover_group_item, viewGroup, false);
            fVar = new f(this, null);
            fVar.QF = (HeadImageView) view.findViewById(v.portrait);
            fVar.QG = (TextView) view.findViewById(v.title);
            fVar.QH = (TextView) view.findViewById(v.description);
            view.setTag(fVar);
        } else {
            fVar = (f) view.getTag();
        }
        if (getCount() == 0) {
            return null;
        }
        if (i < this.aew.size()) {
            fVar.QF.setImageResource(this.aew.get(i).qW());
            fVar.QG.setText(this.aew.get(i).qX());
            fVar.QH.setText(this.aew.get(i).getDescription());
        } else if (i >= this.aew.size() && i < getCount()) {
            int size = i - this.aew.size();
            fVar.QF.setImageResource(this.QE.get(size).qW());
            fVar.QG.setText(this.QE.get(size).qX());
            fVar.QH.setText(this.QE.get(size).getDescription());
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        DiscoverMoreActivity discoverMoreActivity = (DiscoverMoreActivity) this.mContext;
        discoverMoreActivity.getLayoutMode().L(skinType == 1);
        discoverMoreActivity.getLayoutMode().h(view);
        return view;
    }

    public void fL(int i) {
        this.aYq = i;
        notifyDataSetChanged();
    }

    public void gf(String str) {
        this.aYr = str;
    }

    public ArrayList<com.baidu.tbadk.b.a.a> NV() {
        return this.aew;
    }
}
