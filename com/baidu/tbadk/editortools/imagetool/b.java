package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aua = true;
        this.atZ = 6;
        this.atm = c.i(context, 10);
        this.aub = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aua = true;
        this.atZ = 6;
        this.atm = c.i(context, i);
        this.aub = new int[]{12, 13, 9};
    }

    public void eJ(int i) {
        if (this.atm != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.atm;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void ft(String str) {
        TextView mutiImageTips;
        if (this.atm != null && (mutiImageTips = ((MultiImgToolView) this.atm).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fu(String str) {
        if (this.atm instanceof MultiImgToolView) {
            ((MultiImgToolView) this.atm).setNoPicTips(str);
        }
    }
}
