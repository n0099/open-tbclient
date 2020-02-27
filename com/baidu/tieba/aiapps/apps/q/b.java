package com.baidu.tieba.aiapps.apps.q;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.picture.component.BaseBrowseView;
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
    private boolean bBt;
    private String bCS;
    private String bCU;
    private ArrayList<MediaModel> bCc;
    private com.baidu.swan.apps.media.chooser.c.d bDh;
    private HandlerC0418b egl;
    private a egm;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.bCc = bundle.getParcelableArrayList("mediaModels");
        this.bCS = r.safeGetString(bundle, "swanAppId");
        this.bBt = r.c(bundle, "compressed", false);
        this.bCU = r.safeGetString(bundle, "swanTmpPath");
        this.bDh = dVar;
        this.egl = new HandlerC0418b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bbn();
        if (this.egl != null) {
            this.egl.sendEmptyMessage(1);
        }
        if (this.bBt) {
            Iterator<MediaModel> it = this.bCc.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.d.c.rh(next.getPath()), BaseBrowseView.IMG_TYPE_GIF)) {
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
            Iterator<MediaModel> it2 = this.bCc.iterator();
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
        if (this.egl != null) {
            this.egl.sendEmptyMessage(2);
        }
        if (this.bDh != null) {
            this.bDh.onResult(true, null, this.bCc);
        }
        bbo();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bu = q.bu(this.bCU, file.getName());
            if (bu != null && bu.exists() && com.baidu.swan.d.c.copyFile(file, bu) != 0) {
                mediaModel.jl(bu.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File bu = q.bu(this.bCU, file.getName());
            if (bu != null) {
                mediaModel.jl(bu.getAbsolutePath());
                q.a(file, bu, i);
                mediaModel.setSize(bu.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File bu = q.bu(this.bCU, new File(videoModel.getPath()).getName());
            if (bu != null) {
                com.baidu.swan.d.c.copyFile(new File(videoModel.getPath()), bu);
                videoModel.jl(bu.getPath());
                videoModel.setSize(bu.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends com.baidu.swan.apps.y.a {
        private HandlerC0418b egl;

        public a(HandlerC0418b handlerC0418b) {
            this.egl = handlerC0418b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.egl.ego != null && this.egl.ego.isShowing()) {
                this.egl.ego.cancel();
                this.egl.ego = null;
            }
            if (this.egl != null) {
                this.egl.removeMessages(1);
                this.egl.removeMessages(2);
                this.egl = null;
            }
            b.this.bbo();
        }
    }

    private void bbn() {
        this.egm = new a(this.egl);
        com.baidu.swan.apps.w.a.TU().registerActivityLifecycleCallbacks(this.egm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbo() {
        if (this.egm != null) {
            com.baidu.swan.apps.w.a.TU().unregisterActivityLifecycleCallbacks(this.egm);
            this.egm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0418b extends Handler {
        private Dialog ego;
        private WeakReference<Context> mReference;

        private HandlerC0418b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.ego = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.ego.setContentView(R.layout.swanapp_progress_dialog);
                        this.ego.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState() ? 0 : 8);
                        this.ego.setCancelable(false);
                        this.ego.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.ego != null && this.ego.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.ego.cancel();
                        }
                        this.ego = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
