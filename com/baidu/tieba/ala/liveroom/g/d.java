package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c gfJ;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.gfJ = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.gfJ.f(this.mPageContext);
        this.mRootView = this.gfJ.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.gfJ != null) {
            this.gfJ.a(iShareCallback);
        }
    }

    private void bDZ() {
        this.gfJ.bDZ();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.gfJ.a(alaLiveRecorder);
        bDZ();
    }

    public boolean bEa() {
        return this.gfJ.bEa();
    }

    public boolean bEb() {
        return this.gfJ.bEb();
    }

    public String getLiveTitle() {
        return this.gfJ.getLiveTitle();
    }

    public boolean bEc() {
        return this.gfJ.bEc();
    }

    public boolean bEd() {
        return this.gfJ.bEd();
    }

    public void kU(boolean z) {
        this.gfJ.kU(z);
    }

    public void bEe() {
        this.gfJ.gsK = false;
    }

    public String bEf() {
        return this.gfJ.bEf();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.gfJ.a(bVar);
    }

    public void I(boolean z, boolean z2) {
        if (z) {
            this.gfJ.onKeyboardVisibilityChanged(false);
        } else {
            this.gfJ.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.gfJ.a(aVar);
    }

    public void CM(String str) {
        this.gfJ.CM(str);
    }

    public void onResume() {
        this.gfJ.onResume();
    }

    public void onRefresh() {
        this.gfJ.onRefresh();
    }

    public boolean bEg() {
        return this.gfJ.bEg();
    }

    public void bEh() {
        this.gfJ.bEh();
    }

    public void release() {
        this.gfJ.release();
    }

    public void destroy() {
        this.gfJ.destroy();
    }

    public void kV(boolean z) {
        this.gfJ.kV(z);
    }

    public void bEi() {
        if (this.gfJ != null) {
            this.gfJ.bEi();
        }
    }

    public void kW(boolean z) {
        if (this.gfJ != null) {
            this.gfJ.kW(z);
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        if (this.gfJ != null) {
            this.gfJ.a(aVar);
        }
    }
}
