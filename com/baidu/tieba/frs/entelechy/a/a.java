package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tieba.frs.entelechy.view.a;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.tieba.frs.entelechy.view.a> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public a(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: awf */
    public T alk() {
        return (T) this.cYh;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cYh == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cYh == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cYh != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cYh != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cYh == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cYh == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cYh == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.cYh).getCurrentPosition();
    }
}
