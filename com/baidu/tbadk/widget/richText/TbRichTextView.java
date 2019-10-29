package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.ImageView.h {
    private static final float cVK = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private int bjK;
    private final com.baidu.tieba.pb.a.c cQw;
    private int cUC;
    private h cUE;
    private com.baidu.adp.lib.e.b<ImageView> cUv;
    private com.baidu.adp.lib.e.b<GifView> cUw;
    private com.baidu.tbadk.widget.richText.a cUx;
    private e cXA;
    public final View.OnClickListener cXB;
    private final f cXC;
    private boolean cXD;
    private Drawable cXE;
    private CustomMessageListener cXF;
    private com.baidu.adp.lib.e.b<TextView> cXc;
    private com.baidu.adp.lib.e.b<View> cXd;
    private com.baidu.adp.lib.e.b<LinearLayout> cXe;
    private com.baidu.adp.lib.e.b<RelativeLayout> cXf;
    private GridImageLayout cXg;
    private boolean cXh;
    private TextUtils.TruncateAt cXi;
    private j cXj;
    private i cXk;
    private View.OnClickListener cXl;
    private boolean cXm;
    private int cXn;
    private View.OnClickListener cXo;
    private boolean cXp;
    private boolean cXq;
    private Runnable cXr;
    private boolean cXs;
    private g cXt;
    private TbRichText cXu;
    private boolean cXv;
    private boolean cXw;
    private boolean cXx;
    private boolean cXy;
    private boolean cXz;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cit;
    private com.baidu.tieba.pb.a.c czv;
    private boolean isHost;
    private boolean mIsFromCDN;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private final int mType;
    private String mUrl;
    private View.OnLongClickListener onLongClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface e {
        void aAd();
    }

    /* loaded from: classes.dex */
    public interface f {
        void x(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface i {
        void e(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.cXx = z;
        azZ();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.cXg != null) {
            this.cXg.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.cXz = z;
    }

    public boolean azY() {
        return this.cXs;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.cUx != null) {
            this.cUx.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.bjK = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.cXi = truncateAt;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        public String url;

        public d(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bj(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).cXJ;
            }
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof d) {
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

    public static TbRichText a(Context context, JSONArray jSONArray, int i2) {
        return new TbRichText(context, jSONArray, i2);
    }

    public static TbRichText a(Context context, JSONArray jSONArray, boolean z) {
        return new TbRichText(context, jSONArray, z);
    }

    public static TbRichText a(Context context, List<PbContent> list, boolean z) {
        return new TbRichText(context, list, z);
    }

    public static com.baidu.adp.lib.e.b<TextView> q(final Context context, int i2) {
        return new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aAc */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(TextView textView) {
                textView.setText((CharSequence) null);
                textView.setTag(null);
                textView.setSingleLine(false);
                textView.setEllipsize(null);
                textView.setBackgroundResource(0);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setTextColor(0);
                textView.setGravity(3);
                textView.setOnClickListener(null);
                textView.setOnTouchListener(null);
                if (textView instanceof TbListTextView) {
                    ((TbListTextView) textView).setCheckSelection(true);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public TextView passivateObject(TextView textView) {
                textView.setText((CharSequence) null);
                textView.setTag(null);
                textView.setSingleLine(false);
                textView.setEllipsize(null);
                textView.setBackgroundResource(0);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setTextColor(0);
                textView.setGravity(3);
                textView.setOnClickListener(null);
                textView.setOnTouchListener(null);
                if (textView instanceof TbListTextView) {
                    ((TbListTextView) textView).setCheckSelection(true);
                }
                return textView;
            }
        }, i2, 0);
    }

    public TbRichTextView(Context context) {
        super(context);
        this.cUx = new com.baidu.tbadk.widget.richText.a();
        this.cUv = null;
        this.cXc = null;
        this.cXd = null;
        this.cXe = null;
        this.cXf = null;
        this.cUw = null;
        this.cXh = true;
        this.cXi = null;
        this.cXj = null;
        this.cUE = null;
        this.czv = null;
        this.cXk = null;
        this.cXl = null;
        this.cXm = true;
        this.mIsFromCDN = true;
        this.cXn = -1;
        this.cXp = false;
        this.cXq = false;
        this.cXr = null;
        this.cXs = false;
        this.cXv = false;
        this.mMaxWidth = -1;
        this.bjK = -1;
        this.cXw = true;
        this.cXx = false;
        this.isHost = false;
        this.cXy = false;
        this.cXz = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cUE != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cUE.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        for (int i4 = 0; i4 < childCount2; i4++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i4)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cUE.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bj(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cUE.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.cQw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.czv != null) {
                    TbRichTextView.this.czv.N(view);
                    return TbRichTextView.this.czv.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.cXB = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cXk != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cXk.e(view, str);
                }
            }
        };
        this.cXC = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cXy = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cXy = false;
                }
            }
        };
        this.mType = 19;
        this.cit = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.h(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.cXF = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cXx ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cXu != null && !v.isEmpty(TbRichTextView.this.cXu.azh())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cXu.azh().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.ay(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
    }

    public TbRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUx = new com.baidu.tbadk.widget.richText.a();
        this.cUv = null;
        this.cXc = null;
        this.cXd = null;
        this.cXe = null;
        this.cXf = null;
        this.cUw = null;
        this.cXh = true;
        this.cXi = null;
        this.cXj = null;
        this.cUE = null;
        this.czv = null;
        this.cXk = null;
        this.cXl = null;
        this.cXm = true;
        this.mIsFromCDN = true;
        this.cXn = -1;
        this.cXp = false;
        this.cXq = false;
        this.cXr = null;
        this.cXs = false;
        this.cXv = false;
        this.mMaxWidth = -1;
        this.bjK = -1;
        this.cXw = true;
        this.cXx = false;
        this.isHost = false;
        this.cXy = false;
        this.cXz = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cUE != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cUE.a(view, null, i2, TbRichTextView.this.isHost, false);
                        return;
                    }
                    if (tag != null && (tag instanceof String)) {
                        str2 = (String) tag;
                    } else if ((view instanceof TbImageView) && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            str = tbRichTextMemeInfo.memeInfo.pic_url;
                        } else {
                            str = "";
                        }
                        int childCount2 = TbRichTextView.this.getChildCount();
                        for (int i4 = 0; i4 < childCount2; i4++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i4)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cUE.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bj(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.cUE.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.cQw = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.czv != null) {
                    TbRichTextView.this.czv.N(view);
                    return TbRichTextView.this.czv.onDoubleTap(motionEvent);
                }
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
                return false;
            }

            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.mOnClickListener != null) {
                    TbRichTextView.this.mOnClickListener.onClick(view);
                    return true;
                }
                return false;
            }
        });
        this.cXB = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cXk != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cXk.e(view, str);
                }
            }
        };
        this.cXC = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cXy = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cXy = false;
                }
            }
        };
        this.mType = 19;
        this.cit = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.h(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.cXF = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cXx ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cXu != null && !v.isEmpty(TbRichTextView.this.cXu.azh())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cXu.azh().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.ay(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.cUx.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        azZ();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.cUx;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.cUx.release();
            this.cUx = aVar;
            azZ();
            if (this.cXg != null) {
                this.cXg.setLayoutStrategy(this.cUx);
            }
        }
    }

    private void azZ() {
        int contentSizeOfLzl = this.cXx ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.cUx.cVP = contentSizeOfLzl;
        this.cUx.cVO = contentSizeOfLzl;
    }

    private void init() {
        com.baidu.tbadk.widget.richText.e eVar = null;
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.e) {
            eVar = (com.baidu.tbadk.widget.richText.e) getContext();
        } else if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
            eVar = (com.baidu.tbadk.widget.richText.e) ab.getOrignalPage();
        }
        if (ab != null) {
            ab.registerListener(this.cXF);
        }
        if (eVar != null) {
            this.cUv = eVar.azQ();
            this.cXc = eVar.azR();
            this.cXd = eVar.azT();
            this.cXe = eVar.azU();
            this.cUw = eVar.azS();
            this.cXf = eVar.azV();
            if (eVar.getListView() != null && this.cXj == null) {
                this.cXj = new j(eVar.azP());
                eVar.getListView().setRecyclerListener(this.cXj);
            }
        }
        this.cUC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.cUw != null) {
                    TbRichTextView.this.cUw.returnObject((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.cUv != null) {
                    TbRichTextView.this.cUv.returnObject((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.cXc != null) {
                    TbRichTextView.this.cXc.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.cXd != null) {
                    TbRichTextView.this.cXd.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cXd != null) {
                    TbRichTextView.this.cXd.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.cUw != null) {
                            TbRichTextView.this.cUw.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.cUv != null) {
                            TbRichTextView.this.cUv.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.cXf != null) {
                    TbRichTextView.this.cXf.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.cXe != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.cXc != null) {
                                        TbRichTextView.this.cXc.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.cXd != null) {
                                        TbRichTextView.this.cXd.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cXd != null) {
                                        TbRichTextView.this.cXd.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.cXe.returnObject((LinearLayout) view2);
                            return;
                        }
                        return;
                    }
                    view2.setBackgroundDrawable(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }
        });
    }

    public void setText(TbRichText tbRichText) {
        setText(tbRichText, false);
    }

    public void setText(TbRichText tbRichText, boolean z) {
        setText(tbRichText, z, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r3v38, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r4v11 */
    public void setText(TbRichText tbRichText, boolean z, c cVar) {
        ArrayList<TbRichTextData> azh;
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        boolean z2;
        SpannableStringBuilder azq;
        boolean z3;
        View view;
        KeyEvent.Callback a2;
        boolean z4;
        int i4;
        int i5;
        if (this.cXu != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.cXu = tbRichText;
            removeAllViews();
            if (tbRichText != null && (azh = tbRichText.azh()) != null) {
                View view2 = null;
                boolean z5 = true;
                Iterator<TbRichTextData> it = azh.iterator();
                boolean z6 = false;
                int i6 = 0;
                int i7 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z7 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView cE = cE(getContext());
                            boolean a3 = a(next, cE, true, cVar);
                            if (z && !this.cXs && (azq = next.azq()) != null) {
                                this.cXs = azq.length() >= 200;
                            }
                            if (this.czv != null) {
                                cE.setOnTouchListener(this.cQw);
                            } else {
                                cE.setOnClickListener(this.cXl);
                            }
                            z7 = a3;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = cE;
                            z2 = z6;
                        } else if (next.getType() == 8) {
                            if (!this.cXz) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.azp() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.azp().azI()) {
                                            GifView gifView = getGifView();
                                            b bVar = new b();
                                            bVar.cXJ = true;
                                            gifView.setTag(bVar);
                                            z7 = b(next, gifView);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = gifView;
                                        } else {
                                            ?? cD = cD(getContext());
                                            z7 = c(next, cD, this.cUx.cVQ, this.cUx.cVR);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = cD;
                                        }
                                    }
                                    z2 = z6;
                                    i2 = i7;
                                    i3 = i6;
                                    relativeLayout = view3;
                                }
                            } else if (!z6) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.azj());
                                z7 = true;
                                z2 = true;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f azt = next.azt();
                            if (azt != null && azt.azX()) {
                                a2 = b(azt);
                            } else {
                                a2 = a(next);
                            }
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = a2;
                            z7 = true;
                        } else if (next.getType() == 512) {
                            View bk = bk(view2);
                            if (bk == null) {
                                view3 = bk;
                            } else {
                                z2 = z6;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = bk;
                                z7 = a(next, bk);
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z7 = a(next, (LinearLayout) textVoiceView, cVar);
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView2 = getGifView();
                            z7 = a(next, gifView2);
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = gifView2;
                        } else if (next.getType() == 20) {
                            if (i7 < 10) {
                                int i8 = i7 + 1;
                                if (next == null || next.azv() == null || next.azv().memeInfo == null || StringUtils.isNull(next.azv().memeInfo.pic_url)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (z4) {
                                    RelativeLayout borrowObject = this.cXf.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.azv().memeInfo.width.intValue(), next.azv().memeInfo.height.intValue()));
                                    if (com.baidu.tbadk.t.v.axj() && this.cXh) {
                                        b(borrowObject, next.azv().memeInfo.width.intValue(), next.azv().memeInfo.height.intValue(), this.cUx.cVQ, this.cUx.cVR);
                                    } else {
                                        a(borrowObject, next.azv().memeInfo.width.intValue(), next.azv().memeInfo.height.intValue(), this.cUx.cVQ, this.cUx.cVR);
                                    }
                                    ImageView borrowObject2 = this.cUv.borrowObject();
                                    b(next, borrowObject2, this.cUx.cVQ, this.cUx.cVR);
                                    if (com.baidu.tbadk.t.v.axj() && this.cXh) {
                                        ImageView borrowObject3 = this.cUv.borrowObject();
                                        borrowObject3.setTag(this.cXu);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.cUC);
                                            tbImageView.setAdjustViewBounds(false);
                                            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.azv().memeInfo.width.intValue(), next.azv().memeInfo.height.intValue(), this.cUx.cVQ, this.cUx.cVR, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.azv().memeInfo.height.intValue()) {
                                            i5 = dimens / 2;
                                            i4 = dimens2 / 2;
                                        } else {
                                            i4 = dimens2;
                                            i5 = dimens;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i4);
                                        layoutParams.addRule(8, R.id.meme_image_view);
                                        layoutParams.addRule(11);
                                        borrowObject3.setOnClickListener(this.mOnClickListener);
                                        if (borrowObject.getLeft() > 0) {
                                            layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds6);
                                        }
                                        am.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.azv().memeInfo.width.intValue(), next.azv().memeInfo.height.intValue(), this.cUx.cVQ, this.cUx.cVR, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                    }
                                    z7 = z4;
                                    z2 = z6;
                                    i2 = i8;
                                    i3 = i6;
                                    relativeLayout = borrowObject;
                                } else {
                                    z7 = z4;
                                    z2 = z6;
                                    i2 = i8;
                                    i3 = i6;
                                    relativeLayout = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView cD2 = cD(getContext());
                                z7 = a(next, cD2, (this.cUx.cVQ - getPaddingLeft()) - getPaddingRight(), this.cUx.cVR);
                                z2 = z6;
                                i2 = i7;
                                i3 = i6 + 1;
                                relativeLayout = cD2;
                            }
                            z2 = z6;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = view3;
                        }
                        if (!z7 || relativeLayout == null) {
                            z3 = z5;
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z5 && this.cUx.cWg >= 0) {
                                z5 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.cUx.cWg;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z3 = false;
                                    view = relativeLayout;
                                }
                                z3 = z5;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.cUx.cWc;
                                } else {
                                    layoutParams2.topMargin = this.cUx.cVN;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z3 = z5;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.cUx.cWa;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.cUx.cVZ;
                                    } else {
                                        layoutParams2.topMargin = this.cUx.cVN;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                }
                                z3 = z5;
                                view = relativeLayout;
                            }
                        }
                        z6 = z2;
                        z5 = z3;
                        i6 = i3;
                        view2 = view;
                        view3 = relativeLayout;
                        i7 = i2;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.cUx.cWf;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.cUx.cWe >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.cUx.cWe;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.cXg == null || this.cXg.getParent() != null) {
            this.cXg = new GridImageLayout(getContext());
            this.cXg.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.cXg.setLayoutStrategy(this.cUx);
        this.cXg.setObjectPool(this.cUv, this.cUw);
        this.cXg.setOnImageClickListener(this.cUE);
        this.cXg.setIsHost(this.isHost);
        return this.cXg;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.cXl = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.cUv.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.cUx.cVQ - getPaddingLeft()) - getPaddingRight(), this.cUx.cVR, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.cUx.cVX);
            if (com.baidu.tbadk.core.i.agq().isShowImages()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(fVar.getThumbUrl(), 17, false);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] q = this.cUx.q(i2, i3, i4, i5);
        if (q == null) {
            return false;
        }
        int i6 = q[0];
        int i7 = q[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cUx.cVS);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.cUx.cVY) {
            imageView.setScaleType(this.cUx.cVW);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.cUx.Id);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.czv != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.cQw);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cXC);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.cXC);
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    private boolean b(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize == null) {
            return false;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (!this.cUx.cVY || i4 <= i7 || cVK <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * cVK <= i4) {
                if (i7 * cVK > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * cVK);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cUx.cVS);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.cUx.cVY) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.czv != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.cQw);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cXC);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int i7;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize == null) {
            return false;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.cUx.cVY && i4 > i8 && cVK > 1.0f) {
            if (i8 * cVK > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * cVK > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * cVK);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.cUx.cVS);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.cUx.cVY) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.czv == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.cQw);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.cXC);
                        imageView.setOnLongClickListener(this.onLongClickListener);
                    }
                } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
                    imageView.setOnLongClickListener(this.onLongClickListener);
                }
                return true;
            }
        }
        i6 = i9;
        i7 = i8;
        if (imageView instanceof TbImageView) {
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i7, i6);
        if (!this.cUx.cVY) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.czv == null) {
        }
        imageView.setOnClickListener(onClickListener);
        imageView.setLayoutParams(layoutParams2);
        if (!(imageView instanceof TbImageView)) {
        }
        return true;
    }

    private void a(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize != null) {
            int[] iArr = {imageResize[0], imageResize[1]};
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (!this.cUx.cVY || i4 <= i6 || cVK <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * cVK <= i4) {
                    if (i6 * cVK > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * cVK);
                    }
                }
                if (iArr[0] > 0) {
                    i7 = (iArr[1] * i4) / iArr[0];
                }
            }
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i7));
        }
    }

    private void b(RelativeLayout relativeLayout, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize != null) {
            int[] iArr = {imageResize[0], imageResize[1]};
            int i8 = iArr[0];
            int i9 = iArr[1];
            if (this.cUx.cVY && i4 > i8 && cVK > 1.0f) {
                if (i8 * cVK > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * cVK > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * cVK);
                }
                if (iArr[0] > 0) {
                    i6 = (i7 * iArr[1]) / iArr[0];
                    relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i6));
                }
            }
            i6 = i9;
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(i4, i6));
        }
    }

    private LinearLayout a(final TbRichTextData tbRichTextData) {
        if (this.cUx.cVT <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.cUx.cVN;
        linearLayout.setClickable(true);
        Bitmap bitmap = am.getBitmap(this.cUx.cVT);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.azq() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).aj(TbRichTextView.this.getContext(), tbRichTextData.azq().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ab.getOrignalPage()).aj(TbRichTextView.this.getContext(), tbRichTextData.azq().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView cD(Context context) {
        ImageView borrowObject = this.cUv != null ? this.cUv.borrowObject() : null;
        if (borrowObject == null || borrowObject.getParent() != null) {
            borrowObject = null;
        }
        if (borrowObject != null) {
            borrowObject.setContentDescription(context.getString(R.string.editor_image));
        }
        return borrowObject;
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        TbRichTextLinkImageInfo azx = tbRichTextData.azx();
        if (azx != null && azx.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.cUx.cVX) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(azx.azO(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(azx.getLink()));
                if (!azx.azF()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, azx.getWidth(), azx.getHeight(), i2, i3, this.cXB);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.azv() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cUC);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            if (this.cUx.cVX) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.azv().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.azv());
        }
        return b(imageView, tbRichTextData.azv().memeInfo.width.intValue(), tbRichTextData.azv().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.azp() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.cUC);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            if (this.cUx.cVX) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(this.cUx.azg() ? tbRichTextData.azp().azA() : tbRichTextData.azp().azD(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.azp().azF()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.azp().getWidth(), tbRichTextData.azp().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView cE(Context context) {
        TextView textView = null;
        if (this.cXc != null) {
            textView = this.cXc.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.cUx.cnq, 0, this.cUx.cnq, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.cXv) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.cUx.cVN;
        }
        textView.setLineSpacing(this.cUx.cVM, this.cUx.cVL);
        textView.setTextSize(0, this.cUx.ath);
        textView.setTextColor(this.cUx.mTextColor);
        textView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.cUx.cVU);
        if (this.cXi != null) {
            textView.setEllipsize(this.cXi);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.bjK > 0) {
            textView.setMaxLines(this.bjK);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder azq = tbRichTextData.azq();
        if (azq == null || azq.length() <= 0) {
            return false;
        }
        if (this.cUx.cVP > 0 && this.cUx.cVO > 0) {
            tbRichTextData.ay(this.cUx.cVO, this.cUx.cVP);
        }
        if (cVar != null) {
            cVar.a(azq, textView, this);
        }
        try {
            textView.setText(azq);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.cXw) {
            if (tbRichTextData.azz()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.cwP());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.azs() != null) {
            tbRichTextData.azs().needRecompute = this.cXD;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.cUw != null) {
            gifView = this.cUw.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(am.getColor(R.color.black_alpha8));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.cUC);
        gifView2.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            gifView2.setLayoutParams(layoutParams);
        }
        return gifView2;
    }

    private boolean a(final TbRichTextData tbRichTextData, GifView gifView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gifView.getLayoutParams();
        if (layoutParams == null || layoutParams.width != tbRichTextData.azu().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.azu().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.azu().mGifInfo.mGifWidth, tbRichTextData.azu().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.cXt != null) {
                    TbRichTextEmotionInfo azu = tbRichTextData.azu();
                    TbRichTextView.this.cXt.a(view, azu.mGifInfo.mGid, azu.mGifInfo.mPackageName, azu.mGifInfo.mIcon, azu.mGifInfo.mStaticUrl, azu.mGifInfo.mDynamicUrl, azu.mGifInfo.mSharpText, azu.mGifInfo.mGifWidth, azu.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.azu().mGifInfo);
        return true;
    }

    private boolean b(TbRichTextData tbRichTextData, GifView gifView) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(am.b(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = am.getDrawable(com.baidu.tbadk.util.e.Vl());
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(am.getDrawable(R.color.common_color_10220));
        }
        String azE = tbRichTextData.azp().azE();
        if (StringUtils.isNull(azE)) {
            if (this.cUx.cWh) {
                azE = this.cUx.mIsFromCDN ? tbRichTextData.azp().azA() : tbRichTextData.azp().azC();
            }
            if (StringUtils.isNull(azE)) {
                azE = this.cUx.mIsFromCDN ? tbRichTextData.azp().azD() : tbRichTextData.azp().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        gifView.T(azE, 38);
        return a(gifView, tbRichTextData.azp().getWidth(), tbRichTextData.azp().getHeight(), this.cUx.cVQ, this.cUx.cVR, this.mOnClickListener);
    }

    private View bk(View view) {
        View borrowObject = this.cXd != null ? this.cXd.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.cXn != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.cXn, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.cUx.cWb >= 0) {
                layoutParams.topMargin = this.cUx.cWb;
            } else {
                layoutParams.topMargin = this.cUx.cVN;
            }
            layoutParams.bottomMargin = this.cUx.cWd;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.cXo);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.azr());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.cXe.borrowObject();
        if (borrowObject != null) {
            TextView cE = cE(getContext());
            if (cE == null) {
                this.cXe.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(cE);
            View bk = bk(null);
            if (bk == null) {
                this.cXc.returnObject(cE);
                this.cXe.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(bk);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(TbRichTextData tbRichTextData, LinearLayout linearLayout, c cVar) {
        boolean a2;
        boolean z = true;
        if (linearLayout == null) {
            return false;
        }
        int childCount = linearLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt == null) {
                a2 = z;
            } else if (childAt instanceof TextView) {
                a2 = a(tbRichTextData, (TextView) childAt, false, cVar) & z;
            } else if (childAt.getClass().getSimpleName().equals("PlayVoiceBnt")) {
                a2 = a(tbRichTextData, childAt) & z;
            } else {
                a2 = childAt.getClass().getSimpleName().equals("PlayVoiceBntNew") ? a(tbRichTextData, childAt) & z : z;
            }
            i2++;
            z = a2;
        }
        return z;
    }

    public void setTextSize(float f2) {
        if (f2 != this.cUx.ath) {
            this.cUx.ath = f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
                }
            }
        }
    }

    public void setTextColor(int i2) {
        if (i2 != this.cUx.mTextColor) {
            this.cUx.mTextColor = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setTextColor(i2);
                }
            }
        }
    }

    public void setTextPadding(int i2) {
        if (this.cUx.cnq != i2) {
            this.cUx.cnq = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.cUx.cnq, 0, 0, this.cUx.cnq);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.cUx.cVV) {
            this.cUx.cVV = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setLinkTextColor(i2);
                }
            }
        }
    }

    public void setDuiEnabled(boolean z) {
        this.cXh = z;
    }

    public h getOnImageClickListener() {
        return this.cUE;
    }

    public void setOnImageClickListener(h hVar) {
        this.cUE = hVar;
        if (this.cXg != null) {
            this.cXg.setOnImageClickListener(this.cUE);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.czv = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.cXt = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.cXm != z) {
            this.cXm = z;
            if (z2) {
                requestLayout();
            }
            if (!this.cXm && this.cUv != null) {
                this.cUv.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j implements AbsListView.RecyclerListener {
        private int mId;

        public j(int i) {
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
        this.cXp = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.cXq) {
                    aAb();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.cXp) {
                    aAa();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cXq && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cXp = true;
        return super.onTouchEvent(motionEvent);
    }

    private void aAa() {
        this.cXq = false;
        if (this.cXr == null) {
            this.cXr = new a();
        }
        postDelayed(this.cXr, ViewConfiguration.getLongPressTimeout());
    }

    private void aAb() {
        if (this.cXr != null) {
            removeCallbacks(this.cXr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.cXy && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.cXq = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.cXn = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.cXo = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.cXE != drawable) {
            this.cXD = true;
            this.cXE = drawable;
        }
        setText(this.cXu);
        this.cXD = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cUx != null) {
            this.cUx.release();
        }
        stopLoad();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        stopLoad();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8 || i2 == 4) {
            stopLoad();
        } else {
            refresh();
        }
    }

    public void a(String str, e eVar) {
        this.cXA = eVar;
        qx(str);
    }

    public void qx(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h Z = com.baidu.adp.base.i.Z(getContext());
        if (Z != null) {
            bdUniqueId = Z.getUniqueId();
            z = Z.isScroll();
        } else {
            bdUniqueId = null;
            z = false;
        }
        if (!(str.equals(this.mUrl) && this.mPageId == bdUniqueId)) {
            stopLoad();
        }
        this.mUrl = str;
        this.mPageId = bdUniqueId;
        setBackgroundDrawable(null);
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fT().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            h(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.f.c.fT().M(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.f.c.fT().a(this.mUrl, 19, this.cit, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fT().a(this.mUrl, 19, this.cit);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.cXA != null) {
                    this.cXA.aAd();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        qx(this.mUrl);
    }

    public void setTextViewOnClickListener(View.OnClickListener onClickListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnClickListener(onClickListener);
            }
        }
    }

    public void setTextViewCheckSelection(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setCheckSelection(z);
            }
        }
    }

    public void setTextViewOnTouchListener(View.OnTouchListener onTouchListener) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                ((TbListTextView) childAt).setOnTouchListener(onTouchListener);
            }
        }
    }

    public TextView getTextView() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TbListTextView) {
                return (TbListTextView) childAt;
            }
        }
        return null;
    }

    public i getOnLinkImageClickListener() {
        return this.cXk;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.cXk = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.cXw = z;
    }

    public void setTextCenter(boolean z) {
        this.cXv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean cXJ;

        private b() {
        }
    }
}
