package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c gkR;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.gkR = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.gkR.f(this.mPageContext);
        this.mRootView = this.gkR.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gkR != null) {
            this.gkR.a(iShareCallback);
        }
    }

    private void bHl() {
        this.gkR.bHl();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.gkR.a(alaLiveRecorder);
        bHl();
    }

    public boolean bHm() {
        return this.gkR.bHm();
    }

    public boolean bHn() {
        return this.gkR.bHn();
    }

    public String getLiveTitle() {
        return this.gkR.getLiveTitle();
    }

    public boolean bHo() {
        return this.gkR.bHo();
    }

    public boolean bHp() {
        return this.gkR.bHp();
    }

    public void lx(boolean z) {
        this.gkR.lx(z);
    }

    public void bHq() {
        this.gkR.gyh = false;
    }

    public String bHr() {
        return this.gkR.bHr();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.gkR.a(bVar);
    }

    public void J(boolean z, boolean z2) {
        if (z) {
            this.gkR.onKeyboardVisibilityChanged(false);
        } else {
            this.gkR.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.gkR.a(aVar);
    }

    public void Dy(String str) {
        this.gkR.Dy(str);
    }

    public void onResume() {
        this.gkR.onResume();
    }

    public void onRefresh() {
        this.gkR.onRefresh();
    }

    public boolean bHs() {
        return this.gkR.bHs();
    }

    public void bHt() {
        this.gkR.bHt();
    }

    public void release() {
        this.gkR.release();
    }

    public void destroy() {
        this.gkR.destroy();
    }

    public void ly(boolean z) {
        this.gkR.ly(z);
    }

    public void bHu() {
        if (this.gkR != null) {
            this.gkR.bHu();
        }
    }

    public void lz(boolean z) {
        if (this.gkR != null) {
            this.gkR.lz(z);
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        if (this.gkR != null) {
            this.gkR.a(aVar);
        }
    }
}
