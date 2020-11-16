package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hgb;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hgb = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hgb.setTbPageContext(this.mPageContext);
        this.mRootView = this.hgb.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hgb != null) {
            this.hgb.a(iShareCallback);
        }
    }

    private void caz() {
        this.hgb.caz();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hgb.c(alaLiveRecorder);
        caz();
    }

    public boolean caA() {
        return this.hgb.caA();
    }

    public boolean caB() {
        return this.hgb.caB();
    }

    public String getLiveTitle() {
        return this.hgb.getLiveTitle();
    }

    public boolean caC() {
        return this.hgb.caC();
    }

    public boolean caD() {
        return this.hgb.caD();
    }

    public void nf(boolean z) {
        this.hgb.nf(z);
    }

    public void caE() {
        this.hgb.htS = false;
    }

    public String caF() {
        return this.hgb.caF();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hgb.a(bVar);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.hgb.onKeyboardVisibilityChanged(false);
        } else {
            this.hgb.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hgb.a(aVar);
    }

    public void Hy(String str) {
        this.hgb.Hy(str);
    }

    public void onResume() {
        this.hgb.onResume();
    }

    public void onRefresh() {
        this.hgb.onRefresh();
    }

    public boolean caG() {
        return this.hgb.caG();
    }

    public void caH() {
        this.hgb.caH();
    }

    public void release() {
        this.hgb.release();
    }

    public void destroy() {
        this.hgb.destroy();
    }

    public void ng(boolean z) {
        this.hgb.ng(z);
    }

    public void caI() {
        if (this.hgb != null) {
            this.hgb.caI();
        }
    }

    public void nh(boolean z) {
        if (this.hgb != null) {
            this.hgb.nh(z);
        }
    }

    public void a(com.baidu.live.k.a aVar) {
        if (this.hgb != null) {
            this.hgb.a(aVar);
        }
    }
}
