package com.baidu.tieba.ala.liveroom.h;

import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public class d {
    private com.baidu.tieba.ala.liveroom.views.c hgu;
    private TbPageContext mPageContext;
    private View mRootView;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        init();
    }

    private void init() {
        this.hgu = new com.baidu.tieba.ala.liveroom.views.c(this.mPageContext);
        this.hgu.setTbPageContext(this.mPageContext);
        this.mRootView = this.hgu.getView();
    }

    public void a(IShareCallback iShareCallback) {
        if (this.hgu != null) {
            this.hgu.a(iShareCallback);
        }
    }

    private void cbg() {
        this.hgu.cbg();
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(AlaLiveRecorder alaLiveRecorder, int i) {
        this.hgu.c(alaLiveRecorder);
        cbg();
    }

    public boolean cbh() {
        return this.hgu.cbh();
    }

    public boolean cbi() {
        return this.hgu.cbi();
    }

    public String getLiveTitle() {
        return this.hgu.getLiveTitle();
    }

    public boolean cbj() {
        return this.hgu.cbj();
    }

    public boolean cbk() {
        return this.hgu.cbk();
    }

    public void ne(boolean z) {
        this.hgu.ne(z);
    }

    public void cbl() {
        this.hgu.hul = false;
    }

    public String cbm() {
        return this.hgu.cbm();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }

    public int getVisibility() {
        return this.mRootView.getVisibility();
    }

    public void a(e.b bVar) {
        this.hgu.a(bVar);
    }

    public void P(boolean z, boolean z2) {
        if (z) {
            this.hgu.onKeyboardVisibilityChanged(false);
        } else {
            this.hgu.onKeyboardVisibilityChanged(z2);
        }
    }

    public void a(e.a aVar) {
        this.hgu.a(aVar);
    }

    public void HX(String str) {
        this.hgu.HX(str);
    }

    public void onResume() {
        this.hgu.onResume();
    }

    public void onRefresh() {
        this.hgu.onRefresh();
    }

    public boolean cbn() {
        return this.hgu.cbn();
    }

    public void cbo() {
        this.hgu.cbo();
    }

    public void release() {
        this.hgu.release();
    }

    public void destroy() {
        this.hgu.destroy();
    }

    public void nf(boolean z) {
        this.hgu.nf(z);
    }

    public void cbp() {
        if (this.hgu != null) {
            this.hgu.cbp();
        }
    }

    public void ng(boolean z) {
        if (this.hgu != null) {
            this.hgu.ng(z);
        }
    }

    public void a(com.baidu.live.k.a aVar) {
        if (this.hgu != null) {
            this.hgu.a(aVar);
        }
    }
}
