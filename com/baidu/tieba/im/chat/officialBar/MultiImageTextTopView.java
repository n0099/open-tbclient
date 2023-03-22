package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.ap7;
import com.baidu.tieba.bf;
import com.baidu.tieba.eq7;
import com.baidu.tieba.hs7;
import com.baidu.tieba.nr7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MultiImageTextTopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public bf e;
    public int f;

    /* loaded from: classes4.dex */
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
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.e != null) {
                    this.a.e.P(view2, 9, this.a.f, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eq7.a a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MultiImageTextTopView d;

        public b(MultiImageTextTopView multiImageTextTopView, eq7.a aVar, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextTopView, aVar, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = multiImageTextTopView;
            this.a = aVar;
            this.b = tbPageContext;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            eq7.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.a) != null && !StringUtils.isNull(aVar.d)) {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.a.d});
                if (this.c == 1) {
                    TiebaStatic.eventStat(this.d.a, "official_msg_ck", "click", 1, "fid", this.a.e);
                    ap7 n = hs7.n(this.a.f);
                    if (n != null) {
                        TiebaStatic.eventStat(this.d.a, "message_open_detail", "click", 1, "task_type", n.a, "task_id", n.b, "loc", "0");
                        int i = this.a.g;
                        if ((i == 1 || i == 3) && !"0".equals(n.b)) {
                            nr7.c().a(n.b);
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("official_message_open_detail");
                    statisticItem.param("msg_id", this.a.h / 100);
                    statisticItem.param("official_id", this.a.i);
                    statisticItem.param("official_type", this.a.j);
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", this.a.k);
                    statisticItem.param("obj_params1", this.a.d);
                    TiebaStatic.log(statisticItem);
                }
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
        this.e = null;
        this.a = context;
        d();
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.b.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0111, 1, skinType);
            SkinManager.setViewTextColor(this.d, R.color.common_color_10067, 1, skinType);
        }
    }

    public void setOnItemViewLongClickListener(bf bfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bfVar) == null) {
            this.e = bfVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.d.setVisibility(8);
                this.d.setText("");
                return;
            }
            this.d.setVisibility(0);
            this.d.setText(str);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05e5, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092483);
            this.b = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0924a1);
            this.d = (TextView) findViewById(R.id.show_time);
            setOnLongClickListener(new a(this));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setText("");
            this.b.setBackgroundDrawable(null);
            this.b.setImageDrawable(null);
            this.d.setVisibility(8);
            this.d.setText("");
        }
    }

    public void setData(TbPageContext<?> tbPageContext, eq7.a aVar, View view2, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, aVar, view2, i) == null) {
            setPadding((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201), (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201), (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201), (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
            if (aVar == null) {
                return;
            }
            if (!TextUtils.isEmpty(aVar.a)) {
                str = aVar.a;
            } else {
                str = "";
            }
            this.c.setText(str);
            if (!TextUtils.isEmpty(aVar.d)) {
                setOnClickListener(new b(this, aVar, tbPageContext, i));
            }
            if (!TextUtils.isEmpty(aVar.c)) {
                this.b.setTag(aVar.c);
                this.b.M(aVar.c, 10, false);
            }
        }
    }
}
