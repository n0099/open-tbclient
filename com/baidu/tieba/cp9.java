package com.baidu.tieba;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.personCenter.model.PersonCreatorModel;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterDataView;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterFunView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CreationData;
/* loaded from: classes5.dex */
public class cp9 extends em6<jo9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCreatorCenterDataView A;
    public LinearLayout B;
    public LinearLayout C;
    public LinearLayout D;
    public LinearLayout E;
    public FrameLayout F;
    public TextView G;
    public TextView H;
    public TextView I;
    public View J;
    public View K;
    public View L;
    public PersonCreatorCenterFunView M;
    public PersonCreatorCenterFunView N;
    public PersonCreatorCenterFunView O;
    public PersonCreatorCenterFunView P;
    public boolean Q;
    public boolean R;
    public PersonCreatorModel i;
    public TbPageContext j;
    public LinearLayout k;
    public LinearLayout l;
    public LinearLayout m;
    public TBSpecificationBtn n;
    public TBSpecificationBtn o;
    public PersonCreatorCenterFunView p;
    public PersonCreatorCenterFunView q;
    public PersonCreatorCenterFunView r;
    public PersonCreatorCenterDataView s;
    public PersonCreatorCenterDataView t;
    public PersonCreatorCenterDataView u;
    public ImageView v;
    public PersonCreatorCenterFunView w;
    public PersonCreatorCenterFunView x;
    public PersonCreatorCenterDataView y;
    public PersonCreatorCenterDataView z;

    @Override // com.baidu.tieba.em6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07d7 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp9(TbPageContext<?> tbPageContext) {
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
        this.j = tbPageContext;
        this.i = new PersonCreatorModel(tbPageContext);
        this.L = h();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.L.setPadding(dimens, 0, dimens, 0);
        LinearLayout linearLayout = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091bb0);
        this.B = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091bab);
        this.C = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091bb1);
        this.D = linearLayout3;
        linearLayout3.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091240);
        this.F = frameLayout;
        frameLayout.setOnClickListener(this);
        this.G = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f091baf);
        this.I = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f091baa);
        this.J = this.L.findViewById(R.id.obfuscated_res_0x7f090409);
        this.K = this.L.findViewById(R.id.obfuscated_res_0x7f090408);
        this.l = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091bd8);
        this.m = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091bd7);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.L.findViewById(R.id.obfuscated_res_0x7f0907e2);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setText("投稿");
        this.H = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f09081f);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.L.findViewById(R.id.obfuscated_res_0x7f091507);
        this.o = tBSpecificationBtn2;
        tBSpecificationBtn2.setText("立即开通");
        PersonCreatorCenterFunView personCreatorCenterFunView = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bd0);
        this.p = personCreatorCenterFunView;
        personCreatorCenterFunView.a(R.drawable.obfuscated_res_0x7f080a1a, this.j.getString(R.string.obfuscated_res_0x7f0f050b));
        PersonCreatorCenterFunView personCreatorCenterFunView2 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bd1);
        this.q = personCreatorCenterFunView2;
        personCreatorCenterFunView2.a(R.drawable.obfuscated_res_0x7f080a13, this.j.getString(R.string.obfuscated_res_0x7f0f17ef));
        PersonCreatorCenterFunView personCreatorCenterFunView3 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bcf);
        this.r = personCreatorCenterFunView3;
        personCreatorCenterFunView3.a(R.drawable.obfuscated_res_0x7f080a16, this.j.getString(R.string.video_data));
        this.s = (PersonCreatorCenterDataView) this.L.findViewById(R.id.obfuscated_res_0x7f092a77);
        this.t = (PersonCreatorCenterDataView) this.L.findViewById(R.id.obfuscated_res_0x7f092a76);
        this.u = (PersonCreatorCenterDataView) this.L.findViewById(R.id.obfuscated_res_0x7f092a74);
        this.k = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091bd5);
        this.v = (ImageView) this.L.findViewById(R.id.obfuscated_res_0x7f091ba9);
        PersonCreatorCenterFunView personCreatorCenterFunView4 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bce);
        this.w = personCreatorCenterFunView4;
        personCreatorCenterFunView4.a(R.drawable.obfuscated_res_0x7f0809ee, this.j.getString(R.string.tieba_string_god_guide));
        PersonCreatorCenterFunView personCreatorCenterFunView5 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bd2);
        this.x = personCreatorCenterFunView5;
        personCreatorCenterFunView5.a(R.drawable.obfuscated_res_0x7f080a16, this.j.getString(R.string.tieba_string_post_data));
        this.y = (PersonCreatorCenterDataView) this.L.findViewById(R.id.obfuscated_res_0x7f092a79);
        this.z = (PersonCreatorCenterDataView) this.L.findViewById(R.id.obfuscated_res_0x7f092a78);
        this.A = (PersonCreatorCenterDataView) this.L.findViewById(R.id.obfuscated_res_0x7f092a75);
        PersonCreatorCenterFunView personCreatorCenterFunView6 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bd6);
        this.M = personCreatorCenterFunView6;
        personCreatorCenterFunView6.a(R.drawable.obfuscated_res_0x7f080a4f, this.j.getString(R.string.obfuscated_res_0x7f0f0e2b));
        PersonCreatorCenterFunView personCreatorCenterFunView7 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bd4);
        this.N = personCreatorCenterFunView7;
        personCreatorCenterFunView7.a(R.drawable.obfuscated_res_0x7f080d3f, this.j.getString(R.string.obfuscated_res_0x7f0f109a));
        PersonCreatorCenterFunView personCreatorCenterFunView8 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bcd);
        this.O = personCreatorCenterFunView8;
        personCreatorCenterFunView8.a(R.drawable.obfuscated_res_0x7f080af6, this.j.getString(R.string.obfuscated_res_0x7f0f06d5));
        PersonCreatorCenterFunView personCreatorCenterFunView9 = (PersonCreatorCenterFunView) this.L.findViewById(R.id.obfuscated_res_0x7f091bd3);
        this.P = personCreatorCenterFunView9;
        personCreatorCenterFunView9.a(R.drawable.obfuscated_res_0x7f08094c, this.j.getString(R.string.obfuscated_res_0x7f0f0c82));
        if (Build.VERSION.SDK_INT < 24) {
            LinearLayout linearLayout4 = (LinearLayout) this.L.findViewById(R.id.obfuscated_res_0x7f091c31);
            this.E = linearLayout4;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.c, R.dimen.tbds37);
            this.E.setLayoutParams(layoutParams);
        }
        j(tbPageContext, this.a);
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TbWebViewActivityConfig activityConfig = BrowserHelper.getActivityConfig(getContext(), "", str, true);
            activityConfig.setFixTitle(true);
            activityConfig.start();
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.Q = z;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.R = z;
            r();
        }
    }

    @Override // com.baidu.tieba.em6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0204);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            EMManager.from(this.l).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.k).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.m).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.w.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.x.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.z.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.z.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (R.id.obfuscated_res_0x7f091bb0 == view2.getId()) {
                tsa tsaVar = new tsa(g(), (ViewGroup) h(), "person", 3, null);
                tsaVar.h("5");
                tsaVar.f(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_PERSON);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", "9"));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f091bab == view2.getId()) {
                t(TbConfig.URL_CREATE_CENTER);
                TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "2"));
                TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f091bb1 == view2.getId()) {
                this.i.O(true);
            } else if (R.id.obfuscated_res_0x7f091240 == view2.getId()) {
                WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(getContext());
                workPublishGuideActivityConfig.setRequestCode(25064);
                workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && UtilHelper.isViewPrimary(this.w, true) && this.R) {
            new StatisticItem("c15051").param("uid", TbadkCoreApplication.getCurrentAccountId()).eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.em6
    /* renamed from: s */
    public void i(jo9 jo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jo9Var) == null) {
            if (jo9Var == null) {
                q(8);
                return;
            }
            CreationData d = jo9Var.d();
            if (d == null) {
                this.l.setVisibility(8);
                this.m.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                this.s.a(d.view_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f18f3), d.view_count_trend.intValue());
                this.t.a(d.valid_play_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f18f4), d.valid_play_count_trend.intValue());
                this.u.a(d.agree_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f18f5), d.agree_count_trend.intValue());
            }
            if (TbSingleton.getInstance().getNewGodData() != null) {
                NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                if (!StringUtils.isNull(newGodData.getFieldName()) && newGodData.getStatus() == 3) {
                    this.x.a(R.drawable.obfuscated_res_0x7f080a16, this.j.getString(R.string.tieba_string_auth_data));
                    this.w.a(R.drawable.obfuscated_res_0x7f0809ee, this.j.getString(R.string.tieba_string_god_examine));
                } else {
                    this.x.a(R.drawable.obfuscated_res_0x7f080a16, this.j.getString(R.string.tieba_string_post_data));
                    this.w.a(R.drawable.obfuscated_res_0x7f0809ee, this.j.getString(R.string.tieba_string_god_guide));
                }
            }
            if (this.Q) {
                y(this.w, this.j.getString(R.string.tieba_look_god_examine));
            }
            CreationData c = jo9Var.c();
            if (c != null) {
                this.y.a(c.view_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f18f0), c.view_count_trend.intValue());
                this.z.a(c.agree_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f18f2), c.agree_count_trend.intValue());
                this.A.a(c.comment_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f18f1), c.comment_trend.intValue());
            }
            j(this.j, this.a);
        }
    }

    public final void y(View view2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, view2, str) == null) && view2 != null && !StringUtils.isNull(str) && view2.getVisibility() == 0) {
            lr6 lr6Var = new lr6(this.j, view2);
            lr6Var.L(R.drawable.bg_tip_blue_up_left);
            lr6Var.o(16);
            lr6Var.x(true);
            lr6Var.Q(42);
            lr6Var.R(0);
            lr6Var.n(3000);
            lr6Var.S(str);
            this.Q = false;
        }
    }
}
