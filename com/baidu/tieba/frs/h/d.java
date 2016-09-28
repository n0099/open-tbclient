package com.baidu.tieba.frs.h;

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
    public View WH;
    public TextView aVU;
    public LinearLayout caz;
    public LinearLayout ced;
    public RelativeLayout cee;
    public HeadImageView cef;
    public HeadPendantClickableView ceg;
    public TextView ceh;
    public UserIconBox cei;
    public TextView cej;
    public View cek;
    public TextView cel;
    public TextView cem;
    public TextView cen;
    public TextView ceo;
    public TextView cep;
    public TextView ceq;
    public TextView cer;
    public PbTogetherhiAvatarList ces;
    public View cet;
    public TextView ceu;
    public TextView cev;
    public TextView cew;
    public TextView cex;
    public TextView cey;
    private int cez;
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
        this.cez = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(r.e.ds162);
        this.caz = (LinearLayout) view.findViewById(r.g.frs_togetherhi_list);
        this.ced = (LinearLayout) view.findViewById(r.g.togetherhi_plan_layout);
        this.cee = (RelativeLayout) view.findViewById(r.g.pb_togetherhi_living_layout);
        this.WH = view.findViewById(r.g.card_home_page_normal_thread_top_line);
        this.ceg = (HeadPendantClickableView) view.findViewById(r.g.frs_togetherhi_pendant_avatar);
        this.cef = (HeadImageView) view.findViewById(r.g.frs_togetherhi_avatar);
        this.ceg.wk();
        if (this.ceg.getHeadView() != null) {
            this.ceg.getHeadView().setIsRound(true);
            this.ceg.getHeadView().setDrawBorder(false);
        }
        if (this.ceg.getPendantView() != null) {
            this.ceg.getPendantView().setIsRound(true);
            this.ceg.getPendantView().setDrawBorder(false);
        }
        this.aVU = (TextView) view.findViewById(r.g.frs_togetherhi_user_name);
        this.ceh = (TextView) view.findViewById(r.g.frs_togetherhi_thread_title);
        this.cei = (UserIconBox) view.findViewById(r.g.frs_user_icon_box);
        this.cej = (TextView) view.findViewById(r.g.frs_togetherhi_thread_content);
        this.cek = view.findViewById(r.g.frs_item_location_sep);
        this.cel = (TextView) view.findViewById(r.g.frs_item_location_address);
        this.cem = (TextView) view.findViewById(r.g.togetherhi_activity_title);
        this.cen = (TextView) view.findViewById(r.g.togetherhi_activity_location);
        this.ceo = (TextView) view.findViewById(r.g.togetherhi_activity_time);
        this.cep = (TextView) view.findViewById(r.g.togetherhi_activity_user_number);
        this.ceq = (TextView) view.findViewById(r.g.togetherhi_activity_user_number_tv1);
        this.cer = (TextView) view.findViewById(r.g.togetherhi_activity_user_number_tv2);
        this.ces = (PbTogetherhiAvatarList) view.findViewById(r.g.togetherhi_avatar_list);
        this.cet = view.findViewById(r.g.th_image_shadow);
        this.image1 = (TbImageView) view.findViewById(r.g.th_image1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams.height = this.cez / 2;
        layoutParams.width = this.cez / 2;
        this.image1.setLayoutParams(layoutParams);
        this.image1.setDefaultErrorResource(r.f.th_photo_bg);
        this.image2 = (TbImageView) view.findViewById(r.g.th_image2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams2.height = this.cez / 2;
        layoutParams2.width = this.cez / 2;
        this.image2.setLayoutParams(layoutParams2);
        this.image2.setDefaultErrorResource(r.f.th_photo_bg);
        this.image3 = (TbImageView) view.findViewById(r.g.th_image3);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams3.height = this.cez / 2;
        layoutParams3.width = this.cez / 2;
        this.image3.setLayoutParams(layoutParams3);
        this.image3.setDefaultErrorResource(r.f.th_photo_bg);
        this.image4 = (TbImageView) view.findViewById(r.g.th_image4);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams4.height = this.cez / 2;
        layoutParams4.width = this.cez / 2;
        this.image4.setLayoutParams(layoutParams4);
        this.image4.setDefaultErrorResource(r.f.th_photo_bg);
        this.livingTag = (TextView) view.findViewById(r.g.th_living);
        this.ceu = (TextView) view.findViewById(r.g.th_title);
        this.cev = (TextView) view.findViewById(r.g.th_join_num);
        this.location = (TextView) view.findViewById(r.g.th_location);
        this.cew = (TextView) view.findViewById(r.g.frs_thread_post_time);
        this.cex = (TextView) view.findViewById(r.g.frs_thread_praise_cnt);
        this.cey = (TextView) view.findViewById(r.g.frs_thread_comment_cnt);
        view.setBackgroundResource(r.d.common_color_10022);
    }
}
