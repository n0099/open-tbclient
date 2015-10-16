package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c extends x.a {
    public int apS;
    public View bpG;
    public TextView bpH;
    public RelativeLayout bpI;
    public HeadImageView bpJ;
    public TextView bpK;
    public TextView bpL;
    public TextView bpM;
    public TextView bpN;
    public View bpO;
    public View rootView;

    public c(View view) {
        super(view);
        this.apS = 3;
        this.rootView = null;
        this.bpG = null;
        this.bpH = null;
        this.bpI = null;
        this.bpJ = null;
        this.bpK = null;
        this.bpL = null;
        this.bpM = null;
        this.bpN = null;
        this.bpO = null;
        this.rootView = view;
        I(this.rootView);
    }

    private void I(View view) {
        if (view != null) {
            this.bpG = view.findViewById(i.f.top_divider_line);
            this.bpH = (TextView) view.findViewById(i.f.magic_item_theme_title);
            this.bpI = (RelativeLayout) view.findViewById(i.f.magicpost_item_user_info_view);
            this.bpJ = (HeadImageView) view.findViewById(i.f.magic_item_photo);
            this.bpK = (TextView) view.findViewById(i.f.magic_item_username);
            this.bpL = (TextView) view.findViewById(i.f.magic_item_replytime);
            this.bpM = (TextView) view.findViewById(i.f.magic_item_comment_textview);
            this.bpN = (TextView) view.findViewById(i.f.magic_item_reply_content);
            this.bpO = view.findViewById(i.f.magic_item_divider_line);
        }
    }
}
