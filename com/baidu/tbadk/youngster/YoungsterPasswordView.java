package com.baidu.tbadk.youngster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.f1.b.c;
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
/* loaded from: classes8.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int YOUNGSTER_NIGHT_OPEN = 7;
    public static final int YOUNGSTER_PASSWORD_INPUT = 3;
    public static final int YOUNGSTER_PASSWORD_INPUT_FOR_TIME = 6;
    public static final int YOUNGSTER_PASSWORD_RESET = 4;
    public static final int YOUNGSTER_PASSWORD_RESET_VERIFY = 5;
    public static final int YOUNGSTER_PASSWORD_SET = 1;
    public static final int YOUNGSTER_PASSWORD_SET_VERIFY = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f47408e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47409f;

    /* renamed from: g  reason: collision with root package name */
    public PasswordView f47410g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47411h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f47412i;
    public LinearLayout j;
    public int k;
    public String l;
    public int m;
    public BdTopToast n;
    public PasswordView.g o;
    public CustomMessageListener p;

    /* loaded from: classes8.dex */
    public class a implements PasswordView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordView f47413a;

        public a(YoungsterPasswordView youngsterPasswordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterPasswordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47413a = youngsterPasswordView;
        }

        @Override // com.baidu.tbadk.youngster.PasswordView.g
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String passWord = this.f47413a.f47410g.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f47413a.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (this.f47413a.k) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f47413a.m);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.f47413a.f47410g.clearPassword();
                        return;
                    case 2:
                        if (StringUtils.isNull(this.f47413a.l)) {
                            return;
                        }
                        if (this.f47413a.l.equals(passWord)) {
                            c.f(passWord);
                            if (this.f47413a.m == 1) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                if (b.a.e.a.b.g().h() > 3) {
                                    b.a.e.a.b.g().n(3);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                b.a.q0.s.b0.b.e(this.f47413a.getContext(), 2);
                            }
                            this.f47413a.hideSoftKeyboard();
                            return;
                        }
                        if (this.f47413a.getParent() != null && !this.f47413a.n.isShown()) {
                            this.f47413a.n.show((ViewGroup) this.f47413a.getParent().getParent());
                        }
                        this.f47413a.f47410g.clearPassword();
                        return;
                    case 3:
                        if (c.e(passWord)) {
                            b.a.q0.f1.b.b.b();
                            c.a();
                            if (this.f47413a.m != 2 && this.f47413a.m != 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (this.f47413a.f47408e != null) {
                                    this.f47413a.f47408e.getPageActivity().finish();
                                }
                            } else {
                                b.a.q0.s.b0.b.e(this.f47413a.getContext(), 2);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            b.a.q0.s.e0.b.j().t("key_youngster_homgpage_top_view_closed", false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.FALSE));
                            return;
                        }
                        if (this.f47413a.getParent() != null && !this.f47413a.n.isShown()) {
                            this.f47413a.n.show((ViewGroup) this.f47413a.getParent().getParent());
                        }
                        this.f47413a.f47410g.clearPassword();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f47413a.m);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.f47413a.f47410g.clearPassword();
                        return;
                    case 5:
                        if (StringUtils.isNull(this.f47413a.l)) {
                            return;
                        }
                        if (this.f47413a.l.equals(passWord)) {
                            c.f(passWord);
                            if (this.f47413a.m == 2 || this.f47413a.m == 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                b.a.q0.s.b0.b.e(this.f47413a.getContext(), 2);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                            if (b.a.e.a.b.g().h() > 3) {
                                b.a.e.a.b.g().n(3);
                                return;
                            }
                            return;
                        }
                        if (this.f47413a.getParent() != null && !this.f47413a.n.isShown()) {
                            this.f47413a.n.show((ViewGroup) this.f47413a.getParent().getParent());
                        }
                        this.f47413a.f47410g.clearPassword();
                        return;
                    case 6:
                        if (c.e(passWord)) {
                            b.a.q0.f1.b.b.b();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 6));
                            if (this.f47413a.f47408e != null) {
                                this.f47413a.f47408e.getPageActivity().finish();
                                return;
                            }
                            return;
                        }
                        if (this.f47413a.getParent() != null && !this.f47413a.n.isShown()) {
                            this.f47413a.n.show((ViewGroup) this.f47413a.getParent().getParent());
                        }
                        this.f47413a.f47410g.clearPassword();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordView f47414a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(YoungsterPasswordView youngsterPasswordView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterPasswordView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47414a = youngsterPasswordView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f47414a.getParent() == null) {
                return;
            }
            new BdTopToast(this.f47414a.getContext(), 2000).setIcon(false).setContent(this.f47414a.getContext().getString(R.string.youngster_settings_verify_fail)).show((ViewGroup) this.f47414a.getParent().getParent());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f47408e = tbPageContext;
        if (tbPageContext != null) {
            this.p.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.p);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.view_youngster_password, this);
            this.f47409f = (TextView) findViewById(R.id.txt_youngster_password_title);
            this.f47410g = (PasswordView) findViewById(R.id.password_view_youngster);
            this.f47411h = (TextView) findViewById(R.id.txt_youngster_password_content);
            this.f47412i = (ImageView) findViewById(R.id.img_youngster_content_arrow);
            this.j = (LinearLayout) findViewById(R.id.youngster_content_group);
            this.f47410g.setOnPasswordInputComplete(this.o);
            this.j.setOnClickListener(this);
            this.n = new BdTopToast(getContext(), 2000).setIcon(false).setContent(getContext().getString(R.string.youngster_settings_input_password_error));
        }
    }

    public void hideSoftKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47410g.hideSoftKeyboard();
        }
    }

    public void initByType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.k = i2;
            this.f47412i.setVisibility(8);
            switch (i2) {
                case 1:
                    this.f47409f.setText(R.string.youngster_settings_set_password);
                    this.f47411h.setText(R.string.youngster_settings_set_password_content);
                    return;
                case 2:
                    this.f47409f.setText(R.string.youngster_settings_verify_password);
                    this.f47411h.setText(R.string.youngster_settings_set_password_content);
                    return;
                case 3:
                case 6:
                    this.f47409f.setText(R.string.youngster_settings_input_password);
                    this.f47411h.setText(R.string.youngster_settings_input_password_content);
                    this.f47412i.setVisibility(0);
                    return;
                case 4:
                    this.f47409f.setText(R.string.youngster_settings_set_new_password);
                    this.f47411h.setText(R.string.youngster_settings_reset_password_content);
                    return;
                case 5:
                    this.f47409f.setText(R.string.youngster_settings_verify_password);
                    this.f47411h.setText(R.string.youngster_settings_reset_password_content);
                    return;
                default:
                    return;
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f47409f, R.color.CAM_X0105);
            this.f47410g.onChangeSkinType();
            SkinManager.setViewTextColor(this.f47411h, R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f47412i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.j) {
            int i2 = this.k;
            if (i2 == 3 || i2 == 6) {
                String youngsterVerifyUrl = YoungsterVerifyActivityConfig.getYoungsterVerifyUrl();
                if (!StringUtils.isNull(youngsterVerifyUrl)) {
                    YoungsterVerifyActivityConfig youngsterVerifyActivityConfig = new YoungsterVerifyActivityConfig(getContext(), getContext().getString(R.string.youngster_settings_verify_title), youngsterVerifyUrl, true);
                    youngsterVerifyActivityConfig.setKeyYoungsterPasswordFrom(this.m);
                    youngsterVerifyActivityConfig.setNoMenu(true);
                    youngsterVerifyActivityConfig.setFixTitle(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterVerifyActivityConfig));
                }
                this.f47410g.clearPassword();
            }
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f47408e = tbPageContext;
        }
    }

    public void setPrePassword(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    public void showSoftKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f47410g.showSoftKeyboard();
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoungsterPasswordView(Context context, AttributeSet attributeSet) {
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
    public YoungsterPasswordView(Context context, AttributeSet attributeSet, int i2) {
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
        this.o = new a(this);
        this.p = new b(this, 2921489);
        g();
    }
}
