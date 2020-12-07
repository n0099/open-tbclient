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
    private com.baidu.live.liveroom.e.a iEA;
    private com.baidu.tieba.ext.bdplayer.a.a iEB;
    private String iEC;
    private f iED;
    private d iEz;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iED = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iEB = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cxQ();
            this.iEC = str;
            this.iEA = aVar;
            if (this.iEB != null) {
                if (this.iED != null) {
                    this.iED.cxO();
                }
                if (this.iEz == null) {
                    this.iEz = new d(this.mContext);
                }
                this.iEz.setContentView(view);
                this.iEz.setPlayer(this.iEB);
                this.iEz.setContext(this.mContext);
                this.iEz.cxL();
                this.iEz.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cxI() {
                        if (b.this.iEA != null) {
                            return b.this.iEA.Pw();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cy(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.iEz != null) {
            if (!z) {
                this.iEB.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iEz.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Px() {
        if (this.iEz != null) {
            this.iEz.Xt();
        }
        this.iED.JT(this.iEC);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Py() {
        return d.Py();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Pz() {
        return (this.iEz != null && this.iEz.cxN()) || (this.iEB != null && this.iEB.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
