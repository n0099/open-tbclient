package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.azv = true;
        this.azu = 6;
        this.ayH = c.k(context, 10);
        this.azw = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.azv = true;
        this.azu = 6;
        this.ayH = c.k(context, i);
        this.azw = new int[]{12, 13, 9};
    }

    public void eE(int i) {
        if (this.ayH != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.ayH;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fi(String str) {
        TextView mutiImageTips;
        if (this.ayH != null && (mutiImageTips = ((MultiImgToolView) this.ayH).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fj(String str) {
        if (this.ayH instanceof MultiImgToolView) {
            ((MultiImgToolView) this.ayH).setNoPicTips(str);
        }
    }
}
