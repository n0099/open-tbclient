package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c gwZ;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.gwZ = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.gwZ.f(this.mPageContext);
        this.mRootView = this.gwZ.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gwZ != null) {
            this.gwZ.a(iShareCallback);
        }
    }

    private void bQQ() {
        this.gwZ.bQQ();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.gwZ.a(alaLiveRecorder);
        bQQ();
    }

    public boolean bQR() {
        return this.gwZ.bQR();
    }

    public boolean bQS() {
        return this.gwZ.bQS();
    }

    public String getLiveTitle() {
        return this.gwZ.getLiveTitle();
    }

    public boolean bQT() {
        return this.gwZ.bQT();
    }

    public boolean bQU() {
        return this.gwZ.bQU();
    }

    public void ma(boolean z) {
        this.gwZ.ma(z);
    }

    public void bQV() {
        this.gwZ.gKk = false;
    }

    public String bQW() {
        return this.gwZ.bQW();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.gwZ.a(bVar);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.gwZ.onKeyboardVisibilityChanged(false);
        } else {
            this.gwZ.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.gwZ.a(aVar);
    }

    public void FW(String str) {
        this.gwZ.FW(str);
    }

    public void onResume() {
        this.gwZ.onResume();
    }

    public void onRefresh() {
        this.gwZ.onRefresh();
    }

    public boolean bQX() {
        return this.gwZ.bQX();
    }

    public void bQY() {
        this.gwZ.bQY();
    }

    public void release() {
        this.gwZ.release();
    }

    public void destroy() {
        this.gwZ.destroy();
    }

    public void mb(boolean z) {
        this.gwZ.mb(z);
    }

    public void bQZ() {
        if (this.gwZ != null) {
            this.gwZ.bQZ();
        }
    }

    public void mc(boolean z) {
        if (this.gwZ != null) {
            this.gwZ.mc(z);
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        if (this.gwZ != null) {
            this.gwZ.a(aVar);
        }
    }
}
