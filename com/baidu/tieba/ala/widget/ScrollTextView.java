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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollTextView extends RelativeLayout {
    private int aZn;
    private int aZp;
    private ViewFlipper gwc;
    private boolean gwd;
    private Drawable gwe;
    private int gwf;
    private int gwg;
    private boolean gwh;
    @AnimRes
    private int gwi;
    @AnimRes
    private int gwj;
    private boolean gwk;
    private int gwl;
    private int gwm;
    private b gwn;
    private boolean gwo;
    private d gwp;
    private c gwq;
    private a gwr;
    private boolean gws;
    private boolean isStarted;
    private List<AlaLiveWishListData> mDatas;
    private int mFlags;
    private int mGravity;
    private int mInterval;
    private int mPosition;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes3.dex */
    public interface b {
        void b(AlaLiveWishListData alaLiveWishListData, int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(AlaLiveWishListData alaLiveWishListData, int i);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void bJO();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.gwd = false;
        this.mTextColor = getResources().getColor(a.d.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mGravity = 21;
        this.gwh = false;
        this.gwi = a.C0182a.anim_bottom_in;
        this.gwj = a.C0182a.anim_top_out;
        this.gwk = false;
        this.gwl = 800;
        this.mFlags = -1;
        this.gwm = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.gwr = new a();
        this.gws = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.k.ScrollTextView_setInterval, this.mInterval);
        this.gwd = obtainStyledAttributes.getBoolean(a.k.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.k.ScrollTextView_setTextColor, this.mTextColor);
        this.gwe = obtainStyledAttributes.getDrawable(a.k.ScrollTextView_setTextBackground);
        this.aZn = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.aZp = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.gwf = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.gwg = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
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
        this.gwk = obtainStyledAttributes.hasValue(a.k.ScrollTextView_setAnimDuration);
        this.gwl = obtainStyledAttributes.getInt(a.k.ScrollTextView_setAnimDuration, this.gwl);
        this.gwh = obtainStyledAttributes.getBoolean(a.k.ScrollTextView_isLooper, this.gwh);
        this.gwi = a.C0182a.anim_bottom_in;
        this.gwj = a.C0182a.anim_top_out;
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
        this.gwm = obtainStyledAttributes.getInt(a.k.ScrollTextView_setTypeface, this.gwm);
        switch (this.gwm) {
            case 1:
                this.gwm = 1;
                break;
            case 2:
                this.gwm = 2;
                break;
            case 3:
                this.gwm = 3;
                break;
        }
        this.gwc = new ViewFlipper(getContext());
        this.gwc.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.gwc);
        bJN();
        if (this.gwn != null) {
            this.gwc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.gwc.getDisplayedChild();
                    ScrollTextView.this.gwn.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void bJM() {
        if (this.isStarted) {
            removeCallbacks(this.gwr);
            this.isStarted = false;
        }
    }

    public void bJN() {
        if (!this.isStarted && !this.gwo) {
            this.isStarted = true;
            postDelayed(this.gwr, this.mInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScrollTextView.this.isStarted) {
                if (ScrollTextView.this.gwc.getDisplayedChild() + 1 != ScrollTextView.this.gwc.getChildCount() || ScrollTextView.this.gwh) {
                    ScrollTextView.this.bD(ScrollTextView.this.gwi, ScrollTextView.this.gwj);
                    ScrollTextView.this.gwc.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.gwl);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.gwc.removeAllViews();
                ScrollTextView.this.bJM();
                if (ScrollTextView.this.gwp != null) {
                    ScrollTextView.this.gwp.bJO();
                    return;
                }
                return;
            }
            ScrollTextView.this.bJM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.gwl);
        this.gwc.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.gwl);
        this.gwc.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.gwq != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.gwc.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.gwq.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.gws) {
                    ScrollTextView.this.gwc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.gwc.removeAllViews();
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
            this.gwc.removeAllViews();
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
                this.gwc.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void ac(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.gws = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.gwc.getChildCount() > 0) {
                    this.gwc.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.gwc.getChildCount();
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
                this.gwc.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.gws = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.gwc.removeAllViews();
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
                this.gwc.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.gwd);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.gwm);
        textView.setPadding(this.aZn, 0, this.aZp, 0);
        if (this.gwe != null) {
            textView.setBackgroundDrawable(this.gwe);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.gwg > 0) {
                layoutParams.height = this.gwg;
            }
            if (this.gwf > 0) {
                layoutParams.setMargins(0, this.gwf, 0, this.gwf);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.gwn = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gwo = true;
        bJM();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gwo = false;
        bJN();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.gwp = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.gwq = cVar;
    }
}
