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
public class bc extends BaseAdapter {
    Activity a;
    private int b = 0;

    public bc(Activity activity) {
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
        bd bdVar;
        if (view == null) {
            LayoutInflater layoutInflater = this.a.getLayoutInflater();
            bd bdVar2 = new bd(this, null);
            view = layoutInflater.inflate(R.layout.search_select_dialog_item, (ViewGroup) null);
            bdVar2.a = (TextView) view.findViewById(R.id.text);
            bdVar2.b = (ImageView) view.findViewById(R.id.image);
            view.setTag(bdVar2);
            bdVar = bdVar2;
        } else {
            bdVar = (bd) view.getTag();
        }
        int af = TiebaApplication.b().af();
        com.baidu.tieba.c.ad.b(bdVar.a, af);
        switch (i) {
            case 0:
                bdVar.a.setText(this.a.getString(R.string.enter_forum));
                if (this.b == 0) {
                    bdVar.b.setVisibility(0);
                    bdVar.a.setTextColor(this.a.getResources().getColor(R.color.blue));
                    break;
                } else {
                    bdVar.b.setVisibility(4);
                    com.baidu.tieba.c.ad.b(bdVar.a, af);
                    break;
                }
            case 1:
                bdVar.a.setText(this.a.getString(R.string.search_post));
                if (this.b == 1) {
                    bdVar.b.setVisibility(0);
                    bdVar.a.setTextColor(this.a.getResources().getColor(R.color.blue));
                    break;
                } else {
                    bdVar.b.setVisibility(4);
                    com.baidu.tieba.c.ad.b(bdVar.a, af);
                    break;
                }
        }
        return view;
    }
}
