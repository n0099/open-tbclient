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
    private View cqd;
    private View cqe;
    private TextView cqf;
    private FrameLayout cqg;
    private ImageView cqh;

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
        this.cqd = findViewById(d.h.divider_top);
        this.cqe = findViewById(d.h.divider_bottom);
        this.cqf = (TextView) findViewById(d.h.frs_praise_title);
        this.cqg = (FrameLayout) findViewById(d.h.frs_praise_portrait);
        this.cqh = (ImageView) findViewById(d.h.frs_praise_more);
        ai.c(this.cqh, d.g.icon_arrow_more_gray_n);
    }

    public void changeSkinType(int i) {
        ai.j(this, d.g.home_thread_card_item_bg);
        ai.k(this.cqd, d.e.cp_bg_line_c);
        ai.k(this.cqe, d.e.cp_bg_line_c);
        ai.i(this.cqf, d.e.cp_cont_b);
        ai.c(this.cqh, d.g.icon_arrow_more_gray_n);
    }

    public void setData(final AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cqf.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.cqg.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.cqg.getChildCount() != 5; size--) {
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
                this.cqg.addView(headImageView, layoutParams);
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
