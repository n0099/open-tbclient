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
public final class s extends BaseAdapter {
    private final Context a;
    private com.baidu.tbadk.editortool.ab b;
    private ArrayList<com.baidu.tieba.im.data.c> c;
    private com.baidu.tbadk.core.view.o d;
    private x e = null;
    private ViewGroup f = null;
    private final View.OnClickListener g = new t(this);

    public s(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.baidu.tbadk.editortool.ab(context);
    }

    public final void a(x xVar) {
        this.e = xVar;
    }

    public final void a(ArrayList<com.baidu.tieba.im.data.c> arrayList) {
        this.c = arrayList;
    }

    public final void a(com.baidu.tbadk.core.view.o oVar) {
        this.d = oVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.c == null) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    public final com.baidu.tbadk.editortool.ab a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        w wVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) getItem(i);
        if (cVar != null) {
            Object tag = view != null ? view.getTag() : null;
            if (tag == null) {
                w wVar2 = new w(this, (byte) 0);
                wVar2.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.invite_friend_list_item, (ViewGroup) null);
                wVar2.b = (HeadImageView) wVar2.a.findViewById(com.baidu.tieba.im.h.photo);
                wVar2.b.setIsRound(true);
                wVar2.c = (TextView) wVar2.a.findViewById(com.baidu.tieba.im.h.txt_user_name);
                wVar2.d = (TbCheckBox) wVar2.a.findViewById(com.baidu.tieba.im.h.ckb_select);
                wVar2.a.setOnClickListener(this.g);
                if (this.d != null) {
                    wVar2.d.setStatedChangedListener(this.d);
                }
                wVar2.a.setTag(wVar2);
                wVar = wVar2;
            } else {
                wVar = (w) tag;
            }
            if (this.e != null) {
                x xVar = this.e;
                View view2 = wVar.a;
                xVar.a(cVar);
            }
            String c = cVar.c();
            if (cVar != null) {
                wVar.b.setImageBitmap(null);
                wVar.b.setTag(c);
                this.b.c(c, new u(this));
            }
            wVar.c.setText(cVar.b());
            wVar.d.setTagData(cVar);
            if (this.a instanceof InviteFriendListActivity) {
                ((InviteFriendListActivity) this.a).getLayoutMode().a(wVar.a);
            }
        } else {
            wVar = null;
        }
        if (wVar != null) {
            return wVar.a;
        }
        return null;
    }
}
