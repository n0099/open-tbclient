package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class UserRecommendLayout extends LinearLayout {
    private View.OnClickListener cEB;
    private View.OnClickListener cEC;
    private int cTE;
    private int cTF;
    private com.baidu.adp.lib.e.b<g> cTG;
    private final ViewGroup.OnHierarchyChangeListener cTH;
    private TbPageContext pageContext;

    public UserRecommendLayout(Context context) {
        super(context);
        this.cTF = 0;
        this.cEB = null;
        this.cEC = null;
        this.cTG = null;
        this.cTH = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof g) && UserRecommendLayout.this.cTG != null) {
                    g gVar = (g) view2;
                    if (gVar.getTag() instanceof c) {
                        ((c) gVar.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.cTG.m((g) view2);
                }
            }
        };
        init();
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cTF = 0;
        this.cEB = null;
        this.cEC = null;
        this.cTG = null;
        this.cTH = new ViewGroup.OnHierarchyChangeListener() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
                if ((view2 instanceof g) && UserRecommendLayout.this.cTG != null) {
                    g gVar = (g) view2;
                    if (gVar.getTag() instanceof c) {
                        ((c) gVar.getTag()).unRegisterListener(UserRecommendLayout.this.pageContext.getUniqueId());
                    }
                    UserRecommendLayout.this.cTG.m((g) view2);
                }
            }
        };
        init();
    }

    private void init() {
        setOrientation(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.cTH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    public void setData(List<MetaData> list) {
        if (!v.v(list)) {
            int ac = ((com.baidu.adp.lib.util.e.ac(getContext()) - (getPaddingLeft() * 2)) - (this.cTF * 2)) / 3;
            this.cTE = this.cTF + ac;
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount && i < list.size()) {
                if (getChildAt(i) instanceof g) {
                    g gVar = (g) getChildAt(i);
                    a(gVar, i, ac);
                    a(gVar, list.get(i));
                }
                i++;
            }
            int i2 = i;
            while (i2 < childCount) {
                removeViewAt(i2);
                i2++;
            }
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    g fH = this.cTG.fH();
                    if (fH.getParent() != null) {
                        ((ViewGroup) fH.getParent()).removeView(fH);
                    }
                    a(fH, i3, ac);
                    a(fH, list.get(i3));
                    addView(fH);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(g gVar, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.cTF;
        }
        gVar.setLayoutParams(layoutParams);
    }

    private void a(final g gVar, MetaData metaData) {
        c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        gVar.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", am.z(metaData.getFansNum())));
        gVar.getUsername().setText(metaData.getName_show());
        gVar.getLikeBtn().setFanNumCallBack(new CommonUserLikeButton.a() { // from class: com.baidu.tieba.frs.view.UserRecommendLayout.2
            @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
            public void dH(int i) {
                gVar.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", am.z(i)));
            }
        });
        if (gVar.getLikeBtn().getTag() instanceof c) {
            cVar = (c) gVar.getLikeBtn().getTag();
        } else {
            cVar = new c(this.pageContext, gVar.getLikeBtn());
        }
        cVar.setFromType(NewWriteModel.THREAD_TYPE_LBS);
        gVar.getLikeBtn().setTag(cVar);
        cVar.a(metaData);
        gVar.getLikeBtn().setAfterOnClickListener(this.cEB);
        gVar.getHeaderView().setData(metaData);
        gVar.getHeaderView().setAfterClickListener(this.cEC);
        gVar.setIsGod(metaData.isGod());
        gVar.onChangeSkinType(skinType);
    }

    public int getChildItemWidth() {
        return this.cTE;
    }

    public void setViewPool(com.baidu.adp.lib.e.b<g> bVar) {
        this.cTG = bVar;
    }

    public void setItemSpace(int i) {
        this.cTF = i;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.cEB = onClickListener;
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.cEC = onClickListener;
    }
}
