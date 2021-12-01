package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.r0.r1.g.d;
import c.a.r0.r1.l.c.a;
import c.a.r0.r1.w.c;
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
/* loaded from: classes10.dex */
public class MultiImageTextBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45838e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45839f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45840g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.f.h.b f45841h;

    /* renamed from: i  reason: collision with root package name */
    public int f45842i;

    /* renamed from: j  reason: collision with root package name */
    public int f45843j;

    /* renamed from: k  reason: collision with root package name */
    public String f45844k;

    /* loaded from: classes10.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f45845e;

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
            this.f45845e = multiImageTextBottomView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f45845e.f45841h != null) {
                    this.f45845e.f45841h.onItemViewLongClick(view, 9, this.f45845e.f45842i, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1327a f45846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f45847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45848g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextBottomView f45849h;

        public b(MultiImageTextBottomView multiImageTextBottomView, a.C1327a c1327a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView, c1327a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45849h = multiImageTextBottomView;
            this.f45846e = c1327a;
            this.f45847f = tbPageContext;
            this.f45848g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1327a c1327a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1327a = this.f45846e) == null || StringUtils.isNull(c1327a.f23041d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f45847f, new String[]{this.f45846e.f23041d});
            if (this.f45848g == 1) {
                TiebaStatic.eventStat(this.f45849h.f45838e, "official_msg_ck", "click", 1, "fid", this.f45846e.f23042e);
                d j2 = c.j(this.f45849h.f45844k);
                if (j2 != null) {
                    Context context = this.f45849h.f45838e;
                    TiebaStatic.eventStat(context, "message_open_detail", "click", 1, "task_type", j2.a, "task_id", j2.f22924b, "loc", "" + this.f45849h.f45843j);
                    int i2 = this.f45846e.f23044g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f22924b)) {
                        c.a.r0.r1.u.a.c().a(j2.f22924b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f45846e.f23045h / 100);
                statisticItem.param("official_id", this.f45846e.f23046i);
                statisticItem.param("official_type", this.f45846e.f23047j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f45846e.f23048k);
                statisticItem.param("obj_params1", this.f45846e.f23041d);
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
            LayoutInflater.from(this.f45838e).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.bottom_content_pic);
            this.f45839f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f45840g = (TextView) findViewById(R.id.bottom_title);
        }
    }

    public void onSkinChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.f45839f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f45840g, R.color.common_color_10039, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f45840g.setText("");
            this.f45839f.setBackgroundDrawable(null);
            this.f45839f.setImageDrawable(null);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1327a c1327a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1327a, view, i2) == null) || c1327a == null) {
            return;
        }
        this.f45840g.setText(!TextUtils.isEmpty(c1327a.a) ? c1327a.a : "");
        if (!TextUtils.isEmpty(c1327a.f23041d)) {
            setOnClickListener(new b(this, c1327a, tbPageContext, i2));
        }
        if (TextUtils.isEmpty(c1327a.f23040c)) {
            return;
        }
        this.f45839f.setTag(c1327a.f23040c);
        this.f45839f.startLoad(c1327a.f23040c, 10, false);
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f45841h = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f45842i = i2;
        }
    }

    public void setStPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f45843j = i2;
        }
    }

    public void setTaskInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f45844k = str;
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
        this.f45841h = null;
        this.f45838e = context;
        f();
        setOnLongClickListener(new a(this));
    }
}
