package com.baidu.tbadk.editortools.emotiontool;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j Kz;
    private int apH;
    private com.baidu.tbadk.editortools.emotiontool.b apN;
    private int apO;
    private EmotionTabWidgetView.a apP;
    private int apQ;
    private int apR;
    private LinearLayout apS;
    private ImageView apT;
    private TextView apU;
    private LinearLayout.LayoutParams apV;
    private boolean apW;
    private View apX;
    private TbImageView apY;
    private boolean apZ;
    private int from;
    private ArrayList<v> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apO = -1;
        this.apW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apO = -1;
        this.apW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.apO = -1;
        this.apW = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.apN = new com.baidu.tbadk.editortools.emotiontool.b(getContext());
        this.apN.setOrientation(0);
        this.apN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.apN.setBaselineAligned(false);
        addView(this.apN);
        this.apQ = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.apR = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.apV = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds122), -1);
        this.apN.setPadding(0, 0, 0, 0);
        AO();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.apZ = z;
    }

    public void setDatas(ArrayList<v> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(v vVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        al.c(linearLayout, i.e.bg_emotion_tab_horizonscrollview, this.apH);
        c cVar = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.apZ) {
            tbImageView.setForegroundColor(al.getColor(i.c.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(i.c.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar.aqb = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.apR, this.apQ, this.apR, this.apQ);
        View view = new View(getContext());
        cVar.aqc = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds2);
        if (!this.apZ) {
            view.setBackgroundColor(al.getColor(i.c.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(i.c.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar);
        this.apN.addView(linearLayout, this.apN.getChildCount() - 1, this.apV);
        EmotionGroupType AZ = vVar.AZ();
        if (AZ == EmotionGroupType.LOCAL) {
            if (vVar.Bg() != null) {
                vVar.Bg().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.apN.getChildCount() - 3, null));
        } else if (AZ == EmotionGroupType.PROMOTION) {
            if (vVar.Bh() != null) {
                vVar.Bh().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, vVar.getGroupId(), null));
        } else if (AZ == EmotionGroupType.BIG_EMOTION) {
            if (this.apW) {
                if (vVar.Bg() != null) {
                    vVar.Bg().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.apN.getChildCount() - 3, null));
            } else {
                if (vVar.Bh() != null) {
                    vVar.Bh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new g(this));
            }
        }
        if (this.apY == null) {
            this.apY = tbImageView;
            this.apY.setForegroundColor(al.getColor(i.c.transparent));
        }
        return tbImageView;
    }

    public void AO() {
        this.apT = new ImageView(getContext());
        this.apT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.apT.setPadding(this.apR, this.apQ, this.apR, this.apQ);
        this.apS = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.apT.setLayoutParams(layoutParams);
        al.a(this.apT, i.e.icon_store, this.apH);
        this.apS.addView(this.apT);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.d(view, i.c.emotion_tab_div_line_color, this.apH);
        this.apS.addView(view);
        this.apU = new TextView(getContext());
        this.apU.setGravity(17);
        this.apU.setTextSize(10.0f);
        this.apU.setText("N");
        this.apU.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.apN.addView(this.apS, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1));
        this.apN.setNewView(this.apU);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.apN.setNewViewVisible(true);
        } else {
            this.apN.setNewViewVisible(false);
        }
        this.apS.setOnClickListener(new h(this));
        this.apX = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.apX.setLayoutParams(layoutParams3);
        this.apN.addView(this.apX);
        if (!appResponseToCmd) {
            this.apS.setVisibility(8);
        }
    }

    public void c(v vVar) {
        b(vVar);
    }

    public void f(int i, boolean z) {
        this.apW = z;
        int i2 = i + 1;
        int childCount = this.apN.getChildCount();
        v vVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && vVar.AZ() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.apN.getChildAt(i2)).getChildAt(0);
            if (!this.apW) {
                tbImageView.setOnClickListener(new i(this));
                if (vVar.Bh() != null) {
                    vVar.Bh().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (vVar.Bg() != null) {
                vVar.Bg().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.apO) {
            if (this.apO != -1) {
                LinearLayout linearLayout = (LinearLayout) this.apN.getChildAt(this.apO + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apH == 0) {
                        color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                    } else {
                        color = al.getColor(i.c.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.apO = i;
            LinearLayout linearLayout2 = (LinearLayout) this.apN.getChildAt(this.apO + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(i.f.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            v vVar = this.mDatas.get(this.apO);
            if (vVar.Bg() != null) {
                vVar.Bg().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(i.c.transparent));
                this.apY = tbImageView2;
            }
        }
    }

    public void reset() {
        this.apO = -1;
        this.apN.removeAllViews();
        AO();
        cI(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cI(int i) {
        int color;
        this.apH = i;
        if (this.apT != null) {
            al.a(this.apT, i.e.icon_store, i);
        }
        if (this.apS != null) {
            al.c(this.apS, i.e.bg_emotion_tab_horizonscrollview, i);
            if (this.apS.getChildCount() > 0) {
                al.d(this.apS.getChildAt(1), i.c.emotion_tab_div_line_color, i);
            }
        }
        if (this.apX != null) {
            al.c(this.apX, i.e.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.apU != null) {
            al.c(this.apU, i.e.icon_news_head_prompt_one, i);
            al.a(this.apU, i.c.cp_cont_i, 1, i);
        }
        int childCount = this.apN.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.apN.getChildAt(i2);
            if (childAt != null) {
                al.c(childAt, i.e.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aqb != null) {
                        if (i == 0) {
                            color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                        } else {
                            color = al.getColor(i.c.emotion_tab_widget_foreground_color);
                        }
                        cVar.aqb.setForegroundColor(color);
                    }
                    if (cVar.aqc != null) {
                        al.d(cVar.aqc, i.c.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.apY != null) {
            this.apY.setForegroundColor(al.getColor(i.c.transparent));
            if (this.apY.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.apY.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.apP = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YP;

        private a(int i) {
            this.YP = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.apY) {
                ((TbImageView) view).setForegroundColor(al.getColor(i.c.transparent));
                if (EmotionTabHorizonScrollView.this.apY != null) {
                    if (!EmotionTabHorizonScrollView.this.apZ) {
                        EmotionTabHorizonScrollView.this.apY.setForegroundColor(al.getColor(i.c.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.apY.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(i.c.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.apY = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.YP);
            EmotionTabHorizonScrollView.this.apP.dR(this.YP);
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
        TbImageView aqb;
        View aqc;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
