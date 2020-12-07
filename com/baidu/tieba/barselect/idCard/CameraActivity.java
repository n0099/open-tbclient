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
/* loaded from: classes21.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File idK;
    private OCRCameraLayout idL;
    private OCRCameraLayout idM;
    private OCRCameraLayout idN;
    private ImageView idO;
    private CameraView idP;
    private ImageView idQ;
    private CropView idR;
    private FrameOverlayView idS;
    private MaskView idT;
    private ImageView idU;
    private Handler handler = new Handler();
    private e idn = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean crz() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener idV = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener idW = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.idP.getCameraControl().crg() == 0) {
                CameraActivity.this.idP.getCameraControl().ya(1);
            } else {
                CameraActivity.this.idP.getCameraControl().ya(0);
            }
            CameraActivity.this.crv();
        }
    };
    private View.OnClickListener idX = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.idP.a(CameraActivity.this.idK, CameraActivity.this.idZ);
        }
    };
    private CameraView.b idY = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.idK);
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
    private CameraView.b idZ = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.idL.setVisibility(4);
                    if (CameraActivity.this.idT.getMaskType() == 0) {
                        CameraActivity.this.idR.setFilePath(CameraActivity.this.idK.getAbsolutePath());
                        CameraActivity.this.crt();
                        return;
                    }
                    CameraActivity.this.idQ.setImageBitmap(bitmap);
                    CameraActivity.this.cru();
                }
            });
        }
    };
    private View.OnClickListener iea = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.idR.setFilePath(null);
            CameraActivity.this.crs();
        }
    };
    private View.OnClickListener ieb = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.idT.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.idT.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.idS.getFrameRect();
                    break;
            }
            CameraActivity.this.idQ.setImageBitmap(CameraActivity.this.idR.e(frameRect));
            CameraActivity.this.crw();
        }
    };
    private View.OnClickListener iec = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.crx();
        }
    };
    private View.OnClickListener ied = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.idQ.setImageBitmap(null);
            CameraActivity.this.crs();
        }
    };
    private View.OnClickListener iee = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.idR.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.idL = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.idN = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.idP = (CameraView) findViewById(R.id.camera_view);
        this.idP.getCameraControl().a(this.idn);
        this.idO = (ImageView) findViewById(R.id.light_button);
        this.idO.setOnClickListener(this.idW);
        this.idU = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.idV);
        this.idU.setOnClickListener(this.idX);
        this.idQ = (ImageView) findViewById(R.id.display_image_view);
        this.idN.findViewById(R.id.confirm_button).setOnClickListener(this.iec);
        this.idN.findViewById(R.id.cancel_button).setOnClickListener(this.ied);
        findViewById(R.id.rotate_button).setOnClickListener(this.iee);
        this.idR = (CropView) findViewById(R.id.crop_view);
        this.idM = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.idS = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.idM.findViewById(R.id.confirm_button).setOnClickListener(this.ieb);
        this.idT = (MaskView) this.idM.findViewById(R.id.crop_mask_view);
        this.idM.findViewById(R.id.cancel_button).setOnClickListener(this.iea);
        c(getResources().getConfiguration());
        crr();
        this.idP.setAutoPictureCallback(this.idY);
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
        this.idP.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.idP.start();
    }

    private void crr() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.idK = new File(stringExtra);
            if (!this.idK.exists()) {
                try {
                    this.idK.createNewFile();
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
                this.idS.setVisibility(4);
                break;
            case 1:
                this.idS.setVisibility(4);
                i = 2;
                break;
            default:
                this.idT.setVisibility(4);
                i = 0;
                break;
        }
        this.idP.setMaskType(i, this);
        this.idT.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crs() {
        this.idP.getCameraControl().resume();
        crv();
        this.idL.setVisibility(0);
        this.idN.setVisibility(4);
        this.idM.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crt() {
        this.idP.getCameraControl().pause();
        crv();
        this.idL.setVisibility(4);
        this.idN.setVisibility(4);
        this.idM.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cru() {
        this.idP.getCameraControl().pause();
        crv();
        this.idL.setVisibility(4);
        this.idN.setVisibility(0);
        this.idM.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crv() {
        if (this.idP.getCameraControl().crg() == 1) {
            this.idO.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.idO.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crw() {
        this.idP.getCameraControl().pause();
        crv();
        crx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crx() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.idK);
                    ((BitmapDrawable) CameraActivity.this.idQ.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String y(Uri uri) {
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
                i = OCRCameraLayout.ifh;
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
                this.idP.setOrientation(0);
                break;
        }
        this.idL.setOrientation(i);
        this.idP.setOrientation(i2);
        this.idM.setOrientation(i);
        this.idN.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.idR.setFilePath(y(intent.getData()));
                crt();
                return;
            }
            this.idP.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.idP.getCameraControl().crf();
                    break;
                } else {
                    ao(this);
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
        if (this.idP != null && this.idP.getCameraControl() != null) {
            this.idP.getCameraControl().crq();
        }
    }

    private void cry() {
        c.crA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cry();
    }

    public void ao(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jm(false);
        aVar.oP(R.string.request_permission_default_title);
        aVar.oQ(R.string.request_permission_camera);
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
        aVar.brv();
    }
}
