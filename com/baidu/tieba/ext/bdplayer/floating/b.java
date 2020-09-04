package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.tieba.ext.bdplayer.floating.d;
/* loaded from: classes7.dex */
public class b implements com.baidu.live.liveroom.e.b {
    private static final String TAG = com.baidu.tieba.ext.bdplayer.a.d.class.getSimpleName();
    private String hEA;
    private f hEB;
    private d hEx;
    private com.baidu.live.liveroom.e.a hEy;
    private com.baidu.tieba.ext.bdplayer.a.a hEz;
    private Context mContext;

    public b(Context context, @NonNull f fVar) {
        this.mContext = context;
        this.hEB = fVar;
    }

    @Override // com.baidu.live.liveroom.e.b
    public void a(com.baidu.live.liveroom.e.d dVar, View view, String str, com.baidu.live.liveroom.e.a aVar) {
        if (dVar != null && (dVar instanceof com.baidu.tieba.ext.bdplayer.a.d)) {
            this.hEz = ((com.baidu.tieba.ext.bdplayer.a.d) dVar).chF();
            this.hEA = str;
            this.hEy = aVar;
            if (this.hEz != null) {
                if (this.hEB != null) {
                    this.hEB.chD();
                }
                if (this.hEx == null) {
                    this.hEx = new d(this.mContext);
                }
                this.hEx.setContentView(view);
                this.hEx.setPlayer(this.hEz);
                this.hEx.setContext(this.mContext);
                this.hEx.chA();
                this.hEx.a(new d.b() { // from class: com.baidu.tieba.ext.bdplayer.floating.b.1
                    @Override // com.baidu.tieba.ext.bdplayer.floating.d.b
                    public boolean chx() {
                        if (b.this.hEy != null) {
                            return b.this.hEy.Lm();
                        }
                        return false;
                    }
                });
            }
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void cc(boolean z) {
        if (this.hEx != null) {
            if (!z) {
                this.hEz.setPlayerMode(PlayerConstant.HALF_MODE);
            }
            this.hEx.dismiss(true);
        }
    }

    @Override // com.baidu.live.liveroom.e.b
    public void Ln() {
        if (this.hEx != null) {
            this.hEx.PR();
        }
        this.hEB.HC(this.hEA);
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Lo() {
        return d.Lo();
    }

    @Override // com.baidu.live.liveroom.e.b
    public boolean Lp() {
        return (this.hEx != null && this.hEx.chC()) || (this.hEz != null && this.hEz.isFloatingMode());
    }
}
