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
    private File fEY;
    private OCRCameraLayout fEZ;
    private OCRCameraLayout fFa;
    private OCRCameraLayout fFb;
    private ImageView fFc;
    private CameraView fFd;
    private ImageView fFe;
    private CropView fFf;
    private FrameOverlayView fFg;
    private MaskView fFh;
    private ImageView fFi;
    private Handler handler = new Handler();
    private e fEF = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean buJ() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener fFj = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener fFk = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.fFd.getCameraControl().bur() == 0) {
                CameraActivity.this.fFd.getCameraControl().rj(1);
            } else {
                CameraActivity.this.fFd.getCameraControl().rj(0);
            }
            CameraActivity.this.buF();
        }
    };
    private View.OnClickListener fFl = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fFd.a(CameraActivity.this.fEY, CameraActivity.this.fFn);
        }
    };
    private CameraView.b fFm = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEY);
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
    private CameraView.b fFn = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.fEZ.setVisibility(4);
                    if (CameraActivity.this.fFh.getMaskType() == 0) {
                        CameraActivity.this.fFf.setFilePath(CameraActivity.this.fEY.getAbsolutePath());
                        CameraActivity.this.buD();
                        return;
                    }
                    CameraActivity.this.fFe.setImageBitmap(bitmap);
                    CameraActivity.this.buE();
                }
            });
        }
    };
    private View.OnClickListener fFo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fFf.setFilePath(null);
            CameraActivity.this.buC();
        }
    };
    private View.OnClickListener fFp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.fFh.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.fFh.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.fFg.getFrameRect();
                    break;
            }
            CameraActivity.this.fFe.setImageBitmap(CameraActivity.this.fFf.e(frameRect));
            CameraActivity.this.buG();
        }
    };
    private View.OnClickListener fFq = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.buH();
        }
    };
    private View.OnClickListener fFr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fFe.setImageBitmap(null);
            CameraActivity.this.buC();
        }
    };
    private View.OnClickListener fFs = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fFf.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.fEZ = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.fFb = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.fFd = (CameraView) findViewById(R.id.camera_view);
        this.fFd.getCameraControl().a(this.fEF);
        this.fFc = (ImageView) findViewById(R.id.light_button);
        this.fFc.setOnClickListener(this.fFk);
        this.fFi = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.fFj);
        this.fFi.setOnClickListener(this.fFl);
        this.fFe = (ImageView) findViewById(R.id.display_image_view);
        this.fFb.findViewById(R.id.confirm_button).setOnClickListener(this.fFq);
        this.fFb.findViewById(R.id.cancel_button).setOnClickListener(this.fFr);
        findViewById(R.id.rotate_button).setOnClickListener(this.fFs);
        this.fFf = (CropView) findViewById(R.id.crop_view);
        this.fFa = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.fFg = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.fFa.findViewById(R.id.confirm_button).setOnClickListener(this.fFp);
        this.fFh = (MaskView) this.fFa.findViewById(R.id.crop_mask_view);
        this.fFa.findViewById(R.id.cancel_button).setOnClickListener(this.fFo);
        b(getResources().getConfiguration());
        buB();
        this.fFd.setAutoPictureCallback(this.fFm);
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
        this.fFd.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fFd.start();
    }

    private void buB() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.fEY = new File(stringExtra);
            if (!this.fEY.exists()) {
                try {
                    this.fEY.createNewFile();
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
                this.fFg.setVisibility(4);
                break;
            case 1:
                this.fFg.setVisibility(4);
                i = 2;
                break;
            default:
                this.fFh.setVisibility(4);
                i = 0;
                break;
        }
        this.fFd.setMaskType(i, this);
        this.fFh.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buC() {
        this.fFd.getCameraControl().resume();
        buF();
        this.fEZ.setVisibility(0);
        this.fFb.setVisibility(4);
        this.fFa.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buD() {
        this.fFd.getCameraControl().pause();
        buF();
        this.fEZ.setVisibility(4);
        this.fFb.setVisibility(4);
        this.fFa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buE() {
        this.fFd.getCameraControl().pause();
        buF();
        this.fEZ.setVisibility(4);
        this.fFb.setVisibility(0);
        this.fFa.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buF() {
        if (this.fFd.getCameraControl().bur() == 1) {
            this.fFc.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.fFc.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buG() {
        this.fFd.getCameraControl().pause();
        buF();
        buH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buH() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fEY);
                    ((BitmapDrawable) CameraActivity.this.fFe.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.fGv;
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
                this.fFd.setOrientation(0);
                break;
        }
        this.fEZ.setOrientation(i);
        this.fFd.setOrientation(i2);
        this.fFa.setOrientation(i);
        this.fFb.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.fFf.setFilePath(t(intent.getData()));
                buD();
                return;
            }
            this.fFd.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.fFd.getCameraControl().buq();
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
        if (this.fFd != null && this.fFd.getCameraControl() != null) {
            this.fFd.getCameraControl().buA();
        }
    }

    private void buI() {
        c.buK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        buI();
    }

    public void al(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fI(false);
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
        aVar.aEG();
    }
}
