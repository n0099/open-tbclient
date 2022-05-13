package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a97;
import com.repackage.c87;
import com.repackage.ff;
import com.repackage.p57;
import com.repackage.v67;
/* loaded from: classes3.dex */
public class MultiImageTextBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbImageView b;
    public TextView c;
    public ff d;
    public int e;
    public int f;
    public String g;

    /* loaded from: classes3.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImageTextBottomView a;

        public a(MultiImageTextBottomView multiImageTextBottomView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImageTextBottomView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.d != null) {
                    this.a.d.onItemViewLongClick(view2, 9, this.a.e, 0L);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67.a a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MultiImageTextBottomView d;

        public b(MultiImageTextBottomView multiImageTextBottomView, v67.a aVar, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImageTextBottomView, aVar, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = multiImageTextBottomView;
            this.a = aVar;
            this.b = tbPageContext;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            v67.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = this.a) == null || StringUtils.isNull(aVar.d)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{this.a.d});
            if (this.c == 1) {
                TiebaStatic.eventStat(this.d.a, "official_msg_ck", "click", 1, "fid", this.a.e);
                p57 l = a97.l(this.d.g);
                if (l != null) {
                    Context context = this.d.a;
                    TiebaStatic.eventStat(context, "message_open_detail", "click", 1, StampMissionHttpRequestMessage.KEY_TASK_TYPE, l.a, "task_id", l.b, "loc", "" + this.d.f);
                    int i = this.a.g;
                    if ((i == 1 || i == 3) && !"0".equals(l.b)) {
                        c87.c().a(l.b);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImageTextBottomView(Context context) {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(0);
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0553, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0903c2);
            this.b = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0903e6);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!z) {
                skinType = 0;
            }
            this.b.setAutoChangeStyle(z);
            SkinManager.setViewTextColor(this.c, R.color.common_color_10039, 1, skinType);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setText("");
            this.b.setBackgroundDrawable(null);
            this.b.setImageDrawable(null);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, v67.a aVar, View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, tbPageContext, aVar, view2, i) == null) || aVar == null) {
            return;
        }
        this.c.setText(!TextUtils.isEmpty(aVar.a) ? aVar.a : "");
        if (!TextUtils.isEmpty(aVar.d)) {
            setOnClickListener(new b(this, aVar, tbPageContext, i));
        }
        if (TextUtils.isEmpty(aVar.c)) {
            return;
        }
        this.b.setTag(aVar.c);
        this.b.K(aVar.c, 10, false);
    }

    public void setOnItemViewLongClickListener(ff ffVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ffVar) == null) {
            this.d = ffVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
        }
    }

    public void setStPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }

    public void setTaskInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.a = context;
        f();
        setOnLongClickListener(new a(this));
    }
}
