package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    private View coj;
    private View cok;
    private TextView col;

    /* renamed from: com  reason: collision with root package name */
    private FrameLayout f1com;
    private ImageView con;

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(d.j.frs_header_extra_praise_layout, this);
        initView();
    }

    private void initView() {
        this.coj = findViewById(d.h.divider_top);
        this.cok = findViewById(d.h.divider_bottom);
        this.col = (TextView) findViewById(d.h.frs_praise_title);
        this.f1com = (FrameLayout) findViewById(d.h.frs_praise_portrait);
        this.con = (ImageView) findViewById(d.h.frs_praise_more);
        ai.c(this.con, d.g.icon_arrow_more_gray_n);
    }

    public void changeSkinType(int i) {
        ai.j(this, d.g.home_thread_card_item_bg);
        ai.k(this.coj, d.e.cp_bg_line_c);
        ai.k(this.cok, d.e.cp_bg_line_c);
        ai.i(this.col, d.e.cp_cont_b);
        ai.c(this.con, d.g.icon_arrow_more_gray_n);
    }

    public void setData(final AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.col.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.f1com.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.f1com.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds40), getResources().getDimensionPixelSize(d.f.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultErrorResource(d.g.icon_default_avatar100);
                headImageView.setDefaultBgResource(d.e.cp_bg_line_e);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(ai.getColor(d.e.cp_bg_line_d));
                headImageView.setBorderWidth(com.baidu.adp.lib.util.k.g(getContext(), d.f.ds2));
                headImageView.c(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(d.f.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(d.f.ds8));
                }
                layoutParams.gravity = 5;
                this.f1com.addView(headImageView, layoutParams);
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(agreeBanner.url)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(FrsHeaderPraiseView.this.getContext(), null, agreeBanner.url, true)));
                }
            }
        });
    }
}
