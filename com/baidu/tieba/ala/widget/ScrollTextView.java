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
    private ViewFlipper iah;
    private boolean iai;
    private Drawable iaj;
    private int iak;
    private int ial;
    private boolean iam;
    @AnimRes
    private int ian;
    @AnimRes
    private int iao;
    private boolean iap;
    private int iaq;
    private int iar;
    private b ias;
    private boolean iat;
    private d iau;
    private c iav;
    private a iaw;
    private boolean iax;
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
        void cqo();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.iai = false;
        this.mTextColor = getResources().getColor(a.c.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
        this.mGravity = 21;
        this.iam = false;
        this.ian = a.C0205a.anim_bottom_in;
        this.iao = a.C0205a.anim_top_out;
        this.iap = false;
        this.iaq = 800;
        this.mFlags = -1;
        this.iar = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.iaw = new a();
        this.iax = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.j.ScrollTextView_setInterval, this.mInterval);
        this.iai = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.ScrollTextView_setTextColor, this.mTextColor);
        this.iaj = obtainStyledAttributes.getDrawable(a.j.ScrollTextView_setTextBackground);
        this.bCW = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.bCY = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.iak = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.ial = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
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
        this.iap = obtainStyledAttributes.hasValue(a.j.ScrollTextView_setAnimDuration);
        this.iaq = obtainStyledAttributes.getInt(a.j.ScrollTextView_setAnimDuration, this.iaq);
        this.iam = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_isLooper, this.iam);
        this.ian = a.C0205a.anim_bottom_in;
        this.iao = a.C0205a.anim_top_out;
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
        this.iar = obtainStyledAttributes.getInt(a.j.ScrollTextView_setTypeface, this.iar);
        switch (this.iar) {
            case 1:
                this.iar = 1;
                break;
            case 2:
                this.iar = 2;
                break;
            case 3:
                this.iar = 3;
                break;
        }
        this.iah = new ViewFlipper(getContext());
        this.iah.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.iah);
        cqn();
        if (this.ias != null) {
            this.iah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.iah.getDisplayedChild();
                    ScrollTextView.this.ias.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void cqm() {
        if (this.isStarted) {
            removeCallbacks(this.iaw);
            this.isStarted = false;
        }
    }

    public void cqn() {
        if (!this.isStarted && !this.iat) {
            this.isStarted = true;
            postDelayed(this.iaw, this.mInterval);
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
                if (ScrollTextView.this.iah.getDisplayedChild() + 1 != ScrollTextView.this.iah.getChildCount() || ScrollTextView.this.iam) {
                    ScrollTextView.this.cd(ScrollTextView.this.ian, ScrollTextView.this.iao);
                    ScrollTextView.this.iah.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.iaq);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.iah.removeAllViews();
                ScrollTextView.this.cqm();
                if (ScrollTextView.this.iau != null) {
                    ScrollTextView.this.iau.cqo();
                    return;
                }
                return;
            }
            ScrollTextView.this.cqm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.iaq);
        this.iah.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.iaq);
        this.iah.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.iav != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.iah.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.iav.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.iax) {
                    ScrollTextView.this.iah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.iah.removeAllViews();
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
            this.iah.removeAllViews();
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
                this.iah.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void an(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.iax = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.iah.getChildCount() > 0) {
                    this.iah.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.iah.getChildCount();
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
                this.iah.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.iax = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.iah.removeAllViews();
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
                this.iah.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.iai);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.iar);
        textView.setPadding(this.bCW, 0, this.bCY, 0);
        if (this.iaj != null) {
            textView.setBackgroundDrawable(this.iaj);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.ial > 0) {
                layoutParams.height = this.ial;
            }
            if (this.iak > 0) {
                layoutParams.setMargins(0, this.iak, 0, this.iak);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.ias = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.iat = true;
        cqm();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iat = false;
        cqn();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.iau = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.iav = cVar;
    }
}
