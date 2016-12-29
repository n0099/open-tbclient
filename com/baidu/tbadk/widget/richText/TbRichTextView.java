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
import com.baidu.tbadk.core.util.ar;
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
    private static final int aIR = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32);
    private static final float aIS = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst());
    private static final float aIT;
    static int aIU;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEe;
    private com.baidu.adp.lib.f.b<ImageView> aIV;
    private com.baidu.adp.lib.f.b<TextView> aIW;
    private com.baidu.adp.lib.f.b<View> aIX;
    private com.baidu.adp.lib.f.b<View> aIY;
    private com.baidu.adp.lib.f.b<LinearLayout> aIZ;
    private com.baidu.tbadk.widget.richText.a aJA;
    private String aJB;
    private boolean aJC;
    private boolean aJD;
    private boolean aJE;
    private int aJF;
    private boolean aJG;
    private boolean aJH;
    private boolean aJI;
    private int aJJ;
    private boolean aJK;
    private boolean aJL;
    public final View.OnClickListener aJM;
    private final View.OnTouchListener aJN;
    private boolean aJO;
    private Drawable aJP;
    private CustomMessageListener aJQ;
    private com.baidu.adp.lib.f.b<GifView> aJa;
    private float aJb;
    private int aJc;
    private int aJd;
    private float aJe;
    private int aJf;
    private int aJg;
    private int aJh;
    private int aJi;
    private int aJj;
    private ImageView.ScaleType aJk;
    private int aJl;
    private int aJm;
    private boolean aJn;
    private TextUtils.TruncateAt aJo;
    private g aJp;
    private e aJq;
    private f aJr;
    private View.OnClickListener aJs;
    private boolean aJt;
    private int aJu;
    private boolean aJv;
    private boolean aJw;
    private Runnable aJx;
    private boolean aJy;
    private d aJz;
    private BdUniqueId ayd;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int vj;

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
        aIT = aIS > 0.0f ? 1.0f / aIS : 0.3f;
        aIU = 174;
    }

    public void setSubPbPost(boolean z) {
        this.aJK = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aJL = z;
    }

    public boolean Il() {
        return this.aJy;
    }

    public void Im() {
        this.aJC = true;
    }

    public String getBackgroundImageUrl() {
        return this.aJB;
    }

    public void setBackgroundImageUrl(String str) {
        this.aJB = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.vj = i;
    }

    public void setMaxLines(int i) {
        this.aJF = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aJo = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aJI = z;
    }

    public boolean getIsSupportVitality() {
        return this.aJI;
    }

    public float getLineSpacing() {
        return this.aJb;
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
    public boolean Q(View view) {
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

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, int i) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, i);
    }

    public static com.baidu.tbadk.widget.richText.a a(Context context, JSONArray jSONArray, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, jSONArray, z);
    }

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.f.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new u(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aIV = null;
        this.aIW = null;
        this.aIX = null;
        this.aIY = null;
        this.aIZ = null;
        this.aJa = null;
        this.aJb = 0.0f;
        this.aJc = 0;
        this.aJd = 0;
        this.aJe = 15.0f;
        this.aJf = -1;
        this.aJg = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aJh = -9989158;
        this.aJi = 200;
        this.aJj = 200;
        this.aJk = null;
        this.aJl = 0;
        this.aJm = 0;
        this.aJn = false;
        this.aJo = null;
        this.aJp = null;
        this.aJq = null;
        this.aJr = null;
        this.aJs = null;
        this.aJt = true;
        this.mIsFromCDN = true;
        this.aJu = -1;
        this.aJv = false;
        this.aJw = false;
        this.aJx = null;
        this.aJy = false;
        this.aJB = null;
        this.aJC = false;
        this.aJD = false;
        this.vj = -1;
        this.aJF = -1;
        this.aJG = true;
        this.aJH = false;
        this.aJI = false;
        this.aJK = false;
        this.aJL = true;
        this.mOnClickListener = new o(this);
        this.aJM = new q(this);
        this.aJN = new r(this);
        this.mType = 19;
        this.aEe = new s(this);
        this.aJQ = new t(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIV = null;
        this.aIW = null;
        this.aIX = null;
        this.aIY = null;
        this.aIZ = null;
        this.aJa = null;
        this.aJb = 0.0f;
        this.aJc = 0;
        this.aJd = 0;
        this.aJe = 15.0f;
        this.aJf = -1;
        this.aJg = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aJh = -9989158;
        this.aJi = 200;
        this.aJj = 200;
        this.aJk = null;
        this.aJl = 0;
        this.aJm = 0;
        this.aJn = false;
        this.aJo = null;
        this.aJp = null;
        this.aJq = null;
        this.aJr = null;
        this.aJs = null;
        this.aJt = true;
        this.mIsFromCDN = true;
        this.aJu = -1;
        this.aJv = false;
        this.aJw = false;
        this.aJx = null;
        this.aJy = false;
        this.aJB = null;
        this.aJC = false;
        this.aJD = false;
        this.vj = -1;
        this.aJF = -1;
        this.aJG = true;
        this.aJH = false;
        this.aJI = false;
        this.aJK = false;
        this.aJL = true;
        this.mOnClickListener = new o(this);
        this.aJM = new q(this);
        this.aJN = new r(this);
        this.mType = 19;
        this.aEe = new s(this);
        this.aJQ = new t(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.TbRichTextView);
        this.aJd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aJc = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aJb = obtainStyledAttributes.getFloat(5, 1.12f);
        this.aJe = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aJe);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aJi = obtainStyledAttributes.getDimensionPixelSize(6, this.aJi);
        this.aJj = obtainStyledAttributes.getDimensionPixelSize(7, this.aJj);
        this.aJl = obtainStyledAttributes.getResourceId(8, 0);
        this.aJf = obtainStyledAttributes.getDimensionPixelSize(9, this.aJf);
        this.aJg = obtainStyledAttributes.getDimensionPixelSize(10, this.aJg);
        this.aJm = obtainStyledAttributes.getResourceId(11, 0);
        this.aJn = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aJb = f2;
    }

    private void init() {
        aIU = getContext().getResources().getDimensionPixelSize(r.e.ds348);
        m mVar = null;
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (C != null && (C.getOrignalPage() instanceof m)) {
            mVar = (m) C.getOrignalPage();
        }
        if (C != null) {
            C.registerListener(this.aJQ);
        }
        if (mVar != null) {
            this.aIV = mVar.Ib();
            this.aIW = mVar.Ic();
            this.aIY = mVar.Ie();
            this.aIZ = mVar.If();
            this.aJa = mVar.Id();
            this.aIX = mVar.Ig();
            if (mVar.getListView() != null && this.aJp == null) {
                this.aJp = new g(mVar.Ia());
                mVar.getListView().setRecyclerListener(this.aJp);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new v(this));
        this.aJJ = com.baidu.adp.lib.util.k.I(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        a(aVar, z, (b) null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x0027 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x0027 */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z, b bVar) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Hy;
        boolean z2;
        SpannableStringBuilder HE;
        View view;
        View a2;
        View view2 = null;
        if (this.aJA != aVar || (aVar != null && aVar.aIf)) {
            if (aVar != null) {
                aVar.aIf = false;
            }
            this.aJA = aVar;
            removeAllViews();
            if (aVar != null && (Hy = aVar.Hy()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = Hy.iterator();
                int i = 0;
                View view3 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView aq = aq(getContext());
                            boolean a3 = a(next, aq, true, bVar);
                            if (z && !this.aJy && (HE = next.HE()) != null) {
                                this.aJy = HE.length() >= 200;
                            }
                            aq.setOnClickListener(this.aJs);
                            z2 = a3;
                            view3 = aq;
                        } else if (next.getType() == 8) {
                            if (i < 10) {
                                i++;
                                ImageView ap = ap(getContext());
                                z2 = b(next, ap, this.aJi, this.aJj);
                                view3 = ap;
                            }
                        } else if (next.getType() == 32) {
                            n HH = next.HH();
                            if (HH != null && HH.Ii()) {
                                a2 = b(HH);
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
                            ImageView ap2 = ap(getContext());
                            i++;
                            z2 = a(next, ap2, (this.aJi - getPaddingLeft()) - getPaddingRight(), this.aJj);
                            view3 = ap2;
                        } else {
                            if (next.getType() == 1536) {
                                com.baidu.tbadk.widget.richText.f HM = next.HM();
                                HM.fx(aVar.Hx());
                                if (HM != null) {
                                    View a4 = a(HM, aVar.Hx(), aVar.getAuthorId());
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
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
                            } else if (i > 1) {
                                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds4);
                            }
                            view3.setLayoutParams(layoutParams);
                        }
                        view2 = view;
                    }
                }
                if (view2 != null && !(view2 instanceof TbListTextView)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams2.bottomMargin = this.aJd;
                    view2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.aJs = onClickListener;
    }

    private View b(n nVar) {
        if (nVar == null || !nVar.isAvaliable()) {
            return null;
        }
        ImageView ey = this.aIV.ey();
        if (ey instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) ey;
            foreDrawableImageView.setForegroundDrawable(r.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(r.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, nVar.getWidth(), nVar.getHeight(), (this.aJi - getPaddingLeft()) - getPaddingRight(), this.aJj, new w(this, nVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aJC);
            if (com.baidu.tbadk.core.l.oJ().oP()) {
                foreDrawableImageView.setDefaultBgResource(r.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(r.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(nVar.qh(), 17, false);
            return ey;
        }
        return ey;
    }

    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aJI && M(i, i2) && this.aJJ > 0) {
            i3 = this.aJJ;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aJl);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (!this.aJE || i3 <= i5 || aIS <= 1.0f) {
            i3 = i5;
        } else {
            if (i5 * aIS <= i3) {
                if (i5 * aIS > i3 * 0.68f) {
                    i3 = (int) (i3 * 0.68f);
                } else {
                    i3 = (int) (i5 * aIS);
                }
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i3) / iArr[0];
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
        if (this.aJE) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else if (this.aJk == null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(this.aJk);
        }
        if (this.aJI) {
            if (M(i, i2)) {
                layoutParams.width = -1;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = aIR;
            }
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aJm <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aJd;
        linearLayout.setClickable(true);
        Bitmap cQ = ar.cQ(this.aJm);
        if (cQ != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cQ));
        }
        linearLayout.setFocusable(false);
        if (this.aJI) {
            layoutParams.leftMargin = aIR;
            layoutParams.rightMargin = aIR;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new x(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aJm;
    }

    public void setVideoImageId(int i) {
        this.aJm = i;
    }

    private ImageView ap(Context context) {
        ImageView ey = this.aIV != null ? this.aIV.ey() : null;
        if (ey == null || ey.getParent() != null) {
            ey = null;
        }
        if (ey != null) {
            ey.setContentDescription(context.getString(r.j.log_msg_pic));
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l HK = cVar.HK();
        if (HK != null && HK.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aJC) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(HK.HZ(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(HK.getLink()));
                if (!HK.HS()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, HK.getWidth(), HK.getHeight(), i, i2, this.aJM);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.g HD = cVar.HD();
        if (HD == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aJC) {
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
        this.aJE = z;
    }

    private TextView aq(Context context) {
        TextView textView = null;
        if (this.aIW != null) {
            textView = this.aIW.ey();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aJc, 0, this.aJc, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aJD) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aJd;
        }
        textView.setLineSpacing(0.0f, this.aJb);
        textView.setTextSize(0, this.aJe);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(ar.getColor(r.d.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(r.d.transparent));
        textView.setSingleLine(this.aJn);
        if (this.aJo != null) {
            textView.setEllipsize(this.aJo);
        }
        if (this.vj > 0) {
            textView.setMaxWidth(this.vj);
        }
        if (this.aJF > 0) {
            textView.setMaxLines(this.aJF);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder HE = cVar.HE();
        if (HE == null || HE.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aJg > 0 && this.aJf > 0) {
            cVar.K(this.aJf, this.aJg);
        }
        if (textSize > 0) {
            cVar.J(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(HE, textView, this);
        }
        try {
            textView.setText(HE);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aJG) {
            if (cVar.HN()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bki());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aJI) {
            layoutParams.leftMargin = aIR;
            layoutParams.rightMargin = aIR;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.HG() != null) {
            cVar.HG().aIy = this.aJO;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aJa != null) {
            gifView = this.aJa.ey();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aJI) {
                layoutParams.leftMargin = aIR;
                layoutParams.rightMargin = aIR;
            } else {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
            gifView2.setLayoutParams(layoutParams);
        }
        return gifView2;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.HI().ayb.axF || layoutParams.height != cVar.HI().ayb.axG) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.HI().ayb.axF, cVar.HI().ayb.axG);
            layoutParams2.gravity = 3;
            if (this.aJI) {
                layoutParams2.leftMargin = aIR;
                layoutParams2.rightMargin = aIR;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new p(this, cVar));
        gifView.a(cVar.HI().ayb);
        return true;
    }

    private View getVoiceView() {
        View ey = this.aIY != null ? this.aIY.ey() : null;
        if ((ey == null || ey.getParent() != null) && this.aJu != -1) {
            ey = LayoutInflater.from(getContext()).inflate(this.aJu, (ViewGroup) null);
        }
        if (ey != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aJd;
            layoutParams.bottomMargin = this.aJd;
            ey.setLayoutParams(layoutParams);
            return ey;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aIX != null) {
            eVar = this.aIX.ey();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aJd;
        layoutParams.bottomMargin = this.aJd;
        if (this.aJI) {
            layoutParams.leftMargin = aIR;
            layoutParams.rightMargin = aIR;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.j(this.aJt, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aJC);
                eVar2.getGraffitiImageView().setDefaultResource(this.aJl);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aJN);
            }
            eVar2.a(fVar, i, str, this.aJi - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aJL);
        }
        return eVar;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.HF());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aJI) {
            layoutParams.leftMargin = aIR;
            layoutParams.rightMargin = aIR;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ey = this.aIZ.ey();
        if (ey != null) {
            TextView aq = aq(getContext());
            if (aq == null) {
                this.aIZ.n(ey);
                return null;
            }
            ey.addView(aq);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aIW.n(aq);
                this.aIZ.n(ey);
                return null;
            }
            ey.addView(voiceView);
            return ey;
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, LinearLayout linearLayout, b bVar) {
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
                a2 = a(cVar, (TextView) childAt, false, bVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(cVar, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(cVar, childAt) & z : z;
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
        if (applyDimension != this.aJe) {
            this.aJe = applyDimension;
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
        if (this.aJc != i) {
            this.aJc = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aJc, 0, 0, this.aJc);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aJh) {
            this.aJh = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean M(int i, int i2) {
        if (this.aJJ <= 0) {
            return false;
        }
        return ((((float) i) / ((float) this.aJJ)) > aIT ? 1 : ((((float) i) / ((float) this.aJJ)) == aIT ? 0 : -1)) > 0;
    }

    public int getMaxImageWidth() {
        return this.aJi;
    }

    public void setMaxImageWidth(int i) {
        this.aJi = i;
    }

    public int getMaxImageHeight() {
        return this.aJj;
    }

    public void setMaxImageHeight(int i) {
        this.aJj = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aJk;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aJk = scaleType;
    }

    public int getDefaultImageId() {
        return this.aJl;
    }

    public void setDefaultImageId(int i) {
        this.aJl = i;
    }

    public e getOnImageClickListener() {
        return this.aJq;
    }

    public void setOnImageClickListener(e eVar) {
        this.aJq = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aJz = dVar;
    }

    public void j(boolean z, boolean z2) {
        if (this.aJt != z) {
            this.aJt = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aJt && this.aIV != null) {
                this.aIV.clear();
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
        this.aJv = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aJw) {
                    Io();
                    break;
                } else if (!this.aJH) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aJv) {
                    In();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aJv = true;
        return super.onTouchEvent(motionEvent);
    }

    private void In() {
        this.aJw = false;
        if (this.aJx == null) {
            this.aJx = new a();
        }
        postDelayed(this.aJx, ViewConfiguration.getLongPressTimeout());
    }

    private void Io() {
        if (this.aJx != null) {
            removeCallbacks(this.aJx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aJH && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aJw = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aJu = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aJB = null;
        if (this.aJP != drawable) {
            this.aJO = true;
            this.aJP = drawable;
        }
        setText(this.aJA);
        this.aJO = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DU();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        DU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            DU();
        } else {
            refresh();
        }
    }

    public void gD(String str) {
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
        if (!(str.equals(this.mUrl) && this.ayd == bdUniqueId)) {
            DU();
        }
        this.mUrl = str;
        this.ayd = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().am(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aEe, 0, 0, this.ayd, new Object[0]);
        }
    }

    public void DU() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aEe);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.jV(), aVar.jV().getNinePatchChunk(), aVar.jZ(), null);
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
        gD(this.mUrl);
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
        return this.aJr;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aJr = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aJG = z;
    }

    public void setTextCenter(boolean z) {
        this.aJD = z;
    }
}
