package com.baidu.tieba.ala.liveroom.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private m ald;
    protected c eTF;
    private ViewGroup ewd;
    private ViewGroup mParentView;
    private TbPageContext mTbPageContext;
    private boolean ewj = true;
    private ViewGroup.LayoutParams ewe = new ViewGroup.LayoutParams(-2, -1);

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ewd = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.g.live_root_view);
        bdQ();
    }

    private void bdQ() {
        this.mParentView = new FrameLayout(this.ewd.getContext());
        this.mParentView.setBackgroundColor(0);
        this.ewd.addView(this.mParentView, this.ewe);
    }

    public void a(m mVar, b bVar) {
        if (mVar != null && mVar.mLiveInfo != null && !TextUtils.isEmpty(TbConfig.getLiveEnterFrom()) && bVar != null) {
            this.ald = mVar;
            if (this.mParentView == null || this.ewd.indexOfChild(this.mParentView) < 0) {
                bdQ();
                this.mParentView.setVisibility(this.ewj ? 0 : 8);
            }
            if (this.eTF == null || (this.mParentView != null && this.mParentView.indexOfChild(this.eTF.getView()) < 0)) {
                this.eTF = new c(this.mTbPageContext);
                this.mParentView.addView(this.eTF.getView(), new FrameLayout.LayoutParams(-2, -1));
                this.eTF.bjY().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.eTF.bjX();
                        a.this.eTF.hide();
                    }
                });
            }
            b bVar2 = new b();
            bVar2.setTitle(bVar.getTitle());
            bVar2.setImageUrl(bVar.getImageUrl());
            bVar2.setScheme(bVar.getScheme());
            bVar2.setImageId(a.f.back_to_come_logo);
            bVar2.pU(a.i.ala_back_to_come_title);
            this.eTF.a(bVar2);
            this.eTF.show();
        }
    }

    public void bW(int i) {
        View bjY;
        LinearLayout.LayoutParams layoutParams;
        if (this.eTF != null && (bjY = this.eTF.bjY()) != null && (layoutParams = (LinearLayout.LayoutParams) bjY.getLayoutParams()) != null) {
            if (i == 1) {
                layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds288);
                this.eTF.show();
            } else if (i == 2) {
                this.eTF.hide();
            }
            bjY.setLayoutParams(layoutParams);
        }
    }

    public void onDestory() {
        reset(true);
    }

    private void reset(boolean z) {
        this.ewj = true;
        hS(z);
    }

    private void hS(boolean z) {
        if (this.eTF != null && this.eTF.getView() != null && (this.eTF.getView().getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eTF.getView().getParent()).removeView(this.eTF.getView());
        }
        if (z && this.mParentView != null && (this.mParentView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.mParentView.getParent()).removeView(this.mParentView);
        }
    }
}
