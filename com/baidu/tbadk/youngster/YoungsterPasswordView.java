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
import d.a.o0.c1.b.c;
import d.a.o0.c1.b.d;
import d.a.o0.c1.b.e;
/* loaded from: classes3.dex */
public class YoungsterPasswordView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f13628e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13629f;

    /* renamed from: g  reason: collision with root package name */
    public PasswordView f13630g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13631h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f13632i;
    public LinearLayout j;
    public int k;
    public String l;
    public int m;
    public BdTopToast n;
    public PasswordView.g o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a implements PasswordView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordView f13633a;

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
            this.f13633a = youngsterPasswordView;
        }

        @Override // com.baidu.tbadk.youngster.PasswordView.g
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String passWord = this.f13633a.f13630g.getPassWord();
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f13633a.getContext());
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordInput(passWord);
                switch (this.f13633a.k) {
                    case 1:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(2);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f13633a.m);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.f13633a.f13630g.e();
                        return;
                    case 2:
                        if (StringUtils.isNull(this.f13633a.l)) {
                            return;
                        }
                        if (this.f13633a.l.equals(passWord)) {
                            e.f(passWord);
                            if (this.f13633a.m == 1) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921487));
                                if (d.a.c.a.b.f().g() > 3) {
                                    d.a.c.a.b.f().m(3);
                                }
                            } else {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 2));
                                d.a.o0.r.a0.b.e(this.f13633a.getContext(), 2);
                            }
                            this.f13633a.g();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.TRUE));
                            c.b(this.f13633a.m);
                            return;
                        }
                        if (this.f13633a.getParent() != null && !this.f13633a.n.isShown()) {
                            this.f13633a.n.j((ViewGroup) this.f13633a.getParent().getParent());
                        }
                        this.f13633a.f13630g.e();
                        return;
                    case 3:
                        if (e.e(passWord)) {
                            d.b();
                            e.a();
                            if (this.f13633a.m != 2 && this.f13633a.m != 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 3));
                                if (this.f13633a.f13628e != null) {
                                    this.f13633a.f13628e.getPageActivity().finish();
                                }
                            } else {
                                d.a.o0.r.a0.b.e(this.f13633a.getContext(), 2);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 3));
                            d.a.o0.r.d0.b.j().t("key_youngster_homgpage_top_view_closed", false);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921509, Boolean.FALSE));
                            return;
                        }
                        if (this.f13633a.getParent() != null && !this.f13633a.n.isShown()) {
                            this.f13633a.n.j((ViewGroup) this.f13633a.getParent().getParent());
                        }
                        this.f13633a.f13630g.e();
                        return;
                    case 4:
                        youngsterPasswordActivityConfig.setYoungsterPasswordPageType(5);
                        youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.f13633a.m);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
                        this.f13633a.f13630g.e();
                        return;
                    case 5:
                        if (StringUtils.isNull(this.f13633a.l)) {
                            return;
                        }
                        if (this.f13633a.l.equals(passWord)) {
                            e.f(passWord);
                            if (this.f13633a.m == 2 || this.f13633a.m == 3) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486, 5));
                                d.a.o0.r.a0.b.e(this.f13633a.getContext(), 2);
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921484, 5));
                            if (d.a.c.a.b.f().g() > 3) {
                                d.a.c.a.b.f().m(3);
                                return;
                            }
                            return;
                        }
                        if (this.f13633a.getParent() != null && !this.f13633a.n.isShown()) {
                            this.f13633a.n.j((ViewGroup) this.f13633a.getParent().getParent());
                        }
                        this.f13633a.f13630g.e();
                        return;
                    case 6:
                        if (e.e(passWord)) {
                            d.b();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921561, 6));
                            if (this.f13633a.f13628e != null) {
                                this.f13633a.f13628e.getPageActivity().finish();
                                return;
                            }
                            return;
                        }
                        if (this.f13633a.getParent() != null && !this.f13633a.n.isShown()) {
                            this.f13633a.n.j((ViewGroup) this.f13633a.getParent().getParent());
                        }
                        this.f13633a.f13630g.e();
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YoungsterPasswordView f13634a;

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
            this.f13634a = youngsterPasswordView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f13634a.getParent() == null) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this.f13634a.getContext(), 2000);
            bdTopToast.i(false);
            bdTopToast.h(this.f13634a.getContext().getString(R.string.youngster_settings_verify_fail));
            bdTopToast.j((ViewGroup) this.f13634a.getParent().getParent());
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
        this.f13628e = tbPageContext;
        if (tbPageContext != null) {
            this.p.setTag(tbPageContext.getUniqueId());
            tbPageContext.registerListener(this.p);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13630g.f();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.view_youngster_password, this);
            this.f13629f = (TextView) findViewById(R.id.txt_youngster_password_title);
            this.f13630g = (PasswordView) findViewById(R.id.password_view_youngster);
            this.f13631h = (TextView) findViewById(R.id.txt_youngster_password_content);
            this.f13632i = (ImageView) findViewById(R.id.img_youngster_content_arrow);
            this.j = (LinearLayout) findViewById(R.id.youngster_content_group);
            this.f13630g.setOnPasswordInputComplete(this.o);
            this.j.setOnClickListener(this);
            BdTopToast bdTopToast = new BdTopToast(getContext(), 2000);
            bdTopToast.i(false);
            bdTopToast.h(getContext().getString(R.string.youngster_settings_input_password_error));
            this.n = bdTopToast;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.k = i2;
            this.f13632i.setVisibility(8);
            switch (i2) {
                case 1:
                    this.f13629f.setText(R.string.youngster_settings_set_password);
                    this.f13631h.setText(R.string.youngster_settings_set_password_content);
                    return;
                case 2:
                    this.f13629f.setText(R.string.youngster_settings_verify_password);
                    this.f13631h.setText(R.string.youngster_settings_set_password_content);
                    return;
                case 3:
                case 6:
                    this.f13629f.setText(R.string.youngster_settings_input_password);
                    this.f13631h.setText(R.string.youngster_settings_input_password_content);
                    this.f13632i.setVisibility(0);
                    return;
                case 4:
                    this.f13629f.setText(R.string.youngster_settings_set_new_password);
                    this.f13631h.setText(R.string.youngster_settings_reset_password_content);
                    return;
                case 5:
                    this.f13629f.setText(R.string.youngster_settings_verify_password);
                    this.f13631h.setText(R.string.youngster_settings_reset_password_content);
                    return;
                default:
                    return;
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.f13629f, R.color.CAM_X0105);
            this.f13630g.j();
            SkinManager.setViewTextColor(this.f13631h, R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13632i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13630g.q();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.j) {
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
                this.f13630g.e();
            }
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
            this.f13628e = tbPageContext;
        }
    }

    public void setPrePassword(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.l = str;
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
        h();
    }
}
