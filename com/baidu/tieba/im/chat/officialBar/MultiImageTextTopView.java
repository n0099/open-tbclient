package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.r0.k1.g.d;
import c.a.r0.k1.l.c.a;
import c.a.r0.k1.w.c;
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
    public Context f53038e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f53039f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53040g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53041h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.e.h.b f53042i;

    /* renamed from: j  reason: collision with root package name */
    public int f53043j;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f53044e;

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
            this.f53044e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f53044e.f53042i != null) {
                    this.f53044e.f53042i.onItemViewLongClick(view, 9, this.f53044e.f53043j, 0L);
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
        public final /* synthetic */ a.C1001a f53045e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f53046f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53047g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f53048h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1001a c1001a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1001a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53048h = multiImageTextTopView;
            this.f53045e = c1001a;
            this.f53046f = tbPageContext;
            this.f53047g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1001a c1001a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1001a = this.f53045e) == null || StringUtils.isNull(c1001a.f21495d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f53046f, new String[]{this.f53045e.f21495d});
            if (this.f53047g == 1) {
                TiebaStatic.eventStat(this.f53048h.f53038e, "official_msg_ck", PrefetchEvent.STATE_CLICK, 1, "fid", this.f53045e.f21496e);
                d j2 = c.j(this.f53045e.f21497f);
                if (j2 != null) {
                    TiebaStatic.eventStat(this.f53048h.f53038e, "message_open_detail", PrefetchEvent.STATE_CLICK, 1, "task_type", j2.f21346a, "task_id", j2.f21347b, "loc", "0");
                    int i2 = this.f53045e.f21498g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f21347b)) {
                        c.a.r0.k1.u.a.c().a(j2.f21347b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f53045e.f21499h / 100);
                statisticItem.param("official_id", this.f53045e.f21500i);
                statisticItem.param("official_type", this.f53045e.f21501j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f53045e.k);
                statisticItem.param("obj_params1", this.f53045e.f21495d);
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
            LayoutInflater.from(this.f53038e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f53039f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f53040g = (TextView) findViewById(R.id.top_title);
            this.f53041h = (TextView) findViewById(R.id.show_time);
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
            this.f53039f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f53040g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f53041h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f53040g.setText("");
            this.f53039f.setBackgroundDrawable(null);
            this.f53039f.setImageDrawable(null);
            this.f53041h.setVisibility(8);
            this.f53041h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1001a c1001a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1001a, view, i2) == null) {
            setPadding((int) this.f53038e.getResources().getDimension(R.dimen.ds30), (int) this.f53038e.getResources().getDimension(R.dimen.ds30), (int) this.f53038e.getResources().getDimension(R.dimen.ds30), (int) this.f53038e.getResources().getDimension(R.dimen.ds30));
            if (c1001a == null) {
                return;
            }
            this.f53040g.setText(!TextUtils.isEmpty(c1001a.f21492a) ? c1001a.f21492a : "");
            if (!TextUtils.isEmpty(c1001a.f21495d)) {
                setOnClickListener(new b(this, c1001a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1001a.f21494c)) {
                return;
            }
            this.f53039f.setTag(c1001a.f21494c);
            this.f53039f.startLoad(c1001a.f21494c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(c.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f53042i = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f53043j = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f53041h.setVisibility(8);
                this.f53041h.setText("");
                return;
            }
            this.f53041h.setVisibility(0);
            this.f53041h.setText(str);
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
        this.f53042i = null;
        this.f53038e = context;
        d();
    }
}
