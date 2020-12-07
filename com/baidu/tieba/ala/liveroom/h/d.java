package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hpI;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hpI = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hpI.setTbPageContext(this.mPageContext);
        this.mRootView = this.hpI.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hpI != null) {
            this.hpI.a(iShareCallback);
        }
    }

    private void ceu() {
        this.hpI.ceu();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hpI.c(alaLiveRecorder);
        ceu();
    }

    public boolean cev() {
        return this.hpI.cev();
    }

    public boolean cew() {
        return this.hpI.cew();
    }

    public String getLiveTitle() {
        return this.hpI.getLiveTitle();
    }

    public boolean cex() {
        return this.hpI.cex();
    }

    public boolean cey() {
        return this.hpI.cey();
    }

    public void nA(boolean z) {
        this.hpI.nA(z);
    }

    public void cez() {
        this.hpI.hDv = false;
    }

    public String ceA() {
        return this.hpI.ceA();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hpI.a(bVar);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.hpI.onKeyboardVisibilityChanged(false);
        } else {
            this.hpI.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hpI.a(aVar);
    }

    public void In(String str) {
        this.hpI.In(str);
    }

    public void onResume() {
        this.hpI.onResume();
    }

    public void onRefresh() {
        this.hpI.onRefresh();
    }

    public boolean ceB() {
        return this.hpI.ceB();
    }

    public void ceC() {
        this.hpI.ceC();
    }

    public void release() {
        this.hpI.release();
    }

    public void destroy() {
        this.hpI.destroy();
    }

    public void nB(boolean z) {
        this.hpI.nB(z);
    }

    public void ceD() {
        if (this.hpI != null) {
            this.hpI.ceD();
        }
    }

    public void nC(boolean z) {
        if (this.hpI != null) {
            this.hpI.nC(z);
        }
    }

    public void a(com.baidu.live.m.a aVar) {
        if (this.hpI != null) {
            this.hpI.a(aVar);
        }
    }
}
