package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
import java.lang.reflect.Field;
/* loaded from: classes2.dex */
public class h extends MediaPlayer {
    private b bNJ;
    private Handler bNL;
    private Handler.Callback bNM;

    /* loaded from: classes2.dex */
    public interface b {
        void handleOppoError(String str);
    }

    public h() {
        if (!TextUtils.isEmpty(Build.BRAND) && RomTypeUtil.ROM_OPPO.toLowerCase().equals(Build.BRAND.toLowerCase())) {
            try {
                Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (obj instanceof Handler) {
                    this.bNL = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.bNM = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                h(e);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if ((h.this.bNM == null || !h.this.bNM.handleMessage(message)) && h.this.bNL != null) {
                    h.this.bNL.handleMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.this.h(e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th) {
        if (th != null) {
            String i = com.baidu.tieba.i.a.i(th);
            if (this.bNJ != null) {
                this.bNJ.handleOppoError(i);
            }
        }
    }

    @Override // android.media.MediaPlayer
    public void setSurface(Surface surface) {
        if (surface != null && surface.isValid()) {
            super.setSurface(surface);
        }
    }

    public void a(b bVar) {
        this.bNJ = bVar;
    }
}
