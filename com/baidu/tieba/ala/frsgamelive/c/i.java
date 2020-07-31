package com.baidu.tieba.ala.frsgamelive.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class i extends com.baidu.adp.widget.ListView.c {
    private ImageView fMO;
    private TextView fMP;
    private View mBottomLine;
    private View.OnClickListener mClickListener;
    private Context mContext;
    private View mRootView;
    private View mTopLine;

    public i(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
        this.fMP = (TextView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_tip);
        this.fMO = (ImageView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_icon);
        this.mTopLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.mBottomLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        qZ(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void qZ(int i) {
        if (this.mRootView != null) {
            ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
        }
        if (this.fMP != null) {
            ao.setViewTextColor(this.fMP, R.color.cp_link_tip_c);
        }
        if (this.fMO != null) {
            ao.setImageResource(this.fMO, R.drawable.icon_inf_arrowblue_n);
        }
        if (this.mTopLine != null) {
            ao.setBackgroundResource(this.mTopLine, R.color.cp_bg_line_c);
        }
        if (this.mBottomLine != null) {
            ao.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_c);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mClickListener != null && this.mRootView != null) {
            this.mClickListener.onClick(this.mRootView);
        }
    }
}
