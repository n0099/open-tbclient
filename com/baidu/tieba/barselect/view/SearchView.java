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
/* loaded from: classes8.dex */
public class SearchView extends LinearLayout {
    private ImageView gZe;
    private View isu;
    private TextView isv;
    private TextView isw;
    private View isx;
    private TextView isy;
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
        tN();
    }

    private void tN() {
        this.isu = findViewById(R.id.search_view_title_container);
        this.isv = (TextView) findViewById(R.id.search_view_title);
        this.isw = (TextView) findViewById(R.id.search_view_rank);
        this.isx = findViewById(R.id.search_container);
        this.gZe = (ImageView) findViewById(R.id.search_bar_icon);
        this.isy = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.isu.setVisibility(0);
        this.isw.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void vU(int i) {
        ao.e(this.isx, l.getDimens(getContext(), R.dimen.tbds100), R.color.CAM_X0204, R.color.CAM_X0204, i);
        SvgManager.bwr().a(this.gZe, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.isv, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.isw, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.isy, R.color.CAM_X0109, 1, i);
        ao.setBackgroundColor(this, R.color.CAM_X0201, i);
    }

    public void w(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.isx.setOnClickListener(this.mOnClickListener);
        }
    }
}
