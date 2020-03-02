package com.baidu.tieba.ala.alasquare.special_forum.b;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public abstract class a {
    protected int elc;
    protected com.baidu.tieba.ala.alasquare.special_forum.data.a etb;
    protected View mMaskView;
    protected int mScreenWidth;
    protected TbPageContext mTbPageContext;

    public abstract boolean b(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar);

    public abstract View getContentView();

    public abstract void hR(boolean z);

    public abstract void init();

    public abstract void onChangeSkinType(int i);

    public abstract void onDestroy();

    public abstract void startPlay();

    public abstract void stopPlay();

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mScreenWidth = l.getEquipmentWidth(this.mTbPageContext.getPageActivity());
        this.elc = (int) ((this.mScreenWidth * 9.0d) / 16.0d);
    }

    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.a aVar) {
        this.etb = aVar;
    }

    public void N(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(getContentView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bdu() {
        this.mMaskView = new View(this.mTbPageContext.getPageActivity());
        this.mMaskView.setLayoutParams(new FrameLayout.LayoutParams(this.mScreenWidth, this.elc));
        this.mMaskView.setBackgroundDrawable(new ColorDrawable(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.black_alpha30)));
        return this.mMaskView;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void bdv() {
        this.mScreenWidth = l.getEquipmentWidth(this.mTbPageContext.getPageActivity());
        this.elc = (int) ((this.mScreenWidth * 9.0d) / 16.0d);
        if (this.mMaskView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMaskView.getLayoutParams();
            layoutParams.width = this.mScreenWidth;
            layoutParams.height = this.elc;
            this.mMaskView.setLayoutParams(layoutParams);
        }
    }
}
