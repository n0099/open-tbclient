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
import androidx.fragment.app.Fragment;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private static final float fXz = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private ItemCardView ais;
    private GridImageLayout amY;
    private int dEV;
    private final com.baidu.tieba.pb.a.c fQV;
    private com.baidu.adp.lib.d.b<ImageView> fVL;
    private com.baidu.adp.lib.d.b<GifView> fVM;
    private com.baidu.tbadk.widget.richText.a fVN;
    private i fVW;
    public boolean fZA;
    private f fZB;
    public final View.OnClickListener fZC;
    private final g fZD;
    private boolean fZE;
    private Drawable fZF;
    private CustomMessageListener fZG;
    private com.baidu.tieba.pb.a<ImageView> fZa;
    private com.baidu.adp.lib.d.b<TextView> fZb;
    private com.baidu.adp.lib.d.b<View> fZc;
    private com.baidu.adp.lib.d.b<LinearLayout> fZd;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZe;
    private boolean fZf;
    private TextUtils.TruncateAt fZg;
    private k fZh;
    private j fZi;
    private View.OnClickListener fZj;
    private View.OnClickListener fZk;
    private boolean fZl;
    private int fZm;
    private View.OnClickListener fZn;
    private boolean fZo;
    private Runnable fZp;
    private boolean fZq;
    private h fZr;
    private TbRichText fZs;
    private boolean fZt;
    private boolean fZu;
    private boolean fZv;
    private boolean fZw;
    private boolean fZx;
    private boolean fZy;
    private int fZz;
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fah;
    private com.baidu.tieba.pb.a.c fxj;
    private boolean isHost;
    private boolean mHasPerformedLongPress;
    private boolean mIsFromCDN;
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
        void bIz();
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
        void g(View view, String str);
    }

    public void setSubPbPost(boolean z) {
        this.fZv = z;
        bIu();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.amY != null) {
            this.amY.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.fZx = z;
    }

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.fZy = z;
    }

    public boolean bIt() {
        return this.fZq;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.fVN != null) {
            this.fVN.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.dEV = i2;
        if (this.mTextView != null) {
            this.mTextView.setMaxLines(i2);
        }
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.fZg = truncateAt;
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
    public boolean bZ(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).fZK;
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
        return new TbRichText(context, list, null, z);
    }

    public static TbRichText a(Context context, List<PbContent> list, String str, boolean z) {
        return new TbRichText(context, list, str, z);
    }

    public static com.baidu.adp.lib.d.b<TextView> K(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bIy */
            public TextView makeObject() {
                return new TbListTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: i */
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
            /* renamed from: j */
            public TextView activateObject(TextView textView) {
                return textView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: k */
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
        this.fVN = new com.baidu.tbadk.widget.richText.a();
        this.fZa = null;
        this.fVL = null;
        this.fZb = null;
        this.fZc = null;
        this.fZd = null;
        this.fZe = null;
        this.fVM = null;
        this.fZf = true;
        this.fZg = null;
        this.fZh = null;
        this.fVW = null;
        this.fxj = null;
        this.fZi = null;
        this.fZj = null;
        this.fZk = null;
        this.fZl = true;
        this.mIsFromCDN = true;
        this.fZm = -1;
        this.fZo = false;
        this.mHasPerformedLongPress = false;
        this.fZp = null;
        this.fZq = false;
        this.fZt = false;
        this.mMaxWidth = -1;
        this.dEV = -1;
        this.fZu = true;
        this.fZv = false;
        this.isHost = false;
        this.fZw = false;
        this.fZx = false;
        this.fZy = false;
        this.fZA = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.fVW != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.fVW.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.fVW.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bZ(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.fVW.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.fQV = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.fxj != null) {
                    TbRichTextView.this.fxj.ad(view);
                    return TbRichTextView.this.fxj.onDoubleTap(motionEvent);
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
        this.fZC = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.fZi != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.fZi.g(view, str);
                }
            }
        };
        this.fZD = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fZw = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fZw = false;
                }
            }
        };
        this.mType = 19;
        this.fah = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.g(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.fZG = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.fZv ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.fZs != null && !y.isEmpty(TbRichTextView.this.fZs.bHD())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.fZs.bHD().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bq(contentSizeOfLzl, contentSizeOfLzl);
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
        this.fVN = new com.baidu.tbadk.widget.richText.a();
        this.fZa = null;
        this.fVL = null;
        this.fZb = null;
        this.fZc = null;
        this.fZd = null;
        this.fZe = null;
        this.fVM = null;
        this.fZf = true;
        this.fZg = null;
        this.fZh = null;
        this.fVW = null;
        this.fxj = null;
        this.fZi = null;
        this.fZj = null;
        this.fZk = null;
        this.fZl = true;
        this.mIsFromCDN = true;
        this.fZm = -1;
        this.fZo = false;
        this.mHasPerformedLongPress = false;
        this.fZp = null;
        this.fZq = false;
        this.fZt = false;
        this.mMaxWidth = -1;
        this.dEV = -1;
        this.fZu = true;
        this.fZv = false;
        this.isHost = false;
        this.fZw = false;
        this.fZx = false;
        this.fZy = false;
        this.fZA = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.fVW != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.fVW.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.fVW.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.bZ(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.fVW.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.fQV = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.fxj != null) {
                    TbRichTextView.this.fxj.ad(view);
                    return TbRichTextView.this.fxj.onDoubleTap(motionEvent);
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
        this.fZC = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.fZi != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.fZi.g(view, str);
                }
            }
        };
        this.fZD = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fZw = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fZw = false;
                }
            }
        };
        this.mType = 19;
        this.fah = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i2) {
                TbRichTextView.this.g(aVar);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        };
        this.fZG = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.fZv ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.fZs != null && !y.isEmpty(TbRichTextView.this.fZs.bHD())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.fZs.bHD().iterator();
                    while (it.hasNext()) {
                        TbRichTextData next = it.next();
                        if (next != null) {
                            next.bq(contentSizeOfLzl, contentSizeOfLzl);
                        }
                    }
                }
                TbRichTextView.this.setTextSize(contentSizeOfLzl);
            }
        };
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TbRichTextView);
        this.fVN.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bIu();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.fVN;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.fVN.release();
            this.fVN = aVar;
            bIu();
            if (this.amY != null) {
                this.amY.setLayoutStrategy(this.fVN);
            }
        }
    }

    private void bIu() {
        int contentSizeOfLzl = this.fZv ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.fVN.fXF = contentSizeOfLzl;
        this.fVN.fXE = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.h hVar;
        com.baidu.tbadk.widget.richText.h hVar2;
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.h) {
            hVar = (com.baidu.tbadk.widget.richText.h) getContext();
        } else if (J == null || !(J.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
            hVar = null;
        } else {
            hVar = (com.baidu.tbadk.widget.richText.h) J.getOrignalPage();
        }
        if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!y.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.h)) {
                hVar2 = (com.baidu.tbadk.widget.richText.h) fragments.get(0);
                if (J != null) {
                    J.registerListener(this.fZG);
                }
                if (hVar2 != null) {
                    this.fVL = hVar2.bIl();
                    this.fZb = hVar2.bIm();
                    this.fZc = hVar2.bIo();
                    this.fZd = hVar2.bIp();
                    this.fVM = hVar2.bIn();
                    this.fZe = hVar2.bIq();
                    if (hVar2.getListView() != null && this.fZh == null) {
                        this.fZh = new k(hVar2.bIk());
                        hVar2.getListView().setRecyclerListener(this.fZh);
                    }
                }
                this.fZz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).fZL) {
                                if (TbRichTextView.this.fVM != null) {
                                    TbRichTextView.this.fVM.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.fZa == null) {
                                    TbRichTextView.this.fZa = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.fZa.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).fZL) {
                                if (TbRichTextView.this.fVL != null) {
                                    TbRichTextView.this.fVL.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.fZa == null) {
                                    TbRichTextView.this.fZa = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.fZa.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.fZb != null) {
                            TbRichTextView.this.fZb.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.fZc != null) {
                            TbRichTextView.this.fZc.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fZc != null) {
                            TbRichTextView.this.fZc.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.fVM != null) {
                                    TbRichTextView.this.fVM.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.fVL != null) {
                                    TbRichTextView.this.fVL.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.fZe != null) {
                            TbRichTextView.this.fZe.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.fZd != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.fZb != null) {
                                                TbRichTextView.this.fZb.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.fZc != null) {
                                                TbRichTextView.this.fZc.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fZc != null) {
                                                TbRichTextView.this.fZc.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.fZd.returnObject((LinearLayout) view2);
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
        if (J != null) {
        }
        if (hVar2 != null) {
        }
        this.fZz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).fZL) {
                        if (TbRichTextView.this.fVM != null) {
                            TbRichTextView.this.fVM.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.fZa == null) {
                            TbRichTextView.this.fZa = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.fZa.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).fZL) {
                        if (TbRichTextView.this.fVL != null) {
                            TbRichTextView.this.fVL.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.fZa == null) {
                            TbRichTextView.this.fZa = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.fZa.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.fZb != null) {
                    TbRichTextView.this.fZb.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.fZc != null) {
                    TbRichTextView.this.fZc.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fZc != null) {
                    TbRichTextView.this.fZc.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.fVM != null) {
                            TbRichTextView.this.fVM.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.fVL != null) {
                            TbRichTextView.this.fVL.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.fZe != null) {
                    TbRichTextView.this.fZe.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.fZd != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.fZb != null) {
                                        TbRichTextView.this.fZb.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.fZc != null) {
                                        TbRichTextView.this.fZc.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fZc != null) {
                                        TbRichTextView.this.fZc.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.fZd.returnObject((LinearLayout) view2);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:244:0x0037 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:245:0x0037 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.baidu.tbadk.widget.richText.TbRichTextView] */
    /* JADX WARN: Type inference failed for: r2v87, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v68 */
    public void setText(TbRichText tbRichText, boolean z, c cVar, boolean z2, boolean z3) {
        ArrayList<TbRichTextData> bHD;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        SpannableStringBuilder bHK;
        RelativeLayout relativeLayout;
        boolean z6;
        View view;
        boolean z7;
        ImageView imageView;
        boolean z8;
        ImageView imageView2;
        GifView gifView;
        boolean z9;
        GifView gifView2;
        LinearLayout linearLayout;
        boolean z10;
        int i4;
        if (this.fZs != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.fZs = tbRichText;
            removeAllViews();
            if (tbRichText != null && (bHD = tbRichText.bHD()) != null) {
                Object obj = null;
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = bHD.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView fA = fA(getContext());
                            boolean a2 = a(next, fA, true, cVar);
                            if (z && !this.fZq && (bHK = next.bHK()) != null) {
                                this.fZq = bHK.length() >= 200;
                            }
                            if (this.fxj != null) {
                                fA.setOnTouchListener(this.fQV);
                            } else {
                                fA.setOnClickListener(this.fZj);
                            }
                            z4 = a2;
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = fA;
                        } else if (next.getType() == 8) {
                            if (!this.fZx) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.bHJ() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHJ().bIb()) {
                                            GifView gifView3 = null;
                                            gifView3 = null;
                                            boolean z13 = false;
                                            if (z3) {
                                                String bHX = next.bHJ().bHX();
                                                if (StringUtils.isNull(bHX)) {
                                                    if (this.fVN.fXY) {
                                                        bHX = this.fVN.mIsFromCDN ? next.bHJ().bHT() : next.bHJ().bHV();
                                                    }
                                                    if (StringUtils.isNull(bHX)) {
                                                        bHX = this.fVN.mIsFromCDN ? next.bHJ().bHW() : next.bHJ().getSrc();
                                                    }
                                                }
                                                if (this.fZa != null) {
                                                    ImageView aA = this.fZa.aA(bHX);
                                                    if (aA instanceof GifView) {
                                                        gifView3 = (GifView) aA;
                                                    }
                                                }
                                                if (gifView3 == null) {
                                                    z9 = false;
                                                    gifView2 = getGifView();
                                                } else {
                                                    z9 = true;
                                                    gifView2 = gifView3;
                                                }
                                                z13 = z9;
                                                gifView = gifView2;
                                            } else {
                                                gifView = getGifView();
                                            }
                                            b bVar = new b();
                                            bVar.fZK = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            boolean a3 = a(next, gifView, z13);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.fZL = true;
                                                gifView.setTag(R.id.tag_rich_text_view_recycle, dVar);
                                            }
                                            z4 = a3;
                                            z5 = z12 ? 1 : 0;
                                            i2 = i5;
                                            i3 = i6;
                                            relativeLayout = gifView;
                                        } else {
                                            ImageView imageView3 = null;
                                            if (!z3) {
                                                z7 = false;
                                                imageView = fz(getContext());
                                            } else {
                                                String bHT = this.fVN.bHC() ? next.bHJ().bHT() : next.bHJ().bHW();
                                                if (this.fZa != null) {
                                                    imageView3 = this.fZa.aA(bHT);
                                                }
                                                if (imageView3 == null) {
                                                    z8 = false;
                                                    imageView2 = fz(getContext());
                                                } else {
                                                    z8 = true;
                                                    imageView2 = imageView3;
                                                }
                                                z7 = z8;
                                                imageView = imageView2;
                                            }
                                            boolean a4 = a(next, imageView, this.fVN.fXG, this.fVN.fXH, z7);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.fZL = true;
                                                imageView.setTag(R.id.tag_rich_text_view_recycle, dVar2);
                                            }
                                            z4 = a4;
                                            z5 = z12 ? 1 : 0;
                                            i2 = i5;
                                            i3 = i6;
                                            relativeLayout = imageView;
                                        }
                                    }
                                    z4 = false;
                                    z5 = z12 ? 1 : 0;
                                    i2 = i5;
                                    i3 = i6;
                                    relativeLayout = obj;
                                }
                            } else if (!z12) {
                                GridImageLayout gridImageView = getGridImageView();
                                gridImageView.setData(tbRichText.bHE());
                                z4 = true;
                                z5 = true;
                                i2 = i5;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.i bHN = next.bHN();
                            if (bHN != null && bHN.bIs()) {
                                linearLayout = b(bHN);
                            } else {
                                linearLayout = a(next);
                            }
                            z4 = true;
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = linearLayout;
                        } else if (next.getType() == 512) {
                            View ca = ca(view2);
                            if (ca == null) {
                                obj = ca;
                            } else {
                                z4 = a(next, ca);
                                z5 = z12 ? 1 : 0;
                                i2 = i5;
                                i3 = i6;
                                relativeLayout = ca;
                            }
                        } else if (next.getType() == 768) {
                            View textVoiceView = getTextVoiceView();
                            z4 = a(next, (LinearLayout) textVoiceView, cVar);
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = textVoiceView;
                        } else if (next.getType() == 17) {
                            GifView gifView4 = getGifView();
                            z4 = a(next, gifView4);
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = gifView4;
                        } else if (next.getType() == 20) {
                            if (i5 < 10) {
                                int i7 = i5 + 1;
                                if (next == null || next.bHP() == null || next.bHP().memeInfo == null || StringUtils.isNull(next.bHP().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.fZe.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.bHP().memeInfo.width.intValue(), next.bHP().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.fZf) {
                                        b(borrowObject, next.bHP().memeInfo.width.intValue(), next.bHP().memeInfo.height.intValue(), this.fVN.fXG, this.fVN.fXH);
                                    } else {
                                        a(borrowObject, next.bHP().memeInfo.width.intValue(), next.bHP().memeInfo.height.intValue(), this.fVN.fXG, this.fVN.fXH);
                                    }
                                    ImageView borrowObject2 = this.fVL.borrowObject();
                                    b(next, borrowObject2, this.fVN.fXG, this.fVN.fXH);
                                    if (DuiSwitch.getInOn() && this.fZf) {
                                        ImageView borrowObject3 = this.fVL.borrowObject();
                                        borrowObject3.setTag(this.fZs);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.fZz);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.fZx) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.bHP().memeInfo.width.intValue(), next.bHP().memeInfo.height.intValue(), this.fVN.fXG, this.fVN.fXH, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.bHP().memeInfo.height.intValue()) {
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
                                        b(borrowObject2, next.bHP().memeInfo.width.intValue(), next.bHP().memeInfo.height.intValue(), this.fVN.fXG, this.fVN.fXH, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                    }
                                    z4 = z10;
                                    z5 = z12 ? 1 : 0;
                                    i2 = i7;
                                    i3 = i6;
                                    relativeLayout = borrowObject;
                                } else {
                                    z4 = z10;
                                    z5 = z12 ? 1 : 0;
                                    i2 = i7;
                                    i3 = i6;
                                    relativeLayout = obj;
                                }
                            }
                        } else if (next.getType() != 1280) {
                            if (next.getType() == 1281) {
                                boolean b2 = b(next);
                                ItemCardView itemCardView = this.ais;
                                z4 = b2;
                                z5 = z12 ? 1 : 0;
                                i2 = i5;
                                i3 = i6;
                                relativeLayout = itemCardView;
                            }
                            z4 = false;
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = obj;
                        } else {
                            ImageView fz = fz(getContext());
                            z4 = a(next, fz, (this.fVN.fXG - getPaddingLeft()) - getPaddingRight(), this.fVN.fXH);
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6 + 1;
                            relativeLayout = fz;
                        }
                        if (!z4 || relativeLayout == null) {
                            z6 = z11;
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z11 && this.fVN.fXW >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.fVN.fXW;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z6 = false;
                                    view = relativeLayout;
                                }
                                z6 = z11;
                                view = relativeLayout;
                            } else {
                                if (relativeLayout instanceof TbListTextView) {
                                    if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.fVN.fXS;
                                    } else {
                                        layoutParams2.topMargin = this.fVN.fXC;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z6 = z11;
                                } else if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.fVN.fXQ;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.fVN.fXP;
                                    } else {
                                        layoutParams2.topMargin = this.fVN.fXC;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z6 = z11;
                                } else {
                                    if ((relativeLayout instanceof ItemCardView) && !z11) {
                                        layoutParams2.topMargin = this.fVN.fXX;
                                        relativeLayout.setLayoutParams(layoutParams2);
                                    }
                                    z6 = z11;
                                }
                                view = relativeLayout;
                            }
                        }
                        z12 = z5;
                        z11 = z6;
                        i5 = i2;
                        i6 = i3;
                        view2 = view;
                        obj = relativeLayout;
                    }
                }
                if (view2 instanceof TbListTextView) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams3.bottomMargin = this.fVN.fXV;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.fVN.fXU >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.fVN.fXU;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.fZa != null) {
                    this.fZa.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.amY == null || this.amY.getParent() != null) {
            this.amY = new GridImageLayout(getContext());
            this.amY.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.amY.setLayoutStrategy(this.fVN);
        this.amY.setObjectPool(this.fVL, this.fVM);
        this.amY.setOnImageClickListener(this.fVW);
        if (this.fZk != null) {
            this.amY.setOnClickListener(this.fZk);
        }
        this.amY.setIsHost(this.isHost);
        if (this.fZy) {
            this.amY.setOnLongClickListener(this.onLongClickListener);
        }
        return this.amY;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.fZj = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.i iVar) {
        if (iVar == null || !iVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.fVL.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, iVar.getWidth(), iVar.getHeight(), (this.fVN.fXG - getPaddingLeft()) - getPaddingRight(), this.fVN.fXH, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), iVar.getVideoUrl(), iVar.getWidth(), iVar.getHeight(), iVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.fVN.fXN);
            if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
                foreDrawableImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
            }
            foreDrawableImageView.startLoad(iVar.getThumbUrl(), 17, false);
            return borrowObject;
        }
        return borrowObject;
    }

    private boolean a(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int[] B = this.fVN.B(i2, i3, i4, i5);
        if (B == null) {
            return false;
        }
        int i6 = B[0];
        int i7 = B[1];
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i7) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i7);
        if (this.fVN.fXO) {
            imageView.setScaleType(this.fVN.fXM);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.fVN.amp);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.fxj != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.fQV);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fZD);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.fZD);
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
        if (!this.fVN.fXO || i4 <= i7 || fXz <= 1.0f) {
            i6 = i8;
            i4 = i7;
        } else {
            if (i7 * fXz <= i4) {
                if (i7 * fXz > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * fXz);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.fVN.fXI);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.fVN.fXO) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.fxj != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.fQV);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fZD);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            imageView.setOnLongClickListener(this.onLongClickListener);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ImageView imageView, int i2, int i3, int i4, int i5, View.OnClickListener onClickListener) {
        int i6;
        int[] imageResize = l.getImageResize(i2, i3, i4, i5);
        if (imageResize == null) {
            return false;
        }
        int[] iArr = {imageResize[0], imageResize[1]};
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (this.fVN.fXO && i4 > i7 && fXz > 1.0f) {
            if (i7 * fXz > i4) {
                i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i7 * fXz > i4 * 0.68f) {
                i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i7 = (int) (i7 * fXz);
            }
            if (iArr[0] > 0) {
                i8 = (iArr[1] * i7) / iArr[0];
                i6 = i7;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.fVN.fXI);
                    if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i8) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i8);
                if (!this.fVN.fXO) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.fxj == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.fQV);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.fZD);
                        imageView.setOnLongClickListener(this.onLongClickListener);
                    }
                } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
                    imageView.setOnLongClickListener(this.onLongClickListener);
                }
                return true;
            }
        }
        i6 = i7;
        if (imageView instanceof TbImageView) {
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i6, i8);
        if (!this.fVN.fXO) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.fxj == null) {
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
            if (!this.fVN.fXO || i4 <= i6 || fXz <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * fXz <= i4) {
                    if (i6 * fXz > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * fXz);
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
            if (this.fVN.fXO && i4 > i8 && fXz > 1.0f) {
                if (i8 * fXz > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * fXz > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * fXz);
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
        if (this.fVN.fXJ <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.fVN.fXC;
        linearLayout.setClickable(true);
        Bitmap bitmap = ap.getBitmap(this.fVN.fXJ);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.bHK() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.h) {
                        ((com.baidu.tbadk.widget.richText.h) TbRichTextView.this.getContext()).aF(TbRichTextView.this.getContext(), tbRichTextData.bHK().toString());
                        return;
                    }
                    com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(TbRichTextView.this.getContext());
                    if (J != null && (J.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
                        ((com.baidu.tbadk.widget.richText.h) J.getOrignalPage()).aF(TbRichTextView.this.getContext(), tbRichTextData.bHK().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView fz(Context context) {
        ImageView borrowObject = this.fVL != null ? this.fVL.borrowObject() : null;
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
        TbRichTextLinkImageInfo bHR = tbRichTextData.bHR();
        if (bHR != null && bHR.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.fVN.fXN) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(bHR.bIj(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(bHR.getLink()));
                if (!bHR.bHY()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, bHR.getWidth(), bHR.getHeight(), i2, i3, this.fZC);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.bHP() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.fZz);
            if (this.fZx) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.fVN.fXN) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.bHP().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.bHP());
        }
        return b(imageView, tbRichTextData.bHP().memeInfo.width.intValue(), tbRichTextData.bHP().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.bHJ() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setTLIconType(tbRichTextData.getIconType());
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.fZz);
            if (this.fZx) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.fVN.fXN) {
                tbImageView.setSupportNoImage(true);
            }
            String bHT = this.fVN.bHC() ? tbRichTextData.bHJ().bHT() : tbRichTextData.bHJ().bHW();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(bHT)) {
                tbImageView.startLoad(bHT, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.bHJ().bHY()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.bHJ().getWidth(), tbRichTextData.bHJ().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView fA(Context context) {
        TextView textView = null;
        if (this.fZb != null) {
            textView = this.fZb.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.fVN.dyJ, 0, this.fVN.dyJ, 0);
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
        if (this.fZt) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.fVN.fXC;
        }
        textView.setLineSpacing(this.fVN.fXB, this.fVN.fXA);
        textView.setTextSize(0, this.fVN.mTextSize);
        if (this.fVN.fXD) {
            com.baidu.tbadk.core.elementsMaven.c.br(textView).ob(R.string.F_X02);
        }
        textView.setTextColor(this.fVN.mTextColor);
        textView.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.fVN.fXK);
        if (this.fZg != null) {
            textView.setEllipsize(this.fZg);
        }
        if (this.fZA) {
            com.baidu.tbadk.core.elementsMaven.c.br(textView).oj(R.array.S_O_X001);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.dEV > 0) {
            textView.setMaxLines(this.dEV);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder bHK = tbRichTextData.bHK();
        if (bHK == null || bHK.length() <= 0) {
            return false;
        }
        if (this.fVN.fXF > 0 && this.fVN.fXE > 0) {
            tbRichTextData.bq(this.fVN.fXE, this.fVN.fXF);
        }
        if (cVar != null) {
            cVar.a(bHK, textView, this);
        }
        try {
            textView.setText(bHK);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.fZu) {
            if (tbRichTextData.bHS()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.dWg());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.bHM() != null) {
            tbRichTextData.bHM().needRecompute = this.fZE;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.fVM != null) {
            gifView = this.fVM.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(ap.getColor(R.color.CAM_X0401));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.fZz);
        if (this.fZx) {
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.bHO().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.bHO().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.bHO().mGifInfo.mGifWidth, tbRichTextData.bHO().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.fZr != null) {
                    TbRichTextEmotionInfo bHO = tbRichTextData.bHO();
                    TbRichTextView.this.fZr.a(view, bHO.mGifInfo.mGid, bHO.mGifInfo.mPackageName, bHO.mGifInfo.mIcon, bHO.mGifInfo.mStaticUrl, bHO.mGifInfo.mDynamicUrl, bHO.mGifInfo.mSharpText, bHO.mGifInfo.mGifWidth, bHO.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.bHO().mGifInfo);
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
        Drawable drawable = ap.getDrawable(R.color.CAM_X0209);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(ap.getDrawable(R.color.common_color_10220));
        }
        String bHX = tbRichTextData.bHJ().bHX();
        if (StringUtils.isNull(bHX)) {
            if (this.fVN.fXY) {
                bHX = this.fVN.mIsFromCDN ? tbRichTextData.bHJ().bHT() : tbRichTextData.bHJ().bHV();
            }
            if (StringUtils.isNull(bHX)) {
                bHX = this.fVN.mIsFromCDN ? tbRichTextData.bHJ().bHW() : tbRichTextData.bHJ().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(bHX)) {
            gifView.az(bHX, 38);
        }
        return a(gifView, tbRichTextData.bHJ().getWidth(), tbRichTextData.bHJ().getHeight(), this.fVN.fXG, this.fVN.fXH, this.mOnClickListener);
    }

    private View ca(View view) {
        View borrowObject = this.fZc != null ? this.fZc.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.fZm != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.fZm, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.fVN.fXR >= 0) {
                layoutParams.topMargin = this.fVN.fXR;
            } else {
                layoutParams.topMargin = this.fVN.fXC;
            }
            layoutParams.bottomMargin = this.fVN.fXT;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.fZn);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.bHL());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        if (view instanceof PlayVoiceBntNew) {
            ((PlayVoiceBntNew) view).bur();
            return true;
        }
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.fZd.borrowObject();
        if (borrowObject != null) {
            TextView fA = fA(getContext());
            if (fA == null) {
                this.fZd.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(fA);
            View ca = ca(null);
            if (ca == null) {
                this.fZb.returnObject(fA);
                this.fZd.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(ca);
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
        if (tbRichTextData == null || tbRichTextData.getEvaluateItemInfo() == null) {
            return false;
        }
        if (this.ais == null) {
            this.ais = new ItemCardView(getContext());
            this.ais.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", tbRichTextData.getEvaluateItemInfo().getItemID());
                    hashMap.put("source", 3);
                    TiebaStatic.log(new ar("common_click").dR("page_type", PageStayDurationConstants.PageName.PB).aq("gua_type", 2).aq("obj_locate", 16));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                }
            });
        }
        this.ais.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.ais.setData(tbRichTextData.getEvaluateItemInfo(), 17);
        this.ais.onChangeSkinType();
        return true;
    }

    public void setTextSize(float f2) {
        if (f2 != this.fVN.mTextSize) {
            this.fVN.mTextSize = f2;
            this.fVN.fXE = (int) f2;
            this.fVN.fXF = (int) f2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextSize(0, f2);
                }
            }
        }
    }

    public void setTextBold() {
        this.fVN.fXD = true;
    }

    public void setTextColor(int i2) {
        if (i2 != this.fVN.mTextColor) {
            this.fVN.mTextColor = i2;
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
        if (this.fVN.dyJ != i2) {
            this.fVN.dyJ = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.fVN.dyJ, 0, 0, this.fVN.dyJ);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.fVN.fXL) {
            this.fVN.fXL = i2;
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
        this.fZf = z;
    }

    public i getOnImageClickListener() {
        return this.fVW;
    }

    public void setOnImageClickListener(i iVar) {
        this.fVW = iVar;
        if (this.amY != null) {
            this.amY.setOnImageClickListener(this.fVW);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.fxj = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.fZr = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.fZl != z) {
            this.fZl = z;
            if (z2) {
                requestLayout();
            }
            if (!this.fZl && this.fVL != null) {
                this.fVL.clear();
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
        this.fZo = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    bIw();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.fZo) {
                    bIv();
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
        this.fZo = true;
        return super.onTouchEvent(motionEvent);
    }

    private void bIv() {
        this.mHasPerformedLongPress = false;
        if (this.fZp == null) {
            this.fZp = new a();
        }
        postDelayed(this.fZp, ViewConfiguration.getLongPressTimeout());
    }

    private void bIw() {
        if (this.fZp != null) {
            removeCallbacks(this.fZp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.fZw && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.fZm = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.fZn = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.fZF != drawable) {
            this.fZE = true;
            this.fZF = drawable;
        }
        setText(this.fZs);
        this.fZE = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fVN != null) {
            this.fVN.release();
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
        this.fZB = fVar;
        Em(str);
    }

    public void Em(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.i H = com.baidu.adp.base.j.H(getContext());
        if (H != null) {
            bdUniqueId = H.getUniqueId();
            z = H.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mw().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            g(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.d.mw().ax(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.d.mw().a(this.mUrl, 19, this.fah, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.d.mw().a(this.mUrl, 19, this.fah);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            try {
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ninePatchDrawable.getPaint().setAlpha(80);
                }
                setBackgroundDrawable(ninePatchDrawable);
                if (this.fZB != null) {
                    this.fZB.bIz();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        Em(this.mUrl);
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
        return this.fZi;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.fZi = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.fZu = z;
    }

    public void setTextCenter(boolean z) {
        this.fZt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean fZK;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        boolean fZL;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.fZa == null) {
            this.fZa = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIx */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.j.J(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkV().isShowImages();
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
                /* renamed from: b */
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
                /* renamed from: c */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
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
                /* renamed from: d */
                public ImageView passivateObject(ImageView imageView) {
                    return imageView;
                }
            }, 10, 0) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.pb.a
                /* renamed from: az */
                public ImageView aA(Object obj) {
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
        return this.fZa;
    }

    public TbRichText getRichText() {
        return this.fZs;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.fZk = onClickListener;
    }
}
