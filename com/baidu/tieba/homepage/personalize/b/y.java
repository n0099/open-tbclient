package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cAy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: af */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, w.j.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.a(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        cc.Sv().hX("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.Uc)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, gVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, gVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int amL;
        private View bjr;
        private TextView czG;
        private TextView czM;
        private TextView czN;
        private LinearLayout czO;
        private LinearLayout czP;
        private com.baidu.tieba.homepage.personalize.data.h czQ;
        private View.OnClickListener czR;
        private View.OnClickListener czS;
        private View.OnClickListener czT;

        public a(View view) {
            super(view);
            this.amL = 3;
            this.czR = new z(this);
            this.czS = new aa(this);
            this.czT = new ab(this);
            this.czG = (TextView) view.findViewById(w.h.new_user_guide_tip);
            this.bjr = view.findViewById(w.h.new_user_guide_close);
            this.czM = (TextView) view.findViewById(w.h.new_user_guide_man);
            this.czN = (TextView) view.findViewById(w.h.new_user_guide_woman);
            this.czO = (LinearLayout) view.findViewById(w.h.new_user_guide_sex_layout);
            this.czP = (LinearLayout) view.findViewById(w.h.new_user_guide_age_layout);
            this.czM.setOnClickListener(this.czS);
            this.czN.setOnClickListener(this.czS);
            this.bjr.setOnClickListener(this.czR);
        }

        protected void onChangeSkinType(int i) {
            if (this.amL != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i((View) this.czG, w.e.cp_cont_d);
                aq.j(this.bjr, w.g.icon_x_normal);
                this.amL = i;
            }
            if (this.czQ != null && this.czQ.cAz.size() == 2) {
                if (this.czQ.cAz.get(0).cAx) {
                    aq.i((View) this.czM, w.e.cp_cont_g);
                    aq.j(this.czM, w.g.shape_semi_circle_left_selected);
                } else {
                    aq.i((View) this.czM, w.e.cp_cont_f);
                    aq.j(this.czM, w.g.shape_semi_circle_left_line);
                }
                if (this.czQ.cAz.get(1).cAx) {
                    aq.i((View) this.czN, w.e.cp_cont_g);
                    aq.j(this.czN, w.g.shape_semi_circle_right_selected);
                } else {
                    aq.i((View) this.czN, w.e.cp_cont_f);
                    aq.j(this.czN, w.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.czP.getChildCount(); i2++) {
                View childAt = this.czP.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jA = jA(((TextView) childAt).getText().toString());
                    if (jA != null && jA.cAx) {
                        aq.i(childAt, w.e.cp_cont_g);
                        aq.j(childAt, w.g.shape_semi_circle_all_selected);
                    } else {
                        aq.i(childAt, w.e.cp_cont_f);
                        aq.j(childAt, w.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jA(String str) {
            if (StringUtils.isNull(str) || this.czQ == null || this.czQ.cAA == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.czQ.cAA) {
                if (gVar != null && str.equals(gVar.Uc)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.czQ = hVar;
                if (hVar.cAz.size() == 2) {
                    this.czM.setText(hVar.cAz.get(0).Uc);
                    this.czN.setText(hVar.cAz.get(1).Uc);
                } else {
                    this.czO.setVisibility(8);
                }
                this.czP.removeAllViews();
                if (hVar.cAA.size() > 0) {
                    for (int i = 0; i < hVar.cAA.size(); i++) {
                        View jB = jB(hVar.cAA.get(i).Uc);
                        if (jB != null) {
                            this.czP.addView(jB);
                            if (i != hVar.cAA.size() - 1) {
                                this.czP.addView(ajI());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.he()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, w.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.Uc)) {
                                gVar2.cAx = !gVar2.cAx;
                                gVar = gVar2;
                            } else {
                                gVar2.cAx = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        y.this.a(gVar, i);
                        TiebaStatic.log(new as("c10982").Z("obj_name", charSequence));
                    }
                }
            }
        }

        private View jB(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60)));
            textView.setOnClickListener(this.czT);
            return textView;
        }

        private View ajI() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
