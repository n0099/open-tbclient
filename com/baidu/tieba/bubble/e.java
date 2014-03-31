package com.baidu.tieba.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.a.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.a.h;
import com.baidu.tieba.a.i;
import com.baidu.tieba.a.k;
import com.baidu.tieba.data.BubbleListData;
import java.util.List;
/* loaded from: classes.dex */
public final class e extends f {
    private NavigationBar a;
    private ViewGroup c;
    private GridView d;
    private View e;
    private d f;
    private BubbleChooseActivity g;
    private ProgressBar h;

    public e(BubbleChooseActivity bubbleChooseActivity) {
        super(bubbleChooseActivity);
        this.g = bubbleChooseActivity;
        bubbleChooseActivity.setContentView(i.bubble_activity_view);
        this.a = (NavigationBar) bubbleChooseActivity.findViewById(h.lay_title_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(k.bubble_choose);
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.bubble_explain, bubbleChooseActivity);
        this.c = (ViewGroup) bubbleChooseActivity.findViewById(h.container);
        this.d = (GridView) bubbleChooseActivity.findViewById(h.gv_bubble_list);
        this.f = new d(bubbleChooseActivity);
        this.d.setAdapter((ListAdapter) this.f);
        this.h = (ProgressBar) bubbleChooseActivity.findViewById(h.bubble_progress);
    }

    public final void a(List<BubbleListData.BubbleData> list, boolean z) {
        if (this.f != null) {
            this.f.a(z);
            this.f.a(list);
        }
    }

    public final d a() {
        return this.f;
    }

    public final View d() {
        return this.e;
    }

    public final GridView e() {
        return this.d;
    }

    public final BubbleListData.BubbleData a(int i) {
        if (this.f == null) {
            return null;
        }
        return this.f.getItem(i);
    }

    public final void b(int i) {
        this.a.b(i);
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.c);
    }

    public final void f() {
        this.h.setVisibility(0);
    }

    public final void g() {
        this.h.setVisibility(8);
    }
}
