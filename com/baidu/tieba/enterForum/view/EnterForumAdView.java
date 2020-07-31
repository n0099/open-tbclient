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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes16.dex */
public class EnterForumAdView extends FrameLayout {
    private int hha;
    private ViewEventCenter hpA;
    private boolean hpB;
    private com.baidu.tieba.enterForum.data.b hpC;
    private a hpD;
    private Drawable hpu;
    private Drawable hpv;
    private Drawable hpw;
    private Drawable hpx;
    private boolean hpy;
    private TbImageView hpz;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes16.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.hpy = false;
        this.hpB = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpy = false;
        this.hpB = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpy = false;
        this.hpB = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.hpx = new ColorDrawable(1241513984);
        this.hpu = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.hpv = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.hpw = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hpD == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hpD.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.hpA = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bWA();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.hpz.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.hpz.setLayoutParams(layoutParams2);
    }

    private void bWA() {
        ap a2;
        if (this.hpz == null) {
            this.hpz = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.hpz.setPlaceHolder(3);
            this.hpz.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.hpy = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b bVJ = EnterForumDelegateStatic.hhT.bVJ();
        if (bVJ != null && bVJ.isValid()) {
            this.hpy = true;
            this.hpz.startLoad(bVJ.hgV, 38, false);
            invalidate();
            if (this.hpA != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.hgX = true;
                cVar.hgY = false;
                cVar.hgZ = getBottom();
                cVar.hha = this.hha;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.hpA.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.hpC != bVJ && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bVJ.hgU), String.valueOf(bVJ.hgU), 5)) != null) {
                com.baidu.tieba.s.c.dkh().a(this.mTag, com.baidu.tieba.s.a.Ny("" + bVJ.hgU), a2);
                com.baidu.tieba.s.c.dkh().b(this.mTag, false);
            }
        } else {
            if (this.hpA != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.hgX = false;
                cVar2.hgY = false;
                cVar2.hgZ = getBottom();
                cVar2.hha = this.hha;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.hpA.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.hpC = bVJ;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hpx.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.hpu.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.hpv.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.hpw.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hpu.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.hhT.bVJ() != null && this.hpA != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.hgX = true;
            cVar.hgY = false;
            cVar.hgZ = i4;
            cVar.hha = this.hha;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.hpA.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hpy) {
            this.hpx.draw(canvas);
        }
        this.hpu.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.hha = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ap a2;
        com.baidu.tieba.enterForum.data.b bVJ = EnterForumDelegateStatic.hhT.bVJ();
        if (bVJ != null) {
            String str = EnterForumDelegateStatic.hhT.bVJ().aye;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bVJ.hgU), String.valueOf(bVJ.hgU), 5)) != null) {
                    com.baidu.tieba.s.c.dkh().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.hpB = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bWB() {
        return this.hpB;
    }

    public boolean bWC() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.hpz;
    }

    public void setOnBackPressedListener(a aVar) {
        this.hpD = aVar;
    }
}
