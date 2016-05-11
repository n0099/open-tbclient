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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l BV;
    private h aVI;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVJ;
    private EmotionTabWidgetView.a aVK;
    private LinearLayout aVL;
    private ImageView aVM;
    private boolean aVN;
    private TbImageView aVO;
    private boolean aVP;
    private int aej;
    private LinearLayout.LayoutParams asB;
    private int asC;
    private int asD;
    private TextView asE;
    private View asF;
    private int asz;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.asz = -1;
        this.aVN = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.asz = -1;
        this.aVN = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.asz = -1;
        this.aVN = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aVI = new h(getContext());
        this.aVI.setOrientation(0);
        this.aVI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aVI.setBaselineAligned(false);
        addView(this.aVI);
        this.asC = getResources().getDimensionPixelSize(t.e.face_tab_widget_tb_padding);
        this.asD = getResources().getDimensionPixelSize(t.e.face_tab_widget_lr_padding);
        this.asB = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds122), -1);
        this.aVI.setPadding(0, 0, 0, 0);
        LL();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aVP = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.aVJ = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        at.d(linearLayout, t.f.bg_emotion_tab_horizonscrollview, this.aej);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aVP) {
            tbImageView.setForegroundColor(at.getColor(t.d.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(t.d.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.aVR = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.asD, this.asC, this.asD, this.asC);
        View view = new View(getContext());
        cVar2.aVS = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds2);
        if (!this.aVP) {
            view.setBackgroundColor(at.getColor(t.d.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(t.d.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.aVI.addView(linearLayout, this.aVI.getChildCount() - 1, this.asB);
        EmotionGroupType Bv = cVar.Bv();
        if (Bv == EmotionGroupType.LOCAL) {
            if (cVar.Bw() != null) {
                cVar.Bw().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.aVI.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m11getInst().getResources().getString(t.j.local_emotion));
        } else if (Bv == EmotionGroupType.PROMOTION) {
            if (cVar.Bx() != null) {
                cVar.Bx().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m11getInst().getResources().getString(t.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (Bv == EmotionGroupType.BIG_EMOTION) {
            if (this.aVN) {
                if (cVar.Bw() != null) {
                    cVar.Bw().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.aVI.getChildCount() - 3, null));
            } else {
                if (cVar.Bx() != null) {
                    cVar.Bx().a(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (this.aVO == null) {
            this.aVO = tbImageView;
            this.aVO.setForegroundColor(at.getColor(t.d.transparent));
        }
        return tbImageView;
    }

    public void LL() {
        this.aVM = new ImageView(getContext());
        this.aVM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aVM.setPadding(this.asD, this.asC, this.asD, this.asC);
        this.aVL = new LinearLayout(getContext());
        this.aVL.setContentDescription(TbadkCoreApplication.m11getInst().getResources().getString(t.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aVM.setLayoutParams(layoutParams);
        at.b(this.aVM, t.f.icon_store, this.aej);
        this.aVL.addView(this.aVM);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        at.e(view, t.d.emotion_tab_div_line_color, this.aej);
        this.aVL.addView(view);
        this.asE = new TextView(getContext());
        this.asE.setGravity(17);
        this.asE.setTextSize(10.0f);
        this.asE.setText("N");
        this.asE.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aVI.addView(this.aVL, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.face_tab_widget_width), -1));
        this.aVI.setNewView(this.asE);
        boolean appResponseToCmd = TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m11getInst().isFaceShopNew() && appResponseToCmd) {
            this.aVI.setNewViewVisible(true);
        } else {
            this.aVI.setNewViewVisible(false);
        }
        this.aVL.setOnClickListener(new n(this));
        this.asF = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.asF.setLayoutParams(layoutParams3);
        this.aVI.addView(this.asF);
        if (!appResponseToCmd) {
            this.aVL.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void k(int i, boolean z) {
        this.aVN = z;
        int i2 = i + 1;
        int childCount = this.aVI.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.aVJ.get(i2 - 1);
        if (i2 < childCount && cVar.Bv() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aVI.getChildAt(i2)).getChildAt(0);
            if (!this.aVN) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.Bx() != null) {
                    cVar.Bx().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.Bw() != null) {
                cVar.Bw().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.asz) {
            if (this.asz != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aVI.getChildAt(this.asz + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aej == 0) {
                        color = getResources().getColor(t.d.emotion_tab_widget_foreground_color);
                    } else {
                        color = at.getColor(t.d.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.asz = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aVI.getChildAt(this.asz + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(t.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aVJ.get(this.asz);
            if (cVar.Bw() != null) {
                cVar.Bw().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(at.getColor(t.d.transparent));
                this.aVO = tbImageView2;
            }
        }
    }

    public void reset() {
        this.asz = -1;
        this.aVI.removeAllViews();
        LL();
        cW(TbadkCoreApplication.m11getInst().getSkinType());
    }

    public void cW(int i) {
        int color;
        this.aej = i;
        if (this.aVM != null) {
            at.b(this.aVM, t.f.icon_store, i);
        }
        if (this.aVL != null) {
            at.d(this.aVL, t.f.bg_emotion_tab_horizonscrollview, i);
            if (this.aVL.getChildCount() > 0) {
                at.e(this.aVL.getChildAt(1), t.d.emotion_tab_div_line_color, i);
            }
        }
        if (this.asF != null) {
            at.d(this.asF, t.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.asE != null) {
            at.d(this.asE, t.f.icon_news_head_prompt_one, i);
            at.b(this.asE, t.d.cp_cont_i, 1, i);
        }
        int childCount = this.aVI.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aVI.getChildAt(i2);
            if (childAt != null) {
                at.d(childAt, t.f.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aVR != null) {
                        if (i == 0) {
                            color = getResources().getColor(t.d.emotion_tab_widget_foreground_color);
                        } else {
                            color = at.getColor(t.d.emotion_tab_widget_foreground_color);
                        }
                        cVar.aVR.setForegroundColor(color);
                    }
                    if (cVar.aVS != null) {
                        at.e(cVar.aVS, t.d.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aVO != null) {
            this.aVO.setForegroundColor(at.getColor(t.d.transparent));
            if (this.aVO.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aVO.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aVK = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BV = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int Vw;

        private a(int i) {
            this.Vw = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aVO) {
                ((TbImageView) view).setForegroundColor(at.getColor(t.d.transparent));
                if (EmotionTabHorizonScrollView.this.aVO != null) {
                    if (!EmotionTabHorizonScrollView.this.aVP) {
                        EmotionTabHorizonScrollView.this.aVO.setForegroundColor(at.getColor(t.d.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aVO.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(t.d.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aVO = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.Vw);
            EmotionTabHorizonScrollView.this.aVK.ew(this.Vw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final String mGroupId;

        private b(String str) {
            this.mGroupId = str;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, b bVar) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        TbImageView aVR;
        View aVS;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
