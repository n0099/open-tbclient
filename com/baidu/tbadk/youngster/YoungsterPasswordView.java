package com.baidu.tbadk.youngster;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.g1.b.c;
import c.a.q0.g1.b.d;
import c.a.q0.g1.b.e;
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
/* loaded from: classes6.dex */
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
    public TbPageContext<?> f49030e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49031f;

    /* renamed from: g  reason: collision with root package name */
    public PasswordView f49032g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49033h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f49034i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f49035j;
    public int k;
    public String l;
    public int m;
    public BdTopToast n;
    public PasswordView.g o;
    public CustomMessageListener p;

    /* loaded from: classes6.dex */
    public class a implements PasswordView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordView f49036a;

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
            this.f49036a = youngsterPasswordView;
        }

        @Override // com.baidu.tbadk.youngster.PasswordView.g
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String passWord = this.f49036a.f49032g.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f49036a.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (this.f49036a.k) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f49036a.m);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.f49036a.f49032g.clearPassword();
                        return;
                    case 2:
                        if (StringUtils.isNull(this.f49036a.l)) {
                            return;
                        }
                        if (this.f49036a.l.equals(passWord)) {
                            e.f(passWord);
                            if (this.f49036a.m == 1) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                if (c.a.e.a.b.f().h() > 3) {
                                    c.a.e.a.b.f().n(3);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                c.a.q0.s.a0.b.e(this.f49036a.getContext(), 2);
                            }
                            this.f49036a.hideSoftKeyboard();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.TRUE));
                            c.b(this.f49036a.m);
                            return;
                        }
                        if (this.f49036a.getParent() != null && !this.f49036a.n.isShown()) {
                            this.f49036a.n.show((ViewGroup) this.f49036a.getParent().getParent());
                        }
                        this.f49036a.f49032g.clearPassword();
                        return;
                    case 3:
                        if (e.e(passWord)) {
                            d.b();
                            e.a();
                            if (this.f49036a.m != 2 && this.f49036a.m != 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (this.f49036a.f49030e != null) {
                                    this.f49036a.f49030e.getPageActivity().finish();
                                }
                            } else {
                                c.a.q0.s.a0.b.e(this.f49036a.getContext(), 2);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            c.a.q0.s.d0.b.j().t("key_youngster_homgpage_top_view_closed", false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.FALSE));
                            return;
                        }
                        if (this.f49036a.getParent() != null && !this.f49036a.n.isShown()) {
                            this.f49036a.n.show((ViewGroup) this.f49036a.getParent().getParent());
                        }
                        this.f49036a.f49032g.clearPassword();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f49036a.m);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.f49036a.f49032g.clearPassword();
                        return;
                    case 5:
                        if (StringUtils.isNull(this.f49036a.l)) {
                            return;
                        }
                        if (this.f49036a.l.equals(passWord)) {
                            e.f(passWord);
                            if (this.f49036a.m == 2 || this.f49036a.m == 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                c.a.q0.s.a0.b.e(this.f49036a.getContext(), 2);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                            if (c.a.e.a.b.f().h() > 3) {
                                c.a.e.a.b.f().n(3);
                                return;
                            }
                            return;
                        }
                        if (this.f49036a.getParent() != null && !this.f49036a.n.isShown()) {
                            this.f49036a.n.show((ViewGroup) this.f49036a.getParent().getParent());
                        }
                        this.f49036a.f49032g.clearPassword();
                        return;
                    case 6:
                        if (e.e(passWord)) {
                            d.b();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 6));
                            if (this.f49036a.f49030e != null) {
                                this.f49036a.f49030e.getPageActivity().finish();
                                return;
                            }
                            return;
                        }
                        if (this.f49036a.getParent() != null && !this.f49036a.n.isShown()) {
                            this.f49036a.n.show((ViewGroup) this.f49036a.getParent().getParent());
                        }
                        this.f49036a.f49032g.clearPassword();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordView f49037a;

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
            this.f49037a = youngsterPasswordView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f49037a.getParent() == null) {
                return;
            }
            new BdTopToast(this.f49037a.getContext(), 2000).setIcon(false).setContent(this.f49037a.getContext().getString(R.string.youngster_settings_verify_fail)).show((ViewGroup) this.f49037a.getParent().getParent());
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
        this.f49030e = tbPageContext;
        if (tbPageContext != null) {
            this.p.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.p);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.view_youngster_password, this);
            this.f49031f = (TextView) findViewById(R.id.txt_youngster_password_title);
            this.f49032g = (PasswordView) findViewById(R.id.password_view_youngster);
            this.f49033h = (TextView) findViewById(R.id.txt_youngster_password_content);
            this.f49034i = (ImageView) findViewById(R.id.img_youngster_content_arrow);
            this.f49035j = (LinearLayout) findViewById(R.id.youngster_content_group);
            this.f49032g.setOnPasswordInputComplete(this.o);
            this.f49035j.setOnClickListener(this);
            this.n = new BdTopToast(getContext(), 2000).setIcon(false).setContent(getContext().getString(R.string.youngster_settings_input_password_error));
        }
    }

    public void hideSoftKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f49032g.hideSoftKeyboard();
        }
    }

    public void initByType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.k = i2;
            this.f49034i.setVisibility(8);
            switch (i2) {
                case 1:
                    this.f49031f.setText(R.string.youngster_settings_set_password);
                    this.f49033h.setText(R.string.youngster_settings_set_password_content);
                    return;
                case 2:
                    this.f49031f.setText(R.string.youngster_settings_verify_password);
                    this.f49033h.setText(R.string.youngster_settings_set_password_content);
                    return;
                case 3:
                case 6:
                    this.f49031f.setText(R.string.youngster_settings_input_password);
                    this.f49033h.setText(R.string.youngster_settings_input_password_content);
                    this.f49034i.setVisibility(0);
                    return;
                case 4:
                    this.f49031f.setText(R.string.youngster_settings_set_new_password);
                    this.f49033h.setText(R.string.youngster_settings_reset_password_content);
                    return;
                case 5:
                    this.f49031f.setText(R.string.youngster_settings_verify_password);
                    this.f49033h.setText(R.string.youngster_settings_reset_password_content);
                    return;
                default:
                    return;
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f49031f, R.color.CAM_X0105);
            this.f49032g.onChangeSkinType();
            SkinManager.setViewTextColor(this.f49033h, R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f49034i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == this.f49035j) {
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
                this.f49032g.clearPassword();
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
            this.f49030e = tbPageContext;
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
            this.f49032g.showSoftKeyboard();
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
