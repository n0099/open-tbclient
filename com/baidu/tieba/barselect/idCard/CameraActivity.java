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
    private OCRCameraLayout gyA;
    private OCRCameraLayout gyB;
    private OCRCameraLayout gyC;
    private ImageView gyD;
    private CameraView gyE;
    private ImageView gyF;
    private CropView gyG;
    private FrameOverlayView gyH;
    private MaskView gyI;
    private ImageView gyJ;
    private File gyz;
    private Handler handler = new Handler();
    private e gyg = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean bKL() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener gyK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener gyL = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.gyE.getCameraControl().bKs() == 0) {
                CameraActivity.this.gyE.getCameraControl().se(1);
            } else {
                CameraActivity.this.gyE.getCameraControl().se(0);
            }
            CameraActivity.this.bKH();
        }
    };
    private View.OnClickListener gyM = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gyE.a(CameraActivity.this.gyz, CameraActivity.this.gyO);
        }
    };
    private CameraView.b gyN = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.gyz);
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
    private CameraView.b gyO = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.gyA.setVisibility(4);
                    if (CameraActivity.this.gyI.getMaskType() == 0) {
                        CameraActivity.this.gyG.setFilePath(CameraActivity.this.gyz.getAbsolutePath());
                        CameraActivity.this.bKF();
                        return;
                    }
                    CameraActivity.this.gyF.setImageBitmap(bitmap);
                    CameraActivity.this.bKG();
                }
            });
        }
    };
    private View.OnClickListener gyP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gyG.setFilePath(null);
            CameraActivity.this.bKE();
        }
    };
    private View.OnClickListener gyQ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.gyI.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.gyI.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.gyH.getFrameRect();
                    break;
            }
            CameraActivity.this.gyF.setImageBitmap(CameraActivity.this.gyG.e(frameRect));
            CameraActivity.this.bKI();
        }
    };
    private View.OnClickListener gyR = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.bKJ();
        }
    };
    private View.OnClickListener gyS = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gyF.setImageBitmap(null);
            CameraActivity.this.bKE();
        }
    };
    private View.OnClickListener gyT = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gyG.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.gyA = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.gyC = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.gyE = (CameraView) findViewById(R.id.camera_view);
        this.gyE.getCameraControl().a(this.gyg);
        this.gyD = (ImageView) findViewById(R.id.light_button);
        this.gyD.setOnClickListener(this.gyL);
        this.gyJ = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.gyK);
        this.gyJ.setOnClickListener(this.gyM);
        this.gyF = (ImageView) findViewById(R.id.display_image_view);
        this.gyC.findViewById(R.id.confirm_button).setOnClickListener(this.gyR);
        this.gyC.findViewById(R.id.cancel_button).setOnClickListener(this.gyS);
        findViewById(R.id.rotate_button).setOnClickListener(this.gyT);
        this.gyG = (CropView) findViewById(R.id.crop_view);
        this.gyB = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.gyH = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.gyB.findViewById(R.id.confirm_button).setOnClickListener(this.gyQ);
        this.gyI = (MaskView) this.gyB.findViewById(R.id.crop_mask_view);
        this.gyB.findViewById(R.id.cancel_button).setOnClickListener(this.gyP);
        c(getResources().getConfiguration());
        bKD();
        this.gyE.setAutoPictureCallback(this.gyN);
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
        this.gyE.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gyE.start();
    }

    private void bKD() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.gyz = new File(stringExtra);
            if (!this.gyz.exists()) {
                try {
                    this.gyz.createNewFile();
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
                this.gyH.setVisibility(4);
                break;
            case 1:
                this.gyH.setVisibility(4);
                i = 2;
                break;
            default:
                this.gyI.setVisibility(4);
                i = 0;
                break;
        }
        this.gyE.setMaskType(i, this);
        this.gyI.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKE() {
        this.gyE.getCameraControl().resume();
        bKH();
        this.gyA.setVisibility(0);
        this.gyC.setVisibility(4);
        this.gyB.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKF() {
        this.gyE.getCameraControl().pause();
        bKH();
        this.gyA.setVisibility(4);
        this.gyC.setVisibility(4);
        this.gyB.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKG() {
        this.gyE.getCameraControl().pause();
        bKH();
        this.gyA.setVisibility(4);
        this.gyC.setVisibility(0);
        this.gyB.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKH() {
        if (this.gyE.getCameraControl().bKs() == 1) {
            this.gyD.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.gyD.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKI() {
        this.gyE.getCameraControl().pause();
        bKH();
        bKJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKJ() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.gyz);
                    ((BitmapDrawable) CameraActivity.this.gyF.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String w(Uri uri) {
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
        c(configuration);
    }

    private void c(Configuration configuration) {
        int i;
        int i2 = 0;
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        switch (configuration.orientation) {
            case 1:
                i = OCRCameraLayout.ORIENTATION_PORTRAIT;
                break;
            case 2:
                i = OCRCameraLayout.gzW;
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
                this.gyE.setOrientation(0);
                break;
        }
        this.gyA.setOrientation(i);
        this.gyE.setOrientation(i2);
        this.gyB.setOrientation(i);
        this.gyC.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.gyG.setFilePath(w(intent.getData()));
                bKF();
                return;
            }
            this.gyE.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.gyE.getCameraControl().bKr();
                    break;
                } else {
                    ag(this);
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
        if (this.gyE != null && this.gyE.getCameraControl() != null) {
            this.gyE.getCameraControl().bKC();
        }
    }

    private void bKK() {
        c.bKM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bKK();
    }

    public void ag(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.gX(false);
        aVar.kC(R.string.request_permission_default_title);
        aVar.kD(R.string.request_permission_camera);
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
        aVar.aST();
    }
}
