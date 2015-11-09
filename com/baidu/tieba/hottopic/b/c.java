package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends x.a {
    public int arf;
    public View bqk;
    public TextView bql;
    public RelativeLayout bqm;
    public HeadImageView bqn;
    public TextView bqo;
    public TextView bqp;
    public TextView bqq;
    public TextView bqr;
    public View bqs;
    public View rootView;

    public c(View view) {
        super(view);
        this.arf = 3;
        this.rootView = null;
        this.bqk = null;
        this.bql = null;
        this.bqm = null;
        this.bqn = null;
        this.bqo = null;
        this.bqp = null;
        this.bqq = null;
        this.bqr = null;
        this.bqs = null;
        this.rootView = view;
        J(this.rootView);
    }

    private void J(View view) {
        if (view != null) {
            this.bqk = view.findViewById(i.f.top_divider_line);
            this.bql = (TextView) view.findViewById(i.f.magic_item_theme_title);
            this.bqm = (RelativeLayout) view.findViewById(i.f.magicpost_item_user_info_view);
            this.bqn = (HeadImageView) view.findViewById(i.f.magic_item_photo);
            this.bqo = (TextView) view.findViewById(i.f.magic_item_username);
            this.bqp = (TextView) view.findViewById(i.f.magic_item_replytime);
            this.bqq = (TextView) view.findViewById(i.f.magic_item_comment_textview);
            this.bqr = (TextView) view.findViewById(i.f.magic_item_reply_content);
            this.bqs = view.findViewById(i.f.magic_item_divider_line);
        }
    }
}
