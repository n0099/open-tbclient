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
    private boolean bZT;
    private ArrayList<MediaModel> caO;
    private String cbJ;
    private String cbL;
    private com.baidu.swan.apps.media.chooser.c.d cbY;
    private HandlerC0470b eGK;
    private a eGL;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.caO = bundle.getParcelableArrayList("mediaModels");
        this.cbJ = r.safeGetString(bundle, "swanAppId");
        this.bZT = r.c(bundle, "compressed", false);
        this.cbL = r.safeGetString(bundle, "swanTmpPath");
        this.cbY = dVar;
        this.eGK = new HandlerC0470b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bjv();
        if (this.eGK != null) {
            this.eGK.sendEmptyMessage(1);
        }
        if (this.bZT) {
            Iterator<MediaModel> it = this.caO.iterator();
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
            Iterator<MediaModel> it2 = this.caO.iterator();
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
        if (this.eGK != null) {
            this.eGK.sendEmptyMessage(2);
        }
        if (this.cbY != null) {
            this.cbY.a(true, null, this.caO);
        }
        bjw();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bE = q.bE(this.cbL, file.getName());
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
            File bE = q.bE(this.cbL, file.getName());
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
            File bE = q.bE(this.cbL, new File(videoModel.getPath()).getName());
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
        private HandlerC0470b eGK;

        public a(HandlerC0470b handlerC0470b) {
            this.eGK = handlerC0470b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.eGK.eGN != null && this.eGK.eGN.isShowing()) {
                this.eGK.eGN.cancel();
                this.eGK.eGN = null;
            }
            if (this.eGK != null) {
                this.eGK.removeMessages(1);
                this.eGK.removeMessages(2);
                this.eGK = null;
            }
            b.this.bjw();
        }
    }

    private void bjv() {
        this.eGL = new a(this.eGK);
        com.baidu.swan.apps.w.a.abN().registerActivityLifecycleCallbacks(this.eGL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjw() {
        if (this.eGL != null) {
            com.baidu.swan.apps.w.a.abN().unregisterActivityLifecycleCallbacks(this.eGL);
            this.eGL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0470b extends Handler {
        private Dialog eGN;
        private WeakReference<Context> mReference;

        private HandlerC0470b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.eGN = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.eGN.setContentView(R.layout.swanapp_progress_dialog);
                        this.eGN.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState() ? 0 : 8);
                        this.eGN.setCancelable(false);
                        this.eGN.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.eGN != null && this.eGN.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.eGN.cancel();
                        }
                        this.eGN = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
