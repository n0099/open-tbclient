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
/* loaded from: classes9.dex */
public class b implements Runnable {
    private boolean bwz;
    private String bxY;
    private ArrayList<MediaModel> bxi;
    private String bya;
    private com.baidu.swan.apps.media.chooser.c.d byn;
    private HandlerC0405b ebZ;
    private a eca;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.bxi = bundle.getParcelableArrayList("mediaModels");
        this.bxY = r.safeGetString(bundle, "swanAppId");
        this.bwz = r.c(bundle, "compressed", false);
        this.bya = r.safeGetString(bundle, "swanTmpPath");
        this.byn = dVar;
        this.ebZ = new HandlerC0405b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        aYE();
        if (this.ebZ != null) {
            this.ebZ.sendEmptyMessage(1);
        }
        if (this.bwz) {
            Iterator<MediaModel> it = this.bxi.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.d.c.qP(next.getPath()), BaseBrowseView.IMG_TYPE_GIF)) {
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
            Iterator<MediaModel> it2 = this.bxi.iterator();
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
        if (this.ebZ != null) {
            this.ebZ.sendEmptyMessage(2);
        }
        if (this.byn != null) {
            this.byn.onResult(true, null, this.bxi);
        }
        aYF();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bk = q.bk(this.bya, file.getName());
            if (bk != null && bk.exists() && com.baidu.swan.d.c.copyFile(file, bk) != 0) {
                mediaModel.iT(bk.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File bk = q.bk(this.bya, file.getName());
            if (bk != null) {
                mediaModel.iT(bk.getAbsolutePath());
                q.a(file, bk, i);
                mediaModel.setSize(bk.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File bk = q.bk(this.bya, new File(videoModel.getPath()).getName());
            if (bk != null) {
                com.baidu.swan.d.c.copyFile(new File(videoModel.getPath()), bk);
                videoModel.iT(bk.getPath());
                videoModel.setSize(bk.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.swan.apps.y.a {
        private HandlerC0405b ebZ;

        public a(HandlerC0405b handlerC0405b) {
            this.ebZ = handlerC0405b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.ebZ.ecc != null && this.ebZ.ecc.isShowing()) {
                this.ebZ.ecc.cancel();
                this.ebZ.ecc = null;
            }
            if (this.ebZ != null) {
                this.ebZ.removeMessages(1);
                this.ebZ.removeMessages(2);
                this.ebZ = null;
            }
            b.this.aYF();
        }
    }

    private void aYE() {
        this.eca = new a(this.ebZ);
        com.baidu.swan.apps.w.a.Rk().registerActivityLifecycleCallbacks(this.eca);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYF() {
        if (this.eca != null) {
            com.baidu.swan.apps.w.a.Rk().unregisterActivityLifecycleCallbacks(this.eca);
            this.eca = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC0405b extends Handler {
        private Dialog ecc;
        private WeakReference<Context> mReference;

        private HandlerC0405b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.ecc = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.ecc.setContentView(R.layout.swanapp_progress_dialog);
                        this.ecc.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState() ? 0 : 8);
                        this.ecc.setCancelable(false);
                        this.ecc.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.ecc != null && this.ecc.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.ecc.cancel();
                        }
                        this.ecc = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
