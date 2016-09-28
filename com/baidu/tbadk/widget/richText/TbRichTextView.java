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
import com.baidu.tieba.r;
import com.baidu.tieba.togetherhi.TogetherHiLivingView;
import com.baidu.tieba.togetherhi.ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    private static final int aIJ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32);
    static int aIK = 174;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDV;
    private com.baidu.adp.lib.f.b<ImageView> aIL;
    private com.baidu.adp.lib.f.b<TextView> aIM;
    private com.baidu.adp.lib.f.b<View> aIN;
    private com.baidu.adp.lib.f.b<View> aIO;
    private com.baidu.adp.lib.f.b<LinearLayout> aIP;
    private com.baidu.adp.lib.f.b<GifView> aIQ;
    private com.baidu.adp.lib.f.b<View> aIR;
    private float aIS;
    private int aIT;
    private int aIU;
    private float aIV;
    private int aIW;
    private int aIX;
    private int aIY;
    private int aIZ;
    private boolean aJA;
    private boolean aJB;
    public final View.OnClickListener aJC;
    private final View.OnTouchListener aJD;
    private boolean aJE;
    private Drawable aJF;
    private CustomMessageListener aJG;
    private int aJa;
    private ImageView.ScaleType aJb;
    private int aJc;
    private int aJd;
    private boolean aJe;
    private TextUtils.TruncateAt aJf;
    private g aJg;
    private e aJh;
    private f aJi;
    private boolean aJj;
    private int aJk;
    private boolean aJl;
    private boolean aJm;
    private Runnable aJn;
    private boolean aJo;
    private d aJp;
    private com.baidu.tbadk.widget.richText.a aJq;
    private String aJr;
    private boolean aJs;
    private boolean aJt;
    private boolean aJu;
    private int aJv;
    private boolean aJw;
    private boolean aJx;
    private boolean aJy;
    private int aJz;
    private BdUniqueId ahL;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;
    private int vi;

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

    public void setSubPbPost(boolean z) {
        this.aJA = z;
    }

    public void setShowGraffitiSaveBtn(boolean z) {
        this.aJB = z;
    }

    public boolean IN() {
        return this.aJo;
    }

    public void IO() {
        this.aJs = true;
    }

    public String getBackgroundImageUrl() {
        return this.aJr;
    }

    public void setBackgroundImageUrl(String str) {
        this.aJr = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.vi = i;
    }

    public void setMaxLines(int i) {
        this.aJv = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aJf = truncateAt;
    }

    public void setIsSupportVitality(boolean z) {
        this.aJy = z;
    }

    public boolean getIsSupportVitality() {
        return this.aJy;
    }

    public float getLineSpacing() {
        return this.aIS;
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
    public boolean P(View view) {
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

    public static com.baidu.tbadk.widget.richText.a b(Context context, List<PbContent> list, boolean z) {
        return new com.baidu.tbadk.widget.richText.a(context, list, z);
    }

    public static com.baidu.adp.lib.f.b<TextView> i(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new v(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aIL = null;
        this.aIM = null;
        this.aIN = null;
        this.aIO = null;
        this.aIP = null;
        this.aIQ = null;
        this.aIR = null;
        this.aIS = 0.0f;
        this.aIT = 0;
        this.aIU = 0;
        this.aIV = 15.0f;
        this.aIW = -1;
        this.aIX = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aIY = -9989158;
        this.aIZ = 200;
        this.aJa = 200;
        this.aJb = null;
        this.aJc = 0;
        this.aJd = 0;
        this.aJe = false;
        this.aJf = null;
        this.aJg = null;
        this.aJh = null;
        this.aJi = null;
        this.aJj = true;
        this.mIsFromCDN = true;
        this.aJk = -1;
        this.aJl = false;
        this.aJm = false;
        this.aJn = null;
        this.aJo = false;
        this.aJr = null;
        this.aJs = false;
        this.aJt = false;
        this.vi = -1;
        this.aJv = -1;
        this.aJw = true;
        this.aJx = false;
        this.aJy = false;
        this.aJA = false;
        this.aJB = true;
        this.mOnClickListener = new p(this);
        this.aJC = new r(this);
        this.aJD = new s(this);
        this.mType = 19;
        this.aDV = new t(this);
        this.aJG = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIL = null;
        this.aIM = null;
        this.aIN = null;
        this.aIO = null;
        this.aIP = null;
        this.aIQ = null;
        this.aIR = null;
        this.aIS = 0.0f;
        this.aIT = 0;
        this.aIU = 0;
        this.aIV = 15.0f;
        this.aIW = -1;
        this.aIX = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aIY = -9989158;
        this.aIZ = 200;
        this.aJa = 200;
        this.aJb = null;
        this.aJc = 0;
        this.aJd = 0;
        this.aJe = false;
        this.aJf = null;
        this.aJg = null;
        this.aJh = null;
        this.aJi = null;
        this.aJj = true;
        this.mIsFromCDN = true;
        this.aJk = -1;
        this.aJl = false;
        this.aJm = false;
        this.aJn = null;
        this.aJo = false;
        this.aJr = null;
        this.aJs = false;
        this.aJt = false;
        this.vi = -1;
        this.aJv = -1;
        this.aJw = true;
        this.aJx = false;
        this.aJy = false;
        this.aJA = false;
        this.aJB = true;
        this.mOnClickListener = new p(this);
        this.aJC = new r(this);
        this.aJD = new s(this);
        this.mType = 19;
        this.aDV = new t(this);
        this.aJG = new u(this, CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.TbRichTextView);
        this.aIU = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aIT = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aIS = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aIV = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aIV);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aIZ = obtainStyledAttributes.getDimensionPixelSize(6, this.aIZ);
        this.aJa = obtainStyledAttributes.getDimensionPixelSize(7, this.aJa);
        this.aJc = obtainStyledAttributes.getResourceId(8, 0);
        this.aIW = obtainStyledAttributes.getDimensionPixelSize(9, this.aIW);
        this.aIX = obtainStyledAttributes.getDimensionPixelSize(10, this.aIX);
        this.aJd = obtainStyledAttributes.getResourceId(11, 0);
        this.aJe = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aIS = f2;
    }

    private void init() {
        aIK = getContext().getResources().getDimensionPixelSize(r.e.ds348);
        m mVar = null;
        com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else if (C != null && (C.getOrignalPage() instanceof m)) {
            mVar = (m) C.getOrignalPage();
        }
        if (C != null) {
            C.registerListener(this.aJG);
        }
        if (mVar != null) {
            this.aIL = mVar.ID();
            this.aIM = mVar.IE();
            this.aIO = mVar.IG();
            this.aIP = mVar.IH();
            this.aIQ = mVar.IF();
            this.aIN = mVar.II();
            if (mVar.getListView() != null && this.aJg == null) {
                this.aJg = new g(mVar.IC());
                mVar.getListView().setRecyclerListener(this.aJg);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new w(this));
        this.aJz = com.baidu.adp.lib.util.k.K(getContext());
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        a(aVar, z, (b) null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0026 */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z, b bVar) {
        ArrayList<com.baidu.tbadk.widget.richText.c> HZ;
        int i;
        boolean z2;
        SpannableStringBuilder If;
        View a2;
        n Io;
        if (this.aJq != aVar || (aVar != null && aVar.aHW)) {
            if (aVar != null) {
                aVar.aHW = false;
            }
            this.aJq = aVar;
            removeAllViews();
            if (aVar != null && (HZ = aVar.HZ()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = HZ.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView as = as(getContext());
                            boolean a3 = a(next, as, true, bVar);
                            if (z && !this.aJo && (If = next.If()) != null) {
                                this.aJo = If.length() >= 200;
                            }
                            i = i2;
                            view2 = as;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView ar = ar(getContext());
                                z2 = b(next, ar, (this.aIZ - getPaddingLeft()) - getPaddingRight(), this.aJa);
                                i = i2 + 1;
                                view2 = ar;
                            }
                        } else if (next.getType() == 32) {
                            o Ii = next.Ii();
                            if (Ii != null && Ii.IK()) {
                                a2 = b(Ii);
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
                            z2 = a(next, (LinearLayout) textVoiceView, bVar);
                            i = i2;
                        } else if (next.getType() == 17) {
                            GifView gifView = getGifView();
                            view2 = gifView;
                            z2 = a(next, gifView);
                            i = i2;
                        } else if (next.getType() == 1280) {
                            ImageView ar2 = ar(getContext());
                            z2 = a(next, ar2, (this.aIZ - getPaddingLeft()) - getPaddingRight(), this.aJa);
                            i = i2 + 1;
                            view2 = ar2;
                        } else if (next.getType() == 1536) {
                            com.baidu.tbadk.widget.richText.f In = next.In();
                            In.fu(aVar.HY());
                            if (In != null) {
                                View a4 = a(In, aVar.HY(), aVar.getAuthorId());
                                z2 = true;
                                i = i2;
                                view2 = a4;
                            }
                            z2 = false;
                            i = i2;
                            view2 = view2;
                        } else {
                            if (next.getType() == 1792 && (Io = next.Io()) != null) {
                                View b2 = b(Io);
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
                    layoutParams.bottomMargin = this.aIU;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(o oVar) {
        if (oVar == null || !oVar.isAvaliable()) {
            return null;
        }
        ImageView ey = this.aIL.ey();
        if (ey instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) ey;
            foreDrawableImageView.setForegroundDrawable(r.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(r.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, oVar.getWidth(), oVar.getHeight(), (this.aIZ - getPaddingLeft()) - getPaddingRight(), this.aJa, new x(this, oVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aJs);
            if (com.baidu.tbadk.core.l.oH().oN()) {
                foreDrawableImageView.setDefaultBgResource(r.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(r.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(oVar.qd(), 17, false);
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
        if (this.aJy && M(i, i2) && this.aJz > 0) {
            i3 = this.aJz;
            i4 = (int) (i3 * 1.618f);
        }
        int[] c2 = com.baidu.adp.lib.util.k.c(i, i2, i3, i4);
        if (c2 == null) {
            return false;
        }
        int[] iArr = {c2[0], c2[1]};
        if (!this.aJj) {
            iArr[0] = i3;
            iArr[1] = aIK;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aJc);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aJu && i3 > i5) {
            float M = com.baidu.adp.lib.util.k.M(getContext());
            if (M > 1.0f) {
                if (i5 * M <= i3) {
                    i3 = (int) (i5 * M);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aIU;
                if (!this.aJu) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aJb == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aJb);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                if (this.aJy) {
                    if (M(i, i2)) {
                        layoutParams.width = -1;
                    } else {
                        layoutParams.leftMargin = aIJ;
                        layoutParams.rightMargin = aIJ;
                    }
                }
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aIU;
        if (!this.aJu) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        if (this.aJy) {
        }
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aJd <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aIU;
        linearLayout.setClickable(true);
        Bitmap cN = av.cN(this.aJd);
        if (cN != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cN));
        }
        linearLayout.setFocusable(false);
        if (this.aJy) {
            layoutParams.leftMargin = aIJ;
            layoutParams.rightMargin = aIJ;
        }
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new y(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aJd;
    }

    public void setVideoImageId(int i) {
        this.aJd = i;
    }

    private ImageView ar(Context context) {
        ImageView ey = this.aIL != null ? this.aIL.ey() : null;
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
        l Il = cVar.Il();
        if (Il != null && Il.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aJs) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Il.IB(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new c(Il.getLink()));
                if (!Il.Iu()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Il.getWidth(), Il.getHeight(), i, i2, this.aJC);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        com.baidu.tbadk.widget.richText.g Ie = cVar.Ie();
        if (Ie == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aJs) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(Ie.It(), this.mIsFromCDN ? 17 : 18, false);
            if (!Ie.Iu()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Ie.getWidth(), Ie.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aJu = z;
    }

    private TextView as(Context context) {
        TextView textView = null;
        if (this.aIM != null) {
            textView = this.aIM.ey();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aIT, 0, this.aIT, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z, b bVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aJt) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.aIU;
        }
        textView.setLineSpacing(0.0f, this.aIS);
        textView.setTextSize(0, this.aIV);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(av.getColor(r.d.cp_link_tip_c));
        textView.setSingleLine(this.aJe);
        if (this.aJf != null) {
            textView.setEllipsize(this.aJf);
        }
        if (this.vi > 0) {
            textView.setMaxWidth(this.vi);
        }
        if (this.aJv > 0) {
            textView.setMaxLines(this.aJv);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder If = cVar.If();
        if (If == null || If.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aIX > 0 && this.aIW > 0) {
            cVar.K(this.aIW, this.aIX);
        }
        if (textSize > 0) {
            cVar.J(lineHeight, textSize);
        }
        if (bVar != null) {
            bVar.a(If, textView, this);
        }
        try {
            textView.setText(If);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aJw) {
            if (cVar.Ip()) {
                textView.setMovementMethod(com.baidu.tieba.view.g.bqP());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        if (this.aJy) {
            layoutParams.leftMargin = aIJ;
            layoutParams.rightMargin = aIJ;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        if (cVar != null && cVar.Ih() != null) {
            cVar.Ih().aIq = this.aJE;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aIQ != null) {
            gifView = this.aIQ.ey();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            if (this.aJy) {
                layoutParams.leftMargin = aIJ;
                layoutParams.rightMargin = aIJ;
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
        if (layoutParams == null || layoutParams.width != cVar.Ij().axN.axr || layoutParams.height != cVar.Ij().axN.axs) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Ij().axN.axr, cVar.Ij().axN.axs);
            layoutParams2.gravity = 3;
            if (this.aJy) {
                layoutParams2.leftMargin = aIJ;
                layoutParams2.rightMargin = aIJ;
            }
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new q(this, cVar));
        gifView.a(cVar.Ij().axN);
        return true;
    }

    private View getVoiceView() {
        View ey = this.aIO != null ? this.aIO.ey() : null;
        if ((ey == null || ey.getParent() != null) && this.aJk != -1) {
            ey = LayoutInflater.from(getContext()).inflate(this.aJk, (ViewGroup) null);
        }
        if (ey != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aIU;
            layoutParams.bottomMargin = this.aIU;
            ey.setLayoutParams(layoutParams);
            return ey;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aIN != null) {
            eVar = this.aIN.ey();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aIU;
        layoutParams.bottomMargin = this.aIU;
        if (this.aJy) {
            layoutParams.leftMargin = aIJ;
            layoutParams.rightMargin = aIJ;
        }
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.k(this.aJj, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aJs);
                eVar2.getGraffitiImageView().setDefaultResource(this.aJc);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aJD);
            }
            eVar2.a(fVar, i, str, this.aIZ - (getPaddingLeft() + getPaddingRight()), getPaddingRight(), this.aJB);
        }
        return eVar;
    }

    private View b(n nVar) {
        m mVar;
        if (this.aIR == null) {
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(getContext());
            if (getContext() instanceof m) {
                mVar = (m) getContext();
            } else {
                mVar = (C == null || !(C.getOrignalPage() instanceof m)) ? null : (m) C.getOrignalPage();
            }
            this.aIR = mVar.fy(nVar.Vf);
        }
        View ey = this.aIR != null ? this.aIR.ey() : null;
        if (ey == null || ey.getParent() != null) {
            if (nVar.Vf == 1) {
                ey = new ds(getContext());
            } else {
                ey = new TogetherHiLivingView(getContext());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aIU;
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
        view.setTag(cVar.Ig());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.aJy) {
            layoutParams.leftMargin = aIJ;
            layoutParams.rightMargin = aIJ;
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout ey = this.aIP.ey();
        if (ey != null) {
            TextView as = as(getContext());
            if (as == null) {
                this.aIP.n(ey);
                return null;
            }
            ey.addView(as);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aIM.n(as);
                this.aIP.n(ey);
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
        if (applyDimension != this.aIV) {
            this.aIV = applyDimension;
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
        if (this.aIT != i) {
            this.aIT = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aIT, 0, 0, this.aIT);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aIY) {
            this.aIY = i;
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
        if (this.aJz <= 0) {
            return false;
        }
        return (((((float) i) / ((float) this.aJz)) > 0.3f ? 1 : ((((float) i) / ((float) this.aJz)) == 0.3f ? 0 : -1)) > 0) && ((((((float) i2) / ((float) this.aJz)) * 1.618f) > 1.0f ? 1 : (((((float) i2) / ((float) this.aJz)) * 1.618f) == 1.0f ? 0 : -1)) > 0);
    }

    public int getMaxImageWidth() {
        return this.aIZ;
    }

    public void setMaxImageWidth(int i) {
        this.aIZ = i;
    }

    public int getMaxImageHeight() {
        return this.aJa;
    }

    public void setMaxImageHeight(int i) {
        this.aJa = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aJb;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aJb = scaleType;
    }

    public int getDefaultImageId() {
        return this.aJc;
    }

    public void setDefaultImageId(int i) {
        this.aJc = i;
    }

    public e getOnImageClickListener() {
        return this.aJh;
    }

    public void setOnImageClickListener(e eVar) {
        this.aJh = eVar;
    }

    public void setOnEmotionClickListener(d dVar) {
        this.aJp = dVar;
    }

    public void k(boolean z, boolean z2) {
        if (this.aJj != z) {
            this.aJj = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aJj && this.aIL != null) {
                this.aIL.clear();
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
        this.aJl = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aJm) {
                    IQ();
                    break;
                } else if (!this.aJx) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aJl) {
                    IP();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aJl = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IP() {
        this.aJm = false;
        if (this.aJn == null) {
            this.aJn = new a();
        }
        postDelayed(this.aJn, ViewConfiguration.getLongPressTimeout());
    }

    private void IQ() {
        if (this.aJn != null) {
            removeCallbacks(this.aJn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aJx && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aJm = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aJk = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aJr = null;
        if (this.aJF != drawable) {
            this.aJE = true;
            this.aJF = drawable;
        }
        setText(this.aJq);
        this.aJE = false;
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

    public void gI(String str) {
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
        if (!(str.equals(this.mUrl) && this.ahL == bdUniqueId)) {
            Eh();
        }
        this.mUrl = str;
        this.ahL = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.eA().al(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aDV, 0, 0, this.ahL, new Object[0]);
        }
    }

    public void Eh() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.mUrl, 19, this.aDV);
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
        gI(this.mUrl);
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
        return this.aJi;
    }

    public void setOnLinkImageClickListener(f fVar) {
        this.aJi = fVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aJw = z;
    }

    public void setTextCenter(boolean z) {
        this.aJt = z;
    }
}
