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
    private int beN;
    private int beP;
    private ViewFlipper gOH;
    private boolean gOI;
    private Drawable gOJ;
    private int gOK;
    private int gOL;
    private boolean gOM;
    @AnimRes
    private int gON;
    @AnimRes
    private int gOO;
    private boolean gOP;
    private int gOQ;
    private int gOR;
    private b gOS;
    private boolean gOT;
    private d gOU;
    private c gOV;
    private a gOW;
    private boolean gOX;
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
        void bQh();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.gOI = false;
        this.mTextColor = getResources().getColor(a.d.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
        this.mGravity = 21;
        this.gOM = false;
        this.gON = a.C0178a.anim_bottom_in;
        this.gOO = a.C0178a.anim_top_out;
        this.gOP = false;
        this.gOQ = 800;
        this.mFlags = -1;
        this.gOR = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.gOW = new a();
        this.gOX = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.k.ScrollTextView_setInterval, this.mInterval);
        this.gOI = obtainStyledAttributes.getBoolean(a.k.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.k.ScrollTextView_setTextColor, this.mTextColor);
        this.gOJ = obtainStyledAttributes.getDrawable(a.k.ScrollTextView_setTextBackground);
        this.beN = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.beP = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.gOK = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
        this.gOL = obtainStyledAttributes.getDimensionPixelOffset(a.k.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.e.sdk_ds0));
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
        this.gOP = obtainStyledAttributes.hasValue(a.k.ScrollTextView_setAnimDuration);
        this.gOQ = obtainStyledAttributes.getInt(a.k.ScrollTextView_setAnimDuration, this.gOQ);
        this.gOM = obtainStyledAttributes.getBoolean(a.k.ScrollTextView_isLooper, this.gOM);
        this.gON = a.C0178a.anim_bottom_in;
        this.gOO = a.C0178a.anim_top_out;
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
        this.gOR = obtainStyledAttributes.getInt(a.k.ScrollTextView_setTypeface, this.gOR);
        switch (this.gOR) {
            case 1:
                this.gOR = 1;
                break;
            case 2:
                this.gOR = 2;
                break;
            case 3:
                this.gOR = 3;
                break;
        }
        this.gOH = new ViewFlipper(getContext());
        this.gOH.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.gOH);
        bQg();
        if (this.gOS != null) {
            this.gOH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.gOH.getDisplayedChild();
                    ScrollTextView.this.gOS.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void bQf() {
        if (this.isStarted) {
            removeCallbacks(this.gOW);
            this.isStarted = false;
        }
    }

    public void bQg() {
        if (!this.isStarted && !this.gOT) {
            this.isStarted = true;
            postDelayed(this.gOW, this.mInterval);
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
                if (ScrollTextView.this.gOH.getDisplayedChild() + 1 != ScrollTextView.this.gOH.getChildCount() || ScrollTextView.this.gOM) {
                    ScrollTextView.this.bK(ScrollTextView.this.gON, ScrollTextView.this.gOO);
                    ScrollTextView.this.gOH.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.gOQ);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.gOH.removeAllViews();
                ScrollTextView.this.bQf();
                if (ScrollTextView.this.gOU != null) {
                    ScrollTextView.this.gOU.bQh();
                    return;
                }
                return;
            }
            ScrollTextView.this.bQf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.gOQ);
        this.gOH.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.gOQ);
        this.gOH.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.gOV != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.gOH.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.gOV.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.gOX) {
                    ScrollTextView.this.gOH.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.gOH.removeAllViews();
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
            this.gOH.removeAllViews();
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
                this.gOH.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void ad(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.gOX = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.gOH.getChildCount() > 0) {
                    this.gOH.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.gOH.getChildCount();
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
                this.gOH.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.gOX = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.gOH.removeAllViews();
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
                this.gOH.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.gOI);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.gOR);
        textView.setPadding(this.beN, 0, this.beP, 0);
        if (this.gOJ != null) {
            textView.setBackgroundDrawable(this.gOJ);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.gOL > 0) {
                layoutParams.height = this.gOL;
            }
            if (this.gOK > 0) {
                layoutParams.setMargins(0, this.gOK, 0, this.gOK);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.gOS = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gOT = true;
        bQf();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gOT = false;
        bQg();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.gOU = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.gOV = cVar;
    }
}
