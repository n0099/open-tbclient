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
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools TA;
    private int boZ;
    private LinearLayout.LayoutParams bpC;
    private int ccJ;
    private int ctH;
    private int ctI;
    private TextView ctJ;
    private View ctK;
    private ImageView ePA;
    private boolean ePB;
    private TbImageView ePC;
    private boolean ePD;
    private EmotionLinearLayout ePw;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ePx;
    private EmotionTabWidgetView.a ePy;
    private LinearLayout ePz;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boZ = -1;
        this.ePB = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boZ = -1;
        this.ePB = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.boZ = -1;
        this.ePB = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ePw = new EmotionLinearLayout(getContext());
        this.ePw.setOrientation(0);
        this.ePw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ePw.setBaselineAligned(false);
        addView(this.ePw);
        this.ctH = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ctI = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bpC = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.ePw.setPadding(0, 0, 0, 0);
        bcK();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ePD = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ePx = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.ePH = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.ePF = tbImageView;
        if (cVar.ari() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.ctI, this.ctH, this.ctI, this.ctH);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, (int) R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.g(getContext(), R.dimen.ds12), l.g(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.ePG = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.ePw.addView(relativeLayout, this.ePw.getChildCount() - 1, this.bpC);
            if (cVar.ark() != null) {
                cVar.ark().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ePD && this.ccJ == 1) {
                view.setBackgroundColor(al.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ePC == null) {
                this.ePC = tbImageView;
                this.ePC.setForegroundColor(al.getColor(R.color.common_color_10022));
            }
            al.g(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ccJ);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.ctI, this.ctH, this.ctI, this.ctH);
            View view2 = new View(getContext());
            aVar.ePG = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ePw.addView(linearLayout, this.ePw.getChildCount() - 1, this.bpC);
            EmotionGroupType ari = cVar.ari();
            if (ari == EmotionGroupType.LOCAL) {
                if (cVar.arj() != null) {
                    cVar.arj().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ePw.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (ari == EmotionGroupType.PROMOTION) {
                if (cVar.ark() != null) {
                    cVar.ark().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (ari == EmotionGroupType.BIG_EMOTION) {
                if (this.ePB) {
                    if (cVar.arj() != null) {
                        cVar.arj().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ePw.getChildCount() - 3));
                } else {
                    if (cVar.ark() != null) {
                        cVar.ark().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).afO();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (ari == EmotionGroupType.USER_COLLECT) {
                if (cVar.ark() != null) {
                    cVar.ark().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ePw.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (ari == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.ark() != null) {
                    cVar.ark().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ePD && this.ccJ == 1) {
                view2.setBackgroundColor(al.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ePC == null) {
                this.ePC = tbImageView;
                this.ePC.setForegroundColor(al.getColor(R.color.common_color_10022));
            }
            al.g(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ccJ);
        }
        return tbImageView;
    }

    public void bcK() {
        this.ePA = new ImageView(getContext());
        this.ePA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ePA.setPadding(this.ctI, this.ctH, this.ctI, this.ctH);
        this.ePz = new LinearLayout(getContext());
        this.ePz.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ePA.setLayoutParams(layoutParams);
        al.b(this.ePA, (int) R.drawable.face_store, this.ccJ);
        this.ePz.addView(this.ePA);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.h(view, R.color.common_color_10288, this.ccJ);
        this.ePz.addView(view);
        this.ctJ = new TextView(getContext());
        this.ctJ.setGravity(17);
        this.ctJ.setTextSize(10.0f);
        this.ctJ.setText("N");
        this.ctJ.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ePw.addView(this.ePz, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.ePw.setNewView(this.ctJ);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ePw.setNewViewVisible(true);
        } else {
            this.ePw.setNewViewVisible(false);
        }
        this.ePz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.ctJ != null) {
                    EmotionTabHorizonScrollView.this.ePw.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.TA != null) {
                    EmotionTabHorizonScrollView.this.TA.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.jS()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.ctK = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.ctK.setLayoutParams(layoutParams3);
        this.ePw.addView(this.ctK);
        if (!appResponseToIntentClass) {
            this.ePz.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ePB = z;
        int i2 = i + 1;
        int childCount = this.ePw.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ePx.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.ari() == EmotionGroupType.BIG_EMOTION || cVar.ari() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ePw.getChildAt(i2)).getChildAt(0);
                if (!this.ePB) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).afO();
                        }
                    });
                    if (cVar.ark() != null) {
                        cVar.ark().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.arj() != null) {
                    cVar.arj().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.ePw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ePw.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).ePH;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.ePz.setVisibility(8);
        } else {
            this.ePz.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.ari() == EmotionGroupType.BIG_EMOTION || cVar.ari() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.boZ) {
            if (this.boZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ePw.getChildAt(this.boZ + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ccJ == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = al.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.boZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ePw.getChildAt(this.boZ + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ePx.get(this.boZ);
            if (cVar.arj() != null) {
                cVar.arj().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(R.color.common_color_10022));
                this.ePC = tbImageView2;
            }
        }
    }

    public void reset() {
        this.boZ = -1;
        this.ePw.removeAllViews();
        bcK();
        iW(this.ccJ);
    }

    public void iW(int i) {
        int color;
        this.ccJ = i;
        if (this.ePA != null) {
            al.b(this.ePA, (int) R.drawable.face_store, i);
        }
        if (this.ePz != null) {
            al.g(this.ePz, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.ePz.getChildCount() > 0) {
                al.h(this.ePz.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.ctK != null) {
            al.g(this.ctK, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.ctJ != null) {
            al.g(this.ctJ, R.drawable.icon_news_head_prompt_one, i);
            al.c(this.ctJ, R.color.cp_btn_a, 1, i);
        }
        int childCount = this.ePw.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ePw.getChildAt(i2);
            if (childAt != null) {
                al.g(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.ePF != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = al.getColor(R.color.common_color_10287);
                        }
                        aVar.ePF.setForegroundColor(color);
                    }
                    if (aVar.ePG != null) {
                        al.h(aVar.ePG, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ePC != null) {
            this.ePC.setForegroundColor(al.getColor(R.color.common_color_10022));
            if (this.ePC.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ePC.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ePy = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bQf;

        private b(int i) {
            this.bQf = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ePC) {
                ((TbImageView) view).setForegroundColor(al.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ePC != null) {
                    if (!EmotionTabHorizonScrollView.this.ePD) {
                        EmotionTabHorizonScrollView.this.ePC.setForegroundColor(al.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ePC.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ePC = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bQf);
            EmotionTabHorizonScrollView.this.ePy.ku(this.bQf);
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
        TbImageView ePF;
        View ePG;
        com.baidu.tbadk.editortools.emotiontool.c ePH;

        private a() {
        }
    }
}
