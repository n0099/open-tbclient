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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SearchView extends LinearLayout {
    private ImageView fwy;
    private View gAN;
    private TextView gAO;
    private TextView gAP;
    private View gAQ;
    private TextView gAR;
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
        rV();
    }

    private void rV() {
        this.gAN = findViewById(R.id.search_view_title_container);
        this.gAO = (TextView) findViewById(R.id.search_view_title);
        this.gAP = (TextView) findViewById(R.id.search_view_rank);
        this.gAQ = findViewById(R.id.search_container);
        this.fwy = (ImageView) findViewById(R.id.search_bar_icon);
        this.gAR = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.gAN.setVisibility(0);
        this.gAP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void qi(int i) {
        am.c(this.gAQ, l.getDimens(getContext(), R.dimen.tbds100), (int) R.color.cp_bg_line_c, (int) R.color.cp_bg_line_c, i);
        SvgManager.aUV().a(this.fwy, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.gAO, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gAP, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gAR, R.color.cp_cont_d, 1, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
    }

    public void t(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.gAQ.setOnClickListener(this.mOnClickListener);
        }
    }
}
