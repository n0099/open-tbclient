package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c eZZ;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.eZZ = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.mRootView = this.eZZ.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.eZZ != null) {
            this.eZZ.a(iShareCallback);
        }
    }

    private void blB() {
        this.eZZ.blB();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.eZZ.a(alaLiveRecorder);
        blB();
    }

    public boolean blC() {
        return this.eZZ.blC();
    }

    public boolean blD() {
        return this.eZZ.blD();
    }

    public String getLiveTitle() {
        return this.eZZ.getLiveTitle();
    }

    public boolean blE() {
        return this.eZZ.blE();
    }

    public boolean blF() {
        return this.eZZ.blF();
    }

    public void jm(boolean z) {
        this.eZZ.jm(z);
    }

    public void blG() {
        this.eZZ.flE = false;
    }

    public String blH() {
        return this.eZZ.blH();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.eZZ.a(bVar);
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.eZZ.onKeyboardVisibilityChanged(false);
        } else {
            this.eZZ.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.eZZ.a(aVar);
    }

    public void yU(String str) {
        this.eZZ.yU(str);
    }

    public void onResume() {
        this.eZZ.onResume();
    }

    public void onRefresh() {
        this.eZZ.onRefresh();
    }

    public boolean blI() {
        return this.eZZ.blI();
    }

    public void blJ() {
        this.eZZ.blJ();
    }

    public void release() {
        this.eZZ.release();
    }

    public void destroy() {
        this.eZZ.destroy();
    }

    public void jn(boolean z) {
        this.eZZ.jn(z);
    }

    public void blK() {
        if (this.eZZ != null) {
            this.eZZ.blK();
        }
    }
}
