package com.baidu.tieba.ala.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnimRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollTextView extends RelativeLayout {
    private int bCW;
    private int bCY;
    private ViewFlipper iaj;
    private boolean iak;
    private Drawable ial;
    private int iam;
    private int ian;
    private boolean iao;
    @AnimRes
    private int iap;
    @AnimRes
    private int iaq;
    private boolean iar;
    private int ias;
    private int iat;
    private b iau;
    private boolean iav;
    private d iaw;
    private c iax;
    private a iay;
    private boolean iaz;
    private boolean isStarted;
    private List<AlaLiveWishListData> mDatas;
    private int mFlags;
    private int mGravity;
    private int mInterval;
    private int mPosition;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes4.dex */
    public interface b {
        void b(AlaLiveWishListData alaLiveWishListData, int i);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(AlaLiveWishListData alaLiveWishListData, int i);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void cqp();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.iak = false;
        this.mTextColor = getResources().getColor(a.c.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
        this.mGravity = 21;
        this.iao = false;
        this.iap = a.C0205a.anim_bottom_in;
        this.iaq = a.C0205a.anim_top_out;
        this.iar = false;
        this.ias = 800;
        this.mFlags = -1;
        this.iat = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.iay = new a();
        this.iaz = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.j.ScrollTextView_setInterval, this.mInterval);
        this.iak = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.ScrollTextView_setTextColor, this.mTextColor);
        this.ial = obtainStyledAttributes.getDrawable(a.j.ScrollTextView_setTextBackground);
        this.bCW = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.bCY = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.iam = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.ian = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        if (obtainStyledAttributes.hasValue(a.j.ScrollTextView_setTextSize)) {
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.j.ScrollTextView_setTextSize, this.mTextSize);
        }
        switch (obtainStyledAttributes.getInt(a.j.ScrollTextView_setGravity, 0)) {
            case 0:
                this.mGravity = 19;
                break;
            case 1:
                this.mGravity = 17;
                break;
            case 2:
                this.mGravity = 21;
                break;
        }
        this.iar = obtainStyledAttributes.hasValue(a.j.ScrollTextView_setAnimDuration);
        this.ias = obtainStyledAttributes.getInt(a.j.ScrollTextView_setAnimDuration, this.ias);
        this.iao = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_isLooper, this.iao);
        this.iap = a.C0205a.anim_bottom_in;
        this.iaq = a.C0205a.anim_top_out;
        this.mFlags = obtainStyledAttributes.getInt(a.j.ScrollTextView_setFlags, this.mFlags);
        switch (this.mFlags) {
            case 0:
                this.mFlags = 17;
                break;
            case 1:
                this.mFlags = 9;
                break;
            default:
                this.mFlags = 1;
                break;
        }
        this.iat = obtainStyledAttributes.getInt(a.j.ScrollTextView_setTypeface, this.iat);
        switch (this.iat) {
            case 1:
                this.iat = 1;
                break;
            case 2:
                this.iat = 2;
                break;
            case 3:
                this.iat = 3;
                break;
        }
        this.iaj = new ViewFlipper(getContext());
        this.iaj.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.iaj);
        cqo();
        if (this.iau != null) {
            this.iaj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.iaj.getDisplayedChild();
                    ScrollTextView.this.iau.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void cqn() {
        if (this.isStarted) {
            removeCallbacks(this.iay);
            this.isStarted = false;
        }
    }

    public void cqo() {
        if (!this.isStarted && !this.iav) {
            this.isStarted = true;
            postDelayed(this.iay, this.mInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScrollTextView.this.isStarted) {
                if (ScrollTextView.this.iaj.getDisplayedChild() + 1 != ScrollTextView.this.iaj.getChildCount() || ScrollTextView.this.iao) {
                    ScrollTextView.this.cd(ScrollTextView.this.iap, ScrollTextView.this.iaq);
                    ScrollTextView.this.iaj.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.ias);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.iaj.removeAllViews();
                ScrollTextView.this.cqn();
                if (ScrollTextView.this.iaw != null) {
                    ScrollTextView.this.iaw.cqp();
                    return;
                }
                return;
            }
            ScrollTextView.this.cqn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.ias);
        this.iaj.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.ias);
        this.iaj.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.iax != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.iaj.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.iax.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.iaz) {
                    ScrollTextView.this.iaj.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.iaj.removeAllViews();
                        }
                    }, 500L);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void setDatas(ArrayList<AlaLiveWishListData> arrayList) {
        setDatas(arrayList, 0);
    }

    public void setDatas(ArrayList<AlaLiveWishListData> arrayList, int i) {
        this.mDatas = arrayList;
        this.mPosition = i;
        if (!ListUtils.isEmpty(arrayList) && i >= 0 && i < arrayList.size()) {
            this.iaj.removeAllViews();
            int i2 = 0;
            while (i < arrayList.size()) {
                View inflate = LayoutInflater.from(getContext()).inflate(a.g.ala_item_scroll_text_view, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.wish_image_view);
                AlaLiveWishListData alaLiveWishListData = arrayList.get(i);
                ((TextView) inflate.findViewById(a.f.wish_text)).setText(alaLiveWishListData.gift_name);
                tbImageView.setDefaultBgResource(a.e.icon_live_gift_default);
                tbImageView.setDefaultErrorResource(a.e.icon_live_gift_default);
                tbImageView.setAutoChangeStyle(false);
                tbImageView.startLoad(alaLiveWishListData.gift_url, 10, false);
                ((TextView) inflate.findViewById(a.f.wish_count_tv)).setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
                this.iaj.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void an(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.iaz = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.iaj.getChildCount() > 0) {
                    this.iaj.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.iaj.getChildCount();
            while (i2 < arrayList.size()) {
                View inflate = LayoutInflater.from(getContext()).inflate(a.g.ala_item_scroll_text_view, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.wish_image_view);
                AlaLiveWishListData alaLiveWishListData = arrayList.get(i2);
                ((TextView) inflate.findViewById(a.f.wish_text)).setText(alaLiveWishListData.gift_name);
                tbImageView.setDefaultBgResource(a.e.icon_live_gift_default);
                tbImageView.setDefaultErrorResource(a.e.icon_live_gift_default);
                tbImageView.setAutoChangeStyle(false);
                tbImageView.startLoad(alaLiveWishListData.gift_url, 10, false);
                ((TextView) inflate.findViewById(a.f.wish_count_tv)).setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
                this.iaj.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.iaz = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.iaj.removeAllViews();
            for (int i3 = 0; i3 < this.mDatas.size(); i3++) {
                TextView textView = new TextView(getContext());
                a(textView, list.get(i3).gift_name, i3);
                textView.setCompoundDrawablePadding(8);
                int i4 = (int) ((getResources().getDisplayMetrics().density * i) + 0.5f);
                drawable.setBounds(0, 0, i4, i4);
                if (i2 == 3) {
                    textView.setCompoundDrawables(drawable, null, null, null);
                } else if (i2 == 48) {
                    textView.setCompoundDrawables(null, drawable, null, null);
                } else if (i2 == 5) {
                    textView.setCompoundDrawables(null, null, drawable, null);
                } else if (i2 == 80) {
                    textView.setCompoundDrawables(null, null, null, drawable);
                }
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(this.mGravity);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                this.iaj.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.iak);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.iat);
        textView.setPadding(this.bCW, 0, this.bCY, 0);
        if (this.ial != null) {
            textView.setBackgroundDrawable(this.ial);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.ian > 0) {
                layoutParams.height = this.ian;
            }
            if (this.iam > 0) {
                layoutParams.setMargins(0, this.iam, 0, this.iam);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.iau = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.iav = true;
        cqn();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iav = false;
        cqo();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.iaw = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.iax = cVar;
    }
}
