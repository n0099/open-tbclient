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
    private String[] aoB;
    private int aoC = 0;
    private View.OnClickListener aoD = new f(this);

    public e(String[] strArr) {
        this.aoB = strArr;
    }

    public String Bh() {
        if (this.aoB != null) {
            return this.aoB[this.aoC];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aoB == null) {
            return 0;
        }
        return this.aoB.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(viewGroup.getContext(), x.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.aoF = (TextView) view.findViewById(w.reason_text);
            gVar2.aoG = (ImageView) view.findViewById(w.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.aoD);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.aoF.setText(this.aoB[i]);
        if (gVar.mIndex == this.aoC) {
            bc.c(gVar.aoG, v.icon_found_information_choose);
            gVar.aoG.setVisibility(0);
            bc.b(gVar.aoF, t.forbid_selected_txt, 1);
        } else {
            gVar.aoG.setVisibility(4);
            bc.b(gVar.aoF, t.appeal_com_text, 1);
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
