package com.baidu.tieba.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ao;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.core.d {
    private ViewGroup b;
    private View c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private NewUserGuideActivity o;
    private ao p;
    private Button q;
    private final Hashtable<Integer, ImageView> n = new Hashtable<>();
    private boolean r = false;
    private boolean s = false;
    private boolean t = true;
    private final View.OnClickListener u = new q(this);

    public void a(InterestFrsData interestFrsData) {
        b(interestFrsData);
        this.s = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = (NewUserGuideActivity) getActivity();
        this.p = this.o.h();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (this.p != null && !this.s) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_new_user");
            } else {
                this.r = this.o.getIntent().getBooleanExtra("is_new_user", false);
            }
            b(this.p.b());
        }
    }

    private void b(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        ImageView imageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < tag_list.size()) {
                    InterestFrsData.Tag tag = tag_list.get(i2);
                    if (tag.getBid() >= 1 && tag.getBid() <= 10 && (imageView = this.n.get(Integer.valueOf(tag.getBid()))) != null) {
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
        this.o.g().b(str, new s(this, imageView));
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.s.guide_main, (ViewGroup) null);
        this.c = this.b.findViewById(com.baidu.tieba.r.root_main_view_cover);
        this.d = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_1);
        this.e = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_2);
        this.f = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_3);
        this.g = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_4);
        this.h = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_5);
        this.i = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_6);
        this.j = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_7);
        this.k = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_8);
        this.l = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_9);
        this.m = (ImageView) this.b.findViewById(com.baidu.tieba.r.icon_10);
        this.q = (Button) this.b.findViewById(com.baidu.tieba.r.btn_next);
        this.n.put(1, this.d);
        this.n.put(2, this.e);
        this.n.put(3, this.f);
        this.n.put(4, this.g);
        this.n.put(5, this.h);
        this.n.put(6, this.i);
        this.n.put(7, this.j);
        this.n.put(8, this.k);
        this.n.put(9, this.l);
        this.n.put(10, this.m);
        this.q.setOnClickListener(this.u);
        this.d.setOnClickListener(this.u);
        this.e.setOnClickListener(this.u);
        this.f.setOnClickListener(this.u);
        this.g.setOnClickListener(this.u);
        this.h.setOnClickListener(this.u);
        this.i.setOnClickListener(this.u);
        this.j.setOnClickListener(this.u);
        this.k.setOnClickListener(this.u);
        this.l.setOnClickListener(this.u);
        this.l.setOnClickListener(this.u);
        this.m.setOnClickListener(this.u);
        return this.b;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }
}
