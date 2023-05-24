package com.baidu.tieba;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
/* loaded from: classes5.dex */
public final class bhb extends zgb<BannerConfigItem.BannerInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageLoaderSupplier c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947646381, "Lcom/baidu/tieba/bhb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947646381, "Lcom/baidu/tieba/bhb;");
        }
    }

    /* loaded from: classes5.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public final /* synthetic */ bhb b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(bhb bhbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bhbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bhbVar;
        }

        public final void c(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageView) == null) {
                this.a = imageView;
            }
        }

        public final ImageView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (ImageView) invokeV.objValue;
        }

        public final void b(BannerConfigItem.BannerInfo bannerInfo, int i, Context context) {
            ImageView imageView;
            ImageLoaderSupplier e;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bannerInfo, i, context) == null) && (imageView = this.a) != null && (e = this.b.e()) != null) {
                if (bannerInfo != null) {
                    str = bannerInfo.imageUrl;
                } else {
                    str = null;
                }
                ImageLoaderSupplier.ImageParam imageParam = new ImageLoaderSupplier.ImageParam(str, -1, -1);
                if (context instanceof ContextThemeWrapper) {
                    ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) context;
                    if (mgb.a.a(contextThemeWrapper.getBaseContext())) {
                        RLog.debug("PluginCenterBannerAdapter", "imageLoaderSupplier load success context.baseContext:" + contextThemeWrapper.getBaseContext());
                        Context baseContext = contextThemeWrapper.getBaseContext();
                        Intrinsics.checkExpressionValueIsNotNull(baseContext, "context.baseContext");
                        e.onLoad(baseContext, imageView, imageParam);
                        return;
                    }
                    RLog.error("PluginCenterBannerAdapter", "imageLoaderSupplier load error context.baseContext null", new Object[0]);
                } else if (mgb.a.a(context)) {
                    RLog.debug("PluginCenterBannerAdapter", "imageLoaderSupplier load success context:" + context);
                    e.onLoad(context, imageView, imageParam);
                } else {
                    RLog.error("PluginCenterBannerAdapter", "imageLoaderSupplier load error context null", new Object[0]);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bhb(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        RLog.debug("PluginCenterBannerAdapter", "constructor");
    }

    @NonNull
    public final a d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            a aVar = new a(this);
            aVar.c((ImageView) view2.findViewById(R.id.top_banner_image));
            ImageView a2 = aVar.a();
            if (a2 == null) {
                Intrinsics.throwNpe();
            }
            a2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view2.setTag(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final ImageLoaderSupplier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ImageLoaderSupplier) invokeV.objValue;
    }

    public final void f(BannerConfigItem.BannerInfo bannerInfo, a aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, bannerInfo, aVar, i) == null) && bannerInfo != null) {
            Context mContext = this.b;
            Intrinsics.checkExpressionValueIsNotNull(mContext, "mContext");
            aVar.b(bannerInfo, i, mContext);
        }
    }

    public final void g(ImageLoaderSupplier imageLoaderSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, imageLoaderSupplier) == null) {
            this.c = imageLoaderSupplier;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            Object obj = null;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.pay_ui_layout_plugincenter_banner_item, (ViewGroup) null);
                if (view2 == null) {
                    Intrinsics.throwNpe();
                }
                view2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                aVar = d(view2);
            } else {
                if (view2 != null) {
                    obj = view2.getTag();
                }
                if (obj != null) {
                    aVar = (a) obj;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type tv.athena.revenue.payui.view.banner.PluginCenterBannerAdapter.ViewHolder");
                }
            }
            BannerConfigItem.BannerInfo item = getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(position)");
            f(item, aVar, i);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
