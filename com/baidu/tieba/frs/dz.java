package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class dz extends x.a {
    public TextView aPf;
    public LinearLayout aSR;
    public TextView aSV;
    public UserIconBox aSX;
    public HeadImageView aSY;
    public TextView aTb;
    public TextView aTd;
    public LinearLayout aXh;
    public UserIconBox aXi;
    public TextView aYG;
    public TextView aYH;
    public TextView aYI;
    public View aYJ;
    public TbImageView aYK;
    public LinearLayout aYL;
    public FrameLayout aYM;

    public dz(View view) {
        super(view);
        this.aSR = (LinearLayout) view.findViewById(i.f.frs_xiaoying_top_container);
        this.aXh = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aSY = (HeadImageView) view.findViewById(i.f.frs_xiaoying_user_head);
        this.aSX = (UserIconBox) view.findViewById(i.f.frs_xiaoying_tshow_icon_box);
        this.aXi = (UserIconBox) view.findViewById(i.f.frs_xiaoying_user_icon_box);
        this.aYG = (TextView) view.findViewById(i.f.frs_xiaoying_user_name);
        this.aSV = (TextView) view.findViewById(i.f.frs_xiaoying_reply_time);
        this.aPf = (TextView) view.findViewById(i.f.frs_xiaoying_title);
        this.aYH = (TextView) view.findViewById(i.f.frs_xiaoying_abstract_text);
        this.aYI = (TextView) view.findViewById(i.f.frs_xiaoying_location_address);
        this.aYJ = view.findViewById(i.f.frs_xiaoying_location_divider);
        this.aTb = (TextView) view.findViewById(i.f.frs_xiaoying_praise_num);
        this.aTd = (TextView) view.findViewById(i.f.frs_xiaoying_reply_num);
        this.aYK = (TbImageView) view.findViewById(i.f.frs_xiaoying_frame_pic);
        this.aYL = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYM = (FrameLayout) view.findViewById(i.f.frs_xiaoying_video_container);
    }
}
