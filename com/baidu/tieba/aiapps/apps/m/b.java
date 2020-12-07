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
    private boolean dgW;
    private ArrayList<MediaModel> dhO;
    private String diK;
    private String diM;
    private com.baidu.swan.apps.media.chooser.c.d gfr;
    private HandlerC0631b gfs;
    private a gft;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.dhO = bundle.getParcelableArrayList("mediaModels");
        this.diK = u.safeGetString(bundle, "swanAppId");
        this.dgW = u.c(bundle, "compressed", false);
        this.diM = u.safeGetString(bundle, "swanTmpPath");
        this.gfr = dVar;
        this.gfs = new HandlerC0631b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bOJ();
        if (this.gfs != null) {
            this.gfs.sendEmptyMessage(1);
        }
        if (this.dgW) {
            Iterator<MediaModel> it = this.dhO.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.zJ(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.dhO.iterator();
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
        if (this.gfs != null) {
            this.gfs.sendEmptyMessage(2);
        }
        if (this.gfr != null) {
            this.gfr.a(true, null, this.dhO);
        }
        bOK();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cN = t.cN(this.diM, file.getName());
            if (cN != null && cN.exists() && com.baidu.swan.c.d.copyFile(file, cN) != 0) {
                mediaModel.qG(cN.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cN = t.cN(this.diM, file.getName());
            if (cN != null) {
                mediaModel.qG(cN.getAbsolutePath());
                t.a(file, cN, i);
                mediaModel.setSize(cN.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cN = t.cN(this.diM, new File(videoModel.getPath()).getName());
            if (cN != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cN);
                videoModel.qG(cN.getPath());
                videoModel.setSize(cN.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0631b gfs;

        public a(HandlerC0631b handlerC0631b) {
            this.gfs = handlerC0631b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.gfs.gfv != null && this.gfs.gfv.isShowing()) {
                this.gfs.gfv.cancel();
                this.gfs.gfv = null;
            }
            if (this.gfs != null) {
                this.gfs.removeMessages(1);
                this.gfs.removeMessages(2);
                this.gfs = null;
            }
            b.this.bOK();
        }
    }

    private void bOJ() {
        this.gft = new a(this.gfs);
        com.baidu.swan.apps.t.a.aza().registerActivityLifecycleCallbacks(this.gft);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOK() {
        if (this.gft != null) {
            com.baidu.swan.apps.t.a.aza().unregisterActivityLifecycleCallbacks(this.gft);
            this.gft = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class HandlerC0631b extends Handler {
        private Dialog gfv;
        private WeakReference<Context> mReference;

        private HandlerC0631b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.gfv = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.gfv.setContentView(R.layout.swanapp_progress_dialog);
                        this.gfv.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState() ? 0 : 8);
                        this.gfv.setCancelable(false);
                        this.gfv.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.gfv != null && this.gfv.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.gfv.cancel();
                        }
                        this.gfv = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
