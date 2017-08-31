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
        super(context, com.baidu.tieba.homepage.personalize.data.h.ddo);
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
        u.XY().jv("c10988");
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
        private int apS;
        private View bxJ;
        private TextView cYO;
        private TextView dcH;
        private TextView dcI;
        private LinearLayout dcJ;
        private LinearLayout dcK;
        private com.baidu.tieba.homepage.personalize.data.h dcL;
        private View.OnClickListener dcM;
        private View.OnClickListener dcN;
        private View.OnClickListener dcO;

        public a(View view) {
            super(view);
            this.apS = 3;
            this.dcM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10984");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE));
                }
            };
            this.dcN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.dcL != null) {
                        a.this.a(a.this.dcL.ddp, view2, 1);
                    }
                }
            };
            this.dcO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.m.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.dcL != null) {
                        a.this.a(a.this.dcL.ddq, view2, 2);
                    }
                }
            };
            this.cYO = (TextView) view.findViewById(d.h.new_user_guide_tip);
            this.bxJ = view.findViewById(d.h.new_user_guide_close);
            this.dcH = (TextView) view.findViewById(d.h.new_user_guide_man);
            this.dcI = (TextView) view.findViewById(d.h.new_user_guide_woman);
            this.dcJ = (LinearLayout) view.findViewById(d.h.new_user_guide_sex_layout);
            this.dcK = (LinearLayout) view.findViewById(d.h.new_user_guide_age_layout);
            this.dcH.setOnClickListener(this.dcN);
            this.dcI.setOnClickListener(this.dcN);
            this.bxJ.setOnClickListener(this.dcM);
        }

        protected void onChangeSkinType(int i) {
            if (this.apS != i) {
                aj.k(getView(), d.e.cp_bg_line_d);
                aj.i(this.cYO, d.e.cp_cont_d);
                aj.j(this.bxJ, d.g.icon_x_normal);
                this.apS = i;
            }
            if (this.dcL != null && this.dcL.ddp.size() == 2) {
                if (this.dcL.ddp.get(0).isSelect) {
                    aj.i(this.dcH, d.e.cp_cont_g);
                    aj.j(this.dcH, d.g.shape_semi_circle_left_selected);
                } else {
                    aj.i(this.dcH, d.e.cp_cont_f);
                    aj.j(this.dcH, d.g.shape_semi_circle_left_line);
                }
                if (this.dcL.ddp.get(1).isSelect) {
                    aj.i(this.dcI, d.e.cp_cont_g);
                    aj.j(this.dcI, d.g.shape_semi_circle_right_selected);
                } else {
                    aj.i(this.dcI, d.e.cp_cont_f);
                    aj.j(this.dcI, d.g.shape_semi_circle_right_line);
                }
            }
            for (int i2 = 0; i2 < this.dcK.getChildCount(); i2++) {
                View childAt = this.dcK.getChildAt(i2);
                if (childAt instanceof TextView) {
                    com.baidu.tieba.homepage.personalize.data.g lN = lN(((TextView) childAt).getText().toString());
                    if (lN != null && lN.isSelect) {
                        aj.i(childAt, d.e.cp_cont_g);
                        aj.j(childAt, d.g.shape_semi_circle_all_selected);
                    } else {
                        aj.i(childAt, d.e.cp_cont_f);
                        aj.j(childAt, d.g.shape_semi_circle_all_line);
                    }
                }
            }
        }

        private com.baidu.tieba.homepage.personalize.data.g lN(String str) {
            if (StringUtils.isNull(str) || this.dcL == null || this.dcL.ddq == null) {
                return null;
            }
            for (com.baidu.tieba.homepage.personalize.data.g gVar : this.dcL.ddq) {
                if (gVar != null && str.equals(gVar.tagName)) {
                    return gVar;
                }
            }
            return null;
        }

        protected void a(com.baidu.tieba.homepage.personalize.data.h hVar) {
            if (hVar != null) {
                this.dcL = hVar;
                if (hVar.ddp.size() == 2) {
                    this.dcH.setText(hVar.ddp.get(0).tagName);
                    this.dcI.setText(hVar.ddp.get(1).tagName);
                } else {
                    this.dcJ.setVisibility(8);
                }
                this.dcK.removeAllViews();
                if (hVar.ddq.size() > 0) {
                    for (int i = 0; i < hVar.ddq.size(); i++) {
                        View lO = lO(hVar.ddq.get(i).tagName);
                        if (lO != null) {
                            this.dcK.addView(lO);
                            if (i != hVar.ddq.size() - 1) {
                                this.dcK.addView(aqU());
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

        private View lO(String str) {
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
            textView.setOnClickListener(this.dcO);
            return textView;
        }

        private View aqU() {
            View view = new View(getView().getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }
}
