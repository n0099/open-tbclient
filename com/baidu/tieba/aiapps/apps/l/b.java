package com.baidu.tieba.aiapps.apps.l;

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
/* loaded from: classes19.dex */
public class b implements Runnable {
    private String cAW;
    private String cAY;
    private ArrayList<MediaModel> cAd;
    private boolean czk;
    private com.baidu.swan.apps.media.chooser.c.d ftU;
    private HandlerC0580b ftV;
    private a ftW;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.cAd = bundle.getParcelableArrayList("mediaModels");
        this.cAW = u.safeGetString(bundle, "swanAppId");
        this.czk = u.c(bundle, "compressed", false);
        this.cAY = u.safeGetString(bundle, "swanTmpPath");
        this.ftU = dVar;
        this.ftV = new HandlerC0580b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bDr();
        if (this.ftV != null) {
            this.ftV.sendEmptyMessage(1);
        }
        if (this.czk) {
            Iterator<MediaModel> it = this.cAd.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.xv(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.cAd.iterator();
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
        if (this.ftV != null) {
            this.ftV.sendEmptyMessage(2);
        }
        if (this.ftU != null) {
            this.ftU.a(true, null, this.cAd);
        }
        bDs();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cv = t.cv(this.cAY, file.getName());
            if (cv != null && cv.exists() && com.baidu.swan.c.d.copyFile(file, cv) != 0) {
                mediaModel.ot(cv.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cv = t.cv(this.cAY, file.getName());
            if (cv != null) {
                mediaModel.ot(cv.getAbsolutePath());
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
            File cv = t.cv(this.cAY, new File(videoModel.getPath()).getName());
            if (cv != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cv);
                videoModel.ot(cv.getPath());
                videoModel.setSize(cv.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0580b ftV;

        public a(HandlerC0580b handlerC0580b) {
            this.ftV = handlerC0580b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.ftV.ftY != null && this.ftV.ftY.isShowing()) {
                this.ftV.ftY.cancel();
                this.ftV.ftY = null;
            }
            if (this.ftV != null) {
                this.ftV.removeMessages(1);
                this.ftV.removeMessages(2);
                this.ftV = null;
            }
            b.this.bDs();
        }
    }

    private void bDr() {
        this.ftW = new a(this.ftV);
        com.baidu.swan.apps.t.a.aoJ().registerActivityLifecycleCallbacks(this.ftW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDs() {
        if (this.ftW != null) {
            com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.ftW);
            this.ftW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class HandlerC0580b extends Handler {
        private Dialog ftY;
        private WeakReference<Context> mReference;

        private HandlerC0580b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.ftY = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.ftY.setContentView(R.layout.swanapp_progress_dialog);
                        this.ftY.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState() ? 0 : 8);
                        this.ftY.setCancelable(false);
                        this.ftY.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.ftY != null && this.ftY.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.ftY.cancel();
                        }
                        this.ftY = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
