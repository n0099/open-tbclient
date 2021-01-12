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
    private int iBM;
    private Drawable iJZ;
    private Drawable iKa;
    private Drawable iKb;
    private Drawable iKc;
    private boolean iKd;
    private TbImageView iKe;
    private ViewEventCenter iKf;
    private boolean iKg;
    private com.baidu.tieba.enterForum.data.b iKh;
    private a iKi;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes2.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iKd = false;
        this.iKg = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKd = false;
        this.iKg = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iKd = false;
        this.iKg = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iKc = new ColorDrawable(1241513984);
        this.iJZ = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iKa = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iKb = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iKi == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iKi.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iKf = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cwc();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iKe.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iKe.setLayoutParams(layoutParams2);
    }

    private void cwc() {
        aq a2;
        if (this.iKe == null) {
            this.iKe = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iKe.setPlaceHolder(3);
            this.iKe.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iKd = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cvn = EnterForumDelegateStatic.iCM.cvn();
        if (cvn != null && cvn.isValid()) {
            this.iKd = true;
            this.iKe.startLoad(cvn.iBH, 38, false);
            invalidate();
            if (this.iKf != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iBJ = true;
                cVar.iBK = false;
                cVar.iBL = getBottom();
                cVar.iBM = this.iBM;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iKf.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iKh != cvn && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cvn.iBG), String.valueOf(cvn.iBG), 5)) != null) {
                com.baidu.tieba.s.c.dKg().a(this.mTag, com.baidu.tieba.s.a.RS("" + cvn.iBG), a2);
                com.baidu.tieba.s.c.dKg().b(this.mTag, false);
            }
        } else {
            if (this.iKf != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iBJ = false;
                cVar2.iBK = false;
                cVar2.iBL = getBottom();
                cVar2.iBM = this.iBM;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iKf.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iKh = cvn;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iKc.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iJZ.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iKa.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iKb.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iJZ.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.iCM.cvn() != null && this.iKf != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iBJ = true;
            cVar.iBK = false;
            cVar.iBL = i4;
            cVar.iBM = this.iBM;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iKf.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iKd) {
            this.iKc.draw(canvas);
        }
        this.iJZ.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iBM = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b cvn = EnterForumDelegateStatic.iCM.cvn();
        if (cvn != null) {
            String str = EnterForumDelegateStatic.iCM.cvn().aEU;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cvn.iBG), String.valueOf(cvn.iBG), 5)) != null) {
                    com.baidu.tieba.s.c.dKg().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iKg = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cwd() {
        return this.iKg;
    }

    public boolean cwe() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iKe;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iKi = aVar;
    }
}
