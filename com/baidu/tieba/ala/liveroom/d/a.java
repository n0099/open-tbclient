package com.baidu.tieba.ala.liveroom.d;

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
/* loaded from: classes3.dex */
public class a {
    private q aLQ;
    private ViewGroup fIb;
    protected c fYc;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean fAa = true;
    private ViewGroup.LayoutParams fYb = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.fIb = viewGroup;
        bvX();
    }

    private void bvX() {
        this.mParentView = new FrameLayout(this.fIb.getContext());
        this.mParentView.setId(a.g.ala_live_room_back_to_target);
        this.mParentView.setBackgroundColor(0);
        this.fIb.addView(this.mParentView, this.fYb);
    }

    public void a(q qVar, b bVar) {
        if (qVar != null && qVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aLQ = qVar;
            if (this.mParentView == null || this.fIb.indexOfChild(this.mParentView) < 0) {
                bvX();
                this.mParentView.setVisibility(this.fAa ? 0 : 8);
            }
            if (this.fYc == null || (this.mParentView != null && this.mParentView.indexOfChild(this.fYc.getView()) < 0)) {
                this.fYc = new c(this.mTbPageContext);
                this.mParentView.addView(this.fYc.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.fYc.bCn().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fYc.bCm();
                        a.this.fYc.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.rr(a.i.ala_back_to_come_title);
            this.fYc.a(bVar2);
            this.fYc.show();
        }
    }

    public void cA(int i) {
        View bCn;
        LinearLayout.LayoutParams layoutParams;
        if (this.fYc != null && (bCn = this.fYc.bCn()) != null && (layoutParams = (LinearLayout.LayoutParams) bCn.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.fYc.show();
            } else if (i == 2) {
                this.fYc.hide();
            }
            bCn.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.fAa = true;
        jx(z);
    }

    private void jx(boolean z) {
        if (this.fYc != null && this.fYc.getView() != null && (this.fYc.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fYc.getView().getParent()).removeView(this.fYc.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
