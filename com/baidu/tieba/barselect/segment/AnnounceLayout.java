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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.v;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes8.dex */
public class AnnounceLayout extends CardBasicLayout {
    private float dXg;
    private TextView gAf;
    private Context mContext;

    public AnnounceLayout(Context context) {
        this(context, null);
    }

    public AnnounceLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds90) * 2);
        initUI();
    }

    protected void initUI() {
        this.mContext = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setGravity(17);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.announce_layout, (ViewGroup) this, true);
        rV();
    }

    private void rV() {
        this.gAf = (TextView) findViewById(R.id.announce_content);
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        super.setData(i, fVar);
        if (this.gwA == null || this.gAn == null || this.status < 0) {
            setVisibility(8);
            return;
        }
        if (this.status == a.gAC) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds120) * 2);
        }
        if (this.status == a.gAD || this.status == a.gAE) {
            this.dXg = l.getScreenSize((Activity) getContext()).widthPixels - (l.getDimens(getContext(), R.dimen.tbds96) * 2);
        }
        a(new SpannableStringBuilder(this.gAn.bKe()));
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.gAf.setText(TbadkCoreApplication.getInst().getString(R.string.empty_announce));
        } else if (!v.a(this.dXg, this.gAf.getPaint(), spannableStringBuilder.toString(), 2)) {
            this.gAf.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(StringHelper.STRING_MORE);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(TbadkCoreApplication.getInst().getString(R.string.detail));
            spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tieba.barselect.segment.AnnounceLayout.1
            }, 0, spannableStringBuilder3.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.gAf.getPaint(), (int) this.dXg, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            float f2 = this.dXg;
            if (staticLayout.getLineCount() >= 2) {
                spannableStringBuilder.delete(staticLayout.getLineEnd(1), spannableStringBuilder.length());
                f = this.dXg - staticLayout.getLineWidth(1);
            } else {
                f = f2;
            }
            CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
            float measureText = this.gAf.getPaint().measureText(spannableStringBuilder3.toString());
            int i = 2;
            while (measureText > this.gAf.getPaint().measureText(subSequence.toString()) + f) {
                i++;
                if (spannableStringBuilder.length() - i < 0) {
                    break;
                }
                subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
            }
            if (spannableStringBuilder.length() - i > 0) {
                spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder2);
            }
            this.gAf.setText(spannableStringBuilder);
        }
    }
}
