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
    private EditorTools Ta;
    private int aLF;
    private int bbd;
    private int bbe;
    private TextView bbf;
    private View bbg;
    private EmotionLinearLayout dmI;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dmJ;
    private EmotionTabWidgetView.a dmK;
    private LinearLayout dmL;
    private ImageView dmM;
    private boolean dmN;
    private TbImageView dmO;
    private boolean dmP;
    private int from;
    private int mCurrentIndex;
    private LinearLayout.LayoutParams mParams;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.dmN = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.dmN = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.dmN = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dmI = new EmotionLinearLayout(getContext());
        this.dmI.setOrientation(0);
        this.dmI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dmI.setBaselineAligned(false);
        addView(this.dmI);
        this.bbd = getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.bbe = getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds122), -1);
        this.dmI.setPadding(0, 0, 0, 0);
        aux();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dmP = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dmJ = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dmT = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dmR = tbImageView;
        if (cVar.Mm() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bbe, this.bbd, this.bbe, this.bbd);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, e.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), e.C0210e.ds12), l.h(getContext(), e.C0210e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dmS = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dmI.addView(relativeLayout, this.dmI.getChildCount() - 1, this.mParams);
            if (cVar.Mo() != null) {
                cVar.Mo().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dmP && this.aLF == 1) {
                view.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dmO == null) {
                this.dmO = tbImageView;
                this.dmO.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(relativeLayout, e.f.bg_emotion_tab_horizonscrollview, this.aLF);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bbe, this.bbd, this.bbe, this.bbd);
            View view2 = new View(getContext());
            aVar.dmS = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dmI.addView(linearLayout, this.dmI.getChildCount() - 1, this.mParams);
            EmotionGroupType Mm = cVar.Mm();
            if (Mm == EmotionGroupType.LOCAL) {
                if (cVar.Mn() != null) {
                    cVar.Mn().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dmI.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.local_emotion));
            } else if (Mm == EmotionGroupType.PROMOTION) {
                if (cVar.Mo() != null) {
                    cVar.Mo().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Mm == EmotionGroupType.BIG_EMOTION) {
                if (this.dmN) {
                    if (cVar.Mn() != null) {
                        cVar.Mn().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dmI.getChildCount() - 3));
                } else {
                    if (cVar.Mo() != null) {
                        cVar.Mo().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).BN();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Mm == EmotionGroupType.USER_COLLECT) {
                if (cVar.Mo() != null) {
                    cVar.Mo().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dmI.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Mm == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Mo() != null) {
                    cVar.Mo().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dmP && this.aLF == 1) {
                view2.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dmO == null) {
                this.dmO = tbImageView;
                this.dmO.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(linearLayout, e.f.bg_emotion_tab_horizonscrollview, this.aLF);
        }
        return tbImageView;
    }

    public void aux() {
        this.dmM = new ImageView(getContext());
        this.dmM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dmM.setPadding(this.bbe, this.bbd, this.bbe, this.bbd);
        this.dmL = new LinearLayout(getContext());
        this.dmL.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dmM.setLayoutParams(layoutParams);
        al.b(this.dmM, e.f.face_store, this.aLF);
        this.dmL.addView(this.dmM);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, e.d.common_color_10288, this.aLF);
        this.dmL.addView(view);
        this.bbf = new TextView(getContext());
        this.bbf.setGravity(17);
        this.bbf.setTextSize(10.0f);
        this.bbf.setText("N");
        this.bbf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dmI.addView(this.dmL, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds106), -1));
        this.dmI.setNewView(this.bbf);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dmI.setNewViewVisible(true);
        } else {
            this.dmI.setNewViewVisible(false);
        }
        this.dmL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bbf != null) {
                    EmotionTabHorizonScrollView.this.dmI.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Ta != null) {
                    EmotionTabHorizonScrollView.this.Ta.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kV()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), e.j.neterror);
                }
            }
        });
        this.bbg = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bbg.setLayoutParams(layoutParams3);
        this.dmI.addView(this.bbg);
        if (!appResponseToIntentClass) {
            this.dmL.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dmN = z;
        int i2 = i + 1;
        int childCount = this.dmI.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dmJ.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Mm() == EmotionGroupType.BIG_EMOTION || cVar.Mm() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dmI.getChildAt(i2)).getChildAt(0);
                if (!this.dmN) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).BN();
                        }
                    });
                    if (cVar.Mo() != null) {
                        cVar.Mo().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Mn() != null) {
                    cVar.Mn().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dmI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dmI.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dmT;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dmL.setVisibility(8);
        } else {
            this.dmL.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Mm() == EmotionGroupType.BIG_EMOTION || cVar.Mm() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dmI.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aLF == 0) {
                        color = getResources().getColor(e.d.common_color_10287);
                    } else {
                        color = al.getColor(e.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dmI.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dmJ.get(this.mCurrentIndex);
            if (cVar.Mn() != null) {
                cVar.Mn().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(e.d.common_color_10022));
                this.dmO = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dmI.removeAllViews();
        aux();
        eC(this.aLF);
    }

    public void eC(int i) {
        int color;
        this.aLF = i;
        if (this.dmM != null) {
            al.b(this.dmM, e.f.face_store, i);
        }
        if (this.dmL != null) {
            al.d(this.dmL, e.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dmL.getChildCount() > 0) {
                al.e(this.dmL.getChildAt(1), e.d.common_color_10288, i);
            }
        }
        if (this.bbg != null) {
            al.d(this.bbg, e.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bbf != null) {
            al.d(this.bbf, e.f.icon_news_head_prompt_one, i);
            al.b(this.bbf, e.d.cp_cont_i, 1, i);
        }
        int childCount = this.dmI.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dmI.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, e.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dmR != null) {
                        if (i == 0) {
                            color = getResources().getColor(e.d.common_color_10287);
                        } else {
                            color = al.getColor(e.d.common_color_10287);
                        }
                        aVar.dmR.setForegroundColor(color);
                    }
                    if (aVar.dmS != null) {
                        al.e(aVar.dmS, e.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dmO != null) {
            this.dmO.setForegroundColor(al.getColor(e.d.common_color_10022));
            if (this.dmO.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dmO.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dmK = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        private final int azT;

        private b(int i) {
            this.azT = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dmO) {
                ((TbImageView) view).setForegroundColor(al.getColor(e.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dmO != null) {
                    if (!EmotionTabHorizonScrollView.this.dmP) {
                        EmotionTabHorizonScrollView.this.dmO.setForegroundColor(al.getColor(e.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dmO.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(e.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dmO = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.azT);
            EmotionTabHorizonScrollView.this.dmK.fV(this.azT);
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
        TbImageView dmR;
        View dmS;
        com.baidu.tbadk.editortools.emotiontool.c dmT;

        private a() {
        }
    }
}
