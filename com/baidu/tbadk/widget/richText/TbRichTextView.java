package com.baidu.tbadk.widget.richText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.DuiSwitch;
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
    private static final float dJv = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private GridImageLayout Oa;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> cUw;
    private final com.baidu.tieba.pb.a.c dEh;
    private com.baidu.adp.lib.d.b<ImageView> dIh;
    private com.baidu.adp.lib.d.b<GifView> dIi;
    private com.baidu.tbadk.widget.richText.a dIj;
    private int dIo;
    private i dIr;
    private com.baidu.tieba.pb.a<ImageView> dKU;
    private com.baidu.adp.lib.d.b<TextView> dKV;
    private com.baidu.adp.lib.d.b<View> dKW;
    private com.baidu.adp.lib.d.b<LinearLayout> dKX;
    private com.baidu.adp.lib.d.b<RelativeLayout> dKY;
    private boolean dKZ;
    private TextUtils.TruncateAt dLa;
    private k dLb;
    private j dLc;
    private View.OnClickListener dLd;
    private boolean dLe;
    private int dLf;
    private View.OnClickListener dLg;
    private boolean dLh;
    private Runnable dLi;
    private boolean dLj;
    private h dLk;
    private TbRichText dLl;
    private boolean dLm;
    private boolean dLn;
    private boolean dLo;
    private boolean dLp;
    private boolean dLq;
    private f dLr;
    public final View.OnClickListener dLs;
    private final g dLt;
    private boolean dLu;
    private Drawable dLv;
    private CustomMessageListener dLw;
    private com.baidu.tieba.pb.a.c dmA;
    private boolean isHost;
    private boolean mHasPerformedLongPress;
    private boolean mIsFromCDN;
    private int mMaxLines;
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
    public interface f {
        void aSv();
    }

    /* loaded from: classes.dex */
    public interface g {
        void x(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface h {
        void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(View view, String str, int i, boolean z, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface j {
        void e(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.dLo = z;
        aSq();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.Oa != null) {
            this.Oa.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.dLq = z;
    }

    public boolean aSp() {
        return this.dLj;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.dIj != null) {
            this.dIj.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.mMaxLines = i2;
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.dLa = truncateAt;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
        super.setOnLongClickListener(onLongClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        public String url;

        public e(String str) {
            this.url = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).dLA;
            }
            if ((view instanceof TbImageView) && view.getTag() != null) {
                if (view.getTag() instanceof e) {
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

    public static com.baidu.adp.lib.d.b<TextView> z(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aSu */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
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
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
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
        this.dIj = new com.baidu.tbadk.widget.richText.a();
        this.dKU = null;
        this.dIh = null;
        this.dKV = null;
        this.dKW = null;
        this.dKX = null;
        this.dKY = null;
        this.dIi = null;
        this.dKZ = true;
        this.dLa = null;
        this.dLb = null;
        this.dIr = null;
        this.dmA = null;
        this.dLc = null;
        this.dLd = null;
        this.dLe = true;
        this.mIsFromCDN = true;
        this.dLf = -1;
        this.dLh = false;
        this.mHasPerformedLongPress = false;
        this.dLi = null;
        this.dLj = false;
        this.dLm = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.dLn = true;
        this.dLo = false;
        this.isHost = false;
        this.dLp = false;
        this.dLq = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.dIr != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.dIr.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.dIr.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bk(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.dIr.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.dEh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.dmA != null) {
                    TbRichTextView.this.dmA.Q(view);
                    return TbRichTextView.this.dmA.onDoubleTap(motionEvent);
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
        this.dLs = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.dLc != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.dLc.e(view, str);
                }
            }
        };
        this.dLt = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.dLp = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.dLp = false;
                }
            }
        };
        this.mType = 19;
        this.cUw = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.h(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.dLw = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.dLo ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.dLl != null && !v.isEmpty(TbRichTextView.this.dLl.aRz())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.dLl.aRz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aU(contentSizeOfLzl, contentSizeOfLzl);
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
        this.dIj = new com.baidu.tbadk.widget.richText.a();
        this.dKU = null;
        this.dIh = null;
        this.dKV = null;
        this.dKW = null;
        this.dKX = null;
        this.dKY = null;
        this.dIi = null;
        this.dKZ = true;
        this.dLa = null;
        this.dLb = null;
        this.dIr = null;
        this.dmA = null;
        this.dLc = null;
        this.dLd = null;
        this.dLe = true;
        this.mIsFromCDN = true;
        this.dLf = -1;
        this.dLh = false;
        this.mHasPerformedLongPress = false;
        this.dLi = null;
        this.dLj = false;
        this.dLm = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.dLn = true;
        this.dLo = false;
        this.isHost = false;
        this.dLp = false;
        this.dLq = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.dIr != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.dIr.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.dIr.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bk(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.dIr.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.dEh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.dmA != null) {
                    TbRichTextView.this.dmA.Q(view);
                    return TbRichTextView.this.dmA.onDoubleTap(motionEvent);
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
        this.dLs = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.dLc != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.dLc.e(view, str);
                }
            }
        };
        this.dLt = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void x(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.dLp = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.dLp = false;
                }
            }
        };
        this.mType = 19;
        this.cUw = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.h(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.dLw = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.dLo ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.dLl != null && !v.isEmpty(TbRichTextView.this.dLl.aRz())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.dLl.aRz().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.aU(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.dIj.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        aSq();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.dIj;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.dIj.release();
            this.dIj = aVar;
            aSq();
            if (this.Oa != null) {
                this.Oa.setLayoutStrategy(this.dIj);
            }
        }
    }

    private void aSq() {
        int contentSizeOfLzl = this.dLo ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.dIj.dJA = contentSizeOfLzl;
        this.dIj.dJz = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.h hVar;
        com.baidu.tbadk.widget.richText.h hVar2;
        com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.h) {
            hVar = (com.baidu.tbadk.widget.richText.h) getContext();
        } else if (ab == null || !(ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
            hVar = null;
        } else {
            hVar = (com.baidu.tbadk.widget.richText.h) ab.getOrignalPage();
        }
        if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!v.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.h)) {
                hVar2 = (com.baidu.tbadk.widget.richText.h) fragments.get(0);
                if (ab != null) {
                    ab.registerListener(this.dLw);
                }
                if (hVar2 != null) {
                    this.dIh = hVar2.aSh();
                    this.dKV = hVar2.aSi();
                    this.dKW = hVar2.aSk();
                    this.dKX = hVar2.aSl();
                    this.dIi = hVar2.aSj();
                    this.dKY = hVar2.aSm();
                    if (hVar2.getListView() != null && this.dLb == null) {
                        this.dLb = new k(hVar2.aSg());
                        hVar2.getListView().setRecyclerListener(this.dLb);
                    }
                }
                this.dIo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).dLB) {
                                if (TbRichTextView.this.dIi != null) {
                                    TbRichTextView.this.dIi.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.dKU == null) {
                                    TbRichTextView.this.dKU = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.dKU.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).dLB) {
                                if (TbRichTextView.this.dIh != null) {
                                    TbRichTextView.this.dIh.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.dKU == null) {
                                    TbRichTextView.this.dKU = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.dKU.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.dKV != null) {
                            TbRichTextView.this.dKV.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.dKW != null) {
                            TbRichTextView.this.dKW.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dKW != null) {
                            TbRichTextView.this.dKW.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.dIi != null) {
                                    TbRichTextView.this.dIi.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.dIh != null) {
                                    TbRichTextView.this.dIh.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.dKY != null) {
                            TbRichTextView.this.dKY.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.dKX != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.dKV != null) {
                                                TbRichTextView.this.dKV.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.dKW != null) {
                                                TbRichTextView.this.dKW.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dKW != null) {
                                                TbRichTextView.this.dKW.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.dKX.returnObject((LinearLayout) view2);
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
        }
        hVar2 = hVar;
        if (ab != null) {
        }
        if (hVar2 != null) {
        }
        this.dIo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).dLB) {
                        if (TbRichTextView.this.dIi != null) {
                            TbRichTextView.this.dIi.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.dKU == null) {
                            TbRichTextView.this.dKU = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.dKU.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).dLB) {
                        if (TbRichTextView.this.dIh != null) {
                            TbRichTextView.this.dIh.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.dKU == null) {
                            TbRichTextView.this.dKU = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.dKU.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.dKV != null) {
                    TbRichTextView.this.dKV.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.dKW != null) {
                    TbRichTextView.this.dKW.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dKW != null) {
                    TbRichTextView.this.dKW.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.dIi != null) {
                            TbRichTextView.this.dIi.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.dIh != null) {
                            TbRichTextView.this.dIh.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.dKY != null) {
                    TbRichTextView.this.dKY.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.dKX != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.dKV != null) {
                                        TbRichTextView.this.dKV.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.dKW != null) {
                                        TbRichTextView.this.dKW.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.dKW != null) {
                                        TbRichTextView.this.dKW.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.dKX.returnObject((LinearLayout) view2);
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

    public void setText(TbRichText tbRichText, boolean z, c cVar) {
        setText(tbRichText, z, cVar, false, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:235:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:236:0x0038 */
    public void setText(TbRichText tbRichText, boolean z, c cVar, boolean z2, boolean z3) {
        ArrayList<TbRichTextData> aRz;
        int i2;
        int i3;
        boolean z4;
        SpannableStringBuilder aRG;
        boolean z5;
        View view;
        boolean z6;
        ImageView eh;
        boolean z7;
        ImageView imageView;
        boolean z8;
        GifView gifView;
        boolean z9;
        GifView gifView2;
        View a2;
        boolean z10;
        int i4;
        if (this.dLl != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.dLl = tbRichText;
            removeAllViews();
            if (tbRichText != null && (aRz = tbRichText.aRz()) != null) {
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = aRz.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z13 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ei = ei(getContext());
                            boolean a3 = a(next, ei, true, cVar);
                            if (z && !this.dLj && (aRG = next.aRG()) != null) {
                                this.dLj = aRG.length() >= 200;
                            }
                            if (this.dmA != null) {
                                ei.setOnTouchListener(this.dEh);
                            } else {
                                ei.setOnClickListener(this.dLd);
                            }
                            z13 = a3;
                            i2 = i5;
                            i3 = i6;
                            view3 = ei;
                            z4 = z12;
                        } else if (next.getType() == 8) {
                            if (!this.dLq) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.aRF() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.aRF().aRY()) {
                                            GifView gifView3 = null;
                                            if (!z3) {
                                                z8 = false;
                                                gifView = getGifView();
                                            } else {
                                                String aRU = next.aRF().aRU();
                                                if (StringUtils.isNull(aRU)) {
                                                    if (this.dIj.dJS) {
                                                        aRU = this.dIj.mIsFromCDN ? next.aRF().aRQ() : next.aRF().aRS();
                                                    }
                                                    if (StringUtils.isNull(aRU)) {
                                                        aRU = this.dIj.mIsFromCDN ? next.aRF().aRT() : next.aRF().getSrc();
                                                    }
                                                }
                                                if (this.dKU != null) {
                                                    ImageView ai = this.dKU.ai(aRU);
                                                    if (ai instanceof GifView) {
                                                        gifView3 = (GifView) ai;
                                                    }
                                                }
                                                if (gifView3 == null) {
                                                    gifView2 = getGifView();
                                                    z9 = false;
                                                } else {
                                                    z9 = true;
                                                    gifView2 = gifView3;
                                                }
                                                z8 = z9;
                                                gifView = gifView2;
                                            }
                                            b bVar = new b();
                                            bVar.dLA = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            z13 = a(next, gifView, z8);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.dLB = true;
                                                gifView.setTag(R.id.tag_rich_text_view_recycle, dVar);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = gifView;
                                        } else {
                                            ImageView imageView2 = null;
                                            if (!z3) {
                                                z6 = false;
                                                eh = eh(getContext());
                                            } else {
                                                String aRQ = this.dIj.aRy() ? next.aRF().aRQ() : next.aRF().aRT();
                                                if (this.dKU != null) {
                                                    imageView2 = this.dKU.ai(aRQ);
                                                }
                                                if (imageView2 == null) {
                                                    imageView = eh(getContext());
                                                    z7 = false;
                                                } else {
                                                    z7 = true;
                                                    imageView = imageView2;
                                                }
                                                z6 = z7;
                                                eh = imageView;
                                            }
                                            z13 = a(next, eh, this.dIj.dJB, this.dIj.dJC, z6);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.dLB = true;
                                                eh.setTag(R.id.tag_rich_text_view_recycle, dVar2);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = eh;
                                        }
                                    }
                                    z4 = z12;
                                    i2 = i5;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            } else if (!z12) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.aRA());
                                z13 = true;
                                z4 = true;
                                i2 = i5;
                                i3 = i6;
                                view3 = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.i aRJ = next.aRJ();
                            if (aRJ != null && aRJ.aSo()) {
                                a2 = b(aRJ);
                            } else {
                                a2 = a(next);
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = a2;
                            z13 = true;
                        } else if (next.getType() == 512) {
                            view3 = bl(view2);
                            if (view3 != null) {
                                z13 = a(next, view3);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6;
                                view3 = view3;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z13 = a(next, (LinearLayout) textVoiceView, cVar);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = textVoiceView;
                        } else if (next.getType() == 17) {
                            View gifView4 = getGifView();
                            z13 = a(next, (GifView) gifView4);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = gifView4;
                        } else if (next.getType() == 20) {
                            if (i5 < 10) {
                                int i7 = i5 + 1;
                                if (next == null || next.aRL() == null || next.aRL().memeInfo == null || StringUtils.isNull(next.aRL().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.dKY.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.aRL().memeInfo.width.intValue(), next.aRL().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.dKZ) {
                                        b(borrowObject, next.aRL().memeInfo.width.intValue(), next.aRL().memeInfo.height.intValue(), this.dIj.dJB, this.dIj.dJC);
                                    } else {
                                        a(borrowObject, next.aRL().memeInfo.width.intValue(), next.aRL().memeInfo.height.intValue(), this.dIj.dJB, this.dIj.dJC);
                                    }
                                    ImageView borrowObject2 = this.dIh.borrowObject();
                                    b(next, borrowObject2, this.dIj.dJB, this.dIj.dJC);
                                    if (DuiSwitch.getInOn() && this.dKZ) {
                                        ImageView borrowObject3 = this.dIh.borrowObject();
                                        borrowObject3.setTag(this.dLl);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.dIo);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.dLq) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.aRL().memeInfo.width.intValue(), next.aRL().memeInfo.height.intValue(), this.dIj.dJB, this.dIj.dJC, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.aRL().memeInfo.height.intValue()) {
                                            i4 = dimens / 2;
                                            dimens2 /= 2;
                                        } else {
                                            i4 = dimens;
                                        }
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, dimens2);
                                        layoutParams.addRule(8, R.id.meme_image_view);
                                        layoutParams.addRule(11);
                                        borrowObject3.setOnClickListener(this.mOnClickListener);
                                        if (borrowObject.getLeft() > 0) {
                                            layoutParams.rightMargin = l.getDimens(getContext(), R.dimen.ds6);
                                        }
                                        am.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.aRL().memeInfo.width.intValue(), next.aRL().memeInfo.height.intValue(), this.dIj.dJB, this.dIj.dJC, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                    }
                                    z13 = z10;
                                    i2 = i7;
                                    i3 = i6;
                                    view3 = borrowObject;
                                    z4 = z12;
                                } else {
                                    z13 = z10;
                                    z4 = z12;
                                    i2 = i7;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            }
                        } else {
                            if (next.getType() == 1280) {
                                ImageView eh2 = eh(getContext());
                                z13 = a(next, eh2, (this.dIj.dJB - getPaddingLeft()) - getPaddingRight(), this.dIj.dJC);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6 + 1;
                                view3 = eh2;
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = view3;
                        }
                        if (!z13 || view3 == null) {
                            z5 = z11;
                            view = view2;
                        } else {
                            addView(view3);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                            if (z11 && this.dIj.dJR >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.dIj.dJR;
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = false;
                                    view = view3;
                                }
                                z5 = z11;
                                view = view3;
                            } else if (view3 instanceof TbListTextView) {
                                if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                    layoutParams2.topMargin = this.dIj.dJN;
                                } else {
                                    layoutParams2.topMargin = this.dIj.dJy;
                                }
                                view3.setLayoutParams(layoutParams2);
                                z5 = z11;
                                view = view3;
                            } else {
                                if (((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.dIj.dJL;
                                    } else if ((view2 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.dIj.dJK;
                                    } else {
                                        layoutParams2.topMargin = this.dIj.dJy;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                }
                                z5 = z11;
                                view = view3;
                            }
                        }
                        z12 = z4;
                        z11 = z5;
                        i5 = i2;
                        i6 = i3;
                        view2 = view;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.dIj.dJQ;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.dIj.dJP >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.dIj.dJP;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.dKU != null) {
                    this.dKU.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.Oa == null || this.Oa.getParent() != null) {
            this.Oa = new GridImageLayout(getContext());
            this.Oa.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.Oa.setLayoutStrategy(this.dIj);
        this.Oa.setObjectPool(this.dIh, this.dIi);
        this.Oa.setOnImageClickListener(this.dIr);
        this.Oa.setIsHost(this.isHost);
        return this.Oa;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.dLd = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.i iVar) {
        if (iVar == null || !iVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.dIh.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, iVar.getWidth(), iVar.getHeight(), (this.dIj.dJB - getPaddingLeft()) - getPaddingRight(), this.dIj.dJC, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), iVar.getVideoUrl(), iVar.getWidth(), iVar.getHeight(), iVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.dIj.dJI);
            if (com.baidu.tbadk.core.i.axy().isShowImages()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(iVar.getThumbUrl(), 17, false);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] u = this.dIj.u(i2, i3, i4, i5);
        if (u == null) {
            return false;
        }
        int i6 = u[0];
        int i7 = u[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.dIj.dJJ) {
            imageView.setScaleType(this.dIj.dJH);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.dIj.Nr);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.dmA != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.dEh);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.dLt);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.dLt);
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
        if (!this.dIj.dJJ || i4 <= i7 || dJv <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * dJv <= i4) {
                if (i7 * dJv > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * dJv);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.dIj.dJD);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.dIj.dJJ) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.dmA != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.dEh);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.dLt);
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
        if (this.dIj.dJJ && i4 > i8 && dJv > 1.0f) {
            if (i8 * dJv > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * dJv > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * dJv);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.dIj.dJD);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.dIj.dJJ) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.dmA == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.dEh);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.dLt);
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
        if (!this.dIj.dJJ) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.dmA == null) {
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
            if (!this.dIj.dJJ || i4 <= i6 || dJv <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * dJv <= i4) {
                    if (i6 * dJv > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * dJv);
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
            if (this.dIj.dJJ && i4 > i8 && dJv > 1.0f) {
                if (i8 * dJv > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * dJv > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * dJv);
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
        if (this.dIj.dJE <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.dIj.dJy;
        linearLayout.setClickable(true);
        Bitmap bitmap = am.getBitmap(this.dIj.dJE);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.aRG() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.h) {
                        ((com.baidu.tbadk.widget.richText.h) TbRichTextView.this.getContext()).aD(TbRichTextView.this.getContext(), tbRichTextData.aRG().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> ab = com.baidu.adp.base.i.ab(TbRichTextView.this.getContext());
                    if (ab != null && (ab.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
                        ((com.baidu.tbadk.widget.richText.h) ab.getOrignalPage()).aD(TbRichTextView.this.getContext(), tbRichTextData.aRG().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView eh(Context context) {
        ImageView borrowObject = this.dIh != null ? this.dIh.borrowObject() : null;
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
        TbRichTextLinkImageInfo aRN = tbRichTextData.aRN();
        if (aRN != null && aRN.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.dIj.dJI) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(aRN.aSf(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(aRN.getLink()));
                if (!aRN.aRV()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, aRN.getWidth(), aRN.getHeight(), i2, i3, this.dLs);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.aRL() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.dIo);
            if (this.dLq) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.dIj.dJI) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.aRL().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.aRL());
        }
        return b(imageView, tbRichTextData.aRL().memeInfo.width.intValue(), tbRichTextData.aRL().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.aRF() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.dIo);
            if (this.dLq) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.dIj.dJI) {
                tbImageView.setSupportNoImage(true);
            }
            String aRQ = this.dIj.aRy() ? tbRichTextData.aRF().aRQ() : tbRichTextData.aRF().aRT();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(aRQ)) {
                tbImageView.startLoad(aRQ, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.aRF().aRV()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.aRF().getWidth(), tbRichTextData.aRF().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView ei(Context context) {
        TextView textView = null;
        if (this.dKV != null) {
            textView = this.dKV.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.dIj.cZU, 0, this.dIj.cZU, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.dLm) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.dIj.dJy;
        }
        textView.setLineSpacing(this.dIj.dJx, this.dIj.dJw);
        textView.setTextSize(0, this.dIj.mTextSize);
        textView.setTextColor(this.dIj.mTextColor);
        textView.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.dIj.dJF);
        if (this.dLa != null) {
            textView.setEllipsize(this.dLa);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.mMaxLines > 0) {
            textView.setMaxLines(this.mMaxLines);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder aRG = tbRichTextData.aRG();
        if (aRG == null || aRG.length() <= 0) {
            return false;
        }
        if (this.dIj.dJA > 0 && this.dIj.dJz > 0) {
            tbRichTextData.aU(this.dIj.dJz, this.dIj.dJA);
        }
        if (cVar != null) {
            cVar.a(aRG, textView, this);
        }
        try {
            textView.setText(aRG);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.dLn) {
            if (tbRichTextData.aRP()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.cRX());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.aRI() != null) {
            tbRichTextData.aRI().needRecompute = this.dLu;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.dIi != null) {
            gifView = this.dIi.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(am.getColor(R.color.cp_border_a));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.dIo);
        if (this.dLq) {
            gifView2.setPlaceHolder(2);
        } else {
            gifView2.setPlaceHolder(3);
        }
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.aRK().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.aRK().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.aRK().mGifInfo.mGifWidth, tbRichTextData.aRK().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.dLk != null) {
                    TbRichTextEmotionInfo aRK = tbRichTextData.aRK();
                    TbRichTextView.this.dLk.a(view, aRK.mGifInfo.mGid, aRK.mGifInfo.mPackageName, aRK.mGifInfo.mIcon, aRK.mGifInfo.mStaticUrl, aRK.mGifInfo.mDynamicUrl, aRK.mGifInfo.mSharpText, aRK.mGifInfo.mGifWidth, aRK.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.aRK().mGifInfo);
        return true;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(am.c(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = am.getDrawable(R.color.cp_bg_line_j);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(am.getDrawable(R.color.common_color_10220));
        }
        String aRU = tbRichTextData.aRF().aRU();
        if (StringUtils.isNull(aRU)) {
            if (this.dIj.dJS) {
                aRU = this.dIj.mIsFromCDN ? tbRichTextData.aRF().aRQ() : tbRichTextData.aRF().aRS();
            }
            if (StringUtils.isNull(aRU)) {
                aRU = this.dIj.mIsFromCDN ? tbRichTextData.aRF().aRT() : tbRichTextData.aRF().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(aRU)) {
            gifView.ag(aRU, 38);
        }
        return a(gifView, tbRichTextData.aRF().getWidth(), tbRichTextData.aRF().getHeight(), this.dIj.dJB, this.dIj.dJC, this.mOnClickListener);
    }

    private View bl(View view) {
        View borrowObject = this.dKW != null ? this.dKW.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.dLf != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.dLf, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.dIj.dJM >= 0) {
                layoutParams.topMargin = this.dIj.dJM;
            } else {
                layoutParams.topMargin = this.dIj.dJy;
            }
            layoutParams.bottomMargin = this.dIj.dJO;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.dLg);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.aRH());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.dKX.borrowObject();
        if (borrowObject != null) {
            TextView ei = ei(getContext());
            if (ei == null) {
                this.dKX.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(ei);
            View bl = bl(null);
            if (bl == null) {
                this.dKV.returnObject(ei);
                this.dKX.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(bl);
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
        if (f2 != this.dIj.mTextSize) {
            this.dIj.mTextSize = f2;
            this.dIj.dJz = (int) f2;
            this.dIj.dJA = (int) f2;
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
        if (i2 != this.dIj.mTextColor) {
            this.dIj.mTextColor = i2;
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
        if (this.dIj.cZU != i2) {
            this.dIj.cZU = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.dIj.cZU, 0, 0, this.dIj.cZU);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.dIj.dJG) {
            this.dIj.dJG = i2;
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
        this.dKZ = z;
    }

    public i getOnImageClickListener() {
        return this.dIr;
    }

    public void setOnImageClickListener(i iVar) {
        this.dIr = iVar;
        if (this.Oa != null) {
            this.Oa.setOnImageClickListener(this.dIr);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.dmA = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.dLk = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.dLe != z) {
            this.dLe = z;
            if (z2) {
                requestLayout();
            }
            if (!this.dLe && this.dIh != null) {
                this.dIh.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k implements AbsListView.RecyclerListener {
        private int mId;

        public k(int i) {
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
        this.dLh = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    aSs();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.dLh) {
                    aSr();
                    break;
                }
                break;
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mHasPerformedLongPress && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dLh = true;
        return super.onTouchEvent(motionEvent);
    }

    private void aSr() {
        this.mHasPerformedLongPress = false;
        if (this.dLi == null) {
            this.dLi = new a();
        }
        postDelayed(this.dLi, ViewConfiguration.getLongPressTimeout());
    }

    private void aSs() {
        if (this.dLi != null) {
            removeCallbacks(this.dLi);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.dLp && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.dLf = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.dLg = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.dLv != drawable) {
            this.dLu = true;
            this.dLv = drawable;
        }
        setText(this.dLl);
        this.dLu = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.dIj != null) {
            this.dIj.release();
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

    public void a(String str, f fVar) {
        this.dLr = fVar;
        vN(str);
    }

    public void vN(String str) {
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.gr().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            h(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.c.gr().Q(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.c.gr().a(this.mUrl, 19, this.cUw, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.gr().a(this.mUrl, 19, this.cUw);
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
                if (this.dLr != null) {
                    this.dLr.aSv();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.h
    public void refresh() {
        vN(this.mUrl);
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

    public j getOnLinkImageClickListener() {
        return this.dLc;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.dLc = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.dLn = z;
    }

    public void setTextCenter(boolean z) {
        this.dLm = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean dLA;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        boolean dLB;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.dKU == null) {
            this.dKU = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: aSt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.i.ab(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.i.axy().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    return imageView;
                }
            }, 10, 0) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.pb.a
                /* renamed from: ah */
                public ImageView ai(Object obj) {
                    ImageView imageView;
                    if (obj instanceof String) {
                        Iterator it = this._pool.iterator();
                        while (it.hasNext()) {
                            imageView = (ImageView) it.next();
                            if ((imageView instanceof TbImageView) && obj.equals(((TbImageView) imageView).getUrl())) {
                                break;
                            }
                        }
                    }
                    imageView = null;
                    this._pool.remove(imageView);
                    return imageView;
                }
            };
        }
        return this.dKU;
    }

    public TbRichText getRichText() {
        return this.dLl;
    }
}
