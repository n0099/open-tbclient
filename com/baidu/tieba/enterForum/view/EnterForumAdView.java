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
    private int iix;
    private Drawable iqN;
    private Drawable iqO;
    private Drawable iqP;
    private Drawable iqQ;
    private boolean iqR;
    private TbImageView iqS;
    private ViewEventCenter iqT;
    private boolean iqU;
    private com.baidu.tieba.enterForum.data.b iqV;
    private a iqW;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes22.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iqR = false;
        this.iqU = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqR = false;
        this.iqU = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqR = false;
        this.iqU = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iqQ = new ColorDrawable(1241513984);
        this.iqN = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iqO = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iqP = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iqW == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iqW.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iqT = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cth();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iqS.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iqS.setLayoutParams(layoutParams2);
    }

    private void cth() {
        aq a2;
        if (this.iqS == null) {
            this.iqS = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iqS.setPlaceHolder(3);
            this.iqS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iqR = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b css = EnterForumDelegateStatic.ijx.css();
        if (css != null && css.isValid()) {
            this.iqR = true;
            this.iqS.startLoad(css.iis, 38, false);
            invalidate();
            if (this.iqT != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iiu = true;
                cVar.iiv = false;
                cVar.iiw = getBottom();
                cVar.iix = this.iix;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iqT.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iqV != css && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(css.iir), String.valueOf(css.iir), 5)) != null) {
                com.baidu.tieba.s.c.dIX().a(this.mTag, com.baidu.tieba.s.a.SD("" + css.iir), a2);
                com.baidu.tieba.s.c.dIX().b(this.mTag, false);
            }
        } else {
            if (this.iqT != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iiu = false;
                cVar2.iiv = false;
                cVar2.iiw = getBottom();
                cVar2.iix = this.iix;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iqT.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iqV = css;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iqQ.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iqN.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iqO.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iqP.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iqN.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.ijx.css() != null && this.iqT != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iiu = true;
            cVar.iiv = false;
            cVar.iiw = i4;
            cVar.iix = this.iix;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iqT.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iqR) {
            this.iqQ.draw(canvas);
        }
        this.iqN.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iix = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b css = EnterForumDelegateStatic.ijx.css();
        if (css != null) {
            String str = EnterForumDelegateStatic.ijx.css().aIk;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(css.iir), String.valueOf(css.iir), 5)) != null) {
                    com.baidu.tieba.s.c.dIX().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iqU = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cti() {
        return this.iqU;
    }

    public boolean ctj() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iqS;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iqW = aVar;
    }
}
