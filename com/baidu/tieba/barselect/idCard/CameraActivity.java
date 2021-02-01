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
    private OCRCameraLayout irf;
    private OCRCameraLayout irg;
    private OCRCameraLayout irh;
    private ImageView iri;
    private CameraView irj;
    private ImageView irk;
    private CropView irl;
    private FrameOverlayView irm;
    private MaskView irn;
    private ImageView iro;
    private File outputFile;
    private Handler handler = new Handler();
    private e iqM = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean crM() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener irp = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener irq = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.irj.getCameraControl().crt() == 0) {
                CameraActivity.this.irj.getCameraControl().wR(1);
            } else {
                CameraActivity.this.irj.getCameraControl().wR(0);
            }
            CameraActivity.this.crI();
        }
    };
    private View.OnClickListener irr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irj.a(CameraActivity.this.outputFile, CameraActivity.this.irt);
        }
    };
    private CameraView.b irs = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
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
    private CameraView.b irt = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.irf.setVisibility(4);
                    if (CameraActivity.this.irn.getMaskType() == 0) {
                        CameraActivity.this.irl.setFilePath(CameraActivity.this.outputFile.getAbsolutePath());
                        CameraActivity.this.crG();
                        return;
                    }
                    CameraActivity.this.irk.setImageBitmap(bitmap);
                    CameraActivity.this.crH();
                }
            });
        }
    };
    private View.OnClickListener iru = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irl.setFilePath(null);
            CameraActivity.this.crF();
        }
    };
    private View.OnClickListener irv = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.irn.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.irn.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.irm.getFrameRect();
                    break;
            }
            CameraActivity.this.irk.setImageBitmap(CameraActivity.this.irl.d(frameRect));
            CameraActivity.this.crJ();
        }
    };
    private View.OnClickListener irw = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.crK();
        }
    };
    private View.OnClickListener irx = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irk.setImageBitmap(null);
            CameraActivity.this.crF();
        }
    };
    private View.OnClickListener iry = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.irl.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.irf = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.irh = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.irj = (CameraView) findViewById(R.id.camera_view);
        this.irj.getCameraControl().a(this.iqM);
        this.iri = (ImageView) findViewById(R.id.light_button);
        this.iri.setOnClickListener(this.irq);
        this.iro = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.irp);
        this.iro.setOnClickListener(this.irr);
        this.irk = (ImageView) findViewById(R.id.display_image_view);
        this.irh.findViewById(R.id.confirm_button).setOnClickListener(this.irw);
        this.irh.findViewById(R.id.cancel_button).setOnClickListener(this.irx);
        findViewById(R.id.rotate_button).setOnClickListener(this.iry);
        this.irl = (CropView) findViewById(R.id.crop_view);
        this.irg = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.irm = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.irg.findViewById(R.id.confirm_button).setOnClickListener(this.irv);
        this.irn = (MaskView) this.irg.findViewById(R.id.crop_mask_view);
        this.irg.findViewById(R.id.cancel_button).setOnClickListener(this.iru);
        c(getResources().getConfiguration());
        crE();
        this.irj.setAutoPictureCallback(this.irs);
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
        this.irj.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.irj.start();
    }

    private void crE() {
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
                this.irm.setVisibility(4);
                break;
            case 1:
                this.irm.setVisibility(4);
                i = 2;
                break;
            default:
                this.irn.setVisibility(4);
                i = 0;
                break;
        }
        this.irj.setMaskType(i, this);
        this.irn.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crF() {
        this.irj.getCameraControl().resume();
        crI();
        this.irf.setVisibility(0);
        this.irh.setVisibility(4);
        this.irg.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crG() {
        this.irj.getCameraControl().pause();
        crI();
        this.irf.setVisibility(4);
        this.irh.setVisibility(4);
        this.irg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crH() {
        this.irj.getCameraControl().pause();
        crI();
        this.irf.setVisibility(4);
        this.irh.setVisibility(0);
        this.irg.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crI() {
        if (this.irj.getCameraControl().crt() == 1) {
            this.iri.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.iri.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crJ() {
        this.irj.getCameraControl().pause();
        crI();
        crK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crK() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.outputFile);
                    ((BitmapDrawable) CameraActivity.this.irk.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.isB;
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
                this.irj.setOrientation(0);
                break;
        }
        this.irf.setOrientation(i);
        this.irj.setOrientation(i2);
        this.irg.setOrientation(i);
        this.irh.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.irl.setFilePath(D(intent.getData()));
                crG();
                return;
            }
            this.irj.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.irj.getCameraControl().crs();
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
        if (this.irj != null && this.irj.getCameraControl() != null) {
            this.irj.getCameraControl().crD();
        }
    }

    private void crL() {
        c.crN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        crL();
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
