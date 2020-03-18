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
    private EditorTools FO;
    private int Nj;
    private LinearLayout.LayoutParams cyx;
    private View dAa;
    private int dzX;
    private int dzY;
    private TextView dzZ;
    private EmotionLinearLayout fTo;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> fTp;
    private EmotionTabWidgetView.a fTq;
    private LinearLayout fTr;
    private ImageView fTs;
    private boolean fTt;
    private TbImageView fTu;
    private boolean fTv;
    private int from;
    private int mCurrentIndex;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        this.fTt = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        this.fTt = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.fTt = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.fTo = new EmotionLinearLayout(getContext());
        this.fTo.setOrientation(0);
        this.fTo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fTo.setBaselineAligned(false);
        addView(this.fTo);
        this.dzX = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dzY = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.cyx = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.fTo.setPadding(0, 0, 0, 0);
        bxu();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.fTv = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.fTp = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.fTz = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.fTx = tbImageView;
        if (cVar.aON() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.dzY, this.dzX, this.dzY, this.dzX);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.fTy = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.fTo.addView(relativeLayout, this.fTo.getChildCount() - 1, this.cyx);
            if (cVar.aOP() != null) {
                cVar.aOP().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.fTv && (this.Nj == 1 || this.Nj == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fTu == null) {
                this.fTu = tbImageView;
                this.fTu.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.Nj);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.dzY, this.dzX, this.dzY, this.dzX);
            View view2 = new View(getContext());
            aVar.fTy = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.fTo.addView(linearLayout, this.fTo.getChildCount() - 1, this.cyx);
            EmotionGroupType aON = cVar.aON();
            if (aON == EmotionGroupType.LOCAL) {
                if (cVar.aOO() != null) {
                    cVar.aOO().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fTo.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (aON == EmotionGroupType.PROMOTION) {
                if (cVar.aOP() != null) {
                    cVar.aOP().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (aON == EmotionGroupType.BIG_EMOTION) {
                if (this.fTt) {
                    if (cVar.aOO() != null) {
                        cVar.aOO().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.fTo.getChildCount() - 3));
                } else {
                    if (cVar.aOP() != null) {
                        cVar.aOP().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aEL();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (aON == EmotionGroupType.USER_COLLECT) {
                if (cVar.aOP() != null) {
                    cVar.aOP().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.fTo.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (aON == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.aOP() != null) {
                    cVar.aOP().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.fTv && (this.Nj == 1 || this.Nj == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.fTu == null) {
                this.fTu = tbImageView;
                this.fTu.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.Nj);
        }
        return tbImageView;
    }

    public void bxu() {
        this.fTs = new ImageView(getContext());
        this.fTs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.fTs.setPadding(this.dzY, this.dzX, this.dzY, this.dzX);
        this.fTr = new LinearLayout(getContext());
        this.fTr.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fTs.setLayoutParams(layoutParams);
        am.setImageResource(this.fTs, R.drawable.face_store, this.Nj);
        this.fTr.addView(this.fTs);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.Nj);
        this.fTr.addView(view);
        this.dzZ = new TextView(getContext());
        this.dzZ.setGravity(17);
        this.dzZ.setTextSize(10.0f);
        this.dzZ.setText("N");
        this.dzZ.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.fTo.addView(this.fTr, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.fTo.setNewView(this.dzZ);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.fTo.setNewViewVisible(true);
        } else {
            this.fTo.setNewViewVisible(false);
        }
        this.fTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.dzZ != null) {
                    EmotionTabHorizonScrollView.this.fTo.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.FO != null) {
                    EmotionTabHorizonScrollView.this.FO.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.dAa = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.dAa.setLayoutParams(layoutParams3);
        this.fTo.addView(this.dAa);
        if (!appResponseToIntentClass) {
            this.fTr.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.fTt = z;
        int i2 = i + 1;
        int childCount = this.fTo.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.fTp.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.aON() == EmotionGroupType.BIG_EMOTION || cVar.aON() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.fTo.getChildAt(i2)).getChildAt(0);
                if (!this.fTt) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).aEL();
                        }
                    });
                    if (cVar.aOP() != null) {
                        cVar.aOP().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aOO() != null) {
                    cVar.aOO().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.fTo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.fTo.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).fTz;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.fTr.setVisibility(8);
        } else {
            this.fTr.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.aON() == EmotionGroupType.BIG_EMOTION || cVar.aON() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fTo.getChildAt(this.mCurrentIndex + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.Nj == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fTo.getChildAt(this.mCurrentIndex + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.fTp.get(this.mCurrentIndex);
            if (cVar.aOO() != null) {
                cVar.aOO().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.fTu = tbImageView2;
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fTo.removeAllViews();
        bxu();
        onChangeSkin(this.Nj);
    }

    public void onChangeSkin(int i) {
        int color;
        this.Nj = i;
        if (this.fTs != null) {
            am.setImageResource(this.fTs, R.drawable.face_store, i);
        }
        if (this.fTr != null) {
            am.setBackgroundResource(this.fTr, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.fTr.getChildCount() > 0) {
                am.setBackgroundColor(this.fTr.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.dAa != null) {
            am.setBackgroundResource(this.dAa, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.dzZ != null) {
            am.setBackgroundResource(this.dzZ, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.dzZ, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.fTo.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.fTo.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.fTx != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.fTx.setForegroundColor(color);
                    }
                    if (aVar.fTy != null) {
                        am.setBackgroundColor(aVar.fTy, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.fTu != null) {
            this.fTu.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.fTu.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fTu.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.fTq = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
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
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.fTu) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.fTu != null) {
                    if (!EmotionTabHorizonScrollView.this.fTv) {
                        EmotionTabHorizonScrollView.this.fTu.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.fTu.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.fTu = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.fTq.mC(this.mTabIndex);
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
        TbImageView fTx;
        View fTy;
        com.baidu.tbadk.editortools.emotiontool.c fTz;

        private a() {
        }
    }
}
