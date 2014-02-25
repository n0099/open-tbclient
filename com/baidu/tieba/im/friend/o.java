package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cr;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private final Context a;
    private com.baidu.tieba.util.i b;
    private ArrayList<com.baidu.tieba.im.data.d> c;
    private cr d;
    private t e = null;
    private ViewGroup f = null;
    private final View.OnClickListener g = new p(this);

    public o(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.baidu.tieba.util.i(context);
    }

    public void a(t tVar) {
        this.e = tVar;
    }

    public void a(ArrayList<com.baidu.tieba.im.data.d> arrayList) {
        this.c = arrayList;
    }

    public void a(cr crVar) {
        this.d = crVar;
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

    public com.baidu.tieba.util.i a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        s sVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        com.baidu.tieba.im.data.d dVar = (com.baidu.tieba.im.data.d) getItem(i);
        if (dVar != null) {
            sVar = a(view != null ? view.getTag() : null, dVar);
        } else {
            sVar = null;
        }
        if (sVar != null) {
            return sVar.a;
        }
        return null;
    }

    private s a(Object obj, com.baidu.tieba.im.data.d dVar) {
        s sVar;
        if (obj == null) {
            sVar = b();
        } else {
            sVar = (s) obj;
        }
        if (this.e != null) {
            this.e.a(sVar.a, dVar);
        }
        a(dVar, sVar, dVar.c());
        sVar.c.setText(dVar.b());
        sVar.d.setTagData(dVar);
        if (this.a instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.a).getLayoutMode().a(sVar.a);
        }
        return sVar;
    }

    private void a(com.baidu.tieba.im.data.d dVar, s sVar, String str) {
        if (dVar != null) {
            sVar.b.setImageBitmap(null);
            sVar.b.setTag(str);
            this.b.c(str, new q(this));
        }
    }

    private s b() {
        s sVar = new s(this, null);
        sVar.a = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        sVar.b = (HeadImageView) sVar.a.findViewById(R.id.photo);
        sVar.b.setIsRound(true);
        sVar.c = (TextView) sVar.a.findViewById(R.id.txt_user_name);
        sVar.d = (TbCheckBox) sVar.a.findViewById(R.id.ckb_select);
        sVar.a.setOnClickListener(this.g);
        if (this.d != null) {
            sVar.d.setStatedChangedListener(this.d);
        }
        sVar.a.setTag(sVar);
        return sVar;
    }
}
