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
    private ArrayList<com.baidu.tieba.im.data.a> amP;
    private View.OnClickListener aoG = new f(this);
    private IMBlackListActivity bbw;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.bbw = iMBlackListActivity;
    }

    public void s(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.amP = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.amP != null) {
            this.amP.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amP != null) {
            return this.amP.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amP != null) {
            return this.amP.get(i);
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

    private g OE() {
        g gVar = new g(this, null);
        gVar.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.bbw.getPageContext().getContext(), com.baidu.tieba.x.im_black_list_item, null);
        gVar.bby = (HeadImageView) gVar.rootView.findViewById(com.baidu.tieba.w.header_view);
        gVar.bby.setIsRound(true);
        gVar.aHf = (TextView) gVar.rootView.findViewById(com.baidu.tieba.w.user_name);
        gVar.bbz = (Button) gVar.rootView.findViewById(com.baidu.tieba.w.remove_button);
        gVar.rootView.setTag(gVar);
        gVar.bbz.setOnClickListener(this.aoG);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = OE();
        } else {
            gVar = (g) obj;
        }
        a(gVar, aVar.ME());
        gVar.aHf.setText(aVar.getUserName());
        gVar.bbz.setTag(aVar);
        this.bbw.getLayoutMode().h(gVar.rootView);
        return gVar;
    }

    private void a(g gVar, String str) {
        if (str != null) {
            gVar.bby.setTag(str);
            gVar.bby.d(str, 12, false);
        }
    }
}
