package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.t0.s1.g.d;
import c.a.t0.s1.l.c.a;
import c.a.t0.s1.w.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes12.dex */
public class MultiImageTextBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f44837e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f44838f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44839g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.f.h.b f44840h;

    /* renamed from: i  reason: collision with root package name */
    public int f44841i;

    /* renamed from: j  reason: collision with root package name */
    public int f44842j;
    public String k;

    /* loaded from: classes12.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f44843e;

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
            this.f44843e = multiImageTextBottomView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f44843e.f44840h != null) {
                    this.f44843e.f44840h.onItemViewLongClick(view, 9, this.f44843e.f44841i, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1369a f44844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f44845f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44846g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f44847h;

        public b(MultiImageTextBottomView multiImageTextBottomView, a.C1369a c1369a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView, c1369a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44847h = multiImageTextBottomView;
            this.f44844e = c1369a;
            this.f44845f = tbPageContext;
            this.f44846g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1369a c1369a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1369a = this.f44844e) == null || StringUtils.isNull(c1369a.f22155d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f44845f, new String[]{this.f44844e.f22155d});
            if (this.f44846g == 1) {
                TiebaStatic.eventStat(this.f44847h.f44837e, "official_msg_ck", "click", 1, "fid", this.f44844e.f22156e);
                d j2 = c.j(this.f44847h.k);
                if (j2 != null) {
                    Context context = this.f44847h.f44837e;
                    TiebaStatic.eventStat(context, "message_open_detail", "click", 1, "task_type", j2.a, "task_id", j2.f22043b, "loc", "" + this.f44847h.f44842j);
                    int i2 = this.f44844e.f22158g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f22043b)) {
                        c.a.t0.s1.u.a.c().a(j2.f22043b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f44844e.f22159h / 100);
                statisticItem.param("official_id", this.f44844e.f22160i);
                statisticItem.param("official_type", this.f44844e.f22161j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f44844e.k);
                statisticItem.param("obj_params1", this.f44844e.f22155d);
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
            LayoutInflater.from(this.f44837e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
            this.f44838f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f44839g = (TextView) findViewById(R.id.bottom_title);
        }
    }

    public void onSkinChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f44838f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f44839g, R.color.common_color_10039, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f44839g.setText("");
            this.f44838f.setBackgroundDrawable(null);
            this.f44838f.setImageDrawable(null);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1369a c1369a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1369a, view, i2) == null) || c1369a == null) {
            return;
        }
        this.f44839g.setText(!TextUtils.isEmpty(c1369a.a) ? c1369a.a : "");
        if (!TextUtils.isEmpty(c1369a.f22155d)) {
            setOnClickListener(new b(this, c1369a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1369a.f22154c)) {
            return;
        }
        this.f44838f.setTag(c1369a.f22154c);
        this.f44838f.startLoad(c1369a.f22154c, 10, false);
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f44840h = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f44841i = i2;
        }
    }

    public void setStPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f44842j = i2;
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
        this.f44840h = null;
        this.f44837e = context;
        f();
        setOnLongClickListener(new a(this));
    }
}
