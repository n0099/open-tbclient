package com.baidu.tieba.ala.frsgamelive.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.b {
    private ImageView gYF;
    private TextView gYG;
    private View mBottomLine;
    private View.OnClickListener mClickListener;
    private Context mContext;
    private View mRootView;
    private View mTopLine;

    public c(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
        this.gYG = (TextView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_tip);
        this.gYF = (ImageView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_icon);
        this.mTopLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.mBottomLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        uw(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void uw(int i) {
        if (this.mRootView != null) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
        }
        if (this.gYG != null) {
            ap.setViewTextColor(this.gYG, R.color.CAM_X0304);
        }
        if (this.gYF != null) {
            ap.setImageResource(this.gYF, R.drawable.icon_inf_arrowblue_n);
        }
        if (this.mTopLine != null) {
            ap.setBackgroundResource(this.mTopLine, R.color.CAM_X0204);
        }
        if (this.mBottomLine != null) {
            ap.setBackgroundResource(this.mBottomLine, R.color.CAM_X0204);
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
