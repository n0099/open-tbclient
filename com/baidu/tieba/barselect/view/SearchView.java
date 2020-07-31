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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class SearchView extends LinearLayout {
    private ImageView fNo;
    private View gTp;
    private TextView gTq;
    private TextView gTr;
    private View gTs;
    private TextView gTt;
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
        ss();
    }

    private void ss() {
        this.gTp = findViewById(R.id.search_view_title_container);
        this.gTq = (TextView) findViewById(R.id.search_view_title);
        this.gTr = (TextView) findViewById(R.id.search_view_rank);
        this.gTs = findViewById(R.id.search_container);
        this.fNo = (ImageView) findViewById(R.id.search_bar_icon);
        this.gTt = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.gTp.setVisibility(0);
        this.gTr.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void qZ(int i) {
        ao.c(this.gTs, l.getDimens(getContext(), R.dimen.tbds100), R.color.cp_bg_line_c, R.color.cp_bg_line_c, i);
        SvgManager.baR().a(this.fNo, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.gTq, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.gTr, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.gTt, R.color.cp_cont_d, 1, i);
        ao.setBackgroundColor(this, R.color.cp_bg_line_d, i);
    }

    public void u(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.gTs.setOnClickListener(this.mOnClickListener);
        }
    }
}
