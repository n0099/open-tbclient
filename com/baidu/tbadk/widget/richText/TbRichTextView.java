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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.t;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.togetherhi.ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    private static final int aJk = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds32);
    static int aJl = 174;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEx;
    private int aJA;
    private int aJB;
    private ImageView.ScaleType aJC;
    private int aJD;
    private int aJE;
    private boolean aJF;
    private TextUtils.TruncateAt aJG;
    private f aJH;
    private d aJI;
    private e aJJ;
    private boolean aJK;
    private int aJL;
    private boolean aJM;
    private boolean aJN;
    private Runnable aJO;
    private boolean aJP;
    private c aJQ;
    private com.baidu.tbadk.widget.richText.a aJR;
    private String aJS;
    private boolean aJT;
    private boolean aJU;
    private boolean aJV;
    private int aJW;
    private boolean aJX;
    private boolean aJY;
    private boolean aJZ;
    private com.baidu.adp.lib.f.b<ImageView> aJm;
    private com.baidu.adp.lib.f.b<TextView> aJn;
    private com.baidu.adp.lib.f.b<View> aJo;
    private com.baidu.adp.lib.f.b<View> aJp;
    private com.baidu.adp.lib.f.b<LinearLayout> aJq;
    private com.baidu.adp.lib.f.b<GifView> aJr;
    private com.baidu.adp.lib.f.b<View> aJs;
    private float aJt;
    private int aJu;
    private int aJv;
    private float aJw;
    private int aJx;
    private int aJy;
    private int aJz;
    private int aKa;
    private boolean aKb;
    private boolean aKc;
    public final View.OnClickListener aKd;
    private final View.OnTouchListener aKe;
    private boolean aKf;
    private Drawable aKg;
    private CustomMessageListener aKh;
    private BdUniqueId aid;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int vi;

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

    public void setSubPbPost(boolean z) {
        this.aKb = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aKc = z;
    }

    public boolean IN() {
        return this.aJP;
    }

    public void IO() {
        this.aJT = true;
    }

    public String getBackgroundImageUrl() {
        return this.aJS;
    }

    public void setBackgroundImageUrl(String str) {
        this.aJS = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.vi = i;
    }

    public void setMaxLines(int i) {
        this.aJW = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aJG = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aJZ = z;
    }

    public boolean getIsSupportVitality() {
        return this.aJZ;
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
    public boolean P(View view) {
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

    public static com.baidu.adp.lib.f.b<TextView> j(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new v(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aJm = null;
        this.aJn = null;
        this.aJo = null;
        this.aJp = null;
        this.aJq = null;
        this.aJr = null;
        this.aJs = null;
        this.aJt = 0.0f;
        this.aJu = 0;
        this.aJv = 0;
        this.aJw = 15.0f;
        this.aJx = -1;
        this.aJy = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aJz = -9989158;
        this.aJA = 200;
        this.aJB = 200;
        this.aJC = null;
        this.aJD = 0;
        this.aJE = 0;
        this.aJF = false;
        this.aJG = null;
        this.aJH = null;
        this.aJI = null;
        this.aJJ = null;
        this.aJK = true;
        this.mIsFromCDN = true;
        this.aJL = -1;
        this.aJM = false;
        this.aJN = false;
        this.aJO = null;
        this.aJP = false;
        this.aJS = null;
        this.aJT = false;
        this.aJU = false;
        this.vi = -1;
        this.aJW = -1;
        this.aJX = true;
        this.aJY = false;
        this.aJZ = false;
        this.aKb = false;
        this.aKc = true;
        this.mOnClickListener = new p(this);
        this.aKd = new r(this);
        this.aKe = new s(this);
        this.mType = 19;
        this.aEx = new t(this);
        this.aKh = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJm = null;
        this.aJn = null;
        this.aJo = null;
        this.aJp = null;
        this.aJq = null;
        this.aJr = null;
        this.aJs = null;
        this.aJt = 0.0f;
        this.aJu = 0;
        this.aJv = 0;
        this.aJw = 15.0f;
        this.aJx = -1;
        this.aJy = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aJz = -9989158;
        this.aJA = 200;
        this.aJB = 200;
        this.aJC = null;
        this.aJD = 0;
        this.aJE = 0;
        this.aJF = false;
        this.aJG = null;
        this.aJH = null;
        this.aJI = null;
        this.aJJ = null;
        this.aJK = true;
        this.mIsFromCDN = true;
        this.aJL = -1;
        this.aJM = false;
        this.aJN = false;
        this.aJO = null;
        this.aJP = false;
        this.aJS = null;
        this.aJT = false;
        this.aJU = false;
        this.vi = -1;
        this.aJW = -1;
        this.aJX = true;
        this.aJY = false;
        this.aJZ = false;
        this.aKb = false;
        this.aKc = true;
        this.mOnClickListener = new p(this);
        this.aKd = new r(this);
        this.aKe = new s(this);
        this.mType = 19;
        this.aEx = new t(this);
        this.aKh = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.TbRichTextView);
        this.aJv = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aJu = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aJt = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aJw = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aJw);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aJA = obtainStyledAttributes.getDimensionPixelSize(6, this.aJA);
        this.aJB = obtainStyledAttributes.getDimensionPixelSize(7, this.aJB);
        this.aJD = obtainStyledAttributes.getResourceId(8, 0);
        this.aJx = obtainStyledAttributes.getDimensionPixelSize(9, this.aJx);
        this.aJy = obtainStyledAttributes.getDimensionPixelSize(10, this.aJy);
        this.aJE = obtainStyledAttributes.getResourceId(11, 0);
        this.aJF = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aJt = f2;
    }

    private void init() {
        aJl = getContext().getResources().getDimensionPixelSize(t.e.ds348);
        m mVar = null;
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (C != null && (C.getOrignalPage() instanceof m)) {
            mVar = (m) C.getOrignalPage();
        }
        if (C != null) {
            C.registerListener(this.aKh);
        }
        if (mVar != null) {
            this.aJm = mVar.IE();
            this.aJn = mVar.IF();
            this.aJp = mVar.IH();
            this.aJq = mVar.II();
            this.aJr = mVar.IG();
            this.aJo = mVar.IJ();
            if (mVar.getListView() != null && this.aJH == null) {
                this.aJH = new f(mVar.ID());
                mVar.getListView().setRecyclerListener(this.aJH);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new w(this));
        this.aKa = com.baidu.adp.lib.util.k.K(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0026 */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Ia;
        int i;
        boolean z2;
        SpannableStringBuilder Ig;
        View a2;
        n Ip;
        if (this.aJR != aVar || (aVar != null && aVar.aIx)) {
            if (aVar != null) {
                aVar.aIx = false;
            }
            this.aJR = aVar;
            removeAllViews();
            if (aVar != null && (Ia = aVar.Ia()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = Ia.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView au = au(getContext());
                            boolean a3 = a(next, au, true);
                            if (z && !this.aJP && (Ig = next.Ig()) != null) {
                                this.aJP = Ig.length() >= 200;
                            }
                            i = i2;
                            view2 = au;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView at = at(getContext());
                                z2 = b(next, at, (this.aJA - getPaddingLeft()) - getPaddingRight(), this.aJB);
                                i = i2 + 1;
                                view2 = at;
                            }
                        } else if (next.getType() == 32) {
                            o Ij = next.Ij();
                            if (Ij != null && Ij.IL()) {
                                a2 = b(Ij);
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
                            ImageView at2 = at(getContext());
                            z2 = a(next, at2, (this.aJA - getPaddingLeft()) - getPaddingRight(), this.aJB);
                            i = i2 + 1;
                            view2 = at2;
                        } else if (next.getType() == 1536) {
                            com.baidu.tbadk.widget.richText.f Io = next.Io();
                            Io.fv(aVar.HZ());
                            if (Io != null) {
                                View a4 = a(Io, aVar.HZ(), aVar.getAuthorId());
                                z2 = true;
                                i = i2;
                                view2 = a4;
                            }
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        } else {
                            if (next.getType() == 1792 && (Ip = next.Ip()) != null) {
                                View b2 = b(Ip);
                                z2 = true;
                                i = i2;
                                view2 = b2;
                            }
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
                    layoutParams.bottomMargin = this.aJv;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(o oVar) {
        if (oVar == null || !oVar.isAvaliable()) {
            return null;
        }
        ImageView ey = this.aJm.ey();
        if (ey instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) ey;
            foreDrawableImageView.setForegroundDrawable(t.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(t.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(t.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, oVar.getWidth(), oVar.getHeight(), (this.aJA - getPaddingLeft()) - getPaddingRight(), this.aJB, new x(this, oVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aJT);
            if (com.baidu.tbadk.core.l.oG().oM()) {
                foreDrawableImageView.setDefaultBgResource(t.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(t.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(oVar.pS(), 17, false);
            return ey;
        }
        return ey;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aJZ && M(i, i2) && this.aKa > 0) {
            i3 = this.aKa;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (!this.aJK) {
            iArr[0] = i3;
            iArr[1] = aJl;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aJD);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aJV && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aJv;
                if (!this.aJV) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aJC == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aJC);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                if (this.aJZ) {
                    if (M(i, i2)) {
                        layoutParams.width = -1;
                    } else {
                        layoutParams.leftMargin = aJk;
                        layoutParams.rightMargin = aJk;
                    }
                }
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aJv;
        if (!this.aJV) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        if (this.aJZ) {
        }
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aJE <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aJv;
        linearLayout.setClickable(true);
        Bitmap cN = av.cN(this.aJE);
        if (cN != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cN));
        }
        linearLayout.setFocusable(false);
        if (this.aJZ) {
            layoutParams.leftMargin = aJk;
            layoutParams.rightMargin = aJk;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new y(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aJE;
    }

    public void setVideoImageId(int i) {
        this.aJE = i;
    }

    private ImageView at(Context context) {
        ImageView ey = this.aJm != null ? this.aJm.ey() : null;
        if (ey == null || ey.getParent() != null) {
            ey = null;
        }
        if (ey != null) {
            ey.setContentDescription(context.getString(t.j.log_msg_pic));
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l Im = cVar.Im();
        if (Im != null && Im.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aJT) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Im.IC(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(Im.getLink()));
                if (!Im.Iv()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Im.getWidth(), Im.getHeight(), i, i2, this.aKd);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        g If = cVar.If();
        if (If == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aJT) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(If.Iu(), this.mIsFromCDN ? 17 : 18, false);
            if (!If.Iv()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, If.getWidth(), If.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aJV = z;
    }

    private TextView au(Context context) {
        TextView textView = null;
        if (this.aJn != null) {
            textView = this.aJn.ey();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aJu, 0, this.aJu, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aJU) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aJv;
        }
        textView.setLineSpacing(0.0f, this.aJt);
        textView.setTextSize(0, this.aJw);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(av.getColor(t.d.cp_link_tip_c));
        textView.setSingleLine(this.aJF);
        if (this.aJG != null) {
            textView.setEllipsize(this.aJG);
        }
        if (this.vi > 0) {
            textView.setMaxWidth(this.vi);
        }
        if (this.aJW > 0) {
            textView.setMaxLines(this.aJW);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder Ig = cVar.Ig();
        if (Ig == null || Ig.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aJy > 0 && this.aJx > 0) {
            cVar.K(this.aJx, this.aJy);
        }
        if (textSize > 0) {
            cVar.J(lineHeight, textSize);
        }
        try {
            textView.setText(Ig);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aJX) {
            if (cVar.Iq()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bql());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aJZ) {
            layoutParams.leftMargin = aJk;
            layoutParams.rightMargin = aJk;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.Ii() != null) {
            cVar.Ii().aIR = this.aKf;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aJr != null) {
            gifView = this.aJr.ey();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aJZ) {
                layoutParams.leftMargin = aJk;
                layoutParams.rightMargin = aJk;
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
        if (layoutParams == null || layoutParams.width != cVar.Ik().ayk.axO || layoutParams.height != cVar.Ik().ayk.axP) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Ik().ayk.axO, cVar.Ik().ayk.axP);
            layoutParams2.gravity = 3;
            if (this.aJZ) {
                layoutParams2.leftMargin = aJk;
                layoutParams2.rightMargin = aJk;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.Ik().ayk);
        return true;
    }

    private View getVoiceView() {
        View ey = this.aJp != null ? this.aJp.ey() : null;
        if ((ey == null || ey.getParent() != null) && this.aJL != -1) {
            ey = LayoutInflater.from(getContext()).inflate(this.aJL, (ViewGroup) null);
        }
        if (ey != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aJv;
            layoutParams.bottomMargin = this.aJv;
            ey.setLayoutParams(layoutParams);
            return ey;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aJo != null) {
            eVar = this.aJo.ey();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aJv;
        layoutParams.bottomMargin = this.aJv;
        if (this.aJZ) {
            layoutParams.leftMargin = aJk;
            layoutParams.rightMargin = aJk;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.k(this.aJK, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aJT);
                eVar2.getGraffitiImageView().setDefaultResource(this.aJD);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aKe);
            }
            eVar2.a(fVar, i, str, this.aJA - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aKc);
        }
        return eVar;
    }

    private View b(n nVar) {
        m mVar;
        if (this.aJs == null) {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (getContext() instanceof m) {
                mVar = (m) getContext();
            } else {
                mVar = (C == null || !(C.getOrignalPage() instanceof m)) ? null : (m) C.getOrignalPage();
            }
            this.aJs = mVar.fz(nVar.UV);
        }
        View ey = this.aJs != null ? this.aJs.ey() : null;
        if (ey == null || ey.getParent() != null) {
            if (nVar.UV == 1) {
                ey = new ds(getContext());
            } else {
                ey = new TogetherHiLivingView(getContext());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aJv;
        ey.setLayoutParams(layoutParams);
        if (ey instanceof ds) {
            ey.setData(nVar);
        }
        if (ey instanceof TogetherHiLivingView) {
            ey.setData(nVar);
        }
        return ey;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.Ih());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aJZ) {
            layoutParams.leftMargin = aJk;
            layoutParams.rightMargin = aJk;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ey = this.aJq.ey();
        if (ey != null) {
            TextView au = au(getContext());
            if (au == null) {
                this.aJq.n(ey);
                return null;
            }
            ey.addView(au);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aJn.n(au);
                this.aJq.n(ey);
                return null;
            }
            ey.addView(voiceView);
            return ey;
        }
        return ey;
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
        if (applyDimension != this.aJw) {
            this.aJw = applyDimension;
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
        if (this.aJu != i) {
            this.aJu = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aJu, 0, 0, this.aJu);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aJz) {
            this.aJz = i;
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
        if (this.aKa <= 0) {
            return false;
        }
        return (((((float) i) / ((float) this.aKa)) > 0.3f ? 1 : ((((float) i) / ((float) this.aKa)) == 0.3f ? 0 : -1)) > 0) && ((((((float) i2) / ((float) this.aKa)) * 1.618f) > 1.0f ? 1 : (((((float) i2) / ((float) this.aKa)) * 1.618f) == 1.0f ? 0 : -1)) > 0);
    }

    public int getMaxImageWidth() {
        return this.aJA;
    }

    public void setMaxImageWidth(int i) {
        this.aJA = i;
    }

    public int getMaxImageHeight() {
        return this.aJB;
    }

    public void setMaxImageHeight(int i) {
        this.aJB = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aJC;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aJC = scaleType;
    }

    public int getDefaultImageId() {
        return this.aJD;
    }

    public void setDefaultImageId(int i) {
        this.aJD = i;
    }

    public d getOnImageClickListener() {
        return this.aJI;
    }

    public void setOnImageClickListener(d dVar) {
        this.aJI = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aJQ = cVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aJK != z) {
            this.aJK = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aJK && this.aJm != null) {
                this.aJm.clear();
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
        this.aJM = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aJN) {
                    IQ();
                    break;
                } else if (!this.aJY) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aJM) {
                    IP();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aJM = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IP() {
        this.aJN = false;
        if (this.aJO == null) {
            this.aJO = new a();
        }
        postDelayed(this.aJO, ViewConfiguration.getLongPressTimeout());
    }

    private void IQ() {
        if (this.aJO != null) {
            removeCallbacks(this.aJO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aJY && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aJN = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aJL = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aJS = null;
        if (this.aKg != drawable) {
            this.aKf = true;
            this.aKg = drawable;
        }
        setText(this.aJR);
        this.aKf = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Eh();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Eh();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            Eh();
        } else {
            refresh();
        }
    }

    public void gE(String str) {
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
        if (!(str.equals(this.mUrl) && this.aid == bdUniqueId)) {
            Eh();
        }
        this.mUrl = str;
        this.aid = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aEx, 0, 0, this.aid, new Object[0]);
        }
    }

    public void Eh() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aEx);
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
        gE(this.mUrl);
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
        return this.aJJ;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aJJ = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aJX = z;
    }

    public void setTextCenter(boolean z) {
        this.aJU = z;
    }
}
