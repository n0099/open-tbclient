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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SearchView extends LinearLayout {
    private ImageView dDS;
    private View ezd;
    private TextView eze;
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
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_search_layout, (ViewGroup) this, true);
        qX();
    }

    private void qX() {
        this.ezd = findViewById(R.id.search_container);
        this.dDS = (ImageView) findViewById(R.id.search_bar_icon);
        this.eze = (TextView) findViewById(R.id.search_text);
    }

    public void nz(int i) {
        am.b(this.ezd, l.g(getContext(), R.dimen.tbds100), (int) R.color.cp_bg_line_c, (int) R.color.cp_bg_line_c, i);
        am.b(this.dDS, (int) R.drawable.icon_bazhu_search_n, i);
        am.d(this.eze, R.color.cp_cont_d, 1, i);
        am.g(this, R.drawable.bar_select_bg_top_round, i);
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.ezd.setOnClickListener(this.mOnClickListener);
        }
    }
}
