package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class h extends MediaPlayer {
    private b deh;
    private Handler dej;
    private Handler.Callback dek;

    /* loaded from: classes3.dex */
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
                    this.dej = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.dek = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                l(e);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if ((h.this.dek == null || !h.this.dek.handleMessage(message)) && h.this.dej != null) {
                    h.this.dej.handleMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.this.l(e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Throwable th) {
        if (th != null) {
            String o = com.baidu.tieba.j.a.o(th);
            if (this.deh != null) {
                this.deh.handleOppoError(o);
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
        this.deh = bVar;
    }
}
