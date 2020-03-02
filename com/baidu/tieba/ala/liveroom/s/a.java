package com.baidu.tieba.ala.liveroom.s;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.m;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private m ald;
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fjQ != null && view == a.this.fjQ.getView() && !UtilHelper.isFastDoubleClick()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                    alaStaticItem.addParams("other_params", a.this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (!com.baidu.live.r.a.zh().zi().d(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.fjR = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.ald, a.this.otherParams);
                    a.this.fjR.show();
                }
            }
        }
    };
    private ViewGroup ewe;
    protected b fjQ;
    private c fjR;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean d(ViewGroup viewGroup, m mVar) {
        if (viewGroup == null) {
            return false;
        }
        this.ald = mVar;
        if (this.fjQ == null) {
            this.fjQ = new b(getPageContext(), mVar.Ye, this.dri);
        }
        if (this.ewe != null && this.ewe.indexOfChild(this.fjQ.getView()) > 0) {
            this.ewe.removeView(this.fjQ.getView());
        }
        this.ewe = viewGroup;
        this.fjQ.getView().setId(a.g.guide_rename_view);
        this.fjQ.getView().setVisibility(0);
        initTasks();
        bqo();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bqo() {
        com.baidu.live.r.a.zh().a(new com.baidu.live.r.c() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
        });
    }

    private void zp(String str) {
        if (this.ald != null) {
            bqp();
            if (this.fjR != null && this.fjR.isShowing()) {
                this.fjR.onSuccess();
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.ald != null && this.ald.mLiveInfo != null) {
                k(this.ald.mLiveInfo.live_id, 1);
            }
        }
    }

    private void zq(String str) {
        if (this.fjR != null && this.fjR.isShowing()) {
            this.fjR.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void ae(Intent intent) {
        if (intent == null) {
            zq(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            zp(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            zq(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void e(ViewGroup viewGroup, m mVar) {
        if (d(viewGroup, mVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fjQ.getView(), layoutParams);
        }
    }

    public void bqp() {
        if (this.ewe != null && this.ewe.indexOfChild(this.fjQ.getView()) > 0) {
            this.ewe.removeView(this.fjQ.getView());
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
