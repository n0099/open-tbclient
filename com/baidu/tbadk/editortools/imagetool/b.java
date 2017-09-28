package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aBx = true;
        this.aBw = 6;
        this.aAH = c.k(context, 10);
        this.aBy = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aBx = true;
        this.aBw = 6;
        this.aAH = c.k(context, i);
        this.aBy = new int[]{12, 13, 9};
    }

    public void eV(int i) {
        if (this.aAH != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aAH;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fF(String str) {
        TextView mutiImageTips;
        if (this.aAH != null && (mutiImageTips = ((MultiImgToolView) this.aAH).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fG(String str) {
        if (this.aAH instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aAH).setNoPicTips(str);
        }
    }
}
