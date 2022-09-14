package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.gm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class b59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final e49 b;
    @Nullable
    public final View c;
    @Nullable
    public final TbAlphaVideo d;
    public final int e;
    public String f;
    public String g;
    public final HttpMessageListener h;
    public final gm8.f i;
    public gm8.f j;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b59 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b59 b59Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b59Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b59Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage.getError() == 0 && (map = (Map) MessageManager.getInstance().runTask(2001284, Map.class, httpResponsedMessage).getData()) != null) {
                String str = (String) map.get("b_url");
                String str2 = (String) map.get("dynamic_url");
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.a.f)) {
                    this.a.f = str;
                    this.a.g = str2;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(str2);
                    this.a.n(true);
                } else if (TextUtils.isEmpty(str) || str.equals(this.a.f)) {
                } else {
                    this.a.f = str;
                    this.a.g = str2;
                    TbadkCoreApplication.getInst().setDefaultBubble(this.a.f);
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.a.g);
                    this.a.n(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements gm8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b59 a;

        public b(b59 b59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b59Var;
        }

        @Override // com.baidu.tieba.gm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f = null;
                this.a.g = null;
                this.a.n(false);
                if (this.a.j != null) {
                    this.a.j.onRefresh();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ b59 b;

        public c(b59 b59Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b59Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b59Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((c) onVar, str, i);
                if (onVar == null || onVar.p() == null || onVar.o() == null) {
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), onVar.p(), onVar.p().getNinePatchChunk(), onVar.o(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                }
                this.b.c.setBackgroundDrawable(ninePatchDrawable);
                if (this.a && this.b.b.o() != null) {
                    gm8.c(this.b.a, this.b.b.o(), true, this.b.i);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
            }
        }
    }

    public b59(@NonNull TbPageContext<?> tbPageContext, @NonNull e49 e49Var, @Nullable View view2, @Nullable TbAlphaVideo tbAlphaVideo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, e49Var, view2, tbAlphaVideo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = TbadkCoreApplication.getInst().getDefaultBubble();
        this.g = TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes();
        this.h = new a(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.i = new b(this);
        this.a = tbPageContext;
        this.b = e49Var;
        this.c = view2;
        this.d = tbAlphaVideo;
        this.e = i;
        tbPageContext.registerListener(this.h);
        n(true);
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.c == null || this.e == 14 || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) || TextUtils.isEmpty(this.f)) {
            return;
        }
        if (this.d != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
            if (!TextUtils.isEmpty(this.g)) {
                marginLayoutParams.topMargin = this.a.getResources().getDimensionPixelSize(R.dimen.tbds48) * (-1);
                this.d.setVisibility(0);
                this.d.k(ln4.a(this.g));
            } else {
                this.d.setVisibility(8);
                marginLayoutParams.topMargin = 0;
            }
            this.c.setLayoutParams(marginLayoutParams);
        }
        zg.h().m(this.f, 19, new c(this, z), this.a.getUniqueId());
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n(false);
        }
    }

    public void m(u45 u45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u45Var) == null) && u45Var.a == 25) {
            Object obj = u45Var.c;
            if (obj instanceof Map) {
                Map map = (Map) obj;
                this.f = (String) map.get("b_url");
                this.g = (String) map.get("dynamic_url");
            } else {
                this.f = null;
                this.g = null;
            }
            n(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void n(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (view2 = this.c) == null) {
            return;
        }
        view2.setPadding(0, 0, 0, 0);
        this.c.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
        k(z);
    }

    public void o(gm8.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.j = fVar;
        }
    }
}
