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
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.togetherhi.ds;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    private static final int aFh = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds32);
    static int aFi = 174;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAA;
    private int aFA;
    private int aFB;
    private boolean aFC;
    private TextUtils.TruncateAt aFD;
    private f aFE;
    private d aFF;
    private e aFG;
    private boolean aFH;
    private int aFI;
    private boolean aFJ;
    private boolean aFK;
    private Runnable aFL;
    private boolean aFM;
    private c aFN;
    private com.baidu.tbadk.widget.richText.a aFO;
    private String aFP;
    private boolean aFQ;
    private boolean aFR;
    private boolean aFS;
    private int aFT;
    private boolean aFU;
    private boolean aFV;
    private boolean aFW;
    private int aFX;
    private boolean aFY;
    private boolean aFZ;
    private com.baidu.adp.lib.f.b<ImageView> aFj;
    private com.baidu.adp.lib.f.b<TextView> aFk;
    private com.baidu.adp.lib.f.b<View> aFl;
    private com.baidu.adp.lib.f.b<View> aFm;
    private com.baidu.adp.lib.f.b<LinearLayout> aFn;
    private com.baidu.adp.lib.f.b<GifView> aFo;
    private com.baidu.adp.lib.f.b<View> aFp;
    private float aFq;
    private int aFr;
    private int aFs;
    private float aFt;
    private int aFu;
    private int aFv;
    private int aFw;
    private int aFx;
    private int aFy;
    private ImageView.ScaleType aFz;
    public final View.OnClickListener aGa;
    private final View.OnTouchListener aGb;
    private boolean aGc;
    private Drawable aGd;
    private CustomMessageListener aGe;
    private BdUniqueId aeu;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int so;

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
        this.aFY = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aFZ = z;
    }

    public boolean Hq() {
        return this.aFM;
    }

    public void Hr() {
        this.aFQ = true;
    }

    public String getBackgroundImageUrl() {
        return this.aFP;
    }

    public void setBackgroundImageUrl(String str) {
        this.aFP = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.so = i;
    }

    public void setMaxLines(int i) {
        this.aFT = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aFD = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aFW = z;
    }

    public boolean getIsSupportVitality() {
        return this.aFW;
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
    public boolean O(View view) {
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

    public static com.baidu.adp.lib.f.b<TextView> h(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new v(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aFj = null;
        this.aFk = null;
        this.aFl = null;
        this.aFm = null;
        this.aFn = null;
        this.aFo = null;
        this.aFp = null;
        this.aFq = 0.0f;
        this.aFr = 0;
        this.aFs = 0;
        this.aFt = 15.0f;
        this.aFu = -1;
        this.aFv = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aFw = -9989158;
        this.aFx = 200;
        this.aFy = 200;
        this.aFz = null;
        this.aFA = 0;
        this.aFB = 0;
        this.aFC = false;
        this.aFD = null;
        this.aFE = null;
        this.aFF = null;
        this.aFG = null;
        this.aFH = true;
        this.mIsFromCDN = true;
        this.aFI = -1;
        this.aFJ = false;
        this.aFK = false;
        this.aFL = null;
        this.aFM = false;
        this.aFP = null;
        this.aFQ = false;
        this.aFR = false;
        this.so = -1;
        this.aFT = -1;
        this.aFU = true;
        this.aFV = false;
        this.aFW = false;
        this.aFY = false;
        this.aFZ = true;
        this.mOnClickListener = new p(this);
        this.aGa = new r(this);
        this.aGb = new s(this);
        this.mType = 19;
        this.aAA = new t(this);
        this.aGe = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFj = null;
        this.aFk = null;
        this.aFl = null;
        this.aFm = null;
        this.aFn = null;
        this.aFo = null;
        this.aFp = null;
        this.aFq = 0.0f;
        this.aFr = 0;
        this.aFs = 0;
        this.aFt = 15.0f;
        this.aFu = -1;
        this.aFv = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aFw = -9989158;
        this.aFx = 200;
        this.aFy = 200;
        this.aFz = null;
        this.aFA = 0;
        this.aFB = 0;
        this.aFC = false;
        this.aFD = null;
        this.aFE = null;
        this.aFF = null;
        this.aFG = null;
        this.aFH = true;
        this.mIsFromCDN = true;
        this.aFI = -1;
        this.aFJ = false;
        this.aFK = false;
        this.aFL = null;
        this.aFM = false;
        this.aFP = null;
        this.aFQ = false;
        this.aFR = false;
        this.so = -1;
        this.aFT = -1;
        this.aFU = true;
        this.aFV = false;
        this.aFW = false;
        this.aFY = false;
        this.aFZ = true;
        this.mOnClickListener = new p(this);
        this.aGa = new r(this);
        this.aGb = new s(this);
        this.mType = 19;
        this.aAA = new t(this);
        this.aGe = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.TbRichTextView);
        this.aFs = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aFr = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aFq = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aFt = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aFt);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aFx = obtainStyledAttributes.getDimensionPixelSize(6, this.aFx);
        this.aFy = obtainStyledAttributes.getDimensionPixelSize(7, this.aFy);
        this.aFA = obtainStyledAttributes.getResourceId(8, 0);
        this.aFu = obtainStyledAttributes.getDimensionPixelSize(9, this.aFu);
        this.aFv = obtainStyledAttributes.getDimensionPixelSize(10, this.aFv);
        this.aFB = obtainStyledAttributes.getResourceId(11, 0);
        this.aFC = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aFq = f2;
    }

    private void init() {
        aFi = getContext().getResources().getDimensionPixelSize(u.e.ds348);
        m mVar = null;
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (s != null && (s.getOrignalPage() instanceof m)) {
            mVar = (m) s.getOrignalPage();
        }
        if (s != null) {
            s.registerListener(this.aGe);
        }
        if (mVar != null) {
            this.aFj = mVar.Hh();
            this.aFk = mVar.Hi();
            this.aFm = mVar.Hk();
            this.aFn = mVar.Hl();
            this.aFo = mVar.Hj();
            this.aFl = mVar.Hm();
            if (mVar.getListView() != null && this.aFE == null) {
                this.aFE = new f(mVar.Hg());
                mVar.getListView().setRecyclerListener(this.aFE);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new w(this));
        this.aFX = com.baidu.adp.lib.util.k.A(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0026 */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GF;
        int i;
        boolean z2;
        SpannableStringBuilder GL;
        View a2;
        n GU;
        if (this.aFO != aVar || (aVar != null && aVar.aEw)) {
            if (aVar != null) {
                aVar.aEw = false;
            }
            this.aFO = aVar;
            removeAllViews();
            if (aVar != null && (GF = aVar.GF()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = GF.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ak = ak(getContext());
                            boolean a3 = a(next, ak, true);
                            if (z && !this.aFM && (GL = next.GL()) != null) {
                                this.aFM = GL.length() >= 200;
                            }
                            i = i2;
                            view2 = ak;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView aj = aj(getContext());
                                z2 = b(next, aj, (this.aFx - getPaddingLeft()) - getPaddingRight(), this.aFy);
                                i = i2 + 1;
                                view2 = aj;
                            }
                        } else if (next.getType() == 32) {
                            o GO = next.GO();
                            if (GO != null && GO.Ho()) {
                                a2 = b(GO);
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
                            ImageView aj2 = aj(getContext());
                            z2 = a(next, aj2, (this.aFx - getPaddingLeft()) - getPaddingRight(), this.aFy);
                            i = i2 + 1;
                            view2 = aj2;
                        } else if (next.getType() == 1536) {
                            com.baidu.tbadk.widget.richText.f GT = next.GT();
                            GT.fh(aVar.GE());
                            if (GT != null) {
                                View a4 = a(GT, aVar.GE(), aVar.getAuthorId());
                                z2 = true;
                                i = i2;
                                view2 = a4;
                            }
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        } else {
                            if (next.getType() == 1792 && (GU = next.GU()) != null) {
                                View b2 = b(GU);
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
                    layoutParams.bottomMargin = this.aFs;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(o oVar) {
        if (oVar == null || !oVar.isAvaliable()) {
            return null;
        }
        ImageView dE = this.aFj.dE();
        if (dE instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) dE;
            foreDrawableImageView.setForegroundDrawable(u.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(u.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(u.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, oVar.getWidth(), oVar.getHeight(), (this.aFx - getPaddingLeft()) - getPaddingRight(), this.aFy, new x(this, oVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aFQ);
            if (com.baidu.tbadk.core.l.nW().oc()) {
                foreDrawableImageView.setDefaultBgResource(u.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(u.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(oVar.pg(), 17, false);
            return dE;
        }
        return dE;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aFW && J(i, i2) && this.aFX > 0) {
            i3 = this.aFX;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aFH) {
            iArr[0] = i3;
            iArr[1] = aFi;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aFA);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aFS && i3 > i5) {
            float C = com.baidu.adp.lib.util.k.C(getContext());
            if (C > 1.0f) {
                if (i5 * C <= i3) {
                    i3 = (int) (i5 * C);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aFs;
                if (!this.aFS) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aFz == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aFz);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                if (this.aFW) {
                    if (J(i, i2)) {
                        layoutParams.width = -1;
                    } else {
                        layoutParams.leftMargin = aFh;
                        layoutParams.rightMargin = aFh;
                    }
                }
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aFs;
        if (!this.aFS) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        if (this.aFW) {
        }
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aFB <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aFs;
        linearLayout.setClickable(true);
        Bitmap cA = av.cA(this.aFB);
        if (cA != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cA));
        }
        linearLayout.setFocusable(false);
        if (this.aFW) {
            layoutParams.leftMargin = aFh;
            layoutParams.rightMargin = aFh;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new y(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aFB;
    }

    public void setVideoImageId(int i) {
        this.aFB = i;
    }

    private ImageView aj(Context context) {
        ImageView dE = this.aFj != null ? this.aFj.dE() : null;
        if (dE == null || dE.getParent() != null) {
            dE = null;
        }
        if (dE != null) {
            dE.setContentDescription(context.getString(u.j.log_msg_pic));
        }
        return dE;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l GR = cVar.GR();
        if (GR != null && GR.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aFQ) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(GR.Hf(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(GR.getLink()));
                if (!GR.GY()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, GR.getWidth(), GR.getHeight(), i, i2, this.aGa);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        g GK = cVar.GK();
        if (GK == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aFQ) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(GK.GX(), this.mIsFromCDN ? 17 : 18, false);
            if (!GK.GY()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, GK.getWidth(), GK.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aFS = z;
    }

    private TextView ak(Context context) {
        TextView textView = null;
        if (this.aFk != null) {
            textView = this.aFk.dE();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aFr, 0, this.aFr, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aFR) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aFs;
        }
        textView.setLineSpacing(0.0f, this.aFq);
        textView.setTextSize(0, this.aFt);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aFw);
        textView.setSingleLine(this.aFC);
        if (this.aFD != null) {
            textView.setEllipsize(this.aFD);
        }
        if (this.so > 0) {
            textView.setMaxWidth(this.so);
        }
        if (this.aFT > 0) {
            textView.setMaxLines(this.aFT);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder GL = cVar.GL();
        if (GL == null || GL.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aFv > 0 && this.aFu > 0) {
            cVar.H(this.aFu, this.aFv);
        }
        if (textSize > 0) {
            cVar.G(lineHeight, textSize);
        }
        try {
            textView.setText(GL);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aFU) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setFocusable(false);
        if (this.aFW) {
            layoutParams.leftMargin = aFh;
            layoutParams.rightMargin = aFh;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.GN() != null) {
            cVar.GN().aEP = this.aGc;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aFo != null) {
            gifView = this.aFo.dE();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aFW) {
                layoutParams.leftMargin = aFh;
                layoutParams.rightMargin = aFh;
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
        if (layoutParams == null || layoutParams.width != cVar.GP().auo.atS || layoutParams.height != cVar.GP().auo.atT) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.GP().auo.atS, cVar.GP().auo.atT);
            layoutParams2.gravity = 3;
            if (this.aFW) {
                layoutParams2.leftMargin = aFh;
                layoutParams2.rightMargin = aFh;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.GP().auo);
        return true;
    }

    private View getVoiceView() {
        View dE = this.aFm != null ? this.aFm.dE() : null;
        if ((dE == null || dE.getParent() != null) && this.aFI != -1) {
            dE = LayoutInflater.from(getContext()).inflate(this.aFI, (ViewGroup) null);
        }
        if (dE != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aFs;
            layoutParams.bottomMargin = this.aFs;
            dE.setLayoutParams(layoutParams);
            return dE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aFl != null) {
            eVar = this.aFl.dE();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aFs;
        layoutParams.bottomMargin = this.aFs;
        if (this.aFW) {
            layoutParams.leftMargin = aFh;
            layoutParams.rightMargin = aFh;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.i(this.aFH, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aFQ);
                eVar2.getGraffitiImageView().setDefaultResource(this.aFA);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aGb);
            }
            eVar2.a(fVar, i, str, this.aFx - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aFZ);
        }
        return eVar;
    }

    private View b(n nVar) {
        m mVar;
        if (this.aFp == null) {
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
            if (getContext() instanceof m) {
                mVar = (m) getContext();
            } else {
                mVar = (s == null || !(s.getOrignalPage() instanceof m)) ? null : (m) s.getOrignalPage();
            }
            this.aFp = mVar.fk(nVar.Rv);
        }
        View dE = this.aFp != null ? this.aFp.dE() : null;
        if (dE == null || dE.getParent() != null) {
            if (nVar.Rv == 1) {
                dE = new ds(getContext());
            } else {
                dE = new TogetherHiLivingView(getContext());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aFs;
        dE.setLayoutParams(layoutParams);
        if (dE instanceof ds) {
            dE.setData(nVar);
        }
        if (dE instanceof TogetherHiLivingView) {
            dE.setData(nVar);
        }
        return dE;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.GM());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aFW) {
            layoutParams.leftMargin = aFh;
            layoutParams.rightMargin = aFh;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout dE = this.aFn.dE();
        if (dE != null) {
            TextView ak = ak(getContext());
            if (ak == null) {
                this.aFn.k(dE);
                return null;
            }
            dE.addView(ak);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aFk.k(ak);
                this.aFn.k(dE);
                return null;
            }
            dE.addView(voiceView);
            return dE;
        }
        return dE;
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
        if (applyDimension != this.aFt) {
            this.aFt = applyDimension;
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
        if (this.aFr != i) {
            this.aFr = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aFr, 0, 0, this.aFr);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aFw) {
            this.aFw = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    private boolean J(int i, int i2) {
        if (this.aFX <= 0) {
            return false;
        }
        return (((((float) i) / ((float) this.aFX)) > 0.3f ? 1 : ((((float) i) / ((float) this.aFX)) == 0.3f ? 0 : -1)) > 0) && ((((((float) i2) / ((float) this.aFX)) * 1.618f) > 1.0f ? 1 : (((((float) i2) / ((float) this.aFX)) * 1.618f) == 1.0f ? 0 : -1)) > 0);
    }

    public int getMaxImageWidth() {
        return this.aFx;
    }

    public void setMaxImageWidth(int i) {
        this.aFx = i;
    }

    public int getMaxImageHeight() {
        return this.aFy;
    }

    public void setMaxImageHeight(int i) {
        this.aFy = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aFz;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aFz = scaleType;
    }

    public int getDefaultImageId() {
        return this.aFA;
    }

    public void setDefaultImageId(int i) {
        this.aFA = i;
    }

    public d getOnImageClickListener() {
        return this.aFF;
    }

    public void setOnImageClickListener(d dVar) {
        this.aFF = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aFN = cVar;
    }

    public void i(boolean z, boolean z2) {
        if (this.aFH != z) {
            this.aFH = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aFH && this.aFj != null) {
                this.aFj.clear();
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
        this.aFJ = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aFK) {
                    Ht();
                    break;
                } else if (!this.aFV) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aFJ) {
                    Hs();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aFJ = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Hs() {
        this.aFK = false;
        if (this.aFL == null) {
            this.aFL = new a();
        }
        postDelayed(this.aFL, ViewConfiguration.getLongPressTimeout());
    }

    private void Ht() {
        if (this.aFL != null) {
            removeCallbacks(this.aFL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aFV && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aFK = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aFI = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aFP = null;
        if (this.aGd != drawable) {
            this.aGc = true;
            this.aGd = drawable;
        }
        setText(this.aFO);
        this.aGc = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CN();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CN();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CN();
        } else {
            refresh();
        }
    }

    public void gC(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.aeu == bdUniqueId)) {
            CN();
        }
        this.mUrl = str;
        this.aeu = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dG().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.dG().V(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.dG().a(this.mUrl, 19, this.aAA, 0, 0, this.aeu, new Object[0]);
        }
    }

    public void CN() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.dG().a(this.mUrl, 19, this.aAA);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.jb(), aVar.jb().getNinePatchChunk(), aVar.jf(), null);
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
        gC(this.mUrl);
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
        return this.aFG;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aFG = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aFU = z;
    }

    public void setTextCenter(boolean z) {
        this.aFR = z;
    }
}
