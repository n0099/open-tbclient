package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class a extends x.a {
    public TextView aOn;
    public UserIconBox agT;
    public UserIconBox agU;
    public TextView agy;
    public TextView agz;
    public int ahf;
    public LinearLayout bId;
    public LinearLayout bIe;
    public View bIf;
    public TextView bIg;
    public View bIh;
    public FrameLayout bIi;
    public LinearLayout bIj;
    public LinearLayout bIk;
    public FrsCommonImageLayout bIl;
    public View bIm;
    public TextView bcB;
    public HeadImageView bcC;
    public TextView bcG;
    public TextView bcI;
    public TextView bcy;
    public PlayVoiceBnt bcz;
    public TextView bgj;
    public View bgk;
    public TextView bhA;

    public a(View view) {
        super(view);
        this.ahf = 3;
        this.bId = (LinearLayout) view.findViewById(n.g.hot_thread_item_root);
        this.bIe = (LinearLayout) view.findViewById(n.g.hot_thread_theme_area);
        this.bIf = view.findViewById(n.g.hot_thread_theme_top_divider_line);
        this.bIg = (TextView) view.findViewById(n.g.hot_thread_theme_title);
        this.bIh = view.findViewById(n.g.hot_thread_theme_bottom_divider_line);
        this.bIi = (FrameLayout) view.findViewById(n.g.hot_thread_none_theme);
        this.bIk = (LinearLayout) view.findViewById(n.g.hot_thread_item_user_info_view);
        this.bIj = (LinearLayout) view.findViewById(n.g.hot_thread_item_top_linear_layout);
        this.bcC = (HeadImageView) view.findViewById(n.g.hot_thread_photo);
        this.agT = (UserIconBox) view.findViewById(n.g.hot_thread_user_tshow_icon_box);
        this.agU = (UserIconBox) view.findViewById(n.g.hot_thread_user_icon_box);
        this.bcB = (TextView) view.findViewById(n.g.hot_thread_lv_author);
        this.agy = (TextView) view.findViewById(n.g.hot_thread_lv_reply_time);
        this.aOn = (TextView) view.findViewById(n.g.hot_thread_lv_title);
        this.bcy = (TextView) view.findViewById(n.g.abstract_text);
        this.bcz = (PlayVoiceBnt) view.findViewById(n.g.abstract_voice);
        this.bIl = (FrsCommonImageLayout) view.findViewById(n.g.abstract_img_layout);
        this.agz = (TextView) view.findViewById(n.g.hot_thread_praise_num);
        this.bhA = (TextView) view.findViewById(n.g.action_button);
        this.bcG = (TextView) view.findViewById(n.g.hot_thread_reply_num);
        this.bcI = (TextView) view.findViewById(n.g.frs_more_abstract);
        this.bgj = (TextView) view.findViewById(n.g.hot_thread_item_location_address);
        this.bgk = view.findViewById(n.g.hot_thread_item_location_sep);
        this.bIm = view.findViewById(n.g.hot_thread_item_divider_line);
        this.bId.setBackgroundResource(n.d.transparent);
    }

    public static int VE() {
        return n.g.hot_thread_user_icon_box;
    }
}
