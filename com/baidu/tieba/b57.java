package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.sw8;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.z47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b57 extends BdBaseViewPagerAdapter.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z47 d;
    public boolean e;
    public LikeModel f;
    public sw8 g;
    public b h;
    public a05 i;
    public a05 j;
    public TbPageContext<?> k;
    public byte l;
    public TextView m;
    public BarImageView[] n;
    public TextView[] o;
    public TextView[] p;
    public TextView[] q;
    public TextView[] r;
    public TextView[] s;
    public FollowUserButton[] t;
    public final int[] u;
    public final int[] v;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends r9 implements sw8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z47.a a;
        public FollowUserButton b;
        public final /* synthetic */ b57 c;

        public b(b57 b57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b57Var;
        }

        public /* synthetic */ b(b57 b57Var, a aVar) {
            this(b57Var);
        }

        @Override // com.baidu.tieba.sw8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.c.e = false;
            }
        }

        @Override // com.baidu.tieba.sw8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.c.e = false;
                this.c.o(this.b, false);
                this.a.m(false);
            }
        }

        public void d(FollowUserButton followUserButton, z47.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, followUserButton, aVar) == null) {
                this.a = aVar;
                this.b = followUserButton;
            }
        }

        @Override // com.baidu.tieba.r9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.c.e = false;
                if (this.c.f.getErrorCode() == 22) {
                    zi.Q(this.c.k.getPageActivity(), this.c.k.getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.c.f.getErrorCode() != 0) {
                        zi.Q(this.c.k.getPageActivity(), this.c.f.getErrorString());
                        return;
                    }
                    this.c.o(this.b, true);
                    this.a.m(true);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b57(View view2, TbPageContext<?> tbPageContext, byte b2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, Byte.valueOf(b2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.i = new a05();
        this.j = new a05();
        this.n = new BarImageView[3];
        this.o = new TextView[3];
        this.p = new TextView[3];
        this.q = new TextView[3];
        this.r = new TextView[3];
        this.s = new TextView[3];
        this.t = new FollowUserButton[3];
        this.u = new int[]{R.id.obfuscated_res_0x7f091c4e, R.id.obfuscated_res_0x7f091c4f, R.id.obfuscated_res_0x7f091c50};
        this.v = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.k = tbPageContext;
        this.l = b2;
        k(view2);
    }

    public void m(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            TextView textView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void c(yn ynVar) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ynVar) != null) || !(ynVar instanceof z47)) {
            return;
        }
        z47 z47Var = (z47) ynVar;
        this.d = z47Var;
        this.m.setText(z47Var.a);
        z47.a[] aVarArr = this.d.d;
        if (aVarArr != null && aVarArr.length != 0) {
            int min = Math.min(3, aVarArr.length);
            for (int i3 = 0; i3 < min; i3++) {
                z47.a[] aVarArr2 = this.d.d;
                if (aVarArr2[i3] != null) {
                    this.n[i3].K(aVarArr2[i3].b(), 10, false);
                    this.p[i3].setText(this.d.d[i3].c());
                    this.s[i3].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1033, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.d[i3].f())}));
                    this.r[i3].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1031, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.d.d[i3].a())}));
                    this.t[i3].setTag(Integer.valueOf(i3));
                    o(this.t[i3], this.d.d[i3].l());
                    TextView textView = this.o[i3];
                    if (this.d.b) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    textView.setVisibility(i);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p[i3].getLayoutParams();
                    Activity pageActivity = this.k.getPageActivity();
                    if (this.d.b) {
                        i2 = R.dimen.tbds15;
                    } else {
                        i2 = R.dimen.tbds0;
                    }
                    layoutParams.leftMargin = zi.g(pageActivity, i2);
                    if (!StringUtils.isNull(this.d.d[i3].k())) {
                        this.q[i3].setText(this.d.d[i3].k());
                    } else if (!StringUtils.isNull(this.d.d[i3].h()) && UbsABTestHelper.isRecommendBarHotText()) {
                        this.q[i3].setText(this.d.d[i3].h());
                    } else {
                        this.q[i3].setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1032));
                    }
                }
            }
        }
    }

    public final void h(z47.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!zi.F()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0cd1));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.f == null) {
                LikeModel likeModel = new LikeModel(this.k);
                this.f = likeModel;
                likeModel.setLoadDataCallBack(this.h);
            }
            this.h.d(followUserButton, aVar);
            if (yi.isForumName(aVar.c())) {
                this.e = true;
                this.f.U();
                this.f.Y(aVar.c(), String.valueOf(aVar.g()));
            }
        }
    }

    public final void i(z47.a aVar, FollowUserButton followUserButton) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, followUserButton) != null) || this.e) {
            return;
        }
        if (!zi.F()) {
            UtilHelper.showToast(this.k.getPageActivity(), this.k.getString(R.string.obfuscated_res_0x7f0f0cd1));
        } else if (aVar == null || StringUtils.isNull(aVar.c()) || aVar.g() <= 0 || !ViewHelper.checkUpIsLogin(this.k.getPageActivity())) {
        } else {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            if (this.g == null) {
                sw8 sw8Var = new sw8();
                this.g = sw8Var;
                sw8Var.b(this.h);
            }
            this.h.d(followUserButton, aVar);
            this.e = true;
            this.g.c(aVar.c(), aVar.g());
        }
    }

    public z47 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (z47) invokeV.objValue;
    }

    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c51);
            this.i.v(R.color.CAM_X0109);
            this.i.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.t(R.color.CAM_X0304);
            this.j.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            this.j.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            int i = 0;
            while (i < 3) {
                View findViewById = view2.findViewById(this.u[i]);
                findViewById.setTag(Integer.valueOf(i));
                findViewById.setOnClickListener(this);
                this.n[i] = (BarImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f091c4d);
                this.o[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091c57);
                this.p[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091c53);
                this.q[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091c4c);
                this.r[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091c4a);
                this.s[i] = (TextView) findViewById.findViewById(R.id.obfuscated_res_0x7f091c55);
                this.t[i] = (FollowUserButton) findViewById.findViewById(R.id.obfuscated_res_0x7f091c49);
                this.t[i].setOnClickListener(this);
                int i2 = i + 1;
                this.o[i].setText(String.valueOf(i2));
                this.n[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                this.n[i].setShowInnerBorder(true);
                this.n[i].setStrokeWith(zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.n[i].setShowOval(true);
                this.n[i].setPlaceHolder(2);
                this.n[i].setShowOuterBorder(false);
                this.n[i].setStrokeColorResId(R.color.CAM_X0401);
                i = i2;
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view2) == null) && this.d != null && view2 != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            z47.a aVar = this.d.d[intValue];
            if (view2 instanceof TBSpecificationBtn) {
                if (aVar.l()) {
                    i(aVar, this.t[intValue]);
                    return;
                }
                h(aVar, this.t[intValue]);
                StatisticItem param = new StatisticItem("c13644").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
                if (!StringUtils.isNull(this.d.a)) {
                    param = param.param("obj_name", this.d.a);
                }
                TiebaStatic.log(param);
            } else if (id == R.id.obfuscated_res_0x7f091c4e || id == R.id.obfuscated_res_0x7f091c4f || id == R.id.obfuscated_res_0x7f091c50) {
                FrsActivityConfig callFrom = new FrsActivityConfig(this.k.getPageActivity()).createNormalCfg(aVar.c(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
                if (UbsABTestHelper.isRecommendBarHotText()) {
                    Intent intent = callFrom.getIntent();
                    if (aVar.i() != 0 && intent != null) {
                        intent.putExtra("transition_type", 0);
                        intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.i());
                    }
                }
                this.k.sendMessage(new CustomMessage(2003000, callFrom));
                StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.g()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.l);
                if (!StringUtils.isNull(this.d.a)) {
                    param2 = param2.param("obj_name", this.d.a);
                }
                TiebaStatic.log(param2);
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.o[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.o[i2], (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.v[i2]).cornerRadius(zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.o[i2]);
            }
            this.t[i2].onChangeSkinType(i);
            SkinManager.setViewTextColor(this.p[i2], (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r[i2], (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s[i2], (int) R.color.CAM_X0109);
        }
    }

    public void n(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.d == null) {
            return;
        }
        if (z) {
            o(this.t[i], true);
            this.d.d[i].m(true);
            return;
        }
        o(this.t[i], false);
        this.d.d[i].m(false);
    }

    public final void o(FollowUserButton followUserButton, boolean z) {
        a05 a05Var;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, followUserButton, z) != null) || followUserButton == null) {
            return;
        }
        if (z) {
            a05Var = this.i;
        } else {
            a05Var = this.j;
        }
        followUserButton.setConfig(a05Var);
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        if (z) {
            i = R.string.obfuscated_res_0x7f0f0676;
        } else {
            i = R.string.obfuscated_res_0x7f0f02ba;
        }
        followUserButton.setText(inst.getString(i));
        followUserButton.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
