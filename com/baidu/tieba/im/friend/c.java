package com.baidu.tieba.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c extends BaseAdapter {
    private IMBlackListActivity a;
    private com.baidu.tieba.util.i b;
    private ArrayList<com.baidu.tieba.im.data.a> c;
    private View.OnClickListener d = new d(this);

    public c(IMBlackListActivity iMBlackListActivity) {
        this.b = null;
        this.a = iMBlackListActivity;
        this.b = new com.baidu.tieba.util.i(this.a);
    }

    public final void a(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.c = arrayList;
    }

    public final void a(com.baidu.tieba.im.data.a aVar) {
        if (this.c != null) {
            this.c.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.c != null) {
            return this.c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        com.baidu.tieba.im.data.a aVar = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar != null) {
            Object tag = view != null ? view.getTag() : null;
            if (tag == null) {
                e eVar2 = new e(this, (byte) 0);
                eVar2.a = LayoutInflater.from(this.a).inflate(R.layout.im_black_list_item, (ViewGroup) null);
                eVar2.b = (HeadImageView) eVar2.a.findViewById(R.id.header_view);
                eVar2.b.setIsRound(true);
                eVar2.c = (TextView) eVar2.a.findViewById(R.id.user_name);
                eVar2.d = (Button) eVar2.a.findViewById(R.id.remove_button);
                eVar2.a.setTag(eVar2);
                eVar2.d.setOnClickListener(this.d);
                eVar = eVar2;
            } else {
                eVar = (e) tag;
            }
            String c = aVar.c();
            if (c != null) {
                com.baidu.tieba.util.i iVar = this.b;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(c);
                if (b != null) {
                    b.a(eVar.b);
                } else {
                    eVar.b.setTag(c);
                    eVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                }
            }
            eVar.c.setText(aVar.b());
            eVar.d.setTag(aVar);
            this.a.getLayoutMode().a(eVar.a);
        } else {
            eVar = null;
        }
        if (eVar != null) {
            return eVar.a;
        }
        return null;
    }

    public final com.baidu.tieba.util.i a() {
        if (this.b == null) {
            this.b = new com.baidu.tieba.util.i(this.a);
        }
        return this.b;
    }
}
