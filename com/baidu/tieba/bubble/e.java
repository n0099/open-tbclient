package com.baidu.tieba.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private NavigationBar a;
    private ViewGroup b;
    private GridView c;
    private View d;
    private d e;
    private BubbleChooseActivity f;
    private ProgressBar g;

    public e(BubbleChooseActivity bubbleChooseActivity) {
        super(bubbleChooseActivity);
        this.f = bubbleChooseActivity;
        bubbleChooseActivity.setContentView(s.bubble_activity_view);
        this.a = (NavigationBar) bubbleChooseActivity.findViewById(r.lay_title_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(u.bubble_choose);
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, s.bubble_explain, bubbleChooseActivity);
        this.b = (ViewGroup) bubbleChooseActivity.findViewById(r.container);
        this.c = (GridView) bubbleChooseActivity.findViewById(r.gv_bubble_list);
        this.e = new d(bubbleChooseActivity);
        this.c.setAdapter((ListAdapter) this.e);
        this.g = (ProgressBar) bubbleChooseActivity.findViewById(r.bubble_progress);
    }

    public void a(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.e != null) {
            this.e.a(z);
            this.e.a(list);
        }
    }

    public d a() {
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
