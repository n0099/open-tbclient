package com.baidu.tbadk.editortools.imagetool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.tbadk.editortools.y;
/* loaded from: classes.dex */
public class b extends y {
    public b(Context context) {
        super(context, (String) null, 11);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolView = c.h(context, 10);
        this.toolLaunchAction = new int[]{12, 13, 9};
    }

    public b(Context context, int i) {
        super(context, (String) null, 11);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolView = c.h(context, i);
        this.toolLaunchAction = new int[]{12, 13, 9};
    }

    public void eo(int i) {
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

    public void fg(String str) {
        TextView mutiImageTips;
        if (this.toolView != null && (mutiImageTips = ((MultiImgToolView) this.toolView).getMutiImageTips()) != null) {
            mutiImageTips.setText(str);
        }
    }

    public void fh(String str) {
        if (this.toolView instanceof MultiImgToolView) {
            ((MultiImgToolView) this.toolView).setNoPicTips(str);
        }
    }
}
