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
/* loaded from: classes21.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private ImageView hMA;
    private File hMq;
    private OCRCameraLayout hMr;
    private OCRCameraLayout hMs;
    private OCRCameraLayout hMt;
    private ImageView hMu;
    private CameraView hMv;
    private ImageView hMw;
    private CropView hMx;
    private FrameOverlayView hMy;
    private MaskView hMz;
    private Handler handler = new Handler();
    private e hLW = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean clj() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hMB = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener hMC = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hMv.getCameraControl().ckP() == 0) {
                CameraActivity.this.hMv.getCameraControl().wJ(1);
            } else {
                CameraActivity.this.hMv.getCameraControl().wJ(0);
            }
            CameraActivity.this.clf();
        }
    };
    private View.OnClickListener hMD = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hMv.a(CameraActivity.this.hMq, CameraActivity.this.hMF);
        }
    };
    private CameraView.b hME = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hMq);
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
    private CameraView.b hMF = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hMr.setVisibility(4);
                    if (CameraActivity.this.hMz.getMaskType() == 0) {
                        CameraActivity.this.hMx.setFilePath(CameraActivity.this.hMq.getAbsolutePath());
                        CameraActivity.this.cld();
                        return;
                    }
                    CameraActivity.this.hMw.setImageBitmap(bitmap);
                    CameraActivity.this.cle();
                }
            });
        }
    };
    private View.OnClickListener hMG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hMx.setFilePath(null);
            CameraActivity.this.clc();
        }
    };
    private View.OnClickListener hMH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.hMz.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.hMz.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.hMy.getFrameRect();
                    break;
            }
            CameraActivity.this.hMw.setImageBitmap(CameraActivity.this.hMx.e(frameRect));
            CameraActivity.this.clg();
        }
    };
    private View.OnClickListener hMI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.clh();
        }
    };
    private View.OnClickListener hMJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hMw.setImageBitmap(null);
            CameraActivity.this.clc();
        }
    };
    private View.OnClickListener hMK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hMx.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hMr = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.hMt = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hMv = (CameraView) findViewById(R.id.camera_view);
        this.hMv.getCameraControl().a(this.hLW);
        this.hMu = (ImageView) findViewById(R.id.light_button);
        this.hMu.setOnClickListener(this.hMC);
        this.hMA = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hMB);
        this.hMA.setOnClickListener(this.hMD);
        this.hMw = (ImageView) findViewById(R.id.display_image_view);
        this.hMt.findViewById(R.id.confirm_button).setOnClickListener(this.hMI);
        this.hMt.findViewById(R.id.cancel_button).setOnClickListener(this.hMJ);
        findViewById(R.id.rotate_button).setOnClickListener(this.hMK);
        this.hMx = (CropView) findViewById(R.id.crop_view);
        this.hMs = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.hMy = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hMs.findViewById(R.id.confirm_button).setOnClickListener(this.hMH);
        this.hMz = (MaskView) this.hMs.findViewById(R.id.crop_mask_view);
        this.hMs.findViewById(R.id.cancel_button).setOnClickListener(this.hMG);
        c(getResources().getConfiguration());
        clb();
        this.hMv.setAutoPictureCallback(this.hME);
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
        this.hMv.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hMv.start();
    }

    private void clb() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hMq = new File(stringExtra);
            if (!this.hMq.exists()) {
                try {
                    this.hMq.createNewFile();
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
                this.hMy.setVisibility(4);
                break;
            case 1:
                this.hMy.setVisibility(4);
                i = 2;
                break;
            default:
                this.hMz.setVisibility(4);
                i = 0;
                break;
        }
        this.hMv.setMaskType(i, this);
        this.hMz.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clc() {
        this.hMv.getCameraControl().resume();
        clf();
        this.hMr.setVisibility(0);
        this.hMt.setVisibility(4);
        this.hMs.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cld() {
        this.hMv.getCameraControl().pause();
        clf();
        this.hMr.setVisibility(4);
        this.hMt.setVisibility(4);
        this.hMs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cle() {
        this.hMv.getCameraControl().pause();
        clf();
        this.hMr.setVisibility(4);
        this.hMt.setVisibility(0);
        this.hMs.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clf() {
        if (this.hMv.getCameraControl().ckP() == 1) {
            this.hMu.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hMu.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clg() {
        this.hMv.getCameraControl().pause();
        clf();
        clh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clh() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hMq);
                    ((BitmapDrawable) CameraActivity.this.hMw.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String x(Uri uri) {
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
                i = OCRCameraLayout.hNN;
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
                this.hMv.setOrientation(0);
                break;
        }
        this.hMr.setOrientation(i);
        this.hMv.setOrientation(i2);
        this.hMs.setOrientation(i);
        this.hMt.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.hMx.setFilePath(x(intent.getData()));
                cld();
                return;
            }
            this.hMv.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hMv.getCameraControl().ckO();
                    break;
                } else {
                    ao(this);
                    break;
                }
                break;
            case CyberPlayerManager.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.storage_permission_required);
                    break;
                }
                break;
        }
        if (this.hMv != null && this.hMv.getCameraControl() != null) {
            this.hMv.getCameraControl().cla();
        }
    }

    private void cli() {
        c.clk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cli();
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iN(false);
        aVar.ol(R.string.request_permission_default_title);
        aVar.om(R.string.request_permission_camera);
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
        aVar.bmC();
    }
}
