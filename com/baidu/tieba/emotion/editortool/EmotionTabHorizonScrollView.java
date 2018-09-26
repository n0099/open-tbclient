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
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools SG;
    private int aCJ;
    private int aSn;
    private LinearLayout.LayoutParams aSp;
    private int aSq;
    private int aSr;
    private TextView aSs;
    private View aSt;
    private EmotionLinearLayout cWE;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cWF;
    private EmotionTabWidgetView.a cWG;
    private LinearLayout cWH;
    private ImageView cWI;
    private boolean cWJ;
    private TbImageView cWK;
    private boolean cWL;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSn = -1;
        this.cWJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSn = -1;
        this.cWJ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aSn = -1;
        this.cWJ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cWE = new EmotionLinearLayout(getContext());
        this.cWE.setOrientation(0);
        this.cWE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cWE.setBaselineAligned(false);
        addView(this.cWE);
        this.aSq = getResources().getDimensionPixelSize(e.C0141e.ds8);
        this.aSr = getResources().getDimensionPixelSize(e.C0141e.ds10);
        this.aSp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0141e.ds122), -1);
        this.cWE.setPadding(0, 0, 0, 0);
        apP();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cWL = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cWF = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cWP = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cWN = tbImageView;
        if (cVar.IY() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aSr, this.aSq, this.aSr, this.aSq);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, e.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), e.C0141e.ds12), l.h(getContext(), e.C0141e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cWO = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0141e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cWE.addView(relativeLayout, this.cWE.getChildCount() - 1, this.aSp);
            if (cVar.Ja() != null) {
                cVar.Ja().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cWL && this.aCJ == 1) {
                view.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.cWK == null) {
                this.cWK = tbImageView;
                this.cWK.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(relativeLayout, e.f.bg_emotion_tab_horizonscrollview, this.aCJ);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aSr, this.aSq, this.aSr, this.aSq);
            View view2 = new View(getContext());
            aVar.cWO = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0141e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cWE.addView(linearLayout, this.cWE.getChildCount() - 1, this.aSp);
            EmotionGroupType IY = cVar.IY();
            if (IY == EmotionGroupType.LOCAL) {
                if (cVar.IZ() != null) {
                    cVar.IZ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cWE.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.local_emotion));
            } else if (IY == EmotionGroupType.PROMOTION) {
                if (cVar.Ja() != null) {
                    cVar.Ja().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (IY == EmotionGroupType.BIG_EMOTION) {
                if (this.cWJ) {
                    if (cVar.IZ() != null) {
                        cVar.IZ().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cWE.getChildCount() - 3));
                } else {
                    if (cVar.Ja() != null) {
                        cVar.Ja().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).yt();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (IY == EmotionGroupType.USER_COLLECT) {
                if (cVar.Ja() != null) {
                    cVar.Ja().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cWE.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (IY == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Ja() != null) {
                    cVar.Ja().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cWL && this.aCJ == 1) {
                view2.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.cWK == null) {
                this.cWK = tbImageView;
                this.cWK.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(linearLayout, e.f.bg_emotion_tab_horizonscrollview, this.aCJ);
        }
        return tbImageView;
    }

    public void apP() {
        this.cWI = new ImageView(getContext());
        this.cWI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cWI.setPadding(this.aSr, this.aSq, this.aSr, this.aSq);
        this.cWH = new LinearLayout(getContext());
        this.cWH.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cWI.setLayoutParams(layoutParams);
        al.b(this.cWI, e.f.face_store, this.aCJ);
        this.cWH.addView(this.cWI);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0141e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, e.d.common_color_10288, this.aCJ);
        this.cWH.addView(view);
        this.aSs = new TextView(getContext());
        this.aSs.setGravity(17);
        this.aSs.setTextSize(10.0f);
        this.aSs.setText("N");
        this.aSs.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cWE.addView(this.cWH, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0141e.ds106), -1));
        this.cWE.setNewView(this.aSs);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cWE.setNewViewVisible(true);
        } else {
            this.cWE.setNewViewVisible(false);
        }
        this.cWH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aSs != null) {
                    EmotionTabHorizonScrollView.this.cWE.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.SG != null) {
                    EmotionTabHorizonScrollView.this.SG.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kK()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), e.j.neterror);
                }
            }
        });
        this.aSt = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aSt.setLayoutParams(layoutParams3);
        this.cWE.addView(this.aSt);
        if (!appResponseToIntentClass) {
            this.cWH.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.cWJ = z;
        int i2 = i + 1;
        int childCount = this.cWE.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cWF.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.IY() == EmotionGroupType.BIG_EMOTION || cVar.IY() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cWE.getChildAt(i2)).getChildAt(0);
                if (!this.cWJ) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).yt();
                        }
                    });
                    if (cVar.Ja() != null) {
                        cVar.Ja().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.IZ() != null) {
                    cVar.IZ().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cWE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cWE.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cWP;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cWH.setVisibility(8);
        } else {
            this.cWH.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.IY() == EmotionGroupType.BIG_EMOTION || cVar.IY() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aSn) {
            if (this.aSn != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cWE.getChildAt(this.aSn + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aCJ == 0) {
                        color = getResources().getColor(e.d.common_color_10287);
                    } else {
                        color = al.getColor(e.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aSn = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cWE.getChildAt(this.aSn + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cWF.get(this.aSn);
            if (cVar.IZ() != null) {
                cVar.IZ().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(e.d.common_color_10022));
                this.cWK = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aSn = -1;
        this.cWE.removeAllViews();
        apP();
        dQ(this.aCJ);
    }

    public void dQ(int i) {
        int color;
        this.aCJ = i;
        if (this.cWI != null) {
            al.b(this.cWI, e.f.face_store, i);
        }
        if (this.cWH != null) {
            al.d(this.cWH, e.f.bg_emotion_tab_horizonscrollview, i);
            if (this.cWH.getChildCount() > 0) {
                al.e(this.cWH.getChildAt(1), e.d.common_color_10288, i);
            }
        }
        if (this.aSt != null) {
            al.d(this.aSt, e.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aSs != null) {
            al.d(this.aSs, e.f.icon_news_head_prompt_one, i);
            al.b(this.aSs, e.d.cp_cont_i, 1, i);
        }
        int childCount = this.cWE.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cWE.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, e.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cWN != null) {
                        if (i == 0) {
                            color = getResources().getColor(e.d.common_color_10287);
                        } else {
                            color = al.getColor(e.d.common_color_10287);
                        }
                        aVar.cWN.setForegroundColor(color);
                    }
                    if (aVar.cWO != null) {
                        al.e(aVar.cWO, e.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cWK != null) {
            this.cWK.setForegroundColor(al.getColor(e.d.common_color_10022));
            if (this.cWK.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cWK.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cWG = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aqP;

        private b(int i) {
            this.aqP = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cWK) {
                ((TbImageView) view).setForegroundColor(al.getColor(e.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cWK != null) {
                    if (!EmotionTabHorizonScrollView.this.cWL) {
                        EmotionTabHorizonScrollView.this.cWK.setForegroundColor(al.getColor(e.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cWK.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(e.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cWK = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aqP);
            EmotionTabHorizonScrollView.this.cWG.fk(this.aqP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
    public static class a {
        TbImageView cWN;
        View cWO;
        com.baidu.tbadk.editortools.emotiontool.c cWP;

        private a() {
        }
    }
}
