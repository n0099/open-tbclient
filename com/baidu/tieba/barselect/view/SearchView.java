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
    private ImageView gNs;
    private View ifX;
    private TextView ifY;
    private TextView ifZ;
    private View iga;
    private TextView igb;
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
        uo();
    }

    private void uo() {
        this.ifX = findViewById(R.id.search_view_title_container);
        this.ifY = (TextView) findViewById(R.id.search_view_title);
        this.ifZ = (TextView) findViewById(R.id.search_view_rank);
        this.iga = findViewById(R.id.search_container);
        this.gNs = (ImageView) findViewById(R.id.search_bar_icon);
        this.igb = (TextView) findViewById(R.id.search_text);
    }

    public void setRank(int i) {
        this.ifX.setVisibility(0);
        this.ifZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i)));
    }

    public void vJ(int i) {
        ap.c(this.iga, l.getDimens(getContext(), R.dimen.tbds100), R.color.CAM_X0204, R.color.CAM_X0204, i);
        SvgManager.btW().a(this.gNs, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, (SvgManager.SvgResourceStateType) null);
        ap.setViewTextColor(this.ifY, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.ifZ, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.igb, R.color.CAM_X0109, 1, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201, i);
    }

    public void v(View.OnClickListener onClickListener) {
        if (this.mOnClickListener == null) {
            this.mOnClickListener = onClickListener;
            this.iga.setOnClickListener(this.mOnClickListener);
        }
    }
}
