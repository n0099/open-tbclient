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
    static int aAK = 174;
    private int Bo;
    private com.baidu.adp.lib.e.b<ImageView> aAL;
    private com.baidu.adp.lib.e.b<TextView> aAM;
    private com.baidu.adp.lib.e.b<View> aAN;
    private com.baidu.adp.lib.e.b<LinearLayout> aAO;
    private com.baidu.adp.lib.e.b<GifView> aAP;
    private float aAQ;
    private int aAR;
    private int aAS;
    private float aAT;
    private int aAU;
    private int aAV;
    private int aAW;
    private int aAX;
    private int aAY;
    private ImageView.ScaleType aAZ;
    private int aBa;
    private int aBb;
    private boolean aBc;
    private TextUtils.TruncateAt aBd;
    private f aBe;
    private d aBf;
    private e aBg;
    private boolean aBh;
    private int aBi;
    private boolean aBj;
    private boolean aBk;
    private Runnable aBl;
    private boolean aBm;
    private c aBn;
    private com.baidu.tbadk.widget.richText.a aBo;
    private String aBp;
    private boolean aBq;
    private boolean aBr;
    private int aBs;
    public final View.OnClickListener aBt;
    private boolean aBu;
    private Drawable aBv;
    private BdUniqueId asv;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aye;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

    /* loaded from: classes.dex */
    public interface c {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, String str, int i);
    }

    /* loaded from: classes.dex */
    public interface e {
        void b(View view, String str);
    }

    public boolean Fi() {
        return this.aBm;
    }

    public void Fj() {
        this.aBq = true;
    }

    public String getBackgroundImageUrl() {
        return this.aBp;
    }

    public void setBackgroundImageUrl(String str) {
        this.aBp = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Bo = i;
    }

    public void setMaxLines(int i) {
        this.aBs = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aBd = truncateAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public String url;

        public b(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            return ((view instanceof TbImageView) && view.getTag() != null && (view.getTag() instanceof b)) ? false : true;
        }
        return false;
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new q(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aAL = null;
        this.aAM = null;
        this.aAN = null;
        this.aAO = null;
        this.aAP = null;
        this.aAQ = 0.0f;
        this.aAR = 0;
        this.aAS = 0;
        this.aAT = 15.0f;
        this.aAU = -1;
        this.aAV = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aAW = -9989158;
        this.aAX = 200;
        this.aAY = 200;
        this.aAZ = null;
        this.aBa = 0;
        this.aBb = 0;
        this.aBc = false;
        this.aBd = null;
        this.aBe = null;
        this.aBf = null;
        this.aBg = null;
        this.aBh = true;
        this.mIsFromCDN = true;
        this.aBi = -1;
        this.aBj = false;
        this.aBk = false;
        this.aBl = null;
        this.aBm = false;
        this.aBp = null;
        this.aBq = false;
        this.Bo = -1;
        this.aBs = -1;
        this.mOnClickListener = new n(this);
        this.aBt = new o(this);
        this.mType = 19;
        this.aye = new p(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAL = null;
        this.aAM = null;
        this.aAN = null;
        this.aAO = null;
        this.aAP = null;
        this.aAQ = 0.0f;
        this.aAR = 0;
        this.aAS = 0;
        this.aAT = 15.0f;
        this.aAU = -1;
        this.aAV = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aAW = -9989158;
        this.aAX = 200;
        this.aAY = 200;
        this.aAZ = null;
        this.aBa = 0;
        this.aBb = 0;
        this.aBc = false;
        this.aBd = null;
        this.aBe = null;
        this.aBf = null;
        this.aBg = null;
        this.aBh = true;
        this.mIsFromCDN = true;
        this.aBi = -1;
        this.aBj = false;
        this.aBk = false;
        this.aBl = null;
        this.aBm = false;
        this.aBp = null;
        this.aBq = false;
        this.Bo = -1;
        this.aBs = -1;
        this.mOnClickListener = new n(this);
        this.aBt = new o(this);
        this.mType = 19;
        this.aye = new p(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.TbRichTextView);
        this.aAS = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aAR = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aAQ = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aAT = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aAT);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aAX = obtainStyledAttributes.getDimensionPixelSize(6, this.aAX);
        this.aAY = obtainStyledAttributes.getDimensionPixelSize(7, this.aAY);
        this.aBa = obtainStyledAttributes.getResourceId(8, 0);
        this.aAU = obtainStyledAttributes.getDimensionPixelSize(9, this.aAU);
        this.aAV = obtainStyledAttributes.getDimensionPixelSize(10, this.aAV);
        this.aBb = obtainStyledAttributes.getResourceId(11, 0);
        this.aBc = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aAQ = f2;
    }

    private void init() {
        aAK = getContext().getResources().getDimensionPixelSize(i.d.adk_default_image_height);
        l lVar = null;
        if (getContext() instanceof l) {
            lVar = (l) getContext();
        } else {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (C != null && (C.getOrignalPage() instanceof l)) {
                lVar = (l) C.getOrignalPage();
            }
        }
        if (lVar != null) {
            this.aAL = lVar.getImageViewPool();
            this.aAM = lVar.getTextViewPool();
            this.aAN = lVar.getVoiceViewPool();
            this.aAO = lVar.getTextVoiceViewPool();
            this.aAP = lVar.getGifViewPool();
            if (lVar.getListView() != null && this.aBe == null) {
                this.aBe = new f(lVar.getRichTextViewId());
                lVar.getListView().setRecyclerListener(this.aBe);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new r(this));
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x001c */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> EI;
        int i;
        boolean z2;
        SpannableStringBuilder EO;
        View a2;
        if (this.aBo != aVar) {
            this.aBo = aVar;
            removeAllViews();
            if (aVar != null && (EI = aVar.EI()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = EI.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ao = ao(getContext());
                            boolean a3 = a(next, ao, true);
                            if (z && !this.aBm && (EO = next.EO()) != null) {
                                this.aBm = EO.length() >= 200;
                            }
                            i = i2;
                            view2 = ao;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView an = an(getContext());
                                z2 = b(next, an, (this.aAX - getPaddingLeft()) - getPaddingRight(), this.aAY);
                                i = i2 + 1;
                                view2 = an;
                            }
                        } else if (next.getType() == 32) {
                            m ER = next.ER();
                            if (ER != null && ER.Fh()) {
                                a2 = b(ER);
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
                        } else if (next.getType() == 1280) {
                            ImageView an2 = an(getContext());
                            z2 = a(next, an2, (this.aAX - getPaddingLeft()) - getPaddingRight(), this.aAY);
                            i = i2 + 1;
                            view2 = an2;
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
                    layoutParams.bottomMargin = this.aAS;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(m mVar) {
        if (mVar == null || !mVar.isAvaliable()) {
            return null;
        }
        LinearLayout gZ = this.aAO.gZ();
        if (gZ != null) {
            gZ.setOrientation(1);
            ImageView gZ2 = this.aAL.gZ();
            if (gZ2 instanceof com.baidu.tbadk.widget.d) {
                com.baidu.tbadk.widget.d dVar = (com.baidu.tbadk.widget.d) gZ2;
                dVar.setForegroundDrawable(i.e.icon_play_video);
                if (this.aBq) {
                    dVar.setSupportNoImage(true);
                }
                dVar.d(mVar.getThumbUrl(), 17, false);
                a(dVar, mVar.getWidth(), mVar.getHeight(), this.aAX, this.aAY, this.mOnClickListener);
                gZ2.setOnClickListener(new s(this, mVar));
                gZ.addView(dVar);
            }
            TextView gZ3 = this.aAM.gZ();
            if (gZ3 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                gZ3.setGravity(16);
                gZ3.setCompoundDrawablePadding(getResources().getDimensionPixelSize(i.d.ds12));
                an.b(gZ3, i.c.cp_link_tip_c, 1);
                gZ3.setTextSize(0, getResources().getDimension(i.d.fontsize24));
                gZ3.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.xiaoying_logo), (Drawable) null, (Drawable) null, (Drawable) null);
                gZ3.setText(mVar.fT(getResources().getString(i.h.come_from_xiaoying)));
                gZ3.setLayoutParams(layoutParams);
                gZ.addView(gZ3);
                return gZ;
            }
            return gZ;
        }
        return gZ;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aBh) {
            iArr[0] = i3;
            iArr[1] = aAK;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aBa);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aBr && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aAS;
                if (!this.aBr) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aAZ == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aAZ);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aAS;
        if (!this.aBr) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aBb <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aAS;
        linearLayout.setClickable(true);
        Bitmap cw = an.cw(this.aBb);
        if (cw != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cw));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new t(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aBb;
    }

    public void setVideoImageId(int i) {
        this.aBb = i;
    }

    private ImageView an(Context context) {
        ImageView gZ = this.aAL != null ? this.aAL.gZ() : null;
        if (gZ == null || gZ.getParent() != null) {
            return null;
        }
        return gZ;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        k EU = cVar.EU();
        if (EU != null && EU.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aBq) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.d(EU.Fg(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(EU.getLink()));
                if (!EU.EZ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, EU.getWidth(), EU.getHeight(), i, i2, this.aBt);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.f EN = cVar.EN();
        if (EN == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aBq) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(EN.EY(), this.mIsFromCDN ? 17 : 18, false);
            if (!EN.EZ()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, EN.getWidth(), EN.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aBr = z;
    }

    private TextView ao(Context context) {
        TextView textView = null;
        if (this.aAM != null) {
            textView = this.aAM.gZ();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aAR, 0, this.aAR, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aAS;
        textView.setLineSpacing(0.0f, this.aAQ);
        textView.setTextSize(0, this.aAT);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aAW);
        textView.setSingleLine(this.aBc);
        if (this.aBd != null) {
            textView.setEllipsize(this.aBd);
        }
        if (this.Bo > 0) {
            textView.setMaxWidth(this.Bo);
        }
        if (this.aBs > 0) {
            textView.setMaxLines(this.aBs);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder EO = cVar.EO();
        if (EO == null || EO.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aAV > 0 && this.aAU > 0) {
            cVar.O(this.aAU, this.aAV);
        }
        if (textSize > 0) {
            cVar.N(lineHeight, textSize);
        }
        try {
            textView.setText(EO);
        } catch (Exception e2) {
            textView.setText("");
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.EQ() != null) {
            cVar.EQ().aAx = this.aBu;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aAP != null) {
            gifView = this.aAP.gZ();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.ES().ast.arX || layoutParams.height != cVar.ES().ast.arY) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.ES().ast.arX, cVar.ES().ast.arY);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new u(this, cVar));
        gifView.a(cVar.ES().ast);
        return true;
    }

    private View getVoiceView() {
        View gZ = this.aAN != null ? this.aAN.gZ() : null;
        if ((gZ == null || gZ.getParent() != null) && this.aBi != -1) {
            gZ = LayoutInflater.from(getContext()).inflate(this.aBi, (ViewGroup) null);
        }
        if (gZ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aAS;
            layoutParams.bottomMargin = this.aAS;
            gZ.setLayoutParams(layoutParams);
            return gZ;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.EP());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout gZ = this.aAO.gZ();
        if (gZ != null) {
            TextView ao = ao(getContext());
            if (ao == null) {
                this.aAO.k(gZ);
                return null;
            }
            gZ.addView(ao);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aAM.k(ao);
                this.aAO.k(gZ);
                return null;
            }
            gZ.addView(voiceView);
            return gZ;
        }
        return gZ;
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

    public void setTextSize(float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f2, resources.getDisplayMetrics());
        if (applyDimension != this.aAT) {
            this.aAT = applyDimension;
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
        if (this.aAR != i) {
            this.aAR = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aAR, 0, 0, this.aAR);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aAW) {
            this.aAW = i;
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
        return this.aAX;
    }

    public void setMaxImageWidth(int i) {
        this.aAX = i;
    }

    public int getMaxImageHeight() {
        return this.aAY;
    }

    public void setMaxImageHeight(int i) {
        this.aAY = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aAZ;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aAZ = scaleType;
    }

    public int getDefaultImageId() {
        return this.aBa;
    }

    public void setDefaultImageId(int i) {
        this.aBa = i;
    }

    public d getOnImageClickListener() {
        return this.aBf;
    }

    public void setOnImageClickListener(d dVar) {
        this.aBf = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aBn = cVar;
    }

    public void f(boolean z, boolean z2) {
        if (this.aBh != z) {
            this.aBh = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aBh && this.aAL != null) {
                this.aAL.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f implements AbsListView.RecyclerListener {
        private int mId;

        public f(int i) {
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
        this.aBj = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aBk) {
                    Fl();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aBj) {
                    Fk();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aBj = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Fk() {
        this.aBk = false;
        if (this.aBl == null) {
            this.aBl = new a();
        }
        postDelayed(this.aBl, ViewConfiguration.getLongPressTimeout());
    }

    private void Fl() {
        if (this.aBl != null) {
            removeCallbacks(this.aBl);
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
                TbRichTextView.this.aBk = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aBi = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aBp = null;
        if (this.aBv != drawable) {
            this.aBu = true;
            this.aBv = drawable;
        }
        setText(this.aBo);
        this.aBu = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BS();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        BS();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            BS();
        } else {
            refresh();
        }
    }

    public void fU(String str) {
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
        if (!(str.equals(this.mUrl) && this.asv == bdUniqueId)) {
            BS();
        }
        this.mUrl = str;
        this.asv = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.hb().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.hb().W(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.hb().a(this.mUrl, 19, this.aye, 0, 0, this.asv, new Object[0]);
        }
    }

    public void BS() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.hb().a(this.mUrl, 19, this.aye);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.nb(), aVar.nb().getNinePatchChunk(), aVar.nf(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        fU(this.mUrl);
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

    public e getOnLinkImageClickListener() {
        return this.aBg;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aBg = eVar;
    }
}
