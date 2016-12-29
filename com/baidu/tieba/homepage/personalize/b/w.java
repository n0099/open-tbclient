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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public w(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.crW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public a a(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, r.h.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.a(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        bz.OH().hO("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.PR)) {
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
        private int aib;
        private TextView crg;
        private View crh;
        private TextView crn;
        private TextView cro;
        private LinearLayout crp;
        private LinearLayout crq;
        private com.baidu.tieba.homepage.personalize.data.h crr;
        private View.OnClickListener crs;
        private View.OnClickListener crt;
        private View.OnClickListener cru;

        public a(View view) {
            super(view);
            this.aib = 3;
            this.crs = new x(this);
            this.crt = new y(this);
            this.cru = new z(this);
            this.crg = (TextView) view.findViewById(r.g.new_user_guide_tip);
            this.crh = view.findViewById(r.g.new_user_guide_close);
            this.crn = (TextView) view.findViewById(r.g.new_user_guide_man);
            this.cro = (TextView) view.findViewById(r.g.new_user_guide_woman);
            this.crp = (LinearLayout) view.findViewById(r.g.new_user_guide_sex_layout);
            this.crq = (LinearLayout) view.findViewById(r.g.new_user_guide_age_layout);
            this.crn.setOnClickListener(this.crt);
            this.cro.setOnClickListener(this.crt);
            this.crh.setOnClickListener(this.crs);
        }

        protected void onChangeSkinType(int i) {
            if (this.aib != i) {
                ar.l(getView(), r.d.cp_bg_line_d);
                ar.j((View) this.crg, r.d.cp_cont_d);
                ar.k(this.crh, r.f.icon_x_normal);
                this.aib = i;
            }
            if (this.crr != null && this.crr.crX.size() == 2) {
                if (this.crr.crX.get(0).crV) {
                    ar.j((View) this.crn, r.d.cp_cont_g);
                    ar.k(this.crn, r.f.shape_semi_circle_left_selected);
                } else {
                    ar.j((View) this.crn, r.d.cp_cont_f);
                    ar.k(this.crn, r.f.shape_semi_circle_left_line);
                }
                if (this.crr.crX.get(1).crV) {
                    ar.j((View) this.cro, r.d.cp_cont_g);
                    ar.k(this.cro, r.f.shape_semi_circle_right_selected);
                } else {
                    ar.j((View) this.cro, r.d.cp_cont_f);
                    ar.k(this.cro, r.f.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.crq.getChildCount(); i2++) {
                View childAt = this.crq.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g jL = jL(((TextView) childAt).getText().toString());
                    if (jL != null && jL.crV) {
                        ar.j(childAt, r.d.cp_cont_g);
                        ar.k(childAt, r.f.shape_semi_circle_all_selected);
                    } else {
                        ar.j(childAt, r.d.cp_cont_f);
                        ar.k(childAt, r.f.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g jL(String str) {
            if (StringUtils.isNull(str) || this.crr == null || this.crr.crY == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.crr.crY) {
                if (gVar != null && str.equals(gVar.PR)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.crr = hVar;
                if (hVar.crX.size() == 2) {
                    this.crn.setText(hVar.crX.get(0).PR);
                    this.cro.setText(hVar.crX.get(1).PR);
                } else {
                    this.crp.setVisibility(8);
                }
                this.crq.removeAllViews();
                if (hVar.crY.size() > 0) {
                    for (int i = 0; i < hVar.crY.size(); i++) {
                        View jM = jM(hVar.crY.get(i).PR);
                        if (jM != null) {
                            this.crq.addView(jM);
                            if (i != hVar.crY.size() - 1) {
                                this.crq.addView(ajp());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.gm()) {
                    com.baidu.adp.lib.util.k.showToast(w.this.mContext, r.j.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.PR)) {
                                gVar2.crV = !gVar2.crV;
                                gVar = gVar2;
                            } else {
                                gVar2.crV = false;
                            }
                        }
                        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
                        w.this.a(gVar, i);
                        TiebaStatic.log(new at("c10982").ab("obj_name", charSequence));
                    }
                }
            }
        }

        private View jM(String str) {
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
            textView.setOnClickListener(this.cru);
            return textView;
        }

        private View ajp() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
