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
    private int bzB;
    private int bzz;
    private ViewFlipper hPK;
    private boolean hPL;
    private Drawable hPM;
    private int hPN;
    private int hPO;
    private boolean hPP;
    @AnimRes
    private int hPQ;
    @AnimRes
    private int hPR;
    private boolean hPS;
    private int hPT;
    private int hPU;
    private b hPV;
    private boolean hPW;
    private d hPX;
    private c hPY;
    private a hPZ;
    private boolean hQa;
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
        void cmI();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.hPL = false;
        this.mTextColor = getResources().getColor(a.c.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
        this.mGravity = 21;
        this.hPP = false;
        this.hPQ = a.C0197a.anim_bottom_in;
        this.hPR = a.C0197a.anim_top_out;
        this.hPS = false;
        this.hPT = 800;
        this.mFlags = -1;
        this.hPU = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.hPZ = new a();
        this.hQa = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.j.ScrollTextView_setInterval, this.mInterval);
        this.hPL = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.ScrollTextView_setTextColor, this.mTextColor);
        this.hPM = obtainStyledAttributes.getDrawable(a.j.ScrollTextView_setTextBackground);
        this.bzz = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.bzB = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.hPN = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.hPO = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
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
        this.hPS = obtainStyledAttributes.hasValue(a.j.ScrollTextView_setAnimDuration);
        this.hPT = obtainStyledAttributes.getInt(a.j.ScrollTextView_setAnimDuration, this.hPT);
        this.hPP = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_isLooper, this.hPP);
        this.hPQ = a.C0197a.anim_bottom_in;
        this.hPR = a.C0197a.anim_top_out;
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
        this.hPU = obtainStyledAttributes.getInt(a.j.ScrollTextView_setTypeface, this.hPU);
        switch (this.hPU) {
            case 1:
                this.hPU = 1;
                break;
            case 2:
                this.hPU = 2;
                break;
            case 3:
                this.hPU = 3;
                break;
        }
        this.hPK = new ViewFlipper(getContext());
        this.hPK.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.hPK);
        cmH();
        if (this.hPV != null) {
            this.hPK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.hPK.getDisplayedChild();
                    ScrollTextView.this.hPV.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void cmG() {
        if (this.isStarted) {
            removeCallbacks(this.hPZ);
            this.isStarted = false;
        }
    }

    public void cmH() {
        if (!this.isStarted && !this.hPW) {
            this.isStarted = true;
            postDelayed(this.hPZ, this.mInterval);
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
                if (ScrollTextView.this.hPK.getDisplayedChild() + 1 != ScrollTextView.this.hPK.getChildCount() || ScrollTextView.this.hPP) {
                    ScrollTextView.this.bZ(ScrollTextView.this.hPQ, ScrollTextView.this.hPR);
                    ScrollTextView.this.hPK.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.hPT);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.hPK.removeAllViews();
                ScrollTextView.this.cmG();
                if (ScrollTextView.this.hPX != null) {
                    ScrollTextView.this.hPX.cmI();
                    return;
                }
                return;
            }
            ScrollTextView.this.cmG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.hPT);
        this.hPK.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.hPT);
        this.hPK.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.hPY != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.hPK.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.hPY.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.hQa) {
                    ScrollTextView.this.hPK.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.hPK.removeAllViews();
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
            this.hPK.removeAllViews();
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
                this.hPK.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void am(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.hQa = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.hPK.getChildCount() > 0) {
                    this.hPK.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.hPK.getChildCount();
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
                this.hPK.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.hQa = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.hPK.removeAllViews();
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
                this.hPK.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.hPL);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.hPU);
        textView.setPadding(this.bzz, 0, this.bzB, 0);
        if (this.hPM != null) {
            textView.setBackgroundDrawable(this.hPM);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.hPO > 0) {
                layoutParams.height = this.hPO;
            }
            if (this.hPN > 0) {
                layoutParams.setMargins(0, this.hPN, 0, this.hPN);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.hPV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hPW = true;
        cmG();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hPW = false;
        cmH();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.hPX = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.hPY = cVar;
    }
}
