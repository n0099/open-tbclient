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
    private EditorTools Zd;
    private int afW;
    private LinearLayout.LayoutParams cXz;
    private int dZK;
    private int dZL;
    private TextView dZM;
    private View dZN;
    private int from;
    private EmotionLinearLayout gyc;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gyd;
    private EmotionTabWidgetView.a gye;
    private LinearLayout gyf;
    private ImageView gyg;
    private boolean gyh;
    private TbImageView gyi;
    private boolean gyj;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.gyh = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.gyh = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.gyh = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.gyc = new EmotionLinearLayout(getContext());
        this.gyc.setOrientation(0);
        this.gyc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gyc.setBaselineAligned(false);
        addView(this.gyc);
        this.dZK = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dZL = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cXz = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.gyc.setPadding(0, 0, 0, 0);
        bHe();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.gyj = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gyd = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.gyn = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.gyl = tbImageView;
        if (cVar.aXc() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.dZL, this.dZK, this.dZL, this.dZK);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.gym = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.gyc.addView(relativeLayout, this.gyc.getChildCount() - 1, this.cXz);
            if (cVar.aXe() != null) {
                cVar.aXe().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.gyj && (this.afW == 1 || this.afW == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gyi == null) {
                this.gyi = tbImageView;
                this.gyi.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.afW);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.dZL, this.dZK, this.dZL, this.dZK);
            View view2 = new View(getContext());
            aVar.gym = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.gyc.addView(linearLayout, this.gyc.getChildCount() - 1, this.cXz);
            EmotionGroupType aXc = cVar.aXc();
            if (aXc == EmotionGroupType.LOCAL) {
                if (cVar.aXd() != null) {
                    cVar.aXd().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gyc.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aXc == EmotionGroupType.PROMOTION) {
                if (cVar.aXe() != null) {
                    cVar.aXe().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aXc == EmotionGroupType.BIG_EMOTION) {
                if (this.gyh) {
                    if (cVar.aXd() != null) {
                        cVar.aXd().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.gyc.getChildCount() - 3));
                } else {
                    if (cVar.aXe() != null) {
                        cVar.aXe().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aMX();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aXc == EmotionGroupType.USER_COLLECT) {
                if (cVar.aXe() != null) {
                    cVar.aXe().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gyc.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aXc == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aXe() != null) {
                    cVar.aXe().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.gyj && (this.afW == 1 || this.afW == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gyi == null) {
                this.gyi = tbImageView;
                this.gyi.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.afW);
        }
        return tbImageView;
    }

    public void bHe() {
        this.gyg = new ImageView(getContext());
        this.gyg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gyg.setPadding(this.dZL, this.dZK, this.dZL, this.dZK);
        this.gyf = new LinearLayout(getContext());
        this.gyf.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.gyg.setLayoutParams(layoutParams);
        am.setImageResource(this.gyg, R.drawable.face_store, this.afW);
        this.gyf.addView(this.gyg);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.afW);
        this.gyf.addView(view);
        this.dZM = new TextView(getContext());
        this.dZM.setGravity(17);
        this.dZM.setTextSize(10.0f);
        this.dZM.setText("N");
        this.dZM.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.gyc.addView(this.gyf, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.gyc.setNewView(this.dZM);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.gyc.setNewViewVisible(true);
        } else {
            this.gyc.setNewViewVisible(false);
        }
        this.gyf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.dZM != null) {
                    EmotionTabHorizonScrollView.this.gyc.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Zd != null) {
                    EmotionTabHorizonScrollView.this.Zd.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.dZN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.dZN.setLayoutParams(layoutParams3);
        this.gyc.addView(this.dZN);
        if (!appResponseToIntentClass) {
            this.gyf.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gyh = z;
        int i2 = i + 1;
        int childCount = this.gyc.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.gyd.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aXc() == EmotionGroupType.BIG_EMOTION || cVar.aXc() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.gyc.getChildAt(i2)).getChildAt(0);
                if (!this.gyh) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aMX();
                        }
                    });
                    if (cVar.aXe() != null) {
                        cVar.aXe().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aXd() != null) {
                    cVar.aXd().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.gyc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gyc.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).gyn;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.gyf.setVisibility(8);
        } else {
            this.gyf.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aXc() == EmotionGroupType.BIG_EMOTION || cVar.aXc() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.gyc.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.afW == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.gyc.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gyd.get(this.mCurrentIndex);
            if (cVar.aXd() != null) {
                cVar.aXd().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.gyi = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gyc.removeAllViews();
        bHe();
        onChangeSkin(this.afW);
    }

    public void onChangeSkin(int i) {
        int color;
        this.afW = i;
        if (this.gyg != null) {
            am.setImageResource(this.gyg, R.drawable.face_store, i);
        }
        if (this.gyf != null) {
            am.setBackgroundResource(this.gyf, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.gyf.getChildCount() > 0) {
                am.setBackgroundColor(this.gyf.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.dZN != null) {
            am.setBackgroundResource(this.dZN, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.dZM != null) {
            am.setBackgroundResource(this.dZM, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.dZM, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.gyc.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.gyc.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.gyl != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.gyl.setForegroundColor(color);
                    }
                    if (aVar.gym != null) {
                        am.setBackgroundColor(aVar.gym, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.gyi != null) {
            this.gyi.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.gyi.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gyi.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.gye = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.gyi) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.gyi != null) {
                    if (!EmotionTabHorizonScrollView.this.gyj) {
                        EmotionTabHorizonScrollView.this.gyi.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.gyi.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.gyi = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.gye.mN(this.mTabIndex);
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
        TbImageView gyl;
        View gym;
        com.baidu.tbadk.editortools.emotiontool.c gyn;

        private a() {
        }
    }
}
