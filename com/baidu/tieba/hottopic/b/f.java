package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.viewpager.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends a.C0043a {
    public int ahf;
    private View bIL;
    public LinearLayout bIM;
    public BarImageView bIN;
    public LinearLayout bIO;
    public TextView bIP;
    public LinearLayout bIQ;
    public TextView bIR;
    public TextView bIS;
    public TextView bIT;
    public TextView bIU;

    public f(View view) {
        super(view);
        this.ahf = 3;
        this.bIL = view;
        initView();
    }

    private void initView() {
        this.bIM = (LinearLayout) this.bIL.findViewById(n.g.forum_info_card_root);
        this.bIN = (BarImageView) this.bIL.findViewById(n.g.forum_avatar);
        this.bIO = (LinearLayout) this.bIL.findViewById(n.g.forum_text_info);
        this.bIP = (TextView) this.bIL.findViewById(n.g.forum_name);
        this.bIQ = (LinearLayout) this.bIL.findViewById(n.g.forum_info_text_center);
        this.bIR = (TextView) this.bIL.findViewById(n.g.forum_follows_count);
        this.bIS = (TextView) this.bIL.findViewById(n.g.forum_thread_count);
        this.bIT = (TextView) this.bIL.findViewById(n.g.forum_intro);
        this.bIU = (TextView) this.bIL.findViewById(n.g.forum_add_love);
    }
}
