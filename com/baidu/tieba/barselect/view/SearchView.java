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
/* loaded from: classes7.dex */
public class SearchView extends LinearLayout {
    private ImageView gUy;
    private View inN;
    private TextView inO;
    private TextView inP;
    private View inQ;
    private TextView inR;
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
        tC();
    }

    private void tC() {
        this.inN = findViewById(R.id.search_view_title_container);
        this.inO = (TextView) findViewById(R.id.search_view_title);
        this.inP = (TextView) findViewById(R.id.search_view_rank);
        this.inQ = findViewById(R.id.search_container);
        this.gUy = (ImageView) findViewById(R.id.search_bar_icon);
        this.inR = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.inN.setVisibility(0);
        this.inP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void uo(int i) {
        ao.e(this.inQ, l.getDimens(getContext(), R.dimen.tbds100), R.color.CAM_X0204, R.color.CAM_X0204, i);
        SvgManager.bsx().a(this.gUy, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ao.setViewTextColor(this.inO, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.inP, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.inR, R.color.CAM_X0109, 1, i);
        ao.setBackgroundColor(this, R.color.CAM_X0201, i);
    }

    public void w(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.inQ.setOnClickListener(this.mOnClickListener);
        }
    }
}
