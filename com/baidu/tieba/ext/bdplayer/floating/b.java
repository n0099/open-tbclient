package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.baidu.live.liveroom.e.h;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tieba.ext.bdplayer.floating.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.e.b {
    private static final String TAG = com.baidu.tieba.ext.bdplayer.a.d.class.getSimpleName();
    private com.baidu.live.liveroom.e.a hLA;
    private com.baidu.tieba.ext.bdplayer.a.a hLB;
    private String hLC;
    private f hLD;
    private d hLz;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.hLD = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (isDebug()) {
            Log.d(TAG, "showFloatingPlayer " + dVar);
        }
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.hLB = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).ckS();
            this.hLC = str;
            this.hLA = aVar;
            if (this.hLB != null) {
                if (this.hLD != null) {
                    this.hLD.ckQ();
                }
                if (this.hLz == null) {
                    this.hLz = new d(this.mContext);
                }
                this.hLz.setContentView(view);
                this.hLz.setPlayer(this.hLB);
                this.hLz.setContext(this.mContext);
                this.hLz.cbp();
                this.hLz.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean dG(JSONObject jSONObject) {
                        if (b.this.hLA != null) {
                            return b.this.hLA.L(jSONObject);
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cc(boolean z) {
        if (isDebug()) {
            Log.d(TAG, "hideFloatingPlayer");
        }
        if (this.hLz != null) {
            if (!z) {
                this.hLB.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.hLz.S(true, true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void LP() {
        if (this.hLz != null) {
            this.hLz.Qz();
        }
        this.hLD.HZ(this.hLC);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean LQ() {
        return d.LQ();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean LR() {
        return (this.hLz != null && this.hLz.ckP()) || (this.hLB != null && this.hLB.isFloatingMode());
    }

    private boolean isDebug() {
        return h.isDebug();
    }
}
