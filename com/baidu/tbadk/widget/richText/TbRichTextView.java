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
import com.baidu.tbadk.core.util.at;
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
    private static final int aEG = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds32);
    static int aEH = 174;
    private com.baidu.adp.lib.f.b<ImageView> aEI;
    private com.baidu.adp.lib.f.b<TextView> aEJ;
    private com.baidu.adp.lib.f.b<View> aEK;
    private com.baidu.adp.lib.f.b<View> aEL;
    private com.baidu.adp.lib.f.b<LinearLayout> aEM;
    private com.baidu.adp.lib.f.b<GifView> aEN;
    private com.baidu.adp.lib.f.b<View> aEO;
    private float aEP;
    private int aEQ;
    private int aER;
    private float aES;
    private int aET;
    private int aEU;
    private int aEV;
    private int aEW;
    private int aEX;
    private ImageView.ScaleType aEY;
    private int aEZ;
    private boolean aFA;
    private Drawable aFB;
    private CustomMessageListener aFC;
    private int aFa;
    private boolean aFb;
    private TextUtils.TruncateAt aFc;
    private f aFd;
    private d aFe;
    private e aFf;
    private boolean aFg;
    private int aFh;
    private boolean aFi;
    private boolean aFj;
    private Runnable aFk;
    private boolean aFl;
    private c aFm;
    private com.baidu.tbadk.widget.richText.a aFn;
    private String aFo;
    private boolean aFp;
    private boolean aFq;
    private int aFr;
    private boolean aFs;
    private boolean aFt;
    private boolean aFu;
    private int aFv;
    private boolean aFw;
    private boolean aFx;
    public final View.OnClickListener aFy;
    private final View.OnTouchListener aFz;
    private BdUniqueId atA;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> azI;
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
        this.aFw = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aFx = z;
    }

    public boolean Hp() {
        return this.aFl;
    }

    public void Hq() {
        this.aFp = true;
    }

    public String getBackgroundImageUrl() {
        return this.aFo;
    }

    public void setBackgroundImageUrl(String str) {
        this.aFo = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.so = i;
    }

    public void setMaxLines(int i) {
        this.aFr = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aFc = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aFu = z;
    }

    public boolean getIsSupportVitality() {
        return this.aFu;
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

    public static com.baidu.adp.lib.f.b<TextView> h(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new v(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aEI = null;
        this.aEJ = null;
        this.aEK = null;
        this.aEL = null;
        this.aEM = null;
        this.aEN = null;
        this.aEO = null;
        this.aEP = 0.0f;
        this.aEQ = 0;
        this.aER = 0;
        this.aES = 15.0f;
        this.aET = -1;
        this.aEU = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aEV = -9989158;
        this.aEW = 200;
        this.aEX = 200;
        this.aEY = null;
        this.aEZ = 0;
        this.aFa = 0;
        this.aFb = false;
        this.aFc = null;
        this.aFd = null;
        this.aFe = null;
        this.aFf = null;
        this.aFg = true;
        this.mIsFromCDN = true;
        this.aFh = -1;
        this.aFi = false;
        this.aFj = false;
        this.aFk = null;
        this.aFl = false;
        this.aFo = null;
        this.aFp = false;
        this.so = -1;
        this.aFr = -1;
        this.aFs = true;
        this.aFt = false;
        this.aFu = false;
        this.aFw = false;
        this.aFx = true;
        this.mOnClickListener = new p(this);
        this.aFy = new r(this);
        this.aFz = new s(this);
        this.mType = 19;
        this.azI = new t(this);
        this.aFC = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEI = null;
        this.aEJ = null;
        this.aEK = null;
        this.aEL = null;
        this.aEM = null;
        this.aEN = null;
        this.aEO = null;
        this.aEP = 0.0f;
        this.aEQ = 0;
        this.aER = 0;
        this.aES = 15.0f;
        this.aET = -1;
        this.aEU = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aEV = -9989158;
        this.aEW = 200;
        this.aEX = 200;
        this.aEY = null;
        this.aEZ = 0;
        this.aFa = 0;
        this.aFb = false;
        this.aFc = null;
        this.aFd = null;
        this.aFe = null;
        this.aFf = null;
        this.aFg = true;
        this.mIsFromCDN = true;
        this.aFh = -1;
        this.aFi = false;
        this.aFj = false;
        this.aFk = null;
        this.aFl = false;
        this.aFo = null;
        this.aFp = false;
        this.so = -1;
        this.aFr = -1;
        this.aFs = true;
        this.aFt = false;
        this.aFu = false;
        this.aFw = false;
        this.aFx = true;
        this.mOnClickListener = new p(this);
        this.aFy = new r(this);
        this.aFz = new s(this);
        this.mType = 19;
        this.azI = new t(this);
        this.aFC = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.TbRichTextView);
        this.aER = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aEQ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aEP = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aES = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aES);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aEW = obtainStyledAttributes.getDimensionPixelSize(6, this.aEW);
        this.aEX = obtainStyledAttributes.getDimensionPixelSize(7, this.aEX);
        this.aEZ = obtainStyledAttributes.getResourceId(8, 0);
        this.aET = obtainStyledAttributes.getDimensionPixelSize(9, this.aET);
        this.aEU = obtainStyledAttributes.getDimensionPixelSize(10, this.aEU);
        this.aFa = obtainStyledAttributes.getResourceId(11, 0);
        this.aFb = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aEP = f2;
    }

    private void init() {
        aEH = getContext().getResources().getDimensionPixelSize(t.e.adk_default_image_height);
        m mVar = null;
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (s != null && (s.getOrignalPage() instanceof m)) {
            mVar = (m) s.getOrignalPage();
        }
        if (s != null) {
            s.registerListener(this.aFC);
        }
        if (mVar != null) {
            this.aEI = mVar.Hg();
            this.aEJ = mVar.Hh();
            this.aEL = mVar.Hj();
            this.aEM = mVar.Hk();
            this.aEN = mVar.Hi();
            this.aEK = mVar.Hl();
            if (mVar.getListView() != null && this.aFd == null) {
                this.aFd = new f(mVar.Hf());
                mVar.getListView().setRecyclerListener(this.aFd);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new w(this));
        this.aFv = com.baidu.adp.lib.util.k.B(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x001c */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GE;
        int i;
        boolean z2;
        SpannableStringBuilder GK;
        View a2;
        n GT;
        if (this.aFn != aVar) {
            this.aFn = aVar;
            removeAllViews();
            if (aVar != null && (GE = aVar.GE()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = GE.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView al = al(getContext());
                            boolean a3 = a(next, al, true);
                            if (z && !this.aFl && (GK = next.GK()) != null) {
                                this.aFl = GK.length() >= 200;
                            }
                            i = i2;
                            view2 = al;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ak = ak(getContext());
                                z2 = b(next, ak, (this.aEW - getPaddingLeft()) - getPaddingRight(), this.aEX);
                                i = i2 + 1;
                                view2 = ak;
                            }
                        } else if (next.getType() == 32) {
                            o GN = next.GN();
                            if (GN != null && GN.Hn()) {
                                a2 = b(GN);
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
                            ImageView ak2 = ak(getContext());
                            z2 = a(next, ak2, (this.aEW - getPaddingLeft()) - getPaddingRight(), this.aEX);
                            i = i2 + 1;
                            view2 = ak2;
                        } else if (next.getType() == 1536) {
                            com.baidu.tbadk.widget.richText.f GS = next.GS();
                            GS.fb(aVar.GD());
                            if (GS != null) {
                                View a4 = a(GS, aVar.GD(), aVar.getAuthorId());
                                z2 = true;
                                i = i2;
                                view2 = a4;
                            }
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        } else {
                            if (next.getType() == 1792 && (GT = next.GT()) != null) {
                                View b2 = b(GT);
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
                    layoutParams.bottomMargin = this.aER;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(o oVar) {
        if (oVar == null || !oVar.isAvaliable()) {
            return null;
        }
        ImageView dD = this.aEI.dD();
        if (dD instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) dD;
            foreDrawableImageView.setForegroundDrawable(t.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(t.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, oVar.getWidth(), oVar.getHeight(), (this.aEW - getPaddingLeft()) - getPaddingRight(), this.aEX, new x(this, oVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aFp);
            if (com.baidu.tbadk.core.l.ob().oh()) {
                foreDrawableImageView.setDefaultBgResource(t.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(t.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(oVar.po(), 17, false);
            return dD;
        }
        return dD;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        if (this.aFu && J(i, i2) && this.aFv > 0) {
            i3 = this.aFv;
            i4 = (int) (i3 * 1.618f);
        }
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aFg) {
            iArr[0] = i3;
            iArr[1] = aEH;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aEZ);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aFq && i3 > i5) {
            float D = com.baidu.adp.lib.util.k.D(getContext());
            if (D > 1.0f) {
                if (i5 * D <= i3) {
                    i3 = (int) (i5 * D);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aER;
                if (!this.aFq) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aEY == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aEY);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                if (this.aFu) {
                    if (J(i, i2)) {
                        layoutParams.width = -1;
                    } else {
                        layoutParams.leftMargin = aEG;
                        layoutParams.rightMargin = aEG;
                    }
                }
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aER;
        if (!this.aFq) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        if (this.aFu) {
        }
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aFa <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aER;
        linearLayout.setClickable(true);
        Bitmap cz = at.cz(this.aFa);
        if (cz != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cz));
        }
        linearLayout.setFocusable(false);
        if (this.aFu) {
            layoutParams.leftMargin = aEG;
            layoutParams.rightMargin = aEG;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new y(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aFa;
    }

    public void setVideoImageId(int i) {
        this.aFa = i;
    }

    private ImageView ak(Context context) {
        ImageView dD = this.aEI != null ? this.aEI.dD() : null;
        if (dD == null || dD.getParent() != null) {
            dD = null;
        }
        if (dD != null) {
            dD.setContentDescription(context.getString(t.j.log_msg_pic));
        }
        return dD;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l GQ = cVar.GQ();
        if (GQ != null && GQ.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aFp) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(GQ.He(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(GQ.getLink()));
                if (!GQ.GX()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, GQ.getWidth(), GQ.getHeight(), i, i2, this.aFy);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        g GJ = cVar.GJ();
        if (GJ == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aFp) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(GJ.GW(), this.mIsFromCDN ? 17 : 18, false);
            if (!GJ.GX()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, GJ.getWidth(), GJ.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aFq = z;
    }

    private TextView al(Context context) {
        TextView textView = null;
        if (this.aEJ != null) {
            textView = this.aEJ.dD();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aEQ, 0, this.aEQ, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aER;
        textView.setLineSpacing(0.0f, this.aEP);
        textView.setTextSize(0, this.aES);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aEV);
        textView.setSingleLine(this.aFb);
        if (this.aFc != null) {
            textView.setEllipsize(this.aFc);
        }
        if (this.so > 0) {
            textView.setMaxWidth(this.so);
        }
        if (this.aFr > 0) {
            textView.setMaxLines(this.aFr);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder GK = cVar.GK();
        if (GK == null || GK.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aEU > 0 && this.aET > 0) {
            cVar.H(this.aET, this.aEU);
        }
        if (textSize > 0) {
            cVar.G(lineHeight, textSize);
        }
        try {
            textView.setText(GK);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aFs) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setFocusable(false);
        if (this.aFu) {
            layoutParams.leftMargin = aEG;
            layoutParams.rightMargin = aEG;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.GM() != null) {
            cVar.GM().aEo = this.aFA;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aEN != null) {
            gifView = this.aEN.dD();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aFu) {
                layoutParams.leftMargin = aEG;
                layoutParams.rightMargin = aEG;
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
        if (layoutParams == null || layoutParams.width != cVar.GO().aty.atc || layoutParams.height != cVar.GO().aty.atd) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.GO().aty.atc, cVar.GO().aty.atd);
            layoutParams2.gravity = 3;
            if (this.aFu) {
                layoutParams2.leftMargin = aEG;
                layoutParams2.rightMargin = aEG;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.GO().aty);
        return true;
    }

    private View getVoiceView() {
        View dD = this.aEL != null ? this.aEL.dD() : null;
        if ((dD == null || dD.getParent() != null) && this.aFh != -1) {
            dD = LayoutInflater.from(getContext()).inflate(this.aFh, (ViewGroup) null);
        }
        if (dD != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aER;
            layoutParams.bottomMargin = this.aER;
            dD.setLayoutParams(layoutParams);
            return dD;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aEK != null) {
            eVar = this.aEK.dD();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aER;
        layoutParams.bottomMargin = this.aER;
        if (this.aFu) {
            layoutParams.leftMargin = aEG;
            layoutParams.rightMargin = aEG;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.h(this.aFg, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aFp);
                eVar2.getGraffitiImageView().setDefaultResource(this.aEZ);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aFz);
            }
            eVar2.a(fVar, i, str, this.aEW - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aFx);
        }
        return eVar;
    }

    private View b(n nVar) {
        m mVar;
        if (this.aEO == null) {
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
            if (getContext() instanceof m) {
                mVar = (m) getContext();
            } else {
                mVar = (s == null || !(s.getOrignalPage() instanceof m)) ? null : (m) s.getOrignalPage();
            }
            this.aEO = mVar.fe(nVar.Rd);
        }
        View dD = this.aEO != null ? this.aEO.dD() : null;
        if (dD == null || dD.getParent() != null) {
            if (nVar.Rd == 1) {
                dD = new ds(getContext());
            } else {
                dD = new TogetherHiLivingView(getContext());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aER;
        dD.setLayoutParams(layoutParams);
        if (dD instanceof ds) {
            dD.setData(nVar);
        }
        if (dD instanceof TogetherHiLivingView) {
            dD.setData(nVar);
        }
        return dD;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.GL());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aFu) {
            layoutParams.leftMargin = aEG;
            layoutParams.rightMargin = aEG;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout dD = this.aEM.dD();
        if (dD != null) {
            TextView al = al(getContext());
            if (al == null) {
                this.aEM.k(dD);
                return null;
            }
            dD.addView(al);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aEJ.k(al);
                this.aEM.k(dD);
                return null;
            }
            dD.addView(voiceView);
            return dD;
        }
        return dD;
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
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBnt") ? a(cVar, childAt) & z : z;
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
        if (applyDimension != this.aES) {
            this.aES = applyDimension;
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
        if (this.aEQ != i) {
            this.aEQ = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aEQ, 0, 0, this.aEQ);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aEV) {
            this.aEV = i;
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
        if (this.aFv <= 0) {
            return false;
        }
        return (((((float) i) / ((float) this.aFv)) > 0.3f ? 1 : ((((float) i) / ((float) this.aFv)) == 0.3f ? 0 : -1)) > 0) && ((((((float) i2) / ((float) this.aFv)) * 1.618f) > 1.0f ? 1 : (((((float) i2) / ((float) this.aFv)) * 1.618f) == 1.0f ? 0 : -1)) > 0);
    }

    public int getMaxImageWidth() {
        return this.aEW;
    }

    public void setMaxImageWidth(int i) {
        this.aEW = i;
    }

    public int getMaxImageHeight() {
        return this.aEX;
    }

    public void setMaxImageHeight(int i) {
        this.aEX = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aEY;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aEY = scaleType;
    }

    public int getDefaultImageId() {
        return this.aEZ;
    }

    public void setDefaultImageId(int i) {
        this.aEZ = i;
    }

    public d getOnImageClickListener() {
        return this.aFe;
    }

    public void setOnImageClickListener(d dVar) {
        this.aFe = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aFm = cVar;
    }

    public void h(boolean z, boolean z2) {
        if (this.aFg != z) {
            this.aFg = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aFg && this.aEI != null) {
                this.aEI.clear();
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
        this.aFi = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aFj) {
                    Hs();
                    break;
                } else if (!this.aFt) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aFi) {
                    Hr();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aFi = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Hr() {
        this.aFj = false;
        if (this.aFk == null) {
            this.aFk = new a();
        }
        postDelayed(this.aFk, ViewConfiguration.getLongPressTimeout());
    }

    private void Hs() {
        if (this.aFk != null) {
            removeCallbacks(this.aFk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aFt && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aFj = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aFh = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aFo = null;
        if (this.aFB != drawable) {
            this.aFA = true;
            this.aFB = drawable;
        }
        setText(this.aFn);
        this.aFA = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CF();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CF();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CF();
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
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(getContext());
        if (q != null) {
            bdUniqueId = q.getUniqueId();
            z = q.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.atA == bdUniqueId)) {
            CF();
        }
        this.mUrl = str;
        this.atA = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.dF().V(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, 19, this.azI, 0, 0, this.atA, new Object[0]);
        }
    }

    public void CF() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, 19, this.azI);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.iY(), aVar.iY().getNinePatchChunk(), aVar.jc(), null);
                if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
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

    public e getOnLinkImageClickListener() {
        return this.aFf;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aFf = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aFs = z;
    }
}
