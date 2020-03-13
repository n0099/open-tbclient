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
    private int fUj;
    private Drawable fZd;
    private Drawable fZe;
    private Drawable fZf;
    private Drawable fZg;
    private boolean fZh;
    private TbImageView fZi;
    private ViewEventCenter fZj;
    private boolean fZk;
    private com.baidu.tieba.enterForum.data.a fZl;
    private a fZm;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fZh = false;
        this.fZk = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fZh = false;
        this.fZk = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fZh = false;
        this.fZk = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.fZg = new ColorDrawable(1241513984);
        this.fZd = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fZe = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fZf = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.fZm == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.fZm.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fZj = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bzn();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.fZi.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.fZi.setLayoutParams(layoutParams2);
    }

    private void bzn() {
        an a2;
        if (this.fZi == null) {
            this.fZi = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fZi.setPlaceHolder(3);
            this.fZi.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.fZh = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.a byM = EnterForumDelegateStatic.fUX.byM();
        if (byM != null && byM.isValid()) {
            this.fZh = true;
            this.fZi.startLoad(byM.fUe, 38, false);
            invalidate();
            if (this.fZj != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.fUg = true;
                bVar.fUh = false;
                bVar.fUi = getBottom();
                bVar.fUj = this.fUj;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fZj.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            if (this.fZl != byM && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(byM.fUd), String.valueOf(byM.fUd), 5)) != null) {
                com.baidu.tieba.s.c.cKb().a(this.mTag, com.baidu.tieba.s.a.IP("" + byM.fUd), a2);
                com.baidu.tieba.s.c.cKb().b(this.mTag, false);
            }
        } else {
            if (this.fZj != null) {
                com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
                bVar3.fUg = false;
                bVar3.fUh = false;
                bVar3.fUi = getBottom();
                bVar3.fUj = this.fUj;
                com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar4.a(bVar3);
                this.fZj.dispatchMvcEvent(bVar4);
            }
            setVisibility(8);
        }
        this.fZl = byM;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fZg.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.fZd.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fZe.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fZf.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fZd.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.fUX.byM() != null && this.fZj != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.fUg = true;
            bVar.fUh = false;
            bVar.fUi = i4;
            bVar.fUj = this.fUj;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fZj.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fZh) {
            this.fZg.draw(canvas);
        }
        this.fZd.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.fUj = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a2;
        com.baidu.tieba.enterForum.data.a byM = EnterForumDelegateStatic.fUX.byM();
        if (byM != null) {
            String str = EnterForumDelegateStatic.fUX.byM().cLS;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(byM.fUd), String.valueOf(byM.fUd), 5)) != null) {
                    com.baidu.tieba.s.c.cKb().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fZk = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bzo() {
        return this.fZk;
    }

    public boolean bzp() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.fZi;
    }

    public void setOnBackPressedListener(a aVar) {
        this.fZm = aVar;
    }
}
