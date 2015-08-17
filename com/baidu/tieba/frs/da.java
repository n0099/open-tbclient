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
public class da extends x.a {
    public TextView aPV;
    public LinearLayout aTH;
    public TextView aTL;
    public UserIconBox aTN;
    public HeadImageView aTO;
    public TextView aTR;
    public TextView aTT;
    public LinearLayout aXS;
    public UserIconBox aXT;
    public TextView aYA;
    public TextView aYB;
    public TextView aYC;
    public View aYD;
    public TbImageView aYE;
    public LinearLayout aYF;
    public FrameLayout aYG;

    public da(View view) {
        super(view);
        this.aTH = (LinearLayout) view.findViewById(i.f.frs_xiaoying_top_container);
        this.aXS = (LinearLayout) view.findViewById(i.f.new_year_color_egg);
        this.aTO = (HeadImageView) view.findViewById(i.f.frs_xiaoying_user_head);
        this.aTN = (UserIconBox) view.findViewById(i.f.frs_xiaoying_tshow_icon_box);
        this.aXT = (UserIconBox) view.findViewById(i.f.frs_xiaoying_user_icon_box);
        this.aYA = (TextView) view.findViewById(i.f.frs_xiaoying_user_name);
        this.aTL = (TextView) view.findViewById(i.f.frs_xiaoying_reply_time);
        this.aPV = (TextView) view.findViewById(i.f.frs_xiaoying_title);
        this.aYB = (TextView) view.findViewById(i.f.frs_xiaoying_abstract_text);
        this.aYC = (TextView) view.findViewById(i.f.frs_xiaoying_location_address);
        this.aYD = view.findViewById(i.f.frs_xiaoying_location_divider);
        this.aTR = (TextView) view.findViewById(i.f.frs_xiaoying_praise_num);
        this.aTT = (TextView) view.findViewById(i.f.frs_xiaoying_reply_num);
        this.aYE = (TbImageView) view.findViewById(i.f.frs_xiaoying_frame_pic);
        this.aYF = (LinearLayout) view.findViewById(i.f.frs_item_user_info_view);
        this.aYG = (FrameLayout) view.findViewById(i.f.frs_xiaoying_video_container);
    }
}
