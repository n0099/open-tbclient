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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SearchView extends LinearLayout {
    private ImageView fHT;
    private View gNJ;
    private TextView gNK;
    private TextView gNL;
    private View gNM;
    private TextView gNN;
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
        sq();
    }

    private void sq() {
        this.gNJ = findViewById(R.id.search_view_title_container);
        this.gNK = (TextView) findViewById(R.id.search_view_title);
        this.gNL = (TextView) findViewById(R.id.search_view_rank);
        this.gNM = findViewById(R.id.search_container);
        this.fHT = (ImageView) findViewById(R.id.search_bar_icon);
        this.gNN = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.gNJ.setVisibility(0);
        this.gNL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void qJ(int i) {
        an.c(this.gNM, l.getDimens(getContext(), R.dimen.tbds100), (int) R.color.cp_bg_line_c, (int) R.color.cp_bg_line_c, i);
        SvgManager.aWQ().a(this.fHT, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        an.setViewTextColor(this.gNK, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.gNL, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.gNN, R.color.cp_cont_d, 1, i);
        an.setBackgroundColor(this, R.color.cp_bg_line_d, i);
    }

    public void u(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.gNM.setOnClickListener(this.mOnClickListener);
        }
    }
}
