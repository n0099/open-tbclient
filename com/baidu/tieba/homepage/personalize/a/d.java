package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tieba.card.j;
/* loaded from: classes2.dex */
public class d<T extends com.baidu.tieba.card.j> extends com.baidu.tieba.card.a.a<T> implements com.baidu.tieba.play.f {
    public d(T t) {
        super(t);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a.a
    /* renamed from: aBB */
    public T alk() {
        return (T) this.cYh;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.cYh == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cYh).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.cYh == 0) {
            return false;
        }
        return ((com.baidu.tieba.card.j) this.cYh).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.cYh != 0) {
            ((com.baidu.tieba.card.j) this.cYh).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.cYh != 0) {
            ((com.baidu.tieba.card.j) this.cYh).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.cYh == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cYh).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.cYh == 0) {
            return null;
        }
        return ((com.baidu.tieba.card.j) this.cYh).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.cYh == 0) {
            return 0;
        }
        return ((com.baidu.tieba.card.j) this.cYh).getCurrentPosition();
    }
}
