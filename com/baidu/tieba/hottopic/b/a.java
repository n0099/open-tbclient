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
    public TextView aUB;
    public PlayVoiceBnt aYA;
    public TextView aYC;
    public TextView aYD;
    public UserIconBox aYE;
    public HeadImageView aYF;
    public TextView aYI;
    public TextView aYK;
    public TextView aYM;
    public TextView aYz;
    public int afY;
    public LinearLayout bEA;
    public View bEB;
    public TextView bEC;
    public View bED;
    public FrameLayout bEE;
    public LinearLayout bEF;
    public LinearLayout bEG;
    public FrsCommonImageLayout bEH;
    public View bEI;
    public LinearLayout bEz;
    public TextView bck;
    public View bcl;
    public UserIconBox bdA;
    public TextView bdB;

    public a(View view) {
        super(view);
        this.afY = 3;
        this.bEz = (LinearLayout) view.findViewById(n.f.hot_thread_item_root);
        this.bEA = (LinearLayout) view.findViewById(n.f.hot_thread_theme_area);
        this.bEB = view.findViewById(n.f.hot_thread_theme_top_divider_line);
        this.bEC = (TextView) view.findViewById(n.f.hot_thread_theme_title);
        this.bED = view.findViewById(n.f.hot_thread_theme_bottom_divider_line);
        this.bEE = (FrameLayout) view.findViewById(n.f.hot_thread_none_theme);
        this.bEG = (LinearLayout) view.findViewById(n.f.hot_thread_item_user_info_view);
        this.bEF = (LinearLayout) view.findViewById(n.f.hot_thread_item_top_linear_layout);
        this.aYF = (HeadImageView) view.findViewById(n.f.hot_thread_photo);
        this.aYE = (UserIconBox) view.findViewById(n.f.hot_thread_user_tshow_icon_box);
        this.bdA = (UserIconBox) view.findViewById(n.f.hot_thread_user_icon_box);
        this.aYD = (TextView) view.findViewById(n.f.hot_thread_lv_author);
        this.aYC = (TextView) view.findViewById(n.f.hot_thread_lv_reply_time);
        this.aUB = (TextView) view.findViewById(n.f.hot_thread_lv_title);
        this.aYz = (TextView) view.findViewById(n.f.abstract_text);
        this.aYA = (PlayVoiceBnt) view.findViewById(n.f.abstract_voice);
        this.bEH = (FrsCommonImageLayout) view.findViewById(n.f.abstract_img_layout);
        this.aYI = (TextView) view.findViewById(n.f.hot_thread_praise_num);
        this.bdB = (TextView) view.findViewById(n.f.action_button);
        this.aYK = (TextView) view.findViewById(n.f.hot_thread_reply_num);
        this.aYM = (TextView) view.findViewById(n.f.frs_more_abstract);
        this.bck = (TextView) view.findViewById(n.f.hot_thread_item_location_address);
        this.bcl = view.findViewById(n.f.hot_thread_item_location_sep);
        this.bEI = view.findViewById(n.f.hot_thread_item_divider_line);
        this.bEz.setBackgroundResource(n.c.transparent);
    }

    public static int UB() {
        return n.f.hot_thread_user_icon_box;
    }
}
