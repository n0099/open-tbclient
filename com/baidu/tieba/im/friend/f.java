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
public class f extends BaseAdapter {
    private IMBlackListActivity a;
    private com.baidu.tbadk.editortool.ab b;
    private ArrayList<com.baidu.tieba.im.data.a> c;
    private View.OnClickListener d = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.b = null;
        this.a = iMBlackListActivity;
        this.b = new com.baidu.tbadk.editortool.ab(this.a);
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
        h hVar;
        com.baidu.tieba.im.data.a aVar = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar != null) {
            hVar = a(view != null ? view.getTag() : null, aVar);
        } else {
            hVar = null;
        }
        if (hVar != null) {
            return hVar.a;
        }
        return null;
    }

    public com.baidu.tbadk.editortool.ab a() {
        if (this.b == null) {
            this.b = new com.baidu.tbadk.editortool.ab(this.a);
        }
        return this.b;
    }

    private h b() {
        h hVar = new h(this, null);
        hVar.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.im_black_list_item, (ViewGroup) null);
        hVar.b = (HeadImageView) hVar.a.findViewById(com.baidu.tieba.r.header_view);
        hVar.b.setIsRound(true);
        hVar.c = (TextView) hVar.a.findViewById(com.baidu.tieba.r.user_name);
        hVar.d = (Button) hVar.a.findViewById(com.baidu.tieba.r.remove_button);
        hVar.a.setTag(hVar);
        hVar.d.setOnClickListener(this.d);
        return hVar;
    }

    private h a(Object obj, com.baidu.tieba.im.data.a aVar) {
        h hVar;
        if (obj == null) {
            hVar = b();
        } else {
            hVar = (h) obj;
        }
        a(hVar, aVar.c());
        hVar.c.setText(aVar.b());
        hVar.d.setTag(aVar);
        this.a.getLayoutMode().a(hVar.a);
        return hVar;
    }

    private void a(h hVar, String str) {
        if (str != null) {
            com.baidu.adp.widget.a.a c = this.b.c(str);
            if (c != null) {
                c.a(hVar.b);
                return;
            }
            hVar.b.setTag(str);
            hVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.photo));
        }
    }
}
