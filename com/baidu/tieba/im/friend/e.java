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
    private IMBlackListActivity aVu;
    private ArrayList<com.baidu.tieba.im.data.a> aew;
    private View.OnClickListener agm = new f(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.aVu = iMBlackListActivity;
    }

    public void setData(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.aew = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.aew != null) {
            this.aew.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew != null) {
            return this.aew.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aew != null) {
            return this.aew.get(i);
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
            return gVar.Xi;
        }
        return null;
    }

    private g MU() {
        g gVar = new g(this, null);
        gVar.Xi = com.baidu.adp.lib.g.b.ek().inflate(this.aVu, com.baidu.tieba.w.im_black_list_item, null);
        gVar.aVw = (HeadImageView) gVar.Xi.findViewById(com.baidu.tieba.v.header_view);
        gVar.aVw.setIsRound(true);
        gVar.aEg = (TextView) gVar.Xi.findViewById(com.baidu.tieba.v.user_name);
        gVar.aVx = (Button) gVar.Xi.findViewById(com.baidu.tieba.v.remove_button);
        gVar.Xi.setTag(gVar);
        gVar.aVx.setOnClickListener(this.agm);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = MU();
        } else {
            gVar = (g) obj;
        }
        a(gVar, aVar.Mi());
        gVar.aEg.setText(aVar.getUserName());
        gVar.aVx.setTag(aVar);
        this.aVu.getLayoutMode().h(gVar.Xi);
        return gVar;
    }

    private void a(g gVar, String str) {
        if (str != null) {
            gVar.aVw.setTag(str);
            gVar.aVw.c(str, 12, false);
        }
    }
}
