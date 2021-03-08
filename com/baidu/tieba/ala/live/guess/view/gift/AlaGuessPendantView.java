package com.baidu.tieba.ala.live.guess.view.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.tieba.ala.live.guess.widget.TimeCountTextView;
/* loaded from: classes10.dex */
public class AlaGuessPendantView extends PendantChildView {
    private boolean gSp;
    private AlaGuessActivityView hkF;

    public AlaGuessPendantView(Context context) {
        super(context);
        this.gSp = false;
    }

    private void setIsHorizontal(boolean z) {
        this.gSp = z;
    }

    public void e(ViewGroup.LayoutParams layoutParams) {
        if (this.hkF == null) {
            this.hkF = new AlaGuessActivityView(getContext());
        }
        setBackgroundColor(0);
        setMode(PendantParentView.Model.VERTICAL);
        addView(this.hkF, layoutParams);
    }

    public ImageView getImgActivity() {
        return this.hkF.hkD;
    }

    public TimeCountTextView getTimerView() {
        return this.hkF.hkE;
    }

    public TextView getTvCountDown() {
        return this.hkF.bEg;
    }

    public void removeView() {
        if (this.hkF != null && this.hkF.getParent() != null) {
            removeView(this.hkF);
            this.hkF = null;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (this.hkF != null) {
            this.hkF.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalPkPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getVerticalBBChattingPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getHorizontalPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public PendantParentView.Position getHorizontalFullPosition() {
        return PendantParentView.Position.RIGHT;
    }

    @Override // com.baidu.live.pendantview.PendantChildView
    public int getPriority() {
        return (this.byt == PendantParentView.Model.VERTICAL || this.byt == PendantParentView.Model.VERTICAL_BB_CHATING) ? 95 : 24;
    }
}
