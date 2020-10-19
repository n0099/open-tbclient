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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes22.dex */
public class EnterForumAdView extends FrameLayout {
    private int hPZ;
    private Drawable hYo;
    private Drawable hYp;
    private Drawable hYq;
    private Drawable hYr;
    private boolean hYs;
    private TbImageView hYt;
    private ViewEventCenter hYu;
    private boolean hYv;
    private com.baidu.tieba.enterForum.data.b hYw;
    private a hYx;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes22.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.hYs = false;
        this.hYv = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYs = false;
        this.hYv = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYs = false;
        this.hYv = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.hYr = new ColorDrawable(1241513984);
        this.hYo = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.hYp = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.hYq = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hYx == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hYx.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.hYu = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cnz();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.hYt.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.hYt.setLayoutParams(layoutParams2);
    }

    private void cnz() {
        aq a2;
        if (this.hYt == null) {
            this.hYt = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.hYt.setPlaceHolder(3);
            this.hYt.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.hYs = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cmK = EnterForumDelegateStatic.hQZ.cmK();
        if (cmK != null && cmK.isValid()) {
            this.hYs = true;
            this.hYt.startLoad(cmK.hPU, 38, false);
            invalidate();
            if (this.hYu != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.hPW = true;
                cVar.hPX = false;
                cVar.hPY = getBottom();
                cVar.hPZ = this.hPZ;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.hYu.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.hYw != cmK && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cmK.hPT), String.valueOf(cmK.hPT), 5)) != null) {
                com.baidu.tieba.s.c.dDn().a(this.mTag, com.baidu.tieba.s.a.RN("" + cmK.hPT), a2);
                com.baidu.tieba.s.c.dDn().b(this.mTag, false);
            }
        } else {
            if (this.hYu != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.hPW = false;
                cVar2.hPX = false;
                cVar2.hPY = getBottom();
                cVar2.hPZ = this.hPZ;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.hYu.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.hYw = cmK;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hYr.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.hYo.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.hYp.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.hYq.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hYo.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.hQZ.cmK() != null && this.hYu != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.hPW = true;
            cVar.hPX = false;
            cVar.hPY = i4;
            cVar.hPZ = this.hPZ;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.hYu.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hYs) {
            this.hYr.draw(canvas);
        }
        this.hYo.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.hPZ = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b cmK = EnterForumDelegateStatic.hQZ.cmK();
        if (cmK != null) {
            String str = EnterForumDelegateStatic.hQZ.cmK().aHf;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cmK.hPT), String.valueOf(cmK.hPT), 5)) != null) {
                    com.baidu.tieba.s.c.dDn().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.hYv = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cnA() {
        return this.hYv;
    }

    public boolean cnB() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.hYt;
    }

    public void setOnBackPressedListener(a aVar) {
        this.hYx = aVar;
    }
}
