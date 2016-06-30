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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l BW;
    private int aeK;
    private int atp;
    private LinearLayout.LayoutParams atr;
    private int ats;
    private int att;
    private TextView atu;
    private View atv;
    private h brp;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> brq;
    private EmotionTabWidgetView.a brr;
    private LinearLayout brs;
    private ImageView brt;
    private boolean bru;
    private TbImageView brv;
    private boolean brw;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.atp = -1;
        this.bru = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atp = -1;
        this.bru = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.atp = -1;
        this.bru = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.brp = new h(getContext());
        this.brp.setOrientation(0);
        this.brp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.brp.setBaselineAligned(false);
        addView(this.brp);
        this.ats = getResources().getDimensionPixelSize(u.e.ds8);
        this.att = getResources().getDimensionPixelSize(u.e.ds10);
        this.atr = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds122), -1);
        this.brp.setPadding(0, 0, 0, 0);
        Rp();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.brw = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.brq = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        av.d(linearLayout, u.f.bg_emotion_tab_horizonscrollview, this.aeK);
        c cVar2 = new c(null);
        TbImageView tbImageView = new TbImageView(getContext());
        if (!this.brw) {
            tbImageView.setForegroundColor(av.getColor(u.d.common_color_10287));
        } else {
            tbImageView.setForegroundColor(getResources().getColor(u.d.common_color_10287));
        }
        tbImageView.setAutoChangeStyle(false);
        cVar2.bry = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.att, this.ats, this.att, this.ats);
        View view = new View(getContext());
        cVar2.brz = view;
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds2);
        if (!this.brw) {
            view.setBackgroundColor(av.getColor(u.d.common_color_10288));
        } else {
            view.setBackgroundColor(getResources().getColor(u.d.common_color_10288));
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(cVar2);
        this.brp.addView(linearLayout, this.brp.getChildCount() - 1, this.atr);
        EmotionGroupType BF = cVar.BF();
        if (BF == EmotionGroupType.LOCAL) {
            if (cVar.BG() != null) {
                cVar.BG().a(tbImageView);
            }
            tbImageView.setOnClickListener(new a(this, this.brp.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(u.j.local_emotion));
        } else if (BF == EmotionGroupType.PROMOTION) {
            if (cVar.BH() != null) {
                cVar.BH().a(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(u.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (BF == EmotionGroupType.BIG_EMOTION) {
            if (this.bru) {
                if (cVar.BG() != null) {
                    cVar.BG().a(tbImageView);
                }
                tbImageView.setOnClickListener(new a(this, this.brp.getChildCount() - 3, null));
            } else {
                if (cVar.BH() != null) {
                    cVar.BH().a(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (this.brv == null) {
            this.brv = tbImageView;
            this.brv.setForegroundColor(av.getColor(u.d.common_color_10022));
        }
        return tbImageView;
    }

    public void Rp() {
        this.brt = new ImageView(getContext());
        this.brt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.brt.setPadding(this.att, this.ats, this.att, this.ats);
        this.brs = new LinearLayout(getContext());
        this.brs.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(u.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.brt.setLayoutParams(layoutParams);
        av.b(this.brt, u.f.icon_store, this.aeK);
        this.brs.addView(this.brt);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        av.e(view, u.d.common_color_10288, this.aeK);
        this.brs.addView(view);
        this.atu = new TextView(getContext());
        this.atu.setGravity(17);
        this.atu.setTextSize(10.0f);
        this.atu.setText("N");
        this.atu.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.brp.addView(this.brs, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(u.e.ds106), -1));
        this.brp.setNewView(this.atu);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.brp.setNewViewVisible(true);
        } else {
            this.brp.setNewViewVisible(false);
        }
        this.brs.setOnClickListener(new n(this));
        this.atv = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.atv.setLayoutParams(layoutParams3);
        this.brp.addView(this.atv);
        if (!appResponseToIntentClass) {
            this.brs.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void y(int i, boolean z) {
        this.bru = z;
        int i2 = i + 1;
        int childCount = this.brp.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.brq.get(i2 - 1);
        if (i2 < childCount && cVar.BF() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.brp.getChildAt(i2)).getChildAt(0);
            if (!this.bru) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.BH() != null) {
                    cVar.BH().a(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new a(this, i2 - 1, null));
            if (cVar.BG() != null) {
                cVar.BG().a(tbImageView);
            }
        }
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.atp) {
            if (this.atp != -1) {
                LinearLayout linearLayout = (LinearLayout) this.brp.getChildAt(this.atp + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aeK == 0) {
                        color = getResources().getColor(u.d.common_color_10287);
                    } else {
                        color = av.getColor(u.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.atp = i;
            LinearLayout linearLayout2 = (LinearLayout) this.brp.getChildAt(this.atp + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(u.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.brq.get(this.atp);
            if (cVar.BG() != null) {
                cVar.BG().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(av.getColor(u.d.common_color_10022));
                this.brv = tbImageView2;
            }
        }
    }

    public void reset() {
        this.atp = -1;
        this.brp.removeAllViews();
        Rp();
        cX(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void cX(int i) {
        int color;
        this.aeK = i;
        if (this.brt != null) {
            av.b(this.brt, u.f.icon_store, i);
        }
        if (this.brs != null) {
            av.d(this.brs, u.f.bg_emotion_tab_horizonscrollview, i);
            if (this.brs.getChildCount() > 0) {
                av.e(this.brs.getChildAt(1), u.d.common_color_10288, i);
            }
        }
        if (this.atv != null) {
            av.d(this.atv, u.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.atu != null) {
            av.d(this.atu, u.f.icon_news_head_prompt_one, i);
            av.b(this.atu, u.d.cp_cont_i, 1, i);
        }
        int childCount = this.brp.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.brp.getChildAt(i2);
            if (childAt != null) {
                av.d(childAt, u.f.bg_emotion_tab_horizonscrollview, i);
                c cVar = (c) childAt.getTag();
                if (cVar != null) {
                    if (cVar.bry != null) {
                        if (i == 0) {
                            color = getResources().getColor(u.d.common_color_10287);
                        } else {
                            color = av.getColor(u.d.common_color_10287);
                        }
                        cVar.bry.setForegroundColor(color);
                    }
                    if (cVar.brz != null) {
                        av.e(cVar.brz, u.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.brv != null) {
            this.brv.setForegroundColor(av.getColor(u.d.common_color_10022));
            if (this.brv.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.brv.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.brr = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int VM;

        private a(int i) {
            this.VM = i;
        }

        /* synthetic */ a(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, a aVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.brv) {
                ((TbImageView) view).setForegroundColor(av.getColor(u.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.brv != null) {
                    if (!EmotionTabHorizonScrollView.this.brw) {
                        EmotionTabHorizonScrollView.this.brv.setForegroundColor(av.getColor(u.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.brv.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(u.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.brv = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.VM);
            EmotionTabHorizonScrollView.this.brr.eA(this.VM);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), this.mGroupId, false, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        TbImageView bry;
        View brz;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }
}
