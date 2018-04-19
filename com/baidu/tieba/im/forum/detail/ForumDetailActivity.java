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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
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
    private com.baidu.tieba.im.forum.detail.a dWF;
    private ForumDetailModel dWG;
    private RecommendForumInfo dWH;
    private List<SimpleThreadInfo> dWI;
    private BarEmotionResponseMessage.ForumEmotionData dWK;
    private String fromType;
    private String mForumId;
    private boolean dWJ = false;
    public boolean dWL = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.forum_detail_activity);
        this.dWF = new com.baidu.tieba.im.forum.detail.a(this);
        this.dWF.aDH().a(new a());
        this.dWF.b(new b());
        this.dWG = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        aDw();
        aDy();
    }

    private void aDw() {
        if (l.hg()) {
            this.dWF.showLoading();
            this.dWG.jA(this.mForumId);
            this.dWG.nw(this.mForumId);
            return;
        }
        this.dWF.atM();
        this.dWF.ij(d.k.game_index_no_network_text);
        showToast(d.k.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aDw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dWF.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dWF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void nv(String str) {
        this.dWF.atM();
        if (TextUtils.isEmpty(str)) {
            showToast(d.k.neterror);
        } else {
            showToast(str);
        }
        if (l.hg()) {
            this.dWF.ij(d.k.no_data_text);
        } else {
            this.dWF.ij(d.k.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.dWH = forumDetailSocketResponse.getForumInfo();
        this.dWI = forumDetailSocketResponse.getThreadInfoList();
        this.dWJ = forumDetailSocketResponse.isBawuShow() == 1;
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        aDx();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.dWH = forumDetailHttpResponse.getForumInfo();
        this.dWI = forumDetailHttpResponse.getThreadInfoList();
        this.dWJ = forumDetailHttpResponse.isBawuShow() == 1;
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        aDx();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.dWF.a(barEmotionResponseMessage.data);
            this.dWK = barEmotionResponseMessage.data;
        }
    }

    private void aDx() {
        this.dWF.atM();
        this.dWF.hideNoDataView();
        if (this.dWH != null || (this.dWI != null && this.dWI.size() > 0)) {
            this.dWL = true;
            this.dWI = bZ(this.dWI);
            this.dWF.a(this.dWH, this.dWJ, this.applyInfo);
            this.dWF.O(this.dWI);
            return;
        }
        this.dWL = false;
        this.dWF.ij(d.k.no_data_text);
    }

    private List<SimpleThreadInfo> bZ(List<SimpleThreadInfo> list) {
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

    private void aDy() {
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

    public String rG() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == d.g.bar_info_member_lay) {
            if (this.dWH != null && this.dWH.forum_id != null) {
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.dWH.forum_id), this.dWH.forum_name)));
            }
        } else if (id == d.g.bar_info_clean_lay) {
            this.dWF.aDG();
        } else if (id == d.g.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(this.mForumId, 0))));
        } else if (id == d.g.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
            } else if (this.dWK != null && this.dWK.forum_pkg_status == 1 && !TextUtils.isEmpty(this.dWK.url) && this.dWH != null) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.dWK.url + "?forum_id=" + this.dWH.forum_id)));
            }
        } else if (id == d.g.bar_info_manager_lay && this.dWH != null) {
            ax.wg().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.dWH.forum_name + "&fid=" + this.dWH.forum_id});
            TiebaStatic.log(new al("c12714"));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view2, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.dWG.subscribeBar(false, this.mForumId);
        } else if (!c.Ae().Ag() || !c.Ae().Am()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.bZ(d.k.error_open_personal_single_alloff);
            aVar.b(getResources().getString(d.k.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.tD();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.dWF.setSwitch(false);
                }
            }, 500L);
        } else {
            this.dWG.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes3.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (!ForumDetailActivity.this.dWL) {
                if (z) {
                    ForumDetailActivity.this.dWF.hideNoDataView();
                    ForumDetailActivity.this.dWF.showLoading();
                    ForumDetailActivity.this.dWG.jA(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.dWF.atM();
                ForumDetailActivity.this.dWF.ij(d.k.game_index_no_network_text);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (l.hg()) {
                ForumDetailActivity.this.dWF.hideNoDataView();
                ForumDetailActivity.this.dWF.showLoading();
                ForumDetailActivity.this.dWG.jA(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void gU(boolean z) {
        if (z) {
            showToast(d.k.success);
            gW(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.dWF.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void gV(boolean z) {
        if (z) {
            showToast(d.k.success);
            gW(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.dWF.setSwitch(true);
            }
        }, 500L);
    }

    public void gW(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    com.baidu.tieba.im.settingcache.d.aGW().i(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.dWF.setSwitch(z);
    }

    public void gX(boolean z) {
        this.dWF.a(this.dWH, z);
    }

    public void gY(boolean z) {
        this.dWF.b(this.dWH, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.dWK != null && this.dWK.forum_pkg_status == 1 && !TextUtils.isEmpty(this.dWK.url) && this.dWH != null) {
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.dWK.url + "?forum_id=" + this.dWH.forum_id)));
        }
    }
}
