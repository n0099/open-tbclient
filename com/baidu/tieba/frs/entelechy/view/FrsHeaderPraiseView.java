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
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class FrsHeaderPraiseView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f16238e;

    /* renamed from: f  reason: collision with root package name */
    public View f16239f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16240g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f16241h;
    public ImageView i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AgreeBanner f16242e;

        public a(AgreeBanner agreeBanner) {
            this.f16242e = agreeBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f16242e.url)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(FrsHeaderPraiseView.this.getContext(), null, this.f16242e.url, true)));
        }
    }

    public FrsHeaderPraiseView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.f16238e = findViewById(R.id.divider_top);
        this.f16239f = findViewById(R.id.divider_bottom);
        this.f16240g = (TextView) findViewById(R.id.frs_praise_title);
        this.f16241h = (FrameLayout) findViewById(R.id.frs_praise_portrait);
        ImageView imageView = (ImageView) findViewById(R.id.frs_praise_more);
        this.i = imageView;
        SkinManager.setImageResource(imageView, R.drawable.icon_arrow_more_gray_n);
    }

    public void setData(AgreeBanner agreeBanner) {
        if (agreeBanner == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f16240g.setText(agreeBanner.text);
        List<SimpleUser> list = agreeBanner.top_agree_user;
        this.f16241h.removeAllViews();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 5) {
                for (int i = 0; i < list.size() && i != 5; i++) {
                    arrayList.add(list.get(i));
                }
            } else {
                arrayList.addAll(list);
            }
            for (int size = arrayList.size() - 1; size >= 0 && this.f16241h.getChildCount() != 5; size--) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds40), getResources().getDimensionPixelSize(R.dimen.ds40));
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setDefaultResource(17170445);
                headImageView.setDefaultBgResource(R.color.CAM_X0205);
                headImageView.setIsRound(true);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
                headImageView.setBorderWidth(l.g(getContext(), R.dimen.ds2));
                headImageView.W(((SimpleUser) arrayList.get(size)).portrait, 12, false);
                if (size != arrayList.size() - 1) {
                    layoutParams.rightMargin = (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds40)) - (((arrayList.size() - 1) - size) * getResources().getDimensionPixelSize(R.dimen.ds8));
                }
                layoutParams.gravity = 5;
                this.f16241h.addView(headImageView, layoutParams);
            }
        }
        setOnClickListener(new a(agreeBanner));
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsHeaderPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.frs_header_extra_praise_layout, this);
        a();
    }
}
