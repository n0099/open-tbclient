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
    private File fEb;
    private OCRCameraLayout fEc;
    private OCRCameraLayout fEd;
    private OCRCameraLayout fEe;
    private ImageView fEf;
    private CameraView fEg;
    private ImageView fEh;
    private CropView fEi;
    private FrameOverlayView fEj;
    private MaskView fEk;
    private ImageView fEl;
    private Handler handler = new Handler();
    private e fDI = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean buB() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener fEm = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener fEn = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.fEg.getCameraControl().buj() == 0) {
                CameraActivity.this.fEg.getCameraControl().rh(1);
            } else {
                CameraActivity.this.fEg.getCameraControl().rh(0);
            }
            CameraActivity.this.bux();
        }
    };
    private View.OnClickListener fEo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEg.a(CameraActivity.this.fEb, CameraActivity.this.fEq);
        }
    };
    private CameraView.b fEp = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEb);
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
    private CameraView.b fEq = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.fEc.setVisibility(4);
                    if (CameraActivity.this.fEk.getMaskType() == 0) {
                        CameraActivity.this.fEi.setFilePath(CameraActivity.this.fEb.getAbsolutePath());
                        CameraActivity.this.buv();
                        return;
                    }
                    CameraActivity.this.fEh.setImageBitmap(bitmap);
                    CameraActivity.this.buw();
                }
            });
        }
    };
    private View.OnClickListener fEr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEi.setFilePath(null);
            CameraActivity.this.buu();
        }
    };
    private View.OnClickListener fEs = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.fEk.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.fEk.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.fEj.getFrameRect();
                    break;
            }
            CameraActivity.this.fEh.setImageBitmap(CameraActivity.this.fEi.e(frameRect));
            CameraActivity.this.buy();
        }
    };
    private View.OnClickListener fEt = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.buz();
        }
    };
    private View.OnClickListener fEu = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEh.setImageBitmap(null);
            CameraActivity.this.buu();
        }
    };
    private View.OnClickListener fEv = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fEi.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.fEc = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.fEe = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.fEg = (CameraView) findViewById(R.id.camera_view);
        this.fEg.getCameraControl().a(this.fDI);
        this.fEf = (ImageView) findViewById(R.id.light_button);
        this.fEf.setOnClickListener(this.fEn);
        this.fEl = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.fEm);
        this.fEl.setOnClickListener(this.fEo);
        this.fEh = (ImageView) findViewById(R.id.display_image_view);
        this.fEe.findViewById(R.id.confirm_button).setOnClickListener(this.fEt);
        this.fEe.findViewById(R.id.cancel_button).setOnClickListener(this.fEu);
        findViewById(R.id.rotate_button).setOnClickListener(this.fEv);
        this.fEi = (CropView) findViewById(R.id.crop_view);
        this.fEd = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.fEj = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.fEd.findViewById(R.id.confirm_button).setOnClickListener(this.fEs);
        this.fEk = (MaskView) this.fEd.findViewById(R.id.crop_mask_view);
        this.fEd.findViewById(R.id.cancel_button).setOnClickListener(this.fEr);
        b(getResources().getConfiguration());
        but();
        this.fEg.setAutoPictureCallback(this.fEp);
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
        this.fEg.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fEg.start();
    }

    private void but() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.fEb = new File(stringExtra);
            if (!this.fEb.exists()) {
                try {
                    this.fEb.createNewFile();
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
                this.fEj.setVisibility(4);
                break;
            case 1:
                this.fEj.setVisibility(4);
                i = 2;
                break;
            default:
                this.fEk.setVisibility(4);
                i = 0;
                break;
        }
        this.fEg.setMaskType(i, this);
        this.fEk.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buu() {
        this.fEg.getCameraControl().resume();
        bux();
        this.fEc.setVisibility(0);
        this.fEe.setVisibility(4);
        this.fEd.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buv() {
        this.fEg.getCameraControl().pause();
        bux();
        this.fEc.setVisibility(4);
        this.fEe.setVisibility(4);
        this.fEd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buw() {
        this.fEg.getCameraControl().pause();
        bux();
        this.fEc.setVisibility(4);
        this.fEe.setVisibility(0);
        this.fEd.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bux() {
        if (this.fEg.getCameraControl().buj() == 1) {
            this.fEf.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.fEf.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buy() {
        this.fEg.getCameraControl().pause();
        bux();
        buz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buz() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEb);
                    ((BitmapDrawable) CameraActivity.this.fEh.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.fFy;
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
                this.fEg.setOrientation(0);
                break;
        }
        this.fEc.setOrientation(i);
        this.fEg.setOrientation(i2);
        this.fEd.setOrientation(i);
        this.fEe.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.fEi.setFilePath(t(intent.getData()));
                buv();
                return;
            }
            this.fEg.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.fEg.getCameraControl().bui();
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
        if (this.fEg != null && this.fEg.getCameraControl() != null) {
            this.fEg.getCameraControl().bus();
        }
    }

    private void buA() {
        c.buC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        buA();
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
        aVar.aEA();
    }
}
