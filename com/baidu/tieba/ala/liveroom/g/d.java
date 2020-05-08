package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c fEY;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.fEY = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.fEY.f(this.mPageContext);
        this.mRootView = this.fEY.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fEY != null) {
            this.fEY.a(iShareCallback);
        }
    }

    private void buW() {
        this.fEY.buW();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.fEY.a(alaLiveRecorder);
        buW();
    }

    public boolean buX() {
        return this.fEY.buX();
    }

    public boolean buY() {
        return this.fEY.buY();
    }

    public String getLiveTitle() {
        return this.fEY.getLiveTitle();
    }

    public boolean buZ() {
        return this.fEY.buZ();
    }

    public boolean bva() {
        return this.fEY.bva();
    }

    public void kp(boolean z) {
        this.fEY.kp(z);
    }

    public void bvb() {
        this.fEY.fQR = false;
    }

    public String bvc() {
        return this.fEY.bvc();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.fEY.a(bVar);
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.fEY.onKeyboardVisibilityChanged(false);
        } else {
            this.fEY.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.fEY.a(aVar);
    }

    public void AG(String str) {
        this.fEY.AG(str);
    }

    public void onResume() {
        this.fEY.onResume();
    }

    public void onRefresh() {
        this.fEY.onRefresh();
    }

    public boolean bvd() {
        return this.fEY.bvd();
    }

    public void bve() {
        this.fEY.bve();
    }

    public void release() {
        this.fEY.release();
    }

    public void destroy() {
        this.fEY.destroy();
    }

    public void kq(boolean z) {
        this.fEY.kq(z);
    }

    public void bvf() {
        if (this.fEY != null) {
            this.fEY.bvf();
        }
    }
}
