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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {
    private int eXO;
    private Drawable fdg;
    private Drawable fdh;
    private Drawable fdi;
    private Drawable fdj;
    private boolean fdk;
    private TbImageView fdl;
    private ViewEventCenter fdm;
    private boolean fdn;
    private com.baidu.tieba.enterForum.data.a fdo;
    private a fdp;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes4.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fdk = false;
        this.fdn = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdk = false;
        this.fdn = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdk = false;
        this.fdn = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fdj = new ColorDrawable(1241513984);
        this.fdg = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fdh = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fdi = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fdp == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fdp.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fdm = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bht();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fdl.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fdl.setLayoutParams(layoutParams2);
    }

    private void bht() {
        an a2;
        if (this.fdl == null) {
            this.fdl = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fdl.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
            this.fdl.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void P(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fdk = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a bgR = EnterForumDelegateStatic.eYF.bgR();
        if (bgR != null && bgR.isValid()) {
            this.fdk = true;
            this.fdl.startLoad(bgR.eXJ, 38, false);
            invalidate();
            if (this.fdm != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.eXL = true;
                bVar.eXM = false;
                bVar.eXN = getBottom();
                bVar.eXO = this.eXO;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fdm.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fdo != bgR && (a2 = com.baidu.tieba.q.a.a(false, "a025", "common_exp", 0, 0, true, String.valueOf(bgR.eXI), String.valueOf(bgR.eXI), 5)) != null) {
                com.baidu.tieba.q.c.cpt().a(this.mTag, "enterfourm_att_" + bgR.eXI, a2);
                com.baidu.tieba.q.c.cpt().b(this.mTag, false);
            }
        } else {
            if (this.fdm != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.eXL = false;
                bVar3.eXM = false;
                bVar3.eXN = getBottom();
                bVar3.eXO = this.eXO;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fdm.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fdo = bgR;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fdj.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fdg.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fdh.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fdi.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fdg.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.eYF.bgR() != null && this.fdm != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.eXL = true;
            bVar.eXM = false;
            bVar.eXN = i4;
            bVar.eXO = this.eXO;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fdm.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fdk) {
            this.fdj.draw(canvas);
        }
        this.fdg.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.eXO = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a bgR = EnterForumDelegateStatic.eYF.bgR();
        if (bgR != null) {
            String str = EnterForumDelegateStatic.eYF.bgR().bEl;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.ae(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.q.a.a(true, "a025", "common_click", 0, 0, true, String.valueOf(bgR.eXI), String.valueOf(bgR.eXI), 5)) != null) {
                    com.baidu.tieba.q.c.cpt().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fdn = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bhu() {
        return this.fdn;
    }

    public boolean bhv() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fdl;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fdp = aVar;
    }
}
