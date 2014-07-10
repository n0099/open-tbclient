package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    private final Context a;
    private com.baidu.tbadk.editortool.aa b;
    private List<com.baidu.tbadk.coreExtra.relationship.b> c;
    private com.baidu.tbadk.core.view.o d;
    private w e = null;
    private ViewGroup f = null;
    private final View.OnClickListener g = new s(this);

    public r(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.baidu.tbadk.editortool.aa(context);
    }

    public void a(w wVar) {
        this.e = wVar;
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.c = list;
    }

    public void a(com.baidu.tbadk.core.view.o oVar) {
        this.d = oVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public com.baidu.tbadk.editortool.aa a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) getItem(i);
        if (bVar != null) {
            vVar = a(view != null ? view.getTag() : null, bVar);
        } else {
            vVar = null;
        }
        if (vVar != null) {
            return vVar.a;
        }
        return null;
    }

    private v a(Object obj, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        v vVar;
        if (obj == null) {
            vVar = b();
        } else {
            vVar = (v) obj;
        }
        if (this.e != null) {
            this.e.a(vVar.a, bVar);
        }
        a(bVar, vVar, bVar.d());
        vVar.c.setText(bVar.b());
        vVar.d.setTagData(bVar);
        if (this.a instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.a).getLayoutMode().a(vVar.a);
        }
        return vVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.b bVar, v vVar, String str) {
        if (bVar != null) {
            vVar.b.setImageBitmap(null);
            vVar.b.setTag(str);
            this.b.c(str, new t(this));
        }
    }

    private v b() {
        v vVar = new v(this, null);
        vVar.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.invite_friend_list_item, (ViewGroup) null);
        vVar.b = (HeadImageView) vVar.a.findViewById(com.baidu.tieba.v.photo);
        vVar.b.setIsRound(false);
        vVar.c = (TextView) vVar.a.findViewById(com.baidu.tieba.v.txt_user_name);
        vVar.d = (TbCheckBox) vVar.a.findViewById(com.baidu.tieba.v.ckb_select);
        vVar.a.setOnClickListener(this.g);
        if (this.d != null) {
            vVar.d.setStatedChangedListener(this.d);
        }
        vVar.a.setTag(vVar);
        return vVar;
    }
}
