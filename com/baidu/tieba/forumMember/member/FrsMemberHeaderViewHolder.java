package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View headerDividerLine3;
    public View mDivider;
    public LinearLayout mExperienceView;
    public ImageView mLevelIcon;
    public TextView mLevelNameView;
    public TextView mLevelTipView;
    public ImageView mLevelTopImage;
    public ImageView mLevelTopImageBg;
    public TextView mLikeButton;
    public TextView mScoreView;
    public NoPressedLinearLayout rootForumMemberHeader;
    public TextView tipExperience;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLikeButton = (TextView) view.findViewById(R.id.like_btn);
        this.mLevelTipView = (TextView) view.findViewById(R.id.lever_tip_view);
        this.mLevelIcon = (ImageView) view.findViewById(R.id.header_level_img);
        this.mLevelNameView = (TextView) view.findViewById(R.id.user_level_name);
        this.mDivider = view.findViewById(R.id.header_divider_line2);
        this.mExperienceView = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.mScoreView = (TextView) view.findViewById(R.id.tip_experience_score);
        this.rootForumMemberHeader = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.headerDividerLine3 = view.findViewById(R.id.header_divider_line3);
        this.tipExperience = (TextView) view.findViewById(R.id.tip_experience);
        this.mLevelTopImage = (ImageView) view.findViewById(R.id.love_level_top);
        this.mLevelTopImageBg = (ImageView) view.findViewById(R.id.love_level_bg);
        this.mLikeButton.setOnClickListener(onClickListener);
        this.mLevelNameView.setOnClickListener(onClickListener);
    }
}
