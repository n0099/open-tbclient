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
    private d iSc;
    private com.baidu.live.liveroom.e.a iSd;
    private com.baidu.tieba.ext.bdplayer.a.a iSe;
    private String iSf;
    private f iSg;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iSg = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iSe = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).cyl();
            this.iSf = str;
            this.iSd = aVar;
            if (this.iSe != null) {
                if (this.iSg != null) {
                    this.iSg.cyj();
                }
                if (this.iSc == null) {
                    this.iSc = new d(this.mContext);
                }
                this.iSc.setContentView(view);
                this.iSc.setPlayer(this.iSe);
                this.iSc.setContext(this.mContext);
                this.iSc.cyg();
                this.iSc.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean cye() {
                        if (b.this.iSd != null) {
                            return b.this.iSd.MN();
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
        if (this.iSc != null) {
            if (!z) {
                this.iSe.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iSc.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void MO() {
        if (this.iSc != null) {
            this.iSc.Wq();
        }
        this.iSg.Jr(this.iSf);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MP() {
        return d.MP();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MQ() {
        return (this.iSc != null && this.iSc.cyi()) || (this.iSe != null && this.iSe.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
