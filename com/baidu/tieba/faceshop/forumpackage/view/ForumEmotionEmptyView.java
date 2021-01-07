package com.baidu.tieba.faceshop.forumpackage.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ForumEmotionEmptyView extends RelativeLayout {
    private LinearLayout iZo;
    private TextView iZp;
    private ViewGroup iZq;
    private TextView iZr;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;

    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_empty_layout, this);
        this.iZp = (TextView) findViewById(R.id.forum_emotion_filter);
        this.iZq = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.iZr = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.iZo = (LinearLayout) findViewById(R.id.forum_emotion_no_data_container);
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.iZo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.d.ra(R.string.invite_friend_no_data_now), null, true);
        this.mNoDataView.setVisibility(0);
    }

    public void onChangeSkin(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
        ao.setViewTextColor(this.iZq.getChildAt(0), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iZq.getChildAt(0), R.color.CAM_X0201);
        ao.setViewTextColor(this.iZq.getChildAt(1), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iZq.getChildAt(1), R.color.CAM_X0201);
        ao.setViewTextColor(this.iZr, R.color.CAM_X0107);
        ao.setViewTextColor(this.iZp, R.color.CAM_X0107);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public TextView getFilterView() {
        return this.iZp;
    }

    public ViewGroup getFilterDropDownView() {
        return this.iZq;
    }
}
