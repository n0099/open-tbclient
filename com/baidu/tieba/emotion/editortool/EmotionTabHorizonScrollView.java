package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private i Lr;
    private int aEX;
    private LinearLayout.LayoutParams aEZ;
    private int aFa;
    private int aFb;
    private TextView aFc;
    private View aFd;
    private int aql;
    private com.baidu.tieba.emotion.editortool.a bWP;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bWQ;
    private EmotionTabWidgetView.a bWR;
    private LinearLayout bWS;
    private ImageView bWT;
    private boolean bWU;
    private TbImageView bWV;
    private boolean bWW;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEX = -1;
        this.bWU = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEX = -1;
        this.bWU = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aEX = -1;
        this.bWU = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bWP = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.bWP.setOrientation(0);
        this.bWP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bWP.setBaselineAligned(false);
        addView(this.bWP);
        this.aFa = getResources().getDimensionPixelSize(d.f.ds8);
        this.aFb = getResources().getDimensionPixelSize(d.f.ds10);
        this.aEZ = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.bWP.setPadding(0, 0, 0, 0);
        aaS();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.bWW = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.bWQ = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        a aVar = new a();
        aVar.bXa = cVar;
        TbImageView tbImageView = new TbImageView(getContext());
        tbImageView.setAutoChangeStyle(false);
        aVar.bWY = tbImageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        tbImageView.setLayoutParams(layoutParams);
        linearLayout.addView(tbImageView);
        tbImageView.setPadding(this.aFb, this.aFa, this.aFb, this.aFa);
        View view = new View(getContext());
        aVar.bWZ = view;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        linearLayout.addView(view, layoutParams2);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setTag(aVar);
        this.bWP.addView(linearLayout, this.bWP.getChildCount() - 1, this.aEZ);
        EmotionGroupType Dp = cVar.Dp();
        if (Dp == EmotionGroupType.LOCAL) {
            if (cVar.Dq() != null) {
                cVar.Dq().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this.bWP.getChildCount() - 3));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
        } else if (Dp == EmotionGroupType.PROMOTION) {
            if (cVar.Dr() != null) {
                cVar.Dr().e(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
        } else if (Dp == EmotionGroupType.BIG_EMOTION) {
            if (this.bWU) {
                if (cVar.Dq() != null) {
                    cVar.Dq().e(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.bWP.getChildCount() - 3));
            } else {
                if (cVar.Dr() != null) {
                    cVar.Dr().e(tbImageView);
                }
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tz();
                    }
                });
            }
            tbImageView.setContentDescription(cVar.getGroupName());
        } else if (Dp == EmotionGroupType.USER_COLLECT) {
            if (cVar.Dr() != null) {
                cVar.Dr().e(tbImageView);
            }
            tbImageView.setOnClickListener(new b(this.bWP.getChildCount() - 3));
            tbImageView.setContentDescription("");
        }
        if (!this.bWW && this.aql == 1) {
            view.setBackgroundColor(ai.getColor(d.e.common_color_10288));
            tbImageView.setForegroundColor(ai.getColor(d.e.common_color_10287));
        } else {
            view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
            tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
        }
        if (this.bWV == null) {
            this.bWV = tbImageView;
            this.bWV.setForegroundColor(ai.getColor(d.e.common_color_10022));
        }
        ai.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.aql);
        return tbImageView;
    }

    public void aaS() {
        this.bWT = new ImageView(getContext());
        this.bWT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.bWT.setPadding(this.aFb, this.aFa, this.aFb, this.aFa);
        this.bWS = new LinearLayout(getContext());
        this.bWS.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.bWT.setLayoutParams(layoutParams);
        ai.c(this.bWT, d.g.face_store, this.aql);
        this.bWS.addView(this.bWT);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ai.e(view, d.e.common_color_10288, this.aql);
        this.bWS.addView(view);
        this.aFc = new TextView(getContext());
        this.aFc.setGravity(17);
        this.aFc.setTextSize(10.0f);
        this.aFc.setText("N");
        this.aFc.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bWP.addView(this.bWS, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.bWP.setNewView(this.aFc);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.bWP.setNewViewVisible(true);
        } else {
            this.bWP.setNewViewVisible(false);
        }
        this.bWS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aFc != null) {
                    EmotionTabHorizonScrollView.this.bWP.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Lr != null) {
                    EmotionTabHorizonScrollView.this.Lr.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(EmotionTabHorizonScrollView.this.getContext(), "")));
            }
        });
        this.aFd = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aFd.setLayoutParams(layoutParams3);
        this.bWP.addView(this.aFd);
        if (!appResponseToIntentClass) {
            this.bWS.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void n(int i, boolean z) {
        this.bWU = z;
        int i2 = i + 1;
        int childCount = this.bWP.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.bWQ.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.Dp() == EmotionGroupType.BIG_EMOTION || cVar.Dp() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.bWP.getChildAt(i2)).getChildAt(0);
                if (!this.bWU) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tz();
                        }
                    });
                    if (cVar.Dr() != null) {
                        cVar.Dr().e(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.Dq() != null) {
                    cVar.Dq().e(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.bWP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bWP.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).bXa;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.bWS.setVisibility(8);
        } else {
            this.bWS.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.Dp() == EmotionGroupType.BIG_EMOTION || cVar.Dp() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aEX) {
            if (this.aEX != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bWP.getChildAt(this.aEX + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aql == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = ai.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aEX = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bWP.getChildAt(this.aEX + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bWQ.get(this.aEX);
            if (cVar.Dq() != null) {
                cVar.Dq().e(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ai.getColor(d.e.common_color_10022));
                this.bWV = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aEX = -1;
        this.bWP.removeAllViews();
        aaS();
        dt(this.aql);
    }

    public void dt(int i) {
        int color;
        this.aql = i;
        if (this.bWT != null) {
            ai.c(this.bWT, d.g.face_store, i);
        }
        if (this.bWS != null) {
            ai.d(this.bWS, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.bWS.getChildCount() > 0) {
                ai.e(this.bWS.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aFd != null) {
            ai.d(this.aFd, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aFc != null) {
            ai.d(this.aFc, d.g.icon_news_head_prompt_one, i);
            ai.b(this.aFc, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.bWP.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.bWP.getChildAt(i2);
            if (childAt != null) {
                ai.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.bWY != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = ai.getColor(d.e.common_color_10287);
                        }
                        aVar.bWY.setForegroundColor(color);
                    }
                    if (aVar.bWZ != null) {
                        ai.e(aVar.bWZ, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.bWV != null) {
            this.bWV.setForegroundColor(ai.getColor(d.e.common_color_10022));
            if (this.bWV.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bWV.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.bWR = aVar;
    }

    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int afQ;

        private b(int i) {
            this.afQ = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.bWV) {
                ((TbImageView) view).setForegroundColor(ai.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.bWV != null) {
                    if (!EmotionTabHorizonScrollView.this.bWW) {
                        EmotionTabHorizonScrollView.this.bWV.setForegroundColor(ai.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.bWV.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.bWV = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.afQ);
            EmotionTabHorizonScrollView.this.bWR.eT(this.afQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
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
        TbImageView bWY;
        View bWZ;
        com.baidu.tbadk.editortools.emotiontool.c bXa;

        private a() {
        }
    }
}
