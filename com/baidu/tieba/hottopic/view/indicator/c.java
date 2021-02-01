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
/* loaded from: classes8.dex */
public class c {
    private View iVJ;
    private boolean isShow = false;
    private ViewGroup kyD;
    private a kyE;
    private b kyF;
    private Animation kyy;
    private Animation kyz;
    private View rootView;
    private int topHeight;

    /* loaded from: classes8.dex */
    public interface a {
        void cTz();
    }

    public c(ViewGroup viewGroup) {
        this.kyD = viewGroup;
    }

    public void a(a aVar) {
        this.kyE = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<p> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.kyD.addView(this.rootView);
            if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background_1));
            } else {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background));
            }
            this.rootView.startAnimation(go(context));
        }
    }

    public void gn(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(gp(context));
        }
    }

    private View b(final Context context, List<p> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.iVJ = inflate.findViewById(R.id.topic_more_top_view);
        CC(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.kyF = new b(context, i);
        this.kyF.setTagList(list);
        gridView.setAdapter((ListAdapter) this.kyF);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW, c.this.kyF.getItem(i2)));
                c.this.gn(context);
            }
        });
        return inflate;
    }

    public void CC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iVJ.getLayoutParams();
        layoutParams.height = i;
        this.iVJ.setLayoutParams(layoutParams);
    }

    private Animation go(Context context) {
        if (this.kyy == null) {
            this.kyy = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.kyy;
    }

    private Animation gp(Context context) {
        if (this.kyz == null) {
            this.kyz = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.kyz.setAnimationListener(new d() { // from class: com.baidu.tieba.hottopic.view.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.kyE != null) {
                    c.this.kyE.cTz();
                }
                c.this.kyD.removeView(c.this.rootView);
            }
        });
        return this.kyz;
    }

    public void CD(int i) {
        this.topHeight = i;
    }
}
