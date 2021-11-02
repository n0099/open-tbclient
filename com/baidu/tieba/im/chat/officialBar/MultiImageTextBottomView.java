package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class MultiImageTextBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f50224e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f50225f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50226g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.e.h.b f50227h;

    /* renamed from: i  reason: collision with root package name */
    public int f50228i;
    public int j;
    public String k;

    /* loaded from: classes9.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f50229e;

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
            this.f50229e = multiImageTextBottomView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f50229e.f50227h != null) {
                    this.f50229e.f50227h.onItemViewLongClick(view, 9, this.f50229e.f50228i, 0L);
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
        public final /* synthetic */ a.C1004a f50230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50231f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50232g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f50233h;

        public b(MultiImageTextBottomView multiImageTextBottomView, a.C1004a c1004a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView, c1004a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50233h = multiImageTextBottomView;
            this.f50230e = c1004a;
            this.f50231f = tbPageContext;
            this.f50232g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1004a c1004a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1004a = this.f50230e) == null || StringUtils.isNull(c1004a.f20260d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f50231f, new String[]{this.f50230e.f20260d});
            if (this.f50232g == 1) {
                TiebaStatic.eventStat(this.f50233h.f50224e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f50230e.f20261e);
                d j = c.j(this.f50233h.k);
                if (j != null) {
                    Context context = this.f50233h.f50224e;
                    TiebaStatic.eventStat(context, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f20116a, "task_id", j.f20117b, "loc", "" + this.f50233h.j);
                    int i2 = this.f50230e.f20263g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f20117b)) {
                        b.a.r0.l1.u.a.c().a(j.f20117b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f50230e.f20264h / 100);
                statisticItem.param("official_id", this.f50230e.f20265i);
                statisticItem.param("official_type", this.f50230e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f50230e.k);
                statisticItem.param("obj_params1", this.f50230e.f20260d);
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
            LayoutInflater.from(this.f50224e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
            this.f50225f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f50226g = (TextView) findViewById(R.id.bottom_title);
        }
    }

    public void onSkinChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f50225f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f50226g, R.color.common_color_10039, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f50226g.setText("");
            this.f50225f.setBackgroundDrawable(null);
            this.f50225f.setImageDrawable(null);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1004a c1004a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1004a, view, i2) == null) || c1004a == null) {
            return;
        }
        this.f50226g.setText(!TextUtils.isEmpty(c1004a.f20257a) ? c1004a.f20257a : "");
        if (!TextUtils.isEmpty(c1004a.f20260d)) {
            setOnClickListener(new b(this, c1004a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1004a.f20259c)) {
            return;
        }
        this.f50225f.setTag(c1004a.f20259c);
        this.f50225f.startLoad(c1004a.f20259c, 10, false);
    }

    public void setOnItemViewLongClickListener(b.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f50227h = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f50228i = i2;
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
        this.f50227h = null;
        this.f50224e = context;
        f();
        setOnLongClickListener(new a(this));
    }
}
