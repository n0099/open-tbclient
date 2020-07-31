package com.baidu.tieba.ala.liveroom.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private q avf;
    private ViewGroup fNw;
    protected c gdj;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fFh = true;
    private ViewGroup.LayoutParams gdi = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.fNw = viewGroup;
        bzi();
    }

    private void bzi() {
        this.mParentView = new FrameLayout(this.fNw.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.fNw.addView(this.mParentView, this.gdi);
    }

    public void a(q qVar, b bVar) {
        if (qVar != null && qVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.avf = qVar;
            if (this.mParentView == null || this.fNw.indexOfChild(this.mParentView) < 0) {
                bzi();
                this.mParentView.setVisibility(this.fFh ? 0 : 8);
            }
            if (this.gdj == null || (this.mParentView != null && this.mParentView.indexOfChild(this.gdj.getView()) < 0)) {
                this.gdj = new c(this.mTbPageContext);
                this.mParentView.addView(this.gdj.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.gdj.bFy().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.gdj.bFx();
                        a.this.gdj.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.rH(a.i.ala_back_to_come_title);
            this.gdj.a(bVar2);
            this.gdj.show();
        }
    }

    public void bN(int i) {
        View bFy;
        LinearLayout.LayoutParams layoutParams;
        if (this.gdj != null && (bFy = this.gdj.bFy()) != null && (layoutParams = (LinearLayout.LayoutParams) bFy.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.gdj.show();
            } else if (i == 2) {
                this.gdj.hide();
            }
            bFy.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.fFh = true;
        kb(z);
    }

    private void kb(boolean z) {
        if (this.gdj != null && this.gdj.getView() != null && (this.gdj.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gdj.getView().getParent()).removeView(this.gdj.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
