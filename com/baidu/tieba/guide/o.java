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
public final class o extends com.baidu.tbadk.core.d {
    private ViewGroup a;
    private View b;
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
    private ao o;
    private Button p;
    private final Hashtable<Integer, ImageView> m = new Hashtable<>();
    private boolean q = false;
    private boolean r = false;
    private boolean s = true;
    private final View.OnClickListener t = new p(this);

    public final void a(InterestFrsData interestFrsData) {
        b(interestFrsData);
        this.r = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n = (NewUserGuideActivity) getActivity();
        this.o = this.n.i();
        if (this.o == null || this.r) {
            return;
        }
        if (bundle != null) {
            this.q = bundle.getBoolean("is_new_user");
        } else {
            this.q = this.n.getIntent().getBooleanExtra("is_new_user", false);
        }
        b(this.o.b());
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
                    if (tag.getBid() > 0 && tag.getBid() <= 10 && (imageView = this.m.get(Integer.valueOf(tag.getBid()))) != null) {
                        imageView.setTag(tag);
                        this.n.h().b(tag.getBicon(), new r(this, imageView));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.a.i.guide_main, (ViewGroup) null);
        this.b = this.a.findViewById(com.baidu.tieba.a.h.root_main_view_cover);
        this.c = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_1);
        this.d = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_2);
        this.e = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_3);
        this.f = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_4);
        this.g = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_5);
        this.h = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_6);
        this.i = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_7);
        this.j = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_8);
        this.k = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_9);
        this.l = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.icon_10);
        this.p = (Button) this.a.findViewById(com.baidu.tieba.a.h.btn_next);
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
        this.p.setOnClickListener(this.t);
        this.c.setOnClickListener(this.t);
        this.d.setOnClickListener(this.t);
        this.e.setOnClickListener(this.t);
        this.f.setOnClickListener(this.t);
        this.g.setOnClickListener(this.t);
        this.h.setOnClickListener(this.t);
        this.i.setOnClickListener(this.t);
        this.j.setOnClickListener(this.t);
        this.k.setOnClickListener(this.t);
        this.k.setOnClickListener(this.t);
        this.l.setOnClickListener(this.t);
        return this.a;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
    }
}
