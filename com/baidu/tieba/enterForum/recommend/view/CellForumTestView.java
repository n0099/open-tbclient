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
import com.repackage.bj8;
import com.repackage.dj8;
import com.repackage.ku4;
import com.repackage.l66;
import com.repackage.m66;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.vt4;
/* loaded from: classes3.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public TbCornersImageView c;
    public ImageView d;
    public TextView e;
    public TBSpecificationBtn f;
    public int g;
    public int h;
    public int i;
    public BdUniqueId j;
    public l66 k;
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
    public m66 x;

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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01d2, (ViewGroup) this, true);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0905b9);
            this.c = (TbCornersImageView) findViewById(R.id.obfuscated_res_0x7f0905ba);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0905b7);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0905b8);
            this.f = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f0905b6);
            ku4 ku4Var = new ku4();
            this.f.setTextSize(R.dimen.tbds42);
            this.f.setConfig(ku4Var);
            int f = oi.f(context, R.dimen.tbds10);
            this.c.setCornerTopLeftRadius(f);
            this.b.setRadius(f);
            this.b.setConrers(3);
            this.b.setPlaceHolder(3);
            this.b.setDrawCorner(true);
            this.i = oi.f(context, R.dimen.tbds262);
            this.d.setOnClickListener(this);
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
        TbImageView tbImageView = this.b;
        if (tbImageView != null) {
            tbImageView.setSkinType(skinType);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f0807c3, SvgManager.SvgResourceStateType.NORMAL);
        if (skinType != 1 && skinType != 4) {
            ((ViewGroup.MarginLayoutParams) this.e.getLayoutParams()).setMargins(0, 0, 0, 0);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(oi.f(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(oi.f(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(oi.f(getContext(), R.dimen.tbds5)).into(this.e);
        } else {
            ((ViewGroup.MarginLayoutParams) this.e.getLayoutParams()).setMargins(oi.f(getContext(), R.dimen.tbds4), 0, oi.f(getContext(), R.dimen.tbds9), 0);
            float f = oi.f(getContext(), R.dimen.tbds10);
            TBSelector.makeDrawableSelector().blRadius(f).brRadius(f).defaultColor(R.color.CAM_X0207).into(this.e);
        }
        SkinManager.setImageResource(this.d, R.drawable.icon_ba_close);
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
    }

    public l66 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (l66) invokeV.objValue;
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
    public void onClick(View view2) {
        int i;
        StatisticItem j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            if (this.d == view2) {
                if (mi.A() && this.u == 1) {
                    TiebaStatic.log(new StatisticItem("c13373").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.k.a));
                    m66 m66Var = this.x;
                    if (m66Var != null) {
                        m66Var.a(this.u);
                    }
                    RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                    requestTestCloseMessage.setTestId(this.k.a);
                    requestTestCloseMessage.setFromPage(1L);
                    MessageManager.getInstance().sendMessage(requestTestCloseMessage);
                }
            } else if (ViewHelper.checkUpIsLogin(getContext())) {
                TiebaStatic.log(new StatisticItem("c13372").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.k.a));
                int i2 = this.v;
                l66 l66Var = this.k;
                if (l66Var != null && i2 >= 0 && (j = bj8.j(true, "a065", "common_click", i, (i = i2 + 1), false, null, String.valueOf(l66Var.a), 0)) != null) {
                    dj8.g().c(this.j, j);
                }
                if (!this.l) {
                    String q = vt4.k().q("enter_forum_test_id_list", "");
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
                    vt4.k().y("enter_forum_test_id_list", sb.toString());
                }
                this.c.setVisibility(8);
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
            this.g = View.MeasureSpec.getSize(i);
            this.h = View.MeasureSpec.getSize(i2);
            if (!this.w) {
                this.b.getLayoutParams().height = this.h - this.i;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
        }
    }

    public void setData(l66 l66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, l66Var) == null) || l66Var == null) {
            return;
        }
        this.k = l66Var;
        this.b.K(l66Var.d ? l66Var.e : l66Var.c, 10, false);
        this.l = false;
        String q = vt4.k().q("enter_forum_test_id_list", "");
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
                    if (str.equals(l66Var.a + "*" + TbadkCoreApplication.getCurrentAccountId())) {
                        this.l = true;
                        break;
                    }
                }
                i++;
            }
        }
        this.c.setVisibility(this.l ? 8 : 0);
        if (StringUtils.isNull(l66Var.b)) {
            this.e.setText(R.string.obfuscated_res_0x7f0f038a);
        } else {
            this.e.setText(l66Var.b);
        }
        this.f.setText(getResources().getString(l66Var.d ? R.string.obfuscated_res_0x7f0f0388 : R.string.obfuscated_res_0x7f0f0389));
    }

    public void setDataIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.v = i;
        }
    }

    public void setForumTestDelClickListener(m66 m66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, m66Var) == null) {
            this.x = m66Var;
        }
    }

    public void setIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.u = i;
            if (i == 1) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void setIsScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.w = z;
        }
    }

    public void setMoveBottom(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
            this.t = f;
        }
    }

    public void setMoveLeft(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f) == null) {
            this.q = f;
        }
    }

    public void setMoveRight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f) == null) {
            this.s = f;
        }
    }

    public void setMoveTop(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f) == null) {
            this.r = f;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void setViewBottom(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f) == null) {
            this.p = f;
        }
    }

    public void setViewLeft(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f) == null) {
            this.m = f;
        }
    }

    public void setViewRight(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f) == null) {
            this.o = f;
        }
    }

    public void setViewTop(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f) == null) {
            this.n = f;
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
