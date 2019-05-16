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
    private int eQX;
    private Drawable eWi;
    private Drawable eWj;
    private Drawable eWk;
    private TbImageView eWl;
    private ViewEventCenter eWm;
    private boolean eWn;
    private boolean isShow;
    private BdUniqueId mTag;

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.eWn = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWn = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWn = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        this.eWi = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.eWj = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.eWk = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.eWm = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        beE();
    }

    private void beE() {
        if (this.eWl == null) {
            this.eWl = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.eWl.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        com.baidu.tieba.enterForum.data.a bec = EnterForumDelegateStatic.eRO.bec();
        if (bec != null) {
            this.eWl.startLoad(bec.picUrl, 38, false);
            if (this.eWm != null) {
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                bVar.eQU = true;
                bVar.eQV = false;
                bVar.eQW = getBottom();
                bVar.eQX = this.eQX;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(bVar);
                this.eWm.dispatchMvcEvent(bVar2);
            }
            setVisibility(0);
            am a = com.baidu.tieba.q.a.a(false, "a025", "common_exp", 0, 0, true, String.valueOf(bec.eQT), String.valueOf(bec.eQT), 5);
            if (a != null) {
                com.baidu.tieba.q.c.clt().a(this.mTag, "enterfourm_att_" + bec.eQT, a);
                com.baidu.tieba.q.c.clt().b(this.mTag, false);
                return;
            }
            return;
        }
        if (this.eWm != null) {
            com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
            bVar3.eQU = false;
            bVar3.eQV = false;
            bVar3.eQW = getBottom();
            bVar3.eQX = this.eQX;
            com.baidu.tbadk.mvc.c.b bVar4 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar4.a(bVar3);
            this.eWm.dispatchMvcEvent(bVar4);
        }
        setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.eWi.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.eWj.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.eWk.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.eWi.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.eRO.bec() != null && this.eWm != null) {
            com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
            bVar.eQU = true;
            bVar.eQV = false;
            bVar.eQW = i4;
            bVar.eQX = this.eQX;
            com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar2.a(bVar);
            this.eWm.dispatchMvcEvent(bVar2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.eWi.draw(canvas);
        if (this.eWn && this.isShow) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.eWk.draw(canvas);
            } else {
                this.eWj.draw(canvas);
            }
        }
    }

    public void setAdViewHeight(int i) {
        this.eQX = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        am a;
        com.baidu.tieba.enterForum.data.a bec = EnterForumDelegateStatic.eRO.bec();
        if (bec != null) {
            String str = EnterForumDelegateStatic.eRO.bec().bCP;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.af(context, str);
                }
                if (bdUniqueId != null && (a = com.baidu.tieba.q.a.a(true, "a025", "common_click", 0, 0, true, String.valueOf(bec.eQT), String.valueOf(bec.eQT), 5)) != null) {
                    com.baidu.tieba.q.c.clt().b(bdUniqueId, a);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.eWn = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }
}
