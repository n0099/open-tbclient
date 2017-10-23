package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aBl = true;
        this.aBk = 6;
        this.aAv = c.j(context, 10);
        this.aBm = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aBl = true;
        this.aBk = 6;
        this.aAv = c.j(context, i);
        this.aBm = new int[]{12, 13, 9};
    }

    public void eU(int i) {
        if (this.aAv != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aAv;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fE(String str) {
        TextView mutiImageTips;
        if (this.aAv != null && (mutiImageTips = ((MultiImgToolView) this.aAv).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fF(String str) {
        if (this.aAv instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aAv).setNoPicTips(str);
        }
    }
}
