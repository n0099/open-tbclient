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
    private int aLH;
    private int bbg;
    private int bbh;
    private TextView bbi;
    private View bbj;
    private EmotionLinearLayout dpA;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dpB;
    private EmotionTabWidgetView.a dpC;
    private LinearLayout dpD;
    private ImageView dpE;
    private boolean dpF;
    private TbImageView dpG;
    private boolean dpH;
    private int from;
    private int mCurrentIndex;
    private LinearLayout.LayoutParams mParams;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.dpF = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.dpF = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.dpF = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dpA = new EmotionLinearLayout(getContext());
        this.dpA.setOrientation(0);
        this.dpA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dpA.setBaselineAligned(false);
        addView(this.dpA);
        this.bbg = getResources().getDimensionPixelSize(e.C0210e.ds8);
        this.bbh = getResources().getDimensionPixelSize(e.C0210e.ds10);
        this.mParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds122), -1);
        this.dpA.setPadding(0, 0, 0, 0);
        avm();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dpH = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dpB = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dpL = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dpJ = tbImageView;
        if (cVar.Mn() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bbh, this.bbg, this.bbh, this.bbg);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, e.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.h(getContext(), e.C0210e.ds12), l.h(getContext(), e.C0210e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dpK = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dpA.addView(relativeLayout, this.dpA.getChildCount() - 1, this.mParams);
            if (cVar.Mp() != null) {
                cVar.Mp().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dpH && this.aLH == 1) {
                view.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dpG == null) {
                this.dpG = tbImageView;
                this.dpG.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(relativeLayout, e.f.bg_emotion_tab_horizonscrollview, this.aLH);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bbh, this.bbg, this.bbh, this.bbg);
            View view2 = new View(getContext());
            aVar.dpK = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dpA.addView(linearLayout, this.dpA.getChildCount() - 1, this.mParams);
            EmotionGroupType Mn = cVar.Mn();
            if (Mn == EmotionGroupType.LOCAL) {
                if (cVar.Mo() != null) {
                    cVar.Mo().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dpA.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.local_emotion));
            } else if (Mn == EmotionGroupType.PROMOTION) {
                if (cVar.Mp() != null) {
                    cVar.Mp().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (Mn == EmotionGroupType.BIG_EMOTION) {
                if (this.dpF) {
                    if (cVar.Mo() != null) {
                        cVar.Mo().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dpA.getChildCount() - 3));
                } else {
                    if (cVar.Mp() != null) {
                        cVar.Mp().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).BN();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (Mn == EmotionGroupType.USER_COLLECT) {
                if (cVar.Mp() != null) {
                    cVar.Mp().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dpA.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (Mn == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.Mp() != null) {
                    cVar.Mp().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dpH && this.aLH == 1) {
                view2.setBackgroundColor(al.getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(e.d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(e.d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(e.d.common_color_10287));
            }
            if (this.dpG == null) {
                this.dpG = tbImageView;
                this.dpG.setForegroundColor(al.getColor(e.d.common_color_10022));
            }
            al.d(linearLayout, e.f.bg_emotion_tab_horizonscrollview, this.aLH);
        }
        return tbImageView;
    }

    public void avm() {
        this.dpE = new ImageView(getContext());
        this.dpE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dpE.setPadding(this.bbh, this.bbg, this.bbh, this.bbg);
        this.dpD = new LinearLayout(getContext());
        this.dpD.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(e.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dpE.setLayoutParams(layoutParams);
        al.b(this.dpE, e.f.face_store, this.aLH);
        this.dpD.addView(this.dpE);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.e(view, e.d.common_color_10288, this.aLH);
        this.dpD.addView(view);
        this.bbi = new TextView(getContext());
        this.bbi.setGravity(17);
        this.bbi.setTextSize(10.0f);
        this.bbi.setText("N");
        this.bbi.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dpA.addView(this.dpD, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(e.C0210e.ds106), -1));
        this.dpA.setNewView(this.bbi);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dpA.setNewViewVisible(true);
        } else {
            this.dpA.setNewViewVisible(false);
        }
        this.dpD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.bbi != null) {
                    EmotionTabHorizonScrollView.this.dpA.setNewViewVisible(false);
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
        this.bbj = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.bbj.setLayoutParams(layoutParams3);
        this.dpA.addView(this.bbj);
        if (!appResponseToIntentClass) {
            this.dpD.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.dpF = z;
        int i2 = i + 1;
        int childCount = this.dpA.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dpB.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Mn() == EmotionGroupType.BIG_EMOTION || cVar.Mn() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dpA.getChildAt(i2)).getChildAt(0);
                if (!this.dpF) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(e.j.emotion_cant_show)).BN();
                        }
                    });
                    if (cVar.Mp() != null) {
                        cVar.Mp().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Mo() != null) {
                    cVar.Mo().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dpA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dpA.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dpL;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dpD.setVisibility(8);
        } else {
            this.dpD.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Mn() == EmotionGroupType.BIG_EMOTION || cVar.Mn() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dpA.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aLH == 0) {
                        color = getResources().getColor(e.d.common_color_10287);
                    } else {
                        color = al.getColor(e.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dpA.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dpB.get(this.mCurrentIndex);
            if (cVar.Mo() != null) {
                cVar.Mo().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(e.d.common_color_10022));
                this.dpG = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dpA.removeAllViews();
        avm();
        eD(this.aLH);
    }

    public void eD(int i) {
        int color;
        this.aLH = i;
        if (this.dpE != null) {
            al.b(this.dpE, e.f.face_store, i);
        }
        if (this.dpD != null) {
            al.d(this.dpD, e.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dpD.getChildCount() > 0) {
                al.e(this.dpD.getChildAt(1), e.d.common_color_10288, i);
            }
        }
        if (this.bbj != null) {
            al.d(this.bbj, e.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.bbi != null) {
            al.d(this.bbi, e.f.icon_news_head_prompt_one, i);
            al.b(this.bbi, e.d.cp_cont_i, 1, i);
        }
        int childCount = this.dpA.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dpA.getChildAt(i2);
            if (childAt != null) {
                al.d(childAt, e.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dpJ != null) {
                        if (i == 0) {
                            color = getResources().getColor(e.d.common_color_10287);
                        } else {
                            color = al.getColor(e.d.common_color_10287);
                        }
                        aVar.dpJ.setForegroundColor(color);
                    }
                    if (aVar.dpK != null) {
                        al.e(aVar.dpK, e.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dpG != null) {
            this.dpG.setForegroundColor(al.getColor(e.d.common_color_10022));
            if (this.dpG.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dpG.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dpC = aVar;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dpG) {
                ((TbImageView) view).setForegroundColor(al.getColor(e.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dpG != null) {
                    if (!EmotionTabHorizonScrollView.this.dpH) {
                        EmotionTabHorizonScrollView.this.dpG.setForegroundColor(al.getColor(e.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dpG.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(e.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dpG = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.azT);
            EmotionTabHorizonScrollView.this.dpC.fW(this.azT);
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
        TbImageView dpJ;
        View dpK;
        com.baidu.tbadk.editortools.emotiontool.c dpL;

        private a() {
        }
    }
}
