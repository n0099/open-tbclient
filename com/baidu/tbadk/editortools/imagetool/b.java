package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.arf = true;
        this.are = 6;
        this.aqi = c.f(context, 10);
        this.arg = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.arf = true;
        this.are = 6;
        this.aqi = c.f(context, i);
        this.arg = new int[]{12, 13, 9};
    }

    public void er(int i) {
        if (this.aqi != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.aqi;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fu(String str) {
        TextView mutiImageTips;
        if (this.aqi != null && (mutiImageTips = ((MultiImgToolView) this.aqi).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fv(String str) {
        if (this.aqi instanceof MultiImgToolView) {
            ((MultiImgToolView) this.aqi).setNoPicTips(str);
        }
    }
}
