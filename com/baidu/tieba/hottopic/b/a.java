package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class a extends x.a {
    public TextView aPy;
    public TextView aTl;
    public PlayVoiceBnt aTm;
    public TextView aTo;
    public TextView aTp;
    public UserIconBox aTq;
    public HeadImageView aTr;
    public TextView aTu;
    public TextView aTw;
    public TextView aTy;
    public UserIconBox aXC;
    public TextView aXD;
    public TextView aXF;
    public View aXG;
    public int arf;
    public LinearLayout bpX;
    public LinearLayout bpY;
    public View bpZ;
    public TextView bqa;
    public View bqb;
    public FrameLayout bqc;
    public LinearLayout bqd;
    public LinearLayout bqe;
    public FrsCommonImageLayout bqf;
    public View bqg;

    public a(View view) {
        super(view);
        this.arf = 3;
        this.bpX = (LinearLayout) view.findViewById(i.f.hot_thread_item_root);
        this.bpY = (LinearLayout) view.findViewById(i.f.hot_thread_theme_area);
        this.bpZ = view.findViewById(i.f.hot_thread_theme_top_divider_line);
        this.bqa = (TextView) view.findViewById(i.f.hot_thread_theme_title);
        this.bqb = view.findViewById(i.f.hot_thread_theme_bottom_divider_line);
        this.bqc = (FrameLayout) view.findViewById(i.f.hot_thread_none_theme);
        this.bqe = (LinearLayout) view.findViewById(i.f.hot_thread_item_user_info_view);
        this.bqd = (LinearLayout) view.findViewById(i.f.hot_thread_item_top_linear_layout);
        this.aTr = (HeadImageView) view.findViewById(i.f.hot_thread_photo);
        this.aTq = (UserIconBox) view.findViewById(i.f.hot_thread_user_tshow_icon_box);
        this.aXC = (UserIconBox) view.findViewById(i.f.hot_thread_user_icon_box);
        this.aTp = (TextView) view.findViewById(i.f.hot_thread_lv_author);
        this.aTo = (TextView) view.findViewById(i.f.hot_thread_lv_reply_time);
        this.aPy = (TextView) view.findViewById(i.f.hot_thread_lv_title);
        this.aTl = (TextView) view.findViewById(i.f.abstract_text);
        this.aTm = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.bqf = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTu = (TextView) view.findViewById(i.f.hot_thread_praise_num);
        this.aXD = (TextView) view.findViewById(i.f.action_button);
        this.aTw = (TextView) view.findViewById(i.f.hot_thread_reply_num);
        this.aTy = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXF = (TextView) view.findViewById(i.f.hot_thread_item_location_address);
        this.aXG = view.findViewById(i.f.hot_thread_item_location_sep);
        this.bqg = view.findViewById(i.f.hot_thread_item_divider_line);
        this.bpX.setBackgroundResource(i.c.transparent);
    }

    public static int Rq() {
        return i.f.hot_thread_user_icon_box;
    }
}
