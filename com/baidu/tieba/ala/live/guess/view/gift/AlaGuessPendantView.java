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
    private boolean gQs;
    private AlaGuessActivityView hiI;

    public AlaGuessPendantView(Context context) {
        super(context);
        this.gQs = false;
    }

    private void setIsHorizontal(boolean z) {
        this.gQs = z;
    }

    public void e(ViewGroup.LayoutParams layoutParams) {
        if (this.hiI == null) {
            this.hiI = new AlaGuessActivityView(getContext());
        }
        setBackgroundColor(0);
        setMode(PendantParentView.Model.VERTICAL);
        addView(this.hiI, layoutParams);
    }

    public ImageView getImgActivity() {
        return this.hiI.hiG;
    }

    public TimeCountTextView getTimerView() {
        return this.hiI.hiH;
    }

    public TextView getTvCountDown() {
        return this.hiI.bCG;
    }

    public void removeView() {
        if (this.hiI != null && this.hiI.getParent() != null) {
            removeView(this.hiI);
            this.hiI = null;
        }
    }

    public void c(View.OnClickListener onClickListener) {
        if (this.hiI != null) {
            this.hiI.setOnClickListener(onClickListener);
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
