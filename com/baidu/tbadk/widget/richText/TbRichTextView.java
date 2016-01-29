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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int aFN = 174;
    private int BF;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aCG;
    private com.baidu.adp.lib.f.b<ImageView> aFO;
    private com.baidu.adp.lib.f.b<TextView> aFP;
    private com.baidu.adp.lib.f.b<View> aFQ;
    private com.baidu.adp.lib.f.b<LinearLayout> aFR;
    private com.baidu.adp.lib.f.b<GifView> aFS;
    private float aFT;
    private int aFU;
    private int aFV;
    private float aFW;
    private int aFX;
    private int aFY;
    private int aFZ;
    private int aGa;
    private int aGb;
    private ImageView.ScaleType aGc;
    private int aGd;
    private int aGe;
    private boolean aGf;
    private TextUtils.TruncateAt aGg;
    private f aGh;
    private d aGi;
    private e aGj;
    private boolean aGk;
    private int aGl;
    private boolean aGm;
    private boolean aGn;
    private Runnable aGo;
    private boolean aGp;
    private c aGq;
    private com.baidu.tbadk.widget.richText.a aGr;
    private String aGs;
    private boolean aGt;
    private boolean aGu;
    private int aGv;
    private boolean aGw;
    public final View.OnClickListener aGx;
    private boolean aGy;
    private Drawable aGz;
    private BdUniqueId awS;
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

    public boolean HB() {
        return this.aGp;
    }

    public void HC() {
        this.aGt = true;
    }

    public String getBackgroundImageUrl() {
        return this.aGs;
    }

    public void setBackgroundImageUrl(String str) {
        this.aGs = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BF = i;
    }

    public void setMaxLines(int i) {
        this.aGv = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aGg = truncateAt;
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
    public boolean K(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof b) {
                    return false;
                }
                if ((view.getTag() instanceof String) && TextUtils.equals("VideoView", (String) view.getTag())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.f.b<TextView> g(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new q(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aFO = null;
        this.aFP = null;
        this.aFQ = null;
        this.aFR = null;
        this.aFS = null;
        this.aFT = 0.0f;
        this.aFU = 0;
        this.aFV = 0;
        this.aFW = 15.0f;
        this.aFX = -1;
        this.aFY = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aFZ = -9989158;
        this.aGa = 200;
        this.aGb = 200;
        this.aGc = null;
        this.aGd = 0;
        this.aGe = 0;
        this.aGf = false;
        this.aGg = null;
        this.aGh = null;
        this.aGi = null;
        this.aGj = null;
        this.aGk = true;
        this.mIsFromCDN = true;
        this.aGl = -1;
        this.aGm = false;
        this.aGn = false;
        this.aGo = null;
        this.aGp = false;
        this.aGs = null;
        this.aGt = false;
        this.BF = -1;
        this.aGv = -1;
        this.aGw = true;
        this.mOnClickListener = new n(this);
        this.aGx = new o(this);
        this.mType = 19;
        this.aCG = new p(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFO = null;
        this.aFP = null;
        this.aFQ = null;
        this.aFR = null;
        this.aFS = null;
        this.aFT = 0.0f;
        this.aFU = 0;
        this.aFV = 0;
        this.aFW = 15.0f;
        this.aFX = -1;
        this.aFY = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aFZ = -9989158;
        this.aGa = 200;
        this.aGb = 200;
        this.aGc = null;
        this.aGd = 0;
        this.aGe = 0;
        this.aGf = false;
        this.aGg = null;
        this.aGh = null;
        this.aGi = null;
        this.aGj = null;
        this.aGk = true;
        this.mIsFromCDN = true;
        this.aGl = -1;
        this.aGm = false;
        this.aGn = false;
        this.aGo = null;
        this.aGp = false;
        this.aGs = null;
        this.aGt = false;
        this.BF = -1;
        this.aGv = -1;
        this.aGw = true;
        this.mOnClickListener = new n(this);
        this.aGx = new o(this);
        this.mType = 19;
        this.aCG = new p(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.TbRichTextView);
        this.aFV = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aFU = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aFT = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aFW = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aFW);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aGa = obtainStyledAttributes.getDimensionPixelSize(6, this.aGa);
        this.aGb = obtainStyledAttributes.getDimensionPixelSize(7, this.aGb);
        this.aGd = obtainStyledAttributes.getResourceId(8, 0);
        this.aFX = obtainStyledAttributes.getDimensionPixelSize(9, this.aFX);
        this.aFY = obtainStyledAttributes.getDimensionPixelSize(10, this.aFY);
        this.aGe = obtainStyledAttributes.getResourceId(11, 0);
        this.aGf = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aFT = f2;
    }

    private void init() {
        aFN = getContext().getResources().getDimensionPixelSize(t.e.adk_default_image_height);
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
            this.aFO = lVar.Hs();
            this.aFP = lVar.Ht();
            this.aFQ = lVar.Hv();
            this.aFR = lVar.Hw();
            this.aFS = lVar.Hu();
            if (lVar.getListView() != null && this.aGh == null) {
                this.aGh = new f(lVar.Hr());
                lVar.getListView().setRecyclerListener(this.aGh);
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
        ArrayList<com.baidu.tbadk.widget.richText.c> GS;
        int i;
        boolean z2;
        SpannableStringBuilder GY;
        View a2;
        if (this.aGr != aVar) {
            this.aGr = aVar;
            removeAllViews();
            if (aVar != null && (GS = aVar.GS()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = GS.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aq = aq(getContext());
                            boolean a3 = a(next, aq, true);
                            if (z && !this.aGp && (GY = next.GY()) != null) {
                                this.aGp = GY.length() >= 200;
                            }
                            i = i2;
                            view2 = aq;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ap = ap(getContext());
                                z2 = b(next, ap, (this.aGa - getPaddingLeft()) - getPaddingRight(), this.aGb);
                                i = i2 + 1;
                                view2 = ap;
                            }
                        } else if (next.getType() == 32) {
                            m Hb = next.Hb();
                            if (Hb != null && Hb.Hz()) {
                                a2 = b(Hb);
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
                            ImageView ap2 = ap(getContext());
                            z2 = a(next, ap2, (this.aGa - getPaddingLeft()) - getPaddingRight(), this.aGb);
                            i = i2 + 1;
                            view2 = ap2;
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
                    layoutParams.bottomMargin = this.aFV;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(m mVar) {
        if (mVar == null || !mVar.isAvaliable()) {
            return null;
        }
        ImageView hj = this.aFO.hj();
        if (hj instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) hj;
            foreDrawableImageView.setForegroundDrawable(t.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(t.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, mVar.getWidth(), mVar.getHeight(), (this.aGa - getPaddingLeft()) - getPaddingRight(), this.aGb, new s(this, mVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aGt);
            if (com.baidu.tbadk.core.l.rn().rt()) {
                foreDrawableImageView.setDefaultBgResource(t.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(t.d.cp_bg_line_c);
            }
            foreDrawableImageView.d(mVar.Hx(), 17, false);
            return hj;
        }
        return hj;
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
        if (!this.aGk) {
            iArr[0] = i3;
            iArr[1] = aFN;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aGd);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aGu && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aFV;
                if (!this.aGu) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aGc == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aGc);
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
        layoutParams2.topMargin = this.aFV;
        if (!this.aGu) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aGe <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aFV;
        linearLayout.setClickable(true);
        Bitmap cO = ar.cO(this.aGe);
        if (cO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cO));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new t(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aGe;
    }

    public void setVideoImageId(int i) {
        this.aGe = i;
    }

    private ImageView ap(Context context) {
        ImageView hj = this.aFO != null ? this.aFO.hj() : null;
        if (hj == null || hj.getParent() != null) {
            return null;
        }
        return hj;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        k He = cVar.He();
        if (He != null && He.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aGt) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.d(He.Hq(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(He.getLink()));
                if (!He.Hj()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, He.getWidth(), He.getHeight(), i, i2, this.aGx);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.f GX = cVar.GX();
        if (GX == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aGt) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.d(GX.Hi(), this.mIsFromCDN ? 17 : 18, false);
            if (!GX.Hj()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, GX.getWidth(), GX.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aGu = z;
    }

    private TextView aq(Context context) {
        TextView textView = null;
        if (this.aFP != null) {
            textView = this.aFP.hj();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aFU, 0, this.aFU, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aFV;
        textView.setLineSpacing(0.0f, this.aFT);
        textView.setTextSize(0, this.aFW);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aFZ);
        textView.setSingleLine(this.aGf);
        if (this.aGg != null) {
            textView.setEllipsize(this.aGg);
        }
        if (this.BF > 0) {
            textView.setMaxWidth(this.BF);
        }
        if (this.aGv > 0) {
            textView.setMaxLines(this.aGv);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder GY = cVar.GY();
        if (GY == null || GY.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aFY > 0 && this.aFX > 0) {
            cVar.K(this.aFX, this.aFY);
        }
        if (textSize > 0) {
            cVar.J(lineHeight, textSize);
        }
        try {
            textView.setText(GY);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aGw) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.Ha() != null) {
            cVar.Ha().aFw = this.aGy;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aFS != null) {
            gifView = this.aFS.hj();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Hc().awQ.awu || layoutParams.height != cVar.Hc().awQ.awv) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Hc().awQ.awu, cVar.Hc().awQ.awv);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new u(this, cVar));
        gifView.a(cVar.Hc().awQ);
        return true;
    }

    private View getVoiceView() {
        View hj = this.aFQ != null ? this.aFQ.hj() : null;
        if ((hj == null || hj.getParent() != null) && this.aGl != -1) {
            hj = LayoutInflater.from(getContext()).inflate(this.aGl, (ViewGroup) null);
        }
        if (hj != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aFV;
            layoutParams.bottomMargin = this.aFV;
            hj.setLayoutParams(layoutParams);
            return hj;
        }
        return null;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.GZ());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hj = this.aFR.hj();
        if (hj != null) {
            TextView aq = aq(getContext());
            if (aq == null) {
                this.aFR.k(hj);
                return null;
            }
            hj.addView(aq);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aFP.k(aq);
                this.aFR.k(hj);
                return null;
            }
            hj.addView(voiceView);
            return hj;
        }
        return hj;
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
        if (applyDimension != this.aFW) {
            this.aFW = applyDimension;
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
        if (this.aFU != i) {
            this.aFU = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aFU, 0, 0, this.aFU);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aFZ) {
            this.aFZ = i;
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
        return this.aGa;
    }

    public void setMaxImageWidth(int i) {
        this.aGa = i;
    }

    public int getMaxImageHeight() {
        return this.aGb;
    }

    public void setMaxImageHeight(int i) {
        this.aGb = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aGc;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aGc = scaleType;
    }

    public int getDefaultImageId() {
        return this.aGd;
    }

    public void setDefaultImageId(int i) {
        this.aGd = i;
    }

    public d getOnImageClickListener() {
        return this.aGi;
    }

    public void setOnImageClickListener(d dVar) {
        this.aGi = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aGq = cVar;
    }

    public void g(boolean z, boolean z2) {
        if (this.aGk != z) {
            this.aGk = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aGk && this.aFO != null) {
                this.aFO.clear();
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
        this.aGm = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aGn) {
                    HE();
                    break;
                } else {
                    motionEvent.setAction(3);
                    break;
                }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aGm) {
                    HD();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aGm = true;
        return super.onTouchEvent(motionEvent);
    }

    private void HD() {
        this.aGn = false;
        if (this.aGo == null) {
            this.aGo = new a();
        }
        postDelayed(this.aGo, ViewConfiguration.getLongPressTimeout());
    }

    private void HE() {
        if (this.aGo != null) {
            removeCallbacks(this.aGo);
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
                TbRichTextView.this.aGn = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aGl = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aGs = null;
        if (this.aGz != drawable) {
            this.aGy = true;
            this.aGz = drawable;
        }
        setText(this.aGr);
        this.aGy = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ea();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ea();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ea();
        } else {
            refresh();
        }
    }

    public void gi(String str) {
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
        if (!(str.equals(this.mUrl) && this.awS == bdUniqueId)) {
            Ea();
        }
        this.mUrl = str;
        this.awS = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hl().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hl().ai(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.hl().a(this.mUrl, 19, this.aCG, 0, 0, this.awS, new Object[0]);
        }
    }

    public void Ea() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hl().a(this.mUrl, 19, this.aCG);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mS(), aVar.mS().getNinePatchChunk(), aVar.mW(), null);
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
        gi(this.mUrl);
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
        return this.aGj;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aGj = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aGw = z;
    }
}
