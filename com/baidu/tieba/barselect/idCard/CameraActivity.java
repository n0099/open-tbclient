package com.baidu.tieba.barselect.idCard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.CameraView;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.p0.s.s.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class CameraActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE_GENERAL = "general";
    public static final String CONTENT_TYPE_ID_CARD_BACK = "IDCardBack";
    public static final String CONTENT_TYPE_ID_CARD_FRONT = "IDCardFront";
    public static final String KEY_CONTENT_TYPE = "contentType";
    public static final String KEY_OUTPUT_FILE_PATH = "outputFilePath";
    public static final int PERMISSIONS_EXTERNAL_STORAGE = 801;
    public static final int PERMISSIONS_REQUEST_CAMERA = 800;
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener albumButtonOnClickListener;
    public CameraView.c autoTakePictureCallback;
    public CameraView cameraView;
    public View.OnClickListener confirmButtonOnClickListener;
    public View.OnClickListener confirmCancelButtonOnClickListener;
    public OCRCameraLayout confirmResultContainer;
    public String contentType;
    public View.OnClickListener cropCancelButtonListener;
    public View.OnClickListener cropConfirmButtonListener;
    public OCRCameraLayout cropContainer;
    public MaskView cropMaskView;
    public CropView cropView;
    public ImageView displayImageView;
    public Handler handler;
    public ImageView lightButton;
    public View.OnClickListener lightButtonOnClickListener;
    public File outputFile;
    public FrameOverlayView overlayView;
    public d.a.q0.x.c.e permissionCallback;
    public View.OnClickListener rotateButtonOnClickListener;
    public View.OnClickListener takeButtonOnClickListener;
    public ImageView takePhotoBtn;
    public CameraView.c takePictureCallback;
    public OCRCameraLayout takePictureContainer;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14428e;

        public a(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14428e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14428e.doConfirmResult();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14429e;

        public b(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14429e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14429e.displayImageView.setImageBitmap(null);
                this.f14429e.showTakePicture();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14430e;

        public c(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14430e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14430e.cropView.g(90);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f14431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14432f;

        public d(CameraActivity cameraActivity, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14432f = cameraActivity;
            this.f14431e = activity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f14431e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f14433e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14434f;

        public e(CameraActivity cameraActivity, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14434f = cameraActivity;
            this.f14433e = activity;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, this.f14433e.getPackageName(), null));
                this.f14433e.startActivity(intent);
                this.f14433e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.q0.x.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14435a;

        public f(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14435a = cameraActivity;
        }

        @Override // d.a.q0.x.c.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ActivityCompat.requestPermissions(this.f14435a, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14436e;

        public g(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14436e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (ContextCompat.checkSelfPermission(this.f14436e.getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0 && Build.VERSION.SDK_INT >= 16) {
                    ActivityCompat.requestPermissions(this.f14436e, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 801);
                    return;
                }
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                this.f14436e.startActivityForResult(intent, 100);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14437e;

        public h(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14437e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14437e.cameraView.getCameraControl().d() == 0) {
                    this.f14437e.cameraView.getCameraControl().h(1);
                } else {
                    this.f14437e.cameraView.getCameraControl().h(0);
                }
                this.f14437e.updateFlashMode();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14438e;

        public i(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14438e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14438e.cameraView.g(this.f14438e.outputFile, this.f14438e.takePictureCallback);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CameraView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14439a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f14440e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f14441f;

            public a(j jVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14441f = jVar;
                this.f14440e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f14441f.f14439a.outputFile);
                        this.f14440e.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        this.f14440e.recycle();
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("contentType", this.f14441f.f14439a.contentType);
                    this.f14441f.f14439a.setResult(-1, intent);
                    this.f14441f.f14439a.finish();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14439a = cameraActivity;
        }

        @Override // com.baidu.tieba.barselect.idCard.CameraView.c
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                d.a.q0.x.c.c.c(new a(this, bitmap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements CameraView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14442a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f14443e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ k f14444f;

            public a(k kVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14444f = kVar;
                this.f14443e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f14444f.f14442a.takePictureContainer.setVisibility(4);
                    if (this.f14444f.f14442a.cropMaskView.getMaskType() == 0) {
                        this.f14444f.f14442a.cropView.setFilePath(this.f14444f.f14442a.outputFile.getAbsolutePath());
                        this.f14444f.f14442a.showCrop();
                        return;
                    }
                    this.f14444f.f14442a.displayImageView.setImageBitmap(this.f14443e);
                    this.f14444f.f14442a.showResultConfirm();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14442a = cameraActivity;
        }

        @Override // com.baidu.tieba.barselect.idCard.CameraView.c
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                this.f14442a.handler.post(new a(this, bitmap));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14445e;

        public l(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14445e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14445e.cropView.setFilePath(null);
                this.f14445e.showTakePicture();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14446e;

        public m(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14446e = cameraActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int maskType = this.f14446e.cropMaskView.getMaskType();
                this.f14446e.displayImageView.setImageBitmap(this.f14446e.cropView.e((maskType == 1 || maskType == 2) ? this.f14446e.cropMaskView.getFrameRect() : this.f14446e.overlayView.getFrameRect()));
                this.f14446e.cropAndConfirm();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CameraActivity f14447e;

        public n(CameraActivity cameraActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cameraActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14447e = cameraActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f14447e.outputFile);
                    ((BitmapDrawable) this.f14447e.displayImageView.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Intent intent = new Intent();
                intent.putExtra("contentType", this.f14447e.contentType);
                this.f14447e.setResult(-1, intent);
                this.f14447e.finish();
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
        this.handler = new Handler();
        this.permissionCallback = new f(this);
        this.albumButtonOnClickListener = new g(this);
        this.lightButtonOnClickListener = new h(this);
        this.takeButtonOnClickListener = new i(this);
        this.autoTakePictureCallback = new j(this);
        this.takePictureCallback = new k(this);
        this.cropCancelButtonListener = new l(this);
        this.cropConfirmButtonListener = new m(this);
        this.confirmButtonOnClickListener = new a(this);
        this.confirmCancelButtonOnClickListener = new b(this);
        this.rotateButtonOnClickListener = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cropAndConfirm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.cameraView.getCameraControl().pause();
            updateFlashMode();
            doConfirmResult();
        }
    }

    private void doClear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            d.a.q0.x.c.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doConfirmResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            d.a.q0.x.c.c.c(new n(this));
        }
    }

    private String getRealPathFromURI(Uri uri) {
        Cursor cursor;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, uri)) == null) {
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

    private void initParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            String stringExtra = getIntent().getStringExtra("outputFilePath");
            if (stringExtra != null) {
                File file = new File(stringExtra);
                this.outputFile = file;
                if (!file.exists()) {
                    try {
                        this.outputFile.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            String stringExtra2 = getIntent().getStringExtra("contentType");
            this.contentType = stringExtra2;
            if (stringExtra2 == null) {
                this.contentType = "general";
            }
            String str = this.contentType;
            char c2 = 65535;
            int hashCode = str.hashCode();
            int i2 = 0;
            if (hashCode != -1070661090) {
                if (hashCode != -80148248) {
                    if (hashCode == 242421330 && str.equals("IDCardBack")) {
                        c2 = 1;
                    }
                } else if (str.equals("general")) {
                    c2 = 2;
                }
            } else if (str.equals("IDCardFront")) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.overlayView.setVisibility(4);
                i2 = 1;
            } else if (c2 != 1) {
                this.cropMaskView.setVisibility(4);
            } else {
                this.overlayView.setVisibility(4);
                i2 = 2;
            }
            this.cameraView.setMaskType(i2, this);
            this.cropMaskView.setMaskType(i2);
        }
    }

    private void setOrientation(Configuration configuration) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, configuration) == null) {
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            int i3 = configuration.orientation;
            int i4 = 0;
            if (i3 == 1) {
                i2 = OCRCameraLayout.p;
            } else if (i3 != 2) {
                i2 = OCRCameraLayout.p;
                this.cameraView.setOrientation(0);
            } else {
                i2 = OCRCameraLayout.q;
                i4 = (rotation == 0 || rotation == 1) ? 90 : 270;
            }
            this.takePictureContainer.setOrientation(i2);
            this.cameraView.setOrientation(i4);
            this.cropContainer.setOrientation(i2);
            this.confirmResultContainer.setOrientation(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCrop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.cameraView.getCameraControl().pause();
            updateFlashMode();
            this.takePictureContainer.setVisibility(4);
            this.confirmResultContainer.setVisibility(4);
            this.cropContainer.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResultConfirm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.cameraView.getCameraControl().pause();
            updateFlashMode();
            this.takePictureContainer.setVisibility(4);
            this.confirmResultContainer.setVisibility(0);
            this.cropContainer.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTakePicture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.cameraView.getCameraControl().resume();
            updateFlashMode();
            this.takePictureContainer.setVisibility(0);
            this.confirmResultContainer.setVisibility(4);
            this.cropContainer.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFlashMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (this.cameraView.getCameraControl().d() == 1) {
                this.lightButton.setImageResource(R.drawable.bd_ocr_light_on);
            } else {
                this.lightButton.setImageResource(R.drawable.bd_ocr_light_off);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 100) {
                if (i3 == -1) {
                    this.cropView.setFilePath(getRealPathFromURI(intent.getData()));
                    showCrop();
                    return;
                }
                this.cameraView.getCameraControl().resume();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            setOrientation(configuration);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.bd_ocr_activity_camera);
            this.takePictureContainer = (OCRCameraLayout) findViewById(R.id.take_picture_container);
            this.confirmResultContainer = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
            CameraView cameraView = (CameraView) findViewById(R.id.camera_view);
            this.cameraView = cameraView;
            cameraView.getCameraControl().i(this.permissionCallback);
            ImageView imageView = (ImageView) findViewById(R.id.light_button);
            this.lightButton = imageView;
            imageView.setOnClickListener(this.lightButtonOnClickListener);
            this.takePhotoBtn = (ImageView) findViewById(R.id.take_photo_button);
            findViewById(R.id.album_button).setOnClickListener(this.albumButtonOnClickListener);
            this.takePhotoBtn.setOnClickListener(this.takeButtonOnClickListener);
            this.displayImageView = (ImageView) findViewById(R.id.display_image_view);
            this.confirmResultContainer.findViewById(R.id.confirm_button).setOnClickListener(this.confirmButtonOnClickListener);
            this.confirmResultContainer.findViewById(R.id.cancel_button).setOnClickListener(this.confirmCancelButtonOnClickListener);
            findViewById(R.id.rotate_button).setOnClickListener(this.rotateButtonOnClickListener);
            this.cropView = (CropView) findViewById(R.id.crop_view);
            this.cropContainer = (OCRCameraLayout) findViewById(R.id.crop_container);
            this.overlayView = (FrameOverlayView) findViewById(R.id.overlay_view);
            this.cropContainer.findViewById(R.id.confirm_button).setOnClickListener(this.cropConfirmButtonListener);
            this.cropMaskView = (MaskView) this.cropContainer.findViewById(R.id.crop_mask_view);
            this.cropContainer.findViewById(R.id.cancel_button).setOnClickListener(this.cropCancelButtonListener);
            setOrientation(getResources().getConfiguration());
            initParams();
            this.cameraView.setAutoPictureCallback(this.autoTakePictureCallback);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            doClear();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
            this.cameraView.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 != 800) {
                if (i2 == 801 && (iArr.length <= 0 || iArr[0] != 0)) {
                    d.a.d.e.p.l.L(TbadkCoreApplication.getInst(), R.string.storage_permission_required);
                }
            } else if (iArr.length > 0 && iArr[0] == 0) {
                this.cameraView.getCameraControl().g();
            } else {
                popPermissionDialog(this);
            }
            CameraView cameraView = this.cameraView;
            if (cameraView == null || cameraView.getCameraControl() == null) {
                return;
            }
            this.cameraView.getCameraControl().e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.cameraView.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
        }
    }

    public void popPermissionDialog(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(activity);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setTitle(R.string.request_permission_default_title);
            aVar.setMessageId(R.string.request_permission_camera);
            aVar.setPositiveButton(R.string.isopen, new e(this, activity)).setNegativeButton(R.string.cancel, new d(this, activity)).create(getPageContext());
            aVar.show();
        }
    }
}
