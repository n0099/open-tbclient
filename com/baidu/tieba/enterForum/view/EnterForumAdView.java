package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes2.dex */
public class EnterForumAdView extends FrameLayout {
    private int iGt;
    private Drawable iOG;
    private Drawable iOH;
    private Drawable iOI;
    private Drawable iOJ;
    private boolean iOK;
    private TbImageView iOL;
    private ViewEventCenter iOM;
    private boolean iON;
    private com.baidu.tieba.enterForum.data.b iOO;
    private a iOP;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes2.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iOK = false;
        this.iON = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iOK = false;
        this.iON = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iOK = false;
        this.iON = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iOJ = new ColorDrawable(1241513984);
        this.iOG = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iOH = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iOI = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iOP == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iOP.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iOM = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        czU();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iOL.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iOL.setLayoutParams(layoutParams2);
    }

    private void czU() {
        aq a2;
        if (this.iOL == null) {
            this.iOL = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iOL.setPlaceHolder(3);
            this.iOL.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iOK = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b czf = EnterForumDelegateStatic.iHt.czf();
        if (czf != null && czf.isValid()) {
            this.iOK = true;
            this.iOL.startLoad(czf.iGo, 38, false);
            invalidate();
            if (this.iOM != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iGq = true;
                cVar.iGr = false;
                cVar.iGs = getBottom();
                cVar.iGt = this.iGt;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iOM.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iOO != czf && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(czf.iGn), String.valueOf(czf.iGn), 5)) != null) {
                com.baidu.tieba.s.c.dNY().a(this.mTag, com.baidu.tieba.s.a.Ta("" + czf.iGn), a2);
                com.baidu.tieba.s.c.dNY().b(this.mTag, false);
            }
        } else {
            if (this.iOM != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iGq = false;
                cVar2.iGr = false;
                cVar2.iGs = getBottom();
                cVar2.iGt = this.iGt;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iOM.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iOO = czf;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iOJ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iOG.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iOH.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iOI.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iOG.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.iHt.czf() != null && this.iOM != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iGq = true;
            cVar.iGr = false;
            cVar.iGs = i4;
            cVar.iGt = this.iGt;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iOM.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iOK) {
            this.iOJ.draw(canvas);
        }
        this.iOG.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iGt = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b czf = EnterForumDelegateStatic.iHt.czf();
        if (czf != null) {
            String str = EnterForumDelegateStatic.iHt.czf().aJH;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(czf.iGn), String.valueOf(czf.iGn), 5)) != null) {
                    com.baidu.tieba.s.c.dNY().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iON = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean czV() {
        return this.iON;
    }

    public boolean czW() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iOL;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iOP = aVar;
    }
}
