package com.baidu.tieba.ala.live.guess.view.gift;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.tieba.ala.live.guess.widget.TimeCountTextView;
/* loaded from: classes11.dex */
public class AlaGuessPendantView extends PendantChildView {
    private boolean gQG;
    private AlaGuessActivityView hiW;

    public AlaGuessPendantView(Context context) {
        super(context);
        this.gQG = false;
    }

    private void setIsHorizontal(boolean z) {
        this.gQG = z;
    }

    public void e(ViewGroup.LayoutParams layoutParams) {
        if (this.hiW == null) {
            this.hiW = new AlaGuessActivityView(getContext());
        }
        setBackgroundColor(0);
        setMode(PendantParentView.Model.VERTICAL);
        addView(this.hiW, layoutParams);
    }

    public ImageView getImgActivity() {
        return this.hiW.hiU;
    }

    public TimeCountTextView getTimerView() {
        return this.hiW.hiV;
    }

    public TextView getTvCountDown() {
        return this.hiW.bCG;
    }

    public void removeView() {
        if (this.hiW != null && this.hiW.getParent() != null) {
            removeView(this.hiW);
            this.hiW = null;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (this.hiW != null) {
            this.hiW.setOnClickListener(onClickListener);
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
        return (this.bwT == PendantParentView.Model.VERTICAL || this.bwT == PendantParentView.Model.VERTICAL_BB_CHATING) ? 95 : 24;
    }
}
