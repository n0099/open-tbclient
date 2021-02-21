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
    private View iVX;
    private boolean isShow = false;
    private Animation kyM;
    private Animation kyN;
    private ViewGroup kyR;
    private a kyS;
    private b kyT;
    private View rootView;
    private int topHeight;

    /* loaded from: classes8.dex */
    public interface a {
        void cTG();
    }

    public c(ViewGroup viewGroup) {
        this.kyR = viewGroup;
    }

    public void a(a aVar) {
        this.kyS = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<p> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.kyR.addView(this.rootView);
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
        this.iVX = inflate.findViewById(R.id.topic_more_top_view);
        CC(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.kyT = new b(context, i);
        this.kyT.setTagList(list);
        gridView.setAdapter((ListAdapter) this.kyT);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW, c.this.kyT.getItem(i2)));
                c.this.gn(context);
            }
        });
        return inflate;
    }

    public void CC(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iVX.getLayoutParams();
        layoutParams.height = i;
        this.iVX.setLayoutParams(layoutParams);
    }

    private Animation go(Context context) {
        if (this.kyM == null) {
            this.kyM = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.kyM;
    }

    private Animation gp(Context context) {
        if (this.kyN == null) {
            this.kyN = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.kyN.setAnimationListener(new d() { // from class: com.baidu.tieba.hottopic.view.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.kyS != null) {
                    c.this.kyS.cTG();
                }
                c.this.kyR.removeView(c.this.rootView);
            }
        });
        return this.kyN;
    }

    public void CD(int i) {
        this.topHeight = i;
    }
}
