package com.baidu.tieba.im.forum.detail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ForumDetailActivity extends BaseActivity<ForumDetailActivity> implements com.baidu.adp.widget.BdSwitchView.b, l {
    public boolean aQI = false;
    private m bcO;
    private h bcP;
    private RecommendForumInfo bcQ;
    private List<SimpleThreadInfo> bcR;
    private String bcS;
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.forum_detail_activity);
        this.bcO = new m(this);
        this.bcO.Mh().a(new f(this));
        this.bcO.c(new g(this));
        this.bcP = new h(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        Qo();
        Qq();
    }

    private void Qo() {
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.bcO.showLoading();
            this.bcP.gC(this.mForumId);
            return;
        }
        this.bcO.Qw();
        this.bcO.fh(com.baidu.tieba.y.game_index_no_network_text);
        showToast(com.baidu.tieba.y.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bcO.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bcO.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void gB(String str) {
        this.bcO.Qw();
        if (TextUtils.isEmpty(str)) {
            showToast(com.baidu.tieba.y.neterror);
        } else {
            showToast(str);
        }
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.bcO.fh(com.baidu.tieba.y.no_data_text);
        } else {
            this.bcO.fh(com.baidu.tieba.y.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.bcQ = forumDetailSocketResponse.getForumInfo();
        this.bcR = forumDetailSocketResponse.getThreadInfoList();
        Qp();
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.bcQ = forumDetailHttpResponse.getForumInfo();
        this.bcR = forumDetailHttpResponse.getThreadInfoList();
        Qp();
    }

    private void Qp() {
        this.bcO.Qw();
        this.bcO.hideNoDataView();
        if (this.bcQ != null || (this.bcR != null && this.bcR.size() > 0)) {
            this.aQI = true;
            this.bcR = aD(this.bcR);
            this.bcO.c(this.bcQ);
            this.bcO.R(this.bcR);
            return;
        }
        this.aQI = false;
        this.bcO.fh(com.baidu.tieba.y.no_data_text);
    }

    private List<SimpleThreadInfo> aD(List<SimpleThreadInfo> list) {
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
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(this.mForumId), 4, null, 1)));
            sendMessage(new CustomMessage(2001155, String.valueOf(this.mForumId)));
        }
    }

    private void Qq() {
        this.bcS = getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE);
        if (!StringUtils.isNull(this.bcS)) {
            String str = "";
            if (this.bcS.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (this.bcS.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.bcS.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (this.bcS.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else if (this.bcS.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
                str = "aio_side_2_sub";
            }
            if (!StringUtils.isNull(str)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
            }
        }
    }

    public String Qr() {
        return this.bcS;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.bar_info_clean_lay) {
            this.bcO.Qy();
        } else if (id == com.baidu.tieba.v.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.toInt(this.mForumId, 0))));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.bcP.h(false, this.mForumId);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vy() || !com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.bx(com.baidu.tieba.y.error_open_personal_single_alloff);
            aVar.c(getResources().getString(com.baidu.tieba.y.signallforum_signnow), new a(this, aVar));
            aVar.b(getPageContext());
            aVar.re();
            this.mHandler.postDelayed(new b(this), 500L);
        } else {
            this.bcP.h(true, this.mForumId);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void cy(boolean z) {
        if (z) {
            showToast(com.baidu.tieba.y.success_string);
            cA(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new c(this), 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void cz(boolean z) {
        if (z) {
            showToast(com.baidu.tieba.y.success_string);
            cA(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new d(this), 500L);
    }

    public void cA(boolean z) {
        new e(this, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.bcO.setSwitch(z);
    }

    public void cB(boolean z) {
        this.bcO.a(this.bcQ, z);
    }
}
