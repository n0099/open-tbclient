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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class FrsHeaderPraiseView extends RelativeLayout {
    private View fiN;
    private View fiO;
    private TextView fiP;
    private FrameLayout fiQ;
    private ImageView fiR;

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(d.h.frs_header_extra_praise_layout, this);
        initView();
    }

    private void initView() {
        this.fiN = findViewById(d.g.divider_top);
        this.fiO = findViewById(d.g.divider_bottom);
        this.fiP = (TextView) findViewById(d.g.frs_praise_title);
        this.fiQ = (FrameLayout) findViewById(d.g.frs_praise_portrait);
        this.fiR = (ImageView) findViewById(d.g.frs_praise_more);
        al.c(this.fiR, d.f.icon_arrow_more_gray_n);
    }

    public void setData(final AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fiP.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.fiQ.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.fiQ.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds40), getResources().getDimensionPixelSize(d.e.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultErrorResource(d.f.icon_default_avatar100);
                headImageView.setDefaultBgResource(d.C0277d.cp_bg_line_e);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(al.getColor(d.C0277d.cp_bg_line_d));
                headImageView.setBorderWidth(l.h(getContext(), d.e.ds2));
                headImageView.startLoad(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(d.e.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(d.e.ds8));
                }
                layoutParams.gravity = 5;
                this.fiQ.addView(headImageView, layoutParams);
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
