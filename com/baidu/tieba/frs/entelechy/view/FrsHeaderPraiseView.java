package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    private View cin;
    private View cio;
    private TextView cip;
    private FrameLayout ciq;
    private ImageView cir;

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(w.j.frs_header_extra_praise_layout, this);
        initView();
    }

    private void initView() {
        this.cin = findViewById(w.h.divider_top);
        this.cio = findViewById(w.h.divider_bottom);
        this.cip = (TextView) findViewById(w.h.frs_praise_title);
        this.ciq = (FrameLayout) findViewById(w.h.frs_praise_portrait);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.util.as.j(this, w.g.home_thread_card_item_bg);
        com.baidu.tbadk.core.util.as.k(this.cin, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(this.cio, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.i(this.cip, w.e.cp_cont_b);
        com.baidu.tbadk.core.util.as.c(this.cir, w.g.icon_find_more_heibai);
    }

    public void setData(AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cip.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.ciq.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.ciq.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds40), getResources().getDimensionPixelSize(w.f.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultErrorResource(w.g.icon_default_avatar100);
                headImageView.setDefaultBgResource(w.e.cp_bg_line_e);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_bg_line_d));
                headImageView.setBorderWidth(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds2));
                headImageView.c(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(w.f.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(w.f.ds8));
                }
                layoutParams.gravity = 5;
                this.ciq.addView(headImageView, layoutParams);
            }
        }
        setOnClickListener(new bb(this, agreeBanner));
    }
}
