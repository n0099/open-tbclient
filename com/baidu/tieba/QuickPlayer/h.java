package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.android.util.devices.RomUtils;
import java.lang.reflect.Field;
/* loaded from: classes13.dex */
public class h extends MediaPlayer {
    private b evY;
    private Handler ewa;
    private Handler.Callback ewb;

    /* loaded from: classes13.dex */
    public interface b {
        void handleOppoError(String str);
    }

    public h() {
        if (!TextUtils.isEmpty(Build.BRAND) && RomUtils.ROM_OPPO.toLowerCase().equals(Build.BRAND.toLowerCase())) {
            try {
                Field declaredField = MediaPlayer.class.getDeclaredField("mEventHandler");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (obj instanceof Handler) {
                    this.ewa = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.ewb = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                p(e);
            }
        }
    }

    /* loaded from: classes13.dex */
    private class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if ((h.this.ewb == null || !h.this.ewb.handleMessage(message)) && h.this.ewa != null) {
                    h.this.ewa.handleMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.this.p(e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Throwable th) {
        if (th != null) {
            String s = com.baidu.tieba.k.a.s(th);
            if (this.evY != null) {
                this.evY.handleOppoError(s);
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
        this.evY = bVar;
    }
}
