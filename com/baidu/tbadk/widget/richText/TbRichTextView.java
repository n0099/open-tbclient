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
import com.baidu.tbadk.core.util.as;
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
    private static final int aOS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32);
    private static final int aOT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
    private static final float aOU = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
    private static final float aOV;
    static int aOW;
    private int BS;
    private int Uq;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aJO;
    private final View.OnTouchListener aKv;
    private final com.baidu.tieba.pb.a.d aMg;
    private com.baidu.adp.lib.e.b<ImageView> aOX;
    private com.baidu.adp.lib.e.b<TextView> aOY;
    private com.baidu.adp.lib.e.b<View> aOZ;
    private boolean aPA;
    private d aPB;
    private boolean aPC;
    private TbRichText aPD;
    private String aPE;
    private boolean aPF;
    private boolean aPG;
    private boolean aPH;
    private int aPI;
    private boolean aPJ;
    private boolean aPK;
    private boolean aPL;
    private boolean aPM;
    private int aPN;
    private int aPO;
    private boolean aPP;
    private boolean aPQ;
    private boolean aPR;
    public final View.OnClickListener aPS;
    private final TbImageView.b aPT;
    private boolean aPU;
    private Drawable aPV;
    private CustomMessageListener aPW;
    private com.baidu.adp.lib.e.b<View> aPa;
    private com.baidu.adp.lib.e.b<LinearLayout> aPb;
    private com.baidu.adp.lib.e.b<GifView> aPc;
    private float aPd;
    private int aPe;
    private int aPf;
    private float aPg;
    private int aPh;
    private int aPi;
    private int aPj;
    private int aPk;
    private int aPl;
    private ImageView.ScaleType aPm;
    private int aPn;
    private boolean aPo;
    private TextUtils.TruncateAt aPp;
    private g aPq;
    private e aPr;
    private com.baidu.tieba.pb.a.d aPs;
    private f aPt;
    private View.OnClickListener aPu;
    private boolean aPv;
    private int aPw;
    private boolean aPx;
    private boolean aPy;
    private Runnable aPz;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private View.OnLongClickListener onLongClickListener;

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
        aOV = aOU > 0.0f ? 1.0f / aOU : 0.3f;
        aOW = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aPP = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aPR = z;
    }

    public boolean II() {
        return this.aPA;
    }

    public void IJ() {
        this.aPF = true;
    }

    public String getBackgroundImageUrl() {
        return this.aPE;
    }

    public void setBackgroundImageUrl(String str) {
        this.aPE = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BS = i;
    }

    public void setMaxLines(int i) {
        this.aPI = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aPp = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aPL = z;
    }

    public boolean getIsSupportVitality() {
        return this.aPL;
    }

    public void setIsSupportNewFirstFloor(boolean z) {
        this.aPM = z;
    }

    public void setPbFirstFloorLastTextToBottom(int i) {
        this.aPN = i;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    public float getLineSpacing() {
        return this.aPd;
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
    public boolean M(View view) {
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
        return new com.baidu.adp.lib.e.b<>(new p(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aOX = null;
        this.aOY = null;
        this.aOZ = null;
        this.aPa = null;
        this.aPb = null;
        this.aPc = null;
        this.aPd = 0.0f;
        this.aPe = 0;
        this.aPf = 0;
        this.aPg = 15.0f;
        this.aPh = -1;
        this.aPi = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aPj = -9989158;
        this.aPk = 200;
        this.aPl = 200;
        this.aPm = null;
        this.Uq = 0;
        this.aPn = 0;
        this.aPo = false;
        this.aPp = null;
        this.aPq = null;
        this.aPr = null;
        this.aPs = null;
        this.aPt = null;
        this.aPu = null;
        this.aPv = true;
        this.mIsFromCDN = true;
        this.aPw = -1;
        this.aPx = false;
        this.aPy = false;
        this.aPz = null;
        this.aPA = false;
        this.aPC = true;
        this.aPE = null;
        this.aPF = false;
        this.aPG = false;
        this.BS = -1;
        this.aPI = -1;
        this.aPJ = true;
        this.aPK = false;
        this.aPL = false;
        this.aPM = false;
        this.aPN = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
        this.aPP = false;
        this.aPQ = false;
        this.aPR = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aMg = new com.baidu.tieba.pb.a.d(new j(this));
        this.aPS = new k(this);
        this.aKv = new l(this);
        this.aPT = new m(this);
        this.mType = 19;
        this.aJO = new n(this);
        this.aPW = new o(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOX = null;
        this.aOY = null;
        this.aOZ = null;
        this.aPa = null;
        this.aPb = null;
        this.aPc = null;
        this.aPd = 0.0f;
        this.aPe = 0;
        this.aPf = 0;
        this.aPg = 15.0f;
        this.aPh = -1;
        this.aPi = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aPj = -9989158;
        this.aPk = 200;
        this.aPl = 200;
        this.aPm = null;
        this.Uq = 0;
        this.aPn = 0;
        this.aPo = false;
        this.aPp = null;
        this.aPq = null;
        this.aPr = null;
        this.aPs = null;
        this.aPt = null;
        this.aPu = null;
        this.aPv = true;
        this.mIsFromCDN = true;
        this.aPw = -1;
        this.aPx = false;
        this.aPy = false;
        this.aPz = null;
        this.aPA = false;
        this.aPC = true;
        this.aPE = null;
        this.aPF = false;
        this.aPG = false;
        this.BS = -1;
        this.aPI = -1;
        this.aPJ = true;
        this.aPK = false;
        this.aPL = false;
        this.aPM = false;
        this.aPN = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds48);
        this.aPP = false;
        this.aPQ = false;
        this.aPR = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aMg = new com.baidu.tieba.pb.a.d(new j(this));
        this.aPS = new k(this);
        this.aKv = new l(this);
        this.aPT = new m(this);
        this.mType = 19;
        this.aJO = new n(this);
        this.aPW = new o(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TbRichTextView);
        this.aPf = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aPe = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aPd = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aPg = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aPg);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aPk = obtainStyledAttributes.getDimensionPixelSize(6, this.aPk);
        this.aPl = obtainStyledAttributes.getDimensionPixelSize(7, this.aPl);
        this.Uq = obtainStyledAttributes.getResourceId(8, 0);
        this.aPh = obtainStyledAttributes.getDimensionPixelSize(9, this.aPh);
        this.aPi = obtainStyledAttributes.getDimensionPixelSize(10, this.aPi);
        this.aPn = obtainStyledAttributes.getResourceId(11, 0);
        this.aPo = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aPd = f2;
    }

    private void init() {
        aOW = getContext().getResources().getDimensionPixelSize(w.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Z.getOrignalPage();
        }
        if (Z != null) {
            Z.registerListener(this.aPW);
        }
        if (dVar != null) {
            this.aOX = dVar.Iz();
            this.aOY = dVar.IA();
            this.aPa = dVar.IC();
            this.aPb = dVar.ID();
            this.aPc = dVar.IB();
            this.aOZ = dVar.IE();
            if (dVar.getListView() != null && this.aPq == null) {
                this.aPq = new g(dVar.Iy());
                dVar.getListView().setRecyclerListener(this.aPq);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new q(this));
        this.aPO = com.baidu.adp.lib.util.k.af(getContext());
    }

    public void setText(TbRichText tbRichText) {
        a(tbRichText, false);
    }

    public void a(TbRichText tbRichText, boolean z) {
        a(tbRichText, z, (b) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r7v5 */
    public void a(TbRichText tbRichText, boolean z, b bVar) {
        ArrayList<TbRichTextData> HU;
        boolean z2;
        int i;
        int i2;
        SpannableStringBuilder Ib;
        ImageView imageView;
        View view;
        KeyEvent.Callback a2;
        if (this.aPD != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aPD = tbRichText;
            removeAllViews();
            if (tbRichText != null && (HU = tbRichText.HU()) != null) {
                Iterator<TbRichTextData> it = HU.iterator();
                int i3 = 0;
                View view2 = null;
                boolean z3 = true;
                View view3 = null;
                int i4 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aV = aV(getContext());
                            boolean a3 = a(next, aV, true, bVar);
                            if (z && !this.aPA && (Ib = next.Ib()) != null) {
                                this.aPA = Ib.length() >= 200;
                            }
                            if (this.aPs != null) {
                                aV.setOnTouchListener(this.aMg);
                                z2 = a3;
                                i = i4;
                                i2 = i3;
                                imageView = aV;
                            } else {
                                aV.setOnClickListener(this.aPu);
                                z2 = a3;
                                i = i4;
                                i2 = i3;
                                imageView = aV;
                            }
                        } else if (next.getType() == 8 && this.aPC) {
                            if (i3 < 10) {
                                ImageView aU = aU(getContext());
                                z2 = b(next, aU, this.aPk, this.aPl);
                                imageView = aU;
                                i = i4;
                                i2 = i3 + 1;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e Ie = next.Ie();
                            if (Ie != null && Ie.IG()) {
                                a2 = b(Ie);
                            } else {
                                a2 = a(next);
                            }
                            imageView = a2;
                            z2 = true;
                            i = i4;
                            i2 = i3;
                        } else if (next.getType() == 512) {
                            view3 = getVoiceView();
                            if (view3 != null) {
                                imageView = view3;
                                z2 = a(next, view3);
                                i = i4;
                                i2 = i3;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            imageView = textVoiceView;
                            i = i4;
                            i2 = i3;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            z2 = a(next, gifView);
                            imageView = gifView;
                            i = i4;
                            i2 = i3;
                        } else if (next.getType() == 20 && this.aPC) {
                            if (i4 < 10) {
                                ImageView aU2 = aU(getContext());
                                z2 = b(next, aU2, this.aPk, this.aPl);
                                imageView = aU2;
                                i = i4 + 1;
                                i2 = i3;
                            }
                        } else if (next.getType() != 1280 || !this.aPC) {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo Ik = next.Ik();
                                Ik.fu(tbRichText.HT());
                                if (Ik != null) {
                                    z2 = true;
                                    imageView = a(Ik, tbRichText.HT(), tbRichText.getAuthorId());
                                    i = i4;
                                    i2 = i3;
                                }
                            }
                            imageView = view3;
                            z2 = false;
                            i = i4;
                            i2 = i3;
                        } else {
                            ImageView aU3 = aU(getContext());
                            z2 = a(next, aU3, (this.aPk - getPaddingLeft()) - getPaddingRight(), this.aPl);
                            imageView = aU3;
                            i = i4;
                            i2 = i3 + 1;
                        }
                        if (!z2 || imageView == 0) {
                            view = view2;
                        } else {
                            addView(imageView);
                            view = imageView;
                        }
                        if (z3 && this.aPM) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                            if (layoutParams == null) {
                                z3 = false;
                                view2 = view;
                                i3 = i2;
                                view3 = imageView;
                                i4 = i;
                            } else {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds0);
                                imageView.setLayoutParams(layoutParams);
                                z3 = false;
                                view2 = view;
                                i3 = i2;
                                view3 = imageView;
                                i4 = i;
                            }
                        } else {
                            if ((imageView instanceof ImageView) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                                view.setLayoutParams(layoutParams2);
                                int g2 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
                                int g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
                                if (this.aPM) {
                                    g2 = aOT;
                                    g3 = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds16);
                                }
                                if ((i2 == 1 && i == 0) || (i2 == 0 && i == 1)) {
                                    layoutParams2.topMargin = g2;
                                } else if (i2 > 1 || i > 1) {
                                    layoutParams2.topMargin = g3;
                                }
                                imageView.setLayoutParams(layoutParams2);
                            }
                            view2 = view;
                            view3 = imageView;
                            i3 = i2;
                            i4 = i;
                        }
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    if (this.aPM) {
                        layoutParams3.bottomMargin = this.aPN;
                    } else {
                        layoutParams3.bottomMargin = this.aPf;
                    }
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.aPM) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds52);
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aPu = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fJ = this.aOX.fJ();
        if (fJ instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fJ;
            foreDrawableImageView.setForegroundDrawable(w.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(w.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aPk - getPaddingLeft()) - getPaddingRight(), this.aPl, new com.baidu.tbadk.widget.richText.g(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aPF);
            if (r.oK().oQ()) {
                foreDrawableImageView.setDefaultBgResource(w.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(w.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.getThumbUrl(), 17, false);
            return fJ;
        }
        return fJ;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int i5;
        if (this.aPL && S(i, i2) && this.aPO > 0) {
            i3 = this.aPO;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        int i6 = iArr[0];
        int i7 = iArr[1];
        if (!this.aPH || i3 <= i6 || aOU <= 1.0f) {
            i3 = i6;
            i5 = i7;
        } else {
            if (i6 * aOU <= i3) {
                if (i6 * aOU > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i6 * aOU);
                }
            }
            i5 = iArr[0] > 0 ? (iArr[1] * i3) / iArr[0] : i7;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Uq);
            if (tbImageView.getGifIconWidth() >= i3 || tbImageView.getGifIconHeight() >= i5) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i5);
        if (this.aPH) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aPm == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aPm);
        }
        if (this.aPL) {
            if (S(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aOS;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.aPs != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.aMg);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if ((imageView instanceof TbImageView) && this.onLongClickListener != null) {
            ((TbImageView) imageView).setDispatchTouchListener(this.aPT);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aPn <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aPf;
        linearLayout.setClickable(true);
        Bitmap cO = as.cO(this.aPn);
        if (cO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cO));
        }
        linearLayout.setFocusable(false);
        if (this.aPL) {
            layoutParams.leftMargin = aOS;
            layoutParams.rightMargin = aOS;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new h(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aPn;
    }

    public void setVideoImageId(int i) {
        this.aPn = i;
    }

    private ImageView aU(Context context) {
        ImageView fJ = this.aOX != null ? this.aOX.fJ() : null;
        if (fJ == null || fJ.getParent() != null) {
            fJ = null;
        }
        if (fJ != null) {
            fJ.setContentDescription(context.getString(w.l.editor_image));
        }
        return fJ;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Ii = tbRichTextData.Ii();
        if (Ii != null && Ii.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aPF) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Ii.Ix(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(Ii.getLink()));
                if (!Ii.Iq()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Ii.getWidth(), Ii.getHeight(), i, i2, this.aPS);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.getType() == 20) {
            if (tbRichTextData.Ig() == null) {
                return false;
            }
        } else if (tbRichTextData.Ia() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aPF) {
                tbImageView.setSupportNoImage(true);
            }
            if (tbRichTextData.getType() == 20) {
                tbImageView.c(tbRichTextData.Ig().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setTag(w.h.tag_rich_text_meme_info, tbRichTextData.Ig());
            } else {
                tbImageView.c(tbRichTextData.Ia().Ip(), this.mIsFromCDN ? 17 : 18, false);
                if (!tbRichTextData.Ia().Iq()) {
                    tbImageView.setAdjustViewBounds(false);
                }
                tbImageView.setTag(w.h.tag_rich_text_meme_info, null);
            }
        }
        if (tbRichTextData.getType() == 20) {
            return a(imageView, tbRichTextData.Ig().memeInfo.width.intValue(), tbRichTextData.Ig().memeInfo.height.intValue(), i, i2, this.mOnClickListener);
        }
        return a(imageView, tbRichTextData.Ia().getWidth(), tbRichTextData.Ia().getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aPH = z;
    }

    private TextView aV(Context context) {
        TextView textView = null;
        if (this.aOY != null) {
            textView = this.aOY.fJ();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aPe, 0, this.aPe, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aPG) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aPf;
        }
        textView.setLineSpacing(0.0f, this.aPd);
        textView.setTextSize(0, this.aPg);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(as.getColor(w.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(w.e.transparent));
        textView.setSingleLine(this.aPo);
        if (this.aPp != null) {
            textView.setEllipsize(this.aPp);
        }
        if (this.BS > 0) {
            textView.setMaxWidth(this.BS);
        }
        if (this.aPI > 0) {
            textView.setMaxLines(this.aPI);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Ib = tbRichTextData.Ib();
        if (Ib == null || Ib.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aPM) {
            this.aPh = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            this.aPi = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
        }
        if (this.aPi > 0 && this.aPh > 0) {
            tbRichTextData.Q(this.aPh, this.aPi);
        }
        if (textSize > 0) {
            tbRichTextData.P(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(Ib, textView, this);
        }
        try {
            textView.setText(Ib);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aPJ) {
            if (tbRichTextData.Il()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bqB());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aPM) {
            textView.setLineSpacing(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8), 1.0f);
        } else if (this.aPL) {
            layoutParams.leftMargin = aOS;
            layoutParams.rightMargin = aOS;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Id() != null) {
            tbRichTextData.Id().needRecompute = this.aPU;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aPc != null) {
            gifView = this.aPc.fJ();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aPL) {
                layoutParams.leftMargin = aOS;
                layoutParams.rightMargin = aOS;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.If().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.If().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.If().mGifInfo.mGifWidth, tbRichTextData.If().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aPL) {
                layoutParams2.leftMargin = aOS;
                layoutParams2.rightMargin = aOS;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new i(this, tbRichTextData));
        gifView.a(tbRichTextData.If().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fJ = this.aPa != null ? this.aPa.fJ() : null;
        if ((fJ == null || fJ.getParent() != null) && this.aPw != -1) {
            fJ = LayoutInflater.from(getContext()).inflate(this.aPw, (ViewGroup) null);
        }
        if (fJ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aPf;
            if (!this.aPM) {
                layoutParams.bottomMargin = this.aPf;
            }
            fJ.setLayoutParams(layoutParams);
            return fJ;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.d dVar = null;
        if (this.aOZ != null) {
            dVar = this.aOZ.fJ();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aPf;
        layoutParams.bottomMargin = this.aPf;
        if (this.aPL) {
            layoutParams.leftMargin = aOS;
            layoutParams.rightMargin = aOS;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.k(this.aPv, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aPF);
                dVar2.getGraffitiImageView().setDefaultResource(this.Uq);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aKv);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aPk - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aPR);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Ic());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aPL) {
            layoutParams.leftMargin = aOS;
            layoutParams.rightMargin = aOS;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fJ = this.aPb.fJ();
        if (fJ != null) {
            TextView aV = aV(getContext());
            if (aV == null) {
                this.aPb.n(fJ);
                return null;
            }
            fJ.addView(aV);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aOY.n(aV);
                this.aPb.n(fJ);
                return null;
            }
            fJ.addView(voiceView);
            return fJ;
        }
        return fJ;
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
        if (applyDimension != this.aPg) {
            this.aPg = applyDimension;
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
        if (this.aPe != i) {
            this.aPe = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aPe, 0, 0, this.aPe);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aPj) {
            this.aPj = i;
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
        if (this.aPO <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aPO)) > aOV ? 1 : ((((float) i) / ((float) this.aPO)) == aOV ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aPk;
    }

    public void setMaxImageWidth(int i) {
        this.aPk = i;
    }

    public int getMaxImageHeight() {
        return this.aPl;
    }

    public void setMaxImageHeight(int i) {
        this.aPl = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aPm;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aPm = scaleType;
    }

    public int getDefaultImageId() {
        return this.Uq;
    }

    public void setDefaultImageId(int i) {
        this.Uq = i;
    }

    public e getOnImageClickListener() {
        return this.aPr;
    }

    public void setOnImageClickListener(e eVar) {
        this.aPr = eVar;
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.d dVar) {
        this.aPs = dVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aPB = dVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aPv != z) {
            this.aPv = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aPv && this.aOX != null) {
                this.aOX.clear();
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
        this.aPx = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aPy) {
                    IL();
                    break;
                } else if (!this.aPK) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aPx) {
                    IK();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aPx = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IK() {
        this.aPy = false;
        if (this.aPz == null) {
            this.aPz = new a();
        }
        postDelayed(this.aPz, ViewConfiguration.getLongPressTimeout());
    }

    private void IL() {
        if (this.aPz != null) {
            removeCallbacks(this.aPz);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aPK && !TbRichTextView.this.aPQ && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aPy = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aPw = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aPE = null;
        if (this.aPV != drawable) {
            this.aPU = true;
            this.aPV = drawable;
        }
        setText(this.aPD);
        this.aPU = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DY();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DY();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DY();
        } else {
            refresh();
        }
    }

    public void gP(String str) {
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
            DY();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fL().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, 19, this.aJO, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void DY() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, 19, this.aJO);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kP(), aVar.kP().getNinePatchChunk(), aVar.kT(), null);
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
        gP(this.mUrl);
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
        return this.aPt;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aPt = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aPJ = z;
    }

    public void setTextCenter(boolean z) {
        this.aPG = z;
    }

    public void setIsNeedShowImages(boolean z) {
        this.aPC = z;
    }
}
