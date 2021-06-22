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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class FrsHeaderPraiseView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f15458e;

    /* renamed from: f  reason: collision with root package name */
    public View f15459f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15460g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f15461h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f15462i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeBanner f15463e;

        public a(AgreeBanner agreeBanner) {
            this.f15463e = agreeBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f15463e.url)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(FrsHeaderPraiseView.this.getContext(), null, this.f15463e.url, true)));
        }
    }

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f15458e = findViewById(R.id.divider_top);
        this.f15459f = findViewById(R.id.divider_bottom);
        this.f15460g = (TextView) findViewById(R.id.frs_praise_title);
        this.f15461h = (FrameLayout) findViewById(R.id.frs_praise_portrait);
        ImageView imageView = (ImageView) findViewById(R.id.frs_praise_more);
        this.f15462i = imageView;
        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_more_gray_n);
    }

    public void setData(AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f15460g.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.f15461h.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i2 = 0; i2 < list.size() && i2 != 5; i2++) {
                    arrayList.add(list.get(i2));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.f15461h.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds40), getResources().getDimensionPixelSize(R.dimen.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultBgResource(R.color.CAM_X0205);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
                headImageView.setBorderWidth(l.g(getContext(), R.dimen.ds2));
                headImageView.U(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds8));
                }
                layoutParams.gravity = 5;
                this.f15461h.addView(headImageView, layoutParams);
            }
        }
        setOnClickListener(new a(agreeBanner));
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.frs_header_extra_praise_layout, this);
        a();
    }
}
