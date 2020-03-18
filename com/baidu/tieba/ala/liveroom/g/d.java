package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c faK;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.faK = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.mRootView = this.faK.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.faK != null) {
            this.faK.a(iShareCallback);
        }
    }

    private void blH() {
        this.faK.blH();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.faK.a(alaLiveRecorder);
        blH();
    }

    public boolean blI() {
        return this.faK.blI();
    }

    public boolean blJ() {
        return this.faK.blJ();
    }

    public String getLiveTitle() {
        return this.faK.getLiveTitle();
    }

    public boolean blK() {
        return this.faK.blK();
    }

    public boolean blL() {
        return this.faK.blL();
    }

    public void jo(boolean z) {
        this.faK.jo(z);
    }

    public void blM() {
        this.faK.fmq = false;
    }

    public String blN() {
        return this.faK.blN();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.faK.a(bVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.faK.onKeyboardVisibilityChanged(false);
        } else {
            this.faK.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.faK.a(aVar);
    }

    public void yV(String str) {
        this.faK.yV(str);
    }

    public void onResume() {
        this.faK.onResume();
    }

    public void onRefresh() {
        this.faK.onRefresh();
    }

    public boolean blO() {
        return this.faK.blO();
    }

    public void blP() {
        this.faK.blP();
    }

    public void release() {
        this.faK.release();
    }

    public void destroy() {
        this.faK.destroy();
    }

    public void jp(boolean z) {
        this.faK.jp(z);
    }

    public void blQ() {
        if (this.faK != null) {
            this.faK.blQ();
        }
    }
}
