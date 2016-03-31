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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.a.i {
    static int aIG = 174;
    private int Ca;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDE;
    private com.baidu.adp.lib.f.b<ImageView> aIH;
    private com.baidu.adp.lib.f.b<TextView> aII;
    private com.baidu.adp.lib.f.b<View> aIJ;
    private com.baidu.adp.lib.f.b<View> aIK;
    private com.baidu.adp.lib.f.b<LinearLayout> aIL;
    private com.baidu.adp.lib.f.b<GifView> aIM;
    private float aIN;
    private int aIO;
    private int aIP;
    private float aIQ;
    private int aIR;
    private int aIS;
    private int aIT;
    private int aIU;
    private int aIV;
    private ImageView.ScaleType aIW;
    private int aIX;
    private int aIY;
    private boolean aIZ;
    private TextUtils.TruncateAt aJa;
    private f aJb;
    private d aJc;
    private e aJd;
    private boolean aJe;
    private int aJf;
    private boolean aJg;
    private boolean aJh;
    private Runnable aJi;
    private boolean aJj;
    private c aJk;
    private com.baidu.tbadk.widget.richText.a aJl;
    private String aJm;
    private boolean aJn;
    private boolean aJo;
    private int aJp;
    private boolean aJq;
    private boolean aJr;
    public final View.OnClickListener aJs;
    private final View.OnTouchListener aJt;
    private boolean aJu;
    private Drawable aJv;
    private BdUniqueId axz;
    private boolean mIsFromCDN;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    private final int mType;
    private String mUrl;

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

    public boolean IX() {
        return this.aJj;
    }

    public void IY() {
        this.aJn = true;
    }

    public String getBackgroundImageUrl() {
        return this.aJm;
    }

    public void setBackgroundImageUrl(String str) {
        this.aJm = str;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setMaxWidth(int i) {
        this.Ca = i;
    }

    public void setMaxLines(int i) {
        this.aJp = i;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.aJa = truncateAt;
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

    public static com.baidu.adp.lib.f.b<TextView> g(Context context, int i) {
        return new com.baidu.adp.lib.f.b<>(new s(context), i, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.aIH = null;
        this.aII = null;
        this.aIJ = null;
        this.aIK = null;
        this.aIL = null;
        this.aIM = null;
        this.aIN = 0.0f;
        this.aIO = 0;
        this.aIP = 0;
        this.aIQ = 15.0f;
        this.aIR = -1;
        this.aIS = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aIT = -9989158;
        this.aIU = 200;
        this.aIV = 200;
        this.aIW = null;
        this.aIX = 0;
        this.aIY = 0;
        this.aIZ = false;
        this.aJa = null;
        this.aJb = null;
        this.aJc = null;
        this.aJd = null;
        this.aJe = true;
        this.mIsFromCDN = true;
        this.aJf = -1;
        this.aJg = false;
        this.aJh = false;
        this.aJi = null;
        this.aJj = false;
        this.aJm = null;
        this.aJn = false;
        this.Ca = -1;
        this.aJp = -1;
        this.aJq = true;
        this.aJr = false;
        this.mOnClickListener = new o(this);
        this.aJs = new p(this);
        this.aJt = new q(this);
        this.mType = 19;
        this.aDE = new r(this);
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIH = null;
        this.aII = null;
        this.aIJ = null;
        this.aIK = null;
        this.aIL = null;
        this.aIM = null;
        this.aIN = 0.0f;
        this.aIO = 0;
        this.aIP = 0;
        this.aIQ = 15.0f;
        this.aIR = -1;
        this.aIS = -1;
        this.mTextColor = ViewCompat.MEASURED_STATE_MASK;
        this.aIT = -9989158;
        this.aIU = 200;
        this.aIV = 200;
        this.aIW = null;
        this.aIX = 0;
        this.aIY = 0;
        this.aIZ = false;
        this.aJa = null;
        this.aJb = null;
        this.aJc = null;
        this.aJd = null;
        this.aJe = true;
        this.mIsFromCDN = true;
        this.aJf = -1;
        this.aJg = false;
        this.aJh = false;
        this.aJi = null;
        this.aJj = false;
        this.aJm = null;
        this.aJn = false;
        this.Ca = -1;
        this.aJp = -1;
        this.aJq = true;
        this.aJr = false;
        this.mOnClickListener = new o(this);
        this.aJs = new p(this);
        this.aJt = new q(this);
        this.mType = 19;
        this.aDE = new r(this);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.TbRichTextView);
        this.aIP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.aIO = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.aIN = obtainStyledAttributes.getFloat(5, 1.2f);
        this.aIQ = obtainStyledAttributes.getDimensionPixelSize(2, (int) this.aIQ);
        this.mTextColor = obtainStyledAttributes.getColor(3, this.mTextColor);
        this.aIU = obtainStyledAttributes.getDimensionPixelSize(6, this.aIU);
        this.aIV = obtainStyledAttributes.getDimensionPixelSize(7, this.aIV);
        this.aIX = obtainStyledAttributes.getResourceId(8, 0);
        this.aIR = obtainStyledAttributes.getDimensionPixelSize(9, this.aIR);
        this.aIS = obtainStyledAttributes.getDimensionPixelSize(10, this.aIS);
        this.aIY = obtainStyledAttributes.getResourceId(11, 0);
        this.aIZ = obtainStyledAttributes.getBoolean(12, false);
        obtainStyledAttributes.recycle();
    }

    public void setLineSpacing(float f2) {
        this.aIN = f2;
    }

    private void init() {
        aIG = getContext().getResources().getDimensionPixelSize(t.e.adk_default_image_height);
        m mVar = null;
        if (getContext() instanceof m) {
            mVar = (m) getContext();
        } else {
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(getContext());
            if (s != null && (s.getOrignalPage() instanceof m)) {
                mVar = (m) s.getOrignalPage();
            }
        }
        if (mVar != null) {
            this.aIH = mVar.IO();
            this.aII = mVar.IP();
            this.aIK = mVar.IR();
            this.aIL = mVar.IS();
            this.aIM = mVar.IQ();
            this.aIJ = mVar.IT();
            if (mVar.getListView() != null && this.aJb == null) {
                this.aJb = new f(mVar.IN());
                mVar.getListView().setRecyclerListener(this.aJb);
            }
        }
        setOrientation(1);
        setOnHierarchyChangeListener(new t(this));
    }

    public void setText(com.baidu.tbadk.widget.richText.a aVar) {
        a(aVar, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x001c */
    public void a(com.baidu.tbadk.widget.richText.a aVar, boolean z) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Im;
        int i;
        boolean z2;
        SpannableStringBuilder Is;
        View a2;
        if (this.aJl != aVar) {
            this.aJl = aVar;
            removeAllViews();
            if (aVar != null && (Im = aVar.Im()) != null) {
                Iterator<com.baidu.tbadk.widget.richText.c> it = Im.iterator();
                int i2 = 0;
                View view = null;
                View view2 = null;
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView an = an(getContext());
                            boolean a3 = a(next, an, true);
                            if (z && !this.aJj && (Is = next.Is()) != null) {
                                this.aJj = Is.length() >= 200;
                            }
                            i = i2;
                            view2 = an;
                            z2 = a3;
                        } else if (next.getType() == 8) {
                            if (i2 < 10) {
                                ImageView am = am(getContext());
                                z2 = b(next, am, (this.aIU - getPaddingLeft()) - getPaddingRight(), this.aIV);
                                i = i2 + 1;
                                view2 = am;
                            }
                        } else if (next.getType() == 32) {
                            n Iv = next.Iv();
                            if (Iv != null && Iv.IV()) {
                                a2 = b(Iv);
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
                            ImageView am2 = am(getContext());
                            z2 = a(next, am2, (this.aIU - getPaddingLeft()) - getPaddingRight(), this.aIV);
                            i = i2 + 1;
                            view2 = am2;
                        } else {
                            if (next.getType() == 1536) {
                                com.baidu.tbadk.widget.richText.f IA = next.IA();
                                IA.fx(aVar.Il());
                                if (IA != null) {
                                    View a4 = a(IA, aVar.Il(), aVar.getAuthorId());
                                    z2 = true;
                                    i = i2;
                                    view2 = a4;
                                }
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
                    layoutParams.bottomMargin = this.aIP;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private View b(n nVar) {
        if (nVar == null || !nVar.isAvaliable()) {
            return null;
        }
        ImageView hp = this.aIH.hp();
        if (hp instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) hp;
            foreDrawableImageView.setForegroundDrawable(t.f.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(t.d.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            a(foreDrawableImageView, nVar.getWidth(), nVar.getHeight(), (this.aIU - getPaddingLeft()) - getPaddingRight(), this.aIV, new u(this, nVar));
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.aJn);
            if (com.baidu.tbadk.core.l.qE().qK()) {
                foreDrawableImageView.setDefaultBgResource(t.f.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(t.d.cp_bg_line_c);
            }
            foreDrawableImageView.c(nVar.rV(), 17, false);
            return hp;
        }
        return hp;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ImageView imageView, int i, int i2, int i3, int i4, View.OnClickListener onClickListener) {
        int[] b2 = com.baidu.adp.lib.util.k.b(i, i2, i3, i4);
        if (b2 == null) {
            return false;
        }
        int[] iArr = {b2[0], b2[1]};
        if (!this.aJe) {
            iArr[0] = i3;
            iArr[1] = aIG;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.aIX);
            if (tbImageView.getGifIconWidth() >= iArr[0] || tbImageView.getGifIconHeight() >= iArr[1]) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.aJo && i3 > i5) {
            float D = com.baidu.adp.lib.util.k.D(getContext());
            if (D > 1.0f) {
                if (i5 * D <= i3) {
                    i3 = (int) (i5 * D);
                }
                if (iArr[0] > 0) {
                    i6 = (iArr[1] * i3) / iArr[0];
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i6);
                layoutParams.topMargin = this.aIP;
                if (!this.aJo) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else if (this.aIW == null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    imageView.setScaleType(this.aIW);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                imageView.setOnClickListener(onClickListener);
                imageView.setLayoutParams(layoutParams);
                return true;
            }
        }
        i3 = i5;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i6);
        layoutParams2.topMargin = this.aIP;
        if (!this.aJo) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        return true;
    }

    private LinearLayout a(com.baidu.tbadk.widget.richText.c cVar) {
        if (this.aIY <= 0 || cVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.aIP;
        linearLayout.setClickable(true);
        Bitmap cR = at.cR(this.aIY);
        if (cR != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), cR));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new v(this, cVar));
        return linearLayout;
    }

    public int getVideoImageId() {
        return this.aIY;
    }

    public void setVideoImageId(int i) {
        this.aIY = i;
    }

    private ImageView am(Context context) {
        ImageView hp = this.aIH != null ? this.aIH.hp() : null;
        if (hp == null || hp.getParent() != null) {
            hp = null;
        }
        if (hp != null) {
            hp.setContentDescription(context.getString(t.j.log_msg_pic));
        }
        return hp;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        l Iy = cVar.Iy();
        if (Iy != null && Iy.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.aJn) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.c(Iy.IM(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new b(Iy.getLink()));
                if (!Iy.IF()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return a(imageView, Iy.getWidth(), Iy.getHeight(), i, i2, this.aJs);
        }
        return false;
    }

    private boolean b(com.baidu.tbadk.widget.richText.c cVar, ImageView imageView, int i, int i2) {
        if (cVar == null || imageView == null) {
            return false;
        }
        g Ir = cVar.Ir();
        if (Ir == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (this.aJn) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.c(Ir.IE(), this.mIsFromCDN ? 17 : 18, false);
            if (!Ir.IF()) {
                tbImageView.setAdjustViewBounds(false);
            }
        }
        return a(imageView, Ir.getWidth(), Ir.getHeight(), i, i2, this.mOnClickListener);
    }

    public void setImageViewStretch(boolean z) {
        this.aJo = z;
    }

    private TextView an(Context context) {
        TextView textView = null;
        if (this.aII != null) {
            textView = this.aII.hp();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.aIO, 0, this.aIO, 0);
        return textView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, TextView textView, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.topMargin = this.aIP;
        textView.setLineSpacing(0.0f, this.aIN);
        textView.setTextSize(0, this.aIQ);
        textView.setTextColor(this.mTextColor);
        textView.setLinkTextColor(this.aIT);
        textView.setSingleLine(this.aIZ);
        if (this.aJa != null) {
            textView.setEllipsize(this.aJa);
        }
        if (this.Ca > 0) {
            textView.setMaxWidth(this.Ca);
        }
        if (this.aJp > 0) {
            textView.setMaxLines(this.aJp);
        }
        if (cVar == null) {
            return false;
        }
        SpannableStringBuilder Is = cVar.Is();
        if (Is == null || Is.length() <= 0) {
            return false;
        }
        int lineHeight = textView.getLineHeight();
        int textSize = lineHeight - ((int) textView.getTextSize());
        if (this.aIS > 0 && this.aIR > 0) {
            cVar.H(this.aIR, this.aIS);
        }
        if (textSize > 0) {
            cVar.G(lineHeight, textSize);
        }
        try {
            textView.setText(Is);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.aJq) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(cVar);
        textView.setHighlightColor(0);
        if (cVar != null && cVar.Iu() != null) {
            cVar.Iu().aIo = this.aJu;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.aIM != null) {
            gifView = this.aIM.hp();
        }
        if (gifView == null || gifView.getParent() != null) {
            return new GifView(getContext());
        }
        return gifView;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != cVar.Iw().axx.axb || layoutParams.height != cVar.Iw().axx.axc) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.Iw().axx.axb, cVar.Iw().axx.axc);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new w(this, cVar));
        gifView.a(cVar.Iw().axx);
        return true;
    }

    private View getVoiceView() {
        View hp = this.aIK != null ? this.aIK.hp() : null;
        if ((hp == null || hp.getParent() != null) && this.aJf != -1) {
            hp = LayoutInflater.from(getContext()).inflate(this.aJf, (ViewGroup) null);
        }
        if (hp != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.aIP;
            layoutParams.bottomMargin = this.aIP;
            hp.setLayoutParams(layoutParams);
            return hp;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private View a(com.baidu.tbadk.widget.richText.f fVar, int i, String str) {
        com.baidu.tieba.graffiti.e eVar = null;
        if (this.aIJ != null) {
            eVar = this.aIJ.hp();
        }
        if (eVar == null || eVar.getParent() != null) {
            eVar = new com.baidu.tieba.graffiti.e(getContext());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.aIP;
        layoutParams.bottomMargin = this.aIP;
        eVar.setLayoutParams(layoutParams);
        if (eVar instanceof com.baidu.tieba.graffiti.e) {
            com.baidu.tieba.graffiti.e eVar2 = eVar;
            eVar2.h(this.aJe, false);
            if (eVar2.getGraffitiImageView() != null) {
                eVar2.getGraffitiImageView().setSupportNoImage(this.aJn);
                eVar2.getGraffitiImageView().setDefaultResource(this.aIX);
            }
            if (eVar2.getSaveBtn() != null) {
                eVar2.getSaveBtn().setOnTouchListener(this.aJt);
            }
            eVar2.a(fVar, i, str, this.aIU - (getPaddingLeft() + getPaddingRight()), getPaddingRight());
        }
        return eVar;
    }

    private boolean a(com.baidu.tbadk.widget.richText.c cVar, View view) {
        view.setTag(cVar.It());
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout hp = this.aIL.hp();
        if (hp != null) {
            TextView an = an(getContext());
            if (an == null) {
                this.aIL.k(hp);
                return null;
            }
            hp.addView(an);
            View voiceView = getVoiceView();
            if (voiceView == null) {
                this.aII.k(an);
                this.aIL.k(hp);
                return null;
            }
            hp.addView(voiceView);
            return hp;
        }
        return hp;
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
        if (applyDimension != this.aIQ) {
            this.aIQ = applyDimension;
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
        if (this.aIO != i) {
            this.aIO = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.aIO, 0, 0, this.aIO);
                }
            }
        }
    }

    public void setLinkTextColor(int i) {
        if (i != this.aIT) {
            this.aIT = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i);
                }
            }
        }
    }

    public int getMaxImageWidth() {
        return this.aIU;
    }

    public void setMaxImageWidth(int i) {
        this.aIU = i;
    }

    public int getMaxImageHeight() {
        return this.aIV;
    }

    public void setMaxImageHeight(int i) {
        this.aIV = i;
    }

    public ImageView.ScaleType getScaleType() {
        return this.aIW;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.aIW = scaleType;
    }

    public int getDefaultImageId() {
        return this.aIX;
    }

    public void setDefaultImageId(int i) {
        this.aIX = i;
    }

    public d getOnImageClickListener() {
        return this.aJc;
    }

    public void setOnImageClickListener(d dVar) {
        this.aJc = dVar;
    }

    public void setOnEmotionClickListener(c cVar) {
        this.aJk = cVar;
    }

    public void h(boolean z, boolean z2) {
        if (this.aJe != z) {
            this.aJe = z;
            if (z2) {
                requestLayout();
            }
            if (!this.aJe && this.aIH != null) {
                this.aIH.clear();
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
        this.aJg = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.aJh) {
                    Ja();
                    break;
                } else if (!this.aJr) {
                    motionEvent.setAction(3);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.aJg) {
                    IZ();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.aJg = true;
        return super.onTouchEvent(motionEvent);
    }

    private void IZ() {
        this.aJh = false;
        if (this.aJi == null) {
            this.aJi = new a();
        }
        postDelayed(this.aJi, ViewConfiguration.getLongPressTimeout());
    }

    private void Ja() {
        if (this.aJi != null) {
            removeCallbacks(this.aJi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.aJr && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.aJh = true;
            }
        }
    }

    public void setVoiceViewRes(int i) {
        this.aJf = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        this.aJm = null;
        if (this.aJv != drawable) {
            this.aJu = true;
            this.aJv = drawable;
        }
        setText(this.aJl);
        this.aJu = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EL();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        EL();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            EL();
        } else {
            refresh();
        }
    }

    public void gu(String str) {
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
        if (!(str.equals(this.mUrl) && this.axz == bdUniqueId)) {
            EL();
        }
        this.mUrl = str;
        this.axz = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.g.c.hr().a(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            e(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.g.c.hr().ah(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.g.c.hr().a(this.mUrl, 19, this.aDE, 0, 0, this.axz, new Object[0]);
        }
    }

    public void EL() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.g.c.hr().a(this.mUrl, 19, this.aDE);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.mK(), aVar.mK().getNinePatchChunk(), aVar.mO(), null);
                if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.a.i
    public void refresh() {
        gu(this.mUrl);
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
        return this.aJd;
    }

    public void setOnLinkImageClickListener(e eVar) {
        this.aJd = eVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.aJq = z;
    }
}
