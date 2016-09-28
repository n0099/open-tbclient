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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l EJ;
    private int ahV;
    private int awO;
    private LinearLayout.LayoutParams awQ;
    private int awR;
    private int awS;
    private TextView awT;
    private View awU;
    private h bFb;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFc;
    private EmotionTabWidgetView.a bFd;
    private LinearLayout bFe;
    private ImageView bFf;
    private boolean bFg;
    private TbImageView bFh;
    private boolean bFi;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awO = -1;
        this.bFg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awO = -1;
        this.bFg = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.awO = -1;
        this.bFg = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bFb = new h(getContext());
        this.bFb.setOrientation(0);
        this.bFb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bFb.setBaselineAligned(false);
        addView(this.bFb);
        this.awR = getResources().getDimensionPixelSize(r.e.ds8);
        this.awS = getResources().getDimensionPixelSize(r.e.ds10);
        this.awQ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds122), -1);
        this.bFb.setPadding(0, 0, 0, 0);
        Xb();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bFi = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bFc = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bFm = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bFk = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.awS, this.awR, this.awS, this.awR);
        View view = new View(getContext());
        aVar.bFl = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bFb.addView(linearLayout, this.bFb.getChildCount() - 1, this.awQ);
        EmotionGroupType Da = cVar.Da();
        if (Da == EmotionGroupType.LOCAL) {
            if (cVar.Db() != null) {
                cVar.Db().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bFb.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.j.local_emotion));
        } else if (Da == EmotionGroupType.PROMOTION) {
            if (cVar.Dc() != null) {
                cVar.Dc().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(r.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (Da == EmotionGroupType.BIG_EMOTION) {
            if (this.bFg) {
                if (cVar.Db() != null) {
                    cVar.Db().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bFb.getChildCount() - 3, null));
            } else {
                if (cVar.Dc() != null) {
                    cVar.Dc().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bFi) {
            view.setBackgroundColor(av.getColor(r.d.common_color_10288));
            tbImageView.setForegroundColor(av.getColor(r.d.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(r.d.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(r.d.common_color_10287));
        }
        if (this.bFh == null) {
            this.bFh = tbImageView;
            this.bFh.setForegroundColor(av.getColor(r.d.common_color_10022));
        }
        av.d(linearLayout, r.f.bg_emotion_tab_horizonscrollview, this.ahV);
        return tbImageView;
    }

    public void Xb() {
        this.bFf = new ImageView(getContext());
        this.bFf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bFf.setPadding(this.awS, this.awR, this.awS, this.awR);
        this.bFe = new LinearLayout(getContext());
        this.bFe.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(r.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bFf.setLayoutParams(layoutParams);
        av.c(this.bFf, r.f.icon_store, this.ahV);
        this.bFe.addView(this.bFf);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        av.e(view, r.d.common_color_10288, this.ahV);
        this.bFe.addView(view);
        this.awT = new TextView(getContext());
        this.awT.setGravity(17);
        this.awT.setTextSize(10.0f);
        this.awT.setText("N");
        this.awT.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bFb.addView(this.bFe, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(r.e.ds106), -1));
        this.bFb.setNewView(this.awT);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bFb.setNewViewVisible(true);
        } else {
            this.bFb.setNewViewVisible(false);
        }
        this.bFe.setOnClickListener(new n(this));
        this.awU = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.awU.setLayoutParams(layoutParams3);
        this.bFb.addView(this.awU);
        if (!appResponseToIntentClass) {
            this.bFe.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void z(int i, boolean z) {
        this.bFg = z;
        int i2 = i + 1;
        int childCount = this.bFb.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFc.get(i2 - 1);
        if (i2 < childCount && cVar.Da() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bFb.getChildAt(i2)).getChildAt(0);
            if (!this.bFg) {
                tbImageView.setOnClickListener(new o(this));
                if (cVar.Dc() != null) {
                    cVar.Dc().e(tbImageView);
                    return;
                }
                return;
            }
            tbImageView.setOnClickListener(new b(this, i2 - 1, null));
            if (cVar.Db() != null) {
                cVar.Db().e(tbImageView);
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bFb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bFb.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bFm;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bFe.setVisibility(8);
        } else {
            this.bFe.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Da() == EmotionGroupType.BIG_EMOTION || cVar.Da() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.awO) {
            if (this.awO != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bFb.getChildAt(this.awO + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ahV == 0) {
                        color = getResources().getColor(r.d.common_color_10287);
                    } else {
                        color = av.getColor(r.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.awO = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bFb.getChildAt(this.awO + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFc.get(this.awO);
            if (cVar.Db() != null) {
                cVar.Db().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(av.getColor(r.d.common_color_10022));
                this.bFh = tbImageView2;
            }
        }
    }

    public void reset() {
        this.awO = -1;
        this.bFb.removeAllViews();
        Xb();
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dl(int i) {
        int color;
        this.ahV = i;
        if (this.bFf != null) {
            av.c(this.bFf, r.f.icon_store, i);
        }
        if (this.bFe != null) {
            av.d(this.bFe, r.f.bg_emotion_tab_horizonscrollview, i);
            if (this.bFe.getChildCount() > 0) {
                av.e(this.bFe.getChildAt(1), r.d.common_color_10288, i);
            }
        }
        if (this.awU != null) {
            av.d(this.awU, r.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.awT != null) {
            av.d(this.awT, r.f.icon_news_head_prompt_one, i);
            av.b(this.awT, r.d.cp_cont_i, 1, i);
        }
        int childCount = this.bFb.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bFb.getChildAt(i2);
            if (childAt != null) {
                av.d(childAt, r.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bFk != null) {
                        if (i == 0) {
                            color = getResources().getColor(r.d.common_color_10287);
                        } else {
                            color = av.getColor(r.d.common_color_10287);
                        }
                        aVar.bFk.setForegroundColor(color);
                    }
                    if (aVar.bFl != null) {
                        av.e(aVar.bFl, r.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bFh != null) {
            this.bFh.setForegroundColor(av.getColor(r.d.common_color_10022));
            if (this.bFh.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bFh.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bFd = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int Zw;

        private b(int i) {
            this.Zw = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bFh) {
                ((TbImageView) view).setForegroundColor(av.getColor(r.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bFh != null) {
                    if (!EmotionTabHorizonScrollView.this.bFi) {
                        EmotionTabHorizonScrollView.this.bFh.setForegroundColor(av.getColor(r.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bFh.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(r.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bFh = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.Zw);
            EmotionTabHorizonScrollView.this.bFd.eN(this.Zw);
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
        TbImageView bFk;
        View bFl;
        com.baidu.tbadk.editortools.emotiontool.c bFm;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
