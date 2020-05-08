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
    private Drawable gIa;
    private Drawable gIb;
    private Drawable gIc;
    private Drawable gId;
    private boolean gIe;
    private TbImageView gIf;
    private ViewEventCenter gIg;
    private boolean gIh;
    private com.baidu.tieba.enterForum.data.c gIi;
    private a gIj;
    private int gzN;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.gIe = false;
        this.gIh = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIe = false;
        this.gIh = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIe = false;
        this.gIh = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.gId = new ColorDrawable(1241513984);
        this.gIa = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.gIb = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.gIc = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.gIj == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.gIj.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.gIg = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bJH();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.gIf.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.gIf.setLayoutParams(layoutParams2);
    }

    private void bJH() {
        an a2;
        if (this.gIf == null) {
            this.gIf = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.gIf.setPlaceHolder(3);
            this.gIf.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.gIe = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.c bIS = EnterForumDelegateStatic.gAG.bIS();
        if (bIS != null && bIS.isValid()) {
            this.gIe = true;
            this.gIf.startLoad(bIS.gzI, 38, false);
            invalidate();
            if (this.gIg != null) {
                com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
                dVar.gzK = true;
                dVar.gzL = false;
                dVar.gzM = getBottom();
                dVar.gzN = this.gzN;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(dVar);
                this.gIg.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.gIi != bIS && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bIS.gzH), String.valueOf(bIS.gzH), 5)) != null) {
                com.baidu.tieba.s.c.cVo().a(this.mTag, com.baidu.tieba.s.a.KB("" + bIS.gzH), a2);
                com.baidu.tieba.s.c.cVo().b(this.mTag, false);
            }
        } else {
            if (this.gIg != null) {
                com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
                dVar2.gzK = false;
                dVar2.gzL = false;
                dVar2.gzM = getBottom();
                dVar2.gzN = this.gzN;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(dVar2);
                this.gIg.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.gIi = bIS;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.gId.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.gIa.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.gIb.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.gIc.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.gIa.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.gAG.bIS() != null && this.gIg != null) {
            com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
            dVar.gzK = true;
            dVar.gzL = false;
            dVar.gzM = i4;
            dVar.gzN = this.gzN;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(dVar);
            this.gIg.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gIe) {
            this.gId.draw(canvas);
        }
        this.gIa.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.gzN = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.c bIS = EnterForumDelegateStatic.gAG.bIS();
        if (bIS != null) {
            String str = EnterForumDelegateStatic.gAG.bIS().arb;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bIS.gzH), String.valueOf(bIS.gzH), 5)) != null) {
                    com.baidu.tieba.s.c.cVo().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.gIh = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bJI() {
        return this.gIh;
    }

    public boolean bJJ() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.gIf;
    }

    public void setOnBackPressedListener(a aVar) {
        this.gIj = aVar;
    }
}
