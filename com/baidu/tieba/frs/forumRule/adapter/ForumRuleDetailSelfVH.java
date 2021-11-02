package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.u.c;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.h1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f48512a;

    /* renamed from: b  reason: collision with root package name */
    public final int f48513b;
    public TextView mBjhAuthorAuth;
    public EMTextView mCheckStatus;
    public TBSpecificationBtn mEditStatusBtn;
    public HeadImageView mHeadView;
    public EMTextView mPreface;
    public LinearLayout mPrefaceLayout;
    public EMTextView mPrefaceTitle;
    public TextView mTime;
    public ImageView mUserForumLevel;
    public TextView mUserIdentity;
    public TextView mUserName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailSelfVH(View view) {
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
        this.f48513b = l.g(TbadkCoreApplication.getInst(), c1.tbds6);
        this.f48512a = view;
        initView(view);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void initView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            HeadImageView headImageView = (HeadImageView) view.findViewById(e1.forum_rules_head_view_info_item);
            this.mHeadView = headImageView;
            headImageView.setRadius(c1.tbds47);
            this.mHeadView.setConrers(15);
            this.mUserName = (TextView) view.findViewById(e1.forum_rules_user_name_info_item);
            this.mUserIdentity = (TextView) view.findViewById(e1.forum_rules_user_identity_info_item);
            this.mUserForumLevel = (ImageView) view.findViewById(e1.forum_rules_user_forum_level_info_item);
            this.mBjhAuthorAuth = (TextView) view.findViewById(e1.forum_rules_bjh_author_auth_info_item);
            this.mTime = (TextView) view.findViewById(e1.forum_rules_revise);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(e1.forum_rules_edit_status);
            this.mEditStatusBtn = tBSpecificationBtn;
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(h1.forum_rules_compile));
            EMTextView eMTextView = (EMTextView) view.findViewById(e1.forum_rules_check_status);
            this.mCheckStatus = eMTextView;
            eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(h1.forum_rules_review));
            this.mPrefaceLayout = (LinearLayout) view.findViewById(e1.forum_rules_preface_layout);
            this.mPrefaceTitle = (EMTextView) view.findViewById(e1.forum_rules_preface_title);
            this.mPreface = (EMTextView) view.findViewById(e1.forum_rules_preface);
        }
    }

    public void onChangeBjhAuthorAuthSkinType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String string = TbadkApplication.getInst().getString(h1.forum_rules_forum);
            if (!StringUtils.isNull(str)) {
                this.mBjhAuthorAuth.setVisibility(0);
                TextView textView = this.mBjhAuthorAuth;
                textView.setText(str + string);
                return;
            }
            this.mBjhAuthorAuth.setVisibility(8);
        }
    }

    public void onChangeForumLevelSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 <= 0) {
            return;
        }
        SkinManager.setImageResource(this.mUserForumLevel, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public void onChangePrefaceSkinType(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.mPreface == null || this.mPrefaceLayout == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.mPrefaceLayout.setVisibility(8);
            return;
        }
        this.mPreface.setText(str);
        this.mPrefaceLayout.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c d2 = c.d(this.mUserName);
            d2.A(h1.F_X01);
            d2.v(b1.CAM_X0105);
            c d3 = c.d(this.mTime);
            d3.A(h1.F_X01);
            d3.v(b1.CAM_X0109);
            c d4 = c.d(this.mCheckStatus);
            d4.A(h1.F_X01);
            d4.v(b1.CAM_X0107);
            c.d(this.mPreface).v(b1.CAM_X0105);
            c d5 = c.d(this.mPrefaceTitle);
            d5.A(h1.F_X02);
            d5.v(b1.CAM_X0105);
            SkinManager.setViewTextColor(this.mBjhAuthorAuth, b1.CAM_X0109);
            this.mHeadView.setSkinType(i2);
            this.mEditStatusBtn.setTextSize(c1.T_X08);
        }
    }

    public void onChangeStatusSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 1) {
                this.mEditStatusBtn.setVisibility(8);
                this.mCheckStatus.setVisibility(0);
                return;
            }
            this.mCheckStatus.setVisibility(8);
            this.mEditStatusBtn.setVisibility(0);
        }
    }

    public void onChangeTimeSkinType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.mTime.setText(timeStamp2Date(str));
            } else {
                this.mTime.setVisibility(8);
            }
        }
    }

    public void onChangeUserIdentitySkinType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.f48513b);
                int i2 = b1.CAM_X0303;
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i2, i2).build(), DrawableSelector.make().setShape(0).radius(this.f48513b).defaultColor("#4D000000").build()});
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (layerDrawable.getDrawable(1) != null) {
                        layerDrawable.getDrawable(1).setAlpha(255);
                    }
                } else if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(0);
                }
                this.mUserIdentity.setBackgroundDrawable(layerDrawable);
                SkinManager.setViewTextColor(this.mUserIdentity, b1.CAM_X0101);
            }
        }
    }

    public String timeStamp2Date(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}
