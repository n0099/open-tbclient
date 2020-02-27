package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c eZY;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.eZY = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.mRootView = this.eZY.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.eZY != null) {
            this.eZY.a(iShareCallback);
        }
    }

    private void blz() {
        this.eZY.blz();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.eZY.a(alaLiveRecorder);
        blz();
    }

    public boolean blA() {
        return this.eZY.blA();
    }

    public boolean blB() {
        return this.eZY.blB();
    }

    public String getLiveTitle() {
        return this.eZY.getLiveTitle();
    }

    public boolean blC() {
        return this.eZY.blC();
    }

    public boolean blD() {
        return this.eZY.blD();
    }

    public void jm(boolean z) {
        this.eZY.jm(z);
    }

    public void blE() {
        this.eZY.flD = false;
    }

    public String blF() {
        return this.eZY.blF();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.eZY.a(bVar);
    }

    public void E(boolean z, boolean z2) {
        if (z) {
            this.eZY.onKeyboardVisibilityChanged(false);
        } else {
            this.eZY.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.eZY.a(aVar);
    }

    public void yU(String str) {
        this.eZY.yU(str);
    }

    public void onResume() {
        this.eZY.onResume();
    }

    public void onRefresh() {
        this.eZY.onRefresh();
    }

    public boolean blG() {
        return this.eZY.blG();
    }

    public void blH() {
        this.eZY.blH();
    }

    public void release() {
        this.eZY.release();
    }

    public void destroy() {
        this.eZY.destroy();
    }

    public void jn(boolean z) {
        this.eZY.jn(z);
    }

    public void blI() {
        if (this.eZY != null) {
            this.eZY.blI();
        }
    }
}
