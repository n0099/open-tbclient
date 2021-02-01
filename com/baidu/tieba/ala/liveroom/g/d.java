package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hBk;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hBk = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hBk.setTbPageContext(this.mPageContext);
        this.mRootView = this.hBk.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hBk != null) {
            this.hBk.a(iShareCallback);
        }
    }

    private void cep() {
        this.hBk.cep();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hBk.c(alaLiveRecorder);
        cep();
    }

    public boolean ceq() {
        return this.hBk.ceq();
    }

    public boolean cer() {
        return this.hBk.cer();
    }

    public String getLiveTitle() {
        return this.hBk.getLiveTitle();
    }

    public boolean ces() {
        return this.hBk.ces();
    }

    public boolean cet() {
        return this.hBk.cet();
    }

    public void oh(boolean z) {
        this.hBk.oh(z);
    }

    public void ceu() {
        this.hBk.hPl = false;
    }

    public String cev() {
        return this.hBk.cev();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hBk.a(bVar);
    }

    public void R(boolean z, boolean z2) {
        if (z) {
            this.hBk.onKeyboardVisibilityChanged(false);
        } else {
            this.hBk.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hBk.a(aVar);
    }

    public void HH(String str) {
        this.hBk.HH(str);
    }

    public void onResume() {
        this.hBk.onResume();
    }

    public void onRefresh() {
        this.hBk.onRefresh();
    }

    public boolean cew() {
        return this.hBk.cew();
    }

    public void cex() {
        this.hBk.cex();
    }

    public void release() {
        this.hBk.release();
    }

    public void destroy() {
        this.hBk.destroy();
    }

    public void oi(boolean z) {
        this.hBk.oi(z);
    }

    public void cey() {
        if (this.hBk != null) {
            this.hBk.cey();
        }
    }

    public void oj(boolean z) {
        if (this.hBk != null) {
            this.hBk.oj(z);
        }
    }

    public void a(com.baidu.live.m.a aVar) {
        if (this.hBk != null) {
            this.hBk.a(aVar);
        }
    }
}
