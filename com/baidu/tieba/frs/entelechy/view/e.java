package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.t;
/* loaded from: classes9.dex */
public class e extends y.a {
    public Context mContext;
    public View mRoot;
    public TextView mTipView;

    public e(View view, Context context) {
        super(view);
        this.mRoot = view;
        this.mTipView = (TextView) view.findViewById(R.id.view_frs_read_progress);
        this.mContext = context;
    }

    public void a(t tVar) {
        if (tVar != null) {
            this.mTipView.setText(R.string.read_here);
            aQm();
        }
    }

    public void aQm() {
        am.setViewTextColor(this.mTipView, (int) R.color.cp_link_tip_a);
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_e);
    }
}
