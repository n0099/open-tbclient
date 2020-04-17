package com.baidu.tieba.aiapps.apps.q;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.q;
import com.baidu.swan.apps.as.r;
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
/* loaded from: classes12.dex */
public class b implements Runnable {
    private boolean bZN;
    private ArrayList<MediaModel> caI;
    private String cbD;
    private String cbF;
    private com.baidu.swan.apps.media.chooser.c.d cbS;
    private HandlerC0449b eGF;
    private a eGG;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.caI = bundle.getParcelableArrayList("mediaModels");
        this.cbD = r.safeGetString(bundle, "swanAppId");
        this.bZN = r.c(bundle, "compressed", false);
        this.cbF = r.safeGetString(bundle, "swanTmpPath");
        this.cbS = dVar;
        this.eGF = new HandlerC0449b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bjx();
        if (this.eGF != null) {
            this.eGF.sendEmptyMessage(1);
        }
        if (this.bZN) {
            Iterator<MediaModel> it = this.caI.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.d.c.su(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.caI.iterator();
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
        if (this.eGF != null) {
            this.eGF.sendEmptyMessage(2);
        }
        if (this.cbS != null) {
            this.cbS.a(true, null, this.caI);
        }
        bjy();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bE = q.bE(this.cbF, file.getName());
            if (bE != null && bE.exists() && com.baidu.swan.d.c.copyFile(file, bE) != 0) {
                mediaModel.kx(bE.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File bE = q.bE(this.cbF, file.getName());
            if (bE != null) {
                mediaModel.kx(bE.getAbsolutePath());
                q.a(file, bE, i);
                mediaModel.setSize(bE.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File bE = q.bE(this.cbF, new File(videoModel.getPath()).getName());
            if (bE != null) {
                com.baidu.swan.d.c.copyFile(new File(videoModel.getPath()), bE);
                videoModel.kx(bE.getPath());
                videoModel.setSize(bE.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends com.baidu.swan.apps.y.a {
        private HandlerC0449b eGF;

        public a(HandlerC0449b handlerC0449b) {
            this.eGF = handlerC0449b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.eGF.eGI != null && this.eGF.eGI.isShowing()) {
                this.eGF.eGI.cancel();
                this.eGF.eGI = null;
            }
            if (this.eGF != null) {
                this.eGF.removeMessages(1);
                this.eGF.removeMessages(2);
                this.eGF = null;
            }
            b.this.bjy();
        }
    }

    private void bjx() {
        this.eGG = new a(this.eGF);
        com.baidu.swan.apps.w.a.abO().registerActivityLifecycleCallbacks(this.eGG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjy() {
        if (this.eGG != null) {
            com.baidu.swan.apps.w.a.abO().unregisterActivityLifecycleCallbacks(this.eGG);
            this.eGG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0449b extends Handler {
        private Dialog eGI;
        private WeakReference<Context> mReference;

        private HandlerC0449b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.eGI = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.eGI.setContentView(R.layout.swanapp_progress_dialog);
                        this.eGI.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState() ? 0 : 8);
                        this.eGI.setCancelable(false);
                        this.eGI.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.eGI != null && this.eGI.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.eGI.cancel();
                        }
                        this.eGI = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
