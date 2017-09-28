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
        super(context, com.baidu.tieba.homepage.personalize.data.h.daz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
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
        u.XR().jq("c10988");
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
        private int aoZ;
        private TextView cWj;
        private View cZJ;
        private TextView cZQ;
        private TextView cZR;
        private LinearLayout cZS;
        private LinearLayout cZT;
        private com.baidu.tieba.homepage.personalize.data.h cZU;
        private View.OnClickListener cZV;
        private View.OnClickListener cZW;
        private View.OnClickListener cZX;

        public a(View view) {
            super(view);
            this.aoZ = 3;
            this.cZV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10984");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE));
                }
            };
            this.cZW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.cZU != null) {
                        a.this.a(a.this.cZU.daA, view2, 1);
                    }
                }
            };
            this.cZX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.m.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.cZU != null) {
                        a.this.a(a.this.cZU.daB, view2, 2);
                    }
                }
            };
            this.cWj = (TextView) view.findViewById(d.h.new_user_guide_tip);
            this.cZJ = view.findViewById(d.h.new_user_guide_close);
            this.cZQ = (TextView) view.findViewById(d.h.new_user_guide_man);
            this.cZR = (TextView) view.findViewById(d.h.new_user_guide_woman);
            this.cZS = (LinearLayout) view.findViewById(d.h.new_user_guide_sex_layout);
            this.cZT = (LinearLayout) view.findViewById(d.h.new_user_guide_age_layout);
            this.cZQ.setOnClickListener(this.cZW);
            this.cZR.setOnClickListener(this.cZW);
            this.cZJ.setOnClickListener(this.cZV);
        }

        protected void onChangeSkinType(int i) {
            if (this.aoZ != i) {
                aj.k(getView(), d.e.cp_bg_line_d);
                aj.i(this.cWj, d.e.cp_cont_d);
                aj.j(this.cZJ, d.g.icon_x_normal);
                this.aoZ = i;
            }
            if (this.cZU != null && this.cZU.daA.size() == 2) {
                if (this.cZU.daA.get(0).isSelect) {
                    aj.i(this.cZQ, d.e.cp_cont_g);
                    aj.j(this.cZQ, d.g.shape_semi_circle_left_selected);
                } else {
                    aj.i(this.cZQ, d.e.cp_cont_f);
                    aj.j(this.cZQ, d.g.shape_semi_circle_left_line);
                }
                if (this.cZU.daA.get(1).isSelect) {
                    aj.i(this.cZR, d.e.cp_cont_g);
                    aj.j(this.cZR, d.g.shape_semi_circle_right_selected);
                } else {
                    aj.i(this.cZR, d.e.cp_cont_f);
                    aj.j(this.cZR, d.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.cZT.getChildCount(); i2++) {
                View childAt = this.cZT.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g lt = lt(((TextView) childAt).getText().toString());
                    if (lt != null && lt.isSelect) {
                        aj.i(childAt, d.e.cp_cont_g);
                        aj.j(childAt, d.g.shape_semi_circle_all_selected);
                    } else {
                        aj.i(childAt, d.e.cp_cont_f);
                        aj.j(childAt, d.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g lt(String str) {
            if (StringUtils.isNull(str) || this.cZU == null || this.cZU.daB == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.cZU.daB) {
                if (gVar != null && str.equals(gVar.tagName)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.cZU = hVar;
                if (hVar.daA.size() == 2) {
                    this.cZQ.setText(hVar.daA.get(0).tagName);
                    this.cZR.setText(hVar.daA.get(1).tagName);
                } else {
                    this.cZS.setVisibility(8);
                }
                this.cZT.removeAllViews();
                if (hVar.daB.size() > 0) {
                    for (int i = 0; i < hVar.daB.size(); i++) {
                        View lu = lu(hVar.daB.get(i).tagName);
                        if (lu != null) {
                            this.cZT.addView(lu);
                            if (i != hVar.daB.size() - 1) {
                                this.cZT.addView(apL());
                            }
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(List<com.baidu.tieba.homepage.personalize.data.g> list, View view, int i) {
            if (list != null && list.size() != 0) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    com.baidu.adp.lib.util.l.showToast(m.this.mContext, d.l.neterror);
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

        private View lu(String str) {
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
            textView.setOnClickListener(this.cZX);
            return textView;
        }

        private View apL() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
