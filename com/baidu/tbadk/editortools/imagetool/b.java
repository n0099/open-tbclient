package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.x;
/* loaded from: classes.dex */
public class b extends x {
    public b(Context context) {
        super(context, (String) null, 11);
        this.azN = true;
        this.azM = 6;
        this.ayZ = c.k(context, 10);
        this.azO = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.azN = true;
        this.azM = 6;
        this.ayZ = c.k(context, i);
        this.azO = new int[]{12, 13, 9};
    }

    public void eH(int i) {
        if (this.ayZ != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.ayZ;
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
        if (this.ayZ != null && (mutiImageTips = ((MultiImgToolView) this.ayZ).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fp(String str) {
        if (this.ayZ instanceof MultiImgToolView) {
            ((MultiImgToolView) this.ayZ).setNoPicTips(str);
        }
    }
}
