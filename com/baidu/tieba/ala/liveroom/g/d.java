package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c fSS;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.fSS = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.fSS.f(this.mPageContext);
        this.mRootView = this.fSS.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fSS != null) {
            this.fSS.a(iShareCallback);
        }
    }

    private void bAV() {
        this.fSS.bAV();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.fSS.a(alaLiveRecorder);
        bAV();
    }

    public boolean bAW() {
        return this.fSS.bAW();
    }

    public boolean bAX() {
        return this.fSS.bAX();
    }

    public String getLiveTitle() {
        return this.fSS.getLiveTitle();
    }

    public boolean bAY() {
        return this.fSS.bAY();
    }

    public boolean bAZ() {
        return this.fSS.bAZ();
    }

    public void kJ(boolean z) {
        this.fSS.kJ(z);
    }

    public void bBa() {
        this.fSS.gfC = false;
    }

    public String bBb() {
        return this.fSS.bBb();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.fSS.a(bVar);
    }

    public void H(boolean z, boolean z2) {
        if (z) {
            this.fSS.onKeyboardVisibilityChanged(false);
        } else {
            this.fSS.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.fSS.a(aVar);
    }

    public void Co(String str) {
        this.fSS.Co(str);
    }

    public void onResume() {
        this.fSS.onResume();
    }

    public void onRefresh() {
        this.fSS.onRefresh();
    }

    public boolean bBc() {
        return this.fSS.bBc();
    }

    public void bBd() {
        this.fSS.bBd();
    }

    public void release() {
        this.fSS.release();
    }

    public void destroy() {
        this.fSS.destroy();
    }

    public void kK(boolean z) {
        this.fSS.kK(z);
    }

    public void bBe() {
        if (this.fSS != null) {
            this.fSS.bBe();
        }
    }

    public void kL(boolean z) {
        if (this.fSS != null) {
            this.fSS.kL(z);
        }
    }
}
