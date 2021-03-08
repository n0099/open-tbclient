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
/* loaded from: classes7.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private OCRCameraLayout itc;
    private OCRCameraLayout itd;
    private OCRCameraLayout ite;
    private ImageView itf;
    private CameraView itg;
    private ImageView ith;
    private CropView iti;
    private FrameOverlayView itj;
    private MaskView itk;
    private ImageView itl;
    private File outputFile;
    private Handler handler = new Handler();
    private e isJ = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean crZ() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener itm = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener itn = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.itg.getCameraControl().crG() == 0) {
                CameraActivity.this.itg.getCameraControl().wS(1);
            } else {
                CameraActivity.this.itg.getCameraControl().wS(0);
            }
            CameraActivity.this.crV();
        }
    };
    private View.OnClickListener ito = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.itg.a(CameraActivity.this.outputFile, CameraActivity.this.itq);
        }
    };
    private CameraView.b itp = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
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
    private CameraView.b itq = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.itc.setVisibility(4);
                    if (CameraActivity.this.itk.getMaskType() == 0) {
                        CameraActivity.this.iti.setFilePath(CameraActivity.this.outputFile.getAbsolutePath());
                        CameraActivity.this.crT();
                        return;
                    }
                    CameraActivity.this.ith.setImageBitmap(bitmap);
                    CameraActivity.this.crU();
                }
            });
        }
    };
    private View.OnClickListener itr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iti.setFilePath(null);
            CameraActivity.this.crS();
        }
    };
    private View.OnClickListener its = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.itk.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.itk.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.itj.getFrameRect();
                    break;
            }
            CameraActivity.this.ith.setImageBitmap(CameraActivity.this.iti.d(frameRect));
            CameraActivity.this.crW();
        }
    };
    private View.OnClickListener itt = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.crX();
        }
    };
    private View.OnClickListener itu = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ith.setImageBitmap(null);
            CameraActivity.this.crS();
        }
    };
    private View.OnClickListener itv = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iti.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.itc = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.ite = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.itg = (CameraView) findViewById(R.id.camera_view);
        this.itg.getCameraControl().a(this.isJ);
        this.itf = (ImageView) findViewById(R.id.light_button);
        this.itf.setOnClickListener(this.itn);
        this.itl = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.itm);
        this.itl.setOnClickListener(this.ito);
        this.ith = (ImageView) findViewById(R.id.display_image_view);
        this.ite.findViewById(R.id.confirm_button).setOnClickListener(this.itt);
        this.ite.findViewById(R.id.cancel_button).setOnClickListener(this.itu);
        findViewById(R.id.rotate_button).setOnClickListener(this.itv);
        this.iti = (CropView) findViewById(R.id.crop_view);
        this.itd = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.itj = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.itd.findViewById(R.id.confirm_button).setOnClickListener(this.its);
        this.itk = (MaskView) this.itd.findViewById(R.id.crop_mask_view);
        this.itd.findViewById(R.id.cancel_button).setOnClickListener(this.itr);
        c(getResources().getConfiguration());
        crR();
        this.itg.setAutoPictureCallback(this.itp);
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
        this.itg.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.itg.start();
    }

    private void crR() {
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
                this.itj.setVisibility(4);
                break;
            case 1:
                this.itj.setVisibility(4);
                i = 2;
                break;
            default:
                this.itk.setVisibility(4);
                i = 0;
                break;
        }
        this.itg.setMaskType(i, this);
        this.itk.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crS() {
        this.itg.getCameraControl().resume();
        crV();
        this.itc.setVisibility(0);
        this.ite.setVisibility(4);
        this.itd.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crT() {
        this.itg.getCameraControl().pause();
        crV();
        this.itc.setVisibility(4);
        this.ite.setVisibility(4);
        this.itd.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crU() {
        this.itg.getCameraControl().pause();
        crV();
        this.itc.setVisibility(4);
        this.ite.setVisibility(0);
        this.itd.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crV() {
        if (this.itg.getCameraControl().crG() == 1) {
            this.itf.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.itf.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crW() {
        this.itg.getCameraControl().pause();
        crV();
        crX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crX() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.outputFile);
                    ((BitmapDrawable) CameraActivity.this.ith.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.iuy;
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
                this.itg.setOrientation(0);
                break;
        }
        this.itc.setOrientation(i);
        this.itg.setOrientation(i2);
        this.itd.setOrientation(i);
        this.ite.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.iti.setFilePath(D(intent.getData()));
                crT();
                return;
            }
            this.itg.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.itg.getCameraControl().crF();
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
        if (this.itg != null && this.itg.getCameraControl() != null) {
            this.itg.getCameraControl().crQ();
        }
    }

    private void crY() {
        c.csa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        crY();
    }

    public void ak(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jG(false);
        aVar.nx(R.string.request_permission_default_title);
        aVar.ny(R.string.request_permission_camera);
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
        aVar.bqz();
    }
}
