package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hpK;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hpK = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hpK.setTbPageContext(this.mPageContext);
        this.mRootView = this.hpK.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hpK != null) {
            this.hpK.a(iShareCallback);
        }
    }

    private void cev() {
        this.hpK.cev();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hpK.c(alaLiveRecorder);
        cev();
    }

    public boolean cew() {
        return this.hpK.cew();
    }

    public boolean cex() {
        return this.hpK.cex();
    }

    public String getLiveTitle() {
        return this.hpK.getLiveTitle();
    }

    public boolean cey() {
        return this.hpK.cey();
    }

    public boolean cez() {
        return this.hpK.cez();
    }

    public void nA(boolean z) {
        this.hpK.nA(z);
    }

    public void ceA() {
        this.hpK.hDx = false;
    }

    public String ceB() {
        return this.hpK.ceB();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hpK.a(bVar);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.hpK.onKeyboardVisibilityChanged(false);
        } else {
            this.hpK.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hpK.a(aVar);
    }

    public void In(String str) {
        this.hpK.In(str);
    }

    public void onResume() {
        this.hpK.onResume();
    }

    public void onRefresh() {
        this.hpK.onRefresh();
    }

    public boolean ceC() {
        return this.hpK.ceC();
    }

    public void ceD() {
        this.hpK.ceD();
    }

    public void release() {
        this.hpK.release();
    }

    public void destroy() {
        this.hpK.destroy();
    }

    public void nB(boolean z) {
        this.hpK.nB(z);
    }

    public void ceE() {
        if (this.hpK != null) {
            this.hpK.ceE();
        }
    }

    public void nC(boolean z) {
        if (this.hpK != null) {
            this.hpK.nC(z);
        }
    }

    public void a(com.baidu.live.m.a aVar) {
        if (this.hpK != null) {
            this.hpK.a(aVar);
        }
    }
}
