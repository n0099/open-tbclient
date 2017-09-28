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
    private i JG;
    private int aDG;
    private LinearLayout.LayoutParams aDI;
    private int aDJ;
    private int aDK;
    private TextView aDL;
    private View aDM;
    private int aoZ;
    private com.baidu.tieba.emotion.editortool.a cbp;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbq;
    private EmotionTabWidgetView.a cbr;
    private LinearLayout cbs;
    private ImageView cbt;
    private boolean cbu;
    private TbImageView cbv;
    private boolean cbw;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDG = -1;
        this.cbu = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDG = -1;
        this.cbu = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aDG = -1;
        this.cbu = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cbp = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.cbp.setOrientation(0);
        this.cbp.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cbp.setBaselineAligned(false);
        addView(this.cbp);
        this.aDJ = getResources().getDimensionPixelSize(d.f.ds8);
        this.aDK = getResources().getDimensionPixelSize(d.f.ds10);
        this.aDI = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.cbp.setPadding(0, 0, 0, 0);
        acl();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cbw = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cbq = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cbA = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cby = tbImageView;
        if (cVar.CO() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aDK, this.aDJ, this.aDK, this.aDJ);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.g.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.f.ds12), l.f(getContext(), d.f.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cbz = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cbp.addView(relativeLayout, this.cbp.getChildCount() - 1, this.aDI);
            if (cVar.CQ() != null) {
                cVar.CQ().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cbw && this.aoZ == 1) {
                view.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.cbv == null) {
                this.cbv = tbImageView;
                this.cbv.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(relativeLayout, d.g.bg_emotion_tab_horizonscrollview, this.aoZ);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aDK, this.aDJ, this.aDK, this.aDJ);
            View view2 = new View(getContext());
            aVar.cbz = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cbp.addView(linearLayout, this.cbp.getChildCount() - 1, this.aDI);
            EmotionGroupType CO = cVar.CO();
            if (CO == EmotionGroupType.LOCAL) {
                if (cVar.CP() != null) {
                    cVar.CP().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cbp.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
            } else if (CO == EmotionGroupType.PROMOTION) {
                if (cVar.CQ() != null) {
                    cVar.CQ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
            } else if (CO == EmotionGroupType.BIG_EMOTION) {
                if (this.cbu) {
                    if (cVar.CP() != null) {
                        cVar.CP().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cbp.getChildCount() - 3));
                } else {
                    if (cVar.CQ() != null) {
                        cVar.CQ().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tq();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (CO == EmotionGroupType.USER_COLLECT) {
                if (cVar.CQ() != null) {
                    cVar.CQ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cbp.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (CO == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.CQ() != null) {
                    cVar.CQ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cbw && this.aoZ == 1) {
                view2.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.cbv == null) {
                this.cbv = tbImageView;
                this.cbv.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.aoZ);
        }
        return tbImageView;
    }

    public void acl() {
        this.cbt = new ImageView(getContext());
        this.cbt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cbt.setPadding(this.aDK, this.aDJ, this.aDK, this.aDJ);
        this.cbs = new LinearLayout(getContext());
        this.cbs.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cbt.setLayoutParams(layoutParams);
        aj.b(this.cbt, d.g.face_store, this.aoZ);
        this.cbs.addView(this.cbt);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.e.common_color_10288, this.aoZ);
        this.cbs.addView(view);
        this.aDL = new TextView(getContext());
        this.aDL.setGravity(17);
        this.aDL.setTextSize(10.0f);
        this.aDL.setText("N");
        this.aDL.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cbp.addView(this.cbs, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.cbp.setNewView(this.aDL);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cbp.setNewViewVisible(true);
        } else {
            this.cbp.setNewViewVisible(false);
        }
        this.cbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aDL != null) {
                    EmotionTabHorizonScrollView.this.cbp.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.JG != null) {
                    EmotionTabHorizonScrollView.this.JG.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.hh()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.l.neterror);
                }
            }
        });
        this.aDM = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aDM.setLayoutParams(layoutParams3);
        this.cbp.addView(this.aDM);
        if (!appResponseToIntentClass) {
            this.cbs.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void k(int i, boolean z) {
        this.cbu = z;
        int i2 = i + 1;
        int childCount = this.cbp.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbq.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.CO() == EmotionGroupType.BIG_EMOTION || cVar.CO() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cbp.getChildAt(i2)).getChildAt(0);
                if (!this.cbu) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tq();
                        }
                    });
                    if (cVar.CQ() != null) {
                        cVar.CQ().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.CP() != null) {
                    cVar.CP().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cbp.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cbp.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cbA;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cbs.setVisibility(8);
        } else {
            this.cbs.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CO() == EmotionGroupType.BIG_EMOTION || cVar.CO() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aDG) {
            if (this.aDG != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cbp.getChildAt(this.aDG + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aoZ == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = aj.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aDG = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cbp.getChildAt(this.aDG + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbq.get(this.aDG);
            if (cVar.CP() != null) {
                cVar.CP().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.e.common_color_10022));
                this.cbv = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aDG = -1;
        this.cbp.removeAllViews();
        acl();
        dE(this.aoZ);
    }

    public void dE(int i) {
        int color;
        this.aoZ = i;
        if (this.cbt != null) {
            aj.b(this.cbt, d.g.face_store, i);
        }
        if (this.cbs != null) {
            aj.d(this.cbs, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.cbs.getChildCount() > 0) {
                aj.e(this.cbs.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aDM != null) {
            aj.d(this.aDM, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aDL != null) {
            aj.d(this.aDL, d.g.icon_news_head_prompt_one, i);
            aj.b(this.aDL, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.cbp.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cbp.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cby != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = aj.getColor(d.e.common_color_10287);
                        }
                        aVar.cby.setForegroundColor(color);
                    }
                    if (aVar.cbz != null) {
                        aj.e(aVar.cbz, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cbv != null) {
            this.cbv.setForegroundColor(aj.getColor(d.e.common_color_10022));
            if (this.cbv.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cbv.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cbr = aVar;
    }

    public void setEditorTools(i iVar) {
        this.JG = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aey;

        private b(int i) {
            this.aey = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cbv) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cbv != null) {
                    if (!EmotionTabHorizonScrollView.this.cbw) {
                        EmotionTabHorizonScrollView.this.cbv.setForegroundColor(aj.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cbv.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cbv = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aey);
            EmotionTabHorizonScrollView.this.cbr.fd(this.aey);
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
            if (com.baidu.adp.lib.g.b.g(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        com.baidu.tbadk.editortools.emotiontool.c cbA;
        TbImageView cby;
        View cbz;

        private a() {
        }
    }
}
