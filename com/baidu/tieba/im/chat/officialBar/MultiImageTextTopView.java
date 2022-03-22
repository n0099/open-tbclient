package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.p0.u1.g.d;
import c.a.p0.u1.l.c.a;
import c.a.p0.u1.w.c;
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
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f33700b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33701c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33702d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.f.h.b f33703e;

    /* renamed from: f  reason: collision with root package name */
    public int f33704f;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageTextTopView a;

        public a(MultiImageTextTopView multiImageTextTopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.a.f33703e != null) {
                    this.a.f33703e.onItemViewLongClick(view, 9, this.a.f33704f, 0L);
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
        public final /* synthetic */ a.C1417a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f33705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f33706c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f33707d;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1417a c1417a, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1417a, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33707d = multiImageTextTopView;
            this.a = c1417a;
            this.f33705b = tbPageContext;
            this.f33706c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1417a c1417a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1417a = this.a) == null || StringUtils.isNull(c1417a.f18836d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f33705b, new String[]{this.a.f18836d});
            if (this.f33706c == 1) {
                TiebaStatic.eventStat(this.f33707d.a, "official_msg_ck", "click", 1, "fid", this.a.f18837e);
                d j = c.j(this.a.f18838f);
                if (j != null) {
                    TiebaStatic.eventStat(this.f33707d.a, "message_open_detail", "click", 1, StampMissionHttpRequestMessage.KEY_TASK_TYPE, j.a, "task_id", j.f18756b, "loc", "0");
                    int i = this.a.f18839g;
                    if ((i == 1 || i == 3) && !"0".equals(j.f18756b)) {
                        c.a.p0.u1.u.a.c().a(j.f18756b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.a.f18840h / 100);
                statisticItem.param("official_id", this.a.i);
                statisticItem.param("official_type", this.a.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.a.k);
                statisticItem.param("obj_params1", this.a.f18836d);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0566, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0920af);
            this.f33700b = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f33701c = (TextView) findViewById(R.id.obfuscated_res_0x7f0920ce);
            this.f33702d = (TextView) findViewById(R.id.obfuscated_res_0x7f091cf9);
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
            this.f33700b.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f33701c, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f33702d, R.color.common_color_10067, 1, skinType);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f33701c.setText("");
            this.f33700b.setBackgroundDrawable(null);
            this.f33700b.setImageDrawable(null);
            this.f33702d.setVisibility(8);
            this.f33702d.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1417a c1417a, View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1417a, view, i) == null) {
            setPadding((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201), (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201), (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201), (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
            if (c1417a == null) {
                return;
            }
            this.f33701c.setText(!TextUtils.isEmpty(c1417a.a) ? c1417a.a : "");
            if (!TextUtils.isEmpty(c1417a.f18836d)) {
                setOnClickListener(new b(this, c1417a, tbPageContext, i));
            }
            if (TextUtils.isEmpty(c1417a.f18835c)) {
                return;
            }
            this.f33700b.setTag(c1417a.f18835c);
            this.f33700b.J(c1417a.f18835c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f33703e = bVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f33704f = i;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f33702d.setVisibility(8);
                this.f33702d.setText("");
                return;
            }
            this.f33702d.setVisibility(0);
            this.f33702d.setText(str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f33703e = null;
        this.a = context;
        d();
    }
}
