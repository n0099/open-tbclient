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
import com.baidu.tieba.t;
import com.baidu.tieba.togetherhi.PbTogetherhiAvatarList;
/* loaded from: classes.dex */
public class d extends y.a {
    public View Wx;
    public TextView aVl;
    public LinearLayout cax;
    private int ceA;
    public LinearLayout cee;
    public RelativeLayout cef;
    public HeadImageView ceg;
    public HeadPendantClickableView ceh;
    public TextView cei;
    public UserIconBox cej;
    public TextView cek;
    public View cel;
    public TextView cem;
    public TextView cen;
    public TextView ceo;
    public TextView cep;
    public TextView ceq;
    public TextView cer;
    public TextView ces;
    public PbTogetherhiAvatarList cet;
    public View ceu;
    public TextView cev;
    public TextView cew;
    public TextView cex;
    public TextView cey;
    public TextView cez;
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
        this.ceA = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - view.getResources().getDimensionPixelSize(t.e.ds162);
        this.cax = (LinearLayout) view.findViewById(t.g.frs_togetherhi_list);
        this.cee = (LinearLayout) view.findViewById(t.g.togetherhi_plan_layout);
        this.cef = (RelativeLayout) view.findViewById(t.g.pb_togetherhi_living_layout);
        this.Wx = view.findViewById(t.g.card_home_page_normal_thread_top_line);
        this.ceh = (HeadPendantClickableView) view.findViewById(t.g.frs_togetherhi_pendant_avatar);
        this.ceg = (HeadImageView) view.findViewById(t.g.frs_togetherhi_avatar);
        this.ceh.vW();
        if (this.ceh.getHeadView() != null) {
            this.ceh.getHeadView().setIsRound(true);
            this.ceh.getHeadView().setDrawBorder(false);
        }
        if (this.ceh.getPendantView() != null) {
            this.ceh.getPendantView().setIsRound(true);
            this.ceh.getPendantView().setDrawBorder(false);
        }
        this.aVl = (TextView) view.findViewById(t.g.frs_togetherhi_user_name);
        this.cei = (TextView) view.findViewById(t.g.frs_togetherhi_thread_title);
        this.cej = (UserIconBox) view.findViewById(t.g.frs_user_icon_box);
        this.cek = (TextView) view.findViewById(t.g.frs_togetherhi_thread_content);
        this.cel = view.findViewById(t.g.frs_item_location_sep);
        this.cem = (TextView) view.findViewById(t.g.frs_item_location_address);
        this.cen = (TextView) view.findViewById(t.g.togetherhi_activity_title);
        this.ceo = (TextView) view.findViewById(t.g.togetherhi_activity_location);
        this.cep = (TextView) view.findViewById(t.g.togetherhi_activity_time);
        this.ceq = (TextView) view.findViewById(t.g.togetherhi_activity_user_number);
        this.cer = (TextView) view.findViewById(t.g.togetherhi_activity_user_number_tv1);
        this.ces = (TextView) view.findViewById(t.g.togetherhi_activity_user_number_tv2);
        this.cet = (PbTogetherhiAvatarList) view.findViewById(t.g.togetherhi_avatar_list);
        this.ceu = view.findViewById(t.g.th_image_shadow);
        this.image1 = (TbImageView) view.findViewById(t.g.th_image1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams.height = this.ceA / 2;
        layoutParams.width = this.ceA / 2;
        this.image1.setLayoutParams(layoutParams);
        this.image1.setDefaultErrorResource(t.f.th_photo_bg);
        this.image2 = (TbImageView) view.findViewById(t.g.th_image2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams2.height = this.ceA / 2;
        layoutParams2.width = this.ceA / 2;
        this.image2.setLayoutParams(layoutParams2);
        this.image2.setDefaultErrorResource(t.f.th_photo_bg);
        this.image3 = (TbImageView) view.findViewById(t.g.th_image3);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams3.height = this.ceA / 2;
        layoutParams3.width = this.ceA / 2;
        this.image3.setLayoutParams(layoutParams3);
        this.image3.setDefaultErrorResource(t.f.th_photo_bg);
        this.image4 = (TbImageView) view.findViewById(t.g.th_image4);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.image1.getLayoutParams();
        layoutParams4.height = this.ceA / 2;
        layoutParams4.width = this.ceA / 2;
        this.image4.setLayoutParams(layoutParams4);
        this.image4.setDefaultErrorResource(t.f.th_photo_bg);
        this.livingTag = (TextView) view.findViewById(t.g.th_living);
        this.cev = (TextView) view.findViewById(t.g.th_title);
        this.cew = (TextView) view.findViewById(t.g.th_join_num);
        this.location = (TextView) view.findViewById(t.g.th_location);
        this.cex = (TextView) view.findViewById(t.g.frs_thread_post_time);
        this.cey = (TextView) view.findViewById(t.g.frs_thread_praise_cnt);
        this.cez = (TextView) view.findViewById(t.g.frs_thread_comment_cnt);
        view.setBackgroundResource(t.d.common_color_10022);
    }
}
