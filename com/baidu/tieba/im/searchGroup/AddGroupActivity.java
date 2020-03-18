package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.SearchGroupModel;
import java.util.List;
/* loaded from: classes13.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    private a hKw = null;
    private SearchGroupModel hKx = null;
    private c hKy = new c(CmdConfigSocket.CMD_REQUEST_SEARCH_GROUP) { // from class: com.baidu.tieba.im.searchGroup.AddGroupActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            AddGroupActivity.this.hKw.showProgressBar(false);
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103007) {
                AddGroupActivity.this.bYk();
            } else if (!(socketResponsedMessage instanceof ResponseSearchGroupMessage)) {
                AddGroupActivity.this.bYk();
            } else {
                ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                if (responseSearchGroupMessage.getError() != 0) {
                    AddGroupActivity.this.aI(responseSearchGroupMessage.getErrorString(), responseSearchGroupMessage.getError());
                    return;
                }
                List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
                if (searchResult == null || searchResult.size() <= 0) {
                    AddGroupActivity.this.bYk();
                } else {
                    AddGroupActivity.this.a(searchResult.get(0));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hKw = new a(this);
        this.hKx = new SearchGroupModel(this);
        registerListener(this.hKy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hKw.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hKw.bYm()) {
            finish();
        } else if (view == this.hKw.bYl()) {
            TiebaStatic.log("add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                Du((String) view.getTag());
            }
        } else if (view == this.hKw.bTQ()) {
            this.hKw.bYo();
        } else if (view == this.hKw.bYn()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ZXING_CAPTURE, new IntentConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        if (this.hKx != null) {
            this.hKx.cancelLoadData();
        }
    }

    public void Du(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.hKw.showProgressBar(true);
                this.hKx.sendMessage(b.toLong(str, 0L));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.hKw.showProgressBar(false);
                showToast(R.string.groupid_error);
                return;
            }
        }
        showToast(R.string.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYk() {
        showToast(R.string.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getPageContext().getContext(), baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, int i) {
        if (i < 0) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        } else {
            showToast(getResources().getString(R.string.neterror));
        }
    }
}
