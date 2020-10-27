package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c has;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.has = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.has.setTbPageContext(this.mPageContext);
        this.mRootView = this.has.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.has != null) {
            this.has.a(iShareCallback);
        }
    }

    private void bYE() {
        this.has.bYE();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.has.b(alaLiveRecorder);
        bYE();
    }

    public boolean bYF() {
        return this.has.bYF();
    }

    public boolean bYG() {
        return this.has.bYG();
    }

    public String getLiveTitle() {
        return this.has.getLiveTitle();
    }

    public boolean bYH() {
        return this.has.bYH();
    }

    public boolean bYI() {
        return this.has.bYI();
    }

    public void mV(boolean z) {
        this.has.mV(z);
    }

    public void bYJ() {
        this.has.hon = false;
    }

    public String bYK() {
        return this.has.bYK();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.has.a(bVar);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.has.onKeyboardVisibilityChanged(false);
        } else {
            this.has.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.has.a(aVar);
    }

    public void HF(String str) {
        this.has.HF(str);
    }

    public void onResume() {
        this.has.onResume();
    }

    public void onRefresh() {
        this.has.onRefresh();
    }

    public boolean bYL() {
        return this.has.bYL();
    }

    public void bYM() {
        this.has.bYM();
    }

    public void release() {
        this.has.release();
    }

    public void destroy() {
        this.has.destroy();
    }

    public void mW(boolean z) {
        this.has.mW(z);
    }

    public void bYN() {
        if (this.has != null) {
            this.has.bYN();
        }
    }

    public void mX(boolean z) {
        if (this.has != null) {
            this.has.mX(z);
        }
    }

    public void a(com.baidu.live.k.a aVar) {
        if (this.has != null) {
            this.has.a(aVar);
        }
    }
}
