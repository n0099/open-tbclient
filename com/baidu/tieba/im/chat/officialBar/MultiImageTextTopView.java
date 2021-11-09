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
    public Context f50233e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f50234f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50235g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50236h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.e.e.h.b f50237i;
    public int j;

    /* loaded from: classes9.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f50238e;

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
            this.f50238e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f50238e.f50237i != null) {
                    this.f50238e.f50237i.onItemViewLongClick(view, 9, this.f50238e.j, 0L);
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
        public final /* synthetic */ a.C1004a f50239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f50240f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50241g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f50242h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1004a c1004a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1004a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50242h = multiImageTextTopView;
            this.f50239e = c1004a;
            this.f50240f = tbPageContext;
            this.f50241g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1004a c1004a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1004a = this.f50239e) == null || StringUtils.isNull(c1004a.f20260d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f50240f, new String[]{this.f50239e.f20260d});
            if (this.f50241g == 1) {
                TiebaStatic.eventStat(this.f50242h.f50233e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f50239e.f20261e);
                d j = c.j(this.f50239e.f20262f);
                if (j != null) {
                    TiebaStatic.eventStat(this.f50242h.f50233e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j.f20116a, "task_id", j.f20117b, "loc", "0");
                    int i2 = this.f50239e.f20263g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j.f20117b)) {
                        b.a.r0.l1.u.a.c().a(j.f20117b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f50239e.f20264h / 100);
                statisticItem.param("official_id", this.f50239e.f20265i);
                statisticItem.param("official_type", this.f50239e.j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f50239e.k);
                statisticItem.param("obj_params1", this.f50239e.f20260d);
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
            LayoutInflater.from(this.f50233e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f50234f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f50235g = (TextView) findViewById(R.id.top_title);
            this.f50236h = (TextView) findViewById(R.id.show_time);
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
            this.f50234f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f50235g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f50236h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f50235g.setText("");
            this.f50234f.setBackgroundDrawable(null);
            this.f50234f.setImageDrawable(null);
            this.f50236h.setVisibility(8);
            this.f50236h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1004a c1004a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1004a, view, i2) == null) {
            setPadding((int) this.f50233e.getResources().getDimension(R.dimen.ds30), (int) this.f50233e.getResources().getDimension(R.dimen.ds30), (int) this.f50233e.getResources().getDimension(R.dimen.ds30), (int) this.f50233e.getResources().getDimension(R.dimen.ds30));
            if (c1004a == null) {
                return;
            }
            this.f50235g.setText(!TextUtils.isEmpty(c1004a.f20257a) ? c1004a.f20257a : "");
            if (!TextUtils.isEmpty(c1004a.f20260d)) {
                setOnClickListener(new b(this, c1004a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1004a.f20259c)) {
                return;
            }
            this.f50234f.setTag(c1004a.f20259c);
            this.f50234f.startLoad(c1004a.f20259c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(b.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f50237i = bVar;
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
                this.f50236h.setVisibility(8);
                this.f50236h.setText("");
                return;
            }
            this.f50236h.setVisibility(0);
            this.f50236h.setText(str);
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
        this.f50237i = null;
        this.f50233e = context;
        d();
    }
}
