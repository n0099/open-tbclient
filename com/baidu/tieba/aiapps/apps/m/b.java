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
    private boolean cVM;
    private ArrayList<MediaModel> cWE;
    private String cXx;
    private String cXz;
    private com.baidu.swan.apps.media.chooser.c.d fRJ;
    private HandlerC0607b fRK;
    private a fRL;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.cWE = bundle.getParcelableArrayList("mediaModels");
        this.cXx = u.safeGetString(bundle, "swanAppId");
        this.cVM = u.c(bundle, "compressed", false);
        this.cXz = u.safeGetString(bundle, "swanTmpPath");
        this.fRJ = dVar;
        this.fRK = new HandlerC0607b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bJj();
        if (this.fRK != null) {
            this.fRK.sendEmptyMessage(1);
        }
        if (this.cVM) {
            Iterator<MediaModel> it = this.cWE.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.yT(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.cWE.iterator();
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
        if (this.fRK != null) {
            this.fRK.sendEmptyMessage(2);
        }
        if (this.fRJ != null) {
            this.fRJ.a(true, null, this.cWE);
        }
        bJk();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cH = t.cH(this.cXz, file.getName());
            if (cH != null && cH.exists() && com.baidu.swan.c.d.copyFile(file, cH) != 0) {
                mediaModel.pR(cH.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cH = t.cH(this.cXz, file.getName());
            if (cH != null) {
                mediaModel.pR(cH.getAbsolutePath());
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
            File cH = t.cH(this.cXz, new File(videoModel.getPath()).getName());
            if (cH != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cH);
                videoModel.pR(cH.getPath());
                videoModel.setSize(cH.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0607b fRK;

        public a(HandlerC0607b handlerC0607b) {
            this.fRK = handlerC0607b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fRK.fRN != null && this.fRK.fRN.isShowing()) {
                this.fRK.fRN.cancel();
                this.fRK.fRN = null;
            }
            if (this.fRK != null) {
                this.fRK.removeMessages(1);
                this.fRK.removeMessages(2);
                this.fRK = null;
            }
            b.this.bJk();
        }
    }

    private void bJj() {
        this.fRL = new a(this.fRK);
        com.baidu.swan.apps.t.a.aua().registerActivityLifecycleCallbacks(this.fRL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJk() {
        if (this.fRL != null) {
            com.baidu.swan.apps.t.a.aua().unregisterActivityLifecycleCallbacks(this.fRL);
            this.fRL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class HandlerC0607b extends Handler {
        private Dialog fRN;
        private WeakReference<Context> mReference;

        private HandlerC0607b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.fRN = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fRN.setContentView(R.layout.swanapp_progress_dialog);
                        this.fRN.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState() ? 0 : 8);
                        this.fRN.setCancelable(false);
                        this.fRN.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fRN != null && this.fRN.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fRN.cancel();
                        }
                        this.fRN = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
