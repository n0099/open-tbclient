package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes5.dex */
public class FrsTopItemInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final String u;
    public static final String v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32983b;

    /* renamed from: c  reason: collision with root package name */
    public View f32984c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32985d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f32986e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32987f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32988g;

    /* renamed from: h  reason: collision with root package name */
    public ItemTableView f32989h;
    public TextView i;
    public RelativeLayout j;
    public HeadImageView k;
    public TextView l;
    public RankStarView m;
    public ImageView n;
    public View o;
    public ItemInfo p;
    public double q;
    public double r;
    public View.OnClickListener s;
    public View.OnClickListener t;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTopItemInfoView a;

        public a(FrsTopItemInfoView frsTopItemInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTopItemInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTopItemInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.a.a) || WriteActivityConfig.isAsyncWriting() || this.a.p == null) {
                return;
            }
            WriteActivityConfig.newInstance((Activity) this.a.a).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(this.a.p)).setItemIsSchool(this.a.p.is_school.intValue() == 1).setStarCount(this.a.p.score != null ? this.a.p.score.comment_star.intValue() : 0).send();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTopItemInfoView a;

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.o0.r.t.a a;

            public a(b bVar, c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.a.dismiss();
                }
            }
        }

        public b(FrsTopItemInfoView frsTopItemInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTopItemInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTopItemInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.a.a instanceof FrsActivity)) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a((FrsActivity) this.a.a);
                aVar.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f03fb));
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f03fa, new a(this, aVar));
                aVar.create(((FrsActivity) this.a.a).getPageContext()).show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(372480627, "Lcom/baidu/tieba/frs/view/FrsTopItemInfoView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(372480627, "Lcom/baidu/tieba/frs/view/FrsTopItemInfoView;");
                return;
            }
        }
        u = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06ba);
        v = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06fc);
        w = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        x = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        y = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
        z = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsTopItemInfoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final SpannableStringBuilder c(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) ? new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", v, Double.valueOf(d2), u)) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0358, this);
            setOrientation(1);
            this.f32983b = (TextView) findViewById(R.id.obfuscated_res_0x7f090fad);
            this.f32984c = findViewById(R.id.obfuscated_res_0x7f090fa1);
            this.f32985d = (TextView) findViewById(R.id.obfuscated_res_0x7f090faf);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e20);
            this.f32986e = imageView;
            imageView.setOnClickListener(this.t);
            this.f32987f = (TextView) findViewById(R.id.obfuscated_res_0x7f090369);
            this.f32988g = (TextView) findViewById(R.id.obfuscated_res_0x7f091762);
            this.f32989h = (ItemTableView) findViewById(R.id.obfuscated_res_0x7f090fa5);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091ffd);
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090916);
            this.k = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f0922a1);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090658);
            this.m = (RankStarView) findViewById(R.id.obfuscated_res_0x7f091d99);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f091aa5);
            this.o = findViewById(R.id.obfuscated_res_0x7f0903ca);
            this.f32983b.setText(R.string.obfuscated_res_0x7f0f06b8);
            this.l.setText(R.string.obfuscated_res_0x7f0f06b6);
            this.f32987f.setText(R.string.obfuscated_res_0x7f0f06b7);
            if (DeviceInfoUtil.isXiaoMi()) {
                this.f32987f.setPadding(0, -w, 0, 0);
            }
            this.k.setPlaceHolder(1);
            this.m.setStarSpacing(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
            this.j.setOnClickListener(this.s);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c d3 = c.d(this.f32983b);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f32984c, R.color.CAM_X0109);
            c d4 = c.d(this.f32985d);
            d4.A(R.string.F_X02);
            d4.v(R.color.CAM_X0105);
            c d5 = c.d(this.f32987f);
            d5.A(R.string.F_X02);
            d5.v(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f32988g, R.color.CAM_X0109, 1);
            c d6 = c.d(this.i);
            d6.v(R.color.CAM_X0109);
            d6.A(R.string.F_X01);
            c d7 = c.d(this.l);
            d7.A(R.string.F_X01);
            d7.v(R.color.CAM_X0105);
            this.f32989h.d();
            this.m.f();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f0805f8, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0210);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f32986e, R.drawable.obfuscated_res_0x7f080627, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
            this.p = itemInfo;
            if (itemInfo == null || itemInfo.score == null) {
                return;
            }
            this.f32985d.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.q = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.r = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.k.J(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f32987f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f32988g.getLayoutParams();
            double d2 = this.q;
            if (d2 > 0.0d && d2 <= 10.0d) {
                this.f32987f.setText(String.valueOf(d2));
                this.f32988g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06b9, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(intValue)}));
                if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                    this.m.setStarCount(itemTable.comment_star.intValue());
                }
                this.f32984c.setVisibility(0);
                this.i.setVisibility(0);
                this.i.setText(c(this.r), TextView.BufferType.SPANNABLE);
                this.f32989h.setData(itemTable.item_plot, intValue);
                return;
            }
            this.f32987f.setText(R.string.obfuscated_res_0x7f0f06b7);
            this.f32987f.setTextSize(0, z);
            layoutParams.topMargin = y;
            layoutParams.height = z;
            this.f32987f.setLayoutParams(layoutParams);
            layoutParams2.topMargin = x;
            this.f32988g.setGravity(17);
            this.f32988g.setLayoutParams(layoutParams2);
            this.f32988g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06b9, new Object[]{"0"}));
            this.m.setStarCount(0.0f);
            this.i.setVisibility(8);
            this.f32984c.setVisibility(8);
            this.f32989h.a();
        }
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, forumWriteData) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.t = new b(this);
        d(context);
    }
}
