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
    /* renamed from: arI */
    public T afY() {
        return (T) this.csV;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        if (this.csV == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.csV).isPlayStarted();
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        if (this.csV == 0) {
            return false;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.csV).isPlaying();
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
        if (this.csV != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.csV).startPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.csV != 0) {
            ((com.baidu.tieba.frs.entelechy.view.a) this.csV).stopPlay();
        }
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.csV == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.csV).getVideoContainer();
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.csV == 0) {
            return null;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.csV).getPlayUrl();
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.csV == 0) {
            return 0;
        }
        return ((com.baidu.tieba.frs.entelechy.view.a) this.csV).getCurrentPosition();
    }
}
