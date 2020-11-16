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
    private d itH;
    private com.baidu.live.liveroom.e.a itI;
    private com.baidu.tieba.ext.bdplayer.a.a itJ;
    private String itK;
    private f itL;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.itL = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.itJ = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).ctB();
            this.itK = str;
            this.itI = aVar;
            if (this.itJ != null) {
                if (this.itL != null) {
                    this.itL.ctz();
                }
                if (this.itH == null) {
                    this.itH = new d(this.mContext);
                }
                this.itH.setContentView(view);
                this.itH.setPlayer(this.itJ);
                this.itH.setContext(this.mContext);
                this.itH.ctw();
                this.itH.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean ctt() {
                        if (b.this.itI != null) {
                            return b.this.itI.Ne();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void ck(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.itH != null) {
            if (!z) {
                this.itJ.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.itH.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Nf() {
        if (this.itH != null) {
            this.itH.UT();
        }
        this.itL.Jd(this.itK);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Ng() {
        return d.Ng();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Nh() {
        return (this.itH != null && this.itH.cty()) || (this.itJ != null && this.itJ.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
