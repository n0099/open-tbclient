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
    private ImageView hAa;
    private CropView hAb;
    private FrameOverlayView hAc;
    private MaskView hAd;
    private ImageView hAe;
    private File hzU;
    private OCRCameraLayout hzV;
    private OCRCameraLayout hzW;
    private OCRCameraLayout hzX;
    private ImageView hzY;
    private CameraView hzZ;
    private Handler handler = new Handler();
    private e hzA = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cic() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hAf = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener hAg = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hzZ.getCameraControl().chI() == 0) {
                CameraActivity.this.hzZ.getCameraControl().wq(1);
            } else {
                CameraActivity.this.hzZ.getCameraControl().wq(0);
            }
            CameraActivity.this.chY();
        }
    };
    private View.OnClickListener hAh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hzZ.a(CameraActivity.this.hzU, CameraActivity.this.hAj);
        }
    };
    private CameraView.b hAi = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hzU);
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
    private CameraView.b hAj = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hzV.setVisibility(4);
                    if (CameraActivity.this.hAd.getMaskType() == 0) {
                        CameraActivity.this.hAb.setFilePath(CameraActivity.this.hzU.getAbsolutePath());
                        CameraActivity.this.chW();
                        return;
                    }
                    CameraActivity.this.hAa.setImageBitmap(bitmap);
                    CameraActivity.this.chX();
                }
            });
        }
    };
    private View.OnClickListener hAk = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hAb.setFilePath(null);
            CameraActivity.this.chV();
        }
    };
    private View.OnClickListener hAl = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.hAd.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.hAd.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.hAc.getFrameRect();
                    break;
            }
            CameraActivity.this.hAa.setImageBitmap(CameraActivity.this.hAb.e(frameRect));
            CameraActivity.this.chZ();
        }
    };
    private View.OnClickListener hAm = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cia();
        }
    };
    private View.OnClickListener hAn = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hAa.setImageBitmap(null);
            CameraActivity.this.chV();
        }
    };
    private View.OnClickListener hAo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hAb.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hzV = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.hzX = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hzZ = (CameraView) findViewById(R.id.camera_view);
        this.hzZ.getCameraControl().a(this.hzA);
        this.hzY = (ImageView) findViewById(R.id.light_button);
        this.hzY.setOnClickListener(this.hAg);
        this.hAe = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hAf);
        this.hAe.setOnClickListener(this.hAh);
        this.hAa = (ImageView) findViewById(R.id.display_image_view);
        this.hzX.findViewById(R.id.confirm_button).setOnClickListener(this.hAm);
        this.hzX.findViewById(R.id.cancel_button).setOnClickListener(this.hAn);
        findViewById(R.id.rotate_button).setOnClickListener(this.hAo);
        this.hAb = (CropView) findViewById(R.id.crop_view);
        this.hzW = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.hAc = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hzW.findViewById(R.id.confirm_button).setOnClickListener(this.hAl);
        this.hAd = (MaskView) this.hzW.findViewById(R.id.crop_mask_view);
        this.hzW.findViewById(R.id.cancel_button).setOnClickListener(this.hAk);
        c(getResources().getConfiguration());
        chU();
        this.hzZ.setAutoPictureCallback(this.hAi);
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
        this.hzZ.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hzZ.start();
    }

    private void chU() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hzU = new File(stringExtra);
            if (!this.hzU.exists()) {
                try {
                    this.hzU.createNewFile();
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
                this.hAc.setVisibility(4);
                break;
            case 1:
                this.hAc.setVisibility(4);
                i = 2;
                break;
            default:
                this.hAd.setVisibility(4);
                i = 0;
                break;
        }
        this.hzZ.setMaskType(i, this);
        this.hAd.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chV() {
        this.hzZ.getCameraControl().resume();
        chY();
        this.hzV.setVisibility(0);
        this.hzX.setVisibility(4);
        this.hzW.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chW() {
        this.hzZ.getCameraControl().pause();
        chY();
        this.hzV.setVisibility(4);
        this.hzX.setVisibility(4);
        this.hzW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chX() {
        this.hzZ.getCameraControl().pause();
        chY();
        this.hzV.setVisibility(4);
        this.hzX.setVisibility(0);
        this.hzW.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chY() {
        if (this.hzZ.getCameraControl().chI() == 1) {
            this.hzY.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hzY.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chZ() {
        this.hzZ.getCameraControl().pause();
        chY();
        cia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cia() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hzU);
                    ((BitmapDrawable) CameraActivity.this.hAa.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.hBr;
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
                this.hzZ.setOrientation(0);
                break;
        }
        this.hzV.setOrientation(i);
        this.hzZ.setOrientation(i2);
        this.hzW.setOrientation(i);
        this.hzX.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.hAb.setFilePath(x(intent.getData()));
                chW();
                return;
            }
            this.hzZ.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hzZ.getCameraControl().chH();
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
        if (this.hzZ != null && this.hzZ.getCameraControl() != null) {
            this.hzZ.getCameraControl().chT();
        }
    }

    private void cib() {
        c.cid();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cib();
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iA(false);
        aVar.oa(R.string.request_permission_default_title);
        aVar.ob(R.string.request_permission_camera);
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
        aVar.bkJ();
    }
}
