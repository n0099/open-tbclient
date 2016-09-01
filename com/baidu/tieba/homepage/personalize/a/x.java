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
import com.baidu.tieba.card.cd;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.j, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.j.cGP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a a(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, t.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.j jVar, a aVar) {
        aVar.a(jVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        cd.NI().hJ("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.i iVar, int i) {
        if (iVar != null && !StringUtils.isNull(iVar.PE)) {
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
        private int ait;
        private TextView cFX;
        private View cFY;
        private TextView cGe;
        private TextView cGf;
        private LinearLayout cGg;
        private LinearLayout cGh;
        private com.baidu.tieba.homepage.personalize.data.j cGi;
        private View.OnClickListener cGj;
        private View.OnClickListener cGk;
        private View.OnClickListener cGl;

        public a(View view) {
            super(view);
            this.ait = 3;
            this.cGj = new y(this);
            this.cGk = new z(this);
            this.cGl = new aa(this);
            this.cFX = (TextView) view.findViewById(t.g.new_user_guide_tip);
            this.cFY = view.findViewById(t.g.new_user_guide_close);
            this.cGe = (TextView) view.findViewById(t.g.new_user_guide_man);
            this.cGf = (TextView) view.findViewById(t.g.new_user_guide_woman);
            this.cGg = (LinearLayout) view.findViewById(t.g.new_user_guide_sex_layout);
            this.cGh = (LinearLayout) view.findViewById(t.g.new_user_guide_age_layout);
            this.cGe.setOnClickListener(this.cGk);
            this.cGf.setOnClickListener(this.cGk);
            this.cFY.setOnClickListener(this.cGj);
        }

        protected void onChangeSkinType(int i) {
            if (this.ait != i) {
                av.l(getView(), t.d.cp_bg_line_d);
                av.j((View) this.cFX, t.d.cp_cont_d);
                av.k(this.cFY, t.f.icon_x_normal);
                this.ait = i;
            }
            if (this.cGi != null && this.cGi.cGQ.size() == 2) {
                if (this.cGi.cGQ.get(0).cGO) {
                    av.j((View) this.cGe, t.d.cp_cont_g);
                    av.k(this.cGe, t.f.shape_semi_circle_left_selected);
                } else {
                    av.j((View) this.cGe, t.d.cp_cont_f);
                    av.k(this.cGe, t.f.shape_semi_circle_left_line);
                }
                if (this.cGi.cGQ.get(1).cGO) {
                    av.j((View) this.cGf, t.d.cp_cont_g);
                    av.k(this.cGf, t.f.shape_semi_circle_right_selected);
                } else {
                    av.j((View) this.cGf, t.d.cp_cont_f);
                    av.k(this.cGf, t.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cGh.getChildCount(); i2++) {
                View childAt = this.cGh.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.i kP = kP(((TextView) childAt).getText().toString());
                    if (kP != null && kP.cGO) {
                        av.j(childAt, t.d.cp_cont_g);
                        av.k(childAt, t.f.shape_semi_circle_all_selected);
                    } else {
                        av.j(childAt, t.d.cp_cont_f);
                        av.k(childAt, t.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.i kP(String str) {
            if (StringUtils.isNull(str) || this.cGi == null || this.cGi.cGR == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.i iVar : this.cGi.cGR) {
                if (iVar != null && str.equals(iVar.PE)) {
                    return iVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.j jVar) {
            if (jVar != null) {
                this.cGi = jVar;
                if (jVar.cGQ.size() == 2) {
                    this.cGe.setText(jVar.cGQ.get(0).PE);
                    this.cGf.setText(jVar.cGQ.get(1).PE);
                } else {
                    this.cGg.setVisibility(8);
                }
                this.cGh.removeAllViews();
                if (jVar.cGR.size() > 0) {
                    for (int i = 0; i < jVar.cGR.size(); i++) {
                        View kQ = kQ(jVar.cGR.get(i).PE);
                        if (kQ != null) {
                            this.cGh.addView(kQ);
                            if (i != jVar.cGR.size() - 1) {
                                this.cGh.addView(amG());
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
                    com.baidu.adp.lib.util.k.showToast(x.this.mContext, t.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.i iVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.i iVar2 : list) {
                            if (charSequence.equals(iVar2.PE)) {
                                iVar2.cGO = !iVar2.cGO;
                                iVar = iVar2;
                            } else {
                                iVar2.cGO = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        x.this.a(iVar, i);
                        TiebaStatic.log(new ay("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View kQ(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds110), TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds60)));
            textView.setOnClickListener(this.cGl);
            return textView;
        }

        private View amG() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
