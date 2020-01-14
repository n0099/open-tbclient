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
/* loaded from: classes7.dex */
public class EnterForumAdView extends FrameLayout {
    private int fRz;
    private Drawable fWN;
    private Drawable fWO;
    private Drawable fWP;
    private Drawable fWQ;
    private boolean fWR;
    private TbImageView fWS;
    private ViewEventCenter fWT;
    private boolean fWU;
    private com.baidu.tieba.enterForum.data.a fWV;
    private a fWW;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes7.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fWR = false;
        this.fWU = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fWR = false;
        this.fWU = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWR = false;
        this.fWU = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fWQ = new ColorDrawable(1241513984);
        this.fWN = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fWO = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fWP = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fWW == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fWW.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fWT = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bxI();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fWS.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fWS.setLayoutParams(layoutParams2);
    }

    private void bxI() {
        an a2;
        if (this.fWS == null) {
            this.fWS = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fWS.setPlaceHolder(3);
            this.fWS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fWR = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a bxe = EnterForumDelegateStatic.fSo.bxe();
        if (bxe != null && bxe.isValid()) {
            this.fWR = true;
            this.fWS.startLoad(bxe.fRu, 38, false);
            invalidate();
            if (this.fWT != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fRw = true;
                bVar.fRx = false;
                bVar.fRy = getBottom();
                bVar.fRz = this.fRz;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fWT.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fWV != bxe && (a2 = com.baidu.tieba.r.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bxe.fRt), String.valueOf(bxe.fRt), 5)) != null) {
                com.baidu.tieba.r.c.cIu().a(this.mTag, com.baidu.tieba.r.a.IA("" + bxe.fRt), a2);
                com.baidu.tieba.r.c.cIu().b(this.mTag, false);
            }
        } else {
            if (this.fWT != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fRw = false;
                bVar3.fRx = false;
                bVar3.fRy = getBottom();
                bVar3.fRz = this.fRz;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fWT.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fWV = bxe;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fWQ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fWN.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fWO.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fWP.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fWN.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fSo.bxe() != null && this.fWT != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fRw = true;
            bVar.fRx = false;
            bVar.fRy = i4;
            bVar.fRz = this.fRz;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fWT.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fWR) {
            this.fWQ.draw(canvas);
        }
        this.fWN.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.fRz = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a bxe = EnterForumDelegateStatic.fSo.bxe();
        if (bxe != null) {
            String str = EnterForumDelegateStatic.fSo.bxe().cHN;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.r.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bxe.fRt), String.valueOf(bxe.fRt), 5)) != null) {
                    com.baidu.tieba.r.c.cIu().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fWU = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bxJ() {
        return this.fWU;
    }

    public boolean bxK() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fWS;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fWW = aVar;
    }
}
