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
    private int fTU;
    private Drawable fYO;
    private Drawable fYP;
    private Drawable fYQ;
    private Drawable fYR;
    private boolean fYS;
    private TbImageView fYT;
    private ViewEventCenter fYU;
    private boolean fYV;
    private com.baidu.tieba.enterForum.data.a fYW;
    private a fYX;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fYS = false;
        this.fYV = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fYS = false;
        this.fYV = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYS = false;
        this.fYV = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fYR = new ColorDrawable(1241513984);
        this.fYO = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fYP = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fYQ = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fYX == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fYX.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fYU = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bzk();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fYT.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fYT.setLayoutParams(layoutParams2);
    }

    private void bzk() {
        an a2;
        if (this.fYT == null) {
            this.fYT = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fYT.setPlaceHolder(3);
            this.fYT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fYS = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a byJ = EnterForumDelegateStatic.fUI.byJ();
        if (byJ != null && byJ.isValid()) {
            this.fYS = true;
            this.fYT.startLoad(byJ.fTP, 38, false);
            invalidate();
            if (this.fYU != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fTR = true;
                bVar.fTS = false;
                bVar.fTT = getBottom();
                bVar.fTU = this.fTU;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fYU.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fYW != byJ && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(byJ.fTO), String.valueOf(byJ.fTO), 5)) != null) {
                com.baidu.tieba.s.c.cJY().a(this.mTag, com.baidu.tieba.s.a.IO("" + byJ.fTO), a2);
                com.baidu.tieba.s.c.cJY().b(this.mTag, false);
            }
        } else {
            if (this.fYU != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fTR = false;
                bVar3.fTS = false;
                bVar3.fTT = getBottom();
                bVar3.fTU = this.fTU;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fYU.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fYW = byJ;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fYR.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fYO.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fYP.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fYQ.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fYO.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fUI.byJ() != null && this.fYU != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fTR = true;
            bVar.fTS = false;
            bVar.fTT = i4;
            bVar.fTU = this.fTU;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fYU.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fYS) {
            this.fYR.draw(canvas);
        }
        this.fYO.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.fTU = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a byJ = EnterForumDelegateStatic.fUI.byJ();
        if (byJ != null) {
            String str = EnterForumDelegateStatic.fUI.byJ().cLQ;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(byJ.fTO), String.valueOf(byJ.fTO), 5)) != null) {
                    com.baidu.tieba.s.c.cJY().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fYV = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bzl() {
        return this.fYV;
    }

    public boolean bzm() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fYT;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fYX = aVar;
    }
}
