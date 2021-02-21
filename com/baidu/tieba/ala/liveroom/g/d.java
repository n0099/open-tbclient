package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hBy;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hBy = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hBy.setTbPageContext(this.mPageContext);
        this.mRootView = this.hBy.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hBy != null) {
            this.hBy.a(iShareCallback);
        }
    }

    private void cew() {
        this.hBy.cew();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hBy.c(alaLiveRecorder);
        cew();
    }

    public boolean cex() {
        return this.hBy.cex();
    }

    public boolean cey() {
        return this.hBy.cey();
    }

    public String getLiveTitle() {
        return this.hBy.getLiveTitle();
    }

    public boolean cez() {
        return this.hBy.cez();
    }

    public boolean ceA() {
        return this.hBy.ceA();
    }

    public void oh(boolean z) {
        this.hBy.oh(z);
    }

    public void ceB() {
        this.hBy.hPz = false;
    }

    public String ceC() {
        return this.hBy.ceC();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hBy.a(bVar);
    }

    public void R(boolean z, boolean z2) {
        if (z) {
            this.hBy.onKeyboardVisibilityChanged(false);
        } else {
            this.hBy.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hBy.a(aVar);
    }

    public void HI(String str) {
        this.hBy.HI(str);
    }

    public void onResume() {
        this.hBy.onResume();
    }

    public void onRefresh() {
        this.hBy.onRefresh();
    }

    public boolean ceD() {
        return this.hBy.ceD();
    }

    public void ceE() {
        this.hBy.ceE();
    }

    public void release() {
        this.hBy.release();
    }

    public void destroy() {
        this.hBy.destroy();
    }

    public void oi(boolean z) {
        this.hBy.oi(z);
    }

    public void ceF() {
        if (this.hBy != null) {
            this.hBy.ceF();
        }
    }

    public void oj(boolean z) {
        if (this.hBy != null) {
            this.hBy.oj(z);
        }
    }

    public void a(com.baidu.live.m.a aVar) {
        if (this.hBy != null) {
            this.hBy.a(aVar);
        }
    }
}
