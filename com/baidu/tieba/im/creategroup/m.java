package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] eAP;
    private GroupAddressEditActivity eAR;

    public m(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eAP = null;
        this.eAR = null;
        this.eAR = groupAddressEditActivity;
        this.eAP = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAP != null) {
            return this.eAP.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eAP == null || i <= -1 || i >= this.eAP.length) ? "" : this.eAP[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eAR);
            view = aVar.aix();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mT(getItem(i).toString());
        if (this.eAR.aHD() == i) {
            aVar.hq(true);
        } else {
            aVar.hq(false);
        }
        bU(view);
        return view;
    }

    private void bU(View view) {
        this.eAR.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eAR.getLayoutMode().aM(view);
    }
}
