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
    private LayoutInflater aWo;
    private LinearLayout aWp;
    private ImageView aWq;
    private TextView aza;
    private ProgressBar azb;

    /* loaded from: classes.dex */
    public enum BOTTOM_TYPE {
        LINE,
        HAVE_MORE,
        NO_MORE;

        /* JADX DEBUG: Replace access to removed values field (aWr) with 'values()' method */
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
        this.aWo = activity.getLayoutInflater();
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        View inflate = this.aWo.inflate(com.baidu.tieba.w.im_frsgroup_bottom_item, (ViewGroup) null);
        this.aza = (TextView) inflate.findViewById(com.baidu.tieba.v.list_more_title);
        this.azb = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.list_more_progress);
        this.aWq = (ImageView) inflate.findViewById(com.baidu.tieba.v.list_more_line);
        this.aWp = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.list_more_text);
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
                this.aWq.setVisibility(0);
                this.aWp.setVisibility(8);
                return;
            }
            this.aWq.setVisibility(8);
            this.aWp.setVisibility(0);
            if (bottom_type == BOTTOM_TYPE.HAVE_MORE) {
                this.aza.setText(com.baidu.tieba.y.frsgroup_load_more);
                this.azb.setVisibility(0);
                return;
            }
            this.aza.setText(com.baidu.tieba.y.frsgroup_no_more);
            this.azb.setVisibility(8);
        }
    }
}
