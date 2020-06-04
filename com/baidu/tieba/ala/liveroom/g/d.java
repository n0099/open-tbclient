package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c fTd;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.fTd = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.fTd.f(this.mPageContext);
        this.mRootView = this.fTd.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fTd != null) {
            this.fTd.a(iShareCallback);
        }
    }

    private void bAX() {
        this.fTd.bAX();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.fTd.a(alaLiveRecorder);
        bAX();
    }

    public boolean bAY() {
        return this.fTd.bAY();
    }

    public boolean bAZ() {
        return this.fTd.bAZ();
    }

    public String getLiveTitle() {
        return this.fTd.getLiveTitle();
    }

    public boolean bBa() {
        return this.fTd.bBa();
    }

    public boolean bBb() {
        return this.fTd.bBb();
    }

    public void kJ(boolean z) {
        this.fTd.kJ(z);
    }

    public void bBc() {
        this.fTd.gfN = false;
    }

    public String bBd() {
        return this.fTd.bBd();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.fTd.a(bVar);
    }

    public void H(boolean z, boolean z2) {
        if (z) {
            this.fTd.onKeyboardVisibilityChanged(false);
        } else {
            this.fTd.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.fTd.a(aVar);
    }

    public void Co(String str) {
        this.fTd.Co(str);
    }

    public void onResume() {
        this.fTd.onResume();
    }

    public void onRefresh() {
        this.fTd.onRefresh();
    }

    public boolean bBe() {
        return this.fTd.bBe();
    }

    public void bBf() {
        this.fTd.bBf();
    }

    public void release() {
        this.fTd.release();
    }

    public void destroy() {
        this.fTd.destroy();
    }

    public void kK(boolean z) {
        this.fTd.kK(z);
    }

    public void bBg() {
        if (this.fTd != null) {
            this.fTd.bBg();
        }
    }

    public void kL(boolean z) {
        if (this.fTd != null) {
            this.fTd.kL(z);
        }
    }
}
