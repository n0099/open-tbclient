package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.r0.l1.g.d;
import b.a.r0.l1.l.c.a;
import b.a.r0.l1.w.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51145e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f51146f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51147g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51148h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.e.f.h.b f51149i;
    public int j;

    /* loaded from: classes9.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f51150e;

        public a(MultiImageTextTopView multiImageTextTopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51150e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f51150e.f51149i != null) {
                    this.f51150e.f51149i.onItemViewLongClick(view, 9, this.f51150e.j, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1072a f51151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f51152f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f51153g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f51154h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1072a c1072a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1072a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51154h = multiImageTextTopView;
            this.f51151e = c1072a;
            this.f51152f = tbPageContext;
            this.f51153g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1072a c1072a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1072a = this.f51151e) == null || StringUtils.isNull(c1072a.f21782d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f51152f, new String[]{this.f51151e.f21782d});
            if (this.f51153g == 1) {
                TiebaStatic.eventStat(this.f51154h.f51145e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f51151e.f21783e);
                d j = c.j(this.f51151e.f21784f);
                if (j != null) {
                    TiebaStatic.eventStat(this.f51154h.f51145e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f21638a, "task_id", j.f21639b, "loc", "0");
                    int i2 = this.f51151e.f21785g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f21639b)) {
                        b.a.r0.l1.u.a.c().a(j.f21639b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f51151e.f21786h / 100);
                statisticItem.param("official_id", this.f51151e.f21787i);
                statisticItem.param("official_type", this.f51151e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f51151e.k);
                statisticItem.param("obj_params1", this.f51151e.f21782d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImageTextTopView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f51145e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f51146f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f51147g = (TextView) findViewById(R.id.top_title);
            this.f51148h = (TextView) findViewById(R.id.show_time);
            setOnLongClickListener(new a(this));
        }
    }

    public void onSkinChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f51146f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f51147g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f51148h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f51147g.setText("");
            this.f51146f.setBackgroundDrawable(null);
            this.f51146f.setImageDrawable(null);
            this.f51148h.setVisibility(8);
            this.f51148h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1072a c1072a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1072a, view, i2) == null) {
            setPadding((int) this.f51145e.getResources().getDimension(R.dimen.ds30), (int) this.f51145e.getResources().getDimension(R.dimen.ds30), (int) this.f51145e.getResources().getDimension(R.dimen.ds30), (int) this.f51145e.getResources().getDimension(R.dimen.ds30));
            if (c1072a == null) {
                return;
            }
            this.f51147g.setText(!TextUtils.isEmpty(c1072a.f21779a) ? c1072a.f21779a : "");
            if (!TextUtils.isEmpty(c1072a.f21782d)) {
                setOnClickListener(new b(this, c1072a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1072a.f21781c)) {
                return;
            }
            this.f51146f.setTag(c1072a.f21781c);
            this.f51146f.startLoad(c1072a.f21781c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(b.a.e.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f51149i = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.j = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f51148h.setVisibility(8);
                this.f51148h.setText("");
                return;
            }
            this.f51148h.setVisibility(0);
            this.f51148h.setText(str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51149i = null;
        this.f51145e = context;
        d();
    }
}
