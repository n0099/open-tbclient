package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private TbPageContext<?> aRG;
    private int czW;
    private ArrayList<i> dAN = new ArrayList<>();
    private p dAO;
    private int dAP;

    public h(TbPageContext<?> tbPageContext) {
        this.czW = 0;
        this.dAP = 0;
        this.aRG = tbPageContext;
        this.czW = l.t(tbPageContext.getPageActivity(), d.e.ds24);
        this.dAP = l.t(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dAN != null) {
            return this.dAN.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mD */
    public i getItem(int i) {
        if (this.dAN == null || i >= this.dAN.size()) {
            return null;
        }
        return this.dAN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).atI();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i) == 0) {
            if (view != null && (view.getTag() instanceof c)) {
                cVar = (c) view.getTag();
            } else {
                view = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.bawu_item_title_view, viewGroup, false);
                c cVar2 = new c();
                cVar2.ry = (TextView) view.findViewById(d.g.text_view_title);
                cVar2.mLine = view.findViewById(d.g.line_divider);
                view.setTag(cVar2);
                cVar = cVar2;
            }
            cVar.ry.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.aRG.getLayoutMode().aM(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof b)) {
                b bVar2 = (b) view.getTag();
                bVar2.dAS.setVisibility(0);
                bVar2.dAT.setVisibility(8);
                bVar2.dAU.setVisibility(8);
                bVar2.dAV.setVisibility(8);
                bVar = bVar2;
            } else {
                view = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                b bVar3 = new b();
                bVar3.dAR = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                bVar3.dAS = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                bVar3.dAT = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                bVar3.dAU = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                bVar3.dAV = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(bVar3);
                bVar = bVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar4 = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar4 != null && bVar4.atJ() != null && bVar4.atJ().size() > 0) {
                if (bVar4.isLast()) {
                    bVar.dAR.setPadding(this.czW, 0, this.czW, this.dAP);
                    if (this.dAO != null && !this.dAO.isEmpty()) {
                        if (bVar4.atJ().size() == 2) {
                            if (bVar4.atK().equals(this.aRG.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                bVar.dAV.setVisibility(8);
                                bVar.dAU.setVisibility(0);
                                bVar.dAU.V(this.aRG.getResources().getString(d.j.tip_manager_apply), this.dAO.atV());
                                bVar.dAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRG.getPageActivity()), new String[]{h.this.dAO.atY()});
                                    }
                                });
                            } else if (bVar4.atK().equals(this.aRG.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                bVar.dAV.setVisibility(8);
                                bVar.dAU.setVisibility(0);
                                bVar.dAU.V(this.aRG.getResources().getString(d.j.tip_assist_apply), this.dAO.atX());
                                bVar.dAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRG.getPageActivity()), new String[]{h.this.dAO.atZ()});
                                    }
                                });
                            }
                        } else if (bVar4.atK().equals(this.aRG.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            bVar.dAT.setVisibility(8);
                            bVar.dAV.setVisibility(0);
                            bVar.dAU.setVisibility(8);
                            bVar.dAV.V(this.aRG.getResources().getString(d.j.tip_manager_apply), this.dAO.atV());
                            bVar.dAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRG.getPageActivity()), new String[]{h.this.dAO.atY()});
                                }
                            });
                        } else if (bVar4.atK().equals(this.aRG.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            bVar.dAT.setVisibility(8);
                            bVar.dAV.setVisibility(0);
                            bVar.dAU.setVisibility(8);
                            bVar.dAV.V(this.aRG.getResources().getString(d.j.tip_assist_apply), this.dAO.atX());
                            bVar.dAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRG.getPageActivity()), new String[]{h.this.dAO.atZ()});
                                }
                            });
                        }
                    }
                } else {
                    bVar.dAR.setPadding(this.czW, 0, this.czW, 0);
                    bVar.dAU.setVisibility(8);
                    bVar.dAV.setVisibility(8);
                }
                bVar.dAS.a(bVar4.atJ().get(0));
                if (bVar4.atJ().size() >= 2) {
                    bVar.dAT.a(bVar4.atJ().get(1));
                    bVar.dAT.setVisibility(0);
                } else {
                    bVar.dAT.setVisibility(8);
                }
                this.aRG.getLayoutMode().aM(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.drg = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.aRG.getLayoutMode().aM(view);
        }
        return view;
    }

    public void I(ArrayList<i> arrayList) {
        this.dAN = arrayList;
    }

    public void a(p pVar) {
        this.dAO = pVar;
    }

    /* loaded from: classes3.dex */
    public class b {
        RelativeLayout dAR;
        BawuMemberInfoView dAS;
        BawuMemberInfoView dAT;
        BawuManagerApplyInfoView dAU;
        BawuManagerApplyInfoView dAV;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        View mLine;
        TextView ry;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View drg;

        public a() {
        }
    }
}
