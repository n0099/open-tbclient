package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends a.C0043a {
    public int afY;
    public TextView bAL;
    private View bFf;
    public LinearLayout bFg;
    public BarImageView bFh;
    public LinearLayout bFi;
    public LinearLayout bFj;
    public TextView bFk;
    public TextView bFl;
    public TextView bFm;
    public TextView bFn;

    public f(View view) {
        super(view);
        this.afY = 3;
        this.bFf = view;
        initView();
    }

    private void initView() {
        this.bFg = (LinearLayout) this.bFf.findViewById(n.f.forum_info_card_root);
        this.bFh = (BarImageView) this.bFf.findViewById(n.f.forum_avatar);
        this.bFi = (LinearLayout) this.bFf.findViewById(n.f.forum_text_info);
        this.bAL = (TextView) this.bFf.findViewById(n.f.forum_name);
        this.bFj = (LinearLayout) this.bFf.findViewById(n.f.forum_info_text_center);
        this.bFk = (TextView) this.bFf.findViewById(n.f.forum_follows_count);
        this.bFl = (TextView) this.bFf.findViewById(n.f.forum_thread_count);
        this.bFm = (TextView) this.bFf.findViewById(n.f.forum_intro);
        this.bFn = (TextView) this.bFf.findViewById(n.f.forum_add_love);
    }
}
