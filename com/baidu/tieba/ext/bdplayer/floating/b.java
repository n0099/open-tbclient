package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tieba.ext.bdplayer.floating.d;
/* loaded from: classes7.dex */
public class b implements com.baidu.live.liveroom.e.b {
    private static final String TAG = com.baidu.tieba.ext.bdplayer.a.d.class.getSimpleName();
    private d hEr;
    private com.baidu.live.liveroom.e.a hEs;
    private com.baidu.tieba.ext.bdplayer.a.a hEt;
    private String hEu;
    private f hEv;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.hEv = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        Log.d(TAG, "showFloatingPlayer " + dVar);
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.hEt = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).chE();
            this.hEu = str;
            this.hEs = aVar;
            if (this.hEt != null) {
                if (this.hEv != null) {
                    this.hEv.chC();
                }
                if (this.hEr == null) {
                    this.hEr = new d(this.mContext);
                }
                this.hEr.setContentView(view);
                this.hEr.setPlayer(this.hEt);
                this.hEr.setContext(this.mContext);
                this.hEr.chz();
                this.hEr.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean chw() {
                        if (b.this.hEs != null) {
                            return b.this.hEs.Lm();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cc(boolean z) {
        Log.d(TAG, "hideFloatingPlayer");
        if (this.hEr != null) {
            if (!z) {
                this.hEt.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.hEr.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Ln() {
        if (this.hEr != null) {
            this.hEr.PR();
        }
        this.hEv.HB(this.hEu);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Lo() {
        return d.Lo();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Lp() {
        return (this.hEr != null && this.hEr.chB()) || (this.hEt != null && this.hEt.isFloatingMode());
    }
}
