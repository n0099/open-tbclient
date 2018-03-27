package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private com.baidu.tieba.im.forum.detail.a eCb;
    private ForumDetailModel eCc;
    private RecommendForumInfo eCd;
    private List<SimpleThreadInfo> eCe;
    private BarEmotionResponseMessage.ForumEmotionData eCg;
    private String fromType;
    private String mForumId;
    private boolean eCf = false;
    public boolean eCh = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.forum_detail_activity);
        this.eCb = new com.baidu.tieba.im.forum.detail.a(this);
        this.eCb.aIK().a(new a());
        this.eCb.b(new b());
        this.eCc = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        aIy();
        aIA();
    }

    private void aIy() {
        if (l.pa()) {
            this.eCb.showLoading();
            this.eCc.jw(this.mForumId);
            this.eCc.ns(this.mForumId);
            return;
        }
        this.eCb.aIH();
        this.eCb.lc(d.j.game_index_no_network_text);
        showToast(d.j.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aIy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eCb.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCb.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void nr(String str) {
        this.eCb.aIH();
        if (TextUtils.isEmpty(str)) {
            showToast(d.j.neterror);
        } else {
            showToast(str);
        }
        if (l.pa()) {
            this.eCb.lc(d.j.no_data_text);
        } else {
            this.eCb.lc(d.j.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.eCd = forumDetailSocketResponse.getForumInfo();
        this.eCe = forumDetailSocketResponse.getThreadInfoList();
        this.eCf = forumDetailSocketResponse.isBawuShow() == 1;
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        aIz();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.eCd = forumDetailHttpResponse.getForumInfo();
        this.eCe = forumDetailHttpResponse.getThreadInfoList();
        this.eCf = forumDetailHttpResponse.isBawuShow() == 1;
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        aIz();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.eCb.a(barEmotionResponseMessage.data);
            this.eCg = barEmotionResponseMessage.data;
        }
    }

    private void aIz() {
        this.eCb.aIH();
        this.eCb.hideNoDataView();
        if (this.eCd != null || (this.eCe != null && this.eCe.size() > 0)) {
            this.eCh = true;
            this.eCe = cg(this.eCe);
            this.eCb.a(this.eCd, this.eCf, this.applyInfo);
            this.eCb.X(this.eCe);
            return;
        }
        this.eCh = false;
        this.eCb.lc(d.j.no_data_text);
    }

    private List<SimpleThreadInfo> cg(List<SimpleThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (SimpleThreadInfo simpleThreadInfo : list) {
            if (simpleThreadInfo != null) {
                if (i >= 5) {
                    break;
                }
                i++;
                arrayList.add(simpleThreadInfo);
            }
        }
        return arrayList;
    }

    public void clearHistory() {
        if (!TextUtils.isEmpty(this.mForumId)) {
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.mForumId), 4, null, 1)));
            sendMessage(new CustomMessage(2001151, String.valueOf(this.mForumId)));
        }
    }

    private void aIA() {
        this.fromType = getIntent().getStringExtra("from_type");
        if (!StringUtils.isNull(this.fromType)) {
            String str = "";
            if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.fromType.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else if (this.fromType.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
                str = "aio_side_2_sub";
            }
            if (!StringUtils.isNull(str)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
            }
        }
    }

    public String zd() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.bar_info_member_lay) {
            if (this.eCd != null && this.eCd.forum_id != null) {
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.eCd.forum_id), this.eCd.forum_name)));
            }
        } else if (id == d.g.bar_info_clean_lay) {
            this.eCb.aIJ();
        } else if (id == d.g.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.h(this.mForumId, 0))));
        } else if (id == d.g.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
            } else if (this.eCg != null && this.eCg.forum_pkg_status == 1 && !TextUtils.isEmpty(this.eCg.url) && this.eCd != null) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.eCg.url + "?forum_id=" + this.eCd.forum_id)));
            }
        } else if (id == d.g.bar_info_manager_lay && this.eCd != null) {
            aw.Du().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.eCd.forum_name + "&fid=" + this.eCd.forum_id});
            TiebaStatic.log(new ak("c12714"));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.eCc.subscribeBar(false, this.mForumId);
        } else if (!c.Hq().Hs() || !c.Hq().Hy()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.fb(d.j.error_open_personal_single_alloff);
            aVar.b(getResources().getString(d.j.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.AV();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.eCb.setSwitch(false);
                }
            }, 500L);
        } else {
            this.eCc.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes3.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (!ForumDetailActivity.this.eCh) {
                if (z) {
                    ForumDetailActivity.this.eCb.hideNoDataView();
                    ForumDetailActivity.this.eCb.showLoading();
                    ForumDetailActivity.this.eCc.jw(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.eCb.aIH();
                ForumDetailActivity.this.eCb.lc(d.j.game_index_no_network_text);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.pa()) {
                ForumDetailActivity.this.eCb.hideNoDataView();
                ForumDetailActivity.this.eCb.showLoading();
                ForumDetailActivity.this.eCc.jw(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void hu(boolean z) {
        if (z) {
            showToast(d.j.success);
            hw(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.eCb.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void hv(boolean z) {
        if (z) {
            showToast(d.j.success);
            hw(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.eCb.setSwitch(true);
            }
        }, 500L);
    }

    public void hw(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.aLW().h(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.eCb.setSwitch(z);
    }

    public void hx(boolean z) {
        this.eCb.a(this.eCd, z);
    }

    public void hy(boolean z) {
        this.eCb.b(this.eCd, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.eCg != null && this.eCg.forum_pkg_status == 1 && !TextUtils.isEmpty(this.eCg.url) && this.eCd != null) {
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.eCg.url + "?forum_id=" + this.eCd.forum_id)));
        }
    }
}
