package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.dba;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class exa {
    public static /* synthetic */ Interceptable $ic = null;
    public static double k = 3.88d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final bwa b;
    @Nullable
    public final View c;
    @Nullable
    public final TbAlphaVideo d;
    public final int e;
    public String f;
    public String g;
    public final HttpMessageListener h;
    public final dba.f i;
    public dba.f j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947751099, "Lcom/baidu/tieba/exa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947751099, "Lcom/baidu/tieba/exa;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ exa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(exa exaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exaVar, Integer.valueOf(i)};
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
            this.a = exaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Map map;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage.getError() != 0 || (map = (Map) MessageManager.getInstance().runTask(2001284, Map.class, httpResponsedMessage).getData()) == null) {
                return;
            }
            String str = (String) map.get("b_url");
            String str2 = (String) map.get("dynamic_url");
            if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.a.f)) {
                if (TextUtils.isEmpty(str) || str.equals(this.a.f)) {
                    return;
                }
                this.a.f = str;
                this.a.g = str2;
                TbadkCoreApplication.getInst().setDefaultBubble(this.a.f);
                TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(this.a.g);
                this.a.o(true);
                return;
            }
            this.a.f = str;
            this.a.g = str2;
            TbadkCoreApplication.getInst().setDefaultBubble(str);
            TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(str2);
            this.a.o(true);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dba.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ exa a;

        public b(exa exaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = exaVar;
        }

        @Override // com.baidu.tieba.dba.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.f = null;
            this.a.g = null;
            this.a.o(false);
            if (this.a.j != null) {
                this.a.j.onRefresh();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ exa b;

        public c(exa exaVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exaVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = exaVar;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((c) bdImage, str, i);
                if (bdImage != null && bdImage.getRawBitmap() != null && bdImage.getPadding() != null) {
                    NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), bdImage.getRawBitmap(), bdImage.getRawBitmap().getNinePatchChunk(), bdImage.getPadding(), null);
                    if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                    }
                    this.b.c.setBackgroundDrawable(ninePatchDrawable);
                    if (this.a && this.b.b.p() != null) {
                        dba.c(this.b.a, this.b.b.p(), true, this.b.i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001353, Boolean.TRUE));
                }
            }
        }
    }

    public exa(@NonNull TbPageContext<?> tbPageContext, @NonNull bwa bwaVar, @Nullable View view2, @Nullable TbAlphaVideo tbAlphaVideo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bwaVar, view2, tbAlphaVideo, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = TbadkCoreApplication.getInst().getDefaultBubble();
        this.g = TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes();
        this.h = new a(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.i = new b(this);
        this.a = tbPageContext;
        this.b = bwaVar;
        this.c = view2;
        this.d = tbAlphaVideo;
        this.e = i;
        tbPageContext.registerListener(this.h);
        o(true);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048580, this, z) != null) || (view2 = this.c) == null) {
            return;
        }
        view2.setPadding(0, 0, 0, 0);
        this.c.setBackgroundDrawable(null);
        SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
        l(z);
    }

    public void p(dba.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public final void k(TbAlphaVideo tbAlphaVideo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbAlphaVideo) != null) || tbAlphaVideo == null) {
            return;
        }
        int dip2px = BdUtilHelper.dip2px(TbadkCoreApplication.getInst(), 50.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (dip2px * k), dip2px);
        layoutParams.addRule(11);
        layoutParams.rightMargin = this.a.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        tbAlphaVideo.setLayoutParams(layoutParams);
    }

    public void n(lh5 lh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, lh5Var) == null) && lh5Var.a == 25) {
            Object obj = lh5Var.c;
            if (obj instanceof Map) {
                Map map = (Map) obj;
                this.f = (String) map.get("b_url");
                this.g = (String) map.get("dynamic_url");
            } else {
                this.f = null;
                this.g = null;
            }
            o(false);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.c == null || this.e == 14 || !TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f)) {
            if (this.d != null) {
                if (!TextUtils.isEmpty(this.g)) {
                    this.d.setVisibility(0);
                    this.d.k(kv4.a(this.g));
                    k(this.d);
                } else {
                    this.d.setVisibility(8);
                }
            }
            BdResourceLoader.getInstance().loadResource(this.f, 19, new c(this, z), this.a.getUniqueId());
            return;
        }
        this.d.setVisibility(8);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o(false);
        }
    }
}
