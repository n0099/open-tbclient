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
    private d iTL;
    private com.baidu.live.liveroom.e.a iTM;
    private com.baidu.tieba.ext.bdplayer.a.a iTN;
    private String iTO;
    private f iTP;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iTP = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iTN = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cyr();
            this.iTO = str;
            this.iTM = aVar;
            if (this.iTN != null) {
                if (this.iTP != null) {
                    this.iTP.cyp();
                }
                if (this.iTL == null) {
                    this.iTL = new d(this.mContext);
                }
                this.iTL.setContentView(view);
                this.iTL.setPlayer(this.iTN);
                this.iTL.setContext(this.mContext);
                this.iTL.cym();
                this.iTL.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cyk() {
                        if (b.this.iTM != null) {
                            return b.this.iTM.MQ();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cG(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.iTL != null) {
            if (!z) {
                this.iTN.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iTL.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void MR() {
        if (this.iTL != null) {
            this.iTL.Wt();
        }
        this.iTP.JA(this.iTO);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MS() {
        return d.MS();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MT() {
        return (this.iTL != null && this.iTL.cyo()) || (this.iTN != null && this.iTN.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
