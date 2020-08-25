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
    private String cAS;
    private String cAU;
    private ArrayList<MediaModel> czZ;
    private boolean czg;
    private com.baidu.swan.apps.media.chooser.c.d ftQ;
    private HandlerC0580b ftR;
    private a ftS;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.czZ = bundle.getParcelableArrayList("mediaModels");
        this.cAS = u.safeGetString(bundle, "swanAppId");
        this.czg = u.c(bundle, "compressed", false);
        this.cAU = u.safeGetString(bundle, "swanTmpPath");
        this.ftQ = dVar;
        this.ftR = new HandlerC0580b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bDq();
        if (this.ftR != null) {
            this.ftR.sendEmptyMessage(1);
        }
        if (this.czg) {
            Iterator<MediaModel> it = this.czZ.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.xu(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.czZ.iterator();
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
        if (this.ftR != null) {
            this.ftR.sendEmptyMessage(2);
        }
        if (this.ftQ != null) {
            this.ftQ.a(true, null, this.czZ);
        }
        bDr();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cv = t.cv(this.cAU, file.getName());
            if (cv != null && cv.exists() && com.baidu.swan.c.d.copyFile(file, cv) != 0) {
                mediaModel.os(cv.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cv = t.cv(this.cAU, file.getName());
            if (cv != null) {
                mediaModel.os(cv.getAbsolutePath());
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
            File cv = t.cv(this.cAU, new File(videoModel.getPath()).getName());
            if (cv != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cv);
                videoModel.os(cv.getPath());
                videoModel.setSize(cv.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0580b ftR;

        public a(HandlerC0580b handlerC0580b) {
            this.ftR = handlerC0580b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.ftR.ftU != null && this.ftR.ftU.isShowing()) {
                this.ftR.ftU.cancel();
                this.ftR.ftU = null;
            }
            if (this.ftR != null) {
                this.ftR.removeMessages(1);
                this.ftR.removeMessages(2);
                this.ftR = null;
            }
            b.this.bDr();
        }
    }

    private void bDq() {
        this.ftS = new a(this.ftR);
        com.baidu.swan.apps.t.a.aoJ().registerActivityLifecycleCallbacks(this.ftS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDr() {
        if (this.ftS != null) {
            com.baidu.swan.apps.t.a.aoJ().unregisterActivityLifecycleCallbacks(this.ftS);
            this.ftS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class HandlerC0580b extends Handler {
        private Dialog ftU;
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
                        this.ftU = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.ftU.setContentView(R.layout.swanapp_progress_dialog);
                        this.ftU.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState() ? 0 : 8);
                        this.ftU.setCancelable(false);
                        this.ftU.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.ftU != null && this.ftU.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.ftU.cancel();
                        }
                        this.ftU = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
