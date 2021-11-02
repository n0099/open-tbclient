package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.r0.j1.b;
import b.a.r0.j1.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotThreadItemHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView abstractTextView;
    public LinearLayout hotThreadItemRoot;
    public FrameLayout hotThreadNoneThemeArea;
    public View hotThreadThemeBottomDivilerLine;
    public TextView hotThreadThemeTitle;
    public View hotThreadThemeTopDivilerLine;
    public LinearLayout hotThreadTopLayout;
    public LinearLayout hot_thread_theme_area;
    public View itemDivilerLine;
    public TextView locationAddress;
    public View locationSepView;
    public TextView mActionButton;
    public TextView mAuthor;
    public FrsCommonImageLayout mImageLayout;
    public TextView mMoreAbtract;
    public HeadImageView mPhoto;
    public TextView mPraiseNum;
    public TextView mReplyNum;
    public TextView mReplyTime;
    public UserIconBox mTShowIcon;
    public TextView mTitle;
    public UserIconBox mUserIcon;
    public LinearLayout mUserLayout;
    public PlayVoiceBnt mVoice;
    public int skinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotThreadItemHolder(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.skinType = 3;
        this.hotThreadItemRoot = (LinearLayout) view.findViewById(e.hot_thread_item_root);
        this.hot_thread_theme_area = (LinearLayout) view.findViewById(e.hot_thread_theme_area);
        this.hotThreadThemeTopDivilerLine = view.findViewById(e.hot_thread_theme_top_divider_line);
        this.hotThreadThemeTitle = (TextView) view.findViewById(e.hot_thread_theme_title);
        this.hotThreadThemeBottomDivilerLine = view.findViewById(e.hot_thread_theme_bottom_divider_line);
        this.hotThreadNoneThemeArea = (FrameLayout) view.findViewById(e.hot_thread_none_theme);
        this.mUserLayout = (LinearLayout) view.findViewById(e.hot_thread_item_user_info_view);
        this.hotThreadTopLayout = (LinearLayout) view.findViewById(e.hot_thread_item_top_linear_layout);
        this.mPhoto = (HeadImageView) view.findViewById(e.hot_thread_photo);
        this.mTShowIcon = (UserIconBox) view.findViewById(e.hot_thread_user_tshow_icon_box);
        this.mUserIcon = (UserIconBox) view.findViewById(e.hot_thread_user_icon_box);
        this.mAuthor = (TextView) view.findViewById(e.hot_thread_lv_author);
        this.mReplyTime = (TextView) view.findViewById(e.hot_thread_lv_reply_time);
        this.mTitle = (TextView) view.findViewById(e.hot_thread_lv_title);
        this.abstractTextView = (TextView) view.findViewById(e.abstract_text);
        this.mVoice = (PlayVoiceBnt) view.findViewById(e.abstract_voice);
        this.mImageLayout = (FrsCommonImageLayout) view.findViewById(e.abstract_img_layout);
        this.mPraiseNum = (TextView) view.findViewById(e.hot_thread_praise_num);
        this.mActionButton = (TextView) view.findViewById(e.action_button);
        this.mReplyNum = (TextView) view.findViewById(e.hot_thread_reply_num);
        this.mMoreAbtract = (TextView) view.findViewById(e.frs_more_abstract);
        this.locationAddress = (TextView) view.findViewById(e.hot_thread_item_location_address);
        this.locationSepView = view.findViewById(e.hot_thread_item_location_sep);
        this.itemDivilerLine = view.findViewById(e.hot_thread_item_divider_line);
        this.hotThreadItemRoot.setBackgroundResource(b.transparent);
    }

    public static int getUserIconId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? e.hot_thread_user_icon_box : invokeV.intValue;
    }
}
