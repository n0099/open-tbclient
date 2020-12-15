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
    private d iEB;
    private com.baidu.live.liveroom.e.a iEC;
    private com.baidu.tieba.ext.bdplayer.a.a iED;
    private String iEE;
    private f iEF;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iEF = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iED = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cxR();
            this.iEE = str;
            this.iEC = aVar;
            if (this.iED != null) {
                if (this.iEF != null) {
                    this.iEF.cxP();
                }
                if (this.iEB == null) {
                    this.iEB = new d(this.mContext);
                }
                this.iEB.setContentView(view);
                this.iEB.setPlayer(this.iED);
                this.iEB.setContext(this.mContext);
                this.iEB.cxM();
                this.iEB.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cxJ() {
                        if (b.this.iEC != null) {
                            return b.this.iEC.Pw();
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
        if (this.iEB != null) {
            if (!z) {
                this.iED.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iEB.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Px() {
        if (this.iEB != null) {
            this.iEB.Xt();
        }
        this.iEF.JT(this.iEE);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Py() {
        return d.Py();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Pz() {
        return (this.iEB != null && this.iEB.cxO()) || (this.iED != null && this.iED.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
