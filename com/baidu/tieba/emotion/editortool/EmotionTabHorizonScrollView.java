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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private com.baidu.tbadk.editortools.l EJ;
    private int ait;
    private int axl;
    private LinearLayout.LayoutParams axn;
    private int axo;
    private int axp;
    private TextView axq;
    private View axr;
    private h bEQ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bER;
    private EmotionTabWidgetView.a bES;
    private LinearLayout bET;
    private ImageView bEU;
    private boolean bEV;
    private TbImageView bEW;
    private boolean bEX;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axl = -1;
        this.bEV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axl = -1;
        this.bEV = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.axl = -1;
        this.bEV = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bEQ = new h(getContext());
        this.bEQ.setOrientation(0);
        this.bEQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bEQ.setBaselineAligned(false);
        addView(this.bEQ);
        this.axo = getResources().getDimensionPixelSize(t.e.ds8);
        this.axp = getResources().getDimensionPixelSize(t.e.ds10);
        this.axn = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds122), -1);
        this.bEQ.setPadding(0, 0, 0, 0);
        WI();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bEX = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bER = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a(null);
        aVar.bFb = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bEZ = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.axp, this.axo, this.axp, this.axo);
        View view = new View(getContext());
        aVar.bFa = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bEQ.addView(linearLayout, this.bEQ.getChildCount() - 1, this.axn);
        EmotionGroupType Da = cVar.Da();
        if (Da == EmotionGroupType.LOCAL) {
            if (cVar.Db() != null) {
                cVar.Db().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this, this.bEQ.getChildCount() - 3, null));
            tbImageView.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(t.j.local_emotion));
        } else if (Da == EmotionGroupType.PROMOTION) {
            if (cVar.Dc() != null) {
                cVar.Dc().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(this, cVar.getGroupId(), null));
            tbImageView.setContentDescription(String.valueOf(TbadkCoreApplication.m9getInst().getResources().getString(t.j.download_promotion_emotion)) + cVar.getGroupId());
        } else if (Da == EmotionGroupType.BIG_EMOTION) {
            if (this.bEV) {
                if (cVar.Db() != null) {
                    cVar.Db().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this, this.bEQ.getChildCount() - 3, null));
            } else {
                if (cVar.Dc() != null) {
                    cVar.Dc().e(tbImageView);
                }
                tbImageView.setOnClickListener(new m(this));
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        }
        if (!this.bEX) {
            view.setBackgroundColor(av.getColor(t.d.common_color_10288));
            tbImageView.setForegroundColor(av.getColor(t.d.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(t.d.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(t.d.common_color_10287));
        }
        if (this.bEW == null) {
            this.bEW = tbImageView;
            this.bEW.setForegroundColor(av.getColor(t.d.common_color_10022));
        }
        av.d(linearLayout, t.f.bg_emotion_tab_horizonscrollview, this.ait);
        return tbImageView;
    }

    public void WI() {
        this.bEU = new ImageView(getContext());
        this.bEU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bEU.setPadding(this.axp, this.axo, this.axp, this.axo);
        this.bET = new LinearLayout(getContext());
        this.bET.setContentDescription(TbadkCoreApplication.m9getInst().getResources().getString(t.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bEU.setLayoutParams(layoutParams);
        av.c(this.bEU, t.f.icon_store, this.ait);
        this.bET.addView(this.bEU);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        av.e(view, t.d.common_color_10288, this.ait);
        this.bET.addView(view);
        this.axq = new TextView(getContext());
        this.axq.setGravity(17);
        this.axq.setTextSize(10.0f);
        this.axq.setText("N");
        this.axq.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bEQ.addView(this.bET, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(t.e.ds106), -1));
        this.bEQ.setNewView(this.axq);
        boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.m9getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bEQ.setNewViewVisible(true);
        } else {
            this.bEQ.setNewViewVisible(false);
        }
        this.bET.setOnClickListener(new n(this));
        this.axr = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.axr.setLayoutParams(layoutParams3);
        this.bEQ.addView(this.axr);
        if (!appResponseToIntentClass) {
            this.bET.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void z(int i, boolean z) {
        this.bEV = z;
        int i2 = i + 1;
        int childCount = this.bEQ.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bER.get(i2 - 1);
        if (i2 < childCount && cVar.Da() == EmotionGroupType.BIG_EMOTION) {
            TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bEQ.getChildAt(i2)).getChildAt(0);
            if (!this.bEV) {
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
        int childCount = this.bEQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bEQ.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bFb;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bET.setVisibility(8);
        } else {
            this.bET.setVisibility(0);
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
        if (i != this.axl) {
            if (this.axl != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bEQ.getChildAt(this.axl + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ait == 0) {
                        color = getResources().getColor(t.d.common_color_10287);
                    } else {
                        color = av.getColor(t.d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.axl = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bEQ.getChildAt(this.axl + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bER.get(this.axl);
            if (cVar.Db() != null) {
                cVar.Db().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(av.getColor(t.d.common_color_10022));
                this.bEW = tbImageView2;
            }
        }
    }

    public void reset() {
        this.axl = -1;
        this.bEQ.removeAllViews();
        WI();
        dl(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void dl(int i) {
        int color;
        this.ait = i;
        if (this.bEU != null) {
            av.c(this.bEU, t.f.icon_store, i);
        }
        if (this.bET != null) {
            av.d(this.bET, t.f.bg_emotion_tab_horizonscrollview, i);
            if (this.bET.getChildCount() > 0) {
                av.e(this.bET.getChildAt(1), t.d.common_color_10288, i);
            }
        }
        if (this.axr != null) {
            av.d(this.axr, t.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.axq != null) {
            av.d(this.axq, t.f.icon_news_head_prompt_one, i);
            av.b(this.axq, t.d.cp_cont_i, 1, i);
        }
        int childCount = this.bEQ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bEQ.getChildAt(i2);
            if (childAt != null) {
                av.d(childAt, t.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bEZ != null) {
                        if (i == 0) {
                            color = getResources().getColor(t.d.common_color_10287);
                        } else {
                            color = av.getColor(t.d.common_color_10287);
                        }
                        aVar.bEZ.setForegroundColor(color);
                    }
                    if (aVar.bFa != null) {
                        av.e(aVar.bFa, t.d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bEW != null) {
            this.bEW.setForegroundColor(av.getColor(t.d.common_color_10022));
            if (this.bEW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bEW.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bES = aVar;
    }

    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.EJ = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int Zj;

        private b(int i) {
            this.Zj = i;
        }

        /* synthetic */ b(EmotionTabHorizonScrollView emotionTabHorizonScrollView, int i, b bVar) {
            this(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bEW) {
                ((TbImageView) view).setForegroundColor(av.getColor(t.d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bEW != null) {
                    if (!EmotionTabHorizonScrollView.this.bEX) {
                        EmotionTabHorizonScrollView.this.bEW.setForegroundColor(av.getColor(t.d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bEW.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(t.d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bEW = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.Zj);
            EmotionTabHorizonScrollView.this.bES.eO(this.Zj);
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
        TbImageView bEZ;
        View bFa;
        com.baidu.tbadk.editortools.emotiontool.c bFb;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
