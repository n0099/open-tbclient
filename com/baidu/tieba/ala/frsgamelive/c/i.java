package com.baidu.tieba.ala.frsgamelive.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.widget.ListView.b {
    private ImageView exN;
    private TextView exO;
    private View mBottomLine;
    private View.OnClickListener mClickListener;
    private Context mContext;
    private View mRootView;
    private View mTopLine;

    public i(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
        this.exO = (TextView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_tip);
        this.exN = (ImageView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_icon);
        this.mTopLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.mBottomLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        oT(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void oT(int i) {
        if (this.mRootView != null) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
        }
        if (this.exO != null) {
            am.setViewTextColor(this.exO, (int) R.color.cp_link_tip_c);
        }
        if (this.exN != null) {
            am.setImageResource(this.exN, R.drawable.icon_inf_arrowblue_n);
        }
        if (this.mTopLine != null) {
            am.setBackgroundResource(this.mTopLine, R.color.cp_bg_line_c);
        }
        if (this.mBottomLine != null) {
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_c);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mClickListener != null && this.mRootView != null) {
            this.mClickListener.onClick(this.mRootView);
        }
    }
}
