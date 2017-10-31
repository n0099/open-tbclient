package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aBU = true;
        this.aBT = 6;
        this.aBf = c.j(context, 10);
        this.aBV = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aBU = true;
        this.aBT = 6;
        this.aBf = c.j(context, i);
        this.aBV = new int[]{12, 13, 9};
    }

    public void eV(int i) {
        if (this.aBf != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aBf;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fL(String str) {
        TextView mutiImageTips;
        if (this.aBf != null && (mutiImageTips = ((MultiImgToolView) this.aBf).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fM(String str) {
        if (this.aBf instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aBf).setNoPicTips(str);
        }
    }
}
