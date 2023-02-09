package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ap5;
import com.baidu.tieba.ej;
import com.baidu.tieba.p09;
import com.baidu.tieba.p15;
import com.baidu.tieba.sw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class TbLabelWidget extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public d c;
    public c d;
    public View e;
    public TbImageView f;
    public TextView g;
    public View h;
    public TextView i;
    public View j;
    public TextView k;
    public BarImageView l;
    public TextView m;
    public TextView n;
    public TbImageView o;
    public View p;
    public b q;
    public p15 r;
    public p15 s;
    public p15 t;
    public int u;
    public boolean v;
    public TbPageContext w;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, int i, c cVar);
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbLabelWidget a;

        public a(TbLabelWidget tbLabelWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLabelWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbLabelWidget;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.e();
            if (this.a.q != null) {
                this.a.q.a(view2, 1, this.a.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public long h;
        public int i;
        public String j;
        public String k;
        public String l;
        public final /* synthetic */ TbLabelWidget m;

        public c(TbLabelWidget tbLabelWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLabelWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = tbLabelWidget;
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ThemeColorInfo a;
        public ThemeColorInfo b;
        public ThemeColorInfo c;
        public ThemeColorInfo d;
        public ThemeColorInfo e;
        public final /* synthetic */ TbLabelWidget f;

        public d(TbLabelWidget tbLabelWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLabelWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tbLabelWidget;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbLabelWidget(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbLabelWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLabelWidget(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 24;
        this.b = 16;
        this.u = -1;
        f();
        i();
        h();
        g();
    }

    public final boolean j(ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, themeElement)) == null) {
            if (themeElement != null && !StringUtils.isNull(themeElement.common_color)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, themeElement) == null) && j(themeElement)) {
            this.n.setTextColor(p09.f(themeElement.common_color));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            e();
            b bVar = this.q;
            if (bVar != null) {
                bVar.a(view2, 0, this.d);
            }
        }
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
            this.w = tbPageContext;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k();
            if (this.v) {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.f.setVisibility(0);
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f.K(this.d.c, 10, false);
                if (TextUtils.isEmpty(this.d.d)) {
                    this.g.setVisibility(8);
                    this.h.setVisibility(8);
                } else {
                    this.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.d, 10, ""));
                    this.g.setVisibility(0);
                    this.h.setVisibility(0);
                }
                this.i.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, StringHelper.STRING_MORE));
                if (!StringUtils.isNull(this.d.f)) {
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.f, 8, StringHelper.STRING_MORE));
                } else {
                    this.k.setVisibility(8);
                    this.j.setVisibility(8);
                }
                if (!StringUtils.isNull(this.d.k)) {
                    this.o.K(this.d.k, 10, false);
                } else {
                    this.o.setVisibility(8);
                }
                if (!StringUtils.isNull(this.d.l)) {
                    this.n.setText(this.d.l);
                    return;
                } else {
                    this.n.setVisibility(8);
                    return;
                }
            }
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            if (!TextUtils.isEmpty(this.d.a)) {
                this.l.setVisibility(0);
                this.l.K(this.d.a, 10, false);
            } else {
                this.l.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.d.b) && !TextUtils.isEmpty(this.d.e)) {
                this.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.b, this.b, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06b6) + StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, StringHelper.STRING_MORE));
            } else if (!TextUtils.isEmpty(this.d.e)) {
                this.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, StringHelper.STRING_MORE));
            }
        }
    }

    public final void e() {
        c cVar;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (cVar = this.d) == null) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.g)) {
            UrlManager.getInstance().dealOneLink(TbadkCoreApplication.getInst().getCurrentPageContext(getContext()), new String[]{this.d.g});
            return;
        }
        long j = this.d.h;
        if (j == 0) {
            return;
        }
        if (NewWebHotTopicPageSwitch.isOn() && (tbPageContext = this.w) != null) {
            ap5.e(tbPageContext, String.valueOf(j), null);
        } else {
            new HotTopicActivityConfig(getContext()).createNormalConfig(String.valueOf(j), null, null, "2").start();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new d(this);
            this.d = new c(this);
        }
    }

    public final void g() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (textView = this.n) != null) {
            textView.setOnClickListener(new a(this));
        }
    }

    public c getContentStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (c) invokeV.objValue;
    }

    public TbPageContext getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.w;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public d getStyleStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (d) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.r = p15.d(this.e);
            this.s = p15.d(this.j);
            this.t = p15.d(this.k);
        }
    }

    public void setUseFullScreenStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.p.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_tb_label_widget, (ViewGroup) this, false);
            this.e = inflate;
            this.f = (TbImageView) inflate.findViewById(R.id.tabel_icon);
            this.g = (TextView) this.e.findViewById(R.id.label_type);
            this.h = this.e.findViewById(R.id.label_decollator);
            this.i = (TextView) this.e.findViewById(R.id.label_sheme);
            this.j = this.e.findViewById(R.id.label_point);
            this.k = (TextView) this.e.findViewById(R.id.label_tail);
            this.l = (BarImageView) this.e.findViewById(R.id.recommend_forum_avatar);
            this.m = (TextView) this.e.findViewById(R.id.recommend_info_view);
            this.o = (TbImageView) this.e.findViewById(R.id.icon_right_arrow);
            this.n = (TextView) this.e.findViewById(R.id.info_right_btn);
            this.p = this.e.findViewById(R.id.place_holder_view);
            this.e.setOnClickListener(this);
            addView(this.e);
            setId(R.id.tb_label_view_root);
        }
    }

    public void k() {
        ThemeColorInfo themeColorInfo;
        ThemeColorInfo themeColorInfo2;
        ThemeColorInfo themeColorInfo3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r.n(R.string.J_X01);
            if (this.v) {
                p15 p15Var = this.s;
                p15Var.n(R.string.J_X03);
                p15Var.f(R.color.CAM_X0108);
                this.t.v(R.color.CAM_X0108);
                int skinType = TbadkApplication.getInst().getSkinType();
                if (skinType != this.u) {
                    this.u = skinType;
                    d dVar = this.c;
                    ThemeColorInfo themeColorInfo4 = dVar.b;
                    if (themeColorInfo4 != null && (themeColorInfo = dVar.c) != null && (themeColorInfo2 = dVar.d) != null && (themeColorInfo3 = dVar.a) != null) {
                        if (skinType != 1) {
                            if (skinType != 4) {
                                l(themeColorInfo4.day, themeColorInfo.day, themeColorInfo2.day, themeColorInfo3.day);
                            } else {
                                l(themeColorInfo4.dark, themeColorInfo.dark, themeColorInfo2.dark, themeColorInfo3.dark);
                            }
                        } else {
                            l(themeColorInfo4.night, themeColorInfo.night, themeColorInfo2.night, themeColorInfo3.night);
                        }
                    }
                    ThemeColorInfo themeColorInfo5 = this.c.e;
                    if (themeColorInfo5 != null) {
                        if (skinType != 1) {
                            if (skinType != 4) {
                                m(themeColorInfo5.day);
                                return;
                            } else {
                                m(themeColorInfo5.dark);
                                return;
                            }
                        }
                        m(themeColorInfo5.night);
                        return;
                    }
                    return;
                }
                return;
            }
            this.r.f(R.color.CAM_X0209);
            p15 d2 = p15.d(this.m);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0107);
        }
    }

    public final void l(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3, ThemeElement themeElement4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, themeElement, themeElement2, themeElement3, themeElement4) == null) {
            if (j(themeElement)) {
                this.g.setTextColor(p09.f(themeElement.common_color));
            }
            if (j(themeElement2)) {
                this.h.setBackgroundColor(p09.f(themeElement2.common_color));
            }
            if (j(themeElement3)) {
                this.i.setTextColor(p09.f(themeElement3.common_color));
            }
            if (j(themeElement4)) {
                this.r.g(p09.f(themeElement4.common_color));
            }
        }
    }

    public void setData(sw4 sw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, sw4Var) == null) && sw4Var != null && sw4Var.getThreadData() != null) {
            ThreadData threadData = sw4Var.getThreadData();
            if (threadData.getThreadRecommendInfoDataList() != null && threadData.getThreadRecommendInfoDataList().size() > 0) {
                boolean z = false;
                ThreadRecommendInfoData threadRecommendInfoData = threadData.getThreadRecommendInfoDataList().get(0);
                if (threadRecommendInfoData == null) {
                    return;
                }
                c cVar = this.d;
                cVar.a = threadRecommendInfoData.forumAvatar;
                cVar.b = threadRecommendInfoData.forumName;
                cVar.d = threadRecommendInfoData.recommendType;
                cVar.f = threadRecommendInfoData.recommendTail;
                cVar.c = threadRecommendInfoData.recommendIcon;
                cVar.e = threadRecommendInfoData.recommendReason;
                cVar.g = threadRecommendInfoData.jumpLink;
                cVar.h = threadRecommendInfoData.recommendTopicId;
                cVar.i = threadRecommendInfoData.businessType;
                cVar.j = threadRecommendInfoData.businessId;
                cVar.k = threadRecommendInfoData.jumpIcon;
                cVar.l = threadRecommendInfoData.jumpText;
                d dVar = this.c;
                dVar.b = threadRecommendInfoData.recommendTypeColor;
                ThemeColorInfo themeColorInfo = threadRecommendInfoData.recommendReasonColor;
                dVar.d = themeColorInfo;
                if (themeColorInfo != null) {
                    z = true;
                }
                this.v = z;
                d dVar2 = this.c;
                dVar2.c = threadRecommendInfoData.stripColor;
                dVar2.a = threadRecommendInfoData.backgroundColor;
                dVar2.e = threadRecommendInfoData.jumpTextColor;
                d();
            }
        }
    }

    public void setStyleForPb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setUseFullScreenStyle();
            int g = ej.g(getContext(), R.dimen.M_W_X006);
            int g2 = ej.g(getContext(), R.dimen.M_W_X007);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.setMargins(g, g2, g, 0);
            this.e.setLayoutParams(marginLayoutParams);
        }
    }
}
