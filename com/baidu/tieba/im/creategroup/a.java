package com.baidu.tieba.im.creategroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.e {
    private View a;
    private TextView c;
    private ImageView d;

    public a(Context context) {
        super(context);
        this.a = null;
        this.c = null;
        this.d = null;
        e();
    }

    public View a() {
        return this.a;
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void a(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    private void e() {
        this.a = LayoutInflater.from(this.b).inflate(R.layout.address_lbs_item, (ViewGroup) null);
        this.c = (TextView) this.a.findViewById(R.id.text);
        this.d = (ImageView) this.a.findViewById(R.id.group_address_list_item_selected);
        this.a.setTag(this);
    }
}
