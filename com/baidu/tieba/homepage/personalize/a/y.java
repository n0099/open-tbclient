package com.baidu.tieba.homepage.personalize.a;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.j, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public y(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.j.csB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a a(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, u.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.j jVar, a aVar) {
        aVar.a(jVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        bw.Lg().he("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.i iVar, int i) {
        if (iVar != null && !StringUtils.isNull(iVar.csz)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_SEX_GUIDE, iVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_NU_AGE_GUIDE, iVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int aeK;
        private TextView crJ;
        private View crK;
        private TextView crQ;
        private TextView crR;
        private LinearLayout crS;
        private LinearLayout crT;
        private com.baidu.tieba.homepage.personalize.data.j crU;
        private View.OnClickListener crV;
        private View.OnClickListener crW;
        private View.OnClickListener crX;

        public a(View view) {
            super(view);
            this.aeK = 3;
            this.crV = new z(this);
            this.crW = new aa(this);
            this.crX = new ab(this);
            this.crJ = (TextView) view.findViewById(u.g.new_user_guide_tip);
            this.crK = view.findViewById(u.g.new_user_guide_close);
            this.crQ = (TextView) view.findViewById(u.g.new_user_guide_man);
            this.crR = (TextView) view.findViewById(u.g.new_user_guide_woman);
            this.crS = (LinearLayout) view.findViewById(u.g.new_user_guide_sex_layout);
            this.crT = (LinearLayout) view.findViewById(u.g.new_user_guide_age_layout);
            this.crQ.setOnClickListener(this.crW);
            this.crR.setOnClickListener(this.crW);
            this.crK.setOnClickListener(this.crV);
        }

        protected void onChangeSkinType(int i) {
            if (this.aeK != i) {
                av.l(getView(), u.d.cp_bg_line_d);
                av.j((View) this.crJ, u.d.cp_cont_d);
                av.k(this.crK, u.f.icon_x_normal);
                this.aeK = i;
            }
            if (this.crU != null && this.crU.csC.size() == 2) {
                if (this.crU.csC.get(0).csA) {
                    av.j((View) this.crQ, u.d.cp_cont_g);
                    av.k(this.crQ, u.f.shape_semi_circle_left_selected);
                } else {
                    av.j((View) this.crQ, u.d.cp_cont_f);
                    av.k(this.crQ, u.f.shape_semi_circle_left_line);
                }
                if (this.crU.csC.get(1).csA) {
                    av.j((View) this.crR, u.d.cp_cont_g);
                    av.k(this.crR, u.f.shape_semi_circle_right_selected);
                } else {
                    av.j((View) this.crR, u.d.cp_cont_f);
                    av.k(this.crR, u.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.crT.getChildCount(); i2++) {
                View childAt = this.crT.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.i jZ = jZ(((TextView) childAt).getText().toString());
                    if (jZ != null && jZ.csA) {
                        av.j(childAt, u.d.cp_cont_g);
                        av.k(childAt, u.f.shape_semi_circle_all_selected);
                    } else {
                        av.j(childAt, u.d.cp_cont_f);
                        av.k(childAt, u.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.i jZ(String str) {
            if (StringUtils.isNull(str) || this.crU == null || this.crU.csD == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.i iVar : this.crU.csD) {
                if (iVar != null && str.equals(iVar.csz)) {
                    return iVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.j jVar) {
            if (jVar != null) {
                this.crU = jVar;
                if (jVar.csC.size() == 2) {
                    this.crQ.setText(jVar.csC.get(0).csz);
                    this.crR.setText(jVar.csC.get(1).csz);
                } else {
                    this.crS.setVisibility(8);
                }
                this.crT.removeAllViews();
                if (jVar.csD.size() > 0) {
                    for (int i = 0; i < jVar.csD.size(); i++) {
                        View ka = ka(jVar.csD.get(i).csz);
                        if (ka != null) {
                            this.crT.addView(ka);
                            if (i != jVar.csD.size() - 1) {
                                this.crT.addView(ahi());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.i> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.fr()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, u.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.i iVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.i iVar2 : list) {
                            if (charSequence.equals(iVar2.csz)) {
                                iVar2.csA = !iVar2.csA;
                                iVar = iVar2;
                            } else {
                                iVar2.csA = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        y.this.a(iVar, i);
                        TiebaStatic.log(new ay("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View ka(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds60)));
            textView.setOnClickListener(this.crX);
            return textView;
        }

        private View ahi() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
