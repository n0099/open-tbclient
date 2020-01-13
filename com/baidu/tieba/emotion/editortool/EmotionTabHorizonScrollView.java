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
/* loaded from: classes5.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Fv;
    private int MH;
    private LinearLayout.LayoutParams cuk;
    private int dvq;
    private int dvr;
    private TextView dvs;
    private View dvt;
    private EmotionLinearLayout fPV;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fPW;
    private EmotionTabWidgetView.a fPX;
    private LinearLayout fPY;
    private ImageView fPZ;
    private boolean fQa;
    private TbImageView fQb;
    private boolean fQc;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.fQa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.fQa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.fQa = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fPV = new EmotionLinearLayout(getContext());
        this.fPV.setOrientation(0);
        this.fPV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fPV.setBaselineAligned(false);
        addView(this.fPV);
        this.dvq = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dvr = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cuk = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.fPV.setPadding(0, 0, 0, 0);
        bvI();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.fQc = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fPW = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.fQg = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.fQe = tbImageView;
        if (cVar.aMk() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.dvr, this.dvq, this.dvr, this.dvq);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.fQf = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.fPV.addView(relativeLayout, this.fPV.getChildCount() - 1, this.cuk);
            if (cVar.aMm() != null) {
                cVar.aMm().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.fQc && (this.MH == 1 || this.MH == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fQb == null) {
                this.fQb = tbImageView;
                this.fQb.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.MH);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.dvr, this.dvq, this.dvr, this.dvq);
            View view2 = new View(getContext());
            aVar.fQf = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.fPV.addView(linearLayout, this.fPV.getChildCount() - 1, this.cuk);
            EmotionGroupType aMk = cVar.aMk();
            if (aMk == EmotionGroupType.LOCAL) {
                if (cVar.aMl() != null) {
                    cVar.aMl().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fPV.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aMk == EmotionGroupType.PROMOTION) {
                if (cVar.aMm() != null) {
                    cVar.aMm().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aMk == EmotionGroupType.BIG_EMOTION) {
                if (this.fQa) {
                    if (cVar.aMl() != null) {
                        cVar.aMl().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.fPV.getChildCount() - 3));
                } else {
                    if (cVar.aMm() != null) {
                        cVar.aMm().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aCu();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aMk == EmotionGroupType.USER_COLLECT) {
                if (cVar.aMm() != null) {
                    cVar.aMm().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fPV.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aMk == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aMm() != null) {
                    cVar.aMm().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.fQc && (this.MH == 1 || this.MH == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fQb == null) {
                this.fQb = tbImageView;
                this.fQb.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.MH);
        }
        return tbImageView;
    }

    public void bvI() {
        this.fPZ = new ImageView(getContext());
        this.fPZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fPZ.setPadding(this.dvr, this.dvq, this.dvr, this.dvq);
        this.fPY = new LinearLayout(getContext());
        this.fPY.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fPZ.setLayoutParams(layoutParams);
        am.setImageResource(this.fPZ, R.drawable.face_store, this.MH);
        this.fPY.addView(this.fPZ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.MH);
        this.fPY.addView(view);
        this.dvs = new TextView(getContext());
        this.dvs.setGravity(17);
        this.dvs.setTextSize(10.0f);
        this.dvs.setText("N");
        this.dvs.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.fPV.addView(this.fPY, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.fPV.setNewView(this.dvs);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.fPV.setNewViewVisible(true);
        } else {
            this.fPV.setNewViewVisible(false);
        }
        this.fPY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.dvs != null) {
                    EmotionTabHorizonScrollView.this.fPV.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Fv != null) {
                    EmotionTabHorizonScrollView.this.Fv.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.dvt = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.dvt.setLayoutParams(layoutParams3);
        this.fPV.addView(this.dvt);
        if (!appResponseToIntentClass) {
            this.fPY.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fQa = z;
        int i2 = i + 1;
        int childCount = this.fPV.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.fPW.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aMk() == EmotionGroupType.BIG_EMOTION || cVar.aMk() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.fPV.getChildAt(i2)).getChildAt(0);
                if (!this.fQa) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aCu();
                        }
                    });
                    if (cVar.aMm() != null) {
                        cVar.aMm().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aMl() != null) {
                    cVar.aMl().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.fPV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fPV.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).fQg;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.fPY.setVisibility(8);
        } else {
            this.fPY.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aMk() == EmotionGroupType.BIG_EMOTION || cVar.aMk() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fPV.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.MH == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fPV.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fPW.get(this.mCurrentIndex);
            if (cVar.aMl() != null) {
                cVar.aMl().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.fQb = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fPV.removeAllViews();
        bvI();
        onChangeSkin(this.MH);
    }

    public void onChangeSkin(int i) {
        int color;
        this.MH = i;
        if (this.fPZ != null) {
            am.setImageResource(this.fPZ, R.drawable.face_store, i);
        }
        if (this.fPY != null) {
            am.setBackgroundResource(this.fPY, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.fPY.getChildCount() > 0) {
                am.setBackgroundColor(this.fPY.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.dvt != null) {
            am.setBackgroundResource(this.dvt, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.dvs != null) {
            am.setBackgroundResource(this.dvs, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.dvs, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.fPV.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.fPV.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.fQe != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.fQe.setForegroundColor(color);
                    }
                    if (aVar.fQf != null) {
                        am.setBackgroundColor(aVar.fQf, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.fQb != null) {
            this.fQb.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.fQb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fQb.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.fPX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.fQb) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.fQb != null) {
                    if (!EmotionTabHorizonScrollView.this.fQc) {
                        EmotionTabHorizonScrollView.this.fQb.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.fQb.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.fQb = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.fPX.mi(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static class a {
        TbImageView fQe;
        View fQf;
        com.baidu.tbadk.editortools.emotiontool.c fQg;

        private a() {
        }
    }
}
