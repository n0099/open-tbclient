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
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {
    private boolean cFS;
    private int eZJ;
    private Drawable ffa;
    private Drawable ffb;
    private Drawable ffc;
    private Drawable ffd;
    private boolean ffe;
    private TbImageView fff;
    private ViewEventCenter ffg;
    private boolean ffh;
    private com.baidu.tieba.enterForum.data.a ffi;
    private a ffj;
    private BdUniqueId mTag;

    /* loaded from: classes4.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.ffe = false;
        this.ffh = false;
        this.cFS = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffe = false;
        this.ffh = false;
        this.cFS = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffe = false;
        this.ffh = false;
        this.cFS = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.ffd = new ColorDrawable(1241513984);
        this.ffa = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.ffb = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.ffc = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.ffj == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.ffj.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.ffg = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bfl();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fff.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fff.setLayoutParams(layoutParams2);
    }

    private void bfl() {
        an a2;
        if (this.fff == null) {
            this.fff = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fff.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.fff.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.ffe = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a beI = EnterForumDelegateStatic.faz.beI();
        if (beI != null && beI.isValid()) {
            this.ffe = true;
            this.fff.startLoad(beI.eZE, 38, false);
            invalidate();
            if (this.ffg != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.eZG = true;
                bVar.eZH = false;
                bVar.eZI = getBottom();
                bVar.eZJ = this.eZJ;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.ffg.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.ffi != beI && (a2 = com.baidu.tieba.q.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 0, true, String.valueOf(beI.eZD), String.valueOf(beI.eZD), 5)) != null) {
                com.baidu.tieba.q.c.cni().a(this.mTag, "enterfourm_att_" + beI.eZD, a2);
                com.baidu.tieba.q.c.cni().b(this.mTag, false);
            }
        } else {
            if (this.ffg != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.eZG = false;
                bVar3.eZH = false;
                bVar3.eZI = getBottom();
                bVar3.eZJ = this.eZJ;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.ffg.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.ffi = beI;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ffd.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.ffa.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.ffb.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.ffc.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.ffa.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.faz.beI() != null && this.ffg != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.eZG = true;
            bVar.eZH = false;
            bVar.eZI = i4;
            bVar.eZJ = this.eZJ;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.ffg.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ffe) {
            this.ffd.draw(canvas);
        }
        this.ffa.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.eZJ = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a beI = EnterForumDelegateStatic.faz.beI();
        if (beI != null) {
            String str = EnterForumDelegateStatic.faz.beI().bVl;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.q.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 0, 0, true, String.valueOf(beI.eZD), String.valueOf(beI.eZD), 5)) != null) {
                    com.baidu.tieba.q.c.cni().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.ffh = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.cFS = z;
        invalidate();
    }

    public boolean bfm() {
        return this.ffh;
    }

    public boolean bfn() {
        return this.cFS;
    }

    public View getAdImageView() {
        return this.fff;
    }

    public void setOnBackPressedListener(a aVar) {
        this.ffj = aVar;
    }
}
