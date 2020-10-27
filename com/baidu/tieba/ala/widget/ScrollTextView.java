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
    private int btm;
    private int btp;
    private ViewFlipper hJN;
    private boolean hJO;
    private Drawable hJP;
    private int hJQ;
    private int hJR;
    private boolean hJS;
    @AnimRes
    private int hJT;
    @AnimRes
    private int hJU;
    private boolean hJV;
    private int hJW;
    private int hJX;
    private b hJY;
    private boolean hJZ;
    private d hKa;
    private c hKb;
    private a hKc;
    private boolean hKd;
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
        void ckg();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.hJO = false;
        this.mTextColor = getResources().getColor(a.d.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mGravity = 21;
        this.hJS = false;
        this.hJT = a.C0195a.anim_bottom_in;
        this.hJU = a.C0195a.anim_top_out;
        this.hJV = false;
        this.hJW = 800;
        this.mFlags = -1;
        this.hJX = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.hKc = new a();
        this.hKd = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.k.ScrollTextView_setInterval, this.mInterval);
        this.hJO = obtainStyledAttributes.getBoolean(a.k.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.k.ScrollTextView_setTextColor, this.mTextColor);
        this.hJP = obtainStyledAttributes.getDrawable(a.k.ScrollTextView_setTextBackground);
        this.btm = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.btp = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.hJQ = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.hJR = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        if (obtainStyledAttributes.hasValue(a.k.ScrollTextView_setTextSize)) {
            this.mTextSize = (int) obtainStyledAttributes.getDimension(a.k.ScrollTextView_setTextSize, this.mTextSize);
        }
        switch (obtainStyledAttributes.getInt(a.k.ScrollTextView_setGravity, 0)) {
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
        this.hJV = obtainStyledAttributes.hasValue(a.k.ScrollTextView_setAnimDuration);
        this.hJW = obtainStyledAttributes.getInt(a.k.ScrollTextView_setAnimDuration, this.hJW);
        this.hJS = obtainStyledAttributes.getBoolean(a.k.ScrollTextView_isLooper, this.hJS);
        this.hJT = a.C0195a.anim_bottom_in;
        this.hJU = a.C0195a.anim_top_out;
        this.mFlags = obtainStyledAttributes.getInt(a.k.ScrollTextView_setFlags, this.mFlags);
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
        this.hJX = obtainStyledAttributes.getInt(a.k.ScrollTextView_setTypeface, this.hJX);
        switch (this.hJX) {
            case 1:
                this.hJX = 1;
                break;
            case 2:
                this.hJX = 2;
                break;
            case 3:
                this.hJX = 3;
                break;
        }
        this.hJN = new ViewFlipper(getContext());
        this.hJN.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.hJN);
        ckf();
        if (this.hJY != null) {
            this.hJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.hJN.getDisplayedChild();
                    ScrollTextView.this.hJY.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void cke() {
        if (this.isStarted) {
            removeCallbacks(this.hKc);
            this.isStarted = false;
        }
    }

    public void ckf() {
        if (!this.isStarted && !this.hJZ) {
            this.isStarted = true;
            postDelayed(this.hKc, this.mInterval);
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
                if (ScrollTextView.this.hJN.getDisplayedChild() + 1 != ScrollTextView.this.hJN.getChildCount() || ScrollTextView.this.hJS) {
                    ScrollTextView.this.bX(ScrollTextView.this.hJT, ScrollTextView.this.hJU);
                    ScrollTextView.this.hJN.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.hJW);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.hJN.removeAllViews();
                ScrollTextView.this.cke();
                if (ScrollTextView.this.hKa != null) {
                    ScrollTextView.this.hKa.ckg();
                    return;
                }
                return;
            }
            ScrollTextView.this.cke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.hJW);
        this.hJN.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.hJW);
        this.hJN.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.hKb != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.hJN.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.hKb.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.hKd) {
                    ScrollTextView.this.hJN.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.hJN.removeAllViews();
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
            this.hJN.removeAllViews();
            int i2 = 0;
            while (i < arrayList.size()) {
                View inflate = LayoutInflater.from(getContext()).inflate(a.h.ala_item_scroll_text_view, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.wish_image_view);
                AlaLiveWishListData alaLiveWishListData = arrayList.get(i);
                ((TextView) inflate.findViewById(a.g.wish_text)).setText(alaLiveWishListData.gift_name);
                tbImageView.setDefaultBgResource(a.f.icon_live_gift_default);
                tbImageView.setDefaultErrorResource(a.f.icon_live_gift_default);
                tbImageView.setAutoChangeStyle(false);
                tbImageView.startLoad(alaLiveWishListData.gift_url, 10, false);
                ((TextView) inflate.findViewById(a.g.wish_count_tv)).setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
                this.hJN.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void am(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.hKd = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.hJN.getChildCount() > 0) {
                    this.hJN.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.hJN.getChildCount();
            while (i2 < arrayList.size()) {
                View inflate = LayoutInflater.from(getContext()).inflate(a.h.ala_item_scroll_text_view, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.wish_image_view);
                AlaLiveWishListData alaLiveWishListData = arrayList.get(i2);
                ((TextView) inflate.findViewById(a.g.wish_text)).setText(alaLiveWishListData.gift_name);
                tbImageView.setDefaultBgResource(a.f.icon_live_gift_default);
                tbImageView.setDefaultErrorResource(a.f.icon_live_gift_default);
                tbImageView.setAutoChangeStyle(false);
                tbImageView.startLoad(alaLiveWishListData.gift_url, 10, false);
                ((TextView) inflate.findViewById(a.g.wish_count_tv)).setText(alaLiveWishListData.process_num + "/" + alaLiveWishListData.finish_num);
                this.hJN.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.hKd = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.hJN.removeAllViews();
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
                this.hJN.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.hJO);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.hJX);
        textView.setPadding(this.btm, 0, this.btp, 0);
        if (this.hJP != null) {
            textView.setBackgroundDrawable(this.hJP);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.hJR > 0) {
                layoutParams.height = this.hJR;
            }
            if (this.hJQ > 0) {
                layoutParams.setMargins(0, this.hJQ, 0, this.hJQ);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.hJY = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hJZ = true;
        cke();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hJZ = false;
        ckf();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.hKa = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.hKb = cVar;
    }
}
