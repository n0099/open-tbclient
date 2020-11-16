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
/* loaded from: classes20.dex */
public class SearchView extends LinearLayout {
    private ImageView gEv;
    private View hVa;
    private TextView hVb;
    private TextView hVc;
    private View hVd;
    private TextView hVe;
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
        this.hVa = findViewById(R.id.search_view_title_container);
        this.hVb = (TextView) findViewById(R.id.search_view_title);
        this.hVc = (TextView) findViewById(R.id.search_view_rank);
        this.hVd = findViewById(R.id.search_container);
        this.gEv = (ImageView) findViewById(R.id.search_bar_icon);
        this.hVe = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.hVa.setVisibility(0);
        this.hVc.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void vc(int i) {
        ap.c(this.hVd, l.getDimens(getContext(), R.dimen.tbds100), R.color.CAM_X0204, R.color.CAM_X0204, i);
        SvgManager.bqB().a(this.gEv, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.hVb, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.hVc, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.hVe, R.color.CAM_X0109, 1, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201, i);
    }

    public void v(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.hVd.setOnClickListener(this.mOnClickListener);
        }
    }
}
