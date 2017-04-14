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
import com.baidu.tbadk.core.q;
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
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    private static final int aNm = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32);
    private static final float aNn = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
    private static final float aNo;
    static int aNp;
    private int BP;
    private int Vl;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIH;
    private int aNA;
    private int aNB;
    private int aNC;
    private int aND;
    private int aNE;
    private ImageView.ScaleType aNF;
    private int aNG;
    private boolean aNH;
    private TextUtils.TruncateAt aNI;
    private g aNJ;
    private e aNK;
    private f aNL;
    private View.OnClickListener aNM;
    private boolean aNN;
    private int aNO;
    private boolean aNP;
    private boolean aNQ;
    private Runnable aNR;
    private boolean aNS;
    private d aNT;
    private TbRichText aNU;
    private String aNV;
    private boolean aNW;
    private boolean aNX;
    private boolean aNY;
    private int aNZ;
    private com.baidu.adp.lib.e.b<ImageView> aNq;
    private com.baidu.adp.lib.e.b<TextView> aNr;
    private com.baidu.adp.lib.e.b<View> aNs;
    private com.baidu.adp.lib.e.b<View> aNt;
    private com.baidu.adp.lib.e.b<LinearLayout> aNu;
    private com.baidu.adp.lib.e.b<GifView> aNv;
    private float aNw;
    private int aNx;
    private int aNy;
    private float aNz;
    private boolean aOa;
    private boolean aOb;
    private boolean aOc;
    private int aOd;
    private boolean aOe;
    private boolean aOf;
    public final View.OnClickListener aOg;
    private final View.OnTouchListener aOh;
    private boolean aOi;
    private Drawable aOj;
    private CustomMessageListener aOk;
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
        aNo = aNn > 0.0f ? 1.0f / aNn : 0.3f;
        aNp = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aOe = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aOf = z;
    }

    public boolean Jb() {
        return this.aNS;
    }

    public void Jc() {
        this.aNW = true;
    }

    public String getBackgroundImageUrl() {
        return this.aNV;
    }

    public void setBackgroundImageUrl(String str) {
        this.aNV = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BP = i;
    }

    public void setMaxLines(int i) {
        this.aNZ = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aNI = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aOc = z;
    }

    public boolean getIsSupportVitality() {
        return this.aOc;
    }

    public float getLineSpacing() {
        return this.aNw;
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
        return new com.baidu.adp.lib.e.b<>(new l(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aNq = null;
        this.aNr = null;
        this.aNs = null;
        this.aNt = null;
        this.aNu = null;
        this.aNv = null;
        this.aNw = 0.0f;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 15.0f;
        this.aNA = -1;
        this.aNB = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNC = -9989158;
        this.aND = 200;
        this.aNE = 200;
        this.aNF = null;
        this.Vl = 0;
        this.aNG = 0;
        this.aNH = false;
        this.aNI = null;
        this.aNJ = null;
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = true;
        this.mIsFromCDN = true;
        this.aNO = -1;
        this.aNP = false;
        this.aNQ = false;
        this.aNR = null;
        this.aNS = false;
        this.aNV = null;
        this.aNW = false;
        this.aNX = false;
        this.BP = -1;
        this.aNZ = -1;
        this.aOa = true;
        this.aOb = false;
        this.aOc = false;
        this.aOe = false;
        this.aOf = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aOg = new h(this);
        this.aOh = new i(this);
        this.mType = 19;
        this.aIH = new j(this);
        this.aOk = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNq = null;
        this.aNr = null;
        this.aNs = null;
        this.aNt = null;
        this.aNu = null;
        this.aNv = null;
        this.aNw = 0.0f;
        this.aNx = 0;
        this.aNy = 0;
        this.aNz = 15.0f;
        this.aNA = -1;
        this.aNB = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNC = -9989158;
        this.aND = 200;
        this.aNE = 200;
        this.aNF = null;
        this.Vl = 0;
        this.aNG = 0;
        this.aNH = false;
        this.aNI = null;
        this.aNJ = null;
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = true;
        this.mIsFromCDN = true;
        this.aNO = -1;
        this.aNP = false;
        this.aNQ = false;
        this.aNR = null;
        this.aNS = false;
        this.aNV = null;
        this.aNW = false;
        this.aNX = false;
        this.BP = -1;
        this.aNZ = -1;
        this.aOa = true;
        this.aOb = false;
        this.aOc = false;
        this.aOe = false;
        this.aOf = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aOg = new h(this);
        this.aOh = new i(this);
        this.mType = 19;
        this.aIH = new j(this);
        this.aOk = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TbRichTextView);
        this.aNy = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aNx = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aNw = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aNz = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aNz);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aND = obtainStyledAttributes.getDimensionPixelSize(6, this.aND);
        this.aNE = obtainStyledAttributes.getDimensionPixelSize(7, this.aNE);
        this.Vl = obtainStyledAttributes.getResourceId(8, 0);
        this.aNA = obtainStyledAttributes.getDimensionPixelSize(9, this.aNA);
        this.aNB = obtainStyledAttributes.getDimensionPixelSize(10, this.aNB);
        this.aNG = obtainStyledAttributes.getResourceId(11, 0);
        this.aNH = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aNw = f2;
    }

    private void init() {
        aNp = getContext().getResources().getDimensionPixelSize(w.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Z.getOrignalPage();
        }
        if (Z != null) {
            Z.registerListener(this.aOk);
        }
        if (dVar != null) {
            this.aNq = dVar.IS();
            this.aNr = dVar.IT();
            this.aNt = dVar.IV();
            this.aNu = dVar.IW();
            this.aNv = dVar.IU();
            this.aNs = dVar.IX();
            if (dVar.getListView() != null && this.aNJ == null) {
                this.aNJ = new g(dVar.IR());
                dVar.getListView().setRecyclerListener(this.aNJ);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new m(this));
        this.aOd = com.baidu.adp.lib.util.k.af(getContext());
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
        ArrayList<TbRichTextData> Io;
        boolean z2;
        SpannableStringBuilder Iv;
        View view;
        View a2;
        View view2 = null;
        if (this.aNU != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aNU = tbRichText;
            removeAllViews();
            if (tbRichText != null && (Io = tbRichText.Io()) != null) {
                Iterator<TbRichTextData> it = Io.iterator();
                int i = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aS = aS(getContext());
                            boolean a3 = a(next, aS, true, bVar);
                            if (z && !this.aNS && (Iv = next.Iv()) != null) {
                                this.aNS = Iv.length() >= 200;
                            }
                            aS.setOnClickListener(this.aNM);
                            z2 = a3;
                            view3 = aS;
                        } else if (next.getType() == 8) {
                            if (i < 10) {
                                i++;
                                ImageView aR = aR(getContext());
                                z2 = b(next, aR, this.aND, this.aNE);
                                view3 = aR;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e Iy = next.Iy();
                            if (Iy != null && Iy.IZ()) {
                                a2 = b(Iy);
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
                            ImageView aR2 = aR(getContext());
                            i++;
                            z2 = a(next, aR2, (this.aND - getPaddingLeft()) - getPaddingRight(), this.aNE);
                            view3 = aR2;
                        } else {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo ID = next.ID();
                                ID.fu(tbRichText.In());
                                if (ID != null) {
                                    View a4 = a(ID, tbRichText.In(), tbRichText.getAuthorId());
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
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
                            } else if (i > 1) {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4);
                            }
                            view3.setLayoutParams(layoutParams);
                        }
                        view2 = view;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams2.bottomMargin = this.aNy;
                    view2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aNM = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fJ = this.aNq.fJ();
        if (fJ instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fJ;
            foreDrawableImageView.setForegroundDrawable(w.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(w.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aND - getPaddingLeft()) - getPaddingRight(), this.aNE, new n(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aNW);
            if (q.po().pu()) {
                foreDrawableImageView.setDefaultBgResource(w.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(w.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.qP(), 17, false);
            return fJ;
        }
        return fJ;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aOc && S(i, i2) && this.aOd > 0) {
            i3 = this.aOd;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Vl);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aNY || i3 <= i5 || aNn <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aNn <= i3) {
                if (i5 * aNn > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aNn);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aNY) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aNF == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aNF);
        }
        if (this.aOc) {
            if (S(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aNm;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aNG <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aNy;
        linearLayout.setClickable(true);
        Bitmap cO = aq.cO(this.aNG);
        if (cO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cO));
        }
        linearLayout.setFocusable(false);
        if (this.aOc) {
            layoutParams.leftMargin = aNm;
            layoutParams.rightMargin = aNm;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aNG;
    }

    public void setVideoImageId(int i) {
        this.aNG = i;
    }

    private ImageView aR(Context context) {
        ImageView fJ = this.aNq != null ? this.aNq.fJ() : null;
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
        TbRichTextLinkImageInfo IB = tbRichTextData.IB();
        if (IB != null && IB.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aNW) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IB.IQ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IB.getLink()));
                if (!IB.IJ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IB.getWidth(), IB.getHeight(), i, i2, this.aOg);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextImageInfo Iu = tbRichTextData.Iu();
        if (Iu == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aNW) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(Iu.II(), this.mIsFromCDN ? 17 : 18, false);
            if (!Iu.IJ()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Iu.getWidth(), Iu.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aNY = z;
    }

    private TextView aS(Context context) {
        TextView textView = null;
        if (this.aNr != null) {
            textView = this.aNr.fJ();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aNx, 0, this.aNx, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aNX) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aNy;
        }
        textView.setLineSpacing(0.0f, this.aNw);
        textView.setTextSize(0, this.aNz);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(w.e.transparent));
        textView.setSingleLine(this.aNH);
        if (this.aNI != null) {
            textView.setEllipsize(this.aNI);
        }
        if (this.BP > 0) {
            textView.setMaxWidth(this.BP);
        }
        if (this.aNZ > 0) {
            textView.setMaxLines(this.aNZ);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder Iv = tbRichTextData.Iv();
        if (Iv == null || Iv.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aNB > 0 && this.aNA > 0) {
            tbRichTextData.Q(this.aNA, this.aNB);
        }
        if (textSize > 0) {
            tbRichTextData.P(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(Iv, textView, this);
        }
        try {
            textView.setText(Iv);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aOa) {
            if (tbRichTextData.IE()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bmm());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aOc) {
            layoutParams.leftMargin = aNm;
            layoutParams.rightMargin = aNm;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Ix() != null) {
            tbRichTextData.Ix().needRecompute = this.aOi;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aNv != null) {
            gifView = this.aNv.fJ();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aOc) {
                layoutParams.leftMargin = aNm;
                layoutParams.rightMargin = aNm;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.Iz().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Iz().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Iz().mGifInfo.mGifWidth, tbRichTextData.Iz().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aOc) {
                layoutParams2.leftMargin = aNm;
                layoutParams2.rightMargin = aNm;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new com.baidu.tbadk.widget.richText.g(this, tbRichTextData));
        gifView.a(tbRichTextData.Iz().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fJ = this.aNt != null ? this.aNt.fJ() : null;
        if ((fJ == null || fJ.getParent() != null) && this.aNO != -1) {
            fJ = LayoutInflater.from(getContext()).inflate(this.aNO, (ViewGroup) null);
        }
        if (fJ != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aNy;
            layoutParams.bottomMargin = this.aNy;
            fJ.setLayoutParams(layoutParams);
            return fJ;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.d dVar = null;
        if (this.aNs != null) {
            dVar = this.aNs.fJ();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aNy;
        layoutParams.bottomMargin = this.aNy;
        if (this.aOc) {
            layoutParams.leftMargin = aNm;
            layoutParams.rightMargin = aNm;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.j(this.aNN, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aNW);
                dVar2.getGraffitiImageView().setDefaultResource(this.Vl);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aOh);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aND - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aOf);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Iw());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aOc) {
            layoutParams.leftMargin = aNm;
            layoutParams.rightMargin = aNm;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fJ = this.aNu.fJ();
        if (fJ != null) {
            TextView aS = aS(getContext());
            if (aS == null) {
                this.aNu.n(fJ);
                return null;
            }
            fJ.addView(aS);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aNr.n(aS);
                this.aNu.n(fJ);
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
        if (applyDimension != this.aNz) {
            this.aNz = applyDimension;
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
        if (this.aNx != i) {
            this.aNx = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aNx, 0, 0, this.aNx);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aNC) {
            this.aNC = i;
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
        if (this.aOd <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aOd)) > aNo ? 1 : ((((float) i) / ((float) this.aOd)) == aNo ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aND;
    }

    public void setMaxImageWidth(int i) {
        this.aND = i;
    }

    public int getMaxImageHeight() {
        return this.aNE;
    }

    public void setMaxImageHeight(int i) {
        this.aNE = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aNF;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aNF = scaleType;
    }

    public int getDefaultImageId() {
        return this.Vl;
    }

    public void setDefaultImageId(int i) {
        this.Vl = i;
    }

    public e getOnImageClickListener() {
        return this.aNK;
    }

    public void setOnImageClickListener(e eVar) {
        this.aNK = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aNT = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aNN != z) {
            this.aNN = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aNN && this.aNq != null) {
                this.aNq.clear();
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
        this.aNP = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aNQ) {
                    Je();
                    break;
                } else if (!this.aOb) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aNP) {
                    Jd();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aNP = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jd() {
        this.aNQ = false;
        if (this.aNR == null) {
            this.aNR = new a();
        }
        postDelayed(this.aNR, ViewConfiguration.getLongPressTimeout());
    }

    private void Je() {
        if (this.aNR != null) {
            removeCallbacks(this.aNR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aOb && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aNQ = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aNO = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aNV = null;
        if (this.aOj != drawable) {
            this.aOi = true;
            this.aOj = drawable;
        }
        setText(this.aNU);
        this.aOi = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EG();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        EG();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            EG();
        } else {
            refresh();
        }
    }

    public void gv(String str) {
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
            EG();
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
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, 19, this.aIH, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void EG() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fL().a(this.mUrl, 19, this.aIH);
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

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        gv(this.mUrl);
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
        return this.aNL;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aNL = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aOa = z;
    }

    public void setTextCenter(boolean z) {
        this.aNX = z;
    }
}
