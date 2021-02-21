package com.baidu.tieba.faceshop.forumpackage.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ForumEmotionEmptyView extends RelativeLayout {
    private LinearLayout jaC;
    private TextView jaD;
    private ViewGroup jaE;
    private TextView jaF;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;

    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_empty_layout, this);
        this.jaD = (TextView) findViewById(R.id.forum_emotion_filter);
        this.jaE = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.jaF = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.jaC = (LinearLayout) findViewById(R.id.forum_emotion_no_data_container);
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.jaC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.d.pz(R.string.invite_friend_no_data_now), null, true);
        this.mNoDataView.setVisibility(0);
    }

    public void onChangeSkin(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
        ap.setViewTextColor(this.jaE.getChildAt(0), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jaE.getChildAt(0), R.color.CAM_X0201);
        ap.setViewTextColor(this.jaE.getChildAt(1), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jaE.getChildAt(1), R.color.CAM_X0201);
        ap.setViewTextColor(this.jaF, R.color.CAM_X0107);
        ap.setViewTextColor(this.jaD, R.color.CAM_X0107);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public TextView getFilterView() {
        return this.jaD;
    }

    public ViewGroup getFilterDropDownView() {
        return this.jaE;
    }
}
