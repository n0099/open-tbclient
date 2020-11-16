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
    private boolean cZW;
    private ArrayList<MediaModel> daQ;
    private String dbJ;
    private String dbL;
    private com.baidu.swan.apps.media.chooser.c.d fXg;
    private HandlerC0619b fXh;
    private a fXi;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.daQ = bundle.getParcelableArrayList("mediaModels");
        this.dbJ = u.safeGetString(bundle, "swanAppId");
        this.cZW = u.c(bundle, "compressed", false);
        this.dbL = u.safeGetString(bundle, "swanTmpPath");
        this.fXg = dVar;
        this.fXh = new HandlerC0619b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bLb();
        if (this.fXh != null) {
            this.fXh.sendEmptyMessage(1);
        }
        if (this.cZW) {
            Iterator<MediaModel> it = this.daQ.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.zc(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.daQ.iterator();
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
        if (this.fXh != null) {
            this.fXh.sendEmptyMessage(2);
        }
        if (this.fXg != null) {
            this.fXg.a(true, null, this.daQ);
        }
        bLc();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cG = t.cG(this.dbL, file.getName());
            if (cG != null && cG.exists() && com.baidu.swan.c.d.copyFile(file, cG) != 0) {
                mediaModel.pZ(cG.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cG = t.cG(this.dbL, file.getName());
            if (cG != null) {
                mediaModel.pZ(cG.getAbsolutePath());
                t.a(file, cG, i);
                mediaModel.setSize(cG.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cG = t.cG(this.dbL, new File(videoModel.getPath()).getName());
            if (cG != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cG);
                videoModel.pZ(cG.getPath());
                videoModel.setSize(cG.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0619b fXh;

        public a(HandlerC0619b handlerC0619b) {
            this.fXh = handlerC0619b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fXh.fXk != null && this.fXh.fXk.isShowing()) {
                this.fXh.fXk.cancel();
                this.fXh.fXk = null;
            }
            if (this.fXh != null) {
                this.fXh.removeMessages(1);
                this.fXh.removeMessages(2);
                this.fXh = null;
            }
            b.this.bLc();
        }
    }

    private void bLb() {
        this.fXi = new a(this.fXh);
        com.baidu.swan.apps.t.a.avS().registerActivityLifecycleCallbacks(this.fXi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLc() {
        if (this.fXi != null) {
            com.baidu.swan.apps.t.a.avS().unregisterActivityLifecycleCallbacks(this.fXi);
            this.fXi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static class HandlerC0619b extends Handler {
        private Dialog fXk;
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
                        this.fXk = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fXk.setContentView(R.layout.swanapp_progress_dialog);
                        this.fXk.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState() ? 0 : 8);
                        this.fXk.setCancelable(false);
                        this.fXk.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fXk != null && this.fXk.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fXk.cancel();
                        }
                        this.fXk = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
