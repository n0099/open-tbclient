package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.auV = true;
        this.auU = 6;
        this.auh = c.h(context, 10);
        this.auW = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.auV = true;
        this.auU = 6;
        this.auh = c.h(context, i);
        this.auW = new int[]{12, 13, 9};
    }

    public void eI(int i) {
        if (this.auh != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.auh;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fw(String str) {
        TextView mutiImageTips;
        if (this.auh != null && (mutiImageTips = ((MultiImgToolView) this.auh).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fx(String str) {
        if (this.auh instanceof MultiImgToolView) {
            ((MultiImgToolView) this.auh).setNoPicTips(str);
        }
    }
}
