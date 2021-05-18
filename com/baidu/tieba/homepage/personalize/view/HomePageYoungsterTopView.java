package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class HomePageYoungsterTopView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f16571e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16572f;

    /* renamed from: g  reason: collision with root package name */
    public c f16573g;

    /* renamed from: h  reason: collision with root package name */
    public b f16574h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomePageYoungsterTopView.this.f16574h != null) {
                HomePageYoungsterTopView.this.f16574h.onDelete();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onDelete();
    }

    /* loaded from: classes4.dex */
    public static class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<Context> f16576e;

        public c(Context context) {
            this.f16576e = new WeakReference<>(context);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Context context = this.f16576e.get();
            if (context == null || !d.a.j0.c1.b.c.d()) {
                return;
            }
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(context);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }
    }

    public HomePageYoungsterTopView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
    }

    public final void b() {
        RelativeLayout.inflate(getContext(), R.layout.view_homepage_youngster_top, this);
        this.f16571e = (TextView) findViewById(R.id.youngster_top_text);
        this.f16572f = (ImageView) findViewById(R.id.youngster_top_delete);
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.youngster_open_title) + "，" + getContext().getString(R.string.youngster_homgpage_top_text));
        c cVar = new c(getContext());
        this.f16573g = cVar;
        spannableString.setSpan(cVar, 9, 13, 33);
        this.f16571e.setText(spannableString);
        this.f16571e.setMovementMethod(LinkMovementMethod.getInstance());
        this.f16572f.setOnClickListener(new a());
        c();
    }

    public void c() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
        SkinManager.setViewTextColor(this.f16571e, R.color.CAM_X0107);
        SkinManager.setImageResource(this.f16572f, R.drawable.icon_home_card_delete);
    }

    public void setOnDeleteClick(b bVar) {
        this.f16574h = bVar;
    }

    public HomePageYoungsterTopView(Context context) {
        this(context, null);
    }

    public HomePageYoungsterTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomePageYoungsterTopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
