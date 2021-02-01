package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
/* loaded from: classes2.dex */
public class EnterForumAdView extends FrameLayout {
    private int iHw;
    private Drawable iPH;
    private Drawable iPI;
    private Drawable iPJ;
    private Drawable iPK;
    private boolean iPL;
    private TbImageView iPM;
    private ViewEventCenter iPN;
    private boolean iPO;
    private com.baidu.tieba.enterForum.data.b iPP;
    private a iPQ;
    private boolean isShow;
    private BdUniqueId mTag;

    /* loaded from: classes2.dex */
    public interface a {
        void onBackPressed();
    }

    public EnterForumAdView(@NonNull Context context) {
        super(context);
        this.iPL = false;
        this.iPO = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iPL = false;
        this.iPO = false;
        this.isShow = false;
        init(context);
    }

    public EnterForumAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iPL = false;
        this.iPO = false;
        this.isShow = false;
        init(context);
    }

    private void init(Context context) {
        setClipChildren(true);
        this.iPK = new ColorDrawable(1241513984);
        this.iPH = context.getResources().getDrawable(R.drawable.enter_forum_ad_top_shader);
        this.iPI = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2);
        this.iPJ = context.getResources().getDrawable(R.drawable.enter_forum_ad_bottom_shader2_1);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(EnterForumAdView.this.mTag, EnterForumAdView.this.getContext());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.iPQ == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.iPQ.onBackPressed();
        return true;
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.iPN = viewEventCenter;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setAdData() {
        cxo();
        ((ViewGroup) getRootView()).setClipChildren(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getRootView().getHeight();
        setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.iPM.getLayoutParams();
        layoutParams2.height = getRootView().getHeight();
        this.iPM.setLayoutParams(layoutParams2);
    }

    private void cxo() {
        ar a2;
        if (this.iPM == null) {
            this.iPM = (TbImageView) findViewById(R.id.enter_forum_ad_image);
            this.iPM.setPlaceHolder(3);
            this.iPM.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.enterForum.view.EnterForumAdView.2
                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onComplete(String str, boolean z) {
                    if (z) {
                        EnterForumAdView.this.iPL = false;
                        EnterForumAdView.this.invalidate();
                    }
                }

                @Override // com.baidu.tbadk.widget.TbImageView.b
                public void onCancel() {
                }
            });
        }
        com.baidu.tieba.enterForum.data.b cwz = EnterForumDelegateStatic.iIw.cwz();
        if (cwz != null && cwz.isValid()) {
            this.iPL = true;
            this.iPM.startLoad(cwz.iHr, 38, false);
            invalidate();
            if (this.iPN != null) {
                com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                cVar.iHt = true;
                cVar.iHu = false;
                cVar.iHv = getBottom();
                cVar.iHw = this.iHw;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar.a(cVar);
                this.iPN.dispatchMvcEvent(bVar);
            }
            setVisibility(0);
            if (this.iPP != cwz && (a2 = com.baidu.tieba.s.a.a(false, PageStayDurationConstants.PageName.ENTER_FORUM, "common_exp", 0, 1, true, String.valueOf(cwz.iHq), String.valueOf(cwz.iHq), 5)) != null) {
                com.baidu.tieba.s.c.dMr().a(this.mTag, com.baidu.tieba.s.a.SQ("" + cwz.iHq), a2);
                com.baidu.tieba.s.c.dMr().b(this.mTag, false);
            }
        } else {
            if (this.iPN != null) {
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.iHt = false;
                cVar2.iHu = false;
                cVar2.iHv = getBottom();
                cVar2.iHw = this.iHw;
                com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
                bVar2.a(cVar2);
                this.iPN.dispatchMvcEvent(bVar2);
            }
            setVisibility(8);
        }
        this.iPP = cwz;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.iPK.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.iPH.setBounds(0, 0, getMeasuredWidth(), getResources().getDimensionPixelOffset(R.dimen.tbds260));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.tbds240);
        this.iPI.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
        this.iPJ.setBounds(0, getMeasuredHeight() - dimensionPixelOffset, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.iPH.setBounds(0, -i2, getMeasuredWidth(), (-i2) + getResources().getDimensionPixelOffset(R.dimen.tbds260));
        if (z && EnterForumDelegateStatic.iIw.cwz() != null && this.iPN != null) {
            com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
            cVar.iHt = true;
            cVar.iHu = false;
            cVar.iHv = i4;
            cVar.iHw = this.iHw;
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(16, null, null, null);
            bVar.a(cVar);
            this.iPN.dispatchMvcEvent(bVar);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iPL) {
            this.iPK.draw(canvas);
        }
        this.iPH.draw(canvas);
    }

    public void setAdViewHeight(int i) {
        this.iHw = i;
    }

    public static final void a(BdUniqueId bdUniqueId, Context context) {
        ar a2;
        com.baidu.tieba.enterForum.data.b cwz = EnterForumDelegateStatic.iIw.cwz();
        if (cwz != null) {
            String str = EnterForumDelegateStatic.iIw.cwz().aHq;
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    com.baidu.tbadk.browser.a.startWebActivity(context, str);
                }
                if (bdUniqueId != null && (a2 = com.baidu.tieba.s.a.a(true, PageStayDurationConstants.PageName.ENTER_FORUM, "common_click", 3, 1, true, String.valueOf(cwz.iHq), String.valueOf(cwz.iHq), 5)) != null) {
                    com.baidu.tieba.s.c.dMr().b(bdUniqueId, a2);
                }
            }
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        this.iPO = z;
        invalidate();
    }

    public void setRecentlyIsShow(boolean z) {
        this.isShow = z;
        invalidate();
    }

    public boolean cxp() {
        return this.iPO;
    }

    public boolean cxq() {
        return this.isShow;
    }

    public View getAdImageView() {
        return this.iPM;
    }

    public void setOnBackPressedListener(a aVar) {
        this.iPQ = aVar;
    }
}
