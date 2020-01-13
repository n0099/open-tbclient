package com.baidu.tieba.ala.liveroom.v;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.data.l;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class a {
    private l aiW;
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fgJ != null && view == a.this.fgJ.getView() && !UtilHelper.isFastDoubleClick()) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                    alaStaticItem.addParams("other_params", a.this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                if (!com.baidu.live.o.a.wN().wO().d(a.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_RENAME)) {
                    a.this.fgK = new c(a.this.mTbPageContext.getPageActivity(), a.this.mTbPageContext, a.this.aiW, a.this.otherParams);
                    a.this.fgK.show();
                }
            }
        }
    };
    private ViewGroup erT;
    protected b fgJ;
    private c fgK;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean e(ViewGroup viewGroup, l lVar) {
        if (viewGroup == null) {
            return false;
        }
        this.aiW = lVar;
        if (this.fgJ == null) {
            this.fgJ = new b(getPageContext(), lVar.Wt, this.dmY);
        }
        if (this.erT != null && this.erT.indexOfChild(this.fgJ.getView()) > 0) {
            this.erT.removeView(this.fgJ.getView());
        }
        this.erT = viewGroup;
        this.fgJ.getView().setId(a.g.guide_rename_view);
        this.fgJ.getView().setVisibility(0);
        initTasks();
        boG();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void boG() {
        com.baidu.live.o.a.wN().a(new com.baidu.live.o.c() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
        });
    }

    private void yX(String str) {
        if (this.aiW != null) {
            boH();
            if (this.fgK != null && this.fgK.isShowing()) {
                this.fgK.onSuccess();
            }
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_SUC);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
            if (this.mTbPageContext != null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
            }
            if (this.aiW != null && this.aiW.mLiveInfo != null) {
                k(this.aiW.mLiveInfo.live_id, 1);
            }
        }
    }

    private void yY(String str) {
        if (this.fgK != null && this.fgK.isShowing()) {
            this.fgK.onFail();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mTbPageContext.showToast(str);
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void ae(Intent intent) {
        if (intent == null) {
            yY(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        } else if (intent.getBooleanExtra("isModifySuccess", false)) {
            yX(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_success_toast));
        } else {
            yY(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_rename_fail_toast));
        }
    }

    public void f(ViewGroup viewGroup, l lVar) {
        if (e(viewGroup, lVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fgJ.getView(), layoutParams);
        }
    }

    public void boH() {
        if (this.erT != null && this.erT.indexOfChild(this.fgJ.getView()) > 0) {
            this.erT.removeView(this.fgJ.getView());
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
