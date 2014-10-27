package com.baidu.tieba.flist;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private com.baidu.tieba.square.q auR;
    private int auS = 0;
    b auT;
    Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auR == null || this.auR.bMu == null) {
            return 0;
        }
        return this.auR.bMu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auR == null || this.auR.bMu == null) {
            return null;
        }
        return this.auR.bMu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = DJ();
        }
        if (this.auR != null) {
            com.baidu.tieba.square.q qVar = this.auR.bMu.get(i);
            this.auT = (b) view.getTag();
            if (qVar != null) {
                a(this.auT, qVar, view, i);
            }
        }
        return view;
    }

    public void ez(int i) {
        this.auS = i;
        notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.square.q qVar) {
        this.auR = qVar;
    }

    public com.baidu.tieba.square.q DI() {
        return this.auR;
    }

    private View DJ() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.forum_list_dir_menu_item, null);
        this.auT = new b(this);
        this.auT.auU = (ImageView) inflate.findViewById(com.baidu.tieba.v.menu_choose);
        this.auT.auV = (TextView) inflate.findViewById(com.baidu.tieba.v.menu_name);
        inflate.setTag(this.auT);
        return inflate;
    }

    private void a(b bVar, com.baidu.tieba.square.q qVar, View view, int i) {
        if (bVar != null && qVar != null) {
            bVar.auV.setText("");
            if (i == 0) {
                bVar.auV.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_menu_all)) + qVar.auZ);
            } else {
                bVar.auV.setText(qVar.auZ);
            }
            if (i != this.auS) {
                bVar.auU.setVisibility(4);
                aw.b(bVar.auV, com.baidu.tieba.s.forum_list_menu_notselected, 1);
                return;
            }
            bVar.auU.setVisibility(0);
            aw.b(bVar.auV, com.baidu.tieba.s.forum_list_menu_selected, 1);
        }
    }
}
