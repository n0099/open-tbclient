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
    public boolean aQr = false;
    private RecommendForumInfo bcA;
    private List<SimpleThreadInfo> bcB;
    private String bcC;
    private m bcy;
    private h bcz;
    private String mForumId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.forum_detail_activity);
        this.bcy = new m(this);
        this.bcy.LU().a(new f(this));
        this.bcy.c(new g(this));
        this.bcz = new h(this);
        this.mForumId = getIntent().getStringExtra("forum_id");
        Qb();
        Qd();
    }

    private void Qb() {
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.bcy.showLoading();
            this.bcz.gz(this.mForumId);
            return;
        }
        this.bcy.Qj();
        this.bcy.fg(com.baidu.tieba.y.game_index_no_network_text);
        showToast(com.baidu.tieba.y.neterror);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bcy.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bcy.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void gy(String str) {
        this.bcy.Qj();
        if (TextUtils.isEmpty(str)) {
            showToast(com.baidu.tieba.y.neterror);
        } else {
            showToast(str);
        }
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            this.bcy.fg(com.baidu.tieba.y.no_data_text);
        } else {
            this.bcy.fg(com.baidu.tieba.y.game_index_no_network_text);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void a(ForumDetailSocketResponse forumDetailSocketResponse) {
        this.bcA = forumDetailSocketResponse.getForumInfo();
        this.bcB = forumDetailSocketResponse.getThreadInfoList();
        Qc();
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void a(ForumDetailHttpResponse forumDetailHttpResponse) {
        this.bcA = forumDetailHttpResponse.getForumInfo();
        this.bcB = forumDetailHttpResponse.getThreadInfoList();
        Qc();
    }

    private void Qc() {
        this.bcy.Qj();
        this.bcy.hideNoDataView();
        if (this.bcA != null || (this.bcB != null && this.bcB.size() > 0)) {
            this.aQr = true;
            this.bcB = aB(this.bcB);
            this.bcy.c(this.bcA);
            this.bcy.R(this.bcB);
            return;
        }
        this.aQr = false;
        this.bcy.fg(com.baidu.tieba.y.no_data_text);
    }

    private List<SimpleThreadInfo> aB(List<SimpleThreadInfo> list) {
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

    private void Qd() {
        this.bcC = getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE);
        if (!StringUtils.isNull(this.bcC)) {
            String str = "";
            if (this.bcC.equals(ForumDetailActivityConfig.FromType.FRS.toString())) {
                str = "frs_2_sub";
            } else if (this.bcC.equals(ForumDetailActivityConfig.FromType.BAR_DIR.toString()) || this.bcC.equals(ForumDetailActivityConfig.FromType.BAR_RANK.toString())) {
                str = "sq_2_sub";
            } else if (this.bcC.equals(ForumDetailActivityConfig.FromType.FRS_SIDE.toString())) {
                str = "side_2_sub";
            } else if (this.bcC.equals(ForumDetailActivityConfig.FromType.BAR.toString())) {
                str = "aio_side_2_sub";
            }
            if (!StringUtils.isNull(str)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), str, "click", 1, new Object[0]);
            }
        }
    }

    public String Qe() {
        return this.bcC;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == com.baidu.tieba.v.bar_info_clean_lay) {
            this.bcy.Ql();
        } else if (id == com.baidu.tieba.v.bar_info_history_lay) {
            sendMessage(new CustomMessage(2002001, new OfficialBarHistoryActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.toInt(this.mForumId, 0))));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.b
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.OFF) {
            this.bcz.h(false, this.mForumId);
        } else if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vs() || !com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.bx(com.baidu.tieba.y.error_open_personal_single_alloff);
            aVar.c(getResources().getString(com.baidu.tieba.y.signallforum_signnow), new a(this, aVar));
            aVar.b(getPageContext());
            aVar.re();
            this.mHandler.postDelayed(new b(this), 500L);
        } else {
            this.bcz.h(true, this.mForumId);
        }
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void cA(boolean z) {
        if (z) {
            showToast(com.baidu.tieba.y.success_string);
            cC(true);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_add ", "like_add", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new c(this), 500L);
    }

    @Override // com.baidu.tieba.im.forum.detail.l
    public void cB(boolean z) {
        if (z) {
            showToast(com.baidu.tieba.y.success_string);
            cC(false);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "like_cancel ", "like_canel", 1, new Object[0]);
            return;
        }
        this.mHandler.postDelayed(new d(this), 500L);
    }

    public void cC(boolean z) {
        new e(this, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void setSwitch(boolean z) {
        this.bcy.setSwitch(z);
    }

    public void cD(boolean z) {
        this.bcy.a(this.bcA, z);
    }
}
