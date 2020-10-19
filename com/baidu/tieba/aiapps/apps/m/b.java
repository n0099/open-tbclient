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
    private boolean cNq;
    private ArrayList<MediaModel> cOi;
    private String cPb;
    private String cPd;
    private com.baidu.swan.apps.media.chooser.c.d fJo;
    private HandlerC0593b fJp;
    private a fJq;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.cOi = bundle.getParcelableArrayList("mediaModels");
        this.cPb = u.safeGetString(bundle, "swanAppId");
        this.cNq = u.c(bundle, "compressed", false);
        this.cPd = u.safeGetString(bundle, "swanTmpPath");
        this.fJo = dVar;
        this.fJp = new HandlerC0593b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bHq();
        if (this.fJp != null) {
            this.fJp.sendEmptyMessage(1);
        }
        if (this.cNq) {
            Iterator<MediaModel> it = this.cOi.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.yA(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.cOi.iterator();
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
        if (this.fJp != null) {
            this.fJp.sendEmptyMessage(2);
        }
        if (this.fJo != null) {
            this.fJo.a(true, null, this.cOi);
        }
        bHr();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cA = t.cA(this.cPd, file.getName());
            if (cA != null && cA.exists() && com.baidu.swan.c.d.copyFile(file, cA) != 0) {
                mediaModel.py(cA.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cA = t.cA(this.cPd, file.getName());
            if (cA != null) {
                mediaModel.py(cA.getAbsolutePath());
                t.a(file, cA, i);
                mediaModel.setSize(cA.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cA = t.cA(this.cPd, new File(videoModel.getPath()).getName());
            if (cA != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cA);
                videoModel.py(cA.getPath());
                videoModel.setSize(cA.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0593b fJp;

        public a(HandlerC0593b handlerC0593b) {
            this.fJp = handlerC0593b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fJp.fJs != null && this.fJp.fJs.isShowing()) {
                this.fJp.fJs.cancel();
                this.fJp.fJs = null;
            }
            if (this.fJp != null) {
                this.fJp.removeMessages(1);
                this.fJp.removeMessages(2);
                this.fJp = null;
            }
            b.this.bHr();
        }
    }

    private void bHq() {
        this.fJq = new a(this.fJp);
        com.baidu.swan.apps.t.a.asf().registerActivityLifecycleCallbacks(this.fJq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHr() {
        if (this.fJq != null) {
            com.baidu.swan.apps.t.a.asf().unregisterActivityLifecycleCallbacks(this.fJq);
            this.fJq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class HandlerC0593b extends Handler {
        private Dialog fJs;
        private WeakReference<Context> mReference;

        private HandlerC0593b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.fJs = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fJs.setContentView(R.layout.swanapp_progress_dialog);
                        this.fJs.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState() ? 0 : 8);
                        this.fJs.setCancelable(false);
                        this.fJs.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fJs != null && this.fJs.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fJs.cancel();
                        }
                        this.fJs = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
