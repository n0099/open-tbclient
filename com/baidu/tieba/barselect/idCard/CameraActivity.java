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
    private File fEd;
    private OCRCameraLayout fEe;
    private OCRCameraLayout fEf;
    private OCRCameraLayout fEg;
    private ImageView fEh;
    private CameraView fEi;
    private ImageView fEj;
    private CropView fEk;
    private FrameOverlayView fEl;
    private MaskView fEm;
    private ImageView fEn;
    private Handler handler = new Handler();
    private e fDK = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean buD() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener fEo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener fEp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.fEi.getCameraControl().bul() == 0) {
                CameraActivity.this.fEi.getCameraControl().rh(1);
            } else {
                CameraActivity.this.fEi.getCameraControl().rh(0);
            }
            CameraActivity.this.buz();
        }
    };
    private View.OnClickListener fEq = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEi.a(CameraActivity.this.fEd, CameraActivity.this.fEs);
        }
    };
    private CameraView.b fEr = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEd);
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
    private CameraView.b fEs = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.fEe.setVisibility(4);
                    if (CameraActivity.this.fEm.getMaskType() == 0) {
                        CameraActivity.this.fEk.setFilePath(CameraActivity.this.fEd.getAbsolutePath());
                        CameraActivity.this.bux();
                        return;
                    }
                    CameraActivity.this.fEj.setImageBitmap(bitmap);
                    CameraActivity.this.buy();
                }
            });
        }
    };
    private View.OnClickListener fEt = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEk.setFilePath(null);
            CameraActivity.this.buw();
        }
    };
    private View.OnClickListener fEu = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.fEm.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.fEm.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.fEl.getFrameRect();
                    break;
            }
            CameraActivity.this.fEj.setImageBitmap(CameraActivity.this.fEk.e(frameRect));
            CameraActivity.this.buA();
        }
    };
    private View.OnClickListener fEv = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.buB();
        }
    };
    private View.OnClickListener fEw = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEj.setImageBitmap(null);
            CameraActivity.this.buw();
        }
    };
    private View.OnClickListener fEx = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEk.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.fEe = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.fEg = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.fEi = (CameraView) findViewById(R.id.camera_view);
        this.fEi.getCameraControl().a(this.fDK);
        this.fEh = (ImageView) findViewById(R.id.light_button);
        this.fEh.setOnClickListener(this.fEp);
        this.fEn = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.fEo);
        this.fEn.setOnClickListener(this.fEq);
        this.fEj = (ImageView) findViewById(R.id.display_image_view);
        this.fEg.findViewById(R.id.confirm_button).setOnClickListener(this.fEv);
        this.fEg.findViewById(R.id.cancel_button).setOnClickListener(this.fEw);
        findViewById(R.id.rotate_button).setOnClickListener(this.fEx);
        this.fEk = (CropView) findViewById(R.id.crop_view);
        this.fEf = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.fEl = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.fEf.findViewById(R.id.confirm_button).setOnClickListener(this.fEu);
        this.fEm = (MaskView) this.fEf.findViewById(R.id.crop_mask_view);
        this.fEf.findViewById(R.id.cancel_button).setOnClickListener(this.fEt);
        b(getResources().getConfiguration());
        buv();
        this.fEi.setAutoPictureCallback(this.fEr);
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
        this.fEi.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fEi.start();
    }

    private void buv() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.fEd = new File(stringExtra);
            if (!this.fEd.exists()) {
                try {
                    this.fEd.createNewFile();
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
                this.fEl.setVisibility(4);
                break;
            case 1:
                this.fEl.setVisibility(4);
                i = 2;
                break;
            default:
                this.fEm.setVisibility(4);
                i = 0;
                break;
        }
        this.fEi.setMaskType(i, this);
        this.fEm.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buw() {
        this.fEi.getCameraControl().resume();
        buz();
        this.fEe.setVisibility(0);
        this.fEg.setVisibility(4);
        this.fEf.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bux() {
        this.fEi.getCameraControl().pause();
        buz();
        this.fEe.setVisibility(4);
        this.fEg.setVisibility(4);
        this.fEf.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buy() {
        this.fEi.getCameraControl().pause();
        buz();
        this.fEe.setVisibility(4);
        this.fEg.setVisibility(0);
        this.fEf.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buz() {
        if (this.fEi.getCameraControl().bul() == 1) {
            this.fEh.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.fEh.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buA() {
        this.fEi.getCameraControl().pause();
        buz();
        buB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buB() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEd);
                    ((BitmapDrawable) CameraActivity.this.fEj.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.fFA;
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
                this.fEi.setOrientation(0);
                break;
        }
        this.fEe.setOrientation(i);
        this.fEi.setOrientation(i2);
        this.fEf.setOrientation(i);
        this.fEg.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.fEk.setFilePath(t(intent.getData()));
                bux();
                return;
            }
            this.fEi.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.fEi.getCameraControl().buk();
                    break;
                } else {
                    aj(this);
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
        if (this.fEi != null && this.fEi.getCameraControl() != null) {
            this.fEi.getCameraControl().buu();
        }
    }

    private void buC() {
        c.buE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        buC();
    }

    public void aj(final Activity activity) {
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
