package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.d efs;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.efs = new com.baidu.tieba.ala.liveroom.views.d(this.mPageContext);
        this.mRootView = this.efs.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.efs != null) {
            this.efs.a(iShareCallback);
        }
    }

    private void aRA() {
        this.efs.aRA();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.efs.a(alaLiveRecorder);
        aRA();
    }

    public boolean aRB() {
        return this.efs.aRB();
    }

    public boolean aRC() {
        return this.efs.aRC();
    }

    public String getLiveTitle() {
        return this.efs.getLiveTitle();
    }

    public boolean aRD() {
        return this.efs.aRD();
    }

    public boolean aRE() {
        return this.efs.aRE();
    }

    public void hL(boolean z) {
        this.efs.hL(z);
    }

    public void aRF() {
        this.efs.epM = false;
    }

    public String aRG() {
        return this.efs.aRG();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(f.b bVar) {
        this.efs.a(bVar);
    }

    public void C(boolean z, boolean z2) {
        if (z) {
            this.efs.onKeyboardVisibilityChanged(false);
        } else {
            this.efs.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(f.a aVar) {
        this.efs.a(aVar);
    }

    public void tH(String str) {
        this.efs.tH(str);
    }

    public void onResume() {
        this.efs.onResume();
    }

    public void onRefresh() {
        this.efs.onRefresh();
    }

    public boolean aRH() {
        return this.efs.aRH();
    }

    public void aRI() {
        this.efs.aRI();
    }

    public void release() {
        this.efs.release();
    }

    public void destroy() {
        this.efs.destroy();
    }

    public void hM(boolean z) {
        this.efs.hM(z);
    }

    public void aRJ() {
        if (this.efs != null) {
            this.efs.aRJ();
        }
    }
}
