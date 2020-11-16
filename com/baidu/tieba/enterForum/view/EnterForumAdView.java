package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes21.dex */
public class EnterForumAdView extends FrameLayout {
    private int ijl;
    private Drawable irA;
    private Drawable irB;
    private Drawable irC;
    private Drawable irD;
    private boolean irE;
    private TbImageView irF;
    private ViewEventCenter irG;
    private boolean irH;
    private com.baidu.tieba.enterForum.data.b irI;
    private a irJ;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes21.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.irE = false;
        this.irH = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.irE = false;
        this.irH = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.irE = false;
        this.irH = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.irD = new ColorDrawable(1241513984);
        this.irA = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.irB = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.irC = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.irJ == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.irJ.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.irG = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        csK();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.irF.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.irF.setLayoutParams(layoutParams2);
    }

    private void csK() {
        ar a2;
        if (this.irF == null) {
            this.irF = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.irF.setPlaceHolder(3);
            this.irF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.irE = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b crV = EnterForumDelegateStatic.ikl.crV();
        if (crV != null && crV.isValid()) {
            this.irE = true;
            this.irF.startLoad(crV.ijg, 38, false);
            invalidate();
            if (this.irG != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iji = true;
                cVar.ijj = false;
                cVar.ijk = getBottom();
                cVar.ijl = this.ijl;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.irG.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.irI != crV && (a2 = com.baidu.tieba.t.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(crV.ijf), String.valueOf(crV.ijf), 5)) != null) {
                com.baidu.tieba.t.c.dIO().a(this.mTag, com.baidu.tieba.t.a.Se("" + crV.ijf), a2);
                com.baidu.tieba.t.c.dIO().b(this.mTag, false);
            }
        } else {
            if (this.irG != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iji = false;
                cVar2.ijj = false;
                cVar2.ijk = getBottom();
                cVar2.ijl = this.ijl;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.irG.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.irI = crV;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.irD.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.irA.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.irB.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.irC.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.irA.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.ikl.crV() != null && this.irG != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iji = true;
            cVar.ijj = false;
            cVar.ijk = i4;
            cVar.ijl = this.ijl;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.irG.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.irE) {
            this.irD.draw(canvas);
        }
        this.irA.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.ijl = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ar a2;
        com.baidu.tieba.enterForum.data.b crV = EnterForumDelegateStatic.ikl.crV();
        if (crV != null) {
            String str = EnterForumDelegateStatic.ikl.crV().aGz;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.t.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(crV.ijf), String.valueOf(crV.ijf), 5)) != null) {
                    com.baidu.tieba.t.c.dIO().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.irH = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean csL() {
        return this.irH;
    }

    public boolean csM() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.irF;
    }

    public void setOnBackPressedListener(a aVar) {
        this.irJ = aVar;
    }
}
