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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.idCard.CameraView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File ewM;
    private OCRCameraLayout ewN;
    private OCRCameraLayout ewO;
    private OCRCameraLayout ewP;
    private ImageView ewQ;
    private CameraView ewR;
    private ImageView ewS;
    private CropView ewT;
    private FrameOverlayView ewU;
    private MaskView ewV;
    private ImageView ewW;
    private Handler handler = new Handler();
    private e ews = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean aZl() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    };
    private View.OnClickListener ewX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener ewY = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.ewR.getCameraControl().aYS() == 0) {
                CameraActivity.this.ewR.getCameraControl().pv(1);
            } else {
                CameraActivity.this.ewR.getCameraControl().pv(0);
            }
            CameraActivity.this.aZh();
        }
    };
    private View.OnClickListener ewZ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ewR.a(CameraActivity.this.ewM, CameraActivity.this.exb);
        }
    };
    private CameraView.b exa = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.ewM);
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
    private CameraView.b exb = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.ewN.setVisibility(4);
                    if (CameraActivity.this.ewV.getMaskType() == 0) {
                        CameraActivity.this.ewT.setFilePath(CameraActivity.this.ewM.getAbsolutePath());
                        CameraActivity.this.aZf();
                        return;
                    }
                    CameraActivity.this.ewS.setImageBitmap(bitmap);
                    CameraActivity.this.aZg();
                }
            });
        }
    };
    private View.OnClickListener exc = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ewT.setFilePath(null);
            CameraActivity.this.aZe();
        }
    };
    private View.OnClickListener exd = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.ewV.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.ewV.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.ewU.getFrameRect();
                    break;
            }
            CameraActivity.this.ewS.setImageBitmap(CameraActivity.this.ewT.l(frameRect));
            CameraActivity.this.aZi();
        }
    };
    private View.OnClickListener exe = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.aZj();
        }
    };
    private View.OnClickListener exf = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ewS.setImageBitmap(null);
            CameraActivity.this.aZe();
        }
    };
    private View.OnClickListener exg = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ewT.py(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.ewN = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.ewP = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.ewR = (CameraView) findViewById(R.id.camera_view);
        this.ewR.getCameraControl().a(this.ews);
        this.ewQ = (ImageView) findViewById(R.id.light_button);
        this.ewQ.setOnClickListener(this.ewY);
        this.ewW = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.ewX);
        this.ewW.setOnClickListener(this.ewZ);
        this.ewS = (ImageView) findViewById(R.id.display_image_view);
        this.ewP.findViewById(R.id.confirm_button).setOnClickListener(this.exe);
        this.ewP.findViewById(R.id.cancel_button).setOnClickListener(this.exf);
        findViewById(R.id.rotate_button).setOnClickListener(this.exg);
        this.ewT = (CropView) findViewById(R.id.crop_view);
        this.ewO = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.ewU = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.ewO.findViewById(R.id.confirm_button).setOnClickListener(this.exd);
        this.ewV = (MaskView) this.ewO.findViewById(R.id.crop_mask_view);
        this.ewO.findViewById(R.id.cancel_button).setOnClickListener(this.exc);
        b(getResources().getConfiguration());
        aZd();
        this.ewR.setAutoPictureCallback(this.exa);
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
        this.ewR.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ewR.start();
    }

    private void aZd() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.ewM = new File(stringExtra);
            if (!this.ewM.exists()) {
                try {
                    this.ewM.createNewFile();
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
                this.ewU.setVisibility(4);
                break;
            case 1:
                this.ewU.setVisibility(4);
                i = 2;
                break;
            default:
                this.ewV.setVisibility(4);
                i = 0;
                break;
        }
        this.ewR.setMaskType(i, this);
        this.ewV.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZe() {
        this.ewR.getCameraControl().resume();
        aZh();
        this.ewN.setVisibility(0);
        this.ewP.setVisibility(4);
        this.ewO.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZf() {
        this.ewR.getCameraControl().pause();
        aZh();
        this.ewN.setVisibility(4);
        this.ewP.setVisibility(4);
        this.ewO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZg() {
        this.ewR.getCameraControl().pause();
        aZh();
        this.ewN.setVisibility(4);
        this.ewP.setVisibility(0);
        this.ewO.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZh() {
        if (this.ewR.getCameraControl().aYS() == 1) {
            this.ewQ.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.ewQ.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZi() {
        this.ewR.getCameraControl().pause();
        aZh();
        aZj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZj() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.ewM);
                    ((BitmapDrawable) CameraActivity.this.ewS.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.eyl;
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
                this.ewR.setOrientation(0);
                break;
        }
        this.ewN.setOrientation(i);
        this.ewR.setOrientation(i2);
        this.ewO.setOrientation(i);
        this.ewP.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.ewT.setFilePath(t(intent.getData()));
                aZf();
                return;
            }
            this.ewR.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.ewR.getCameraControl().aYR();
                    break;
                } else {
                    ak(this);
                    break;
                }
                break;
            case 801:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.storage_permission_required);
                    break;
                }
                break;
        }
        if (this.ewR != null && this.ewR.getCameraControl() != null) {
            this.ewR.getCameraControl().aZc();
        }
    }

    private void aZk() {
        c.aZm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aZk();
    }

    public void ak(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dR(false);
        aVar.ht(R.string.request_permission_default_title);
        aVar.hu(R.string.request_permission_camera);
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
        aVar.agI();
    }
}
