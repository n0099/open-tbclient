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
    private d iRO;
    private com.baidu.live.liveroom.e.a iRP;
    private com.baidu.tieba.ext.bdplayer.a.a iRQ;
    private String iRR;
    private f iRS;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iRS = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iRQ = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cye();
            this.iRR = str;
            this.iRP = aVar;
            if (this.iRQ != null) {
                if (this.iRS != null) {
                    this.iRS.cyc();
                }
                if (this.iRO == null) {
                    this.iRO = new d(this.mContext);
                }
                this.iRO.setContentView(view);
                this.iRO.setPlayer(this.iRQ);
                this.iRO.setContext(this.mContext);
                this.iRO.cxZ();
                this.iRO.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cxX() {
                        if (b.this.iRP != null) {
                            return b.this.iRP.MN();
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
        if (this.iRO != null) {
            if (!z) {
                this.iRQ.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iRO.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void MO() {
        if (this.iRO != null) {
            this.iRO.Wq();
        }
        this.iRS.Jq(this.iRR);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MP() {
        return d.MP();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MQ() {
        return (this.iRO != null && this.iRO.cyb()) || (this.iRQ != null && this.iRQ.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
