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
    private EmotionLinearLayout gMX;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gMY;
    private EmotionTabWidgetView.a gMZ;
    private LinearLayout gNa;
    private ImageView gNb;
    private boolean gNc;
    private TbImageView gNd;
    private boolean gNe;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.gNc = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.gNc = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.gNc = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.gMX = new EmotionLinearLayout(getContext());
        this.gMX.setOrientation(0);
        this.gMX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gMX.setBaselineAligned(false);
        addView(this.gMX);
        this.enV = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.enW = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.diD = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.gMX.setPadding(0, 0, 0, 0);
        bNA();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.gNe = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gMY = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.gNi = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.gNg = tbImageView;
        if (cVar.bdm() == EmotionGroupType.SINGLE_FORUM) {
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
            aVar.gNh = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.gMX.addView(relativeLayout, this.gMX.getChildCount() - 1, this.diD);
            if (cVar.bdo() != null) {
                cVar.bdo().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.gNe && (this.agt == 1 || this.agt == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gNd == null) {
                this.gNd = tbImageView;
                this.gNd.setForegroundColor(am.getColor(R.color.common_color_10022));
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
            aVar.gNh = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.gMX.addView(linearLayout, this.gMX.getChildCount() - 1, this.diD);
            EmotionGroupType bdm = cVar.bdm();
            if (bdm == EmotionGroupType.LOCAL) {
                if (cVar.bdn() != null) {
                    cVar.bdn().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gMX.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bdm == EmotionGroupType.PROMOTION) {
                if (cVar.bdo() != null) {
                    cVar.bdo().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bdm == EmotionGroupType.BIG_EMOTION) {
                if (this.gNc) {
                    if (cVar.bdn() != null) {
                        cVar.bdn().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.gMX.getChildCount() - 3));
                } else {
                    if (cVar.bdo() != null) {
                        cVar.bdo().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aSY();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bdm == EmotionGroupType.USER_COLLECT) {
                if (cVar.bdo() != null) {
                    cVar.bdo().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gMX.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bdm == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bdo() != null) {
                    cVar.bdo().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.gNe && (this.agt == 1 || this.agt == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gNd == null) {
                this.gNd = tbImageView;
                this.gNd.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.agt);
        }
        return tbImageView;
    }

    public void bNA() {
        this.gNb = new ImageView(getContext());
        this.gNb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gNb.setPadding(this.enW, this.enV, this.enW, this.enV);
        this.gNa = new LinearLayout(getContext());
        this.gNa.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.gNb.setLayoutParams(layoutParams);
        am.setImageResource(this.gNb, R.drawable.face_store, this.agt);
        this.gNa.addView(this.gNb);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.agt);
        this.gNa.addView(view);
        this.enX = new TextView(getContext());
        this.enX.setGravity(17);
        this.enX.setTextSize(10.0f);
        this.enX.setText("N");
        this.enX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.gMX.addView(this.gNa, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.gMX.setNewView(this.enX);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.gMX.setNewViewVisible(true);
        } else {
            this.gMX.setNewViewVisible(false);
        }
        this.gNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.enX != null) {
                    EmotionTabHorizonScrollView.this.gMX.setNewViewVisible(false);
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
        this.gMX.addView(this.enY);
        if (!appResponseToIntentClass) {
            this.gNa.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gNc = z;
        int i2 = i + 1;
        int childCount = this.gMX.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.gMY.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bdm() == EmotionGroupType.BIG_EMOTION || cVar.bdm() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.gMX.getChildAt(i2)).getChildAt(0);
                if (!this.gNc) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aSY();
                        }
                    });
                    if (cVar.bdo() != null) {
                        cVar.bdo().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bdn() != null) {
                    cVar.bdn().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.gMX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gMX.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).gNi;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.gNa.setVisibility(8);
        } else {
            this.gNa.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bdm() == EmotionGroupType.BIG_EMOTION || cVar.bdm() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.gMX.getChildAt(this.mCurrentIndex + 1);
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
            LinearLayout linearLayout2 = (LinearLayout) this.gMX.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gMY.get(this.mCurrentIndex);
            if (cVar.bdn() != null) {
                cVar.bdn().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.gNd = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gMX.removeAllViews();
        bNA();
        onChangeSkin(this.agt);
    }

    public void onChangeSkin(int i) {
        int color;
        this.agt = i;
        if (this.gNb != null) {
            am.setImageResource(this.gNb, R.drawable.face_store, i);
        }
        if (this.gNa != null) {
            am.setBackgroundResource(this.gNa, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.gNa.getChildCount() > 0) {
                am.setBackgroundColor(this.gNa.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.enY != null) {
            am.setBackgroundResource(this.enY, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.enX != null) {
            am.setBackgroundResource(this.enX, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.enX, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.gMX.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.gMX.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.gNg != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.gNg.setForegroundColor(color);
                    }
                    if (aVar.gNh != null) {
                        am.setBackgroundColor(aVar.gNh, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.gNd != null) {
            this.gNd.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.gNd.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gNd.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.gMZ = aVar;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.gNd) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.gNd != null) {
                    if (!EmotionTabHorizonScrollView.this.gNe) {
                        EmotionTabHorizonScrollView.this.gNd.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.gNd.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.gNd = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.gMZ.nr(this.mTabIndex);
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
        TbImageView gNg;
        View gNh;
        com.baidu.tbadk.editortools.emotiontool.c gNi;

        private a() {
        }
    }
}
