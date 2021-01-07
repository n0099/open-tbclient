package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.liveroom.e.h;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tieba.ext.bdplayer.floating.d;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.liveroom.e.b {
    private static final String TAG = com.baidu.tieba.ext.bdplayer.a.d.class.getSimpleName();
    private d iQN;
    private com.baidu.live.liveroom.e.a iQO;
    private com.baidu.tieba.ext.bdplayer.a.a iQP;
    private String iQQ;
    private f iQR;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iQR = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iQP = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cAL();
            this.iQQ = str;
            this.iQO = aVar;
            if (this.iQP != null) {
                if (this.iQR != null) {
                    this.iQR.cAJ();
                }
                if (this.iQN == null) {
                    this.iQN = new d(this.mContext);
                }
                this.iQN.setContentView(view);
                this.iQN.setPlayer(this.iQP);
                this.iQN.setContext(this.mContext);
                this.iQN.cAG();
                this.iQN.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cAD() {
                        if (b.this.iQO != null) {
                            return b.this.iQO.Pk();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cB(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.iQN != null) {
            if (!z) {
                this.iQP.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iQN.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Pl() {
        if (this.iQN != null) {
            this.iQN.YA();
        }
        this.iQR.JQ(this.iQQ);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Pm() {
        return d.Pm();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Pn() {
        return (this.iQN != null && this.iQN.cAI()) || (this.iQP != null && this.iQP.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
