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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nn4;
import com.repackage.sg8;
import com.repackage.ur4;
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
    public b n;
    public ur4 o;
    public ur4 p;
    public ur4 q;
    public int r;
    public boolean s;

    /* loaded from: classes3.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadRecommendInfoData a;
        public final /* synthetic */ TbLabelWidget b;

        public a(TbLabelWidget tbLabelWidget, ThreadRecommendInfoData threadRecommendInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLabelWidget, threadRecommendInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbLabelWidget;
            this.a = threadRecommendInfoData;
        }

        @Override // com.baidu.tbadk.widget.TbLabelWidget.b
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!TextUtils.isEmpty(this.a.jumpLink)) {
                    UrlManager.getInstance().dealOneLink(TbadkCoreApplication.getInst().getCurrentPageContext(this.b.getContext()), new String[]{this.a.jumpLink});
                } else {
                    long j = this.a.recommendTopicId;
                    if (j == 0) {
                        return;
                    }
                    new HotTopicActivityConfig(this.b.getContext()).createNormalConfig(String.valueOf(j), null, null, "2").start();
                }
                StatisticItem statisticItem = new StatisticItem("c14686");
                statisticItem.param("obj_type", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2);
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
        public final /* synthetic */ TbLabelWidget g;

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
            this.g = tbLabelWidget;
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
        public final /* synthetic */ TbLabelWidget e;

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
            this.e = tbLabelWidget;
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f();
            if (this.s) {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.f.J(this.d.c, 10, false);
                this.g.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.d, 8, ""));
                this.i.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, StringHelper.STRING_MORE));
                if (!StringUtils.isNull(this.d.f)) {
                    this.j.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.f, 8, StringHelper.STRING_MORE));
                    return;
                }
                this.k.setVisibility(8);
                this.j.setVisibility(8);
                return;
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
                this.l.J(this.d.a, 10, false);
            } else {
                this.l.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.d.b) && !TextUtils.isEmpty(this.d.e)) {
                this.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.b, this.b, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0650) + StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, StringHelper.STRING_MORE));
            } else if (TextUtils.isEmpty(this.d.e)) {
            } else {
                this.m.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.e, this.a, StringHelper.STRING_MORE));
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new d(this);
            this.d = new c(this);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = ur4.d(this.e);
            this.p = ur4.d(this.j);
            this.q = ur4.d(this.k);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d04eb, (ViewGroup) this, false);
            this.e = inflate;
            this.f = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091edd);
            this.g = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0911ff);
            this.h = this.e.findViewById(R.id.obfuscated_res_0x7f0911f8);
            this.i = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0911fb);
            this.j = this.e.findViewById(R.id.obfuscated_res_0x7f0911fa);
            this.k = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0911fd);
            this.l = (BarImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091a97);
            this.m = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091aa4);
            setOnClickListener(this);
            addView(this.e);
        }
    }

    public final boolean e(ThemeElement themeElement) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, themeElement)) == null) ? (themeElement == null || StringUtils.isNull(themeElement.common_color)) ? false : true : invokeL.booleanValue;
    }

    public void f() {
        d dVar;
        ThemeColorInfo themeColorInfo;
        ThemeColorInfo themeColorInfo2;
        ThemeColorInfo themeColorInfo3;
        ThemeColorInfo themeColorInfo4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o.n(R.string.J_X01);
            if (this.s) {
                ur4 ur4Var = this.p;
                ur4Var.n(R.string.J_X03);
                ur4Var.f(R.color.CAM_X0108);
                this.q.v(R.color.CAM_X0108);
                int skinType = TbadkApplication.getInst().getSkinType();
                if (skinType == this.r || (themeColorInfo = (dVar = this.c).b) == null || (themeColorInfo2 = dVar.c) == null || (themeColorInfo3 = dVar.d) == null || (themeColorInfo4 = dVar.a) == null) {
                    return;
                }
                this.r = skinType;
                if (skinType == 1) {
                    g(themeColorInfo.night, themeColorInfo2.night, themeColorInfo3.night, themeColorInfo4.night);
                    return;
                } else if (skinType != 4) {
                    g(themeColorInfo.day, themeColorInfo2.day, themeColorInfo3.day, themeColorInfo4.day);
                    return;
                } else {
                    g(themeColorInfo.dark, themeColorInfo2.dark, themeColorInfo3.dark, themeColorInfo4.dark);
                    return;
                }
            }
            this.o.f(R.color.CAM_X0209);
            ur4 d2 = ur4.d(this.m);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0107);
        }
    }

    public final void g(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3, ThemeElement themeElement4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, themeElement, themeElement2, themeElement3, themeElement4) == null) {
            if (e(themeElement)) {
                this.g.setTextColor(sg8.f(themeElement.common_color));
            }
            if (e(themeElement2)) {
                this.h.setBackgroundColor(sg8.f(themeElement2.common_color));
            }
            if (e(themeElement3)) {
                this.i.setTextColor(sg8.f(themeElement3.common_color));
            }
            if (e(themeElement4)) {
                this.o.g(sg8.f(themeElement4.common_color));
            }
        }
    }

    public c getContentStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (c) invokeV.objValue;
    }

    public d getStyleStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (d) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view2) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.a(view2);
    }

    public void setData(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, nn4Var) == null) || nn4Var == null || nn4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = nn4Var.getThreadData();
        if (threadData.getThreadRecommendInfoDataList() == null || threadData.getThreadRecommendInfoDataList().size() <= 0) {
            return;
        }
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
        d dVar = this.c;
        dVar.b = threadRecommendInfoData.recommendTypeColor;
        ThemeColorInfo themeColorInfo = threadRecommendInfoData.recommendReasonColor;
        dVar.d = themeColorInfo;
        this.s = themeColorInfo != null;
        d dVar2 = this.c;
        dVar2.c = threadRecommendInfoData.stripColor;
        dVar2.a = threadRecommendInfoData.backgroundColor;
        a();
        setEventCallback(new a(this, threadRecommendInfoData));
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.n = bVar;
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
        this.r = -1;
        b();
        d();
        c();
    }
}
