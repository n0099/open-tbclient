package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.j0.b;
import c.a.p0.w0.m.c.f;
import c.a.p0.w0.m.d.a;
import c.a.p0.z3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f31929b;

    /* renamed from: c  reason: collision with root package name */
    public TbCornersImageView f31930c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f31931d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31932e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f31933f;

    /* renamed from: g  reason: collision with root package name */
    public int f31934g;

    /* renamed from: h  reason: collision with root package name */
    public int f31935h;
    public int i;
    public BdUniqueId j;
    public f k;
    public boolean l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public int u;
    public int v;
    public boolean w;
    public a x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellForumTestView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.l = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01d1, (ViewGroup) this, true);
            this.f31929b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0905af);
            this.f31930c = (TbCornersImageView) findViewById(R.id.obfuscated_res_0x7f0905b0);
            this.f31931d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0905ad);
            this.f31932e = (TextView) findViewById(R.id.obfuscated_res_0x7f0905ae);
            this.f31933f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f0905ac);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            this.f31933f.setTextSize(R.dimen.tbds42);
            this.f31933f.setConfig(aVar);
            int f2 = n.f(context, R.dimen.tbds10);
            this.f31930c.setCornerTopLeftRadius(f2);
            this.f31929b.setRadius(f2);
            this.f31929b.setConrers(3);
            this.f31929b.setPlaceHolder(3);
            this.f31929b.setDrawCorner(true);
            this.i = n.f(context, R.dimen.tbds262);
            this.f31931d.setOnClickListener(this);
            setOnClickListener(this);
            b();
        }
    }

    public void b() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        TbImageView tbImageView = this.f31929b;
        if (tbImageView != null) {
            tbImageView.setSkinType(skinType);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f31933f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f31930c, R.drawable.obfuscated_res_0x7f0807c0, SvgManager.SvgResourceStateType.NORMAL);
        if (skinType != 1 && skinType != 4) {
            ((ViewGroup.MarginLayoutParams) this.f31932e.getLayoutParams()).setMargins(0, 0, 0, 0);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(n.f(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(n.f(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(n.f(getContext(), R.dimen.tbds5)).into(this.f31932e);
        } else {
            ((ViewGroup.MarginLayoutParams) this.f31932e.getLayoutParams()).setMargins(n.f(getContext(), R.dimen.tbds4), 0, n.f(getContext(), R.dimen.tbds9), 0);
            float f2 = n.f(getContext(), R.dimen.tbds10);
            TBSelector.makeDrawableSelector().blRadius(f2).brRadius(f2).defaultColor(R.color.CAM_X0207).into(this.f31932e);
        }
        SkinManager.setImageResource(this.f31931d, R.drawable.icon_ba_close);
        SkinManager.setViewTextColor(this.f31932e, (int) R.color.CAM_X0105);
    }

    public f getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (f) invokeV.objValue;
    }

    public int getDataIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : invokeV.intValue;
    }

    public int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u : invokeV.intValue;
    }

    public float getMoveBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.t : invokeV.floatValue;
    }

    public float getMoveLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : invokeV.floatValue;
    }

    public float getMoveRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : invokeV.floatValue;
    }

    public float getMoveTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : invokeV.floatValue;
    }

    public float getViewBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.p : invokeV.floatValue;
    }

    public float getViewLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.floatValue;
    }

    public float getViewRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : invokeV.floatValue;
    }

    public float getViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.floatValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (this.f31931d == view) {
                if (l.A() && this.u == 1) {
                    TiebaStatic.log(new StatisticItem("c13373").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.k.a));
                    a aVar = this.x;
                    if (aVar != null) {
                        aVar.a(this.u);
                    }
                    RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                    requestTestCloseMessage.setTestId(this.k.a);
                    requestTestCloseMessage.setFromPage(1L);
                    MessageManager.getInstance().sendMessage(requestTestCloseMessage);
                }
            } else if (ViewHelper.checkUpIsLogin(getContext())) {
                TiebaStatic.log(new StatisticItem("c13372").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.k.a));
                int i2 = this.v;
                f fVar = this.k;
                if (fVar != null && i2 >= 0 && (l = c.a.p0.z3.a.l(true, "a065", "common_click", i, (i = i2 + 1), false, null, String.valueOf(fVar.a), 0)) != null) {
                    c.g().c(this.j, l);
                }
                if (!this.l) {
                    String q = b.k().q("enter_forum_test_id_list", "");
                    String[] split = q.split("[|]");
                    String str = this.k.a + "*" + TbadkCoreApplication.getCurrentAccountId();
                    StringBuilder sb = new StringBuilder();
                    if (split.length < 20) {
                        sb.append(q);
                        sb.append("|");
                        sb.append(str);
                    } else {
                        int i3 = 0;
                        for (String str2 : split) {
                            if (i3 != 0) {
                                sb.append(str2);
                                sb.append("|");
                            }
                            i3++;
                        }
                        sb.append(str);
                    }
                    b.k().y("enter_forum_test_id_list", sb.toString());
                }
                this.f31930c.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.k.a)));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            this.f31934g = View.MeasureSpec.getSize(i);
            this.f31935h = View.MeasureSpec.getSize(i2);
            if (!this.w) {
                this.f31929b.getLayoutParams().height = this.f31935h - this.i;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f31934g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f31935h, 1073741824));
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) || fVar == null) {
            return;
        }
        this.k = fVar;
        this.f31929b.J(fVar.f19515d ? fVar.f19516e : fVar.f19514c, 10, false);
        this.l = false;
        String q = b.k().q("enter_forum_test_id_list", "");
        String[] split = q.split("[|]");
        if (!StringUtils.isNull(q)) {
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str = split[i];
                if (!StringUtils.isNull(str)) {
                    if (str.equals(fVar.a + "*" + TbadkCoreApplication.getCurrentAccountId())) {
                        this.l = true;
                        break;
                    }
                }
                i++;
            }
        }
        this.f31930c.setVisibility(this.l ? 8 : 0);
        if (StringUtils.isNull(fVar.f19513b)) {
            this.f31932e.setText(R.string.obfuscated_res_0x7f0f0388);
        } else {
            this.f31932e.setText(fVar.f19513b);
        }
        this.f31933f.setText(getResources().getString(fVar.f19515d ? R.string.obfuscated_res_0x7f0f0386 : R.string.obfuscated_res_0x7f0f0387));
    }

    public void setDataIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.v = i;
        }
    }

    public void setForumTestDelClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.x = aVar;
        }
    }

    public void setIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.u = i;
            if (i == 1) {
                this.f31931d.setVisibility(0);
            } else {
                this.f31931d.setVisibility(8);
            }
        }
    }

    public void setIsScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.w = z;
        }
    }

    public void setMoveBottom(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.t = f2;
        }
    }

    public void setMoveLeft(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.q = f2;
        }
    }

    public void setMoveRight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            this.s = f2;
        }
    }

    public void setMoveTop(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.r = f2;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void setViewBottom(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            this.p = f2;
        }
    }

    public void setViewLeft(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            this.m = f2;
        }
    }

    public void setViewRight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f2) == null) {
            this.o = f2;
        }
    }

    public void setViewTop(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            this.n = f2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.l = false;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.l = false;
        a(context);
    }
}
