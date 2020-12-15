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
/* loaded from: classes22.dex */
public class EnterForumAdView extends FrameLayout {
    private ViewEventCenter iCA;
    private boolean iCB;
    private com.baidu.tieba.enterForum.data.b iCC;
    private a iCD;
    private Drawable iCu;
    private Drawable iCv;
    private Drawable iCw;
    private Drawable iCx;
    private boolean iCy;
    private TbImageView iCz;
    private boolean isShow;
    private int iug;
    private BdUniqueId mTag;

    /* loaded from: classes22.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iCy = false;
        this.iCB = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iCy = false;
        this.iCB = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCy = false;
        this.iCB = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iCx = new ColorDrawable(1241513984);
        this.iCu = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iCv = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iCw = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iCD == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iCD.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iCA = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cxa();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iCz.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iCz.setLayoutParams(layoutParams2);
    }

    private void cxa() {
        ar a2;
        if (this.iCz == null) {
            this.iCz = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iCz.setPlaceHolder(3);
            this.iCz.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iCy = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cwl = EnterForumDelegateStatic.ivg.cwl();
        if (cwl != null && cwl.isValid()) {
            this.iCy = true;
            this.iCz.startLoad(cwl.iub, 38, false);
            invalidate();
            if (this.iCA != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iud = true;
                cVar.iue = false;
                cVar.iuf = getBottom();
                cVar.iug = this.iug;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iCA.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iCC != cwl && (a2 = com.baidu.tieba.t.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cwl.iua), String.valueOf(cwl.iua), 5)) != null) {
                com.baidu.tieba.t.c.dOf().a(this.mTag, com.baidu.tieba.t.a.Ts("" + cwl.iua), a2);
                com.baidu.tieba.t.c.dOf().b(this.mTag, false);
            }
        } else {
            if (this.iCA != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iud = false;
                cVar2.iue = false;
                cVar2.iuf = getBottom();
                cVar2.iug = this.iug;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iCA.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iCC = cwl;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iCx.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iCu.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iCv.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iCw.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iCu.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.ivg.cwl() != null && this.iCA != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iud = true;
            cVar.iue = false;
            cVar.iuf = i4;
            cVar.iug = this.iug;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iCA.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iCy) {
            this.iCx.draw(canvas);
        }
        this.iCu.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iug = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ar a2;
        com.baidu.tieba.enterForum.data.b cwl = EnterForumDelegateStatic.ivg.cwl();
        if (cwl != null) {
            String str = EnterForumDelegateStatic.ivg.cwl().aJj;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.t.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cwl.iua), String.valueOf(cwl.iua), 5)) != null) {
                    com.baidu.tieba.t.c.dOf().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iCB = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cxb() {
        return this.iCB;
    }

    public boolean cxc() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iCz;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iCD = aVar;
    }
}
