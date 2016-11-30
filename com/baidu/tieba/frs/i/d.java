package com.baidu.tieba.frs.i;

import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.togetherhi.PbTogetherhiAvatarList;
/* loaded from: classes.dex */
public class d extends y.a {
    public View Xf;
    public TextView aYg;
    public LinearLayout cdW;
    public TextView ciA;
    private int ciB;
    public LinearLayout cif;
    public RelativeLayout cig;
    public HeadImageView cih;
    public HeadPendantClickableView cii;
    public TextView cij;
    public UserIconBox cik;
    public TextView cil;
    public View cim;
    public TextView cin;
    public TextView cio;
    public TextView cip;
    public TextView ciq;
    public TextView cir;
    public TextView cis;
    public TextView cit;
    public PbTogetherhiAvatarList ciu;
    public View civ;
    public TextView ciw;
    public TextView cix;
    public TextView ciy;
    public TextView ciz;
    public TbImageView image1;
    public TbImageView image2;
    public TbImageView image3;
    public TbImageView image4;
    public TextView livingTag;
    public TextView location;
    public int mSkinType;

    public d(View view) {
        super(view);
        this.mSkinType = 3;
        this.ciB = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(r.e.ds162);
        this.cdW = (LinearLayout) view.findViewById(r.g.frs_togetherhi_list);
        this.cif = (LinearLayout) view.findViewById(r.g.togetherhi_plan_layout);
        this.cig = (RelativeLayout) view.findViewById(r.g.pb_togetherhi_living_layout);
        this.Xf = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.cii = (HeadPendantClickableView) view.findViewById(r.g.frs_togetherhi_pendant_avatar);
        this.cih = (HeadImageView) view.findViewById(r.g.frs_togetherhi_avatar);
        this.cii.wo();
        if (this.cii.getHeadView() != null) {
            this.cii.getHeadView().setIsRound(true);
            this.cii.getHeadView().setDrawBorder(false);
        }
        if (this.cii.getPendantView() != null) {
            this.cii.getPendantView().setIsRound(true);
            this.cii.getPendantView().setDrawBorder(false);
        }
        this.aYg = (TextView) view.findViewById(r.g.frs_togetherhi_user_name);
        this.cij = (TextView) view.findViewById(r.g.frs_togetherhi_thread_title);
        this.cik = (UserIconBox) view.findViewById(r.g.frs_user_icon_box);
        this.cil = (TextView) view.findViewById(r.g.frs_togetherhi_thread_content);
        this.cim = view.findViewById(r.g.frs_item_location_sep);
        this.cin = (TextView) view.findViewById(r.g.frs_item_location_address);
        this.cio = (TextView) view.findViewById(r.g.togetherhi_activity_title);
        this.cip = (TextView) view.findViewById(r.g.togetherhi_activity_location);
        this.ciq = (TextView) view.findViewById(r.g.togetherhi_activity_time);
        this.cir = (TextView) view.findViewById(r.g.togetherhi_activity_user_number);
        this.cis = (TextView) view.findViewById(r.g.togetherhi_activity_user_number_tv1);
        this.cit = (TextView) view.findViewById(r.g.togetherhi_activity_user_number_tv2);
        this.ciu = (PbTogetherhiAvatarList) view.findViewById(r.g.togetherhi_avatar_list);
        this.civ = view.findViewById(r.g.th_image_shadow);
        this.image1 = (TbImageView) view.findViewById(r.g.th_image1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams.height = this.ciB / 2;
        layoutParams.width = this.ciB / 2;
        this.image1.setLayoutParams(layoutParams);
        this.image1.setDefaultErrorResource(r.f.th_photo_bg);
        this.image2 = (TbImageView) view.findViewById(r.g.th_image2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams2.height = this.ciB / 2;
        layoutParams2.width = this.ciB / 2;
        this.image2.setLayoutParams(layoutParams2);
        this.image2.setDefaultErrorResource(r.f.th_photo_bg);
        this.image3 = (TbImageView) view.findViewById(r.g.th_image3);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams3.height = this.ciB / 2;
        layoutParams3.width = this.ciB / 2;
        this.image3.setLayoutParams(layoutParams3);
        this.image3.setDefaultErrorResource(r.f.th_photo_bg);
        this.image4 = (TbImageView) view.findViewById(r.g.th_image4);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams4.height = this.ciB / 2;
        layoutParams4.width = this.ciB / 2;
        this.image4.setLayoutParams(layoutParams4);
        this.image4.setDefaultErrorResource(r.f.th_photo_bg);
        this.livingTag = (TextView) view.findViewById(r.g.th_living);
        this.ciw = (TextView) view.findViewById(r.g.th_title);
        this.cix = (TextView) view.findViewById(r.g.th_join_num);
        this.location = (TextView) view.findViewById(r.g.th_location);
        this.ciy = (TextView) view.findViewById(r.g.frs_thread_post_time);
        this.ciz = (TextView) view.findViewById(r.g.frs_thread_praise_cnt);
        this.ciA = (TextView) view.findViewById(r.g.frs_thread_comment_cnt);
        view.setBackgroundResource(r.d.common_color_10022);
    }
}
