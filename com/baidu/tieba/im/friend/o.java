package com.baidu.tieba.im.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.bu;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.util.i b;
    private ArrayList<com.baidu.tieba.im.data.c> c;
    private bu d;
    private s e = null;
    private ViewGroup f = null;
    private View.OnClickListener g = new q(this);

    public o(Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.baidu.tieba.util.i(context);
    }

    public void a(s sVar) {
        this.e = sVar;
    }

    public void a(ArrayList<com.baidu.tieba.im.data.c> arrayList) {
        this.c = arrayList;
    }

    public void a(bu buVar) {
        this.d = buVar;
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
        r rVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) getItem(i);
        if (cVar != null) {
            rVar = a(view != null ? view.getTag() : null, cVar);
        } else {
            rVar = null;
        }
        if (rVar != null) {
            return rVar.a;
        }
        return null;
    }

    private r a(Object obj, com.baidu.tieba.im.data.c cVar) {
        r rVar;
        if (obj == null) {
            rVar = b();
        } else {
            rVar = (r) obj;
        }
        if (this.e != null) {
            this.e.a(rVar.a, cVar);
        }
        a(cVar, rVar, cVar.c());
        rVar.c.setText(cVar.b());
        rVar.d.setTagData(cVar);
        if (this.a instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.a).getLayoutMode().a(rVar.a);
        }
        return rVar;
    }

    private void a(com.baidu.tieba.im.data.c cVar, r rVar, String str) {
        if (cVar != null) {
            rVar.b.setTag(str);
            com.baidu.adp.widget.ImageView.d c = this.b.c(cVar.c());
            if (c != null) {
                rVar.b.setImageBitmap(c.h());
                rVar.b.invalidate();
                return;
            }
            this.b.b(str, new p(this, str, rVar));
        }
    }

    private r b() {
        r rVar = new r(this, null);
        rVar.a = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        rVar.b = (HeadImageView) rVar.a.findViewById(R.id.photo);
        rVar.b.setIsRound(true);
        rVar.c = (TextView) rVar.a.findViewById(R.id.txt_user_name);
        rVar.d = (TbCheckBox) rVar.a.findViewById(R.id.ckb_select);
        rVar.a.setOnClickListener(this.g);
        if (this.d != null) {
            rVar.d.setStatedChangedListener(this.d);
        }
        rVar.a.setTag(rVar);
        return rVar;
    }
}
