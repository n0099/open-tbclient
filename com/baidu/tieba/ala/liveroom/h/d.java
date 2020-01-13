package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.d eWi;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.eWi = new com.baidu.tieba.ala.liveroom.views.d(this.mPageContext);
        this.mRootView = this.eWi.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.eWi != null) {
            this.eWi.a(iShareCallback);
        }
    }

    private void bjL() {
        this.eWi.bjL();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.eWi.a(alaLiveRecorder);
        bjL();
    }

    public boolean bjM() {
        return this.eWi.bjM();
    }

    public boolean bjN() {
        return this.eWi.bjN();
    }

    public String getLiveTitle() {
        return this.eWi.getLiveTitle();
    }

    public boolean bjO() {
        return this.eWi.bjO();
    }

    public boolean bjP() {
        return this.eWi.bjP();
    }

    public void jj(boolean z) {
        this.eWi.jj(z);
    }

    public void bjQ() {
        this.eWi.fiA = false;
    }

    public String bjR() {
        return this.eWi.bjR();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(f.b bVar) {
        this.eWi.a(bVar);
    }

    public void C(boolean z, boolean z2) {
        if (z) {
            this.eWi.onKeyboardVisibilityChanged(false);
        } else {
            this.eWi.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(f.a aVar) {
        this.eWi.a(aVar);
    }

    public void yA(String str) {
        this.eWi.yA(str);
    }

    public void onResume() {
        this.eWi.onResume();
    }

    public void onRefresh() {
        this.eWi.onRefresh();
    }

    public boolean bjS() {
        return this.eWi.bjS();
    }

    public void bjT() {
        this.eWi.bjT();
    }

    public void release() {
        this.eWi.release();
    }

    public void destroy() {
        this.eWi.destroy();
    }

    public void jk(boolean z) {
        this.eWi.jk(z);
    }

    public void bjU() {
        if (this.eWi != null) {
            this.eWi.bjU();
        }
    }
}
