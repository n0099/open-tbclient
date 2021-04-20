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
import com.alibaba.fastjson.asm.Label;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.CameraView;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.h0.r.s.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class CameraActivity extends BaseActivity {
    public static final String CONTENT_TYPE_GENERAL = "general";
    public static final String CONTENT_TYPE_ID_CARD_BACK = "IDCardBack";
    public static final String CONTENT_TYPE_ID_CARD_FRONT = "IDCardFront";
    public static final String KEY_CONTENT_TYPE = "contentType";
    public static final String KEY_OUTPUT_FILE_PATH = "outputFilePath";
    public static final int PERMISSIONS_EXTERNAL_STORAGE = 801;
    public static final int PERMISSIONS_REQUEST_CAMERA = 800;
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    public CameraView cameraView;
    public OCRCameraLayout confirmResultContainer;
    public String contentType;
    public OCRCameraLayout cropContainer;
    public MaskView cropMaskView;
    public CropView cropView;
    public ImageView displayImageView;
    public ImageView lightButton;
    public File outputFile;
    public FrameOverlayView overlayView;
    public ImageView takePhotoBtn;
    public OCRCameraLayout takePictureContainer;
    public Handler handler = new Handler();
    public d.b.i0.v.c.e permissionCallback = new f();
    public View.OnClickListener albumButtonOnClickListener = new g();
    public View.OnClickListener lightButtonOnClickListener = new h();
    public View.OnClickListener takeButtonOnClickListener = new i();
    public CameraView.c autoTakePictureCallback = new j();
    public CameraView.c takePictureCallback = new k();
    public View.OnClickListener cropCancelButtonListener = new l();
    public View.OnClickListener cropConfirmButtonListener = new m();
    public View.OnClickListener confirmButtonOnClickListener = new a();
    public View.OnClickListener confirmCancelButtonOnClickListener = new b();
    public View.OnClickListener rotateButtonOnClickListener = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.doConfirmResult();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.displayImageView.setImageBitmap(null);
            CameraActivity.this.showTakePicture();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cropView.g(90);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f14804e;

        public d(Activity activity) {
            this.f14804e = activity;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            this.f14804e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f14806e;

        public e(Activity activity) {
            this.f14806e = activity;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f14806e.getPackageName(), null));
            this.f14806e.startActivity(intent);
            this.f14806e.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.i0.v.c.e {
        public f() {
        }

        @Override // d.b.i0.v.c.e
        public boolean a() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(CameraActivity.this.getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0 && Build.VERSION.SDK_INT >= 16) {
                ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 801);
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            CameraActivity.this.startActivityForResult(intent, 100);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.cameraView.getCameraControl().g() == 0) {
                CameraActivity.this.cameraView.getCameraControl().b(1);
            } else {
                CameraActivity.this.cameraView.getCameraControl().b(0);
            }
            CameraActivity.this.updateFlashMode();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cameraView.g(CameraActivity.this.outputFile, CameraActivity.this.takePictureCallback);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CameraView.c {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f14813e;

            public a(Bitmap bitmap) {
                this.f14813e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.outputFile);
                    this.f14813e.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    this.f14813e.recycle();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Intent intent = new Intent();
                intent.putExtra("contentType", CameraActivity.this.contentType);
                CameraActivity.this.setResult(-1, intent);
                CameraActivity.this.finish();
            }
        }

        public j() {
        }

        @Override // com.baidu.tieba.barselect.idCard.CameraView.c
        public void a(Bitmap bitmap) {
            d.b.i0.v.c.c.c(new a(bitmap));
        }
    }

    /* loaded from: classes4.dex */
    public class k implements CameraView.c {

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f14816e;

            public a(Bitmap bitmap) {
                this.f14816e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraActivity.this.takePictureContainer.setVisibility(4);
                if (CameraActivity.this.cropMaskView.getMaskType() == 0) {
                    CameraActivity.this.cropView.setFilePath(CameraActivity.this.outputFile.getAbsolutePath());
                    CameraActivity.this.showCrop();
                    return;
                }
                CameraActivity.this.displayImageView.setImageBitmap(this.f14816e);
                CameraActivity.this.showResultConfirm();
            }
        }

        public k() {
        }

        @Override // com.baidu.tieba.barselect.idCard.CameraView.c
        public void a(Bitmap bitmap) {
            CameraActivity.this.handler.post(new a(bitmap));
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cropView.setFilePath(null);
            CameraActivity.this.showTakePicture();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int maskType = CameraActivity.this.cropMaskView.getMaskType();
            CameraActivity.this.displayImageView.setImageBitmap(CameraActivity.this.cropView.e((maskType == 1 || maskType == 2) ? CameraActivity.this.cropMaskView.getFrameRect() : CameraActivity.this.overlayView.getFrameRect()));
            CameraActivity.this.cropAndConfirm();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.outputFile);
                ((BitmapDrawable) CameraActivity.this.displayImageView.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Intent intent = new Intent();
            intent.putExtra("contentType", CameraActivity.this.contentType);
            CameraActivity.this.setResult(-1, intent);
            CameraActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cropAndConfirm() {
        this.cameraView.getCameraControl().pause();
        updateFlashMode();
        doConfirmResult();
    }

    private void doClear() {
        d.b.i0.v.c.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doConfirmResult() {
        d.b.i0.v.c.c.c(new n());
    }

    private String getRealPathFromURI(Uri uri) {
        Cursor cursor;
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

    private void initParams() {
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

    private void setOrientation(Configuration configuration) {
        int i2;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showCrop() {
        this.cameraView.getCameraControl().pause();
        updateFlashMode();
        this.takePictureContainer.setVisibility(4);
        this.confirmResultContainer.setVisibility(4);
        this.cropContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResultConfirm() {
        this.cameraView.getCameraControl().pause();
        updateFlashMode();
        this.takePictureContainer.setVisibility(4);
        this.confirmResultContainer.setVisibility(0);
        this.cropContainer.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTakePicture() {
        this.cameraView.getCameraControl().resume();
        updateFlashMode();
        this.takePictureContainer.setVisibility(0);
        this.confirmResultContainer.setVisibility(4);
        this.cropContainer.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFlashMode() {
        if (this.cameraView.getCameraControl().g() == 1) {
            this.lightButton.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.lightButton.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setOrientation(configuration);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.takePictureContainer = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.confirmResultContainer = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        CameraView cameraView = (CameraView) findViewById(R.id.camera_view);
        this.cameraView = cameraView;
        cameraView.getCameraControl().c(this.permissionCallback);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        doClear();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.cameraView.f();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 800) {
            if (i2 == 801 && (iArr.length <= 0 || iArr[0] != 0)) {
                d.b.c.e.p.l.K(TbadkCoreApplication.getInst(), R.string.storage_permission_required);
            }
        } else if (iArr.length > 0 && iArr[0] == 0) {
            this.cameraView.getCameraControl().a();
        } else {
            popPermissionDialog(this);
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null || cameraView.getCameraControl() == null) {
            return;
        }
        this.cameraView.getCameraControl().h();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cameraView.e();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void popPermissionDialog(Activity activity) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(activity);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setTitle(R.string.request_permission_default_title);
        aVar.setMessageId(R.string.request_permission_camera);
        aVar.setPositiveButton(R.string.isopen, new e(activity)).setNegativeButton(R.string.cancel, new d(activity)).create(getPageContext());
        aVar.show();
    }
}
