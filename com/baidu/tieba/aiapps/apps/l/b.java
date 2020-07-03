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
    private boolean cpl;
    private ArrayList<MediaModel> cqf;
    private String cra;
    private String crd;
    private com.baidu.swan.apps.media.chooser.c.d crq;
    private HandlerC0523b fdK;
    private a fdL;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.cqf = bundle.getParcelableArrayList("mediaModels");
        this.cra = s.safeGetString(bundle, "swanAppId");
        this.cpl = s.c(bundle, "compressed", false);
        this.crd = s.safeGetString(bundle, "swanTmpPath");
        this.crq = dVar;
        this.fdK = new HandlerC0523b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bro();
        if (this.fdK != null) {
            this.fdK.sendEmptyMessage(1);
        }
        if (this.cpl) {
            Iterator<MediaModel> it = this.cqf.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.e.d.ug(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.cqf.iterator();
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
        if (this.fdK != null) {
            this.fdK.sendEmptyMessage(2);
        }
        if (this.crq != null) {
            this.crq.a(true, null, this.cqf);
        }
        brp();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cc = r.cc(this.crd, file.getName());
            if (cc != null && cc.exists() && com.baidu.swan.e.d.copyFile(file, cc) != 0) {
                mediaModel.lS(cc.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cc = r.cc(this.crd, file.getName());
            if (cc != null) {
                mediaModel.lS(cc.getAbsolutePath());
                r.a(file, cc, i);
                mediaModel.setSize(cc.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cc = r.cc(this.crd, new File(videoModel.getPath()).getName());
            if (cc != null) {
                com.baidu.swan.e.d.copyFile(new File(videoModel.getPath()), cc);
                videoModel.lS(cc.getPath());
                videoModel.setSize(cc.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends com.baidu.swan.apps.w.a {
        private HandlerC0523b fdK;

        public a(HandlerC0523b handlerC0523b) {
            this.fdK = handlerC0523b;
        }

        @Override // com.baidu.swan.apps.w.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.fdK.fdN != null && this.fdK.fdN.isShowing()) {
                this.fdK.fdN.cancel();
                this.fdK.fdN = null;
            }
            if (this.fdK != null) {
                this.fdK.removeMessages(1);
                this.fdK.removeMessages(2);
                this.fdK = null;
            }
            b.this.brp();
        }
    }

    private void bro() {
        this.fdL = new a(this.fdK);
        com.baidu.swan.apps.u.a.afX().registerActivityLifecycleCallbacks(this.fdL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brp() {
        if (this.fdL != null) {
            com.baidu.swan.apps.u.a.afX().unregisterActivityLifecycleCallbacks(this.fdL);
            this.fdL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0523b extends Handler {
        private Dialog fdN;
        private WeakReference<Context> mReference;

        private HandlerC0523b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.fdN = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.fdN.setContentView(R.layout.swanapp_progress_dialog);
                        this.fdN.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState() ? 0 : 8);
                        this.fdN.setCancelable(false);
                        this.fdN.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.fdN != null && this.fdN.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.fdN.cancel();
                        }
                        this.fdN = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
