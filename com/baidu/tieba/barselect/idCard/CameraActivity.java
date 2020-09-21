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
/* loaded from: classes20.dex */
public class CameraActivity extends BaseActivity {
    private String contentType;
    private File hla;
    private OCRCameraLayout hlb;
    private OCRCameraLayout hlc;
    private OCRCameraLayout hld;
    private ImageView hle;
    private CameraView hlf;
    private ImageView hlg;
    private CropView hlh;
    private FrameOverlayView hli;
    private MaskView hlj;
    private ImageView hlk;
    private Handler handler = new Handler();
    private e hkG = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean ceG() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hll = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener hlm = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hlf.getCameraControl().cem() == 0) {
                CameraActivity.this.hlf.getCameraControl().vK(1);
            } else {
                CameraActivity.this.hlf.getCameraControl().vK(0);
            }
            CameraActivity.this.ceC();
        }
    };
    private View.OnClickListener hln = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hlf.a(CameraActivity.this.hla, CameraActivity.this.hlp);
        }
    };
    private CameraView.b hlo = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hla);
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
    private CameraView.b hlp = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hlb.setVisibility(4);
                    if (CameraActivity.this.hlj.getMaskType() == 0) {
                        CameraActivity.this.hlh.setFilePath(CameraActivity.this.hla.getAbsolutePath());
                        CameraActivity.this.ceA();
                        return;
                    }
                    CameraActivity.this.hlg.setImageBitmap(bitmap);
                    CameraActivity.this.ceB();
                }
            });
        }
    };
    private View.OnClickListener hlq = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hlh.setFilePath(null);
            CameraActivity.this.cez();
        }
    };
    private View.OnClickListener hlr = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.hlj.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.hlj.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.hli.getFrameRect();
                    break;
            }
            CameraActivity.this.hlg.setImageBitmap(CameraActivity.this.hlh.e(frameRect));
            CameraActivity.this.ceD();
        }
    };
    private View.OnClickListener hls = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.ceE();
        }
    };
    private View.OnClickListener hlt = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hlg.setImageBitmap(null);
            CameraActivity.this.cez();
        }
    };
    private View.OnClickListener hlu = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hlh.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hlb = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.hld = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hlf = (CameraView) findViewById(R.id.camera_view);
        this.hlf.getCameraControl().a(this.hkG);
        this.hle = (ImageView) findViewById(R.id.light_button);
        this.hle.setOnClickListener(this.hlm);
        this.hlk = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hll);
        this.hlk.setOnClickListener(this.hln);
        this.hlg = (ImageView) findViewById(R.id.display_image_view);
        this.hld.findViewById(R.id.confirm_button).setOnClickListener(this.hls);
        this.hld.findViewById(R.id.cancel_button).setOnClickListener(this.hlt);
        findViewById(R.id.rotate_button).setOnClickListener(this.hlu);
        this.hlh = (CropView) findViewById(R.id.crop_view);
        this.hlc = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.hli = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hlc.findViewById(R.id.confirm_button).setOnClickListener(this.hlr);
        this.hlj = (MaskView) this.hlc.findViewById(R.id.crop_mask_view);
        this.hlc.findViewById(R.id.cancel_button).setOnClickListener(this.hlq);
        c(getResources().getConfiguration());
        cey();
        this.hlf.setAutoPictureCallback(this.hlo);
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
        this.hlf.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hlf.start();
    }

    private void cey() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hla = new File(stringExtra);
            if (!this.hla.exists()) {
                try {
                    this.hla.createNewFile();
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
                this.hli.setVisibility(4);
                break;
            case 1:
                this.hli.setVisibility(4);
                i = 2;
                break;
            default:
                this.hlj.setVisibility(4);
                i = 0;
                break;
        }
        this.hlf.setMaskType(i, this);
        this.hlj.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cez() {
        this.hlf.getCameraControl().resume();
        ceC();
        this.hlb.setVisibility(0);
        this.hld.setVisibility(4);
        this.hlc.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceA() {
        this.hlf.getCameraControl().pause();
        ceC();
        this.hlb.setVisibility(4);
        this.hld.setVisibility(4);
        this.hlc.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceB() {
        this.hlf.getCameraControl().pause();
        ceC();
        this.hlb.setVisibility(4);
        this.hld.setVisibility(0);
        this.hlc.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceC() {
        if (this.hlf.getCameraControl().cem() == 1) {
            this.hle.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hle.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceD() {
        this.hlf.getCameraControl().pause();
        ceC();
        ceE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceE() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hla);
                    ((BitmapDrawable) CameraActivity.this.hlg.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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

    private String x(Uri uri) {
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
                i = OCRCameraLayout.hmx;
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
                this.hlf.setOrientation(0);
                break;
        }
        this.hlb.setOrientation(i);
        this.hlf.setOrientation(i2);
        this.hlc.setOrientation(i);
        this.hld.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.hlh.setFilePath(x(intent.getData()));
                ceA();
                return;
            }
            this.hlf.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hlf.getCameraControl().cel();
                    break;
                } else {
                    an(this);
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
        if (this.hlf != null && this.hlf.getCameraControl() != null) {
            this.hlf.getCameraControl().cex();
        }
    }

    private void ceF() {
        c.ceH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ceF();
    }

    public void an(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.ie(false);
        aVar.nD(R.string.request_permission_default_title);
        aVar.nE(R.string.request_permission_camera);
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
        aVar.bia();
    }
}
