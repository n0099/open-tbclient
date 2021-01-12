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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionCenterActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools acX;
    private int akf;
    private int bHL;
    private LinearLayout.LayoutParams epm;
    private int fCI;
    private int fCJ;
    private TextView fCK;
    private View fCL;
    private int from;
    private EmotionLinearLayout iAk;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> iAl;
    private EmotionTabWidgetView.a iAm;
    private LinearLayout iAn;
    private ImageView iAo;
    private boolean iAp;
    private TbImageView iAq;
    private boolean iAr;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHL = -1;
        this.iAp = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHL = -1;
        this.iAp = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bHL = -1;
        this.iAp = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.iAk = new EmotionLinearLayout(getContext());
        this.iAk.setOrientation(0);
        this.iAk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iAk.setBaselineAligned(false);
        addView(this.iAk);
        this.fCI = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fCJ = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.epm = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.iAk.setPadding(0, 0, 0, 0);
        ctr();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.iAr = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.iAl = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.iAv = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.iAt = tbImageView;
        if (cVar.bBj() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fCJ, this.fCI, this.fCJ, this.fCI);
            ImageView imageView = new ImageView(getContext());
            ao.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1).addRule(11);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.iAk.addView(relativeLayout, this.iAk.getChildCount() - 1, this.epm);
            if (cVar.bBl() != null) {
                cVar.bBl().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.iAr && (this.akf == 1 || this.akf == 4)) {
                view.setBackgroundColor(ao.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ao.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iAq == null) {
                this.iAq = tbImageView;
                this.iAq.setForegroundColor(ao.getColor(R.color.common_color_10022));
            }
            ao.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.akf);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fCJ, this.fCI, this.fCJ, this.fCI);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.iAk.addView(linearLayout, this.iAk.getChildCount() - 1, this.epm);
            EmotionGroupType bBj = cVar.bBj();
            if (bBj == EmotionGroupType.LOCAL) {
                if (cVar.bBk() != null) {
                    cVar.bBk().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iAk.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bBj == EmotionGroupType.PROMOTION) {
                if (cVar.bBl() != null) {
                    cVar.bBl().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bBj == EmotionGroupType.BIG_EMOTION) {
                if (this.iAp) {
                    if (cVar.bBk() != null) {
                        cVar.bBk().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.iAk.getChildCount() - 3));
                } else {
                    if (cVar.bBl() != null) {
                        cVar.bBl().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bqk();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bBj == EmotionGroupType.USER_COLLECT) {
                if (cVar.bBl() != null) {
                    cVar.bBl().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.iAk.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bBj == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bBl() != null) {
                    cVar.bBl().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.iAr && (this.akf == 1 || this.akf == 4)) {
                view2.setBackgroundColor(ao.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ao.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.iAq == null) {
                this.iAq = tbImageView;
                this.iAq.setForegroundColor(ao.getColor(R.color.common_color_10022));
            }
            ao.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.akf);
        }
        return tbImageView;
    }

    public void ctr() {
        this.iAo = new ImageView(getContext());
        this.iAo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.iAo.setPadding(this.fCJ, this.fCI, this.fCJ, this.fCI);
        this.iAn = new LinearLayout(getContext());
        this.iAn.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.iAo.setLayoutParams(layoutParams);
        ao.setImageResource(this.iAo, R.drawable.face_store, this.akf);
        this.iAn.addView(this.iAo);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ao.setBackgroundColor(view, R.color.common_color_10288, this.akf);
        this.fCK = new TextView(getContext());
        this.fCK.setGravity(17);
        this.fCK.setTextSize(10.0f);
        this.fCK.setText("N");
        this.fCK.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.iAk.addView(this.iAn, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.iAk.setNewView(this.fCK);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.iAk.setNewViewVisible(true);
        } else {
            this.iAk.setNewViewVisible(false);
        }
        this.iAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fCK != null) {
                    EmotionTabHorizonScrollView.this.iAk.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.acX != null) {
                    EmotionTabHorizonScrollView.this.acX.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fCL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fCL.setLayoutParams(layoutParams3);
        this.iAk.addView(this.fCL);
        if (!appResponseToIntentClass) {
            this.iAn.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iAp = z;
        int i2 = i + 1;
        int childCount = this.iAk.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.iAl.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bBj() == EmotionGroupType.BIG_EMOTION || cVar.bBj() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.iAk.getChildAt(i2)).getChildAt(0);
                if (!this.iAp) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bqk();
                        }
                    });
                    if (cVar.bBl() != null) {
                        cVar.bBl().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bBk() != null) {
                    cVar.bBk().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.iAk.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iAk.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).iAv;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.iAn.setVisibility(8);
        } else {
            this.iAn.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bBj() == EmotionGroupType.BIG_EMOTION || cVar.bBj() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bHL) {
            if (this.bHL != -1) {
                LinearLayout linearLayout = (LinearLayout) this.iAk.getChildAt(this.bHL + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.akf == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ao.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bHL = i;
            LinearLayout linearLayout2 = (LinearLayout) this.iAk.getChildAt(this.bHL + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(R.id.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.iAl.get(this.bHL);
            if (cVar.bBk() != null) {
                cVar.bBk().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ao.getColor(R.color.common_color_10022));
                this.iAq = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bHL = -1;
        this.iAk.removeAllViews();
        ctr();
        onChangeSkin(this.akf);
    }

    public void onChangeSkin(int i) {
        int color;
        this.akf = i;
        if (this.iAo != null) {
            ao.setImageResource(this.iAo, R.drawable.face_store, i);
        }
        if (this.iAn != null) {
            ao.setBackgroundResource(this.iAn, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.iAn.getChildCount() > 0) {
                ao.setBackgroundColor(this.iAn.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fCL != null) {
            ao.setBackgroundResource(this.fCL, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fCK != null) {
            ao.setBackgroundResource(this.fCK, R.drawable.icon_news_head_prompt_one, i);
            ao.setViewTextColor(this.fCK, R.color.CAM_X0101, 1, i);
        }
        int childCount = this.iAk.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.iAk.getChildAt(i2);
            if (childAt != null) {
                ao.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.iAt != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ao.getColor(R.color.common_color_10287);
                        }
                        aVar.iAt.setForegroundColor(color);
                    }
                    if (aVar.iAu != null) {
                        ao.setBackgroundColor(aVar.iAu, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.iAq != null) {
            this.iAq.setForegroundColor(ao.getColor(R.color.common_color_10022));
            if (this.iAq.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.iAq.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.iAm = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!EmotionTabHorizonScrollView.this.acX.qP(5).bBf() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iAl.get(this.mTabIndex)).bBj() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.iAl.get(this.mTabIndex)).bBj() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.iAq) {
                ((TbImageView) view).setForegroundColor(ao.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.iAq != null) {
                    if (!EmotionTabHorizonScrollView.this.iAr) {
                        EmotionTabHorizonScrollView.this.iAq.setForegroundColor(ao.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.iAq.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.iAq = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.iAm.rd(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.f.b.toInt(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.f.b.toInt(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        TbImageView iAt;
        View iAu;
        com.baidu.tbadk.editortools.emotiontool.c iAv;

        private a() {
        }
    }
}
