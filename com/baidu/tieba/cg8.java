package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class cg8 extends a86<kf8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public View j;
    public ImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public kf8 s;
    public mf8 t;
    public UserData u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public View y;

    @Override // com.baidu.tieba.a86
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0721 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg8(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.y = h();
        int g = zi.g(this.c, R.dimen.M_W_X003);
        this.y.setPadding(g, 0, g, 0);
        this.v = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f09199d);
        this.w = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f09199e);
        this.j = this.y.findViewById(R.id.obfuscated_res_0x7f091034);
        this.k = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090c9c);
        this.o = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090c9f);
        this.l = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090ca0);
        this.m = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090c9e);
        this.n = (TextView) this.y.findViewById(R.id.function_desc);
        this.p = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091d0e);
        this.q = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090ca1);
        this.r = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f09058e);
        this.x = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f09058f);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.a86
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.i != i) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setImageResource(this.m, R.drawable.person_center_red_tip_shape);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            cx4 d = cx4.d(this.x);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            cx4 d2 = cx4.d(this.w);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            if (this.s.e.equals("更多")) {
                cx4 d3 = cx4.d(this.j);
                d3.m(2);
                d3.n(R.string.J_X06);
                d3.f(R.color.CAM_X0205);
            }
            this.i = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        z86<T> z86Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.j) {
            kf8 kf8Var = this.s;
            if (kf8Var.a == 36 && "游戏".equals(kf8Var.e) && (z86Var = this.e) != 0) {
                z86Var.a(view2, this.s);
                return;
            } else {
                r();
                return;
            }
        }
        s(view2);
    }

    public final void r() {
        kf8 kf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (kf8Var = this.s) == null) {
            return;
        }
        int i = kf8Var.a;
        if (i != 25) {
            if (i != 33) {
                if (i != 41) {
                    if (i != 61) {
                        if (i != 30) {
                            if (i != 31) {
                                switch (i) {
                                    case 10:
                                        PersonRedTipManager.getInstance().updateRedTipState(1, false, true);
                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                                        if (this.u != null) {
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getName_show(), this.u.getSex(), "iowner_gift")));
                                            return;
                                        }
                                        return;
                                    case 11:
                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                                        if (!StringUtils.isNull(this.s.g)) {
                                            UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                                            return;
                                        }
                                        return;
                                    case 12:
                                        PersonRedTipManager.getInstance().updateRedTipState(7, false, true);
                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 12));
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.b.getPageActivity())));
                                        return;
                                    default:
                                        switch (i) {
                                            case 16:
                                                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
                                                PersonRedTipManager.getInstance().updateRedTipState(3, false, true);
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.b.getPageActivity())));
                                                return;
                                            case 17:
                                                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.b.getPageActivity())));
                                                return;
                                            case 18:
                                                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 15));
                                                UrlManager.getInstance().dealOneLink(this.b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                                                return;
                                            default:
                                                switch (i) {
                                                    case 36:
                                                        TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.s.k));
                                                        t(this.s.g);
                                                        return;
                                                    case 37:
                                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                                                        cz4.l().v("key_has_borrow_cash_clicked", true);
                                                        mf8 mf8Var = this.s.i;
                                                        if (mf8Var != null) {
                                                            mf8Var.a = false;
                                                        }
                                                        this.m.setVisibility(8);
                                                        String r = cz4.l().r("cash_pay", "");
                                                        if (!StringUtils.isNull(r)) {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, r));
                                                            return;
                                                        }
                                                        return;
                                                    case 38:
                                                        ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                                                        if (activityPrizeData.isPersonItemSwitch()) {
                                                            String h5Url = activityPrizeData.getH5Url();
                                                            if (!StringUtils.isNull(h5Url)) {
                                                                TiebaStatic.log(new StatisticItem("c12598"));
                                                                PersonRedTipManager.getInstance().updateRedTipState(9, false, true);
                                                                UrlManager.getInstance().dealOneLink(g(), new String[]{h5Url}, true);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    case 39:
                                                        BrowserHelper.A(true, this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02e4), TbConfig.URL_BAIDU_SINGKIL);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case 43:
                                                                v();
                                                                BrowserHelper.p(this.b.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                                                                return;
                                                            case 44:
                                                                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                                                                if (!TextUtils.isEmpty(this.s.g)) {
                                                                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                                                                }
                                                                if (!yi.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.third_lite_game_center)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                                                                    return;
                                                                } else {
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.baidu_lite_game_center)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                                                                    return;
                                                                }
                                                            case 45:
                                                                if (!TextUtils.isEmpty(kf8Var.g)) {
                                                                    BrowserHelper.p(this.c, this.s.g);
                                                                }
                                                                StatisticItem.make("c13548").eventStat();
                                                                return;
                                                            case 46:
                                                                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g}, true);
                                                                return;
                                                            case 47:
                                                                if (!TextUtils.isEmpty(kf8Var.g)) {
                                                                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                                                                    return;
                                                                }
                                                                return;
                                                            case 48:
                                                                if (!TextUtils.isEmpty(kf8Var.g)) {
                                                                    BrowserHelper.p(this.c, this.s.g);
                                                                    return;
                                                                }
                                                                return;
                                                            case 49:
                                                                if (!TextUtils.isEmpty(kf8Var.g)) {
                                                                    BrowserHelper.c = true;
                                                                    BrowserHelper.p(this.c, this.s.g);
                                                                    return;
                                                                }
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                            }
                            PersonRedTipManager.getInstance().updateRedTipState(10, false, true);
                            cz4.l().v("key_feedback_tip_show", false);
                            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                            if (getContext() != null) {
                                getContext().startActivity(f49.a());
                            }
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SERVICE_CENTER_CLICK);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                        t49.b();
                        return;
                    }
                    mf8 mf8Var2 = kf8Var.i;
                    if (mf8Var2 != null && mf8Var2.a) {
                        mf8Var2.a = false;
                        this.m.setVisibility(8);
                        cz4.l().x("setting_private_red_dot", 0);
                    }
                    u();
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                cz4.l().v("key_baidu_financial_has_clicked", true);
                mf8 mf8Var3 = this.s.i;
                if (mf8Var3 != null) {
                    mf8Var3.a = false;
                }
                this.m.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.b.getPageActivity(), this.s.j)));
        } else if (this.u != null) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getPortrait(), this.u.getSex(), true)));
        }
    }

    public final void s(View view2) {
        kf8 kf8Var;
        mf8 mf8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (kf8Var = this.s) != null && view2 == this.p) {
            int i = kf8Var.a;
            if (i != 10) {
                if (i == 45 && (mf8Var = this.t) != null && !TextUtils.isEmpty(mf8Var.d)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.d});
                    return;
                }
                return;
            }
            CurrencyJumpHelper.personGotoBuyBean(this.b.getPageActivity());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a86
    /* renamed from: w */
    public void i(kf8 kf8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, kf8Var) != null) || kf8Var == null) {
            return;
        }
        this.s = kf8Var;
        this.u = kf8Var.h;
        this.t = kf8Var.i;
        this.l.setText(kf8Var.e);
        if (this.s.e.equals("服务中心")) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        y();
        z(this.t);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            x(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst("nohead:url=", ""));
            String str2 = "?";
            if (str.contains("?")) {
                str2 = "&";
            }
            sb.append(str2);
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.b, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                zi.P(this.b.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            BrowserHelper.y(this.b.getPageActivity(), true, str);
        }
    }

    public final void z(mf8 mf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mf8Var) == null) {
            if (mf8Var != null) {
                if (mf8Var.a) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (!StringUtils.isNull(mf8Var.b)) {
                    this.n.setVisibility(0);
                    this.n.setText(mf8Var.b);
                } else {
                    this.n.setVisibility(8);
                }
                if (mf8Var.h) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                if (!TextUtils.isEmpty(mf8Var.c)) {
                    this.p.setVisibility(0);
                    this.p.setText(mf8Var.c);
                    TextView textView = this.p;
                    Drawable drawable = mf8Var.e;
                    Drawable drawable2 = mf8Var.f;
                    Drawable drawable3 = mf8Var.g;
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable3);
                    return;
                }
                this.p.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext().getPageActivity())));
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.s.b > 0) {
                this.k.setVisibility(0);
                kf8 kf8Var = this.s;
                if (kf8Var.c) {
                    if (kf8Var.d) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, this.s.b, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, this.s.b, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.k, kf8Var.b);
                return;
            }
            this.k.setVisibility(8);
        }
    }
}
