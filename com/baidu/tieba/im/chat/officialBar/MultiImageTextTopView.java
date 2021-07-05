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
import d.a.s0.i1.g.d;
import d.a.s0.i1.l.c.a;
import d.a.s0.i1.w.c;
/* loaded from: classes5.dex */
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f17311e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17312f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17313g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17314h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.e.h.b f17315i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f17316e;

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
            this.f17316e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f17316e.f17315i != null) {
                    this.f17316e.f17315i.onItemViewLongClick(view, 9, this.f17316e.j, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1512a f17317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f17318f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17319g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f17320h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1512a c1512a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1512a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17320h = multiImageTextTopView;
            this.f17317e = c1512a;
            this.f17318f = tbPageContext;
            this.f17319g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1512a c1512a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1512a = this.f17317e) == null || StringUtils.isNull(c1512a.f61767d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f17318f, new String[]{this.f17317e.f61767d});
            if (this.f17319g == 1) {
                TiebaStatic.eventStat(this.f17320h.f17311e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f17317e.f61768e);
                d j = c.j(this.f17317e.f61769f);
                if (j != null) {
                    TiebaStatic.eventStat(this.f17320h.f17311e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f61623a, "task_id", j.f61624b, "loc", "0");
                    int i2 = this.f17317e.f61770g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f61624b)) {
                        d.a.s0.i1.u.a.c().a(j.f61624b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f17317e.f61771h / 100);
                statisticItem.param("official_id", this.f17317e.f61772i);
                statisticItem.param("official_type", this.f17317e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f17317e.k);
                statisticItem.param("obj_params1", this.f17317e.f61767d);
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
            LayoutInflater.from(this.f17311e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f17312f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f17313g = (TextView) findViewById(R.id.top_title);
            this.f17314h = (TextView) findViewById(R.id.show_time);
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
            this.f17312f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f17313g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f17314h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f17313g.setText("");
            this.f17312f.setBackgroundDrawable(null);
            this.f17312f.setImageDrawable(null);
            this.f17314h.setVisibility(8);
            this.f17314h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1512a c1512a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1512a, view, i2) == null) {
            setPadding((int) this.f17311e.getResources().getDimension(R.dimen.ds30), (int) this.f17311e.getResources().getDimension(R.dimen.ds30), (int) this.f17311e.getResources().getDimension(R.dimen.ds30), (int) this.f17311e.getResources().getDimension(R.dimen.ds30));
            if (c1512a == null) {
                return;
            }
            this.f17313g.setText(!TextUtils.isEmpty(c1512a.f61764a) ? c1512a.f61764a : "");
            if (!TextUtils.isEmpty(c1512a.f61767d)) {
                setOnClickListener(new b(this, c1512a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1512a.f61766c)) {
                return;
            }
            this.f17312f.setTag(c1512a.f61766c);
            this.f17312f.M(c1512a.f61766c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(d.a.c.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f17315i = bVar;
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
                this.f17314h.setVisibility(8);
                this.f17314h.setText("");
                return;
            }
            this.f17314h.setVisibility(0);
            this.f17314h.setText(str);
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
        this.f17315i = null;
        this.f17311e = context;
        d();
    }
}
