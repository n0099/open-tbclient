package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends x.a {
    public int afY;
    public TextView bAN;
    public TextView bBB;
    public View bES;
    public TextView bET;
    public RelativeLayout bEU;
    public HeadImageView bEV;
    public TextView bEW;
    public TextView bEX;
    public View bEY;
    public View rootView;

    public d(View view) {
        super(view);
        this.afY = 3;
        this.rootView = null;
        this.bES = null;
        this.bET = null;
        this.bEU = null;
        this.bEV = null;
        this.bEW = null;
        this.bEX = null;
        this.bAN = null;
        this.bBB = null;
        this.bEY = null;
        this.rootView = view;
        P(this.rootView);
    }

    private void P(View view) {
        if (view != null) {
            this.bES = view.findViewById(n.f.top_divider_line);
            this.bET = (TextView) view.findViewById(n.f.magic_item_theme_title);
            this.bEU = (RelativeLayout) view.findViewById(n.f.magicpost_item_user_info_view);
            this.bEV = (HeadImageView) view.findViewById(n.f.magic_item_photo);
            this.bEW = (TextView) view.findViewById(n.f.magic_item_username);
            this.bEX = (TextView) view.findViewById(n.f.magic_item_replytime);
            this.bAN = (TextView) view.findViewById(n.f.magic_item_comment_textview);
            this.bBB = (TextView) view.findViewById(n.f.magic_item_reply_content);
            this.bEY = view.findViewById(n.f.magic_item_divider_line);
        }
    }
}
