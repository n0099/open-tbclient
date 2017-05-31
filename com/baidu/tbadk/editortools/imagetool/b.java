package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.azx = true;
        this.azw = 6;
        this.ayJ = c.k(context, 10);
        this.azy = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.azx = true;
        this.azw = 6;
        this.ayJ = c.k(context, i);
        this.azy = new int[]{12, 13, 9};
    }

    public void eE(int i) {
        if (this.ayJ != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.ayJ;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fj(String str) {
        TextView mutiImageTips;
        if (this.ayJ != null && (mutiImageTips = ((MultiImgToolView) this.ayJ).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fk(String str) {
        if (this.ayJ instanceof MultiImgToolView) {
            ((MultiImgToolView) this.ayJ).setNoPicTips(str);
        }
    }
}
