package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class bt1 implements fv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public ArrayList<MediaModel> b;
        public boolean c;
        public String d;
        public uy2 e;
        public HandlerC0254b f;
        public a g;

        /* loaded from: classes5.dex */
        public class a extends gw2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public HandlerC0254b a;
            public final /* synthetic */ b b;

            public a(b bVar, HandlerC0254b handlerC0254b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, handlerC0254b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = handlerC0254b;
            }

            @Override // com.baidu.tieba.gw2, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
                    if ((activity instanceof SwanAppActivity) || (activity instanceof SwanAppAlbumActivity) || (activity instanceof SwanAppAlbumPreviewActivity)) {
                        if (this.a.b != null && this.a.b.isShowing()) {
                            this.a.b.cancel();
                            this.a.b = null;
                        }
                        HandlerC0254b handlerC0254b = this.a;
                        if (handlerC0254b != null) {
                            handlerC0254b.removeMessages(1);
                            this.a.removeMessages(2);
                            this.a = null;
                        }
                        this.b.f();
                    }
                }
            }
        }

        /* renamed from: com.baidu.tieba.bt1$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class HandlerC0254b extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public WeakReference<Context> a;
            public Dialog b;

            public HandlerC0254b(Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = new WeakReference<>(context);
            }

            public /* synthetic */ HandlerC0254b(Context context, a aVar) {
                this(context);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i;
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2 && (dialog = this.b) != null && dialog.isShowing()) {
                            Context context = this.a.get();
                            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                                this.b.cancel();
                            }
                            this.b = null;
                            return;
                        }
                        return;
                    }
                    Context context2 = this.a.get();
                    if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                        Dialog dialog2 = new Dialog(this.a.get(), R.style.obfuscated_res_0x7f1001b5);
                        this.b = dialog2;
                        dialog2.setContentView(R.layout.obfuscated_res_0x7f0d092b);
                        boolean a = fu2.M().a();
                        View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f091477);
                        if (a) {
                            i = 0;
                        } else {
                            i = 8;
                        }
                        findViewById.setVisibility(i);
                        this.b.setCancelable(false);
                        this.b.show();
                    }
                }
            }
        }

        public b(Context context, Bundle bundle, uy2 uy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bundle, uy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = bundle.getParcelableArrayList("mediaModels");
            xn3.g(bundle, "swanAppId");
            this.c = xn3.c(bundle, "compressed", false);
            this.d = xn3.g(bundle, "swanTmpPath");
            this.e = uy2Var;
            this.f = new HandlerC0254b(context, null);
        }

        public final void b(MediaModel mediaModel, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, mediaModel, i) != null) || mediaModel == null) {
                return;
            }
            if (ny2.a) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File l = wn3.l(this.d, file.getName());
            if (l == null) {
                return;
            }
            mediaModel.setTempPath(l.getAbsolutePath());
            wn3.n(file, l, i);
            mediaModel.setSize(l.length());
        }

        public final void c(VideoModel videoModel) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoModel) != null) || videoModel == null) {
                return;
            }
            if (ny2.a) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File l = wn3.l(this.d, new File(videoModel.getPath()).getName());
            if (l == null) {
                return;
            }
            cr4.f(new File(videoModel.getPath()), l);
            videoModel.setTempPath(l.getPath());
            videoModel.setSize(l.length());
        }

        public final void d(MediaModel mediaModel) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaModel) != null) || mediaModel == null) {
                return;
            }
            File file = new File(mediaModel.getPath());
            File l = wn3.l(this.d, file.getName());
            if (l != null && l.exists() && cr4.f(file, l) != 0) {
                mediaModel.setTempPath(l.getPath());
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.g = new a(this, this.f);
                fu2.c().registerActivityLifecycleCallbacks(this.g);
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.g != null) {
                fu2.c().unregisterActivityLifecycleCallbacks(this.g);
                this.g = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                HandlerC0254b handlerC0254b = this.f;
                if (handlerC0254b != null) {
                    handlerC0254b.sendEmptyMessage(1);
                }
                if (this.c) {
                    Iterator<MediaModel> it = this.b.iterator();
                    while (it.hasNext()) {
                        MediaModel next = it.next();
                        if (next != null) {
                            if (next instanceof ImageModel) {
                                if (TextUtils.equals(cr4.t(next.getPath()), NativeConstants.TYPE_GIF)) {
                                    d(next);
                                } else {
                                    b(next, 20);
                                }
                            } else if (next instanceof VideoModel) {
                                c((VideoModel) next);
                            }
                        }
                    }
                } else {
                    Iterator<MediaModel> it2 = this.b.iterator();
                    while (it2.hasNext()) {
                        MediaModel next2 = it2.next();
                        if (next2 != null) {
                            if (next2 instanceof ImageModel) {
                                b(next2, 100);
                            } else {
                                d(next2);
                            }
                        }
                    }
                }
                HandlerC0254b handlerC0254b2 = this.f;
                if (handlerC0254b2 != null) {
                    handlerC0254b2.sendEmptyMessage(2);
                }
                uy2 uy2Var = this.e;
                if (uy2Var != null) {
                    uy2Var.a(true, null, this.b);
                }
                f();
            }
        }
    }

    public bt1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.fv1
    public void a(Activity activity, Bundle bundle, uy2 uy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, uy2Var) == null) {
            sn3.k(new b(activity, bundle, uy2Var), "main process compress files");
        }
    }
}
