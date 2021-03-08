package com.baidu.tieba.ala.liveroom.g;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hDh;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hDh = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hDh.setTbPageContext(this.mPageContext);
        this.mRootView = this.hDh.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hDh != null) {
            this.hDh.a(iShareCallback);
        }
    }

    private void ceC() {
        this.hDh.ceC();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hDh.c(alaLiveRecorder);
        ceC();
    }

    public boolean ceD() {
        return this.hDh.ceD();
    }

    public boolean ceE() {
        return this.hDh.ceE();
    }

    public String getLiveTitle() {
        return this.hDh.getLiveTitle();
    }

    public boolean ceF() {
        return this.hDh.ceF();
    }

    public boolean ceG() {
        return this.hDh.ceG();
    }

    public void oh(boolean z) {
        this.hDh.oh(z);
    }

    public void ceH() {
        this.hDh.hRi = false;
    }

    public String ceI() {
        return this.hDh.ceI();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hDh.a(bVar);
    }

    public void R(boolean z, boolean z2) {
        if (z) {
            this.hDh.onKeyboardVisibilityChanged(false);
        } else {
            this.hDh.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hDh.a(aVar);
    }

    public void HR(String str) {
        this.hDh.HR(str);
    }

    public void onResume() {
        this.hDh.onResume();
    }

    public void onRefresh() {
        this.hDh.onRefresh();
    }

    public boolean ceJ() {
        return this.hDh.ceJ();
    }

    public void ceK() {
        this.hDh.ceK();
    }

    public void release() {
        this.hDh.release();
    }

    public void destroy() {
        this.hDh.destroy();
    }

    public void oi(boolean z) {
        this.hDh.oi(z);
    }

    public void ceL() {
        if (this.hDh != null) {
            this.hDh.ceL();
        }
    }

    public void oj(boolean z) {
        if (this.hDh != null) {
            this.hDh.oj(z);
        }
    }

    public void a(com.baidu.live.m.a aVar) {
        if (this.hDh != null) {
            this.hDh.a(aVar);
        }
    }
}
