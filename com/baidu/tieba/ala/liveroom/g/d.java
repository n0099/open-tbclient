package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.d eeB;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.eeB = new com.baidu.tieba.ala.liveroom.views.d(this.mPageContext);
        this.mRootView = this.eeB.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.eeB != null) {
            this.eeB.a(iShareCallback);
        }
    }

    private void aRy() {
        this.eeB.aRy();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.eeB.a(alaLiveRecorder);
        aRy();
    }

    public boolean aRz() {
        return this.eeB.aRz();
    }

    public boolean aRA() {
        return this.eeB.aRA();
    }

    public String getLiveTitle() {
        return this.eeB.getLiveTitle();
    }

    public boolean aRB() {
        return this.eeB.aRB();
    }

    public boolean aRC() {
        return this.eeB.aRC();
    }

    public void hL(boolean z) {
        this.eeB.hL(z);
    }

    public void aRD() {
        this.eeB.eoV = false;
    }

    public String aRE() {
        return this.eeB.aRE();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(f.b bVar) {
        this.eeB.a(bVar);
    }

    public void C(boolean z, boolean z2) {
        if (z) {
            this.eeB.onKeyboardVisibilityChanged(false);
        } else {
            this.eeB.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(f.a aVar) {
        this.eeB.a(aVar);
    }

    public void tH(String str) {
        this.eeB.tH(str);
    }

    public void onResume() {
        this.eeB.onResume();
    }

    public void onRefresh() {
        this.eeB.onRefresh();
    }

    public boolean aRF() {
        return this.eeB.aRF();
    }

    public void aRG() {
        this.eeB.aRG();
    }

    public void release() {
        this.eeB.release();
    }

    public void destroy() {
        this.eeB.destroy();
    }

    public void hM(boolean z) {
        this.eeB.hM(z);
    }

    public void aRH() {
        if (this.eeB != null) {
            this.eeB.aRH();
        }
    }
}
