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
public class c extends BaseAdapter {
    private IMBlackListActivity a;
    private com.baidu.tieba.util.i b;
    private ArrayList<com.baidu.tieba.im.data.a> c;
    private View.OnClickListener d = new d(this);

    public c(IMBlackListActivity iMBlackListActivity) {
        this.b = null;
        this.a = iMBlackListActivity;
        this.b = new com.baidu.tieba.util.i(this.a);
    }

    public void a(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.c = arrayList;
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        if (this.c != null) {
            this.c.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c != null) {
            return this.c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        com.baidu.tieba.im.data.a aVar = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar != null) {
            eVar = a(view != null ? view.getTag() : null, aVar);
        } else {
            eVar = null;
        }
        if (eVar != null) {
            return eVar.a;
        }
        return null;
    }

    public com.baidu.tieba.util.i a() {
        if (this.b == null) {
            this.b = new com.baidu.tieba.util.i(this.a);
        }
        return this.b;
    }

    private e b() {
        e eVar = new e(this, null);
        eVar.a = LayoutInflater.from(this.a).inflate(R.layout.im_black_list_item, (ViewGroup) null);
        eVar.b = (HeadImageView) eVar.a.findViewById(R.id.header_view);
        eVar.b.setIsRound(true);
        eVar.c = (TextView) eVar.a.findViewById(R.id.user_name);
        eVar.d = (Button) eVar.a.findViewById(R.id.remove_button);
        eVar.a.setTag(eVar);
        eVar.d.setOnClickListener(this.d);
        return eVar;
    }

    private e a(Object obj, com.baidu.tieba.im.data.a aVar) {
        e eVar;
        if (obj == null) {
            eVar = b();
        } else {
            eVar = (e) obj;
        }
        a(eVar, aVar.c());
        eVar.c.setText(aVar.b());
        eVar.d.setTag(aVar);
        this.a.getLayoutMode().a(eVar.a);
        return eVar;
    }

    private void a(e eVar, String str) {
        if (str != null) {
            com.baidu.adp.widget.ImageView.d c = this.b.c(str);
            if (c != null) {
                c.a(eVar.b);
                return;
            }
            eVar.b.setTag(str);
            eVar.b.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
        }
    }
}
