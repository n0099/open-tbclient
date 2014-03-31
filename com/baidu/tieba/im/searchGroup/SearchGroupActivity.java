package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.b.o;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.bp;
/* loaded from: classes.dex */
public class SearchGroupActivity extends com.baidu.tbadk.a implements View.OnClickListener {
    protected bp a;
    private g b;
    private com.baidu.adp.framework.c.g c = new d(this, 103007);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new g(this);
        this.a = new bp();
        registerListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.b == null || this.b.a() == null || this.b.a().a() == null) {
            return;
        }
        this.b.a().a().c();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.im.h.home_bt_search_s && (view.getTag() instanceof String)) {
            a((String) view.getTag());
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.b.e();
                this.b.a((ResponseSearchGroupMessage) null);
                this.a.a(Integer.parseInt(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.b.c();
                showToast(com.baidu.tieba.im.j.groupid_error);
                return;
            }
        }
        showToast(com.baidu.tieba.im.j.please_input_groupid);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BaseGroupData item;
        if (this.b != null && this.b.a() != null && this.b.a().a(i) && (item = this.b.a().getItem(i)) != null) {
            TiebaStatic.a(this, "search_group_item", "click", 1, new Object[0]);
            sendMessage(new com.baidu.adp.framework.message.a(2008011, new o(this, item.getGroupId(), 0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.b != null && this.b.a() != null) {
            ac.a(this.b.a, this.b.a().a(), 0, -1);
        }
    }
}
