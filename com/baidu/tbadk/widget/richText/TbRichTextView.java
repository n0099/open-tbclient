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
import android.view.KeyEvent;
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
    private static final int aNC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32);
    private static final int aND = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
    private static final float aNE = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
    private static final float aNF;
    static int aNG;
    private int BS;
    private int Ur;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIz;
    private final View.OnTouchListener aJg;
    private final com.baidu.tieba.pb.a.d aKQ;
    private com.baidu.adp.lib.e.b<ImageView> aNH;
    private com.baidu.adp.lib.e.b<TextView> aNI;
    private com.baidu.adp.lib.e.b<View> aNJ;
    private com.baidu.adp.lib.e.b<View> aNK;
    private com.baidu.adp.lib.e.b<LinearLayout> aNL;
    private com.baidu.adp.lib.e.b<GifView> aNM;
    private float aNN;
    private int aNO;
    private int aNP;
    private float aNQ;
    private int aNR;
    private int aNS;
    private int aNT;
    private int aNU;
    private int aNV;
    private ImageView.ScaleType aNW;
    private int aNX;
    private boolean aNY;
    private TextUtils.TruncateAt aNZ;
    private boolean aOA;
    public final View.OnClickListener aOB;
    private boolean aOC;
    private Drawable aOD;
    private CustomMessageListener aOE;
    private g aOa;
    private e aOb;
    private com.baidu.tieba.pb.a.d aOc;
    private f aOd;
    private View.OnClickListener aOe;
    private boolean aOf;
    private int aOg;
    private boolean aOh;
    private boolean aOi;
    private Runnable aOj;
    private boolean aOk;
    private d aOl;
    private boolean aOm;
    private TbRichText aOn;
    private String aOo;
    private boolean aOp;
    private boolean aOq;
    private boolean aOr;
    private int aOs;
    private boolean aOt;
    private boolean aOu;
    private boolean aOv;
    private boolean aOw;
    private int aOx;
    private int aOy;
    private boolean aOz;
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
        aNF = aNE > 0.0f ? 1.0f / aNE : 0.3f;
        aNG = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aOz = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aOA = z;
    }

    public boolean Ik() {
        return this.aOk;
    }

    public void Il() {
        this.aOp = true;
    }

    public String getBackgroundImageUrl() {
        return this.aOo;
    }

    public void setBackgroundImageUrl(String str) {
        this.aOo = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BS = i;
    }

    public void setMaxLines(int i) {
        this.aOs = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aNZ = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aOv = z;
    }

    public boolean getIsSupportVitality() {
        return this.aOv;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aOw = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aOx = i;
    }

    public float getLineSpacing() {
        return this.aNN;
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
        return new com.baidu.adp.lib.e.b<>(new n(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aNH = null;
        this.aNI = null;
        this.aNJ = null;
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = 0.0f;
        this.aNO = 0;
        this.aNP = 0;
        this.aNQ = 15.0f;
        this.aNR = -1;
        this.aNS = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNT = -9989158;
        this.aNU = 200;
        this.aNV = 200;
        this.aNW = null;
        this.Ur = 0;
        this.aNX = 0;
        this.aNY = false;
        this.aNZ = null;
        this.aOa = null;
        this.aOb = null;
        this.aOc = null;
        this.aOd = null;
        this.aOe = null;
        this.aOf = true;
        this.mIsFromCDN = true;
        this.aOg = -1;
        this.aOh = false;
        this.aOi = false;
        this.aOj = null;
        this.aOk = false;
        this.aOm = true;
        this.aOo = null;
        this.aOp = false;
        this.aOq = false;
        this.BS = -1;
        this.aOs = -1;
        this.aOt = true;
        this.aOu = false;
        this.aOv = false;
        this.aOw = false;
        this.aOx = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
        this.aOz = false;
        this.aOA = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aKQ = new com.baidu.tieba.pb.a.d(new i(this));
        this.aOB = new j(this);
        this.aJg = new k(this);
        this.mType = 19;
        this.aIz = new l(this);
        this.aOE = new m(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNH = null;
        this.aNI = null;
        this.aNJ = null;
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = 0.0f;
        this.aNO = 0;
        this.aNP = 0;
        this.aNQ = 15.0f;
        this.aNR = -1;
        this.aNS = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNT = -9989158;
        this.aNU = 200;
        this.aNV = 200;
        this.aNW = null;
        this.Ur = 0;
        this.aNX = 0;
        this.aNY = false;
        this.aNZ = null;
        this.aOa = null;
        this.aOb = null;
        this.aOc = null;
        this.aOd = null;
        this.aOe = null;
        this.aOf = true;
        this.mIsFromCDN = true;
        this.aOg = -1;
        this.aOh = false;
        this.aOi = false;
        this.aOj = null;
        this.aOk = false;
        this.aOm = true;
        this.aOo = null;
        this.aOp = false;
        this.aOq = false;
        this.BS = -1;
        this.aOs = -1;
        this.aOt = true;
        this.aOu = false;
        this.aOv = false;
        this.aOw = false;
        this.aOx = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
        this.aOz = false;
        this.aOA = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aKQ = new com.baidu.tieba.pb.a.d(new i(this));
        this.aOB = new j(this);
        this.aJg = new k(this);
        this.mType = 19;
        this.aIz = new l(this);
        this.aOE = new m(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TbRichTextView);
        this.aNP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aNO = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aNN = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aNQ = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aNQ);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aNU = obtainStyledAttributes.getDimensionPixelSize(6, this.aNU);
        this.aNV = obtainStyledAttributes.getDimensionPixelSize(7, this.aNV);
        this.Ur = obtainStyledAttributes.getResourceId(8, 0);
        this.aNR = obtainStyledAttributes.getDimensionPixelSize(9, this.aNR);
        this.aNS = obtainStyledAttributes.getDimensionPixelSize(10, this.aNS);
        this.aNX = obtainStyledAttributes.getResourceId(11, 0);
        this.aNY = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aNN = f2;
    }

    private void init() {
        aNG = getContext().getResources().getDimensionPixelSize(w.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Z.getOrignalPage();
        }
        if (Z != null) {
            Z.registerListener(this.aOE);
        }
        if (dVar != null) {
            this.aNH = dVar.Ib();
            this.aNI = dVar.Ic();
            this.aNK = dVar.Ie();
            this.aNL = dVar.If();
            this.aNM = dVar.Id();
            this.aNJ = dVar.Ig();
            if (dVar.getListView() != null && this.aOa == null) {
                this.aOa = new g(dVar.Ia());
                dVar.getListView().setRecyclerListener(this.aOa);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new o(this));
        this.aOy = com.baidu.adp.lib.util.k.af(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> Hx;
        boolean z2;
        int i;
        SpannableStringBuilder HE;
        ImageView imageView;
        View view;
        KeyEvent.Callback a2;
        if (this.aOn != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aOn = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Hx = tbRichText.Hx()) != null) {
                Iterator<TbRichTextData> it = Hx.iterator();
                int i2 = 0;
                View view2 = null;
                View view3 = null;
                boolean z3 = true;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aV = aV(getContext());
                            boolean a3 = a(next, aV, true, bVar);
                            if (z && !this.aOk && (HE = next.HE()) != null) {
                                this.aOk = HE.length() >= 200;
                            }
                            if (this.aOc != null) {
                                aV.setOnTouchListener(this.aKQ);
                                z2 = a3;
                                i = i2;
                                imageView = aV;
                            } else {
                                aV.setOnClickListener(this.aOe);
                                z2 = a3;
                                i = i2;
                                imageView = aV;
                            }
                        } else if (next.getType() == 8 && this.aOm) {
                            if (i2 < 10) {
                                ImageView aU = aU(getContext());
                                z2 = b(next, aU, this.aNU, this.aNV);
                                imageView = aU;
                                i = i2 + 1;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e HH = next.HH();
                            if (HH != null && HH.Ii()) {
                                a2 = b(HH);
                            } else {
                                a2 = a(next);
                            }
                            imageView = a2;
                            z2 = true;
                            i = i2;
                        } else if (next.getType() == 512) {
                            view3 = getVoiceView();
                            if (view3 != null) {
                                imageView = view3;
                                z2 = a(next, view3);
                                i = i2;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            imageView = textVoiceView;
                            i = i2;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            z2 = a(next, gifView);
                            imageView = gifView;
                            i = i2;
                        } else if (next.getType() != 1280 || !this.aOm) {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo HM = next.HM();
                                HM.fs(tbRichText.Hw());
                                if (HM != null) {
                                    z2 = true;
                                    imageView = a(HM, tbRichText.Hw(), tbRichText.getAuthorId());
                                    i = i2;
                                }
                            }
                            imageView = view3;
                            z2 = false;
                            i = i2;
                        } else {
                            ImageView aU2 = aU(getContext());
                            z2 = a(next, aU2, (this.aNU - getPaddingLeft()) - getPaddingRight(), this.aNV);
                            imageView = aU2;
                            i = i2 + 1;
                        }
                        if (!z2 || imageView == 0) {
                            view = view2;
                        } else {
                            addView(imageView);
                            view = imageView;
                        }
                        if (z3 && this.aOw) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                            if (layoutParams == null) {
                                z3 = false;
                                view2 = view;
                                i2 = i;
                                view3 = imageView;
                            } else {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds0);
                                imageView.setLayoutParams(layoutParams);
                                z3 = false;
                                view2 = view;
                                i2 = i;
                                view3 = imageView;
                            }
                        } else {
                            if ((imageView instanceof ImageView) && next.getType() == 8) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                                view.setLayoutParams(layoutParams2);
                                int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
                                int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
                                if (this.aOw) {
                                    g2 = aND;
                                    g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16);
                                }
                                if (i == 1) {
                                    layoutParams2.topMargin = g2;
                                } else if (i > 1) {
                                    layoutParams2.topMargin = g3;
                                }
                                imageView.setLayoutParams(layoutParams2);
                            }
                            view2 = view;
                            view3 = imageView;
                            i2 = i;
                        }
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    if (this.aOw) {
                        layoutParams3.bottomMargin = this.aOx;
                    } else {
                        layoutParams3.bottomMargin = this.aNP;
                    }
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.aOw) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds52);
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aOe = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fK = this.aNH.fK();
        if (fK instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fK;
            foreDrawableImageView.setForegroundDrawable(w.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(w.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aNU - getPaddingLeft()) - getPaddingRight(), this.aNV, new p(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aOp);
            if (r.oN().oT()) {
                foreDrawableImageView.setDefaultBgResource(w.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(w.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.getThumbUrl(), 17, false);
            return fK;
        }
        return fK;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aOv && S(i, i2) && this.aOy > 0) {
            i3 = this.aOy;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Ur);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aOr || i3 <= i5 || aNE <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aNE <= i3) {
                if (i5 * aNE > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aNE);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aOr) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aNW == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aNW);
        }
        if (this.aOv) {
            if (S(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aNC;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aOc != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aKQ);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aNX <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aNP;
        linearLayout.setClickable(true);
        Bitmap cM = aq.cM(this.aNX);
        if (cM != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cM));
        }
        linearLayout.setFocusable(false);
        if (this.aOv) {
            layoutParams.leftMargin = aNC;
            layoutParams.rightMargin = aNC;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new com.baidu.tbadk.widget.richText.g(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aNX;
    }

    public void setVideoImageId(int i) {
        this.aNX = i;
    }

    private ImageView aU(Context context) {
        ImageView fK = this.aNH != null ? this.aNH.fK() : null;
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
        TbRichTextLinkImageInfo HK = tbRichTextData.HK();
        if (HK != null && HK.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aOp) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(HK.HZ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(HK.getLink()));
                if (!HK.HS()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, HK.getWidth(), HK.getHeight(), i, i2, this.aOB);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextImageInfo HD = tbRichTextData.HD();
        if (HD == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aOp) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(HD.HR(), this.mIsFromCDN ? 17 : 18, false);
            if (!HD.HS()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, HD.getWidth(), HD.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aOr = z;
    }

    private TextView aV(Context context) {
        TextView textView = null;
        if (this.aNI != null) {
            textView = this.aNI.fK();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aNO, 0, this.aNO, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aOq) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aNP;
        }
        textView.setLineSpacing(0.0f, this.aNN);
        textView.setTextSize(0, this.aNQ);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(w.e.transparent));
        textView.setSingleLine(this.aNY);
        if (this.aNZ != null) {
            textView.setEllipsize(this.aNZ);
        }
        if (this.BS > 0) {
            textView.setMaxWidth(this.BS);
        }
        if (this.aOs > 0) {
            textView.setMaxLines(this.aOs);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder HE = tbRichTextData.HE();
        if (HE == null || HE.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aOw) {
            this.aNR = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            this.aNS = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
        }
        if (this.aNS > 0 && this.aNR > 0) {
            tbRichTextData.Q(this.aNR, this.aNS);
        }
        if (textSize > 0) {
            tbRichTextData.P(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(HE, textView, this);
        }
        try {
            textView.setText(HE);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aOt) {
            if (tbRichTextData.HN()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bmr());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aOw) {
            textView.setLineSpacing(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8), 1.0f);
        } else if (this.aOv) {
            layoutParams.leftMargin = aNC;
            layoutParams.rightMargin = aNC;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.HG() != null) {
            tbRichTextData.HG().needRecompute = this.aOC;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aNM != null) {
            gifView = this.aNM.fK();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aOv) {
                layoutParams.leftMargin = aNC;
                layoutParams.rightMargin = aNC;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.HI().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.HI().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.HI().mGifInfo.mGifWidth, tbRichTextData.HI().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aOv) {
                layoutParams2.leftMargin = aNC;
                layoutParams2.rightMargin = aNC;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new h(this, tbRichTextData));
        gifView.a(tbRichTextData.HI().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fK = this.aNK != null ? this.aNK.fK() : null;
        if ((fK == null || fK.getParent() != null) && this.aOg != -1) {
            fK = LayoutInflater.from(getContext()).inflate(this.aOg, (ViewGroup) null);
        }
        if (fK != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aNP;
            if (!this.aOw) {
                layoutParams.bottomMargin = this.aNP;
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
        if (this.aNJ != null) {
            dVar = this.aNJ.fK();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aNP;
        layoutParams.bottomMargin = this.aNP;
        if (this.aOv) {
            layoutParams.leftMargin = aNC;
            layoutParams.rightMargin = aNC;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.j(this.aOf, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aOp);
                dVar2.getGraffitiImageView().setDefaultResource(this.Ur);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aJg);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aNU - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aOA);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.HF());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aOv) {
            layoutParams.leftMargin = aNC;
            layoutParams.rightMargin = aNC;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fK = this.aNL.fK();
        if (fK != null) {
            TextView aV = aV(getContext());
            if (aV == null) {
                this.aNL.n(fK);
                return null;
            }
            fK.addView(aV);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aNI.n(aV);
                this.aNL.n(fK);
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
        if (applyDimension != this.aNQ) {
            this.aNQ = applyDimension;
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
        if (this.aNO != i) {
            this.aNO = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aNO, 0, 0, this.aNO);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aNT) {
            this.aNT = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean S(int i, int i2) {
        if (this.aOy <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aOy)) > aNF ? 1 : ((((float) i) / ((float) this.aOy)) == aNF ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aNU;
    }

    public void setMaxImageWidth(int i) {
        this.aNU = i;
    }

    public int getMaxImageHeight() {
        return this.aNV;
    }

    public void setMaxImageHeight(int i) {
        this.aNV = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aNW;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aNW = scaleType;
    }

    public int getDefaultImageId() {
        return this.Ur;
    }

    public void setDefaultImageId(int i) {
        this.Ur = i;
    }

    public e getOnImageClickListener() {
        return this.aOb;
    }

    public void setOnImageClickListener(e eVar) {
        this.aOb = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.d dVar) {
        this.aOc = dVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aOl = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aOf != z) {
            this.aOf = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aOf && this.aNH != null) {
                this.aNH.clear();
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
        this.aOh = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aOi) {
                    In();
                    break;
                } else if (!this.aOu) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aOh) {
                    Im();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aOh = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Im() {
        this.aOi = false;
        if (this.aOj == null) {
            this.aOj = new a();
        }
        postDelayed(this.aOj, ViewConfiguration.getLongPressTimeout());
    }

    private void In() {
        if (this.aOj != null) {
            removeCallbacks(this.aOj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aOu && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aOi = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aOg = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aOo = null;
        if (this.aOD != drawable) {
            this.aOC = true;
            this.aOD = drawable;
        }
        setText(this.aOn);
        this.aOC = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DE();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DE();
        } else {
            refresh();
        }
    }

    public void gs(String str) {
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
            DE();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fM().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, this.aIz, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void DE() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, this.aIz);
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
        gs(this.mUrl);
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
        return this.aOd;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aOd = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aOt = z;
    }

    public void setTextCenter(boolean z) {
        this.aOq = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aOm = z;
    }
}
