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
    private Drawable gHU;
    private Drawable gHV;
    private Drawable gHW;
    private Drawable gHX;
    private boolean gHY;
    private TbImageView gHZ;
    private ViewEventCenter gIa;
    private boolean gIb;
    private com.baidu.tieba.enterForum.data.c gIc;
    private a gId;
    private int gzH;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.gHY = false;
        this.gIb = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHY = false;
        this.gIb = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHY = false;
        this.gIb = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.gHX = new ColorDrawable(1241513984);
        this.gHU = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.gHV = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.gHW = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.gId == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.gId.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.gIa = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bJJ();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.gHZ.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.gHZ.setLayoutParams(layoutParams2);
    }

    private void bJJ() {
        an a2;
        if (this.gHZ == null) {
            this.gHZ = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.gHZ.setPlaceHolder(3);
            this.gHZ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.gHY = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.c bIU = EnterForumDelegateStatic.gAA.bIU();
        if (bIU != null && bIU.isValid()) {
            this.gHY = true;
            this.gHZ.startLoad(bIU.gzC, 38, false);
            invalidate();
            if (this.gIa != null) {
                com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
                dVar.gzE = true;
                dVar.gzF = false;
                dVar.gzG = getBottom();
                dVar.gzH = this.gzH;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(dVar);
                this.gIa.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.gIc != bIU && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bIU.gzB), String.valueOf(bIU.gzB), 5)) != null) {
                com.baidu.tieba.s.c.cVr().a(this.mTag, com.baidu.tieba.s.a.Ky("" + bIU.gzB), a2);
                com.baidu.tieba.s.c.cVr().b(this.mTag, false);
            }
        } else {
            if (this.gIa != null) {
                com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
                dVar2.gzE = false;
                dVar2.gzF = false;
                dVar2.gzG = getBottom();
                dVar2.gzH = this.gzH;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(dVar2);
                this.gIa.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.gIc = bIU;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.gHX.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.gHU.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.gHV.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.gHW.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.gHU.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.gAA.bIU() != null && this.gIa != null) {
            com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
            dVar.gzE = true;
            dVar.gzF = false;
            dVar.gzG = i4;
            dVar.gzH = this.gzH;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(dVar);
            this.gIa.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gHY) {
            this.gHX.draw(canvas);
        }
        this.gHU.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.gzH = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.c bIU = EnterForumDelegateStatic.gAA.bIU();
        if (bIU != null) {
            String str = EnterForumDelegateStatic.gAA.bIU().aqV;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bIU.gzB), String.valueOf(bIU.gzB), 5)) != null) {
                    com.baidu.tieba.s.c.cVr().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.gIb = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bJK() {
        return this.gIb;
    }

    public boolean bJL() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.gHZ;
    }

    public void setOnBackPressedListener(a aVar) {
        this.gId = aVar;
    }
}
