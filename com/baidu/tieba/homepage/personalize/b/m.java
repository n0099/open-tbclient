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
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public m(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.dek);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(View.inflate(this.mContext, d.j.new_user_guide, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.a(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        u.Yj().jx("c10988");
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar, int i) {
        if (gVar != null && !StringUtils.isNull(gVar.tagName)) {
            if (i == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            } else if (i == 2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int apQ;
        private TextView cZI;
        private TextView ddD;
        private TextView ddE;
        private LinearLayout ddF;
        private LinearLayout ddG;
        private com.baidu.tieba.homepage.personalize.data.h ddH;
        private View.OnClickListener ddI;
        private View.OnClickListener ddJ;
        private View.OnClickListener ddK;
        private View ddw;

        public a(View view) {
            super(view);
            this.apQ = 3;
            this.ddI = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10984");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE));
                }
            };
            this.ddJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ddH != null) {
                        a.this.a(a.this.ddH.del, view2, 1);
                    }
                }
            };
            this.ddK = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ddH != null) {
                        a.this.a(a.this.ddH.dem, view2, 2);
                    }
                }
            };
            this.cZI = (TextView) view.findViewById(d.h.new_user_guide_tip);
            this.ddw = view.findViewById(d.h.new_user_guide_close);
            this.ddD = (TextView) view.findViewById(d.h.new_user_guide_man);
            this.ddE = (TextView) view.findViewById(d.h.new_user_guide_woman);
            this.ddF = (LinearLayout) view.findViewById(d.h.new_user_guide_sex_layout);
            this.ddG = (LinearLayout) view.findViewById(d.h.new_user_guide_age_layout);
            this.ddD.setOnClickListener(this.ddJ);
            this.ddE.setOnClickListener(this.ddJ);
            this.ddw.setOnClickListener(this.ddI);
        }

        protected void onChangeSkinType(int i) {
            if (this.apQ != i) {
                aj.k(getView(), d.e.cp_bg_line_d);
                aj.i(this.cZI, d.e.cp_cont_d);
                aj.j(this.ddw, d.g.icon_x_normal);
                this.apQ = i;
            }
            if (this.ddH != null && this.ddH.del.size() == 2) {
                if (this.ddH.del.get(0).isSelect) {
                    aj.i(this.ddD, d.e.cp_cont_g);
                    aj.j(this.ddD, d.g.shape_semi_circle_left_selected);
                } else {
                    aj.i(this.ddD, d.e.cp_cont_f);
                    aj.j(this.ddD, d.g.shape_semi_circle_left_line);
                }
                if (this.ddH.del.get(1).isSelect) {
                    aj.i(this.ddE, d.e.cp_cont_g);
                    aj.j(this.ddE, d.g.shape_semi_circle_right_selected);
                } else {
                    aj.i(this.ddE, d.e.cp_cont_f);
                    aj.j(this.ddE, d.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.ddG.getChildCount(); i2++) {
                View childAt = this.ddG.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g lP = lP(((TextView) childAt).getText().toString());
                    if (lP != null && lP.isSelect) {
                        aj.i(childAt, d.e.cp_cont_g);
                        aj.j(childAt, d.g.shape_semi_circle_all_selected);
                    } else {
                        aj.i(childAt, d.e.cp_cont_f);
                        aj.j(childAt, d.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g lP(String str) {
            if (StringUtils.isNull(str) || this.ddH == null || this.ddH.dem == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.ddH.dem) {
                if (gVar != null && str.equals(gVar.tagName)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.ddH = hVar;
                if (hVar.del.size() == 2) {
                    this.ddD.setText(hVar.del.get(0).tagName);
                    this.ddE.setText(hVar.del.get(1).tagName);
                } else {
                    this.ddF.setVisibility(8);
                }
                this.ddG.removeAllViews();
                if (hVar.dem.size() > 0) {
                    for (int i = 0; i < hVar.dem.size(); i++) {
                        View lQ = lQ(hVar.dem.get(i).tagName);
                        if (lQ != null) {
                            this.ddG.addView(lQ);
                            if (i != hVar.dem.size() - 1) {
                                this.ddG.addView(arf());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.i.hi()) {
                    com.baidu.adp.lib.util.k.showToast(m.this.mContext, d.l.neterror);
                } else if (view instanceof TextView) {
                    String charSequence = ((TextView) view).getText().toString();
                    if (!StringUtils.isNull(charSequence)) {
                        com.baidu.tieba.homepage.personalize.data.g gVar = null;
                        for (com.baidu.tieba.homepage.personalize.data.g gVar2 : list) {
                            if (charSequence.equals(gVar2.tagName)) {
                                gVar2.isSelect = !gVar2.isSelect;
                            } else {
                                gVar2.isSelect = false;
                                gVar2 = gVar;
                            }
                            gVar = gVar2;
                        }
                        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                        m.this.a(gVar, i);
                        TiebaStatic.log(new ak("c10982").ad("obj_name", charSequence));
                    }
                }
            }
        }

        private View lQ(String str) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10);
            TextView textView = new TextView(getView().getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.fontsize24));
            textView.setText(str);
            textView.setLayoutParams(new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds110), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds60)));
            textView.setOnClickListener(this.ddK);
            return textView;
        }

        private View arf() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
