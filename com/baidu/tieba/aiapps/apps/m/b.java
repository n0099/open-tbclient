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
    private boolean dlQ;
    private ArrayList<MediaModel> dmI;
    private String dnG;
    private String dnJ;
    private com.baidu.swan.apps.media.chooser.listener.d goI;
    private HandlerC0622b goJ;
    private a goK;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.listener.d dVar) {
        this.mContext = context;
        this.dmI = bundle.getParcelableArrayList("mediaModels");
        this.dnG = u.h(bundle, "swanAppId");
        this.dlQ = u.c(bundle, "compressed", false);
        this.dnJ = u.h(bundle, "swanTmpPath");
        this.goI = dVar;
        this.goJ = new HandlerC0622b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bRc();
        if (this.goJ != null) {
            this.goJ.sendEmptyMessage(1);
        }
        if (this.dlQ) {
            Iterator<MediaModel> it = this.dmI.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.zI(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.dmI.iterator();
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
        if (this.goJ != null) {
            this.goJ.sendEmptyMessage(2);
        }
        if (this.goI != null) {
            this.goI.a(true, null, this.dmI);
        }
        bRd();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cM = t.cM(this.dnJ, file.getName());
            if (cM != null && cM.exists() && com.baidu.swan.c.d.copyFile(file, cM) != 0) {
                mediaModel.qA(cM.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cM = t.cM(this.dnJ, file.getName());
            if (cM != null) {
                mediaModel.qA(cM.getAbsolutePath());
                t.a(file, cM, i);
                mediaModel.setSize(cM.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cM = t.cM(this.dnJ, new File(videoModel.getPath()).getName());
            if (cM != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cM);
                videoModel.qA(cM.getPath());
                videoModel.setSize(cM.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0622b goJ;

        public a(HandlerC0622b handlerC0622b) {
            this.goJ = handlerC0622b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.goJ.goM != null && this.goJ.goM.isShowing()) {
                this.goJ.goM.cancel();
                this.goJ.goM = null;
            }
            if (this.goJ != null) {
                this.goJ.removeMessages(1);
                this.goJ.removeMessages(2);
                this.goJ = null;
            }
            b.this.bRd();
        }
    }

    private void bRc() {
        this.goK = new a(this.goJ);
        com.baidu.swan.apps.t.a.aAr().registerActivityLifecycleCallbacks(this.goK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRd() {
        if (this.goK != null) {
            com.baidu.swan.apps.t.a.aAr().unregisterActivityLifecycleCallbacks(this.goK);
            this.goK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC0622b extends Handler {
        private Dialog goM;
        private WeakReference<Context> mReference;

        private HandlerC0622b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.goM = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.goM.setContentView(R.layout.swanapp_progress_dialog);
                        this.goM.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.aAN().alD() ? 0 : 8);
                        this.goM.setCancelable(false);
                        this.goM.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.goM != null && this.goM.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.goM.cancel();
                        }
                        this.goM = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
