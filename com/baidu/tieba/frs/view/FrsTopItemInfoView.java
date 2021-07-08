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
import d.a.c.e.p.l;
import d.a.o0.r.s.a;
import d.a.o0.r.u.c;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes4.dex */
public class FrsTopItemInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final String y;
    public static final String z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f16204e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16205f;

    /* renamed from: g  reason: collision with root package name */
    public View f16206g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16207h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f16208i;
    public TextView j;
    public TextView k;
    public ItemTableView l;
    public TextView m;
    public RelativeLayout n;
    public HeadImageView o;
    public TextView p;
    public RankStarView q;
    public ImageView r;
    public View s;
    public ItemInfo t;
    public double u;
    public double v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTopItemInfoView f16209e;

        public a(FrsTopItemInfoView frsTopItemInfoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTopItemInfoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16209e = frsTopItemInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f16209e.f16204e) || WriteActivityConfig.isAsyncWriting() || this.f16209e.t == null) {
                return;
            }
            WriteActivityConfig.newInstance((Activity) this.f16209e.f16204e).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(this.f16209e.t)).setItemIsSchool(this.f16209e.t.is_school.intValue() == 1).setStarCount(this.f16209e.t.score != null ? this.f16209e.t.score.comment_star.intValue() : 0).send();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTopItemInfoView f16210e;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.r.s.a f16211e;

            public a(b bVar, d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16211e = aVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f16211e.dismiss();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16210e = frsTopItemInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f16210e.f16204e instanceof FrsActivity)) {
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a((FrsActivity) this.f16210e.f16204e);
                aVar.setMessage(this.f16210e.f16204e.getString(R.string.comment_tab_dialog_info));
                aVar.setPositiveButton(R.string.comment_tab_dialog_botton_text, new a(this, aVar));
                aVar.create(((FrsActivity) this.f16210e.f16204e).getPageContext()).show();
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
        y = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
        z = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
        A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
        B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
        C = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
        D = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) ? new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", z, Double.valueOf(d2), y)) : (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f16204e = context;
            LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
            setOrientation(1);
            this.f16205f = (TextView) findViewById(R.id.item_title_name);
            this.f16206g = findViewById(R.id.item_split);
            this.f16207h = (TextView) findViewById(R.id.item_title_value);
            ImageView imageView = (ImageView) findViewById(R.id.icon_question);
            this.f16208i = imageView;
            imageView.setOnClickListener(this.x);
            this.j = (TextView) findViewById(R.id.big_score);
            this.k = (TextView) findViewById(R.id.people_num);
            this.l = (ItemTableView) findViewById(R.id.item_table);
            this.m = (TextView) findViewById(R.id.time_score);
            this.n = (RelativeLayout) findViewById(R.id.evaluate_container);
            this.o = (HeadImageView) findViewById(R.id.user_head);
            this.p = (TextView) findViewById(R.id.click_tip);
            this.q = (RankStarView) findViewById(R.id.star_view);
            this.r = (ImageView) findViewById(R.id.right_arrow);
            this.s = findViewById(R.id.bottom_line);
            this.f16205f.setText(R.string.frs_evaluate_item_title);
            this.p.setText(R.string.frs_evaluate_click_tip);
            this.j.setText(R.string.frs_evaluate_exception);
            if (DeviceInfoUtil.isXiaoMi()) {
                this.j.setPadding(0, -A, 0, 0);
            }
            this.o.setPlaceHolder(1);
            this.q.setStarSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
            this.n.setOnClickListener(this.w);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c d3 = c.d(this.f16205f);
            d3.y(R.string.F_X02);
            d3.t(R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f16206g, R.color.CAM_X0109);
            c d4 = c.d(this.f16207h);
            d4.y(R.string.F_X02);
            d4.t(R.color.CAM_X0105);
            c d5 = c.d(this.j);
            d5.y(R.string.F_X02);
            d5.t(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1);
            c d6 = c.d(this.m);
            d6.t(R.color.CAM_X0109);
            d6.y(R.string.F_X01);
            c d7 = c.d(this.p);
            d7.y(R.string.F_X01);
            d7.t(R.color.CAM_X0105);
            this.l.d();
            this.q.f();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0210);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16208i, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
            this.t = itemInfo;
            if (itemInfo == null || itemInfo.score == null) {
                return;
            }
            this.f16207h.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.u = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.v = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.o.M(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            double d2 = this.u;
            if (d2 > 0.0d && d2 <= 10.0d) {
                this.j.setText(String.valueOf(d2));
                this.k.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(intValue)}));
                if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                    this.q.setStarCount(itemTable.comment_star.intValue());
                }
                this.f16206g.setVisibility(0);
                this.m.setVisibility(0);
                this.m.setText(c(this.v), TextView.BufferType.SPANNABLE);
                this.l.setData(itemTable.item_plot, intValue);
                return;
            }
            this.j.setText(R.string.frs_evaluate_exception);
            this.j.setTextSize(0, D);
            layoutParams.topMargin = C;
            layoutParams.height = D;
            this.j.setLayoutParams(layoutParams);
            layoutParams2.topMargin = B;
            this.k.setGravity(17);
            this.k.setLayoutParams(layoutParams2);
            this.k.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
            this.q.setStarCount(0.0f);
            this.m.setVisibility(8);
            this.f16206g.setVisibility(8);
            this.l.a();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.x = new b(this);
        d(context);
    }
}
