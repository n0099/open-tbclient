package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.txa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes5.dex */
public class ThemeAndStarView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SimpleDraweeView a;
    public TextView b;
    public ImageView c;
    public boolean d;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;
        public final /* synthetic */ ThemeAndStarView b;

        public a(ThemeAndStarView themeAndStarView, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {themeAndStarView, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = themeAndStarView;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String jumpUrl = this.a.getJumpUrl();
                if (!StringUtils.isNull(jumpUrl)) {
                    UrlManager.getInstance().dealOneLink(new String[]{txa.a(jumpUrl, "0", "", String.valueOf(this.a.getCardId()))});
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.b.getContext(), this.a.getCardId())));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThemeAndStarView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThemeAndStarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThemeAndStarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = true;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070387), BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0703ed));
            layoutParams.addRule(11);
            layoutParams.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds30);
            setLayoutParams(layoutParams);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
            this.a = simpleDraweeView;
            simpleDraweeView.setContentDescription("个性卡片");
            addView(this.a);
            ImageView imageView = new ImageView(getContext());
            this.c = imageView;
            imageView.setContentDescription("个性卡片ID前缀");
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070215), BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f0701b2));
            layoutParams2.gravity = BadgeDrawable.TOP_START;
            layoutParams2.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds13);
            this.c.setLayoutParams(layoutParams2);
            addView(this.c);
            TextView textView = new TextView(getContext());
            this.b = textView;
            textView.setContentDescription("个性卡片ID");
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = BadgeDrawable.BOTTOM_START;
            layoutParams3.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X001);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds3);
            this.b.setLayoutParams(layoutParams3);
            addView(this.b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = this.b;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0105);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_zb_no, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            }
        }
    }

    public boolean c(ThemeCardInUserData themeCardInUserData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, themeCardInUserData)) == null) {
            if (themeCardInUserData != null && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                if (this.d && (this.a.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.getLayoutParams();
                    layoutParams.rightMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds106);
                    this.a.setLayoutParams(layoutParams);
                }
                this.a.setVisibility(0);
                this.a.setImageDrawable(null);
                setVisibility(0);
                if (!StringUtils.isNull(themeCardInUserData.getDynamicUrl())) {
                    this.a.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(themeCardInUserData.getDynamicUrl())).setAutoPlayAnimations(true).build());
                } else {
                    this.a.setImageURI(Uri.parse(themeCardInUserData.getCardImageUrlAndroid()));
                }
                if (!StringUtils.isNull(themeCardInUserData.getExclusiveNo()) && !StringUtils.isNull(themeCardInUserData.getCardImageUrlAndroid())) {
                    this.b.setVisibility(0);
                    this.c.setVisibility(0);
                    this.b.setText(themeCardInUserData.getExclusiveNo());
                    WebPManager.setPureDrawable(this.c, R.drawable.icon_pure_zb_no, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                    try {
                        this.b.setTypeface(ResourcesCompat.getFont(getContext(), R.font.baidunumber_medium));
                    } catch (Resources.NotFoundException e) {
                        BdLog.e(e);
                    }
                    EMManager.from(this.b).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0105);
                    this.c.setAlpha(0.7f);
                    this.b.setAlpha(0.7f);
                } else {
                    this.b.setVisibility(8);
                    this.c.setVisibility(8);
                }
                this.a.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                this.a.setOnClickListener(new a(this, themeCardInUserData));
                return true;
            }
            this.a.setVisibility(8);
            setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setIsNegativeFeedbackShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.d = z;
        }
    }
}
