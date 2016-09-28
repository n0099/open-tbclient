package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.auE = true;
        this.auD = 6;
        this.atI = c.h(context, 10);
        this.auF = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.auE = true;
        this.auD = 6;
        this.atI = c.h(context, i);
        this.auF = new int[]{12, 13, 9};
    }

    public void eE(int i) {
        if (this.atI != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.atI;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fx(String str) {
        TextView mutiImageTips;
        if (this.atI != null && (mutiImageTips = ((MultiImgToolView) this.atI).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fy(String str) {
        if (this.atI instanceof MultiImgToolView) {
            ((MultiImgToolView) this.atI).setNoPicTips(str);
        }
    }
}
