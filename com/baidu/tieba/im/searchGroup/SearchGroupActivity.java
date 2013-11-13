package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.w;
import com.baidu.tieba.j;
import com.baidu.tieba.util.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SearchGroupActivity extends j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected w f1784a;
    private d b;
    private com.baidu.tieba.im.messageCenter.h c = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new d(this);
        this.f1784a = new w();
        com.baidu.tieba.im.messageCenter.f.a().a(103007, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.f.a().a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, SearchGroupActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        b();
    }

    private void b() {
        if (this.b != null && this.b.a() != null && this.b.a().a() != null) {
            this.b.a().a().b();
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_bt_search_s /* 2131100316 */:
                if (view.getTag() instanceof String) {
                    a((String) view.getTag());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            try {
                this.b.d();
                this.b.a((ResponseSearchGroupMessage) null);
                this.f1784a.a(Long.parseLong(str));
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                this.b.b();
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
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "search_group_item", "click", 1);
            }
            GroupInfoActivity.a(this, item.getGroupId(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.b != null && this.b.a() != null) {
            ak.a(this.b.f1788a, this.b.a().a(), 0, -1);
        }
    }
}
