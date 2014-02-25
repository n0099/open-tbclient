package com.baidu.tieba.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.bh;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.j {
    private ViewGroup b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private NewUserGuideActivity n;
    private bh o;
    private Button p;
    private Hashtable<Integer, ImageView> m = new Hashtable<>();
    private boolean q = false;
    private boolean r = false;
    private View.OnClickListener s = new p(this);

    public void a(InterestFrsData interestFrsData) {
        b(interestFrsData);
        this.r = true;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n = (NewUserGuideActivity) getActivity();
        this.o = this.n.h();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (this.o != null && !this.r) {
            if (bundle != null) {
                this.q = bundle.getBoolean("is_new_user");
            } else {
                this.q = this.n.getIntent().getBooleanExtra("is_new_user", false);
            }
            b(this.o.b());
        }
    }

    private void b(InterestFrsData interestFrsData) {
        if (interestFrsData != null) {
            ArrayList<InterestFrsData.Tag> tag_list = interestFrsData.getTag_list();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tag_list.size()) {
                    InterestFrsData.Tag tag = tag_list.get(i2);
                    if (tag.getBid() >= 1 && tag.getBid() <= 10) {
                        ImageView imageView = this.m.get(Integer.valueOf(tag.getBid()));
                        imageView.setTag(tag);
                        a(imageView, tag.getBicon());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(ImageView imageView, String str) {
        this.n.g().b(str, new q(this, imageView));
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = (ViewGroup) layoutInflater.inflate(R.layout.guide_main, (ViewGroup) null);
        this.c = (ImageView) this.b.findViewById(R.id.icon_1);
        this.d = (ImageView) this.b.findViewById(R.id.icon_2);
        this.e = (ImageView) this.b.findViewById(R.id.icon_3);
        this.f = (ImageView) this.b.findViewById(R.id.icon_4);
        this.g = (ImageView) this.b.findViewById(R.id.icon_5);
        this.h = (ImageView) this.b.findViewById(R.id.icon_6);
        this.i = (ImageView) this.b.findViewById(R.id.icon_7);
        this.j = (ImageView) this.b.findViewById(R.id.icon_8);
        this.k = (ImageView) this.b.findViewById(R.id.icon_9);
        this.l = (ImageView) this.b.findViewById(R.id.icon_10);
        this.p = (Button) this.b.findViewById(R.id.btn_next);
        this.m.put(1, this.c);
        this.m.put(2, this.d);
        this.m.put(3, this.e);
        this.m.put(4, this.f);
        this.m.put(5, this.g);
        this.m.put(6, this.h);
        this.m.put(7, this.i);
        this.m.put(8, this.j);
        this.m.put(9, this.k);
        this.m.put(10, this.l);
        this.p.setOnClickListener(this.s);
        this.c.setOnClickListener(this.s);
        this.d.setOnClickListener(this.s);
        this.e.setOnClickListener(this.s);
        this.f.setOnClickListener(this.s);
        this.g.setOnClickListener(this.s);
        this.h.setOnClickListener(this.s);
        this.i.setOnClickListener(this.s);
        this.j.setOnClickListener(this.s);
        this.k.setOnClickListener(this.s);
        this.k.setOnClickListener(this.s);
        this.l.setOnClickListener(this.s);
        return this.b;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }
}
