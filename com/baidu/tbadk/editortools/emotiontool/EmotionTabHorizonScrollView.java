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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j Kz;
    private int apR;
    private com.baidu.tbadk.editortools.emotiontool.b apX;
    private int apY;
    private EmotionTabWidgetView.a apZ;
    private int aqa;
    private int aqb;
    private LinearLayout aqc;
    private ImageView aqd;
    private TextView aqe;
    private LinearLayout.LayoutParams aqf;
    private boolean aqg;
    private View aqh;
    private TbImageView aqi;
    private boolean aqj;
    private int from;
    private ArrayList<t> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apY = -1;
        this.aqg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apY = -1;
        this.aqg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.apY = -1;
        this.aqg = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.apX = new com.baidu.tbadk.editortools.emotiontool.b(getContext());
        this.apX.setOrientation(0);
        this.apX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.apX.setBaselineAligned(false);
        addView(this.apX);
        this.aqa = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.aqb = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.aqf = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds122), -1);
        this.apX.setPadding(0, 0, 0, 0);
        AO();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aqj = z;
    }

    public void setDatas(ArrayList<t> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(t tVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        am.c(linearLayout, i.e.bg_emotion_tab_horizonscrollview, this.apR);
        c cVar = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aqj) {
            tbImageView.setForegroundColor(am.getColor(i.c.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(i.c.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar.aql = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aqb, this.aqa, this.aqb, this.aqa);
        View view = new View(getContext());
        cVar.aqm = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds2);
        if (!this.aqj) {
            view.setBackgroundColor(am.getColor(i.c.emotion_tab_div_line_color));
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
        this.apX.addView(linearLayout, this.apX.getChildCount() - 1, this.aqf);
        EmotionGroupType AZ = tVar.AZ();
        if (AZ == EmotionGroupType.LOCAL) {
            if (tVar.Bg() != null) {
                tVar.Bg().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.apX.getChildCount() - 3, null));
        } else if (AZ == EmotionGroupType.PROMOTION) {
            if (tVar.Bh() != null) {
                tVar.Bh().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, tVar.getGroupId(), null));
        } else if (AZ == EmotionGroupType.BIG_EMOTION) {
            if (this.aqg) {
                if (tVar.Bg() != null) {
                    tVar.Bg().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.apX.getChildCount() - 3, null));
            } else {
                if (tVar.Bh() != null) {
                    tVar.Bh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new g(this));
            }
        }
        if (this.aqi == null) {
            this.aqi = tbImageView;
            this.aqi.setForegroundColor(am.getColor(i.c.transparent));
        }
        return tbImageView;
    }

    public void AO() {
        this.aqd = new ImageView(getContext());
        this.aqd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aqd.setPadding(this.aqb, this.aqa, this.aqb, this.aqa);
        this.aqc = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aqd.setLayoutParams(layoutParams);
        am.b(this.aqd, i.e.icon_store, this.apR);
        this.aqc.addView(this.aqd);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.d(view, i.c.emotion_tab_div_line_color, this.apR);
        this.aqc.addView(view);
        this.aqe = new TextView(getContext());
        this.aqe.setGravity(17);
        this.aqe.setTextSize(10.0f);
        this.aqe.setText("N");
        this.aqe.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.apX.addView(this.aqc, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1));
        this.apX.setNewView(this.aqe);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.apX.setNewViewVisible(true);
        } else {
            this.apX.setNewViewVisible(false);
        }
        this.aqc.setOnClickListener(new h(this));
        this.aqh = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aqh.setLayoutParams(layoutParams3);
        this.apX.addView(this.aqh);
        if (!appResponseToCmd) {
            this.aqc.setVisibility(8);
        }
    }

    public void c(t tVar) {
        b(tVar);
    }

    public void g(int i, boolean z) {
        this.aqg = z;
        int i2 = i + 1;
        int childCount = this.apX.getChildCount();
        t tVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && tVar.AZ() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.apX.getChildAt(i2)).getChildAt(0);
            if (!this.aqg) {
                tbImageView.setOnClickListener(new i(this));
                if (tVar.Bh() != null) {
                    tVar.Bh().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (tVar.Bg() != null) {
                tVar.Bg().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.apY) {
            if (this.apY != -1) {
                LinearLayout linearLayout = (LinearLayout) this.apX.getChildAt(this.apY + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apR == 0) {
                        color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                    } else {
                        color = am.getColor(i.c.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.apY = i;
            LinearLayout linearLayout2 = (LinearLayout) this.apX.getChildAt(this.apY + 1);
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
            t tVar = this.mDatas.get(this.apY);
            if (tVar.Bg() != null) {
                tVar.Bg().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(i.c.transparent));
                this.aqi = tbImageView2;
            }
        }
    }

    public void reset() {
        this.apY = -1;
        this.apX.removeAllViews();
        AO();
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cP(int i) {
        int color;
        this.apR = i;
        if (this.aqd != null) {
            am.b(this.aqd, i.e.icon_store, i);
        }
        if (this.aqc != null) {
            am.c(this.aqc, i.e.bg_emotion_tab_horizonscrollview, i);
            if (this.aqc.getChildCount() > 0) {
                am.d(this.aqc.getChildAt(1), i.c.emotion_tab_div_line_color, i);
            }
        }
        if (this.aqh != null) {
            am.c(this.aqh, i.e.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aqe != null) {
            am.c(this.aqe, i.e.icon_news_head_prompt_one, i);
            am.a(this.aqe, i.c.cp_cont_i, 1, i);
        }
        int childCount = this.apX.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.apX.getChildAt(i2);
            if (childAt != null) {
                am.c(childAt, i.e.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aql != null) {
                        if (i == 0) {
                            color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                        } else {
                            color = am.getColor(i.c.emotion_tab_widget_foreground_color);
                        }
                        cVar.aql.setForegroundColor(color);
                    }
                    if (cVar.aqm != null) {
                        am.d(cVar.aqm, i.c.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aqi != null) {
            this.aqi.setForegroundColor(am.getColor(i.c.transparent));
            if (this.aqi.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aqi.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.apZ = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YR;

        private a(int i) {
            this.YR = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aqi) {
                ((TbImageView) view).setForegroundColor(am.getColor(i.c.transparent));
                if (EmotionTabHorizonScrollView.this.aqi != null) {
                    if (!EmotionTabHorizonScrollView.this.aqj) {
                        EmotionTabHorizonScrollView.this.aqi.setForegroundColor(am.getColor(i.c.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aqi.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(i.c.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aqi = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.YR);
            EmotionTabHorizonScrollView.this.apZ.ea(this.YR);
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
        TbImageView aql;
        View aqm;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
