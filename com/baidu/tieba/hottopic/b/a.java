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
    public TextView aPf;
    public TextView aSS;
    public PlayVoiceBnt aST;
    public TextView aSV;
    public TextView aSW;
    public UserIconBox aSX;
    public HeadImageView aSY;
    public TextView aTb;
    public TextView aTd;
    public TextView aTf;
    public UserIconBox aXi;
    public TextView aXj;
    public TextView aXl;
    public View aXm;
    public int apR;
    public LinearLayout bpi;
    public LinearLayout bpj;
    public View bpk;
    public TextView bpl;
    public View bpm;
    public FrameLayout bpn;
    public LinearLayout bpo;
    public LinearLayout bpp;
    public FrsCommonImageLayout bpq;
    public View bpr;

    public a(View view) {
        super(view);
        this.apR = 3;
        this.bpi = (LinearLayout) view.findViewById(i.f.hot_thread_item_root);
        this.bpj = (LinearLayout) view.findViewById(i.f.hot_thread_theme_area);
        this.bpk = view.findViewById(i.f.hot_thread_theme_top_divider_line);
        this.bpl = (TextView) view.findViewById(i.f.hot_thread_theme_title);
        this.bpm = view.findViewById(i.f.hot_thread_theme_bottom_divider_line);
        this.bpn = (FrameLayout) view.findViewById(i.f.hot_thread_none_theme);
        this.bpp = (LinearLayout) view.findViewById(i.f.hot_thread_item_user_info_view);
        this.bpo = (LinearLayout) view.findViewById(i.f.hot_thread_item_top_linear_layout);
        this.aSY = (HeadImageView) view.findViewById(i.f.hot_thread_photo);
        this.aSX = (UserIconBox) view.findViewById(i.f.hot_thread_user_tshow_icon_box);
        this.aXi = (UserIconBox) view.findViewById(i.f.hot_thread_user_icon_box);
        this.aSW = (TextView) view.findViewById(i.f.hot_thread_lv_author);
        this.aSV = (TextView) view.findViewById(i.f.hot_thread_lv_reply_time);
        this.aPf = (TextView) view.findViewById(i.f.hot_thread_lv_title);
        this.aSS = (TextView) view.findViewById(i.f.abstract_text);
        this.aST = (PlayVoiceBnt) view.findViewById(i.f.abstract_voice);
        this.bpq = (FrsCommonImageLayout) view.findViewById(i.f.abstract_img_layout);
        this.aTb = (TextView) view.findViewById(i.f.hot_thread_praise_num);
        this.aXj = (TextView) view.findViewById(i.f.action_button);
        this.aTd = (TextView) view.findViewById(i.f.hot_thread_reply_num);
        this.aTf = (TextView) view.findViewById(i.f.frs_more_abstract);
        this.aXl = (TextView) view.findViewById(i.f.hot_thread_item_location_address);
        this.aXm = view.findViewById(i.f.hot_thread_item_location_sep);
        this.bpr = view.findViewById(i.f.hot_thread_item_divider_line);
        this.bpi.setBackgroundResource(i.c.transparent);
    }

    public static int QY() {
        return i.f.hot_thread_user_icon_box;
    }
}
