package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
public class bf extends y.a {
    public TextView aOH;
    public UserIconBox ahW;
    public UserIconBox ahX;
    public TextView ahw;
    public TextView ahz;
    public int aiA;
    public TextView bTt;
    public TextView bTu;
    public RelativeLayout bUA;
    public LinearLayout bUB;
    public LinearLayout bUC;
    public LinearLayout bUD;
    public View bUE;
    public TbImageView bUF;
    public RelativeLayout bUG;
    public TbImageView bUH;
    public TextView bUI;
    public ThreadSkinView bUJ;
    public int bUo;
    public FrameLayout bUp;
    public LinearLayout bUq;
    public RelativeLayout bUr;
    public TbImageView bUs;
    public TextView bUt;
    public PlayVoiceBnt bUu;
    public FrsCommonImageLayout bUv;
    public TextView bUw;
    public HeadImageView bUx;
    public TextView bUy;
    public TextView bUz;

    public bf(View view, int i) {
        super(view);
        this.aiA = 3;
        this.bUo = 0;
        this.bUo = i;
        this.bUp = (FrameLayout) view.findViewById(r.g.frs_list);
        this.bUA = (RelativeLayout) view.findViewById(r.g.frs_item_user_info_view);
        this.bUB = (LinearLayout) view.findViewById(r.g.frs_item_base_user_info);
        this.bUq = (LinearLayout) view.findViewById(r.g.frs_list_item_top_linear_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bUq.getLayoutParams();
        layoutParams.topMargin = i;
        this.bUq.setLayoutParams(layoutParams);
        this.bUr = (RelativeLayout) view.findViewById(r.g.frs_list_item_top_card);
        this.bUs = (TbImageView) view.findViewById(r.g.frs_normal_item_theme_card);
        this.bUx = (HeadImageView) view.findViewById(r.g.frs_photo);
        this.ahW = (UserIconBox) view.findViewById(r.g.frs_user_tshow_icon_box);
        this.ahX = (UserIconBox) view.findViewById(r.g.frs_user_icon_box);
        this.bUw = (TextView) view.findViewById(r.g.frs_lv_author);
        this.ahw = (TextView) view.findViewById(r.g.frs_lv_reply_time);
        this.aOH = (TextView) view.findViewById(r.g.frs_lv_title);
        this.bUt = (TextView) view.findViewById(r.g.abstract_text);
        this.bUu = (PlayVoiceBnt) view.findViewById(r.g.abstract_voice);
        this.bUv = (FrsCommonImageLayout) view.findViewById(r.g.abstract_img_layout);
        this.ahz = (TextView) view.findViewById(r.g.frs_praise_num);
        this.bUy = (TextView) view.findViewById(r.g.action_button);
        this.bTu = (TextView) view.findViewById(r.g.frs_reply_num);
        this.bUz = (TextView) view.findViewById(r.g.frs_more_abstract);
        this.bUC = (LinearLayout) view.findViewById(r.g.frs_item_num);
        this.bUD = (LinearLayout) view.findViewById(r.g.frs_item_loc_view);
        this.bTt = (TextView) view.findViewById(r.g.frs_item_location_address);
        this.bUE = view.findViewById(r.g.frs_item_location_sep);
        this.bUF = (TbImageView) view.findViewById(r.g.game_activity_banner);
        this.bUH = (TbImageView) view.findViewById(r.g.app_code_banner);
        this.bUI = (TextView) view.findViewById(r.g.app_code_btn);
        this.bUG = (RelativeLayout) view.findViewById(r.g.app_code_wrapper);
        this.bUJ = (ThreadSkinView) view.findViewById(r.g.frs_thread_skin);
    }
}
