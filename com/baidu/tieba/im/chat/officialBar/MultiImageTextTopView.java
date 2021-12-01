package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45850e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45851f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45852g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45853h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.d.f.h.b f45854i;

    /* renamed from: j  reason: collision with root package name */
    public int f45855j;

    /* loaded from: classes10.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f45856e;

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
            this.f45856e = multiImageTextTopView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f45856e.f45854i != null) {
                    this.f45856e.f45854i.onItemViewLongClick(view, 9, this.f45856e.f45855j, 0L);
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
        public final /* synthetic */ a.C1327a f45857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f45858f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45859g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MultiImageTextTopView f45860h;

        public b(MultiImageTextTopView multiImageTextTopView, a.C1327a c1327a, TbPageContext tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, c1327a, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45860h = multiImageTextTopView;
            this.f45857e = c1327a;
            this.f45858f = tbPageContext;
            this.f45859g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.C1327a c1327a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (c1327a = this.f45857e) == null || StringUtils.isNull(c1327a.f23041d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f45858f, new String[]{this.f45857e.f23041d});
            if (this.f45859g == 1) {
                TiebaStatic.eventStat(this.f45860h.f45850e, "official_msg_ck", "click", 1, "fid", this.f45857e.f23042e);
                d j2 = c.j(this.f45857e.f23043f);
                if (j2 != null) {
                    TiebaStatic.eventStat(this.f45860h.f45850e, "message_open_detail", "click", 1, "task_type", j2.a, "task_id", j2.f22924b, "loc", "0");
                    int i2 = this.f45857e.f23044g;
                    if ((i2 == 1 || i2 == 3) && !"0".equals(j2.f22924b)) {
                        c.a.r0.r1.u.a.c().a(j2.f22924b);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                statisticItem.param("msg_id", this.f45857e.f23045h / 100);
                statisticItem.param("official_id", this.f45857e.f23046i);
                statisticItem.param("official_type", this.f45857e.f23047j);
                statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                statisticItem.param("task_id", this.f45857e.f23048k);
                statisticItem.param("obj_params1", this.f45857e.f23041d);
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
            LayoutInflater.from(this.f45850e).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.top_content_pic);
            this.f45851f = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f45852g = (TextView) findViewById(R.id.top_title);
            this.f45853h = (TextView) findViewById(R.id.show_time);
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
            this.f45851f.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.f45852g, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.f45853h, R.color.common_color_10067, 1, skinType);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f45852g.setText("");
            this.f45851f.setBackgroundDrawable(null);
            this.f45851f.setImageDrawable(null);
            this.f45853h.setVisibility(8);
            this.f45853h.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, a.C1327a c1327a, View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, c1327a, view, i2) == null) {
            setPadding((int) this.f45850e.getResources().getDimension(R.dimen.ds30), (int) this.f45850e.getResources().getDimension(R.dimen.ds30), (int) this.f45850e.getResources().getDimension(R.dimen.ds30), (int) this.f45850e.getResources().getDimension(R.dimen.ds30));
            if (c1327a == null) {
                return;
            }
            this.f45852g.setText(!TextUtils.isEmpty(c1327a.a) ? c1327a.a : "");
            if (!TextUtils.isEmpty(c1327a.f23041d)) {
                setOnClickListener(new b(this, c1327a, tbPageContext, i2));
            }
            if (TextUtils.isEmpty(c1327a.f23040c)) {
                return;
            }
            this.f45851f.setTag(c1327a.f23040c);
            this.f45851f.startLoad(c1327a.f23040c, 10, false);
        }
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f45854i = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f45855j = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f45853h.setVisibility(8);
                this.f45853h.setText("");
                return;
            }
            this.f45853h.setVisibility(0);
            this.f45853h.setText(str);
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
        this.f45854i = null;
        this.f45850e = context;
        d();
    }
}
