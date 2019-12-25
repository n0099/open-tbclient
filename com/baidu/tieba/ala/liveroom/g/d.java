package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.d eUw;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.eUw = new com.baidu.tieba.ala.liveroom.views.d(this.mPageContext);
        this.mRootView = this.eUw.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.eUw != null) {
            this.eUw.a(iShareCallback);
        }
    }

    private void biZ() {
        this.eUw.biZ();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.eUw.a(alaLiveRecorder);
        biZ();
    }

    public boolean bja() {
        return this.eUw.bja();
    }

    public boolean bjb() {
        return this.eUw.bjb();
    }

    public String getLiveTitle() {
        return this.eUw.getLiveTitle();
    }

    public boolean bjc() {
        return this.eUw.bjc();
    }

    public boolean bjd() {
        return this.eUw.bjd();
    }

    public void ja(boolean z) {
        this.eUw.ja(z);
    }

    public void bje() {
        this.eUw.ffp = false;
    }

    public String bjf() {
        return this.eUw.bjf();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(f.b bVar) {
        this.eUw.a(bVar);
    }

    public void C(boolean z, boolean z2) {
        if (z) {
            this.eUw.onKeyboardVisibilityChanged(false);
        } else {
            this.eUw.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(f.a aVar) {
        this.eUw.a(aVar);
    }

    public void yw(String str) {
        this.eUw.yw(str);
    }

    public void onResume() {
        this.eUw.onResume();
    }

    public void onRefresh() {
        this.eUw.onRefresh();
    }

    public boolean bjg() {
        return this.eUw.bjg();
    }

    public void bjh() {
        this.eUw.bjh();
    }

    public void release() {
        this.eUw.release();
    }

    public void destroy() {
        this.eUw.destroy();
    }

    public void jb(boolean z) {
        this.eUw.jb(z);
    }

    public void bji() {
        if (this.eUw != null) {
            this.eUw.bji();
        }
    }
}
