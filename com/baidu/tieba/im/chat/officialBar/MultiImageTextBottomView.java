package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import d.a.p0.i1.g.d;
import d.a.p0.i1.l.c.a;
import d.a.p0.i1.w.c;
/* loaded from: classes4.dex */
public class MultiImageTextBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17340e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17341f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17342g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.e.h.b f17343h;

    /* renamed from: i  reason: collision with root package name */
    public int f17344i;
    public int j;
    public String k;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f17345e;

        public a(MultiImageTextBottomView multiImageTextBottomView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17345e = multiImageTextBottomView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f17345e.f17343h != null) {
                    this.f17345e.f17343h.onItemViewLongClick(view, 9, this.f17345e.f17344i, 0L);
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
        public final /* synthetic */ a.C1468a f17346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17348g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f17349h;

        public b(MultiImageTextBottomView multiImageTextBottomView, a.C1468a c1468a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView, c1468a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17349h = multiImageTextBottomView;
            this.f17346e = c1468a;
            this.f17347f = tbPageContext;
            this.f17348g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1468a c1468a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1468a = this.f17346e) == null || StringUtils.isNull(c1468a.f58532d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17347f, new String[]{this.f17346e.f58532d});
            if (this.f17348g == 1) {
                TiebaStatic.eventStat(this.f17349h.f17340e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17346e.f58533e);
                d j = c.j(this.f17349h.k);
                if (j != null) {
                    Context context = this.f17349h.f17340e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f58388a, "task_id", j.f58389b, "loc", "" + this.f17349h.j);
                    int i2 = this.f17346e.f58535g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f58389b)) {
                        d.a.p0.i1.u.a.c().a(j.f58389b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17346e.f58536h / 100);
                statisticItem.param("official_id", this.f17346e.f58537i);
                statisticItem.param("official_type", this.f17346e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17346e.k);
                statisticItem.param("obj_params1", this.f17346e.f58532d);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImageTextBottomView(Context context) {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            LayoutInflater.from(this.f17340e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
            this.f17341f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f17342g = (TextView) findViewById(R.id.bottom_title);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f17341f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f17342g, R.color.common_color_10039, 1, skinType);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17342g.setText("");
            this.f17341f.setBackgroundDrawable(null);
            this.f17341f.setImageDrawable(null);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1468a c1468a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1468a, view, i2) == null) || c1468a == null) {
            return;
        }
        this.f17342g.setText(!TextUtils.isEmpty(c1468a.f58529a) ? c1468a.f58529a : "");
        if (!TextUtils.isEmpty(c1468a.f58532d)) {
            setOnClickListener(new b(this, c1468a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1468a.f58531c)) {
            return;
        }
        this.f17341f.setTag(c1468a.f58531c);
        this.f17341f.M(c1468a.f58531c, 10, false);
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f17343h = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f17344i = i2;
        }
    }

    public void setStPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.j = i2;
        }
    }

    public void setTaskInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.k = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
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
        this.f17343h = null;
        this.f17340e = context;
        f();
        setOnLongClickListener(new a(this));
    }
}
