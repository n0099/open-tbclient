package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BaseAdapter {
    private final Context a;
    private com.baidu.tbadk.editortool.ab b;
    private ArrayList<com.baidu.tieba.im.data.e> c;
    private com.baidu.tbadk.core.view.o d;
    private x e = null;
    private ViewGroup f = null;
    private final View.OnClickListener g = new t(this);

    public s(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.baidu.tbadk.editortool.ab(context);
    }

    public void a(x xVar) {
        this.e = xVar;
    }

    public void a(ArrayList<com.baidu.tieba.im.data.e> arrayList) {
        this.c = arrayList;
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

    public com.baidu.tbadk.editortool.ab a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        w wVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        com.baidu.tieba.im.data.e eVar = (com.baidu.tieba.im.data.e) getItem(i);
        if (eVar != null) {
            wVar = a(view != null ? view.getTag() : null, eVar);
        } else {
            wVar = null;
        }
        if (wVar != null) {
            return wVar.a;
        }
        return null;
    }

    private w a(Object obj, com.baidu.tieba.im.data.e eVar) {
        w wVar;
        if (obj == null) {
            wVar = b();
        } else {
            wVar = (w) obj;
        }
        if (this.e != null) {
            this.e.a(wVar.a, eVar);
        }
        a(eVar, wVar, eVar.c());
        wVar.c.setText(eVar.b());
        wVar.d.setTagData(eVar);
        if (this.a instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.a).getLayoutMode().a(wVar.a);
        }
        return wVar;
    }

    private void a(com.baidu.tieba.im.data.e eVar, w wVar, String str) {
        if (eVar != null) {
            wVar.b.setImageBitmap(null);
            wVar.b.setTag(str);
            this.b.c(str, new u(this));
        }
    }

    private w b() {
        w wVar = new w(this, null);
        wVar.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.invite_friend_list_item, (ViewGroup) null);
        wVar.b = (HeadImageView) wVar.a.findViewById(com.baidu.tieba.r.photo);
        wVar.b.setIsRound(true);
        wVar.c = (TextView) wVar.a.findViewById(com.baidu.tieba.r.txt_user_name);
        wVar.d = (TbCheckBox) wVar.a.findViewById(com.baidu.tieba.r.ckb_select);
        wVar.a.setOnClickListener(this.g);
        if (this.d != null) {
            wVar.d.setStatedChangedListener(this.d);
        }
        wVar.a.setTag(wVar);
        return wVar;
    }
}
