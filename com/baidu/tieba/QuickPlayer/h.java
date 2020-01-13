package com.baidu.tieba.QuickPlayer;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.android.util.devices.RomUtils;
import java.lang.reflect.Field;
/* loaded from: classes11.dex */
public class h extends MediaPlayer {
    private b dRq;
    private Handler dRs;
    private Handler.Callback dRt;

    /* loaded from: classes11.dex */
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
                    this.dRs = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.dRt = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                o(e);
            }
        }
    }

    /* loaded from: classes11.dex */
    private class a implements Handler.Callback {
        private a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if ((h.this.dRt == null || !h.this.dRt.handleMessage(message)) && h.this.dRs != null) {
                    h.this.dRs.handleMessage(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                h.this.o(e);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Throwable th) {
        if (th != null) {
            String r = com.baidu.tieba.j.a.r(th);
            if (this.dRq != null) {
                this.dRq.handleOppoError(r);
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
        this.dRq = bVar;
    }
}
