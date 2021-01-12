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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
    private static final float fTK = l.getEquipmentDensity(TbadkCoreApplication.getInst());
    private ItemCardView ahk;
    private GridImageLayout alQ;
    private int dBq;
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> eWs;
    private final com.baidu.tieba.pb.a.c fNi;
    private com.baidu.adp.lib.d.b<ImageView> fRW;
    private com.baidu.adp.lib.d.b<GifView> fRX;
    private com.baidu.tbadk.widget.richText.a fRY;
    private i fSh;
    private boolean fVA;
    private h fVB;
    private TbRichText fVC;
    private boolean fVD;
    private boolean fVE;
    private boolean fVF;
    private boolean fVG;
    private boolean fVH;
    private boolean fVI;
    private int fVJ;
    public boolean fVK;
    private f fVL;
    public final View.OnClickListener fVM;
    private final g fVN;
    private boolean fVO;
    private Drawable fVP;
    private CustomMessageListener fVQ;
    private com.baidu.tieba.pb.a<ImageView> fVk;
    private com.baidu.adp.lib.d.b<TextView> fVl;
    private com.baidu.adp.lib.d.b<View> fVm;
    private com.baidu.adp.lib.d.b<LinearLayout> fVn;
    private com.baidu.adp.lib.d.b<RelativeLayout> fVo;
    private boolean fVp;
    private TextUtils.TruncateAt fVq;
    private k fVr;
    private j fVs;
    private View.OnClickListener fVt;
    private View.OnClickListener fVu;
    private boolean fVv;
    private int fVw;
    private View.OnClickListener fVx;
    private boolean fVy;
    private Runnable fVz;
    private com.baidu.tieba.pb.a.c ftt;
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
        void bIc();
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
        this.fVF = z;
        bHX();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
        if (this.alQ != null) {
            this.alQ.setIsHost(z);
        }
    }

    public void setIsUseGridImage(boolean z) {
        this.fVH = z;
    }

    public void setmIsGridImageSupportLongPress(boolean z) {
        this.fVI = z;
    }

    public boolean bHW() {
        return this.fVA;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        if (this.fRY != null) {
            this.fRY.mIsFromCDN = z;
        }
    }

    public void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    public void setMaxLines(int i2) {
        this.dBq = i2;
        if (this.mTextView != null) {
            this.mTextView.setMaxLines(i2);
        }
    }

    public void setTextEllipsize(TextUtils.TruncateAt truncateAt) {
        this.fVq = truncateAt;
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
    public boolean cd(View view) {
        if (view instanceof ImageView) {
            if (view instanceof GifView) {
                return view.getTag(R.id.tag_rich_text_view_gif_view) != null && (view.getTag(R.id.tag_rich_text_view_gif_view) instanceof b) && ((b) view.getTag(R.id.tag_rich_text_view_gif_view)).fVU;
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

    public static com.baidu.adp.lib.d.b<TextView> K(final Context context, int i2) {
        return new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TextView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bIb */
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
        this.fRY = new com.baidu.tbadk.widget.richText.a();
        this.fVk = null;
        this.fRW = null;
        this.fVl = null;
        this.fVm = null;
        this.fVn = null;
        this.fVo = null;
        this.fRX = null;
        this.fVp = true;
        this.fVq = null;
        this.fVr = null;
        this.fSh = null;
        this.ftt = null;
        this.fVs = null;
        this.fVt = null;
        this.fVu = null;
        this.fVv = true;
        this.mIsFromCDN = true;
        this.fVw = -1;
        this.fVy = false;
        this.mHasPerformedLongPress = false;
        this.fVz = null;
        this.fVA = false;
        this.fVD = false;
        this.mMaxWidth = -1;
        this.dBq = -1;
        this.fVE = true;
        this.fVF = false;
        this.isHost = false;
        this.fVG = false;
        this.fVH = false;
        this.fVI = false;
        this.fVK = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.fSh != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.fSh.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.fSh.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.cd(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.fSh.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.fNi = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.ftt != null) {
                    TbRichTextView.this.ftt.ad(view);
                    return TbRichTextView.this.ftt.onDoubleTap(motionEvent);
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
        this.fVM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.fVs != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.fVs.f(view, str);
                }
            }
        };
        this.fVN = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fVG = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fVG = false;
                }
            }
        };
        this.mType = 19;
        this.eWs = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.fVQ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.fVF ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.fVC != null && !x.isEmpty(TbRichTextView.this.fVC.bHf())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.fVC.bHf().iterator();
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
        this.fRY = new com.baidu.tbadk.widget.richText.a();
        this.fVk = null;
        this.fRW = null;
        this.fVl = null;
        this.fVm = null;
        this.fVn = null;
        this.fVo = null;
        this.fRX = null;
        this.fVp = true;
        this.fVq = null;
        this.fVr = null;
        this.fSh = null;
        this.ftt = null;
        this.fVs = null;
        this.fVt = null;
        this.fVu = null;
        this.fVv = true;
        this.mIsFromCDN = true;
        this.fVw = -1;
        this.fVy = false;
        this.mHasPerformedLongPress = false;
        this.fVz = null;
        this.fVA = false;
        this.fVD = false;
        this.mMaxWidth = -1;
        this.dBq = -1;
        this.fVE = true;
        this.fVF = false;
        this.isHost = false;
        this.fVG = false;
        this.fVH = false;
        this.fVI = false;
        this.fVK = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2 = null;
                int i2 = -1;
                if (TbRichTextView.this.fSh != null && (view instanceof ImageView)) {
                    Object tag = view.getTag();
                    if (tag != null && (tag instanceof TbRichText)) {
                        int childCount = TbRichTextView.this.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            i2++;
                            if (view.getParent() == TbRichTextView.this.getChildAt(i3)) {
                                break;
                            }
                        }
                        TbRichTextView.this.fSh.a(view, null, i2, TbRichTextView.this.isHost, false);
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
                        TbRichTextView.this.fSh.a(view, str, i2, TbRichTextView.this.isHost, false);
                        return;
                    } else if (view instanceof TbImageView) {
                        str2 = ((TbImageView) view).getUrl();
                    } else if (view instanceof GifView) {
                        str2 = ((GifView) view).getUrl();
                    }
                    int childCount3 = TbRichTextView.this.getChildCount();
                    for (int i5 = 0; i5 < childCount3; i5++) {
                        View childAt = TbRichTextView.this.getChildAt(i5);
                        if (TbRichTextView.this.cd(childAt)) {
                            i2++;
                        }
                        if (view == childAt) {
                            break;
                        }
                    }
                    TbRichTextView.this.fSh.a(view, str2, i2, TbRichTextView.this.isHost, false);
                }
            }
        };
        this.fNi = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.7
            @Override // com.baidu.tieba.pb.a.c.a
            public boolean onDoubleTap(View view, MotionEvent motionEvent) {
                if (TbRichTextView.this.ftt != null) {
                    TbRichTextView.this.ftt.ad(view);
                    return TbRichTextView.this.ftt.onDoubleTap(motionEvent);
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
        this.fVM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (TbRichTextView.this.fVs != null && (view instanceof TbImageView)) {
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof e)) {
                        str = null;
                    } else {
                        str = ((e) tag).url;
                    }
                    TbRichTextView.this.fVs.f(view, str);
                }
            }
        };
        this.fVN = new g() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.2
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
            public void L(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    TbRichTextView.this.fVG = true;
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    TbRichTextView.this.fVG = false;
                }
            }
        };
        this.mType = 19;
        this.eWs = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.3
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
        this.fVQ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int contentSizeOfLzl = TbRichTextView.this.fVF ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
                if (TbRichTextView.this.fVC != null && !x.isEmpty(TbRichTextView.this.fVC.bHf())) {
                    Iterator<TbRichTextData> it = TbRichTextView.this.fVC.bHf().iterator();
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
        this.fRY.b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        bHX();
    }

    public com.baidu.tbadk.widget.richText.a getLayoutStrategy() {
        return this.fRY;
    }

    public void setLayoutStrategy(com.baidu.tbadk.widget.richText.a aVar) {
        if (aVar != null) {
            this.fRY.release();
            this.fRY = aVar;
            bHX();
            if (this.alQ != null) {
                this.alQ.setLayoutStrategy(this.fRY);
            }
        }
    }

    private void bHX() {
        int contentSizeOfLzl = this.fVF ? TbConfig.getContentSizeOfLzl() : TbConfig.getContentSize();
        this.fRY.fTQ = contentSizeOfLzl;
        this.fRY.fTP = contentSizeOfLzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void init() {
        com.baidu.tbadk.widget.richText.h hVar;
        com.baidu.tbadk.widget.richText.h hVar2;
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(getContext());
        if (getContext() instanceof com.baidu.tbadk.widget.richText.h) {
            hVar = (com.baidu.tbadk.widget.richText.h) getContext();
        } else if (K == null || !(K.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
            hVar = null;
        } else {
            hVar = (com.baidu.tbadk.widget.richText.h) K.getOrignalPage();
        }
        if (hVar == null && (getContext() instanceof BaseFragmentActivity)) {
            List<Fragment> fragments = ((BaseFragmentActivity) getContext()).getSupportFragmentManager().getFragments();
            if (!x.isEmpty(fragments) && (fragments.get(0) instanceof com.baidu.tbadk.widget.richText.h)) {
                hVar2 = (com.baidu.tbadk.widget.richText.h) fragments.get(0);
                if (K != null) {
                    K.registerListener(this.fVQ);
                }
                if (hVar2 != null) {
                    this.fRW = hVar2.bHO();
                    this.fVl = hVar2.bHP();
                    this.fVm = hVar2.bHR();
                    this.fVn = hVar2.bHS();
                    this.fRX = hVar2.bHQ();
                    this.fVo = hVar2.bHT();
                    if (hVar2.getListView() != null && this.fVr == null) {
                        this.fVr = new k(hVar2.bHN());
                        hVar2.getListView().setRecyclerListener(this.fVr);
                    }
                }
                this.fVJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
                setOrientation(1);
                setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        if (view2 instanceof GifView) {
                            Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag instanceof d) || !((d) tag).fVV) {
                                if (TbRichTextView.this.fRX != null) {
                                    TbRichTextView.this.fRX.returnObject((GifView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.fVk == null) {
                                    TbRichTextView.this.fVk = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.fVk.returnObject((ImageView) view2);
                            }
                        } else if (view2 instanceof ImageView) {
                            Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                            if (!(tag2 instanceof d) || !((d) tag2).fVV) {
                                if (TbRichTextView.this.fRW != null) {
                                    TbRichTextView.this.fRW.returnObject((ImageView) view2);
                                }
                            } else {
                                if (TbRichTextView.this.fVk == null) {
                                    TbRichTextView.this.fVk = TbRichTextView.this.getRecycleImageViewPool();
                                }
                                TbRichTextView.this.fVk.returnObject((ImageView) view2);
                            }
                        } else if ((view2 instanceof TextView) && TbRichTextView.this.fVl != null) {
                            TbRichTextView.this.fVl.returnObject((TextView) view2);
                        } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.fVm != null) {
                            TbRichTextView.this.fVm.returnObject(view2);
                        } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fVm != null) {
                            TbRichTextView.this.fVm.returnObject(view2);
                        } else if (view2 instanceof GridImageLayout) {
                            int childCount = ((GridImageLayout) view2).getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = ((GridImageLayout) view2).getChildAt(i2);
                                if ((childAt instanceof GifView) && TbRichTextView.this.fRX != null) {
                                    TbRichTextView.this.fRX.returnObject((GifView) childAt);
                                } else if ((childAt instanceof ImageView) && TbRichTextView.this.fRW != null) {
                                    TbRichTextView.this.fRW.returnObject((ImageView) childAt);
                                }
                            }
                            ((GridImageLayout) view2).removeAllViews();
                            ((GridImageLayout) view2).clearData();
                        } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.fVo != null) {
                            TbRichTextView.this.fVo.returnObject((RelativeLayout) view2);
                        }
                        if (view2 instanceof LinearLayout) {
                            Object tag3 = view2.getTag();
                            if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                                if (TbRichTextView.this.fVn != null) {
                                    int childCount2 = ((LinearLayout) view2).getChildCount();
                                    for (int i3 = 0; i3 < childCount2; i3++) {
                                        View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                        if (childAt2 != null) {
                                            if ((childAt2 instanceof TextView) && TbRichTextView.this.fVl != null) {
                                                TbRichTextView.this.fVl.returnObject((TextView) childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.fVm != null) {
                                                TbRichTextView.this.fVm.returnObject(childAt2);
                                            } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fVm != null) {
                                                TbRichTextView.this.fVm.returnObject(childAt2);
                                            }
                                        }
                                    }
                                    ((LinearLayout) view2).removeAllViews();
                                    TbRichTextView.this.fVn.returnObject((LinearLayout) view2);
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
        if (K != null) {
        }
        if (hVar2 != null) {
        }
        this.fVJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds21);
        setOrientation(1);
        setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.10
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if (view2 instanceof GifView) {
                    Object tag = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag instanceof d) || !((d) tag).fVV) {
                        if (TbRichTextView.this.fRX != null) {
                            TbRichTextView.this.fRX.returnObject((GifView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.fVk == null) {
                            TbRichTextView.this.fVk = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.fVk.returnObject((ImageView) view2);
                    }
                } else if (view2 instanceof ImageView) {
                    Object tag2 = view2.getTag(R.id.tag_rich_text_view_recycle);
                    if (!(tag2 instanceof d) || !((d) tag2).fVV) {
                        if (TbRichTextView.this.fRW != null) {
                            TbRichTextView.this.fRW.returnObject((ImageView) view2);
                        }
                    } else {
                        if (TbRichTextView.this.fVk == null) {
                            TbRichTextView.this.fVk = TbRichTextView.this.getRecycleImageViewPool();
                        }
                        TbRichTextView.this.fVk.returnObject((ImageView) view2);
                    }
                } else if ((view2 instanceof TextView) && TbRichTextView.this.fVl != null) {
                    TbRichTextView.this.fVl.returnObject((TextView) view2);
                } else if ((view2 instanceof PlayVoiceBnt) && TbRichTextView.this.fVm != null) {
                    TbRichTextView.this.fVm.returnObject(view2);
                } else if ((view2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fVm != null) {
                    TbRichTextView.this.fVm.returnObject(view2);
                } else if (view2 instanceof GridImageLayout) {
                    int childCount = ((GridImageLayout) view2).getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = ((GridImageLayout) view2).getChildAt(i2);
                        if ((childAt instanceof GifView) && TbRichTextView.this.fRX != null) {
                            TbRichTextView.this.fRX.returnObject((GifView) childAt);
                        } else if ((childAt instanceof ImageView) && TbRichTextView.this.fRW != null) {
                            TbRichTextView.this.fRW.returnObject((ImageView) childAt);
                        }
                    }
                    ((GridImageLayout) view2).removeAllViews();
                    ((GridImageLayout) view2).clearData();
                } else if ((view2 instanceof RelativeLayout) && TbRichTextView.this.fVo != null) {
                    TbRichTextView.this.fVo.returnObject((RelativeLayout) view2);
                }
                if (view2 instanceof LinearLayout) {
                    Object tag3 = view2.getTag();
                    if (tag3 == null || !(tag3 instanceof String) || !"VideoView".equals(tag3)) {
                        if (TbRichTextView.this.fVn != null) {
                            int childCount2 = ((LinearLayout) view2).getChildCount();
                            for (int i3 = 0; i3 < childCount2; i3++) {
                                View childAt2 = ((LinearLayout) view2).getChildAt(i3);
                                if (childAt2 != null) {
                                    if ((childAt2 instanceof TextView) && TbRichTextView.this.fVl != null) {
                                        TbRichTextView.this.fVl.returnObject((TextView) childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBnt) && TbRichTextView.this.fVm != null) {
                                        TbRichTextView.this.fVm.returnObject(childAt2);
                                    } else if ((childAt2 instanceof PlayVoiceBntNew) && TbRichTextView.this.fVm != null) {
                                        TbRichTextView.this.fVm.returnObject(childAt2);
                                    }
                                }
                            }
                            ((LinearLayout) view2).removeAllViews();
                            TbRichTextView.this.fVn.returnObject((LinearLayout) view2);
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
        ArrayList<TbRichTextData> bHf;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        SpannableStringBuilder bHm;
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
        if (this.fVC != tbRichText || (tbRichText != null && tbRichText.isChanged)) {
            if (tbRichText != null) {
                tbRichText.isChanged = false;
            }
            this.fVC = tbRichText;
            removeAllViews();
            if (tbRichText != null && (bHf = tbRichText.bHf()) != null) {
                Object obj = null;
                View view2 = null;
                boolean z11 = true;
                Iterator<TbRichTextData> it = bHf.iterator();
                boolean z12 = false;
                int i5 = 0;
                int i6 = 0;
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        if (next.getType() == 1) {
                            TextView fC = fC(getContext());
                            boolean a2 = a(next, fC, true, cVar);
                            if (z && !this.fVA && (bHm = next.bHm()) != null) {
                                this.fVA = bHm.length() >= 200;
                            }
                            if (this.ftt != null) {
                                fC.setOnTouchListener(this.fNi);
                            } else {
                                fC.setOnClickListener(this.fVt);
                            }
                            z4 = a2;
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = fC;
                        } else if (next.getType() == 8) {
                            if (!this.fVH) {
                                if (i6 < 10) {
                                    i6++;
                                    if (next.bHl() != null) {
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.bHl().bHD()) {
                                            GifView gifView3 = null;
                                            gifView3 = null;
                                            boolean z13 = false;
                                            if (z3) {
                                                String bHz = next.bHl().bHz();
                                                if (StringUtils.isNull(bHz)) {
                                                    if (this.fRY.fUj) {
                                                        bHz = this.fRY.mIsFromCDN ? next.bHl().bHv() : next.bHl().bHx();
                                                    }
                                                    if (StringUtils.isNull(bHz)) {
                                                        bHz = this.fRY.mIsFromCDN ? next.bHl().bHy() : next.bHl().getSrc();
                                                    }
                                                }
                                                if (this.fVk != null) {
                                                    ImageView ay = this.fVk.ay(bHz);
                                                    if (ay instanceof GifView) {
                                                        gifView3 = (GifView) ay;
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
                                            bVar.fVU = true;
                                            gifView.setTag(R.id.tag_rich_text_view_gif_view, bVar);
                                            boolean a3 = a(next, gifView, z13);
                                            if (z2) {
                                                d dVar = new d();
                                                dVar.fVV = true;
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
                                                imageView = fB(getContext());
                                            } else {
                                                String bHv = this.fRY.bHe() ? next.bHl().bHv() : next.bHl().bHy();
                                                if (this.fVk != null) {
                                                    imageView3 = this.fVk.ay(bHv);
                                                }
                                                if (imageView3 == null) {
                                                    z8 = false;
                                                    imageView2 = fB(getContext());
                                                } else {
                                                    z8 = true;
                                                    imageView2 = imageView3;
                                                }
                                                z7 = z8;
                                                imageView = imageView2;
                                            }
                                            boolean a4 = a(next, imageView, this.fRY.fTR, this.fRY.fTS, z7);
                                            if (z2) {
                                                d dVar2 = new d();
                                                dVar2.fVV = true;
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
                                gridImageView.setData(tbRichText.bHg());
                                z4 = true;
                                z5 = true;
                                i2 = i5;
                                i3 = i6;
                                relativeLayout = gridImageView;
                            }
                        } else if (next.getType() == 32) {
                            com.baidu.tbadk.widget.richText.i bHp = next.bHp();
                            if (bHp != null && bHp.bHV()) {
                                linearLayout = b(bHp);
                            } else {
                                linearLayout = a(next);
                            }
                            z4 = true;
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6;
                            relativeLayout = linearLayout;
                        } else if (next.getType() == 512) {
                            View ce = ce(view2);
                            if (ce == null) {
                                obj = ce;
                            } else {
                                z4 = a(next, ce);
                                z5 = z12 ? 1 : 0;
                                i2 = i5;
                                i3 = i6;
                                relativeLayout = ce;
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
                                if (next == null || next.bHr() == null || next.bHr().memeInfo == null || StringUtils.isNull(next.bHr().memeInfo.pic_url)) {
                                    z10 = false;
                                } else {
                                    z10 = true;
                                }
                                if (z10) {
                                    RelativeLayout borrowObject = this.fVo.borrowObject();
                                    borrowObject.removeAllViews();
                                    borrowObject.setLayoutParams(new LinearLayout.LayoutParams(next.bHr().memeInfo.width.intValue(), next.bHr().memeInfo.height.intValue()));
                                    if (DuiSwitch.getInOn() && this.fVp) {
                                        b(borrowObject, next.bHr().memeInfo.width.intValue(), next.bHr().memeInfo.height.intValue(), this.fRY.fTR, this.fRY.fTS);
                                    } else {
                                        a(borrowObject, next.bHr().memeInfo.width.intValue(), next.bHr().memeInfo.height.intValue(), this.fRY.fTR, this.fRY.fTS);
                                    }
                                    ImageView borrowObject2 = this.fRW.borrowObject();
                                    b(next, borrowObject2, this.fRY.fTR, this.fRY.fTS);
                                    if (DuiSwitch.getInOn() && this.fVp) {
                                        ImageView borrowObject3 = this.fRW.borrowObject();
                                        borrowObject3.setTag(this.fVC);
                                        if (borrowObject3 instanceof TbImageView) {
                                            TbImageView tbImageView = (TbImageView) borrowObject3;
                                            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                                            tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
                                            tbImageView.setBorderSurroundContent(true);
                                            tbImageView.setDrawCorner(true);
                                            tbImageView.setDrawBorder(true);
                                            tbImageView.setLongIconSupport(true);
                                            tbImageView.setGifIconSupport(true);
                                            tbImageView.setConrers(15);
                                            tbImageView.setRadius(this.fVJ);
                                            tbImageView.setAdjustViewBounds(false);
                                            if (this.fVH) {
                                                tbImageView.setPlaceHolder(2);
                                            } else {
                                                tbImageView.setPlaceHolder(3);
                                            }
                                        }
                                        borrowObject3.setScaleType(ImageView.ScaleType.FIT_XY);
                                        int dimens = l.getDimens(getContext(), R.dimen.ds78);
                                        int dimens2 = l.getDimens(getContext(), R.dimen.ds78);
                                        borrowObject2.setId(R.id.meme_image_view);
                                        c(borrowObject2, next.bHr().memeInfo.width.intValue(), next.bHr().memeInfo.height.intValue(), this.fRY.fTR, this.fRY.fTS, this.mOnClickListener);
                                        borrowObject.addView(borrowObject2);
                                        if (dimens2 > next.bHr().memeInfo.height.intValue()) {
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
                                        ao.setImageResource(borrowObject3, R.drawable.icon_emotion_dui_n);
                                        borrowObject.addView(borrowObject3, layoutParams);
                                    } else {
                                        b(borrowObject2, next.bHr().memeInfo.width.intValue(), next.bHr().memeInfo.height.intValue(), this.fRY.fTR, this.fRY.fTS, this.mOnClickListener);
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
                                ItemCardView itemCardView = this.ahk;
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
                            ImageView fB = fB(getContext());
                            z4 = a(next, fB, (this.fRY.fTR - getPaddingLeft()) - getPaddingRight(), this.fRY.fTS);
                            z5 = z12 ? 1 : 0;
                            i2 = i5;
                            i3 = i6 + 1;
                            relativeLayout = fB;
                        }
                        if (!z4 || relativeLayout == null) {
                            z6 = z11;
                            view = view2;
                        } else {
                            addView(relativeLayout);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
                            if (z11 && this.fRY.fUh >= 0) {
                                z11 = false;
                                if (layoutParams2 != null) {
                                    layoutParams2.topMargin = this.fRY.fUh;
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z6 = false;
                                    view = relativeLayout;
                                }
                                z6 = z11;
                                view = relativeLayout;
                            } else {
                                if (relativeLayout instanceof TbListTextView) {
                                    if ((view2 instanceof ImageView) || (view2 instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.fRY.fUd;
                                    } else {
                                        layoutParams2.topMargin = this.fRY.fTN;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z6 = z11;
                                } else if (((relativeLayout instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) && (next.getType() == 8 || next.getType() == 20 || next.getType() == 17)) {
                                    if (view2 instanceof TbListTextView) {
                                        layoutParams2.topMargin = this.fRY.fUb;
                                    } else if ((view2 instanceof ImageView) || (relativeLayout instanceof RelativeLayout)) {
                                        layoutParams2.topMargin = this.fRY.fUa;
                                    } else {
                                        layoutParams2.topMargin = this.fRY.fTN;
                                    }
                                    relativeLayout.setLayoutParams(layoutParams2);
                                    z6 = z11;
                                } else {
                                    if ((relativeLayout instanceof ItemCardView) && !z11) {
                                        layoutParams2.topMargin = this.fRY.fUi;
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
                    layoutParams3.bottomMargin = this.fRY.fUg;
                    view2.setLayoutParams(layoutParams3);
                } else if (view2 != null && this.fRY.fUf >= 0) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                    layoutParams4.bottomMargin = this.fRY.fUf;
                    view2.setLayoutParams(layoutParams4);
                }
                if (!z2 && this.fVk != null) {
                    this.fVk.clear();
                }
            }
        }
    }

    private GridImageLayout getGridImageView() {
        if (this.alQ == null || this.alQ.getParent() != null) {
            this.alQ = new GridImageLayout(getContext());
            this.alQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.alQ.setLayoutStrategy(this.fRY);
        this.alQ.setObjectPool(this.fRW, this.fRX);
        this.alQ.setOnImageClickListener(this.fSh);
        if (this.fVu != null) {
            this.alQ.setOnClickListener(this.fVu);
        }
        this.alQ.setIsHost(this.isHost);
        if (this.fVI) {
            this.alQ.setOnLongClickListener(this.onLongClickListener);
        }
        return this.alQ;
    }

    public void setCommonTextViewOnClickListener(View.OnClickListener onClickListener) {
        this.fVt = onClickListener;
    }

    private View b(final com.baidu.tbadk.widget.richText.i iVar) {
        if (iVar == null || !iVar.isAvaliable()) {
            return null;
        }
        ImageView borrowObject = this.fRW.borrowObject();
        if (borrowObject instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) borrowObject;
            foreDrawableImageView.setForegroundDrawable(R.drawable.icon_play_video);
            foreDrawableImageView.setNoImageBottomTextColor(R.color.CAM_X0108);
            foreDrawableImageView.setNoImageBottomTextPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds32));
            foreDrawableImageView.setNoImageBottomTextSize(TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.fontsize28));
            foreDrawableImageView.setNoImageBottomText("点击播放视频");
            foreDrawableImageView.setInterceptOnClick(false);
            foreDrawableImageView.setTag("VideoView");
            b(foreDrawableImageView, iVar.getWidth(), iVar.getHeight(), (this.fRY.fTR - getPaddingLeft()) - getPaddingRight(), this.fRY.fTS, new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(TbadkCoreStatisticKey.KEY_RICH_TEXT_VIDEO_CLICK);
                    XiaoyingUtil.startPlayXiaoyingVideo(TbRichTextView.this.getContext(), iVar.getVideoUrl(), iVar.getWidth(), iVar.getHeight(), iVar.getThumbUrl());
                }
            });
            foreDrawableImageView.setDefaultResource(0);
            foreDrawableImageView.setSupportNoImage(this.fRY.fTY);
            if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
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
        int[] B = this.fRY.B(i2, i3, i4, i5);
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
        if (this.fRY.fTZ) {
            imageView.setScaleType(this.fRY.fTX);
            if (imageView instanceof TbImageView) {
                ((TbImageView) imageView).setOnDrawListener(this.fRY.alg);
            }
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ftt != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.fNi);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fVN);
                imageView.setOnLongClickListener(this.onLongClickListener);
            }
        } else if ((imageView instanceof GifView) && this.onLongClickListener != null) {
            ((GifView) imageView).setDispatchTouchListener(this.fVN);
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
        if (!this.fRY.fTZ || i4 <= i7 || fTK <= 1.0f) {
            i6 = i8;
            i4 = i7;
        } else {
            if (i7 * fTK <= i4) {
                if (i7 * fTK > i4 * 0.68f) {
                    i4 = (int) (i4 * 0.68f);
                } else {
                    i4 = (int) (i7 * fTK);
                }
            }
            i6 = iArr[0] > 0 ? (iArr[1] * i4) / iArr[0] : i8;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setDefaultResource(this.fRY.fTT);
            if (tbImageView.getGifIconWidth() >= i4 || tbImageView.getGifIconHeight() >= i6) {
                tbImageView.setGifIconSupport(false);
            } else {
                tbImageView.setGifIconSupport(true);
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i6);
        if (this.fRY.fTZ) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ftt != null && (imageView instanceof TbImageView)) {
            ((TbImageView) imageView).setTbGestureDetector(this.fNi);
            imageView.setClickable(true);
        } else {
            imageView.setOnClickListener(onClickListener);
        }
        imageView.setLayoutParams(layoutParams);
        if (imageView instanceof TbImageView) {
            if (this.onLongClickListener != null) {
                ((TbImageView) imageView).setDispatchTouchListener(this.fVN);
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
        if (this.fRY.fTZ && i4 > i7 && fTK > 1.0f) {
            if (i7 * fTK > i4) {
                i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
            } else if (i7 * fTK > i4 * 0.68f) {
                i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
            } else {
                i7 = (int) (i7 * fTK);
            }
            if (iArr[0] > 0) {
                i8 = (iArr[1] * i7) / iArr[0];
                i6 = i7;
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setDefaultResource(this.fRY.fTT);
                    if (tbImageView.getGifIconWidth() >= i6 || tbImageView.getGifIconHeight() >= i8) {
                        tbImageView.setGifIconSupport(false);
                    } else {
                        tbImageView.setGifIconSupport(true);
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i8);
                if (!this.fRY.fTZ) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                imageView.setClickable(true);
                imageView.setFocusable(false);
                if (this.ftt == null && (imageView instanceof TbImageView)) {
                    ((TbImageView) imageView).setTbGestureDetector(this.fNi);
                    imageView.setClickable(true);
                } else {
                    imageView.setOnClickListener(onClickListener);
                }
                imageView.setLayoutParams(layoutParams);
                if (!(imageView instanceof TbImageView)) {
                    if (this.onLongClickListener != null) {
                        ((TbImageView) imageView).setDispatchTouchListener(this.fVN);
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
        if (!this.fRY.fTZ) {
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        if (this.ftt == null) {
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
            if (!this.fRY.fTZ || i4 <= i6 || fTK <= 1.0f) {
                i4 = i6;
            } else {
                if (i6 * fTK <= i4) {
                    if (i6 * fTK > i4 * 0.68f) {
                        i4 = (int) (i4 * 0.68f);
                    } else {
                        i4 = (int) (i6 * fTK);
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
            if (this.fRY.fTZ && i4 > i8 && fTK > 1.0f) {
                if (i8 * fTK > i4) {
                    i7 = (i4 - l.getDimens(getContext(), R.dimen.ds78)) - l.getDimens(getContext(), R.dimen.ds16);
                } else if (i8 * fTK > i4 * 0.68f) {
                    i7 = ((int) (i4 * 0.68f)) - l.getDimens(getContext(), R.dimen.ds78);
                } else {
                    i7 = (int) (i8 * fTK);
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
        if (this.fRY.fTU <= 0 || tbRichTextData == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setTag("VideoView");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.fRY.fTN;
        linearLayout.setClickable(true);
        Bitmap bitmap = ao.getBitmap(this.fRY.fTU);
        if (bitmap != null) {
            linearLayout.setBackgroundDrawable(new BitmapDrawable(getContext().getResources(), bitmap));
        }
        linearLayout.setFocusable(false);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tbRichTextData.bHm() != null) {
                    if (TbRichTextView.this.getContext() instanceof com.baidu.tbadk.widget.richText.h) {
                        ((com.baidu.tbadk.widget.richText.h) TbRichTextView.this.getContext()).aG(TbRichTextView.this.getContext(), tbRichTextData.bHm().toString());
                        return;
                    }
                    com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(TbRichTextView.this.getContext());
                    if (K != null && (K.getOrignalPage() instanceof com.baidu.tbadk.widget.richText.h)) {
                        ((com.baidu.tbadk.widget.richText.h) K.getOrignalPage()).aG(TbRichTextView.this.getContext(), tbRichTextData.bHm().toString());
                    }
                }
            }
        });
        return linearLayout;
    }

    private ImageView fB(Context context) {
        ImageView borrowObject = this.fRW != null ? this.fRW.borrowObject() : null;
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
        TbRichTextLinkImageInfo bHt = tbRichTextData.bHt();
        if (bHt != null && bHt.getLink() != null) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                if (this.fRY.fTY) {
                    tbImageView.setSupportNoImage(true);
                }
                tbImageView.startLoad(bHt.bHM(), this.mIsFromCDN ? 17 : 18, false);
                tbImageView.setTag(new e(bHt.getLink()));
                if (!bHt.bHA()) {
                    tbImageView.setAdjustViewBounds(false);
                }
            }
            return b(imageView, bHt.getWidth(), bHt.getHeight(), i2, i3, this.fVM);
        }
        return false;
    }

    private boolean b(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.bHr() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.fVJ);
            if (this.fVH) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.fRY.fTY) {
                tbImageView.setSupportNoImage(true);
            }
            tbImageView.startLoad(tbRichTextData.bHr().memeInfo.pic_url, this.mIsFromCDN ? 17 : 18, false);
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setTag(R.id.tag_rich_text_meme_info, tbRichTextData.bHr());
        }
        return b(imageView, tbRichTextData.bHr().memeInfo.width.intValue(), tbRichTextData.bHr().memeInfo.height.intValue(), i2, i3, this.mOnClickListener);
    }

    private boolean a(TbRichTextData tbRichTextData, ImageView imageView, int i2, int i3, boolean z) {
        if (tbRichTextData == null || imageView == null) {
            return false;
        }
        if (tbRichTextData.bHl() == null) {
            return false;
        }
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
            tbImageView.setTLIconType(tbRichTextData.getIconType());
            tbImageView.setConrers(15);
            tbImageView.setRadius(this.fVJ);
            if (this.fVH) {
                tbImageView.setPlaceHolder(2);
            } else {
                tbImageView.setPlaceHolder(3);
            }
            if (this.fRY.fTY) {
                tbImageView.setSupportNoImage(true);
            }
            String bHv = this.fRY.bHe() ? tbRichTextData.bHl().bHv() : tbRichTextData.bHl().bHy();
            if (!z || tbImageView.getUrl() == null || !tbImageView.getUrl().equals(bHv)) {
                tbImageView.startLoad(bHv, this.mIsFromCDN ? 17 : 18, false);
            }
            if (!tbRichTextData.bHl().bHA()) {
                tbImageView.setAdjustViewBounds(false);
            }
            tbImageView.setTag(R.id.tag_rich_text_meme_info, null);
        }
        return a(imageView, tbRichTextData.bHl().getWidth(), tbRichTextData.bHl().getHeight(), i2, i3, this.mOnClickListener);
    }

    private TextView fC(Context context) {
        TextView textView = null;
        if (this.fVl != null) {
            textView = this.fVl.borrowObject();
        }
        if (textView == null || textView.getParent() != null) {
            textView = new TbListTextView(context);
        }
        textView.setPadding(this.fRY.dva, 0, this.fRY.dva, 0);
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
        if (this.fVD) {
            layoutParams.gravity = 16;
            textView.setGravity(16);
        } else {
            layoutParams.topMargin = this.fRY.fTN;
        }
        textView.setLineSpacing(this.fRY.fTM, this.fRY.fTL);
        textView.setTextSize(0, this.fRY.mTextSize);
        if (this.fRY.fTO) {
            com.baidu.tbadk.core.elementsMaven.c.bv(textView).nX(R.string.F_X02);
        }
        textView.setTextColor(this.fRY.mTextColor);
        textView.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        textView.setHighlightColor(getContext().getResources().getColor(R.color.transparent));
        textView.setSingleLine(this.fRY.fTV);
        if (this.fVq != null) {
            textView.setEllipsize(this.fVq);
        }
        if (this.fVK) {
            float[] nL = com.baidu.tbadk.core.elementsMaven.a.nL(R.array.S_O_X001);
            textView.setShadowLayer(nL[1], nL[2], nL[3], (int) nL[0]);
        }
        if (this.mMaxWidth > 0) {
            textView.setMaxWidth(this.mMaxWidth);
        }
        if (this.dBq > 0) {
            textView.setMaxLines(this.dBq);
        }
        if (tbRichTextData == null) {
            return false;
        }
        SpannableStringBuilder bHm = tbRichTextData.bHm();
        if (bHm == null || bHm.length() <= 0) {
            return false;
        }
        if (this.fRY.fTQ > 0 && this.fRY.fTP > 0) {
            tbRichTextData.bt(this.fRY.fTP, this.fRY.fTQ);
        }
        if (cVar != null) {
            cVar.a(bHm, textView, this);
        }
        try {
            textView.setText(bHm);
        } catch (Exception e2) {
            textView.setText("");
        }
        if (this.fVE) {
            if (tbRichTextData.bHu()) {
                textView.setMovementMethod(com.baidu.tieba.view.c.dTE());
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        textView.setFocusable(false);
        textView.setLayoutParams(layoutParams);
        textView.setTag(tbRichTextData);
        if (tbRichTextData != null && tbRichTextData.bHo() != null) {
            tbRichTextData.bHo().needRecompute = this.fVO;
        }
        return true;
    }

    private GifView getGifView() {
        GifView gifView = null;
        if (this.fRX != null) {
            gifView = this.fRX.borrowObject();
        }
        GifView gifView2 = (gifView == null || gifView.getParent() != null) ? new GifView(getContext()) : gifView;
        gifView2.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        gifView2.setBorderColor(ao.getColor(R.color.CAM_X0401));
        gifView2.setBorderSurroundContent(true);
        gifView2.setDrawCorner(true);
        gifView2.setDrawBorder(true);
        gifView2.setConrers(15);
        gifView2.setDrawBorder(true);
        gifView2.setRadius(this.fVJ);
        if (this.fVH) {
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
        if (layoutParams == null || layoutParams.width != tbRichTextData.bHq().mGifInfo.mGifWidth || layoutParams.height != tbRichTextData.bHq().mGifInfo.mGifHeight) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(tbRichTextData.bHq().mGifInfo.mGifWidth, tbRichTextData.bHq().mGifInfo.mGifHeight);
            layoutParams2.gravity = 3;
            gifView.setLayoutParams(layoutParams2);
        } else {
            layoutParams.bottomMargin = 0;
        }
        gifView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbRichTextView.this.fVB != null) {
                    TbRichTextEmotionInfo bHq = tbRichTextData.bHq();
                    TbRichTextView.this.fVB.a(view, bHq.mGifInfo.mGid, bHq.mGifInfo.mPackageName, bHq.mGifInfo.mIcon, bHq.mGifInfo.mStaticUrl, bHq.mGifInfo.mDynamicUrl, bHq.mGifInfo.mSharpText, bHq.mGifInfo.mGifWidth, bHq.mGifInfo.mGifHeight);
                }
            }
        });
        gifView.a(tbRichTextData.bHq().mGifInfo);
        return true;
    }

    private boolean a(TbRichTextData tbRichTextData, GifView gifView, boolean z) {
        if (gifView == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            gifView.setDefaultNoImageDay(ao.c(getContext().getResources(), R.drawable.icon_click));
        } else {
            gifView.setDefaultNoImageDay(R.drawable.icon_click);
        }
        Drawable drawable = ao.getDrawable(R.color.CAM_X0209);
        if (drawable != null) {
            gifView.setBackgroundDrawable(drawable);
        } else {
            gifView.setBackgroundDrawable(ao.getDrawable(R.color.common_color_10220));
        }
        String bHz = tbRichTextData.bHl().bHz();
        if (StringUtils.isNull(bHz)) {
            if (this.fRY.fUj) {
                bHz = this.fRY.mIsFromCDN ? tbRichTextData.bHl().bHv() : tbRichTextData.bHl().bHx();
            }
            if (StringUtils.isNull(bHz)) {
                bHz = this.fRY.mIsFromCDN ? tbRichTextData.bHl().bHy() : tbRichTextData.bHl().getSrc();
            }
        }
        gifView.setShowStaticDrawable(false);
        if (!z || gifView.getUrl() == null || !gifView.getUrl().equals(bHz)) {
            gifView.ax(bHz, 38);
        }
        return a(gifView, tbRichTextData.bHl().getWidth(), tbRichTextData.bHl().getHeight(), this.fRY.fTR, this.fRY.fTS, this.mOnClickListener);
    }

    private View ce(View view) {
        View borrowObject = this.fVm != null ? this.fVm.borrowObject() : null;
        if ((borrowObject == null || borrowObject.getParent() != null) && this.fVw != -1) {
            borrowObject = LayoutInflater.from(getContext()).inflate(this.fVw, (ViewGroup) null);
        }
        if (borrowObject != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if ((view instanceof TbListTextView) && this.fRY.fUc >= 0) {
                layoutParams.topMargin = this.fRY.fUc;
            } else {
                layoutParams.topMargin = this.fRY.fTN;
            }
            layoutParams.bottomMargin = this.fRY.fUe;
            borrowObject.setLayoutParams(layoutParams);
            if (borrowObject instanceof PlayVoiceBntNew) {
                ((PlayVoiceBntNew) borrowObject).setAfterClickListener(this.fVx);
                return borrowObject;
            }
            return borrowObject;
        }
        return null;
    }

    private boolean a(TbRichTextData tbRichTextData, View view) {
        view.setTag(tbRichTextData.bHn());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        view.setLayoutParams(layoutParams);
        if (view instanceof PlayVoiceBntNew) {
            ((PlayVoiceBntNew) view).btU();
            return true;
        }
        return true;
    }

    private View getTextVoiceView() {
        LinearLayout borrowObject = this.fVn.borrowObject();
        if (borrowObject != null) {
            TextView fC = fC(getContext());
            if (fC == null) {
                this.fVn.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(fC);
            View ce = ce(null);
            if (ce == null) {
                this.fVl.returnObject(fC);
                this.fVn.returnObject(borrowObject);
                return null;
            }
            borrowObject.addView(ce);
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
        if (this.ahk == null) {
            this.ahk = new ItemCardView(getContext());
            this.ahk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", tbRichTextData.getEvaluateItemInfo().getItemID());
                    hashMap.put("source", 3);
                    TiebaStatic.log(new aq("common_click").dW("page_type", PageStayDurationConstants.PageName.PB).an("gua_type", 2).an("obj_locate", 16));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                }
            });
        }
        this.ahk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.ahk.setData(tbRichTextData.getEvaluateItemInfo(), 17);
        this.ahk.onChangeSkinType();
        return true;
    }

    public void setTextSize(float f2) {
        if (f2 != this.fRY.mTextSize) {
            this.fRY.mTextSize = f2;
            this.fRY.fTP = (int) f2;
            this.fRY.fTQ = (int) f2;
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
        this.fRY.fTO = true;
    }

    public void setTextColor(int i2) {
        if (i2 != this.fRY.mTextColor) {
            this.fRY.mTextColor = i2;
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
        if (this.fRY.dva != i2) {
            this.fRY.dva = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && (childAt instanceof TextView)) {
                    ((TextView) childAt).setPadding(this.fRY.dva, 0, 0, this.fRY.dva);
                }
            }
        }
    }

    public void setLinkTextColor(int i2) {
        if (i2 != this.fRY.fTW) {
            this.fRY.fTW = i2;
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
        this.fVp = z;
    }

    public i getOnImageClickListener() {
        return this.fSh;
    }

    public void setOnImageClickListener(i iVar) {
        this.fSh = iVar;
        if (this.alQ != null) {
            this.alQ.setOnImageClickListener(this.fSh);
        }
    }

    public void setOnImageTouchListener(com.baidu.tieba.pb.a.c cVar) {
        this.ftt = cVar;
    }

    public void setOnEmotionClickListener(h hVar) {
        this.fVB = hVar;
    }

    public void setDisplayImage(boolean z, boolean z2) {
        if (this.fVv != z) {
            this.fVv = z;
            if (z2) {
                requestLayout();
            }
            if (!this.fVv && this.fRW != null) {
                this.fRW.clear();
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
        this.fVy = false;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (!this.mHasPerformedLongPress) {
                    bHZ();
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.fVy) {
                    bHY();
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
        this.fVy = true;
        return super.onTouchEvent(motionEvent);
    }

    private void bHY() {
        this.mHasPerformedLongPress = false;
        if (this.fVz == null) {
            this.fVz = new a();
        }
        postDelayed(this.fVz, ViewConfiguration.getLongPressTimeout());
    }

    private void bHZ() {
        if (this.fVz != null) {
            removeCallbacks(this.fVz);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TbRichTextView.this.fVG && TbRichTextView.this.performLongClick()) {
                TbRichTextView.this.mHasPerformedLongPress = true;
            }
        }
    }

    public void setVoiceViewRes(int i2) {
        this.fVw = i2;
    }

    public void setOnVoiceAfterClickListener(View.OnClickListener onClickListener) {
        this.fVx = onClickListener;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.fVP != drawable) {
            this.fVO = true;
            this.fVP = drawable;
        }
        setText(this.fVC);
        this.fVO = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fRY != null) {
            this.fRY.release();
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
        this.fVL = fVar;
        DK(str);
    }

    public void DK(String str) {
        BdUniqueId bdUniqueId;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            this.mUrl = str;
            return;
        }
        getContext();
        com.baidu.adp.base.i I = com.baidu.adp.base.j.I(getContext());
        if (I != null) {
            bdUniqueId = I.getUniqueId();
            z = I.isScroll();
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
        com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.e.d.mx().loadResourceFromMemery(this.mUrl, 19, new Object[0]);
        if (aVar != null) {
            g(aVar);
        } else if (z) {
            invalidate();
        } else if (!com.baidu.adp.lib.e.d.mx().ax(19)) {
            invalidate();
        } else {
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, 19, this.eWs, 0, 0, this.mPageId, new Object[0]);
        }
    }

    public void stopLoad() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.e.d.mx().a(this.mUrl, 19, this.eWs);
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
                if (this.fVL != null) {
                    this.fVL.bIc();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.i
    public void refresh() {
        DK(this.mUrl);
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
        return this.fVs;
    }

    public void setOnLinkImageClickListener(j jVar) {
        this.fVs = jVar;
    }

    public void setHasMovementMethod(boolean z) {
        this.fVE = z;
    }

    public void setTextCenter(boolean z) {
        this.fVD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        boolean fVU;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {
        boolean fVV;

        private d() {
        }
    }

    public com.baidu.tieba.pb.a<ImageView> getRecycleImageViewPool() {
        if (this.fVk == null) {
            this.fVk = new com.baidu.tieba.pb.a<ImageView>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIa */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(com.baidu.adp.base.j.K(TbRichTextView.this.getContext()).getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkB().isShowImages();
                    foreDrawableImageView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
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
                /* renamed from: c */
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
                /* renamed from: d */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
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
                /* renamed from: e */
                public ImageView passivateObject(ImageView imageView) {
                    return imageView;
                }
            }, 10, 0) { // from class: com.baidu.tbadk.widget.richText.TbRichTextView.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.pb.a
                /* renamed from: ax */
                public ImageView ay(Object obj) {
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
        return this.fVk;
    }

    public TbRichText getRichText() {
        return this.fVC;
    }

    public void setmGridEmptyClickListener(View.OnClickListener onClickListener) {
        this.fVu = onClickListener;
    }
}
