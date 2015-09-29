package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends x.a {
    public int apR;
    public TextView bpA;
    public TextView bpB;
    public TextView bpC;
    public View bpD;
    public View bpv;
    public TextView bpw;
    public RelativeLayout bpx;
    public HeadImageView bpy;
    public TextView bpz;
    public View rootView;

    public c(View view) {
        super(view);
        this.apR = 3;
        this.rootView = null;
        this.bpv = null;
        this.bpw = null;
        this.bpx = null;
        this.bpy = null;
        this.bpz = null;
        this.bpA = null;
        this.bpB = null;
        this.bpC = null;
        this.bpD = null;
        this.rootView = view;
        I(this.rootView);
    }

    private void I(View view) {
        if (view != null) {
            this.bpv = view.findViewById(i.f.top_divider_line);
            this.bpw = (TextView) view.findViewById(i.f.magic_item_theme_title);
            this.bpx = (RelativeLayout) view.findViewById(i.f.magicpost_item_user_info_view);
            this.bpy = (HeadImageView) view.findViewById(i.f.magic_item_photo);
            this.bpz = (TextView) view.findViewById(i.f.magic_item_username);
            this.bpA = (TextView) view.findViewById(i.f.magic_item_replytime);
            this.bpB = (TextView) view.findViewById(i.f.magic_item_comment_textview);
            this.bpC = (TextView) view.findViewById(i.f.magic_item_reply_content);
            this.bpD = view.findViewById(i.f.magic_item_divider_line);
        }
    }
}
