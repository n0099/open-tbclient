package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import d.a.q0.i1.g.d;
import d.a.q0.i1.l.c.a;
import d.a.q0.i1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17406e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17407f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17408g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17409h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.d.e.h.b f17410i;
    public int j;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f17411e;

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
            this.f17411e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f17411e.f17410i != null) {
                    this.f17411e.f17410i.onItemViewLongClick(view, 9, this.f17411e.j, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1473a f17412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17414g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f17415h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1473a c1473a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1473a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17415h = multiImageTextTopView;
            this.f17412e = c1473a;
            this.f17413f = tbPageContext;
            this.f17414g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1473a c1473a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1473a = this.f17412e) == null || StringUtils.isNull(c1473a.f59146d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17413f, new String[]{this.f17412e.f59146d});
            if (this.f17414g == 1) {
                TiebaStatic.eventStat(this.f17415h.f17406e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17412e.f59147e);
                d j = c.j(this.f17412e.f59148f);
                if (j != null) {
                    TiebaStatic.eventStat(this.f17415h.f17406e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f59002a, "task_id", j.f59003b, "loc", "0");
                    int i2 = this.f17412e.f59149g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f59003b)) {
                        d.a.q0.i1.u.a.c().a(j.f59003b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17412e.f59150h / 100);
                statisticItem.param("official_id", this.f17412e.f59151i);
                statisticItem.param("official_type", this.f17412e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17412e.k);
                statisticItem.param("obj_params1", this.f17412e.f59146d);
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
            LayoutInflater.from(this.f17406e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f17407f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f17408g = (TextView) findViewById(R.id.top_title);
            this.f17409h = (TextView) findViewById(R.id.show_time);
            setOnLongClickListener(new a(this));
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f17407f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f17408g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f17409h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17408g.setText("");
            this.f17407f.setBackgroundDrawable(null);
            this.f17407f.setImageDrawable(null);
            this.f17409h.setVisibility(8);
            this.f17409h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1473a c1473a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1473a, view, i2) == null) {
            setPadding((int) this.f17406e.getResources().getDimension(R.dimen.ds30), (int) this.f17406e.getResources().getDimension(R.dimen.ds30), (int) this.f17406e.getResources().getDimension(R.dimen.ds30), (int) this.f17406e.getResources().getDimension(R.dimen.ds30));
            if (c1473a == null) {
                return;
            }
            this.f17408g.setText(!TextUtils.isEmpty(c1473a.f59143a) ? c1473a.f59143a : "");
            if (!TextUtils.isEmpty(c1473a.f59146d)) {
                setOnClickListener(new b(this, c1473a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1473a.f59145c)) {
                return;
            }
            this.f17407f.setTag(c1473a.f59145c);
            this.f17407f.M(c1473a.f59145c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(d.a.d.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f17410i = bVar;
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
                this.f17409h.setVisibility(8);
                this.f17409h.setText("");
                return;
            }
            this.f17409h.setVisibility(0);
            this.f17409h.setText(str);
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
        this.f17410i = null;
        this.f17406e = context;
        d();
    }
}
