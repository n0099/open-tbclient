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
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.aq.u;
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
    private boolean crr;
    private ArrayList<MediaModel> csj;
    private String cte;
    private String ctg;
    private com.baidu.swan.apps.media.chooser.c.d fit;
    private HandlerC0534b fiu;
    private a fiv;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.csj = bundle.getParcelableArrayList("mediaModels");
        this.cte = u.safeGetString(bundle, "swanAppId");
        this.crr = u.c(bundle, "compressed", false);
        this.ctg = u.safeGetString(bundle, "swanTmpPath");
        this.fit = dVar;
        this.fiu = new HandlerC0534b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        buv();
        if (this.fiu != null) {
            this.fiu.sendEmptyMessage(1);
        }
        if (this.crr) {
            Iterator<MediaModel> it = this.csj.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.d.d.vj(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.csj.iterator();
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
        if (this.fiu != null) {
            this.fiu.sendEmptyMessage(2);
        }
        if (this.fit != null) {
            this.fit.a(true, null, this.csj);
        }
        buw();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cd = t.cd(this.ctg, file.getName());
            if (cd != null && cd.exists() && com.baidu.swan.d.d.copyFile(file, cd) != 0) {
                mediaModel.mt(cd.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cd = t.cd(this.ctg, file.getName());
            if (cd != null) {
                mediaModel.mt(cd.getAbsolutePath());
                t.a(file, cd, i);
                mediaModel.setSize(cd.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cd = t.cd(this.ctg, new File(videoModel.getPath()).getName());
            if (cd != null) {
                com.baidu.swan.d.d.copyFile(new File(videoModel.getPath()), cd);
                videoModel.mt(cd.getPath());
                videoModel.setSize(cd.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0534b fiu;

        public a(HandlerC0534b handlerC0534b) {
            this.fiu = handlerC0534b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fiu.fiy != null && this.fiu.fiy.isShowing()) {
                this.fiu.fiy.cancel();
                this.fiu.fiy = null;
            }
            if (this.fiu != null) {
                this.fiu.removeMessages(1);
                this.fiu.removeMessages(2);
                this.fiu = null;
            }
            b.this.buw();
        }
    }

    private void buv() {
        this.fiv = new a(this.fiu);
        com.baidu.swan.apps.t.a.ahj().registerActivityLifecycleCallbacks(this.fiv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buw() {
        if (this.fiv != null) {
            com.baidu.swan.apps.t.a.ahj().unregisterActivityLifecycleCallbacks(this.fiv);
            this.fiv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class HandlerC0534b extends Handler {
        private Dialog fiy;
        private WeakReference<Context> mReference;

        private HandlerC0534b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.fiy = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fiy.setContentView(R.layout.swanapp_progress_dialog);
                        this.fiy.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState() ? 0 : 8);
                        this.fiy.setCancelable(false);
                        this.fiy.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fiy != null && this.fiy.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fiy.cancel();
                        }
                        this.fiy = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
