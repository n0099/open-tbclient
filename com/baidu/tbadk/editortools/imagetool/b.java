package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class b extends r {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aCg = true;
        this.aCf = 6;
        this.aBq = c.l(context, 10);
        this.aCh = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aCg = true;
        this.aCf = 6;
        this.aBq = c.l(context, i);
        this.aCh = new int[]{12, 13, 9};
    }

    public void eK(int i) {
        if (this.aBq != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aBq;
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
        if (this.aBq != null && (mutiImageTips = ((MultiImgToolView) this.aBq).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fN(String str) {
        if (this.aBq instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aBq).setNoPicTips(str);
        }
    }
}
