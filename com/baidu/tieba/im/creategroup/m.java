package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes7.dex */
public class m extends BaseAdapter {
    private String[] hrA;
    private GroupAddressLocateActivity hrM;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.hrA = null;
        this.hrM = null;
        this.hrM = groupAddressLocateActivity;
        this.hrA = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hrA != null) {
            return this.hrA.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hrA == null || i <= -1 || i >= this.hrA.length) ? "" : this.hrA[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hrM);
            view = aVar.bdY();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bPZ() != null) {
            if (i + 1 == getCount()) {
                aVar.bPZ().setVisibility(8);
            } else {
                aVar.bPZ().setVisibility(0);
            }
        }
        aVar.Cc(getItem(i).toString());
        if (this.hrM.getSelectedPosition() == i) {
            aVar.mY(true);
        } else {
            aVar.mY(false);
        }
        bS(view);
        return view;
    }

    private void bS(View view) {
        this.hrM.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hrM.getLayoutMode().onModeChanged(view);
    }
}
