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
/* loaded from: classes8.dex */
public class ForumEmotionEmptyView extends RelativeLayout {
    private LinearLayout jcl;
    private TextView jcm;
    private ViewGroup jcn;
    private TextView jco;
    private NoDataView mNoDataView;
    private TbPageContext mPageContext;

    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_empty_layout, this);
        this.jcm = (TextView) findViewById(R.id.forum_emotion_filter);
        this.jcn = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.jco = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.jcl = (LinearLayout) findViewById(R.id.forum_emotion_no_data_container);
        this.mNoDataView = NoDataViewFactory.a(this.mPageContext.getPageActivity(), this.jcl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.d.pA(R.string.invite_friend_no_data_now), null, true);
        this.mNoDataView.setVisibility(0);
    }

    public void onChangeSkin(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mPageContext, i);
        }
        ap.setViewTextColor(this.jcn.getChildAt(0), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jcn.getChildAt(0), R.color.CAM_X0201);
        ap.setViewTextColor(this.jcn.getChildAt(1), R.color.CAM_X0107);
        ap.setBackgroundColor(this.jcn.getChildAt(1), R.color.CAM_X0201);
        ap.setViewTextColor(this.jco, R.color.CAM_X0107);
        ap.setViewTextColor(this.jcm, R.color.CAM_X0107);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public TextView getFilterView() {
        return this.jcm;
    }

    public ViewGroup getFilterDropDownView() {
        return this.jcn;
    }
}
