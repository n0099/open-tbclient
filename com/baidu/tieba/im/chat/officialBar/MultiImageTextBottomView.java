package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.r0.l1.g.d;
import c.a.r0.l1.l.c.a;
import c.a.r0.l1.w.c;
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
/* loaded from: classes7.dex */
public class MultiImageTextBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52958e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52959f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52960g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.e.h.b f52961h;

    /* renamed from: i  reason: collision with root package name */
    public int f52962i;

    /* renamed from: j  reason: collision with root package name */
    public int f52963j;
    public String k;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f52964e;

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
            this.f52964e = multiImageTextBottomView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f52964e.f52961h != null) {
                    this.f52964e.f52961h.onItemViewLongClick(view, 9, this.f52964e.f52962i, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1010a f52965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52966f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52967g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f52968h;

        public b(MultiImageTextBottomView multiImageTextBottomView, a.C1010a c1010a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView, c1010a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52968h = multiImageTextBottomView;
            this.f52965e = c1010a;
            this.f52966f = tbPageContext;
            this.f52967g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1010a c1010a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1010a = this.f52965e) == null || StringUtils.isNull(c1010a.f21675d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f52966f, new String[]{this.f52965e.f21675d});
            if (this.f52967g == 1) {
                TiebaStatic.eventStat(this.f52968h.f52958e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f52965e.f21676e);
                d j2 = c.j(this.f52968h.k);
                if (j2 != null) {
                    Context context = this.f52968h.f52958e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j2.f21526a, "task_id", j2.f21527b, "loc", "" + this.f52968h.f52963j);
                    int i2 = this.f52965e.f21678g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f21527b)) {
                        c.a.r0.l1.u.a.c().a(j2.f21527b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f52965e.f21679h / 100);
                statisticItem.param("official_id", this.f52965e.f21680i);
                statisticItem.param("official_type", this.f52965e.f21681j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f52965e.k);
                statisticItem.param("obj_params1", this.f52965e.f21675d);
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
            LayoutInflater.from(this.f52958e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
            this.f52959f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f52960g = (TextView) findViewById(R.id.bottom_title);
        }
    }

    public void onSkinChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f52959f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f52960g, R.color.common_color_10039, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f52960g.setText("");
            this.f52959f.setBackgroundDrawable(null);
            this.f52959f.setImageDrawable(null);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1010a c1010a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1010a, view, i2) == null) || c1010a == null) {
            return;
        }
        this.f52960g.setText(!TextUtils.isEmpty(c1010a.f21672a) ? c1010a.f21672a : "");
        if (!TextUtils.isEmpty(c1010a.f21675d)) {
            setOnClickListener(new b(this, c1010a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1010a.f21674c)) {
            return;
        }
        this.f52959f.setTag(c1010a.f21674c);
        this.f52959f.startLoad(c1010a.f21674c, 10, false);
    }

    public void setOnItemViewLongClickListener(c.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f52961h = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f52962i = i2;
        }
    }

    public void setStPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f52963j = i2;
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
        this.f52961h = null;
        this.f52958e = context;
        f();
        setOnLongClickListener(new a(this));
    }
}
