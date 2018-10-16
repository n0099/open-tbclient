package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools SY;
    private int aHp;
    private int aWO;
    private LinearLayout.LayoutParams aWQ;
    private int aWR;
    private int aWS;
    private TextView aWT;
    private View aWU;
    private EmotionLinearLayout deW;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> deX;
    private EmotionTabWidgetView.a deY;
    private LinearLayout deZ;
    private ImageView dfa;
    private boolean dfb;
    private TbImageView dfc;
    private boolean dfd;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWO = -1;
        this.dfb = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWO = -1;
        this.dfb = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aWO = -1;
        this.dfb = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.deW = new EmotionLinearLayout(getContext());
        this.deW.setOrientation(0);
        this.deW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.deW.setBaselineAligned(false);
        addView(this.deW);
        this.aWR = getResources().getDimensionPixelSize(e.C0175e.ds8);
        this.aWS = getResources().getDimensionPixelSize(e.C0175e.ds10);
        this.aWQ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0175e.ds122), -1);
        this.deW.setPadding(0, 0, 0, 0);
        atl();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dfd = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.deX = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dfh = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dff = tbImageView;
        if (cVar.KW() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aWS, this.aWR, this.aWS, this.aWR);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, e.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), e.C0175e.ds12), l.h(getContext(), e.C0175e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dfg = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0175e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.deW.addView(relativeLayout, this.deW.getChildCount() - 1, this.aWQ);
            if (cVar.KY() != null) {
                cVar.KY().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dfd && this.aHp == 1) {
                view.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dfc == null) {
                this.dfc = tbImageView;
                this.dfc.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(relativeLayout, e.f.bg_emotion_tab_horizonscrollview, this.aHp);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aWS, this.aWR, this.aWS, this.aWR);
            View view2 = new View(getContext());
            aVar.dfg = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0175e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.deW.addView(linearLayout, this.deW.getChildCount() - 1, this.aWQ);
            EmotionGroupType KW = cVar.KW();
            if (KW == EmotionGroupType.LOCAL) {
                if (cVar.KX() != null) {
                    cVar.KX().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.deW.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.local_emotion));
            } else if (KW == EmotionGroupType.PROMOTION) {
                if (cVar.KY() != null) {
                    cVar.KY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (KW == EmotionGroupType.BIG_EMOTION) {
                if (this.dfb) {
                    if (cVar.KX() != null) {
                        cVar.KX().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.deW.getChildCount() - 3));
                } else {
                    if (cVar.KY() != null) {
                        cVar.KY().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).AC();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (KW == EmotionGroupType.USER_COLLECT) {
                if (cVar.KY() != null) {
                    cVar.KY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.deW.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (KW == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.KY() != null) {
                    cVar.KY().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dfd && this.aHp == 1) {
                view2.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dfc == null) {
                this.dfc = tbImageView;
                this.dfc.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(linearLayout, e.f.bg_emotion_tab_horizonscrollview, this.aHp);
        }
        return tbImageView;
    }

    public void atl() {
        this.dfa = new ImageView(getContext());
        this.dfa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dfa.setPadding(this.aWS, this.aWR, this.aWS, this.aWR);
        this.deZ = new LinearLayout(getContext());
        this.deZ.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dfa.setLayoutParams(layoutParams);
        al.b(this.dfa, e.f.face_store, this.aHp);
        this.deZ.addView(this.dfa);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0175e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, e.d.common_color_10288, this.aHp);
        this.deZ.addView(view);
        this.aWT = new TextView(getContext());
        this.aWT.setGravity(17);
        this.aWT.setTextSize(10.0f);
        this.aWT.setText("N");
        this.aWT.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.deW.addView(this.deZ, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0175e.ds106), -1));
        this.deW.setNewView(this.aWT);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.deW.setNewViewVisible(true);
        } else {
            this.deW.setNewViewVisible(false);
        }
        this.deZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aWT != null) {
                    EmotionTabHorizonScrollView.this.deW.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.SY != null) {
                    EmotionTabHorizonScrollView.this.SY.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kX()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), e.j.neterror);
                }
            }
        });
        this.aWU = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aWU.setLayoutParams(layoutParams3);
        this.deW.addView(this.aWU);
        if (!appResponseToIntentClass) {
            this.deZ.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dfb = z;
        int i2 = i + 1;
        int childCount = this.deW.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.deX.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.KW() == EmotionGroupType.BIG_EMOTION || cVar.KW() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.deW.getChildAt(i2)).getChildAt(0);
                if (!this.dfb) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).AC();
                        }
                    });
                    if (cVar.KY() != null) {
                        cVar.KY().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.KX() != null) {
                    cVar.KX().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.deW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.deW.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dfh;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.deZ.setVisibility(8);
        } else {
            this.deZ.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.KW() == EmotionGroupType.BIG_EMOTION || cVar.KW() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aWO) {
            if (this.aWO != -1) {
                LinearLayout linearLayout = (LinearLayout) this.deW.getChildAt(this.aWO + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aHp == 0) {
                        color = getResources().getColor(e.d.common_color_10287);
                    } else {
                        color = al.getColor(e.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aWO = i;
            LinearLayout linearLayout2 = (LinearLayout) this.deW.getChildAt(this.aWO + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(e.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.deX.get(this.aWO);
            if (cVar.KX() != null) {
                cVar.KX().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(e.d.common_color_10022));
                this.dfc = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aWO = -1;
        this.deW.removeAllViews();
        atl();
        ea(this.aHp);
    }

    public void ea(int i) {
        int color;
        this.aHp = i;
        if (this.dfa != null) {
            al.b(this.dfa, e.f.face_store, i);
        }
        if (this.deZ != null) {
            al.d(this.deZ, e.f.bg_emotion_tab_horizonscrollview, i);
            if (this.deZ.getChildCount() > 0) {
                al.e(this.deZ.getChildAt(1), e.d.common_color_10288, i);
            }
        }
        if (this.aWU != null) {
            al.d(this.aWU, e.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aWT != null) {
            al.d(this.aWT, e.f.icon_news_head_prompt_one, i);
            al.b(this.aWT, e.d.cp_cont_i, 1, i);
        }
        int childCount = this.deW.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.deW.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, e.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dff != null) {
                        if (i == 0) {
                            color = getResources().getColor(e.d.common_color_10287);
                        } else {
                            color = al.getColor(e.d.common_color_10287);
                        }
                        aVar.dff.setForegroundColor(color);
                    }
                    if (aVar.dfg != null) {
                        al.e(aVar.dfg, e.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dfc != null) {
            this.dfc.setForegroundColor(al.getColor(e.d.common_color_10022));
            if (this.dfc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dfc.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.deY = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        private final int avG;

        private b(int i) {
            this.avG = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dfc) {
                ((TbImageView) view).setForegroundColor(al.getColor(e.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dfc != null) {
                    if (!EmotionTabHorizonScrollView.this.dfd) {
                        EmotionTabHorizonScrollView.this.dfc.setForegroundColor(al.getColor(e.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dfc.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(e.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dfc = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.avG);
            EmotionTabHorizonScrollView.this.deY.ft(this.avG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.l(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.l(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TbImageView dff;
        View dfg;
        com.baidu.tbadk.editortools.emotiontool.c dfh;

        private a() {
        }
    }
}
