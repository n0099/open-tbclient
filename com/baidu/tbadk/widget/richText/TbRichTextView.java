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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    private static final float aHA;
    static int aHB;
    private static final int aHy = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds32);
    private static final float aHz = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst());
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCU;
    private com.baidu.adp.lib.e.b<ImageView> aHC;
    private com.baidu.adp.lib.e.b<TextView> aHD;
    private com.baidu.adp.lib.e.b<View> aHE;
    private com.baidu.adp.lib.e.b<View> aHF;
    private com.baidu.adp.lib.e.b<LinearLayout> aHG;
    private com.baidu.adp.lib.e.b<GifView> aHH;
    private float aHI;
    private int aHJ;
    private int aHK;
    private float aHL;
    private int aHM;
    private int aHN;
    private int aHO;
    private int aHP;
    private int aHQ;
    private ImageView.ScaleType aHR;
    private int aHS;
    private int aHT;
    private boolean aHU;
    private TextUtils.TruncateAt aHV;
    private g aHW;
    private e aHX;
    private f aHY;
    private View.OnClickListener aHZ;
    private boolean aIa;
    private int aIb;
    private boolean aIc;
    private boolean aId;
    private Runnable aIe;
    private boolean aIf;
    private d aIg;
    private TbRichText aIh;
    private String aIi;
    private boolean aIj;
    private boolean aIk;
    private boolean aIl;
    private int aIm;
    private boolean aIn;
    private boolean aIo;
    private boolean aIp;
    private int aIq;
    private boolean aIr;
    private boolean aIs;
    public final View.OnClickListener aIt;
    private final View.OnTouchListener aIu;
    private boolean aIv;
    private Drawable aIw;
    private CustomMessageListener aIx;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int va;

    /* loaded from: classes.dex */
    public interface b {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view, String str, int i);
    }

    /* loaded from: classes.dex */
    public interface f {
        void b(View view, String str);
    }

    static {
        aHA = aHz > 0.0f ? 1.0f / aHz : 0.3f;
        aHB = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aIr = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aIs = z;
    }

    public boolean Ic() {
        return this.aIf;
    }

    public void Id() {
        this.aIj = true;
    }

    public String getBackgroundImageUrl() {
        return this.aIi;
    }

    public void setBackgroundImageUrl(String str) {
        this.aIi = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.va = i;
    }

    public void setMaxLines(int i) {
        this.aIm = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aHV = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aIp = z;
    }

    public boolean getIsSupportVitality() {
        return this.aIp;
    }

    public float getLineSpacing() {
        return this.aHI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        public String url;

        public c(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O(View view) {
        if ((view instanceof ImageView) && !(view instanceof GifView)) {
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof c) {
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

    public static TbRichText a(Context context, JSONArray jSONArray, int i) {
        return new TbRichText(context, jSONArray, i);
    }

    public static TbRichText a(Context context, JSONArray jSONArray, boolean z) {
        return new TbRichText(context, jSONArray, z);
    }

    public static TbRichText b(Context context, List<PbContent> list, boolean z) {
        return new TbRichText(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> j(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new l(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aHC = null;
        this.aHD = null;
        this.aHE = null;
        this.aHF = null;
        this.aHG = null;
        this.aHH = null;
        this.aHI = 0.0f;
        this.aHJ = 0;
        this.aHK = 0;
        this.aHL = 15.0f;
        this.aHM = -1;
        this.aHN = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aHO = -9989158;
        this.aHP = 200;
        this.aHQ = 200;
        this.aHR = null;
        this.aHS = 0;
        this.aHT = 0;
        this.aHU = false;
        this.aHV = null;
        this.aHW = null;
        this.aHX = null;
        this.aHY = null;
        this.aHZ = null;
        this.aIa = true;
        this.mIsFromCDN = true;
        this.aIb = -1;
        this.aIc = false;
        this.aId = false;
        this.aIe = null;
        this.aIf = false;
        this.aIi = null;
        this.aIj = false;
        this.aIk = false;
        this.va = -1;
        this.aIm = -1;
        this.aIn = true;
        this.aIo = false;
        this.aIp = false;
        this.aIr = false;
        this.aIs = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aIt = new h(this);
        this.aIu = new i(this);
        this.mType = 19;
        this.aCU = new j(this);
        this.aIx = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHC = null;
        this.aHD = null;
        this.aHE = null;
        this.aHF = null;
        this.aHG = null;
        this.aHH = null;
        this.aHI = 0.0f;
        this.aHJ = 0;
        this.aHK = 0;
        this.aHL = 15.0f;
        this.aHM = -1;
        this.aHN = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aHO = -9989158;
        this.aHP = 200;
        this.aHQ = 200;
        this.aHR = null;
        this.aHS = 0;
        this.aHT = 0;
        this.aHU = false;
        this.aHV = null;
        this.aHW = null;
        this.aHX = null;
        this.aHY = null;
        this.aHZ = null;
        this.aIa = true;
        this.mIsFromCDN = true;
        this.aIb = -1;
        this.aIc = false;
        this.aId = false;
        this.aIe = null;
        this.aIf = false;
        this.aIi = null;
        this.aIj = false;
        this.aIk = false;
        this.va = -1;
        this.aIm = -1;
        this.aIn = true;
        this.aIo = false;
        this.aIp = false;
        this.aIr = false;
        this.aIs = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aIt = new h(this);
        this.aIu = new i(this);
        this.mType = 19;
        this.aCU = new j(this);
        this.aIx = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.TbRichTextView);
        this.aHK = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aHJ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aHI = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aHL = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aHL);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aHP = obtainStyledAttributes.getDimensionPixelSize(6, this.aHP);
        this.aHQ = obtainStyledAttributes.getDimensionPixelSize(7, this.aHQ);
        this.aHS = obtainStyledAttributes.getResourceId(8, 0);
        this.aHM = obtainStyledAttributes.getDimensionPixelSize(9, this.aHM);
        this.aHN = obtainStyledAttributes.getDimensionPixelSize(10, this.aHN);
        this.aHT = obtainStyledAttributes.getResourceId(11, 0);
        this.aHU = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aHI = f2;
    }

    private void init() {
        aHB = getContext().getResources().getDimensionPixelSize(r.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> C = com.baidu.adp.base.k.C(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (C != null && (C.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) C.getOrignalPage();
        }
        if (C != null) {
            C.registerListener(this.aIx);
        }
        if (dVar != null) {
            this.aHC = dVar.HT();
            this.aHD = dVar.HU();
            this.aHF = dVar.HW();
            this.aHG = dVar.HX();
            this.aHH = dVar.HV();
            this.aHE = dVar.HY();
            if (dVar.getListView() != null && this.aHW == null) {
                this.aHW = new g(dVar.HS());
                dVar.getListView().setRecyclerListener(this.aHW);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new m(this));
        this.aIq = com.baidu.adp.lib.util.k.I(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x0027 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x0027 */
    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Hq;
        boolean z2;
        SpannableStringBuilder Hw;
        View view;
        View a2;
        View view2 = null;
        if (this.aIh != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aIh = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Hq = tbRichText.Hq()) != null) {
                Iterator<TbRichTextData> it = Hq.iterator();
                int i = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView as = as(getContext());
                            boolean a3 = a(next, as, true, bVar);
                            if (z && !this.aIf && (Hw = next.Hw()) != null) {
                                this.aIf = Hw.length() >= 200;
                            }
                            as.setOnClickListener(this.aHZ);
                            z2 = a3;
                            view3 = as;
                        } else if (next.getType() == 8) {
                            if (i < 10) {
                                i++;
                                ImageView ar = ar(getContext());
                                z2 = b(next, ar, this.aHP, this.aHQ);
                                view3 = ar;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e Hz = next.Hz();
                            if (Hz != null && Hz.Ia()) {
                                a2 = b(Hz);
                            } else {
                                a2 = a(next);
                            }
                            view3 = a2;
                            z2 = true;
                        } else if (next.getType() == 512) {
                            view3 = getVoiceView();
                            if (view3 != null) {
                                z2 = a(next, view3);
                                view3 = view3;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            view3 = textVoiceView;
                        } else if (next.getType() == 17) {
                            View gifView = getGifView();
                            z2 = a(next, (GifView) gifView);
                            view3 = gifView;
                        } else if (next.getType() == 1280) {
                            ImageView ar2 = ar(getContext());
                            i++;
                            z2 = a(next, ar2, (this.aHP - getPaddingLeft()) - getPaddingRight(), this.aHQ);
                            view3 = ar2;
                        } else {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo HE = next.HE();
                                HE.fy(tbRichText.Hp());
                                if (HE != null) {
                                    View a4 = a(HE, tbRichText.Hp(), tbRichText.getAuthorId());
                                    z2 = true;
                                    view3 = a4;
                                }
                            }
                            z2 = false;
                            view3 = view3;
                        }
                        if (!z2 || view3 == null) {
                            view = view2;
                        } else {
                            addView(view3);
                            view = view3;
                        }
                        if ((view3 instanceof ImageView) && next.getType() == 8) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view3.getLayoutParams();
                            view.setLayoutParams(layoutParams);
                            if (i == 1) {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds20);
                            } else if (i > 1) {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds4);
                            }
                            view3.setLayoutParams(layoutParams);
                        }
                        view2 = view;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams2.bottomMargin = this.aHK;
                    view2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aHZ = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView ew = this.aHC.ew();
        if (ew instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) ew;
            foreDrawableImageView.setForegroundDrawable(r.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(r.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aHP - getPaddingLeft()) - getPaddingRight(), this.aHQ, new n(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aIj);
            if (com.baidu.tbadk.core.l.oC().oI()) {
                foreDrawableImageView.setDefaultBgResource(r.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(r.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.qa(), 17, false);
            return ew;
        }
        return ew;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aIp && N(i, i2) && this.aIq > 0) {
            i3 = this.aIq;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aHS);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aIl || i3 <= i5 || aHz <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aHz <= i3) {
                if (i5 * aHz > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aHz);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aIl) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aHR == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aHR);
        }
        if (this.aIp) {
            if (N(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aHy;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aHT <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aHK;
        linearLayout.setClickable(true);
        Bitmap cP = ap.cP(this.aHT);
        if (cP != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cP));
        }
        linearLayout.setFocusable(false);
        if (this.aIp) {
            layoutParams.leftMargin = aHy;
            layoutParams.rightMargin = aHy;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aHT;
    }

    public void setVideoImageId(int i) {
        this.aHT = i;
    }

    private ImageView ar(Context context) {
        ImageView ew = this.aHC != null ? this.aHC.ew() : null;
        if (ew == null || ew.getParent() != null) {
            ew = null;
        }
        if (ew != null) {
            ew.setContentDescription(context.getString(r.l.log_msg_pic));
        }
        return ew;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo HC = tbRichTextData.HC();
        if (HC != null && HC.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aIj) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(HC.HR(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(HC.getLink()));
                if (!HC.HK()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, HC.getWidth(), HC.getHeight(), i, i2, this.aIt);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextImageInfo Hv = tbRichTextData.Hv();
        if (Hv == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aIj) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(Hv.HJ(), this.mIsFromCDN ? 17 : 18, false);
            if (!Hv.HK()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Hv.getWidth(), Hv.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aIl = z;
    }

    private TextView as(Context context) {
        TextView textView = null;
        if (this.aHD != null) {
            textView = this.aHD.ew();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aHJ, 0, this.aHJ, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aIk) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aHK;
        }
        textView.setLineSpacing(0.0f, this.aHI);
        textView.setTextSize(0, this.aHL);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(ap.getColor(r.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(r.e.transparent));
        textView.setSingleLine(this.aHU);
        if (this.aHV != null) {
            textView.setEllipsize(this.aHV);
        }
        if (this.va > 0) {
            textView.setMaxWidth(this.va);
        }
        if (this.aIm > 0) {
            textView.setMaxLines(this.aIm);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Hw = tbRichTextData.Hw();
        if (Hw == null || Hw.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aHN > 0 && this.aHM > 0) {
            tbRichTextData.L(this.aHM, this.aHN);
        }
        if (textSize > 0) {
            tbRichTextData.K(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(Hw, textView, this);
        }
        try {
            textView.setText(Hw);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aIn) {
            if (tbRichTextData.HF()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.blN());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aIp) {
            layoutParams.leftMargin = aHy;
            layoutParams.rightMargin = aHy;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Hy() != null) {
            tbRichTextData.Hy().needRecompute = this.aIv;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aHH != null) {
            gifView = this.aHH.ew();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aIp) {
                layoutParams.leftMargin = aHy;
                layoutParams.rightMargin = aHy;
            } else {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
            gifView2.setLayoutParams(layoutParams);
        }
        return gifView2;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != tbRichTextData.HA().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.HA().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.HA().mGifInfo.mGifWidth, tbRichTextData.HA().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aIp) {
                layoutParams2.leftMargin = aHy;
                layoutParams2.rightMargin = aHy;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new com.baidu.tbadk.widget.richText.g(this, tbRichTextData));
        gifView.a(tbRichTextData.HA().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View ew = this.aHF != null ? this.aHF.ew() : null;
        if ((ew == null || ew.getParent() != null) && this.aIb != -1) {
            ew = LayoutInflater.from(getContext()).inflate(this.aIb, (ViewGroup) null);
        }
        if (ew != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aHK;
            layoutParams.bottomMargin = this.aHK;
            ew.setLayoutParams(layoutParams);
            return ew;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.d dVar = null;
        if (this.aHE != null) {
            dVar = this.aHE.ew();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aHK;
        layoutParams.bottomMargin = this.aHK;
        if (this.aIp) {
            layoutParams.leftMargin = aHy;
            layoutParams.rightMargin = aHy;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.j(this.aIa, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aIj);
                dVar2.getGraffitiImageView().setDefaultResource(this.aHS);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aIu);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aHP - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aIs);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Hx());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aIp) {
            layoutParams.leftMargin = aHy;
            layoutParams.rightMargin = aHy;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ew = this.aHG.ew();
        if (ew != null) {
            TextView as = as(getContext());
            if (as == null) {
                this.aHG.n(ew);
                return null;
            }
            ew.addView(as);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aHD.n(as);
                this.aHG.n(ew);
                return null;
            }
            ew.addView(voiceView);
            return ew;
        }
        return ew;
    }

    private boolean a(TbRichTextData tbRichTextData, LinearLayout linearLayout, b bVar) {
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
                a2 = a(tbRichTextData, (TextView) childAt, false, bVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(tbRichTextData, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(tbRichTextData, childAt) & z : z;
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
        if (applyDimension != this.aHL) {
            this.aHL = applyDimension;
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
        if (this.aHJ != i) {
            this.aHJ = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aHJ, 0, 0, this.aHJ);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aHO) {
            this.aHO = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean N(int i, int i2) {
        if (this.aIq <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aIq)) > aHA ? 1 : ((((float) i) / ((float) this.aIq)) == aHA ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aHP;
    }

    public void setMaxImageWidth(int i) {
        this.aHP = i;
    }

    public int getMaxImageHeight() {
        return this.aHQ;
    }

    public void setMaxImageHeight(int i) {
        this.aHQ = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aHR;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aHR = scaleType;
    }

    public int getDefaultImageId() {
        return this.aHS;
    }

    public void setDefaultImageId(int i) {
        this.aHS = i;
    }

    public e getOnImageClickListener() {
        return this.aHX;
    }

    public void setOnImageClickListener(e eVar) {
        this.aHX = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aIg = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aIa != z) {
            this.aIa = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aIa && this.aHC != null) {
                this.aHC.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements AbsListView.RecyclerListener {
        private int mId;

        public g(int i) {
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
        this.aIc = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aId) {
                    If();
                    break;
                } else if (!this.aIo) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aIc) {
                    Ie();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aIc = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Ie() {
        this.aId = false;
        if (this.aIe == null) {
            this.aIe = new a();
        }
        postDelayed(this.aIe, ViewConfiguration.getLongPressTimeout());
    }

    private void If() {
        if (this.aIe != null) {
            removeCallbacks(this.aIe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aIo && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aId = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aIb = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aIi = null;
        if (this.aIw != drawable) {
            this.aIv = true;
            this.aIw = drawable;
        }
        setText(this.aIh);
        this.aIv = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DP();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DP();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DP();
        } else {
            refresh();
        }
    }

    public void gA(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.j A = com.baidu.adp.base.k.A(getContext());
        if (A != null) {
            bdUniqueId = A.getUniqueId();
            z = A.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            DP();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.ey().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.ey().am(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.ey().a(this.mUrl, 19, this.aCU, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void DP() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.ey().a(this.mUrl, 19, this.aCU);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.jT(), aVar.jT().getNinePatchChunk(), aVar.jX(), null);
                if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        gA(this.mUrl);
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

    public f getOnLinkImageClickListener() {
        return this.aHY;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aHY = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aIn = z;
    }

    public void setTextCenter(boolean z) {
        this.aIk = z;
    }
}
