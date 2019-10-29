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
/* loaded from: classes2.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private EditorTools Dl;
    private int apR;
    private LinearLayout.LayoutParams bJy;
    private int cIi;
    private int cIj;
    private TextView cIk;
    private View cIl;
    private int csX;
    private EmotionLinearLayout eYV;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eYW;
    private EmotionTabWidgetView.a eYX;
    private LinearLayout eYY;
    private ImageView eYZ;
    private boolean eZa;
    private TbImageView eZb;
    private boolean eZc;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apR = -1;
        this.eZa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apR = -1;
        this.eZa = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.apR = -1;
        this.eZa = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eYV = new EmotionLinearLayout(getContext());
        this.eYV.setOrientation(0);
        this.eYV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eYV.setBaselineAligned(false);
        addView(this.eYV);
        this.cIi = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cIj = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bJy = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.eYV.setPadding(0, 0, 0, 0);
        bdm();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.eZc = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eYW = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eZg = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eZe = tbImageView;
        if (cVar.auo() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.cIj, this.cIi, this.cIj, this.cIi);
            ImageView imageView = new ImageView(getContext());
            am.setImageResource(imageView, R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.getDimens(getContext(), R.dimen.ds12), l.getDimens(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eZf = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.eYV.addView(relativeLayout, this.eYV.getChildCount() - 1, this.bJy);
            if (cVar.auq() != null) {
                cVar.auq().drawImageTo(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.eZc && (this.csX == 1 || this.csX == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eZb == null) {
                this.eZb = tbImageView;
                this.eZb.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.csX);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.cIj, this.cIi, this.cIj, this.cIi);
            View view2 = new View(getContext());
            aVar.eZf = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.eYV.addView(linearLayout, this.eYV.getChildCount() - 1, this.bJy);
            EmotionGroupType auo = cVar.auo();
            if (auo == EmotionGroupType.LOCAL) {
                if (cVar.aup() != null) {
                    cVar.aup().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eYV.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (auo == EmotionGroupType.PROMOTION) {
                if (cVar.auq() != null) {
                    cVar.auq().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (auo == EmotionGroupType.BIG_EMOTION) {
                if (this.eZa) {
                    if (cVar.aup() != null) {
                        cVar.aup().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.eYV.getChildCount() - 3));
                } else {
                    if (cVar.auq() != null) {
                        cVar.auq().drawImageTo(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).akT();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (auo == EmotionGroupType.USER_COLLECT) {
                if (cVar.auq() != null) {
                    cVar.auq().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eYV.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (auo == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.auq() != null) {
                    cVar.auq().drawImageTo(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.eZc && (this.csX == 1 || this.csX == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eZb == null) {
                this.eZb = tbImageView;
                this.eZb.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.setBackgroundResource(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.csX);
        }
        return tbImageView;
    }

    public void bdm() {
        this.eYZ = new ImageView(getContext());
        this.eYZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eYZ.setPadding(this.cIj, this.cIi, this.cIj, this.cIi);
        this.eYY = new LinearLayout(getContext());
        this.eYY.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eYZ.setLayoutParams(layoutParams);
        am.setImageResource(this.eYZ, R.drawable.face_store, this.csX);
        this.eYY.addView(this.eYZ);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.setBackgroundColor(view, R.color.common_color_10288, this.csX);
        this.eYY.addView(view);
        this.cIk = new TextView(getContext());
        this.cIk.setGravity(17);
        this.cIk.setTextSize(10.0f);
        this.cIk.setText("N");
        this.cIk.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.eYV.addView(this.eYY, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.eYV.setNewView(this.cIk);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.eYV.setNewViewVisible(true);
        } else {
            this.eYV.setNewViewVisible(false);
        }
        this.eYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.cIk != null) {
                    EmotionTabHorizonScrollView.this.eYV.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.Dl != null) {
                    EmotionTabHorizonScrollView.this.Dl.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.isNetWorkAvailable()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.cIl = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.cIl.setLayoutParams(layoutParams3);
        this.eYV.addView(this.cIl);
        if (!appResponseToIntentClass) {
            this.eYY.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eZa = z;
        int i2 = i + 1;
        int childCount = this.eYV.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.eYW.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.auo() == EmotionGroupType.BIG_EMOTION || cVar.auo() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.eYV.getChildAt(i2)).getChildAt(0);
                if (!this.eZa) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).akT();
                        }
                    });
                    if (cVar.auq() != null) {
                        cVar.auq().drawImageTo(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.aup() != null) {
                    cVar.aup().drawImageTo(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.eYV.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eYV.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eZg;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.eYY.setVisibility(8);
        } else {
            this.eYY.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.auo() == EmotionGroupType.BIG_EMOTION || cVar.auo() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.apR) {
            if (this.apR != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eYV.getChildAt(this.apR + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.csX == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.apR = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eYV.getChildAt(this.apR + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eYW.get(this.apR);
            if (cVar.aup() != null) {
                cVar.aup().drawImageTo(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.eZb = tbImageView2;
            }
        }
    }

    public void reset() {
        this.apR = -1;
        this.eYV.removeAllViews();
        bdm();
        onChangeSkin(this.csX);
    }

    public void onChangeSkin(int i) {
        int color;
        this.csX = i;
        if (this.eYZ != null) {
            am.setImageResource(this.eYZ, R.drawable.face_store, i);
        }
        if (this.eYY != null) {
            am.setBackgroundResource(this.eYY, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.eYY.getChildCount() > 0) {
                am.setBackgroundColor(this.eYY.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.cIl != null) {
            am.setBackgroundResource(this.cIl, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.cIk != null) {
            am.setBackgroundResource(this.cIk, R.drawable.icon_news_head_prompt_one, i);
            am.setViewTextColor(this.cIk, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.eYV.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.eYV.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eZe != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.eZe.setForegroundColor(color);
                    }
                    if (aVar.eZf != null) {
                        am.setBackgroundColor(aVar.eZf, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.eZb != null) {
            this.eZb.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.eZb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eZb.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.eYX = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int mTabIndex;

        private b(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.eZb) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.eZb != null) {
                    if (!EmotionTabHorizonScrollView.this.eZc) {
                        EmotionTabHorizonScrollView.this.eZb.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.eZb.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.eZb = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.mTabIndex);
            EmotionTabHorizonScrollView.this.eYX.jW(this.mTabIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.toInt(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.toInt(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        TbImageView eZe;
        View eZf;
        com.baidu.tbadk.editortools.emotiontool.c eZg;

        private a() {
        }
    }
}
