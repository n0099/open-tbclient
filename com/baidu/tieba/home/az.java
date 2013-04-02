package com.baidu.tieba.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class az extends BaseAdapter {
    Activity a;
    private int b = 0;

    public az(Activity activity) {
        this.a = null;
        this.a = activity;
    }

    public void a(int i) {
        this.b = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ba baVar;
        if (view == null) {
            LayoutInflater layoutInflater = this.a.getLayoutInflater();
            ba baVar2 = new ba(this, null);
            view = layoutInflater.inflate(R.layout.search_select_dialog_item, (ViewGroup) null);
            baVar2.a = (TextView) view.findViewById(R.id.text);
            baVar2.b = (ImageView) view.findViewById(R.id.image);
            view.setTag(baVar2);
            baVar = baVar2;
        } else {
            baVar = (ba) view.getTag();
        }
        int ah = TiebaApplication.b().ah();
        com.baidu.tieba.c.ae.b(baVar.a, ah);
        switch (i) {
            case 0:
                baVar.a.setText(this.a.getString(R.string.enter_forum));
                if (this.b == 0) {
                    baVar.b.setVisibility(0);
                    baVar.a.setTextColor(this.a.getResources().getColor(R.color.blue));
                    break;
                } else {
                    baVar.b.setVisibility(4);
                    com.baidu.tieba.c.ae.b(baVar.a, ah);
                    break;
                }
            case 1:
                baVar.a.setText(this.a.getString(R.string.search_post));
                if (this.b == 1) {
                    baVar.b.setVisibility(0);
                    baVar.a.setTextColor(this.a.getResources().getColor(R.color.blue));
                    break;
                } else {
                    baVar.b.setVisibility(4);
                    com.baidu.tieba.c.ae.b(baVar.a, ah);
                    break;
                }
        }
        return view;
    }
}
