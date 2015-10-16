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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.j KA;
    private int apS;
    private com.baidu.tbadk.editortools.emotiontool.b apY;
    private int apZ;
    private EmotionTabWidgetView.a aqa;
    private int aqb;
    private int aqc;
    private LinearLayout aqd;
    private ImageView aqe;
    private TextView aqf;
    private LinearLayout.LayoutParams aqg;
    private boolean aqh;
    private View aqi;
    private TbImageView aqj;
    private boolean aqk;
    private int from;
    private ArrayList<t> mDatas;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apZ = -1;
        this.aqh = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apZ = -1;
        this.aqh = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.apZ = -1;
        this.aqh = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.apY = new com.baidu.tbadk.editortools.emotiontool.b(getContext());
        this.apY.setOrientation(0);
        this.apY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.apY.setBaselineAligned(false);
        addView(this.apY);
        this.aqb = getResources().getDimensionPixelSize(i.d.face_tab_widget_tb_padding);
        this.aqc = getResources().getDimensionPixelSize(i.d.face_tab_widget_lr_padding);
        this.aqg = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds122), -1);
        this.apY.setPadding(0, 0, 0, 0);
        AO();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.aqk = z;
    }

    public void setDatas(ArrayList<t> arrayList) {
        this.mDatas = arrayList;
    }

    private TbImageView b(t tVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        an.c(linearLayout, i.e.bg_emotion_tab_horizonscrollview, this.apS);
        c cVar = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.aqk) {
            tbImageView.setForegroundColor(an.getColor(i.c.emotion_tab_widget_foreground_color));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(i.c.emotion_tab_widget_foreground_color));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar.aqm = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aqc, this.aqb, this.aqc, this.aqb);
        View view = new View(getContext());
        cVar.aqn = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds2);
        if (!this.aqk) {
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
        linearLayout.setTag(cVar);
        this.apY.addView(linearLayout, this.apY.getChildCount() - 1, this.aqg);
        EmotionGroupType AZ = tVar.AZ();
        if (AZ == EmotionGroupType.LOCAL) {
            if (tVar.Bg() != null) {
                tVar.Bg().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.apY.getChildCount() - 3, null));
        } else if (AZ == EmotionGroupType.PROMOTION) {
            if (tVar.Bh() != null) {
                tVar.Bh().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, tVar.getGroupId(), null));
        } else if (AZ == EmotionGroupType.BIG_EMOTION) {
            if (this.aqh) {
                if (tVar.Bg() != null) {
                    tVar.Bg().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.apY.getChildCount() - 3, null));
            } else {
                if (tVar.Bh() != null) {
                    tVar.Bh().a(tbImageView);
                }
                tbImageView.setOnClickListener(new g(this));
            }
        }
        if (this.aqj == null) {
            this.aqj = tbImageView;
            this.aqj.setForegroundColor(an.getColor(i.c.transparent));
        }
        return tbImageView;
    }

    public void AO() {
        this.aqe = new ImageView(getContext());
        this.aqe.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.aqe.setPadding(this.aqc, this.aqb, this.aqc, this.aqb);
        this.aqd = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.aqe.setLayoutParams(layoutParams);
        an.b(this.aqe, i.e.icon_store, this.apS);
        this.aqd.addView(this.aqe);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        an.d(view, i.c.emotion_tab_div_line_color, this.apS);
        this.aqd.addView(view);
        this.aqf = new TextView(getContext());
        this.aqf.setGravity(17);
        this.aqf.setTextSize(10.0f);
        this.aqf.setText("N");
        this.aqf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.apY.addView(this.aqd, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(i.d.face_tab_widget_width), -1));
        this.apY.setNewView(this.aqf);
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew() && appResponseToCmd) {
            this.apY.setNewViewVisible(true);
        } else {
            this.apY.setNewViewVisible(false);
        }
        this.aqd.setOnClickListener(new h(this));
        this.aqi = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aqi.setLayoutParams(layoutParams3);
        this.apY.addView(this.aqi);
        if (!appResponseToCmd) {
            this.aqd.setVisibility(8);
        }
    }

    public void c(t tVar) {
        b(tVar);
    }

    public void g(int i, boolean z) {
        this.aqh = z;
        int i2 = i + 1;
        int childCount = this.apY.getChildCount();
        t tVar = this.mDatas.get(i2 - 1);
        if (i2 < childCount && tVar.AZ() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.apY.getChildAt(i2)).getChildAt(0);
            if (!this.aqh) {
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
        if (i != this.apZ) {
            if (this.apZ != -1) {
                LinearLayout linearLayout = (LinearLayout) this.apY.getChildAt(this.apZ + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.apS == 0) {
                        color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                    } else {
                        color = an.getColor(i.c.emotion_tab_widget_foreground_color);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.apZ = i;
            LinearLayout linearLayout2 = (LinearLayout) this.apY.getChildAt(this.apZ + 1);
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
            t tVar = this.mDatas.get(this.apZ);
            if (tVar.Bg() != null) {
                tVar.Bg().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(an.getColor(i.c.transparent));
                this.aqj = tbImageView2;
            }
        }
    }

    public void reset() {
        this.apZ = -1;
        this.apY.removeAllViews();
        AO();
        cP(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void cP(int i) {
        int color;
        this.apS = i;
        if (this.aqe != null) {
            an.b(this.aqe, i.e.icon_store, i);
        }
        if (this.aqd != null) {
            an.c(this.aqd, i.e.bg_emotion_tab_horizonscrollview, i);
            if (this.aqd.getChildCount() > 0) {
                an.d(this.aqd.getChildAt(1), i.c.emotion_tab_div_line_color, i);
            }
        }
        if (this.aqi != null) {
            an.c(this.aqi, i.e.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aqf != null) {
            an.c(this.aqf, i.e.icon_news_head_prompt_one, i);
            an.a(this.aqf, i.c.cp_cont_i, 1, i);
        }
        int childCount = this.apY.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.apY.getChildAt(i2);
            if (childAt != null) {
                an.c(childAt, i.e.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.aqm != null) {
                        if (i == 0) {
                            color = getResources().getColor(i.c.emotion_tab_widget_foreground_color);
                        } else {
                            color = an.getColor(i.c.emotion_tab_widget_foreground_color);
                        }
                        cVar.aqm.setForegroundColor(color);
                    }
                    if (cVar.aqn != null) {
                        an.d(cVar.aqn, i.c.emotion_tab_div_line_color, i);
                    }
                }
            }
        }
        if (this.aqj != null) {
            this.aqj.setForegroundColor(an.getColor(i.c.transparent));
            if (this.aqj.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.aqj.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.aqa = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KA = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int YT;

        private a(int i) {
            this.YT = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.aqj) {
                ((TbImageView) view).setForegroundColor(an.getColor(i.c.transparent));
                if (EmotionTabHorizonScrollView.this.aqj != null) {
                    if (!EmotionTabHorizonScrollView.this.aqk) {
                        EmotionTabHorizonScrollView.this.aqj.setForegroundColor(an.getColor(i.c.emotion_tab_widget_foreground_color));
                    } else {
                        EmotionTabHorizonScrollView.this.aqj.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(i.c.emotion_tab_widget_foreground_color));
                    }
                }
                EmotionTabHorizonScrollView.this.aqj = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.YT);
            EmotionTabHorizonScrollView.this.aqa.ea(this.YT);
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
        TbImageView aqm;
        View aqn;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
