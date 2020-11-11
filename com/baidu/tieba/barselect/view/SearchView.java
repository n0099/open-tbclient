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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class SearchView extends LinearLayout {
    private ImageView gEO;
    private View hUA;
    private TextView hUB;
    private TextView hUC;
    private View hUD;
    private TextView hUE;
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
        setOrientation(1);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_search_layout, (ViewGroup) this, true);
        ul();
    }

    private void ul() {
        this.hUA = findViewById(R.id.search_view_title_container);
        this.hUB = (TextView) findViewById(R.id.search_view_title);
        this.hUC = (TextView) findViewById(R.id.search_view_rank);
        this.hUD = findViewById(R.id.search_container);
        this.gEO = (ImageView) findViewById(R.id.search_bar_icon);
        this.hUE = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.hUA.setVisibility(0);
        this.hUC.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void uE(int i) {
        ap.c(this.hUD, l.getDimens(getContext(), R.dimen.tbds100), R.color.cp_bg_line_c, R.color.cp_bg_line_c, i);
        SvgManager.brn().a(this.gEO, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.hUB, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hUC, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hUE, R.color.cp_cont_d, 1, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d, i);
    }

    public void v(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.hUD.setOnClickListener(this.mOnClickListener);
        }
    }
}
