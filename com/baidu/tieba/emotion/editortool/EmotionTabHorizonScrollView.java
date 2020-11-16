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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes13.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools abp;
    private int ajv;
    private LinearLayout.LayoutParams edU;
    private int fqd;
    private int fqe;
    private TextView fqf;
    private View fqg;
    private int from;
    private EmotionLinearLayout ihJ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> ihK;
    private EmotionTabWidgetView.a ihL;
    private LinearLayout ihM;
    private ImageView ihN;
    private boolean ihO;
    private TbImageView ihP;
    private boolean ihQ;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.ihO = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.ihO = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.ihO = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.ihJ = new EmotionLinearLayout(getContext());
        this.ihJ.setOrientation(0);
        this.ihJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ihJ.setBaselineAligned(false);
        addView(this.ihJ);
        this.fqd = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fqe = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.edU = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.ihJ.setPadding(0, 0, 0, 0);
        cqa();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ihQ = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.ihK = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.ihU = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.ihS = tbImageView;
        if (cVar.bzh() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fqe, this.fqd, this.fqe, this.fqd);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
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
            this.ihJ.addView(relativeLayout, this.ihJ.getChildCount() - 1, this.edU);
            if (cVar.bzj() != null) {
                cVar.bzj().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ihQ && (this.ajv == 1 || this.ajv == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ihP == null) {
                this.ihP = tbImageView;
                this.ihP.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajv);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams2);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fqe, this.fqd, this.fqe, this.fqd);
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams3.gravity = 5;
            layoutParams3.weight = 0.0f;
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.ihJ.addView(linearLayout, this.ihJ.getChildCount() - 1, this.edU);
            EmotionGroupType bzh = cVar.bzh();
            if (bzh == EmotionGroupType.LOCAL) {
                if (cVar.bzi() != null) {
                    cVar.bzi().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ihJ.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bzh == EmotionGroupType.PROMOTION) {
                if (cVar.bzj() != null) {
                    cVar.bzj().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bzh == EmotionGroupType.BIG_EMOTION) {
                if (this.ihO) {
                    if (cVar.bzi() != null) {
                        cVar.bzi().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.ihJ.getChildCount() - 3));
                } else {
                    if (cVar.bzj() != null) {
                        cVar.bzj().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bom();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bzh == EmotionGroupType.USER_COLLECT) {
                if (cVar.bzj() != null) {
                    cVar.bzj().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.ihJ.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bzh == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bzj() != null) {
                    cVar.bzj().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ihQ && (this.ajv == 1 || this.ajv == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ihP == null) {
                this.ihP = tbImageView;
                this.ihP.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajv);
        }
        return tbImageView;
    }

    public void cqa() {
        this.ihN = new ImageView(getContext());
        this.ihN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.ihN.setPadding(this.fqe, this.fqd, this.fqe, this.fqd);
        this.ihM = new LinearLayout(getContext());
        this.ihM.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ihN.setLayoutParams(layoutParams);
        ap.setImageResource(this.ihN, R.drawable.face_store, this.ajv);
        this.ihM.addView(this.ihN);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.ajv);
        this.fqf = new TextView(getContext());
        this.fqf.setGravity(17);
        this.fqf.setTextSize(10.0f);
        this.fqf.setText("N");
        this.fqf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.ihJ.addView(this.ihM, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.ihJ.setNewView(this.fqf);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.ihJ.setNewViewVisible(true);
        } else {
            this.ihJ.setNewViewVisible(false);
        }
        this.ihM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fqf != null) {
                    EmotionTabHorizonScrollView.this.ihJ.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.abp != null) {
                    EmotionTabHorizonScrollView.this.abp.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fqg = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fqg.setLayoutParams(layoutParams3);
        this.ihJ.addView(this.fqg);
        if (!appResponseToIntentClass) {
            this.ihM.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.ihO = z;
        int i2 = i + 1;
        int childCount = this.ihJ.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.ihK.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bzh() == EmotionGroupType.BIG_EMOTION || cVar.bzh() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.ihJ.getChildAt(i2)).getChildAt(0);
                if (!this.ihO) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bom();
                        }
                    });
                    if (cVar.bzj() != null) {
                        cVar.bzj().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bzi() != null) {
                    cVar.bzi().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.ihJ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ihJ.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).ihU;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.ihM.setVisibility(8);
        } else {
            this.ihM.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bzh() == EmotionGroupType.BIG_EMOTION || cVar.bzh() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ihJ.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ajv == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ihJ.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.ihK.get(this.mCurrentIndex);
            if (cVar.bzi() != null) {
                cVar.bzi().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.ihP = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ihJ.removeAllViews();
        cqa();
        onChangeSkin(this.ajv);
    }

    public void onChangeSkin(int i) {
        int color;
        this.ajv = i;
        if (this.ihN != null) {
            ap.setImageResource(this.ihN, R.drawable.face_store, i);
        }
        if (this.ihM != null) {
            ap.setBackgroundResource(this.ihM, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.ihM.getChildCount() > 0) {
                ap.setBackgroundColor(this.ihM.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fqg != null) {
            ap.setBackgroundResource(this.fqg, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fqf != null) {
            ap.setBackgroundResource(this.fqf, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.fqf, R.color.CAM_X0101, 1, i);
        }
        int childCount = this.ihJ.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.ihJ.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.ihS != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.ihS.setForegroundColor(color);
                    }
                    if (aVar.ihT != null) {
                        ap.setBackgroundColor(aVar.ihT, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ihP != null) {
            this.ihP.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.ihP.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ihP.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.ihL = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!EmotionTabHorizonScrollView.this.abp.rI(5).bzd() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.ihK.get(this.mTabIndex)).bzh() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.ihK.get(this.mTabIndex)).bzh() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ihP) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ihP != null) {
                    if (!EmotionTabHorizonScrollView.this.ihQ) {
                        EmotionTabHorizonScrollView.this.ihP.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ihP.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ihP = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.ihL.rW(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
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
    /* loaded from: classes13.dex */
    public static class a {
        TbImageView ihS;
        View ihT;
        com.baidu.tbadk.editortools.emotiontool.c ihU;

        private a() {
        }
    }
}
