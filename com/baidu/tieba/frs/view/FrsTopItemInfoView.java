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
import com.repackage.dq4;
import com.repackage.li;
import com.repackage.wq4;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes3.dex */
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
    public TextView b;
    public View c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public ItemTableView h;
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

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !ViewHelper.checkUpIsLogin(this.a.a) || WriteActivityConfig.isAsyncWriting() || this.a.p == null) {
                return;
            }
            WriteActivityConfig.newInstance((Activity) this.a.a).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(this.a.p)).setItemIsSchool(this.a.p.is_school.intValue() == 1).setStarCount(this.a.p.score != null ? this.a.p.score.comment_star.intValue() : 0).send();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTopItemInfoView a;

        /* loaded from: classes3.dex */
        public class a implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ dq4 a;

            public a(b bVar, dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dq4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dq4Var;
            }

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.a instanceof FrsActivity)) {
                dq4 dq4Var = new dq4((FrsActivity) this.a.a);
                dq4Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f040b));
                dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f040a, new a(this, dq4Var));
                dq4Var.create(((FrsActivity) this.a.a).getPageContext()).show();
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
        u = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06cf);
        v = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0711);
        w = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        x = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        y = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
        z = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
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

    public final SpannableStringBuilder c(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)})) == null) ? new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", v, Double.valueOf(d), u)) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034a, this);
            setOrientation(1);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090f79);
            this.c = findViewById(R.id.obfuscated_res_0x7f090f6d);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090f7b);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dd3);
            this.e = imageView;
            imageView.setOnClickListener(this.t);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090368);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09173d);
            this.h = (ItemTableView) findViewById(R.id.obfuscated_res_0x7f090f71);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091fed);
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0908fc);
            this.k = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f092281);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09063b);
            this.m = (RankStarView) findViewById(R.id.obfuscated_res_0x7f091d8b);
            this.n = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a93);
            this.o = findViewById(R.id.obfuscated_res_0x7f0903ca);
            this.b.setText(R.string.obfuscated_res_0x7f0f06cd);
            this.l.setText(R.string.obfuscated_res_0x7f0f06cb);
            this.f.setText(R.string.obfuscated_res_0x7f0f06cc);
            if (DeviceInfoUtil.isXiaoMi()) {
                this.f.setPadding(0, -w, 0, 0);
            }
            this.k.setPlaceHolder(1);
            this.m.setStarSpacing(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
            this.j.setOnClickListener(this.s);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wq4 d = wq4.d(this);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            wq4 d2 = wq4.d(this.b);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0109);
            wq4 d3 = wq4.d(this.d);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            wq4 d4 = wq4.d(this.f);
            d4.A(R.string.F_X02);
            d4.v(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0109, 1);
            wq4 d5 = wq4.d(this.i);
            d5.v(R.color.CAM_X0109);
            d5.A(R.string.F_X01);
            wq4 d6 = wq4.d(this.l);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0105);
            this.h.d();
            this.m.f();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.obfuscated_res_0x7f0805e5, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0210);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.obfuscated_res_0x7f080612, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
            this.p = itemInfo;
            if (itemInfo == null || itemInfo.score == null) {
                return;
            }
            this.d.setText(itemInfo.name);
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
                this.k.K(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            double d = this.q;
            if (d > 0.0d && d <= 10.0d) {
                this.f.setText(String.valueOf(d));
                this.g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06ce, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(intValue)}));
                if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                    this.m.setStarCount(itemTable.comment_star.intValue());
                }
                this.c.setVisibility(0);
                this.i.setVisibility(0);
                this.i.setText(c(this.r), TextView.BufferType.SPANNABLE);
                this.h.setData(itemTable.item_plot, intValue);
                return;
            }
            this.f.setText(R.string.obfuscated_res_0x7f0f06cc);
            this.f.setTextSize(0, z);
            layoutParams.topMargin = y;
            layoutParams.height = z;
            this.f.setLayoutParams(layoutParams);
            layoutParams2.topMargin = x;
            this.g.setGravity(17);
            this.g.setLayoutParams(layoutParams2);
            this.g.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06ce, new Object[]{"0"}));
            this.m.setStarCount(0.0f);
            this.i.setVisibility(8);
            this.c.setVisibility(8);
            this.h.a();
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
