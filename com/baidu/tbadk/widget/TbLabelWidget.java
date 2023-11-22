package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bqa;
import com.baidu.tieba.bw4;
import com.baidu.tieba.d1b;
import com.baidu.tieba.rt5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeColorInfo;
/* loaded from: classes5.dex */
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
    public EMManager r;
    public EMManager s;
    public int t;
    public boolean u;
    public TbPageContext v;

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view2, int i, c cVar);
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class c {
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

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ThemeColorInfo a;
        public ThemeColorInfo b;
        public ThemeColorInfo c;
        public ThemeColorInfo d;
        public ThemeColorInfo e;
        public ThemeColorInfo f;
        public ThemeColorInfo g;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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

    public final void m(@Nullable ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, themeColorInfo) != null) || themeColorInfo == null) {
            return;
        }
        int color = SkinManager.getColor(R.color.CAM_X0108);
        int f = bqa.f(d1b.c(themeColorInfo));
        if (!bqa.e(f)) {
            color = f;
        }
        this.s.setCorner(R.string.J_X03).setBackGroundRealColor(color);
    }

    public void setData(bw4 bw4Var) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bw4Var) == null) && bw4Var != null && bw4Var.getThreadData() != null) {
            ThreadData threadData = bw4Var.getThreadData();
            if (threadData.getThreadRecommendInfoDataList() == null || threadData.getThreadRecommendInfoDataList().size() <= 0 || (threadRecommendInfoData = threadData.getThreadRecommendInfoDataList().get(0)) == null) {
                return;
            }
            setData(threadRecommendInfoData);
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
        this.t = -1;
        f();
        i();
        h();
        g();
    }

    public void n(@Nullable ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, themeColorInfo) != null) || themeColorInfo == null) {
            return;
        }
        int f = bqa.f(d1b.c(themeColorInfo));
        if (!bqa.e(f)) {
            this.n.setTextColor(f);
        }
    }

    public final void o(@Nullable ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, themeColorInfo) != null) || themeColorInfo == null) {
            return;
        }
        int color = SkinManager.getColor(R.color.CAM_X0108);
        int f = bqa.f(d1b.c(themeColorInfo));
        if (!bqa.e(f)) {
            color = f;
        }
        this.k.setTextColor(color);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            e();
            b bVar = this.q;
            if (bVar != null) {
                bVar.a(view2, 0, this.d);
            }
        }
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            this.v = tbPageContext;
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k();
            if (this.u) {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.f.setVisibility(0);
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f.startLoad(this.d.c, 10, false);
                if (TextUtils.isEmpty(this.d.d)) {
                    this.g.setVisibility(8);
                    this.h.setVisibility(8);
                } else {
                    this.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.d, 10, ""));
                    this.g.setVisibility(0);
                    this.h.setVisibility(0);
                }
                this.i.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, "..."));
                if (!StringUtils.isNull(this.d.f)) {
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.f, 8, "..."));
                } else {
                    this.k.setVisibility(8);
                    this.j.setVisibility(8);
                }
                if (!StringUtils.isNull(this.d.k)) {
                    this.o.startLoad(this.d.k, 10, false);
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
                this.l.startLoad(this.d.a, 10, false);
            } else {
                this.l.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.d.b) && !TextUtils.isEmpty(this.d.e)) {
                this.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.b, this.b, "...") + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0787) + StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, "..."));
            } else if (!TextUtils.isEmpty(this.d.e)) {
                this.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, "..."));
            }
        }
    }

    public final void e() {
        c cVar;
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
        TbPageContext tbPageContext = this.v;
        if (tbPageContext != null) {
            rt5.f(tbPageContext, String.valueOf(j), null);
        } else {
            new HotTopicActivityConfig(getContext()).createNormalConfig(String.valueOf(j), null, null, "2").start();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.r.setCorner(R.string.J_X01);
            if (this.u) {
                int skinType = TbadkApplication.getInst().getSkinType();
                if (skinType != this.t) {
                    this.t = skinType;
                    d dVar = this.c;
                    l(dVar.b, dVar.c, dVar.d, dVar.a);
                    n(this.c.e);
                    m(this.c.f);
                    o(this.c.g);
                    return;
                }
                return;
            }
            this.r.setBackGroundColor(R.color.CAM_X0209);
            EMManager.from(this.m).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0107);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = new d();
            this.d = new c();
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
            return this.v;
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
            this.r = EMManager.from(this.e);
            this.s = EMManager.from(this.j);
            EMManager.from(this.k);
        }
    }

    public void setUseFullScreenStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public final void l(@Nullable ThemeColorInfo themeColorInfo, @Nullable ThemeColorInfo themeColorInfo2, @Nullable ThemeColorInfo themeColorInfo3, @Nullable ThemeColorInfo themeColorInfo4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, themeColorInfo, themeColorInfo2, themeColorInfo3, themeColorInfo4) == null) {
            if (themeColorInfo != null) {
                int f = bqa.f(d1b.c(themeColorInfo));
                if (!bqa.e(f)) {
                    this.g.setTextColor(f);
                }
            }
            if (themeColorInfo2 != null) {
                int f2 = bqa.f(d1b.c(themeColorInfo2));
                if (!bqa.e(f2)) {
                    this.h.setBackgroundColor(f2);
                }
            }
            if (themeColorInfo3 != null) {
                int f3 = bqa.f(d1b.c(themeColorInfo3));
                if (!bqa.e(f3)) {
                    this.i.setTextColor(f3);
                }
            }
            if (themeColorInfo4 != null) {
                int f4 = bqa.f(d1b.c(themeColorInfo4));
                if (!bqa.e(f4)) {
                    this.r.setBackGroundRealColor(f4);
                }
            }
        }
    }

    public void setData(@NonNull ThreadRecommendInfoData threadRecommendInfoData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadRecommendInfoData) == null) {
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
            } else {
                z = false;
            }
            this.u = z;
            d dVar2 = this.c;
            dVar2.c = threadRecommendInfoData.stripColor;
            dVar2.a = threadRecommendInfoData.backgroundColor;
            dVar2.e = threadRecommendInfoData.jumpTextColor;
            dVar2.f = threadRecommendInfoData.dotColorInfo;
            dVar2.g = threadRecommendInfoData.tailColorInfo;
            d();
        }
    }

    public void setStyleForPb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            setUseFullScreenStyle();
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X007);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.setMargins(dimens, dimens2, dimens, 0);
            this.e.setLayoutParams(marginLayoutParams);
        }
    }
}
