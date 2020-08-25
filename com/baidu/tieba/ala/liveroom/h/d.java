package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c gwV;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.gwV = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.gwV.f(this.mPageContext);
        this.mRootView = this.gwV.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gwV != null) {
            this.gwV.a(iShareCallback);
        }
    }

    private void bQP() {
        this.gwV.bQP();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.gwV.a(alaLiveRecorder);
        bQP();
    }

    public boolean bQQ() {
        return this.gwV.bQQ();
    }

    public boolean bQR() {
        return this.gwV.bQR();
    }

    public String getLiveTitle() {
        return this.gwV.getLiveTitle();
    }

    public boolean bQS() {
        return this.gwV.bQS();
    }

    public boolean bQT() {
        return this.gwV.bQT();
    }

    public void lY(boolean z) {
        this.gwV.lY(z);
    }

    public void bQU() {
        this.gwV.gKg = false;
    }

    public String bQV() {
        return this.gwV.bQV();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.gwV.a(bVar);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.gwV.onKeyboardVisibilityChanged(false);
        } else {
            this.gwV.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.gwV.a(aVar);
    }

    public void FV(String str) {
        this.gwV.FV(str);
    }

    public void onResume() {
        this.gwV.onResume();
    }

    public void onRefresh() {
        this.gwV.onRefresh();
    }

    public boolean bQW() {
        return this.gwV.bQW();
    }

    public void bQX() {
        this.gwV.bQX();
    }

    public void release() {
        this.gwV.release();
    }

    public void destroy() {
        this.gwV.destroy();
    }

    public void lZ(boolean z) {
        this.gwV.lZ(z);
    }

    public void bQY() {
        if (this.gwV != null) {
            this.gwV.bQY();
        }
    }

    public void ma(boolean z) {
        if (this.gwV != null) {
            this.gwV.ma(z);
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        if (this.gwV != null) {
            this.gwV.a(aVar);
        }
    }
}
