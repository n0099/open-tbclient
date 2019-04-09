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
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.SearchGroupModel;
import java.util.List;
/* loaded from: classes3.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    private a grG = null;
    private SearchGroupModel grH = null;
    private c grI = new c(103007) { // from class: com.baidu.tieba.im.searchGroup.AddGroupActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            AddGroupActivity.this.grG.lf(false);
            if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103007) {
                AddGroupActivity.this.bvP();
            } else if (!(socketResponsedMessage instanceof ResponseSearchGroupMessage)) {
                AddGroupActivity.this.bvP();
            } else {
                ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                if (responseSearchGroupMessage.getError() != 0) {
                    AddGroupActivity.this.aG(responseSearchGroupMessage.getErrorString(), responseSearchGroupMessage.getError());
                    return;
                }
                List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
                if (searchResult == null || searchResult.size() <= 0) {
                    AddGroupActivity.this.bvP();
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
        this.grG = new a(this);
        this.grH = new SearchGroupModel(this);
        registerListener(this.grI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.grG.changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.grG.bvR()) {
            finish();
        } else if (view == this.grG.bvQ()) {
            TiebaStatic.log("add_group_searchbtn_click");
            if (view.getTag() instanceof String) {
                xr((String) view.getTag());
            }
        } else if (view == this.grG.brp()) {
            this.grG.bvT();
        } else if (view == this.grG.bvS()) {
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
        if (this.grH != null) {
            this.grH.cancelLoadData();
        }
    }

    public void xr(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.grG.lf(true);
                this.grH.sendMessage(b.d(str, 0L));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.grG.lf(false);
                showToast(d.j.groupid_error);
                return;
            }
        }
        showToast(d.j.please_input_groupid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvP() {
        showToast(d.j.add_group_toast_noresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseGroupData baseGroupData) {
        if (baseGroupData != null) {
            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), baseGroupData.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(String str, int i) {
        if (i < 0) {
            showToast(d.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            showToast(str);
        } else {
            showToast(getResources().getString(d.j.neterror));
        }
    }
}
