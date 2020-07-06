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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes9.dex */
public class EnterForumAdView extends FrameLayout {
    private int hbv;
    private Drawable hjM;
    private Drawable hjN;
    private Drawable hjO;
    private Drawable hjP;
    private boolean hjQ;
    private TbImageView hjR;
    private ViewEventCenter hjS;
    private boolean hjT;
    private com.baidu.tieba.enterForum.data.b hjU;
    private a hjV;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes9.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.hjQ = false;
        this.hjT = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjQ = false;
        this.hjT = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjQ = false;
        this.hjT = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.hjP = new ColorDrawable(1241513984);
        this.hjM = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.hjN = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.hjO = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hjV == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hjV.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.hjS = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bTj();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.hjR.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.hjR.setLayoutParams(layoutParams2);
    }

    private void bTj() {
        ao a2;
        if (this.hjR == null) {
            this.hjR = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.hjR.setPlaceHolder(3);
            this.hjR.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.hjQ = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b bSs = EnterForumDelegateStatic.hck.bSs();
        if (bSs != null && bSs.isValid()) {
            this.hjQ = true;
            this.hjR.startLoad(bSs.hbq, 38, false);
            invalidate();
            if (this.hjS != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.hbs = true;
                cVar.hbt = false;
                cVar.hbu = getBottom();
                cVar.hbv = this.hbv;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.hjS.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.hjU != bSs && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(bSs.hbp), String.valueOf(bSs.hbp), 5)) != null) {
                com.baidu.tieba.s.c.dgY().a(this.mTag, com.baidu.tieba.s.a.MQ("" + bSs.hbp), a2);
                com.baidu.tieba.s.c.dgY().b(this.mTag, false);
            }
        } else {
            if (this.hjS != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.hbs = false;
                cVar2.hbt = false;
                cVar2.hbu = getBottom();
                cVar2.hbv = this.hbv;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.hjS.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.hjU = bSs;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hjP.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.hjM.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.hjN.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.hjO.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hjM.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.hck.bSs() != null && this.hjS != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.hbs = true;
            cVar.hbt = false;
            cVar.hbu = i4;
            cVar.hbv = this.hbv;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.hjS.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hjQ) {
            this.hjP.draw(canvas);
        }
        this.hjM.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.hbv = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ao a2;
        com.baidu.tieba.enterForum.data.b bSs = EnterForumDelegateStatic.hck.bSs();
        if (bSs != null) {
            String str = EnterForumDelegateStatic.hck.bSs().awR;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(bSs.hbp), String.valueOf(bSs.hbp), 5)) != null) {
                    com.baidu.tieba.s.c.dgY().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.hjT = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean bTk() {
        return this.hjT;
    }

    public boolean bTl() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.hjR;
    }

    public void setOnBackPressedListener(a aVar) {
        this.hjV = aVar;
    }
}
