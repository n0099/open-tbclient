package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.aqp = true;
        this.aqo = 6;
        this.aps = c.f(context, 10);
        this.aqq = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.aqp = true;
        this.aqo = 6;
        this.aps = c.f(context, i);
        this.aqq = new int[]{12, 13, 9};
    }

    public void en(int i) {
        if (this.aps != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aps;
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
        if (this.aps != null && (mutiImageTips = ((MultiImgToolView) this.aps).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fp(String str) {
        if (this.aps instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aps).setNoPicTips(str);
        }
    }
}
