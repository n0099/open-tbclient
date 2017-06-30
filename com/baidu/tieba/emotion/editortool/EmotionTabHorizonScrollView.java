package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j JT;
    private int aCI;
    private LinearLayout.LayoutParams aCK;
    private int aCL;
    private int aCM;
    private TextView aCN;
    private View aCO;
    private int aoa;
    private boolean bRA;
    private TbImageView bRB;
    private boolean bRC;
    private i bRv;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bRw;
    private EmotionTabWidgetView.a bRx;
    private LinearLayout bRy;
    private ImageView bRz;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCI = -1;
        this.bRA = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCI = -1;
        this.bRA = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aCI = -1;
        this.bRA = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bRv = new i(getContext());
        this.bRv.setOrientation(0);
        this.bRv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bRv.setBaselineAligned(false);
        addView(this.bRv);
        this.aCL = getResources().getDimensionPixelSize(w.f.ds8);
        this.aCM = getResources().getDimensionPixelSize(w.f.ds10);
        this.aCK = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds122), -1);
        this.bRv.setPadding(0, 0, 0, 0);
        aab();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bRC = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bRw = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bRG = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bRE = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aCM, this.aCL, this.aCM, this.aCL);
        View view = new View(getContext());
        aVar.bRF = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bRv.addView(linearLayout, this.bRv.getChildCount() - 1, this.aCK);
        EmotionGroupType CV = cVar.CV();
        if (CV == EmotionGroupType.LOCAL) {
            if (cVar.CW() != null) {
                cVar.CW().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bRv.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.local_emotion));
        } else if (CV == EmotionGroupType.PROMOTION) {
            if (cVar.CX() != null) {
                cVar.CX().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(w.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (CV == EmotionGroupType.BIG_EMOTION) {
            if (this.bRA) {
                if (cVar.CW() != null) {
                    cVar.CW().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bRv.getChildCount() - 3, null));
            } else {
                if (cVar.CX() != null) {
                    cVar.CX().e(tbImageView);
                }
                tbImageView.setOnClickListener(new o(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        } else if (CV == EmotionGroupType.USER_COLLECT) {
            if (cVar.CX() != null) {
                cVar.CX().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bRv.getChildCount() - 3, null));
            tbImageView.setContentDescription("");
        }
        if (!this.bRC && this.aoa == 1) {
            view.setBackgroundColor(as.getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(as.getColor(w.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(w.e.common_color_10287));
        }
        if (this.bRB == null) {
            this.bRB = tbImageView;
            this.bRB.setForegroundColor(as.getColor(w.e.common_color_10022));
        }
        as.d(linearLayout, w.g.bg_emotion_tab_horizonscrollview, this.aoa);
        return tbImageView;
    }

    public void aab() {
        this.bRz = new ImageView(getContext());
        this.bRz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bRz.setPadding(this.aCM, this.aCL, this.aCM, this.aCL);
        this.bRy = new LinearLayout(getContext());
        this.bRy.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bRz.setLayoutParams(layoutParams);
        as.c(this.bRz, w.g.face_store, this.aoa);
        this.bRy.addView(this.bRz);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        as.e(view, w.e.common_color_10288, this.aoa);
        this.bRy.addView(view);
        this.aCN = new TextView(getContext());
        this.aCN.setGravity(17);
        this.aCN.setTextSize(10.0f);
        this.aCN.setText("N");
        this.aCN.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bRv.addView(this.bRy, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1));
        this.bRv.setNewView(this.aCN);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bRv.setNewViewVisible(true);
        } else {
            this.bRv.setNewViewVisible(false);
        }
        this.bRy.setOnClickListener(new p(this));
        this.aCO = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aCO.setLayoutParams(layoutParams3);
        this.bRv.addView(this.aCO);
        if (!appResponseToIntentClass) {
            this.bRy.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void m(int i, boolean z) {
        this.bRA = z;
        int i2 = i + 1;
        int childCount = this.bRv.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bRw.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.CV() == EmotionGroupType.BIG_EMOTION || cVar.CV() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bRv.getChildAt(i2)).getChildAt(0);
                if (!this.bRA) {
                    tbImageView.setOnClickListener(new q(this));
                    if (cVar.CX() != null) {
                        cVar.CX().e(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(this, i2 - 1, null));
                if (cVar.CW() != null) {
                    cVar.CW().e(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bRv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bRv.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bRG;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bRy.setVisibility(8);
        } else {
            this.bRy.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CV() == EmotionGroupType.BIG_EMOTION || cVar.CV() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aCI) {
            if (this.aCI != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bRv.getChildAt(this.aCI + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aoa == 0) {
                        color = getResources().getColor(w.e.common_color_10287);
                    } else {
                        color = as.getColor(w.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aCI = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bRv.getChildAt(this.aCI + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(w.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bRw.get(this.aCI);
            if (cVar.CW() != null) {
                cVar.CW().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(as.getColor(w.e.common_color_10022));
                this.bRB = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aCI = -1;
        this.bRv.removeAllViews();
        aab();
        dp(this.aoa);
    }

    public void dp(int i) {
        int color;
        this.aoa = i;
        if (this.bRz != null) {
            as.c(this.bRz, w.g.face_store, i);
        }
        if (this.bRy != null) {
            as.d(this.bRy, w.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bRy.getChildCount() > 0) {
                as.e(this.bRy.getChildAt(1), w.e.common_color_10288, i);
            }
        }
        if (this.aCO != null) {
            as.d(this.aCO, w.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aCN != null) {
            as.d(this.aCN, w.g.icon_news_head_prompt_one, i);
            as.b(this.aCN, w.e.cp_cont_i, 1, i);
        }
        int childCount = this.bRv.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bRv.getChildAt(i2);
            if (childAt != null) {
                as.d(childAt, w.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bRE != null) {
                        if (i == 0) {
                            color = getResources().getColor(w.e.common_color_10287);
                        } else {
                            color = as.getColor(w.e.common_color_10287);
                        }
                        aVar.bRE.setForegroundColor(color);
                    }
                    if (aVar.bRF != null) {
                        as.e(aVar.bRF, w.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bRB != null) {
            this.bRB.setForegroundColor(as.getColor(w.e.common_color_10022));
            if (this.bRB.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bRB.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bRx = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.JT = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int adZ;

        private b(int i) {
            this.adZ = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bRB) {
                ((TbImageView) view).setForegroundColor(as.getColor(w.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bRB != null) {
                    if (!EmotionTabHorizonScrollView.this.bRC) {
                        EmotionTabHorizonScrollView.this.bRB.setForegroundColor(as.getColor(w.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bRB.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(w.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bRB = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.adZ);
            EmotionTabHorizonScrollView.this.bRx.eP(this.adZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        /* synthetic */ c(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, c cVar) {
            this(str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            switch (EmotionTabHorizonScrollView.this.from) {
                case 1:
                    str = "faceshop_from_write_promotion";
                    break;
                case 2:
                    str = "faceshop_from_pchat_promotion";
                    break;
                case 3:
                    str = "faceshop_from_gchat_promotion";
                    break;
                default:
                    str = "";
                    break;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView bRE;
        View bRF;
        com.baidu.tbadk.editortools.emotiontool.c bRG;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
