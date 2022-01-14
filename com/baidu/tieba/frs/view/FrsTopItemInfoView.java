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
import c.a.s0.s.s.a;
import c.a.s0.s.u.c;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
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
/* loaded from: classes12.dex */
public class FrsTopItemInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A;
    public static final String ALL = "all";
    public static final int B;
    public static final int C;
    public static final int D;
    public static final String y;
    public static final String z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f43845e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43846f;

    /* renamed from: g  reason: collision with root package name */
    public View f43847g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43848h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f43849i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43850j;
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

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTopItemInfoView f43851e;

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
            this.f43851e = frsTopItemInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f43851e.f43845e) || WriteActivityConfig.isAsyncWriting() || this.f43851e.t == null) {
                return;
            }
            WriteActivityConfig.newInstance((Activity) this.f43851e.f43845e).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(this.f43851e.t)).setItemIsSchool(this.f43851e.t.is_school.intValue() == 1).setStarCount(this.f43851e.t.score != null ? this.f43851e.t.score.comment_star.intValue() : 0).send();
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTopItemInfoView f43852e;

        /* loaded from: classes12.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.s.s.a f43853e;

            public a(b bVar, c.a.s0.s.s.a aVar) {
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
                this.f43853e = aVar;
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f43853e.dismiss();
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
            this.f43852e = frsTopItemInfoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f43852e.f43845e instanceof FrsActivity)) {
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a((FrsActivity) this.f43852e.f43845e);
                aVar.setMessage(this.f43852e.f43845e.getString(i1.comment_tab_dialog_info));
                aVar.setPositiveButton(i1.comment_tab_dialog_botton_text, new a(this, aVar));
                aVar.create(((FrsActivity) this.f43852e.f43845e).getPageContext()).show();
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
        y = TbadkCoreApplication.getInst().getString(i1.frs_evaluate_point);
        z = TbadkCoreApplication.getInst().getString(i1.frs_last_seven_days);
        A = n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds8);
        B = n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds21);
        C = n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds28);
        D = n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds42);
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
            this.f43845e = context;
            LayoutInflater.from(context).inflate(g1.frs_top_item_info_view, this);
            setOrientation(1);
            this.f43846f = (TextView) findViewById(f1.item_title_name);
            this.f43847g = findViewById(f1.item_split);
            this.f43848h = (TextView) findViewById(f1.item_title_value);
            ImageView imageView = (ImageView) findViewById(f1.icon_question);
            this.f43849i = imageView;
            imageView.setOnClickListener(this.x);
            this.f43850j = (TextView) findViewById(f1.big_score);
            this.k = (TextView) findViewById(f1.people_num);
            this.l = (ItemTableView) findViewById(f1.item_table);
            this.m = (TextView) findViewById(f1.time_score);
            this.n = (RelativeLayout) findViewById(f1.evaluate_container);
            this.o = (HeadImageView) findViewById(f1.user_head);
            this.p = (TextView) findViewById(f1.click_tip);
            this.q = (RankStarView) findViewById(f1.star_view);
            this.r = (ImageView) findViewById(f1.right_arrow);
            this.s = findViewById(f1.bottom_line);
            this.f43846f.setText(i1.frs_evaluate_item_title);
            this.p.setText(i1.frs_evaluate_click_tip);
            this.f43850j.setText(i1.frs_evaluate_exception);
            if (DeviceInfoUtil.isXiaoMi()) {
                this.f43850j.setPadding(0, -A, 0, 0);
            }
            this.o.setPlaceHolder(1);
            this.q.setStarSpacing(n.f(TbadkCoreApplication.getInst().getContext(), d1.tbds10));
            this.n.setOnClickListener(this.w);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c d2 = c.d(this);
            d2.n(i1.J_X06);
            d2.f(c1.CAM_X0201);
            c d3 = c.d(this.f43846f);
            d3.A(i1.F_X02);
            d3.v(c1.CAM_X0105);
            SkinManager.setBackgroundColor(this.f43847g, c1.CAM_X0109);
            c d4 = c.d(this.f43848h);
            d4.A(i1.F_X02);
            d4.v(c1.CAM_X0105);
            c d5 = c.d(this.f43850j);
            d5.A(i1.F_X02);
            d5.v(c1.CAM_X0105);
            SkinManager.setViewTextColor(this.k, c1.CAM_X0109, 1);
            c d6 = c.d(this.m);
            d6.v(c1.CAM_X0109);
            d6.A(i1.F_X01);
            c d7 = c.d(this.p);
            d7.A(i1.F_X01);
            d7.v(c1.CAM_X0105);
            this.l.onChangeSkinType();
            this.q.updateStarDrawable();
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.r, e1.ic_icon_mybar_pure_list_arrow16_right, c1.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.s, c1.CAM_X0210);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f43849i, e1.ic_icon_pure_use_unknown_n_svg, c1.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
            this.t = itemInfo;
            if (itemInfo == null || itemInfo.score == null) {
                return;
            }
            this.f43848h.setText(itemInfo.name);
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
                this.o.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f43850j.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            double d2 = this.u;
            if (d2 > 0.0d && d2 <= 10.0d) {
                this.f43850j.setText(String.valueOf(d2));
                this.k.setText(TbadkCoreApplication.getInst().getString(i1.frs_evaluate_people, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(intValue)}));
                if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                    this.q.setStarCount(itemTable.comment_star.intValue());
                }
                this.f43847g.setVisibility(0);
                this.m.setVisibility(0);
                this.m.setText(c(this.v), TextView.BufferType.SPANNABLE);
                this.l.setData(itemTable.item_plot, intValue);
                return;
            }
            this.f43850j.setText(i1.frs_evaluate_exception);
            this.f43850j.setTextSize(0, D);
            layoutParams.topMargin = C;
            layoutParams.height = D;
            this.f43850j.setLayoutParams(layoutParams);
            layoutParams2.topMargin = B;
            this.k.setGravity(17);
            this.k.setLayoutParams(layoutParams2);
            this.k.setText(TbadkCoreApplication.getInst().getString(i1.frs_evaluate_people, new Object[]{"0"}));
            this.q.setStarCount(0.0f);
            this.m.setVisibility(8);
            this.f43847g.setVisibility(8);
            this.l.clear();
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
