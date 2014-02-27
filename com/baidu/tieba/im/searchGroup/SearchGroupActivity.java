package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.im.model.an;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SearchGroupActivity extends com.baidu.tieba.f implements View.OnClickListener {
    protected an a;
    private g b;
    private com.baidu.tieba.im.messageCenter.g c = new d(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new g(this);
        this.a = new an();
        com.baidu.tieba.im.messageCenter.d.a().a(103007, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.b == null || this.b.a() == null || this.b.a().a() == null) {
            return;
        }
        this.b.a().a().c();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.home_bt_search_s && (view.getTag() instanceof String)) {
            a((String) view.getTag());
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.b.e();
                this.b.a((ct) null);
                an anVar = this.a;
                an.a(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.b.c();
                showToast(R.string.groupid_error);
                return;
            }
        }
        showToast(R.string.please_input_groupid);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BaseGroupData item;
        if (this.b != null && this.b.a() != null && this.b.a().a(i) && (item = this.b.a().getItem(i)) != null) {
            cb.a(this, "search_group_item", "click", 1, new Object[0]);
            GroupInfoActivity.a(this, item.getGroupId(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.b != null && this.b.a() != null) {
            ap.a(this.b.a, this.b.a().a(), 0, -1);
        }
    }
}
