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
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.CameraView;
import com.baidu.webkit.sdk.PermissionRequest;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private OCRCameraLayout ilA;
    private OCRCameraLayout ilB;
    private ImageView ilC;
    private CameraView ilD;
    private ImageView ilE;
    private CropView ilF;
    private FrameOverlayView ilG;
    private MaskView ilH;
    private ImageView ilI;
    private File ily;
    private OCRCameraLayout ilz;
    private Handler handler = new Handler();
    private e ile = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cqC() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener ilJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ActivityCompat.checkSelfPermission(CameraActivity.this.getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0 && Build.VERSION.SDK_INT >= 16) {
                ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 801);
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            CameraActivity.this.startActivityForResult(intent, 100);
        }
    };
    private View.OnClickListener ilK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.ilD.getCameraControl().cqj() == 0) {
                CameraActivity.this.ilD.getCameraControl().wG(1);
            } else {
                CameraActivity.this.ilD.getCameraControl().wG(0);
            }
            CameraActivity.this.cqy();
        }
    };
    private View.OnClickListener ilL = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ilD.a(CameraActivity.this.ily, CameraActivity.this.ilN);
        }
    };
    private CameraView.b ilM = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void y(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.ily);
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
    private CameraView.b ilN = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void y(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.ilz.setVisibility(4);
                    if (CameraActivity.this.ilH.getMaskType() == 0) {
                        CameraActivity.this.ilF.setFilePath(CameraActivity.this.ily.getAbsolutePath());
                        CameraActivity.this.cqw();
                        return;
                    }
                    CameraActivity.this.ilE.setImageBitmap(bitmap);
                    CameraActivity.this.cqx();
                }
            });
        }
    };
    private View.OnClickListener ilO = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ilF.setFilePath(null);
            CameraActivity.this.cqv();
        }
    };
    private View.OnClickListener ilP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.ilH.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.ilH.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.ilG.getFrameRect();
                    break;
            }
            CameraActivity.this.ilE.setImageBitmap(CameraActivity.this.ilF.d(frameRect));
            CameraActivity.this.cqz();
        }
    };
    private View.OnClickListener ilQ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cqA();
        }
    };
    private View.OnClickListener ilR = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ilE.setImageBitmap(null);
            CameraActivity.this.cqv();
        }
    };
    private View.OnClickListener ilS = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ilF.wJ(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.ilz = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.ilB = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.ilD = (CameraView) findViewById(R.id.camera_view);
        this.ilD.getCameraControl().a(this.ile);
        this.ilC = (ImageView) findViewById(R.id.light_button);
        this.ilC.setOnClickListener(this.ilK);
        this.ilI = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.ilJ);
        this.ilI.setOnClickListener(this.ilL);
        this.ilE = (ImageView) findViewById(R.id.display_image_view);
        this.ilB.findViewById(R.id.confirm_button).setOnClickListener(this.ilQ);
        this.ilB.findViewById(R.id.cancel_button).setOnClickListener(this.ilR);
        findViewById(R.id.rotate_button).setOnClickListener(this.ilS);
        this.ilF = (CropView) findViewById(R.id.crop_view);
        this.ilA = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.ilG = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.ilA.findViewById(R.id.confirm_button).setOnClickListener(this.ilP);
        this.ilH = (MaskView) this.ilA.findViewById(R.id.crop_mask_view);
        this.ilA.findViewById(R.id.cancel_button).setOnClickListener(this.ilO);
        c(getResources().getConfiguration());
        cqu();
        this.ilD.setAutoPictureCallback(this.ilM);
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
        this.ilD.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ilD.start();
    }

    private void cqu() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.ily = new File(stringExtra);
            if (!this.ily.exists()) {
                try {
                    this.ily.createNewFile();
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
                this.ilG.setVisibility(4);
                break;
            case 1:
                this.ilG.setVisibility(4);
                i = 2;
                break;
            default:
                this.ilH.setVisibility(4);
                i = 0;
                break;
        }
        this.ilD.setMaskType(i, this);
        this.ilH.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqv() {
        this.ilD.getCameraControl().resume();
        cqy();
        this.ilz.setVisibility(0);
        this.ilB.setVisibility(4);
        this.ilA.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqw() {
        this.ilD.getCameraControl().pause();
        cqy();
        this.ilz.setVisibility(4);
        this.ilB.setVisibility(4);
        this.ilA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqx() {
        this.ilD.getCameraControl().pause();
        cqy();
        this.ilz.setVisibility(4);
        this.ilB.setVisibility(0);
        this.ilA.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqy() {
        if (this.ilD.getCameraControl().cqj() == 1) {
            this.ilC.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.ilC.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqz() {
        this.ilD.getCameraControl().pause();
        cqy();
        cqA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqA() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.ily);
                    ((BitmapDrawable) CameraActivity.this.ilE.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String D(Uri uri) {
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
                i = OCRCameraLayout.imW;
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
                this.ilD.setOrientation(0);
                break;
        }
        this.ilz.setOrientation(i);
        this.ilD.setOrientation(i2);
        this.ilA.setOrientation(i);
        this.ilB.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.ilF.setFilePath(D(intent.getData()));
                cqw();
                return;
            }
            this.ilD.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.ilD.getCameraControl().cqi();
                    break;
                } else {
                    aq(this);
                    break;
                }
                break;
            case 801:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.storage_permission_required);
                    break;
                }
                break;
        }
        if (this.ilD != null && this.ilD.getCameraControl() != null) {
            this.ilD.getCameraControl().cqt();
        }
    }

    private void cqB() {
        c.cqD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cqB();
    }

    public void aq(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jE(false);
        aVar.nt(R.string.request_permission_default_title);
        aVar.nu(R.string.request_permission_camera);
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
        aVar.bqe();
    }
}
