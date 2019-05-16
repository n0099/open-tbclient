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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class SearchView extends LinearLayout {
    private ImageView dAx;
    private View eud;
    private TextView eue;
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
        qA();
    }

    private void qA() {
        this.eud = findViewById(R.id.search_container);
        this.dAx = (ImageView) findViewById(R.id.search_bar_icon);
        this.eue = (TextView) findViewById(R.id.search_text);
    }

    public void nq(int i) {
        al.b(this.eud, l.g(getContext(), R.dimen.tbds100), (int) R.color.cp_bg_line_c, (int) R.color.cp_bg_line_c, i);
        al.b(this.dAx, (int) R.drawable.icon_bazhu_search_n, i);
        al.c(this.eue, R.color.cp_cont_d, 1, i);
        al.g(this, R.drawable.bar_select_bg_top_round, i);
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.eud.setOnClickListener(this.mOnClickListener);
        }
    }
}
