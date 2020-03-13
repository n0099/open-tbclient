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
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.CameraView;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private ImageView fEA;
    private File fEq;
    private OCRCameraLayout fEr;
    private OCRCameraLayout fEs;
    private OCRCameraLayout fEt;
    private ImageView fEu;
    private CameraView fEv;
    private ImageView fEw;
    private CropView fEx;
    private FrameOverlayView fEy;
    private MaskView fEz;
    private Handler handler = new Handler();
    private e fDX = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean buE() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener fEB = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ActivityCompat.checkSelfPermission(CameraActivity.this.getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0 && Build.VERSION.SDK_INT >= 16) {
                ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, CyberPlayerManager.MEDIA_INFO_NOT_SEEKABLE);
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            CameraActivity.this.startActivityForResult(intent, 100);
        }
    };
    private View.OnClickListener fEC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.fEv.getCameraControl().bum() == 0) {
                CameraActivity.this.fEv.getCameraControl().rh(1);
            } else {
                CameraActivity.this.fEv.getCameraControl().rh(0);
            }
            CameraActivity.this.buA();
        }
    };
    private View.OnClickListener fED = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEv.a(CameraActivity.this.fEq, CameraActivity.this.fEF);
        }
    };
    private CameraView.b fEE = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEq);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        bitmap.recycle();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    intent.putExtra(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivity.this.contentType);
                    CameraActivity.this.setResult(-1, intent);
                    CameraActivity.this.finish();
                }
            });
        }
    };
    private CameraView.b fEF = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.fEr.setVisibility(4);
                    if (CameraActivity.this.fEz.getMaskType() == 0) {
                        CameraActivity.this.fEx.setFilePath(CameraActivity.this.fEq.getAbsolutePath());
                        CameraActivity.this.buy();
                        return;
                    }
                    CameraActivity.this.fEw.setImageBitmap(bitmap);
                    CameraActivity.this.buz();
                }
            });
        }
    };
    private View.OnClickListener fEG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEx.setFilePath(null);
            CameraActivity.this.bux();
        }
    };
    private View.OnClickListener fEH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.fEz.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.fEz.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.fEy.getFrameRect();
                    break;
            }
            CameraActivity.this.fEw.setImageBitmap(CameraActivity.this.fEx.e(frameRect));
            CameraActivity.this.buB();
        }
    };
    private View.OnClickListener fEI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.buC();
        }
    };
    private View.OnClickListener fEJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEw.setImageBitmap(null);
            CameraActivity.this.bux();
        }
    };
    private View.OnClickListener fEK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEx.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.fEr = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.fEt = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.fEv = (CameraView) findViewById(R.id.camera_view);
        this.fEv.getCameraControl().a(this.fDX);
        this.fEu = (ImageView) findViewById(R.id.light_button);
        this.fEu.setOnClickListener(this.fEC);
        this.fEA = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.fEB);
        this.fEA.setOnClickListener(this.fED);
        this.fEw = (ImageView) findViewById(R.id.display_image_view);
        this.fEt.findViewById(R.id.confirm_button).setOnClickListener(this.fEI);
        this.fEt.findViewById(R.id.cancel_button).setOnClickListener(this.fEJ);
        findViewById(R.id.rotate_button).setOnClickListener(this.fEK);
        this.fEx = (CropView) findViewById(R.id.crop_view);
        this.fEs = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.fEy = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.fEs.findViewById(R.id.confirm_button).setOnClickListener(this.fEH);
        this.fEz = (MaskView) this.fEs.findViewById(R.id.crop_mask_view);
        this.fEs.findViewById(R.id.cancel_button).setOnClickListener(this.fEG);
        b(getResources().getConfiguration());
        buw();
        this.fEv.setAutoPictureCallback(this.fEE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.fEv.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fEv.start();
    }

    private void buw() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.fEq = new File(stringExtra);
            if (!this.fEq.exists()) {
                try {
                    this.fEq.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        this.contentType = getIntent().getStringExtra(CameraActivityConfig.KEY_CONTENT_TYPE);
        if (this.contentType == null) {
            this.contentType = CameraActivityConfig.CONTENT_TYPE_GENERAL;
        }
        String str = this.contentType;
        char c = 65535;
        switch (str.hashCode()) {
            case -1070661090:
                if (str.equals(CameraActivityConfig.CONTENT_TYPE_ID_CARD_FRONT)) {
                    c = 0;
                    break;
                }
                break;
            case -80148248:
                if (str.equals(CameraActivityConfig.CONTENT_TYPE_GENERAL)) {
                    c = 2;
                    break;
                }
                break;
            case 242421330:
                if (str.equals(CameraActivityConfig.CONTENT_TYPE_ID_CARD_BACK)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.fEy.setVisibility(4);
                break;
            case 1:
                this.fEy.setVisibility(4);
                i = 2;
                break;
            default:
                this.fEz.setVisibility(4);
                i = 0;
                break;
        }
        this.fEv.setMaskType(i, this);
        this.fEz.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bux() {
        this.fEv.getCameraControl().resume();
        buA();
        this.fEr.setVisibility(0);
        this.fEt.setVisibility(4);
        this.fEs.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buy() {
        this.fEv.getCameraControl().pause();
        buA();
        this.fEr.setVisibility(4);
        this.fEt.setVisibility(4);
        this.fEs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buz() {
        this.fEv.getCameraControl().pause();
        buA();
        this.fEr.setVisibility(4);
        this.fEt.setVisibility(0);
        this.fEs.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buA() {
        if (this.fEv.getCameraControl().bum() == 1) {
            this.fEu.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.fEu.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buB() {
        this.fEv.getCameraControl().pause();
        buA();
        buC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buC() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEq);
                    ((BitmapDrawable) CameraActivity.this.fEw.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.putExtra(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivity.this.contentType);
                CameraActivity.this.setResult(-1, intent);
                CameraActivity.this.finish();
            }
        });
    }

    private String t(Uri uri) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b(configuration);
    }

    private void b(Configuration configuration) {
        int i;
        int i2 = 0;
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        switch (configuration.orientation) {
            case 1:
                i = OCRCameraLayout.ORIENTATION_PORTRAIT;
                break;
            case 2:
                i = OCRCameraLayout.fFN;
                if (rotation == 0 || rotation == 1) {
                    i2 = 90;
                    break;
                } else {
                    i2 = 270;
                    break;
                }
                break;
            default:
                i = OCRCameraLayout.ORIENTATION_PORTRAIT;
                this.fEv.setOrientation(0);
                break;
        }
        this.fEr.setOrientation(i);
        this.fEv.setOrientation(i2);
        this.fEs.setOrientation(i);
        this.fEt.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.fEx.setFilePath(t(intent.getData()));
                buy();
                return;
            }
            this.fEv.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.fEv.getCameraControl().bul();
                    break;
                } else {
                    al(this);
                    break;
                }
                break;
            case CyberPlayerManager.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.storage_permission_required);
                    break;
                }
                break;
        }
        if (this.fEv != null && this.fEv.getCameraControl() != null) {
            this.fEv.getCameraControl().buv();
        }
    }

    private void buD() {
        c.buF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        buD();
    }

    public void al(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fH(false);
        aVar.jV(R.string.request_permission_default_title);
        aVar.jW(R.string.request_permission_camera);
        aVar.a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                activity.startActivity(intent);
                activity.finish();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                activity.finish();
            }
        }).b(getPageContext());
        aVar.aEC();
    }
}
