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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes2.dex */
public class EnterForumAdView extends FrameLayout {
    private int iJt;
    private Drawable iRE;
    private Drawable iRF;
    private Drawable iRG;
    private Drawable iRH;
    private boolean iRI;
    private TbImageView iRJ;
    private ViewEventCenter iRK;
    private boolean iRL;
    private com.baidu.tieba.enterForum.data.b iRM;
    private a iRN;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes2.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iRI = false;
        this.iRL = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iRI = false;
        this.iRL = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iRI = false;
        this.iRL = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iRH = new ColorDrawable(1241513984);
        this.iRE = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iRF = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iRG = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iRN == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iRN.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iRK = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cxB();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iRJ.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iRJ.setLayoutParams(layoutParams2);
    }

    private void cxB() {
        ar a2;
        if (this.iRJ == null) {
            this.iRJ = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iRJ.setPlaceHolder(3);
            this.iRJ.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iRI = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cwM = EnterForumDelegateStatic.iKt.cwM();
        if (cwM != null && cwM.isValid()) {
            this.iRI = true;
            this.iRJ.startLoad(cwM.iJo, 38, false);
            invalidate();
            if (this.iRK != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iJq = true;
                cVar.iJr = false;
                cVar.iJs = getBottom();
                cVar.iJt = this.iJt;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iRK.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iRM != cwM && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cwM.iJn), String.valueOf(cwM.iJn), 5)) != null) {
                com.baidu.tieba.s.c.dMH().a(this.mTag, com.baidu.tieba.s.a.Ti("" + cwM.iJn), a2);
                com.baidu.tieba.s.c.dMH().b(this.mTag, false);
            }
        } else {
            if (this.iRK != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iJq = false;
                cVar2.iJr = false;
                cVar2.iJs = getBottom();
                cVar2.iJt = this.iJt;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iRK.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iRM = cwM;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iRH.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iRE.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iRF.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iRG.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iRE.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.iKt.cwM() != null && this.iRK != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iJq = true;
            cVar.iJr = false;
            cVar.iJs = i4;
            cVar.iJt = this.iJt;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iRK.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iRI) {
            this.iRH.draw(canvas);
        }
        this.iRE.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iJt = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ar a2;
        com.baidu.tieba.enterForum.data.b cwM = EnterForumDelegateStatic.iKt.cwM();
        if (cwM != null) {
            String str = EnterForumDelegateStatic.iKt.cwM().aIQ;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cwM.iJn), String.valueOf(cwM.iJn), 5)) != null) {
                    com.baidu.tieba.s.c.dMH().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iRL = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cxC() {
        return this.iRL;
    }

    public boolean cxD() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iRJ;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iRN = aVar;
    }
}
