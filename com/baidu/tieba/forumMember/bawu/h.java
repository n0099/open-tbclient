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
    private TbPageContext<?> aRR;
    private int cAi;
    private ArrayList<i> dAZ = new ArrayList<>();
    private p dBa;
    private int dBb;

    public h(TbPageContext<?> tbPageContext) {
        this.cAi = 0;
        this.dBb = 0;
        this.aRR = tbPageContext;
        this.cAi = l.t(tbPageContext.getPageActivity(), d.e.ds24);
        this.dBb = l.t(tbPageContext.getPageActivity(), d.e.ds30);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dAZ != null) {
            return this.dAZ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mD */
    public i getItem(int i) {
        if (this.dAZ == null || i >= this.dAZ.size()) {
            return null;
        }
        return this.dAZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i).atJ();
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
                view = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.bawu_item_title_view, viewGroup, false);
                c cVar2 = new c();
                cVar2.rz = (TextView) view.findViewById(d.g.text_view_title);
                cVar2.mLine = view.findViewById(d.g.line_divider);
                view.setTag(cVar2);
                cVar = cVar2;
            }
            cVar.rz.setText(((com.baidu.tieba.forumMember.bawu.c) getItem(i)).getTitle());
            this.aRR.getLayoutMode().aM(view);
        } else if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof b)) {
                b bVar2 = (b) view.getTag();
                bVar2.dBe.setVisibility(0);
                bVar2.dBf.setVisibility(8);
                bVar2.dBg.setVisibility(8);
                bVar2.dBh.setVisibility(8);
                bVar = bVar2;
            } else {
                view = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.bawu_item_member, viewGroup, false);
                b bVar3 = new b();
                bVar3.dBd = (RelativeLayout) view.findViewById(d.g.bawu_item_member_root);
                bVar3.dBe = (BawuMemberInfoView) view.findViewById(d.g.left_member);
                bVar3.dBf = (BawuMemberInfoView) view.findViewById(d.g.right_member);
                bVar3.dBg = (BawuManagerApplyInfoView) view.findViewById(d.g.left_manager_apply);
                bVar3.dBh = (BawuManagerApplyInfoView) view.findViewById(d.g.right_manager_apply);
                view.setTag(bVar3);
                bVar = bVar3;
            }
            com.baidu.tieba.forumMember.bawu.b bVar4 = (com.baidu.tieba.forumMember.bawu.b) getItem(i);
            if (bVar4 != null && bVar4.atK() != null && bVar4.atK().size() > 0) {
                if (bVar4.isLast()) {
                    bVar.dBd.setPadding(this.cAi, 0, this.cAi, this.dBb);
                    if (this.dBa != null && !this.dBa.isEmpty()) {
                        if (bVar4.atK().size() == 2) {
                            if (bVar4.atL().equals(this.aRR.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                                bVar.dBh.setVisibility(8);
                                bVar.dBg.setVisibility(0);
                                bVar.dBg.V(this.aRR.getResources().getString(d.j.tip_manager_apply), this.dBa.atW());
                                bVar.dBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRR.getPageActivity()), new String[]{h.this.dBa.atZ()});
                                    }
                                });
                            } else if (bVar4.atL().equals(this.aRR.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                                bVar.dBh.setVisibility(8);
                                bVar.dBg.setVisibility(0);
                                bVar.dBg.V(this.aRR.getResources().getString(d.j.tip_assist_apply), this.dBa.atY());
                                bVar.dBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.2
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRR.getPageActivity()), new String[]{h.this.dBa.aua()});
                                    }
                                });
                            }
                        } else if (bVar4.atL().equals(this.aRR.getResources().getString(d.j.bawu_member_bazhu_tip))) {
                            bVar.dBf.setVisibility(8);
                            bVar.dBh.setVisibility(0);
                            bVar.dBg.setVisibility(8);
                            bVar.dBh.V(this.aRR.getResources().getString(d.j.tip_manager_apply), this.dBa.atW());
                            bVar.dBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRR.getPageActivity()), new String[]{h.this.dBa.atZ()});
                                }
                            });
                        } else if (bVar4.atL().equals(this.aRR.getResources().getString(d.j.bawu_member_xbazhu_tip))) {
                            bVar.dBf.setVisibility(8);
                            bVar.dBh.setVisibility(0);
                            bVar.dBg.setVisibility(8);
                            bVar.dBh.V(this.aRR.getResources().getString(d.j.tip_assist_apply), this.dBa.atY());
                            bVar.dBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.bawu.h.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(h.this.aRR.getPageActivity()), new String[]{h.this.dBa.aua()});
                                }
                            });
                        }
                    }
                } else {
                    bVar.dBd.setPadding(this.cAi, 0, this.cAi, 0);
                    bVar.dBg.setVisibility(8);
                    bVar.dBh.setVisibility(8);
                }
                bVar.dBe.a(bVar4.atK().get(0));
                if (bVar4.atK().size() >= 2) {
                    bVar.dBf.a(bVar4.atK().get(1));
                    bVar.dBf.setVisibility(0);
                } else {
                    bVar.dBf.setVisibility(8);
                }
                this.aRR.getLayoutMode().aM(view);
            }
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
            } else {
                view = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.bawu_item_divider_view, viewGroup, false);
                a aVar2 = new a();
                aVar2.drs = view.findViewById(d.g.divider_view);
                view.setTag(aVar2);
            }
            this.aRR.getLayoutMode().aM(view);
        }
        return view;
    }

    public void I(ArrayList<i> arrayList) {
        this.dAZ = arrayList;
    }

    public void a(p pVar) {
        this.dBa = pVar;
    }

    /* loaded from: classes3.dex */
    public class b {
        RelativeLayout dBd;
        BawuMemberInfoView dBe;
        BawuMemberInfoView dBf;
        BawuManagerApplyInfoView dBg;
        BawuManagerApplyInfoView dBh;

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        View mLine;
        TextView rz;

        public c() {
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        View drs;

        public a() {
        }
    }
}
