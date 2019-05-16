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
    private EditorTools TB;
    private int boZ;
    private LinearLayout.LayoutParams bpC;
    private int ccI;
    private int ctG;
    private int ctH;
    private TextView ctI;
    private View ctJ;
    private boolean ePA;
    private TbImageView ePB;
    private boolean ePC;
    private EmotionLinearLayout ePv;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ePw;
    private EmotionTabWidgetView.a ePx;
    private LinearLayout ePy;
    private ImageView ePz;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boZ = -1;
        this.ePA = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boZ = -1;
        this.ePA = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.boZ = -1;
        this.ePA = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ePv = new EmotionLinearLayout(getContext());
        this.ePv.setOrientation(0);
        this.ePv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ePv.setBaselineAligned(false);
        addView(this.ePv);
        this.ctG = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ctH = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bpC = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.ePv.setPadding(0, 0, 0, 0);
        bcH();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ePC = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ePw = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.ePG = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.ePE = tbImageView;
        if (cVar.ari() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.ctH, this.ctG, this.ctH, this.ctG);
            ImageView imageView = new ImageView(getContext());
            al.c(imageView, (int) R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.g(getContext(), R.dimen.ds12), l.g(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.ePF = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.ePv.addView(relativeLayout, this.ePv.getChildCount() - 1, this.bpC);
            if (cVar.ark() != null) {
                cVar.ark().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ePC && this.ccI == 1) {
                view.setBackgroundColor(al.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ePB == null) {
                this.ePB = tbImageView;
                this.ePB.setForegroundColor(al.getColor(R.color.common_color_10022));
            }
            al.g(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ccI);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.ctH, this.ctG, this.ctH, this.ctG);
            View view2 = new View(getContext());
            aVar.ePF = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ePv.addView(linearLayout, this.ePv.getChildCount() - 1, this.bpC);
            EmotionGroupType ari = cVar.ari();
            if (ari == EmotionGroupType.LOCAL) {
                if (cVar.arj() != null) {
                    cVar.arj().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ePv.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (ari == EmotionGroupType.PROMOTION) {
                if (cVar.ark() != null) {
                    cVar.ark().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (ari == EmotionGroupType.BIG_EMOTION) {
                if (this.ePA) {
                    if (cVar.arj() != null) {
                        cVar.arj().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ePv.getChildCount() - 3));
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
                tbImageView.setOnClickListener(new b(this.ePv.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (ari == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.ark() != null) {
                    cVar.ark().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ePC && this.ccI == 1) {
                view2.setBackgroundColor(al.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(al.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ePB == null) {
                this.ePB = tbImageView;
                this.ePB.setForegroundColor(al.getColor(R.color.common_color_10022));
            }
            al.g(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ccI);
        }
        return tbImageView;
    }

    public void bcH() {
        this.ePz = new ImageView(getContext());
        this.ePz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ePz.setPadding(this.ctH, this.ctG, this.ctH, this.ctG);
        this.ePy = new LinearLayout(getContext());
        this.ePy.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ePz.setLayoutParams(layoutParams);
        al.b(this.ePz, (int) R.drawable.face_store, this.ccI);
        this.ePy.addView(this.ePz);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.h(view, R.color.common_color_10288, this.ccI);
        this.ePy.addView(view);
        this.ctI = new TextView(getContext());
        this.ctI.setGravity(17);
        this.ctI.setTextSize(10.0f);
        this.ctI.setText("N");
        this.ctI.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ePv.addView(this.ePy, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.ePv.setNewView(this.ctI);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ePv.setNewViewVisible(true);
        } else {
            this.ePv.setNewViewVisible(false);
        }
        this.ePy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.ctI != null) {
                    EmotionTabHorizonScrollView.this.ePv.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.TB != null) {
                    EmotionTabHorizonScrollView.this.TB.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.jS()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.ctJ = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.ctJ.setLayoutParams(layoutParams3);
        this.ePv.addView(this.ctJ);
        if (!appResponseToIntentClass) {
            this.ePy.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ePA = z;
        int i2 = i + 1;
        int childCount = this.ePv.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ePw.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.ari() == EmotionGroupType.BIG_EMOTION || cVar.ari() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ePv.getChildAt(i2)).getChildAt(0);
                if (!this.ePA) {
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
        int childCount = this.ePv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ePv.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).ePG;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.ePy.setVisibility(8);
        } else {
            this.ePy.setVisibility(0);
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
                LinearLayout linearLayout = (LinearLayout) this.ePv.getChildAt(this.boZ + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ccI == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = al.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.boZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ePv.getChildAt(this.boZ + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ePw.get(this.boZ);
            if (cVar.arj() != null) {
                cVar.arj().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(R.color.common_color_10022));
                this.ePB = tbImageView2;
            }
        }
    }

    public void reset() {
        this.boZ = -1;
        this.ePv.removeAllViews();
        bcH();
        iW(this.ccI);
    }

    public void iW(int i) {
        int color;
        this.ccI = i;
        if (this.ePz != null) {
            al.b(this.ePz, (int) R.drawable.face_store, i);
        }
        if (this.ePy != null) {
            al.g(this.ePy, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.ePy.getChildCount() > 0) {
                al.h(this.ePy.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.ctJ != null) {
            al.g(this.ctJ, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.ctI != null) {
            al.g(this.ctI, R.drawable.icon_news_head_prompt_one, i);
            al.c(this.ctI, R.color.cp_btn_a, 1, i);
        }
        int childCount = this.ePv.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ePv.getChildAt(i2);
            if (childAt != null) {
                al.g(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.ePE != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = al.getColor(R.color.common_color_10287);
                        }
                        aVar.ePE.setForegroundColor(color);
                    }
                    if (aVar.ePF != null) {
                        al.h(aVar.ePF, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ePB != null) {
            this.ePB.setForegroundColor(al.getColor(R.color.common_color_10022));
            if (this.ePB.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ePB.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ePx = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bQe;

        private b(int i) {
            this.bQe = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ePB) {
                ((TbImageView) view).setForegroundColor(al.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ePB != null) {
                    if (!EmotionTabHorizonScrollView.this.ePC) {
                        EmotionTabHorizonScrollView.this.ePB.setForegroundColor(al.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ePB.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ePB = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bQe);
            EmotionTabHorizonScrollView.this.ePx.ku(this.bQe);
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
        TbImageView ePE;
        View ePF;
        com.baidu.tbadk.editortools.emotiontool.c ePG;

        private a() {
        }
    }
}
