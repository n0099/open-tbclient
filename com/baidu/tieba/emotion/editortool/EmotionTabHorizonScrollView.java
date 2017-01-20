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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j DX;
    private int ahp;
    private int awg;
    private LinearLayout.LayoutParams awi;
    private int awj;
    private int awk;
    private TextView awl;
    private View awm;
    private h bvL;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bvM;
    private EmotionTabWidgetView.a bvN;
    private LinearLayout bvO;
    private ImageView bvP;
    private boolean bvQ;
    private TbImageView bvR;
    private boolean bvS;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awg = -1;
        this.bvQ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awg = -1;
        this.bvQ = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.awg = -1;
        this.bvQ = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bvL = new h(getContext());
        this.bvL.setOrientation(0);
        this.bvL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bvL.setBaselineAligned(false);
        addView(this.bvL);
        this.awj = getResources().getDimensionPixelSize(r.f.ds8);
        this.awk = getResources().getDimensionPixelSize(r.f.ds10);
        this.awi = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.f.ds122), -1);
        this.bvL.setPadding(0, 0, 0, 0);
        TK();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bvS = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bvM = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bvW = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bvU = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.awk, this.awj, this.awk, this.awj);
        View view = new View(getContext());
        aVar.bvV = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bvL.addView(linearLayout, this.bvL.getChildCount() - 1, this.awi);
        EmotionGroupType CM = cVar.CM();
        if (CM == EmotionGroupType.LOCAL) {
            if (cVar.CN() != null) {
                cVar.CN().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bvL.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.l.local_emotion));
        } else if (CM == EmotionGroupType.PROMOTION) {
            if (cVar.CO() != null) {
                cVar.CO().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(r.l.download_promotion_emotion)) + cVar.getGroupId());
        } else if (CM == EmotionGroupType.BIG_EMOTION) {
            if (this.bvQ) {
                if (cVar.CN() != null) {
                    cVar.CN().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bvL.getChildCount() - 3, null));
            } else {
                if (cVar.CO() != null) {
                    cVar.CO().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bvS) {
            view.setBackgroundColor(ap.getColor(r.e.common_color_10288));
            tbImageView.setForegroundColor(ap.getColor(r.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(r.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(r.e.common_color_10287));
        }
        if (this.bvR == null) {
            this.bvR = tbImageView;
            this.bvR.setForegroundColor(ap.getColor(r.e.common_color_10022));
        }
        ap.d(linearLayout, r.g.bg_emotion_tab_horizonscrollview, this.ahp);
        return tbImageView;
    }

    public void TK() {
        this.bvP = new ImageView(getContext());
        this.bvP.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bvP.setPadding(this.awk, this.awj, this.awk, this.awj);
        this.bvO = new LinearLayout(getContext());
        this.bvO.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bvP.setLayoutParams(layoutParams);
        ap.c(this.bvP, r.g.icon_store, this.ahp);
        this.bvO.addView(this.bvP);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.e(view, r.e.common_color_10288, this.ahp);
        this.bvO.addView(view);
        this.awl = new TextView(getContext());
        this.awl.setGravity(17);
        this.awl.setTextSize(10.0f);
        this.awl.setText("N");
        this.awl.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bvL.addView(this.bvO, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.f.ds106), -1));
        this.bvL.setNewView(this.awl);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bvL.setNewViewVisible(true);
        } else {
            this.bvL.setNewViewVisible(false);
        }
        this.bvO.setOnClickListener(new n(this));
        this.awm = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.awm.setLayoutParams(layoutParams3);
        this.bvL.addView(this.awm);
        if (!appResponseToIntentClass) {
            this.bvO.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void l(int i, boolean z) {
        this.bvQ = z;
        int i2 = i + 1;
        int childCount = this.bvL.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bvM.get(i2 - 1);
        if (i2 < childCount && cVar.CM() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bvL.getChildAt(i2)).getChildAt(0);
            if (!this.bvQ) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.CO() != null) {
                    cVar.CO().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.CN() != null) {
                cVar.CN().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bvL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvL.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bvW;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bvO.setVisibility(8);
        } else {
            this.bvO.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CM() == EmotionGroupType.BIG_EMOTION || cVar.CM() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.awg) {
            if (this.awg != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bvL.getChildAt(this.awg + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ahp == 0) {
                        color = getResources().getColor(r.e.common_color_10287);
                    } else {
                        color = ap.getColor(r.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.awg = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bvL.getChildAt(this.awg + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(r.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bvM.get(this.awg);
            if (cVar.CN() != null) {
                cVar.CN().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(r.e.common_color_10022));
                this.bvR = tbImageView2;
            }
        }
    }

    public void reset() {
        this.awg = -1;
        this.bvL.removeAllViews();
        TK();
        dp(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dp(int i) {
        int color;
        this.ahp = i;
        if (this.bvP != null) {
            ap.c(this.bvP, r.g.icon_store, i);
        }
        if (this.bvO != null) {
            ap.d(this.bvO, r.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bvO.getChildCount() > 0) {
                ap.e(this.bvO.getChildAt(1), r.e.common_color_10288, i);
            }
        }
        if (this.awm != null) {
            ap.d(this.awm, r.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.awl != null) {
            ap.d(this.awl, r.g.icon_news_head_prompt_one, i);
            ap.b(this.awl, r.e.cp_cont_i, 1, i);
        }
        int childCount = this.bvL.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bvL.getChildAt(i2);
            if (childAt != null) {
                ap.d(childAt, r.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bvU != null) {
                        if (i == 0) {
                            color = getResources().getColor(r.e.common_color_10287);
                        } else {
                            color = ap.getColor(r.e.common_color_10287);
                        }
                        aVar.bvU.setForegroundColor(color);
                    }
                    if (aVar.bvV != null) {
                        ap.e(aVar.bvV, r.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bvR != null) {
            this.bvR.setForegroundColor(ap.getColor(r.e.common_color_10022));
            if (this.bvR.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bvR.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bvN = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.DX = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int YC;

        private b(int i) {
            this.YC = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bvR) {
                ((TbImageView) view).setForegroundColor(ap.getColor(r.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bvR != null) {
                    if (!EmotionTabHorizonScrollView.this.bvS) {
                        EmotionTabHorizonScrollView.this.bvR.setForegroundColor(ap.getColor(r.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bvR.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(r.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bvR = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.YC);
            EmotionTabHorizonScrollView.this.bvN.eS(this.YC);
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
        TbImageView bvU;
        View bvV;
        com.baidu.tbadk.editortools.emotiontool.c bvW;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
