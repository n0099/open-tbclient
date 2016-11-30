package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.avy = true;
        this.avx = 6;
        this.auC = c.h(context, 10);
        this.avz = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.avy = true;
        this.avx = 6;
        this.auC = c.h(context, i);
        this.avz = new int[]{12, 13, 9};
    }

    public void eH(int i) {
        if (this.auC != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.auC;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fA(String str) {
        TextView mutiImageTips;
        if (this.auC != null && (mutiImageTips = ((MultiImgToolView) this.auC).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fB(String str) {
        if (this.auC instanceof MultiImgToolView) {
            ((MultiImgToolView) this.auC).setNoPicTips(str);
        }
    }
}
