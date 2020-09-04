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
    private a hCA;
    private Drawable hCr;
    private Drawable hCs;
    private Drawable hCt;
    private Drawable hCu;
    private boolean hCv;
    private TbImageView hCw;
    private ViewEventCenter hCx;
    private boolean hCy;
    private com.baidu.tieba.enterForum.data.b hCz;
    private int htZ;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes16.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.hCv = false;
        this.hCy = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hCv = false;
        this.hCy = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hCv = false;
        this.hCy = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.hCu = new ColorDrawable(1241513984);
        this.hCr = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.hCs = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.hCt = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.hCA == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.hCA.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.hCx = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cgO();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.hCw.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.hCw.setLayoutParams(layoutParams2);
    }

    private void cgO() {
        aq a2;
        if (this.hCw == null) {
            this.hCw = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.hCw.setPlaceHolder(3);
            this.hCw.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.hCv = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.a
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cfX = EnterForumDelegateStatic.huZ.cfX();
        if (cfX != null && cfX.isValid()) {
            this.hCv = true;
            this.hCw.startLoad(cfX.htU, 38, false);
            invalidate();
            if (this.hCx != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.htW = true;
                cVar.htX = false;
                cVar.htY = getBottom();
                cVar.htZ = this.htZ;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.hCx.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.hCz != cfX && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cfX.htT), String.valueOf(cfX.htT), 5)) != null) {
                com.baidu.tieba.s.c.dvJ().a(this.mTag, com.baidu.tieba.s.a.Qz("" + cfX.htT), a2);
                com.baidu.tieba.s.c.dvJ().b(this.mTag, false);
            }
        } else {
            if (this.hCx != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.htW = false;
                cVar2.htX = false;
                cVar2.htY = getBottom();
                cVar2.htZ = this.htZ;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.hCx.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.hCz = cfX;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hCu.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.hCr.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.hCs.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.hCt.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.hCr.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.huZ.cfX() != null && this.hCx != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.htW = true;
            cVar.htX = false;
            cVar.htY = i4;
            cVar.htZ = this.htZ;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.hCx.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hCv) {
            this.hCu.draw(canvas);
        }
        this.hCr.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.htZ = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        aq a2;
        com.baidu.tieba.enterForum.data.b cfX = EnterForumDelegateStatic.huZ.cfX();
        if (cfX != null) {
            String str = EnterForumDelegateStatic.huZ.cfX().aDi;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cfX.htT), String.valueOf(cfX.htT), 5)) != null) {
                    com.baidu.tieba.s.c.dvJ().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.hCy = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cgP() {
        return this.hCy;
    }

    public boolean cgQ() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.hCw;
    }

    public void setOnBackPressedListener(a aVar) {
        this.hCA = aVar;
    }
}
