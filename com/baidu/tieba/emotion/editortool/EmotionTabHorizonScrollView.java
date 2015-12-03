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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.k KS;
    private h aOZ;
    private EmotionTabWidgetView.a aPa;
    private LinearLayout aPb;
    private ImageView aPc;
    private boolean aPd;
    private TbImageView aPe;
    private boolean aPf;
    private int afY;
    private TextView atA;
    private View atB;
    private int atv;
    private LinearLayout.LayoutParams atx;
    private int aty;
    private int atz;
    private int from;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atv = -1;
        this.aPd = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atv = -1;
        this.aPd = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.atv = -1;
        this.aPd = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aOZ = new h(getContext());
        this.aOZ.setOrientation(0);
        this.aOZ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aOZ.setBaselineAligned(false);
        addView(this.aOZ);
        this.aty = getResources().getDimensionPixelSize(n.d.face_tab_widget_tb_padding);
        this.atz = getResources().getDimensionPixelSize(n.d.face_tab_widget_lr_padding);
        this.atx = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.d.ds122), -1);
        this.aOZ.setPadding(0, 0, 0, 0);
        Jj();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aPf = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        as.c(linearLayout, n.e.bg_emotion_tab_horizonscrollview, this.afY);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aPf) {
            tbImageView.setForegroundColor(as.getColor(n.c.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(n.c.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.aPh = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.atz, this.aty, this.atz, this.aty);
        View view = new View(getContext());
        cVar2.aPi = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.ds2);
        if (!this.aPf) {
            view.setBackgroundColor(as.getColor(n.c.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(n.c.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.aOZ.addView(linearLayout, this.aOZ.getChildCount() - 1, this.atx);
        EmotionGroupType BN = cVar.BN();
        if (BN == EmotionGroupType.LOCAL) {
            if (cVar.BO() != null) {
                cVar.BO().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.aOZ.getChildCount() - 3, null));
        } else if (BN == EmotionGroupType.PROMOTION) {
            if (cVar.BP() != null) {
                cVar.BP().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
        } else if (BN == EmotionGroupType.BIG_EMOTION) {
            if (this.aPd) {
                if (cVar.BO() != null) {
                    cVar.BO().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.aOZ.getChildCount() - 3, null));
            } else {
                if (cVar.BP() != null) {
                    cVar.BP().a(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
        }
        if (this.aPe == null) {
            this.aPe = tbImageView;
            this.aPe.setForegroundColor(as.getColor(n.c.transparent));
        }
        return tbImageView;
    }

    public void Jj() {
        this.aPc = new ImageView(getContext());
        this.aPc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aPc.setPadding(this.atz, this.aty, this.atz, this.aty);
        this.aPb = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aPc.setLayoutParams(layoutParams);
        as.b(this.aPc, n.e.icon_store, this.afY);
        this.aPb.addView(this.aPc);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.d.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        as.d(view, n.c.emotion_tab_div_line_color, this.afY);
        this.aPb.addView(view);
        this.atA = new TextView(getContext());
        this.atA.setGravity(17);
        this.atA.setTextSize(10.0f);
        this.atA.setText("N");
        this.atA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aOZ.addView(this.aPb, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(n.d.face_tab_widget_width), -1));
        this.aOZ.setNewView(this.atA);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aOZ.setNewViewVisible(true);
        } else {
            this.aOZ.setNewViewVisible(false);
        }
        this.aPb.setOnClickListener(new n(this));
        this.atB = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.atB.setLayoutParams(layoutParams3);
        this.aOZ.addView(this.atB);
        if (!appResponseToCmd) {
            this.aPb.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void h(int i, boolean z) {
        this.aPd = z;
        int i2 = i + 1;
        int childCount = this.aOZ.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && cVar.BN() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aOZ.getChildAt(i2)).getChildAt(0);
            if (!this.aPd) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.BP() != null) {
                    cVar.BP().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.BO() != null) {
                cVar.BO().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.atv) {
            if (this.atv != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aOZ.getChildAt(this.atv + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.afY == 0) {
                        color = getResources().getColor(n.c.emotion_tab_widget_foreground_color);
                    } else {
                        color = as.getColor(n.c.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.atv = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aOZ.getChildAt(this.atv + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(n.f.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.mDatas.get(this.atv);
            if (cVar.BO() != null) {
                cVar.BO().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(as.getColor(n.c.transparent));
                this.aPe = tbImageView2;
            }
        }
    }

    public void reset() {
        this.atv = -1;
        this.aOZ.removeAllViews();
        Jj();
        cX(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cX(int i) {
        int color;
        this.afY = i;
        if (this.aPc != null) {
            as.b(this.aPc, n.e.icon_store, i);
        }
        if (this.aPb != null) {
            as.c(this.aPb, n.e.bg_emotion_tab_horizonscrollview, i);
            if (this.aPb.getChildCount() > 0) {
                as.d(this.aPb.getChildAt(1), n.c.emotion_tab_div_line_color, i);
            }
        }
        if (this.atB != null) {
            as.c(this.atB, n.e.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.atA != null) {
            as.c(this.atA, n.e.icon_news_head_prompt_one, i);
            as.a(this.atA, n.c.cp_cont_i, 1, i);
        }
        int childCount = this.aOZ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aOZ.getChildAt(i2);
            if (childAt != null) {
                as.c(childAt, n.e.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aPh != null) {
                        if (i == 0) {
                            color = getResources().getColor(n.c.emotion_tab_widget_foreground_color);
                        } else {
                            color = as.getColor(n.c.emotion_tab_widget_foreground_color);
                        }
                        cVar.aPh.setForegroundColor(color);
                    }
                    if (cVar.aPi != null) {
                        as.d(cVar.aPi, n.c.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aPe != null) {
            this.aPe.setForegroundColor(as.getColor(n.c.transparent));
            if (this.aPe.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aPe.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aPa = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int ZJ;

        private a(int i) {
            this.ZJ = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aPe) {
                ((TbImageView) view).setForegroundColor(as.getColor(n.c.transparent));
                if (EmotionTabHorizonScrollView.this.aPe != null) {
                    if (!EmotionTabHorizonScrollView.this.aPf) {
                        EmotionTabHorizonScrollView.this.aPe.setForegroundColor(as.getColor(n.c.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aPe.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(n.c.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aPe = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.ZJ);
            EmotionTabHorizonScrollView.this.aPa.ew(this.ZJ);
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
        TbImageView aPh;
        View aPi;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
