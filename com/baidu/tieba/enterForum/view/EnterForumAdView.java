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
    private int iHK;
    private Drawable iPV;
    private Drawable iPW;
    private Drawable iPX;
    private Drawable iPY;
    private boolean iPZ;
    private TbImageView iQa;
    private ViewEventCenter iQb;
    private boolean iQc;
    private com.baidu.tieba.enterForum.data.b iQd;
    private a iQe;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes2.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iPZ = false;
        this.iQc = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iPZ = false;
        this.iQc = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iPZ = false;
        this.iQc = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iPY = new ColorDrawable(1241513984);
        this.iPV = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iPW = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iPX = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iQe == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iQe.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iQb = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cxv();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iQa.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iQa.setLayoutParams(layoutParams2);
    }

    private void cxv() {
        ar a2;
        if (this.iQa == null) {
            this.iQa = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iQa.setPlaceHolder(3);
            this.iQa.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iPZ = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cwG = EnterForumDelegateStatic.iIK.cwG();
        if (cwG != null && cwG.isValid()) {
            this.iPZ = true;
            this.iQa.startLoad(cwG.iHF, 38, false);
            invalidate();
            if (this.iQb != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iHH = true;
                cVar.iHI = false;
                cVar.iHJ = getBottom();
                cVar.iHK = this.iHK;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iQb.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iQd != cwG && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cwG.iHE), String.valueOf(cwG.iHE), 5)) != null) {
                com.baidu.tieba.s.c.dMz().a(this.mTag, com.baidu.tieba.s.a.Tc("" + cwG.iHE), a2);
                com.baidu.tieba.s.c.dMz().b(this.mTag, false);
            }
        } else {
            if (this.iQb != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iHH = false;
                cVar2.iHI = false;
                cVar2.iHJ = getBottom();
                cVar2.iHK = this.iHK;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iQb.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iQd = cwG;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iPY.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iPV.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iPW.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iPX.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iPV.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.iIK.cwG() != null && this.iQb != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iHH = true;
            cVar.iHI = false;
            cVar.iHJ = i4;
            cVar.iHK = this.iHK;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iQb.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iPZ) {
            this.iPY.draw(canvas);
        }
        this.iPV.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iHK = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ar a2;
        com.baidu.tieba.enterForum.data.b cwG = EnterForumDelegateStatic.iIK.cwG();
        if (cwG != null) {
            String str = EnterForumDelegateStatic.iIK.cwG().aHq;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cwG.iHE), String.valueOf(cwG.iHE), 5)) != null) {
                    com.baidu.tieba.s.c.dMz().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iQc = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cxw() {
        return this.iQc;
    }

    public boolean cxx() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iQa;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iQe = aVar;
    }
}
