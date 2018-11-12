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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    private View dKX;
    private View dKY;
    private TextView dKZ;
    private FrameLayout dLa;
    private ImageView dLb;

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(e.h.frs_header_extra_praise_layout, this);
        initView();
    }

    private void initView() {
        this.dKX = findViewById(e.g.divider_top);
        this.dKY = findViewById(e.g.divider_bottom);
        this.dKZ = (TextView) findViewById(e.g.frs_praise_title);
        this.dLa = (FrameLayout) findViewById(e.g.frs_praise_portrait);
        this.dLb = (ImageView) findViewById(e.g.frs_praise_more);
        al.c(this.dLb, e.f.icon_arrow_more_gray_n);
    }

    public void changeSkinType(int i) {
        al.i(this, e.f.home_thread_card_item_bg);
        al.j(this.dKX, e.d.cp_bg_line_c);
        al.j(this.dKY, e.d.cp_bg_line_e);
        al.h(this.dKZ, e.d.cp_cont_b);
        al.c(this.dLb, e.f.icon_arrow_more_gray_n);
    }

    public void setData(final AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dKZ.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.dLa.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.dLa.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0200e.ds40), getResources().getDimensionPixelSize(e.C0200e.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultErrorResource(e.f.icon_default_avatar100);
                headImageView.setDefaultBgResource(e.d.cp_bg_line_e);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(al.getColor(e.d.cp_bg_line_d));
                headImageView.setBorderWidth(l.h(getContext(), e.C0200e.ds2));
                headImageView.startLoad(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(e.C0200e.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(e.C0200e.ds8));
                }
                layoutParams.gravity = 5;
                this.dLa.addView(headImageView, layoutParams);
            }
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(agreeBanner.url)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(FrsHeaderPraiseView.this.getContext(), null, agreeBanner.url, true)));
                }
            }
        });
    }
}
