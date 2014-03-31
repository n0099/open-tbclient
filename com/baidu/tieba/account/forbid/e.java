package com.baidu.tieba.account.forbid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends BaseAdapter {
    private String[] a;
    private int b = 0;
    private View.OnClickListener c = new f(this);

    public e(String[] strArr) {
        this.a = strArr;
    }

    public final String a() {
        if (this.a != null) {
            return this.a[this.b];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.forbid_list_item, (ViewGroup) null);
            g gVar2 = new g((byte) 0);
            gVar2.a = (TextView) view.findViewById(com.baidu.tieba.a.h.reason_text);
            gVar2.b = (ImageView) view.findViewById(com.baidu.tieba.a.h.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.c);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.c = i;
        boolean z = TbadkApplication.j().l() == 1;
        gVar.a.setText(this.a[i]);
        if (gVar.c == this.b) {
            gVar.b.setImageDrawable(viewGroup.getResources().getDrawable(z ? com.baidu.tieba.a.g.icon_found_information_choose_1 : com.baidu.tieba.a.g.icon_found_information_choose));
            gVar.b.setVisibility(0);
            gVar.a.setTextColor(viewGroup.getResources().getColor(z ? com.baidu.tieba.a.e.forbid_selected_txt_1 : com.baidu.tieba.a.e.forbid_selected_txt));
        } else {
            gVar.b.setVisibility(4);
            gVar.a.setTextColor(viewGroup.getResources().getColor(z ? com.baidu.tieba.a.e.appeal_com_text_1 : com.baidu.tieba.a.e.appeal_com_text));
        }
        return view;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }
}
