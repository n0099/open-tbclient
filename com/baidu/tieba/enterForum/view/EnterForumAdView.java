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
/* loaded from: classes21.dex */
public class EnterForumAdView extends FrameLayout {
    private int hBe;
    private boolean hJA;
    private com.baidu.tieba.enterForum.data.b hJB;
    private a hJC;
    private Drawable hJt;
    private Drawable hJu;
    private Drawable hJv;
    private Drawable hJw;
    private boolean hJx;
    private TbImageView hJy;
    private ViewEventCenter hJz;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes21.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.hJx = false;
        this.hJA = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hJx = false;
        this.hJA = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hJx = false;
        this.hJA = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.hJw = new ColorDrawable(1241513984);
        this.hJt = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.hJu = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.hJv = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hJC == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hJC.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.hJz = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        ckd();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.hJy.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.hJy.setLayoutParams(layoutParams2);
    }

    private void ckd() {
        aq a2;
        if (this.hJy == null) {
            this.hJy = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.hJy.setPlaceHolder(3);
            this.hJy.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.hJx = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cjo = EnterForumDelegateStatic.hCe.cjo();
        if (cjo != null && cjo.isValid()) {
            this.hJx = true;
            this.hJy.startLoad(cjo.hAZ, 38, false);
            invalidate();
            if (this.hJz != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.hBb = true;
                cVar.hBc = false;
                cVar.hBd = getBottom();
                cVar.hBe = this.hBe;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.hJz.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.hJB != cjo && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cjo.hAY), String.valueOf(cjo.hAY), 5)) != null) {
                com.baidu.tieba.s.c.dzC().a(this.mTag, com.baidu.tieba.s.a.QZ("" + cjo.hAY), a2);
                com.baidu.tieba.s.c.dzC().b(this.mTag, false);
            }
        } else {
            if (this.hJz != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.hBb = false;
                cVar2.hBc = false;
                cVar2.hBd = getBottom();
                cVar2.hBe = this.hBe;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.hJz.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.hJB = cjo;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hJw.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.hJt.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.hJu.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.hJv.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hJt.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.hCe.cjo() != null && this.hJz != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.hBb = true;
            cVar.hBc = false;
            cVar.hBd = i4;
            cVar.hBe = this.hBe;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.hJz.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hJx) {
            this.hJw.draw(canvas);
        }
        this.hJt.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.hBe = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b cjo = EnterForumDelegateStatic.hCe.cjo();
        if (cjo != null) {
            String str = EnterForumDelegateStatic.hCe.cjo().aEb;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cjo.hAY), String.valueOf(cjo.hAY), 5)) != null) {
                    com.baidu.tieba.s.c.dzC().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.hJA = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cke() {
        return this.hJA;
    }

    public boolean ckf() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.hJy;
    }

    public void setOnBackPressedListener(a aVar) {
        this.hJC = aVar;
    }
}
