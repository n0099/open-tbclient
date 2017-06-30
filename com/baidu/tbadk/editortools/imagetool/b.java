package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aAA = true;
        this.aAz = 6;
        this.azL = c.k(context, 10);
        this.aAB = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aAA = true;
        this.aAz = 6;
        this.azL = c.k(context, i);
        this.aAB = new int[]{12, 13, 9};
    }

    public void eG(int i) {
        if (this.azL != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.azL;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fD(String str) {
        TextView mutiImageTips;
        if (this.azL != null && (mutiImageTips = ((MultiImgToolView) this.azL).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fE(String str) {
        if (this.azL instanceof MultiImgToolView) {
            ((MultiImgToolView) this.azL).setNoPicTips(str);
        }
    }
}
