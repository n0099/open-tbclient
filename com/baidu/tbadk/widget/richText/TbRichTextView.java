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
import com.baidu.tbadk.core.r;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.b.a.i {
    private static final int aNF = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32);
    private static final int aNG = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
    private static final float aNH = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
    private static final float aNI;
    static int aNJ;
    private int BS;
    private int UF;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIM;
    private final View.OnTouchListener aJt;
    private com.baidu.adp.lib.e.b<ImageView> aNK;
    private com.baidu.adp.lib.e.b<TextView> aNL;
    private com.baidu.adp.lib.e.b<View> aNM;
    private com.baidu.adp.lib.e.b<View> aNN;
    private com.baidu.adp.lib.e.b<LinearLayout> aNO;
    private com.baidu.adp.lib.e.b<GifView> aNP;
    private float aNQ;
    private int aNR;
    private int aNS;
    private float aNT;
    private int aNU;
    private int aNV;
    private int aNW;
    private int aNX;
    private int aNY;
    private ImageView.ScaleType aNZ;
    private boolean aOA;
    private boolean aOB;
    public final View.OnClickListener aOC;
    private boolean aOD;
    private Drawable aOE;
    private CustomMessageListener aOF;
    private int aOa;
    private boolean aOb;
    private TextUtils.TruncateAt aOc;
    private g aOd;
    private e aOe;
    private f aOf;
    private View.OnClickListener aOg;
    private boolean aOh;
    private int aOi;
    private boolean aOj;
    private boolean aOk;
    private Runnable aOl;
    private boolean aOm;
    private d aOn;
    private boolean aOo;
    private TbRichText aOp;
    private String aOq;
    private boolean aOr;
    private boolean aOs;
    private boolean aOt;
    private int aOu;
    private boolean aOv;
    private boolean aOw;
    private boolean aOx;
    private boolean aOy;
    private int aOz;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mTextColor;
    private final int mType;
    private String mUrl;

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
        aNI = aNH > 0.0f ? 1.0f / aNH : 0.3f;
        aNJ = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aOA = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aOB = z;
    }

    public boolean Ip() {
        return this.aOm;
    }

    public void Iq() {
        this.aOr = true;
    }

    public String getBackgroundImageUrl() {
        return this.aOq;
    }

    public void setBackgroundImageUrl(String str) {
        this.aOq = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BS = i;
    }

    public void setMaxLines(int i) {
        this.aOu = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aOc = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aOx = z;
    }

    public boolean getIsSupportVitality() {
        return this.aOx;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aOy = z;
    }

    public float getLineSpacing() {
        return this.aNQ;
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
    public boolean L(View view) {
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

    public static com.baidu.adp.lib.e.b<TextView> l(Context context, int i) {
        return new com.baidu.adp.lib.e.b<>(new l(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = null;
        this.aNO = null;
        this.aNP = null;
        this.aNQ = 0.0f;
        this.aNR = 0;
        this.aNS = 0;
        this.aNT = 15.0f;
        this.aNU = -1;
        this.aNV = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNW = -9989158;
        this.aNX = 200;
        this.aNY = 200;
        this.aNZ = null;
        this.UF = 0;
        this.aOa = 0;
        this.aOb = false;
        this.aOc = null;
        this.aOd = null;
        this.aOe = null;
        this.aOf = null;
        this.aOg = null;
        this.aOh = true;
        this.mIsFromCDN = true;
        this.aOi = -1;
        this.aOj = false;
        this.aOk = false;
        this.aOl = null;
        this.aOm = false;
        this.aOo = true;
        this.aOq = null;
        this.aOr = false;
        this.aOs = false;
        this.BS = -1;
        this.aOu = -1;
        this.aOv = true;
        this.aOw = false;
        this.aOx = false;
        this.aOy = false;
        this.aOA = false;
        this.aOB = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aOC = new h(this);
        this.aJt = new i(this);
        this.mType = 19;
        this.aIM = new j(this);
        this.aOF = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = null;
        this.aNO = null;
        this.aNP = null;
        this.aNQ = 0.0f;
        this.aNR = 0;
        this.aNS = 0;
        this.aNT = 15.0f;
        this.aNU = -1;
        this.aNV = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNW = -9989158;
        this.aNX = 200;
        this.aNY = 200;
        this.aNZ = null;
        this.UF = 0;
        this.aOa = 0;
        this.aOb = false;
        this.aOc = null;
        this.aOd = null;
        this.aOe = null;
        this.aOf = null;
        this.aOg = null;
        this.aOh = true;
        this.mIsFromCDN = true;
        this.aOi = -1;
        this.aOj = false;
        this.aOk = false;
        this.aOl = null;
        this.aOm = false;
        this.aOo = true;
        this.aOq = null;
        this.aOr = false;
        this.aOs = false;
        this.BS = -1;
        this.aOu = -1;
        this.aOv = true;
        this.aOw = false;
        this.aOx = false;
        this.aOy = false;
        this.aOA = false;
        this.aOB = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aOC = new h(this);
        this.aJt = new i(this);
        this.mType = 19;
        this.aIM = new j(this);
        this.aOF = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TbRichTextView);
        this.aNS = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aNR = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aNQ = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aNT = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aNT);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aNX = obtainStyledAttributes.getDimensionPixelSize(6, this.aNX);
        this.aNY = obtainStyledAttributes.getDimensionPixelSize(7, this.aNY);
        this.UF = obtainStyledAttributes.getResourceId(8, 0);
        this.aNU = obtainStyledAttributes.getDimensionPixelSize(9, this.aNU);
        this.aNV = obtainStyledAttributes.getDimensionPixelSize(10, this.aNV);
        this.aOa = obtainStyledAttributes.getResourceId(11, 0);
        this.aOb = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aNQ = f2;
    }

    private void init() {
        aNJ = getContext().getResources().getDimensionPixelSize(w.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Z.getOrignalPage();
        }
        if (Z != null) {
            Z.registerListener(this.aOF);
        }
        if (dVar != null) {
            this.aNK = dVar.Ig();
            this.aNL = dVar.Ih();
            this.aNN = dVar.Ij();
            this.aNO = dVar.Ik();
            this.aNP = dVar.Ii();
            this.aNM = dVar.Il();
            if (dVar.getListView() != null && this.aOd == null) {
                this.aOd = new g(dVar.If());
                dVar.getListView().setRecyclerListener(this.aOd);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new m(this));
        this.aOz = com.baidu.adp.lib.util.k.af(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> HC;
        boolean z2;
        int i;
        SpannableStringBuilder HJ;
        View view;
        View view2;
        View a2;
        if (this.aOp != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aOp = tbRichText;
            removeAllViews();
            if (tbRichText != null && (HC = tbRichText.HC()) != null) {
                Iterator<TbRichTextData> it = HC.iterator();
                int i2 = 0;
                View view3 = null;
                View view4 = null;
                boolean z3 = true;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aV = aV(getContext());
                            boolean a3 = a(next, aV, true, bVar);
                            if (z && !this.aOm && (HJ = next.HJ()) != null) {
                                this.aOm = HJ.length() >= 200;
                            }
                            aV.setOnClickListener(this.aOg);
                            z2 = a3;
                            i = i2;
                            view = aV;
                        } else if (next.getType() == 8 && this.aOo) {
                            if (i2 < 10) {
                                ImageView aU = aU(getContext());
                                z2 = b(next, aU, this.aNX, this.aNY);
                                view = aU;
                                i = i2 + 1;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e HM = next.HM();
                            if (HM != null && HM.In()) {
                                a2 = b(HM);
                            } else {
                                a2 = a(next);
                            }
                            view = a2;
                            z2 = true;
                            i = i2;
                        } else if (next.getType() == 512) {
                            view4 = getVoiceView();
                            if (view4 != null) {
                                view = view4;
                                z2 = a(next, view4);
                                i = i2;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            view = textVoiceView;
                            i = i2;
                        } else if (next.getType() == 17) {
                            View gifView = getGifView();
                            z2 = a(next, (GifView) gifView);
                            view = gifView;
                            i = i2;
                        } else if (next.getType() != 1280 || !this.aOo) {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo HR = next.HR();
                                HR.fr(tbRichText.HB());
                                if (HR != null) {
                                    z2 = true;
                                    view = a(HR, tbRichText.HB(), tbRichText.getAuthorId());
                                    i = i2;
                                }
                            }
                            view = view4;
                            z2 = false;
                            i = i2;
                        } else {
                            ImageView aU2 = aU(getContext());
                            z2 = a(next, aU2, (this.aNX - getPaddingLeft()) - getPaddingRight(), this.aNY);
                            view = aU2;
                            i = i2 + 1;
                        }
                        if (!z2 || view == null) {
                            view2 = view3;
                        } else {
                            addView(view);
                            view2 = view;
                        }
                        if (z3 && this.aOy) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                            if (layoutParams == null) {
                                z3 = false;
                                view3 = view2;
                                i2 = i;
                                view4 = view;
                            } else {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds0);
                                view.setLayoutParams(layoutParams);
                                z3 = false;
                                view3 = view2;
                                i2 = i;
                                view4 = view;
                            }
                        } else {
                            if ((view instanceof ImageView) && next.getType() == 8) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                                view2.setLayoutParams(layoutParams2);
                                int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
                                int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
                                if (this.aOy) {
                                    g2 = aNG;
                                    g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16);
                                }
                                if (i == 1) {
                                    layoutParams2.topMargin = g2;
                                } else if (i > 1) {
                                    layoutParams2.topMargin = g3;
                                }
                                view.setLayoutParams(layoutParams2);
                            }
                            view3 = view2;
                            view4 = view;
                            i2 = i;
                        }
                    }
                }
                if (view3 != null && !(view3 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    if (this.aOy) {
                        layoutParams3.bottomMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds64);
                    } else {
                        layoutParams3.bottomMargin = this.aNS;
                    }
                    view3.setLayoutParams(layoutParams3);
                } else if (view3 != null && this.aOy) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds52);
                    view3.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aOg = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fK = this.aNK.fK();
        if (fK instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fK;
            foreDrawableImageView.setForegroundDrawable(w.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(w.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aNX - getPaddingLeft()) - getPaddingRight(), this.aNY, new n(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aOr);
            if (r.oV().pb()) {
                foreDrawableImageView.setDefaultBgResource(w.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(w.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.qc(), 17, false);
            return fK;
        }
        return fK;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aOx && T(i, i2) && this.aOz > 0) {
            i3 = this.aOz;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.UF);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aOt || i3 <= i5 || aNH <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aNH <= i3) {
                if (i5 * aNH > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aNH);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aOt) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aNZ == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aNZ);
        }
        if (this.aOx) {
            if (T(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aNF;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aOa <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aNS;
        linearLayout.setClickable(true);
        Bitmap cL = aq.cL(this.aOa);
        if (cL != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cL));
        }
        linearLayout.setFocusable(false);
        if (this.aOx) {
            layoutParams.leftMargin = aNF;
            layoutParams.rightMargin = aNF;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aOa;
    }

    public void setVideoImageId(int i) {
        this.aOa = i;
    }

    private ImageView aU(Context context) {
        ImageView fK = this.aNK != null ? this.aNK.fK() : null;
        if (fK == null || fK.getParent() != null) {
            fK = null;
        }
        if (fK != null) {
            fK.setContentDescription(context.getString(w.l.editor_image));
        }
        return fK;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo HP = tbRichTextData.HP();
        if (HP != null && HP.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aOr) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(HP.Ie(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(HP.getLink()));
                if (!HP.HX()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, HP.getWidth(), HP.getHeight(), i, i2, this.aOC);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextImageInfo HI = tbRichTextData.HI();
        if (HI == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aOr) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(HI.HW(), this.mIsFromCDN ? 17 : 18, false);
            if (!HI.HX()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, HI.getWidth(), HI.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aOt = z;
    }

    private TextView aV(Context context) {
        TextView textView = null;
        if (this.aNL != null) {
            textView = this.aNL.fK();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aNR, 0, this.aNR, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aOs) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aNS;
        }
        textView.setLineSpacing(0.0f, this.aNQ);
        textView.setTextSize(0, this.aNT);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(w.e.transparent));
        textView.setSingleLine(this.aOb);
        if (this.aOc != null) {
            textView.setEllipsize(this.aOc);
        }
        if (this.BS > 0) {
            textView.setMaxWidth(this.BS);
        }
        if (this.aOu > 0) {
            textView.setMaxLines(this.aOu);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder HJ = tbRichTextData.HJ();
        if (HJ == null || HJ.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aOy) {
            this.aNU = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            this.aNV = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
        }
        if (this.aNV > 0 && this.aNU > 0) {
            tbRichTextData.R(this.aNU, this.aNV);
        }
        if (textSize > 0) {
            tbRichTextData.Q(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(HJ, textView, this);
        }
        try {
            textView.setText(HJ);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aOv) {
            if (tbRichTextData.HS()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bkT());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aOy) {
            textView.setLineSpacing(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8), 1.0f);
        } else if (this.aOx) {
            layoutParams.leftMargin = aNF;
            layoutParams.rightMargin = aNF;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.HL() != null) {
            tbRichTextData.HL().needRecompute = this.aOD;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aNP != null) {
            gifView = this.aNP.fK();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aOx) {
                layoutParams.leftMargin = aNF;
                layoutParams.rightMargin = aNF;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.HN().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.HN().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.HN().mGifInfo.mGifWidth, tbRichTextData.HN().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aOx) {
                layoutParams2.leftMargin = aNF;
                layoutParams2.rightMargin = aNF;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new com.baidu.tbadk.widget.richText.g(this, tbRichTextData));
        gifView.a(tbRichTextData.HN().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fK = this.aNN != null ? this.aNN.fK() : null;
        if ((fK == null || fK.getParent() != null) && this.aOi != -1) {
            fK = LayoutInflater.from(getContext()).inflate(this.aOi, (ViewGroup) null);
        }
        if (fK != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aNS;
            if (!this.aOy) {
                layoutParams.bottomMargin = this.aNS;
            }
            fK.setLayoutParams(layoutParams);
            return fK;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.d dVar = null;
        if (this.aNM != null) {
            dVar = this.aNM.fK();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aNS;
        layoutParams.bottomMargin = this.aNS;
        if (this.aOx) {
            layoutParams.leftMargin = aNF;
            layoutParams.rightMargin = aNF;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.j(this.aOh, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aOr);
                dVar2.getGraffitiImageView().setDefaultResource(this.UF);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aJt);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aNX - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aOB);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.HK());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aOx) {
            layoutParams.leftMargin = aNF;
            layoutParams.rightMargin = aNF;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fK = this.aNO.fK();
        if (fK != null) {
            TextView aV = aV(getContext());
            if (aV == null) {
                this.aNO.n(fK);
                return null;
            }
            fK.addView(aV);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aNL.n(aV);
                this.aNO.n(fK);
                return null;
            }
            fK.addView(voiceView);
            return fK;
        }
        return fK;
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
        if (applyDimension != this.aNT) {
            this.aNT = applyDimension;
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
        if (this.aNR != i) {
            this.aNR = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aNR, 0, 0, this.aNR);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aNW) {
            this.aNW = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean T(int i, int i2) {
        if (this.aOz <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aOz)) > aNI ? 1 : ((((float) i) / ((float) this.aOz)) == aNI ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aNX;
    }

    public void setMaxImageWidth(int i) {
        this.aNX = i;
    }

    public int getMaxImageHeight() {
        return this.aNY;
    }

    public void setMaxImageHeight(int i) {
        this.aNY = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aNZ;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aNZ = scaleType;
    }

    public int getDefaultImageId() {
        return this.UF;
    }

    public void setDefaultImageId(int i) {
        this.UF = i;
    }

    public e getOnImageClickListener() {
        return this.aOe;
    }

    public void setOnImageClickListener(e eVar) {
        this.aOe = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aOn = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aOh != z) {
            this.aOh = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aOh && this.aNK != null) {
                this.aNK.clear();
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
        this.aOj = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aOk) {
                    Is();
                    break;
                } else if (!this.aOw) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aOj) {
                    Ir();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aOj = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Ir() {
        this.aOk = false;
        if (this.aOl == null) {
            this.aOl = new a();
        }
        postDelayed(this.aOl, ViewConfiguration.getLongPressTimeout());
    }

    private void Is() {
        if (this.aOl != null) {
            removeCallbacks(this.aOl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aOw && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aOk = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aOi = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aOq = null;
        if (this.aOE != drawable) {
            this.aOD = true;
            this.aOE = drawable;
        }
        setText(this.aOp);
        this.aOD = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DK();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DK();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DK();
        } else {
            refresh();
        }
    }

    public void gt(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.j X = com.baidu.adp.base.k.X(getContext());
        if (X != null) {
            bdUniqueId = X.getUniqueId();
            z = X.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            DK();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fM().ak(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, this.aIM, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void DK() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, this.aIM);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kR(), aVar.kR().getNinePatchChunk(), aVar.kV(), null);
                if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.b.a.i
    public void refresh() {
        gt(this.mUrl);
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
        return this.aOf;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aOf = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aOv = z;
    }

    public void setTextCenter(boolean z) {
        this.aOs = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aOo = z;
    }
}
