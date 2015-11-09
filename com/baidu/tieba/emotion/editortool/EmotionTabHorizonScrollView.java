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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j KB;
    private EmotionTabWidgetView.a aKA;
    private LinearLayout aKB;
    private ImageView aKC;
    private boolean aKD;
    private TbImageView aKE;
    private boolean aKF;
    private g aKz;
    private View arA;
    private int arf;
    private int aru;
    private LinearLayout.LayoutParams arw;
    private int arx;
    private int ary;
    private TextView arz;
    private int from;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aru = -1;
        this.aKD = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aru = -1;
        this.aKD = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aru = -1;
        this.aKD = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.aKz = new g(getContext());
        this.aKz.setOrientation(0);
        this.aKz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aKz.setBaselineAligned(false);
        addView(this.aKz);
        this.arx = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.ary = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.arw = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds122), -1);
        this.aKz.setPadding(0, 0, 0, 0);
        HQ();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aKF = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        an.c(linearLayout, i.e.bg_emotion_tab_horizonscrollview, this.arf);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aKF) {
            tbImageView.setForegroundColor(an.getColor(i.c.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(i.c.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.aKH = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.ary, this.arx, this.ary, this.arx);
        View view = new View(getContext());
        cVar2.aKI = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds2);
        if (!this.aKF) {
            view.setBackgroundColor(an.getColor(i.c.emotion_tab_div_line_color));
        } else {
            view.setBackgroundColor(getResources().getColor(i.c.emotion_tab_div_line_color));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.aKz.addView(linearLayout, this.aKz.getChildCount() - 1, this.arw);
        EmotionGroupType AP = cVar.AP();
        if (AP == EmotionGroupType.LOCAL) {
            if (cVar.AQ() != null) {
                cVar.AQ().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.aKz.getChildCount() - 3, null));
        } else if (AP == EmotionGroupType.PROMOTION) {
            if (cVar.AR() != null) {
                cVar.AR().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
        } else if (AP == EmotionGroupType.BIG_EMOTION) {
            if (this.aKD) {
                if (cVar.AQ() != null) {
                    cVar.AQ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.aKz.getChildCount() - 3, null));
            } else {
                if (cVar.AR() != null) {
                    cVar.AR().a(tbImageView);
                }
                tbImageView.setOnClickListener(new l(this));
            }
        }
        if (this.aKE == null) {
            this.aKE = tbImageView;
            this.aKE.setForegroundColor(an.getColor(i.c.transparent));
        }
        return tbImageView;
    }

    public void HQ() {
        this.aKC = new ImageView(getContext());
        this.aKC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aKC.setPadding(this.ary, this.arx, this.ary, this.arx);
        this.aKB = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aKC.setLayoutParams(layoutParams);
        an.b(this.aKC, i.e.icon_store, this.arf);
        this.aKB.addView(this.aKC);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        an.d(view, i.c.emotion_tab_div_line_color, this.arf);
        this.aKB.addView(view);
        this.arz = new TextView(getContext());
        this.arz.setGravity(17);
        this.arz.setTextSize(10.0f);
        this.arz.setText("N");
        this.arz.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.aKz.addView(this.aKB, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1));
        this.aKz.setNewView(this.arz);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.aKz.setNewViewVisible(true);
        } else {
            this.aKz.setNewViewVisible(false);
        }
        this.aKB.setOnClickListener(new m(this));
        this.arA = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.arA.setLayoutParams(layoutParams3);
        this.aKz.addView(this.arA);
        if (!appResponseToCmd) {
            this.aKB.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void h(int i, boolean z) {
        this.aKD = z;
        int i2 = i + 1;
        int childCount = this.aKz.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && cVar.AP() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.aKz.getChildAt(i2)).getChildAt(0);
            if (!this.aKD) {
                tbImageView.setOnClickListener(new n(this));
                if (cVar.AR() != null) {
                    cVar.AR().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.AQ() != null) {
                cVar.AQ().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aru) {
            if (this.aru != -1) {
                LinearLayout linearLayout = (LinearLayout) this.aKz.getChildAt(this.aru + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.arf == 0) {
                        color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                    } else {
                        color = an.getColor(i.c.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aru = i;
            LinearLayout linearLayout2 = (LinearLayout) this.aKz.getChildAt(this.aru + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.mDatas.get(this.aru);
            if (cVar.AQ() != null) {
                cVar.AQ().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(an.getColor(i.c.transparent));
                this.aKE = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aru = -1;
        this.aKz.removeAllViews();
        HQ();
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cP(int i) {
        int color;
        this.arf = i;
        if (this.aKC != null) {
            an.b(this.aKC, i.e.icon_store, i);
        }
        if (this.aKB != null) {
            an.c(this.aKB, i.e.bg_emotion_tab_horizonscrollview, i);
            if (this.aKB.getChildCount() > 0) {
                an.d(this.aKB.getChildAt(1), i.c.emotion_tab_div_line_color, i);
            }
        }
        if (this.arA != null) {
            an.c(this.arA, i.e.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.arz != null) {
            an.c(this.arz, i.e.icon_news_head_prompt_one, i);
            an.a(this.arz, i.c.cp_cont_i, 1, i);
        }
        int childCount = this.aKz.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.aKz.getChildAt(i2);
            if (childAt != null) {
                an.c(childAt, i.e.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aKH != null) {
                        if (i == 0) {
                            color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                        } else {
                            color = an.getColor(i.c.emotion_tab_widget_foreground_color);
                        }
                        cVar.aKH.setForegroundColor(color);
                    }
                    if (cVar.aKI != null) {
                        an.d(cVar.aKI, i.c.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aKE != null) {
            this.aKE.setForegroundColor(an.getColor(i.c.transparent));
            if (this.aKE.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aKE.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aKA = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KB = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YX;

        private a(int i) {
            this.YX = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aKE) {
                ((TbImageView) view).setForegroundColor(an.getColor(i.c.transparent));
                if (EmotionTabHorizonScrollView.this.aKE != null) {
                    if (!EmotionTabHorizonScrollView.this.aKF) {
                        EmotionTabHorizonScrollView.this.aKE.setForegroundColor(an.getColor(i.c.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aKE.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(i.c.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aKE = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.YX);
            EmotionTabHorizonScrollView.this.aKA.ei(this.YX);
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
        TbImageView aKH;
        View aKI;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
