package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class h extends MediaPlayer {
    private b byf;
    private Handler byh;
    private Handler.Callback byi;

    /* loaded from: classes5.dex */
    public interface b {
        void handleOppoError(String str);
    }

    public h() {
        if (!TextUtils.isEmpty(Build.BRAND) && "OPPO".toLowerCase().equals(Build.BRAND.toLowerCase())) {
            try {
                Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (obj instanceof Handler) {
                    this.byh = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.byi = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                n(e);
            }
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if ((h.this.byi == null || !h.this.byi.handleMessage(message)) && h.this.byh != null) {
                    h.this.byh.handleMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.this.n(e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Throwable th) {
        if (th != null) {
            String o = com.baidu.tieba.j.a.o(th);
            if (this.byf != null) {
                this.byf.handleOppoError(o);
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
        this.byf = bVar;
    }
}
