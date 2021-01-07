package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes11.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hBG;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hBG = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hBG.setTbPageContext(this.mPageContext);
        this.mRootView = this.hBG.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hBG != null) {
            this.hBG.a(iShareCallback);
        }
    }

    private void chm() {
        this.hBG.chm();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hBG.c(alaLiveRecorder);
        chm();
    }

    public boolean chn() {
        return this.hBG.chn();
    }

    public boolean cho() {
        return this.hBG.cho();
    }

    public String getLiveTitle() {
        return this.hBG.getLiveTitle();
    }

    public boolean chp() {
        return this.hBG.chp();
    }

    public boolean chq() {
        return this.hBG.chq();
    }

    public void oa(boolean z) {
        this.hBG.oa(z);
    }

    public void chr() {
        this.hBG.hPx = false;
    }

    public String chs() {
        return this.hBG.chs();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hBG.a(bVar);
    }

    public void R(boolean z, boolean z2) {
        if (z) {
            this.hBG.onKeyboardVisibilityChanged(false);
        } else {
            this.hBG.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hBG.a(aVar);
    }

    public void Io(String str) {
        this.hBG.Io(str);
    }

    public void onResume() {
        this.hBG.onResume();
    }

    public void onRefresh() {
        this.hBG.onRefresh();
    }

    public boolean cht() {
        return this.hBG.cht();
    }

    public void chu() {
        this.hBG.chu();
    }

    public void release() {
        this.hBG.release();
    }

    public void destroy() {
        this.hBG.destroy();
    }

    public void ob(boolean z) {
        this.hBG.ob(z);
    }

    public void chv() {
        if (this.hBG != null) {
            this.hBG.chv();
        }
    }

    public void oc(boolean z) {
        if (this.hBG != null) {
            this.hBG.oc(z);
        }
    }

    public void a(com.baidu.live.n.a aVar) {
        if (this.hBG != null) {
            this.hBG.a(aVar);
        }
    }
}
