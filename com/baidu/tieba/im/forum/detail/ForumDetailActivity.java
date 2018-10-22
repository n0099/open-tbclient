package com.baidu.tieba.im.forum.detail;

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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailModel;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements BdSwitchView.a, ForumDetailModel.a {
    private ManagerApplyInfo applyInfo;
    private com.baidu.tieba.im.forum.detail.a eFK;
    private ForumDetailModel eFL;
    private RecommendForumInfo eFM;
    private List<SimpleThreadInfo> eFN;
    private BarEmotionResponseMessage.ForumEmotionData eFP;
    private String fromType;
    private String mForumId;
    private boolean eFO = false;
    public boolean eFQ = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.forum_detail_activity);
        this.eFK = new com.baidu.tieba.im.forum.detail.a(this);
        this.eFK.aPJ().a(new a());
        this.eFK.b(new b());
        this.eFL = new ForumDetailModel(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        aPy();
        aPA();
    }

    private void aPy() {
        if (l.lo()) {
            this.eFK.showLoading();
            this.eFL.sendMessage(this.mForumId);
            this.eFL.pz(this.mForumId);
            return;
        }
        this.eFK.aEH();
        this.eFK.jq(e.j.game_index_no_network_text);
        showToast(e.j.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        aPy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eFK.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eFK.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void py(String str) {
        this.eFK.aEH();
        if (TextUtils.isEmpty(str)) {
            showToast(e.j.neterror);
        } else {
            showToast(str);
        }
        if (l.lo()) {
            this.eFK.jq(e.j.no_data_text);
        } else {
            this.eFK.jq(e.j.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.eFM = forumDetailSocketResponse.getForumInfo();
        this.eFN = forumDetailSocketResponse.getThreadInfoList();
        this.eFO = forumDetailSocketResponse.isBawuShow() == 1;
        this.applyInfo = forumDetailSocketResponse.getApplyInfo();
        aPz();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.eFM = forumDetailHttpResponse.getForumInfo();
        this.eFN = forumDetailHttpResponse.getThreadInfoList();
        this.eFO = forumDetailHttpResponse.isBawuShow() == 1;
        this.applyInfo = forumDetailHttpResponse.getApplyInfo();
        aPz();
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void a(BarEmotionResponseMessage barEmotionResponseMessage) {
        if (barEmotionResponseMessage != null) {
            this.eFK.a(barEmotionResponseMessage.data);
            this.eFP = barEmotionResponseMessage.data;
        }
    }

    private void aPz() {
        this.eFK.aEH();
        this.eFK.hideNoDataView();
        if (this.eFM != null || (this.eFN != null && this.eFN.size() > 0)) {
            this.eFQ = true;
            this.eFN = cB(this.eFN);
            this.eFK.a(this.eFM, this.eFO, this.applyInfo);
            this.eFK.ab(this.eFN);
            return;
        }
        this.eFQ = false;
        this.eFK.jq(e.j.no_data_text);
    }

    private List<SimpleThreadInfo> cB(List<SimpleThreadInfo> list) {
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

    private void aPA() {
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
                TiebaStatic.eventStat(getPageContext().getPageActivity(), str, AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    }

    public String yj() {
        return this.fromType;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.bar_info_member_lay) {
            if (this.eFM != null && this.eFM.forum_id != null) {
                sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(getActivity(), String.valueOf(this.eFM.forum_id), this.eFM.forum_name)));
            }
        } else if (id == e.g.bar_info_clean_lay) {
            this.eFK.aPI();
        } else if (id == e.g.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(this.mForumId, 0))));
        } else if (id == e.g.bar_info_emotion_layout) {
            if (!TbadkApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
            } else if (this.eFP != null && this.eFP.forum_pkg_status == 1 && !TextUtils.isEmpty(this.eFP.url) && this.eFM != null) {
                sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.eFP.url + "?forum_id=" + this.eFM.forum_id)));
            }
        } else if (id == e.g.bar_info_manager_lay && this.eFM != null) {
            ay.CU().c(getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/bawuindex?fn=" + this.eFM.forum_name + "&fid=" + this.eFM.forum_id});
            TiebaStatic.log(new am("c12714"));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.eFL.subscribeBar(false, this.mForumId);
        } else if (!c.Hg().Hi() || !c.Hg().Ho()) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cz(e.j.error_open_personal_single_alloff);
            aVar.b(getResources().getString(e.j.signallforum_signnow), new a.b() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.Au();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    ForumDetailActivity.this.eFK.setSwitch(false);
                }
            }, 500L);
        } else {
            this.eFL.subscribeBar(true, this.mForumId);
        }
    }

    /* loaded from: classes3.dex */
    class a implements NoNetworkView.a {
        a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (!ForumDetailActivity.this.eFQ) {
                if (z) {
                    ForumDetailActivity.this.eFK.hideNoDataView();
                    ForumDetailActivity.this.eFK.showLoading();
                    ForumDetailActivity.this.eFL.sendMessage(ForumDetailActivity.this.mForumId);
                    return;
                }
                ForumDetailActivity.this.eFK.aEH();
                ForumDetailActivity.this.eFK.jq(e.j.game_index_no_network_text);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.lo()) {
                ForumDetailActivity.this.eFK.hideNoDataView();
                ForumDetailActivity.this.eFK.showLoading();
                ForumDetailActivity.this.eFL.sendMessage(ForumDetailActivity.this.mForumId);
            }
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    public void ie(boolean z) {
        if (z) {
            showToast(e.j.success);
            ig(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.eFK.setSwitch(false);
            }
        }, 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.ForumDetailModel.a
    /* renamed from: if  reason: not valid java name */
    public void mo19if(boolean z) {
        if (z) {
            showToast(e.j.success);
            ig(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ForumDetailActivity.this.eFK.setSwitch(true);
            }
        }, 500L);
    }

    public void ig(final boolean z) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.forum.detail.ForumDetailActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(ForumDetailActivity.this.mForumId)) {
                    d.aSV().i(TbadkApplication.getCurrentAccount(), String.valueOf(ForumDetailActivity.this.mForumId), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.eFK.setSwitch(z);
    }

    public void ih(boolean z) {
        this.eFK.a(this.eFM, z);
    }

    public void ii(boolean z) {
        this.eFK.b(this.eFM, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003 && this.eFP != null && this.eFP.forum_pkg_status == 1 && !TextUtils.isEmpty(this.eFP.url) && this.eFM != null) {
            sendMessage(new CustomMessage(2002001, new CommonEmotionManagerActivityConfig(getPageContext().getPageActivity(), this.eFP.url + "?forum_id=" + this.eFM.forum_id)));
        }
    }
}
