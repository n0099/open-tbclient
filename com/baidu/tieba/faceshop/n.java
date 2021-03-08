package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class n extends BaseAdapter {
    private ArrayList<String> eXu;
    private Context mContext;

    public n(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.eXu = arrayList;
    }

    public void setData(ArrayList<String> arrayList) {
        this.eXu = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null || this.eXu.size() <= 0 || i < 0 || i >= this.eXu.size()) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds22)) / 4;
        if (view == null) {
            a aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.face_package_item_image, (ViewGroup) null);
            aVar.iQB = (TbImageView) view.findViewById(R.id.image);
            view.setTag(aVar);
            view.setLayoutParams(new AbsListView.LayoutParams(equipmentWidth, equipmentWidth));
        }
        a aVar2 = (a) view.getTag();
        String obj = getItem(i).toString();
        ap.setBackgroundResource(aVar2.iQB, R.drawable.btn_choose_face_selector);
        aVar2.iQB.a(obj, 10, equipmentWidth, equipmentWidth, false);
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private class a {
        TbImageView iQB;

        private a() {
        }
    }
}
