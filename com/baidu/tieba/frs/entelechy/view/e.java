package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.w;
/* loaded from: classes22.dex */
public class e extends af.a {
    public Context mContext;
    public View mRoot;
    public TextView mTipView;

    public e(View view, Context context) {
        super(view);
        this.mRoot = view;
        this.mTipView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.mContext = context;
    }

    public void a(w wVar) {
        if (wVar != null) {
            this.mTipView.setText(R.string.read_here);
            bsD();
        }
    }

    public void bsD() {
        ap.setViewTextColor(this.mTipView, R.color.cp_link_tip_a);
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_e);
    }
}
