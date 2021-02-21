package com.baidu.tieba.ala.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import androidx.annotation.AnimRes;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class ScrollTextView extends RelativeLayout {
    private int bGG;
    private int bGI;
    private ViewFlipper inX;
    private boolean inY;
    private Drawable inZ;
    private int ioa;
    private int iob;
    private boolean ioc;
    @AnimRes
    private int iod;
    @AnimRes
    private int ioe;
    private boolean iof;
    private int iog;
    private int ioh;
    private b ioi;
    private boolean ioj;
    private d iok;
    private c iol;
    private a iom;
    private boolean ion;
    private boolean isStarted;
    private List<AlaLiveWishListData> mDatas;
    private int mFlags;
    private int mGravity;
    private int mInterval;
    private int mPosition;
    private int mTextColor;
    private int mTextSize;

    /* loaded from: classes11.dex */
    public interface b {
        void b(AlaLiveWishListData alaLiveWishListData, int i);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(AlaLiveWishListData alaLiveWishListData, int i);
    }

    /* loaded from: classes11.dex */
    public interface d {
        void cqI();
    }

    public ScrollTextView(Context context) {
        this(context, null);
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterval = 3000;
        this.inY = false;
        this.mTextColor = getResources().getColor(a.c.sdk_white_alpha100);
        this.mTextSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
        this.mGravity = 21;
        this.ioc = false;
        this.iod = a.C0195a.anim_bottom_in;
        this.ioe = a.C0195a.anim_top_out;
        this.iof = false;
        this.iog = 800;
        this.mFlags = -1;
        this.ioh = 0;
        this.mDatas = new ArrayList();
        this.mPosition = 0;
        this.iom = new a();
        this.ion = false;
        init(context, attributeSet, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ScrollTextView, i, 0);
        this.mInterval = obtainStyledAttributes.getInteger(a.j.ScrollTextView_setInterval, this.mInterval);
        this.inY = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_setSingleLine, false);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.ScrollTextView_setTextColor, this.mTextColor);
        this.inZ = obtainStyledAttributes.getDrawable(a.j.ScrollTextView_setTextBackground);
        this.bGG = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingLeft, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.bGI = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextPaddingRight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.ioa = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemPadding, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
        this.iob = obtainStyledAttributes.getDimensionPixelOffset(a.j.ScrollTextView_setTextItemHeight, getResources().getDimensionPixelOffset(a.d.sdk_ds0));
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
        this.iof = obtainStyledAttributes.hasValue(a.j.ScrollTextView_setAnimDuration);
        this.iog = obtainStyledAttributes.getInt(a.j.ScrollTextView_setAnimDuration, this.iog);
        this.ioc = obtainStyledAttributes.getBoolean(a.j.ScrollTextView_isLooper, this.ioc);
        this.iod = a.C0195a.anim_bottom_in;
        this.ioe = a.C0195a.anim_top_out;
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
        this.ioh = obtainStyledAttributes.getInt(a.j.ScrollTextView_setTypeface, this.ioh);
        switch (this.ioh) {
            case 1:
                this.ioh = 1;
                break;
            case 2:
                this.ioh = 2;
                break;
            case 3:
                this.ioh = 3;
                break;
        }
        this.inX = new ViewFlipper(getContext());
        this.inX.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        addView(this.inX);
        cqH();
        if (this.ioi != null) {
            this.inX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int displayedChild = ScrollTextView.this.inX.getDisplayedChild();
                    ScrollTextView.this.ioi.b((AlaLiveWishListData) ScrollTextView.this.mDatas.get(displayedChild), displayedChild);
                }
            });
        }
        obtainStyledAttributes.recycle();
    }

    public void cqG() {
        if (this.isStarted) {
            removeCallbacks(this.iom);
            this.isStarted = false;
        }
    }

    public void cqH() {
        if (!this.isStarted && !this.ioj) {
            this.isStarted = true;
            postDelayed(this.iom, this.mInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScrollTextView.this.isStarted) {
                if (ScrollTextView.this.inX.getDisplayedChild() + 1 != ScrollTextView.this.inX.getChildCount() || ScrollTextView.this.ioc) {
                    ScrollTextView.this.ca(ScrollTextView.this.iod, ScrollTextView.this.ioe);
                    ScrollTextView.this.inX.showNext();
                    ScrollTextView.this.postDelayed(this, ScrollTextView.this.mInterval + ScrollTextView.this.iog);
                    return;
                }
                ScrollTextView.this.mDatas = new ArrayList();
                ScrollTextView.this.inX.removeAllViews();
                ScrollTextView.this.cqG();
                if (ScrollTextView.this.iok != null) {
                    ScrollTextView.this.iok.cqI();
                    return;
                }
                return;
            }
            ScrollTextView.this.cqG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(@AnimRes int i, @AnimRes int i2) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        loadAnimation.setDuration(this.iog);
        this.inX.setInAnimation(loadAnimation);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i2);
        loadAnimation2.setDuration(this.iog);
        this.inX.setOutAnimation(loadAnimation2);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (ScrollTextView.this.iol != null) {
                    int displayedChild = ScrollTextView.this.mPosition + ScrollTextView.this.inX.getDisplayedChild();
                    if (displayedChild >= ScrollTextView.this.mDatas.size() - 1) {
                        ScrollTextView.this.iol.a((AlaLiveWishListData) ScrollTextView.this.mDatas.get(0), displayedChild);
                    }
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ScrollTextView.this.ion) {
                    ScrollTextView.this.inX.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.widget.ScrollTextView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScrollTextView.this.mDatas.clear();
                            ScrollTextView.this.inX.removeAllViews();
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
            this.inX.removeAllViews();
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
                this.inX.addView(inflate, i2);
                i++;
                i2++;
            }
        }
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.ion = false;
            for (int i = 0; i < this.mDatas.size() - 1; i++) {
                this.mDatas.remove(i);
                if (this.inX.getChildCount() > 0) {
                    this.inX.removeViewAt(0);
                }
            }
            this.mDatas.addAll(arrayList);
            int i2 = 0;
            int childCount = this.inX.getChildCount();
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
                this.inX.addView(inflate, childCount);
                i2++;
                childCount++;
            }
            return;
        }
        this.ion = true;
    }

    public void setDatasWithDrawableIcon(List<AlaLiveWishListData> list, Drawable drawable, int i, int i2) {
        this.mDatas = list;
        if (ListUtils.isEmpty(this.mDatas)) {
            this.inX.removeAllViews();
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
                this.inX.addView(linearLayout, i3);
            }
        }
    }

    private void a(TextView textView, String str, int i) {
        textView.setText(str);
        textView.setSingleLine(this.inY);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setGravity(this.mGravity);
        textView.getPaint().setFlags(this.mFlags);
        textView.setTypeface(null, this.ioh);
        textView.setPadding(this.bGG, 0, this.bGI, 0);
        if (this.inZ != null) {
            textView.setBackgroundDrawable(this.inZ);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (layoutParams != null) {
            if (this.iob > 0) {
                layoutParams.height = this.iob;
            }
            if (this.ioa > 0) {
                layoutParams.setMargins(0, this.ioa, 0, this.ioa);
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    public void setItemOnClickListener(b bVar) {
        this.ioi = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ioj = true;
        cqG();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ioj = false;
        cqH();
    }

    public void setOnScrollTextViewCompleteListener(d dVar) {
        this.iok = dVar;
    }

    public void setOnScrollTextViewChangeListener(c cVar) {
        this.iol = cVar;
    }
}
