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
    private IMBlackListActivity aZZ;
    private View.OnClickListener anL = new f(this);
    private ArrayList<com.baidu.tieba.im.data.a> mData;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(IMBlackListActivity iMBlackListActivity) {
        this.aZZ = iMBlackListActivity;
    }

    public void r(ArrayList<com.baidu.tieba.im.data.a> arrayList) {
        this.mData = arrayList;
    }

    public void b(com.baidu.tieba.im.data.a aVar) {
        if (this.mData != null) {
            this.mData.remove(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
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

    private g Oi() {
        g gVar = new g(this, null);
        gVar.rootView = com.baidu.adp.lib.g.b.ek().inflate(this.aZZ.getPageContext().getContext(), com.baidu.tieba.x.im_black_list_item, null);
        gVar.bab = (HeadImageView) gVar.rootView.findViewById(com.baidu.tieba.w.header_view);
        gVar.bab.setIsRound(true);
        gVar.aFV = (TextView) gVar.rootView.findViewById(com.baidu.tieba.w.user_name);
        gVar.bac = (Button) gVar.rootView.findViewById(com.baidu.tieba.w.remove_button);
        gVar.rootView.setTag(gVar);
        gVar.bac.setOnClickListener(this.anL);
        return gVar;
    }

    private g a(Object obj, com.baidu.tieba.im.data.a aVar) {
        g gVar;
        if (obj == null) {
            gVar = Oi();
        } else {
            gVar = (g) obj;
        }
        a(gVar, aVar.Mj());
        gVar.aFV.setText(aVar.getUserName());
        gVar.bac.setTag(aVar);
        this.aZZ.getLayoutMode().h(gVar.rootView);
        return gVar;
    }

    private void a(g gVar, String str) {
        if (str != null) {
            gVar.bab.setTag(str);
            gVar.bab.d(str, 12, false);
        }
    }
}
