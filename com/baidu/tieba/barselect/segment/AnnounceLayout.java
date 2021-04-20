package com.baidu.tieba.barselect.segment;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.c.e.p.t;
import d.b.h0.b1.m.f;
/* loaded from: classes4.dex */
public class AnnounceLayout extends CardBasicLayout {

    /* renamed from: h  reason: collision with root package name */
    public float f14853h;
    public Context i;
    public TextView j;

    /* loaded from: classes4.dex */
    public class a extends f {
        public a(int i, String str) {
            super(i, str);
        }
    }

    public AnnounceLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        this.j = (TextView) findViewById(R.id.announce_content);
    }

    public void b() {
        this.i = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.announce_layout, (ViewGroup) this, true);
        a();
    }

    public final void c(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
            int i = 2;
            if (!t.b(this.f14853h, this.j.getPaint(), spannableStringBuilder.toString(), 2)) {
                this.j.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.detail));
            spannableStringBuilder3.setSpan(new a(2, null), 0, spannableStringBuilder3.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.j.getPaint(), (int) this.f14853h, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            float f2 = this.f14853h;
            if (staticLayout.getLineCount() >= 2) {
                spannableStringBuilder.delete(staticLayout.getLineEnd(1), spannableStringBuilder.length());
                f2 = this.f14853h - staticLayout.getLineWidth(1);
            }
            CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
            float measureText = this.j.getPaint().measureText(spannableStringBuilder3.toString());
            while (measureText > this.j.getPaint().measureText(subSequence.toString()) + f2) {
                i++;
                if (spannableStringBuilder.length() - i < 0) {
                    break;
                }
                subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
            }
            if (spannableStringBuilder.length() - i > 0) {
                spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
            }
            this.j.setText(spannableStringBuilder);
            return;
        }
        this.j.setText(TbadkCoreApplication.getInst().getString(R.string.empty_announce));
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, d.b.i0.v.b.f fVar) {
        int i2;
        super.setData(i, fVar);
        if (this.f14857f != null && this.f14858g != null && (i2 = this.f14856e) >= 0) {
            if (i2 == d.b.i0.v.e.a.f62965b) {
                this.f14853h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds120) * 2);
            }
            int i3 = this.f14856e;
            if (i3 == d.b.i0.v.e.a.f62966c || i3 == d.b.i0.v.e.a.f62967d) {
                this.f14853h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds96) * 2);
            }
            c(new SpannableStringBuilder(this.f14858g.b()));
            return;
        }
        setVisibility(8);
    }

    public AnnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14853h = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds90) * 2);
        b();
    }
}
