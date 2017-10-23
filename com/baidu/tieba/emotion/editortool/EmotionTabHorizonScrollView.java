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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class EmotionTabHorizonScrollView extends HorizontalCustomScrollView {
    private i JH;
    private int aDt;
    private LinearLayout.LayoutParams aDv;
    private int aDw;
    private int aDx;
    private TextView aDy;
    private View aDz;
    private int aoN;
    private com.baidu.tieba.emotion.editortool.a cbd;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> cbe;
    private EmotionTabWidgetView.a cbf;
    private LinearLayout cbg;
    private ImageView cbh;
    private boolean cbi;
    private TbImageView cbj;
    private boolean cbk;
    private int from;

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDt = -1;
        this.cbi = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDt = -1;
        this.cbi = true;
        init();
    }

    public EmotionTabHorizonScrollView(Context context) {
        super(context);
        this.aDt = -1;
        this.cbi = true;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.cbd = new com.baidu.tieba.emotion.editortool.a(getContext());
        this.cbd.setOrientation(0);
        this.cbd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.cbd.setBaselineAligned(false);
        addView(this.cbd);
        this.aDw = getResources().getDimensionPixelSize(d.f.ds8);
        this.aDx = getResources().getDimensionPixelSize(d.f.ds10);
        this.aDv = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds122), -1);
        this.cbd.setPadding(0, 0, 0, 0);
        ach();
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void setIsInChat(boolean z) {
        this.cbk = z;
    }

    public void setDatas(ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList) {
        this.cbe = arrayList;
    }

    private TbImageView b(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        TbImageView tbImageView = new TbImageView(getContext());
        a aVar = new a();
        aVar.cbo = cVar;
        tbImageView.setAutoChangeStyle(false);
        aVar.cbm = tbImageView;
        if (cVar.CI() == EmotionGroupType.SINGLE_FORUM) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            tbImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(tbImageView);
            tbImageView.setPadding(this.aDx, this.aDw, this.aDx, this.aDw);
            ImageView imageView = new ImageView(getContext());
            aj.c(imageView, d.g.icon_emotion_recommend);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, l.f(getContext(), d.f.ds12), l.f(getContext(), d.f.ds10));
            relativeLayout.addView(imageView, layoutParams);
            View view = new View(getContext());
            aVar.cbn = view;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams2.addRule(11);
            relativeLayout.addView(view, layoutParams2);
            relativeLayout.setClickable(true);
            relativeLayout.setFocusable(true);
            relativeLayout.setTag(aVar);
            this.cbd.addView(relativeLayout, this.cbd.getChildCount() - 1, this.aDv);
            if (cVar.CK() != null) {
                cVar.CK().a(tbImageView);
            }
            tbImageView.setOnClickListener(new c(cVar.getGroupId()));
            tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            if (!this.cbk && this.aoN == 1) {
                view.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.cbj == null) {
                this.cbj = tbImageView;
                this.cbj.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(relativeLayout, d.g.bg_emotion_tab_horizonscrollview, this.aoN);
        } else {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
            layoutParams3.weight = 1.0f;
            tbImageView.setLayoutParams(layoutParams3);
            linearLayout.addView(tbImageView);
            tbImageView.setPadding(this.aDx, this.aDw, this.aDx, this.aDw);
            View view2 = new View(getContext());
            aVar.cbn = view2;
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
            layoutParams4.gravity = 5;
            layoutParams4.weight = 0.0f;
            linearLayout.addView(view2, layoutParams4);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            linearLayout.setTag(aVar);
            this.cbd.addView(linearLayout, this.cbd.getChildCount() - 1, this.aDv);
            EmotionGroupType CI = cVar.CI();
            if (CI == EmotionGroupType.LOCAL) {
                if (cVar.CJ() != null) {
                    cVar.CJ().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cbd.getChildCount() - 3));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.local_emotion));
            } else if (CI == EmotionGroupType.PROMOTION) {
                if (cVar.CK() != null) {
                    cVar.CK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_promotion_emotion) + cVar.getGroupId());
            } else if (CI == EmotionGroupType.BIG_EMOTION) {
                if (this.cbi) {
                    if (cVar.CJ() != null) {
                        cVar.CJ().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new b(this.cbd.getChildCount() - 3));
                } else {
                    if (cVar.CK() != null) {
                        cVar.CK().a(tbImageView);
                    }
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view3) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tj();
                        }
                    });
                }
                tbImageView.setContentDescription(cVar.getGroupName());
            } else if (CI == EmotionGroupType.USER_COLLECT) {
                if (cVar.CK() != null) {
                    cVar.CK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new b(this.cbd.getChildCount() - 3));
                tbImageView.setContentDescription("");
            } else if (CI == EmotionGroupType.SINGLE_FORUM) {
                if (cVar.CK() != null) {
                    cVar.CK().a(tbImageView);
                }
                tbImageView.setOnClickListener(new c(cVar.getGroupId()));
                tbImageView.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.download_single_forum_emotion) + cVar.getGroupId());
            }
            if (!this.cbk && this.aoN == 1) {
                view2.setBackgroundColor(aj.getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(aj.getColor(d.e.common_color_10287));
            } else {
                view2.setBackgroundColor(getResources().getColor(d.e.common_color_10288));
                tbImageView.setForegroundColor(getResources().getColor(d.e.common_color_10287));
            }
            if (this.cbj == null) {
                this.cbj = tbImageView;
                this.cbj.setForegroundColor(aj.getColor(d.e.common_color_10022));
            }
            aj.d(linearLayout, d.g.bg_emotion_tab_horizonscrollview, this.aoN);
        }
        return tbImageView;
    }

    public void ach() {
        this.cbh = new ImageView(getContext());
        this.cbh.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.cbh.setPadding(this.aDx, this.aDw, this.aDx, this.aDw);
        this.cbg = new LinearLayout(getContext());
        this.cbg.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(d.l.face_shop));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.cbh.setLayoutParams(layoutParams);
        aj.b(this.cbh, d.g.face_store, this.aoN);
        this.cbg.addView(this.cbh);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds2), -1);
        layoutParams2.gravity = 5;
        layoutParams2.weight = 0.0f;
        view.setLayoutParams(layoutParams2);
        aj.e(view, d.e.common_color_10288, this.aoN);
        this.cbg.addView(view);
        this.aDy = new TextView(getContext());
        this.aDy.setGravity(17);
        this.aDy.setTextSize(10.0f);
        this.aDy.setText("N");
        this.aDy.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.cbd.addView(this.cbg, new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(d.f.ds106), -1));
        this.cbd.setNewView(this.aDy);
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        if (TbadkCoreApplication.getInst().isFaceShopNew() && appResponseToIntentClass) {
            this.cbd.setNewViewVisible(true);
        } else {
            this.cbd.setNewViewVisible(false);
        }
        this.cbg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EmotionTabHorizonScrollView.this.aDy != null) {
                    EmotionTabHorizonScrollView.this.cbd.setNewViewVisible(false);
                }
                TbadkCoreApplication.getInst().setFaceShopVersion(TbadkCoreApplication.getInst().getTempFaceShopVersion());
                TbadkCoreApplication.getInst().setFaceShopNew(false);
                if (EmotionTabHorizonScrollView.this.JH != null) {
                    EmotionTabHorizonScrollView.this.JH.b(new com.baidu.tbadk.editortools.a(2, 5, null));
                }
                if (j.hh()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionCenterActivityConfig(EmotionTabHorizonScrollView.this.getContext())));
                } else {
                    l.showToast(EmotionTabHorizonScrollView.this.getContext(), d.l.neterror);
                }
            }
        });
        this.aDz = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        this.aDz.setLayoutParams(layoutParams3);
        this.cbd.addView(this.aDz);
        if (!appResponseToIntentClass) {
            this.cbg.setVisibility(8);
        }
    }

    public void c(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        b(cVar);
    }

    public void k(int i, boolean z) {
        this.cbi = z;
        int i2 = i + 1;
        int childCount = this.cbd.getChildCount();
        com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbe.get(i2 - 1);
        if (i2 < childCount) {
            if (cVar.CI() == EmotionGroupType.BIG_EMOTION || cVar.CI() == EmotionGroupType.USER_COLLECT) {
                TbImageView tbImageView = (TbImageView) ((LinearLayout) this.cbd.getChildAt(i2)).getChildAt(0);
                if (!this.cbi) {
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.emotion.editortool.EmotionTabHorizonScrollView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BdToast.a(EmotionTabHorizonScrollView.this.getContext(), EmotionTabHorizonScrollView.this.getContext().getResources().getString(d.l.emotion_cant_show)).tj();
                        }
                    });
                    if (cVar.CK() != null) {
                        cVar.CK().a(tbImageView);
                        return;
                    }
                    return;
                }
                tbImageView.setOnClickListener(new b(i2 - 1));
                if (cVar.CJ() != null) {
                    cVar.CJ().a(tbImageView);
                }
            }
        }
    }

    public void setTabWidgetBigEmontionVisibility(boolean z) {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(FaceShopActivityConfig.class);
        int childCount = this.cbd.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cbd.getChildAt(i);
            if (childAt != null) {
                com.baidu.tbadk.editortools.emotiontool.c cVar = null;
                if (childAt.getTag() instanceof a) {
                    cVar = ((a) childAt.getTag()).cbo;
                }
                if (a(cVar, z)) {
                    childAt.setVisibility(8);
                } else {
                    childAt.setVisibility(0);
                }
            }
        }
        if (!z || !appResponseToIntentClass) {
            this.cbg.setVisibility(8);
        } else {
            this.cbg.setVisibility(0);
        }
    }

    private boolean a(com.baidu.tbadk.editortools.emotiontool.c cVar, boolean z) {
        if (cVar == null) {
            return true;
        }
        return !z && (cVar.CI() == EmotionGroupType.BIG_EMOTION || cVar.CI() == EmotionGroupType.PROMOTION);
    }

    public void setCurrentTab(int i) {
        int color;
        if (i != this.aDt) {
            if (this.aDt != -1) {
                LinearLayout linearLayout = (LinearLayout) this.cbd.getChildAt(this.aDt + 1);
                TbImageView tbImageView = (TbImageView) linearLayout.getChildAt(0);
                if (tbImageView != null) {
                    if (this.aoN == 0) {
                        color = getResources().getColor(d.e.common_color_10287);
                    } else {
                        color = aj.getColor(d.e.common_color_10287);
                    }
                    tbImageView.setForegroundColor(color);
                }
                linearLayout.setSelected(false);
            }
            this.aDt = i;
            LinearLayout linearLayout2 = (LinearLayout) this.cbd.getChildAt(this.aDt + 1);
            linearLayout2.setSelected(true);
            int[] iArr = new int[2];
            linearLayout2.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int width = linearLayout2.getWidth() + i2;
            if (i2 < 0) {
                scrollBy(i2, 0);
            }
            if (getParent() instanceof ViewGroup) {
                View findViewById = ((ViewGroup) getParent()).findViewById(d.h.face_tab_delete);
                int width2 = getResources().getDisplayMetrics().widthPixels - ((findViewById == null || findViewById.getVisibility() != 0) ? 0 : findViewById.getWidth() + 0);
                if (width > width2) {
                    scrollBy(width - width2, 0);
                }
            }
            TbImageView tbImageView2 = (TbImageView) linearLayout2.getChildAt(0);
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.cbe.get(this.aDt);
            if (cVar.CJ() != null) {
                cVar.CJ().a(tbImageView2);
            }
            if (tbImageView2 != null) {
                tbImageView2.setForegroundColor(aj.getColor(d.e.common_color_10022));
                this.cbj = tbImageView2;
            }
        }
    }

    public void reset() {
        this.aDt = -1;
        this.cbd.removeAllViews();
        ach();
        dD(this.aoN);
    }

    public void dD(int i) {
        int color;
        this.aoN = i;
        if (this.cbh != null) {
            aj.b(this.cbh, d.g.face_store, i);
        }
        if (this.cbg != null) {
            aj.d(this.cbg, d.g.bg_emotion_tab_horizonscrollview, i);
            if (this.cbg.getChildCount() > 0) {
                aj.e(this.cbg.getChildAt(1), d.e.common_color_10288, i);
            }
        }
        if (this.aDz != null) {
            aj.d(this.aDz, d.g.bg_emotion_tab_horizonscrollview, i);
        }
        if (this.aDy != null) {
            aj.d(this.aDy, d.g.icon_news_head_prompt_one, i);
            aj.b(this.aDy, d.e.cp_cont_i, 1, i);
        }
        int childCount = this.cbd.getChildCount();
        for (int i2 = 1; i2 < childCount; i2++) {
            View childAt = this.cbd.getChildAt(i2);
            if (childAt != null) {
                aj.d(childAt, d.g.bg_emotion_tab_horizonscrollview, i);
                a aVar = (a) childAt.getTag();
                if (aVar != null) {
                    if (aVar.cbm != null) {
                        if (i == 0) {
                            color = getResources().getColor(d.e.common_color_10287);
                        } else {
                            color = aj.getColor(d.e.common_color_10287);
                        }
                        aVar.cbm.setForegroundColor(color);
                    }
                    if (aVar.cbn != null) {
                        aj.e(aVar.cbn, d.e.common_color_10288, i);
                    }
                }
            }
        }
        if (this.cbj != null) {
            this.cbj.setForegroundColor(aj.getColor(d.e.common_color_10022));
            if (this.cbj.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cbj.getParent()).setSelected(true);
            }
        }
    }

    public void setOnTabSelectedListener(EmotionTabWidgetView.a aVar) {
        this.cbf = aVar;
    }

    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private final int aem;

        private b(int i) {
            this.aem = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view instanceof TbImageView) && ((TbImageView) view) != EmotionTabHorizonScrollView.this.cbj) {
                ((TbImageView) view).setForegroundColor(aj.getColor(d.e.common_color_10022));
                if (EmotionTabHorizonScrollView.this.cbj != null) {
                    if (!EmotionTabHorizonScrollView.this.cbk) {
                        EmotionTabHorizonScrollView.this.cbj.setForegroundColor(aj.getColor(d.e.common_color_10287));
                    } else {
                        EmotionTabHorizonScrollView.this.cbj.setForegroundColor(EmotionTabHorizonScrollView.this.getResources().getColor(d.e.common_color_10287));
                    }
                }
                EmotionTabHorizonScrollView.this.cbj = (TbImageView) view;
            }
            EmotionTabHorizonScrollView.this.setCurrentTab(this.aem);
            EmotionTabHorizonScrollView.this.cbf.fc(this.aem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private final String mGroupId;

        private c(String str) {
            this.mGroupId = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.g.b.g(this.mGroupId, 0) > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(EmotionTabHorizonScrollView.this.getContext(), com.baidu.adp.lib.g.b.g(this.mGroupId, 0), 0)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TbImageView cbm;
        View cbn;
        com.baidu.tbadk.editortools.emotiontool.c cbo;

        private a() {
        }
    }
}
