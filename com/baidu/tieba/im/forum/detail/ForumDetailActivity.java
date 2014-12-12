package com.baidu.tieba.im.forum.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements com.baidu.adp.widget.BdSwitchView.c, j {
    public boolean aJi = false;
    private k aZa;
    private f aZb;
    private RecommendForumInfo aZc;
    private List<SimpleThreadInfo> aZd;
    private String mForumId;

    static {
        TbadkApplication.getInst().RegisterIntent(ForumDetailActivityConfig.class, ForumDetailActivity.class);
        com.baidu.tieba.tbadkCore.a.a.c(303021, ForumDetailSocketResponse.class, false);
        NZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(x.forum_detail_activity);
        this.aZa = new k(this);
        this.aZa.HN().a(new d(this));
        this.aZa.o(new e(this));
        this.aZb = new f(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        NW();
        NY();
    }

    private void NW() {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.aZa.showLoading();
            this.aZb.gG(this.mForumId);
            return;
        }
        this.aZa.Od();
        this.aZa.fb(z.game_index_no_network_text);
        showToast(z.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aZa.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aZa.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.j
    public void gF(String str) {
        this.aZa.Od();
        if (TextUtils.isEmpty(str)) {
            showToast(z.neterror);
        } else {
            showToast(str);
        }
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.aZa.fb(z.no_data_text);
        } else {
            this.aZa.fb(z.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.j
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.aZc = forumDetailSocketResponse.getForumInfo();
        this.aZd = forumDetailSocketResponse.getThreadInfoList();
        NX();
    }

    @Override // com.baidu.tieba.im.forum.detail.j
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.aZc = forumDetailHttpResponse.getForumInfo();
        this.aZd = forumDetailHttpResponse.getThreadInfoList();
        NX();
    }

    private void NX() {
        this.aZa.Od();
        this.aZa.HE();
        if (this.aZc != null || (this.aZd != null && this.aZd.size() > 0)) {
            this.aJi = true;
            this.aZd = as(this.aZd);
            this.aZa.c(this.aZc);
            this.aZa.E(this.aZd);
            return;
        }
        this.aJi = false;
        this.aZa.fb(z.no_data_text);
    }

    private List<SimpleThreadInfo> as(List<SimpleThreadInfo> list) {
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
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(String.valueOf(this.mForumId), 4, null, 1)));
            sendMessage(new CustomMessage(2001155, String.valueOf(this.mForumId)));
        }
    }

    private void NY() {
        String stringExtra = getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE);
        if (!StringUtils.isNull(stringExtra)) {
            String str = "";
            if (stringExtra.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (stringExtra.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || stringExtra.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (stringExtra.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else if (stringExtra.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
                str = "aio_side_2_sub";
            }
            if (!StringUtils.isNull(str)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
            }
        }
    }

    private static void NZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, com.baidu.tieba.tbadkCore.a.a.O(TbConfig.GET_FORUM_DETAIL, 303021));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ForumDetailHttpResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.w.bar_info_clean_lay) {
            this.aZa.Of();
        } else if (id == com.baidu.tieba.w.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.toInt(this.mForumId, 0))));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.aZb.j(false, this.mForumId);
        } else {
            this.aZb.j(true, this.mForumId);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.j
    public void cH(boolean z) {
        if (z) {
            showToast(z.subscribe_success);
            cJ(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new a(this), 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.j
    public void cI(boolean z) {
        if (z) {
            showToast(z.unsubscribe_success);
            cJ(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new b(this), 500L);
    }

    public void cJ(boolean z) {
        new c(this, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.aZa.setSwitch(z);
    }

    public void cK(boolean z) {
        this.aZa.a(this.aZc, z);
    }
}
