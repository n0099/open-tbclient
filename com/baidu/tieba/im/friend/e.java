package com.baidu.tieba.im.friend;

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
    private IMBlackListActivity aVI;
    private ArrayList<com.baidu.tieba.im.data.a> aeE;
    private View.OnClickListener agu = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.aVI = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.aeE = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.aeE != null) {
            this.aeE.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aeE != null) {
            return this.aeE.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aeE != null) {
            return this.aeE.get(i);
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
            return gVar.Xm;
        }
        return null;
    }

    private g MY() {
        g gVar = new g(this, null);
        gVar.Xm = com.baidu.adp.lib.g.b.ek().inflate(this.aVI, com.baidu.tieba.w.im_black_list_item, null);
        gVar.aVK = (HeadImageView) gVar.Xm.findViewById(com.baidu.tieba.v.header_view);
        gVar.aVK.setIsRound(true);
        gVar.aEq = (TextView) gVar.Xm.findViewById(com.baidu.tieba.v.user_name);
        gVar.aVL = (Button) gVar.Xm.findViewById(com.baidu.tieba.v.remove_button);
        gVar.Xm.setTag(gVar);
        gVar.aVL.setOnClickListener(this.agu);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = MY();
        } else {
            gVar = (g) obj;
        }
        a(gVar, aVar.Mm());
        gVar.aEq.setText(aVar.getUserName());
        gVar.aVL.setTag(aVar);
        this.aVI.getLayoutMode().h(gVar.Xm);
        return gVar;
    }

    private void a(g gVar, String str) {
        if (str != null) {
            gVar.aVK.setTag(str);
            gVar.aVK.c(str, 12, false);
        }
    }
}
