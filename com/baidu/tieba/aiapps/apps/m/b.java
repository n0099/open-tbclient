package com.baidu.tieba.aiapps.apps.m;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.t;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumActivity;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tieba.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes24.dex */
public class b implements Runnable {
    private boolean cBl;
    private String cCW;
    private String cCY;
    private ArrayList<MediaModel> cCd;
    private com.baidu.swan.apps.media.chooser.c.d fxf;
    private HandlerC0576b fxg;
    private a fxh;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.cCd = bundle.getParcelableArrayList("mediaModels");
        this.cCW = u.safeGetString(bundle, "swanAppId");
        this.cBl = u.c(bundle, "compressed", false);
        this.cCY = u.safeGetString(bundle, "swanTmpPath");
        this.fxf = dVar;
        this.fxg = new HandlerC0576b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bEE();
        if (this.fxg != null) {
            this.fxg.sendEmptyMessage(1);
        }
        if (this.cBl) {
            Iterator<MediaModel> it = this.cCd.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.xO(next.getPath()), "gif")) {
                            i(next);
                        } else {
                            b(next, 20);
                        }
                    } else if (next instanceof VideoModel) {
                        a((VideoModel) next);
                    }
                }
            }
        } else {
            Iterator<MediaModel> it2 = this.cCd.iterator();
            while (it2.hasNext()) {
                MediaModel next2 = it2.next();
                if (next2 != null) {
                    if (next2 instanceof ImageModel) {
                        b(next2, 100);
                    } else {
                        i(next2);
                    }
                }
            }
        }
        if (this.fxg != null) {
            this.fxg.sendEmptyMessage(2);
        }
        if (this.fxf != null) {
            this.fxf.a(true, null, this.cCd);
        }
        bEF();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cv = t.cv(this.cCY, file.getName());
            if (cv != null && cv.exists() && com.baidu.swan.c.d.copyFile(file, cv) != 0) {
                mediaModel.oM(cv.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cv = t.cv(this.cCY, file.getName());
            if (cv != null) {
                mediaModel.oM(cv.getAbsolutePath());
                t.a(file, cv, i);
                mediaModel.setSize(cv.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cv = t.cv(this.cCY, new File(videoModel.getPath()).getName());
            if (cv != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cv);
                videoModel.oM(cv.getPath());
                videoModel.setSize(cv.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0576b fxg;

        public a(HandlerC0576b handlerC0576b) {
            this.fxg = handlerC0576b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fxg.fxj != null && this.fxg.fxj.isShowing()) {
                this.fxg.fxj.cancel();
                this.fxg.fxj = null;
            }
            if (this.fxg != null) {
                this.fxg.removeMessages(1);
                this.fxg.removeMessages(2);
                this.fxg = null;
            }
            b.this.bEF();
        }
    }

    private void bEE() {
        this.fxh = new a(this.fxg);
        com.baidu.swan.apps.t.a.apu().registerActivityLifecycleCallbacks(this.fxh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEF() {
        if (this.fxh != null) {
            com.baidu.swan.apps.t.a.apu().unregisterActivityLifecycleCallbacks(this.fxh);
            this.fxh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static class HandlerC0576b extends Handler {
        private Dialog fxj;
        private WeakReference<Context> mReference;

        private HandlerC0576b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.fxj = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fxj.setContentView(R.layout.swanapp_progress_dialog);
                        this.fxj.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState() ? 0 : 8);
                        this.fxj.setCancelable(false);
                        this.fxj.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fxj != null && this.fxj.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fxj.cancel();
                        }
                        this.fxj = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
