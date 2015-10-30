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
    public TextView aPq;
    public TextView aTd;
    public PlayVoiceBnt aTe;
    public TextView aTg;
    public TextView aTh;
    public UserIconBox aTi;
    public HeadImageView aTj;
    public TextView aTm;
    public TextView aTo;
    public TextView aTq;
    public UserIconBox aXt;
    public TextView aXu;
    public TextView aXw;
    public View aXx;
    public int apS;
    public LinearLayout bpA;
    public FrsCommonImageLayout bpB;
    public View bpC;
    public LinearLayout bpt;
    public LinearLayout bpu;
    public View bpv;
    public TextView bpw;
    public View bpx;
    public FrameLayout bpy;
    public LinearLayout bpz;

    public a(View view) {
        super(view);
        this.apS = 3;
        this.bpt = (LinearLayout) view.findViewById(i.f.hot_thread_item_root);
        this.bpu = (LinearLayout) view.findViewById(i.f.hot_thread_theme_area);
        this.bpv = view.findViewById(i.f.hot_thread_theme_top_divider_line);
        this.bpw = (TextView) view.findViewById(i.f.hot_thread_theme_title);
        this.bpx = view.findViewById(i.f.hot_thread_theme_bottom_divider_line);
        this.bpy = (FrameLayout) view.findViewById(i.f.hot_thread_none_theme);
        this.bpA = (LinearLayout) view.findViewById(i.f.hot_thread_item_user_info_view);
        this.bpz = (LinearLayout) view.findViewById(i.f.hot_thread_item_top_linear_layout);
        this.aTj = (HeadImageView) view.findViewById(i.f.hot_thread_photo);
        this.aTi = (UserIconBox) view.findViewById(i.f.hot_thread_user_tshow_icon_box);
        this.aXt = (UserIconBox) view.findViewById(i.f.hot_thread_user_icon_box);
        this.aTh = (TextView) view.findViewById(i.f.hot_thread_lv_author);
        this.aTg = (TextView) view.findViewById(i.f.hot_thread_lv_reply_time);
        this.aPq = (TextView) view.findViewById(i.f.hot_thread_lv_title);
        this.aTd = (TextView) view.findViewById(i.f.abstract_text);
        this.aTe = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.bpB = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTm = (TextView) view.findViewById(i.f.hot_thread_praise_num);
        this.aXu = (TextView) view.findViewById(i.f.action_button);
        this.aTo = (TextView) view.findViewById(i.f.hot_thread_reply_num);
        this.aTq = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXw = (TextView) view.findViewById(i.f.hot_thread_item_location_address);
        this.aXx = view.findViewById(i.f.hot_thread_item_location_sep);
        this.bpC = view.findViewById(i.f.hot_thread_item_divider_line);
        this.bpt.setBackgroundResource(i.c.transparent);
    }

    public static int QU() {
        return i.f.hot_thread_user_icon_box;
    }
}
