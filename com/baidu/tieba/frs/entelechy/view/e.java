package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.v;
/* loaded from: classes9.dex */
public class e extends ad.a {
    public Context mContext;
    public View mRoot;
    public TextView mTipView;

    public e(View view, Context context) {
        super(view);
        this.mRoot = view;
        this.mTipView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.mContext = context;
    }

    public void a(v vVar) {
        if (vVar != null) {
            this.mTipView.setText(R.string.read_here);
            aYj();
        }
    }

    public void aYj() {
        an.setViewTextColor(this.mTipView, (int) R.color.cp_link_tip_a);
        an.setBackgroundResource(this.mRoot, R.color.cp_bg_line_e);
    }
}
