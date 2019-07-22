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
    private b cTM;
    private Handler cTO;
    private Handler.Callback cTP;

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
                    this.cTO = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.cTP = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                m(e);
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
                if ((h.this.cTP == null || !h.this.cTP.handleMessage(message)) && h.this.cTO != null) {
                    h.this.cTO.handleMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.this.m(e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Throwable th) {
        if (th != null) {
            String p = com.baidu.tieba.j.a.p(th);
            if (this.cTM != null) {
                this.cTM.handleOppoError(p);
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
        this.cTM = bVar;
    }
}
