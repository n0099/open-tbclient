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
    private File ewT;
    private OCRCameraLayout ewU;
    private OCRCameraLayout ewV;
    private OCRCameraLayout ewW;
    private ImageView ewX;
    private CameraView ewY;
    private ImageView ewZ;
    private CropView exa;
    private FrameOverlayView exb;
    private MaskView exc;
    private ImageView exd;
    private Handler handler = new Handler();
    private e ewz = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean aZn() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{"android.permission.CAMERA"}, 800);
            return false;
        }
    };
    private View.OnClickListener exe = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener exf = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.ewY.getCameraControl().aYU() == 0) {
                CameraActivity.this.ewY.getCameraControl().pw(1);
            } else {
                CameraActivity.this.ewY.getCameraControl().pw(0);
            }
            CameraActivity.this.aZj();
        }
    };
    private View.OnClickListener exg = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ewY.a(CameraActivity.this.ewT, CameraActivity.this.exi);
        }
    };
    private CameraView.b exh = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.ewT);
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
    private CameraView.b exi = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void t(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.ewU.setVisibility(4);
                    if (CameraActivity.this.exc.getMaskType() == 0) {
                        CameraActivity.this.exa.setFilePath(CameraActivity.this.ewT.getAbsolutePath());
                        CameraActivity.this.aZh();
                        return;
                    }
                    CameraActivity.this.ewZ.setImageBitmap(bitmap);
                    CameraActivity.this.aZi();
                }
            });
        }
    };
    private View.OnClickListener exj = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.exa.setFilePath(null);
            CameraActivity.this.aZg();
        }
    };
    private View.OnClickListener exk = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.exc.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.exc.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.exb.getFrameRect();
                    break;
            }
            CameraActivity.this.ewZ.setImageBitmap(CameraActivity.this.exa.l(frameRect));
            CameraActivity.this.aZk();
        }
    };
    private View.OnClickListener exl = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.aZl();
        }
    };
    private View.OnClickListener exm = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ewZ.setImageBitmap(null);
            CameraActivity.this.aZg();
        }
    };
    private View.OnClickListener exn = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.exa.pz(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.ewU = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.ewW = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.ewY = (CameraView) findViewById(R.id.camera_view);
        this.ewY.getCameraControl().a(this.ewz);
        this.ewX = (ImageView) findViewById(R.id.light_button);
        this.ewX.setOnClickListener(this.exf);
        this.exd = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.exe);
        this.exd.setOnClickListener(this.exg);
        this.ewZ = (ImageView) findViewById(R.id.display_image_view);
        this.ewW.findViewById(R.id.confirm_button).setOnClickListener(this.exl);
        this.ewW.findViewById(R.id.cancel_button).setOnClickListener(this.exm);
        findViewById(R.id.rotate_button).setOnClickListener(this.exn);
        this.exa = (CropView) findViewById(R.id.crop_view);
        this.ewV = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.exb = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.ewV.findViewById(R.id.confirm_button).setOnClickListener(this.exk);
        this.exc = (MaskView) this.ewV.findViewById(R.id.crop_mask_view);
        this.ewV.findViewById(R.id.cancel_button).setOnClickListener(this.exj);
        b(getResources().getConfiguration());
        aZf();
        this.ewY.setAutoPictureCallback(this.exh);
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
        this.ewY.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ewY.start();
    }

    private void aZf() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.ewT = new File(stringExtra);
            if (!this.ewT.exists()) {
                try {
                    this.ewT.createNewFile();
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
                this.exb.setVisibility(4);
                break;
            case 1:
                this.exb.setVisibility(4);
                i = 2;
                break;
            default:
                this.exc.setVisibility(4);
                i = 0;
                break;
        }
        this.ewY.setMaskType(i, this);
        this.exc.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZg() {
        this.ewY.getCameraControl().resume();
        aZj();
        this.ewU.setVisibility(0);
        this.ewW.setVisibility(4);
        this.ewV.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZh() {
        this.ewY.getCameraControl().pause();
        aZj();
        this.ewU.setVisibility(4);
        this.ewW.setVisibility(4);
        this.ewV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZi() {
        this.ewY.getCameraControl().pause();
        aZj();
        this.ewU.setVisibility(4);
        this.ewW.setVisibility(0);
        this.ewV.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZj() {
        if (this.ewY.getCameraControl().aYU() == 1) {
            this.ewX.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.ewX.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZk() {
        this.ewY.getCameraControl().pause();
        aZj();
        aZl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZl() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.ewT);
                    ((BitmapDrawable) CameraActivity.this.ewZ.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.eyt;
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
                this.ewY.setOrientation(0);
                break;
        }
        this.ewU.setOrientation(i);
        this.ewY.setOrientation(i2);
        this.ewV.setOrientation(i);
        this.ewW.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.exa.setFilePath(t(intent.getData()));
                aZh();
                return;
            }
            this.ewY.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.ewY.getCameraControl().aYT();
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
        if (this.ewY != null && this.ewY.getCameraControl() != null) {
            this.ewY.getCameraControl().aZe();
        }
    }

    private void aZm() {
        c.aZo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aZm();
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
        aVar.agK();
    }
}
