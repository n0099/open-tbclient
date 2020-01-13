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
/* loaded from: classes6.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File fBE;
    private OCRCameraLayout fBF;
    private OCRCameraLayout fBG;
    private OCRCameraLayout fBH;
    private ImageView fBI;
    private CameraView fBJ;
    private ImageView fBK;
    private CropView fBL;
    private FrameOverlayView fBM;
    private MaskView fBN;
    private ImageView fBO;
    private Handler handler = new Handler();
    private e fBk = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean bsX() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener fBP = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener fBQ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.fBJ.getCameraControl().bsF() == 0) {
                CameraActivity.this.fBJ.getCameraControl().ra(1);
            } else {
                CameraActivity.this.fBJ.getCameraControl().ra(0);
            }
            CameraActivity.this.bsT();
        }
    };
    private View.OnClickListener fBR = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fBJ.a(CameraActivity.this.fBE, CameraActivity.this.fBT);
        }
    };
    private CameraView.b fBS = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fBE);
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
    private CameraView.b fBT = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.fBF.setVisibility(4);
                    if (CameraActivity.this.fBN.getMaskType() == 0) {
                        CameraActivity.this.fBL.setFilePath(CameraActivity.this.fBE.getAbsolutePath());
                        CameraActivity.this.bsR();
                        return;
                    }
                    CameraActivity.this.fBK.setImageBitmap(bitmap);
                    CameraActivity.this.bsS();
                }
            });
        }
    };
    private View.OnClickListener fBU = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fBL.setFilePath(null);
            CameraActivity.this.bsQ();
        }
    };
    private View.OnClickListener fBV = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.fBN.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.fBN.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.fBM.getFrameRect();
                    break;
            }
            CameraActivity.this.fBK.setImageBitmap(CameraActivity.this.fBL.e(frameRect));
            CameraActivity.this.bsU();
        }
    };
    private View.OnClickListener fBW = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.bsV();
        }
    };
    private View.OnClickListener fBX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fBK.setImageBitmap(null);
            CameraActivity.this.bsQ();
        }
    };
    private View.OnClickListener fBY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fBL.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.fBF = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.fBH = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.fBJ = (CameraView) findViewById(R.id.camera_view);
        this.fBJ.getCameraControl().a(this.fBk);
        this.fBI = (ImageView) findViewById(R.id.light_button);
        this.fBI.setOnClickListener(this.fBQ);
        this.fBO = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.fBP);
        this.fBO.setOnClickListener(this.fBR);
        this.fBK = (ImageView) findViewById(R.id.display_image_view);
        this.fBH.findViewById(R.id.confirm_button).setOnClickListener(this.fBW);
        this.fBH.findViewById(R.id.cancel_button).setOnClickListener(this.fBX);
        findViewById(R.id.rotate_button).setOnClickListener(this.fBY);
        this.fBL = (CropView) findViewById(R.id.crop_view);
        this.fBG = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.fBM = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.fBG.findViewById(R.id.confirm_button).setOnClickListener(this.fBV);
        this.fBN = (MaskView) this.fBG.findViewById(R.id.crop_mask_view);
        this.fBG.findViewById(R.id.cancel_button).setOnClickListener(this.fBU);
        b(getResources().getConfiguration());
        bsP();
        this.fBJ.setAutoPictureCallback(this.fBS);
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
        this.fBJ.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fBJ.start();
    }

    private void bsP() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.fBE = new File(stringExtra);
            if (!this.fBE.exists()) {
                try {
                    this.fBE.createNewFile();
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
                this.fBM.setVisibility(4);
                break;
            case 1:
                this.fBM.setVisibility(4);
                i = 2;
                break;
            default:
                this.fBN.setVisibility(4);
                i = 0;
                break;
        }
        this.fBJ.setMaskType(i, this);
        this.fBN.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsQ() {
        this.fBJ.getCameraControl().resume();
        bsT();
        this.fBF.setVisibility(0);
        this.fBH.setVisibility(4);
        this.fBG.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsR() {
        this.fBJ.getCameraControl().pause();
        bsT();
        this.fBF.setVisibility(4);
        this.fBH.setVisibility(4);
        this.fBG.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsS() {
        this.fBJ.getCameraControl().pause();
        bsT();
        this.fBF.setVisibility(4);
        this.fBH.setVisibility(0);
        this.fBG.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (this.fBJ.getCameraControl().bsF() == 1) {
            this.fBI.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.fBI.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        this.fBJ.getCameraControl().pause();
        bsT();
        bsV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsV() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fBE);
                    ((BitmapDrawable) CameraActivity.this.fBK.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String s(Uri uri) {
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
                i = OCRCameraLayout.fDb;
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
                this.fBJ.setOrientation(0);
                break;
        }
        this.fBF.setOrientation(i);
        this.fBJ.setOrientation(i2);
        this.fBG.setOrientation(i);
        this.fBH.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.fBL.setFilePath(s(intent.getData()));
                bsR();
                return;
            }
            this.fBJ.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.fBJ.getCameraControl().bsE();
                    break;
                } else {
                    ai(this);
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
        if (this.fBJ != null && this.fBJ.getCameraControl() != null) {
            this.fBJ.getCameraControl().bsO();
        }
    }

    private void bsW() {
        c.bsY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bsW();
    }

    public void ai(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fA(false);
        aVar.jE(R.string.request_permission_default_title);
        aVar.jF(R.string.request_permission_camera);
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
        aVar.aCp();
    }
}
