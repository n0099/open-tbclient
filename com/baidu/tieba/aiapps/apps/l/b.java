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
import com.baidu.swan.apps.aq.r;
import com.baidu.swan.apps.aq.s;
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
    private boolean ckw;
    private ArrayList<MediaModel> clr;
    private com.baidu.swan.apps.media.chooser.c.d cmC;
    private String cmn;
    private String cmp;
    private HandlerC0515b eTo;
    private a eTp;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.clr = bundle.getParcelableArrayList("mediaModels");
        this.cmn = s.safeGetString(bundle, "swanAppId");
        this.ckw = s.c(bundle, "compressed", false);
        this.cmp = s.safeGetString(bundle, "swanTmpPath");
        this.cmC = dVar;
        this.eTo = new HandlerC0515b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        boM();
        if (this.eTo != null) {
            this.eTo.sendEmptyMessage(1);
        }
        if (this.ckw) {
            Iterator<MediaModel> it = this.clr.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.e.d.tY(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.clr.iterator();
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
        if (this.eTo != null) {
            this.eTo.sendEmptyMessage(2);
        }
        if (this.cmC != null) {
            this.cmC.a(true, null, this.clr);
        }
        boN();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File ca = r.ca(this.cmp, file.getName());
            if (ca != null && ca.exists() && com.baidu.swan.e.d.copyFile(file, ca) != 0) {
                mediaModel.lK(ca.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File ca = r.ca(this.cmp, file.getName());
            if (ca != null) {
                mediaModel.lK(ca.getAbsolutePath());
                r.a(file, ca, i);
                mediaModel.setSize(ca.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File ca = r.ca(this.cmp, new File(videoModel.getPath()).getName());
            if (ca != null) {
                com.baidu.swan.e.d.copyFile(new File(videoModel.getPath()), ca);
                videoModel.lK(ca.getPath());
                videoModel.setSize(ca.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends com.baidu.swan.apps.w.a {
        private HandlerC0515b eTo;

        public a(HandlerC0515b handlerC0515b) {
            this.eTo = handlerC0515b;
        }

        @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.eTo.eTr != null && this.eTo.eTr.isShowing()) {
                this.eTo.eTr.cancel();
                this.eTo.eTr = null;
            }
            if (this.eTo != null) {
                this.eTo.removeMessages(1);
                this.eTo.removeMessages(2);
                this.eTo = null;
            }
            b.this.boN();
        }
    }

    private void boM() {
        this.eTp = new a(this.eTo);
        com.baidu.swan.apps.u.a.aeR().registerActivityLifecycleCallbacks(this.eTp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boN() {
        if (this.eTp != null) {
            com.baidu.swan.apps.u.a.aeR().unregisterActivityLifecycleCallbacks(this.eTp);
            this.eTp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0515b extends Handler {
        private Dialog eTr;
        private WeakReference<Context> mReference;

        private HandlerC0515b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.eTr = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.eTr.setContentView(R.layout.swanapp_progress_dialog);
                        this.eTr.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState() ? 0 : 8);
                        this.eTr.setCancelable(false);
                        this.eTr.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.eTr != null && this.eTr.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.eTr.cancel();
                        }
                        this.eTr = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
