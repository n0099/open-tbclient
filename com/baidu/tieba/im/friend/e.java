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
    private ArrayList<com.baidu.tieba.im.data.a> amM;
    private View.OnClickListener aoD = new f(this);
    private IMBlackListActivity bbv;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.bbv = iMBlackListActivity;
    }

    public void s(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.amM = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.amM != null) {
            this.amM.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amM != null) {
            return this.amM.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amM != null) {
            return this.amM.get(i);
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
            return gVar.rootView;
        }
        return null;
    }

    private g Oz() {
        g gVar = new g(this, null);
        gVar.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.bbv.getPageContext().getContext(), com.baidu.tieba.x.im_black_list_item, null);
        gVar.bbx = (HeadImageView) gVar.rootView.findViewById(com.baidu.tieba.w.header_view);
        gVar.bbx.setIsRound(true);
        gVar.aHc = (TextView) gVar.rootView.findViewById(com.baidu.tieba.w.user_name);
        gVar.bby = (Button) gVar.rootView.findViewById(com.baidu.tieba.w.remove_button);
        gVar.rootView.setTag(gVar);
        gVar.bby.setOnClickListener(this.aoD);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = Oz();
        } else {
            gVar = (g) obj;
        }
        a(gVar, aVar.Mz());
        gVar.aHc.setText(aVar.getUserName());
        gVar.bby.setTag(aVar);
        this.bbv.getLayoutMode().h(gVar.rootView);
        return gVar;
    }

    private void a(g gVar, String str) {
        if (str != null) {
            gVar.bbx.setTag(str);
            gVar.bbx.d(str, 12, false);
        }
    }
}
