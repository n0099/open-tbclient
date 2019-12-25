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
/* loaded from: classes5.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private CropView fyA;
    private FrameOverlayView fyB;
    private MaskView fyC;
    private ImageView fyD;
    private File fyt;
    private OCRCameraLayout fyu;
    private OCRCameraLayout fyv;
    private OCRCameraLayout fyw;
    private ImageView fyx;
    private CameraView fyy;
    private ImageView fyz;
    private Handler handler = new Handler();
    private e fxZ = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean brV() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener fyE = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener fyF = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.fyy.getCameraControl().brD() == 0) {
                CameraActivity.this.fyy.getCameraControl().qV(1);
            } else {
                CameraActivity.this.fyy.getCameraControl().qV(0);
            }
            CameraActivity.this.brR();
        }
    };
    private View.OnClickListener fyG = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fyy.a(CameraActivity.this.fyt, CameraActivity.this.fyI);
        }
    };
    private CameraView.b fyH = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fyt);
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
    private CameraView.b fyI = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void r(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.fyu.setVisibility(4);
                    if (CameraActivity.this.fyC.getMaskType() == 0) {
                        CameraActivity.this.fyA.setFilePath(CameraActivity.this.fyt.getAbsolutePath());
                        CameraActivity.this.brP();
                        return;
                    }
                    CameraActivity.this.fyz.setImageBitmap(bitmap);
                    CameraActivity.this.brQ();
                }
            });
        }
    };
    private View.OnClickListener fyJ = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fyA.setFilePath(null);
            CameraActivity.this.brO();
        }
    };
    private View.OnClickListener fyK = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.fyC.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.fyC.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.fyB.getFrameRect();
                    break;
            }
            CameraActivity.this.fyz.setImageBitmap(CameraActivity.this.fyA.e(frameRect));
            CameraActivity.this.brS();
        }
    };
    private View.OnClickListener fyL = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.brT();
        }
    };
    private View.OnClickListener fyM = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fyz.setImageBitmap(null);
            CameraActivity.this.brO();
        }
    };
    private View.OnClickListener fyN = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.fyA.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.fyu = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.fyw = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.fyy = (CameraView) findViewById(R.id.camera_view);
        this.fyy.getCameraControl().a(this.fxZ);
        this.fyx = (ImageView) findViewById(R.id.light_button);
        this.fyx.setOnClickListener(this.fyF);
        this.fyD = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.fyE);
        this.fyD.setOnClickListener(this.fyG);
        this.fyz = (ImageView) findViewById(R.id.display_image_view);
        this.fyw.findViewById(R.id.confirm_button).setOnClickListener(this.fyL);
        this.fyw.findViewById(R.id.cancel_button).setOnClickListener(this.fyM);
        findViewById(R.id.rotate_button).setOnClickListener(this.fyN);
        this.fyA = (CropView) findViewById(R.id.crop_view);
        this.fyv = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.fyB = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.fyv.findViewById(R.id.confirm_button).setOnClickListener(this.fyK);
        this.fyC = (MaskView) this.fyv.findViewById(R.id.crop_mask_view);
        this.fyv.findViewById(R.id.cancel_button).setOnClickListener(this.fyJ);
        b(getResources().getConfiguration());
        brN();
        this.fyy.setAutoPictureCallback(this.fyH);
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
        this.fyy.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fyy.start();
    }

    private void brN() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.fyt = new File(stringExtra);
            if (!this.fyt.exists()) {
                try {
                    this.fyt.createNewFile();
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
                this.fyB.setVisibility(4);
                break;
            case 1:
                this.fyB.setVisibility(4);
                i = 2;
                break;
            default:
                this.fyC.setVisibility(4);
                i = 0;
                break;
        }
        this.fyy.setMaskType(i, this);
        this.fyC.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        this.fyy.getCameraControl().resume();
        brR();
        this.fyu.setVisibility(0);
        this.fyw.setVisibility(4);
        this.fyv.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brP() {
        this.fyy.getCameraControl().pause();
        brR();
        this.fyu.setVisibility(4);
        this.fyw.setVisibility(4);
        this.fyv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brQ() {
        this.fyy.getCameraControl().pause();
        brR();
        this.fyu.setVisibility(4);
        this.fyw.setVisibility(0);
        this.fyv.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brR() {
        if (this.fyy.getCameraControl().brD() == 1) {
            this.fyx.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.fyx.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brS() {
        this.fyy.getCameraControl().pause();
        brR();
        brT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brT() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.fyt);
                    ((BitmapDrawable) CameraActivity.this.fyz.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.fzQ;
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
                this.fyy.setOrientation(0);
                break;
        }
        this.fyu.setOrientation(i);
        this.fyy.setOrientation(i2);
        this.fyv.setOrientation(i);
        this.fyw.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.fyA.setFilePath(s(intent.getData()));
                brP();
                return;
            }
            this.fyy.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.fyy.getCameraControl().brC();
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
        if (this.fyy != null && this.fyy.getCameraControl() != null) {
            this.fyy.getCameraControl().brM();
        }
    }

    private void brU() {
        c.brW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        brU();
    }

    public void ah(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.fv(false);
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
        aVar.aBW();
    }
}
