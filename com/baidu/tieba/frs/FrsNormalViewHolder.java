package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.t0.d1.f1;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsNormalViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView abstractTextView;
    public TextView locationAddress;
    public View locationSepView;
    public TextView mActionButton;
    public TbImageView mAppCodeBanner;
    public TextView mAppCodeBtn;
    public RelativeLayout mAppCodeWrapper;
    public TextView mAuthor;
    public LinearLayout mBaseUserInfoView;
    public TbImageView mGameBanner;
    public ImageView mIdentityView;
    public FrameLayout mListItem;
    public LinearLayout mLocView;
    public TextView mMoreAbtract;
    public LinearLayout mNumView;
    public HeadImageView mPhoto;
    public TextView mPraiseNum;
    public TextView mReplyNum;
    public TextView mReplyTime;
    public FrsCommonImageLayout mSeg;
    public ThreadSkinView mSkinView;
    public UserIconBox mTShowIcon;
    public TbImageView mThemeCardView;
    public TextView mTitle;
    public RelativeLayout mTopCard;
    public LinearLayout mTopLayout;
    public UserIconBox mUserIcon;
    public RelativeLayout mUserView;
    public PlayVoiceBnt mVoice;
    public int skinType;
    public int topMaggin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsNormalViewHolder(View view, int i2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.skinType = 3;
        this.topMaggin = 0;
        this.topMaggin = i2;
        this.mListItem = (FrameLayout) view.findViewById(f1.frs_list);
        this.mUserView = (RelativeLayout) view.findViewById(f1.frs_item_user_info_view);
        this.mBaseUserInfoView = (LinearLayout) view.findViewById(f1.frs_item_base_user_info);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(f1.frs_list_item_top_linear_layout);
        this.mTopLayout = linearLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.topMargin = i2;
        this.mTopLayout.setLayoutParams(layoutParams);
        this.mTopCard = (RelativeLayout) view.findViewById(f1.frs_list_item_top_card);
        this.mThemeCardView = (TbImageView) view.findViewById(f1.frs_normal_item_theme_card);
        this.mPhoto = (HeadImageView) view.findViewById(f1.frs_photo);
        this.mTShowIcon = (UserIconBox) view.findViewById(f1.frs_user_tshow_icon_box);
        this.mUserIcon = (UserIconBox) view.findViewById(f1.frs_user_icon_box);
        this.mAuthor = (TextView) view.findViewById(f1.frs_lv_author);
        this.mIdentityView = (ImageView) view.findViewById(f1.identity_view);
        this.mReplyTime = (TextView) view.findViewById(f1.frs_lv_reply_time);
        this.mTitle = (TextView) view.findViewById(f1.frs_lv_title);
        this.abstractTextView = (TextView) view.findViewById(f1.abstract_text);
        this.mVoice = (PlayVoiceBnt) view.findViewById(f1.abstract_voice);
        this.mSeg = (FrsCommonImageLayout) view.findViewById(f1.abstract_img_layout);
        this.mPraiseNum = (TextView) view.findViewById(f1.frs_praise_num);
        this.mActionButton = (TextView) view.findViewById(f1.action_button);
        this.mReplyNum = (TextView) view.findViewById(f1.frs_reply_num);
        this.mMoreAbtract = (TextView) view.findViewById(f1.frs_more_abstract);
        this.mNumView = (LinearLayout) view.findViewById(f1.frs_item_num);
        this.mLocView = (LinearLayout) view.findViewById(f1.frs_item_loc_view);
        this.locationAddress = (TextView) view.findViewById(f1.frs_item_location_address);
        this.locationSepView = view.findViewById(f1.frs_item_location_sep);
        this.mGameBanner = (TbImageView) view.findViewById(f1.game_activity_banner);
        this.mAppCodeBanner = (TbImageView) view.findViewById(f1.app_code_banner);
        this.mAppCodeBtn = (TextView) view.findViewById(f1.app_code_btn);
        this.mAppCodeWrapper = (RelativeLayout) view.findViewById(f1.app_code_wrapper);
        this.mSkinView = (ThreadSkinView) view.findViewById(f1.frs_thread_skin);
    }
}
