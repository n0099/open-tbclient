package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.t.ao;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {
    private View.OnClickListener bVj;
    CustomMessageListener eWf;
    View.OnClickListener fSx;
    private ImageView gad;
    private TextView gae;
    private View view;

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.gad == view) {
                    if (NestedScrollHeader.this.bVj != null) {
                        NestedScrollHeader.this.bVj.onClick(view);
                    }
                    NestedScrollHeader.this.btt();
                    com.baidu.tbadk.browser.a.af(NestedScrollHeader.this.getContext(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                } else if (NestedScrollHeader.this.gae == view) {
                    TiebaStatic.log(new am("c10378").P("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.eWf = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.gad = (ImageView) findViewById(R.id.task);
        this.gad.setOnClickListener(this.fSx);
        this.gae = (TextView) findViewById(R.id.search);
        this.gae.setOnClickListener(this.fSx);
        this.view = findViewById(R.id.view);
        onChangeSkinType();
        if (ao.iE()) {
            this.gad.setVisibility(0);
        } else {
            this.gad.setVisibility(8);
        }
        MessageManager.getInstance().registerListener(this.eWf);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVj = onClickListener;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gae.setText(str);
        }
    }

    public void aF(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.gad.getVisibility() == 0 && this.gad.getAlpha() != f) {
                this.gad.setAlpha(f);
            }
            if (this.gae.getAlpha() != f) {
                this.gae.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        al.l(this, R.color.cp_bg_line_d);
        al.j(this.gae, R.color.cp_cont_d);
        al.k(this.gae, R.drawable.task_scroll_search_bg);
        al.l(this.view, R.color.cp_bg_line_d);
        this.gae.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_home_search_n), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.gad, (int) R.drawable.btn_home_task_n);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eWf);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eWf);
    }

    public ImageView getTaskView() {
        return this.gad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btt() {
        am amVar = new am("c13422");
        amVar.P("obj_type", 2);
        amVar.P("obj_locate", 1);
        TiebaStatic.log(amVar);
    }
}
