package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.Activity;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.liveroom.challenge.panel.d;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends g {
    private String bmv;
    private BdAlertDialog gVt;
    private ViewGroup mContentLayout;
    private BdListView mListView;
    private TbPageContext mPageContext;

    public e(TbPageContext tbPageContext, n nVar) {
        super(tbPageContext.getPageActivity(), nVar);
        this.mPageContext = tbPageContext;
        init();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_latest_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds456) * 2;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gVt != null) {
            this.gVt.dismiss();
        }
        if (this.mListView != null && (this.mListView.getWrappedAdapter() instanceof d)) {
            this.mListView.setSelection(0);
            ((d) this.mListView.getWrappedAdapter()).clearData();
            if (this.mListView.getEmptyView() != null) {
                this.mListView.getEmptyView().setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        if (this.gVK != null) {
            this.gVK.bXP();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HC(String str) {
        this.bmv = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setData(List<com.baidu.live.challenge.d> list) {
        d dVar;
        if (this.mListView != null) {
            if (list == null || list.isEmpty()) {
                a(CommonEmptyView.ImgType.NO_DATA);
                return;
            }
            if (this.mListView.getAdapter2() == null || !(this.mListView.getAdapter2().getWrappedAdapter() instanceof d)) {
                dVar = new d();
                this.mListView.setAdapter((ListAdapter) dVar);
            } else {
                dVar = (d) this.mListView.getAdapter2().getWrappedAdapter();
            }
            if (dVar.bXF() == null) {
                dVar.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.1
                    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.d.a
                    public void e(com.baidu.live.challenge.d dVar2) {
                        if (dVar2 != null && !TextUtils.isEmpty(String.valueOf(dVar2.userId))) {
                            if (e.this.gVK != null) {
                                e.this.gVK.removeView();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(dVar2.userId))));
                        }
                    }

                    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.d.a
                    public void f(com.baidu.live.challenge.d dVar2) {
                        if (e.this.gVK != null && dVar2 != null) {
                            e.this.g(dVar2);
                        }
                    }
                });
            }
            dVar.setData(list);
        }
    }

    public void a(com.baidu.live.challenge.d dVar, boolean z) {
        if (this.mListView != null && (this.mListView.getWrappedAdapter() instanceof d)) {
            ((d) this.mListView.getWrappedAdapter()).a(this.mListView, dVar, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXI() {
        if (this.mListView != null && (this.mListView.getWrappedAdapter() instanceof BaseAdapter)) {
            ((BaseAdapter) this.mListView.getWrappedAdapter()).notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bd(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext, str);
        }
        a(BdNetTypeUtil.isNetWorkAvailable() ? CommonEmptyView.ImgType.SERVER_ERROR : CommonEmptyView.ImgType.NO_NET);
    }

    private void a(CommonEmptyView.ImgType imgType) {
        if (this.mContext != null && this.mContentLayout != null && this.mListView != null) {
            View emptyView = this.mListView.getEmptyView();
            if (!(emptyView instanceof CommonEmptyView)) {
                emptyView = new CommonEmptyView(this.mContext);
            }
            CommonEmptyView commonEmptyView = (CommonEmptyView) emptyView;
            if (this.mContentLayout.indexOfChild(commonEmptyView) < 0) {
                if (this.mContentLayout instanceof RelativeLayout) {
                    commonEmptyView.addToParent((RelativeLayout) this.mContentLayout);
                } else if (this.mContentLayout instanceof FrameLayout) {
                    commonEmptyView.addToParent((FrameLayout) this.mContentLayout);
                }
            }
            commonEmptyView.reset();
            commonEmptyView.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                commonEmptyView.setTitle(a.i.sdk_net_fail_tip);
                commonEmptyView.setRefreshButton(a.i.ala_click_retry, new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (e.this.gVK != null) {
                            e.this.gVK.ge(e.this.bmv);
                        }
                    }
                });
            } else {
                commonEmptyView.setTitle("最近没有跟主播连屏过哦");
            }
            this.mListView.setEmptyView(commonEmptyView);
        }
    }

    private void init() {
        this.mContentLayout = (ViewGroup) this.mRootView.findViewById(a.g.layout_challenge_latest_content);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.lv_challenge_latest);
        this.mRootView.findViewById(a.g.iv_challenge_latest_back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gVK != null) {
                    e.this.gVK.bXP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gVt = new BdAlertDialog((Activity) this.mContext);
            this.gVt.setAutoNight(false);
            this.gVt.setCancelable(false);
            this.gVt.setCanceledOnTouchOutside(false);
            this.gVt.setContentViewSize(1);
            BdAlertDialog bdAlertDialog = this.gVt;
            String string = this.mContext.getString(a.i.ala_challenge_invite_alert_msg);
            Object[] objArr = new Object[1];
            objArr[0] = !TextUtils.isEmpty(dVar.userName) ? dVar.userName : "对方主播";
            bdAlertDialog.setMessage(String.format(string, objArr));
            this.gVt.setPositiveButton(a.i.ala_challenge_confirm, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                    e.this.a(dVar, false);
                    if (e.this.gVK != null) {
                        e.this.gVK.X(dVar.userId);
                    }
                }
            });
            this.gVt.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.e.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gVt.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.gVt.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.gVt.setPositiveButtonTextColor(this.mContext.getResources().getColor(a.d.ala_challenge_latest_primary));
                this.gVt.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.gVt.create(this.mPageContext).show();
        }
    }
}
