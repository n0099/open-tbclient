package com.baidu.tieba.ala.frsgamelive.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class i extends com.baidu.adp.widget.ListView.c {
    private ImageView gyA;
    private TextView gyB;
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
        this.gyB = (TextView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_tip);
        this.gyA = (ImageView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_icon);
        this.mTopLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.mBottomLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        uu(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void uu(int i) {
        if (this.mRootView != null) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
        }
        if (this.gyB != null) {
            ap.setViewTextColor(this.gyB, R.color.cp_link_tip_c);
        }
        if (this.gyA != null) {
            ap.setImageResource(this.gyA, R.drawable.icon_inf_arrowblue_n);
        }
        if (this.mTopLine != null) {
            ap.setBackgroundResource(this.mTopLine, R.color.cp_bg_line_c);
        }
        if (this.mBottomLine != null) {
            ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_c);
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
