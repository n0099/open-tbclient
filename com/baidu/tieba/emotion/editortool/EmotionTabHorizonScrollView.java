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
    private EditorTools Za;
    private int afT;
    private LinearLayout.LayoutParams cXu;
    private int dZF;
    private int dZG;
    private TextView dZH;
    private View dZI;
    private int from;
    private EmotionLinearLayout gxW;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> gxX;
    private EmotionTabWidgetView.a gxY;
    private LinearLayout gxZ;
    private ImageView gya;
    private boolean gyb;
    private TbImageView gyc;
    private boolean gyd;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.gyb = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.gyb = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.gyb = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.gxW = new EmotionLinearLayout(getContext());
        this.gxW.setOrientation(0);
        this.gxW.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gxW.setBaselineAligned(false);
        addView(this.gxW);
        this.dZF = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dZG = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cXu = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.gxW.setPadding(0, 0, 0, 0);
        bHg();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.gyd = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.gxX = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.gyh = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.gyf = tbImageView;
        if (cVar.aXe() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.dZG, this.dZF, this.dZG, this.dZF);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.gyg = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.gxW.addView(relativeLayout, this.gxW.getChildCount() - 1, this.cXu);
            if (cVar.aXg() != null) {
                cVar.aXg().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.gyd && (this.afT == 1 || this.afT == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gyc == null) {
                this.gyc = tbImageView;
                this.gyc.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.afT);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.dZG, this.dZF, this.dZG, this.dZF);
            View view2 = new View(getContext());
            aVar.gyg = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.gxW.addView(linearLayout, this.gxW.getChildCount() - 1, this.cXu);
            EmotionGroupType aXe = cVar.aXe();
            if (aXe == EmotionGroupType.LOCAL) {
                if (cVar.aXf() != null) {
                    cVar.aXf().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gxW.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aXe == EmotionGroupType.PROMOTION) {
                if (cVar.aXg() != null) {
                    cVar.aXg().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aXe == EmotionGroupType.BIG_EMOTION) {
                if (this.gyb) {
                    if (cVar.aXf() != null) {
                        cVar.aXf().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.gxW.getChildCount() - 3));
                } else {
                    if (cVar.aXg() != null) {
                        cVar.aXg().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aMZ();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aXe == EmotionGroupType.USER_COLLECT) {
                if (cVar.aXg() != null) {
                    cVar.aXg().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.gxW.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aXe == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aXg() != null) {
                    cVar.aXg().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.gyd && (this.afT == 1 || this.afT == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.gyc == null) {
                this.gyc = tbImageView;
                this.gyc.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.afT);
        }
        return tbImageView;
    }

    public void bHg() {
        this.gya = new ImageView(getContext());
        this.gya.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.gya.setPadding(this.dZG, this.dZF, this.dZG, this.dZF);
        this.gxZ = new LinearLayout(getContext());
        this.gxZ.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.gya.setLayoutParams(layoutParams);
        am.setImageResource(this.gya, R.drawable.face_store, this.afT);
        this.gxZ.addView(this.gya);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.afT);
        this.gxZ.addView(view);
        this.dZH = new TextView(getContext());
        this.dZH.setGravity(17);
        this.dZH.setTextSize(10.0f);
        this.dZH.setText("N");
        this.dZH.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.gxW.addView(this.gxZ, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.gxW.setNewView(this.dZH);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.gxW.setNewViewVisible(true);
        } else {
            this.gxW.setNewViewVisible(false);
        }
        this.gxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.dZH != null) {
                    EmotionTabHorizonScrollView.this.gxW.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Za != null) {
                    EmotionTabHorizonScrollView.this.Za.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.dZI = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.dZI.setLayoutParams(layoutParams3);
        this.gxW.addView(this.dZI);
        if (!appResponseToIntentClass) {
            this.gxZ.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.gyb = z;
        int i2 = i + 1;
        int childCount = this.gxW.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.gxX.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aXe() == EmotionGroupType.BIG_EMOTION || cVar.aXe() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.gxW.getChildAt(i2)).getChildAt(0);
                if (!this.gyb) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aMZ();
                        }
                    });
                    if (cVar.aXg() != null) {
                        cVar.aXg().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aXf() != null) {
                    cVar.aXf().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.gxW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.gxW.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).gyh;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.gxZ.setVisibility(8);
        } else {
            this.gxZ.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aXe() == EmotionGroupType.BIG_EMOTION || cVar.aXe() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.gxW.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.afT == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.gxW.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.gxX.get(this.mCurrentIndex);
            if (cVar.aXf() != null) {
                cVar.aXf().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.gyc = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.gxW.removeAllViews();
        bHg();
        onChangeSkin(this.afT);
    }

    public void onChangeSkin(int i) {
        int color;
        this.afT = i;
        if (this.gya != null) {
            am.setImageResource(this.gya, R.drawable.face_store, i);
        }
        if (this.gxZ != null) {
            am.setBackgroundResource(this.gxZ, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.gxZ.getChildCount() > 0) {
                am.setBackgroundColor(this.gxZ.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.dZI != null) {
            am.setBackgroundResource(this.dZI, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.dZH != null) {
            am.setBackgroundResource(this.dZH, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.dZH, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.gxW.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.gxW.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.gyf != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.gyf.setForegroundColor(color);
                    }
                    if (aVar.gyg != null) {
                        am.setBackgroundColor(aVar.gyg, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.gyc != null) {
            this.gyc.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.gyc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gyc.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.gxY = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.gyc) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.gyc != null) {
                    if (!EmotionTabHorizonScrollView.this.gyd) {
                        EmotionTabHorizonScrollView.this.gyc.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.gyc.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.gyc = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.gxY.mN(this.mTabIndex);
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
        TbImageView gyf;
        View gyg;
        com.baidu.tbadk.editortools.emotiontool.c gyh;

        private a() {
        }
    }
}
