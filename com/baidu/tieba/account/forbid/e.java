package com.baidu.tieba.account.forbid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private String[] aoE;
    private int aoF = 0;
    private View.OnClickListener aoG = new f(this);

    public e(String[] strArr) {
        this.aoE = strArr;
    }

    public String Bn() {
        if (this.aoE != null) {
            return this.aoE[this.aoF];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aoE == null) {
            return 0;
        }
        return this.aoE.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(viewGroup.getContext(), x.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.aoI = (TextView) view.findViewById(w.reason_text);
            gVar2.aoJ = (ImageView) view.findViewById(w.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.aoG);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.aoI.setText(this.aoE[i]);
        if (gVar.mIndex == this.aoF) {
            bc.c(gVar.aoJ, v.icon_found_information_choose);
            gVar.aoJ.setVisibility(0);
            bc.b(gVar.aoI, t.forbid_selected_txt, 1);
        } else {
            gVar.aoJ.setVisibility(4);
            bc.b(gVar.aoI, t.appeal_com_text, 1);
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
