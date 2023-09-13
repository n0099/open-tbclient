package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tieba.gta;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.tieba.video.record.StickerItem;
import com.baidu.tieba.video.record.VideoPreviewView;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes6.dex */
public class hta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecordVideoActivity a;
    public Bitmap b;
    public j c;
    public Camera d;
    public int e;
    public int f;
    public FrameLayout g;
    public int h;
    public int i;
    public List<String> j;
    public boolean k;
    public int l;
    public int m;
    public Camera.Parameters n;
    public gta o;
    public SurfaceView p;
    public List<String> q;
    public String r;
    public k s;
    public cta t;
    public hc9 u;
    public Handler v;
    public GLVideoPreviewView.b w;
    public GLVideoPreviewView.b x;
    public l y;

    /* loaded from: classes6.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface l {
        void F(int i, int i2);
    }

    /* loaded from: classes6.dex */
    public class d implements GLVideoPreviewView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hta a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ d b;

            public a(d dVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.w.q0(this.a);
                }
            }
        }

        public d(hta htaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = htaVar;
        }

        @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
        public void q0(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.w != null) {
                SafeHandler.getInst().post(new a(this, z));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hta a;

        public a(hta htaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = htaVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && this.a.a != null) {
                            BdUtilHelper.showToast(this.a.a, (int) R.string.obfuscated_res_0x7f0f05a4);
                            if (this.a.u != null) {
                                this.a.u.b(2, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f05a4));
                            }
                            this.a.a.finish();
                            return;
                        }
                        return;
                    } else if (this.a.a != null) {
                        if ("OD103".equals(DeviceInfoHelper.getModel())) {
                            hta htaVar = this.a;
                            htaVar.x(htaVar.a);
                            return;
                        }
                        BdUtilHelper.showToast(this.a.a, (int) R.string.disallow_camera_permission);
                        if (this.a.u != null) {
                            Object obj = message.obj;
                            if (obj instanceof String) {
                                string = (String) obj;
                            } else {
                                string = this.a.a.getResources().getString(R.string.disallow_camera_permission);
                            }
                            this.a.u.b(1, string);
                        }
                        this.a.a.finish();
                        return;
                    } else {
                        return;
                    }
                }
                this.a.K();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public b(hta htaVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public c(hta htaVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                Intent intent = new Intent();
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
                this.a.startActivity(intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hta a;

        public e(hta htaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = htaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hta a;

        public f(hta htaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = htaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hta a;

        public g(hta htaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = htaVar;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
                if (this.a.a != null) {
                    this.a.a.finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(hta htaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gta.a a;
        public final /* synthetic */ hta b;

        public i(hta htaVar, gta.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = htaVar;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.o != null) {
                this.b.o.c(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public Bitmap c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(hta htaVar, Context context, int i, int i2, Bitmap bitmap) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {htaVar, context, Integer.valueOf(i), Integer.valueOf(i2), bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
            this.c = bitmap;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                canvas.drawBitmap(this.c, this.a, this.b, (Paint) null);
                super.onDraw(canvas);
            }
        }
    }

    public hta(RecordVideoActivity recordVideoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recordVideoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = 0;
        this.n = null;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lc9.class);
        lc9 lc9Var = runTask != null ? (lc9) runTask.getData() : null;
        if (lc9Var != null) {
            this.u = lc9Var.get();
        }
        this.v = new a(this);
        this.x = new d(this);
        this.a = recordVideoActivity;
        s();
        this.b = BitmapFactory.decodeResource(recordVideoActivity.getResources(), R.drawable.obfuscated_res_0x7f0803a9);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        recordVideoActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.e = displayMetrics.widthPixels;
        this.f = displayMetrics.heightPixels;
        this.g = this.a.R1();
        if (Build.VERSION.SDK_INT >= 18) {
            GLVideoPreviewView gLVideoPreviewView = new GLVideoPreviewView(recordVideoActivity, this);
            this.p = gLVideoPreviewView;
            this.o = gLVideoPreviewView;
            gLVideoPreviewView.setFaceIdentifyStateListener(this.x);
        } else {
            VideoPreviewView videoPreviewView = new VideoPreviewView(recordVideoActivity, this);
            this.p = videoPreviewView;
            this.o = videoPreviewView;
        }
        if (recordVideoActivity != null && recordVideoActivity.R1() != null) {
            recordVideoActivity.R1().addView(this.p, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void B(ira iraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iraVar) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setBeautyLevel(iraVar);
            }
        }
    }

    public void D(GLVideoPreviewView.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && bVar != null) {
            this.w = bVar;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setFilter(str);
            }
        }
    }

    public void F(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            this.s = kVar;
        }
    }

    public void H(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, stickerItem) == null) {
            SurfaceView surfaceView = this.p;
            if (surfaceView instanceof GLVideoPreviewView) {
                ((GLVideoPreviewView) surfaceView).setSticker(stickerItem);
            }
        }
    }

    public void I(l lVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar) == null) && lVar != null) {
            this.y = lVar;
        }
    }

    public void N(gta.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            gta gtaVar = this.o;
            if (gtaVar instanceof GLSurfaceView) {
                this.v.postDelayed(new i(this, aVar), 500L);
            } else {
                gtaVar.c(aVar);
            }
        }
    }

    public final void A() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.g != null && (jVar = this.c) != null && jVar.getParent() != null) {
            this.g.removeView(this.c);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.a(this.d);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.d(this.d);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o.e(this.d);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.l == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public cta k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.t;
        }
        return (cta) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.m == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Handler n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.v;
        }
        return (Handler) invokeV.objValue;
    }

    public gta q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.o;
        }
        return (gta) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.h = 720;
            this.i = 960;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            z();
            this.o.b(this.d);
            SurfaceView surfaceView = this.p;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                ((GLVideoPreviewView) surfaceView).onPause();
            }
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            try {
                if (!bta.f(z)) {
                    if (!z) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!bta.f(z)) {
                        J();
                        return;
                    }
                }
                int c2 = bta.c(z);
                this.l = c2;
                if (-1 != c2) {
                    t();
                    this.t = new cta(this.d);
                    this.k = z;
                    return;
                }
                J();
            } catch (Exception e2) {
                e2.printStackTrace();
                J();
                hc9 hc9Var = this.u;
                if (hc9Var != null) {
                    hc9Var.b(8, bc9.a(e2));
                }
            }
        }
    }

    public int p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i2 == 0) {
                return BdUtilHelper.getEquipmentHeight(context);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public void x(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, activity) == null) {
            y45 y45Var = new y45(activity);
            y45Var.setCanceledOnTouchOutside(false);
            y45Var.setTitle(R.string.request_permission_default_title);
            y45Var.setMessageId(R.string.request_permission_camera);
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b37, new c(this, activity)).setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this, activity)).create(m9.a(activity));
            y45Var.show();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = Integer.MAX_VALUE;
            int[] iArr = null;
            int i3 = Integer.MAX_VALUE;
            for (int[] iArr2 : this.n.getSupportedPreviewFpsRange()) {
                if (Math.abs(20000 - iArr2[1]) <= i2 && Math.abs(15000 - iArr2[0]) <= i3) {
                    i2 = Math.abs(20000 - iArr2[1]);
                    i3 = Math.abs(15000 - iArr2[0]);
                    iArr = iArr2;
                }
            }
            this.n.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    public final void J() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (recordVideoActivity = this.a) == null) {
            return;
        }
        y45 y45Var = new y45(recordVideoActivity.getPageContext().getPageActivity());
        y45Var.setMessageId(R.string.obfuscated_res_0x7f0f1833);
        y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f059b, new g(this));
        y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0590, new h(this));
        y45Var.setCancelable(true);
        y45Var.create(this.a.getPageContext());
        y45Var.show();
    }

    public void f() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SurfaceView surfaceView = this.p;
            boolean z = false;
            boolean z2 = true;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                GLVideoPreviewView gLVideoPreviewView = (GLVideoPreviewView) surfaceView;
                gLVideoPreviewView.setIsChangingCamera(true);
                z();
                gLVideoPreviewView.A();
                if (this.m == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                this.m = i3;
                if (i3 != 1) {
                    z2 = false;
                }
                C(z2);
                gLVideoPreviewView.B();
                gLVideoPreviewView.setIsChangingCamera(false);
                return;
            }
            SurfaceView surfaceView2 = this.p;
            if (surfaceView2 != null && (surfaceView2 instanceof VideoPreviewView)) {
                ((VideoPreviewView) surfaceView2).b(this.d);
                z();
                if (this.m == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.m = i2;
                if (i2 == 1) {
                    z = true;
                }
                C(z);
                K();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.d == null) {
                    return;
                }
                if (this.n == null) {
                    this.n = this.d.getParameters();
                }
                if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode())) {
                    this.n.setFlashMode("torch");
                } else {
                    this.n.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
                this.d.setParameters(this.n);
            } catch (Exception e2) {
                e2.printStackTrace();
                hc9 hc9Var = this.u;
                if (hc9Var != null) {
                    hc9Var.b(7, bc9.a(e2));
                }
            }
        }
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.q == null) {
                this.q = new ArrayList();
            }
            File file = new File(kra.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = kra.f + "rec_tmp_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.q.add(str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    public final void O(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            try {
                this.d.cancelAutoFocus();
                if (this.j.contains("auto")) {
                    Camera.Parameters parameters = this.d.getParameters();
                    this.n = parameters;
                    parameters.setFocusMode("auto");
                }
                this.d.setParameters(this.n);
                this.d.autoFocus(null);
            } catch (Exception e2) {
                e2.printStackTrace();
                hc9 hc9Var = this.u;
                if (hc9Var != null) {
                    hc9Var.b(9, bc9.a(e2));
                }
            }
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            File file = new File(kra.f);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = kra.f + "f_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.r = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        List<String> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (list = this.q) != null && list.size() != 0) {
            List<String> list2 = this.q;
            String remove = list2.remove(list2.size() - 1);
            if (!TextUtils.isEmpty(remove)) {
                File file = new File(remove);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                if (this.d == null) {
                    return false;
                }
                if (this.n == null) {
                    this.n = this.d.getParameters();
                }
                return !DebugKt.DEBUG_PROPERTY_VALUE_OFF.equals(this.n.getFlashMode());
            } catch (Exception e2) {
                e2.printStackTrace();
                hc9 hc9Var = this.u;
                if (hc9Var != null) {
                    hc9Var.b(7, bc9.a(e2));
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            try {
                Camera open = Camera.open(this.l);
                this.d = open;
                this.n = open.getParameters();
                y();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
                Message obtainMessage = this.v.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.obj = bc9.a(e2);
                this.v.sendMessageDelayed(obtainMessage, 1000L);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            boolean z = true;
            if (this.m != 1) {
                z = false;
            }
            C(z);
            SurfaceView surfaceView = this.p;
            if (surfaceView != null && (surfaceView instanceof GLVideoPreviewView)) {
                ((GLVideoPreviewView) surfaceView).onResume();
            }
            SurfaceView surfaceView2 = this.p;
            if (surfaceView2 != null && (surfaceView2 instanceof VideoPreviewView)) {
                ((VideoPreviewView) surfaceView2).m();
            }
        }
    }

    public final void z() {
        Camera camera;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (camera = this.d) != null) {
            try {
                camera.stopPreview();
                this.d.setPreviewCallback(null);
                this.d.setPreviewTexture(null);
                this.d.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                hc9 hc9Var = this.u;
                if (hc9Var != null) {
                    hc9Var.b(6, bc9.a(e2));
                }
            }
            this.d = null;
        }
    }

    public boolean r(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, motionEvent, viewParent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.v.postDelayed(new f(this), 800L);
                }
            } else {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (y > this.f || x < BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070253)) {
                    return true;
                }
                int width = this.b.getWidth();
                int height = this.b.getHeight();
                int i2 = width / 2;
                int a2 = bta.a(x, i2, this.e - i2);
                int i3 = height / 2;
                int a3 = bta.a(y, i3, this.f - i3);
                if (viewParent != null && (viewParent instanceof FrameLayout)) {
                    if (this.g == null) {
                        this.g = (FrameLayout) viewParent;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= this.g.getChildCount()) {
                            break;
                        } else if (this.c == this.g.getChildAt(i4)) {
                            this.g.removeViewAt(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    j jVar = new j(this, this.a, a2 - i2, a3 - i3, this.b);
                    this.c = jVar;
                    this.g.addView(jVar, new ViewGroup.LayoutParams(-2, -2));
                    O(a2, a3);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean w(MotionEvent motionEvent, ViewParent viewParent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, motionEvent, viewParent)) == null) {
            if (this.s != null && motionEvent.getAction() == 0) {
                this.s.a();
            }
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount == 1) {
                return r(motionEvent, viewParent);
            }
            if (pointerCount >= 2) {
                this.v.postDelayed(new e(this), 100L);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void y() {
        RecordVideoActivity recordVideoActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.d == null && (recordVideoActivity = this.a) != null) {
                recordVideoActivity.finish();
                return;
            }
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity());
            int p = p(this.a.getPageContext().getPageActivity());
            if (DeviceInfoUtil.isHuaWeiP40()) {
                p = this.f;
            }
            float f2 = p;
            float f3 = equipmentWidth;
            Camera.Size d2 = bta.d(this.d, 720, (int) (720 * ((f2 * 1.0f) / f3)));
            if (d2 != null) {
                int i2 = d2.width;
                this.h = i2;
                int i3 = d2.height;
                this.i = i3;
                this.n.setPreviewSize(i2, i3);
                gta gtaVar = this.o;
                if (gtaVar != null) {
                    gtaVar.setPreviewSize(this.h, this.i);
                }
            }
            this.n.setPreviewFormat(17);
            G();
            this.d.setDisplayOrientation(bta.b(this.a, this.l));
            List<String> supportedFocusModes = this.n.getSupportedFocusModes();
            this.j = supportedFocusModes;
            if (supportedFocusModes != null) {
                if ((DeviceInfoHelper.getModel().startsWith("GT-I950") || DeviceInfoHelper.getModel().endsWith("SCH-I959") || DeviceInfoHelper.getModel().endsWith("MEIZU MX3")) && this.j.contains("continuous-picture")) {
                    this.n.setFocusMode("continuous-picture");
                } else if (this.j.contains("continuous-video")) {
                    this.n.setFocusMode("continuous-video");
                }
            }
            this.d.setParameters(this.n);
            RecordVideoActivity recordVideoActivity2 = this.a;
            if (recordVideoActivity2 != null && recordVideoActivity2.R1() != null) {
                float f4 = (this.i * 1.0f) / this.h;
                if ((f3 * 1.0f) / f2 > f4) {
                    p = (int) (f3 / f4);
                } else {
                    equipmentWidth = (int) (f2 * f4);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = p;
                this.p.setLayoutParams(layoutParams);
                this.p.invalidate();
                l lVar = this.y;
                if (lVar != null) {
                    lVar.F(layoutParams.width, layoutParams.height);
                }
            }
        }
    }
}
