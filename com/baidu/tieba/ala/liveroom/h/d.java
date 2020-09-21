package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c gAl;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.gAl = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.gAl.f(this.mPageContext);
        this.mRootView = this.gAl.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gAl != null) {
            this.gAl.a(iShareCallback);
        }
    }

    private void bSm() {
        this.gAl.bSm();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.gAl.a(alaLiveRecorder);
        bSm();
    }

    public boolean bSn() {
        return this.gAl.bSn();
    }

    public boolean bSo() {
        return this.gAl.bSo();
    }

    public String getLiveTitle() {
        return this.gAl.getLiveTitle();
    }

    public boolean bSp() {
        return this.gAl.bSp();
    }

    public boolean bSq() {
        return this.gAl.bSq();
    }

    public void md(boolean z) {
        this.gAl.md(z);
    }

    public void bSr() {
        this.gAl.gNA = false;
    }

    public String bSs() {
        return this.gAl.bSs();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.gAl.a(bVar);
    }

    public void M(boolean z, boolean z2) {
        if (z) {
            this.gAl.onKeyboardVisibilityChanged(false);
        } else {
            this.gAl.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.gAl.a(aVar);
    }

    public void Gu(String str) {
        this.gAl.Gu(str);
    }

    public void onResume() {
        this.gAl.onResume();
    }

    public void onRefresh() {
        this.gAl.onRefresh();
    }

    public boolean bSt() {
        return this.gAl.bSt();
    }

    public void bSu() {
        this.gAl.bSu();
    }

    public void release() {
        this.gAl.release();
    }

    public void destroy() {
        this.gAl.destroy();
    }

    public void me(boolean z) {
        this.gAl.me(z);
    }

    public void bSv() {
        if (this.gAl != null) {
            this.gAl.bSv();
        }
    }

    public void mf(boolean z) {
        if (this.gAl != null) {
            this.gAl.mf(z);
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        if (this.gAl != null) {
            this.gAl.a(aVar);
        }
    }
}
