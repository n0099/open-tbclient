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
/* loaded from: classes8.dex */
public class SearchView extends LinearLayout {
    private ImageView gXw;
    private View itF;
    private TextView itG;
    private TextView itH;
    private View itI;
    private TextView itJ;
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
        tz();
    }

    private void tz() {
        this.itF = findViewById(R.id.search_view_title_container);
        this.itG = (TextView) findViewById(R.id.search_view_title);
        this.itH = (TextView) findViewById(R.id.search_view_rank);
        this.itI = findViewById(R.id.search_container);
        this.gXw = (ImageView) findViewById(R.id.search_bar_icon);
        this.itJ = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.itF.setVisibility(0);
        this.itH.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void uu(int i) {
        ap.e(this.itI, l.getDimens(getContext(), R.dimen.tbds100), R.color.CAM_X0204, R.color.CAM_X0204, i);
        SvgManager.bsR().a(this.gXw, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.itG, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.itH, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.itJ, R.color.CAM_X0109, 1, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201, i);
    }

    public void w(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.itI.setOnClickListener(this.mOnClickListener);
        }
    }
}
