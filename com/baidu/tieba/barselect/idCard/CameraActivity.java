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
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private ImageView eGA;
    private CameraView eGB;
    private ImageView eGC;
    private CropView eGD;
    private FrameOverlayView eGE;
    private MaskView eGF;
    private ImageView eGG;
    private File eGw;
    private OCRCameraLayout eGx;
    private OCRCameraLayout eGy;
    private OCRCameraLayout eGz;
    private Handler handler = new Handler();
    private e eGb = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean aZS() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    };
    private View.OnClickListener eGH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener eGI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.eGB.getCameraControl().aZz() == 0) {
                CameraActivity.this.eGB.getCameraControl().oB(1);
            } else {
                CameraActivity.this.eGB.getCameraControl().oB(0);
            }
            CameraActivity.this.aZO();
        }
    };
    private View.OnClickListener eGJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eGB.a(CameraActivity.this.eGw, CameraActivity.this.eGL);
        }
    };
    private CameraView.b eGK = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.eGw);
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
    private CameraView.b eGL = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.eGx.setVisibility(4);
                    if (CameraActivity.this.eGF.getMaskType() == 0) {
                        CameraActivity.this.eGD.setFilePath(CameraActivity.this.eGw.getAbsolutePath());
                        CameraActivity.this.aZM();
                        return;
                    }
                    CameraActivity.this.eGC.setImageBitmap(bitmap);
                    CameraActivity.this.aZN();
                }
            });
        }
    };
    private View.OnClickListener eGM = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eGD.setFilePath(null);
            CameraActivity.this.aZL();
        }
    };
    private View.OnClickListener eGN = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.eGF.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.eGF.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.eGE.getFrameRect();
                    break;
            }
            CameraActivity.this.eGC.setImageBitmap(CameraActivity.this.eGD.g(frameRect));
            CameraActivity.this.aZP();
        }
    };
    private View.OnClickListener eGO = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.aZQ();
        }
    };
    private View.OnClickListener eGP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eGC.setImageBitmap(null);
            CameraActivity.this.aZL();
        }
    };
    private View.OnClickListener eGQ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eGD.oE(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.eGx = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.eGz = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.eGB = (CameraView) findViewById(R.id.camera_view);
        this.eGB.getCameraControl().a(this.eGb);
        this.eGA = (ImageView) findViewById(R.id.light_button);
        this.eGA.setOnClickListener(this.eGI);
        this.eGG = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.eGH);
        this.eGG.setOnClickListener(this.eGJ);
        this.eGC = (ImageView) findViewById(R.id.display_image_view);
        this.eGz.findViewById(R.id.confirm_button).setOnClickListener(this.eGO);
        this.eGz.findViewById(R.id.cancel_button).setOnClickListener(this.eGP);
        findViewById(R.id.rotate_button).setOnClickListener(this.eGQ);
        this.eGD = (CropView) findViewById(R.id.crop_view);
        this.eGy = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.eGE = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.eGy.findViewById(R.id.confirm_button).setOnClickListener(this.eGN);
        this.eGF = (MaskView) this.eGy.findViewById(R.id.crop_mask_view);
        this.eGy.findViewById(R.id.cancel_button).setOnClickListener(this.eGM);
        b(getResources().getConfiguration());
        aZK();
        this.eGB.setAutoPictureCallback(this.eGK);
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
        this.eGB.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eGB.start();
    }

    private void aZK() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.eGw = new File(stringExtra);
            if (!this.eGw.exists()) {
                try {
                    this.eGw.createNewFile();
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
                this.eGE.setVisibility(4);
                break;
            case 1:
                this.eGE.setVisibility(4);
                i = 2;
                break;
            default:
                this.eGF.setVisibility(4);
                i = 0;
                break;
        }
        this.eGB.setMaskType(i, this);
        this.eGF.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZL() {
        this.eGB.getCameraControl().resume();
        aZO();
        this.eGx.setVisibility(0);
        this.eGz.setVisibility(4);
        this.eGy.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZM() {
        this.eGB.getCameraControl().pause();
        aZO();
        this.eGx.setVisibility(4);
        this.eGz.setVisibility(4);
        this.eGy.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        this.eGB.getCameraControl().pause();
        aZO();
        this.eGx.setVisibility(4);
        this.eGz.setVisibility(0);
        this.eGy.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZO() {
        if (this.eGB.getCameraControl().aZz() == 1) {
            this.eGA.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.eGA.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZP() {
        this.eGB.getCameraControl().pause();
        aZO();
        aZQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZQ() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.eGw);
                    ((BitmapDrawable) CameraActivity.this.eGC.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String q(Uri uri) {
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
                i = OCRCameraLayout.eHT;
                if (rotation == 0 || rotation == 1) {
                    i2 = 90;
                    break;
                } else {
                    i2 = SubsamplingScaleImageView.ORIENTATION_270;
                    break;
                }
                break;
            default:
                i = OCRCameraLayout.ORIENTATION_PORTRAIT;
                this.eGB.setOrientation(0);
                break;
        }
        this.eGx.setOrientation(i);
        this.eGB.setOrientation(i2);
        this.eGy.setOrientation(i);
        this.eGz.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.eGD.setFilePath(q(intent.getData()));
                aZM();
                return;
            }
            this.eGB.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.eGB.getCameraControl().aZy();
                    break;
                } else {
                    ac(this);
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
        if (this.eGB != null && this.eGB.getCameraControl() != null) {
            this.eGB.getCameraControl().aZJ();
        }
    }

    private void aZR() {
        c.aZT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aZR();
    }

    public void ac(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.eh(false);
        aVar.hS(R.string.request_permission_default_title);
        aVar.hT(R.string.request_permission_camera);
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
        aVar.akM();
    }
}
