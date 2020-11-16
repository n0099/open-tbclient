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
/* loaded from: classes20.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File hSN;
    private OCRCameraLayout hSO;
    private OCRCameraLayout hSP;
    private OCRCameraLayout hSQ;
    private ImageView hSR;
    private CameraView hSS;
    private ImageView hST;
    private CropView hSU;
    private FrameOverlayView hSV;
    private MaskView hSW;
    private ImageView hSX;
    private Handler handler = new Handler();
    private e hSt = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cnm() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hSY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener hSZ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hSS.getCameraControl().cmT() == 0) {
                CameraActivity.this.hSS.getCameraControl().xu(1);
            } else {
                CameraActivity.this.hSS.getCameraControl().xu(0);
            }
            CameraActivity.this.cni();
        }
    };
    private View.OnClickListener hTa = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSS.a(CameraActivity.this.hSN, CameraActivity.this.hTc);
        }
    };
    private CameraView.b hTb = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hSN);
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
    private CameraView.b hTc = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hSO.setVisibility(4);
                    if (CameraActivity.this.hSW.getMaskType() == 0) {
                        CameraActivity.this.hSU.setFilePath(CameraActivity.this.hSN.getAbsolutePath());
                        CameraActivity.this.cng();
                        return;
                    }
                    CameraActivity.this.hST.setImageBitmap(bitmap);
                    CameraActivity.this.cnh();
                }
            });
        }
    };
    private View.OnClickListener hTd = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSU.setFilePath(null);
            CameraActivity.this.cnf();
        }
    };
    private View.OnClickListener hTe = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.hSW.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.hSW.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.hSV.getFrameRect();
                    break;
            }
            CameraActivity.this.hST.setImageBitmap(CameraActivity.this.hSU.e(frameRect));
            CameraActivity.this.cnj();
        }
    };
    private View.OnClickListener hTf = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cnk();
        }
    };
    private View.OnClickListener hTg = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hST.setImageBitmap(null);
            CameraActivity.this.cnf();
        }
    };
    private View.OnClickListener hTh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hSU.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hSO = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.hSQ = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hSS = (CameraView) findViewById(R.id.camera_view);
        this.hSS.getCameraControl().a(this.hSt);
        this.hSR = (ImageView) findViewById(R.id.light_button);
        this.hSR.setOnClickListener(this.hSZ);
        this.hSX = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hSY);
        this.hSX.setOnClickListener(this.hTa);
        this.hST = (ImageView) findViewById(R.id.display_image_view);
        this.hSQ.findViewById(R.id.confirm_button).setOnClickListener(this.hTf);
        this.hSQ.findViewById(R.id.cancel_button).setOnClickListener(this.hTg);
        findViewById(R.id.rotate_button).setOnClickListener(this.hTh);
        this.hSU = (CropView) findViewById(R.id.crop_view);
        this.hSP = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.hSV = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hSP.findViewById(R.id.confirm_button).setOnClickListener(this.hTe);
        this.hSW = (MaskView) this.hSP.findViewById(R.id.crop_mask_view);
        this.hSP.findViewById(R.id.cancel_button).setOnClickListener(this.hTd);
        c(getResources().getConfiguration());
        cne();
        this.hSS.setAutoPictureCallback(this.hTb);
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
        this.hSS.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hSS.start();
    }

    private void cne() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hSN = new File(stringExtra);
            if (!this.hSN.exists()) {
                try {
                    this.hSN.createNewFile();
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
                this.hSV.setVisibility(4);
                break;
            case 1:
                this.hSV.setVisibility(4);
                i = 2;
                break;
            default:
                this.hSW.setVisibility(4);
                i = 0;
                break;
        }
        this.hSS.setMaskType(i, this);
        this.hSW.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnf() {
        this.hSS.getCameraControl().resume();
        cni();
        this.hSO.setVisibility(0);
        this.hSQ.setVisibility(4);
        this.hSP.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cng() {
        this.hSS.getCameraControl().pause();
        cni();
        this.hSO.setVisibility(4);
        this.hSQ.setVisibility(4);
        this.hSP.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnh() {
        this.hSS.getCameraControl().pause();
        cni();
        this.hSO.setVisibility(4);
        this.hSQ.setVisibility(0);
        this.hSP.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cni() {
        if (this.hSS.getCameraControl().cmT() == 1) {
            this.hSR.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hSR.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnj() {
        this.hSS.getCameraControl().pause();
        cni();
        cnk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnk() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hSN);
                    ((BitmapDrawable) CameraActivity.this.hST.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String y(Uri uri) {
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
                i = OCRCameraLayout.hUk;
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
                this.hSS.setOrientation(0);
                break;
        }
        this.hSO.setOrientation(i);
        this.hSS.setOrientation(i2);
        this.hSP.setOrientation(i);
        this.hSQ.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.hSU.setFilePath(y(intent.getData()));
                cng();
                return;
            }
            this.hSS.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hSS.getCameraControl().cmS();
                    break;
                } else {
                    an(this);
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
        if (this.hSS != null && this.hSS.getCameraControl() != null) {
            this.hSS.getCameraControl().cnd();
        }
    }

    private void cnl() {
        c.cnn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cnl();
    }

    public void an(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.iX(false);
        aVar.or(R.string.request_permission_default_title);
        aVar.os(R.string.request_permission_camera);
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
        aVar.bog();
    }
}
