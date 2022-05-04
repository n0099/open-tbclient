package com.baidu.tbadk.youngster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterVerifyActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.youngster.PasswordView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pg5;
import com.repackage.qg5;
import com.repackage.qt4;
import com.repackage.vt4;
import com.repackage.x8;
/* loaded from: classes3.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public TextView b;
    public PasswordView c;
    public TextView d;
    public ImageView e;
    public LinearLayout f;
    public int g;
    public String h;
    public int i;
    public BdTopToast j;
    public PasswordView.g k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class a implements PasswordView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YoungsterPasswordView a;

        public a(YoungsterPasswordView youngsterPasswordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterPasswordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = youngsterPasswordView;
        }

        @Override // com.baidu.tbadk.youngster.PasswordView.g
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String passWord = this.a.c.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.a.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (this.a.g) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.a.i);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.a.c.e();
                        return;
                    case 2:
                        if (StringUtils.isNull(this.a.h)) {
                            return;
                        }
                        if (this.a.h.equals(passWord)) {
                            qg5.f(passWord);
                            if (this.a.i == 1) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                if (x8.f().g() > 3) {
                                    x8.f().m(3);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                qt4.e(this.a.getContext(), 2);
                            }
                            this.a.g();
                            return;
                        }
                        if (this.a.getParent() != null && !this.a.j.isShown()) {
                            this.a.j.j((ViewGroup) this.a.getParent().getParent());
                        }
                        this.a.c.e();
                        return;
                    case 3:
                        if (qg5.e(passWord)) {
                            pg5.a();
                            qg5.a();
                            if (this.a.i != 2 && this.a.i != 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (this.a.a != null) {
                                    this.a.a.getPageActivity().finish();
                                }
                            } else {
                                qt4.e(this.a.getContext(), 2);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            vt4.k().u("key_youngster_homgpage_top_view_closed", false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.FALSE));
                            return;
                        }
                        if (this.a.getParent() != null && !this.a.j.isShown()) {
                            this.a.j.j((ViewGroup) this.a.getParent().getParent());
                        }
                        this.a.c.e();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.a.i);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.a.c.e();
                        return;
                    case 5:
                        if (StringUtils.isNull(this.a.h)) {
                            return;
                        }
                        if (this.a.h.equals(passWord)) {
                            qg5.f(passWord);
                            if (this.a.i == 2 || this.a.i == 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                qt4.e(this.a.getContext(), 2);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                            if (x8.f().g() > 3) {
                                x8.f().m(3);
                                return;
                            }
                            return;
                        }
                        if (this.a.getParent() != null && !this.a.j.isShown()) {
                            this.a.j.j((ViewGroup) this.a.getParent().getParent());
                        }
                        this.a.c.e();
                        return;
                    case 6:
                        if (qg5.e(passWord)) {
                            pg5.a();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 6));
                            if (this.a.a != null) {
                                this.a.a.getPageActivity().finish();
                                return;
                            }
                            return;
                        }
                        if (this.a.getParent() != null && !this.a.j.isShown()) {
                            this.a.j.j((ViewGroup) this.a.getParent().getParent());
                        }
                        this.a.c.e();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YoungsterPasswordView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(YoungsterPasswordView youngsterPasswordView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterPasswordView, Integer.valueOf(i)};
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
            this.a = youngsterPasswordView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.getParent() == null) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this.a.getContext(), 2000);
            bdTopToast.i(false);
            bdTopToast.h(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f15dc));
            bdTopToast.j((ViewGroup) this.a.getParent().getParent());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterPasswordView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        if (tbPageContext != null) {
            this.l.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.l);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.f();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d08a5, this);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f092235);
            this.c = (PasswordView) findViewById(R.id.obfuscated_res_0x7f091664);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092234);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ee1);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09249a);
            this.c.setOnPasswordInputComplete(this.k);
            this.f.setOnClickListener(this);
            BdTopToast bdTopToast = new BdTopToast(getContext(), 2000);
            bdTopToast.i(false);
            bdTopToast.h(getContext().getString(R.string.obfuscated_res_0x7f0f15d2));
            this.j = bdTopToast;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.g = i;
            this.e.setVisibility(8);
            switch (i) {
                case 1:
                    this.b.setText(R.string.obfuscated_res_0x7f0f15d8);
                    this.d.setText(R.string.obfuscated_res_0x7f0f15d9);
                    return;
                case 2:
                    this.b.setText(R.string.obfuscated_res_0x7f0f15dd);
                    this.d.setText(R.string.obfuscated_res_0x7f0f15d9);
                    return;
                case 3:
                case 6:
                    this.b.setText(R.string.obfuscated_res_0x7f0f15d0);
                    this.d.setText(R.string.obfuscated_res_0x7f0f15d1);
                    this.e.setVisibility(0);
                    return;
                case 4:
                    this.b.setText(R.string.obfuscated_res_0x7f0f15d7);
                    this.d.setText(R.string.obfuscated_res_0x7f0f15d6);
                    return;
                case 5:
                    this.b.setText(R.string.obfuscated_res_0x7f0f15dd);
                    this.d.setText(R.string.obfuscated_res_0x7f0f15d6);
                    return;
                default:
                    return;
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            this.c.j();
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.q();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 == this.f) {
            int i = this.g;
            if (i == 3 || i == 6) {
                String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
                if (!StringUtils.isNull(youngsterVerifyUrl)) {
                    YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.obfuscated_res_0x7f0f15de), youngsterVerifyUrl, true);
                    youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.i);
                    youngsterVerifyActivityConfig.setNoMenu(true);
                    youngsterVerifyActivityConfig.setFixTitle(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterVerifyActivityConfig));
                }
                this.c.e();
            }
        }
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.i = i;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    public void setPrePassword(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.h = str;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterPasswordView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterPasswordView(Context context, AttributeSet attributeSet) {
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
    public YoungsterPasswordView(Context context, AttributeSet attributeSet, int i) {
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
        this.k = new a(this);
        this.l = new b(this, 2921489);
        h();
    }
}
