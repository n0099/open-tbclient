package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes17.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity jlG;
    private String[] jlu;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.jlu = null;
        this.jlG = null;
        this.jlG = groupAddressLocateActivity;
        this.jlu = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jlu != null) {
            return this.jlu.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jlu == null || i <= -1 || i >= this.jlu.length) ? "" : this.jlu[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.jlG);
            view = aVar.bLA();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cCy() != null) {
            if (i + 1 == getCount()) {
                aVar.cCy().setVisibility(8);
            } else {
                aVar.cCy().setVisibility(0);
            }
        }
        aVar.Kg(getItem(i).toString());
        if (this.jlG.getSelectedPosition() == i) {
            aVar.qq(true);
        } else {
            aVar.qq(false);
        }
        co(view);
        return view;
    }

    private void co(View view) {
        this.jlG.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jlG.getLayoutMode().onModeChanged(view);
    }
}
