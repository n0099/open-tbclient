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
    private EditorTools abk;
    private int ajq;
    private LinearLayout.LayoutParams efB;
    private int fqV;
    private int fqW;
    private TextView fqX;
    private View fqY;
    private int from;
    private EmotionLinearLayout igV;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> igW;
    private EmotionTabWidgetView.a igX;
    private LinearLayout igY;
    private ImageView igZ;
    private boolean iha;
    private TbImageView ihb;
    private boolean ihc;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.iha = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.iha = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.iha = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.igV = new EmotionLinearLayout(getContext());
        this.igV.setOrientation(0);
        this.igV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.igV.setBaselineAligned(false);
        addView(this.igV);
        this.fqV = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fqW = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.efB = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.igV.setPadding(0, 0, 0, 0);
        cqx();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.ihc = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.igW = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.ihg = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.ihe = tbImageView;
        if (cVar.bzR() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.fqW, this.fqV, this.fqW, this.fqV);
            ImageView imageView = new ImageView(getContext());
            ap.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.ihf = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.igV.addView(relativeLayout, this.igV.getChildCount() - 1, this.efB);
            if (cVar.bzT() != null) {
                cVar.bzT().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.ihc && (this.ajq == 1 || this.ajq == 4)) {
                view.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ihb == null) {
                this.ihb = tbImageView;
                this.ihb.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajq);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.fqW, this.fqV, this.fqW, this.fqV);
            View view2 = new View(getContext());
            aVar.ihf = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.igV.addView(linearLayout, this.igV.getChildCount() - 1, this.efB);
            EmotionGroupType bzR = cVar.bzR();
            if (bzR == EmotionGroupType.LOCAL) {
                if (cVar.bzS() != null) {
                    cVar.bzS().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.igV.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (bzR == EmotionGroupType.PROMOTION) {
                if (cVar.bzT() != null) {
                    cVar.bzT().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (bzR == EmotionGroupType.BIG_EMOTION) {
                if (this.iha) {
                    if (cVar.bzS() != null) {
                        cVar.bzS().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.igV.getChildCount() - 3));
                } else {
                    if (cVar.bzT() != null) {
                        cVar.bzT().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bpi();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (bzR == EmotionGroupType.USER_COLLECT) {
                if (cVar.bzT() != null) {
                    cVar.bzT().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.igV.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (bzR == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.bzT() != null) {
                    cVar.bzT().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.ihc && (this.ajq == 1 || this.ajq == 4)) {
                view2.setBackgroundColor(ap.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(ap.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.ihb == null) {
                this.ihb = tbImageView;
                this.ihb.setForegroundColor(ap.getColor(R.color.common_color_10022));
            }
            ap.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ajq);
        }
        return tbImageView;
    }

    public void cqx() {
        this.igZ = new ImageView(getContext());
        this.igZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.igZ.setPadding(this.fqW, this.fqV, this.fqW, this.fqV);
        this.igY = new LinearLayout(getContext());
        this.igY.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.igZ.setLayoutParams(layoutParams);
        ap.setImageResource(this.igZ, R.drawable.face_store, this.ajq);
        this.igY.addView(this.igZ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        ap.setBackgroundColor(view, R.color.common_color_10288, this.ajq);
        this.igY.addView(view);
        this.fqX = new TextView(getContext());
        this.fqX.setGravity(17);
        this.fqX.setTextSize(10.0f);
        this.fqX.setText("N");
        this.fqX.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.igV.addView(this.igY, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.igV.setNewView(this.fqX);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.igV.setNewViewVisible(true);
        } else {
            this.igV.setNewViewVisible(false);
        }
        this.igY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.fqX != null) {
                    EmotionTabHorizonScrollView.this.igV.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.abk != null) {
                    EmotionTabHorizonScrollView.this.abk.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), R.string.neterror);
                }
            }
        });
        this.fqY = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.fqY.setLayoutParams(layoutParams3);
        this.igV.addView(this.fqY);
        if (!appResponseToIntentClass) {
            this.igY.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.iha = z;
        int i2 = i + 1;
        int childCount = this.igV.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.igW.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.bzR() == EmotionGroupType.BIG_EMOTION || cVar.bzR() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.igV.getChildAt(i2)).getChildAt(0);
                if (!this.iha) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).bpi();
                        }
                    });
                    if (cVar.bzT() != null) {
                        cVar.bzT().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.bzS() != null) {
                    cVar.bzS().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.igV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.igV.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).ihg;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.igY.setVisibility(8);
        } else {
            this.igY.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.bzR() == EmotionGroupType.BIG_EMOTION || cVar.bzR() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.igV.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ajq == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = ap.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.igV.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.igW.get(this.mCurrentIndex);
            if (cVar.bzS() != null) {
                cVar.bzS().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(ap.getColor(R.color.common_color_10022));
                this.ihb = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.igV.removeAllViews();
        cqx();
        onChangeSkin(this.ajq);
    }

    public void onChangeSkin(int i) {
        int color;
        this.ajq = i;
        if (this.igZ != null) {
            ap.setImageResource(this.igZ, R.drawable.face_store, i);
        }
        if (this.igY != null) {
            ap.setBackgroundResource(this.igY, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.igY.getChildCount() > 0) {
                ap.setBackgroundColor(this.igY.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.fqY != null) {
            ap.setBackgroundResource(this.fqY, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.fqX != null) {
            ap.setBackgroundResource(this.fqX, R.drawable.icon_news_head_prompt_one, i);
            ap.setViewTextColor(this.fqX, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.igV.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.igV.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.ihe != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = ap.getColor(R.color.common_color_10287);
                        }
                        aVar.ihe.setForegroundColor(color);
                    }
                    if (aVar.ihf != null) {
                        ap.setBackgroundColor(aVar.ihf, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.ihb != null) {
            this.ihb.setForegroundColor(ap.getColor(R.color.common_color_10022));
            if (this.ihb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ihb.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.igX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
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
            if (!EmotionTabHorizonScrollView.this.abk.rk(5).bzN() && (((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.igW.get(this.mTabIndex)).bzR() == EmotionGroupType.USER_COLLECT || ((com.baidu.tbadk.editortools.emotiontool.c) EmotionTabHorizonScrollView.this.igW.get(this.mTabIndex)).bzR() == EmotionGroupType.BIG_EMOTION)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921500, true));
                return;
            }
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.ihb) {
                ((TbImageView) view).setForegroundColor(ap.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.ihb != null) {
                    if (!EmotionTabHorizonScrollView.this.ihc) {
                        EmotionTabHorizonScrollView.this.ihb.setForegroundColor(ap.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.ihb.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.ihb = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.igX.ry(this.mTabIndex);
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
        TbImageView ihe;
        View ihf;
        com.baidu.tbadk.editortools.emotiontool.c ihg;

        private a() {
        }
    }
}
