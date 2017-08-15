package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aCS = true;
        this.aCR = 6;
        this.aCd = c.k(context, 10);
        this.aCT = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aCS = true;
        this.aCR = 6;
        this.aCd = c.k(context, i);
        this.aCT = new int[]{12, 13, 9};
    }

    public void eK(int i) {
        if (this.aCd != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aCd;
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
        if (this.aCd != null && (mutiImageTips = ((MultiImgToolView) this.aCd).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fO(String str) {
        if (this.aCd instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aCd).setNoPicTips(str);
        }
    }
}
