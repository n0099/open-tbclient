package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aCT = true;
        this.aCS = 6;
        this.aCe = c.k(context, 10);
        this.aCU = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aCT = true;
        this.aCS = 6;
        this.aCe = c.k(context, i);
        this.aCU = new int[]{12, 13, 9};
    }

    public void eK(int i) {
        if (this.aCe != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aCe;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fR(String str) {
        TextView mutiImageTips;
        if (this.aCe != null && (mutiImageTips = ((MultiImgToolView) this.aCe).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fS(String str) {
        if (this.aCe instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aCe).setNoPicTips(str);
        }
    }
}
