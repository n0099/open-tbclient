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
    private boolean bBG;
    private ArrayList<MediaModel> bCp;
    private String bDf;
    private String bDh;
    private com.baidu.swan.apps.media.chooser.c.d bDu;
    private HandlerC0418b egP;
    private a egQ;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.bCp = bundle.getParcelableArrayList("mediaModels");
        this.bDf = r.safeGetString(bundle, "swanAppId");
        this.bBG = r.c(bundle, "compressed", false);
        this.bDh = r.safeGetString(bundle, "swanTmpPath");
        this.bDu = dVar;
        this.egP = new HandlerC0418b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        bbu();
        if (this.egP != null) {
            this.egP.sendEmptyMessage(1);
        }
        if (this.bBG) {
            Iterator<MediaModel> it = this.bCp.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.d.c.rg(next.getPath()), BaseBrowseView.IMG_TYPE_GIF)) {
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
            Iterator<MediaModel> it2 = this.bCp.iterator();
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
        if (this.egP != null) {
            this.egP.sendEmptyMessage(2);
        }
        if (this.bDu != null) {
            this.bDu.onResult(true, null, this.bCp);
        }
        bbv();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bt = q.bt(this.bDh, file.getName());
            if (bt != null && bt.exists() && com.baidu.swan.d.c.copyFile(file, bt) != 0) {
                mediaModel.jk(bt.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File bt = q.bt(this.bDh, file.getName());
            if (bt != null) {
                mediaModel.jk(bt.getAbsolutePath());
                q.a(file, bt, i);
                mediaModel.setSize(bt.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File bt = q.bt(this.bDh, new File(videoModel.getPath()).getName());
            if (bt != null) {
                com.baidu.swan.d.c.copyFile(new File(videoModel.getPath()), bt);
                videoModel.jk(bt.getPath());
                videoModel.setSize(bt.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends com.baidu.swan.apps.y.a {
        private HandlerC0418b egP;

        public a(HandlerC0418b handlerC0418b) {
            this.egP = handlerC0418b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.egP.egS != null && this.egP.egS.isShowing()) {
                this.egP.egS.cancel();
                this.egP.egS = null;
            }
            if (this.egP != null) {
                this.egP.removeMessages(1);
                this.egP.removeMessages(2);
                this.egP = null;
            }
            b.this.bbv();
        }
    }

    private void bbu() {
        this.egQ = new a(this.egP);
        com.baidu.swan.apps.w.a.TZ().registerActivityLifecycleCallbacks(this.egQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbv() {
        if (this.egQ != null) {
            com.baidu.swan.apps.w.a.TZ().unregisterActivityLifecycleCallbacks(this.egQ);
            this.egQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class HandlerC0418b extends Handler {
        private Dialog egS;
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
                        this.egS = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.egS.setContentView(R.layout.swanapp_progress_dialog);
                        this.egS.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState() ? 0 : 8);
                        this.egS.setCancelable(false);
                        this.egS.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.egS != null && this.egS.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.egS.cancel();
                        }
                        this.egS = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
