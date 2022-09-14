package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class eg8 extends p9<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public LinearLayout b;
    public View c;
    public TbSettingTextTipView d;
    public TbSettingTextTipView e;
    public TbSettingTextTipView f;
    public TbSettingTextTipView g;
    public TbSettingTextTipView h;
    public View i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public SecretSettingActivity l;
    public View m;
    public String[] n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public TbSettingTextTipView q;
    public ScrollView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public MsgSettingItemView v;
    public MsgSettingItemView w;
    public View.OnClickListener x;
    public b y;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg8 a;

        public a(eg8 eg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.y == null) {
                return;
            }
            if (view2 == this.a.c) {
                this.a.y.onBackPressed();
            } else if (view2 == this.a.d) {
                this.a.y.i();
            } else if (view2 == this.a.e) {
                this.a.y.g();
            } else if (view2 == this.a.g) {
                this.a.y.c();
            } else if (view2 == this.a.h) {
                this.a.y.h();
            } else if (view2 == this.a.k) {
                this.a.y.e();
            } else if (view2 == this.a.j) {
                this.a.y.a();
            } else if (view2 == this.a.o) {
                this.a.y.f();
            } else if (view2 == this.a.p) {
                this.a.y.j();
            } else if (view2 == this.a.f) {
                this.a.y.d();
            } else if (view2 == this.a.q) {
                this.a.y.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();

        void onBackPressed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eg8(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {secretSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.x = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d07a7);
        y(secretSettingActivity);
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.y = bVar;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                return;
            }
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void D(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (i2 == 3 && i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0ab9));
            } else if (i2 == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0ab8));
            } else if (i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0aba));
            } else {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0ab7));
            }
        }
    }

    public void E(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i) == null) {
            int i2 = i - 1;
            String[] strArr = this.n;
            if (strArr == null || i2 >= strArr.length || i2 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.e.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.k.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.g.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0275));
                } else {
                    this.j.setTip(this.n[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                D(bx4.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), bx4.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void F(cg8 cg8Var) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cg8Var) == null) || cg8Var == null || (strArr = this.n) == null) {
            return;
        }
        int length = strArr.length;
        int d = cg8Var.d() - 1;
        if (d < length && d >= 0) {
            this.k.setTip(this.n[d]);
        }
        int c = cg8Var.c() - 1;
        if (c < length && c >= 0) {
            this.e.setTip(this.n[c]);
        }
        int e = cg8Var.e() - 1;
        if (e < length && e >= 0) {
            this.g.setTip(this.n[e]);
        }
        int g = cg8Var.g() - 1;
        if (g < length && g >= 0) {
            if (g == 0) {
                this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0275));
            } else {
                this.j.setTip(this.n[g]);
            }
        }
        D(cg8Var.a(), cg8Var.b());
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.l.getLayoutMode().l(i == 1);
            this.l.getLayoutMode().k(this.b);
            this.a.onChangeSkinType(this.l.getPageContext(), i);
            uu4.d(this.s).v(R.color.CAM_X0108);
            uu4.d(this.t).v(R.color.CAM_X0108);
            uu4.d(this.u).v(R.color.CAM_X0108);
            uu4.d(this.r).f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            this.v.c(this.l.getPageContext(), i);
            this.w.c(this.l.getPageContext(), i);
        }
    }

    public BdSwitchView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.v.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.w.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final void x() {
        MsgSettingItemView msgSettingItemView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (msgSettingItemView = this.v) == null || this.w == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().j();
            this.w.setVisibility(8);
            this.w.getSwitchView().j();
            return;
        }
        msgSettingItemView.getSwitchView().m();
        this.w.getSwitchView().j();
    }

    public final void y(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, secretSettingActivity) == null) {
            this.b = (LinearLayout) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091792);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0925c2);
            this.a = navigationBar;
            this.c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setCenterTextTitle(secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ec));
            this.d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0903a2);
            this.e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a79);
            this.f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0914b6);
            this.k = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a7a);
            this.g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a7b);
            this.h = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a81);
            this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0921a9);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.l.findViewById(R.id.obfuscated_res_0x7f090fe7);
            this.v = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f06e4);
            this.v.setOnSwitchStateChangeListener(this.l);
            this.v.setTextSize(0, ej.f(this.l, R.dimen.obfuscated_res_0x7f0702b7));
            MsgSettingItemView msgSettingItemView2 = this.v;
            msgSettingItemView2.setPadding(msgSettingItemView2.getPaddingLeft() + 10, this.v.getPaddingTop() + 10, this.v.getPaddingRight() + 10, this.v.getPaddingBottom() + 10);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.l.findViewById(R.id.obfuscated_res_0x7f090fe8);
            this.w = msgSettingItemView3;
            msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f1229);
            this.w.setTextSize(0, ej.f(this.l, R.dimen.obfuscated_res_0x7f0702b7));
            MsgSettingItemView msgSettingItemView4 = this.w;
            msgSettingItemView4.setPadding(msgSettingItemView4.getPaddingLeft() + 10, this.w.getPaddingTop() + 10, this.w.getPaddingRight() + 10, this.w.getPaddingBottom() + 10);
            this.w.setOnSwitchStateChangeListener(this.l);
            this.i = secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0906e1);
            this.r = (ScrollView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091489);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091e31);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091e32);
            this.u = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091e33);
            this.c.setOnClickListener(this.x);
            this.d.setOnClickListener(this.x);
            this.k.setOnClickListener(this.x);
            this.e.setOnClickListener(this.x);
            this.f.setOnClickListener(this.x);
            this.g.setOnClickListener(this.x);
            this.h.setOnClickListener(this.x);
            this.j.setOnClickListener(this.x);
            this.m = this.l.findViewById(R.id.obfuscated_res_0x7f091a82);
            this.n = this.l.getResources().getStringArray(R.array.obfuscated_res_0x7f030012);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a80);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.x);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a78);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.x);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091a7c);
            this.q = tbSettingTextTipView3;
            tbSettingTextTipView3.setOnClickListener(this.x);
            UserData e = o75.d().e();
            if (e != null && e.getBazhuGradeData() != null && !StringUtils.isNull(e.getBazhuGradeData().getDesc()) && !StringUtils.isNull(e.getBazhuGradeData().getLevel())) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            x();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.g();
        }
    }
}
