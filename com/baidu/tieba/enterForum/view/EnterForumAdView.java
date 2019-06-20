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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes4.dex */
public class EnterForumAdView extends FrameLayout {
    private int eQY;
    private Drawable eWj;
    private Drawable eWk;
    private Drawable eWl;
    private TbImageView eWm;
    private ViewEventCenter eWn;
    private boolean eWo;
    private boolean isShow;
    private BdUniqueId mTag;

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.eWo = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWo = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWo = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        this.eWj = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.eWk = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.eWl = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.eWn = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        beH();
    }

    private void beH() {
        if (this.eWm == null) {
            this.eWm = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.eWm.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        com.baidu.tieba.enterForum.data.a bef = EnterForumDelegateStatic.eRP.bef();
        if (bef != null) {
            this.eWm.startLoad(bef.picUrl, 38, false);
            if (this.eWn != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.eQV = true;
                bVar.eQW = false;
                bVar.eQX = getBottom();
                bVar.eQY = this.eQY;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.eWn.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            am a = com.baidu.tieba.q.a.a(false, "a025", "common_exp", 0, 0, true, String.valueOf(bef.eQU), String.valueOf(bef.eQU), 5);
            if (a != null) {
                com.baidu.tieba.q.c.clw().a(this.mTag, "enterfourm_att_" + bef.eQU, a);
                com.baidu.tieba.q.c.clw().b(this.mTag, false);
                return;
            }
            return;
        }
        if (this.eWn != null) {
            com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
            bVar3.eQV = false;
            bVar3.eQW = false;
            bVar3.eQX = getBottom();
            bVar3.eQY = this.eQY;
            com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar4.a(bVar3);
            this.eWn.dispatchMvcEvent(bVar4);
        }
        setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.eWj.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.eWk.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.eWl.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.eWj.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.eRP.bef() != null && this.eWn != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.eQV = true;
            bVar.eQW = false;
            bVar.eQX = i4;
            bVar.eQY = this.eQY;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.eWn.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.eWj.draw(canvas);
        if (this.eWo && this.isShow) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eWl.draw(canvas);
            } else {
                this.eWk.draw(canvas);
            }
        }
    }

    public void setAdViewHeight(int i) {
        this.eQY = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        am a;
        com.baidu.tieba.enterForum.data.a bef = EnterForumDelegateStatic.eRP.bef();
        if (bef != null) {
            String str = EnterForumDelegateStatic.eRP.bef().bCQ;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.af(context, str);
                }
                if (bdUniqueId != null && (a = com.baidu.tieba.q.a.a(true, "a025", "common_click", 0, 0, true, String.valueOf(bef.eQU), String.valueOf(bef.eQU), 5)) != null) {
                    com.baidu.tieba.q.c.clw().b(bdUniqueId, a);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.eWo = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }
}
