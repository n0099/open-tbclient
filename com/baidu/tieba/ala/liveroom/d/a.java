package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private q aJj;
    protected c fMS;
    private ViewGroup fox;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean foD = true;
    private ViewGroup.LayoutParams foy = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fox = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bta();
    }

    private void bta() {
        this.mParentView = new FrameLayout(this.fox.getContext());
        this.mParentView.setBackgroundColor(0);
        this.fox.addView(this.mParentView, this.foy);
    }

    public void a(q qVar, b bVar) {
        if (qVar != null && qVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.aJj = qVar;
            if (this.mParentView == null || this.fox.indexOfChild(this.mParentView) < 0) {
                bta();
                this.mParentView.setVisibility(this.foD ? 0 : 8);
            }
            if (this.fMS == null || (this.mParentView != null && this.mParentView.indexOfChild(this.fMS.getView()) < 0)) {
                this.fMS = new c(this.mTbPageContext);
                this.mParentView.addView(this.fMS.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.fMS.bzx().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.fMS.bzw();
                        a.this.fMS.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.qR(a.i.ala_back_to_come_title);
            this.fMS.a(bVar2);
            this.fMS.show();
        }
    }

    public void cs(int i) {
        View bzx;
        LinearLayout.LayoutParams layoutParams;
        if (this.fMS != null && (bzx = this.fMS.bzx()) != null && (layoutParams = (LinearLayout.LayoutParams) bzx.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.fMS.show();
            } else if (i == 2) {
                this.fMS.hide();
            }
            bzx.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.foD = true;
        jk(z);
    }

    private void jk(boolean z) {
        if (this.fMS != null && this.fMS.getView() != null && (this.fMS.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fMS.getView().getParent()).removeView(this.fMS.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
