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
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements com.baidu.adp.widget.BdSwitchView.c, l {
    public boolean aKs = false;
    private List<SimpleThreadInfo> baA;
    private m bax;
    private h bay;
    private RecommendForumInfo baz;
    private String mForumId;

    static {
        TbadkApplication.getInst().RegisterIntent(ForumDetailActivityConfig.class, ForumDetailActivity.class);
        com.baidu.tieba.tbadkCore.a.a.c(303021, ForumDetailSocketResponse.class, false);
        Ov();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.forum_detail_activity);
        this.bax = new m(this);
        this.bax.Ik().a(new f(this));
        this.bax.p(new g(this));
        this.bay = new h(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        Os();
        Ou();
    }

    private void Os() {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.bax.showLoading();
            this.bay.gL(this.mForumId);
            return;
        }
        this.bax.Oz();
        this.bax.fg(z.game_index_no_network_text);
        showToast(z.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bax.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bax.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void gK(String str) {
        this.bax.Oz();
        if (TextUtils.isEmpty(str)) {
            showToast(z.neterror);
        } else {
            showToast(str);
        }
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            this.bax.fg(z.no_data_text);
        } else {
            this.bax.fg(z.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.baz = forumDetailSocketResponse.getForumInfo();
        this.baA = forumDetailSocketResponse.getThreadInfoList();
        Ot();
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.baz = forumDetailHttpResponse.getForumInfo();
        this.baA = forumDetailHttpResponse.getThreadInfoList();
        Ot();
    }

    private void Ot() {
        this.bax.Oz();
        this.bax.Ic();
        if (this.baz != null || (this.baA != null && this.baA.size() > 0)) {
            this.aKs = true;
            this.baA = au(this.baA);
            this.bax.c(this.baz);
            this.bax.G(this.baA);
            return;
        }
        this.aKs = false;
        this.bax.fg(z.no_data_text);
    }

    private List<SimpleThreadInfo> au(List<SimpleThreadInfo> list) {
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

    private void Ou() {
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

    private static void Ov() {
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
            this.bax.OB();
        } else if (id == com.baidu.tieba.w.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.toInt(this.mForumId, 0))));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.bay.j(false, this.mForumId);
        } else if (!TbadkApplication.getInst().isMsgRemindOn() || !TbadkApplication.getInst().isMsgChatOn()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.by(z.error_open_personal_single_alloff);
            aVar.c(getResources().getString(z.signallforum_signnow), new a(this, aVar));
            aVar.b(getPageContext());
            aVar.nX();
            this.mHandler.postDelayed(new b(this), 500L);
        } else {
            this.bay.j(true, this.mForumId);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void cM(boolean z) {
        if (z) {
            showToast(z.subscribe_success);
            cO(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new c(this), 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void cN(boolean z) {
        if (z) {
            showToast(z.unsubscribe_success);
            cO(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new d(this), 500L);
    }

    public void cO(boolean z) {
        new e(this, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.bax.setSwitch(z);
    }

    public void cP(boolean z) {
        this.bax.a(this.baz, z);
    }
}
