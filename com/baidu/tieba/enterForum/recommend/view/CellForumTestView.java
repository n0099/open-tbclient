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
import androidx.webkit.ProxyConfig;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.s.g0.b;
import c.a.s0.u0.k.c.f;
import c.a.s0.u0.k.d.a;
import c.a.s0.u3.c;
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
/* loaded from: classes12.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public a B;

    /* renamed from: e  reason: collision with root package name */
    public int f44069e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44070f;

    /* renamed from: g  reason: collision with root package name */
    public TbCornersImageView f44071g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f44072h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f44073i;

    /* renamed from: j  reason: collision with root package name */
    public TBSpecificationBtn f44074j;

    /* renamed from: k  reason: collision with root package name */
    public int f44075k;
    public int l;
    public int m;
    public BdUniqueId n;
    public f o;
    public boolean p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public int y;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellForumTestView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44069e = 3;
        this.p = false;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
            this.f44070f = (TbImageView) findViewById(R.id.cell_forum_test_img);
            this.f44071g = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
            this.f44072h = (ImageView) findViewById(R.id.cell_forum_test_del);
            this.f44073i = (TextView) findViewById(R.id.cell_forum_test_des);
            this.f44074j = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
            c.a.r0.s.i0.n.a aVar = new c.a.r0.s.i0.n.a();
            this.f44074j.setTextSize(R.dimen.tbds42);
            this.f44074j.setConfig(aVar);
            int f2 = m.f(context, R.dimen.tbds10);
            this.f44071g.setCornerTopLeftRadius(f2);
            this.f44070f.setRadius(f2);
            this.f44070f.setConrers(3);
            this.f44070f.setPlaceHolder(3);
            this.f44070f.setDrawCorner(true);
            this.m = m.f(context, R.dimen.tbds262);
            this.f44072h.setOnClickListener(this);
            setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public f getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : (f) invokeV.objValue;
    }

    public int getDataIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.z : invokeV.intValue;
    }

    public int getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.y : invokeV.intValue;
    }

    public float getMoveBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : invokeV.floatValue;
    }

    public float getMoveLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : invokeV.floatValue;
    }

    public float getMoveRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : invokeV.floatValue;
    }

    public float getMoveTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.v : invokeV.floatValue;
    }

    public float getViewBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.t : invokeV.floatValue;
    }

    public float getViewLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : invokeV.floatValue;
    }

    public float getViewRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : invokeV.floatValue;
    }

    public float getViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.r : invokeV.floatValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f44069e) {
            return;
        }
        this.f44069e = skinType;
        TbImageView tbImageView = this.f44070f;
        if (tbImageView != null) {
            tbImageView.setSkinType(skinType);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f44074j;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.changeSkinType();
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f44071g, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
        if (skinType != 1 && skinType != 4) {
            ((ViewGroup.MarginLayoutParams) this.f44073i.getLayoutParams()).setMargins(0, 0, 0, 0);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(m.f(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(m.f(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(m.f(getContext(), R.dimen.tbds5)).into(this.f44073i);
        } else {
            ((ViewGroup.MarginLayoutParams) this.f44073i.getLayoutParams()).setMargins(m.f(getContext(), R.dimen.tbds4), 0, m.f(getContext(), R.dimen.tbds9), 0);
            float f2 = m.f(getContext(), R.dimen.tbds10);
            TBSelector.makeDrawableSelector().blRadius(f2).brRadius(f2).defaultColor(R.color.CAM_X0207).into(this.f44073i);
        }
        SkinManager.setImageResource(this.f44072h, R.drawable.icon_ba_close);
        SkinManager.setViewTextColor(this.f44073i, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (this.f44072h == view) {
                if (k.A() && this.y == 1) {
                    TiebaStatic.log(new StatisticItem("c13373").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.o.a));
                    a aVar = this.B;
                    if (aVar != null) {
                        aVar.onDelClick(this.y);
                    }
                    RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                    requestTestCloseMessage.setTestId(this.o.a);
                    requestTestCloseMessage.setFromPage(1L);
                    MessageManager.getInstance().sendMessage(requestTestCloseMessage);
                }
            } else if (ViewHelper.checkUpIsLogin(getContext())) {
                TiebaStatic.log(new StatisticItem("c13372").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", this.o.a));
                int i3 = this.z;
                f fVar = this.o;
                if (fVar != null && i3 >= 0 && (l = c.a.s0.u3.a.l(true, "a065", "common_click", i2, (i2 = i3 + 1), false, null, String.valueOf(fVar.a), 0)) != null) {
                    c.g().c(this.n, l);
                }
                if (!this.p) {
                    String p = b.j().p("enter_forum_test_id_list", "");
                    String[] split = p.split("[|]");
                    String str = this.o.a + ProxyConfig.MATCH_ALL_SCHEMES + TbadkCoreApplication.getCurrentAccountId();
                    StringBuilder sb = new StringBuilder();
                    if (split.length < 20) {
                        sb.append(p);
                        sb.append("|");
                        sb.append(str);
                    } else {
                        int i4 = 0;
                        for (String str2 : split) {
                            if (i4 != 0) {
                                sb.append(str2);
                                sb.append("|");
                            }
                            i4++;
                        }
                        sb.append(str);
                    }
                    b.j().x("enter_forum_test_id_list", sb.toString());
                }
                this.f44071g.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumTestActivityConfig(getContext(), this.o.a)));
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
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            this.f44075k = View.MeasureSpec.getSize(i2);
            this.l = View.MeasureSpec.getSize(i3);
            if (!this.A) {
                this.f44070f.getLayoutParams().height = this.l - this.m;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f44075k, 1073741824), View.MeasureSpec.makeMeasureSpec(this.l, 1073741824));
        }
    }

    public void refreshAnswer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f44070f.startLoad(this.o.f24276e, 10, false);
            this.f44074j.setText(getResources().getString(R.string.cell_forum_retest_default));
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) || fVar == null) {
            return;
        }
        this.o = fVar;
        this.f44070f.startLoad(fVar.f24275d ? fVar.f24276e : fVar.f24274c, 10, false);
        this.p = false;
        String p = b.j().p("enter_forum_test_id_list", "");
        String[] split = p.split("[|]");
        if (!StringUtils.isNull(p)) {
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (!StringUtils.isNull(str)) {
                    if (str.equals(fVar.a + ProxyConfig.MATCH_ALL_SCHEMES + TbadkCoreApplication.getCurrentAccountId())) {
                        this.p = true;
                        break;
                    }
                }
                i2++;
            }
        }
        this.f44071g.setVisibility(this.p ? 8 : 0);
        if (StringUtils.isNull(fVar.f24273b)) {
            this.f44073i.setText(R.string.cell_forum_test_title_default);
        } else {
            this.f44073i.setText(fVar.f24273b);
        }
        this.f44074j.setText(getResources().getString(fVar.f24275d ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
    }

    public void setDataIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setForumTestDelClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.B = aVar;
        }
    }

    public void setIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.y = i2;
            if (i2 == 1) {
                this.f44072h.setVisibility(0);
            } else {
                this.f44072h.setVisibility(8);
            }
        }
    }

    public void setIsScale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.A = z;
        }
    }

    public void setMoveBottom(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f2) == null) {
            this.x = f2;
        }
    }

    public void setMoveLeft(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            this.u = f2;
        }
    }

    public void setMoveRight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.w = f2;
        }
    }

    public void setMoveTop(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            this.v = f2;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdUniqueId) == null) {
            this.n = bdUniqueId;
        }
    }

    public void setViewBottom(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            this.t = f2;
        }
    }

    public void setViewLeft(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f2) == null) {
            this.q = f2;
        }
    }

    public void setViewRight(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            this.s = f2;
        }
    }

    public void setViewTop(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.r = f2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44069e = 3;
        this.p = false;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CellForumTestView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f44069e = 3;
        this.p = false;
        a(context);
    }
}
