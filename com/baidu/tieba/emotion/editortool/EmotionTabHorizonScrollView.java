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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Zt;
    private int agt;
    private LinearLayout.LayoutParams diD;
    private int enV;
    private int enW;
    private TextView enX;
    private View enY;
    private int from;
    private EmotionLinearLayout gMM;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gMN;
    private EmotionTabWidgetView.a gMO;
    private LinearLayout gMP;
    private ImageView gMQ;
    private boolean gMR;
    private TbImageView gMS;
    private boolean gMT;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.gMR = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.gMR = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.gMR = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.gMM = new EmotionLinearLayout(getContext());
        this.gMM.setOrientation(0);
        this.gMM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gMM.setBaselineAligned(false);
        addView(this.gMM);
        this.enV = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.enW = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.diD = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.gMM.setPadding(0, 0, 0, 0);
        bNy();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.gMT = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gMN = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.gMX = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.gMV = tbImageView;
        if (cVar.bdl() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.enW, this.enV, this.enW, this.enV);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.gMW = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.gMM.addView(relativeLayout, this.gMM.getChildCount() - 1, this.diD);
            if (cVar.bdn() != null) {
                cVar.bdn().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.gMT && (this.agt == 1 || this.agt == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gMS == null) {
                this.gMS = tbImageView;
                this.gMS.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.agt);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.enW, this.enV, this.enW, this.enV);
            View view2 = new View(getContext());
            aVar.gMW = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.gMM.addView(linearLayout, this.gMM.getChildCount() - 1, this.diD);
            EmotionGroupType bdl = cVar.bdl();
            if (bdl == EmotionGroupType.LOCAL) {
                if (cVar.bdm() != null) {
                    cVar.bdm().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gMM.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bdl == EmotionGroupType.PROMOTION) {
                if (cVar.bdn() != null) {
                    cVar.bdn().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bdl == EmotionGroupType.BIG_EMOTION) {
                if (this.gMR) {
                    if (cVar.bdm() != null) {
                        cVar.bdm().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.gMM.getChildCount() - 3));
                } else {
                    if (cVar.bdn() != null) {
                        cVar.bdn().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aSY();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bdl == EmotionGroupType.USER_COLLECT) {
                if (cVar.bdn() != null) {
                    cVar.bdn().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gMM.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bdl == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bdn() != null) {
                    cVar.bdn().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.gMT && (this.agt == 1 || this.agt == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gMS == null) {
                this.gMS = tbImageView;
                this.gMS.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.agt);
        }
        return tbImageView;
    }

    public void bNy() {
        this.gMQ = new ImageView(getContext());
        this.gMQ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gMQ.setPadding(this.enW, this.enV, this.enW, this.enV);
        this.gMP = new LinearLayout(getContext());
        this.gMP.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.gMQ.setLayoutParams(layoutParams);
        am.setImageResource(this.gMQ, R.drawable.face_store, this.agt);
        this.gMP.addView(this.gMQ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.agt);
        this.gMP.addView(view);
        this.enX = new TextView(getContext());
        this.enX.setGravity(17);
        this.enX.setTextSize(10.0f);
        this.enX.setText("N");
        this.enX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.gMM.addView(this.gMP, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.gMM.setNewView(this.enX);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.gMM.setNewViewVisible(true);
        } else {
            this.gMM.setNewViewVisible(false);
        }
        this.gMP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.enX != null) {
                    EmotionTabHorizonScrollView.this.gMM.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Zt != null) {
                    EmotionTabHorizonScrollView.this.Zt.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.enY = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.enY.setLayoutParams(layoutParams3);
        this.gMM.addView(this.enY);
        if (!appResponseToIntentClass) {
            this.gMP.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gMR = z;
        int i2 = i + 1;
        int childCount = this.gMM.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.gMN.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bdl() == EmotionGroupType.BIG_EMOTION || cVar.bdl() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.gMM.getChildAt(i2)).getChildAt(0);
                if (!this.gMR) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aSY();
                        }
                    });
                    if (cVar.bdn() != null) {
                        cVar.bdn().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bdm() != null) {
                    cVar.bdm().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.gMM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gMM.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).gMX;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.gMP.setVisibility(8);
        } else {
            this.gMP.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bdl() == EmotionGroupType.BIG_EMOTION || cVar.bdl() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.gMM.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.agt == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.gMM.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gMN.get(this.mCurrentIndex);
            if (cVar.bdm() != null) {
                cVar.bdm().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.gMS = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gMM.removeAllViews();
        bNy();
        onChangeSkin(this.agt);
    }

    public void onChangeSkin(int i) {
        int color;
        this.agt = i;
        if (this.gMQ != null) {
            am.setImageResource(this.gMQ, R.drawable.face_store, i);
        }
        if (this.gMP != null) {
            am.setBackgroundResource(this.gMP, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.gMP.getChildCount() > 0) {
                am.setBackgroundColor(this.gMP.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.enY != null) {
            am.setBackgroundResource(this.enY, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.enX != null) {
            am.setBackgroundResource(this.enX, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.enX, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.gMM.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.gMM.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.gMV != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.gMV.setForegroundColor(color);
                    }
                    if (aVar.gMW != null) {
                        am.setBackgroundColor(aVar.gMW, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.gMS != null) {
            this.gMS.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.gMS.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gMS.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.gMO = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.gMS) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.gMS != null) {
                    if (!EmotionTabHorizonScrollView.this.gMT) {
                        EmotionTabHorizonScrollView.this.gMS.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.gMS.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.gMS = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.gMO.np(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class a {
        TbImageView gMV;
        View gMW;
        com.baidu.tbadk.editortools.emotiontool.c gMX;

        private a() {
        }
    }
}
