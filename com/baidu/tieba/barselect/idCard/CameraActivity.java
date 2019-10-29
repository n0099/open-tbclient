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
    private File eHn;
    private OCRCameraLayout eHo;
    private OCRCameraLayout eHp;
    private OCRCameraLayout eHq;
    private ImageView eHr;
    private CameraView eHs;
    private ImageView eHt;
    private CropView eHu;
    private FrameOverlayView eHv;
    private MaskView eHw;
    private ImageView eHx;
    private Handler handler = new Handler();
    private e eGS = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean aZU() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    };
    private View.OnClickListener eHy = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener eHz = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.eHs.getCameraControl().aZB() == 0) {
                CameraActivity.this.eHs.getCameraControl().oC(1);
            } else {
                CameraActivity.this.eHs.getCameraControl().oC(0);
            }
            CameraActivity.this.aZQ();
        }
    };
    private View.OnClickListener eHA = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eHs.a(CameraActivity.this.eHn, CameraActivity.this.eHC);
        }
    };
    private CameraView.b eHB = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.eHn);
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
    private CameraView.b eHC = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.eHo.setVisibility(4);
                    if (CameraActivity.this.eHw.getMaskType() == 0) {
                        CameraActivity.this.eHu.setFilePath(CameraActivity.this.eHn.getAbsolutePath());
                        CameraActivity.this.aZO();
                        return;
                    }
                    CameraActivity.this.eHt.setImageBitmap(bitmap);
                    CameraActivity.this.aZP();
                }
            });
        }
    };
    private View.OnClickListener eHD = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eHu.setFilePath(null);
            CameraActivity.this.aZN();
        }
    };
    private View.OnClickListener eHE = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.eHw.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.eHw.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.eHv.getFrameRect();
                    break;
            }
            CameraActivity.this.eHt.setImageBitmap(CameraActivity.this.eHu.g(frameRect));
            CameraActivity.this.aZR();
        }
    };
    private View.OnClickListener eHF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.aZS();
        }
    };
    private View.OnClickListener eHG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eHt.setImageBitmap(null);
            CameraActivity.this.aZN();
        }
    };
    private View.OnClickListener eHH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.eHu.oF(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.eHo = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.eHq = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.eHs = (CameraView) findViewById(R.id.camera_view);
        this.eHs.getCameraControl().a(this.eGS);
        this.eHr = (ImageView) findViewById(R.id.light_button);
        this.eHr.setOnClickListener(this.eHz);
        this.eHx = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.eHy);
        this.eHx.setOnClickListener(this.eHA);
        this.eHt = (ImageView) findViewById(R.id.display_image_view);
        this.eHq.findViewById(R.id.confirm_button).setOnClickListener(this.eHF);
        this.eHq.findViewById(R.id.cancel_button).setOnClickListener(this.eHG);
        findViewById(R.id.rotate_button).setOnClickListener(this.eHH);
        this.eHu = (CropView) findViewById(R.id.crop_view);
        this.eHp = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.eHv = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.eHp.findViewById(R.id.confirm_button).setOnClickListener(this.eHE);
        this.eHw = (MaskView) this.eHp.findViewById(R.id.crop_mask_view);
        this.eHp.findViewById(R.id.cancel_button).setOnClickListener(this.eHD);
        b(getResources().getConfiguration());
        aZM();
        this.eHs.setAutoPictureCallback(this.eHB);
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
        this.eHs.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eHs.start();
    }

    private void aZM() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.eHn = new File(stringExtra);
            if (!this.eHn.exists()) {
                try {
                    this.eHn.createNewFile();
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
                this.eHv.setVisibility(4);
                break;
            case 1:
                this.eHv.setVisibility(4);
                i = 2;
                break;
            default:
                this.eHw.setVisibility(4);
                i = 0;
                break;
        }
        this.eHs.setMaskType(i, this);
        this.eHw.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZN() {
        this.eHs.getCameraControl().resume();
        aZQ();
        this.eHo.setVisibility(0);
        this.eHq.setVisibility(4);
        this.eHp.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZO() {
        this.eHs.getCameraControl().pause();
        aZQ();
        this.eHo.setVisibility(4);
        this.eHq.setVisibility(4);
        this.eHp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZP() {
        this.eHs.getCameraControl().pause();
        aZQ();
        this.eHo.setVisibility(4);
        this.eHq.setVisibility(0);
        this.eHp.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZQ() {
        if (this.eHs.getCameraControl().aZB() == 1) {
            this.eHr.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.eHr.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZR() {
        this.eHs.getCameraControl().pause();
        aZQ();
        aZS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZS() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.eHn);
                    ((BitmapDrawable) CameraActivity.this.eHt.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.eIK;
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
                this.eHs.setOrientation(0);
                break;
        }
        this.eHo.setOrientation(i);
        this.eHs.setOrientation(i2);
        this.eHp.setOrientation(i);
        this.eHq.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.eHu.setFilePath(q(intent.getData()));
                aZO();
                return;
            }
            this.eHs.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.eHs.getCameraControl().aZA();
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
        if (this.eHs != null && this.eHs.getCameraControl() != null) {
            this.eHs.getCameraControl().aZL();
        }
    }

    private void aZT() {
        c.aZV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aZT();
    }

    public void ac(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.eh(false);
        aVar.hT(R.string.request_permission_default_title);
        aVar.hU(R.string.request_permission_camera);
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
        aVar.akO();
    }
}
