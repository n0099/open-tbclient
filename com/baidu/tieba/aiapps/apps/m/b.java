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
import com.baidu.swan.apps.ao.t;
import com.baidu.swan.apps.ao.u;
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
/* loaded from: classes9.dex */
public class b implements Runnable {
    private boolean djp;
    private ArrayList<MediaModel> dkh;
    private String dle;
    private String dlh;
    private com.baidu.swan.apps.media.chooser.listener.d gmW;
    private HandlerC0605b gmX;
    private a gmY;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.listener.d dVar) {
        this.mContext = context;
        this.dkh = bundle.getParcelableArrayList("mediaModels");
        this.dle = u.h(bundle, "swanAppId");
        this.djp = u.c(bundle, "compressed", false);
        this.dlh = u.h(bundle, "swanTmpPath");
        this.gmW = dVar;
        this.gmX = new HandlerC0605b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bNT();
        if (this.gmX != null) {
            this.gmX.sendEmptyMessage(1);
        }
        if (this.djp) {
            Iterator<MediaModel> it = this.dkh.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.yP(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.dkh.iterator();
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
        if (this.gmX != null) {
            this.gmX.sendEmptyMessage(2);
        }
        if (this.gmW != null) {
            this.gmW.a(true, null, this.dkh);
        }
        bNU();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cF = t.cF(this.dlh, file.getName());
            if (cF != null && cF.exists() && com.baidu.swan.c.d.copyFile(file, cF) != 0) {
                mediaModel.pH(cF.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cF = t.cF(this.dlh, file.getName());
            if (cF != null) {
                mediaModel.pH(cF.getAbsolutePath());
                t.a(file, cF, i);
                mediaModel.setSize(cF.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cF = t.cF(this.dlh, new File(videoModel.getPath()).getName());
            if (cF != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cF);
                videoModel.pH(cF.getPath());
                videoModel.setSize(cF.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0605b gmX;

        public a(HandlerC0605b handlerC0605b) {
            this.gmX = handlerC0605b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.gmX.gna != null && this.gmX.gna.isShowing()) {
                this.gmX.gna.cancel();
                this.gmX.gna = null;
            }
            if (this.gmX != null) {
                this.gmX.removeMessages(1);
                this.gmX.removeMessages(2);
                this.gmX = null;
            }
            b.this.bNU();
        }
    }

    private void bNT() {
        this.gmY = new a(this.gmX);
        com.baidu.swan.apps.t.a.awW().registerActivityLifecycleCallbacks(this.gmY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNU() {
        if (this.gmY != null) {
            com.baidu.swan.apps.t.a.awW().unregisterActivityLifecycleCallbacks(this.gmY);
            this.gmY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC0605b extends Handler {
        private Dialog gna;
        private WeakReference<Context> mReference;

        private HandlerC0605b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.gna = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.gna.setContentView(R.layout.swanapp_progress_dialog);
                        this.gna.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.axs().aii() ? 0 : 8);
                        this.gna.setCancelable(false);
                        this.gna.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.gna != null && this.gna.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.gna.cancel();
                        }
                        this.gna = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
