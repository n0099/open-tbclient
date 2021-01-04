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
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File iqh;
    private OCRCameraLayout iqi;
    private OCRCameraLayout iqj;
    private OCRCameraLayout iqk;
    private ImageView iql;
    private CameraView iqm;
    private ImageView iqn;
    private CropView iqo;
    private FrameOverlayView iqp;
    private MaskView iqq;
    private ImageView iqr;
    private Handler handler = new Handler();
    private e ipN = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cut() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener iqs = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener iqt = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.iqm.getCameraControl().cua() == 0) {
                CameraActivity.this.iqm.getCameraControl().yn(1);
            } else {
                CameraActivity.this.iqm.getCameraControl().yn(0);
            }
            CameraActivity.this.cup();
        }
    };
    private View.OnClickListener iqu = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iqm.a(CameraActivity.this.iqh, CameraActivity.this.iqw);
        }
    };
    private CameraView.b iqv = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void y(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.iqh);
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
    private CameraView.b iqw = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void y(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.iqi.setVisibility(4);
                    if (CameraActivity.this.iqq.getMaskType() == 0) {
                        CameraActivity.this.iqo.setFilePath(CameraActivity.this.iqh.getAbsolutePath());
                        CameraActivity.this.cun();
                        return;
                    }
                    CameraActivity.this.iqn.setImageBitmap(bitmap);
                    CameraActivity.this.cuo();
                }
            });
        }
    };
    private View.OnClickListener iqx = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iqo.setFilePath(null);
            CameraActivity.this.cum();
        }
    };
    private View.OnClickListener iqy = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.iqq.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.iqq.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.iqp.getFrameRect();
                    break;
            }
            CameraActivity.this.iqn.setImageBitmap(CameraActivity.this.iqo.d(frameRect));
            CameraActivity.this.cuq();
        }
    };
    private View.OnClickListener iqz = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cur();
        }
    };
    private View.OnClickListener iqA = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iqn.setImageBitmap(null);
            CameraActivity.this.cum();
        }
    };
    private View.OnClickListener iqB = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.iqo.yq(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.iqi = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.iqk = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.iqm = (CameraView) findViewById(R.id.camera_view);
        this.iqm.getCameraControl().a(this.ipN);
        this.iql = (ImageView) findViewById(R.id.light_button);
        this.iql.setOnClickListener(this.iqt);
        this.iqr = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.iqs);
        this.iqr.setOnClickListener(this.iqu);
        this.iqn = (ImageView) findViewById(R.id.display_image_view);
        this.iqk.findViewById(R.id.confirm_button).setOnClickListener(this.iqz);
        this.iqk.findViewById(R.id.cancel_button).setOnClickListener(this.iqA);
        findViewById(R.id.rotate_button).setOnClickListener(this.iqB);
        this.iqo = (CropView) findViewById(R.id.crop_view);
        this.iqj = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.iqp = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.iqj.findViewById(R.id.confirm_button).setOnClickListener(this.iqy);
        this.iqq = (MaskView) this.iqj.findViewById(R.id.crop_mask_view);
        this.iqj.findViewById(R.id.cancel_button).setOnClickListener(this.iqx);
        c(getResources().getConfiguration());
        cul();
        this.iqm.setAutoPictureCallback(this.iqv);
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
        this.iqm.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iqm.start();
    }

    private void cul() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.iqh = new File(stringExtra);
            if (!this.iqh.exists()) {
                try {
                    this.iqh.createNewFile();
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
                this.iqp.setVisibility(4);
                break;
            case 1:
                this.iqp.setVisibility(4);
                i = 2;
                break;
            default:
                this.iqq.setVisibility(4);
                i = 0;
                break;
        }
        this.iqm.setMaskType(i, this);
        this.iqq.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cum() {
        this.iqm.getCameraControl().resume();
        cup();
        this.iqi.setVisibility(0);
        this.iqk.setVisibility(4);
        this.iqj.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cun() {
        this.iqm.getCameraControl().pause();
        cup();
        this.iqi.setVisibility(4);
        this.iqk.setVisibility(4);
        this.iqj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuo() {
        this.iqm.getCameraControl().pause();
        cup();
        this.iqi.setVisibility(4);
        this.iqk.setVisibility(0);
        this.iqj.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cup() {
        if (this.iqm.getCameraControl().cua() == 1) {
            this.iql.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.iql.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuq() {
        this.iqm.getCameraControl().pause();
        cup();
        cur();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cur() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.iqh);
                    ((BitmapDrawable) CameraActivity.this.iqn.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String A(Uri uri) {
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
                i = OCRCameraLayout.irE;
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
                this.iqm.setOrientation(0);
                break;
        }
        this.iqi.setOrientation(i);
        this.iqm.setOrientation(i2);
        this.iqj.setOrientation(i);
        this.iqk.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.iqo.setFilePath(A(intent.getData()));
                cun();
                return;
            }
            this.iqm.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.iqm.getCameraControl().ctZ();
                    break;
                } else {
                    aq(this);
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
        if (this.iqm != null && this.iqm.getCameraControl() != null) {
            this.iqm.getCameraControl().cuk();
        }
    }

    private void cus() {
        c.cuu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cus();
    }

    public void aq(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.jI(false);
        aVar.oZ(R.string.request_permission_default_title);
        aVar.pa(R.string.request_permission_camera);
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
        aVar.btX();
    }
}
