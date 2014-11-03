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
    private ArrayList<com.baidu.tbadk.b.a.a> aeE = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.b.a.a> QI = new ArrayList<>();
    private int aYF = 0;
    private String aYG = "";

    public b(Context context) {
        this.mContext = context;
        c cVar = new c(this, this.mContext, y.nearby_group_title, u.icon_nearby_group, y.nearbygroup_description, 0);
        d dVar = new d(this, this.mContext, y.qr_code, u.icon_qr_code, y.qrcode_description, 1);
        e eVar = new e(this, this.mContext, y.add_group_title_main, u.icon_qun_search, y.addgroup_description, 2);
        this.aeE.clear();
        if (TbadkApplication.m251getInst().isNearByGroupOpen()) {
            this.aeE.add(cVar);
        }
        this.aeE.add(dVar);
        this.aeE.add(eVar);
    }

    public void w(ArrayList<com.baidu.tbadk.b.a.a> arrayList) {
        this.QI = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.QI != null && this.aeE != null) {
            return this.aeE.size() + this.QI.size();
        }
        if (this.aeE != null) {
            return this.aeE.size();
        }
        if (this.QI != null) {
            return this.QI.size();
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
        if (i < this.aeE.size()) {
            return this.aeE.get(i);
        }
        if (i < this.aeE.size() || i >= getCount()) {
            return null;
        }
        return this.QI.get(i - this.aeE.size());
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
            fVar.QJ = (HeadImageView) view.findViewById(v.portrait);
            fVar.QK = (TextView) view.findViewById(v.title);
            fVar.QL = (TextView) view.findViewById(v.description);
            view.setTag(fVar);
        } else {
            fVar = (f) view.getTag();
        }
        if (getCount() == 0) {
            return null;
        }
        if (i < this.aeE.size()) {
            fVar.QJ.setImageResource(this.aeE.get(i).qY());
            fVar.QK.setText(this.aeE.get(i).qZ());
            fVar.QL.setText(this.aeE.get(i).getDescription());
        } else if (i >= this.aeE.size() && i < getCount()) {
            int size = i - this.aeE.size();
            fVar.QJ.setImageResource(this.QI.get(size).qY());
            fVar.QK.setText(this.QI.get(size).qZ());
            fVar.QL.setText(this.QI.get(size).getDescription());
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        DiscoverMoreActivity discoverMoreActivity = (DiscoverMoreActivity) this.mContext;
        discoverMoreActivity.getLayoutMode().L(skinType == 1);
        discoverMoreActivity.getLayoutMode().h(view);
        return view;
    }

    public void fL(int i) {
        this.aYF = i;
        notifyDataSetChanged();
    }

    public void gf(String str) {
        this.aYG = str;
    }

    public ArrayList<com.baidu.tbadk.b.a.a> NY() {
        return this.aeE;
    }
}
