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
import com.baidu.tbadk.core.util.al;
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
    static int aDm = 174;
    private int Bn;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aAE;
    private int aDA;
    private ImageView.ScaleType aDB;
    private int aDC;
    private int aDD;
    private boolean aDE;
    private d aDF;
    private c aDG;
    private boolean aDH;
    private int aDI;
    private boolean aDJ;
    private boolean aDK;
    private Runnable aDL;
    private boolean aDM;
    private b aDN;
    private com.baidu.tbadk.widget.richText.a aDO;
    private String aDP;
    private boolean aDQ;
    private boolean aDR;
    private int aDS;
    private boolean aDT;
    private Drawable aDU;
    private com.baidu.adp.lib.e.b<ImageView> aDn;
    private com.baidu.adp.lib.e.b<TextView> aDo;
    private com.baidu.adp.lib.e.b<View> aDp;
    private com.baidu.adp.lib.e.b<LinearLayout> aDq;
    private com.baidu.adp.lib.e.b<GifView> aDr;
    private float aDs;
    private int aDt;
    private int aDu;
    private float aDv;
    private int aDw;
    private int aDx;
    private int aDy;
    private int aDz;
    private BdUniqueId avj;
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

    public boolean FB() {
        return this.aDM;
    }

    public void FC() {
        this.aDQ = true;
    }

    public String getBackgroundImageUrl() {
        return this.aDP;
    }

    public void setBackgroundImageUrl(String str) {
        this.aDP = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bn = i;
    }

    public void setMaxLines(int i) {
        this.aDS = i;
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
        this.aDn = null;
        this.aDo = null;
        this.aDp = null;
        this.aDq = null;
        this.aDr = null;
        this.aDs = 0.0f;
        this.aDt = 0;
        this.aDu = 0;
        this.aDv = 15.0f;
        this.aDw = -1;
        this.aDx = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aDy = -9989158;
        this.aDz = 200;
        this.aDA = 200;
        this.aDB = null;
        this.aDC = 0;
        this.aDD = 0;
        this.aDE = false;
        this.aDF = null;
        this.aDG = null;
        this.aDH = true;
        this.mIsFromCDN = true;
        this.aDI = -1;
        this.aDJ = false;
        this.aDK = false;
        this.aDL = null;
        this.aDM = false;
        this.aDP = null;
        this.aDQ = false;
        this.Bn = -1;
        this.aDS = -1;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.aAE = new l(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDn = null;
        this.aDo = null;
        this.aDp = null;
        this.aDq = null;
        this.aDr = null;
        this.aDs = 0.0f;
        this.aDt = 0;
        this.aDu = 0;
        this.aDv = 15.0f;
        this.aDw = -1;
        this.aDx = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aDy = -9989158;
        this.aDz = 200;
        this.aDA = 200;
        this.aDB = null;
        this.aDC = 0;
        this.aDD = 0;
        this.aDE = false;
        this.aDF = null;
        this.aDG = null;
        this.aDH = true;
        this.mIsFromCDN = true;
        this.aDI = -1;
        this.aDJ = false;
        this.aDK = false;
        this.aDL = null;
        this.aDM = false;
        this.aDP = null;
        this.aDQ = false;
        this.Bn = -1;
        this.aDS = -1;
        this.mOnClickListener = new k(this);
        this.mType = 19;
        this.aAE = new l(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.TbRichTextView);
        this.aDu = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aDt = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aDs = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aDv = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aDv);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aDz = obtainStyledAttributes.getDimensionPixelSize(6, this.aDz);
        this.aDA = obtainStyledAttributes.getDimensionPixelSize(7, this.aDA);
        this.aDC = obtainStyledAttributes.getResourceId(8, 0);
        this.aDw = obtainStyledAttributes.getDimensionPixelSize(9, this.aDw);
        this.aDx = obtainStyledAttributes.getDimensionPixelSize(10, this.aDx);
        this.aDD = obtainStyledAttributes.getResourceId(11, 0);
        this.aDE = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f) {
        this.aDs = f;
    }

    private void init() {
        aDm = getContext().getResources().getDimensionPixelSize(i.d.adk_default_image_height);
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
            this.aDn = iVar.getImageViewPool();
            this.aDo = iVar.getTextViewPool();
            this.aDp = iVar.getVoiceViewPool();
            this.aDq = iVar.getTextVoiceViewPool();
            this.aDr = iVar.getGifViewPool();
            if (iVar.getListView() != null && this.aDF == null) {
                this.aDF = new d(iVar.getRichTextViewId());
                iVar.getListView().setRecyclerListener(this.aDF);
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
        ArrayList<com.baidu.tbadk.widget.richText.c> Fg;
        int i;
        boolean z2;
        SpannableStringBuilder Fm;
        View a2;
        if (this.aDO != aVar) {
            this.aDO = aVar;
            removeAllViews();
            if (aVar != null && (Fg = aVar.Fg()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = Fg.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ap = ap(getContext());
                            boolean a3 = a(next, ap, true);
                            if (z && !this.aDM && (Fm = next.Fm()) != null) {
                                this.aDM = Fm.length() >= 200;
                            }
                            i = i2;
                            view2 = ap;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ao = ao(getContext());
                                z2 = a(next, ao, (this.aDz - getPaddingLeft()) - getPaddingRight(), this.aDA);
                                i = i2 + 1;
                                view2 = ao;
                            }
                        } else if (next.getType() == 32) {
                            j Fp = next.Fp();
                            if (Fp != null && Fp.FA()) {
                                a2 = b(Fp);
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
                    layoutParams.bottomMargin = this.aDu;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(j jVar) {
        if (jVar == null || !jVar.isAvaliable()) {
            return null;
        }
        LinearLayout gX = this.aDq.gX();
        if (gX != null) {
            gX.setOrientation(1);
            ImageView gX2 = this.aDn.gX();
            if (gX2 instanceof com.baidu.tbadk.widget.d) {
                com.baidu.tbadk.widget.d dVar = (com.baidu.tbadk.widget.d) gX2;
                dVar.setForegroundDrawable(i.e.icon_play_video);
                if (this.aDQ) {
                    dVar.setSupportNoImage(true);
                }
                dVar.d(jVar.getThumbUrl(), 17, false);
                a(dVar, jVar.getWidth(), jVar.getHeight(), this.aDz, this.aDA);
                gX2.setOnClickListener(new o(this, jVar));
                gX.addView(dVar);
            }
            TextView gX3 = this.aDo.gX();
            if (gX3 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                gX3.setGravity(16);
                gX3.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds12));
                al.b(gX3, i.c.cp_link_tip_c, 1);
                gX3.setTextSize(0, getResources().getDimension(i.d.fontsize24));
                gX3.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.xiaoying_logo), (Drawable) null, (Drawable) null, (Drawable) null);
                gX3.setText(jVar.fN(getResources().getString(i.h.come_from_xiaoying)));
                gX3.setLayoutParams(layoutParams);
                gX.addView(gX3);
                return gX;
            }
            return gX;
        }
        return gX;
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
        if (!this.aDH) {
            iArr[0] = i3;
            iArr[1] = aDm;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aDC);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aDR && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aDu;
                if (!this.aDR) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aDB == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aDB);
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
        layoutParams2.topMargin = this.aDu;
        if (!this.aDR) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.mOnClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aDD <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aDu;
        linearLayout.setClickable(true);
        Bitmap cu = al.cu(this.aDD);
        if (cu != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cu));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new p(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aDD;
    }

    public void setVideoImageId(int i) {
        this.aDD = i;
    }

    private ImageView ao(Context context) {
        ImageView gX = this.aDn != null ? this.aDn.gX() : null;
        if (gX == null || gX.getParent() != null) {
            return null;
        }
        return gX;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        f Fl = cVar.Fl();
        if (Fl == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aDQ) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(Fl.Fu(), this.mIsFromCDN ? 17 : 18, false);
            if (!Fl.Fv()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Fl.getWidth(), Fl.getHeight(), i, i2);
    }

    public void setImageViewStretch(boolean z) {
        this.aDR = z;
    }

    private TextView ap(Context context) {
        TextView textView = null;
        if (this.aDo != null) {
            textView = this.aDo.gX();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aDt, 0, this.aDt, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aDu;
        textView.setLineSpacing(0.0f, this.aDs);
        textView.setTextSize(0, this.aDv);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aDy);
        textView.setSingleLine(this.aDE);
        if (this.Bn > 0) {
            textView.setMaxWidth(this.Bn);
        }
        if (this.aDS > 0) {
            textView.setMaxLines(this.aDS);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder Fm = cVar.Fm();
        if (Fm == null || Fm.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aDx > 0 && this.aDw > 0) {
            cVar.O(this.aDw, this.aDx);
        }
        if (textSize > 0) {
            cVar.N(lineHeight, textSize);
        }
        try {
            textView.setText(Fm);
        } catch (Exception e) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.Fo() != null) {
            cVar.Fo().aDc = this.aDT;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aDr != null) {
            gifView = this.aDr.gX();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Fq().avh.auL || layoutParams.height != cVar.Fq().avh.auM) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Fq().avh.auL, cVar.Fq().avh.auM);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.Fq().avh);
        return true;
    }

    private View getVoiceView() {
        View gX = this.aDp != null ? this.aDp.gX() : null;
        if ((gX == null || gX.getParent() != null) && this.aDI != -1) {
            gX = LayoutInflater.from(getContext()).inflate(this.aDI, (ViewGroup) null);
        }
        if (gX != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aDu;
            layoutParams.bottomMargin = this.aDu;
            gX.setLayoutParams(layoutParams);
            return gX;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.Fn());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout gX = this.aDq.gX();
        if (gX != null) {
            TextView ap = ap(getContext());
            if (ap == null) {
                this.aDq.k(gX);
                return null;
            }
            gX.addView(ap);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aDo.k(ap);
                this.aDq.k(gX);
                return null;
            }
            gX.addView(voiceView);
            return gX;
        }
        return gX;
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
        if (applyDimension != this.aDv) {
            this.aDv = applyDimension;
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
        if (this.aDt != i) {
            this.aDt = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aDt, 0, 0, this.aDt);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aDy) {
            this.aDy = i;
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
        return this.aDz;
    }

    public void setMaxImageWidth(int i) {
        this.aDz = i;
    }

    public int getMaxImageHeight() {
        return this.aDA;
    }

    public void setMaxImageHeight(int i) {
        this.aDA = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aDB;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aDB = scaleType;
    }

    public int getDefaultImageId() {
        return this.aDC;
    }

    public void setDefaultImageId(int i) {
        this.aDC = i;
    }

    public c getOnImageClickListener() {
        return this.aDG;
    }

    public void setOnImageClickListener(c cVar) {
        this.aDG = cVar;
    }

    public void setOnEmotionClickListener(b bVar) {
        this.aDN = bVar;
    }

    public void f(boolean z, boolean z2) {
        if (this.aDH != z) {
            this.aDH = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aDH && this.aDn != null) {
                this.aDn.clear();
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
        this.aDJ = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aDK) {
                    FE();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aDJ) {
                    FD();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aDJ = true;
        return super.onTouchEvent(motionEvent);
    }

    private void FD() {
        this.aDK = false;
        if (this.aDL == null) {
            this.aDL = new a();
        }
        postDelayed(this.aDL, ViewConfiguration.getLongPressTimeout());
    }

    private void FE() {
        if (this.aDL != null) {
            removeCallbacks(this.aDL);
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
                TbRichTextView.this.aDK = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aDI = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aDP = null;
        if (this.aDU != drawable) {
            this.aDT = true;
            this.aDU = drawable;
        }
        setText(this.aDO);
        this.aDT = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Cp();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Cp();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Cp();
        } else {
            refresh();
        }
    }

    public void fO(String str) {
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
        if (!(str.equals(this.mUrl) && this.avj == bdUniqueId)) {
            Cp();
        }
        this.mUrl = str;
        this.avj = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.gZ().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            d(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.gZ().W(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.gZ().a(this.mUrl, 19, this.aAE, 0, 0, this.avj, new Object[0]);
        }
    }

    public void Cp() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.gZ().a(this.mUrl, 19, this.aAE);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mZ(), aVar.mZ().getNinePatchChunk(), aVar.nd(), null);
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
        fO(this.mUrl);
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
