package com.baidu.tieba.account.forbid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private String[] anJ;
    private int anK = 0;
    private View.OnClickListener anL = new f(this);

    public e(String[] strArr) {
        this.anJ = strArr;
    }

    public String AN() {
        if (this.anJ != null) {
            return this.anJ[this.anK];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anJ == null) {
            return 0;
        }
        return this.anJ.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), x.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.anN = (TextView) view.findViewById(w.reason_text);
            gVar2.anO = (ImageView) view.findViewById(w.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.anL);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.anN.setText(this.anJ[i]);
        if (gVar.mIndex == this.anK) {
            ax.c(gVar.anO, v.icon_found_information_choose);
            gVar.anO.setVisibility(0);
            ax.b(gVar.anN, t.forbid_selected_txt, 1);
        } else {
            gVar.anO.setVisibility(4);
            ax.b(gVar.anN, t.appeal_com_text, 1);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }
}
