package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.q0.a0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ConcernForumThreadUserInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_USERNAME_LENGTH = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51932e;

    /* renamed from: f  reason: collision with root package name */
    public View f51933f;

    /* renamed from: g  reason: collision with root package name */
    public c2 f51934g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f51935h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f51936i;

    /* renamed from: j  reason: collision with root package name */
    public int f51937j;
    public View.OnClickListener k;
    public TextView mForumName;
    public ClickableHeaderImageView mHeaderImg;
    public TextView mUsernameAndReplyTime;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernForumThreadUserInfoLayout f51938e;

        public a(ConcernForumThreadUserInfoLayout concernForumThreadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernForumThreadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51938e = concernForumThreadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51938e.f51934g == null || StringUtils.isNull(this.f51938e.f51934g.Z())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f51938e.getContext()).createNormalCfg(this.f51938e.f51934g.Z(), m.g())));
            if (this.f51938e.f51936i != null) {
                this.f51938e.f51936i.onClick(view);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConcernForumThreadUserInfoLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) {
            if (c2Var != null && c2Var.J() != null && !StringUtils.isNull(c2Var.J().getPortrait())) {
                this.mHeaderImg.setVisibility(0);
            } else {
                this.mHeaderImg.setVisibility(8);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.concern_forum_thread_user_info_layout, (ViewGroup) this, true);
            this.mHeaderImg = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
            this.mForumName = (TextView) inflate.findViewById(R.id.thread_info_forum_name);
            this.mUsernameAndReplyTime = (TextView) inflate.findViewById(R.id.thread_user_name_and_reply_time);
            this.f51932e = (TextView) inflate.findViewById(R.id.thread_info_address);
            this.f51933f = inflate.findViewById(R.id.divider);
            setGravity(16);
            e();
            this.mForumName.setOnClickListener(this.k);
        }
    }

    public final void e() {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (clickableHeaderImageView = this.mHeaderImg) == null) {
            return;
        }
        clickableHeaderImageView.setDefaultResource(17170445);
        this.mHeaderImg.setDefaultBgResource(R.color.CAM_X0205);
        this.mHeaderImg.setIsRound(true);
        this.mHeaderImg.setOnClickListener(this.k);
    }

    public final void f(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c2Var) == null) {
            if (c2Var != null && !StringUtils.isNull(c2Var.A())) {
                this.f51932e.setText(this.f51934g.A());
                this.f51932e.setVisibility(0);
                this.f51933f.setVisibility(0);
                return;
            }
            this.f51932e.setVisibility(8);
            this.f51933f.setVisibility(8);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHeaderImg : (ClickableHeaderImageView) invokeV.objValue;
    }

    public boolean getIsSimpleThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mUsernameAndReplyTime : (TextView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f51937j == i2) {
            return;
        }
        this.f51937j = i2;
        SkinManager.setViewTextColor(this.mForumName, R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.mUsernameAndReplyTime, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f51932e, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.f51933f, R.color.CAM_X0110);
    }

    public String processUserName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 10, "...") : (String) invokeL.objValue;
    }

    public boolean setData(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c2Var)) == null) {
            if (c2Var == null) {
                return false;
            }
            this.f51934g = c2Var;
            c(c2Var);
            updateForumName(c2Var);
            updateUserNameAndReplyTime(c2Var);
            f(c2Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f51936i = onClickListener;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) || (clickableHeaderImageView = this.mHeaderImg) == null) {
            return;
        }
        clickableHeaderImageView.setPageId(bdUniqueId);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f51935h = onClickListener;
            ClickableHeaderImageView clickableHeaderImageView = this.mHeaderImg;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setAfterClickListener(onClickListener);
            }
        }
    }

    public void showForumNameView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                updateForumName(this.f51934g);
            } else {
                this.mForumName.setVisibility(8);
            }
        }
    }

    public void updateForumName(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, c2Var) == null) {
            if (c2Var != null && !StringUtils.isNull(c2Var.Z())) {
                this.mForumName.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f51934g.Z(), 16, "...") + getResources().getString(R.string.forum));
                this.mForumName.setVisibility(0);
                return;
            }
            this.mForumName.setVisibility(4);
        }
    }

    public void updateUserNameAndReplyTime(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, c2Var) == null) || c2Var == null || StringUtils.isNull(this.f51934g.J().getName_show())) {
            return;
        }
        this.mUsernameAndReplyTime.setText(getContext().getString(R.string.user_name_and_publish_time, processUserName(this.f51934g.J().getName_show()), StringHelper.getFormatTime(c2Var.P())));
        this.mUsernameAndReplyTime.setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConcernForumThreadUserInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernForumThreadUserInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51937j = 3;
        this.k = new a(this);
        d(getContext());
    }
}
