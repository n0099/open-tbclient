package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aBA = true;
        this.aBz = 6;
        this.aAL = c.k(context, 10);
        this.aBB = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aBA = true;
        this.aBz = 6;
        this.aAL = c.k(context, i);
        this.aBB = new int[]{12, 13, 9};
    }

    public void eI(int i) {
        if (this.aAL != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aAL;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fH(String str) {
        TextView mutiImageTips;
        if (this.aAL != null && (mutiImageTips = ((MultiImgToolView) this.aAL).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fI(String str) {
        if (this.aAL instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aAL).setNoPicTips(str);
        }
    }
}
