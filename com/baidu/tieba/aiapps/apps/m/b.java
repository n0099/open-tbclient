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
    private com.baidu.swan.apps.media.chooser.c.d gft;
    private HandlerC0631b gfu;
    private a gfv;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.dhO = bundle.getParcelableArrayList("mediaModels");
        this.diK = u.safeGetString(bundle, "swanAppId");
        this.dgW = u.c(bundle, "compressed", false);
        this.diM = u.safeGetString(bundle, "swanTmpPath");
        this.gft = dVar;
        this.gfu = new HandlerC0631b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bOK();
        if (this.gfu != null) {
            this.gfu.sendEmptyMessage(1);
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
        if (this.gfu != null) {
            this.gfu.sendEmptyMessage(2);
        }
        if (this.gft != null) {
            this.gft.a(true, null, this.dhO);
        }
        bOL();
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
        private HandlerC0631b gfu;

        public a(HandlerC0631b handlerC0631b) {
            this.gfu = handlerC0631b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.gfu.gfx != null && this.gfu.gfx.isShowing()) {
                this.gfu.gfx.cancel();
                this.gfu.gfx = null;
            }
            if (this.gfu != null) {
                this.gfu.removeMessages(1);
                this.gfu.removeMessages(2);
                this.gfu = null;
            }
            b.this.bOL();
        }
    }

    private void bOK() {
        this.gfv = new a(this.gfu);
        com.baidu.swan.apps.t.a.aza().registerActivityLifecycleCallbacks(this.gfv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOL() {
        if (this.gfv != null) {
            com.baidu.swan.apps.t.a.aza().unregisterActivityLifecycleCallbacks(this.gfv);
            this.gfv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class HandlerC0631b extends Handler {
        private Dialog gfx;
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
                        this.gfx = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.gfx.setContentView(R.layout.swanapp_progress_dialog);
                        this.gfx.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState() ? 0 : 8);
                        this.gfx.setCancelable(false);
                        this.gfx.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.gfx != null && this.gfx.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.gfx.cancel();
                        }
                        this.gfx = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
