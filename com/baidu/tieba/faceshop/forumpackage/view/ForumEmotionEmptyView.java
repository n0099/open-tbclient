package com.baidu.tieba.faceshop.forumpackage.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ForumEmotionEmptyView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15857e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f15858f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f15859g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15860h;
    public ViewGroup i;
    public TextView j;

    public ForumEmotionEmptyView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f15857e = tbPageContext;
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.forum_emotion_empty_layout, this);
        this.f15860h = (TextView) findViewById(R.id.forum_emotion_filter);
        this.i = (ViewGroup) findViewById(R.id.forum_emotion_filter_dropdown);
        this.j = (TextView) findViewById(R.id.forum_emotion_board_title);
        this.f15859g = (LinearLayout) findViewById(R.id.forum_emotion_no_data_container);
        NoDataView b2 = NoDataViewFactory.b(this.f15857e.getPageActivity(), this.f15859g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, 0), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, true);
        this.f15858f = b2;
        b2.setVisibility(0);
    }

    public void b(int i) {
        NoDataView noDataView = this.f15858f;
        if (noDataView != null) {
            noDataView.f(this.f15857e, i);
        }
        SkinManager.setViewTextColor(this.i.getChildAt(0), R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.i.getChildAt(0), R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.i.getChildAt(1), R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this.i.getChildAt(1), R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f15860h, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
    }

    public ViewGroup getFilterDropDownView() {
        return this.i;
    }

    public TextView getFilterView() {
        return this.f15860h;
    }
}
