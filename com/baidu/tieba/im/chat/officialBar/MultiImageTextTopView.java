package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f46569e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f46570f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46571g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46572h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.f.h.b f46573i;

    /* renamed from: j  reason: collision with root package name */
    public int f46574j;

    /* loaded from: classes12.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f46575e;

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
            this.f46575e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f46575e.f46573i != null) {
                    this.f46575e.f46573i.onItemViewLongClick(view, 9, this.f46575e.f46574j, 0L);
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
        public final /* synthetic */ a.C1354a f46576e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f46577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f46578g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f46579h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1354a c1354a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1354a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46579h = multiImageTextTopView;
            this.f46576e = c1354a;
            this.f46577f = tbPageContext;
            this.f46578g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1354a c1354a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1354a = this.f46576e) == null || StringUtils.isNull(c1354a.f22781d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f46577f, new String[]{this.f46576e.f22781d});
            if (this.f46578g == 1) {
                TiebaStatic.eventStat(this.f46579h.f46569e, "official_msg_ck", "click", 1, "fid", this.f46576e.f22782e);
                d j2 = c.j(this.f46576e.f22783f);
                if (j2 != null) {
                    TiebaStatic.eventStat(this.f46579h.f46569e, "message_open_detail", "click", 1, "task_type", j2.a, "task_id", j2.f22664b, "loc", "0");
                    int i2 = this.f46576e.f22784g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f22664b)) {
                        c.a.t0.s1.u.a.c().a(j2.f22664b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f46576e.f22785h / 100);
                statisticItem.param("official_id", this.f46576e.f22786i);
                statisticItem.param("official_type", this.f46576e.f22787j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f46576e.f22788k);
                statisticItem.param("obj_params1", this.f46576e.f22781d);
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
            LayoutInflater.from(this.f46569e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f46570f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f46571g = (TextView) findViewById(R.id.top_title);
            this.f46572h = (TextView) findViewById(R.id.show_time);
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
            this.f46570f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f46571g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f46572h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f46571g.setText("");
            this.f46570f.setBackgroundDrawable(null);
            this.f46570f.setImageDrawable(null);
            this.f46572h.setVisibility(8);
            this.f46572h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1354a c1354a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1354a, view, i2) == null) {
            setPadding((int) this.f46569e.getResources().getDimension(R.dimen.ds30), (int) this.f46569e.getResources().getDimension(R.dimen.ds30), (int) this.f46569e.getResources().getDimension(R.dimen.ds30), (int) this.f46569e.getResources().getDimension(R.dimen.ds30));
            if (c1354a == null) {
                return;
            }
            this.f46571g.setText(!TextUtils.isEmpty(c1354a.a) ? c1354a.a : "");
            if (!TextUtils.isEmpty(c1354a.f22781d)) {
                setOnClickListener(new b(this, c1354a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1354a.f22780c)) {
                return;
            }
            this.f46570f.setTag(c1354a.f22780c);
            this.f46570f.startLoad(c1354a.f22780c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f46573i = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f46574j = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f46572h.setVisibility(8);
                this.f46572h.setText("");
                return;
            }
            this.f46572h.setVisibility(0);
            this.f46572h.setText(str);
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
        this.f46573i = null;
        this.f46569e = context;
        d();
    }
}
