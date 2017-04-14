package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.azL = true;
        this.azK = 6;
        this.ayX = c.k(context, 10);
        this.azM = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.azL = true;
        this.azK = 6;
        this.ayX = c.k(context, i);
        this.azM = new int[]{12, 13, 9};
    }

    public void eH(int i) {
        if (this.ayX != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.ayX;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fo(String str) {
        TextView mutiImageTips;
        if (this.ayX != null && (mutiImageTips = ((MultiImgToolView) this.ayX).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fp(String str) {
        if (this.ayX instanceof MultiImgToolView) {
            ((MultiImgToolView) this.ayX).setNoPicTips(str);
        }
    }
}
