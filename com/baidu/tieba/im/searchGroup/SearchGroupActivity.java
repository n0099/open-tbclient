package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.q;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.bw;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class SearchGroupActivity extends BaseActivity implements View.OnClickListener {
    protected bw a;
    private g b;
    private com.baidu.adp.framework.listener.b c = new d(this, MessageTypes.CMD_REQUEST_SEARCH_GROUP);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new g(this);
        this.a = new bw();
        registerListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        b();
    }

    private void b() {
        if (this.b != null && this.b.a() != null && this.b.a().a() != null) {
            this.b.a().a().d();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v.home_bt_search_s && (view.getTag() instanceof String)) {
            a((String) view.getTag());
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.b.d();
                this.b.a((ResponseSearchGroupMessage) null);
                this.a.a(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.b.b();
                showToast(y.groupid_error);
                return;
            }
        }
        showToast(y.please_input_groupid);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BaseGroupData item;
        if (this.b != null && this.b.a() != null && this.b.a().a(i) && (item = this.b.a().getItem(i)) != null) {
            TiebaStatic.eventStat(this, "search_group_item", "click", 1, new Object[0]);
            sendMessage(new CustomMessage(2010011, new q(this, item.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.b != null && this.b.a() != null) {
            ag.a(this.b.a, this.b.a().a(), 0, -1);
        }
    }
}
