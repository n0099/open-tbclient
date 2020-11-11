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
    private d isT;
    private com.baidu.live.liveroom.e.a isU;
    private com.baidu.tieba.ext.bdplayer.a.a isV;
    private String isW;
    private f isX;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.isX = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.isV = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).ctY();
            this.isW = str;
            this.isU = aVar;
            if (this.isV != null) {
                if (this.isX != null) {
                    this.isX.ctW();
                }
                if (this.isT == null) {
                    this.isT = new d(this.mContext);
                }
                this.isT.setContentView(view);
                this.isT.setPlayer(this.isV);
                this.isT.setContext(this.mContext);
                this.isT.ctT();
                this.isT.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean ctQ() {
                        if (b.this.isU != null) {
                            return b.this.isU.NN();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void ci(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.isT != null) {
            if (!z) {
                this.isV.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.isT.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void NO() {
        if (this.isT != null) {
            this.isT.VC();
        }
        this.isX.JC(this.isW);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean NP() {
        return d.NP();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean NQ() {
        return (this.isT != null && this.isT.ctV()) || (this.isV != null && this.isV.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
