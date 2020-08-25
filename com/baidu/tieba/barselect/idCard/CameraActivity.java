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
/* loaded from: classes15.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File hdU;
    private OCRCameraLayout hdV;
    private OCRCameraLayout hdW;
    private OCRCameraLayout hdX;
    private ImageView hdY;
    private CameraView hdZ;
    private ImageView hea;
    private CropView heb;
    private FrameOverlayView hec;
    private MaskView hed;
    private ImageView hee;
    private Handler handler = new Handler();
    private e hdA = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cbq() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hef = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener heg = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hdZ.getCameraControl().caW() == 0) {
                CameraActivity.this.hdZ.getCameraControl().vl(1);
            } else {
                CameraActivity.this.hdZ.getCameraControl().vl(0);
            }
            CameraActivity.this.cbm();
        }
    };
    private View.OnClickListener heh = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hdZ.a(CameraActivity.this.hdU, CameraActivity.this.hej);
        }
    };
    private CameraView.b hei = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hdU);
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
    private CameraView.b hej = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hdV.setVisibility(4);
                    if (CameraActivity.this.hed.getMaskType() == 0) {
                        CameraActivity.this.heb.setFilePath(CameraActivity.this.hdU.getAbsolutePath());
                        CameraActivity.this.cbk();
                        return;
                    }
                    CameraActivity.this.hea.setImageBitmap(bitmap);
                    CameraActivity.this.cbl();
                }
            });
        }
    };
    private View.OnClickListener hek = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.heb.setFilePath(null);
            CameraActivity.this.cbj();
        }
    };
    private View.OnClickListener hel = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.hed.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.hed.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.hec.getFrameRect();
                    break;
            }
            CameraActivity.this.hea.setImageBitmap(CameraActivity.this.heb.e(frameRect));
            CameraActivity.this.cbn();
        }
    };
    private View.OnClickListener hem = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cbo();
        }
    };
    private View.OnClickListener hen = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hea.setImageBitmap(null);
            CameraActivity.this.cbj();
        }
    };
    private View.OnClickListener heo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.heb.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hdV = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.hdX = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hdZ = (CameraView) findViewById(R.id.camera_view);
        this.hdZ.getCameraControl().a(this.hdA);
        this.hdY = (ImageView) findViewById(R.id.light_button);
        this.hdY.setOnClickListener(this.heg);
        this.hee = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hef);
        this.hee.setOnClickListener(this.heh);
        this.hea = (ImageView) findViewById(R.id.display_image_view);
        this.hdX.findViewById(R.id.confirm_button).setOnClickListener(this.hem);
        this.hdX.findViewById(R.id.cancel_button).setOnClickListener(this.hen);
        findViewById(R.id.rotate_button).setOnClickListener(this.heo);
        this.heb = (CropView) findViewById(R.id.crop_view);
        this.hdW = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.hec = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hdW.findViewById(R.id.confirm_button).setOnClickListener(this.hel);
        this.hed = (MaskView) this.hdW.findViewById(R.id.crop_mask_view);
        this.hdW.findViewById(R.id.cancel_button).setOnClickListener(this.hek);
        c(getResources().getConfiguration());
        cbi();
        this.hdZ.setAutoPictureCallback(this.hei);
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
        this.hdZ.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hdZ.start();
    }

    private void cbi() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hdU = new File(stringExtra);
            if (!this.hdU.exists()) {
                try {
                    this.hdU.createNewFile();
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
                this.hec.setVisibility(4);
                break;
            case 1:
                this.hec.setVisibility(4);
                i = 2;
                break;
            default:
                this.hed.setVisibility(4);
                i = 0;
                break;
        }
        this.hdZ.setMaskType(i, this);
        this.hed.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbj() {
        this.hdZ.getCameraControl().resume();
        cbm();
        this.hdV.setVisibility(0);
        this.hdX.setVisibility(4);
        this.hdW.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        this.hdZ.getCameraControl().pause();
        cbm();
        this.hdV.setVisibility(4);
        this.hdX.setVisibility(4);
        this.hdW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbl() {
        this.hdZ.getCameraControl().pause();
        cbm();
        this.hdV.setVisibility(4);
        this.hdX.setVisibility(0);
        this.hdW.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbm() {
        if (this.hdZ.getCameraControl().caW() == 1) {
            this.hdY.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hdY.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbn() {
        this.hdZ.getCameraControl().pause();
        cbm();
        cbo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbo() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hdU);
                    ((BitmapDrawable) CameraActivity.this.hea.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.hfs;
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
                this.hdZ.setOrientation(0);
                break;
        }
        this.hdV.setOrientation(i);
        this.hdZ.setOrientation(i2);
        this.hdW.setOrientation(i);
        this.hdX.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.heb.setFilePath(w(intent.getData()));
                cbk();
                return;
            }
            this.hdZ.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hdZ.getCameraControl().caV();
                    break;
                } else {
                    aj(this);
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
        if (this.hdZ != null && this.hdZ.getCameraControl() != null) {
            this.hdZ.getCameraControl().cbh();
        }
    }

    private void cbp() {
        c.cbr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cbp();
    }

    public void aj(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.ig(false);
        aVar.ns(R.string.request_permission_default_title);
        aVar.nt(R.string.request_permission_camera);
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
        aVar.bhg();
    }
}
