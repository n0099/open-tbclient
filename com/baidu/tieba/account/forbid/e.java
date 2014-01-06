package com.baidu.tieba.account.forbid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private String[] a;
    private int b = 0;
    private View.OnClickListener c = new f(this);

    public e(String[] strArr) {
        this.a = strArr;
    }

    public String a() {
        if (this.a != null) {
            return this.a[this.b];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.forbid_list_item, (ViewGroup) null);
            g gVar2 = new g(null);
            gVar2.a = (TextView) view.findViewById(R.id.reason_text);
            gVar2.b = (ImageView) view.findViewById(R.id.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.c);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.c = i;
        boolean z = TiebaApplication.g().an() == 1;
        gVar.a.setText(this.a[i]);
        if (gVar.c == this.b) {
            gVar.b.setImageDrawable(viewGroup.getResources().getDrawable(z ? R.drawable.icon_found_information_choose_1 : R.drawable.icon_found_information_choose));
            gVar.b.setVisibility(0);
            gVar.a.setTextColor(viewGroup.getResources().getColor(z ? R.color.forbid_selected_txt_1 : R.color.forbid_selected_txt));
        } else {
            gVar.b.setVisibility(4);
            gVar.a.setTextColor(viewGroup.getResources().getColor(z ? R.color.appeal_com_text_1 : R.color.appeal_com_text));
        }
        return view;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }
}
