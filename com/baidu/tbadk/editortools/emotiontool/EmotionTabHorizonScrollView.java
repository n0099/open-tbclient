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
    private int arA;
    private int arB;
    private LinearLayout arC;
    private ImageView arD;
    private TextView arE;
    private LinearLayout.LayoutParams arF;
    private boolean arG;
    private View arH;
    private TbImageView arI;
    private boolean arJ;
    private int arr;
    private com.baidu.tbadk.editortools.emotiontool.b arx;
    private int ary;
    private EmotionTabWidgetView.a arz;
    private int from;
    private ArrayList<v> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ary = -1;
        this.arG = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ary = -1;
        this.arG = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.ary = -1;
        this.arG = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.arx = new com.baidu.tbadk.editortools.emotiontool.b(getContext());
        this.arx.setOrientation(0);
        this.arx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.arx.setBaselineAligned(false);
        addView(this.arx);
        this.arA = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.arB = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.arF = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds122), -1);
        this.arx.setPadding(0, 0, 0, 0);
        Bb();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.arJ = z;
    }

    public void setDatas(ArrayList<v> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(v vVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        al.c(linearLayout, i.e.bg_emotion_tab_horizonscrollview, this.arr);
        c cVar = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.arJ) {
            tbImageView.setForegroundColor(al.getColor(i.c.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(i.c.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar.arL = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.arB, this.arA, this.arB, this.arA);
        View view = new View(getContext());
        cVar.arM = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds2);
        if (!this.arJ) {
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
        this.arx.addView(linearLayout, this.arx.getChildCount() - 1, this.arF);
        EmotionGroupType Bm = vVar.Bm();
        if (Bm == EmotionGroupType.LOCAL) {
            if (vVar.Bt() != null) {
                vVar.Bt().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.arx.getChildCount() - 3, null));
        } else if (Bm == EmotionGroupType.PROMOTION) {
            if (vVar.Bu() != null) {
                vVar.Bu().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, vVar.getGroupId(), null));
        } else if (Bm == EmotionGroupType.BIG_EMOTION) {
            if (this.arG) {
                if (vVar.Bt() != null) {
                    vVar.Bt().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.arx.getChildCount() - 3, null));
            } else {
                if (vVar.Bu() != null) {
                    vVar.Bu().a(tbImageView);
                }
                tbImageView.setOnClickListener(new g(this));
            }
        }
        if (this.arI == null) {
            this.arI = tbImageView;
            this.arI.setForegroundColor(al.getColor(i.c.transparent));
        }
        return tbImageView;
    }

    public void Bb() {
        this.arD = new ImageView(getContext());
        this.arD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.arD.setPadding(this.arB, this.arA, this.arB, this.arA);
        this.arC = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.arD.setLayoutParams(layoutParams);
        al.a(this.arD, i.e.icon_store, this.arr);
        this.arC.addView(this.arD);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        al.d(view, i.c.emotion_tab_div_line_color, this.arr);
        this.arC.addView(view);
        this.arE = new TextView(getContext());
        this.arE.setGravity(17);
        this.arE.setTextSize(10.0f);
        this.arE.setText("N");
        this.arE.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.arx.addView(this.arC, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1));
        this.arx.setNewView(this.arE);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.arx.setNewViewVisible(true);
        } else {
            this.arx.setNewViewVisible(false);
        }
        this.arC.setOnClickListener(new h(this));
        this.arH = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.arH.setLayoutParams(layoutParams3);
        this.arx.addView(this.arH);
        if (!appResponseToCmd) {
            this.arC.setVisibility(8);
        }
    }

    public void c(v vVar) {
        b(vVar);
    }

    public void g(int i, boolean z) {
        this.arG = z;
        int i2 = i + 1;
        int childCount = this.arx.getChildCount();
        v vVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && vVar.Bm() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.arx.getChildAt(i2)).getChildAt(0);
            if (!this.arG) {
                tbImageView.setOnClickListener(new i(this));
                if (vVar.Bu() != null) {
                    vVar.Bu().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (vVar.Bt() != null) {
                vVar.Bt().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.ary) {
            if (this.ary != -1) {
                LinearLayout linearLayout = (LinearLayout) this.arx.getChildAt(this.ary + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.arr == 0) {
                        color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                    } else {
                        color = al.getColor(i.c.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.ary = i;
            LinearLayout linearLayout2 = (LinearLayout) this.arx.getChildAt(this.ary + 1);
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
            v vVar = this.mDatas.get(this.ary);
            if (vVar.Bt() != null) {
                vVar.Bt().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(al.getColor(i.c.transparent));
                this.arI = tbImageView2;
            }
        }
    }

    public void reset() {
        this.ary = -1;
        this.arx.removeAllViews();
        Bb();
        cO(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cO(int i) {
        int color;
        this.arr = i;
        if (this.arD != null) {
            al.a(this.arD, i.e.icon_store, i);
        }
        if (this.arC != null) {
            al.c(this.arC, i.e.bg_emotion_tab_horizonscrollview, i);
            if (this.arC.getChildCount() > 0) {
                al.d(this.arC.getChildAt(1), i.c.emotion_tab_div_line_color, i);
            }
        }
        if (this.arH != null) {
            al.c(this.arH, i.e.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.arE != null) {
            al.c(this.arE, i.e.icon_news_head_prompt_one, i);
            al.a(this.arE, i.c.cp_cont_i, 1, i);
        }
        int childCount = this.arx.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.arx.getChildAt(i2);
            if (childAt != null) {
                al.c(childAt, i.e.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.arL != null) {
                        if (i == 0) {
                            color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                        } else {
                            color = al.getColor(i.c.emotion_tab_widget_foreground_color);
                        }
                        cVar.arL.setForegroundColor(color);
                    }
                    if (cVar.arM != null) {
                        al.d(cVar.arM, i.c.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.arI != null) {
            this.arI.setForegroundColor(al.getColor(i.c.transparent));
            if (this.arI.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.arI.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.arz = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YY;

        private a(int i) {
            this.YY = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.arI) {
                ((TbImageView) view).setForegroundColor(al.getColor(i.c.transparent));
                if (EmotionTabHorizonScrollView.this.arI != null) {
                    if (!EmotionTabHorizonScrollView.this.arJ) {
                        EmotionTabHorizonScrollView.this.arI.setForegroundColor(al.getColor(i.c.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.arI.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(i.c.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.arI = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.YY);
            EmotionTabHorizonScrollView.this.arz.dZ(this.YY);
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
        TbImageView arL;
        View arM;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
