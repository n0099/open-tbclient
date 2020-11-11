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
/* loaded from: classes25.dex */
public class b implements Runnable {
    private boolean dbG;
    private ArrayList<MediaModel> dcz;
    private String dds;
    private String ddv;
    private HandlerC0619b fXA;
    private a fXB;
    private com.baidu.swan.apps.media.chooser.c.d fXz;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.dcz = bundle.getParcelableArrayList("mediaModels");
        this.dds = u.safeGetString(bundle, "swanAppId");
        this.dbG = u.c(bundle, "compressed", false);
        this.ddv = u.safeGetString(bundle, "swanTmpPath");
        this.fXz = dVar;
        this.fXA = new HandlerC0619b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bLI();
        if (this.fXA != null) {
            this.fXA.sendEmptyMessage(1);
        }
        if (this.dbG) {
            Iterator<MediaModel> it = this.dcz.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.zh(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.dcz.iterator();
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
        if (this.fXA != null) {
            this.fXA.sendEmptyMessage(2);
        }
        if (this.fXz != null) {
            this.fXz.a(true, null, this.dcz);
        }
        bLJ();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cH = t.cH(this.ddv, file.getName());
            if (cH != null && cH.exists() && com.baidu.swan.c.d.copyFile(file, cH) != 0) {
                mediaModel.qf(cH.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cH = t.cH(this.ddv, file.getName());
            if (cH != null) {
                mediaModel.qf(cH.getAbsolutePath());
                t.a(file, cH, i);
                mediaModel.setSize(cH.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cH = t.cH(this.ddv, new File(videoModel.getPath()).getName());
            if (cH != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cH);
                videoModel.qf(cH.getPath());
                videoModel.setSize(cH.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0619b fXA;

        public a(HandlerC0619b handlerC0619b) {
            this.fXA = handlerC0619b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fXA.fXD != null && this.fXA.fXD.isShowing()) {
                this.fXA.fXD.cancel();
                this.fXA.fXD = null;
            }
            if (this.fXA != null) {
                this.fXA.removeMessages(1);
                this.fXA.removeMessages(2);
                this.fXA = null;
            }
            b.this.bLJ();
        }
    }

    private void bLI() {
        this.fXB = new a(this.fXA);
        com.baidu.swan.apps.t.a.awA().registerActivityLifecycleCallbacks(this.fXB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLJ() {
        if (this.fXB != null) {
            com.baidu.swan.apps.t.a.awA().unregisterActivityLifecycleCallbacks(this.fXB);
            this.fXB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class HandlerC0619b extends Handler {
        private Dialog fXD;
        private WeakReference<Context> mReference;

        private HandlerC0619b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.fXD = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fXD.setContentView(R.layout.swanapp_progress_dialog);
                        this.fXD.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState() ? 0 : 8);
                        this.fXD.setCancelable(false);
                        this.fXD.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fXD != null && this.fXD.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fXD.cancel();
                        }
                        this.fXD = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
