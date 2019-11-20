package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SearchView extends LinearLayout {
    private ImageView dJZ;
    private View eIK;
    private TextView eIL;
    private Context mContext;
    private View.OnClickListener mOnClickListener;

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(0);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_search_layout, (ViewGroup) this, true);
        md();
    }

    private void md() {
        this.eIK = findViewById(R.id.search_container);
        this.dJZ = (ImageView) findViewById(R.id.search_bar_icon);
        this.eIL = (TextView) findViewById(R.id.search_text);
    }

    public void mD(int i) {
        am.c(this.eIK, l.getDimens(getContext(), R.dimen.tbds100), (int) R.color.cp_bg_line_c, (int) R.color.cp_bg_line_c, i);
        SvgManager.amL().a(this.dJZ, R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, null);
        am.setViewTextColor(this.eIL, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_top_round, i);
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.eIK.setOnClickListener(this.mOnClickListener);
        }
    }
}
