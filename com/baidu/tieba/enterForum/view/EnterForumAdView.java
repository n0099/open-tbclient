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
    private int fUS;
    private Drawable fZL;
    private Drawable fZM;
    private Drawable fZN;
    private Drawable fZO;
    private boolean fZP;
    private TbImageView fZQ;
    private ViewEventCenter fZR;
    private boolean fZS;
    private com.baidu.tieba.enterForum.data.a fZT;
    private a fZU;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fZP = false;
        this.fZS = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fZP = false;
        this.fZS = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fZP = false;
        this.fZS = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fZO = new ColorDrawable(1241513984);
        this.fZL = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fZM = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fZN = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fZU == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fZU.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fZR = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bzt();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fZQ.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fZQ.setLayoutParams(layoutParams2);
    }

    private void bzt() {
        an a2;
        if (this.fZQ == null) {
            this.fZQ = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fZQ.setPlaceHolder(3);
            this.fZQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fZP = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a byS = EnterForumDelegateStatic.fVG.byS();
        if (byS != null && byS.isValid()) {
            this.fZP = true;
            this.fZQ.startLoad(byS.fUN, 38, false);
            invalidate();
            if (this.fZR != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fUP = true;
                bVar.fUQ = false;
                bVar.fUR = getBottom();
                bVar.fUS = this.fUS;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fZR.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fZT != byS && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(byS.fUM), String.valueOf(byS.fUM), 5)) != null) {
                com.baidu.tieba.s.c.cKv().a(this.mTag, com.baidu.tieba.s.a.IP("" + byS.fUM), a2);
                com.baidu.tieba.s.c.cKv().b(this.mTag, false);
            }
        } else {
            if (this.fZR != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fUP = false;
                bVar3.fUQ = false;
                bVar3.fUR = getBottom();
                bVar3.fUS = this.fUS;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fZR.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fZT = byS;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fZO.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fZL.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fZM.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fZN.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fZL.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fVG.byS() != null && this.fZR != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fUP = true;
            bVar.fUQ = false;
            bVar.fUR = i4;
            bVar.fUS = this.fUS;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fZR.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fZP) {
            this.fZO.draw(canvas);
        }
        this.fZL.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.fUS = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a byS = EnterForumDelegateStatic.fVG.byS();
        if (byS != null) {
            String str = EnterForumDelegateStatic.fVG.byS().cMd;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(byS.fUM), String.valueOf(byS.fUM), 5)) != null) {
                    com.baidu.tieba.s.c.cKv().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fZS = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bzu() {
        return this.fZS;
    }

    public boolean bzv() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fZQ;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fZU = aVar;
    }
}
