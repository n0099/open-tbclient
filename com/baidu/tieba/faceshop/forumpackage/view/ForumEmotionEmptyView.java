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
/* loaded from: classes8.dex */
public class ForumEmotionEmptyView extends RelativeLayout {
    private LinearLayout iUH;
    private TextView iUI;
    private ViewGroup iUJ;
    private TextView iUK;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;

    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_empty_layout, this);
        this.iUI = (TextView) findViewById(R.id.forum_emotion_filter);
        this.iUJ = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.iUK = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.iUH = (LinearLayout) findViewById(R.id.forum_emotion_no_data_container);
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.iUH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.d.pu(R.string.invite_friend_no_data_now), null, true);
        this.mNoDataView.setVisibility(0);
    }

    public void onChangeSkin(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
        ao.setViewTextColor(this.iUJ.getChildAt(0), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iUJ.getChildAt(0), R.color.CAM_X0201);
        ao.setViewTextColor(this.iUJ.getChildAt(1), R.color.CAM_X0107);
        ao.setBackgroundColor(this.iUJ.getChildAt(1), R.color.CAM_X0201);
        ao.setViewTextColor(this.iUK, R.color.CAM_X0107);
        ao.setViewTextColor(this.iUI, R.color.CAM_X0107);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public TextView getFilterView() {
        return this.iUI;
    }

    public ViewGroup getFilterDropDownView() {
        return this.iUJ;
    }
}
