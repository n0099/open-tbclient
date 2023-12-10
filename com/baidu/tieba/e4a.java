package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes5.dex */
public final class e4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(aw9 aw9Var, boolean z, boolean z2, ImageView mThreadTypeStampTopPart) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{aw9Var, Boolean.valueOf(z), Boolean.valueOf(z2), mThreadTypeStampTopPart}) == null) {
            Intrinsics.checkNotNullParameter(mThreadTypeStampTopPart, "mThreadTypeStampTopPart");
            if (aw9Var != null && aw9Var.j) {
                mThreadTypeStampTopPart.setImageResource(R.drawable.pic_frs_headlines_n);
                mThreadTypeStampTopPart.setVisibility(0);
                d(mThreadTypeStampTopPart);
            } else if (z && z2) {
                mThreadTypeStampTopPart.setImageResource(R.drawable.obfuscated_res_0x7f081277);
                mThreadTypeStampTopPart.setVisibility(0);
                d(mThreadTypeStampTopPart);
            } else if (z) {
                mThreadTypeStampTopPart.setImageResource(R.drawable.obfuscated_res_0x7f081275);
                mThreadTypeStampTopPart.setVisibility(0);
                d(mThreadTypeStampTopPart);
            } else if (z2) {
                mThreadTypeStampTopPart.setImageResource(R.drawable.obfuscated_res_0x7f081276);
                mThreadTypeStampTopPart.setVisibility(0);
                d(mThreadTypeStampTopPart);
            } else {
                mThreadTypeStampTopPart.setVisibility(8);
            }
        }
    }

    public static final String b(nwa nwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nwaVar)) == null) {
            if (nwaVar != null && nwaVar.u() != null) {
                return nwaVar.u().getIpAddress();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static final void k(TBLottieAnimationView mPbHeadLivingLottie) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, mPbHeadLivingLottie) == null) {
            Intrinsics.checkNotNullParameter(mPbHeadLivingLottie, "$mPbHeadLivingLottie");
            mPbHeadLivingLottie.playAnimation();
        }
    }

    public static final void c(MetaData author, PbFragment mPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, author, mPbFragment) == null) {
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            String userId = author.getUserId();
            String userName = author.getUserName();
            if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(userName)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(mPbFragment.getContext(), userId, userName)));
            }
        }
    }

    public static final void d(final View model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            model.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.s3a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        e4a.e(model, valueAnimator);
                    }
                }
            });
            ofInt.start();
        }
    }

    public static final void e(View model, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, model, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(model, "$model");
            model.setAlpha(valueAnimator.getAnimatedFraction());
        }
    }

    public static final void f(aw9 aw9Var, ColumnLayout mPbHeadOwnerRoot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aw9Var, mPbHeadOwnerRoot) == null) {
            Intrinsics.checkNotNullParameter(mPbHeadOwnerRoot, "mPbHeadOwnerRoot");
            if (aw9Var != null && aw9Var.y0()) {
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703e0);
                int paddingBottom = mPbHeadOwnerRoot.getPaddingBottom();
                if (aw9Var.a()) {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                mPbHeadOwnerRoot.setPadding(mPbHeadOwnerRoot.getPaddingLeft(), dimens, mPbHeadOwnerRoot.getPaddingRight(), paddingBottom);
                return;
            }
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = mPbHeadOwnerRoot.getPaddingBottom();
            if (aw9Var != null && !aw9Var.R().isVideoThreadType() && aw9Var.a() && (!StringUtils.isNull(aw9Var.R().getTitle()) || aw9Var.R().getSpan_str() != null)) {
                dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            mPbHeadOwnerRoot.setPadding(mPbHeadOwnerRoot.getPaddingLeft(), dimens2, mPbHeadOwnerRoot.getPaddingRight(), paddingBottom2);
        }
    }

    public static final void j(aw9 aw9Var, final TBLottieAnimationView mPbHeadLivingLottie) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, aw9Var, mPbHeadLivingLottie) == null) {
            Intrinsics.checkNotNullParameter(mPbHeadLivingLottie, "mPbHeadLivingLottie");
            if (mPbHeadLivingLottie.getVisibility() != 0 && aw9Var != null && aw9Var.R() != null && aw9Var.R().getAuthor() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", aw9Var.o());
                statisticItem.param("fname", aw9Var.p());
                statisticItem.param("obj_param1", aw9Var.R().getAuthor().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", aw9Var.T());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (aw9Var.R().getAuthor().getAlaInfo() != null) {
                    AlaInfoData alaInfo = aw9Var.R().getAuthor().getAlaInfo();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                    if (alaInfo.mYyExtData != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
            mPbHeadLivingLottie.setVisibility(0);
            mPbHeadLivingLottie.setSpeed(0.8f);
            mPbHeadLivingLottie.loop(true);
            mPbHeadLivingLottie.post(new Runnable() { // from class: com.baidu.tieba.u3a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        e4a.k(TBLottieAnimationView.this);
                    }
                }
            });
        }
    }

    public static final void g(aw9 aw9Var, TextView mFloorOwner, MetaData author, nwa firstPost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, aw9Var, mFloorOwner, author, firstPost) == null) {
            Intrinsics.checkNotNullParameter(mFloorOwner, "mFloorOwner");
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(firstPost, "firstPost");
            if (aw9Var != null && aw9Var.a()) {
                mFloorOwner.setVisibility(8);
            } else if (author.getIs_bawu() == 1 && firstPost.F0()) {
                EMManager.from(mFloorOwner).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                mFloorOwner.setVisibility(0);
                mFloorOwner.setText(R.string.brand_official);
            } else if (author.getIs_bawu() == 1 && Intrinsics.areEqual("manager", author.getBawu_type())) {
                mFloorOwner.setText(R.string.bawu_member_bazhu_tip);
                mFloorOwner.setVisibility(0);
                EMManager.from(mFloorOwner).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
            } else if (author.getIs_bawu() == 1 && Intrinsics.areEqual(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST, author.getBawu_type())) {
                mFloorOwner.setText(R.string.bawu_member_xbazhu_tip);
                mFloorOwner.setVisibility(0);
                EMManager.from(mFloorOwner).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
            } else {
                mFloorOwner.setVisibility(8);
            }
        }
    }

    public static final void m(UserIconBox userIconBox, MetaData author, PbFragment mPbFragment, TextView mPbHeadOwnerUserName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, userIconBox, author, mPbFragment, mPbHeadOwnerUserName) == null) {
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            Intrinsics.checkNotNullParameter(mPbHeadOwnerUserName, "mPbHeadOwnerUserName");
            ArrayList<IconData> tShowInfoNew = author.getTShowInfoNew();
            if (userIconBox != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    userIconBox.setTag(tShowInfoNew.get(0).getUrl());
                }
                if (mPbFragment.u0() != null) {
                    userIconBox.setOnClickListener(mPbFragment.u0().c.e);
                }
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                userIconBox.h(tShowInfoNew, 3, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            mPbHeadOwnerUserName.setTag(R.id.tag_user_id, author.getUserId());
            mPbHeadOwnerUserName.setTag(R.id.tag_user_target_scheme, author.getTargetScheme());
            mPbHeadOwnerUserName.setTag(R.id.tag_user_name, author.getName_show());
            if (ListUtils.isEmpty(tShowInfoNew) && !author.isBigV()) {
                SkinManager.setViewTextColor(mPbHeadOwnerUserName, R.color.CAM_X0105, 1);
            } else {
                SkinManager.setViewTextColor(mPbHeadOwnerUserName, R.color.CAM_X0301, 1);
            }
        }
    }

    public static final void h(aw9 pbData, final TextView mPositionView, final TextView mDistanceView, MetaData author, nwa firstPost, final LinearLayout mLocationContainer, ColumnLayout mPbHeadOwnerRoot, final TextView mGeneralDesc, final TextView mCreateTimeView) {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{pbData, mPositionView, mDistanceView, author, firstPost, mLocationContainer, mPbHeadOwnerRoot, mGeneralDesc, mCreateTimeView}) == null) {
            Intrinsics.checkNotNullParameter(pbData, "pbData");
            Intrinsics.checkNotNullParameter(mPositionView, "mPositionView");
            Intrinsics.checkNotNullParameter(mDistanceView, "mDistanceView");
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(firstPost, "firstPost");
            Intrinsics.checkNotNullParameter(mLocationContainer, "mLocationContainer");
            Intrinsics.checkNotNullParameter(mPbHeadOwnerRoot, "mPbHeadOwnerRoot");
            Intrinsics.checkNotNullParameter(mGeneralDesc, "mGeneralDesc");
            Intrinsics.checkNotNullParameter(mCreateTimeView, "mCreateTimeView");
            if (pbData.a()) {
                mPositionView.setVisibility(8);
                if (mLocationContainer.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                    ViewGroup.LayoutParams layoutParams = mLocationContainer.getLayoutParams();
                    if (layoutParams != null) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) layoutParams)).rightMargin = 0;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ColumnLayout.LayoutParams");
                    }
                }
                mPbHeadOwnerRoot.setSpacingRight(0);
                String authInfo = UtilHelper.getAuthInfo(author);
                if (!TextUtils.isEmpty(authInfo)) {
                    mGeneralDesc.setVisibility(0);
                    mGeneralDesc.setText(authInfo);
                    return;
                }
                mGeneralDesc.setVisibility(8);
                return;
            }
            String authInfo2 = UtilHelper.getAuthInfo(author);
            if (!TextUtils.isEmpty(authInfo2)) {
                mGeneralDesc.setVisibility(0);
                mGeneralDesc.setText(authInfo2);
            } else {
                mGeneralDesc.setVisibility(8);
            }
            if (mLocationContainer.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams2 = mLocationContainer.getLayoutParams();
                if (layoutParams2 != null) {
                    ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) layoutParams2)).rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ColumnLayout.LayoutParams");
                }
            }
            mPbHeadOwnerRoot.setSpacingRight(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20));
            cd5 a0 = firstPost.a0();
            String b = b(firstPost);
            if (!TextUtils.isEmpty(b)) {
                mPositionView.setVisibility(0);
                mPositionView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + b);
            } else {
                if (a0 != null && !TextUtils.isEmpty(a0.b())) {
                    String b2 = a0.b();
                    Intrinsics.checkNotNullExpressionValue(b2, "location.name");
                    int length = b2.length() - 1;
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 <= length) {
                        if (!z2) {
                            i = i2;
                        } else {
                            i = length;
                        }
                        if (Intrinsics.compare((int) b2.charAt(i), 32) <= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z2) {
                            if (!z) {
                                z2 = true;
                            } else {
                                i2++;
                            }
                        } else if (!z) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    if (!TextUtils.isEmpty(b2.subSequence(i2, length + 1).toString())) {
                        mPositionView.setVisibility(0);
                        mPositionView.setText(a0.b());
                    }
                }
                mPositionView.setVisibility(8);
            }
            if (a0 != null && !TextUtils.isEmpty(a0.a()) && TextUtils.isEmpty(b)) {
                mDistanceView.setText(a0.a());
                mDistanceView.setVisibility(0);
                final int measureText = (int) mDistanceView.getPaint().measureText(a0.a(), 0, a0.a().length());
                mLocationContainer.post(new Runnable() { // from class: com.baidu.tieba.t3a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            e4a.i(mLocationContainer, mCreateTimeView, mGeneralDesc, measureText, mDistanceView, mPositionView);
                        }
                    }
                });
                return;
            }
            mDistanceView.setVisibility(8);
        }
    }

    public static final void i(LinearLayout mLocationContainer, TextView mCreateTimeView, TextView mGeneralDesc, int i, TextView mDistanceView, TextView mPositionView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{mLocationContainer, mCreateTimeView, mGeneralDesc, Integer.valueOf(i), mDistanceView, mPositionView}) == null) {
            Intrinsics.checkNotNullParameter(mLocationContainer, "$mLocationContainer");
            Intrinsics.checkNotNullParameter(mCreateTimeView, "$mCreateTimeView");
            Intrinsics.checkNotNullParameter(mGeneralDesc, "$mGeneralDesc");
            Intrinsics.checkNotNullParameter(mDistanceView, "$mDistanceView");
            Intrinsics.checkNotNullParameter(mPositionView, "$mPositionView");
            int measuredWidth = mLocationContainer.getMeasuredWidth();
            int measuredWidth2 = mCreateTimeView.getMeasuredWidth();
            int measuredWidth3 = mGeneralDesc.getMeasuredWidth();
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
            if (i2 < i) {
                mDistanceView.setVisibility(8);
                mPositionView.setVisibility(8);
            } else if (i2 - i < dimenPixelSize) {
                mPositionView.setVisibility(8);
            }
        }
    }

    public static final void l(HeadPendantView mPbPendantHeadOwnerHead, MetaData author, boolean z, aw9 pbData, nwa firstPost, ClickableHeaderImageView clickableHeaderImageView, TextView mPbHeadOwnerUserName, View.OnClickListener personCenterClickListener, PbFragment mPbFragment, TbImageView mPbFirstUserGrowthLevel, View.OnClickListener mUserGrowClickListener) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{mPbPendantHeadOwnerHead, author, Boolean.valueOf(z), pbData, firstPost, clickableHeaderImageView, mPbHeadOwnerUserName, personCenterClickListener, mPbFragment, mPbFirstUserGrowthLevel, mUserGrowClickListener}) == null) {
            Intrinsics.checkNotNullParameter(mPbPendantHeadOwnerHead, "mPbPendantHeadOwnerHead");
            Intrinsics.checkNotNullParameter(author, "author");
            Intrinsics.checkNotNullParameter(pbData, "pbData");
            Intrinsics.checkNotNullParameter(firstPost, "firstPost");
            Intrinsics.checkNotNullParameter(mPbHeadOwnerUserName, "mPbHeadOwnerUserName");
            Intrinsics.checkNotNullParameter(personCenterClickListener, "personCenterClickListener");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            Intrinsics.checkNotNullParameter(mPbFirstUserGrowthLevel, "mPbFirstUserGrowthLevel");
            Intrinsics.checkNotNullParameter(mUserGrowClickListener, "mUserGrowClickListener");
            mPbPendantHeadOwnerHead.setBigVDimenSize(R.dimen.tbds36);
            if (!z) {
                mPbPendantHeadOwnerHead.i(author);
                mPbPendantHeadOwnerHead.setIsclearmode(false);
            } else {
                mPbPendantHeadOwnerHead.setIsclearmode(true);
            }
            mPbPendantHeadOwnerHead.setVisibility(0);
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setVisibility(8);
            }
            mPbHeadOwnerUserName.setOnClickListener(personCenterClickListener);
            mPbPendantHeadOwnerHead.getHeadView().setUserId(author.getUserId());
            mPbPendantHeadOwnerHead.getHeadView().setTargetScheme(author.getTargetScheme());
            mPbPendantHeadOwnerHead.getHeadView().setUserName(author.getUserName());
            mPbPendantHeadOwnerHead.getHeadView().setTid(firstPost.U());
            mPbPendantHeadOwnerHead.getHeadView().setFid(pbData.o());
            mPbPendantHeadOwnerHead.getHeadView().setFName(pbData.p());
            mPbPendantHeadOwnerHead.getHeadView().setOnClickListener(personCenterClickListener);
            if (z) {
                mPbPendantHeadOwnerHead.m(author.getAvater());
            } else {
                mPbPendantHeadOwnerHead.o(author);
                mPbPendantHeadOwnerHead.setIsNeedAlpAnima(true);
            }
            String name_show = author.getName_show();
            String userName = author.getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !Intrinsics.areEqual(name_show, userName)) {
                mPbHeadOwnerUserName.setText(du9.b(mPbFragment.getPageContext().getPageActivity(), mPbHeadOwnerUserName.getText().toString()));
                mPbHeadOwnerUserName.setGravity(16);
                mPbHeadOwnerUserName.setTag(R.id.tag_nick_name_activity, du9.a());
                SkinManager.setViewTextColor(mPbHeadOwnerUserName, R.color.CAM_X0312, 1);
            }
            if (TbSingleton.getInstance().isUserGrowthOpen() && author.getUserGrowthData() != null) {
                int a = author.getUserGrowthData().a();
                if (a >= 0 && a < 11) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    mPbFirstUserGrowthLevel.setImageResource(ss.b(a));
                    mPbFirstUserGrowthLevel.setVisibility(0);
                    mPbFirstUserGrowthLevel.setTag(Integer.valueOf(a));
                    mPbFirstUserGrowthLevel.setOnClickListener(mUserGrowClickListener);
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 3, a);
                    return;
                }
                mPbFirstUserGrowthLevel.setVisibility(8);
            }
        }
    }

    public static final void n(aw9 data, nwa mAuthorPostData, boolean z, PbFirstFloorUserLikeButton mPbLikeButton, h4a mPbViews) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{data, mAuthorPostData, Boolean.valueOf(z), mPbLikeButton, mPbViews}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(mAuthorPostData, "mAuthorPostData");
            Intrinsics.checkNotNullParameter(mPbLikeButton, "mPbLikeButton");
            Intrinsics.checkNotNullParameter(mPbViews, "mPbViews");
            if (3 != data.i()) {
                mPbLikeButton.setVisibility(0);
                d(mPbLikeButton);
            }
            if (z) {
                mPbLikeButton.setVisibility(8);
                if (data.R() != null && data.R().getBaijiahaoData() != null && data.R().getBaijiahaoData().oriUgcType == 3) {
                    mPbViews.g(8);
                } else if (data.R() != null && data.R().isQuestionThread()) {
                    mPbViews.g(8);
                } else {
                    mPbViews.g(0);
                }
                String T2 = data.T();
                Intrinsics.checkNotNullExpressionValue(T2, "data.threadId");
                mPbViews.a(T2);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = TbadkCoreApplication.getInst().getString(R.string.person_view_num);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.person_view_num)");
                String format = String.format(string, Arrays.copyOf(new Object[]{StringHelper.numberUniformFormatExtra(data.S())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                mPbViews.f(format);
            } else if (PbNormalLikeButtonSwitch.getIsOn() && !mAuthorPostData.u().hadConcerned() && (data.R() == null || !data.R().isQuestionThread())) {
                mPbViews.g(8);
            } else {
                mPbLikeButton.setVisibility(8);
                mPbViews.g(8);
            }
            if (data.i || 3 == data.i()) {
                mPbLikeButton.setVisibility(8);
            }
        }
    }

    public static final void o(nwa mFirstPost, UserIconBox userIconBox, PbFragment mPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, mFirstPost, userIconBox, mPbFragment) == null) {
            Intrinsics.checkNotNullParameter(mFirstPost, "mFirstPost");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            MetaData u = mFirstPost.u();
            ArrayList<IconData> iconInfo = u.getIconInfo();
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, u.getUserId());
                if (mPbFragment.u0() != null) {
                    userIconBox.setOnClickListener(mPbFragment.u0().c.c);
                }
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                userIconBox.g(iconInfo, 4, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                userIconBox.setAutoChangedStyle(true);
                d(userIconBox);
            }
        }
    }
}
