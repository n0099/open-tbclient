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
    private ImageView gLA;
    private CameraView gLB;
    private ImageView gLC;
    private CropView gLD;
    private FrameOverlayView gLE;
    private MaskView gLF;
    private ImageView gLG;
    private File gLw;
    private OCRCameraLayout gLx;
    private OCRCameraLayout gLy;
    private OCRCameraLayout gLz;
    private Handler handler = new Handler();
    private e gLd = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean bNT() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener gLH = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener gLI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.gLB.getCameraControl().bNA() == 0) {
                CameraActivity.this.gLB.getCameraControl().sE(1);
            } else {
                CameraActivity.this.gLB.getCameraControl().sE(0);
            }
            CameraActivity.this.bNP();
        }
    };
    private View.OnClickListener gLJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gLB.a(CameraActivity.this.gLw, CameraActivity.this.gLL);
        }
    };
    private CameraView.b gLK = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void u(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.gLw);
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
    private CameraView.b gLL = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void u(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.gLx.setVisibility(4);
                    if (CameraActivity.this.gLF.getMaskType() == 0) {
                        CameraActivity.this.gLD.setFilePath(CameraActivity.this.gLw.getAbsolutePath());
                        CameraActivity.this.bNN();
                        return;
                    }
                    CameraActivity.this.gLC.setImageBitmap(bitmap);
                    CameraActivity.this.bNO();
                }
            });
        }
    };
    private View.OnClickListener gLM = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gLD.setFilePath(null);
            CameraActivity.this.bNM();
        }
    };
    private View.OnClickListener gLN = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.gLF.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.gLF.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.gLE.getFrameRect();
                    break;
            }
            CameraActivity.this.gLC.setImageBitmap(CameraActivity.this.gLD.e(frameRect));
            CameraActivity.this.bNQ();
        }
    };
    private View.OnClickListener gLO = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.bNR();
        }
    };
    private View.OnClickListener gLP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gLC.setImageBitmap(null);
            CameraActivity.this.bNM();
        }
    };
    private View.OnClickListener gLQ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.gLD.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.gLx = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.gLz = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.gLB = (CameraView) findViewById(R.id.camera_view);
        this.gLB.getCameraControl().a(this.gLd);
        this.gLA = (ImageView) findViewById(R.id.light_button);
        this.gLA.setOnClickListener(this.gLI);
        this.gLG = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.gLH);
        this.gLG.setOnClickListener(this.gLJ);
        this.gLC = (ImageView) findViewById(R.id.display_image_view);
        this.gLz.findViewById(R.id.confirm_button).setOnClickListener(this.gLO);
        this.gLz.findViewById(R.id.cancel_button).setOnClickListener(this.gLP);
        findViewById(R.id.rotate_button).setOnClickListener(this.gLQ);
        this.gLD = (CropView) findViewById(R.id.crop_view);
        this.gLy = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.gLE = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.gLy.findViewById(R.id.confirm_button).setOnClickListener(this.gLN);
        this.gLF = (MaskView) this.gLy.findViewById(R.id.crop_mask_view);
        this.gLy.findViewById(R.id.cancel_button).setOnClickListener(this.gLM);
        c(getResources().getConfiguration());
        bNL();
        this.gLB.setAutoPictureCallback(this.gLK);
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
        this.gLB.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gLB.start();
    }

    private void bNL() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.gLw = new File(stringExtra);
            if (!this.gLw.exists()) {
                try {
                    this.gLw.createNewFile();
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
                this.gLE.setVisibility(4);
                break;
            case 1:
                this.gLE.setVisibility(4);
                i = 2;
                break;
            default:
                this.gLF.setVisibility(4);
                i = 0;
                break;
        }
        this.gLB.setMaskType(i, this);
        this.gLF.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNM() {
        this.gLB.getCameraControl().resume();
        bNP();
        this.gLx.setVisibility(0);
        this.gLz.setVisibility(4);
        this.gLy.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNN() {
        this.gLB.getCameraControl().pause();
        bNP();
        this.gLx.setVisibility(4);
        this.gLz.setVisibility(4);
        this.gLy.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNO() {
        this.gLB.getCameraControl().pause();
        bNP();
        this.gLx.setVisibility(4);
        this.gLz.setVisibility(0);
        this.gLy.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNP() {
        if (this.gLB.getCameraControl().bNA() == 1) {
            this.gLA.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.gLA.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNQ() {
        this.gLB.getCameraControl().pause();
        bNP();
        bNR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNR() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.gLw);
                    ((BitmapDrawable) CameraActivity.this.gLC.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String w(Uri uri) {
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
                i = OCRCameraLayout.gMT;
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
                this.gLB.setOrientation(0);
                break;
        }
        this.gLx.setOrientation(i);
        this.gLB.setOrientation(i2);
        this.gLy.setOrientation(i);
        this.gLz.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.gLD.setFilePath(w(intent.getData()));
                bNN();
                return;
            }
            this.gLB.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.gLB.getCameraControl().bNz();
                    break;
                } else {
                    ah(this);
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
        if (this.gLB != null && this.gLB.getCameraControl() != null) {
            this.gLB.getCameraControl().bNK();
        }
    }

    private void bNS() {
        c.bNU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bNS();
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.hg(false);
        aVar.kS(R.string.request_permission_default_title);
        aVar.kT(R.string.request_permission_camera);
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
        aVar.aUN();
    }
}
