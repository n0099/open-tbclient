package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aCR = true;
        this.aCQ = 6;
        this.aCc = c.k(context, 10);
        this.aCS = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aCR = true;
        this.aCQ = 6;
        this.aCc = c.k(context, i);
        this.aCS = new int[]{12, 13, 9};
    }

    public void eK(int i) {
        if (this.aCc != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aCc;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fN(String str) {
        TextView mutiImageTips;
        if (this.aCc != null && (mutiImageTips = ((MultiImgToolView) this.aCc).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fO(String str) {
        if (this.aCc instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aCc).setNoPicTips(str);
        }
    }
}
