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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.j, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.j.cHE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a a(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, r.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.j jVar, a aVar) {
        aVar.a(jVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        cb.Oj().hQ("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.i iVar, int i) {
        if (iVar != null && !StringUtils.isNull(iVar.PC)) {
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
        private int ahV;
        private TextView cGL;
        private View cGM;
        private TextView cGS;
        private TextView cGT;
        private LinearLayout cGU;
        private LinearLayout cGV;
        private com.baidu.tieba.homepage.personalize.data.j cGW;
        private View.OnClickListener cGX;
        private View.OnClickListener cGY;
        private View.OnClickListener cGZ;

        public a(View view) {
            super(view);
            this.ahV = 3;
            this.cGX = new y(this);
            this.cGY = new z(this);
            this.cGZ = new aa(this);
            this.cGL = (TextView) view.findViewById(r.g.new_user_guide_tip);
            this.cGM = view.findViewById(r.g.new_user_guide_close);
            this.cGS = (TextView) view.findViewById(r.g.new_user_guide_man);
            this.cGT = (TextView) view.findViewById(r.g.new_user_guide_woman);
            this.cGU = (LinearLayout) view.findViewById(r.g.new_user_guide_sex_layout);
            this.cGV = (LinearLayout) view.findViewById(r.g.new_user_guide_age_layout);
            this.cGS.setOnClickListener(this.cGY);
            this.cGT.setOnClickListener(this.cGY);
            this.cGM.setOnClickListener(this.cGX);
        }

        protected void onChangeSkinType(int i) {
            if (this.ahV != i) {
                av.l(getView(), r.d.cp_bg_line_d);
                av.j((View) this.cGL, r.d.cp_cont_d);
                av.k(this.cGM, r.f.icon_x_normal);
                this.ahV = i;
            }
            if (this.cGW != null && this.cGW.cHF.size() == 2) {
                if (this.cGW.cHF.get(0).cHD) {
                    av.j((View) this.cGS, r.d.cp_cont_g);
                    av.k(this.cGS, r.f.shape_semi_circle_left_selected);
                } else {
                    av.j((View) this.cGS, r.d.cp_cont_f);
                    av.k(this.cGS, r.f.shape_semi_circle_left_line);
                }
                if (this.cGW.cHF.get(1).cHD) {
                    av.j((View) this.cGT, r.d.cp_cont_g);
                    av.k(this.cGT, r.f.shape_semi_circle_right_selected);
                } else {
                    av.j((View) this.cGT, r.d.cp_cont_f);
                    av.k(this.cGT, r.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cGV.getChildCount(); i2++) {
                View childAt = this.cGV.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.i kW = kW(((TextView) childAt).getText().toString());
                    if (kW != null && kW.cHD) {
                        av.j(childAt, r.d.cp_cont_g);
                        av.k(childAt, r.f.shape_semi_circle_all_selected);
                    } else {
                        av.j(childAt, r.d.cp_cont_f);
                        av.k(childAt, r.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.i kW(String str) {
            if (StringUtils.isNull(str) || this.cGW == null || this.cGW.cHG == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.i iVar : this.cGW.cHG) {
                if (iVar != null && str.equals(iVar.PC)) {
                    return iVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.j jVar) {
            if (jVar != null) {
                this.cGW = jVar;
                if (jVar.cHF.size() == 2) {
                    this.cGS.setText(jVar.cHF.get(0).PC);
                    this.cGT.setText(jVar.cHF.get(1).PC);
                } else {
                    this.cGU.setVisibility(8);
                }
                this.cGV.removeAllViews();
                if (jVar.cHG.size() > 0) {
                    for (int i = 0; i < jVar.cHG.size(); i++) {
                        View kX = kX(jVar.cHG.get(i).PC);
                        if (kX != null) {
                            this.cGV.addView(kX);
                            if (i != jVar.cHG.size() - 1) {
                                this.cGV.addView(amU());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.i> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.gm()) {
                    com.baidu.adp.lib.util.k.showToast(x.this.mContext, r.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.i iVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.i iVar2 : list) {
                            if (charSequence.equals(iVar2.PC)) {
                                iVar2.cHD = !iVar2.cHD;
                                iVar = iVar2;
                            } else {
                                iVar2.cHD = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        x.this.a(iVar, i);
                        TiebaStatic.log(new ax("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View kX(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60)));
            textView.setOnClickListener(this.cGZ);
            return textView;
        }

        private View amU() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
