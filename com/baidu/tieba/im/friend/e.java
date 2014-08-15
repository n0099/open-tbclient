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
    private ArrayList<com.baidu.tieba.im.data.a> b;
    private View.OnClickListener c = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.a = iMBlackListActivity;
    }

    public void a(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.b = arrayList;
    }

    public void a(com.baidu.tieba.im.data.a aVar) {
        if (this.b != null) {
            this.b.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b != null) {
            return this.b.get(i);
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

    private g a() {
        g gVar = new g(this, null);
        gVar.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.im_black_list_item, (ViewGroup) null);
        gVar.b = (HeadImageView) gVar.a.findViewById(com.baidu.tieba.u.header_view);
        gVar.b.setIsRound(true);
        gVar.c = (TextView) gVar.a.findViewById(com.baidu.tieba.u.user_name);
        gVar.d = (Button) gVar.a.findViewById(com.baidu.tieba.u.remove_button);
        gVar.a.setTag(gVar);
        gVar.d.setOnClickListener(this.c);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = a();
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
            gVar.b.setTag(str);
            gVar.b.a(str, 12, false);
        }
    }
}
