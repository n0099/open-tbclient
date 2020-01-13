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
/* loaded from: classes10.dex */
public class b implements Runnable {
    private ArrayList<MediaModel> bxV;
    private boolean bxm;
    private String byL;
    private String byN;
    private com.baidu.swan.apps.media.chooser.c.d bza;
    private HandlerC0407b eci;
    private a ecj;
    private Context mContext;

    public b(Context context, Bundle bundle, com.baidu.swan.apps.media.chooser.c.d dVar) {
        this.mContext = context;
        this.bxV = bundle.getParcelableArrayList("mediaModels");
        this.byL = r.safeGetString(bundle, "swanAppId");
        this.bxm = r.c(bundle, "compressed", false);
        this.byN = r.safeGetString(bundle, "swanTmpPath");
        this.bza = dVar;
        this.eci = new HandlerC0407b(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        aYY();
        if (this.eci != null) {
            this.eci.sendEmptyMessage(1);
        }
        if (this.bxm) {
            Iterator<MediaModel> it = this.bxV.iterator();
            while (it.hasNext()) {
                MediaModel next = it.next();
                if (next != null) {
                    if (next instanceof ImageModel) {
                        if (TextUtils.equals(com.baidu.swan.d.c.qS(next.getPath()), BaseBrowseView.IMG_TYPE_GIF)) {
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
            Iterator<MediaModel> it2 = this.bxV.iterator();
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
        if (this.eci != null) {
            this.eci.sendEmptyMessage(2);
        }
        if (this.bza != null) {
            this.bza.onResult(true, null, this.bxV);
        }
        aYZ();
    }

    private void i(MediaModel mediaModel) {
        if (mediaModel != null) {
            File file = new File(mediaModel.getPath());
            File bl = q.bl(this.byN, file.getName());
            if (bl != null && bl.exists() && com.baidu.swan.d.c.copyFile(file, bl) != 0) {
                mediaModel.iW(bl.getPath());
            }
        }
    }

    private void b(MediaModel mediaModel, int i) {
        if (mediaModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressImg : " + mediaModel.getPath());
            }
            File file = new File(mediaModel.getPath());
            File bl = q.bl(this.byN, file.getName());
            if (bl != null) {
                mediaModel.iW(bl.getAbsolutePath());
                q.a(file, bl, i);
                mediaModel.setSize(bl.length());
            }
        }
    }

    private void a(VideoModel videoModel) {
        if (videoModel != null) {
            if (com.baidu.swan.apps.media.chooser.b.c.DEBUG) {
                Log.d("CompressTask", "compressVideo : " + videoModel.getPath());
            }
            File bl = q.bl(this.byN, new File(videoModel.getPath()).getName());
            if (bl != null) {
                com.baidu.swan.d.c.copyFile(new File(videoModel.getPath()), bl);
                videoModel.iW(bl.getPath());
                videoModel.setSize(bl.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends com.baidu.swan.apps.y.a {
        private HandlerC0407b eci;

        public a(HandlerC0407b handlerC0407b) {
            this.eci = handlerC0407b;
        }

        @Override // com.baidu.swan.apps.y.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (!(activity instanceof SwanAppActivity) && !(activity instanceof SwanAppAlbumActivity) && !(activity instanceof SwanAppAlbumPreviewActivity)) {
                return;
            }
            if (this.eci.ecl != null && this.eci.ecl.isShowing()) {
                this.eci.ecl.cancel();
                this.eci.ecl = null;
            }
            if (this.eci != null) {
                this.eci.removeMessages(1);
                this.eci.removeMessages(2);
                this.eci = null;
            }
            b.this.aYZ();
        }
    }

    private void aYY() {
        this.ecj = new a(this.eci);
        com.baidu.swan.apps.w.a.RG().registerActivityLifecycleCallbacks(this.ecj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYZ() {
        if (this.ecj != null) {
            com.baidu.swan.apps.w.a.RG().unregisterActivityLifecycleCallbacks(this.ecj);
            this.ecj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0407b extends Handler {
        private Dialog ecl;
        private WeakReference<Context> mReference;

        private HandlerC0407b(Context context) {
            this.mReference = new WeakReference<>(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Context context = this.mReference.get();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                        this.ecl = new Dialog(this.mReference.get(), R.style.SwanAppCompressDialog);
                        this.ecl.setContentView(R.layout.swanapp_progress_dialog);
                        this.ecl.findViewById(R.id.layer_night).setVisibility(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState() ? 0 : 8);
                        this.ecl.setCancelable(false);
                        this.ecl.show();
                        return;
                    }
                    return;
                case 2:
                    if (this.ecl != null && this.ecl.isShowing()) {
                        Context context2 = this.mReference.get();
                        if ((context2 instanceof Activity) && !((Activity) context2).isFinishing()) {
                            this.ecl.cancel();
                        }
                        this.ecl = null;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
