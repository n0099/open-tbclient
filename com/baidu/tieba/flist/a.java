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
    private com.baidu.tieba.square.q ava;
    private int avb = 0;
    b avc;
    Activity mActivity;

    public a(Activity activity) {
        this.mActivity = activity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ava == null || this.ava.bMJ == null) {
            return 0;
        }
        return this.ava.bMJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ava == null || this.ava.bMJ == null) {
            return null;
        }
        return this.ava.bMJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = DL();
        }
        if (this.ava != null) {
            com.baidu.tieba.square.q qVar = this.ava.bMJ.get(i);
            this.avc = (b) view.getTag();
            if (qVar != null) {
                a(this.avc, qVar, view, i);
            }
        }
        return view;
    }

    public void ez(int i) {
        this.avb = i;
        notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.square.q qVar) {
        this.ava = qVar;
    }

    public com.baidu.tieba.square.q DK() {
        return this.ava;
    }

    private View DL() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.forum_list_dir_menu_item, null);
        this.avc = new b(this);
        this.avc.avd = (ImageView) inflate.findViewById(com.baidu.tieba.v.menu_choose);
        this.avc.ave = (TextView) inflate.findViewById(com.baidu.tieba.v.menu_name);
        inflate.setTag(this.avc);
        return inflate;
    }

    private void a(b bVar, com.baidu.tieba.square.q qVar, View view, int i) {
        if (bVar != null && qVar != null) {
            bVar.ave.setText("");
            if (i == 0) {
                bVar.ave.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_menu_all)) + qVar.avi);
            } else {
                bVar.ave.setText(qVar.avi);
            }
            if (i != this.avb) {
                bVar.avd.setVisibility(4);
                aw.b(bVar.ave, com.baidu.tieba.s.forum_list_menu_notselected, 1);
                return;
            }
            bVar.avd.setVisibility(0);
            aw.b(bVar.ave, com.baidu.tieba.s.forum_list_menu_selected, 1);
        }
    }
}
