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
    private d iau;
    private com.baidu.live.liveroom.e.a iav;
    private com.baidu.tieba.ext.bdplayer.a.a iaw;
    private String iax;
    private f iay;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.iay = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.iaw = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).coq();
            this.iax = str;
            this.iav = aVar;
            if (this.iaw != null) {
                if (this.iay != null) {
                    this.iay.coo();
                }
                if (this.iau == null) {
                    this.iau = new d(this.mContext);
                }
                this.iau.setContentView(view);
                this.iau.setPlayer(this.iaw);
                this.iau.setContext(this.mContext);
                this.iau.col();
                this.iau.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean coi() {
                        if (b.this.iav != null) {
                            return b.this.iav.MT();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cf(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.iau != null) {
            if (!z) {
                this.iaw.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.iau.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void MU() {
        if (this.iau != null) {
            this.iau.RW();
        }
        this.iay.IM(this.iax);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MV() {
        return d.MV();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean MW() {
        return (this.iau != null && this.iau.con()) || (this.iaw != null && this.iaw.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
