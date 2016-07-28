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
        super(context, com.baidu.tieba.homepage.personalize.data.j.cvl);
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
        aVar.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        bw.Lf().he("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.i iVar, int i) {
        if (iVar != null && !StringUtils.isNull(iVar.cvj)) {
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
        private int afy;
        private TextView cuA;
        private TextView cuB;
        private LinearLayout cuC;
        private LinearLayout cuD;
        private com.baidu.tieba.homepage.personalize.data.j cuE;
        private View.OnClickListener cuF;
        private View.OnClickListener cuG;
        private View.OnClickListener cuH;
        private TextView cut;
        private View cuu;

        public a(View view) {
            super(view);
            this.afy = 3;
            this.cuF = new z(this);
            this.cuG = new aa(this);
            this.cuH = new ab(this);
            this.cut = (TextView) view.findViewById(u.g.new_user_guide_tip);
            this.cuu = view.findViewById(u.g.new_user_guide_close);
            this.cuA = (TextView) view.findViewById(u.g.new_user_guide_man);
            this.cuB = (TextView) view.findViewById(u.g.new_user_guide_woman);
            this.cuC = (LinearLayout) view.findViewById(u.g.new_user_guide_sex_layout);
            this.cuD = (LinearLayout) view.findViewById(u.g.new_user_guide_age_layout);
            this.cuA.setOnClickListener(this.cuG);
            this.cuB.setOnClickListener(this.cuG);
            this.cuu.setOnClickListener(this.cuF);
        }

        protected void onChangeSkinType(int i) {
            if (this.afy != i) {
                av.l(getView(), u.d.cp_bg_line_d);
                av.j((View) this.cut, u.d.cp_cont_d);
                av.k(this.cuu, u.f.icon_x_normal);
                this.afy = i;
            }
            if (this.cuE != null && this.cuE.cvm.size() == 2) {
                if (this.cuE.cvm.get(0).cvk) {
                    av.j((View) this.cuA, u.d.cp_cont_g);
                    av.k(this.cuA, u.f.shape_semi_circle_left_selected);
                } else {
                    av.j((View) this.cuA, u.d.cp_cont_f);
                    av.k(this.cuA, u.f.shape_semi_circle_left_line);
                }
                if (this.cuE.cvm.get(1).cvk) {
                    av.j((View) this.cuB, u.d.cp_cont_g);
                    av.k(this.cuB, u.f.shape_semi_circle_right_selected);
                } else {
                    av.j((View) this.cuB, u.d.cp_cont_f);
                    av.k(this.cuB, u.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cuD.getChildCount(); i2++) {
                View childAt = this.cuD.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.i kg = kg(((TextView) childAt).getText().toString());
                    if (kg != null && kg.cvk) {
                        av.j(childAt, u.d.cp_cont_g);
                        av.k(childAt, u.f.shape_semi_circle_all_selected);
                    } else {
                        av.j(childAt, u.d.cp_cont_f);
                        av.k(childAt, u.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.i kg(String str) {
            if (StringUtils.isNull(str) || this.cuE == null || this.cuE.cvn == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.i iVar : this.cuE.cvn) {
                if (iVar != null && str.equals(iVar.cvj)) {
                    return iVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.j jVar) {
            if (jVar != null) {
                this.cuE = jVar;
                if (jVar.cvm.size() == 2) {
                    this.cuA.setText(jVar.cvm.get(0).cvj);
                    this.cuB.setText(jVar.cvm.get(1).cvj);
                } else {
                    this.cuC.setVisibility(8);
                }
                this.cuD.removeAllViews();
                if (jVar.cvn.size() > 0) {
                    for (int i = 0; i < jVar.cvn.size(); i++) {
                        View kh = kh(jVar.cvn.get(i).cvj);
                        if (kh != null) {
                            this.cuD.addView(kh);
                            if (i != jVar.cvn.size() - 1) {
                                this.cuD.addView(ahR());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.i> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.fq()) {
                    com.baidu.adp.lib.util.k.showToast(y.this.mContext, u.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.i iVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.i iVar2 : list) {
                            if (charSequence.equals(iVar2.cvj)) {
                                iVar2.cvk = !iVar2.cvk;
                                iVar = iVar2;
                            } else {
                                iVar2.cvk = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
                        y.this.a(iVar, i);
                        TiebaStatic.log(new ay("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View kh(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds110), TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds60)));
            textView.setOnClickListener(this.cuH);
            return textView;
        }

        private View ahR() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
