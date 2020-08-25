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
/* loaded from: classes16.dex */
public class EnterForumAdView extends FrameLayout {
    private Drawable hCl;
    private Drawable hCm;
    private Drawable hCn;
    private Drawable hCo;
    private boolean hCp;
    private TbImageView hCq;
    private ViewEventCenter hCr;
    private boolean hCs;
    private com.baidu.tieba.enterForum.data.b hCt;
    private a hCu;
    private int htT;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes16.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.hCp = false;
        this.hCs = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hCp = false;
        this.hCs = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hCp = false;
        this.hCs = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.hCo = new ColorDrawable(1241513984);
        this.hCl = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.hCm = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.hCn = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hCu == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hCu.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.hCr = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cgN();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.hCq.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.hCq.setLayoutParams(layoutParams2);
    }

    private void cgN() {
        aq a2;
        if (this.hCq == null) {
            this.hCq = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.hCq.setPlaceHolder(3);
            this.hCq.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.hCp = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cfW = EnterForumDelegateStatic.huT.cfW();
        if (cfW != null && cfW.isValid()) {
            this.hCp = true;
            this.hCq.startLoad(cfW.htO, 38, false);
            invalidate();
            if (this.hCr != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.htQ = true;
                cVar.htR = false;
                cVar.htS = getBottom();
                cVar.htT = this.htT;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.hCr.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.hCt != cfW && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cfW.htN), String.valueOf(cfW.htN), 5)) != null) {
                com.baidu.tieba.s.c.dvE().a(this.mTag, com.baidu.tieba.s.a.Qz("" + cfW.htN), a2);
                com.baidu.tieba.s.c.dvE().b(this.mTag, false);
            }
        } else {
            if (this.hCr != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.htQ = false;
                cVar2.htR = false;
                cVar2.htS = getBottom();
                cVar2.htT = this.htT;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.hCr.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.hCt = cfW;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hCo.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.hCl.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.hCm.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.hCn.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hCl.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.huT.cfW() != null && this.hCr != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.htQ = true;
            cVar.htR = false;
            cVar.htS = i4;
            cVar.htT = this.htT;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.hCr.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hCp) {
            this.hCo.draw(canvas);
        }
        this.hCl.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.htT = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b cfW = EnterForumDelegateStatic.huT.cfW();
        if (cfW != null) {
            String str = EnterForumDelegateStatic.huT.cfW().aDg;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cfW.htN), String.valueOf(cfW.htN), 5)) != null) {
                    com.baidu.tieba.s.c.dvE().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.hCs = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cgO() {
        return this.hCs;
    }

    public boolean cgP() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.hCq;
    }

    public void setOnBackPressedListener(a aVar) {
        this.hCu = aVar;
    }
}
