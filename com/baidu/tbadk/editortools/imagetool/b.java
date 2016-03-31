package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
/* loaded from: classes.dex */
public class b extends aa {
    public b(Context context) {
        super(context, (String) null, 11);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolView = c.f(context, 10);
        this.toolLaunchAction = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolView = c.f(context, i);
        this.toolLaunchAction = new int[]{12, 13, 9};
    }

    public void eH(int i) {
        if (this.toolView != null) {
            MultiImgToolView multiImgToolView = (MultiImgToolView) this.toolView;
            if (i == 1) {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(false);
            }
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
        }
    }

    public void fr(String str) {
        TextView mutiImageTips;
        if (this.toolView != null && (mutiImageTips = ((MultiImgToolView) this.toolView).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fs(String str) {
        if (this.toolView instanceof MultiImgToolView) {
            ((MultiImgToolView) this.toolView).setNoPicTips(str);
        }
    }
}
