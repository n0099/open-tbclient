package com.baidu.tieba.emotion.editortool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends com.baidu.tbadk.core.view.d {
    private i axN;
    private int bdK;
    private int bsW;
    private LinearLayout.LayoutParams bsY;
    private int bsZ;
    private int bta;
    private TextView btb;
    private View btc;
    private com.baidu.tieba.emotion.editortool.a dkR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> dkS;
    private EmotionTabWidgetView.a dkT;
    private LinearLayout dkU;
    private ImageView dkV;
    private boolean dkW;
    private TbImageView dkX;
    private boolean dkY;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsW = -1;
        this.dkW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsW = -1;
        this.dkW = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bsW = -1;
        this.dkW = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.dkR = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.dkR.setOrientation(0);
        this.dkR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dkR.setBaselineAligned(false);
        addView(this.dkR);
        this.bsZ = getResources().getDimensionPixelSize(d.e.ds8);
        this.bta = getResources().getDimensionPixelSize(d.e.ds10);
        this.bsY = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds122), -1);
        this.dkR.setPadding(0, 0, 0, 0);
        aoZ();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.dkY = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.dkS = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.dlc = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.dla = tbImageView;
        if (cVar.KJ() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.bta, this.bsZ, this.bta, this.bsZ);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.f.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.s(getContext(), d.e.ds12), l.s(getContext(), d.e.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.dlb = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.dkR.addView(relativeLayout, this.dkR.getChildCount() - 1, this.bsY);
            if (cVar.KL() != null) {
                cVar.KL().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.dkY && this.bdK == 1) {
                view.setBackgroundColor(aj.getColor(d.C0107d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0107d.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.C0107d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0107d.common_color_10287));
            }
            if (this.dkX == null) {
                this.dkX = tbImageView;
                this.dkX.setForegroundColor(aj.getColor(d.C0107d.common_color_10022));
            }
            aj.f(relativeLayout, d.f.bg_emotion_tab_horizonscrollview, this.bdK);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.bta, this.bsZ, this.bta, this.bsZ);
            View view2 = new View(getContext());
            aVar.dlb = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.dkR.addView(linearLayout, this.dkR.getChildCount() - 1, this.bsY);
            EmotionGroupType KJ = cVar.KJ();
            if (KJ == EmotionGroupType.LOCAL) {
                if (cVar.KK() != null) {
                    cVar.KK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dkR.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.local_emotion));
            } else if (KJ == EmotionGroupType.PROMOTION) {
                if (cVar.KL() != null) {
                    cVar.KL().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_promotion_emotion) + cVar.getGroupId());
            } else if (KJ == EmotionGroupType.BIG_EMOTION) {
                if (this.dkW) {
                    if (cVar.KK() != null) {
                        cVar.KK().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.dkR.getChildCount() - 3));
                } else {
                    if (cVar.KL() != null) {
                        cVar.KL().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).AI();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (KJ == EmotionGroupType.USER_COLLECT) {
                if (cVar.KL() != null) {
                    cVar.KL().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.dkR.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (KJ == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.KL() != null) {
                    cVar.KL().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.dkY && this.bdK == 1) {
                view2.setBackgroundColor(aj.getColor(d.C0107d.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.C0107d.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.C0107d.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.C0107d.common_color_10287));
            }
            if (this.dkX == null) {
                this.dkX = tbImageView;
                this.dkX.setForegroundColor(aj.getColor(d.C0107d.common_color_10022));
            }
            aj.f(linearLayout, d.f.bg_emotion_tab_horizonscrollview, this.bdK);
        }
        return tbImageView;
    }

    public void aoZ() {
        this.dkV = new ImageView(getContext());
        this.dkV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.dkV.setPadding(this.bta, this.bsZ, this.bta, this.bsZ);
        this.dkU = new LinearLayout(getContext());
        this.dkU.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.j.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dkV.setLayoutParams(layoutParams);
        aj.b(this.dkV, d.f.face_store, this.bdK);
        this.dkU.addView(this.dkV);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.g(view, d.C0107d.common_color_10288, this.bdK);
        this.dkU.addView(view);
        this.btb = new TextView(getContext());
        this.btb.setGravity(17);
        this.btb.setTextSize(10.0f);
        this.btb.setText("N");
        this.btb.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dkR.addView(this.dkU, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.e.ds106), -1));
        this.dkR.setNewView(this.btb);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.dkR.setNewViewVisible(true);
        } else {
            this.dkR.setNewViewVisible(false);
        }
        this.dkU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.btb != null) {
                    EmotionTabHorizonScrollView.this.dkR.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.axN != null) {
                    EmotionTabHorizonScrollView.this.axN.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.oI()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.j.neterror);
                }
            }
        });
        this.btc = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.btc.setLayoutParams(layoutParams3);
        this.dkR.addView(this.btc);
        if (!appResponseToIntentClass) {
            this.dkU.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void y(int i, boolean z) {
        this.dkW = z;
        int i2 = i + 1;
        int childCount = this.dkR.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.dkS.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.KJ() == EmotionGroupType.BIG_EMOTION || cVar.KJ() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.dkR.getChildAt(i2)).getChildAt(0);
                if (!this.dkW) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.j.emotion_cant_show)).AI();
                        }
                    });
                    if (cVar.KL() != null) {
                        cVar.KL().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.KK() != null) {
                    cVar.KK().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.dkR.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.dkR.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).dlc;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.dkU.setVisibility(8);
        } else {
            this.dkU.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.KJ() == EmotionGroupType.BIG_EMOTION || cVar.KJ() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bsW) {
            if (this.bsW != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dkR.getChildAt(this.bsW + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.bdK == 0) {
                        color = getResources().getColor(d.C0107d.common_color_10287);
                    } else {
                        color = aj.getColor(d.C0107d.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bsW = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dkR.getChildAt(this.bsW + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.g.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.dkS.get(this.bsW);
            if (cVar.KK() != null) {
                cVar.KK().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.C0107d.common_color_10022));
                this.dkX = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bsW = -1;
        this.dkR.removeAllViews();
        aoZ();
        gz(this.bdK);
    }

    public void gz(int i) {
        int color;
        this.bdK = i;
        if (this.dkV != null) {
            aj.b(this.dkV, d.f.face_store, i);
        }
        if (this.dkU != null) {
            aj.f(this.dkU, d.f.bg_emotion_tab_horizonscrollview, i);
            if (this.dkU.getChildCount() > 0) {
                aj.g(this.dkU.getChildAt(1), d.C0107d.common_color_10288, i);
            }
        }
        if (this.btc != null) {
            aj.f(this.btc, d.f.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.btb != null) {
            aj.f(this.btb, d.f.icon_news_head_prompt_one, i);
            aj.b(this.btb, d.C0107d.cp_cont_i, 1, i);
        }
        int childCount = this.dkR.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.dkR.getChildAt(i2);
            if (childAt != null) {
                aj.f(childAt, d.f.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.dla != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.C0107d.common_color_10287);
                        } else {
                            color = aj.getColor(d.C0107d.common_color_10287);
                        }
                        aVar.dla.setForegroundColor(color);
                    }
                    if (aVar.dlb != null) {
                        aj.g(aVar.dlb, d.C0107d.common_color_10288, i);
                    }
                }
            }
        }
        if (this.dkX != null) {
            this.dkX.setForegroundColor(aj.getColor(d.C0107d.common_color_10022));
            if (this.dkX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.dkX.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.dkT = aVar;
    }

    public void setEditorTools(i iVar) {
        this.axN = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aTk;

        private b(int i) {
            this.aTk = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.dkX) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.C0107d.common_color_10022));
                if (EmotionTabHorizonScrollView.this.dkX != null) {
                    if (!EmotionTabHorizonScrollView.this.dkY) {
                        EmotionTabHorizonScrollView.this.dkX.setForegroundColor(aj.getColor(d.C0107d.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.dkX.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.C0107d.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.dkX = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aTk);
            EmotionTabHorizonScrollView.this.dkT.hV(this.aTk);
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
            if (com.baidu.adp.lib.g.b.h(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.h(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView dla;
        View dlb;
        com.baidu.tbadk.editortools.emotiontool.c dlc;

        private a() {
        }
    }
}
