package com.baidu.tieba.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SelectFriendActivity selectFriendActivity) {
        this.a = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.coreExtra.relationship.b item = this.a.c.getItem(i);
        if (item != null) {
            long c = item.c();
            String b = item.b();
            String d = item.d();
            Intent intent = new Intent();
            intent.putExtra("key_user_id", c);
            intent.putExtra("key_user_name", b);
            intent.putExtra("key_user_portait", d);
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
