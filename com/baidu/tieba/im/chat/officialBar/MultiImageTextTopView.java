package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.j1.g.d;
import c.a.q0.j1.l.c.a;
import c.a.q0.j1.w.c;
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
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52779e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52780f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52781g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52782h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.e.h.b f52783i;

    /* renamed from: j  reason: collision with root package name */
    public int f52784j;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f52785e;

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
            this.f52785e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f52785e.f52783i != null) {
                    this.f52785e.f52783i.onItemViewLongClick(view, 9, this.f52785e.f52784j, 0L);
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
        public final /* synthetic */ a.C0970a f52786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52788g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f52789h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C0970a c0970a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c0970a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52789h = multiImageTextTopView;
            this.f52786e = c0970a;
            this.f52787f = tbPageContext;
            this.f52788g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C0970a c0970a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c0970a = this.f52786e) == null || StringUtils.isNull(c0970a.f20911d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f52787f, new String[]{this.f52786e.f20911d});
            if (this.f52788g == 1) {
                TiebaStatic.eventStat(this.f52789h.f52779e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f52786e.f20912e);
                d j2 = c.j(this.f52786e.f20913f);
                if (j2 != null) {
                    TiebaStatic.eventStat(this.f52789h.f52779e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j2.f20762a, "task_id", j2.f20763b, "loc", "0");
                    int i2 = this.f52786e.f20914g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f20763b)) {
                        c.a.q0.j1.u.a.c().a(j2.f20763b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f52786e.f20915h / 100);
                statisticItem.param("official_id", this.f52786e.f20916i);
                statisticItem.param("official_type", this.f52786e.f20917j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f52786e.k);
                statisticItem.param("obj_params1", this.f52786e.f20911d);
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
            LayoutInflater.from(this.f52779e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f52780f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f52781g = (TextView) findViewById(R.id.top_title);
            this.f52782h = (TextView) findViewById(R.id.show_time);
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
            this.f52780f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f52781g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f52782h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f52781g.setText("");
            this.f52780f.setBackgroundDrawable(null);
            this.f52780f.setImageDrawable(null);
            this.f52782h.setVisibility(8);
            this.f52782h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C0970a c0970a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c0970a, view, i2) == null) {
            setPadding((int) this.f52779e.getResources().getDimension(R.dimen.ds30), (int) this.f52779e.getResources().getDimension(R.dimen.ds30), (int) this.f52779e.getResources().getDimension(R.dimen.ds30), (int) this.f52779e.getResources().getDimension(R.dimen.ds30));
            if (c0970a == null) {
                return;
            }
            this.f52781g.setText(!TextUtils.isEmpty(c0970a.f20908a) ? c0970a.f20908a : "");
            if (!TextUtils.isEmpty(c0970a.f20911d)) {
                setOnClickListener(new b(this, c0970a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c0970a.f20910c)) {
                return;
            }
            this.f52780f.setTag(c0970a.f20910c);
            this.f52780f.startLoad(c0970a.f20910c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(c.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f52783i = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f52784j = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f52782h.setVisibility(8);
                this.f52782h.setText("");
                return;
            }
            this.f52782h.setVisibility(0);
            this.f52782h.setText(str);
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
        this.f52783i = null;
        this.f52779e = context;
        d();
    }
}
