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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes9.dex */
public class EnterForumAdView extends FrameLayout {
    private int fTW;
    private Drawable fYQ;
    private Drawable fYR;
    private Drawable fYS;
    private Drawable fYT;
    private boolean fYU;
    private TbImageView fYV;
    private ViewEventCenter fYW;
    private boolean fYX;
    private com.baidu.tieba.enterForum.data.a fYY;
    private a fYZ;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fYU = false;
        this.fYX = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fYU = false;
        this.fYX = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYU = false;
        this.fYX = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fYT = new ColorDrawable(1241513984);
        this.fYQ = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fYR = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fYS = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fYZ == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fYZ.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fYW = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bzm();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fYV.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fYV.setLayoutParams(layoutParams2);
    }

    private void bzm() {
        an a2;
        if (this.fYV == null) {
            this.fYV = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fYV.setPlaceHolder(3);
            this.fYV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fYU = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a byL = EnterForumDelegateStatic.fUK.byL();
        if (byL != null && byL.isValid()) {
            this.fYU = true;
            this.fYV.startLoad(byL.fTR, 38, false);
            invalidate();
            if (this.fYW != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fTT = true;
                bVar.fTU = false;
                bVar.fTV = getBottom();
                bVar.fTW = this.fTW;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fYW.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fYY != byL && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(byL.fTQ), String.valueOf(byL.fTQ), 5)) != null) {
                com.baidu.tieba.s.c.cKa().a(this.mTag, com.baidu.tieba.s.a.IO("" + byL.fTQ), a2);
                com.baidu.tieba.s.c.cKa().b(this.mTag, false);
            }
        } else {
            if (this.fYW != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fTT = false;
                bVar3.fTU = false;
                bVar3.fTV = getBottom();
                bVar3.fTW = this.fTW;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fYW.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fYY = byL;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fYT.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fYQ.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fYR.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fYS.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fYQ.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fUK.byL() != null && this.fYW != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fTT = true;
            bVar.fTU = false;
            bVar.fTV = i4;
            bVar.fTW = this.fTW;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fYW.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fYU) {
            this.fYT.draw(canvas);
        }
        this.fYQ.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.fTW = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a byL = EnterForumDelegateStatic.fUK.byL();
        if (byL != null) {
            String str = EnterForumDelegateStatic.fUK.byL().cLR;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(byL.fTQ), String.valueOf(byL.fTQ), 5)) != null) {
                    com.baidu.tieba.s.c.cKa().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fYX = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bzn() {
        return this.fYX;
    }

    public boolean bzo() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fYV;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fYZ = aVar;
    }
}
