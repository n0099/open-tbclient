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
    private ImageView fiR;
    private View glX;
    private TextView glY;
    private TextView glZ;
    private View gma;
    private TextView gmb;
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
        rL();
    }

    private void rL() {
        this.glX = findViewById(R.id.search_view_title_container);
        this.glY = (TextView) findViewById(R.id.search_view_title);
        this.glZ = (TextView) findViewById(R.id.search_view_rank);
        this.gma = findViewById(R.id.search_container);
        this.fiR = (ImageView) findViewById(R.id.search_bar_icon);
        this.gmb = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.glX.setVisibility(0);
        this.glZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void pH(int i) {
        am.c(this.gma, l.getDimens(getContext(), R.dimen.tbds100), (int) R.color.cp_bg_line_c, (int) R.color.cp_bg_line_c, i);
        SvgManager.aOR().a(this.fiR, R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        am.setViewTextColor(this.glY, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.glZ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gmb, R.color.cp_cont_d, 1, i);
        am.setBackgroundColor(this, R.color.cp_bg_line_d, i);
    }

    public void u(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.gma.setOnClickListener(this.mOnClickListener);
        }
    }
}
