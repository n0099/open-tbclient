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
    private static final int aFY = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds32);
    static int aFZ = 174;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBq;
    private boolean aGA;
    private boolean aGB;
    private Runnable aGC;
    private boolean aGD;
    private c aGE;
    private com.baidu.tbadk.widget.richText.a aGF;
    private String aGG;
    private boolean aGH;
    private boolean aGI;
    private boolean aGJ;
    private int aGK;
    private boolean aGL;
    private boolean aGM;
    private boolean aGN;
    private int aGO;
    private boolean aGP;
    private boolean aGQ;
    public final View.OnClickListener aGR;
    private final View.OnTouchListener aGS;
    private boolean aGT;
    private Drawable aGU;
    private CustomMessageListener aGV;
    private com.baidu.adp.lib.f.b<ImageView> aGa;
    private com.baidu.adp.lib.f.b<TextView> aGb;
    private com.baidu.adp.lib.f.b<View> aGc;
    private com.baidu.adp.lib.f.b<View> aGd;
    private com.baidu.adp.lib.f.b<LinearLayout> aGe;
    private com.baidu.adp.lib.f.b<GifView> aGf;
    private com.baidu.adp.lib.f.b<View> aGg;
    private float aGh;
    private int aGi;
    private int aGj;
    private float aGk;
    private int aGl;
    private int aGm;
    private int aGn;
    private int aGo;
    private int aGp;
    private ImageView.ScaleType aGq;
    private int aGr;
    private int aGs;
    private boolean aGt;
    private TextUtils.TruncateAt aGu;
    private f aGv;
    private d aGw;
    private e aGx;
    private boolean aGy;
    private int aGz;
    private BdUniqueId afi;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int sS;

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
        this.aGP = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aGQ = z;
    }

    public boolean Ho() {
        return this.aGD;
    }

    public void Hp() {
        this.aGH = true;
    }

    public String getBackgroundImageUrl() {
        return this.aGG;
    }

    public void setBackgroundImageUrl(String str) {
        this.aGG = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.sS = i;
    }

    public void setMaxLines(int i) {
        this.aGK = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aGu = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aGN = z;
    }

    public boolean getIsSupportVitality() {
        return this.aGN;
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
        this.aGa = null;
        this.aGb = null;
        this.aGc = null;
        this.aGd = null;
        this.aGe = null;
        this.aGf = null;
        this.aGg = null;
        this.aGh = 0.0f;
        this.aGi = 0;
        this.aGj = 0;
        this.aGk = 15.0f;
        this.aGl = -1;
        this.aGm = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aGn = -9989158;
        this.aGo = 200;
        this.aGp = 200;
        this.aGq = null;
        this.aGr = 0;
        this.aGs = 0;
        this.aGt = false;
        this.aGu = null;
        this.aGv = null;
        this.aGw = null;
        this.aGx = null;
        this.aGy = true;
        this.mIsFromCDN = true;
        this.aGz = -1;
        this.aGA = false;
        this.aGB = false;
        this.aGC = null;
        this.aGD = false;
        this.aGG = null;
        this.aGH = false;
        this.aGI = false;
        this.sS = -1;
        this.aGK = -1;
        this.aGL = true;
        this.aGM = false;
        this.aGN = false;
        this.aGP = false;
        this.aGQ = true;
        this.mOnClickListener = new p(this);
        this.aGR = new r(this);
        this.aGS = new s(this);
        this.mType = 19;
        this.aBq = new t(this);
        this.aGV = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGa = null;
        this.aGb = null;
        this.aGc = null;
        this.aGd = null;
        this.aGe = null;
        this.aGf = null;
        this.aGg = null;
        this.aGh = 0.0f;
        this.aGi = 0;
        this.aGj = 0;
        this.aGk = 15.0f;
        this.aGl = -1;
        this.aGm = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aGn = -9989158;
        this.aGo = 200;
        this.aGp = 200;
        this.aGq = null;
        this.aGr = 0;
        this.aGs = 0;
        this.aGt = false;
        this.aGu = null;
        this.aGv = null;
        this.aGw = null;
        this.aGx = null;
        this.aGy = true;
        this.mIsFromCDN = true;
        this.aGz = -1;
        this.aGA = false;
        this.aGB = false;
        this.aGC = null;
        this.aGD = false;
        this.aGG = null;
        this.aGH = false;
        this.aGI = false;
        this.sS = -1;
        this.aGK = -1;
        this.aGL = true;
        this.aGM = false;
        this.aGN = false;
        this.aGP = false;
        this.aGQ = true;
        this.mOnClickListener = new p(this);
        this.aGR = new r(this);
        this.aGS = new s(this);
        this.mType = 19;
        this.aBq = new t(this);
        this.aGV = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.TbRichTextView);
        this.aGj = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aGi = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aGh = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aGk = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aGk);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aGo = obtainStyledAttributes.getDimensionPixelSize(6, this.aGo);
        this.aGp = obtainStyledAttributes.getDimensionPixelSize(7, this.aGp);
        this.aGr = obtainStyledAttributes.getResourceId(8, 0);
        this.aGl = obtainStyledAttributes.getDimensionPixelSize(9, this.aGl);
        this.aGm = obtainStyledAttributes.getDimensionPixelSize(10, this.aGm);
        this.aGs = obtainStyledAttributes.getResourceId(11, 0);
        this.aGt = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aGh = f2;
    }

    private void init() {
        aFZ = getContext().getResources().getDimensionPixelSize(u.e.ds348);
        m mVar = null;
        com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (s != null && (s.getOrignalPage() instanceof m)) {
            mVar = (m) s.getOrignalPage();
        }
        if (s != null) {
            s.registerListener(this.aGV);
        }
        if (mVar != null) {
            this.aGa = mVar.Hf();
            this.aGb = mVar.Hg();
            this.aGd = mVar.Hi();
            this.aGe = mVar.Hj();
            this.aGf = mVar.Hh();
            this.aGc = mVar.Hk();
            if (mVar.getListView() != null && this.aGv == null) {
                this.aGv = new f(mVar.He());
                mVar.getListView().setRecyclerListener(this.aGv);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new w(this));
        this.aGO = com.baidu.adp.lib.util.k.A(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0026 */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> GD;
        int i;
        boolean z2;
        SpannableStringBuilder GJ;
        View a2;
        n GS;
        if (this.aGF != aVar || (aVar != null && aVar.aFn)) {
            if (aVar != null) {
                aVar.aFn = false;
            }
            this.aGF = aVar;
            removeAllViews();
            if (aVar != null && (GD = aVar.GD()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = GD.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ak = ak(getContext());
                            boolean a3 = a(next, ak, true);
                            if (z && !this.aGD && (GJ = next.GJ()) != null) {
                                this.aGD = GJ.length() >= 200;
                            }
                            i = i2;
                            view2 = ak;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView aj = aj(getContext());
                                z2 = b(next, aj, (this.aGo - getPaddingLeft()) - getPaddingRight(), this.aGp);
                                i = i2 + 1;
                                view2 = aj;
                            }
                        } else if (next.getType() == 32) {
                            o GM = next.GM();
                            if (GM != null && GM.Hm()) {
                                a2 = b(GM);
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
                            z2 = a(next, aj2, (this.aGo - getPaddingLeft()) - getPaddingRight(), this.aGp);
                            i = i2 + 1;
                            view2 = aj2;
                        } else if (next.getType() == 1536) {
                            com.baidu.tbadk.widget.richText.f GR = next.GR();
                            GR.fg(aVar.GC());
                            if (GR != null) {
                                View a4 = a(GR, aVar.GC(), aVar.getAuthorId());
                                z2 = true;
                                i = i2;
                                view2 = a4;
                            }
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        } else {
                            if (next.getType() == 1792 && (GS = next.GS()) != null) {
                                View b2 = b(GS);
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
                    layoutParams.bottomMargin = this.aGj;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(o oVar) {
        if (oVar == null || !oVar.isAvaliable()) {
            return null;
        }
        ImageView dD = this.aGa.dD();
        if (dD instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) dD;
            foreDrawableImageView.setForegroundDrawable(u.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(u.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m10getInst().getResources().getDimension(u.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, oVar.getWidth(), oVar.getHeight(), (this.aGo - getPaddingLeft()) - getPaddingRight(), this.aGp, new x(this, oVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aGH);
            if (com.baidu.tbadk.core.l.nL().nR()) {
                foreDrawableImageView.setDefaultBgResource(u.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(u.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(oVar.oP(), 17, false);
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
        if (this.aGN && J(i, i2) && this.aGO > 0) {
            i3 = this.aGO;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (!this.aGy) {
            iArr[0] = i3;
            iArr[1] = aFZ;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aGr);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aGJ && i3 > i5) {
            float C = com.baidu.adp.lib.util.k.C(getContext());
            if (C > 1.0f) {
                if (i5 * C <= i3) {
                    i3 = (int) (i5 * C);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aGj;
                if (!this.aGJ) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aGq == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aGq);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                if (this.aGN) {
                    if (J(i, i2)) {
                        layoutParams.width = -1;
                    } else {
                        layoutParams.leftMargin = aFY;
                        layoutParams.rightMargin = aFY;
                    }
                }
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aGj;
        if (!this.aGJ) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        if (this.aGN) {
        }
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aGs <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aGj;
        linearLayout.setClickable(true);
        Bitmap cA = av.cA(this.aGs);
        if (cA != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cA));
        }
        linearLayout.setFocusable(false);
        if (this.aGN) {
            layoutParams.leftMargin = aFY;
            layoutParams.rightMargin = aFY;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new y(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aGs;
    }

    public void setVideoImageId(int i) {
        this.aGs = i;
    }

    private ImageView aj(Context context) {
        ImageView dD = this.aGa != null ? this.aGa.dD() : null;
        if (dD == null || dD.getParent() != null) {
            dD = null;
        }
        if (dD != null) {
            dD.setContentDescription(context.getString(u.j.log_msg_pic));
        }
        return dD;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l GP = cVar.GP();
        if (GP != null && GP.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aGH) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(GP.Hd(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(GP.getLink()));
                if (!GP.GW()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, GP.getWidth(), GP.getHeight(), i, i2, this.aGR);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        g GI = cVar.GI();
        if (GI == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aGH) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(GI.GV(), this.mIsFromCDN ? 17 : 18, false);
            if (!GI.GW()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, GI.getWidth(), GI.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aGJ = z;
    }

    private TextView ak(Context context) {
        TextView textView = null;
        if (this.aGb != null) {
            textView = this.aGb.dD();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aGi, 0, this.aGi, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aGI) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aGj;
        }
        textView.setLineSpacing(0.0f, this.aGh);
        textView.setTextSize(0, this.aGk);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aGn);
        textView.setSingleLine(this.aGt);
        if (this.aGu != null) {
            textView.setEllipsize(this.aGu);
        }
        if (this.sS > 0) {
            textView.setMaxWidth(this.sS);
        }
        if (this.aGK > 0) {
            textView.setMaxLines(this.aGK);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder GJ = cVar.GJ();
        if (GJ == null || GJ.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aGm > 0 && this.aGl > 0) {
            cVar.H(this.aGl, this.aGm);
        }
        if (textSize > 0) {
            cVar.G(lineHeight, textSize);
        }
        try {
            textView.setText(GJ);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aGL) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setFocusable(false);
        if (this.aGN) {
            layoutParams.leftMargin = aFY;
            layoutParams.rightMargin = aFY;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.GL() != null) {
            cVar.GL().aFG = this.aGT;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aGf != null) {
            gifView = this.aGf.dD();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aGN) {
                layoutParams.leftMargin = aFY;
                layoutParams.rightMargin = aFY;
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
        if (layoutParams == null || layoutParams.width != cVar.GN().avd.auH || layoutParams.height != cVar.GN().avd.auI) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.GN().avd.auH, cVar.GN().avd.auI);
            layoutParams2.gravity = 3;
            if (this.aGN) {
                layoutParams2.leftMargin = aFY;
                layoutParams2.rightMargin = aFY;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.GN().avd);
        return true;
    }

    private View getVoiceView() {
        View dD = this.aGd != null ? this.aGd.dD() : null;
        if ((dD == null || dD.getParent() != null) && this.aGz != -1) {
            dD = LayoutInflater.from(getContext()).inflate(this.aGz, (ViewGroup) null);
        }
        if (dD != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aGj;
            layoutParams.bottomMargin = this.aGj;
            dD.setLayoutParams(layoutParams);
            return dD;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aGc != null) {
            eVar = this.aGc.dD();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aGj;
        layoutParams.bottomMargin = this.aGj;
        if (this.aGN) {
            layoutParams.leftMargin = aFY;
            layoutParams.rightMargin = aFY;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.i(this.aGy, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aGH);
                eVar2.getGraffitiImageView().setDefaultResource(this.aGr);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aGS);
            }
            eVar2.a(fVar, i, str, this.aGo - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aGQ);
        }
        return eVar;
    }

    private View b(n nVar) {
        m mVar;
        if (this.aGg == null) {
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
            if (getContext() instanceof m) {
                mVar = (m) getContext();
            } else {
                mVar = (s == null || !(s.getOrignalPage() instanceof m)) ? null : (m) s.getOrignalPage();
            }
            this.aGg = mVar.fj(nVar.Sf);
        }
        View dD = this.aGg != null ? this.aGg.dD() : null;
        if (dD == null || dD.getParent() != null) {
            if (nVar.Sf == 1) {
                dD = new ds(getContext());
            } else {
                dD = new TogetherHiLivingView(getContext());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aGj;
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
        view.setTag(cVar.GK());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aGN) {
            layoutParams.leftMargin = aFY;
            layoutParams.rightMargin = aFY;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout dD = this.aGe.dD();
        if (dD != null) {
            TextView ak = ak(getContext());
            if (ak == null) {
                this.aGe.n(dD);
                return null;
            }
            dD.addView(ak);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aGb.n(ak);
                this.aGe.n(dD);
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
        if (applyDimension != this.aGk) {
            this.aGk = applyDimension;
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
        if (this.aGi != i) {
            this.aGi = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aGi, 0, 0, this.aGi);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aGn) {
            this.aGn = i;
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
        if (this.aGO <= 0) {
            return false;
        }
        return (((((float) i) / ((float) this.aGO)) > 0.3f ? 1 : ((((float) i) / ((float) this.aGO)) == 0.3f ? 0 : -1)) > 0) && ((((((float) i2) / ((float) this.aGO)) * 1.618f) > 1.0f ? 1 : (((((float) i2) / ((float) this.aGO)) * 1.618f) == 1.0f ? 0 : -1)) > 0);
    }

    public int getMaxImageWidth() {
        return this.aGo;
    }

    public void setMaxImageWidth(int i) {
        this.aGo = i;
    }

    public int getMaxImageHeight() {
        return this.aGp;
    }

    public void setMaxImageHeight(int i) {
        this.aGp = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aGq;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aGq = scaleType;
    }

    public int getDefaultImageId() {
        return this.aGr;
    }

    public void setDefaultImageId(int i) {
        this.aGr = i;
    }

    public d getOnImageClickListener() {
        return this.aGw;
    }

    public void setOnImageClickListener(d dVar) {
        this.aGw = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aGE = cVar;
    }

    public void i(boolean z, boolean z2) {
        if (this.aGy != z) {
            this.aGy = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aGy && this.aGa != null) {
                this.aGa.clear();
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
        this.aGA = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aGB) {
                    Hr();
                    break;
                } else if (!this.aGM) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aGA) {
                    Hq();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aGA = true;
        return super.onTouchEvent(motionEvent);
    }

    private void Hq() {
        this.aGB = false;
        if (this.aGC == null) {
            this.aGC = new a();
        }
        postDelayed(this.aGC, ViewConfiguration.getLongPressTimeout());
    }

    private void Hr() {
        if (this.aGC != null) {
            removeCallbacks(this.aGC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aGM && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aGB = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aGz = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aGG = null;
        if (this.aGU != drawable) {
            this.aGT = true;
            this.aGU = drawable;
        }
        setText(this.aGF);
        this.aGT = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CM();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        CM();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            CM();
        } else {
            refresh();
        }
    }

    public void gB(String str) {
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
        if (!(str.equals(this.mUrl) && this.afi == bdUniqueId)) {
            CM();
        }
        this.mUrl = str;
        this.afi = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.dF().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.dF().Y(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, 19, this.aBq, 0, 0, this.afi, new Object[0]);
        }
    }

    public void CM() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.dF().a(this.mUrl, 19, this.aBq);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.ja(), aVar.ja().getNinePatchChunk(), aVar.je(), null);
                if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        gB(this.mUrl);
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
        return this.aGx;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aGx = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aGL = z;
    }

    public void setTextCenter(boolean z) {
        this.aGI = z;
    }
}
