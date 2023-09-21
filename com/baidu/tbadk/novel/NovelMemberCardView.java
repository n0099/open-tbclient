package com.baidu.tbadk.novel;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.is5;
import com.baidu.tieba.ks5;
import com.baidu.tieba.vh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NovelMemberCardView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public TbImageView c;
    public TextView d;
    public ImageView e;
    public ImageView f;
    public View g;
    public TextView h;
    public LinearLayout i;
    public TextView j;
    public ImageView k;
    public LinearLayout l;
    public TextView m;
    public ImageView n;
    public final is5 o;
    public final CustomMessageListener p;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NovelMemberCardView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NovelMemberCardView novelMemberCardView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {novelMemberCardView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = novelMemberCardView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921697) {
                int error = customResponsedMessage.getError();
                if (!(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                this.a.o.u(((Boolean) customResponsedMessage.getData()).booleanValue());
                if (error == 0 && this.a.o.f()) {
                    this.a.o.w(true);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelMemberCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.o = new is5();
        this.p = new a(this, 2921697);
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelMemberCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.o = new is5();
        this.p = new a(this, 2921697);
        c(context);
    }

    public final void j(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(NovelWebViewActivityConfig.KEY_IS_SHOW_TOAST_TIP, z);
            bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_ID, String.valueOf(this.o.m()));
            bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_TID, this.o.i());
            bundle.putString(NovelWebViewActivityConfig.KEY_NOVEL_FID, this.o.e());
            BrowserHelper.startWebActivity(getContext(), "", str, true, true, true, bundle);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelMemberCardView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.o = new is5();
        this.p = new a(this, 2921697);
        c(context);
    }

    public final void b(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (this.o.o()) {
                i = 2;
            } else {
                i = 1;
            }
            if (view2 != this.j && view2 != this.k) {
                if (view2.getId() == R.id.novel_member_rights_page) {
                    ks5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_CARD_VIEW_CLICK, 4, String.valueOf(this.o.m()), this.o.i(), this.o.e(), this.o.h(), this.o.d(), this.o.g(), this.o.j());
                    return;
                } else {
                    ks5.b(CommonStatisticKey.KEY_PB_NOVEL_INFO_READ_MORE_BUTTON_CLICK, i, String.valueOf(this.o.m()), this.o.i(), this.o.e(), this.o.h(), this.o.d(), this.o.g(), this.o.j());
                    return;
                }
            }
            ks5.c(CommonStatisticKey.KEY_PB_NOVEL_JUMP_STORY_CHANNEL_CLICK, String.valueOf(this.o.m()), this.o.i(), this.o.d(), this.o.g(), this.o.j());
        }
    }

    public void setData(vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vh5Var) == null) {
            if (vh5Var != null && !vh5Var.n()) {
                setVisibility(0);
                this.o.t(vh5Var);
                if (!StringUtils.isNull(this.o.k())) {
                    this.c.startLoad(this.o.k(), 10, false);
                } else {
                    this.c.setVisibility(8);
                }
                if (StringUtils.isNull(this.o.l())) {
                    this.d.setText(R.string.novel_default_tip);
                } else {
                    this.d.setText(this.o.l());
                }
                if (!TextUtils.isEmpty(this.o.q()) && !TextUtils.isEmpty(this.o.r())) {
                    this.i.setVisibility(0);
                    this.j.setText(this.o.q());
                    this.j.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                    this.j.setVisibility(8);
                }
                String b = this.o.b();
                if (!TextUtils.isEmpty(b)) {
                    this.m.setText(b);
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                i();
                d(this.o.n());
                return;
            }
            setVisibility(8);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.novel_member_card_layout, (ViewGroup) this, true);
            this.b = findViewById(R.id.novel_member_no_pay_view);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.novel_member_rights_page);
            this.c = tbImageView;
            tbImageView.setDrawCorner(true);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X06);
            this.e = (ImageView) findViewById(R.id.read_more_lock_icon);
            this.f = (ImageView) findViewById(R.id.icon_pure_arrow_right);
            this.d = (TextView) findViewById(R.id.novel_read_more_text);
            this.g = findViewById(R.id.novel_member_pay_view);
            this.h = (TextView) findViewById(R.id.novel_member_pay_tip);
            this.i = (LinearLayout) findViewById(R.id.novel_story_channel_container);
            this.j = (TextView) findViewById(R.id.novel_story_channel_entrance_text);
            this.k = (ImageView) findViewById(R.id.novel_story_channel_entrance_icon);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l = (LinearLayout) findViewById(R.id.novel_copyright_container);
            this.m = (TextView) findViewById(R.id.novel_copyright_text);
            this.n = (ImageView) findViewById(R.id.novel_copyright_icon);
            this.c.setOnClickListener(this);
            setOnClickListener(this);
            e();
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    public void d(vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vh5Var) == null) {
            if (vh5Var.j()) {
                this.b.setVisibility(8);
                this.g.setVisibility(0);
                String m = vh5Var.m();
                if (TextUtils.isEmpty(m)) {
                    m = getContext().getString(R.string.novel_member_payed);
                }
                this.h.setText(m);
                e();
                return;
            }
            this.g.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            b(view2);
            if (view2 != this.j && view2 != this.k) {
                f();
                return;
            }
            String r = this.o.r();
            if (!TextUtils.isEmpty(r)) {
                UrlManager.getInstance().dealOneLink(this.o.s(r));
            }
        }
    }

    public void e() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        this.c.setSkinType(skinType);
        EMManager.from(this.d).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0311);
        EMManager.from(this.h).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X05).setTextColor(R.color.CAM_X0341);
        WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_list_arrow_right, R.color.CAM_X0341, WebPManager.ResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.e, R.drawable.icon_novel_lock, R.color.CAM_X0311, WebPManager.ResourceStateType.NORMAL);
        EMManager.from(this.j).setTextColor(R.color.CAM_X0341);
        WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_novel_arrow_right, R.color.CAM_X0341, WebPManager.ResourceStateType.NORMAL);
        EMManager.from(this.m).setTextColor(R.color.CAM_X0626);
        SkinManager.setBackgroundResource(this.n, R.drawable.icon_novel_copyright);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !StringUtils.isNull(this.o.c()) && !StringUtils.isNull(this.o.a())) {
            if (this.o.o()) {
                is5 is5Var = this.o;
                j(is5Var.x(is5Var.c()), true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921658, Boolean.TRUE));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(getContext());
            } else {
                is5 is5Var2 = this.o;
                j(is5Var2.x(is5Var2.a()), false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public View getNovelCoverPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TbImageView tbImageView = this.c;
            if (tbImageView != null && tbImageView.getVisibility() == 0) {
                return this.c;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelPaidButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View view2 = this.g;
            if (view2 != null && view2.getVisibility() == 0) {
                return this.g;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelReadMoreButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageView imageView = this.e;
            if (imageView != null && imageView.getVisibility() == 0) {
                return this.e;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public View getNovelStoryChannelBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TextView textView = this.j;
            if (textView != null && textView.getVisibility() == 0) {
                return this.j;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            d(this.o.n());
        }
    }

    public final void i() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int dimenPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams == null) {
                return;
            }
            if (this.l.getVisibility() == 0) {
                dimenPixelSize = 0;
            } else {
                dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X008);
            }
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, dimenPixelSize);
            this.g.setLayoutParams(marginLayoutParams);
        }
    }

    public void setStatisticData(String str, String str2, int i, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5}) == null) {
            this.o.v(str, str2, i, str3, str4, str5);
        }
    }
}
