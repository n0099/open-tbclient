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
    private EditorTools TT;
    private LinearLayout.LayoutParams bqN;
    private int bqk;
    private int ceL;
    private int cvZ;
    private int cwa;
    private TextView cwb;
    private View cwc;
    private EmotionLinearLayout eWj;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> eWk;
    private EmotionTabWidgetView.a eWl;
    private LinearLayout eWm;
    private ImageView eWn;
    private boolean eWo;
    private TbImageView eWp;
    private boolean eWq;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqk = -1;
        this.eWo = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqk = -1;
        this.eWo = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.bqk = -1;
        this.eWo = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eWj = new EmotionLinearLayout(getContext());
        this.eWj.setOrientation(0);
        this.eWj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eWj.setBaselineAligned(false);
        addView(this.eWj);
        this.cvZ = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.cwa = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.bqN = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds122), -1);
        this.eWj.setPadding(0, 0, 0, 0);
        bfs();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.eWq = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.eWk = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.eWu = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.eWs = tbImageView;
        if (cVar.asC() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.cwa, this.cvZ, this.cwa, this.cvZ);
            ImageView imageView = new ImageView(getContext());
            am.c(imageView, (int) R.drawable.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.g(getContext(), R.dimen.ds12), l.g(getContext(), R.dimen.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.eWt = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.eWj.addView(relativeLayout, this.eWj.getChildCount() - 1, this.bqN);
            if (cVar.asE() != null) {
                cVar.asE().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.eWq && (this.ceL == 1 || this.ceL == 4)) {
                view.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eWp == null) {
                this.eWp = tbImageView;
                this.eWp.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.g(relativeLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ceL);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.cwa, this.cvZ, this.cwa, this.cvZ);
            View view2 = new View(getContext());
            aVar.eWt = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.eWj.addView(linearLayout, this.eWj.getChildCount() - 1, this.bqN);
            EmotionGroupType asC = cVar.asC();
            if (asC == EmotionGroupType.LOCAL) {
                if (cVar.asD() != null) {
                    cVar.asD().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eWj.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.local_emotion));
            } else if (asC == EmotionGroupType.PROMOTION) {
                if (cVar.asE() != null) {
                    cVar.asE().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_promotion_emotion) + cVar.getGroupId());
            } else if (asC == EmotionGroupType.BIG_EMOTION) {
                if (this.eWo) {
                    if (cVar.asD() != null) {
                        cVar.asD().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.eWj.getChildCount() - 3));
                } else {
                    if (cVar.asE() != null) {
                        cVar.asE().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).agW();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (asC == EmotionGroupType.USER_COLLECT) {
                if (cVar.asE() != null) {
                    cVar.asE().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.eWj.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (asC == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.asE() != null) {
                    cVar.asE().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.eWq && (this.ceL == 1 || this.ceL == 4)) {
                view2.setBackgroundColor(am.getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(am.getColor(R.color.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(R.color.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(R.color.common_color_10287));
            }
            if (this.eWp == null) {
                this.eWp = tbImageView;
                this.eWp.setForegroundColor(am.getColor(R.color.common_color_10022));
            }
            am.g(linearLayout, R.drawable.bg_emotion_tab_horizonscrollview, this.ceL);
        }
        return tbImageView;
    }

    public void bfs() {
        this.eWn = new ImageView(getContext());
        this.eWn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.eWn.setPadding(this.cwa, this.cvZ, this.cwa, this.cvZ);
        this.eWm = new LinearLayout(getContext());
        this.eWm.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eWn.setLayoutParams(layoutParams);
        am.b(this.eWn, (int) R.drawable.face_store, this.ceL);
        this.eWm.addView(this.eWn);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        am.h(view, R.color.common_color_10288, this.ceL);
        this.eWm.addView(view);
        this.cwb = new TextView(getContext());
        this.cwb.setGravity(17);
        this.cwb.setTextSize(10.0f);
        this.cwb.setText("N");
        this.cwb.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.eWj.addView(this.eWm, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1));
        this.eWj.setNewView(this.cwb);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.eWj.setNewViewVisible(true);
        } else {
            this.eWj.setNewViewVisible(false);
        }
        this.eWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.cwb != null) {
                    EmotionTabHorizonScrollView.this.eWj.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.TT != null) {
                    EmotionTabHorizonScrollView.this.TT.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.kc()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), (int) R.string.neterror);
                }
            }
        });
        this.cwc = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.cwc.setLayoutParams(layoutParams3);
        this.eWj.addView(this.cwc);
        if (!appResponseToIntentClass) {
            this.eWm.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void setTabWidgetVisibility(int i, boolean z) {
        this.eWo = z;
        int i2 = i + 1;
        int childCount = this.eWj.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.eWk.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.asC() == EmotionGroupType.BIG_EMOTION || cVar.asC() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.eWj.getChildAt(i2)).getChildAt(0);
                if (!this.eWo) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.b(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(R.string.emotion_cant_show)).agW();
                        }
                    });
                    if (cVar.asE() != null) {
                        cVar.asE().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.asD() != null) {
                    cVar.asD().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.eWj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.eWj.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).eWu;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.eWm.setVisibility(8);
        } else {
            this.eWm.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.asC() == EmotionGroupType.BIG_EMOTION || cVar.asC() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.bqk) {
            if (this.bqk != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eWj.getChildAt(this.bqk + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.ceL == 0) {
                        color = getResources().getColor(R.color.common_color_10287);
                    } else {
                        color = am.getColor(R.color.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.bqk = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eWj.getChildAt(this.bqk + 1);
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
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.eWk.get(this.bqk);
            if (cVar.asD() != null) {
                cVar.asD().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(am.getColor(R.color.common_color_10022));
                this.eWp = tbImageView2;
            }
        }
    }

    public void reset() {
        this.bqk = -1;
        this.eWj.removeAllViews();
        bfs();
        jg(this.ceL);
    }

    public void jg(int i) {
        int color;
        this.ceL = i;
        if (this.eWn != null) {
            am.b(this.eWn, (int) R.drawable.face_store, i);
        }
        if (this.eWm != null) {
            am.g(this.eWm, R.drawable.bg_emotion_tab_horizonscrollview, i);
            if (this.eWm.getChildCount() > 0) {
                am.h(this.eWm.getChildAt(1), R.color.common_color_10288, i);
            }
        }
        if (this.cwc != null) {
            am.g(this.cwc, R.drawable.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.cwb != null) {
            am.g(this.cwb, R.drawable.icon_news_head_prompt_one, i);
            am.d(this.cwb, R.color.cp_cont_a, 1, i);
        }
        int childCount = this.eWj.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.eWj.getChildAt(i2);
            if (childAt != null) {
                am.g(childAt, R.drawable.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.eWs != null) {
                        if (i == 0) {
                            color = getResources().getColor(R.color.common_color_10287);
                        } else {
                            color = am.getColor(R.color.common_color_10287);
                        }
                        aVar.eWs.setForegroundColor(color);
                    }
                    if (aVar.eWt != null) {
                        am.h(aVar.eWt, R.color.common_color_10288, i);
                    }
                }
            }
        }
        if (this.eWp != null) {
            this.eWp.setForegroundColor(am.getColor(R.color.common_color_10022));
            if (this.eWp.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eWp.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.eWl = aVar;
    }

    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private final int bRM;

        private b(int i) {
            this.bRM = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.eWp) {
                ((TbImageView) view).setForegroundColor(am.getColor(R.color.common_color_10022));
                if (EmotionTabHorizonScrollView.this.eWp != null) {
                    if (!EmotionTabHorizonScrollView.this.eWq) {
                        EmotionTabHorizonScrollView.this.eWp.setForegroundColor(am.getColor(R.color.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.eWp.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(R.color.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.eWp = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.bRM);
            EmotionTabHorizonScrollView.this.eWl.kE(this.bRM);
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
            if (com.baidu.adp.lib.g.b.f(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.f(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        TbImageView eWs;
        View eWt;
        com.baidu.tbadk.editortools.emotiontool.c eWu;

        private a() {
        }
    }
}
