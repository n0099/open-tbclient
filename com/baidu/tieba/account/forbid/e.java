package com.baidu.tieba.account.forbid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private String[] agk;
    private int agl = 0;
    private View.OnClickListener agm = new f(this);

    public e(String[] strArr) {
        this.agk = strArr;
    }

    public String xs() {
        if (this.agk != null) {
            return this.agk[this.agl];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.agk == null) {
            return 0;
        }
        return this.agk.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), w.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.ago = (TextView) view.findViewById(v.reason_text);
            gVar2.agp = (ImageView) view.findViewById(v.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.agm);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        TbadkApplication.m251getInst().getSkinType();
        gVar.ago.setText(this.agk[i]);
        if (gVar.mIndex == this.agl) {
            aw.c(gVar.agp, u.icon_found_information_choose);
            gVar.agp.setVisibility(0);
            aw.b(gVar.ago, s.forbid_selected_txt, 1);
        } else {
            gVar.agp.setVisibility(4);
            aw.b(gVar.ago, s.appeal_com_text, 1);
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
