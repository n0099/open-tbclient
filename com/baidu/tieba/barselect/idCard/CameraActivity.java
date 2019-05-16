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
    private File erO;
    private OCRCameraLayout erP;
    private OCRCameraLayout erQ;
    private OCRCameraLayout erR;
    private ImageView erS;
    private CameraView erT;
    private ImageView erU;
    private CropView erV;
    private FrameOverlayView erW;
    private MaskView erX;
    private ImageView erY;
    private Handler handler = new Handler();
    private e eru = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean aXl() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    };
    private View.OnClickListener erZ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener esa = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.erT.getCameraControl().aWT() == 0) {
                CameraActivity.this.erT.getCameraControl().pe(1);
            } else {
                CameraActivity.this.erT.getCameraControl().pe(0);
            }
            CameraActivity.this.aXh();
        }
    };
    private View.OnClickListener esb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.erT.a(CameraActivity.this.erO, CameraActivity.this.esd);
        }
    };
    private CameraView.b esc = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.erO);
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
    private CameraView.b esd = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.erP.setVisibility(4);
                    if (CameraActivity.this.erX.getMaskType() == 0) {
                        CameraActivity.this.erV.setFilePath(CameraActivity.this.erO.getAbsolutePath());
                        CameraActivity.this.aXf();
                        return;
                    }
                    CameraActivity.this.erU.setImageBitmap(bitmap);
                    CameraActivity.this.aXg();
                }
            });
        }
    };
    private View.OnClickListener ese = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.erV.setFilePath(null);
            CameraActivity.this.aXe();
        }
    };
    private View.OnClickListener esf = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.erX.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.erX.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.erW.getFrameRect();
                    break;
            }
            CameraActivity.this.erU.setImageBitmap(CameraActivity.this.erV.l(frameRect));
            CameraActivity.this.aXi();
        }
    };
    private View.OnClickListener esg = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.aXj();
        }
    };
    private View.OnClickListener esh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.erU.setImageBitmap(null);
            CameraActivity.this.aXe();
        }
    };
    private View.OnClickListener esi = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.erV.ph(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.erP = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.erR = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.erT = (CameraView) findViewById(R.id.camera_view);
        this.erT.getCameraControl().a(this.eru);
        this.erS = (ImageView) findViewById(R.id.light_button);
        this.erS.setOnClickListener(this.esa);
        this.erY = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.erZ);
        this.erY.setOnClickListener(this.esb);
        this.erU = (ImageView) findViewById(R.id.display_image_view);
        this.erR.findViewById(R.id.confirm_button).setOnClickListener(this.esg);
        this.erR.findViewById(R.id.cancel_button).setOnClickListener(this.esh);
        findViewById(R.id.rotate_button).setOnClickListener(this.esi);
        this.erV = (CropView) findViewById(R.id.crop_view);
        this.erQ = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.erW = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.erQ.findViewById(R.id.confirm_button).setOnClickListener(this.esf);
        this.erX = (MaskView) this.erQ.findViewById(R.id.crop_mask_view);
        this.erQ.findViewById(R.id.cancel_button).setOnClickListener(this.ese);
        b(getResources().getConfiguration());
        aXd();
        this.erT.setAutoPictureCallback(this.esc);
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
        this.erT.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.erT.start();
    }

    private void aXd() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.erO = new File(stringExtra);
            if (!this.erO.exists()) {
                try {
                    this.erO.createNewFile();
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
                this.erW.setVisibility(4);
                break;
            case 1:
                this.erW.setVisibility(4);
                i = 2;
                break;
            default:
                this.erX.setVisibility(4);
                i = 0;
                break;
        }
        this.erT.setMaskType(i, this);
        this.erX.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXe() {
        this.erT.getCameraControl().resume();
        aXh();
        this.erP.setVisibility(0);
        this.erR.setVisibility(4);
        this.erQ.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXf() {
        this.erT.getCameraControl().pause();
        aXh();
        this.erP.setVisibility(4);
        this.erR.setVisibility(4);
        this.erQ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXg() {
        this.erT.getCameraControl().pause();
        aXh();
        this.erP.setVisibility(4);
        this.erR.setVisibility(0);
        this.erQ.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXh() {
        if (this.erT.getCameraControl().aWT() == 1) {
            this.erS.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.erS.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXi() {
        this.erT.getCameraControl().pause();
        aXh();
        aXj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXj() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.erO);
                    ((BitmapDrawable) CameraActivity.this.erU.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.ORIENTATION_HORIZONTAL;
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
                this.erT.setOrientation(0);
                break;
        }
        this.erP.setOrientation(i);
        this.erT.setOrientation(i2);
        this.erQ.setOrientation(i);
        this.erR.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.erV.setFilePath(t(intent.getData()));
                aXf();
                return;
            }
            this.erT.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.erT.getCameraControl().aWS();
                    break;
                } else {
                    ah(this);
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
        if (this.erT != null && this.erT.getCameraControl() != null) {
            this.erT.getCameraControl().aXc();
        }
    }

    private void aXk() {
        c.aXm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aXk();
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dN(false);
        aVar.hn(R.string.request_permission_default_title);
        aVar.ho(R.string.request_permission_camera);
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
        aVar.afG();
    }
}
