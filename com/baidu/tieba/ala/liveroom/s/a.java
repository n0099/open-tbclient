package com.baidu.tieba.ala.liveroom.s;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.k;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class a {
    private k aio;
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fdD != null && view == a.this.fdD.getView() && !UtilHelper.isFastDoubleClick()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                alaStaticItem.addParams("other_params", a.this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                if (!com.baidu.live.n.a.ww().wx().d(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.fdE = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.aio, a.this.otherParams);
                    a.this.fdE.show();
                }
            }
        }
    };
    private ViewGroup eqG;
    protected b fdD;
    private c fdE;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean e(ViewGroup viewGroup, k kVar) {
        if (viewGroup == null) {
            return false;
        }
        this.aio = kVar;
        if (this.fdD == null) {
            this.fdD = new b(getPageContext(), kVar.Wc, this.dmK);
        }
        if (this.eqG != null && this.eqG.indexOfChild(this.fdD.getView()) > 0) {
            this.eqG.removeView(this.fdD.getView());
        }
        this.eqG = viewGroup;
        this.fdD.getView().setId(a.g.guide_rename_view);
        this.fdD.getView().setVisibility(0);
        initTasks();
        bnG();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bnG() {
        com.baidu.live.n.a.ww().a(new com.baidu.live.n.c() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
        });
    }

    private void yO(String str) {
        if (this.aio != null) {
            bnH();
            if (this.fdE != null && this.fdE.isShowing()) {
                this.fdE.onSuccess();
            }
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.aio != null && this.aio.mLiveInfo != null) {
                k(this.aio.mLiveInfo.live_id, 1);
            }
        }
    }

    private void yP(String str) {
        if (this.fdE != null && this.fdE.isShowing()) {
            this.fdE.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void ae(Intent intent) {
        if (intent == null) {
            yP(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            yO(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            yP(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void f(ViewGroup viewGroup, k kVar) {
        if (e(viewGroup, kVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fdD.getView(), layoutParams);
        }
    }

    public void bnH() {
        if (this.eqG != null && this.eqG.indexOfChild(this.fdD.getView()) > 0) {
            this.eqG.removeView(this.fdD.getView());
        }
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021125, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getUserInfo");
        tbHttpMessageTask.setResponsedClass(GetUserInfoHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void k(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021125);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("no_cache", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021125);
    }
}
