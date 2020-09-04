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
    private File hdY;
    private OCRCameraLayout hdZ;
    private OCRCameraLayout hea;
    private OCRCameraLayout heb;
    private ImageView hec;
    private CameraView hed;
    private ImageView hee;
    private CropView hef;
    private FrameOverlayView heg;
    private MaskView heh;
    private ImageView hei;
    private Handler handler = new Handler();
    private e hdE = new e() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.1
        @Override // com.baidu.tieba.barselect.idCard.e
        public boolean cbr() {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 800);
            return false;
        }
    };
    private View.OnClickListener hej = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.7
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
    private View.OnClickListener hek = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CameraActivity.this.hed.getCameraControl().caX() == 0) {
                CameraActivity.this.hed.getCameraControl().vl(1);
            } else {
                CameraActivity.this.hed.getCameraControl().vl(0);
            }
            CameraActivity.this.cbn();
        }
    };
    private View.OnClickListener hel = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hed.a(CameraActivity.this.hdY, CameraActivity.this.hen);
        }
    };
    private CameraView.b hem = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hdY);
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
    private CameraView.b hen = new CameraView.b() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11
        @Override // com.baidu.tieba.barselect.idCard.CameraView.b
        public void x(final Bitmap bitmap) {
            CameraActivity.this.handler.post(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    CameraActivity.this.hdZ.setVisibility(4);
                    if (CameraActivity.this.heh.getMaskType() == 0) {
                        CameraActivity.this.hef.setFilePath(CameraActivity.this.hdY.getAbsolutePath());
                        CameraActivity.this.cbl();
                        return;
                    }
                    CameraActivity.this.hee.setImageBitmap(bitmap);
                    CameraActivity.this.cbm();
                }
            });
        }
    };
    private View.OnClickListener heo = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hef.setFilePath(null);
            CameraActivity.this.cbk();
        }
    };
    private View.OnClickListener hep = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Rect frameRect;
            switch (CameraActivity.this.heh.getMaskType()) {
                case 1:
                case 2:
                    frameRect = CameraActivity.this.heh.getFrameRect();
                    break;
                default:
                    frameRect = CameraActivity.this.heg.getFrameRect();
                    break;
            }
            CameraActivity.this.hee.setImageBitmap(CameraActivity.this.hef.e(frameRect));
            CameraActivity.this.cbo();
        }
    };
    private View.OnClickListener heq = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.cbp();
        }
    };
    private View.OnClickListener her = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hee.setImageBitmap(null);
            CameraActivity.this.cbk();
        }
    };
    private View.OnClickListener hes = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CameraActivity.this.hef.rotate(90);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bd_ocr_activity_camera);
        this.hdZ = (OCRCameraLayout) findViewById(R.id.take_picture_container);
        this.heb = (OCRCameraLayout) findViewById(R.id.confirm_result_container);
        this.hed = (CameraView) findViewById(R.id.camera_view);
        this.hed.getCameraControl().a(this.hdE);
        this.hec = (ImageView) findViewById(R.id.light_button);
        this.hec.setOnClickListener(this.hek);
        this.hei = (ImageView) findViewById(R.id.take_photo_button);
        findViewById(R.id.album_button).setOnClickListener(this.hej);
        this.hei.setOnClickListener(this.hel);
        this.hee = (ImageView) findViewById(R.id.display_image_view);
        this.heb.findViewById(R.id.confirm_button).setOnClickListener(this.heq);
        this.heb.findViewById(R.id.cancel_button).setOnClickListener(this.her);
        findViewById(R.id.rotate_button).setOnClickListener(this.hes);
        this.hef = (CropView) findViewById(R.id.crop_view);
        this.hea = (OCRCameraLayout) findViewById(R.id.crop_container);
        this.heg = (FrameOverlayView) findViewById(R.id.overlay_view);
        this.hea.findViewById(R.id.confirm_button).setOnClickListener(this.hep);
        this.heh = (MaskView) this.hea.findViewById(R.id.crop_mask_view);
        this.hea.findViewById(R.id.cancel_button).setOnClickListener(this.heo);
        c(getResources().getConfiguration());
        cbj();
        this.hed.setAutoPictureCallback(this.hem);
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
        this.hed.stop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hed.start();
    }

    private void cbj() {
        int i = 1;
        String stringExtra = getIntent().getStringExtra(CameraActivityConfig.KEY_OUTPUT_FILE_PATH);
        if (stringExtra != null) {
            this.hdY = new File(stringExtra);
            if (!this.hdY.exists()) {
                try {
                    this.hdY.createNewFile();
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
                this.heg.setVisibility(4);
                break;
            case 1:
                this.heg.setVisibility(4);
                i = 2;
                break;
            default:
                this.heh.setVisibility(4);
                i = 0;
                break;
        }
        this.hed.setMaskType(i, this);
        this.heh.setMaskType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        this.hed.getCameraControl().resume();
        cbn();
        this.hdZ.setVisibility(0);
        this.heb.setVisibility(4);
        this.hea.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbl() {
        this.hed.getCameraControl().pause();
        cbn();
        this.hdZ.setVisibility(4);
        this.heb.setVisibility(4);
        this.hea.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbm() {
        this.hed.getCameraControl().pause();
        cbn();
        this.hdZ.setVisibility(4);
        this.heb.setVisibility(0);
        this.hea.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbn() {
        if (this.hed.getCameraControl().caX() == 1) {
            this.hec.setImageResource(R.drawable.bd_ocr_light_on);
        } else {
            this.hec.setImageResource(R.drawable.bd_ocr_light_off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbo() {
        this.hed.getCameraControl().pause();
        cbn();
        cbp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.CameraActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(CameraActivity.this.hdY);
                    ((BitmapDrawable) CameraActivity.this.hee.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
                i = OCRCameraLayout.hfw;
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
                this.hed.setOrientation(0);
                break;
        }
        this.hdZ.setOrientation(i);
        this.hed.setOrientation(i2);
        this.hea.setOrientation(i);
        this.heb.setOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (i2 == -1) {
                this.hef.setFilePath(w(intent.getData()));
                cbl();
                return;
            }
            this.hed.getCameraControl().resume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        switch (i) {
            case 800:
                if (iArr.length > 0 && iArr[0] == 0) {
                    this.hed.getCameraControl().caW();
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
        if (this.hed != null && this.hed.getCameraControl() != null) {
            this.hed.getCameraControl().cbi();
        }
    }

    private void cbq() {
        c.cbs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cbq();
    }

    public void aj(final Activity activity) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.ih(false);
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
