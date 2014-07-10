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
    private NavigationBar a;
    private ViewGroup b;
    private GridView c;
    private View d;
    private f e;
    private BubbleChooseActivity f;
    private ProgressBar g;

    public g(BubbleChooseActivity bubbleChooseActivity) {
        super(bubbleChooseActivity);
        this.f = bubbleChooseActivity;
        bubbleChooseActivity.setContentView(w.bubble_activity_view);
        this.a = (NavigationBar) bubbleChooseActivity.findViewById(v.lay_title_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(y.bubble_choose);
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.bubble_explain, bubbleChooseActivity);
        this.b = (ViewGroup) bubbleChooseActivity.findViewById(v.container);
        this.c = (GridView) bubbleChooseActivity.findViewById(v.gv_bubble_list);
        this.e = new f(bubbleChooseActivity);
        this.c.setAdapter((ListAdapter) this.e);
        this.g = (ProgressBar) bubbleChooseActivity.findViewById(v.bubble_progress);
    }

    public void a(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.e != null) {
            this.e.a(z);
            this.e.a(list);
        }
    }

    public f a() {
        return this.e;
    }

    public View b() {
        return this.d;
    }

    public GridView c() {
        return this.c;
    }

    public BubbleListData.BubbleData a(int i) {
        if (this.e == null) {
            return null;
        }
        return this.e.getItem(i);
    }

    public void b(int i) {
        this.a.c(i);
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a((View) this.b);
    }

    public void d() {
        this.g.setVisibility(0);
    }

    public void e() {
        this.g.setVisibility(8);
    }
}
