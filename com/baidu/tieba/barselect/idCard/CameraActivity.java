package com.baidu.tieba.barselect.idCard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.CameraView;
import com.baidu.tieba.c55;
import com.baidu.tieba.rh6;
import com.baidu.tieba.th6;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class CameraActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public String b;
    public Handler c;
    public OCRCameraLayout d;
    public OCRCameraLayout e;
    public OCRCameraLayout f;
    public ImageView g;
    public CameraView h;
    public ImageView i;
    public CropView j;
    public FrameOverlayView k;
    public MaskView l;
    public ImageView m;
    public th6 n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public CameraView.c r;
    public CameraView.c s;
    public View.OnClickListener t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class j implements CameraView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ j b;

            public a(j jVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.b.a.a);
                        this.a.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        this.a.recycle();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.putExtra(CameraActivityConfig.KEY_CONTENT_TYPE, this.b.a.b);
                    this.b.a.setResult(-1, intent);
                    this.b.a.finish();
                }
            }
        }

        public j(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // com.baidu.tieba.barselect.idCard.CameraView.c
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                rh6.c(new a(this, bitmap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements CameraView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ k b;

            public a(k kVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = kVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.d.setVisibility(4);
                    if (this.b.a.l.getMaskType() == 0) {
                        this.b.a.j.setFilePath(this.b.a.a.getAbsolutePath());
                        this.b.a.W1();
                        return;
                    }
                    this.b.a.i.setImageBitmap(this.a);
                    this.b.a.X1();
                }
            }
        }

        public k(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // com.baidu.tieba.barselect.idCard.CameraView.c
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                this.a.c.post(new a(this, bitmap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public a(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.R1();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public b(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i.setImageBitmap(null);
                this.a.Y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public c(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.g(90);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ CameraActivity b;

        public d(CameraActivity cameraActivity, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cameraActivity;
            this.a = activity;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ CameraActivity b;

        public e(CameraActivity cameraActivity, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cameraActivity;
            this.a = activity;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
                Intent intent = new Intent();
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
                this.a.startActivity(intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements th6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public f(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // com.baidu.tieba.th6
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ActivityCompat.requestPermissions(this.a, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public g(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ContextCompat.checkSelfPermission(this.a.getApplicationContext(), com.kuaishou.weapon.p0.h.i) != 0 && Build.VERSION.SDK_INT >= 16) {
                    ActivityCompat.requestPermissions(this.a, new String[]{com.kuaishou.weapon.p0.h.i}, 801);
                    return;
                }
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                this.a.startActivityForResult(intent, 100);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public h(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.h.getCameraControl().d() == 0) {
                    this.a.h.getCameraControl().h(1);
                } else {
                    this.a.h.getCameraControl().h(0);
                }
                this.a.Z1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public i(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.g(this.a.a, this.a.s);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public l(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.setFilePath(null);
                this.a.Y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public m(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Rect frameRect;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int maskType = this.a.l.getMaskType();
                if (maskType != 1 && maskType != 2) {
                    frameRect = this.a.k.getFrameRect();
                } else {
                    frameRect = this.a.l.getFrameRect();
                }
                this.a.i.setImageBitmap(this.a.j.e(frameRect));
                this.a.P1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraActivity a;

        public n(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cameraActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.a.a);
                    ((BitmapDrawable) this.a.i.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.putExtra(CameraActivityConfig.KEY_CONTENT_TYPE, this.a.b);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    public CameraActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new Handler();
        this.n = new f(this);
        this.o = new g(this);
        this.p = new h(this);
        this.q = new i(this);
        this.r = new j(this);
        this.s = new k(this);
        this.t = new l(this);
        this.u = new m(this);
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            V1(configuration);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.getCameraControl().pause();
            Z1();
            R1();
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            rh6.a();
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rh6.c(new n(this));
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h.getCameraControl().pause();
            Z1();
            this.d.setVisibility(4);
            this.f.setVisibility(4);
            this.e.setVisibility(0);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h.getCameraControl().pause();
            Z1();
            this.d.setVisibility(4);
            this.f.setVisibility(0);
            this.e.setVisibility(4);
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.getCameraControl().resume();
            Z1();
            this.d.setVisibility(0);
            this.f.setVisibility(4);
            this.e.setVisibility(4);
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.h.getCameraControl().d() == 1) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080249);
            } else {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080248);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            Q1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            this.h.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            this.h.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStart();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onStop();
        }
    }

    public final String S1(Uri uri) {
        Cursor cursor;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            try {
                cursor = getContentResolver().query(uri, null, null, null, null);
            } catch (Throwable th) {
                th.printStackTrace();
                cursor = null;
            }
            if (cursor == null) {
                return uri.getPath();
            }
            cursor.moveToFirst();
            String string = cursor.getString(cursor.getColumnIndex("_data"));
            cursor.close();
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
            if (stringExtra != null) {
                File file = new File(stringExtra);
                this.a = file;
                if (!file.exists()) {
                    try {
                        this.a.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            String stringExtra2 = getIntent().getStringExtra(CameraActivityConfig.KEY_CONTENT_TYPE);
            this.b = stringExtra2;
            if (stringExtra2 == null) {
                this.b = CameraActivityConfig.CONTENT_TYPE_GENERAL;
            }
            String str = this.b;
            char c2 = 65535;
            int hashCode = str.hashCode();
            int i2 = 0;
            if (hashCode != -1070661090) {
                if (hashCode != -80148248) {
                    if (hashCode == 242421330 && str.equals(CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK)) {
                        c2 = 1;
                    }
                } else if (str.equals(CameraActivityConfig.CONTENT_TYPE_GENERAL)) {
                    c2 = 2;
                }
            } else if (str.equals(CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT)) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    this.l.setVisibility(4);
                } else {
                    this.k.setVisibility(4);
                    i2 = 2;
                }
            } else {
                this.k.setVisibility(4);
                i2 = 1;
            }
            this.h.setMaskType(i2, this);
            this.l.setMaskType(i2);
        }
    }

    public void U1(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            c55 c55Var = new c55(activity);
            c55Var.setCanceledOnTouchOutside(false);
            c55Var.setTitle(R.string.request_permission_default_title);
            c55Var.setMessageId(R.string.request_permission_camera);
            c55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0b08, new e(this, activity)).setNegativeButton(R.string.obfuscated_res_0x7f0f03c9, new d(this, activity)).create(getPageContext());
            c55Var.show();
        }
    }

    public final void V1(Configuration configuration) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int i3 = configuration.orientation;
            int i4 = 0;
            if (i3 != 1) {
                if (i3 != 2) {
                    i2 = OCRCameraLayout.l;
                    this.h.setOrientation(0);
                } else {
                    i2 = OCRCameraLayout.m;
                    i4 = (rotation == 0 || rotation == 1) ? 90 : 270;
                }
            } else {
                i2 = OCRCameraLayout.l;
            }
            this.d.setOrientation(i2);
            this.h.setOrientation(i4);
            this.e.setOrientation(i2);
            this.f.setOrientation(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 100) {
                if (i3 == -1) {
                    this.j.setFilePath(S1(intent.getData()));
                    W1();
                    return;
                }
                this.h.getCameraControl().resume();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0157);
            this.d = (OCRCameraLayout) findViewById(R.id.obfuscated_res_0x7f092360);
            this.f = (OCRCameraLayout) findViewById(R.id.obfuscated_res_0x7f090795);
            CameraView cameraView = (CameraView) findViewById(R.id.obfuscated_res_0x7f09052b);
            this.h = cameraView;
            cameraView.getCameraControl().i(this.n);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914cb);
            this.g = imageView;
            imageView.setOnClickListener(this.p);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f09235f);
            findViewById(R.id.obfuscated_res_0x7f090249).setOnClickListener(this.o);
            this.m.setOnClickListener(this.q);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f0908cd);
            this.f.findViewById(R.id.obfuscated_res_0x7f090790).setOnClickListener(this.v);
            this.f.findViewById(R.id.obfuscated_res_0x7f09052e).setOnClickListener(this.w);
            findViewById(R.id.obfuscated_res_0x7f091ed4).setOnClickListener(this.x);
            this.j = (CropView) findViewById(R.id.obfuscated_res_0x7f09080e);
            this.e = (OCRCameraLayout) findViewById(R.id.obfuscated_res_0x7f09080c);
            this.k = (FrameOverlayView) findViewById(R.id.obfuscated_res_0x7f09198e);
            this.e.findViewById(R.id.obfuscated_res_0x7f090790).setOnClickListener(this.u);
            this.l = (MaskView) this.e.findViewById(R.id.obfuscated_res_0x7f09080d);
            this.e.findViewById(R.id.obfuscated_res_0x7f09052e).setOnClickListener(this.t);
            V1(getResources().getConfiguration());
            T1();
            this.h.setAutoPictureCallback(this.r);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 != 800) {
                if (i2 == 801 && (iArr.length <= 0 || iArr[0] != 0)) {
                    vi.P(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f142c);
                }
            } else if (iArr.length > 0 && iArr[0] == 0) {
                this.h.getCameraControl().g();
            } else {
                U1(this);
            }
            CameraView cameraView = this.h;
            if (cameraView != null && cameraView.getCameraControl() != null) {
                this.h.getCameraControl().e();
            }
        }
    }
}
