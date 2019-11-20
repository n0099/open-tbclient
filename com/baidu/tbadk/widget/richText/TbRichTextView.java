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
    private static final float cUT = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private int bjs;
    private final com.baidu.tieba.pb.a.c cPF;
    private com.baidu.adp.lib.e.b<ImageView> cTE;
    private com.baidu.adp.lib.e.b<GifView> cTF;
    private com.baidu.tbadk.widget.richText.a cTG;
    private int cTL;
    private h cTN;
    private Runnable cWA;
    private boolean cWB;
    private g cWC;
    private TbRichText cWD;
    private boolean cWE;
    private boolean cWF;
    private boolean cWG;
    private boolean cWH;
    private boolean cWI;
    private e cWJ;
    public final View.OnClickListener cWK;
    private final f cWL;
    private boolean cWM;
    private Drawable cWN;
    private CustomMessageListener cWO;
    private com.baidu.adp.lib.e.b<TextView> cWl;
    private com.baidu.adp.lib.e.b<View> cWm;
    private com.baidu.adp.lib.e.b<LinearLayout> cWn;
    private com.baidu.adp.lib.e.b<RelativeLayout> cWo;
    private GridImageLayout cWp;
    private boolean cWq;
    private TextUtils.TruncateAt cWr;
    private j cWs;
    private i cWt;
    private View.OnClickListener cWu;
    private boolean cWv;
    private int cWw;
    private View.OnClickListener cWx;
    private boolean cWy;
    private boolean cWz;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> chB;
    private com.baidu.tieba.pb.a.c cyE;
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
        void aAb();
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
        this.cWG = z;
        azX();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.cWp != null) {
            this.cWp.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.cWI = z;
    }

    public boolean azW() {
        return this.cWB;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.cTG != null) {
            this.cTG.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.bjs = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.cWr = truncateAt;
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
                return view.getTag() != null && (view.getTag() instanceof b) && ((b) view.getTag()).cWS;
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
            /* renamed from: aAa */
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
        this.cTG = new com.baidu.tbadk.widget.richText.a();
        this.cTE = null;
        this.cWl = null;
        this.cWm = null;
        this.cWn = null;
        this.cWo = null;
        this.cTF = null;
        this.cWq = true;
        this.cWr = null;
        this.cWs = null;
        this.cTN = null;
        this.cyE = null;
        this.cWt = null;
        this.cWu = null;
        this.cWv = true;
        this.mIsFromCDN = true;
        this.cWw = -1;
        this.cWy = false;
        this.cWz = false;
        this.cWA = null;
        this.cWB = false;
        this.cWE = false;
        this.mMaxWidth = -1;
        this.bjs = -1;
        this.cWF = true;
        this.cWG = false;
        this.isHost = false;
        this.cWH = false;
        this.cWI = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cTN != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cTN.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.cTN.a(view, str, i2, TbRichTextView.this.isHost, false);
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
                    TbRichTextView.this.cTN.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.cPF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.cyE != null) {
                    TbRichTextView.this.cyE.N(view);
                    return TbRichTextView.this.cyE.onDoubleTap(motionEvent);
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
        this.cWK = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cWt != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cWt.e(view, str);
                }
            }
        };
        this.cWL = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cWH = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cWH = false;
                }
            }
        };
        this.mType = 19;
        this.chB = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
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
        this.cWO = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cWG ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cWD != null && !v.isEmpty(TbRichTextView.this.cWD.azf())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cWD.azf().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aw(contentSizeOfLzl, contentSizeOfLzl);
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
        this.cTG = new com.baidu.tbadk.widget.richText.a();
        this.cTE = null;
        this.cWl = null;
        this.cWm = null;
        this.cWn = null;
        this.cWo = null;
        this.cTF = null;
        this.cWq = true;
        this.cWr = null;
        this.cWs = null;
        this.cTN = null;
        this.cyE = null;
        this.cWt = null;
        this.cWu = null;
        this.cWv = true;
        this.mIsFromCDN = true;
        this.cWw = -1;
        this.cWy = false;
        this.cWz = false;
        this.cWA = null;
        this.cWB = false;
        this.cWE = false;
        this.mMaxWidth = -1;
        this.bjs = -1;
        this.cWF = true;
        this.cWG = false;
        this.isHost = false;
        this.cWH = false;
        this.cWI = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.cTN != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.cTN.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.cTN.a(view, str, i2, TbRichTextView.this.isHost, false);
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
                    TbRichTextView.this.cTN.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.cPF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.cyE != null) {
                    TbRichTextView.this.cyE.N(view);
                    return TbRichTextView.this.cyE.onDoubleTap(motionEvent);
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
        this.cWK = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.cWt != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof d)) {
                        str = null;
                    } else {
                        str = ((d) tag).url;
                    }
                    TbRichTextView.this.cWt.e(view, str);
                }
            }
        };
        this.cWL = new f() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.f
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.cWH = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.cWH = false;
                }
            }
        };
        this.mType = 19;
        this.chB = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
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
        this.cWO = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.cWG ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.cWD != null && !v.isEmpty(TbRichTextView.this.cWD.azf())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.cWD.azf().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aw(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.cTG.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        azX();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.cTG;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.cTG.release();
            this.cTG = aVar;
            azX();
            if (this.cWp != null) {
                this.cWp.setLayoutStrategy(this.cTG);
            }
        }
    }

    private void azX() {
        int contentSizeOfLzl = this.cWG ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.cTG.cUY = contentSizeOfLzl;
        this.cTG.cUX = contentSizeOfLzl;
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
            ab.registerListener(this.cWO);
        }
        if (eVar != null) {
            this.cTE = eVar.azO();
            this.cWl = eVar.azP();
            this.cWm = eVar.azR();
            this.cWn = eVar.azS();
            this.cTF = eVar.azQ();
            this.cWo = eVar.azT();
            if (eVar.getListView() != null && this.cWs == null) {
                this.cWs = new j(eVar.azN());
                eVar.getListView().setRecyclerListener(this.cWs);
            }
        }
        this.cTL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof GifView) && TbRichTextView.this.cTF != null) {
                    TbRichTextView.this.cTF.returnObject((GifView) view2);
                } else if ((view2 instanceof ImageView) && TbRichTextView.this.cTE != null) {
                    TbRichTextView.this.cTE.returnObject((ImageView) view2);
                } else if ((view2 instanceof TextView) && TbRichTextView.this.cWl != null) {
                    TbRichTextView.this.cWl.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.cWm != null) {
                    TbRichTextView.this.cWm.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cWm != null) {
                    TbRichTextView.this.cWm.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.cTF != null) {
                            TbRichTextView.this.cTF.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.cTE != null) {
                            TbRichTextView.this.cTE.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.cWo != null) {
                    TbRichTextView.this.cWo.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag = view2.getTag();
                    if (tag == null || !(tag instanceof String) || !"VideoView".equals(tag)) {
                        if (TbRichTextView.this.cWn != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.cWl != null) {
                                        TbRichTextView.this.cWl.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.cWm != null) {
                                        TbRichTextView.this.cWm.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.cWm != null) {
                                        TbRichTextView.this.cWm.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.cWn.returnObject((LinearLayout) view2);
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
        ArrayList<TbRichTextData> azf;
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        boolean z2;
        SpannableStringBuilder azo;
        boolean z3;
        View view;
        KeyEvent.Callback a2;
        boolean z4;
        int i4;
        int i5;
        if (this.cWD != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.cWD = tbRichText;
            removeAllViews();
            if (tbRichText != null && (azf = tbRichText.azf()) != null) {
                View view2 = null;
                boolean z5 = true;
                Iterator<TbRichTextData> it = azf.iterator();
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
                            if (z && !this.cWB && (azo = next.azo()) != null) {
                                this.cWB = azo.length() >= 200;
                            }
                            if (this.cyE != null) {
                                cE.setOnTouchListener(this.cPF);
                            } else {
                                cE.setOnClickListener(this.cWu);
                            }
                            z7 = a3;
                            i2 = i7;
                            i3 = i6;
                            relativeLayout = cE;
                            z2 = z6;
                        } else if (next.getType() == 8) {
                            if (!this.cWI) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.azn() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.azn().azG()) {
                                            GifView gifView = getGifView();
                                            b bVar = new b();
                                            bVar.cWS = true;
                                            gifView.setTag(bVar);
                                            z7 = b(next, gifView);
                                            z2 = z6;
                                            i2 = i7;
                                            i3 = i6;
                                            relativeLayout = gifView;
                                        } else {
                                            ?? cD = cD(getContext());
                                            z7 = c(next, cD, this.cTG.cUZ, this.cTG.cVa);
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
                                gridImageView.setData(tbRichText.azh());
                                z7 = true;
                                z2 = true;
                                i2 = i7;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.f azr = next.azr();
                            if (azr != null && azr.azV()) {
                                a2 = b(azr);
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
                                if (next == null || next.azt() == null || next.azt().memeInfo == null || StringUtils.isNull(next.azt().memeInfo.pic_url)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (z4) {
                                    RelativeLayout borrowObject = this.cWo.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.azt().memeInfo.width.intValue(), next.azt().memeInfo.height.intValue()));
                                    if (com.baidu.tbadk.t.v.axh() && this.cWq) {
                                        b(borrowObject, next.azt().memeInfo.width.intValue(), next.azt().memeInfo.height.intValue(), this.cTG.cUZ, this.cTG.cVa);
                                    } else {
                                        a(borrowObject, next.azt().memeInfo.width.intValue(), next.azt().memeInfo.height.intValue(), this.cTG.cUZ, this.cTG.cVa);
                                    }
                                    ImageView borrowObject2 = this.cTE.borrowObject();
                                    b(next, borrowObject2, this.cTG.cUZ, this.cTG.cVa);
                                    if (com.baidu.tbadk.t.v.axh() && this.cWq) {
                                        ImageView borrowObject3 = this.cTE.borrowObject();
                                        borrowObject3.setTag(this.cWD);
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
                                            tbImageView.setRadius(this.cTL);
                                            tbImageView.setAdjustViewBounds(false);
                                            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.azt().memeInfo.width.intValue(), next.azt().memeInfo.height.intValue(), this.cTG.cUZ, this.cTG.cVa, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.azt().memeInfo.height.intValue()) {
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
                                        b(borrowObject2, next.azt().memeInfo.width.intValue(), next.azt().memeInfo.height.intValue(), this.cTG.cUZ, this.cTG.cVa, this.mOnClickListener);
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
                                z7 = a(next, cD2, (this.cTG.cUZ - getPaddingLeft()) - getPaddingRight(), this.cTG.cVa);
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
                            if (z5 && this.cTG.cVp >= 0) {
                                z5 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.cTG.cVp;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z3 = false;
                                    view = relativeLayout;
                                }
                                z3 = z5;
                                view = relativeLayout;
                            } else if (relativeLayout instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.cTG.cVl;
                                } else {
                                    layoutParams2.topMargin = this.cTG.cUW;
                                }
                                relativeLayout.setLayoutParams(layoutParams2);
                                z3 = z5;
                                view = relativeLayout;
                            } else {
                                if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.cTG.cVj;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.cTG.cVi;
                                    } else {
                                        layoutParams2.topMargin = this.cTG.cUW;
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
                    layoutParams3.bottomMargin = this.cTG.cVo;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.cTG.cVn >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.cTG.cVn;
                    view2.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.cWp == null || this.cWp.getParent() != null) {
            this.cWp = new GridImageLayout(getContext());
            this.cWp.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.cWp.setLayoutStrategy(this.cTG);
        this.cWp.setObjectPool(this.cTE, this.cTF);
        this.cWp.setOnImageClickListener(this.cTN);
        this.cWp.setIsHost(this.isHost);
        return this.cWp;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.cWu = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.f fVar) {
        if (fVar == null || !fVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.cTE.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, fVar.getWidth(), fVar.getHeight(), (this.cTG.cUZ - getPaddingLeft()) - getPaddingRight(), this.cTG.cVa, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), fVar.getVideoUrl(), fVar.getWidth(), fVar.getHeight(), fVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.cTG.cVg);
            if (com.baidu.tbadk.core.i.ago().isShowImages()) {
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
        int[] q = this.cTG.q(i2, i3, i4, i5);
        if (q == null) {
            return false;
        }
        int i6 = q[0];
        int i7 = q[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cTG.cVb);
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.cTG.cVh) {
            imageView.setScaleType(this.cTG.cVf);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.cTG.HC);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.cyE != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.cPF);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cWL);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.cWL);
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
        if (!this.cTG.cVh || i4 <= i7 || cUT <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * cUT <= i4) {
                if (i7 * cUT > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * cUT);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.cTG.cVb);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.cTG.cVh) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.cyE != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.cPF);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.cWL);
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
        if (this.cTG.cVh && i4 > i8 && cUT > 1.0f) {
            if (i8 * cUT > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * cUT > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * cUT);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.cTG.cVb);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.cTG.cVh) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.cyE == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.cPF);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.cWL);
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
        if (!this.cTG.cVh) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.cyE == null) {
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
            if (!this.cTG.cVh || i4 <= i6 || cUT <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * cUT <= i4) {
                    if (i6 * cUT > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * cUT);
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
            if (this.cTG.cVh && i4 > i8 && cUT > 1.0f) {
                if (i8 * cUT > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * cUT > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * cUT);
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
        if (this.cTG.cVc <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.cTG.cUW;
        linearLayout.setClickable(true);
        Bitmap bitmap = am.getBitmap(this.cTG.cVc);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.azo() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.e) {
                        ((com.baidu.tbadk.widget.richText.e) TbRichTextView.this.getContext()).aj(TbRichTextView.this.getContext(), tbRichTextData.azo().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.e)) {
                        ((com.baidu.tbadk.widget.richText.e) ab.getOrignalPage()).aj(TbRichTextView.this.getContext(), tbRichTextData.azo().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView cD(Context context) {
        ImageView borrowObject = this.cTE != null ? this.cTE.borrowObject() : null;
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
        TbRichTextLinkImageInfo azv = tbRichTextData.azv();
        if (azv != null && azv.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.cTG.cVg) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(azv.azM(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new d(azv.getLink()));
                if (!azv.azD()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, azv.getWidth(), azv.getHeight(), i2, i3, this.cWK);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.azt() == null) {
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
            tbImageView.setRadius(this.cTL);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            if (this.cTG.cVg) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.azt().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.azt());
        }
        return b(imageView, tbRichTextData.azt().memeInfo.width.intValue(), tbRichTextData.azt().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean c(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.azn() == null) {
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
            tbImageView.setRadius(this.cTL);
            tbImageView.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            if (this.cTG.cVg) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(this.cTG.aze() ? tbRichTextData.azn().azy() : tbRichTextData.azn().azB(), this.mIsFromCDN ? 17 : 18, false);
            if (!tbRichTextData.azn().azD()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.azn().getWidth(), tbRichTextData.azn().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView cE(Context context) {
        TextView textView = null;
        if (this.cWl != null) {
            textView = this.cWl.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.cTG.cmz, 0, this.cTG.cmz, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.cWE) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.cTG.cUW;
        }
        textView.setLineSpacing(this.cTG.cUV, this.cTG.cUU);
        textView.setTextSize(0, this.cTG.asP);
        textView.setTextColor(this.cTG.mTextColor);
        textView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.cTG.cVd);
        if (this.cWr != null) {
            textView.setEllipsize(this.cWr);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.bjs > 0) {
            textView.setMaxLines(this.bjs);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder azo = tbRichTextData.azo();
        if (azo == null || azo.length() <= 0) {
            return false;
        }
        if (this.cTG.cUY > 0 && this.cTG.cUX > 0) {
            tbRichTextData.aw(this.cTG.cUX, this.cTG.cUY);
        }
        if (cVar != null) {
            cVar.a(azo, textView, this);
        }
        try {
            textView.setText(azo);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.cWF) {
            if (tbRichTextData.azx()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.cwN());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.azq() != null) {
            tbRichTextData.azq().needRecompute = this.cWM;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.cTF != null) {
            gifView = this.cTF.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(am.getColor(R.color.black_alpha8));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.cTL);
        gifView2.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.azs().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.azs().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.azs().mGifInfo.mGifWidth, tbRichTextData.azs().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.cWC != null) {
                    TbRichTextEmotionInfo azs = tbRichTextData.azs();
                    TbRichTextView.this.cWC.a(view, azs.mGifInfo.mGid, azs.mGifInfo.mPackageName, azs.mGifInfo.mIcon, azs.mGifInfo.mStaticUrl, azs.mGifInfo.mDynamicUrl, azs.mGifInfo.mSharpText, azs.mGifInfo.mGifWidth, azs.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.azs().mGifInfo);
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
        Drawable drawable = am.getDrawable(com.baidu.tbadk.util.e.Vj());
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(am.getDrawable(R.color.common_color_10220));
        }
        String azC = tbRichTextData.azn().azC();
        if (StringUtils.isNull(azC)) {
            if (this.cTG.cVq) {
                azC = this.cTG.mIsFromCDN ? tbRichTextData.azn().azy() : tbRichTextData.azn().azA();
            }
            if (StringUtils.isNull(azC)) {
                azC = this.cTG.mIsFromCDN ? tbRichTextData.azn().azB() : tbRichTextData.azn().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        gifView.T(azC, 38);
        return a(gifView, tbRichTextData.azn().getWidth(), tbRichTextData.azn().getHeight(), this.cTG.cUZ, this.cTG.cVa, this.mOnClickListener);
    }

    private View bk(View view) {
        View borrowObject = this.cWm != null ? this.cWm.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.cWw != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.cWw, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.cTG.cVk >= 0) {
                layoutParams.topMargin = this.cTG.cVk;
            } else {
                layoutParams.topMargin = this.cTG.cUW;
            }
            layoutParams.bottomMargin = this.cTG.cVm;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.cWx);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.azp());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.cWn.borrowObject();
        if (borrowObject != null) {
            TextView cE = cE(getContext());
            if (cE == null) {
                this.cWn.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(cE);
            View bk = bk(null);
            if (bk == null) {
                this.cWl.returnObject(cE);
                this.cWn.returnObject(borrowObject);
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
        if (f2 != this.cTG.asP) {
            this.cTG.asP = f2;
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
        if (i2 != this.cTG.mTextColor) {
            this.cTG.mTextColor = i2;
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
        if (this.cTG.cmz != i2) {
            this.cTG.cmz = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.cTG.cmz, 0, 0, this.cTG.cmz);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.cTG.cVe) {
            this.cTG.cVe = i2;
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
        this.cWq = z;
    }

    public h getOnImageClickListener() {
        return this.cTN;
    }

    public void setOnImageClickListener(h hVar) {
        this.cTN = hVar;
        if (this.cWp != null) {
            this.cWp.setOnImageClickListener(this.cTN);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.cyE = cVar;
    }

    public void setOnEmotionClickListener(g gVar) {
        this.cWC = gVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.cWv != z) {
            this.cWv = z;
            if (z2) {
                requestLayout();
            }
            if (!this.cWv && this.cTE != null) {
                this.cTE.clear();
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
        this.cWy = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.cWz) {
                    azZ();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.cWy) {
                    azY();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cWz && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.cWy = true;
        return super.onTouchEvent(motionEvent);
    }

    private void azY() {
        this.cWz = false;
        if (this.cWA == null) {
            this.cWA = new a();
        }
        postDelayed(this.cWA, ViewConfiguration.getLongPressTimeout());
    }

    private void azZ() {
        if (this.cWA != null) {
            removeCallbacks(this.cWA);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.cWH && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.cWz = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.cWw = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.cWx = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.cWN != drawable) {
            this.cWM = true;
            this.cWN = drawable;
        }
        setText(this.cWD);
        this.cWM = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.cTG != null) {
            this.cTG.release();
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
        this.cWJ = eVar;
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
            com.baidu.adp.lib.f.c.fT().a(this.mUrl, 19, this.chB, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.f.c.fT().a(this.mUrl, 19, this.chB);
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
                if (this.cWJ != null) {
                    this.cWJ.aAb();
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
        return this.cWt;
    }

    public void setOnLinkImageClickListener(i iVar) {
        this.cWt = iVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.cWF = z;
    }

    public void setTextCenter(boolean z) {
        this.cWE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean cWS;

        private b() {
        }
    }
}
