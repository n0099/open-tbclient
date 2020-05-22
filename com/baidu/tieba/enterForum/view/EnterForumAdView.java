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
    private int gOx;
    private Drawable gWL;
    private Drawable gWM;
    private Drawable gWN;
    private Drawable gWO;
    private boolean gWP;
    private TbImageView gWQ;
    private ViewEventCenter gWR;
    private boolean gWS;
    private com.baidu.tieba.enterForum.data.c gWT;
    private a gWU;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.gWP = false;
        this.gWS = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWP = false;
        this.gWS = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWP = false;
        this.gWS = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.gWO = new ColorDrawable(1241513984);
        this.gWL = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.gWM = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.gWN = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.gWU == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.gWU.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.gWR = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bQd();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.gWQ.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.gWQ.setLayoutParams(layoutParams2);
    }

    private void bQd() {
        an a2;
        if (this.gWQ == null) {
            this.gWQ = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.gWQ.setPlaceHolder(3);
            this.gWQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.gWP = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.c bPm = EnterForumDelegateStatic.gPq.bPm();
        if (bPm != null && bPm.isValid()) {
            this.gWP = true;
            this.gWQ.startLoad(bPm.gOs, 38, false);
            invalidate();
            if (this.gWR != null) {
                com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
                dVar.gOu = true;
                dVar.gOv = false;
                dVar.gOw = getBottom();
                dVar.gOx = this.gOx;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(dVar);
                this.gWR.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.gWT != bPm && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bPm.gOr), String.valueOf(bPm.gOr), 5)) != null) {
                com.baidu.tieba.s.c.dct().a(this.mTag, com.baidu.tieba.s.a.Mn("" + bPm.gOr), a2);
                com.baidu.tieba.s.c.dct().b(this.mTag, false);
            }
        } else {
            if (this.gWR != null) {
                com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
                dVar2.gOu = false;
                dVar2.gOv = false;
                dVar2.gOw = getBottom();
                dVar2.gOx = this.gOx;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(dVar2);
                this.gWR.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.gWT = bPm;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.gWO.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.gWL.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.gWM.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.gWN.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.gWL.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.gPq.bPm() != null && this.gWR != null) {
            com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
            dVar.gOu = true;
            dVar.gOv = false;
            dVar.gOw = i4;
            dVar.gOx = this.gOx;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(dVar);
            this.gWR.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gWP) {
            this.gWO.draw(canvas);
        }
        this.gWL.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.gOx = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.c bPm = EnterForumDelegateStatic.gPq.bPm();
        if (bPm != null) {
            String str = EnterForumDelegateStatic.gPq.bPm().auL;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bPm.gOr), String.valueOf(bPm.gOr), 5)) != null) {
                    com.baidu.tieba.s.c.dct().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.gWS = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bQe() {
        return this.gWS;
    }

    public boolean bQf() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.gWQ;
    }

    public void setOnBackPressedListener(a aVar) {
        this.gWU = aVar;
    }
}
