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
    private File hSn;
    private OCRCameraLayout hSo;
    private OCRCameraLayout hSp;
    private OCRCameraLayout hSq;
    private ImageView hSr;
    private CameraView hSs;
    private ImageView hSt;
    private CropView hSu;
    private FrameOverlayView hSv;
    private MaskView hSw;
    private ImageView hSx;
    private Handler handler = new Handler();
    private e hRT = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cnK() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hSy = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener hSz = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hSs.getCameraControl().cnr() == 0) {
                CameraActivity.this.hSs.getCameraControl().wW(1);
            } else {
                CameraActivity.this.hSs.getCameraControl().wW(0);
            }
            CameraActivity.this.cnG();
        }
    };
    private View.OnClickListener hSA = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSs.a(CameraActivity.this.hSn, CameraActivity.this.hSC);
        }
    };
    private CameraView.b hSB = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hSn);
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
    private CameraView.b hSC = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hSo.setVisibility(4);
                    if (CameraActivity.this.hSw.getMaskType() == 0) {
                        CameraActivity.this.hSu.setFilePath(CameraActivity.this.hSn.getAbsolutePath());
                        CameraActivity.this.cnE();
                        return;
                    }
                    CameraActivity.this.hSt.setImageBitmap(bitmap);
                    CameraActivity.this.cnF();
                }
            });
        }
    };
    private View.OnClickListener hSD = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSu.setFilePath(null);
            CameraActivity.this.cnD();
        }
    };
    private View.OnClickListener hSE = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.hSw.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.hSw.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.hSv.getFrameRect();
                    break;
            }
            CameraActivity.this.hSt.setImageBitmap(CameraActivity.this.hSu.e(frameRect));
            CameraActivity.this.cnH();
        }
    };
    private View.OnClickListener hSF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cnI();
        }
    };
    private View.OnClickListener hSG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSt.setImageBitmap(null);
            CameraActivity.this.cnD();
        }
    };
    private View.OnClickListener hSH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSu.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hSo = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.hSq = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hSs = (CameraView) findViewById(R.id.camera_view);
        this.hSs.getCameraControl().a(this.hRT);
        this.hSr = (ImageView) findViewById(R.id.light_button);
        this.hSr.setOnClickListener(this.hSz);
        this.hSx = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hSy);
        this.hSx.setOnClickListener(this.hSA);
        this.hSt = (ImageView) findViewById(R.id.display_image_view);
        this.hSq.findViewById(R.id.confirm_button).setOnClickListener(this.hSF);
        this.hSq.findViewById(R.id.cancel_button).setOnClickListener(this.hSG);
        findViewById(R.id.rotate_button).setOnClickListener(this.hSH);
        this.hSu = (CropView) findViewById(R.id.crop_view);
        this.hSp = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.hSv = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hSp.findViewById(R.id.confirm_button).setOnClickListener(this.hSE);
        this.hSw = (MaskView) this.hSp.findViewById(R.id.crop_mask_view);
        this.hSp.findViewById(R.id.cancel_button).setOnClickListener(this.hSD);
        c(getResources().getConfiguration());
        cnC();
        this.hSs.setAutoPictureCallback(this.hSB);
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
        this.hSs.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hSs.start();
    }

    private void cnC() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hSn = new File(stringExtra);
            if (!this.hSn.exists()) {
                try {
                    this.hSn.createNewFile();
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
                this.hSv.setVisibility(4);
                break;
            case 1:
                this.hSv.setVisibility(4);
                i = 2;
                break;
            default:
                this.hSw.setVisibility(4);
                i = 0;
                break;
        }
        this.hSs.setMaskType(i, this);
        this.hSw.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnD() {
        this.hSs.getCameraControl().resume();
        cnG();
        this.hSo.setVisibility(0);
        this.hSq.setVisibility(4);
        this.hSp.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnE() {
        this.hSs.getCameraControl().pause();
        cnG();
        this.hSo.setVisibility(4);
        this.hSq.setVisibility(4);
        this.hSp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnF() {
        this.hSs.getCameraControl().pause();
        cnG();
        this.hSo.setVisibility(4);
        this.hSq.setVisibility(0);
        this.hSp.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnG() {
        if (this.hSs.getCameraControl().cnr() == 1) {
            this.hSr.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hSr.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnH() {
        this.hSs.getCameraControl().pause();
        cnG();
        cnI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnI() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hSn);
                    ((BitmapDrawable) CameraActivity.this.hSt.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.hTK;
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
                this.hSs.setOrientation(0);
                break;
        }
        this.hSo.setOrientation(i);
        this.hSs.setOrientation(i2);
        this.hSp.setOrientation(i);
        this.hSq.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.hSu.setFilePath(x(intent.getData()));
                cnE();
                return;
            }
            this.hSs.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hSs.getCameraControl().cnq();
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
        if (this.hSs != null && this.hSs.getCameraControl() != null) {
            this.hSs.getCameraControl().cnB();
        }
    }

    private void cnJ() {
        c.cnL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cnJ();
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iW(false);
        aVar.ov(R.string.request_permission_default_title);
        aVar.ow(R.string.request_permission_camera);
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
        aVar.bpc();
    }
}
