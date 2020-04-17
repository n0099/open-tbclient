package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c fET;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.fET = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.fET.f(this.mPageContext);
        this.mRootView = this.fET.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fET != null) {
            this.fET.a(iShareCallback);
        }
    }

    private void buY() {
        this.fET.buY();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.fET.a(alaLiveRecorder);
        buY();
    }

    public boolean buZ() {
        return this.fET.buZ();
    }

    public boolean bva() {
        return this.fET.bva();
    }

    public String getLiveTitle() {
        return this.fET.getLiveTitle();
    }

    public boolean bvb() {
        return this.fET.bvb();
    }

    public boolean bvc() {
        return this.fET.bvc();
    }

    public void kp(boolean z) {
        this.fET.kp(z);
    }

    public void bvd() {
        this.fET.fQM = false;
    }

    public String bve() {
        return this.fET.bve();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.fET.a(bVar);
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.fET.onKeyboardVisibilityChanged(false);
        } else {
            this.fET.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.fET.a(aVar);
    }

    public void AD(String str) {
        this.fET.AD(str);
    }

    public void onResume() {
        this.fET.onResume();
    }

    public void onRefresh() {
        this.fET.onRefresh();
    }

    public boolean bvf() {
        return this.fET.bvf();
    }

    public void bvg() {
        this.fET.bvg();
    }

    public void release() {
        this.fET.release();
    }

    public void destroy() {
        this.fET.destroy();
    }

    public void kq(boolean z) {
        this.fET.kq(z);
    }

    public void bvh() {
        if (this.fET != null) {
            this.fET.bvh();
        }
    }
}
