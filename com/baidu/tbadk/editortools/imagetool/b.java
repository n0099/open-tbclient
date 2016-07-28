package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.arU = true;
        this.arT = 6;
        this.aqX = c.f(context, 10);
        this.arV = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.arU = true;
        this.arT = 6;
        this.aqX = c.f(context, i);
        this.arV = new int[]{12, 13, 9};
    }

    public void er(int i) {
        if (this.aqX != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aqX;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fs(String str) {
        TextView mutiImageTips;
        if (this.aqX != null && (mutiImageTips = ((MultiImgToolView) this.aqX).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void ft(String str) {
        if (this.aqX instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aqX).setNoPicTips(str);
        }
    }
}
