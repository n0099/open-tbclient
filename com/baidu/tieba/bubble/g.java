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
    private GridView aiM;
    private BubbleChooseActivity ajk;
    private View ajm;
    private f ajn;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ViewGroup mRootView;

    public g(BubbleChooseActivity bubbleChooseActivity) {
        super(bubbleChooseActivity);
        this.ajk = bubbleChooseActivity;
        bubbleChooseActivity.setContentView(w.bubble_activity_view);
        this.mNavigationBar = (NavigationBar) bubbleChooseActivity.findViewById(v.lay_title_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(y.bubble_choose);
        this.ajm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.bubble_explain, bubbleChooseActivity);
        this.mRootView = (ViewGroup) bubbleChooseActivity.findViewById(v.container);
        this.aiM = (GridView) bubbleChooseActivity.findViewById(v.gv_bubble_list);
        this.ajn = new f(bubbleChooseActivity);
        this.aiM.setAdapter((ListAdapter) this.ajn);
        this.mProgressBar = (ProgressBar) bubbleChooseActivity.findViewById(v.bubble_progress);
    }

    public void setData(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.ajn != null) {
            this.ajn.bn(z);
            this.ajn.setData(list);
        }
    }

    public f ym() {
        return this.ajn;
    }

    public View yn() {
        return this.ajm;
    }

    public GridView yo() {
        return this.aiM;
    }

    public BubbleListData.BubbleData dW(int i) {
        if (this.ajn == null) {
            return null;
        }
        return this.ajn.getItem(i);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        this.ajk.getLayoutMode().L(i == 1);
        this.ajk.getLayoutMode().h(this.mRootView);
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }
}
