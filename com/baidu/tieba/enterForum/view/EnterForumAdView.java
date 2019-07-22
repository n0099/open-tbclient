package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {
    private int eVY;
    private Drawable fbk;
    private Drawable fbl;
    private Drawable fbm;
    private TbImageView fbn;
    private ViewEventCenter fbo;
    private boolean fbp;
    private boolean isShow;
    private BdUniqueId mTag;

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.fbp = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbp = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbp = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        this.fbk = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.fbl = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.fbm = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.fbo = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        bgK();
    }

    private void bgK() {
        if (this.fbn == null) {
            this.fbn = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.fbn.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        }
        com.baidu.tieba.enterForum.data.a bgi = EnterForumDelegateStatic.eWP.bgi();
        if (bgi != null) {
            this.fbn.startLoad(bgi.picUrl, 38, false);
            if (this.fbo != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.eVV = true;
                bVar.eVW = false;
                bVar.eVX = getBottom();
                bVar.eVY = this.eVY;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.fbo.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            an a = com.baidu.tieba.q.a.a(false, "a025", "common_exp", 0, 0, true, String.valueOf(bgi.eVU), String.valueOf(bgi.eVU), 5);
            if (a != null) {
                com.baidu.tieba.q.c.coo().a(this.mTag, "enterfourm_att_" + bgi.eVU, a);
                com.baidu.tieba.q.c.coo().b(this.mTag, false);
                return;
            }
            return;
        }
        if (this.fbo != null) {
            com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
            bVar3.eVV = false;
            bVar3.eVW = false;
            bVar3.eVX = getBottom();
            bVar3.eVY = this.eVY;
            com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar4.a(bVar3);
            this.fbo.dispatchMvcEvent(bVar4);
        }
        setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.fbk.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.fbl.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.fbm.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.fbk.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.eWP.bgi() != null && this.fbo != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.eVV = true;
            bVar.eVW = false;
            bVar.eVX = i4;
            bVar.eVY = this.eVY;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.fbo.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.fbk.draw(canvas);
        if (this.fbp && this.isShow) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.fbm.draw(canvas);
            } else {
                this.fbl.draw(canvas);
            }
        }
    }

    public void setAdViewHeight(int i) {
        this.eVY = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        an a;
        com.baidu.tieba.enterForum.data.a bgi = EnterForumDelegateStatic.eWP.bgi();
        if (bgi != null) {
            String str = EnterForumDelegateStatic.eWP.bgi().bDN;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.ae(context, str);
                }
                if (bdUniqueId != null && (a = com.baidu.tieba.q.a.a(true, "a025", "common_click", 0, 0, true, String.valueOf(bgi.eVU), String.valueOf(bgi.eVU), 5)) != null) {
                    com.baidu.tieba.q.c.coo().b(bdUniqueId, a);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.fbp = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }
}
