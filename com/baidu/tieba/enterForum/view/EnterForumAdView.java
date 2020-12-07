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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes22.dex */
public class EnterForumAdView extends FrameLayout {
    private com.baidu.tieba.enterForum.data.b iCA;
    private a iCB;
    private Drawable iCs;
    private Drawable iCt;
    private Drawable iCu;
    private Drawable iCv;
    private boolean iCw;
    private TbImageView iCx;
    private ViewEventCenter iCy;
    private boolean iCz;
    private boolean isShow;
    private int iue;
    private BdUniqueId mTag;

    /* loaded from: classes22.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iCw = false;
        this.iCz = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iCw = false;
        this.iCz = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iCw = false;
        this.iCz = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iCv = new ColorDrawable(1241513984);
        this.iCs = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iCt = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iCu = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iCB == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iCB.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iCy = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cwZ();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iCx.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iCx.setLayoutParams(layoutParams2);
    }

    private void cwZ() {
        ar a2;
        if (this.iCx == null) {
            this.iCx = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iCx.setPlaceHolder(3);
            this.iCx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iCw = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cwk = EnterForumDelegateStatic.ive.cwk();
        if (cwk != null && cwk.isValid()) {
            this.iCw = true;
            this.iCx.startLoad(cwk.itZ, 38, false);
            invalidate();
            if (this.iCy != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iub = true;
                cVar.iuc = false;
                cVar.iud = getBottom();
                cVar.iue = this.iue;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iCy.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iCA != cwk && (a2 = com.baidu.tieba.t.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cwk.itY), String.valueOf(cwk.itY), 5)) != null) {
                com.baidu.tieba.t.c.dOe().a(this.mTag, com.baidu.tieba.t.a.Ts("" + cwk.itY), a2);
                com.baidu.tieba.t.c.dOe().b(this.mTag, false);
            }
        } else {
            if (this.iCy != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iub = false;
                cVar2.iuc = false;
                cVar2.iud = getBottom();
                cVar2.iue = this.iue;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iCy.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iCA = cwk;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iCv.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iCs.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iCt.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iCu.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iCs.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.ive.cwk() != null && this.iCy != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iub = true;
            cVar.iuc = false;
            cVar.iud = i4;
            cVar.iue = this.iue;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iCy.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iCw) {
            this.iCv.draw(canvas);
        }
        this.iCs.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iue = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ar a2;
        com.baidu.tieba.enterForum.data.b cwk = EnterForumDelegateStatic.ive.cwk();
        if (cwk != null) {
            String str = EnterForumDelegateStatic.ive.cwk().aJj;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.t.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cwk.itY), String.valueOf(cwk.itY), 5)) != null) {
                    com.baidu.tieba.t.c.dOe().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iCz = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cxa() {
        return this.iCz;
    }

    public boolean cxb() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iCx;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iCB = aVar;
    }
}
