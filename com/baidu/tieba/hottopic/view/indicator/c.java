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
/* loaded from: classes21.dex */
public class c {
    private boolean isShow = false;
    private View iwP;
    private ViewGroup jTA;
    private a jTB;
    private b jTC;
    private Animation jTu;
    private Animation jTv;
    private View rootView;
    private int topHeight;

    /* loaded from: classes21.dex */
    public interface a {
        void cNq();
    }

    public c(ViewGroup viewGroup) {
        this.jTA = viewGroup;
    }

    public void a(a aVar) {
        this.jTB = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<p> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.jTA.addView(this.rootView);
            if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background_1));
            } else {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background));
            }
            this.rootView.startAnimation(fr(context));
        }
    }

    public void fq(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(fs(context));
        }
    }

    private View b(final Context context, List<p> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.iwP = inflate.findViewById(R.id.topic_more_top_view);
        Cq(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.jTC = new b(context, i);
        this.jTC.setTagList(list);
        gridView.setAdapter((ListAdapter) this.jTC);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW, c.this.jTC.getItem(i2)));
                c.this.fq(context);
            }
        });
        return inflate;
    }

    public void Cq(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwP.getLayoutParams();
        layoutParams.height = i;
        this.iwP.setLayoutParams(layoutParams);
    }

    private Animation fr(Context context) {
        if (this.jTu == null) {
            this.jTu = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.jTu;
    }

    private Animation fs(Context context) {
        if (this.jTv == null) {
            this.jTv = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.jTv.setAnimationListener(new d() { // from class: com.baidu.tieba.hottopic.view.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.jTB != null) {
                    c.this.jTB.cNq();
                }
                c.this.jTA.removeView(c.this.rootView);
            }
        });
        return this.jTv;
    }

    public void Cr(int i) {
        this.topHeight = i;
    }
}
