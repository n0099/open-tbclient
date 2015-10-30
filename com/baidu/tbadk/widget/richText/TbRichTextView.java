package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int aBS = 174;
    private int Bo;
    private com.baidu.adp.lib.e.b<ImageView> aBT;
    private com.baidu.adp.lib.e.b<TextView> aBU;
    private com.baidu.adp.lib.e.b<View> aBV;
    private com.baidu.adp.lib.e.b<LinearLayout> aBW;
    private com.baidu.adp.lib.e.b<GifView> aBX;
    private float aBY;
    private int aBZ;
    private boolean aCA;
    private Drawable aCB;
    private int aCa;
    private float aCb;
    private int aCc;
    private int aCd;
    private int aCe;
    private int aCf;
    private int aCg;
    private ImageView.ScaleType aCh;
    private int aCi;
    private int aCj;
    private boolean aCk;
    private TextUtils.TruncateAt aCl;
    private d aCm;
    private c aCn;
    private boolean aCo;
    private int aCp;
    private boolean aCq;
    private boolean aCr;
    private Runnable aCs;
    private boolean aCt;
    private b aCu;
    private com.baidu.tbadk.widget.richText.a aCv;
    private String aCw;
    private boolean aCx;
    private boolean aCy;
    private int aCz;
    private BdUniqueId atH;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> azq;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, String str, int i);
    }

    public boolean Fl() {
        return this.aCt;
    }

    public void Fm() {
        this.aCx = true;
    }

    public String getBackgroundImageUrl() {
        return this.aCw;
    }

    public void setBackgroundImageUrl(String str) {
        this.aCw = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bo = i;
    }

    public void setMaxLines(int i) {
        this.aCz = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aCl = truncateAt;
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new m(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aBT = null;
        this.aBU = null;
        this.aBV = null;
        this.aBW = null;
        this.aBX = null;
        this.aBY = 0.0f;
        this.aBZ = 0;
        this.aCa = 0;
        this.aCb = 15.0f;
        this.aCc = -1;
        this.aCd = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aCe = -9989158;
        this.aCf = 200;
        this.aCg = 200;
        this.aCh = null;
        this.aCi = 0;
        this.aCj = 0;
        this.aCk = false;
        this.aCl = null;
        this.aCm = null;
        this.aCn = null;
        this.aCo = true;
        this.mIsFromCDN = true;
        this.aCp = -1;
        this.aCq = false;
        this.aCr = false;
        this.aCs = null;
        this.aCt = false;
        this.aCw = null;
        this.aCx = false;
        this.Bo = -1;
        this.aCz = -1;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.azq = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBT = null;
        this.aBU = null;
        this.aBV = null;
        this.aBW = null;
        this.aBX = null;
        this.aBY = 0.0f;
        this.aBZ = 0;
        this.aCa = 0;
        this.aCb = 15.0f;
        this.aCc = -1;
        this.aCd = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aCe = -9989158;
        this.aCf = 200;
        this.aCg = 200;
        this.aCh = null;
        this.aCi = 0;
        this.aCj = 0;
        this.aCk = false;
        this.aCl = null;
        this.aCm = null;
        this.aCn = null;
        this.aCo = true;
        this.mIsFromCDN = true;
        this.aCp = -1;
        this.aCq = false;
        this.aCr = false;
        this.aCs = null;
        this.aCt = false;
        this.aCw = null;
        this.aCx = false;
        this.Bo = -1;
        this.aCz = -1;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.azq = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.TbRichTextView);
        this.aCa = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aBZ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aBY = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aCb = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aCb);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aCf = obtainStyledAttributes.getDimensionPixelSize(6, this.aCf);
        this.aCg = obtainStyledAttributes.getDimensionPixelSize(7, this.aCg);
        this.aCi = obtainStyledAttributes.getResourceId(8, 0);
        this.aCc = obtainStyledAttributes.getDimensionPixelSize(9, this.aCc);
        this.aCd = obtainStyledAttributes.getDimensionPixelSize(10, this.aCd);
        this.aCj = obtainStyledAttributes.getResourceId(11, 0);
        this.aCk = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f) {
        this.aBY = f;
    }

    private void init() {
        aBS = getContext().getResources().getDimensionPixelSize(i.d.adk_default_image_height);
        i iVar = null;
        if (getContext() instanceof i) {
            iVar = (i) getContext();
        } else {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (C != null && (C.getOrignalPage() instanceof i)) {
                iVar = (i) C.getOrignalPage();
            }
        }
        if (iVar != null) {
            this.aBT = iVar.getImageViewPool();
            this.aBU = iVar.getTextViewPool();
            this.aBV = iVar.getVoiceViewPool();
            this.aBW = iVar.getTextVoiceViewPool();
            this.aBX = iVar.getGifViewPool();
            if (iVar.getListView() != null && this.aCm == null) {
                this.aCm = new d(iVar.getRichTextViewId());
                iVar.getListView().setRecyclerListener(this.aCm);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new n(this));
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x001c */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EP;
        int i;
        boolean z2;
        SpannableStringBuilder EV;
        View a2;
        if (this.aCv != aVar) {
            this.aCv = aVar;
            removeAllViews();
            if (aVar != null && (EP = aVar.EP()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = EP.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ao = ao(getContext());
                            boolean a3 = a(next, ao, true);
                            if (z && !this.aCt && (EV = next.EV()) != null) {
                                this.aCt = EV.length() >= 200;
                            }
                            i = i2;
                            view2 = ao;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView an = an(getContext());
                                z2 = a(next, an, (this.aCf - getPaddingLeft()) - getPaddingRight(), this.aCg);
                                i = i2 + 1;
                                view2 = an;
                            }
                        } else if (next.getType() == 32) {
                            j EY = next.EY();
                            if (EY != null && EY.Fk()) {
                                a2 = b(EY);
                            } else {
                                a2 = a(next);
                            }
                            z2 = true;
                            view2 = a2;
                            i = i2;
                        } else if (next.getType() == 512) {
                            view2 = getVoiceView();
                            if (view2 != null) {
                                z2 = a(next, view2);
                                i = i2;
                                view2 = view2;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            view2 = textVoiceView;
                            z2 = a(next, (LinearLayout) textVoiceView);
                            i = i2;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            view2 = gifView;
                            z2 = a(next, gifView);
                            i = i2;
                        } else {
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        }
                        if (!z2 || view2 == null) {
                            i2 = i;
                        } else {
                            addView(view2);
                            i2 = i;
                            view = view2;
                        }
                    }
                }
                if (view != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.bottomMargin = this.aCa;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(j jVar) {
        if (jVar == null || !jVar.isAvaliable()) {
            return null;
        }
        LinearLayout gY = this.aBW.gY();
        if (gY != null) {
            gY.setOrientation(1);
            ImageView gY2 = this.aBT.gY();
            if (gY2 instanceof com.baidu.tbadk.widget.d) {
                com.baidu.tbadk.widget.d dVar = (com.baidu.tbadk.widget.d) gY2;
                dVar.setForegroundDrawable(i.e.icon_play_video);
                if (this.aCx) {
                    dVar.setSupportNoImage(true);
                }
                dVar.d(jVar.getThumbUrl(), 17, false);
                a(dVar, jVar.getWidth(), jVar.getHeight(), this.aCf, this.aCg);
                gY2.setOnClickListener(new o(this, jVar));
                gY.addView(dVar);
            }
            TextView gY3 = this.aBU.gY();
            if (gY3 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                gY3.setGravity(16);
                gY3.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds12));
                an.b(gY3, i.c.cp_link_tip_c, 1);
                gY3.setTextSize(0, getResources().getDimension(i.d.fontsize24));
                gY3.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.xiaoying_logo), (Drawable) null, (Drawable) null, (Drawable) null);
                gY3.setText(jVar.fR(getResources().getString(i.h.come_from_xiaoying)));
                gY3.setLayoutParams(layoutParams);
                gY.addView(gY3);
                return gY;
            }
            return gY;
        }
        return gY;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4) {
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aCo) {
            iArr[0] = i3;
            iArr[1] = aBS;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aCi);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aCy && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aCa;
                if (!this.aCy) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aCh == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aCh);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(this.mOnClickListener);
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aCa;
        if (!this.aCy) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.mOnClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aCj <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aCa;
        linearLayout.setClickable(true);
        Bitmap cw = an.cw(this.aCj);
        if (cw != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cw));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new p(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aCj;
    }

    public void setVideoImageId(int i) {
        this.aCj = i;
    }

    private ImageView an(Context context) {
        ImageView gY = this.aBT != null ? this.aBT.gY() : null;
        if (gY == null || gY.getParent() != null) {
            return null;
        }
        return gY;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        f EU = cVar.EU();
        if (EU == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aCx) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(EU.Fd(), this.mIsFromCDN ? 17 : 18, false);
            if (!EU.Fe()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, EU.getWidth(), EU.getHeight(), i, i2);
    }

    public void setImageViewStretch(boolean z) {
        this.aCy = z;
    }

    private TextView ao(Context context) {
        TextView textView = null;
        if (this.aBU != null) {
            textView = this.aBU.gY();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aBZ, 0, this.aBZ, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aCa;
        textView.setLineSpacing(0.0f, this.aBY);
        textView.setTextSize(0, this.aCb);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aCe);
        textView.setSingleLine(this.aCk);
        if (this.aCl != null) {
            textView.setEllipsize(this.aCl);
        }
        if (this.Bo > 0) {
            textView.setMaxWidth(this.Bo);
        }
        if (this.aCz > 0) {
            textView.setMaxLines(this.aCz);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder EV = cVar.EV();
        if (EV == null || EV.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aCd > 0 && this.aCc > 0) {
            cVar.O(this.aCc, this.aCd);
        }
        if (textSize > 0) {
            cVar.N(lineHeight, textSize);
        }
        try {
            textView.setText(EV);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.EX() != null) {
            cVar.EX().aBG = this.aCA;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aBX != null) {
            gifView = this.aBX.gY();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.EZ().atF.atj || layoutParams.height != cVar.EZ().atF.atk) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.EZ().atF.atj, cVar.EZ().atF.atk);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.EZ().atF);
        return true;
    }

    private View getVoiceView() {
        View gY = this.aBV != null ? this.aBV.gY() : null;
        if ((gY == null || gY.getParent() != null) && this.aCp != -1) {
            gY = LayoutInflater.from(getContext()).inflate(this.aCp, (ViewGroup) null);
        }
        if (gY != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aCa;
            layoutParams.bottomMargin = this.aCa;
            gY.setLayoutParams(layoutParams);
            return gY;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.EW());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout gY = this.aBW.gY();
        if (gY != null) {
            TextView ao = ao(getContext());
            if (ao == null) {
                this.aBW.k(gY);
                return null;
            }
            gY.addView(ao);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aBU.k(ao);
                this.aBW.k(gY);
                return null;
            }
            gY.addView(voiceView);
            return gY;
        }
        return gY;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, LinearLayout linearLayout) {
        boolean a2;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt == null) {
                a2 = z;
            } else if (childAt instanceof TextView) {
                a2 = a(cVar, (TextView) childAt, false) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBnt") ? a(cVar, childAt) & z : z;
            }
            i++;
            z = a2;
        }
        return z;
    }

    public void setTextSize(float f) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f, resources.getDisplayMetrics());
        if (applyDimension != this.aCb) {
            this.aCb = applyDimension;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, applyDimension);
                }
            }
        }
    }

    public void setTextColor(int i) {
        if (i != this.mTextColor) {
            this.mTextColor = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void setTextPadding(int i) {
        if (this.aBZ != i) {
            this.aBZ = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aBZ, 0, 0, this.aBZ);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aCe) {
            this.aCe = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    public int getMaxImageWidth() {
        return this.aCf;
    }

    public void setMaxImageWidth(int i) {
        this.aCf = i;
    }

    public int getMaxImageHeight() {
        return this.aCg;
    }

    public void setMaxImageHeight(int i) {
        this.aCg = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aCh;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aCh = scaleType;
    }

    public int getDefaultImageId() {
        return this.aCi;
    }

    public void setDefaultImageId(int i) {
        this.aCi = i;
    }

    public c getOnImageClickListener() {
        return this.aCn;
    }

    public void setOnImageClickListener(c cVar) {
        this.aCn = cVar;
    }

    public void setOnEmotionClickListener(b bVar) {
        this.aCu = bVar;
    }

    public void f(boolean z, boolean z2) {
        if (this.aCo != z) {
            this.aCo = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aCo && this.aBT != null) {
                this.aBT.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements AbsListView.RecyclerListener {
        private int mId;

        public d(int i) {
            this.mId = 0;
            this.mId = i;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(this.mId);
            if (findViewById != null && (findViewById instanceof TbRichTextView)) {
                ((TbRichTextView) findViewById).setText(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.aCq = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aCr) {
                    Fo();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aCq) {
                    Fn();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aCq = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Fn() {
        this.aCr = false;
        if (this.aCs == null) {
            this.aCs = new a();
        }
        postDelayed(this.aCs, ViewConfiguration.getLongPressTimeout());
    }

    private void Fo() {
        if (this.aCs != null) {
            removeCallbacks(this.aCs);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aCr = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aCp = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aCw = null;
        if (this.aCB != drawable) {
            this.aCA = true;
            this.aCB = drawable;
        }
        setText(this.aCv);
        this.aCA = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BZ();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        BZ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            BZ();
        } else {
            refresh();
        }
    }

    public void fS(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.atH == bdUniqueId)) {
            BZ();
        }
        this.mUrl = str;
        this.atH = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ha().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.ha().W(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, 19, this.azq, 0, 0, this.atH, new Object[0]);
        }
    }

    public void BZ() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.ha().a(this.mUrl, 19, this.azq);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.na(), aVar.na().getNinePatchChunk(), aVar.ne(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        fS(this.mUrl);
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnClickListener(onClickListener);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
            }
        }
    }

    public TextView getTextView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TbListTextView) {
                return (TbListTextView) childAt;
            }
        }
        return null;
    }
}
