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
public final class f extends BaseAdapter {
    private IMBlackListActivity a;
    private com.baidu.tbadk.editortool.aa b;
    private ArrayList<com.baidu.tieba.im.data.a> c;
    private View.OnClickListener d = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public f(IMBlackListActivity iMBlackListActivity) {
        this.b = null;
        this.a = iMBlackListActivity;
        this.b = new com.baidu.tbadk.editortool.aa(this.a);
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
        h hVar;
        com.baidu.tieba.im.data.a aVar = (com.baidu.tieba.im.data.a) getItem(i);
        if (aVar != null) {
            Object tag = view != null ? view.getTag() : null;
            if (tag == null) {
                h hVar2 = new h(this, (byte) 0);
                hVar2.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.im.i.im_black_list_item, (ViewGroup) null);
                hVar2.b = (HeadImageView) hVar2.a.findViewById(com.baidu.tieba.im.h.header_view);
                hVar2.b.setIsRound(true);
                hVar2.c = (TextView) hVar2.a.findViewById(com.baidu.tieba.im.h.user_name);
                hVar2.d = (Button) hVar2.a.findViewById(com.baidu.tieba.im.h.remove_button);
                hVar2.a.setTag(hVar2);
                hVar2.d.setOnClickListener(this.d);
                hVar = hVar2;
            } else {
                hVar = (h) tag;
            }
            String c = aVar.c();
            if (c != null) {
                com.baidu.tbadk.editortool.aa aaVar = this.b;
                com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(c);
                if (b != null) {
                    b.a(hVar.b);
                } else {
                    hVar.b.setTag(c);
                    hVar.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.im.g.photo));
                }
            }
            hVar.c.setText(aVar.b());
            hVar.d.setTag(aVar);
            this.a.getLayoutMode().a(hVar.a);
        } else {
            hVar = null;
        }
        if (hVar != null) {
            return hVar.a;
        }
        return null;
    }

    public final com.baidu.tbadk.editortool.aa a() {
        if (this.b == null) {
            this.b = new com.baidu.tbadk.editortool.aa(this.a);
        }
        return this.b;
    }
}
