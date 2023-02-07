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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eu8 extends v9<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public transient /* synthetic */ FieldHolder $fh;
    public TbSettingTextTipView A;
    public TbSettingTextTipView B;
    public TbSettingTextTipView C;
    public TbSettingTextTipView D;
    public TbSettingTextTipView E;
    public View.OnClickListener F;
    public b G;
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
    public TextView x;
    public TbSettingTextTipView y;
    public TbSettingTextTipView z;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu8 a;

        public a(eu8 eu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eu8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.G == null) {
                return;
            }
            if (view2 == this.a.c) {
                this.a.G.onBackPressed();
            } else if (view2 == this.a.d) {
                this.a.G.i();
            } else if (view2 == this.a.e) {
                this.a.G.g();
            } else if (view2 == this.a.g) {
                this.a.G.c();
            } else if (view2 == this.a.h) {
                this.a.G.h();
            } else if (view2 == this.a.k) {
                this.a.G.e();
            } else if (view2 == this.a.j) {
                this.a.G.a();
            } else if (view2 == this.a.o) {
                this.a.G.f();
            } else if (view2 == this.a.p) {
                this.a.G.j();
            } else if (view2 == this.a.f) {
                this.a.G.d();
            } else if (view2 == this.a.q) {
                this.a.G.b();
            } else if (view2 == this.a.y) {
                UrlManager.getInstance().dealOneLink(this.a.l.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/eula_mobile.html"});
            } else if (view2 == this.a.z) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<SecretSettingActivity> pageContext = this.a.l.getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{eu8.H + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
            } else if (view2 == this.a.A) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.l.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/mobile/wisemainstatic/secretright.html"}, true);
                TbSingleton.getInstance().needRefreshForumSquare = true;
            } else if (view2 == this.a.B) {
                UrlManager urlManager2 = UrlManager.getInstance();
                TbPageContext<SecretSettingActivity> pageContext2 = this.a.l.getPageContext();
                urlManager2.dealOneLink(pageContext2, new String[]{eu8.I + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
            } else if (view2 == this.a.C) {
                if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.a.l.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/yy/agreement.html"});
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.l.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/tdou_mobile.html"});
            } else if (view2 == this.a.D) {
                UrlManager urlManager3 = UrlManager.getInstance();
                TbPageContext<SecretSettingActivity> pageContext3 = this.a.l.getPageContext();
                urlManager3.dealOneLink(pageContext3, new String[]{eu8.J + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
            } else if (view2 == this.a.E) {
                UrlManager urlManager4 = UrlManager.getInstance();
                TbPageContext<SecretSettingActivity> pageContext4 = this.a.l.getPageContext();
                urlManager4.dealOneLink(pageContext4, new String[]{eu8.K + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746945, "Lcom/baidu/tieba/eu8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746945, "Lcom/baidu/tieba/eu8;");
                return;
            }
        }
        H = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/privacy-policy";
        I = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/app-permissions";
        J = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/security-check";
        K = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/third-list";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eu8(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {secretSettingActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((x9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.F = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d07ca);
        M(secretSettingActivity);
    }

    public BdSwitchView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.v.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.w.getSwitchView();
        }
        return (BdSwitchView) invokeV.objValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.g();
        }
    }

    public void O(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.G = bVar;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
        }
    }

    public final void L() {
        MsgSettingItemView msgSettingItemView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (msgSettingItemView = this.v) != null && this.w != null && (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) != 0) {
            if (i != 1) {
                msgSettingItemView.getSwitchView().j();
                this.w.setVisibility(8);
                this.w.getSwitchView().j();
                return;
            }
            msgSettingItemView.getSwitchView().m();
            this.w.getSwitchView().j();
        }
    }

    public final void M(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, secretSettingActivity) == null) {
            this.b = (LinearLayout) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091883);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            this.c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setCenterTextTitle(secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1189));
            this.d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0903a9);
            this.e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b58);
            this.f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09159e);
            this.k = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b59);
            this.g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b5a);
            this.h = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b61);
            this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0922b8);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.l.findViewById(R.id.obfuscated_res_0x7f0910c4);
            this.v = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f0727);
            this.v.setOnSwitchStateChangeListener(this.l);
            this.v.setTextSize(0, ej.g(this.l, R.dimen.obfuscated_res_0x7f0702b7));
            MsgSettingItemView msgSettingItemView2 = this.v;
            msgSettingItemView2.setPadding(msgSettingItemView2.getPaddingLeft() + 10, this.v.getPaddingTop() + 10, this.v.getPaddingRight() + 10, this.v.getPaddingBottom() + 10);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.l.findViewById(R.id.obfuscated_res_0x7f0910c5);
            this.w = msgSettingItemView3;
            msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f12d3);
            this.w.setTextSize(0, ej.g(this.l, R.dimen.obfuscated_res_0x7f0702b7));
            MsgSettingItemView msgSettingItemView4 = this.w;
            msgSettingItemView4.setPadding(msgSettingItemView4.getPaddingLeft() + 10, this.w.getPaddingTop() + 10, this.w.getPaddingRight() + 10, this.w.getPaddingBottom() + 10);
            this.w.setOnSwitchStateChangeListener(this.l);
            this.i = secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09071b);
            this.r = (ScrollView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09156d);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091f26);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091f27);
            this.u = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091f28);
            this.c.setOnClickListener(this.F);
            this.d.setOnClickListener(this.F);
            this.k.setOnClickListener(this.F);
            this.e.setOnClickListener(this.F);
            this.f.setOnClickListener(this.F);
            this.g.setOnClickListener(this.F);
            this.h.setOnClickListener(this.F);
            this.j.setOnClickListener(this.F);
            this.m = this.l.findViewById(R.id.obfuscated_res_0x7f091b62);
            this.n = this.l.getResources().getStringArray(R.array.privacy_setting_config);
            this.k.setVisibility(8);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b5f);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b57);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091b5b);
            this.q = tbSettingTextTipView3;
            tbSettingTextTipView3.setOnClickListener(this.F);
            UserData e = he5.d().e();
            if (e != null && e.getBazhuGradeData() != null && !StringUtils.isNull(e.getBazhuGradeData().getDesc()) && !StringUtils.isNull(e.getBazhuGradeData().getLevel())) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.x = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f091b60);
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f0922cf);
            this.y = tbSettingTextTipView4;
            tbSettingTextTipView4.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView5 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f0922ce);
            this.z = tbSettingTextTipView5;
            tbSettingTextTipView5.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView6 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f0922cd);
            this.A = tbSettingTextTipView6;
            tbSettingTextTipView6.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView7 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f0922cc);
            this.B = tbSettingTextTipView7;
            tbSettingTextTipView7.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView8 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f0922d0);
            this.C = tbSettingTextTipView8;
            tbSettingTextTipView8.setOnClickListener(this.F);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.C.setText(R.string.obfuscated_res_0x7f0f1714);
            } else {
                this.C.setText(R.string.obfuscated_res_0x7f0f147a);
            }
            TbSettingTextTipView tbSettingTextTipView9 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f091a77);
            this.D = tbSettingTextTipView9;
            tbSettingTextTipView9.setOnClickListener(this.F);
            TbSettingTextTipView tbSettingTextTipView10 = (TbSettingTextTipView) this.l.findViewById(R.id.obfuscated_res_0x7f092284);
            this.E = tbSettingTextTipView10;
            tbSettingTextTipView10.setOnClickListener(this.F);
            L();
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
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

    public void R(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            if (i2 == 3 && i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0b4b));
            } else if (i2 == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0b4a));
            } else if (i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0b4c));
            } else {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0b49));
            }
        }
    }

    public void S(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) {
            int i2 = i - 1;
            String[] strArr = this.n;
            if (strArr != null && i2 < strArr.length && i2 >= 0) {
                if (TextUtils.equals(str, "like")) {
                    this.e.setTip(this.n[i2]);
                } else if (TextUtils.equals(str, "group")) {
                    this.k.setTip(this.n[i2]);
                } else if (TextUtils.equals(str, "live")) {
                    this.g.setTip(this.n[i2]);
                } else if (TextUtils.equals(str, "reply")) {
                    if (i2 == 0) {
                        this.j.setTip(this.l.getString(R.string.all_person));
                    } else {
                        this.j.setTip(this.n[i2]);
                    }
                } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, "bazhu_show_outside")) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    R(p35.m().n(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), p35.m().n("bazhu_show_outside" + currentAccount, 0));
                }
            }
        }
    }

    public void T(cu8 cu8Var) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, cu8Var) == null) && cu8Var != null && (strArr = this.n) != null) {
            int length = strArr.length;
            int d = cu8Var.d() - 1;
            if (d < length && d >= 0) {
                this.k.setTip(this.n[d]);
            }
            int c = cu8Var.c() - 1;
            if (c < length && c >= 0) {
                this.e.setTip(this.n[c]);
            }
            int e = cu8Var.e() - 1;
            if (e < length && e >= 0) {
                this.g.setTip(this.n[e]);
            }
            int g = cu8Var.g() - 1;
            if (g < length && g >= 0) {
                if (g == 0) {
                    this.j.setTip(this.l.getString(R.string.all_person));
                } else {
                    this.j.setTip(this.n[g]);
                }
            }
            R(cu8Var.a(), cu8Var.b());
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            qv4 layoutMode = this.l.getLayoutMode();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.l.getLayoutMode().k(this.b);
            this.a.onChangeSkinType(this.l.getPageContext(), i);
            p15.d(this.s).v(R.color.CAM_X0108);
            p15.d(this.t).v(R.color.CAM_X0108);
            p15.d(this.u).v(R.color.CAM_X0108);
            p15.d(this.x).v(R.color.CAM_X0108);
            p15.d(this.r).f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.E, R.color.CAM_X0205);
            this.v.c(this.l.getPageContext(), i);
            this.w.c(this.l.getPageContext(), i);
        }
    }
}
