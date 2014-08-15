package com.baidu.tieba.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.model.ao;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.core.d {
    private ViewGroup b;
    private View c;
    private TbImageView d;
    private TbImageView e;
    private TbImageView f;
    private TbImageView g;
    private TbImageView h;
    private TbImageView i;
    private TbImageView j;
    private TbImageView k;
    private TbImageView l;
    private TbImageView m;
    private NewUserGuideActivity o;
    private ao p;
    private Button q;
    private final Hashtable<Integer, TbImageView> n = new Hashtable<>();
    private boolean r = false;
    private boolean s = false;
    private boolean t = true;
    private final View.OnClickListener u = new n(this);

    public void a(InterestFrsData interestFrsData) {
        b(interestFrsData);
        this.s = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = (NewUserGuideActivity) getActivity();
        this.p = this.o.i();
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
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.n.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.a(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.v.guide_main, (ViewGroup) null);
        this.c = this.b.findViewById(com.baidu.tieba.u.root_main_view_cover);
        this.d = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_1);
        this.e = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_2);
        this.f = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_3);
        this.g = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_4);
        this.h = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_5);
        this.i = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_6);
        this.j = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_7);
        this.k = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_8);
        this.l = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_9);
        this.m = (TbImageView) this.b.findViewById(com.baidu.tieba.u.icon_10);
        this.q = (Button) this.b.findViewById(com.baidu.tieba.u.btn_next);
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
