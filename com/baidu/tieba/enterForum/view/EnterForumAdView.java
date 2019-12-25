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
/* loaded from: classes6.dex */
public class EnterForumAdView extends FrameLayout {
    private int fOq;
    private Drawable fTE;
    private Drawable fTF;
    private Drawable fTG;
    private Drawable fTH;
    private boolean fTI;
    private TbImageView fTJ;
    private ViewEventCenter fTK;
    private boolean fTL;
    private com.baidu.tieba.enterForum.data.a fTM;
    private a fTN;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes6.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fTI = false;
        this.fTL = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fTI = false;
        this.fTL = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fTI = false;
        this.fTL = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fTH = new ColorDrawable(1241513984);
        this.fTE = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fTF = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fTG = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fTN == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fTN.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fTK = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bwG();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fTJ.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fTJ.setLayoutParams(layoutParams2);
    }

    private void bwG() {
        an a2;
        if (this.fTJ == null) {
            this.fTJ = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fTJ.setPlaceHolder(3);
            this.fTJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fTI = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a bwc = EnterForumDelegateStatic.fPf.bwc();
        if (bwc != null && bwc.isValid()) {
            this.fTI = true;
            this.fTJ.startLoad(bwc.fOl, 38, false);
            invalidate();
            if (this.fTK != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fOn = true;
                bVar.fOo = false;
                bVar.fOp = getBottom();
                bVar.fOq = this.fOq;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fTK.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fTM != bwc && (a2 = com.baidu.tieba.r.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bwc.fOk), String.valueOf(bwc.fOk), 5)) != null) {
                com.baidu.tieba.r.c.cHo().a(this.mTag, com.baidu.tieba.r.a.Iq("" + bwc.fOk), a2);
                com.baidu.tieba.r.c.cHo().b(this.mTag, false);
            }
        } else {
            if (this.fTK != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fOn = false;
                bVar3.fOo = false;
                bVar3.fOp = getBottom();
                bVar3.fOq = this.fOq;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fTK.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fTM = bwc;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fTH.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fTE.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fTF.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fTG.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fTE.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fPf.bwc() != null && this.fTK != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fOn = true;
            bVar.fOo = false;
            bVar.fOp = i4;
            bVar.fOq = this.fOq;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fTK.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fTI) {
            this.fTH.draw(canvas);
        }
        this.fTE.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.fOq = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a bwc = EnterForumDelegateStatic.fPf.bwc();
        if (bwc != null) {
            String str = EnterForumDelegateStatic.fPf.bwc().cHB;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.r.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bwc.fOk), String.valueOf(bwc.fOk), 5)) != null) {
                    com.baidu.tieba.r.c.cHo().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fTL = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bwH() {
        return this.fTL;
    }

    public boolean bwI() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fTJ;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fTN = aVar;
    }
}
