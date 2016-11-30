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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l EL;
    private int aiA;
    private int axF;
    private LinearLayout.LayoutParams axH;
    private int axI;
    private int axJ;
    private TextView axK;
    private View axL;
    private h bHV;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bHW;
    private EmotionTabWidgetView.a bHX;
    private LinearLayout bHY;
    private ImageView bHZ;
    private boolean bIa;
    private TbImageView bIb;
    private boolean bIc;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axF = -1;
        this.bIa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axF = -1;
        this.bIa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.axF = -1;
        this.bIa = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bHV = new h(getContext());
        this.bHV.setOrientation(0);
        this.bHV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bHV.setBaselineAligned(false);
        addView(this.bHV);
        this.axI = getResources().getDimensionPixelSize(r.e.ds8);
        this.axJ = getResources().getDimensionPixelSize(r.e.ds10);
        this.axH = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds122), -1);
        this.bHV.setPadding(0, 0, 0, 0);
        Yd();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bIc = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bHW = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bIg = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bIe = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.axJ, this.axI, this.axJ, this.axI);
        View view = new View(getContext());
        aVar.bIf = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bHV.addView(linearLayout, this.bHV.getChildCount() - 1, this.axH);
        EmotionGroupType Di = cVar.Di();
        if (Di == EmotionGroupType.LOCAL) {
            if (cVar.Dj() != null) {
                cVar.Dj().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bHV.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.j.local_emotion));
        } else if (Di == EmotionGroupType.PROMOTION) {
            if (cVar.Dk() != null) {
                cVar.Dk().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(r.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (Di == EmotionGroupType.BIG_EMOTION) {
            if (this.bIa) {
                if (cVar.Dj() != null) {
                    cVar.Dj().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bHV.getChildCount() - 3, null));
            } else {
                if (cVar.Dk() != null) {
                    cVar.Dk().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bIc) {
            view.setBackgroundColor(at.getColor(r.d.common_color_10288));
            tbImageView.setForegroundColor(at.getColor(r.d.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(r.d.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(r.d.common_color_10287));
        }
        if (this.bIb == null) {
            this.bIb = tbImageView;
            this.bIb.setForegroundColor(at.getColor(r.d.common_color_10022));
        }
        at.d(linearLayout, r.f.bg_emotion_tab_horizonscrollview, this.aiA);
        return tbImageView;
    }

    public void Yd() {
        this.bHZ = new ImageView(getContext());
        this.bHZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bHZ.setPadding(this.axJ, this.axI, this.axJ, this.axI);
        this.bHY = new LinearLayout(getContext());
        this.bHY.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bHZ.setLayoutParams(layoutParams);
        at.c(this.bHZ, r.f.icon_store, this.aiA);
        this.bHY.addView(this.bHZ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        at.e(view, r.d.common_color_10288, this.aiA);
        this.bHY.addView(view);
        this.axK = new TextView(getContext());
        this.axK.setGravity(17);
        this.axK.setTextSize(10.0f);
        this.axK.setText("N");
        this.axK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bHV.addView(this.bHY, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds106), -1));
        this.bHV.setNewView(this.axK);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bHV.setNewViewVisible(true);
        } else {
            this.bHV.setNewViewVisible(false);
        }
        this.bHY.setOnClickListener(new n(this));
        this.axL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.axL.setLayoutParams(layoutParams3);
        this.bHV.addView(this.axL);
        if (!appResponseToIntentClass) {
            this.bHY.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void z(int i, boolean z) {
        this.bIa = z;
        int i2 = i + 1;
        int childCount = this.bHV.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bHW.get(i2 - 1);
        if (i2 < childCount && cVar.Di() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bHV.getChildAt(i2)).getChildAt(0);
            if (!this.bIa) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.Dk() != null) {
                    cVar.Dk().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.Dj() != null) {
                cVar.Dj().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bHV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bHV.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bIg;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bHY.setVisibility(8);
        } else {
            this.bHY.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Di() == EmotionGroupType.BIG_EMOTION || cVar.Di() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.axF) {
            if (this.axF != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bHV.getChildAt(this.axF + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aiA == 0) {
                        color = getResources().getColor(r.d.common_color_10287);
                    } else {
                        color = at.getColor(r.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.axF = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bHV.getChildAt(this.axF + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(r.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bHW.get(this.axF);
            if (cVar.Dj() != null) {
                cVar.Dj().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(at.getColor(r.d.common_color_10022));
                this.bIb = tbImageView2;
            }
        }
    }

    public void reset() {
        this.axF = -1;
        this.bHV.removeAllViews();
        Yd();
        dm(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dm(int i) {
        int color;
        this.aiA = i;
        if (this.bHZ != null) {
            at.c(this.bHZ, r.f.icon_store, i);
        }
        if (this.bHY != null) {
            at.d(this.bHY, r.f.bg_emotion_tab_horizonscrollview, i);
            if (this.bHY.getChildCount() > 0) {
                at.e(this.bHY.getChildAt(1), r.d.common_color_10288, i);
            }
        }
        if (this.axL != null) {
            at.d(this.axL, r.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.axK != null) {
            at.d(this.axK, r.f.icon_news_head_prompt_one, i);
            at.b(this.axK, r.d.cp_cont_i, 1, i);
        }
        int childCount = this.bHV.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bHV.getChildAt(i2);
            if (childAt != null) {
                at.d(childAt, r.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bIe != null) {
                        if (i == 0) {
                            color = getResources().getColor(r.d.common_color_10287);
                        } else {
                            color = at.getColor(r.d.common_color_10287);
                        }
                        aVar.bIe.setForegroundColor(color);
                    }
                    if (aVar.bIf != null) {
                        at.e(aVar.bIf, r.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bIb != null) {
            this.bIb.setForegroundColor(at.getColor(r.d.common_color_10022));
            if (this.bIb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bIb.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bHX = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EL = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int ZU;

        private b(int i) {
            this.ZU = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bIb) {
                ((TbImageView) view).setForegroundColor(at.getColor(r.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bIb != null) {
                    if (!EmotionTabHorizonScrollView.this.bIc) {
                        EmotionTabHorizonScrollView.this.bIb.setForegroundColor(at.getColor(r.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bIb.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(r.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bIb = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.ZU);
            EmotionTabHorizonScrollView.this.bHX.eQ(this.ZU);
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
        TbImageView bIe;
        View bIf;
        com.baidu.tbadk.editortools.emotiontool.c bIg;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
