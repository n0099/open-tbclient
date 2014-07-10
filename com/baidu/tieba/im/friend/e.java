package com.baidu.tieba.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private IMBlackListActivity a;
    private com.baidu.tbadk.editortool.aa b;
    private ArrayList<com.baidu.tieba.im.data.a> c;
    private View.OnClickListener d = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.b = null;
        this.a = iMBlackListActivity;
        this.b = new com.baidu.tbadk.editortool.aa(this.a);
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
        g gVar;
        com.baidu.tieba.im.data.a aVar = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar != null) {
            gVar = a(view != null ? view.getTag() : null, aVar);
        } else {
            gVar = null;
        }
        if (gVar != null) {
            return gVar.a;
        }
        return null;
    }

    public com.baidu.tbadk.editortool.aa a() {
        if (this.b == null) {
            this.b = new com.baidu.tbadk.editortool.aa(this.a);
        }
        return this.b;
    }

    private g b() {
        g gVar = new g(this, null);
        gVar.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_black_list_item, (ViewGroup) null);
        gVar.b = (HeadImageView) gVar.a.findViewById(com.baidu.tieba.v.header_view);
        gVar.b.setIsRound(true);
        gVar.c = (TextView) gVar.a.findViewById(com.baidu.tieba.v.user_name);
        gVar.d = (Button) gVar.a.findViewById(com.baidu.tieba.v.remove_button);
        gVar.a.setTag(gVar);
        gVar.d.setOnClickListener(this.d);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = b();
        } else {
            gVar = (g) obj;
        }
        a(gVar, aVar.c());
        gVar.c.setText(aVar.b());
        gVar.d.setTag(aVar);
        this.a.getLayoutMode().a(gVar.a);
        return gVar;
    }

    private void a(g gVar, String str) {
        if (str != null) {
            com.baidu.adp.widget.a.a c = this.b.c(str);
            if (c != null) {
                c.a(gVar.b);
                return;
            }
            gVar.b.setTag(str);
            gVar.b.setImageBitmap(com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.photo));
        }
    }
}
