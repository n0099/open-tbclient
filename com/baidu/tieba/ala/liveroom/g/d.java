package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c fam;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.fam = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.mRootView = this.fam.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.fam != null) {
            this.fam.a(iShareCallback);
        }
    }

    private void blC() {
        this.fam.blC();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.fam.a(alaLiveRecorder);
        blC();
    }

    public boolean blD() {
        return this.fam.blD();
    }

    public boolean blE() {
        return this.fam.blE();
    }

    public String getLiveTitle() {
        return this.fam.getLiveTitle();
    }

    public boolean blF() {
        return this.fam.blF();
    }

    public boolean blG() {
        return this.fam.blG();
    }

    public void jm(boolean z) {
        this.fam.jm(z);
    }

    public void blH() {
        this.fam.flR = false;
    }

    public String blI() {
        return this.fam.blI();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.fam.a(bVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.fam.onKeyboardVisibilityChanged(false);
        } else {
            this.fam.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.fam.a(aVar);
    }

    public void yV(String str) {
        this.fam.yV(str);
    }

    public void onResume() {
        this.fam.onResume();
    }

    public void onRefresh() {
        this.fam.onRefresh();
    }

    public boolean blJ() {
        return this.fam.blJ();
    }

    public void blK() {
        this.fam.blK();
    }

    public void release() {
        this.fam.release();
    }

    public void destroy() {
        this.fam.destroy();
    }

    public void jn(boolean z) {
        this.fam.jn(z);
    }

    public void blL() {
        if (this.fam != null) {
            this.fam.blL();
        }
    }
}
