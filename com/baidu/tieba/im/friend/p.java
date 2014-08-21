package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private final Context a;
    private List<com.baidu.tbadk.coreExtra.relationship.b> b;
    private com.baidu.tbadk.core.view.t c;
    private r d = null;
    private ViewGroup e = null;
    private boolean f;

    public p(Context context, boolean z) {
        this.a = context;
        this.f = z;
    }

    public void a(r rVar) {
        this.d = rVar;
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.b = list;
    }

    public void a(com.baidu.tbadk.core.view.t tVar) {
        this.c = tVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        if (this.e == null) {
            this.e = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) getItem(i);
        if (bVar != null) {
            qVar = a(view != null ? view.getTag() : null, bVar);
        } else {
            qVar = null;
        }
        if (qVar != null) {
            return qVar.a;
        }
        return null;
    }

    private q a(Object obj, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        q qVar;
        if (obj == null) {
            qVar = a();
        } else {
            qVar = (q) obj;
        }
        if (this.d != null) {
            this.d.a(qVar.a, bVar);
        }
        a(bVar, qVar, bVar.d());
        qVar.c.setText(bVar.b());
        if (this.f) {
            qVar.d.setVisibility(8);
        } else {
            qVar.d.setTagData(bVar);
        }
        if (this.a instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.a).getLayoutMode().a(qVar.a);
        }
        return qVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.b bVar, q qVar, String str) {
        if (bVar != null) {
            qVar.b.setTag(str);
            qVar.b.a(str, 12, false);
        }
    }

    private q a() {
        q qVar = new q(this);
        qVar.a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.invite_friend_list_item, null);
        qVar.b = (HeadImageView) qVar.a.findViewById(com.baidu.tieba.u.photo);
        qVar.b.setIsRound(false);
        qVar.c = (TextView) qVar.a.findViewById(com.baidu.tieba.u.txt_user_name);
        qVar.d = (TbCheckBox) qVar.a.findViewById(com.baidu.tieba.u.ckb_select);
        if (this.c != null) {
            qVar.d.setStatedChangedListener(this.c);
        }
        qVar.a.setTag(qVar);
        return qVar;
    }
}
