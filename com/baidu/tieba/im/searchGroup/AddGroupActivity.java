package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.e;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.SearchGroupModel;
import java.util.List;
/* loaded from: classes3.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    private a eQa = null;
    private SearchGroupModel eQb = null;
    private c eQc = new c(103007) { // from class: com.baidu.tieba.im.searchGroup.AddGroupActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            AddGroupActivity.this.eQa.iq(false);
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103007) {
                AddGroupActivity.this.aSL();
            } else if (!(socketResponsedMessage instanceof ResponseSearchGroupMessage)) {
                AddGroupActivity.this.aSL();
            } else {
                ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                if (responseSearchGroupMessage.getError() != 0) {
                    AddGroupActivity.this.aj(responseSearchGroupMessage.getErrorString(), responseSearchGroupMessage.getError());
                    return;
                }
                List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
                if (searchResult == null || searchResult.size() <= 0) {
                    AddGroupActivity.this.aSL();
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
        this.eQa = new a(this);
        this.eQb = new SearchGroupModel(this);
        registerListener(this.eQc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQa.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eQa.aSN()) {
            finish();
        } else if (view == this.eQa.aSM()) {
            TiebaStatic.log("add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                pS((String) view.getTag());
            }
        } else if (view == this.eQa.aOl()) {
            this.eQa.aSP();
        } else if (view == this.eQa.aSO()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902030, new IntentConfig(getPageContext().getPageActivity())));
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
        if (this.eQb != null) {
            this.eQb.cancelLoadData();
        }
    }

    public void pS(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.eQa.iq(true);
                this.eQb.sendMessage(b.d(str, 0L));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.eQa.iq(false);
                showToast(e.j.groupid_error);
                return;
            }
        }
        showToast(e.j.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSL() {
        showToast(e.j.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, int i) {
        if (i < 0) {
            showToast(e.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        } else {
            showToast(getResources().getString(e.j.neterror));
        }
    }
}
