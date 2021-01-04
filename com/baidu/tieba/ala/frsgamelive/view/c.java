package com.baidu.tieba.ala.frsgamelive.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.widget.ListView.b {
    private ImageView gYE;
    private TextView gYF;
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
        this.gYF = (TextView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_tip);
        this.gYE = (ImageView) this.mRootView.findViewById(R.id.ala_game_frs_more_live_icon);
        this.mTopLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_top_line);
        this.mBottomLine = this.mRootView.findViewById(R.id.ala_game_frs_more_live_bottom_line);
        vU(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    public void vU(int i) {
        if (this.mRootView != null) {
            ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
        }
        if (this.gYF != null) {
            ao.setViewTextColor(this.gYF, R.color.CAM_X0304);
        }
        if (this.gYE != null) {
            ao.setImageResource(this.gYE, R.drawable.icon_inf_arrowblue_n);
        }
        if (this.mTopLine != null) {
            ao.setBackgroundResource(this.mTopLine, R.color.CAM_X0204);
        }
        if (this.mBottomLine != null) {
            ao.setBackgroundResource(this.mBottomLine, R.color.CAM_X0204);
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
