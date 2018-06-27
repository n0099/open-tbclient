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
    private Handler bjA;
    private Handler.Callback bjB;
    private b bjy;

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
                    this.bjA = (Handler) obj;
                    Field declaredField2 = Handler.class.getDeclaredField("mCallback");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 instanceof Handler.Callback) {
                        this.bjB = (Handler.Callback) obj2;
                    }
                    declaredField2.set(obj, new a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                l(e);
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
                if ((h.this.bjB == null || !h.this.bjB.handleMessage(message)) && h.this.bjA != null) {
                    h.this.bjA.handleMessage(message);
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
            String m = com.baidu.tieba.j.a.m(th);
            if (this.bjy != null) {
                this.bjy.handleOppoError(m);
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
        this.bjy = bVar;
    }
}
