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
    private ArrayList<MediaModel> dhT;
    private boolean dhb;
    private String diT;
    private String diW;
    private com.baidu.swan.apps.media.chooser.listener.d gkb;
    private HandlerC0605b gkc;
    private a gkd;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.listener.d dVar) {
        this.mContext = context;
        this.dhT = bundle.getParcelableArrayList("mediaModels");
        this.diT = u.h(bundle, "swanAppId");
        this.dhb = u.c(bundle, "compressed", false);
        this.diW = u.h(bundle, "swanTmpPath");
        this.gkb = dVar;
        this.gkc = new HandlerC0605b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bNl();
        if (this.gkc != null) {
            this.gkc.sendEmptyMessage(1);
        }
        if (this.dhb) {
            Iterator<MediaModel> it = this.dhT.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.c.d.yx(next.getPath()), "gif")) {
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
            Iterator<MediaModel> it2 = this.dhT.iterator();
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
        if (this.gkc != null) {
            this.gkc.sendEmptyMessage(2);
        }
        if (this.gkb != null) {
            this.gkb.a(true, null, this.dhT);
        }
        bNm();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File cL = t.cL(this.diW, file.getName());
            if (cL != null && cL.exists() && com.baidu.swan.c.d.copyFile(file, cL) != 0) {
                mediaModel.pp(cL.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File cL = t.cL(this.diW, file.getName());
            if (cL != null) {
                mediaModel.pp(cL.getAbsolutePath());
                t.a(file, cL, i);
                mediaModel.setSize(cL.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File cL = t.cL(this.diW, new File(videoModel.getPath()).getName());
            if (cL != null) {
                com.baidu.swan.c.d.copyFile(new File(videoModel.getPath()), cL);
                videoModel.pp(cL.getPath());
                videoModel.setSize(cL.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.swan.apps.v.a {
        private HandlerC0605b gkc;

        public a(HandlerC0605b handlerC0605b) {
            this.gkc = handlerC0605b;
        }

        @Override // com.baidu.swan.apps.v.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.gkc.gkf != null && this.gkc.gkf.isShowing()) {
                this.gkc.gkf.cancel();
                this.gkc.gkf = null;
            }
            if (this.gkc != null) {
                this.gkc.removeMessages(1);
                this.gkc.removeMessages(2);
                this.gkc = null;
            }
            b.this.bNm();
        }
    }

    private void bNl() {
        this.gkd = new a(this.gkc);
        com.baidu.swan.apps.t.a.awy().registerActivityLifecycleCallbacks(this.gkd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNm() {
        if (this.gkd != null) {
            com.baidu.swan.apps.t.a.awy().unregisterActivityLifecycleCallbacks(this.gkd);
            this.gkd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0605b extends Handler {
        private Dialog gkf;
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
                        this.gkf = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.gkf.setContentView(R.layout.swanapp_progress_dialog);
                        this.gkf.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.t.a.awU().ahK() ? 0 : 8);
                        this.gkf.setCancelable(false);
                        this.gkf.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.gkf != null && this.gkf.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.gkf.cancel();
                        }
                        this.gkf = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
