package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c gOE;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.gOE = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.gOE.f(this.mPageContext);
        this.mRootView = this.gOE.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gOE != null) {
            this.gOE.a(iShareCallback);
        }
    }

    private void bVF() {
        this.gOE.bVF();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.gOE.b(alaLiveRecorder);
        bVF();
    }

    public boolean bVG() {
        return this.gOE.bVG();
    }

    public boolean bVH() {
        return this.gOE.bVH();
    }

    public String getLiveTitle() {
        return this.gOE.getLiveTitle();
    }

    public boolean bVI() {
        return this.gOE.bVI();
    }

    public boolean bVJ() {
        return this.gOE.bVJ();
    }

    public void mF(boolean z) {
        this.gOE.mF(z);
    }

    public void bVK() {
        this.gOE.hcx = false;
    }

    public String bVL() {
        return this.gOE.bVL();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.gOE.a(bVar);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.gOE.onKeyboardVisibilityChanged(false);
        } else {
            this.gOE.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.gOE.a(aVar);
    }

    public void Hg(String str) {
        this.gOE.Hg(str);
    }

    public void onResume() {
        this.gOE.onResume();
    }

    public void onRefresh() {
        this.gOE.onRefresh();
    }

    public boolean bVM() {
        return this.gOE.bVM();
    }

    public void bVN() {
        this.gOE.bVN();
    }

    public void release() {
        this.gOE.release();
    }

    public void destroy() {
        this.gOE.destroy();
    }

    public void mG(boolean z) {
        this.gOE.mG(z);
    }

    public void bVO() {
        if (this.gOE != null) {
            this.gOE.bVO();
        }
    }

    public void mH(boolean z) {
        if (this.gOE != null) {
            this.gOE.mH(z);
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        if (this.gOE != null) {
            this.gOE.a(aVar);
        }
    }
}
