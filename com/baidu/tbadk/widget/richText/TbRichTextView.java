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
    private static final int aMW = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32);
    private static final float aMX = com.baidu.adp.lib.util.k.ai(TbadkCoreApplication.m9getInst());
    private static final float aMY;
    static int aMZ;
    private int Co;
    private int US;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIr;
    private boolean aNA;
    private Runnable aNB;
    private boolean aNC;
    private d aND;
    private TbRichText aNE;
    private String aNF;
    private boolean aNG;
    private boolean aNH;
    private boolean aNI;
    private int aNJ;
    private boolean aNK;
    private boolean aNL;
    private boolean aNM;
    private int aNN;
    private boolean aNO;
    private boolean aNP;
    public final View.OnClickListener aNQ;
    private final View.OnTouchListener aNR;
    private boolean aNS;
    private Drawable aNT;
    private CustomMessageListener aNU;
    private com.baidu.adp.lib.e.b<ImageView> aNa;
    private com.baidu.adp.lib.e.b<TextView> aNb;
    private com.baidu.adp.lib.e.b<View> aNc;
    private com.baidu.adp.lib.e.b<View> aNd;
    private com.baidu.adp.lib.e.b<LinearLayout> aNe;
    private com.baidu.adp.lib.e.b<GifView> aNf;
    private float aNg;
    private int aNh;
    private int aNi;
    private float aNj;
    private int aNk;
    private int aNl;
    private int aNm;
    private int aNn;
    private int aNo;
    private ImageView.ScaleType aNp;
    private int aNq;
    private boolean aNr;
    private TextUtils.TruncateAt aNs;
    private g aNt;
    private e aNu;
    private f aNv;
    private View.OnClickListener aNw;
    private boolean aNx;
    private int aNy;
    private boolean aNz;
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
        aMY = aMX > 0.0f ? 1.0f / aMX : 0.3f;
        aMZ = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aNO = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aNP = z;
    }

    public boolean IC() {
        return this.aNC;
    }

    public void ID() {
        this.aNG = true;
    }

    public String getBackgroundImageUrl() {
        return this.aNF;
    }

    public void setBackgroundImageUrl(String str) {
        this.aNF = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Co = i;
    }

    public void setMaxLines(int i) {
        this.aNJ = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aNs = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aNM = z;
    }

    public boolean getIsSupportVitality() {
        return this.aNM;
    }

    public float getLineSpacing() {
        return this.aNg;
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
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.aNd = null;
        this.aNe = null;
        this.aNf = null;
        this.aNg = 0.0f;
        this.aNh = 0;
        this.aNi = 0;
        this.aNj = 15.0f;
        this.aNk = -1;
        this.aNl = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNm = -9989158;
        this.aNn = 200;
        this.aNo = 200;
        this.aNp = null;
        this.US = 0;
        this.aNq = 0;
        this.aNr = false;
        this.aNs = null;
        this.aNt = null;
        this.aNu = null;
        this.aNv = null;
        this.aNw = null;
        this.aNx = true;
        this.mIsFromCDN = true;
        this.aNy = -1;
        this.aNz = false;
        this.aNA = false;
        this.aNB = null;
        this.aNC = false;
        this.aNF = null;
        this.aNG = false;
        this.aNH = false;
        this.Co = -1;
        this.aNJ = -1;
        this.aNK = true;
        this.aNL = false;
        this.aNM = false;
        this.aNO = false;
        this.aNP = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aNQ = new h(this);
        this.aNR = new i(this);
        this.mType = 19;
        this.aIr = new j(this);
        this.aNU = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNa = null;
        this.aNb = null;
        this.aNc = null;
        this.aNd = null;
        this.aNe = null;
        this.aNf = null;
        this.aNg = 0.0f;
        this.aNh = 0;
        this.aNi = 0;
        this.aNj = 15.0f;
        this.aNk = -1;
        this.aNl = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aNm = -9989158;
        this.aNn = 200;
        this.aNo = 200;
        this.aNp = null;
        this.US = 0;
        this.aNq = 0;
        this.aNr = false;
        this.aNs = null;
        this.aNt = null;
        this.aNu = null;
        this.aNv = null;
        this.aNw = null;
        this.aNx = true;
        this.mIsFromCDN = true;
        this.aNy = -1;
        this.aNz = false;
        this.aNA = false;
        this.aNB = null;
        this.aNC = false;
        this.aNF = null;
        this.aNG = false;
        this.aNH = false;
        this.Co = -1;
        this.aNJ = -1;
        this.aNK = true;
        this.aNL = false;
        this.aNM = false;
        this.aNO = false;
        this.aNP = true;
        this.mOnClickListener = new com.baidu.tbadk.widget.richText.f(this);
        this.aNQ = new h(this);
        this.aNR = new i(this);
        this.mType = 19;
        this.aIr = new j(this);
        this.aNU = new k(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.TbRichTextView);
        this.aNi = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aNh = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aNg = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aNj = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aNj);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aNn = obtainStyledAttributes.getDimensionPixelSize(6, this.aNn);
        this.aNo = obtainStyledAttributes.getDimensionPixelSize(7, this.aNo);
        this.US = obtainStyledAttributes.getResourceId(8, 0);
        this.aNk = obtainStyledAttributes.getDimensionPixelSize(9, this.aNk);
        this.aNl = obtainStyledAttributes.getDimensionPixelSize(10, this.aNl);
        this.aNq = obtainStyledAttributes.getResourceId(11, 0);
        this.aNr = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aNg = f2;
    }

    private void init() {
        aMZ = getContext().getResources().getDimensionPixelSize(w.f.ds348);
        com.baidu.tbadk.widget.richText.d dVar = null;
        com.baidu.adp.base.g<?> aa = com.baidu.adp.base.k.aa(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.d) {
            dVar = (com.baidu.tbadk.widget.richText.d) getContext();
        } else if (aa != null && (aa.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.d)) {
            dVar = (com.baidu.tbadk.widget.richText.d) aa.getOrignalPage();
        }
        if (aa != null) {
            aa.registerListener(this.aNU);
        }
        if (dVar != null) {
            this.aNa = dVar.It();
            this.aNb = dVar.Iu();
            this.aNd = dVar.Iw();
            this.aNe = dVar.Ix();
            this.aNf = dVar.Iv();
            this.aNc = dVar.Iy();
            if (dVar.getListView() != null && this.aNt == null) {
                this.aNt = new g(dVar.Is());
                dVar.getListView().setRecyclerListener(this.aNt);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new m(this));
        this.aNN = com.baidu.adp.lib.util.k.ag(getContext());
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
        ArrayList<TbRichTextData> HP;
        boolean z2;
        SpannableStringBuilder HW;
        View view;
        View a2;
        View view2 = null;
        if (this.aNE != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.aNE = tbRichText;
            removeAllViews();
            if (tbRichText != null && (HP = tbRichText.HP()) != null) {
                Iterator<TbRichTextData> it = HP.iterator();
                int i = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aQ = aQ(getContext());
                            boolean a3 = a(next, aQ, true, bVar);
                            if (z && !this.aNC && (HW = next.HW()) != null) {
                                this.aNC = HW.length() >= 200;
                            }
                            aQ.setOnClickListener(this.aNw);
                            z2 = a3;
                            view3 = aQ;
                        } else if (next.getType() == 8) {
                            if (i < 10) {
                                i++;
                                ImageView aP = aP(getContext());
                                z2 = b(next, aP, this.aNn, this.aNo);
                                view3 = aP;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.e HZ = next.HZ();
                            if (HZ != null && HZ.IA()) {
                                a2 = b(HZ);
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
                            ImageView aP2 = aP(getContext());
                            i++;
                            z2 = a(next, aP2, (this.aNn - getPaddingLeft()) - getPaddingRight(), this.aNo);
                            view3 = aP2;
                        } else {
                            if (next.getType() == 1536) {
                                TbRichTextGraffitiInfo Ie = next.Ie();
                                Ie.fr(tbRichText.HO());
                                if (Ie != null) {
                                    View a4 = a(Ie, tbRichText.HO(), tbRichText.getAuthorId());
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
                    layoutParams2.bottomMargin = this.aNi;
                    view2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aNw = onClickListener;
    }

    private View b(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar == null || !eVar.isAvaliable()) {
            return null;
        }
        ImageView fE = this.aNa.fE();
        if (fE instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) fE;
            foreDrawableImageView.setForegroundDrawable(w.g.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(w.e.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, eVar.getWidth(), eVar.getHeight(), (this.aNn - getPaddingLeft()) - getPaddingRight(), this.aNo, new n(this, eVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aNG);
            if (com.baidu.tbadk.core.l.oQ().oW()) {
                foreDrawableImageView.setDefaultBgResource(w.g.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(w.e.cp_bg_line_c);
            }
            foreDrawableImageView.c(eVar.qs(), 17, false);
            return fE;
        }
        return fE;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aNM && S(i, i2) && this.aNN > 0) {
            i3 = this.aNN;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.US);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aNI || i3 <= i5 || aMX <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aMX <= i3) {
                if (i5 * aMX > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aMX);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aNI) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aNp == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aNp);
        }
        if (this.aNM) {
            if (S(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aMW;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(TbRichTextData tbRichTextData) {
        if (this.aNq <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aNi;
        linearLayout.setClickable(true);
        Bitmap cL = aq.cL(this.aNq);
        if (cL != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cL));
        }
        linearLayout.setFocusable(false);
        if (this.aNM) {
            layoutParams.leftMargin = aMW;
            layoutParams.rightMargin = aMW;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new o(this, tbRichTextData));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aNq;
    }

    public void setVideoImageId(int i) {
        this.aNq = i;
    }

    private ImageView aP(Context context) {
        ImageView fE = this.aNa != null ? this.aNa.fE() : null;
        if (fE == null || fE.getParent() != null) {
            fE = null;
        }
        if (fE != null) {
            fE.setContentDescription(context.getString(w.l.log_msg_pic));
        }
        return fE;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo Ic = tbRichTextData.Ic();
        if (Ic != null && Ic.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aNG) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Ic.Ir(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(Ic.getLink()));
                if (!Ic.Ik()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Ic.getWidth(), Ic.getHeight(), i, i2, this.aNQ);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i, int i2) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextImageInfo HV = tbRichTextData.HV();
        if (HV == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aNG) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(HV.Ij(), this.mIsFromCDN ? 17 : 18, false);
            if (!HV.Ik()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, HV.getWidth(), HV.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aNI = z;
    }

    private TextView aQ(Context context) {
        TextView textView = null;
        if (this.aNb != null) {
            textView = this.aNb.fE();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aNh, 0, this.aNh, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aNH) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aNi;
        }
        textView.setLineSpacing(0.0f, this.aNg);
        textView.setTextSize(0, this.aNj);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(aq.getColor(w.e.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(w.e.transparent));
        textView.setSingleLine(this.aNr);
        if (this.aNs != null) {
            textView.setEllipsize(this.aNs);
        }
        if (this.Co > 0) {
            textView.setMaxWidth(this.Co);
        }
        if (this.aNJ > 0) {
            textView.setMaxLines(this.aNJ);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder HW = tbRichTextData.HW();
        if (HW == null || HW.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aNl > 0 && this.aNk > 0) {
            tbRichTextData.Q(this.aNk, this.aNl);
        }
        if (textSize > 0) {
            tbRichTextData.P(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(HW, textView, this);
        }
        try {
            textView.setText(HW);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aNK) {
            if (tbRichTextData.If()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.blC());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aNM) {
            layoutParams.leftMargin = aMW;
            layoutParams.rightMargin = aMW;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.HY() != null) {
            tbRichTextData.HY().needRecompute = this.aNS;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aNf != null) {
            gifView = this.aNf.fE();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aNM) {
                layoutParams.leftMargin = aMW;
                layoutParams.rightMargin = aMW;
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.Ia().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.Ia().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.Ia().mGifInfo.mGifWidth, tbRichTextData.Ia().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            if (this.aNM) {
                layoutParams2.leftMargin = aMW;
                layoutParams2.rightMargin = aMW;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new com.baidu.tbadk.widget.richText.g(this, tbRichTextData));
        gifView.a(tbRichTextData.Ia().mGifInfo);
        return true;
    }

    private View getVoiceView() {
        View fE = this.aNd != null ? this.aNd.fE() : null;
        if ((fE == null || fE.getParent() != null) && this.aNy != -1) {
            fE = LayoutInflater.from(getContext()).inflate(this.aNy, (ViewGroup) null);
        }
        if (fE != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aNi;
            layoutParams.bottomMargin = this.aNi;
            fE.setLayoutParams(layoutParams);
            return fE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(TbRichTextGraffitiInfo tbRichTextGraffitiInfo, int i, String str) {
        com.baidu.tieba.graffiti.d dVar = null;
        if (this.aNc != null) {
            dVar = this.aNc.fE();
        }
        if (dVar == null || dVar.getParent() != null) {
            dVar = new com.baidu.tieba.graffiti.d(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aNi;
        layoutParams.bottomMargin = this.aNi;
        if (this.aNM) {
            layoutParams.leftMargin = aMW;
            layoutParams.rightMargin = aMW;
        }
        dVar.setLayoutParams(layoutParams);
        if (dVar instanceof com.baidu.tieba.graffiti.d) {
            com.baidu.tieba.graffiti.d dVar2 = dVar;
            dVar2.j(this.aNx, false);
            if (dVar2.getGraffitiImageView() != null) {
                dVar2.getGraffitiImageView().setSupportNoImage(this.aNG);
                dVar2.getGraffitiImageView().setDefaultResource(this.US);
            }
            if (dVar2.getSaveBtn() != null) {
                dVar2.getSaveBtn().setOnTouchListener(this.aNR);
            }
            dVar2.a(tbRichTextGraffitiInfo, i, str, this.aNn - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aNP);
        }
        return dVar;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.HX());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aNM) {
            layoutParams.leftMargin = aMW;
            layoutParams.rightMargin = aMW;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout fE = this.aNe.fE();
        if (fE != null) {
            TextView aQ = aQ(getContext());
            if (aQ == null) {
                this.aNe.n(fE);
                return null;
            }
            fE.addView(aQ);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aNb.n(aQ);
                this.aNe.n(fE);
                return null;
            }
            fE.addView(voiceView);
            return fE;
        }
        return fE;
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
        if (applyDimension != this.aNj) {
            this.aNj = applyDimension;
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
        if (this.aNh != i) {
            this.aNh = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aNh, 0, 0, this.aNh);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aNm) {
            this.aNm = i;
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
        if (this.aNN <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aNN)) > aMY ? 1 : ((((float) i) / ((float) this.aNN)) == aMY ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aNn;
    }

    public void setMaxImageWidth(int i) {
        this.aNn = i;
    }

    public int getMaxImageHeight() {
        return this.aNo;
    }

    public void setMaxImageHeight(int i) {
        this.aNo = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aNp;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aNp = scaleType;
    }

    public int getDefaultImageId() {
        return this.US;
    }

    public void setDefaultImageId(int i) {
        this.US = i;
    }

    public e getOnImageClickListener() {
        return this.aNu;
    }

    public void setOnImageClickListener(e eVar) {
        this.aNu = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aND = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aNx != z) {
            this.aNx = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aNx && this.aNa != null) {
                this.aNa.clear();
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
        this.aNz = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aNA) {
                    IF();
                    break;
                } else if (!this.aNL) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aNz) {
                    IE();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aNz = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IE() {
        this.aNA = false;
        if (this.aNB == null) {
            this.aNB = new a();
        }
        postDelayed(this.aNB, ViewConfiguration.getLongPressTimeout());
    }

    private void IF() {
        if (this.aNB != null) {
            removeCallbacks(this.aNB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aNL && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aNA = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aNy = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aNF = null;
        if (this.aNT != drawable) {
            this.aNS = true;
            this.aNT = drawable;
        }
        setText(this.aNE);
        this.aNS = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Ei();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Ei();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Ei();
        } else {
            refresh();
        }
    }

    public void gp(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.j Y = com.baidu.adp.base.k.Y(getContext());
        if (Y != null) {
            bdUniqueId = Y.getUniqueId();
            z = Y.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            Ei();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fG().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fG().am(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fG().a(this.mUrl, 19, this.aIr, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void Ei() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fG().a(this.mUrl, 19, this.aIr);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.kN(), aVar.kN().getNinePatchChunk(), aVar.kR(), null);
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
        gp(this.mUrl);
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
        return this.aNv;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aNv = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aNK = z;
    }

    public void setTextCenter(boolean z) {
        this.aNH = z;
    }
}
