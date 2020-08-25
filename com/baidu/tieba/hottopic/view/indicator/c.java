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
/* loaded from: classes15.dex */
public class c {
    private View hIo;
    private boolean isShow = false;
    private Animation jdo;
    private Animation jdp;
    private ViewGroup jdu;
    private a jdv;
    private b jdw;
    private View rootView;
    private int topHeight;

    /* loaded from: classes15.dex */
    public interface a {
        void cAr();
    }

    public c(ViewGroup viewGroup) {
        this.jdu = viewGroup;
    }

    public void a(a aVar) {
        this.jdv = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<p> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.jdu.addView(this.rootView);
            if (1 == TbadkCoreApplication.getInst().getSkinType() || 4 == TbadkCoreApplication.getInst().getSkinType()) {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background_1));
            } else {
                this.rootView.setBackgroundColor(this.rootView.getContext().getResources().getColor(R.color.topic_more_background));
            }
            this.rootView.startAnimation(fd(context));
        }
    }

    public void fc(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(fe(context));
        }
    }

    private View b(final Context context, List<p> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.hIo = inflate.findViewById(R.id.topic_more_top_view);
        AD(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.jdw = new b(context, i);
        this.jdw.setTagList(list);
        gridView.setAdapter((ListAdapter) this.jdw);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TOPIC_SWITCH_TAB_FROM_POP_WINDOW, c.this.jdw.getItem(i2)));
                c.this.fc(context);
            }
        });
        return inflate;
    }

    public void AD(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hIo.getLayoutParams();
        layoutParams.height = i;
        this.hIo.setLayoutParams(layoutParams);
    }

    private Animation fd(Context context) {
        if (this.jdo == null) {
            this.jdo = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.jdo;
    }

    private Animation fe(Context context) {
        if (this.jdp == null) {
            this.jdp = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.jdp.setAnimationListener(new d() { // from class: com.baidu.tieba.hottopic.view.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.jdv != null) {
                    c.this.jdv.cAr();
                }
                c.this.jdu.removeView(c.this.rootView);
            }
        });
        return this.jdp;
    }

    public void AE(int i) {
        this.topHeight = i;
    }
}
