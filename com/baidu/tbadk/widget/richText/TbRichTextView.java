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
    private static final int aNo = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32);
    private static final float aNp = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst());
    private static final float aNq;
    static int aNr;
    private int BS;
    private int Vn;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIJ;
    private int aNA;
    private float aNB;
    private int aNC;
    private int aND;
    private int aNE;
    private int aNF;
    private int aNG;
    private ImageView.ScaleType aNH;
    private int aNI;
    private boolean aNJ;
    private TextUtils.TruncateAt aNK;
    private g aNL;
    private e aNM;
    private f aNN;
    private View.OnClickListener aNO;
    private boolean aNP;
    private int aNQ;
    private boolean aNR;
    private boolean aNS;
    private Runnable aNT;
    private boolean aNU;
    private d aNV;
    private TbRichText aNW;
    private String aNX;
    private boolean aNY;
    private boolean aNZ;
    private com.baidu.adp.lib.e.b<ImageView> aNs;
    private com.baidu.adp.lib.e.b<TextView> aNt;
    private com.baidu.adp.lib.e.b<View> aNu;
    private com.baidu.adp.lib.e.b<View> aNv;
    private com.baidu.adp.lib.e.b<LinearLayout> aNw;
    private com.baidu.adp.lib.e.b<GifView> aNx;
    private float aNy;
    private int aNz;
    private boolean aOa;
    private int aOb;
    private boolean aOc;
    private boolean aOd;
    private boolean aOe;
    private int aOf;
    private boolean aOg;
    private boolean aOh;
    public final View.OnClickListener aOi;
    private final View.OnTouchListener aOj;
    private boolean aOk;
    private Drawable aOl;
    private CustomMessageListener aOm;
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
        aNq = aNp > 0.0f ? 1.0f / aNp : 0.3f;
        aNr = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aOg = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aOh = z;
    }

    public boolean Jb() {
        return this.aNU;
    }

    public void Jc() {
        this.aNY = true;
    }

    public String getBackgroundImageUrl() {
        return this.aNX;
    }

    public void setBackgroundImageUrl(String str) {
        this.aNX = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.BS = i;
    }

    public void setMaxLines(int i) {
        this.aOb = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aNK = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aOe = z;
    }

    public boolean getIsSupportVitality() {
        return this.aOe;
    }

    public float getLineSpacing() {
        return this.aNy;
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
        this.aNs = null;
        this.aNt = null;
        this.aNu = null;
        this.aNv = null;
        this.aNw = null;
        this.aNx = null;
        this.aNy = 0.0f;
        this.aNz = 0;
        this.aNA = 0;
        this.aNB = 15.0f;
        this.aNC = -1;
        this.aND = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNE = -9989158;
        this.aNF = 200;
        this.aNG = 200;
        this.aNH = null;
        this.Vn = 0;
        this.aNI = 0;
        this.aNJ = false;
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = null;
        this.aNO = null;
        this.aNP = true;
        this.mIsFromCDN = true;
        this.aNQ = -1;
        this.aNR = false;
        this.aNS = false;
        this.aNT = null;
        this.aNU = false;
        this.aNX = null;
        this.aNY = false;
        this.aNZ = false;
        this.BS = -1;
        this.aOb = -1;
        this.aOc = true;
        this.aOd = false;
        this.aOe = false;
        this.aOg = false;
        this.aOh = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aOi = new h(this);
        this.aOj = new i(this);
        this.mType = 19;
        this.aIJ = new j(this);
        this.aOm = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNs = null;
        this.aNt = null;
        this.aNu = null;
        this.aNv = null;
        this.aNw = null;
        this.aNx = null;
        this.aNy = 0.0f;
        this.aNz = 0;
        this.aNA = 0;
        this.aNB = 15.0f;
        this.aNC = -1;
        this.aND = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNE = -9989158;
        this.aNF = 200;
        this.aNG = 200;
        this.aNH = null;
        this.Vn = 0;
        this.aNI = 0;
        this.aNJ = false;
        this.aNK = null;
        this.aNL = null;
        this.aNM = null;
        this.aNN = null;
        this.aNO = null;
        this.aNP = true;
        this.mIsFromCDN = true;
        this.aNQ = -1;
        this.aNR = false;
        this.aNS = false;
        this.aNT = null;
        this.aNU = false;
        this.aNX = null;
        this.aNY = false;
        this.aNZ = false;
        this.BS = -1;
        this.aOb = -1;
        this.aOc = true;
        this.aOd = false;
        this.aOe = false;
        this.aOg = false;
        this.aOh = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aOi = new h(this);
        this.aOj = new i(this);
        this.mType = 19;
        this.aIJ = new j(this);
        this.aOm = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TbRichTextView);
        this.aNA = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aNz = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aNy = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aNB = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aNB);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aNF = obtainStyledAttributes.getDimensionPixelSize(6, this.aNF);
        this.aNG = obtainStyledAttributes.getDimensionPixelSize(7, this.aNG);
        this.Vn = obtainStyledAttributes.getResourceId(8, 0);
        this.aNC = obtainStyledAttributes.getDimensionPixelSize(9, this.aNC);
        this.aND = obtainStyledAttributes.getDimensionPixelSize(10, this.aND);
        this.aNI = obtainStyledAttributes.getResourceId(11, 0);
        this.aNJ = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aNy = f2;
    }

    private void init() {
        aNr = getContext().getResources().getDimensionPixelSize(w.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (Z != null && (Z.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) Z.getOrignalPage();
        }
        if (Z != null) {
            Z.registerListener(this.aOm);
        }
        if (dVar != null) {
            this.aNs = dVar.IS();
            this.aNt = dVar.IT();
            this.aNv = dVar.IV();
            this.aNw = dVar.IW();
            this.aNx = dVar.IU();
            this.aNu = dVar.IX();
            if (dVar.getListView() != null && this.aNL == null) {
                this.aNL = new g(dVar.IR());
                dVar.getListView().setRecyclerListener(this.aNL);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new m(this));
        this.aOf = com.baidu.adp.lib.util.k.af(getContext());
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
        if (this.aNW != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aNW = tbRichText;
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
                            if (z && !this.aNU && (Iv = next.Iv()) != null) {
                                this.aNU = Iv.length() >= 200;
                            }
                            aS.setOnClickListener(this.aNO);
                            z2 = a3;
                            view3 = aS;
                        } else if (next.getType() == 8) {
                            if (i < 10) {
                                i++;
                                ImageView aR = aR(getContext());
                                z2 = b(next, aR, this.aNF, this.aNG);
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
                            z2 = a(next, aR2, (this.aNF - getPaddingLeft()) - getPaddingRight(), this.aNG);
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
                    layoutParams2.bottomMargin = this.aNA;
                    view2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aNO = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fK = this.aNs.fK();
        if (fK instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fK;
            foreDrawableImageView.setForegroundDrawable(w.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(w.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aNF - getPaddingLeft()) - getPaddingRight(), this.aNG, new n(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aNY);
            if (q.po().pu()) {
                foreDrawableImageView.setDefaultBgResource(w.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(w.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.qP(), 17, false);
            return fK;
        }
        return fK;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aOe && S(i, i2) && this.aOf > 0) {
            i3 = this.aOf;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.Vn);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aOa || i3 <= i5 || aNp <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aNp <= i3) {
                if (i5 * aNp > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aNp);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aOa) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aNH == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aNH);
        }
        if (this.aOe) {
            if (S(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aNo;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aNI <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aNA;
        linearLayout.setClickable(true);
        Bitmap cO = aq.cO(this.aNI);
        if (cO != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cO));
        }
        linearLayout.setFocusable(false);
        if (this.aOe) {
            layoutParams.leftMargin = aNo;
            layoutParams.rightMargin = aNo;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aNI;
    }

    public void setVideoImageId(int i) {
        this.aNI = i;
    }

    private ImageView aR(Context context) {
        ImageView fK = this.aNs != null ? this.aNs.fK() : null;
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
        TbRichTextLinkImageInfo IB = tbRichTextData.IB();
        if (IB != null && IB.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aNY) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(IB.IQ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(IB.getLink()));
                if (!IB.IJ()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, IB.getWidth(), IB.getHeight(), i, i2, this.aOi);
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
            if (this.aNY) {
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
        this.aOa = z;
    }

    private TextView aS(Context context) {
        TextView textView = null;
        if (this.aNt != null) {
            textView = this.aNt.fK();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aNz, 0, this.aNz, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aNZ) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aNA;
        }
        textView.setLineSpacing(0.0f, this.aNy);
        textView.setTextSize(0, this.aNB);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(w.e.transparent));
        textView.setSingleLine(this.aNJ);
        if (this.aNK != null) {
            textView.setEllipsize(this.aNK);
        }
        if (this.BS > 0) {
            textView.setMaxWidth(this.BS);
        }
        if (this.aOb > 0) {
            textView.setMaxLines(this.aOb);
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
        if (this.aND > 0 && this.aNC > 0) {
            tbRichTextData.Q(this.aNC, this.aND);
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
        if (this.aOc) {
            if (tbRichTextData.IE()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bnn());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aOe) {
            layoutParams.leftMargin = aNo;
            layoutParams.rightMargin = aNo;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.Ix() != null) {
            tbRichTextData.Ix().needRecompute = this.aOk;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aNx != null) {
            gifView = this.aNx.fK();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aOe) {
                layoutParams.leftMargin = aNo;
                layoutParams.rightMargin = aNo;
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
            if (this.aOe) {
                layoutParams2.leftMargin = aNo;
                layoutParams2.rightMargin = aNo;
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
        View fK = this.aNv != null ? this.aNv.fK() : null;
        if ((fK == null || fK.getParent() != null) && this.aNQ != -1) {
            fK = LayoutInflater.from(getContext()).inflate(this.aNQ, (ViewGroup) null);
        }
        if (fK != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aNA;
            layoutParams.bottomMargin = this.aNA;
            fK.setLayoutParams(layoutParams);
            return fK;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.d dVar = null;
        if (this.aNu != null) {
            dVar = this.aNu.fK();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aNA;
        layoutParams.bottomMargin = this.aNA;
        if (this.aOe) {
            layoutParams.leftMargin = aNo;
            layoutParams.rightMargin = aNo;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.j(this.aNP, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aNY);
                dVar2.getGraffitiImageView().setDefaultResource(this.Vn);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aOj);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aNF - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aOh);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.Iw());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aOe) {
            layoutParams.leftMargin = aNo;
            layoutParams.rightMargin = aNo;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fK = this.aNw.fK();
        if (fK != null) {
            TextView aS = aS(getContext());
            if (aS == null) {
                this.aNw.n(fK);
                return null;
            }
            fK.addView(aS);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aNt.n(aS);
                this.aNw.n(fK);
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
        if (applyDimension != this.aNB) {
            this.aNB = applyDimension;
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
        if (this.aNz != i) {
            this.aNz = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aNz, 0, 0, this.aNz);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aNE) {
            this.aNE = i;
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
        if (this.aOf <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aOf)) > aNq ? 1 : ((((float) i) / ((float) this.aOf)) == aNq ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aNF;
    }

    public void setMaxImageWidth(int i) {
        this.aNF = i;
    }

    public int getMaxImageHeight() {
        return this.aNG;
    }

    public void setMaxImageHeight(int i) {
        this.aNG = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aNH;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aNH = scaleType;
    }

    public int getDefaultImageId() {
        return this.Vn;
    }

    public void setDefaultImageId(int i) {
        this.Vn = i;
    }

    public e getOnImageClickListener() {
        return this.aNM;
    }

    public void setOnImageClickListener(e eVar) {
        this.aNM = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aNV = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aNP != z) {
            this.aNP = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aNP && this.aNs != null) {
                this.aNs.clear();
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
        this.aNR = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aNS) {
                    Je();
                    break;
                } else if (!this.aOd) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aNR) {
                    Jd();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aNR = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Jd() {
        this.aNS = false;
        if (this.aNT == null) {
            this.aNT = new a();
        }
        postDelayed(this.aNT, ViewConfiguration.getLongPressTimeout());
    }

    private void Je() {
        if (this.aNT != null) {
            removeCallbacks(this.aNT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aOd && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aNS = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aNQ = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aNX = null;
        if (this.aOl != drawable) {
            this.aOk = true;
            this.aOl = drawable;
        }
        setText(this.aNW);
        this.aOk = false;
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
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fM().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, this.aIJ, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void EG() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.mUrl, 19, this.aIJ);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kS(), aVar.kS().getNinePatchChunk(), aVar.kW(), null);
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
        return this.aNN;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aNN = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aOc = z;
    }

    public void setTextCenter(boolean z) {
        this.aNZ = z;
    }
}
