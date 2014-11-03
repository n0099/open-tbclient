package com.baidu.tieba.im.frsgroup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class FrsGroupBottomView extends com.baidu.adp.widget.ListView.h {
    private LayoutInflater aWC;
    private LinearLayout aWD;
    private ImageView aWE;
    private TextView azj;
    private ProgressBar azk;

    /* loaded from: classes.dex */
    public enum BOTTOM_TYPE {
        LINE,
        HAVE_MORE,
        NO_MORE;

        /* JADX DEBUG: Replace access to removed values field (aWF) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static BOTTOM_TYPE[] valuesCustom() {
            BOTTOM_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            BOTTOM_TYPE[] bottom_typeArr = new BOTTOM_TYPE[length];
            System.arraycopy(valuesCustom, 0, bottom_typeArr, 0, length);
            return bottom_typeArr;
        }
    }

    public FrsGroupBottomView(Activity activity) {
        this.aWC = activity.getLayoutInflater();
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        View inflate = this.aWC.inflate(com.baidu.tieba.w.im_frsgroup_bottom_item, (ViewGroup) null);
        this.azj = (TextView) inflate.findViewById(com.baidu.tieba.v.list_more_title);
        this.azk = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.list_more_progress);
        this.aWE = (ImageView) inflate.findViewById(com.baidu.tieba.v.list_more_line);
        this.aWD = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.list_more_text);
        com.baidu.tbadk.e.b.u(inflate);
        a(BOTTOM_TYPE.LINE);
        return inflate;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
    }

    public void a(BOTTOM_TYPE bottom_type) {
        if (bottom_type != null) {
            if (bottom_type == BOTTOM_TYPE.LINE) {
                this.aWE.setVisibility(0);
                this.aWD.setVisibility(8);
                return;
            }
            this.aWE.setVisibility(8);
            this.aWD.setVisibility(0);
            if (bottom_type == BOTTOM_TYPE.HAVE_MORE) {
                this.azj.setText(com.baidu.tieba.y.frsgroup_load_more);
                this.azk.setVisibility(0);
                return;
            }
            this.azj.setText(com.baidu.tieba.y.frsgroup_no_more);
            this.azk.setVisibility(8);
        }
    }
}
