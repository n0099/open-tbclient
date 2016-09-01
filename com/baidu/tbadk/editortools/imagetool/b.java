package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.avb = true;
        this.ava = 6;
        this.aue = c.h(context, 10);
        this.avc = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.avb = true;
        this.ava = 6;
        this.aue = c.h(context, i);
        this.avc = new int[]{12, 13, 9};
    }

    public void eF(int i) {
        if (this.aue != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aue;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fv(String str) {
        TextView mutiImageTips;
        if (this.aue != null && (mutiImageTips = ((MultiImgToolView) this.aue).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fw(String str) {
        if (this.aue instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aue).setNoPicTips(str);
        }
    }
}
