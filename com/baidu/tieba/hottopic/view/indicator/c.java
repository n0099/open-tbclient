package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.p;
import java.util.List;
/* loaded from: classes20.dex */
public class c {
    private View hPv;
    private boolean isShow = false;
    private Animation jma;
    private Animation jmb;
    private ViewGroup jmg;
    private a jmh;
    private b jmi;
    private View rootView;
    private int topHeight;

    /* loaded from: classes20.dex */
    public interface a {
        void cDZ();
    }

    public c(ViewGroup viewGroup) {
        this.jmg = viewGroup;
    }

    public void a(a aVar) {
        this.jmh = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<p> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.jmg.addView(this.rootView);
            if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background_1));
            } else {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background));
            }
            this.rootView.startAnimation(fj(context));
        }
    }

    public void fi(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(fk(context));
        }
    }

    private View b(final Context context, List<p> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.hPv = inflate.findViewById(R.id.topic_more_top_view);
        Be(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.jmi = new b(context, i);
        this.jmi.setTagList(list);
        gridView.setAdapter((ListAdapter) this.jmi);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW, c.this.jmi.getItem(i2)));
                c.this.fi(context);
            }
        });
        return inflate;
    }

    public void Be(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPv.getLayoutParams();
        layoutParams.height = i;
        this.hPv.setLayoutParams(layoutParams);
    }

    private Animation fj(Context context) {
        if (this.jma == null) {
            this.jma = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.jma;
    }

    private Animation fk(Context context) {
        if (this.jmb == null) {
            this.jmb = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.jmb.setAnimationListener(new d() { // from class: com.baidu.tieba.hottopic.view.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.jmh != null) {
                    c.this.jmh.cDZ();
                }
                c.this.jmg.removeView(c.this.rootView);
            }
        });
        return this.jmb;
    }

    public void Bf(int i) {
        this.topHeight = i;
    }
}
