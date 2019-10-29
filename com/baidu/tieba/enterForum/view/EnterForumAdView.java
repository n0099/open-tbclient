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
    private boolean cGJ;
    private int faA;
    private Drawable ffR;
    private Drawable ffS;
    private Drawable ffT;
    private Drawable ffU;
    private boolean ffV;
    private TbImageView ffW;
    private ViewEventCenter ffX;
    private boolean ffY;
    private com.baidu.tieba.enterForum.data.a ffZ;
    private a fga;
    private BdUniqueId mTag;

    /* loaded from: classes4.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.ffV = false;
        this.ffY = false;
        this.cGJ = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffV = false;
        this.ffY = false;
        this.cGJ = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffV = false;
        this.ffY = false;
        this.cGJ = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.ffU = new ColorDrawable(1241513984);
        this.ffR = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.ffS = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.ffT = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fga == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fga.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.ffX = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bfn();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.ffW.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.ffW.setLayoutParams(layoutParams2);
    }

    private void bfn() {
        an a2;
        if (this.ffW == null) {
            this.ffW = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.ffW.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
            this.ffW.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.ffV = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a beK = EnterForumDelegateStatic.fbq.beK();
        if (beK != null && beK.isValid()) {
            this.ffV = true;
            this.ffW.startLoad(beK.fav, 38, false);
            invalidate();
            if (this.ffX != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fax = true;
                bVar.fay = false;
                bVar.faz = getBottom();
                bVar.faA = this.faA;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.ffX.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.ffZ != beK && (a2 = com.baidu.tieba.q.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 0, true, String.valueOf(beK.fau), String.valueOf(beK.fau), 5)) != null) {
                com.baidu.tieba.q.c.cnk().a(this.mTag, "enterfourm_att_" + beK.fau, a2);
                com.baidu.tieba.q.c.cnk().b(this.mTag, false);
            }
        } else {
            if (this.ffX != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fax = false;
                bVar3.fay = false;
                bVar3.faz = getBottom();
                bVar3.faA = this.faA;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.ffX.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.ffZ = beK;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ffU.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.ffR.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.ffS.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.ffT.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.ffR.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fbq.beK() != null && this.ffX != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fax = true;
            bVar.fay = false;
            bVar.faz = i4;
            bVar.faA = this.faA;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.ffX.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ffV) {
            this.ffU.draw(canvas);
        }
        this.ffR.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.faA = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a beK = EnterForumDelegateStatic.fbq.beK();
        if (beK != null) {
            String str = EnterForumDelegateStatic.fbq.beK().bWc;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.q.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 0, 0, true, String.valueOf(beK.fau), String.valueOf(beK.fau), 5)) != null) {
                    com.baidu.tieba.q.c.cnk().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.ffY = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.cGJ = z;
        invalidate();
    }

    public boolean bfo() {
        return this.ffY;
    }

    public boolean bfp() {
        return this.cGJ;
    }

    public View getAdImageView() {
        return this.ffW;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fga = aVar;
    }
}
