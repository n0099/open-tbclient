package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.liveroom.e.h;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tieba.ext.bdplayer.floating.d;
/* loaded from: classes10.dex */
public class b implements com.baidu.live.liveroom.e.b {
    private static final String TAG = com.baidu.tieba.ext.bdplayer.a.d.class.getSimpleName();
    private d iMg;
    private com.baidu.live.liveroom.e.a iMh;
    private com.baidu.tieba.ext.bdplayer.a.a iMi;
    private String iMj;
    private f iMk;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iMk = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iMi = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cwT();
            this.iMj = str;
            this.iMh = aVar;
            if (this.iMi != null) {
                if (this.iMk != null) {
                    this.iMk.cwR();
                }
                if (this.iMg == null) {
                    this.iMg = new d(this.mContext);
                }
                this.iMg.setContentView(view);
                this.iMg.setPlayer(this.iMi);
                this.iMg.setContext(this.mContext);
                this.iMg.cwO();
                this.iMg.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cwL() {
                        if (b.this.iMh != null) {
                            return b.this.iMh.Lp();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cx(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.iMg != null) {
            if (!z) {
                this.iMi.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iMg.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Lq() {
        if (this.iMg != null) {
            this.iMg.UH();
        }
        this.iMk.IF(this.iMj);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Lr() {
        return d.Lr();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Ls() {
        return (this.iMg != null && this.iMg.cwQ()) || (this.iMi != null && this.iMi.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
