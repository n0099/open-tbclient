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
    private boolean bBv;
    private String bCU;
    private String bCW;
    private ArrayList<MediaModel> bCe;
    private com.baidu.swan.apps.media.chooser.c.d bDj;
    private a egA;
    private HandlerC0418b egz;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.bCe = bundle.getParcelableArrayList("mediaModels");
        this.bCU = r.safeGetString(bundle, "swanAppId");
        this.bBv = r.c(bundle, "compressed", false);
        this.bCW = r.safeGetString(bundle, "swanTmpPath");
        this.bDj = dVar;
        this.egz = new HandlerC0418b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bbq();
        if (this.egz != null) {
            this.egz.sendEmptyMessage(1);
        }
        if (this.bBv) {
            Iterator<MediaModel> it = this.bCe.iterator();
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
            Iterator<MediaModel> it2 = this.bCe.iterator();
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
        if (this.egz != null) {
            this.egz.sendEmptyMessage(2);
        }
        if (this.bDj != null) {
            this.bDj.onResult(true, null, this.bCe);
        }
        bbr();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bu = q.bu(this.bCW, file.getName());
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
            File bu = q.bu(this.bCW, file.getName());
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
            File bu = q.bu(this.bCW, new File(videoModel.getPath()).getName());
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
        private HandlerC0418b egz;

        public a(HandlerC0418b handlerC0418b) {
            this.egz = handlerC0418b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.egz.egC != null && this.egz.egC.isShowing()) {
                this.egz.egC.cancel();
                this.egz.egC = null;
            }
            if (this.egz != null) {
                this.egz.removeMessages(1);
                this.egz.removeMessages(2);
                this.egz = null;
            }
            b.this.bbr();
        }
    }

    private void bbq() {
        this.egA = new a(this.egz);
        com.baidu.swan.apps.w.a.TW().registerActivityLifecycleCallbacks(this.egA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbr() {
        if (this.egA != null) {
            com.baidu.swan.apps.w.a.TW().unregisterActivityLifecycleCallbacks(this.egA);
            this.egA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0418b extends Handler {
        private Dialog egC;
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
                        this.egC = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.egC.setContentView(R.layout.swanapp_progress_dialog);
                        this.egC.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState() ? 0 : 8);
                        this.egC.setCancelable(false);
                        this.egC.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.egC != null && this.egC.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.egC.cancel();
                        }
                        this.egC = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
