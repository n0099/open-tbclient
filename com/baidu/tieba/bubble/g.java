package com.baidu.tieba.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.f {
    private GridView aiD;
    private BubbleChooseActivity ajb;
    private View ajd;
    private f aje;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public g(BubbleChooseActivity bubbleChooseActivity) {
        super(bubbleChooseActivity);
        this.ajb = bubbleChooseActivity;
        bubbleChooseActivity.setContentView(w.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) bubbleChooseActivity.findViewById(v.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(y.bubble_choose);
        this.ajd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.bubble_explain, bubbleChooseActivity);
        this.mRootView = (ViewGroup) bubbleChooseActivity.findViewById(v.container);
        this.aiD = (GridView) bubbleChooseActivity.findViewById(v.gv_bubble_list);
        this.aje = new f(bubbleChooseActivity);
        this.aiD.setAdapter((ListAdapter) this.aje);
        this.mProgressBar = (ProgressBar) bubbleChooseActivity.findViewById(v.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.aje != null) {
            this.aje.bn(z);
            this.aje.setData(list);
        }
    }

    public f yk() {
        return this.aje;
    }

    public View yl() {
        return this.ajd;
    }

    public GridView ym() {
        return this.aiD;
    }

    public BubbleListData.BubbleData dW(int i) {
        if (this.aje == null) {
            return null;
        }
        return this.aje.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.ajb.getLayoutMode().L(i == 1);
        this.ajb.getLayoutMode().h(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
