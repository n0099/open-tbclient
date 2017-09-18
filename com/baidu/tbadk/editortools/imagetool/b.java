package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aCd = true;
        this.aCc = 6;
        this.aBn = c.k(context, 10);
        this.aCe = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aCd = true;
        this.aCc = 6;
        this.aBn = c.k(context, i);
        this.aCe = new int[]{12, 13, 9};
    }

    public void eK(int i) {
        if (this.aBn != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aBn;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fM(String str) {
        TextView mutiImageTips;
        if (this.aBn != null && (mutiImageTips = ((MultiImgToolView) this.aBn).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fN(String str) {
        if (this.aBn instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aBn).setNoPicTips(str);
        }
    }
}
