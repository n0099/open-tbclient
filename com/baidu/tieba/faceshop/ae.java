package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {
    private Context a;
    private ArrayList<String> b;
    private com.baidu.tieba.util.i c;

    public ae(Context context, ArrayList<String> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = new com.baidu.tieba.util.i(context);
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.size() <= 0 || i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int measuredWidth = viewGroup.getMeasuredWidth() / 4;
        this.c.a(measuredWidth, measuredWidth);
        if (view == null) {
            ag agVar = new ag(this, null);
            view = LayoutInflater.from(this.a).inflate(R.layout.face_package_item_image, (ViewGroup) null);
            agVar.a = (TbImageView) view.findViewById(R.id.image);
            view.setTag(agVar);
        }
        ag agVar2 = (ag) view.getTag();
        view.setLayoutParams(new AbsListView.LayoutParams(measuredWidth, measuredWidth));
        String obj = getItem(i).toString();
        agVar2.a.setTag(obj);
        agVar2.a.setBackgroundResource(TiebaApplication.g().al() == 1 ? R.drawable.btn_choose_face_selector_1 : R.drawable.btn_choose_face_selector);
        this.c.b(obj, new af(this, viewGroup));
        if (i == getCount() - 1) {
            viewGroup.invalidate();
        }
        return view;
    }

    public void a() {
        if (this.c != null) {
            this.c.d();
        }
    }
}
