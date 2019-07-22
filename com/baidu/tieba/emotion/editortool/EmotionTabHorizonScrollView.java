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
    private int cdL;
    private int cuW;
    private int cuX;
    private TextView cuY;
    private View cuZ;
    private ImageView eUA;
    private boolean eUB;
    private TbImageView eUC;
    private boolean eUD;
    private EmotionLinearLayout eUw;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eUx;
    private EmotionTabWidgetView.a eUy;
    private LinearLayout eUz;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpM = -1;
        this.eUB = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpM = -1;
        this.eUB = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bpM = -1;
        this.eUB = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eUw = new EmotionLinearLayout(getContext());
        this.eUw.setOrientation(0);
        this.eUw.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eUw.setBaselineAligned(false);
        addView(this.eUw);
        this.cuW = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cuX = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bqp = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.eUw.setPadding(0, 0, 0, 0);
        beM();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.eUD = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eUx = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eUH = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eUF = tbImageView;
        if (cVar.aso() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.cuX, this.cuW, this.cuX, this.cuW);
            ImageView imageView = new ImageView(getContext());
            am.c(imageView, (int) R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.g(getContext(), R.dimen.ds12), l.g(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eUG = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.eUw.addView(relativeLayout, this.eUw.getChildCount() - 1, this.bqp);
            if (cVar.asq() != null) {
                cVar.asq().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.eUD && this.cdL == 1) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eUC == null) {
                this.eUC = tbImageView;
                this.eUC.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.g(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.cdL);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.cuX, this.cuW, this.cuX, this.cuW);
            View view2 = new View(getContext());
            aVar.eUG = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.eUw.addView(linearLayout, this.eUw.getChildCount() - 1, this.bqp);
            EmotionGroupType aso = cVar.aso();
            if (aso == EmotionGroupType.LOCAL) {
                if (cVar.asp() != null) {
                    cVar.asp().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eUw.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aso == EmotionGroupType.PROMOTION) {
                if (cVar.asq() != null) {
                    cVar.asq().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aso == EmotionGroupType.BIG_EMOTION) {
                if (this.eUB) {
                    if (cVar.asp() != null) {
                        cVar.asp().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.eUw.getChildCount() - 3));
                } else {
                    if (cVar.asq() != null) {
                        cVar.asq().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).agQ();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aso == EmotionGroupType.USER_COLLECT) {
                if (cVar.asq() != null) {
                    cVar.asq().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eUw.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aso == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.asq() != null) {
                    cVar.asq().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.eUD && this.cdL == 1) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eUC == null) {
                this.eUC = tbImageView;
                this.eUC.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.g(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.cdL);
        }
        return tbImageView;
    }

    public void beM() {
        this.eUA = new ImageView(getContext());
        this.eUA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eUA.setPadding(this.cuX, this.cuW, this.cuX, this.cuW);
        this.eUz = new LinearLayout(getContext());
        this.eUz.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eUA.setLayoutParams(layoutParams);
        am.b(this.eUA, (int) R.drawable.face_store, this.cdL);
        this.eUz.addView(this.eUA);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.h(view, R.color.common_color_10288, this.cdL);
        this.eUz.addView(view);
        this.cuY = new TextView(getContext());
        this.cuY.setGravity(17);
        this.cuY.setTextSize(10.0f);
        this.cuY.setText("N");
        this.cuY.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.eUw.addView(this.eUz, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.eUw.setNewView(this.cuY);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.eUw.setNewViewVisible(true);
        } else {
            this.eUw.setNewViewVisible(false);
        }
        this.eUz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.cuY != null) {
                    EmotionTabHorizonScrollView.this.eUw.setNewViewVisible(false);
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
        this.cuZ = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.cuZ.setLayoutParams(layoutParams3);
        this.eUw.addView(this.cuZ);
        if (!appResponseToIntentClass) {
            this.eUz.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eUB = z;
        int i2 = i + 1;
        int childCount = this.eUw.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.eUx.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aso() == EmotionGroupType.BIG_EMOTION || cVar.aso() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.eUw.getChildAt(i2)).getChildAt(0);
                if (!this.eUB) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).agQ();
                        }
                    });
                    if (cVar.asq() != null) {
                        cVar.asq().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.asp() != null) {
                    cVar.asp().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.eUw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eUw.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eUH;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.eUz.setVisibility(8);
        } else {
            this.eUz.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aso() == EmotionGroupType.BIG_EMOTION || cVar.aso() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bpM) {
            if (this.bpM != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eUw.getChildAt(this.bpM + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.cdL == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bpM = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eUw.getChildAt(this.bpM + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eUx.get(this.bpM);
            if (cVar.asp() != null) {
                cVar.asp().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.eUC = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bpM = -1;
        this.eUw.removeAllViews();
        beM();
        jc(this.cdL);
    }

    public void jc(int i) {
        int color;
        this.cdL = i;
        if (this.eUA != null) {
            am.b(this.eUA, (int) R.drawable.face_store, i);
        }
        if (this.eUz != null) {
            am.g(this.eUz, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.eUz.getChildCount() > 0) {
                am.h(this.eUz.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.cuZ != null) {
            am.g(this.cuZ, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.cuY != null) {
            am.g(this.cuY, R.drawable.icon_news_head_prompt_one, i);
            am.d(this.cuY, R.color.cp_btn_a, 1, i);
        }
        int childCount = this.eUw.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.eUw.getChildAt(i2);
            if (childAt != null) {
                am.g(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eUF != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.eUF.setForegroundColor(color);
                    }
                    if (aVar.eUG != null) {
                        am.h(aVar.eUG, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.eUC != null) {
            this.eUC.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.eUC.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eUC.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.eUy = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bRf;

        private b(int i) {
            this.bRf = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.eUC) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.eUC != null) {
                    if (!EmotionTabHorizonScrollView.this.eUD) {
                        EmotionTabHorizonScrollView.this.eUC.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.eUC.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.eUC = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bRf);
            EmotionTabHorizonScrollView.this.eUy.kA(this.bRf);
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
        TbImageView eUF;
        View eUG;
        com.baidu.tbadk.editortools.emotiontool.c eUH;

        private a() {
        }
    }
}
