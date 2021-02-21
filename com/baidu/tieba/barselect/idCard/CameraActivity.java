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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private FrameOverlayView irA;
    private MaskView irB;
    private ImageView irC;
    private OCRCameraLayout irt;
    private OCRCameraLayout iru;
    private OCRCameraLayout irv;
    private ImageView irw;
    private CameraView irx;
    private ImageView iry;
    private CropView irz;
    private File outputFile;
    private Handler handler = new Handler();
    private e ira = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean crT() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener irD = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener irE = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.irx.getCameraControl().crA() == 0) {
                CameraActivity.this.irx.getCameraControl().wR(1);
            } else {
                CameraActivity.this.irx.getCameraControl().wR(0);
            }
            CameraActivity.this.crP();
        }
    };
    private View.OnClickListener irF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irx.a(CameraActivity.this.outputFile, CameraActivity.this.irH);
        }
    };
    private CameraView.b irG = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.outputFile);
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
    private CameraView.b irH = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.irt.setVisibility(4);
                    if (CameraActivity.this.irB.getMaskType() == 0) {
                        CameraActivity.this.irz.setFilePath(CameraActivity.this.outputFile.getAbsolutePath());
                        CameraActivity.this.crN();
                        return;
                    }
                    CameraActivity.this.iry.setImageBitmap(bitmap);
                    CameraActivity.this.crO();
                }
            });
        }
    };
    private View.OnClickListener irI = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irz.setFilePath(null);
            CameraActivity.this.crM();
        }
    };
    private View.OnClickListener irJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.irB.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.irB.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.irA.getFrameRect();
                    break;
            }
            CameraActivity.this.iry.setImageBitmap(CameraActivity.this.irz.d(frameRect));
            CameraActivity.this.crQ();
        }
    };
    private View.OnClickListener irK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.crR();
        }
    };
    private View.OnClickListener irL = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iry.setImageBitmap(null);
            CameraActivity.this.crM();
        }
    };
    private View.OnClickListener irM = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irz.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.irt = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.irv = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.irx = (CameraView) findViewById(R.id.camera_view);
        this.irx.getCameraControl().a(this.ira);
        this.irw = (ImageView) findViewById(R.id.light_button);
        this.irw.setOnClickListener(this.irE);
        this.irC = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.irD);
        this.irC.setOnClickListener(this.irF);
        this.iry = (ImageView) findViewById(R.id.display_image_view);
        this.irv.findViewById(R.id.confirm_button).setOnClickListener(this.irK);
        this.irv.findViewById(R.id.cancel_button).setOnClickListener(this.irL);
        findViewById(R.id.rotate_button).setOnClickListener(this.irM);
        this.irz = (CropView) findViewById(R.id.crop_view);
        this.iru = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.irA = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.iru.findViewById(R.id.confirm_button).setOnClickListener(this.irJ);
        this.irB = (MaskView) this.iru.findViewById(R.id.crop_mask_view);
        this.iru.findViewById(R.id.cancel_button).setOnClickListener(this.irI);
        c(getResources().getConfiguration());
        crL();
        this.irx.setAutoPictureCallback(this.irG);
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
        this.irx.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.irx.start();
    }

    private void crL() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.outputFile = new File(stringExtra);
            if (!this.outputFile.exists()) {
                try {
                    this.outputFile.createNewFile();
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
                this.irA.setVisibility(4);
                break;
            case 1:
                this.irA.setVisibility(4);
                i = 2;
                break;
            default:
                this.irB.setVisibility(4);
                i = 0;
                break;
        }
        this.irx.setMaskType(i, this);
        this.irB.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crM() {
        this.irx.getCameraControl().resume();
        crP();
        this.irt.setVisibility(0);
        this.irv.setVisibility(4);
        this.iru.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crN() {
        this.irx.getCameraControl().pause();
        crP();
        this.irt.setVisibility(4);
        this.irv.setVisibility(4);
        this.iru.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        this.irx.getCameraControl().pause();
        crP();
        this.irt.setVisibility(4);
        this.irv.setVisibility(0);
        this.iru.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crP() {
        if (this.irx.getCameraControl().crA() == 1) {
            this.irw.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.irw.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crQ() {
        this.irx.getCameraControl().pause();
        crP();
        crR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crR() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.outputFile);
                    ((BitmapDrawable) CameraActivity.this.iry.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.isP;
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
                this.irx.setOrientation(0);
                break;
        }
        this.irt.setOrientation(i);
        this.irx.setOrientation(i2);
        this.iru.setOrientation(i);
        this.irv.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.irz.setFilePath(D(intent.getData()));
                crN();
                return;
            }
            this.irx.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.irx.getCameraControl().crz();
                    break;
                } else {
                    ak(this);
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
        if (this.irx != null && this.irx.getCameraControl() != null) {
            this.irx.getCameraControl().crK();
        }
    }

    private void crS() {
        c.crU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        crS();
    }

    public void ak(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jG(false);
        aVar.nw(R.string.request_permission_default_title);
        aVar.nx(R.string.request_permission_camera);
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
        aVar.bqx();
    }
}
