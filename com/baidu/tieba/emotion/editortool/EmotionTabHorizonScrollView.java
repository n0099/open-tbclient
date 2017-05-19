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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j Kg;
    private int aBS;
    private LinearLayout.LayoutParams aBU;
    private int aBV;
    private int aBW;
    private TextView aBX;
    private View aBY;
    private int ane;
    private i bFi;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFj;
    private EmotionTabWidgetView.a bFk;
    private LinearLayout bFl;
    private ImageView bFm;
    private boolean bFn;
    private TbImageView bFo;
    private boolean bFp;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBS = -1;
        this.bFn = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBS = -1;
        this.bFn = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aBS = -1;
        this.bFn = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bFi = new i(getContext());
        this.bFi.setOrientation(0);
        this.bFi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bFi.setBaselineAligned(false);
        addView(this.bFi);
        this.aBV = getResources().getDimensionPixelSize(w.f.ds8);
        this.aBW = getResources().getDimensionPixelSize(w.f.ds10);
        this.aBU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds122), -1);
        this.bFi.setPadding(0, 0, 0, 0);
        VC();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bFp = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bFj = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bFt = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bFr = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aBW, this.aBV, this.aBW, this.aBV);
        View view = new View(getContext());
        aVar.bFs = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bFi.addView(linearLayout, this.bFi.getChildCount() - 1, this.aBU);
        EmotionGroupType CG = cVar.CG();
        if (CG == EmotionGroupType.LOCAL) {
            if (cVar.CH() != null) {
                cVar.CH().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bFi.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.local_emotion));
        } else if (CG == EmotionGroupType.PROMOTION) {
            if (cVar.CI() != null) {
                cVar.CI().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(w.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (CG == EmotionGroupType.BIG_EMOTION) {
            if (this.bFn) {
                if (cVar.CH() != null) {
                    cVar.CH().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bFi.getChildCount() - 3, null));
            } else {
                if (cVar.CI() != null) {
                    cVar.CI().e(tbImageView);
                }
                tbImageView.setOnClickListener(new n(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bFp && this.ane == 1) {
            view.setBackgroundColor(aq.getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(aq.getColor(w.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(w.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(w.e.common_color_10287));
        }
        if (this.bFo == null) {
            this.bFo = tbImageView;
            this.bFo.setForegroundColor(aq.getColor(w.e.common_color_10022));
        }
        aq.d(linearLayout, w.g.bg_emotion_tab_horizonscrollview, this.ane);
        return tbImageView;
    }

    public void VC() {
        this.bFm = new ImageView(getContext());
        this.bFm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bFm.setPadding(this.aBW, this.aBV, this.aBW, this.aBV);
        this.bFl = new LinearLayout(getContext());
        this.bFl.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(w.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bFm.setLayoutParams(layoutParams);
        aq.c(this.bFm, w.g.icon_store, this.ane);
        this.bFl.addView(this.bFm);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aq.e(view, w.e.common_color_10288, this.ane);
        this.bFl.addView(view);
        this.aBX = new TextView(getContext());
        this.aBX.setGravity(17);
        this.aBX.setTextSize(10.0f);
        this.aBX.setText("N");
        this.aBX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bFi.addView(this.bFl, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(w.f.ds106), -1));
        this.bFi.setNewView(this.aBX);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bFi.setNewViewVisible(true);
        } else {
            this.bFi.setNewViewVisible(false);
        }
        this.bFl.setOnClickListener(new o(this));
        this.aBY = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aBY.setLayoutParams(layoutParams3);
        this.bFi.addView(this.aBY);
        if (!appResponseToIntentClass) {
            this.bFl.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void l(int i, boolean z) {
        this.bFn = z;
        int i2 = i + 1;
        int childCount = this.bFi.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFj.get(i2 - 1);
        if (i2 < childCount && cVar.CG() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bFi.getChildAt(i2)).getChildAt(0);
            if (!this.bFn) {
                tbImageView.setOnClickListener(new p(this));
                if (cVar.CI() != null) {
                    cVar.CI().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.CH() != null) {
                cVar.CH().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bFi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bFi.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bFt;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bFl.setVisibility(8);
        } else {
            this.bFl.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CG() == EmotionGroupType.BIG_EMOTION || cVar.CG() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aBS) {
            if (this.aBS != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bFi.getChildAt(this.aBS + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ane == 0) {
                        color = getResources().getColor(w.e.common_color_10287);
                    } else {
                        color = aq.getColor(w.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aBS = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bFi.getChildAt(this.aBS + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFj.get(this.aBS);
            if (cVar.CH() != null) {
                cVar.CH().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aq.getColor(w.e.common_color_10022));
                this.bFo = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aBS = -1;
        this.bFi.removeAllViews();
        VC();
        dm(this.ane);
    }

    public void dm(int i) {
        int color;
        this.ane = i;
        if (this.bFm != null) {
            aq.c(this.bFm, w.g.icon_store, i);
        }
        if (this.bFl != null) {
            aq.d(this.bFl, w.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bFl.getChildCount() > 0) {
                aq.e(this.bFl.getChildAt(1), w.e.common_color_10288, i);
            }
        }
        if (this.aBY != null) {
            aq.d(this.aBY, w.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aBX != null) {
            aq.d(this.aBX, w.g.icon_news_head_prompt_one, i);
            aq.b(this.aBX, w.e.cp_cont_i, 1, i);
        }
        int childCount = this.bFi.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bFi.getChildAt(i2);
            if (childAt != null) {
                aq.d(childAt, w.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bFr != null) {
                        if (i == 0) {
                            color = getResources().getColor(w.e.common_color_10287);
                        } else {
                            color = aq.getColor(w.e.common_color_10287);
                        }
                        aVar.bFr.setForegroundColor(color);
                    }
                    if (aVar.bFs != null) {
                        aq.e(aVar.bFs, w.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bFo != null) {
            this.bFo.setForegroundColor(aq.getColor(w.e.common_color_10022));
            if (this.bFo.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bFo.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bFk = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kg = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int ady;

        private b(int i) {
            this.ady = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bFo) {
                ((TbImageView) view).setForegroundColor(aq.getColor(w.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bFo != null) {
                    if (!EmotionTabHorizonScrollView.this.bFp) {
                        EmotionTabHorizonScrollView.this.bFo.setForegroundColor(aq.getColor(w.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bFo.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(w.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bFo = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.ady);
            EmotionTabHorizonScrollView.this.bFk.eM(this.ady);
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
        TbImageView bFr;
        View bFs;
        com.baidu.tbadk.editortools.emotiontool.c bFt;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
