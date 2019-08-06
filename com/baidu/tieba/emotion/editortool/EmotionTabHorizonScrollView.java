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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools TU;
    private int bpM;
    private LinearLayout.LayoutParams bqp;
    private int cdS;
    private int cvd;
    private int cve;
    private TextView cvf;
    private View cvg;
    private EmotionLinearLayout eUD;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eUE;
    private EmotionTabWidgetView.a eUF;
    private LinearLayout eUG;
    private ImageView eUH;
    private boolean eUI;
    private TbImageView eUJ;
    private boolean eUK;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpM = -1;
        this.eUI = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpM = -1;
        this.eUI = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bpM = -1;
        this.eUI = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eUD = new EmotionLinearLayout(getContext());
        this.eUD.setOrientation(0);
        this.eUD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eUD.setBaselineAligned(false);
        addView(this.eUD);
        this.cvd = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cve = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bqp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.eUD.setPadding(0, 0, 0, 0);
        beO();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.eUK = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eUE = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eUO = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eUM = tbImageView;
        if (cVar.asq() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.cve, this.cvd, this.cve, this.cvd);
            ImageView imageView = new ImageView(getContext());
            am.c(imageView, (int) R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.g(getContext(), R.dimen.ds12), l.g(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eUN = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.eUD.addView(relativeLayout, this.eUD.getChildCount() - 1, this.bqp);
            if (cVar.ass() != null) {
                cVar.ass().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.eUK && this.cdS == 1) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eUJ == null) {
                this.eUJ = tbImageView;
                this.eUJ.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.g(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.cdS);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.cve, this.cvd, this.cve, this.cvd);
            View view2 = new View(getContext());
            aVar.eUN = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.eUD.addView(linearLayout, this.eUD.getChildCount() - 1, this.bqp);
            EmotionGroupType asq = cVar.asq();
            if (asq == EmotionGroupType.LOCAL) {
                if (cVar.asr() != null) {
                    cVar.asr().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eUD.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (asq == EmotionGroupType.PROMOTION) {
                if (cVar.ass() != null) {
                    cVar.ass().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (asq == EmotionGroupType.BIG_EMOTION) {
                if (this.eUI) {
                    if (cVar.asr() != null) {
                        cVar.asr().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.eUD.getChildCount() - 3));
                } else {
                    if (cVar.ass() != null) {
                        cVar.ass().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).agS();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (asq == EmotionGroupType.USER_COLLECT) {
                if (cVar.ass() != null) {
                    cVar.ass().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eUD.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (asq == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.ass() != null) {
                    cVar.ass().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.eUK && this.cdS == 1) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eUJ == null) {
                this.eUJ = tbImageView;
                this.eUJ.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.g(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.cdS);
        }
        return tbImageView;
    }

    public void beO() {
        this.eUH = new ImageView(getContext());
        this.eUH.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eUH.setPadding(this.cve, this.cvd, this.cve, this.cvd);
        this.eUG = new LinearLayout(getContext());
        this.eUG.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eUH.setLayoutParams(layoutParams);
        am.b(this.eUH, (int) R.drawable.face_store, this.cdS);
        this.eUG.addView(this.eUH);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.h(view, R.color.common_color_10288, this.cdS);
        this.eUG.addView(view);
        this.cvf = new TextView(getContext());
        this.cvf.setGravity(17);
        this.cvf.setTextSize(10.0f);
        this.cvf.setText("N");
        this.cvf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.eUD.addView(this.eUG, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.eUD.setNewView(this.cvf);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.eUD.setNewViewVisible(true);
        } else {
            this.eUD.setNewViewVisible(false);
        }
        this.eUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.cvf != null) {
                    EmotionTabHorizonScrollView.this.eUD.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.TU != null) {
                    EmotionTabHorizonScrollView.this.TU.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kc()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.cvg = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.cvg.setLayoutParams(layoutParams3);
        this.eUD.addView(this.cvg);
        if (!appResponseToIntentClass) {
            this.eUG.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eUI = z;
        int i2 = i + 1;
        int childCount = this.eUD.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.eUE.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.asq() == EmotionGroupType.BIG_EMOTION || cVar.asq() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.eUD.getChildAt(i2)).getChildAt(0);
                if (!this.eUI) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).agS();
                        }
                    });
                    if (cVar.ass() != null) {
                        cVar.ass().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.asr() != null) {
                    cVar.asr().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.eUD.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eUD.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eUO;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.eUG.setVisibility(8);
        } else {
            this.eUG.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.asq() == EmotionGroupType.BIG_EMOTION || cVar.asq() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bpM) {
            if (this.bpM != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eUD.getChildAt(this.bpM + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.cdS == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bpM = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eUD.getChildAt(this.bpM + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(R.id.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eUE.get(this.bpM);
            if (cVar.asr() != null) {
                cVar.asr().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.eUJ = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bpM = -1;
        this.eUD.removeAllViews();
        beO();
        jd(this.cdS);
    }

    public void jd(int i) {
        int color;
        this.cdS = i;
        if (this.eUH != null) {
            am.b(this.eUH, (int) R.drawable.face_store, i);
        }
        if (this.eUG != null) {
            am.g(this.eUG, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.eUG.getChildCount() > 0) {
                am.h(this.eUG.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.cvg != null) {
            am.g(this.cvg, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.cvf != null) {
            am.g(this.cvf, R.drawable.icon_news_head_prompt_one, i);
            am.d(this.cvf, R.color.cp_btn_a, 1, i);
        }
        int childCount = this.eUD.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.eUD.getChildAt(i2);
            if (childAt != null) {
                am.g(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eUM != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.eUM.setForegroundColor(color);
                    }
                    if (aVar.eUN != null) {
                        am.h(aVar.eUN, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.eUJ != null) {
            this.eUJ.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.eUJ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eUJ.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.eUF = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bRl;

        private b(int i) {
            this.bRl = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.eUJ) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.eUJ != null) {
                    if (!EmotionTabHorizonScrollView.this.eUK) {
                        EmotionTabHorizonScrollView.this.eUJ.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.eUJ.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.eUJ = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bRl);
            EmotionTabHorizonScrollView.this.eUF.kB(this.bRl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.f(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.f(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        TbImageView eUM;
        View eUN;
        com.baidu.tbadk.editortools.emotiontool.c eUO;

        private a() {
        }
    }
}
