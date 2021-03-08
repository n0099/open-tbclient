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
/* loaded from: classes8.dex */
public class b implements Runnable {
    private boolean dkQ;
    private ArrayList<MediaModel> dlI;
    private String dmF;
    private String dmI;
    private com.baidu.swan.apps.media.chooser.listener.d goF;
    private HandlerC0611b goG;
    private a goH;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.listener.d dVar) {
        this.mContext = context;
        this.dlI = bundle.getParcelableArrayList("mediaModels");
        this.dmF = u.h(bundle, "swanAppId");
        this.dkQ = u.c(bundle, "compressed", false);
        this.dmI = u.h(bundle, "swanTmpPath");
        this.goF = dVar;
        this.goG = new HandlerC0611b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bNZ();
        if (this.goG != null) {
            this.goG.sendEmptyMessage(1);
        }
        if (this.dkQ) {
            Iterator<MediaModel> it = this.dlI.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.yW(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.dlI.iterator();
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
        if (this.goG != null) {
            this.goG.sendEmptyMessage(2);
        }
        if (this.goF != null) {
            this.goF.a(true, null, this.dlI);
        }
        bOa();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cF = t.cF(this.dmI, file.getName());
            if (cF != null && cF.exists() && com.baidu.swan.c.d.copyFile(file, cF) != 0) {
                mediaModel.pO(cF.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cF = t.cF(this.dmI, file.getName());
            if (cF != null) {
                mediaModel.pO(cF.getAbsolutePath());
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
            File cF = t.cF(this.dmI, new File(videoModel.getPath()).getName());
            if (cF != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cF);
                videoModel.pO(cF.getPath());
                videoModel.setSize(cF.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0611b goG;

        public a(HandlerC0611b handlerC0611b) {
            this.goG = handlerC0611b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.goG.goJ != null && this.goG.goJ.isShowing()) {
                this.goG.goJ.cancel();
                this.goG.goJ = null;
            }
            if (this.goG != null) {
                this.goG.removeMessages(1);
                this.goG.removeMessages(2);
                this.goG = null;
            }
            b.this.bOa();
        }
    }

    private void bNZ() {
        this.goH = new a(this.goG);
        com.baidu.swan.apps.t.a.awZ().registerActivityLifecycleCallbacks(this.goH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOa() {
        if (this.goH != null) {
            com.baidu.swan.apps.t.a.awZ().unregisterActivityLifecycleCallbacks(this.goH);
            this.goH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0611b extends Handler {
        private Dialog goJ;
        private WeakReference<Context> mReference;

        private HandlerC0611b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.goJ = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.goJ.setContentView(R.layout.swanapp_progress_dialog);
                        this.goJ.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.axv().ail() ? 0 : 8);
                        this.goJ.setCancelable(false);
                        this.goJ.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.goJ != null && this.goJ.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.goJ.cancel();
                        }
                        this.goJ = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
