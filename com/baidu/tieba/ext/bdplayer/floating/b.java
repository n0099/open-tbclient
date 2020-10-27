package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.baidu.live.liveroom.e.h;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tieba.ext.bdplayer.floating.d;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.e.b {
    private static final String TAG = com.baidu.tieba.ext.bdplayer.a.d.class.getSimpleName();
    private d imV;
    private com.baidu.live.liveroom.e.a imW;
    private com.baidu.tieba.ext.bdplayer.a.a imX;
    private String imY;
    private f imZ;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.imZ = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.imX = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).crx();
            this.imY = str;
            this.imW = aVar;
            if (this.imX != null) {
                if (this.imZ != null) {
                    this.imZ.crv();
                }
                if (this.imV == null) {
                    this.imV = new d(this.mContext);
                }
                this.imV.setContentView(view);
                this.imV.setPlayer(this.imX);
                this.imV.setContext(this.mContext);
                this.imV.crs();
                this.imV.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean crp() {
                        if (b.this.imW != null) {
                            return b.this.imW.Nn();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void ch(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.imV != null) {
            if (!z) {
                this.imX.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.imV.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void No() {
        if (this.imV != null) {
            this.imV.SW();
        }
        this.imZ.Jl(this.imY);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Np() {
        return d.Np();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Nq() {
        return (this.imV != null && this.imV.cru()) || (this.imX != null && this.imX.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
