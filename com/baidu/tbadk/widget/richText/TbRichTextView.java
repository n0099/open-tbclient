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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.DuiSwitch;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.PbContent;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TbRichTextView extends LinearLayout implements com.baidu.adp.newwidget.ImageView.i {
    private static final float fgY = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private ItemCardView afU;
    private GridImageLayout akH;
    private com.baidu.tieba.pb.a.c eHq;
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eku;
    private final com.baidu.tieba.pb.a.c fav;
    private com.baidu.adp.lib.d.b<ImageView> ffj;
    private com.baidu.adp.lib.d.b<GifView> ffk;
    private com.baidu.tbadk.widget.richText.a ffl;
    private int ffq;
    private i ffu;
    private com.baidu.tieba.pb.a<ImageView> fiC;
    private com.baidu.adp.lib.d.b<TextView> fiD;
    private com.baidu.adp.lib.d.b<View> fiE;
    private com.baidu.adp.lib.d.b<LinearLayout> fiF;
    private com.baidu.adp.lib.d.b<RelativeLayout> fiG;
    private boolean fiH;
    private TextUtils.TruncateAt fiI;
    private k fiJ;
    private j fiK;
    private View.OnClickListener fiL;
    private View.OnClickListener fiM;
    private boolean fiN;
    private int fiO;
    private View.OnClickListener fiP;
    private boolean fiQ;
    private Runnable fiR;
    private boolean fiS;
    private h fiT;
    private TbRichText fiU;
    private boolean fiV;
    private boolean fiW;
    private boolean fiX;
    private boolean fiY;
    private boolean fiZ;
    private boolean fja;
    private f fjb;
    public final View.OnClickListener fjc;
    private final g fjd;
    private boolean fje;
    private Drawable fjf;
    private CustomMessageListener fjg;
    private boolean isHost;
    private boolean mHasPerformedLongPress;
    private boolean mIsFromCDN;
    private int mMaxLines;
    private int mMaxWidth;
    private final View.OnClickListener mOnClickListener;
    private BdUniqueId mPageId;
    private TextView mTextView;
    private final int mType;
    private String mUrl;
    private View.OnLongClickListener onLongClickListener;

    /* loaded from: classes.dex */
    public interface c {
        void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView);
    }

    /* loaded from: classes.dex */
    public interface f {
        void bzG();
    }

    /* loaded from: classes.dex */
    public interface g {
        void L(MotionEvent motionEvent);
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
        void f(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.fiX = z;
        bzB();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.akH != null) {
            this.akH.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.fiZ = z;
    }

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.fja = z;
    }

    public boolean bzA() {
        return this.fiS;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.ffl != null) {
            this.ffl.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.mMaxLines = i2;
        if (this.mTextView != null) {
            this.mTextView.setMaxLines(i2);
        }
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.fiI = truncateAt;
        if (this.mTextView != null) {
            this.mTextView.setEllipsize(truncateAt);
        }
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
    public boolean bB(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).fjk;
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

    public static com.baidu.adp.lib.d.b<TextView> A(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bzF */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
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
        this.ffl = new com.baidu.tbadk.widget.richText.a();
        this.fiC = null;
        this.ffj = null;
        this.fiD = null;
        this.fiE = null;
        this.fiF = null;
        this.fiG = null;
        this.ffk = null;
        this.fiH = true;
        this.fiI = null;
        this.fiJ = null;
        this.ffu = null;
        this.eHq = null;
        this.fiK = null;
        this.fiL = null;
        this.fiM = null;
        this.fiN = true;
        this.mIsFromCDN = true;
        this.fiO = -1;
        this.fiQ = false;
        this.mHasPerformedLongPress = false;
        this.fiR = null;
        this.fiS = false;
        this.fiV = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.fiW = true;
        this.fiX = false;
        this.isHost = false;
        this.fiY = false;
        this.fiZ = false;
        this.fja = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.ffu != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.ffu.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.ffu.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bB(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.ffu.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.fav = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.eHq != null) {
                    TbRichTextView.this.eHq.Z(view);
                    return TbRichTextView.this.eHq.onDoubleTap(motionEvent);
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
        this.fjc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.fiK != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.fiK.f(view, str);
                }
            }
        };
        this.fjd = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fiY = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fiY = false;
                }
            }
        };
        this.mType = 19;
        this.eku = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.fjg = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.fiX ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.fiU != null && !y.isEmpty(TbRichTextView.this.fiU.byG())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.fiU.byG().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bt(contentSizeOfLzl, contentSizeOfLzl);
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
        this.ffl = new com.baidu.tbadk.widget.richText.a();
        this.fiC = null;
        this.ffj = null;
        this.fiD = null;
        this.fiE = null;
        this.fiF = null;
        this.fiG = null;
        this.ffk = null;
        this.fiH = true;
        this.fiI = null;
        this.fiJ = null;
        this.ffu = null;
        this.eHq = null;
        this.fiK = null;
        this.fiL = null;
        this.fiM = null;
        this.fiN = true;
        this.mIsFromCDN = true;
        this.fiO = -1;
        this.fiQ = false;
        this.mHasPerformedLongPress = false;
        this.fiR = null;
        this.fiS = false;
        this.fiV = false;
        this.mMaxWidth = -1;
        this.mMaxLines = -1;
        this.fiW = true;
        this.fiX = false;
        this.isHost = false;
        this.fiY = false;
        this.fiZ = false;
        this.fja = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.ffu != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.ffu.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.ffu.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bB(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.ffu.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.fav = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.eHq != null) {
                    TbRichTextView.this.eHq.Z(view);
                    return TbRichTextView.this.eHq.onDoubleTap(motionEvent);
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
        this.fjc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.fiK != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.fiK.f(view, str);
                }
            }
        };
        this.fjd = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fiY = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fiY = false;
                }
            }
        };
        this.mType = 19;
        this.eku = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.fjg = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.fiX ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.fiU != null && !y.isEmpty(TbRichTextView.this.fiU.byG())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.fiU.byG().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bt(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.ffl.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bzB();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.ffl;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.ffl.release();
            this.ffl = aVar;
            bzB();
            if (this.akH != null) {
                this.akH.setLayoutStrategy(this.ffl);
            }
        }
    }

    private void bzB() {
        int contentSizeOfLzl = this.fiX ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.ffl.fhd = contentSizeOfLzl;
        this.ffl.fhc = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.i iVar;
        com.baidu.tbadk.widget.richText.i iVar2;
        com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.i) {
            iVar = (com.baidu.tbadk.widget.richText.i) getContext();
        } else if (I == null || !(I.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.i)) {
            iVar = null;
        } else {
            iVar = (com.baidu.tbadk.widget.richText.i) I.getOrignalPage();
        }
        if (iVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!y.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.i)) {
                iVar2 = (com.baidu.tbadk.widget.richText.i) fragments.get(0);
                if (I != null) {
                    I.registerListener(this.fjg);
                }
                if (iVar2 != null) {
                    this.ffj = iVar2.bzs();
                    this.fiD = iVar2.bzt();
                    this.fiE = iVar2.bzv();
                    this.fiF = iVar2.bzw();
                    this.ffk = iVar2.bzu();
                    this.fiG = iVar2.bzx();
                    if (iVar2.getListView() != null && this.fiJ == null) {
                        this.fiJ = new k(iVar2.bzr());
                        iVar2.getListView().setRecyclerListener(this.fiJ);
                    }
                }
                this.ffq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).fjl) {
                                if (TbRichTextView.this.ffk != null) {
                                    TbRichTextView.this.ffk.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.fiC == null) {
                                    TbRichTextView.this.fiC = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.fiC.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).fjl) {
                                if (TbRichTextView.this.ffj != null) {
                                    TbRichTextView.this.ffj.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.fiC == null) {
                                    TbRichTextView.this.fiC = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.fiC.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.fiD != null) {
                            TbRichTextView.this.fiD.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.fiE != null) {
                            TbRichTextView.this.fiE.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fiE != null) {
                            TbRichTextView.this.fiE.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.ffk != null) {
                                    TbRichTextView.this.ffk.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.ffj != null) {
                                    TbRichTextView.this.ffj.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.fiG != null) {
                            TbRichTextView.this.fiG.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.fiF != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.fiD != null) {
                                                TbRichTextView.this.fiD.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.fiE != null) {
                                                TbRichTextView.this.fiE.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fiE != null) {
                                                TbRichTextView.this.fiE.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.fiF.returnObject((LinearLayout) view2);
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
        iVar2 = iVar;
        if (I != null) {
        }
        if (iVar2 != null) {
        }
        this.ffq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).fjl) {
                        if (TbRichTextView.this.ffk != null) {
                            TbRichTextView.this.ffk.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.fiC == null) {
                            TbRichTextView.this.fiC = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.fiC.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).fjl) {
                        if (TbRichTextView.this.ffj != null) {
                            TbRichTextView.this.ffj.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.fiC == null) {
                            TbRichTextView.this.fiC = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.fiC.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.fiD != null) {
                    TbRichTextView.this.fiD.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.fiE != null) {
                    TbRichTextView.this.fiE.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fiE != null) {
                    TbRichTextView.this.fiE.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.ffk != null) {
                            TbRichTextView.this.ffk.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.ffj != null) {
                            TbRichTextView.this.ffj.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.fiG != null) {
                    TbRichTextView.this.fiG.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.fiF != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.fiD != null) {
                                        TbRichTextView.this.fiD.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.fiE != null) {
                                        TbRichTextView.this.fiE.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fiE != null) {
                                        TbRichTextView.this.fiE.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.fiF.returnObject((LinearLayout) view2);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:242:0x0038 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:243:0x0038 */
    public void setText(TbRichText tbRichText, boolean z, c cVar, boolean z2, boolean z3) {
        ArrayList<TbRichTextData> byG;
        int i2;
        int i3;
        boolean z4;
        SpannableStringBuilder byN;
        boolean z5;
        View view;
        boolean z6;
        ImageView ew;
        boolean z7;
        ImageView imageView;
        boolean z8;
        GifView gifView;
        boolean z9;
        GifView gifView2;
        View a2;
        boolean z10;
        int i4;
        if (this.fiU != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.fiU = tbRichText;
            removeAllViews();
            if (tbRichText != null && (byG = tbRichText.byG()) != null) {
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = byG.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                View view3 = null;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    boolean z13 = false;
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView ex = ex(getContext());
                            boolean a3 = a(next, ex, true, cVar);
                            if (z && !this.fiS && (byN = next.byN()) != null) {
                                this.fiS = byN.length() >= 200;
                            }
                            if (this.eHq != null) {
                                ex.setOnTouchListener(this.fav);
                            } else {
                                ex.setOnClickListener(this.fiL);
                            }
                            z13 = a3;
                            i2 = i5;
                            i3 = i6;
                            view3 = ex;
                            z4 = z12;
                        } else if (next.getType() == 8) {
                            if (!this.fiZ) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.byM() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.byM().bzh()) {
                                            GifView gifView3 = null;
                                            if (!z3) {
                                                z8 = false;
                                                gifView = getGifView();
                                            } else {
                                                String bzd = next.byM().bzd();
                                                if (StringUtils.isNull(bzd)) {
                                                    if (this.ffl.fhw) {
                                                        bzd = this.ffl.mIsFromCDN ? next.byM().byZ() : next.byM().bzb();
                                                    }
                                                    if (StringUtils.isNull(bzd)) {
                                                        bzd = this.ffl.mIsFromCDN ? next.byM().bzc() : next.byM().getSrc();
                                                    }
                                                }
                                                if (this.fiC != null) {
                                                    ImageView at = this.fiC.at(bzd);
                                                    if (at instanceof GifView) {
                                                        gifView3 = (GifView) at;
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
                                            bVar.fjk = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            z13 = a(next, gifView, z8);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.fjl = true;
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
                                                ew = ew(getContext());
                                            } else {
                                                String byZ = this.ffl.byF() ? next.byM().byZ() : next.byM().bzc();
                                                if (this.fiC != null) {
                                                    imageView2 = this.fiC.at(byZ);
                                                }
                                                if (imageView2 == null) {
                                                    imageView = ew(getContext());
                                                    z7 = false;
                                                } else {
                                                    z7 = true;
                                                    imageView = imageView2;
                                                }
                                                z6 = z7;
                                                ew = imageView;
                                            }
                                            z13 = a(next, ew, this.ffl.fhe, this.ffl.fhf, z6);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.fjl = true;
                                                ew.setTag(R.id.tag_rich_text_view_recycle, dVar2);
                                            }
                                            z4 = z12;
                                            i2 = i5;
                                            i3 = i6;
                                            view3 = ew;
                                        }
                                    }
                                    z4 = z12;
                                    i2 = i5;
                                    i3 = i6;
                                    view3 = view3;
                                }
                            } else if (!z12) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.byH());
                                z13 = true;
                                z4 = true;
                                i2 = i5;
                                i3 = i6;
                                view3 = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.j byQ = next.byQ();
                            if (byQ != null && byQ.bzz()) {
                                a2 = b(byQ);
                            } else {
                                a2 = a(next);
                            }
                            z4 = z12;
                            i2 = i5;
                            i3 = i6;
                            view3 = a2;
                            z13 = true;
                        } else if (next.getType() == 512) {
                            view3 = bC(view2);
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
                                if (next == null || next.byS() == null || next.byS().memeInfo == null || StringUtils.isNull(next.byS().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.fiG.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.byS().memeInfo.width.intValue(), next.byS().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.fiH) {
                                        b(borrowObject, next.byS().memeInfo.width.intValue(), next.byS().memeInfo.height.intValue(), this.ffl.fhe, this.ffl.fhf);
                                    } else {
                                        a(borrowObject, next.byS().memeInfo.width.intValue(), next.byS().memeInfo.height.intValue(), this.ffl.fhe, this.ffl.fhf);
                                    }
                                    ImageView borrowObject2 = this.ffj.borrowObject();
                                    b(next, borrowObject2, this.ffl.fhe, this.ffl.fhf);
                                    if (DuiSwitch.getInOn() && this.fiH) {
                                        ImageView borrowObject3 = this.ffj.borrowObject();
                                        borrowObject3.setTag(this.fiU);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.ffq);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.fiZ) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.byS().memeInfo.width.intValue(), next.byS().memeInfo.height.intValue(), this.ffl.fhe, this.ffl.fhf, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.byS().memeInfo.height.intValue()) {
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
                                        ap.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.byS().memeInfo.width.intValue(), next.byS().memeInfo.height.intValue(), this.ffl.fhe, this.ffl.fhf, this.mOnClickListener);
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
                        } else if (next.getType() == 1280) {
                            ImageView ew2 = ew(getContext());
                            z13 = a(next, ew2, (this.ffl.fhe - getPaddingLeft()) - getPaddingRight(), this.ffl.fhf);
                            z4 = z12;
                            i2 = i5;
                            i3 = i6 + 1;
                            view3 = ew2;
                        } else {
                            if (next.getType() == 1281) {
                                z13 = b(next);
                                z4 = z12;
                                i2 = i5;
                                i3 = i6;
                                view3 = this.afU;
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
                            if (z11 && this.ffl.fhu >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.ffl.fhu;
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = false;
                                    view = view3;
                                }
                                z5 = z11;
                                view = view3;
                            } else {
                                if (view3 instanceof TbListTextView) {
                                    if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.ffl.fhq;
                                    } else {
                                        layoutParams2.topMargin = this.ffl.fhb;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = z11;
                                } else if (((view3 instanceof ImageView) || (view3 instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.ffl.fho;
                                    } else if ((view2 instanceof ImageView) || (view3 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.ffl.fhn;
                                    } else {
                                        layoutParams2.topMargin = this.ffl.fhb;
                                    }
                                    view3.setLayoutParams(layoutParams2);
                                    z5 = z11;
                                } else {
                                    if ((view3 instanceof ItemCardView) && !z11) {
                                        layoutParams2.topMargin = this.ffl.fhv;
                                        view3.setLayoutParams(layoutParams2);
                                    }
                                    z5 = z11;
                                }
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
                    layoutParams3.bottomMargin = this.ffl.fht;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.ffl.fhs >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.ffl.fhs;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.fiC != null) {
                    this.fiC.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.akH == null || this.akH.getParent() != null) {
            this.akH = new GridImageLayout(getContext());
            this.akH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.akH.setLayoutStrategy(this.ffl);
        this.akH.setObjectPool(this.ffj, this.ffk);
        this.akH.setOnImageClickListener(this.ffu);
        if (this.fiM != null) {
            this.akH.setOnClickListener(this.fiM);
        }
        this.akH.setIsHost(this.isHost);
        if (this.fja) {
            this.akH.setOnLongClickListener(this.onLongClickListener);
        }
        return this.akH;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.fiL = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.j jVar) {
        if (jVar == null || !jVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.ffj.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.cp_cont_c);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, jVar.getWidth(), jVar.getHeight(), (this.ffl.fhe - getPaddingLeft()) - getPaddingRight(), this.ffl.fhf, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), jVar.getVideoUrl(), jVar.getWidth(), jVar.getHeight(), jVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.ffl.fhl);
            if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
            }
            foreDrawableImageView.startLoad(jVar.getThumbUrl(), 17, false);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] v = this.ffl.v(i2, i3, i4, i5);
        if (v == null) {
            return false;
        }
        int i6 = v[0];
        int i7 = v[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.ffl.fhm) {
            imageView.setScaleType(this.ffl.fhk);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.ffl.ajZ);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.eHq != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.fav);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fjd);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.fjd);
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
        if (!this.ffl.fhm || i4 <= i7 || fgY <= 1.0f) {
            i4 = i7;
            i6 = i8;
        } else {
            if (i7 * fgY <= i4) {
                if (i7 * fgY > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * fgY);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.ffl.fhg);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.ffl.fhm) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.eHq != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.fav);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fjd);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
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
        if (this.ffl.fhm && i4 > i8 && fgY > 1.0f) {
            if (i8 * fgY > i4) {
                i8 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i8 * fgY > i4 * 0.68f) {
                i8 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i8 = (int) (i8 * fgY);
            }
            if (iArr[0] > 0) {
                i6 = (iArr[1] * i8) / iArr[0];
                i7 = i8;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.ffl.fhg);
                    if (tbImageView.getGifIconWidth() >= i7 || tbImageView.getGifIconHeight() >= i6) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i6);
                if (!this.ffl.fhm) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.eHq == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.fav);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.fjd);
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
        if (!this.ffl.fhm) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.eHq == null) {
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
            if (!this.ffl.fhm || i4 <= i6 || fgY <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * fgY <= i4) {
                    if (i6 * fgY > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * fgY);
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
            if (this.ffl.fhm && i4 > i8 && fgY > 1.0f) {
                if (i8 * fgY > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * fgY > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * fgY);
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
        if (this.ffl.fhh <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.ffl.fhb;
        linearLayout.setClickable(true);
        Bitmap bitmap = ap.getBitmap(this.ffl.fhh);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.byN() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.i) {
                        ((com.baidu.tbadk.widget.richText.i) TbRichTextView.this.getContext()).au(TbRichTextView.this.getContext(), tbRichTextData.byN().toString());
                        return;
                    }
                    com.baidu.adp.base.e<?> I = com.baidu.adp.base.i.I(TbRichTextView.this.getContext());
                    if (I != null && (I.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.i)) {
                        ((com.baidu.tbadk.widget.richText.i) I.getOrignalPage()).au(TbRichTextView.this.getContext(), tbRichTextData.byN().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView ew(Context context) {
        ImageView borrowObject = this.ffj != null ? this.ffj.borrowObject() : null;
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
        TbRichTextLinkImageInfo byU = tbRichTextData.byU();
        if (byU != null && byU.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.ffl.fhl) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(byU.bzq(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(byU.getLink()));
                if (!byU.bze()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, byU.getWidth(), byU.getHeight(), i2, i3, this.fjc);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.byS() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.ffq);
            if (this.fiZ) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.ffl.fhl) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.byS().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.byS());
        }
        return b(imageView, tbRichTextData.byS().memeInfo.width.intValue(), tbRichTextData.byS().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.byM() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setTLIconType(tbRichTextData.getIconType());
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.ffq);
            if (this.fiZ) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.ffl.fhl) {
                tbImageView.setSupportNoImage(true);
            }
            String byZ = this.ffl.byF() ? tbRichTextData.byM().byZ() : tbRichTextData.byM().bzc();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(byZ)) {
                tbImageView.startLoad(byZ, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.byM().bze()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.byM().getWidth(), tbRichTextData.byM().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView ex(Context context) {
        TextView textView = null;
        if (this.fiD != null) {
            textView = this.fiD.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.ffl.cNV, 0, this.ffl.cNV, 0);
        return textView;
    }

    private boolean a(TbRichTextData tbRichTextData, TextView textView, boolean z, c cVar) {
        LinearLayout.LayoutParams layoutParams;
        this.mTextView = textView;
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        if (this.fiV) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.ffl.fhb;
        }
        textView.setLineSpacing(this.ffl.fha, this.ffl.fgZ);
        textView.setTextSize(0, this.ffl.mTextSize);
        textView.setTextColor(this.ffl.mTextColor);
        textView.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.ffl.fhi);
        if (this.fiI != null) {
            textView.setEllipsize(this.fiI);
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
        SpannableStringBuilder byN = tbRichTextData.byN();
        if (byN == null || byN.length() <= 0) {
            return false;
        }
        if (this.ffl.fhd > 0 && this.ffl.fhc > 0) {
            tbRichTextData.bt(this.ffl.fhc, this.ffl.fhd);
        }
        if (cVar != null) {
            cVar.a(byN, textView, this);
        }
        try {
            textView.setText(byN);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.fiW) {
            if (tbRichTextData.byW()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.dJc());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.byP() != null) {
            tbRichTextData.byP().needRecompute = this.fje;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.ffk != null) {
            gifView = this.ffk.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(ap.getColor(R.color.cp_border_a));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.ffq);
        if (this.fiZ) {
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.byR().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.byR().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.byR().mGifInfo.mGifWidth, tbRichTextData.byR().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.fiT != null) {
                    TbRichTextEmotionInfo byR = tbRichTextData.byR();
                    TbRichTextView.this.fiT.a(view, byR.mGifInfo.mGid, byR.mGifInfo.mPackageName, byR.mGifInfo.mIcon, byR.mGifInfo.mStaticUrl, byR.mGifInfo.mDynamicUrl, byR.mGifInfo.mSharpText, byR.mGifInfo.mGifWidth, byR.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.byR().mGifInfo);
        return true;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(ap.c(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = ap.getDrawable(R.color.cp_bg_line_j);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(ap.getDrawable(R.color.common_color_10220));
        }
        String bzd = tbRichTextData.byM().bzd();
        if (StringUtils.isNull(bzd)) {
            if (this.ffl.fhw) {
                bzd = this.ffl.mIsFromCDN ? tbRichTextData.byM().byZ() : tbRichTextData.byM().bzb();
            }
            if (StringUtils.isNull(bzd)) {
                bzd = this.ffl.mIsFromCDN ? tbRichTextData.byM().bzc() : tbRichTextData.byM().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(bzd)) {
            gifView.as(bzd, 38);
        }
        return a(gifView, tbRichTextData.byM().getWidth(), tbRichTextData.byM().getHeight(), this.ffl.fhe, this.ffl.fhf, this.mOnClickListener);
    }

    private View bC(View view) {
        View borrowObject = this.fiE != null ? this.fiE.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.fiO != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.fiO, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.ffl.fhp >= 0) {
                layoutParams.topMargin = this.ffl.fhp;
            } else {
                layoutParams.topMargin = this.ffl.fhb;
            }
            layoutParams.bottomMargin = this.ffl.fhr;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.fiP);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.byO());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.fiF.borrowObject();
        if (borrowObject != null) {
            TextView ex = ex(getContext());
            if (ex == null) {
                this.fiF.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(ex);
            View bC = bC(null);
            if (bC == null) {
                this.fiD.returnObject(ex);
                this.fiF.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(bC);
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

    private boolean b(final TbRichTextData tbRichTextData) {
        if (tbRichTextData == null || tbRichTextData.byV() == null) {
            return false;
        }
        if (this.afU == null) {
            this.afU = new ItemCardView(getContext());
            this.afU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", tbRichTextData.byV().byY());
                    hashMap.put("source", 3);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                }
            });
        }
        this.afU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.afU.setData(tbRichTextData.byV(), 17);
        this.afU.onChangeSkinType();
        return true;
    }

    public void setTextSize(float f2) {
        if (f2 != this.ffl.mTextSize) {
            this.ffl.mTextSize = f2;
            this.ffl.fhc = (int) f2;
            this.ffl.fhd = (int) f2;
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
        if (i2 != this.ffl.mTextColor) {
            this.ffl.mTextColor = i2;
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
        if (this.ffl.cNV != i2) {
            this.ffl.cNV = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.ffl.cNV, 0, 0, this.ffl.cNV);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.ffl.fhj) {
            this.ffl.fhj = i2;
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
        this.fiH = z;
    }

    public i getOnImageClickListener() {
        return this.ffu;
    }

    public void setOnImageClickListener(i iVar) {
        this.ffu = iVar;
        if (this.akH != null) {
            this.akH.setOnImageClickListener(this.ffu);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.eHq = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.fiT = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.fiN != z) {
            this.fiN = z;
            if (z2) {
                requestLayout();
            }
            if (!this.fiN && this.ffj != null) {
                this.ffj.clear();
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
        this.fiQ = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    bzD();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.fiQ) {
                    bzC();
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
        this.fiQ = true;
        return super.onTouchEvent(motionEvent);
    }

    private void bzC() {
        this.mHasPerformedLongPress = false;
        if (this.fiR == null) {
            this.fiR = new a();
        }
        postDelayed(this.fiR, ViewConfiguration.getLongPressTimeout());
    }

    private void bzD() {
        if (this.fiR != null) {
            removeCallbacks(this.fiR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.fiY && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.fiO = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.fiP = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.fjf != drawable) {
            this.fje = true;
            this.fjf = drawable;
        }
        setText(this.fiU);
        this.fje = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ffl != null) {
            this.ffl.release();
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
        this.fjb = fVar;
        Dr(str);
    }

    public void Dr(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.h G = com.baidu.adp.base.i.G(getContext());
        if (G != null) {
            bdUniqueId = G.getUniqueId();
            z = G.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.c.mR().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            h(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.c.mR().at(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.c.mR().a(this.mUrl, 19, this.eku, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.c.mR().a(this.mUrl, 19, this.eku);
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
                if (this.fjb != null) {
                    this.fjb.bzG();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        Dr(this.mUrl);
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
        return this.fiK;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.fiK = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.fiW = z;
    }

    public void setTextCenter(boolean z) {
        this.fiV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean fjk;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        boolean fjl;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.fiC == null) {
            this.fiC = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bzE */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.i.I(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bcG().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
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
            }, 10, 0) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.pb.a
                /* renamed from: as */
                public ImageView at(Object obj) {
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
        return this.fiC;
    }

    public TbRichText getRichText() {
        return this.fiU;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.fiM = onClickListener;
    }
}
