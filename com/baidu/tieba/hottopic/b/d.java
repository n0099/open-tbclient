package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends x.a {
    public int ahf;
    public TextView bIA;
    public TextView bIB;
    public TextView bIC;
    public TextView bID;
    public View bIE;
    public View bIw;
    public TextView bIx;
    public RelativeLayout bIy;
    public HeadImageView bIz;
    public View rootView;

    public d(View view) {
        super(view);
        this.ahf = 3;
        this.rootView = null;
        this.bIw = null;
        this.bIx = null;
        this.bIy = null;
        this.bIz = null;
        this.bIA = null;
        this.bIB = null;
        this.bIC = null;
        this.bID = null;
        this.bIE = null;
        this.rootView = view;
        U(this.rootView);
    }

    private void U(View view) {
        if (view != null) {
            this.bIw = view.findViewById(n.g.top_divider_line);
            this.bIx = (TextView) view.findViewById(n.g.magic_item_theme_title);
            this.bIy = (RelativeLayout) view.findViewById(n.g.magicpost_item_user_info_view);
            this.bIz = (HeadImageView) view.findViewById(n.g.magic_item_photo);
            this.bIA = (TextView) view.findViewById(n.g.magic_item_username);
            this.bIB = (TextView) view.findViewById(n.g.magic_item_replytime);
            this.bIC = (TextView) view.findViewById(n.g.magic_item_comment_textview);
            this.bID = (TextView) view.findViewById(n.g.magic_item_reply_content);
            this.bIE = view.findViewById(n.g.magic_item_divider_line);
        }
    }
}
