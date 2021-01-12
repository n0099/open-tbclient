package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hxa;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hxa = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hxa.setTbPageContext(this.mPageContext);
        this.mRootView = this.hxa.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hxa != null) {
            this.hxa.a(iShareCallback);
        }
    }

    private void cdu() {
        this.hxa.cdu();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hxa.c(alaLiveRecorder);
        cdu();
    }

    public boolean cdv() {
        return this.hxa.cdv();
    }

    public boolean cdw() {
        return this.hxa.cdw();
    }

    public String getLiveTitle() {
        return this.hxa.getLiveTitle();
    }

    public boolean cdx() {
        return this.hxa.cdx();
    }

    public boolean cdy() {
        return this.hxa.cdy();
    }

    public void nW(boolean z) {
        this.hxa.nW(z);
    }

    public void cdz() {
        this.hxa.hKR = false;
    }

    public String cdA() {
        return this.hxa.cdA();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hxa.a(bVar);
    }

    public void R(boolean z, boolean z2) {
        if (z) {
            this.hxa.onKeyboardVisibilityChanged(false);
        } else {
            this.hxa.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hxa.a(aVar);
    }

    public void Hd(String str) {
        this.hxa.Hd(str);
    }

    public void onResume() {
        this.hxa.onResume();
    }

    public void onRefresh() {
        this.hxa.onRefresh();
    }

    public boolean cdB() {
        return this.hxa.cdB();
    }

    public void cdC() {
        this.hxa.cdC();
    }

    public void release() {
        this.hxa.release();
    }

    public void destroy() {
        this.hxa.destroy();
    }

    public void nX(boolean z) {
        this.hxa.nX(z);
    }

    public void cdD() {
        if (this.hxa != null) {
            this.hxa.cdD();
        }
    }

    public void nY(boolean z) {
        if (this.hxa != null) {
            this.hxa.nY(z);
        }
    }

    public void a(com.baidu.live.n.a aVar) {
        if (this.hxa != null) {
            this.hxa.a(aVar);
        }
    }
}
