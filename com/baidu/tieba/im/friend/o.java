package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class o extends BaseAdapter {
    private final Context a;
    private com.baidu.tieba.util.i b;
    private ArrayList<com.baidu.tieba.im.data.d> c;
    private cq d;
    private t e = null;
    private ViewGroup f = null;
    private final View.OnClickListener g = new p(this);

    public o(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.baidu.tieba.util.i(context);
    }

    public final void a(t tVar) {
        this.e = tVar;
    }

    public final void a(ArrayList<com.baidu.tieba.im.data.d> arrayList) {
        this.c = arrayList;
    }

    public final void a(cq cqVar) {
        this.d = cqVar;
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

    public final com.baidu.tieba.util.i a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        s sVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        com.baidu.tieba.im.data.d dVar = (com.baidu.tieba.im.data.d) getItem(i);
        if (dVar != null) {
            Object tag = view != null ? view.getTag() : null;
            if (tag == null) {
                s sVar2 = new s(this, (byte) 0);
                sVar2.a = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
                sVar2.b = (HeadImageView) sVar2.a.findViewById(R.id.photo);
                sVar2.b.setIsRound(true);
                sVar2.c = (TextView) sVar2.a.findViewById(R.id.txt_user_name);
                sVar2.d = (TbCheckBox) sVar2.a.findViewById(R.id.ckb_select);
                sVar2.a.setOnClickListener(this.g);
                if (this.d != null) {
                    sVar2.d.setStatedChangedListener(this.d);
                }
                sVar2.a.setTag(sVar2);
                sVar = sVar2;
            } else {
                sVar = (s) tag;
            }
            if (this.e != null) {
                t tVar = this.e;
                View view2 = sVar.a;
                tVar.a(dVar);
            }
            String c = dVar.c();
            if (dVar != null) {
                sVar.b.setImageBitmap(null);
                sVar.b.setTag(c);
                this.b.c(c, new q(this));
            }
            sVar.c.setText(dVar.b());
            sVar.d.setTagData(dVar);
            if (this.a instanceof InviteFriendListActivity) {
                ((InviteFriendListActivity) this.a).getLayoutMode().a(sVar.a);
            }
        } else {
            sVar = null;
        }
        if (sVar != null) {
            return sVar.a;
        }
        return null;
    }
}
