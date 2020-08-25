package com.baidu.tieba.ala.liveroom.v;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.r;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class a {
    private r aAh;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gIj != null && view == a.this.gIj.getView() && !UtilHelper.isFastDoubleClick()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                    alaStaticItem.addParams("other_params", a.this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (!com.baidu.live.t.a.MF().MG().c(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.gIk = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.aAh, a.this.otherParams);
                    a.this.gIk.show();
                }
            }
        }
    };
    private ViewGroup fZu;
    protected b gIj;
    private c gIk;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean d(ViewGroup viewGroup, r rVar) {
        if (viewGroup == null) {
            return false;
        }
        this.aAh = rVar;
        if (this.gIj == null) {
            this.gIj = new b(getPageContext(), rVar.aEd, this.eFC);
        }
        if (this.fZu != null && this.fZu.indexOfChild(this.gIj.getView()) > 0) {
            this.fZu.removeView(this.gIj.getView());
        }
        this.fZu = viewGroup;
        this.gIj.getView().setId(a.g.guide_rename_view);
        this.gIj.getView().setVisibility(0);
        initTasks();
        bWl();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bWl() {
        com.baidu.live.t.a.MF().a(new com.baidu.live.t.c() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
        });
    }

    private void Gu(String str) {
        if (this.aAh != null) {
            bWm();
            if (this.gIk != null && this.gIk.isShowing()) {
                this.gIk.onSuccess();
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.aAh != null && this.aAh.mLiveInfo != null) {
                l(this.aAh.mLiveInfo.live_id, 1);
            }
        }
    }

    private void Gv(String str) {
        if (this.gIk != null && this.gIk.isShowing()) {
            this.gIk.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void Q(Intent intent) {
        if (intent == null) {
            Gv(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            Gu(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            Gv(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void e(ViewGroup viewGroup, r rVar) {
        if (d(viewGroup, rVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gIj.getView(), layoutParams);
        }
    }

    public void bWm() {
        if (this.fZu != null && this.fZu.indexOfChild(this.gIj.getView()) > 0) {
            this.fZu.removeView(this.gIj.getView());
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

    public void l(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021125);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("no_cache", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1021125);
    }
}
