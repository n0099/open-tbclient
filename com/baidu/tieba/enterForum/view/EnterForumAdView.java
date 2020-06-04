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
    private int gOI;
    private Drawable gWW;
    private Drawable gWX;
    private Drawable gWY;
    private Drawable gWZ;
    private boolean gXa;
    private TbImageView gXb;
    private ViewEventCenter gXc;
    private boolean gXd;
    private com.baidu.tieba.enterForum.data.c gXe;
    private a gXf;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.gXa = false;
        this.gXd = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXa = false;
        this.gXd = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gXa = false;
        this.gXd = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.gWZ = new ColorDrawable(1241513984);
        this.gWW = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.gWX = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.gWY = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.gXf == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.gXf.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.gXc = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bQf();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.gXb.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.gXb.setLayoutParams(layoutParams2);
    }

    private void bQf() {
        an a2;
        if (this.gXb == null) {
            this.gXb = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.gXb.setPlaceHolder(3);
            this.gXb.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.gXa = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.c bPo = EnterForumDelegateStatic.gPB.bPo();
        if (bPo != null && bPo.isValid()) {
            this.gXa = true;
            this.gXb.startLoad(bPo.gOD, 38, false);
            invalidate();
            if (this.gXc != null) {
                com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
                dVar.gOF = true;
                dVar.gOG = false;
                dVar.gOH = getBottom();
                dVar.gOI = this.gOI;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(dVar);
                this.gXc.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.gXe != bPo && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bPo.gOC), String.valueOf(bPo.gOC), 5)) != null) {
                com.baidu.tieba.s.c.dcI().a(this.mTag, com.baidu.tieba.s.a.Mo("" + bPo.gOC), a2);
                com.baidu.tieba.s.c.dcI().b(this.mTag, false);
            }
        } else {
            if (this.gXc != null) {
                com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
                dVar2.gOF = false;
                dVar2.gOG = false;
                dVar2.gOH = getBottom();
                dVar2.gOI = this.gOI;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(dVar2);
                this.gXc.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.gXe = bPo;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.gWZ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.gWW.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.gWX.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.gWY.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.gWW.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.gPB.bPo() != null && this.gXc != null) {
            com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
            dVar.gOF = true;
            dVar.gOG = false;
            dVar.gOH = i4;
            dVar.gOI = this.gOI;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(dVar);
            this.gXc.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gXa) {
            this.gWZ.draw(canvas);
        }
        this.gWW.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.gOI = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.c bPo = EnterForumDelegateStatic.gPB.bPo();
        if (bPo != null) {
            String str = EnterForumDelegateStatic.gPB.bPo().auL;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bPo.gOC), String.valueOf(bPo.gOC), 5)) != null) {
                    com.baidu.tieba.s.c.dcI().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.gXd = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bQg() {
        return this.gXd;
    }

    public boolean bQh() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.gXb;
    }

    public void setOnBackPressedListener(a aVar) {
        this.gXf = aVar;
    }
}
